package com.ss.android.ugc.aweme.framework.services;

import com.bytedance.android.bcm.impl.spi.BcmConfigForBtmImpl;
import com.bytedance.android.ec.hybrid.card.event.ECEventCenterSerivceDefaultImpl;
import com.bytedance.android.ec.hybrid.service.MallDeepFeedAnimationServiceImpl;
import com.bytedance.android.ec.slice.adapter.impl.ECSliceAdapterServiceImpl;
import com.bytedance.android.ecom.bcm.track.impl.spi.BcmConfigBusinessProviderImpl;
import com.bytedance.android.ecom.bcm.track.impl.spi.BcmExtraCheckerProviderImpl;
import com.bytedance.android.ecom.bcm.track.impl.spi.EcomConfigForBtmImpl;
import com.bytedance.android.live.browser.rts.jsbridge.service.IESLiveRTSJSBService;
import com.bytedance.android.live.openplatform.impl.base.awemepaas_adapt.OpenPlatformFlavorServiceDefault;
import com.bytedance.android.live.openplatform.impl.base.awemepaas_adapt.OpenPlatformFlavorServiceForDouyin;
import com.bytedance.android.livesdk.castscreen.bytecast.LiveByteCastService;
import com.bytedance.android.marketing.sdk.impl.MarketingBridgeServiceImpl;
import com.bytedance.android.marketing.sdk.impl.MarketingServiceImpl;
import com.bytedance.android.marketing.sdk.impl.MarketingServiceImplV2;
import com.bytedance.android.shopping.api.mall.LegouLynxBehaviorDefaultService;
import com.bytedance.android.shopping.api.mall.LegouMallServiceDefaultImpl;
import com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor.apiImpl.DeliveryCompatImpl;
import com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor.apiImpl.DeliveryEventServiceImpl;
import com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor.apiImpl.MallSessionServiceImpl;
import com.bytedance.android.shopping.mall.feed.ECMallFeedService;
import com.bytedance.android.shopping.mall.feed.ECMallFeedServiceAdapter;
import com.bytedance.android.shopping.mall.impl.ECMallTabOptService;
import com.bytedance.android.shopping.mall.utils.ECMallPerformanceService;
import com.bytedance.applet.aibridge.ecommerce.impl.ECommerceProductCardPreloadService;
import com.bytedance.applet.aibridge.health.AppletHealthServiceImpl;
import com.bytedance.applet.aibridge.navi.AppletNaviServiceImpl;
import com.bytedance.applet.aibridge.navigation.NavigationTestEntry;
import com.bytedance.applet.block.permissionapplycard.blockadapter.PermissionApplyBlockProvider;
import com.bytedance.applet.debug.AppletDebugMessageExtServiceImpl;
import com.bytedance.applet.debugger.AppletDebuggerServiceImpl;
import com.bytedance.applet.dora.payload.CommonBusinessProvider;
import com.bytedance.applet.dora.payload.SystemPermissionStatusProvider;
import com.bytedance.applet.impl.AppletGrantingWidgetServiceImpl;
import com.bytedance.applet.impl.AppletPayloadProviderServiceImpl;
import com.bytedance.applet.impl.AppletV2ServiceImpl;
import com.bytedance.applet.impl.MainlandAppletServiceImpl;
import com.bytedance.applet.impl.RenderLiteServiceImpl;
import com.bytedance.applet.impl.WidgetRenderServiceImpl;
import com.bytedance.applet.impl.moa.MoaGrantingAppletServiceImpl;
import com.bytedance.bmf_mods.AdaptiveGrading;
import com.bytedance.bmf_mods.ByteStreamHD;
import com.bytedance.bmf_mods.ColorHist;
import com.bytedance.bmf_mods.ColorShift;
import com.bytedance.bmf_mods.Denoise;
import com.bytedance.bmf_mods.HydraHDR;
import com.bytedance.bmf_mods.MotionSense;
import com.bytedance.bmf_mods.NoiseDetect;
import com.bytedance.bmf_mods.NoiseLive;
import com.bytedance.bmf_mods.Siti;
import com.bytedance.bmf_mods.TdiLiteStrategy;
import com.bytedance.bmf_mods.VideoBright;
import com.bytedance.bmf_mods.VideoOCLSR;
import com.bytedance.bmf_mods.VideoSRLut;
import com.bytedance.bmf_mods.VideoSRRaisr;
import com.bytedance.bmf_mods.VideoSuperResolution;
import com.bytedance.bmf_mods.VqscoreLive;
import com.bytedance.dataplatform.abtest.GlobalExposureConfig;
import com.bytedance.lighten.loader.ImagePipelineOutService;
import com.bytedance.locallife.LocalLifeLiveServiceImpl;
import com.bytedance.locallife.LocalLifeServiceImpl;
import com.bytedance.timon.clipboard.suite.TMClipboardLifecycleServiceImpl;
import com.bytedance.timon.ext.alog.AlogLoggerImpl;
import com.bytedance.timon.ext.keva.KevaStoreImpl;
import com.bytedance.timon.foundation.impl.LocalTimonLogger;
import com.bytedance.timon.ruler.adapter.RulerBasicLifecycleServiceImpl;
import com.bytedance.timon.ruler.adapter.RulerBusinessServiceImpl;
import com.bytedance.timon.ruler.adapter.RulerHardCodeValidatorServiceImpl;
import com.bytedance.timon.ruler.adapter.RulerServiceImpl;
import com.bytedance.timon.upc.upc_adapter_impl.UpcBusinessServiceImpl;
import com.bytedance.timon.upc.upc_adapter_impl.UpcLifecycleServiceImpl;
import com.bytedance.timon_monitor_impl.CacheLifecycleServiceImpl;
import com.bytedance.timon_monitor_impl.MonitorBusinessServiceImpl;
import com.bytedance.timon_monitor_impl.MonitorLifecycleServiceImpl;
import com.bytedance.timonbase.TMBaseLifecycleService;
import com.bytedance.upc.common.CommonBusinessService;
import com.bytedance.upc.common.CommonService;
import com.bytedance.upc.common.device.DeviceInfoService;
import com.enroll.audio.enroll.VoiceEnrollServiceImpl;
import com.enroll.audio.enroll.sami.BtHeadsetEnrollServiceImpl;
import com.flow.performance.quality.appinit.AppLaunchReporterDelegate;
import com.ivy.ivykit.base.resource.IvyResourceServiceImpl;
import com.ivy.ivykit.plugin.impl.applet.IvyAIPackageResourceServiceImpl;
import com.ivy.ivykit.plugin.impl.jsb.BridgeMethodServiceImpl;
import com.ivy.ivykit.plugin.impl.jsb.BridgeServiceImpl;
import com.ivy.ivykit.plugin.impl.jsb.IvyLynxBridgeServiceImpl;
import com.ivy.ivykit.plugin.impl.render.IvyHybridMonitorServiceImpl;
import com.ivy.ivykit.plugin.impl.render.IvyLynxBehaviorServiceImpl;
import com.ivy.ivykit.plugin.impl.render.IvyLynxRuntimeServiceImpl;
import com.ivy.ivykit.plugin.impl.render.IvyPageServiceImpl;
import com.ivy.ivykit.plugin.impl.render.IvyPluginServiceImpl;
import com.ivy.ivykit.plugin.impl.web.IvyWebServiceImpl;
import com.larus.abtest.impl.AbTestImpl;
import com.larus.abtest.test.GlobalExposureTest;
import com.larus.account.base.impl.AccountServiceImpl;
import com.larus.account.base.impl.IThirdPartyPlatformCallbackImpl;
import com.larus.account.base.impl.LoginServiceImpl;
import com.larus.account.base.impl.MultiAccountProfileImpl;
import com.larus.account.base.impl.MultiAccountServiceImpl;
import com.larus.account.bdturing.GooglePhoneInfo;
import com.larus.account.saas.core.ttaccount.AccountBindingService;
import com.larus.account.saas.core.ttaccount.AccountDispatchService;
import com.larus.account.saas.core.ttaccount.AccountGroupAuthServerService;
import com.larus.account.saas.core.ttaccount.AccountInitManager;
import com.larus.account.saas.core.ttaccount.AccountLoginService;
import com.larus.account.saas.core.ttaccount.AccountManagementService;
import com.larus.account.saas.core.ttaccount.AccountProfileService;
import com.larus.account.saas.core.ttaccount.AccountQrCodeService;
import com.larus.account.saas.core.ttaccount.AccountSessionService;
import com.larus.account.saas.core.ttaccount.AccountSwitchService;
import com.larus.account.saas.core.ttaccount.AccountTouristService;
import com.larus.account.saas.core.ttaccount.SecShareDataService;
import com.larus.account.saas.core.ttaccount.SessionExpiredFrontierMessageHandler;
import com.larus.account.saas.mfa.AccountMfaService;
import com.larus.account.saas.mfa.assist.handler.MfaDeeplinkHandler;
import com.larus.account.saas.mfa.assist.handler.MfaFrontierMessageHandler;
import com.larus.account.saas.security.AccountSecurityDeeplinkHandler;
import com.larus.account.saas.security.AccountSecurityServiceImpl;
import com.larus.account.saas.security.kickout.KickOutNoticeFrontierMessageHandler;
import com.larus.account.saas.ui.DefaultAccountSaasUiResourceResolver;
import com.larus.account.saas.ui.alert.DefaultAccountCommonAlertUiService;
import com.larus.account.saas.ui.loading.DefaultAccountLoadingUiService;
import com.larus.account.saas.ui.security.DefaultAccountRiskDialogUiService;
import com.larus.account.saas.ui.security.DefaultAccountSecurityPushUiService;
import com.larus.agents.impl.service.OfficeTaskSettingsServiceImpl;
import com.larus.agents.impl.webfetch.LocalWebFetchServiceImpl;
import com.larus.agents.impl.webfetch.WebPageFetchServiceImpl;
import com.larus.api.bussiness.VideoArticleProviderImpl;
import com.larus.api.bussiness.VideoFeedProviderImpl;
import com.larus.api.provider.SdkVideoFeedProvider;
import com.larus.api.serviceimpl.PoiFeedPlayerServiceImpl;
import com.larus.apm.impl.ApmImpl;
import com.larus.apm.impl.ApmTraceImpl;
import com.larus.apm.impl.ExtraParamsImpl;
import com.larus.apm.impl.GodzillaImpl;
import com.larus.apm.impl.LoggerImpl;
import com.larus.apm.impl.NpthImpl;
import com.larus.apm.impl.protector.TTProtectorImpl;
import com.larus.app.btm.DoubaoBtmHostDependency;
import com.larus.app.config.ApmConfigs;
import com.larus.app.share.ShareDoubaoForwardService;
import com.larus.app.zlink.config.ZlinkConfigs;
import com.larus.applog.impl.ApplogImpl;
import com.larus.applog.impl.MultiInstanceAppLogServiceImpl;
import com.larus.asr.AsrAutoFillComponentRegistry;
import com.larus.asr.AudioComponentRegistry;
import com.larus.asr.HandsfreeComponentRegistry;
import com.larus.asr.LiveTutorAudioComponentRegistry;
import com.larus.asr.NoOAudioComponentRegistry;
import com.larus.asr.OAudioComponentRegistry;
import com.larus.audio.AudioServiceImpl;
import com.larus.audio.ainotes.AiNoteTtsInterceptor;
import com.larus.audio.asr.KMPFlowAudioSceneServiceImpl;
import com.larus.audio.audiov3.audio.AudioPlayerFactory;
import com.larus.audio.audiov3.audio.AudioRecorderFactory;
import com.larus.audio.audiov3.task.sami.v2.SamiConnectionPoolImpl;
import com.larus.audio.audiov3.task.sami.v2.flow.FlowSamiFactory;
import com.larus.audio.audiov3.util.AudioDeviceHelperImpl;
import com.larus.audio.dora.DoraTtsReaderInterceptor;
import com.larus.audio.flow.client.AudioPlayerConfigFactory;
import com.larus.audio.flow.client.FlowAsrClientImpl;
import com.larus.audio.flow.client.FlowTtsClientImpl;
import com.larus.audio.flow.client.factory.FlowTtsClientFactoryImpl;
import com.larus.audio.flow.client.kmp_com.AsrFileAudioDataProvider;
import com.larus.audio.flow.client.kmp_com.FlowTtsClientKmpManagerDelegate;
import com.larus.audio.flow.client.kmp_com.service.FlowAudioKmpAppInfoProvider;
import com.larus.audio.flow.client.kmp_com.service.LoggerInject;
import com.larus.audio.flow.client.kmp_com.service.TrackerService;
import com.larus.audio.flow.client.report.AsrTracerFactory;
import com.larus.audio.report.AudioDeviceMonitorReporterImpl;
import com.larus.audio.report.AudioEventCommonParamsServiceImpl;
import com.larus.audio.ttsV2.DefaultTtsBackgroundPlayControlServiceImpl;
import com.larus.audio.ttsV2.HeadsetDetectorServiceImpl;
import com.larus.audio.ttsV2.TtsClientServiceImpl;
import com.larus.audio.ttsV2.TtsGuideServiceImpl;
import com.larus.audioplayer.impl.AudioStreamPlayerServiceImpl;
import com.larus.audioplayer.impl.appletpayload.AppletMediaPlayerContextProvider;
import com.larus.audioplayer.impl.manager.AudioStopTimerManagerService;
import com.larus.audioplayer.impl.manager.GlobalAudioControllerImpl;
import com.larus.audioplayer.impl.music.MusicPlayManagerService;
import com.larus.audioplayer.impl.news.NewsUrlAudioManagerService;
import com.larus.audioplayer.impl.news.UrlAudioPlayerService;
import com.larus.audioplayer.impl.observer.GlobalAudioObserverImpl;
import com.larus.audioplayer.impl.utils.MusicActionUtilService;
import com.larus.avatar.impl.DigitalAvatarServiceImpl;
import com.larus.avlink.chat.ChatDoraServiceImpl;
import com.larus.avlink.chat.DoraProxyImpl;
import com.larus.avlink.e.DoraEPicDividerTaskProvider;
import com.larus.avlink.env.diary.block.DiaryImageBlockProvider;
import com.larus.avlink.env.diary.block.DiarySummaryBlockProvider;
import com.larus.avlink.gallery.AlbumImpl;
import com.larus.avlink.impl.DoraAVLinkServiceImpl;
import com.larus.avlink.impl.DoraEServiceImpl;
import com.larus.avlink.utils.DoraTracerService;
import com.larus.aweme.impl.AwemeVideoFeed;
import com.larus.aweme.impl.video.MainBotServiceImpl;
import com.larus.aweme.impl.video.VideoFragmentProviderImpl;
import com.larus.bach.impl.BachDetectCenterAbilityImpl;
import com.larus.bach.impl.BachServiceImpl;
import com.larus.basic.experience.downgrade.impl.FlowDowngradeServiceImpl;
import com.larus.bitable.biz.impl.jsb.OfficeCCMH5JSBRegistry;
import com.larus.bitable.impl.BitableOpenerImpl;
import com.larus.bitable.impl.BitableServiceImpl;
import com.larus.bitable.sdk.impl.BitableSdkServiceImpl;
import com.larus.bitable.sdk.impl.proxy.BitableLifecycleAdapter;
import com.larus.bmhome.AIChatAudioServiceImpl;
import com.larus.bmhome.AIChatControlTraceServiceImpl;
import com.larus.bmhome.AIChatConversationServiceImpl;
import com.larus.bmhome.AIChatRenderTraceServiceImpl;
import com.larus.bmhome.AIChatSRSaverImpl;
import com.larus.bmhome.AIChatServiceImpl;
import com.larus.bmhome.AIChatTTSPlayTraceImpl;
import com.larus.bmhome.AIChatUploadMediaServiceImpl;
import com.larus.bmhome.AiChatUgcAIGCServiceImpl;
import com.larus.bmhome.ChatDebugWranglerProvider;
import com.larus.bmhome.ChatTraceServiceImpl;
import com.larus.bmhome.NotifyService;
import com.larus.bmhome.auth.AuthViewModel;
import com.larus.bmhome.auth.LaunchAccountRemovedCacheServiceImpl;
import com.larus.bmhome.auth.LaunchCacheImpl;
import com.larus.bmhome.auth.LaunchImpl;
import com.larus.bmhome.auth.LaunchMetricImpl;
import com.larus.bmhome.auth.feature_config.FeatureKitImpl;
import com.larus.bmhome.block.MainBotBlockKitExperimentProvider;
import com.larus.bmhome.block.pipeline.task.AddBlockBizModelAfterBizModelListTask;
import com.larus.bmhome.block.pipeline.task.BlockPipelineDeepThinkTaskModeTask;
import com.larus.bmhome.block.pipeline.task.BlockPipelineTaskCotPagePreprocessTask;
import com.larus.bmhome.block.pipeline.task.ElapsedBlockPreprocessPipelineTask;
import com.larus.bmhome.block.pipeline.task.FilterHiddenQuickReplyBlockTask;
import com.larus.bmhome.block.pipeline.task.FlattenDeepThinkContainerPipelineTask;
import com.larus.bmhome.block.pipeline.task.FlattenSingleToolPreviewPipelineTask;
import com.larus.bmhome.block.pipeline.task.MainBotRenderContextPipelineTask;
import com.larus.bmhome.block.pipeline.task.RichMediaLayoutPositionPipelineTask;
import com.larus.bmhome.block.pipeline.task.RichMediaLocalFileFallbackTask;
import com.larus.bmhome.block.presentation.BlockDetailNavigatorServiceImpl;
import com.larus.bmhome.block.provider.ArtifactOpBlockProvider;
import com.larus.bmhome.block.provider.AuthIdentityBlockProvider;
import com.larus.bmhome.block.provider.BizMergeForwardBlockProvider;
import com.larus.bmhome.block.provider.CommerceCreditBlockProvider;
import com.larus.bmhome.block.provider.ContentWebSearchBlockProvider;
import com.larus.bmhome.block.provider.DeepThinkBlockProvider;
import com.larus.bmhome.block.provider.DeepThinkCodeBlockProvider;
import com.larus.bmhome.block.provider.DeepThinkImageAnalysisBlockProvider;
import com.larus.bmhome.block.provider.DeepThinkImageSearchBlockProvider;
import com.larus.bmhome.block.provider.DeepThinkSearchCotBlockProvider;
import com.larus.bmhome.block.provider.ElapsedBlockProvider;
import com.larus.bmhome.block.provider.GenImageBlockProvider;
import com.larus.bmhome.block.provider.LinkReaderBlockProvider;
import com.larus.bmhome.block.provider.LynxCardBlockProvider;
import com.larus.bmhome.block.provider.MetaInfoBlockProvider;
import com.larus.bmhome.block.provider.PoiBlockProvider;
import com.larus.bmhome.block.provider.ResearchWebpageBlockProvider;
import com.larus.bmhome.block.provider.RiskTipsBlockProvider;
import com.larus.bmhome.block.provider.RoutePlanBlockProvider;
import com.larus.bmhome.block.provider.SpringLynxBlockProvider;
import com.larus.bmhome.block.provider.TextBlockProvider;
import com.larus.bmhome.blockarch.impl.DeepThinkBlockServiceImpl;
import com.larus.bmhome.bot.BotStatusCache;
import com.larus.bmhome.bot.setting.ChatSettingComponentRegistry;
import com.larus.bmhome.chat.AiChatMainBotModuleServiceImpl;
import com.larus.bmhome.chat.ChatAzerothServiceImpl;
import com.larus.bmhome.chat.ChatCommonComponentRegistry;
import com.larus.bmhome.chat.FlowMessageImpl;
import com.larus.bmhome.chat.FragmentProviderImpl;
import com.larus.bmhome.chat.LegacyChatServiceImpl;
import com.larus.bmhome.chat.MarkdownResolverServiceImpl;
import com.larus.bmhome.chat.ObricMessageExtImpl;
import com.larus.bmhome.chat.banner.ActiveSwitchBannerComponentRegistry;
import com.larus.bmhome.chat.blockarch.provider.PureVideoBlockProvider;
import com.larus.bmhome.chat.bubble.floating.component.BubbleBannerComponentRegistry;
import com.larus.bmhome.chat.bubble.floating.datasource.BubbleBannerDataServiceImpl;
import com.larus.bmhome.chat.bubble.floating.reach.ChatBottomReachHost;
import com.larus.bmhome.chat.bubble.floating.reach.GeneralBannerReachLifecycleListener;
import com.larus.bmhome.chat.bubble.floating.report.BannerShowReportServiceImpl;
import com.larus.bmhome.chat.bubble.floating.report.BubbleBannerTracker;
import com.larus.bmhome.chat.bubble.floating.runtime.BubbleBannerRuntimeServiceImpl;
import com.larus.bmhome.chat.bubble.floating.source.CommerceMembershipCTABubbleBannerSourceListener;
import com.larus.bmhome.chat.bubble.floating.source.GuidePcBubbleBannerSourceListener;
import com.larus.bmhome.chat.bubble.floating.source.MuseumExtensionBubbleBannerSourceListener;
import com.larus.bmhome.chat.bubble.floating.source.NotificationSwitchBubbleBannerSourceListener;
import com.larus.bmhome.chat.bubble.floating.source.ResendBubbleBannerSourceListener;
import com.larus.bmhome.chat.cache.BotInfoCacheImpl;
import com.larus.bmhome.chat.component.InputComponentRegistry;
import com.larus.bmhome.chat.component.block.ChatUIBlockComponentRegistry;
import com.larus.bmhome.chat.component.bottom.core.InputViewCreator;
import com.larus.bmhome.chat.component.bottom.core.follow.InputSwipePanelServiceImpl;
import com.larus.bmhome.chat.component.bottom.multimodal.upload.FileUploadServiceImpl;
import com.larus.bmhome.chat.component.camera.CameraCommandSideEffectFactoryImpl;
import com.larus.bmhome.chat.component.collection.CollectionEventHelper;
import com.larus.bmhome.chat.component.halfscreen.ChatCommonPageStateComponentRegistry;
import com.larus.bmhome.chat.component.input.InputServiceProviderImpl;
import com.larus.bmhome.chat.component.list.pipeline.AddEduCameraContinuerShootTaskProvider;
import com.larus.bmhome.chat.component.list.pipeline.AddLoadingTaskProvider;
import com.larus.bmhome.chat.component.list.pipeline.AddSpacerTaskProvider;
import com.larus.bmhome.chat.component.list.pipeline.AddSuggestPromptTaskProvider;
import com.larus.bmhome.chat.component.list.pipeline.AiDisclaimerTaskProvider;
import com.larus.bmhome.chat.component.list.pipeline.AwemeOnboardingTaskProvider;
import com.larus.bmhome.chat.component.list.pipeline.AwemeVideoSuggestFilterTaskProvider;
import com.larus.bmhome.chat.component.list.pipeline.BigAvatarTaskProvider;
import com.larus.bmhome.chat.component.list.pipeline.ClearContextTaskProvider;
import com.larus.bmhome.chat.component.list.pipeline.DeleteStageProvider;
import com.larus.bmhome.chat.component.list.pipeline.DirectAddStageProvider;
import com.larus.bmhome.chat.component.list.pipeline.FilterTaskProvider;
import com.larus.bmhome.chat.component.list.pipeline.FinalFilterStageProvider;
import com.larus.bmhome.chat.component.list.pipeline.ForceLoadingWhenStreamingTaskProvider;
import com.larus.bmhome.chat.component.list.pipeline.ImmerseCutTaskProvider;
import com.larus.bmhome.chat.component.list.pipeline.NeedTraversalStageProvider;
import com.larus.bmhome.chat.component.list.pipeline.OfflineMessageTaskProvider;
import com.larus.bmhome.chat.component.list.pipeline.PreDependentFilterTaskProvider;
import com.larus.bmhome.chat.component.list.pipeline.PreDependentStageProvider;
import com.larus.bmhome.chat.component.list.pipeline.PreviewRoundMessageFilterTaskProvider;
import com.larus.bmhome.chat.component.list.pipeline.PromptFilterTaskProvider;
import com.larus.bmhome.chat.component.list.pipeline.RecommendDividerTaskProvider;
import com.larus.bmhome.chat.component.list.pipeline.TimeStampDividerTaskProvider;
import com.larus.bmhome.chat.component.list.pipeline.UpdatePromptLoadingTaskProvider;
import com.larus.bmhome.chat.component.list.pipeline.UpdateStageProvider;
import com.larus.bmhome.chat.component.list.pipeline.UserActiveDeleteTipTaskProvider;
import com.larus.bmhome.chat.component.list.pipeline.need_traversal.MarkWidgetStageProvider;
import com.larus.bmhome.chat.component.list.pipeline.need_traversal.SpecialProvider;
import com.larus.bmhome.chat.component.nita.ChatBottomNitaViewImpl;
import com.larus.bmhome.chat.cotdetail.CotDetailMessageExtServiceImpl;
import com.larus.bmhome.chat.cotdetail.CotDetailServiceImpl;
import com.larus.bmhome.chat.detail.code.preview.AiChatCodePreviewServiceImpl;
import com.larus.bmhome.chat.feedback.ChatFeedbackServiceImpl;
import com.larus.bmhome.chat.headerinfo.DeepThinkHeaderServiceImpl;
import com.larus.bmhome.chat.instruction.helper.ConvReplyModeRecordHelper;
import com.larus.bmhome.chat.larkforward.FlowLarkToDoubaoServiceImpl;
import com.larus.bmhome.chat.list.cell.test.CrowdTestTaskProvider;
import com.larus.bmhome.chat.list.cell.text.interceptor.MarkdownRenderInterceptorImpl;
import com.larus.bmhome.chat.markdown.CustomDataHandlerProvider;
import com.larus.bmhome.chat.messagetransfer.DoubaoToLarkForwardLimitServiceImpl;
import com.larus.bmhome.chat.messagetransfer.FlowMergeForwardServiceImpl;
import com.larus.bmhome.chat.model.repo.BotRepo;
import com.larus.bmhome.chat.model.repo.ChatRepo;
import com.larus.bmhome.chat.model.repo.ConversationRepo;
import com.larus.bmhome.chat.model.repo.RepoDispatcherImpl;
import com.larus.bmhome.chat.monitor.CommonUIMessageImageLoaderImpl;
import com.larus.bmhome.chat.monitor.MessageImageLoaderServiceImpl;
import com.larus.bmhome.chat.nestedmenu.NestMenuComponentRegistry;
import com.larus.bmhome.chat.nestedmenu.NestMenuServiceImpl;
import com.larus.bmhome.chat.nita.ChatNitaPreloadServiceImpl;
import com.larus.bmhome.chat.outerinput.OuterChatInputProviderImpl;
import com.larus.bmhome.chat.reddot.ConversationRedDotServiceImpl;
import com.larus.bmhome.chat.service.ConversationFeedActionServiceImpl;
import com.larus.bmhome.chat.service.NestFileServiceImpl;
import com.larus.bmhome.chat.service.NestedFileCacheManagerServiceImpl;
import com.larus.bmhome.chat.serviceimpl.MainBotCommonServiceImpl;
import com.larus.bmhome.chat.standarduikit.StandardUiKitServiceImpl;
import com.larus.bmhome.chat.standarduikit.artifactfallback.blockadapter.ArtifactFallbackBlockProvider;
import com.larus.bmhome.chat.standarduikit.botreferencetext.blockadapter.BotReferenceTextBlockProvider;
import com.larus.bmhome.chat.standarduikit.browsercontrol.blockadapter.BrowserControlBlockProvider;
import com.larus.bmhome.chat.standarduikit.clarification.blockadapter.InteractionAskBlockProvider;
import com.larus.bmhome.chat.standarduikit.codeartifact.blockadapter.CodeArtifactBlockProvider;
import com.larus.bmhome.chat.standarduikit.coderenderandinterceptor.blockadapter.ContentCodeBlockProvider;
import com.larus.bmhome.chat.standarduikit.commonbutton.blockadapter.CommonButtonBlockProvider;
import com.larus.bmhome.chat.standarduikit.commonbuttonv2.blockadapter.CommonButtonV2BlockProvider;
import com.larus.bmhome.chat.standarduikit.complextask.blockadapter.ComplexTaskBlockProvider;
import com.larus.bmhome.chat.standarduikit.computerusetool.api.CuaApiImpl;
import com.larus.bmhome.chat.standarduikit.computerusetool.blockadapter.ComputerUseToolResultBlockProvider;
import com.larus.bmhome.chat.standarduikit.deepresearchcard.blockadapter.ResearchBlockProvider;
import com.larus.bmhome.chat.standarduikit.deepresearchprogresscard.blockadapter.ResearchProcessBlockProvider;
import com.larus.bmhome.chat.standarduikit.fileblock.OfficeHtmlFileDownloadServiceImpl;
import com.larus.bmhome.chat.standarduikit.fileblock.blockadapter.FileBlockProvider;
import com.larus.bmhome.chat.standarduikit.fileblock.renderer.FileStyleArtifactRendererServiceImpl;
import com.larus.bmhome.chat.standarduikit.fileoperation.blockadapter.FileOperationBlockProvider;
import com.larus.bmhome.chat.standarduikit.generictool.blockadapter.FileOperateBlockProvider;
import com.larus.bmhome.chat.standarduikit.guitool.blockadapter.GuiToolBlockProvider;
import com.larus.bmhome.chat.standarduikit.linkblock.blockadapter.LinkBlockHolderProvider;
import com.larus.bmhome.chat.standarduikit.localfileblock.blockadapter.LocalFileBlockProvider;
import com.larus.bmhome.chat.standarduikit.localfileblock.blockadapter.PcLocalFileBlockProvider;
import com.larus.bmhome.chat.standarduikit.lyricstosong.blockadapter.LyricsToSongBlockProvider;
import com.larus.bmhome.chat.standarduikit.memory.blockadapter.MemoryBlockProvider;
import com.larus.bmhome.chat.standarduikit.miaodaartifact.blockadapter.MiaodaArtifactBlockProvider;
import com.larus.bmhome.chat.standarduikit.quickreply.blockadapter.QuickReplyBlockProvider;
import com.larus.bmhome.chat.standarduikit.quickreply.blockadapter.inputpanel.QuickReplyInputPanelBlockProvider;
import com.larus.bmhome.chat.standarduikit.quickreply.blockadapter.thinking.QuickReplyThinkingBlockProvider;
import com.larus.bmhome.chat.standarduikit.realname.blockadapter.RealNameBlockProvider;
import com.larus.bmhome.chat.standarduikit.replytextloading.blockadapter.ReplyTextLoadingBlockProvider;
import com.larus.bmhome.chat.standarduikit.richmedia.blockadapter.RichMediaLayoutBlockProvider;
import com.larus.bmhome.chat.standarduikit.searchmixedmedia.blockadapter.SearchMixedMediaBlockProvider;
import com.larus.bmhome.chat.standarduikit.splitline.blockadapter.SplitLineBlockProvider;
import com.larus.bmhome.chat.standarduikit.taskcard.blockadapter.TaskCardBlockProvider;
import com.larus.bmhome.chat.standarduikit.videogroup.blockadapter.RelatedVideoBlockProvider;
import com.larus.bmhome.chat.thinkmode.ThinkModeMemoryReportServiceImpl;
import com.larus.bmhome.chat.tips.GuideTipsService;
import com.larus.bmhome.chat.trace.AiChatTraceImpl;
import com.larus.bmhome.chat.trace.ChatImTraceServiceImpl;
import com.larus.bmhome.chat.trace.appreciable.AppreciableTraceService;
import com.larus.bmhome.chat.trace.multemodal.MultimodalTraceService;
import com.larus.bmhome.chat.widgetblock.WidgetBlockProvider;
import com.larus.bmhome.chat.zoom.providers.CodeBlockZoomInAnimationImpl;
import com.larus.bmhome.chat.zoom.providers.ImageAnalysisZoomInAnimationImpl;
import com.larus.bmhome.chat.zoom.providers.ImageSearchZoomInAnimationImpl;
import com.larus.bmhome.chat.zoom.providers.SearchCotZoomInAnimationImpl;
import com.larus.bmhome.component.ClarificationComponentRegistry;
import com.larus.bmhome.component.InputAreaBlockComponentRegistry;
import com.larus.bmhome.component.MainConversationInteractionPanelComponentRegistry;
import com.larus.bmhome.component.TextCellComponentRegistry;
import com.larus.bmhome.creative.api.InputOnlyContainerRegistry;
import com.larus.bmhome.double_post.DoublePostServiceImpl;
import com.larus.bmhome.double_post.utils.AwemeDoublePostTrackServiceImpl;
import com.larus.bmhome.floatchat.FloatChatServiceImpl;
import com.larus.bmhome.floatchat.FloatComponentRegistry;
import com.larus.bmhome.input.impl.EnterKeyBehaviorServiceImpl;
import com.larus.bmhome.instruction.InstructionUtilsService;
import com.larus.bmhome.instruction.suggest.PromptSelectActionDispatcherServiceImpl;
import com.larus.bmhome.interactionpanel.InteractionPanelSidebarServiceImpl;
import com.larus.bmhome.larkinput.impl.service.LarkInputServiceImpl;
import com.larus.bmhome.legacy.ChatLegacyCardComponentRegistry;
import com.larus.bmhome.legacy.ChatLegacyChatBottomComponentRegistry;
import com.larus.bmhome.legacy.ChatLegacyChatTitleComponentRegistry;
import com.larus.bmhome.legacy.ChatLegacyCloudTestComponentRegistry;
import com.larus.bmhome.legacy.ChatLegacyComponentRegistry;
import com.larus.bmhome.legacy.ChatLegacyFastSendImageComponentRegistry;
import com.larus.bmhome.legacy.ChatLegacyListComponentRegistry;
import com.larus.bmhome.legacy.ChatLegacyNonNecessaryComponentRegistry;
import com.larus.bmhome.legacy.MsgOnlyContainerRegistry;
import com.larus.bmhome.legacy.ServiceBotNecessaryComponentRegistry;
import com.larus.bmhome.setting.PostLaunchInfoService;
import com.larus.bmhome.setting.SettingRepo;
import com.larus.bmhome.setting.UserSettingCacheImpl;
import com.larus.bmhome.social.chat.layout.convertor.AIImageContentConvertor;
import com.larus.bmhome.social.chat.layout.convertor.AudioTextContentConverter;
import com.larus.bmhome.social.chat.layout.convertor.TextContentConvertor;
import com.larus.bmhome.social.chat.layout.convertor.UserImageContentConvertor;
import com.larus.bmhome.taskskill.PcLocalDispatcherMessageExtService;
import com.larus.bmhome.taskskill.SkillComponentRegistry;
import com.larus.bmhome.taskskill.pipeline.DeviceOrRuntimeChangedTaskProvider;
import com.larus.bmhome.taskskill.service.PcDevicePanelServiceImpl;
import com.larus.bmhome.taskskill.service.SkillServiceImpl;
import com.larus.bmhome.taskskill.serviceimpl.TaskModeServiceImpl;
import com.larus.bmhome.top.ChatTopComponentRegistry;
import com.larus.bmhome.tts.AutoReadTtsInterceptor;
import com.larus.bmhome.tts.ManualReadTtsInterceptor;
import com.larus.bmhome.tts.OnboardingTtsInterceptor;
import com.larus.bmhome.upload.sdk.impl.spi.ImageUploadSdkBuilderFactoryImpl;
import com.larus.bmhome.utils.LandingRedBadgeHelper;
import com.larus.bmhome.utils.LaunchLandingConfigHelper;
import com.larus.bmhome.utils.VideoShareService;
import com.larus.bmhome.video.download.VideoDownloadLoadingMgr;
import com.larus.bmhome.view.actionbar.custom.ActionBarServiceImpl;
import com.larus.bmhome.view.actionbar.edit.component.CommandSubCreator;
import com.larus.bmhome.view.actionbar.edit.creator.DropdownListSelectorCreator;
import com.larus.bmhome.view.actionbar.edit.creator.FeatureSelectorCreator;
import com.larus.bmhome.view.actionbar.edit.creator.InputBoxCreator;
import com.larus.bmhome.view.actionbar.edit.creator.MultiSelectorCreator;
import com.larus.bmhome.view.actionbar.edit.creator.TabSelectorCreator;
import com.larus.bmhome.view.actionbar.edit.creator.TextListSelectorCreator;
import com.larus.bmhome.view.actionbar.edit.creator.TranslatorCreator;
import com.larus.bmhome.view.actionbar.edit.creator.UserMessageSenderCreator;
import com.larus.bmhome.view.actionbar.edit.creator.sub.ButtonRouterSelectorSubCreator;
import com.larus.bmhome.view.actionbar.edit.creator.sub.CollaboratedMultiFeatureSelectorSubCreator;
import com.larus.bmhome.view.actionbar.edit.creator.sub.DropdownSelectorSubCreator;
import com.larus.bmhome.view.actionbar.edit.creator.sub.FeatureSelectorSubCreator;
import com.larus.bmhome.view.actionbar.edit.creator.sub.ReferenceImageUploadSubCreator;
import com.larus.bmhome.view.actionbar.edit.kmp.widget.CommandKmpInstructionWidgetProvider;
import com.larus.bmhome.view.actionbar.gaokao.GaokaoPreferenceServiceImpl;
import com.larus.bmhome.view.chatinput.ChatInputServiceImpl;
import com.larus.bootprotector.BootProtectorLauncher;
import com.larus.bootprotector.hotfix.BootProtectorHotPatchImpl;
import com.larus.bootprotector.impl.BootProtectorDebugServiceImpl;
import com.larus.bootprotector.mock.BootProtectorDefaultBizCallback;
import com.larus.bot.impl.service.BotCreateServiceImpl;
import com.larus.bot.impl.service.BotDiscoverServiceImpl;
import com.larus.bot.impl.service.BotHealthServiceImpl;
import com.larus.bot.impl.service.BotMakerServiceImpl;
import com.larus.bot.impl.service.BotPerfMonitorServiceImpl;
import com.larus.bot.impl.service.BotRouteInterceptorServiceImpl;
import com.larus.bot.impl.service.UgcBotRepoServiceImpl;
import com.larus.browsertakeover.entry.BrowserTakeoverServiceImpl;
import com.larus.btm.impl.BTMServiceImpl;
import com.larus.business.accessbility.impl.AccessibilityServiceImpl;
import com.larus.business.debug.base.DebugBaseServiceImpl;
import com.larus.business.debug.base.livetutor.LiveTutorDebugServiceImpl;
import com.larus.business.debug.base.nmt.NmtInjectServiceImpl;
import com.larus.business.floatchat.impl.AIFloatChatComponentRegistry;
import com.larus.business.floatchat.impl.AIFloatChatServiceImpl;
import com.larus.business.multitask_management.impl.MultiTaskHostAbilityImpl;
import com.larus.business.multitask_management.impl.MultiTaskServiceImpl;
import com.larus.business.multitask_management.impl.spi.MultiTaskFrontierServiceImpl;
import com.larus.business.multitask_management.impl.view.DefaultTaskUIFactory;
import com.larus.caijing_pay.impl.init.CJPayInitiator;
import com.larus.caijing_pay.impl.init.CJPayServiceImpl;
import com.larus.camera.impl.FlowCameraImpl;
import com.larus.canvas.service.CanvasRepoServiceImpl;
import com.larus.canvas.service.CanvasServiceImpl;
import com.larus.cdm.impl.FlowCompanionDeviceManagerImpl;
import com.larus.chat.gallery.impl.ChatGalleryServiceImpl;
import com.larus.chat.gallery.impl.providers.FindSimilarAvailabilityCheckerImpl;
import com.larus.chat.gallery.impl.providers.FindSimilarClickHandlerImpl;
import com.larus.chat.job.impl.arch.ChatJobComponentRegistry;
import com.larus.chat.job.impl.arch.ChatJobFragmentFactoryImpl;
import com.larus.chat.job.impl.experiment.ChatJobExperimentProvider;
import com.larus.chat.search.impl.NewSearchServiceImpl;
import com.larus.collection.impl.CollectImpl;
import com.larus.commercecredit.impl.CommerceCreditService;
import com.larus.commercecredit.impl.component.ChatCommerceCreditComponentRegistry;
import com.larus.commercemembership.impl.CommerceMembershipService;
import com.larus.commercemembership.impl.component.ChatCommerceMembershipComponentRegistry;
import com.larus.common.account.bdauth.impl.BdauthServiceImpl;
import com.larus.common.account.douyin.DouyinAuthServiceImpl;
import com.larus.common.account.douyin.DouyinHeartBeatServiceImpl;
import com.larus.common.account.douyin.DouyinLogin;
import com.larus.common.account.douyin.ai.chat.AiChatOpenDouyinAuthServiceImpl;
import com.larus.common.account.phone.PhoneLogin;
import com.larus.common.account.platform.larkauth.LarkAuthorization;
import com.larus.common.account.platform.larklogin.LarkLogin;
import com.larus.common.account.weixin.WeixinLogin;
import com.larus.common.app_ops.AppOpsService;
import com.larus.common.baidunavi.impl.BaiduNaviServiceImpl;
import com.larus.common.location.impl.LocationClient;
import com.larus.common.mssdk.impl.SecurityServiceImpl;
import com.larus.common.pollingconfig.impl.PollingConfigImpl;
import com.larus.common.venue.impl.FlowCommonVenueServiceImpl;
import com.larus.common.zlink.impl.ZlinkServiceImpl;
import com.larus.community.impl.applet.AICreationAppletHostServiceImpl;
import com.larus.community.impl.applet.AICreationCommunityFeedRequestSourceFactory;
import com.larus.community.impl.applet.DoubaoCommunityHostBehaviorProvider;
import com.larus.community.impl.applet.music.MusicAppletHostServiceImpl;
import com.larus.community.impl.detail.CreationAppletDetailProviderImpl;
import com.larus.community.impl.detail.DoubaoCommunityDetailContainerProvider;
import com.larus.community.impl.home.AICreationSidebarLauncher;
import com.larus.community.impl.landing.CreationUserLandingComponentRegister;
import com.larus.community.impl.service.CreationServiceImpl;
import com.larus.contextwindow.impl.actionbar.ContextWindowActionBarProvider;
import com.larus.contextwindow.impl.component.ContextWindowEntryComponentRegistry;
import com.larus.contextwindow.impl.service.ContextWindowUsageServiceImpl;
import com.larus.crossplatform.card.impl.CrossPlatformMDDataHandlerProvider;
import com.larus.crossplatform.card.impl.CrossPlatformMarkdownServiceImpl;
import com.larus.crossplatform.card.impl.HybridCardsComponentRegistry;
import com.larus.deeplink.impl.DeeplinkServiceImpl;
import com.larus.discover.impl.service.DiscoverServiceImpl;
import com.larus.disk.impl.IAppDiskServiceImpl;
import com.larus.doc.impl.DocOpenerImpl;
import com.larus.doc.impl.DocServiceImpl;
import com.larus.doc.impl.chat.DocFloatChatComponentRegistry;
import com.larus.doc.impl.chat.DocMessageExtServiceImpl;
import com.larus.doc.impl.operation.download.OfficeDocExportDelegateImpl;
import com.larus.doc.sdk.impl.service.DocSdkBaseServiceImpl;
import com.larus.doc.sdk.impl.v2.DocPermissionServiceImpl;
import com.larus.doc.sdk.impl.v2.DocSdkServiceImplV2;
import com.larus.doc.sdk.impl.v2.adapter.DocLifecycleAdapter;
import com.larus.dora.dorag.res.DoraByteCastManager;
import com.larus.dora.impl.DoraObricServiceImpl;
import com.larus.dora.impl.DoraServiceImpl;
import com.larus.dora.impl.assistant.ObricAssistantWifiServiceImpl;
import com.larus.dora.impl.config.DoraPageConfigServiceImpl;
import com.larus.dora.impl.guide.service.DoraGuideServiceImpl;
import com.larus.dora.impl.network.DoraDeviceInfoImpl;
import com.larus.dora.impl.nl.NLServiceImpl;
import com.larus.dora.impl.offline.record.DoraOfflineRecordSyncServiceImpl;
import com.larus.dora.o.impl.DoraOUIServiceImpl;
import com.larus.dora.o.impl.diary.DoraODiaryServiceImpl;
import com.larus.dora.o.impl.health.DoraOHealthServiceImpl;
import com.larus.dora.obric.onboarding.ObricEnvAuthSheetServiceImpl;
import com.larus.dorag.impl.DoraGResourceServiceImpl;
import com.larus.drive.biz.impl.DriveOpenerImpl;
import com.larus.drive.biz.impl.DriveServiceImpl;
import com.larus.drive.biz.impl.search.kmp.KmpDriveSearchActionHandlerServiceImpl;
import com.larus.drive.biz.impl.search.kmp.KmpDriveSearchCellProvider;
import com.larus.drive.sdk.impl.DriveSdkGenericServiceImpl;
import com.larus.drive.sdk.impl.DriveSdkServiceImpl;
import com.larus.drive.sdk.impl.DriveSdkServiceImplV2;
import com.larus.drive.sdk.impl.FlowDriveSdkServiceImpl;
import com.larus.drive.sdk.impl.FlowOfficeFileDownloadServiceImpl;
import com.larus.drive.sdk.impl.KmpSearchDriveServiceImpl;
import com.larus.drive.sdk.impl.adapter.DriveLifecycleAdapter;
import com.larus.drive.sdk.impl.component.chat.DriveChatComponentRegistry;
import com.larus.e_commerce.impl.ECommerceServiceImpl;
import com.larus.e_commerce.impl.address.ECommerceMessageExtServiceImpl;
import com.larus.e_commerce.impl.order.ChatOrderSettingsComponentRegistry;
import com.larus.e_commerce.impl.servicebot.ServiceBotBtmRegistry;
import com.larus.e_commerce.impl.settings.OrderMessageNotifySettingsProviderImpl;
import com.larus.enterprise.impl.EnterpriseServiceImpl;
import com.larus.enterprise.impl.apptheme.FlowAccountThemeConfigProvider;
import com.larus.enterprise.impl.apptheme.FlowChatThemeConfigProvider;
import com.larus.enterprise.impl.apptheme.FlowCreationThemeConfigProvider;
import com.larus.enterprise.impl.apptheme.FlowOfficeThemeConfigProvider;
import com.larus.enterprise.impl.apptheme.FlowProfileThemeConfigProvider;
import com.larus.enterprise.impl.apptheme.FlowSettingThemeConfigProvider;
import com.larus.enterprise.impl.apptheme.FlowThemeConfigProvider;
import com.larus.enterprise.impl.apptheme.repo.FlowDocExportConfigProvider;
import com.larus.enterprise_biz.impl.EnterpriseWhiteListServiceImpl;
import com.larus.enterprise_biz.impl.share.ShareOfficeDocServiceImpl;
import com.larus.extension.aggregate_search_ui.impl.component.list.cell.kmp.KmpInternalSearchCellDefaultProvider;
import com.larus.extension.aggregate_search_ui.impl.service.AggregateSearchUiServiceImpl;
import com.larus.extension.chat_extension.impl.DouyinRecommendServiceImpl;
import com.larus.extension.chat_extension.impl.ltm.FlowSaaSBotLtmServiceImpl;
import com.larus.extension.summary_card.impl.SummaryCardServiceImpl;
import com.larus.extension.summary_card.impl.component.SummaryCardComponentRegistry;
import com.larus.feedback.impl.service.FlowFeedbackServiceImpl;
import com.larus.feishu.office.im.impl.FlowAdapterExtensionFactoryServiceImpl;
import com.larus.feishu.office.im.impl.FlowAttachmentExtensionFactoryServiceImpl;
import com.larus.feishu.office.im.impl.FlowCameraExtensionFactoryServiceImpl;
import com.larus.feishu.office.im.impl.FlowComponentAdaptServiceImpl;
import com.larus.feishu.office.im.impl.FlowFastAlbumAbilityFactoryServiceImpl;
import com.larus.feishu.office.im.impl.FlowFloatExpandExtensionFactoryServiceImpl;
import com.larus.feishu.office.im.impl.FlowInputMenuStateServiceImpl;
import com.larus.feishu.office.im.impl.FlowKeyboardConfigExtensionFactoryServiceImpl;
import com.larus.feishu.office.im.impl.FlowPlusExtensionFactoryServiceImpl;
import com.larus.feishu.office.im.impl.FlowVoiceInputExtensionFactoryServiceImpl;
import com.larus.feishu.office.im.impl.docpreview.MessageDocPreviewServiceImpl;
import com.larus.feishu.office.im.impl.officemention.OfficeMentionServiceImpl;
import com.larus.feishu.office.im.impl.smart_reply.SmartReplyComponentRegistry;
import com.larus.feishu.office.im.impl.smart_reply.block.SmartReplyBlockProvider;
import com.larus.flowsdk.common.experiment.generated.business.e_commerce.impl.BusinessECommerceImplFlowClientExperimentRegistry;
import com.larus.flowsdk.common.experiment.generated.business.office.drive.drive_sdk.impl.BusinessOfficeDriveDriveSdkImplFlowClientExperimentRegistry;
import com.larus.flowsdk.common.experiment.generated.flowsdk.business.browser_takeover.impl.FlowSDKBusinessBrowserTakeoverImplFlowClientExperimentRegistry;
import com.larus.flowsdk.common.experiment.generated.flowsdk.business.chat.impl.FlowSDKBusinessChatImplFlowClientExperimentRegistry;
import com.larus.flowsdk.common.experiment.generated.flowsdk.business.chat_gallery.api.FlowSDKBusinessChatGalleryApiFlowClientExperimentRegistry;
import com.larus.flowsdk.common.experiment.generated.flowsdk.business.chat_gallery.impl.FlowSDKBusinessChatGalleryImplFlowClientExperimentRegistry;
import com.larus.flowsdk.common.experiment.generated.flowsdk.business.chat_job.impl.FlowSDKBusinessChatJobImplFlowClientExperimentRegistry;
import com.larus.flowsdk.common.experiment.generated.flowsdk.business.context_window.impl.FlowSDKBusinessContextWindowImplFlowClientExperimentRegistry;
import com.larus.flowsdk.common.experiment.generated.flowsdk.business.enterprise.impl.FlowSDKBusinessEnterpriseImplFlowClientExperimentRegistry;
import com.larus.flowsdk.common.experiment.generated.flowsdk.business.flow_skill.api.FlowSDKBusinessFlowSkillApiFlowClientExperimentRegistry;
import com.larus.flowsdk.common.experiment.generated.flowsdk.business.modules.chat_common.FlowSDKBusinessModulesChatCommonFlowClientExperimentRegistry;
import com.larus.flowsdk.common.experiment.generated.flowsdk.business.modules.input.impl.FlowSDKBusinessModulesInputImplFlowClientExperimentRegistry;
import com.larus.flowsdk.common.experiment.generated.flowsdk.business.modules.message_transfer.impl.FlowSDKBusinessModulesMessageTransferImplFlowClientExperimentRegistry;
import com.larus.flowsdk.common.experiment.generated.flowsdk.business.office.api.FlowSDKBusinessOfficeApiFlowClientExperimentRegistry;
import com.larus.flowsdk.common.experiment.generated.flowsdk.business.office.impl.FlowSDKBusinessOfficeImplFlowClientExperimentRegistry;
import com.larus.flowsdk.common.experiment.generated.flowsdk.business.platform.FlowSDKBusinessPlatformFlowClientExperimentRegistry;
import com.larus.flowsdk.common.experiment.generated.flowsdk.business.reach.impl.FlowSDKBusinessReachImplFlowClientExperimentRegistry;
import com.larus.flowsdk.security.impl.FlowFileProtectionServiceImpl;
import com.larus.flowskill.impl.actionbar.TaskSkillActionBarProvider;
import com.larus.home.impl.HomeServiceImpl;
import com.larus.home.impl.HomeServiceV2Impl;
import com.larus.home.impl.LarkOfficeAppLinkInterceptorProvider;
import com.larus.home.impl.keva.KevaPreloadServiceImpl;
import com.larus.home.impl.main.side_bar.data.ConversationGroupConfigProviderImpl;
import com.larus.home.impl.main.side_bar.view.SideBarConversationIconServiceImpl;
import com.larus.home.impl.privacy.ISecPrivacyServiceImpl;
import com.larus.home.impl.privacy.PrivacyServiceImpl;
import com.larus.home.impl.route.HomeRouterServiceImpl;
import com.larus.home.impl.sdk.FlowSdkDependImpl;
import com.larus.home.impl.sdk.MainDouyinAuthService;
import com.larus.home.impl.sdk.audit.FlowBehaviorAuditServiceImpl;
import com.larus.home.impl.sdk.common.FlowSdkCommonDependImpl;
import com.larus.home.impl.sdk.office.FlowOfficeUrlPreviewHostService;
import com.larus.hotpatch.reparo.ReparoHotPatchImpl;
import com.larus.im.InstantMessengerImpl;
import com.larus.init.task.AbTestInitiator;
import com.larus.init.task.AppLogInitiator;
import com.larus.init.task.ImageInitiator;
import com.larus.init.task.bootprotector.BootProtectorDependencyImpl;
import com.larus.init.task.obric.OfficeSdkLazyInitServiceImpl;
import com.larus.init.task.publishtest.PublishDrillServiceImpl;
import com.larus.init.task.util.MarkdownCrashRecovery;
import com.larus.instruction.service.InstructionServiceImpl;
import com.larus.ivykit.anniex.ContainerRedirectServiceImpl;
import com.larus.ivykit.forest.FlowGeckoResourceService;
import com.larus.ivykit.forest.ObricGeckoResourceService;
import com.larus.ivykit.web.TTWebViewServiceImpl;
import com.larus.jato.impl.JatoImpl;
import com.larus.larkfeed.impl.FlowFeedImpl;
import com.larus.larkfeed.impl.FlowLarkFeedImpl;
import com.larus.larkfeed.impl.OfficeSocialBridgeImpl;
import com.larus.larkfeed.impl.lark.holder.content.longpress.DouBaoTextSelectServiceImpl;
import com.larus.larkfeed.impl.mixedfeed.flow.SideBarLarkFeedProvider;
import com.larus.larkfeed.impl.reach.SocialImReachSceneInterceptor;
import com.larus.larkfeed.impl.service.ChatLarkForwardService;
import com.larus.lbs.trace.impl.LbsTraceServiceImpl;
import com.larus.live.impl.LiveService;
import com.larus.live.impl.bridge.xbridge.LiveMethodFinderProvider;
import com.larus.livetutor.impl.impl.LiveTutorServiceImpl;
import com.larus.login.impl.AccountAgeGateDialogProvider;
import com.larus.login.impl.agegate.AgeGateManager;
import com.larus.login.impl.douyinconversationauth.DouyinConversationAuthServiceImpl;
import com.larus.login.impl.impl.AccountTrace;
import com.larus.login.impl.impl.LonginServiceImpl;
import com.larus.login.impl.init.LoginInitServiceImpl;
import com.larus.login.impl.tourist.TouristServiceImpl;
import com.larus.luckydog.impl.LuckyDogComponentRegistry;
import com.larus.luckydog.impl.LuckyDogServiceImpl;
import com.larus.mainbot.impl.FlowMainBotImpl;
import com.larus.map.impl.MapServiceImpl;
import com.larus.minor.impl.ChatMinorComponentRegistry;
import com.larus.minor.impl.ChatMinorSettingsComponentRegistry;
import com.larus.minor.impl.ChatMinorTipsComponentRegistry;
import com.larus.minor.impl.MinorServiceImpl;
import com.larus.mirabridge.impl.service.MiraUtilServiceImpl;
import com.larus.mirabridge.impl.service.PluginInternalServiceImpl;
import com.larus.mirabridge.impl.service.PluginServiceImpl;
import com.larus.mirabridge.impl.service.PrePluginServiceImpl;
import com.larus.navigation.impl.NavigationDispatcher;
import com.larus.network.HttpConstImpl;
import com.larus.network.quota.BDNetworkTagConfigImpl;
import com.larus.nova.AppHostImpl;
import com.larus.nova.InitPeriodServiceImpl;
import com.larus.nova.KmpRouterServiceImpl;
import com.larus.nova.im.MessengerConfigsImpl;
import com.larus.nova.wallet.ChatWalletSettingsComponentRegistry;
import com.larus.office.OfficeSdkServiceImpl;
import com.larus.office.base.common.OfficePlatformServiceImpl;
import com.larus.office.base.connector.LarkConnectorArtifactServiceImpl;
import com.larus.office.base.export.FlowOfficeExportServiceImpl;
import com.larus.office.base.host.OfficeSDKLgwHeaderProvider;
import com.larus.office.base.service.OfficeSdkServiceV2;
import com.larus.office.base.service.OfficeWatermarkSdkService;
import com.larus.office.base.service.adapter.OfficeLifecycleAdapter;
import com.larus.office.base.service.adapter.OfficeWatermarkLifecycleAdapter;
import com.larus.office.base.share.ConversationSharePanelService;
import com.larus.office.card.bitable.BitableArtifactBlockProvider;
import com.larus.office.card.doc.DocArtifactBlockProvider;
import com.larus.office.card.doc.content.OfficeCardDocContentServiceImpl;
import com.larus.office.card.doc.create.OfficeCardDocCreateServiceImpl;
import com.larus.office.card.doc.download.OfficeCardDocDownloadServiceImpl;
import com.larus.office.card.minutes.model.AudioRecordBlockProvider;
import com.larus.office.card.ppt.PPTArtifactBlockProvider;
import com.larus.office.card.sheet.SheetArtifactBlockProvider;
import com.larus.office.card.sheet.download.OfficeCardSheetDownloadServiceImpl;
import com.larus.office.card.urlpreview.OfficeUrlPreviewActionInterceptorProviderImpl;
import com.larus.office.card.urlpreview.OfficeUrlPreviewArtifactBlockProvider;
import com.larus.office.card.urlpreview.OfficeUrlPreviewBlockPipelineObserver;
import com.larus.office.card.urlpreview.OfficeUrlPreviewFileBlockProvider;
import com.larus.office.card.urlpreview.OfficeUrlPreviewMessageListObserver;
import com.larus.office.card.urlpreview.OfficeWikiTokenResolverServiceImpl;
import com.larus.office.container.impl.OfficeContainerService;
import com.larus.office.icon.OfficeFileIconProvider;
import com.larus.office.minutes.impl.MinutesServiceImpl;
import com.larus.office.minutes.impl.adapter.MinutesSdkLifecycleAdapter;
import com.larus.office.minutes.impl.applet.RecordMultiTaskInitEventImpl;
import com.larus.office.minutes.impl.card.model.AudioRecordBlockFunnelPipelineTask;
import com.larus.office.minutes.impl.card.model.AudioRecordBlockPipelineTask;
import com.larus.office.plugins.input.cache.OfficeConversationCacheAccountRemovedServiceImpl;
import com.larus.office.plugins.input.message.OfficeMessageExtService;
import com.larus.perfdegrade.impl.PerfDegradeAbilityImpl;
import com.larus.permission.impl.IPermissionXImpl;
import com.larus.photopicker.impl.PhotoPickerImpl;
import com.larus.photopicker.v2.impl.InnerInnerPhotoPickerServiceImpl;
import com.larus.pipo.pay.impl.PipoPayServiceImpl;
import com.larus.platform.FlowSdkImpl;
import com.larus.podcast.FlowPodcastService;
import com.larus.power.state.impl.PowerStateServiceImpl;
import com.larus.praise.PraiseServiceImpl;
import com.larus.praise.base.impl.AiChatPraiseTriggerServiceImpl;
import com.larus.profile.impl.ProfileServiceImpl;
import com.larus.profile.impl.applet.CreationAppletProfileProviderImpl;
import com.larus.project.ProjectListDataSourceImpl;
import com.larus.project.create.ProjectCreatePanelServiceImpl;
import com.larus.push.impl.IPushServiceImpl;
import com.larus.reach.impl.ReachDebugServiceImpl;
import com.larus.reach.impl.ReachGlobalTopHost;
import com.larus.reach.runtime.ReachServiceImpl;
import com.larus.receive.impl.ReceiveIntentServiceImpl;
import com.larus.search.impl.AiChatHostWebServiceImpl;
import com.larus.search.impl.KmpSearchMixedFeedServiceImpl;
import com.larus.search.impl.LarkAvatarViewProvider;
import com.larus.search.impl.LarkChatServiceProxyImpl;
import com.larus.search.impl.SearchServiceImpl;
import com.larus.search.impl.global.view.aggregate.kmp.KmpAggregateSearchDomainGateServiceImpl;
import com.larus.search.impl.global.view.aggregate.kmp.KmpBotSearchCellProvider;
import com.larus.search.impl.global.view.aggregate.kmp.KmpChatSearchActionHandlerServiceImpl;
import com.larus.search.impl.global.view.aggregate.kmp.KmpContactSearchActionHandlerServiceImpl;
import com.larus.search.impl.global.view.aggregate.kmp.KmpContactSearchCellProvider;
import com.larus.search.impl.global.view.aggregate.kmp.KmpSearchAccountActionHandlerServiceImpl;
import com.larus.security.azeroth.AzerothServiceImpl;
import com.larus.setting.impl.DoubaoAppSettingsHostService;
import com.larus.setting.impl.SettingServiceImpl;
import com.larus.setting.impl.track.SettingTrace;
import com.larus.share.host.MainlandShareChannelExtraConfigurator;
import com.larus.share.host.MainlandShareKeyConfigService;
import com.larus.share.host.MainlandShareRuntimeServiceImpl;
import com.larus.share.impl.AppletSharePanelServiceImpl;
import com.larus.share.impl.ShareImpl;
import com.larus.share.impl.ShareServiceImpl;
import com.larus.share.impl.ShareShortUrlCreateServiceImpl;
import com.larus.share.impl.sdk.SharePanelService;
import com.larus.sheet.impl.SheetOpenerImpl;
import com.larus.sheet.impl.SheetServiceImpl;
import com.larus.sheet.impl.chat.SheetFloatChatComponentRegistry;
import com.larus.sheet.impl.chat.SheetMessageExtServiceImpl;
import com.larus.sheet.operation.download.OfficeSheetExportDelegateImpl;
import com.larus.sheet.sdk.impl.SheetSdkInternalServiceImpl;
import com.larus.sheet.sdk.impl.SheetSdkServiceImplV2;
import com.larus.sheet.sdk.impl.proxy.SheetLifecycleAdapter;
import com.larus.sheet.sdk.impl.proxy.SheetSdkProxyServiceImpl;
import com.larus.shortcuts.api.ShortcutPlatfomServiceImpl;
import com.larus.shortcuts.impl.ShortcutsServiceImpl;
import com.larus.showcase.service.CaseServiceImpl;
import com.larus.slides.impl.AiPptReachSceneInterceptor;
import com.larus.slides.impl.SlidesOpenerImpl;
import com.larus.slides.impl.SlidesServiceImpl;
import com.larus.slides.impl.chat.SlidesFloatChatComponentRegistry;
import com.larus.slides.impl.chat.SlidesMessageExtServiceImpl;
import com.larus.slides.sdk.impl.SlidesSdkServiceImplV2;
import com.larus.slides.sdk.impl.proxy.SlidesLifecycleAdapter;
import com.larus.slides.sdk.impl.proxy.SlidesSdkProxyServiceImpl;
import com.larus.suggest.impl.ChatSuggestComponentRegistry;
import com.larus.suggest.impl.SuggestPromptCellProviderImpl;
import com.larus.suggest.impl.popup.NexPulseDialogServiceImpl;
import com.larus.suggest.impl.wcb.loading.WcbLoadingHandoffTaskProvider;
import com.larus.suggest.impl.wcb.loading.WcbLoadingTaskProvider;
import com.larus.superthread.impl.SuperThreadServiceImpl;
import com.larus.sync.impl.SyncSDKServiceImpl;
import com.larus.timonkit.impl.ClipboardSuiteInitServiceImpl;
import com.larus.timonkit.impl.TimonKitService;
import com.larus.tts.impl.AudioLegacyComponentRegistry;
import com.larus.tts.impl.ChatTtsServiceImpl;
import com.larus.tts.impl.TtsReaderFactoryImpl;
import com.larus.tts.impl.UserSettingImpl;
import com.larus.uaigc.applet.AICreationAppletPageProviderImpl;
import com.larus.uaigc.applet.AICreationMultiTaskInitEventImpl;
import com.larus.uaigc.avatar.instruction.DigitalAvatarTemplateListSelectorCreator;
import com.larus.uaigc.bean.chat.gallery.CreationAiEditServiceImpl;
import com.larus.uaigc.bean.chat.gallery.CreationDetailImageEditServiceImpl;
import com.larus.uaigc.chat.ChatCreationComponentRegistry;
import com.larus.uaigc.chat.block.create.CreationBlockProvider;
import com.larus.uaigc.chat.block.create.RichMediaCreationClickServiceImpl;
import com.larus.uaigc.chat.block.createloading.CreationLoadingBlockProvider;
import com.larus.uaigc.chat.creationsend.CreationSendUiEventComponentRegistry;
import com.larus.uaigc.chat.markdown.CreationDataHandlerProvider;
import com.larus.uaigc.chat.markdown.CreationMessageConcatDelegate;
import com.larus.uaigc.createpage.CreationPageService;
import com.larus.uaigc.helper.CreationImageLocalDetectHandler;
import com.larus.uaigc.helper.CreationImagePreprocessHandler;
import com.larus.uaigc.helper.CreationImageRemoteDetectHandler;
import com.larus.uaigc.helper.CreationImageRemoteDownloadHandler;
import com.larus.uaigc.helper.CreationImageRemoteResolver;
import com.larus.uaigc.helper.CreationImageReviewHandler;
import com.larus.uaigc.helper.CreationResourceCacheHandler;
import com.larus.uaigc.helper.CreationResourcePostProcessHandler;
import com.larus.uaigc.helper.CreationUploadSceneResolver;
import com.larus.uaigc.helper.CreationVideoPreprocessHandler;
import com.larus.uaigc.image.instruction.ImageListSelectorCreator;
import com.larus.uaigc.image.instruction.ImageListSelectorWithMoreTemplateCreator;
import com.larus.uaigc.instruction.AvatarInstructionCreator;
import com.larus.uaigc.instruction.DropFeatureSelectorSubCreator;
import com.larus.uaigc.instruction.MsgInstructionSubCreator;
import com.larus.uaigc.instruction.MultiAttachmentSelectorCreator;
import com.larus.uaigc.instruction.kmp.AvatarButtonKmpInstructionWidgetProvider;
import com.larus.uaigc.instruction.kmp.DropFeatureSelectorKmpInstructionWidgetProvider;
import com.larus.uaigc.instruction.kmp.ImageListSelectorKmpInstructionWidgetProvider;
import com.larus.uaigc.instruction.kmp.ImageTemplateSelectorWithMoreKmpInstructionWidgetProvider;
import com.larus.uaigc.instruction.kmp.MsgInstructionKmpInstructionWidgetProvider;
import com.larus.uaigc.music.MusicService;
import com.larus.uaigc.music.applet.MusicAppletPageProviderImpl;
import com.larus.uaigc.music.controller.MusicTemplateListSelectorCreator;
import com.larus.uaigc.music.lyrics_to_song.LyricsToSongBoxWrapper;
import com.larus.uaigc.music.template.kmp.MusicTemplateSelectorKmpInstructionWidgetProvider;
import com.larus.uaigc.nowatermark.CreationNoWatermarkMessageListObserver;
import com.larus.uaigc.service.CreationAttachmentServiceImpl;
import com.larus.uaigc.service.CreationAvatarServiceImpl;
import com.larus.uaigc.service.CreationInstructionServiceImpl;
import com.larus.uaigc.service.CreationMetadataServiceImpl;
import com.larus.uaigc.service.CreationNotifyServiceImpl;
import com.larus.uaigc.service.CreationReportServiceImpl;
import com.larus.uaigc.service.CreationResourceAccessServiceImpl;
import com.larus.uaigc.service.CreationSaveServiceImpl;
import com.larus.uaigc.service.CreationShareServiceImpl;
import com.larus.uaigc.service.CreationSpringVenueServiceImpl;
import com.larus.uaigc.service.CreationUploadPolicyServiceImpl;
import com.larus.uaigc.service.CreationWorkflowServiceImpl;
import com.larus.uaigc.service.UgcAIGCServiceImpl;
import com.larus.uaigc.spring.ZLotteryServiceImpl;
import com.larus.ugc.feed.impl.detail.spi.CreationDetailFragmentFactoryImpl;
import com.larus.ugc.feed.impl.spi.TemplateCreationFragmentFactoryImpl;
import com.larus.ugc.perf.impl.UgcPerfServiceImpl;
import com.larus.update.IBitsUpdateImpl;
import com.larus.uploader.impl.UploaderServiceImpl;
import com.larus.uploader.impl.preheat.ImageUploadPreheatServiceImpl;
import com.larus.urlplayer.AudioUrlPlayImpl;
import com.larus.vesdk.impl.VeSDKImpl;
import com.larus.video.impl.VideoServiceImpl;
import com.larus.video.impl.init.VideoEngineInitServiceImpl;
import com.larus.voice.output.volume.VolumeServiceImpl;
import com.larus.voice_setting.VoiceSettingPlatformEntryServiceImpl;
import com.larus.voice_setting.VoiceSettingServiceImpl;
import com.larus.voicecall.impl.IVoiceCallConfigServiceImpl;
import com.larus.voicecall.impl.IVoiceCallServiceImpl;
import com.larus.voicecall.impl.RealtimeCallConfigProvider;
import com.larus.voicecall.impl.RealtimeCallStateServiceImpl;
import com.larus.voicecall.impl.RealtimeDebugServiceImpl;
import com.larus.voicecall.impl.autostop.AutoStopAsrServiceProviderImpl;
import com.larus.voicecall.impl.component.RealtimeCallComponentRegistry;
import com.larus.voicecall.impl.component.translator.QuicInterpretComponentRegistry;
import com.larus.voicecall.impl.continue_talk.ContinuesSpeakComponentRegistry;
import com.larus.voicecall.impl.continue_talk.ContinuousTalkTtsInterceptor;
import com.larus.voicecall.impl.degrade.RealtimeCallQuotaReachSceneHandler;
import com.larus.voicecall.impl.obric.ObricRealtimeCallServiceImpl;
import com.larus.voicecall.impl.router.VoiceCallRouterServiceImpl;
import com.larus.voicecall.impl.ui.RealtimeCallService;
import com.larus.voicecall.impl.util.RealtimeCallStrategy;
import com.larus.xbridge.IXBridgeImpl;
import com.larus.xbridge.XBridgeEventSender;
import com.obric.activeness.impl.ObricActivenessMonitorServiceImpl;
import com.obric.aiagent.ipc.idl.FileIDLStubImpl;
import com.obric.aiagent.messenger.ObricIPCImpl;
import com.obric.aiagent.messenger.ObricPccServiceImpl;
import com.obric.aiagent.messenger.stub.AppIntentIDLStub;
import com.obric.aiagent.messenger.stub.AppStateIDLStub;
import com.obric.aiagent.messenger.stub.FlowIDLSPIImpl;
import com.obric.aiagent.messenger.stub.FlowNetworkIDLStub;
import com.obric.aiagent.messenger.stub.FlowUIIDLStub;
import com.obric.aiagent.messenger.stub.FrontierIDLStub;
import com.obric.aiagent.messenger.stub.MessageIDLStub;
import com.obric.aiagent.messenger.stub.ObricForegroundWidgetSyncServiceImpl;
import com.obric.aiagent.messenger.stub.SettingsIDLStub;
import com.obric.aiagent.messenger.stub.permission.FlowPermissionIDLStub;
import com.obric.aiagent.product.platform.impl.rom.CommonRomInfoImpl;
import com.obric.aiagent.runtime.ObricAIAgentPlatformImpl;
import com.obric.assistant.FeatureSettingsConfigImpl;
import com.obric.assistant.ObricAboutAppImpl;
import com.obric.assistant.ObricActivityServiceImpl;
import com.obric.assistant.ObricAppServiceImpl;
import com.obric.assistant.ObricAssistantImpl;
import com.obric.assistant.ObricAvailableManagerImpl;
import com.obric.assistant.ObricConfigServiceImpl;
import com.obric.assistant.ObricContextServiceImpl;
import com.obric.assistant.ObricCustomAppIconImpl;
import com.obric.assistant.ObricEnvServiceImpl;
import com.obric.assistant.ObricFeatureServiceImpl;
import com.obric.assistant.ObricInteractionImpl;
import com.obric.assistant.ObricLazyInitSettingsServiceImpl;
import com.obric.assistant.ObricMmtVideoSettingsServiceImpl;
import com.obric.assistant.ObricMsgInfoSaveServiceImpl;
import com.obric.assistant.ObricOmniLockscreenStateServiceImpl;
import com.obric.assistant.ObricPluginActivityRecordHelper;
import com.obric.assistant.ObricRequestSettingsServiceImpl;
import com.obric.assistant.ObricRtcServiceImpl;
import com.obric.assistant.ObricSettingsServiceImpl;
import com.obric.assistant.ObricUIServiceImpl;
import com.obric.assistant.ObricUtilServiceImpl;
import com.obric.assistant.OfficeSdkLazyInitSettingsServiceImpl;
import com.obric.assistant.account.ObricAccountServiceImpl;
import com.obric.assistant.account.ObricBottomTabServiceImpl;
import com.obric.assistant.activity_stack.ObricActivityStackServiceImpl;
import com.obric.assistant.agent.ObricAgentServiceImpl;
import com.obric.assistant.agent.ObricSemanticServiceImpl;
import com.obric.assistant.apm.ObricSlardarConfigServiceImpl;
import com.obric.assistant.applet.ObricAppletServiceImpl;
import com.obric.assistant.applog.AppLogIDLStub;
import com.obric.assistant.attention.ObricAttentionServiceImpl;
import com.obric.assistant.audio.ModeTimeoutCleanupObserver;
import com.obric.assistant.audio.ObricAsrServiceImpl;
import com.obric.assistant.audio.ObricAssistantForAudioImpl;
import com.obric.assistant.audio.ObricAudioConnectionStatusMonitorService;
import com.obric.assistant.audio.ObricAutoHalfDuplexTimeoutCleanupObserver;
import com.obric.assistant.audio.ObricEnrollInteropServiceImpl;
import com.obric.assistant.audio.ObricEnrollTraceParamServiceImpl;
import com.obric.assistant.audio.ObricTtsControlServiceImpl;
import com.obric.assistant.audio.ObricTtsReaderInterceptor;
import com.obric.assistant.audio.ObricTtsServiceImpl;
import com.obric.assistant.audio.service.AssistantTextModeService;
import com.obric.assistant.audio.service.AutoHalfDuplexModeService;
import com.obric.assistant.audio.service.IObricIntentStatusServiceImpl;
import com.obric.assistant.audio.service.ManualHalfDuplexModeService;
import com.obric.assistant.audio.service.ObricAssistantBaseServiceImpl;
import com.obric.assistant.audio.service.ObricAudioInteractService;
import com.obric.assistant.audio.service.ObricAudioServiceImpl;
import com.obric.assistant.audio.service.ObricRTCCameraConfigService;
import com.obric.assistant.audio.service.ObricRealtimeCallStateService;
import com.obric.assistant.audio.timeout.IdleQuiteService;
import com.obric.assistant.authenticationsession.DoraAuthTrustServiceImpl;
import com.obric.assistant.authenticationsession.QueryAuthenticationServiceImpl;
import com.obric.assistant.authenticationsession.SessionAuthenticationServiceImpl;
import com.obric.assistant.automic.ObricAutoMicServiceImpl;
import com.obric.assistant.awareness.AwarenessEventReporter;
import com.obric.assistant.banner.ObricBannerService;
import com.obric.assistant.block.common.button_group.ButtonGroupBlockProvider;
import com.obric.assistant.block.common.click_intent.ClickIntentBlockProvider;
import com.obric.assistant.block.common.loading.LoadingBlockProvider;
import com.obric.assistant.block.common.progress_card.ProgressCardBlockProvider;
import com.obric.assistant.block.common.reference_msg.ReferenceMsgBlockProvider;
import com.obric.assistant.block.common.tip.TipBlockProvider;
import com.obric.assistant.block.common.user_select.UserSelectBlockProvider;
import com.obric.assistant.block.complex.call_for_me.ComplexCallForMeBlockProvider;
import com.obric.assistant.block.lark.knowledge_authorized.LarkKnowledgeAuthorizedBlockProvider;
import com.obric.assistant.block.search.local.LocalSearchBlockProvider;
import com.obric.assistant.bootprotector.ObricBootProtectorProcessDiffImpl;
import com.obric.assistant.bootprotector.ObricBootProtectorServiceImpl;
import com.obric.assistant.card.ObricIntentEntityListSheetServiceImpl;
import com.obric.assistant.card.OrionCardComponentRegistry;
import com.obric.assistant.card.entity.ObricEntityNavigationServiceImpl;
import com.obric.assistant.card.list.cell.block.ObricComplexTaskServiceImpl;
import com.obric.assistant.chat.ObricChatCommonRegistry;
import com.obric.assistant.chat.ObricChatContextServiceImpl;
import com.obric.assistant.chat.ObricChatDebugExtItemImpl;
import com.obric.assistant.chat.ObricChatInputComponentRegistry;
import com.obric.assistant.chat.ObricChatPageStateServiceImpl;
import com.obric.assistant.chat.ObricChatService;
import com.obric.assistant.chat.ObricChatUIServiceImpl;
import com.obric.assistant.chat.ObricComponentRegistry;
import com.obric.assistant.chat.ObricInputComponentRegistry;
import com.obric.assistant.chat.component.list.pipeline.IntentCardRoundStateTaskProvider;
import com.obric.assistant.chat.component.list.pipeline.OKeyguardCutTaskProvider;
import com.obric.assistant.chat.component.list.pipeline.OSemanticCutTaskProvider;
import com.obric.assistant.chat.impl.MessageExtCollector;
import com.obric.assistant.chat.impl.ObricChatSPIServiceImpl;
import com.obric.assistant.chat.tts.TtsSilentInterceptor;
import com.obric.assistant.chatcontext.ClearContextInKeyguardServiceImpl;
import com.obric.assistant.cocreationreview.CocreationReviewServiceImpl;
import com.obric.assistant.cocreationreview.modules.omni.OmniLabelingFlowIDLStub;
import com.obric.assistant.cocreationreview.modules.searchqa.ObricSearchQaLabelingServiceImpl;
import com.obric.assistant.common.utils.upload.ObricXttTokenSyncServiceImpl;
import com.obric.assistant.complex_task.ComplexTaskSortComparator;
import com.obric.assistant.complex_task.MultiComplexTaskActionHandler;
import com.obric.assistant.component.ObricActionBarSendServiceImpl;
import com.obric.assistant.component.clicktalk.ObricMediaPlayStateChangeListenerUtils;
import com.obric.assistant.component.task.MultiComplexTaskUIFactory;
import com.obric.assistant.desktop_icon.ObricAddDesktopIconServiceImpl;
import com.obric.assistant.device.ObricDeviceManagerImpl;
import com.obric.assistant.dora.ObricDoraServiceImpl;
import com.obric.assistant.dora.ObricVendorBluetoothQueryServiceImpl;
import com.obric.assistant.dora.VendorPrivateLinkServiceImpl;
import com.obric.assistant.feedback.ObricActivationFeedbackImpl;
import com.obric.assistant.feedback.ObricFeedbackService;
import com.obric.assistant.feedback.ObricSystemFeedbackImpl;
import com.obric.assistant.feedback.experience.ObricFeedbackPanelServiceImpl;
import com.obric.assistant.feedback.impl.FeedbackServiceImpl;
import com.obric.assistant.feedback.impl.FlowFeedbackIDLStub;
import com.obric.assistant.frontier.ObricFrontierStatusMonitorService;
import com.obric.assistant.guide.ObricUserGuideImpl;
import com.obric.assistant.impl.ObricActionBarTrackServiceImpl;
import com.obric.assistant.impl.ObricChatExtensionServiceImpl;
import com.obric.assistant.impl.ObricSpecialInputServiceImpl;
import com.obric.assistant.impl.WindowSdkTitleBarInflateImpl;
import com.obric.assistant.interaction.impl.AppLaunchServiceImpl;
import com.obric.assistant.interaction.impl.AssistantChatWindowImpl;
import com.obric.assistant.interaction.impl.AssistantInteractionService;
import com.obric.assistant.interaction.impl.ObricApmServiceImpl;
import com.obric.assistant.interaction.impl.ObricCameraServiceDiffImpl;
import com.obric.assistant.interaction.impl.ObricChatUILifecycleMonitorImpl;
import com.obric.assistant.interaction.impl.ObricInteractServiceImpl;
import com.obric.assistant.interaction.impl.ObricKeyguardServiceImpl;
import com.obric.assistant.interaction.impl.ObricRealtimeCallExtServiceImpl;
import com.obric.assistant.interaction.impl.ObricShowOnLockedServiceImpl;
import com.obric.assistant.interaction.impl.SystemKeySettingsImpl;
import com.obric.assistant.interaction.impl.WindowEffectsImpl;
import com.obric.assistant.interaction.impl.activityresult.ActivityResultHelperImpl;
import com.obric.assistant.interaction.impl.chat.ObricChatMessageBgServiceImpl;
import com.obric.assistant.interaction.impl.essentialtask.EssentialTaskServiceImpl;
import com.obric.assistant.interaction.impl.essentialtask.ObricEssentialTaskServiceImpl;
import com.obric.assistant.interaction.impl.essentialtask.ObricMigrationHandlerImpl;
import com.obric.assistant.interaction.impl.feedback.VibratorSmtFeedbackImpl;
import com.obric.assistant.interaction.impl.keyguard.KeyguardBiometricSettingImpl;
import com.obric.assistant.interaction.impl.keyguard.KeyguardStateImpl;
import com.obric.assistant.interaction.impl.keyguard.SendMsgExtServiceImpl;
import com.obric.assistant.interaction.impl.message.ObricMessageServiceImpl;
import com.obric.assistant.interaction.impl.permission.PermissionHelperImpl;
import com.obric.assistant.interaction.impl.screen.ScreenStateImpl;
import com.obric.assistant.interaction.impl.toast.ToastHelperImpl;
import com.obric.assistant.interaction.impl.window.ObricMessagePopupServiceImpl;
import com.obric.assistant.interaction.impl.window.ObricWindowFloatHostProvider;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.behaviors.AutoDelayedDestroyBehavior;
import com.obric.assistant.interaction.impl.window.behaviors.AutoDismissOverlaysBehavior;
import com.obric.assistant.interaction.impl.window.behaviors.ClearNotificationBehavior;
import com.obric.assistant.interaction.impl.window.behaviors.ClearTaskBehavior;
import com.obric.assistant.interaction.impl.window.behaviors.LockscreenBehavior;
import com.obric.assistant.interaction.impl.window.behaviors.MainBotActivityResumeDestroyBehavior;
import com.obric.assistant.interaction.impl.window.behaviors.MemoryPressureDestroyBehavior;
import com.obric.assistant.interaction.impl.window.behaviors.RemoveTopChatActivityBehavior;
import com.obric.assistant.interaction.impl.window.behaviors.ScreenRotationBehavior;
import com.obric.assistant.interaction.impl.window.behaviors.TaskStackChangeBehavior;
import com.obric.assistant.interaction.impl.window.behaviors.TurnScreenOnBehavior;
import com.obric.assistant.interaction.impl.window.behaviors.WindowKeyguardBiometricSettingBehavior;
import com.obric.assistant.interaction.impl.window.behaviors.WindowLaunchRecoveryBehavior;
import com.obric.assistant.interaction.impl.window.behaviors.WindowMultimodalInputClearBehavior;
import com.obric.assistant.ipc.VoiceInteractionIDLStub;
import com.obric.assistant.ipc.WakeupTruthCaptureSwitchSyncServiceImpl;
import com.obric.assistant.ipc.WakeupTruthUploadManager;
import com.obric.assistant.live.service.ObricLiveService;
import com.obric.assistant.login.LoginReportImpl;
import com.obric.assistant.login.LoginStateImpl;
import com.obric.assistant.login.ObricAccountInfoMonitorServiceImpl;
import com.obric.assistant.login.ObricLoginServiceImpl;
import com.obric.assistant.markdown.ObricMarkdownResolverServiceImpl;
import com.obric.assistant.minormode.ObricMinorModeServiceImpl;
import com.obric.assistant.multiuser.impl.ObricMultiUserServiceImpl;
import com.obric.assistant.network.impl.NetworkInterceptorServiceImpl;
import com.obric.assistant.network.impl.ObricNetworkServiceImpl;
import com.obric.assistant.network.impl.ObricTTNetMonitorHookServiceImpl;
import com.obric.assistant.network.restrict.ObricBackgroundNetworkBlockServiceImpl;
import com.obric.assistant.network.security.ObricSecurityNetworkServiceImpl;
import com.obric.assistant.notification.ObricNotificationIslandService;
import com.obric.assistant.notification.ObricNotificationListenerServiceImpl;
import com.obric.assistant.oauto.OAutoImpl;
import com.obric.assistant.oauto.ObricShortCutsServiceImpl;
import com.obric.assistant.obric_action.ObricActionServiceImpl;
import com.obric.assistant.obric_action.handler.ObricOpenEventTaskDetailHandler;
import com.obric.assistant.obric_action.handler.OpenAutoGuiSettingsActionHandler;
import com.obric.assistant.obric_action.handler.OpenCreateShortcutHandler;
import com.obric.assistant.obric_action.handler.OpenSkillDetailActionHandler;
import com.obric.assistant.obric_action.handler.activity.FinishCurrentPageHandler;
import com.obric.assistant.obric_action.handler.android.ActivityActionHandler;
import com.obric.assistant.obric_action.handler.android.BroadcastActionHandler;
import com.obric.assistant.obric_action.handler.android.ServiceActionHandler;
import com.obric.assistant.obric_action.handler.auth.DismissKeyguardActionHandler;
import com.obric.assistant.obric_action.handler.auth.KeyguardStatusActionHandler;
import com.obric.assistant.obric_action.handler.auth.RequestBiometricAuthActionHandler;
import com.obric.assistant.obric_action.handler.auth.RequestDeviceCredentialAuthActionHandler;
import com.obric.assistant.obric_action.handler.auth.RequestVoicePrintAuthActionHandler;
import com.obric.assistant.obric_action.handler.auth.SessionAuthStatusActionHandler;
import com.obric.assistant.obric_action.handler.chat_page.HideKeyboardActionHandler;
import com.obric.assistant.obric_action.handler.chat_page.OpenAdditionInputPanelHandler;
import com.obric.assistant.obric_action.handler.chat_page.OpenClarifyInputPanelHandler;
import com.obric.assistant.obric_action.handler.chat_page.OpenNewTaskPanelHandler;
import com.obric.assistant.obric_action.handler.chat_page.OpenWindowActionHandler;
import com.obric.assistant.obric_action.handler.chat_page.PopWindowActionHandler;
import com.obric.assistant.obric_action.handler.chat_page.ShowKeyboardActionHandler;
import com.obric.assistant.obric_action.handler.chat_page.StashWindowActionHandler;
import com.obric.assistant.obric_action.handler.feedback.FeedbackHapticActionHandler;
import com.obric.assistant.obric_action.handler.feedback.FeedbackSoundActionHandler;
import com.obric.assistant.obric_action.handler.feedback.FeedbackToastActionHandler;
import com.obric.assistant.obric_action.handler.message.ResendMessageActionHandler;
import com.obric.assistant.obric_action.handler.message.SendMessageActionHandler;
import com.obric.assistant.obric_action.handler.omni_task.OmniTaskFeedbackHandler;
import com.obric.assistant.obric_action.handler.omni_task.StopOmniTaskHandler;
import com.obric.assistant.obric_action.handler.prompt.PromptConfirmDialogActionHandler;
import com.obric.assistant.obric_action.handler.prompt.PromptOptionsDialogActionHandler;
import com.obric.assistant.obric_action.handler.router.DeepLinkActionHandler;
import com.obric.assistant.obric_action.handler.server.ShortLinkApiActionHandler;
import com.obric.assistant.omni.ObricAppreciablePoint;
import com.obric.assistant.onelogin.AccountEventsInterceptorImpl;
import com.obric.assistant.onelogin.ChatCmdInterceptorImpl;
import com.obric.assistant.onelogin.LogoutSceneInterceptorImpl;
import com.obric.assistant.onelogin.ObricOneLoginImpl;
import com.obric.assistant.oneshot.impl.ObricOneshotServiceImpl;
import com.obric.assistant.oneshot.impl.OneshotServiceImpl;
import com.obric.assistant.performance.ObricCrashDumpHprofServiceImpl;
import com.obric.assistant.performance.ObricMemoryReportSPIServiceImpl;
import com.obric.assistant.performance.ObricMemoryReportServiceImpl;
import com.obric.assistant.performance.ObricMemoryUploadServiceImpl;
import com.obric.assistant.performance.ObricPerformanceMonitorServiceImpl;
import com.obric.assistant.performance.ObricThresholdDumpHprofServiceImpl;
import com.obric.assistant.permission.IObricPermissionServiceImpl;
import com.obric.assistant.privacy.ObricPrivacyService;
import com.obric.assistant.privacy.ObricSecurityServiceImpl;
import com.obric.assistant.privacyui.ObricPrivacyAndPermissionUiServiceImpl;
import com.obric.assistant.processesmanager.ObricProcessesManagerImpl;
import com.obric.assistant.product.impl.ObricProductImpl;
import com.obric.assistant.provider.ObricAutoGuiSettingsImpl;
import com.obric.assistant.push.ObricPushConfigServiceImpl;
import com.obric.assistant.receive.ObricReceiveCustomDiffImpl;
import com.obric.assistant.receive.ObricReceiveTextDiffImpl;
import com.obric.assistant.remote_card_container.RemoteCardImpl;
import com.obric.assistant.remote_card_container.appchange.ObricAppChangeListenerServiceImpl;
import com.obric.assistant.reporter.ObricReceiveStreamMessageTypeOverriderImpl;
import com.obric.assistant.reporter.ObricReporterImpl;
import com.obric.assistant.reporter.ObricSystemReporterImpl;
import com.obric.assistant.reporter.ObricTraceParamImpl;
import com.obric.assistant.reporter.startup.AssistantStartupTelemetryImpl;
import com.obric.assistant.router.ObricRouterServiceImpl;
import com.obric.assistant.security.CertificateCheckServiceImpl;
import com.obric.assistant.security.provision.check.impl.SecurityProvisionCheckerImpl;
import com.obric.assistant.sepcialinput.ObricSpecialInputCreator;
import com.obric.assistant.session.ObricVoiceInteractionProxySessionFactory;
import com.obric.assistant.session.endpoint.AiKeySessionEndpoint;
import com.obric.assistant.session.endpoint.ApplicationActivityEndpoint;
import com.obric.assistant.session.endpoint.AssistActivateEndPoint;
import com.obric.assistant.session.endpoint.AutoMicEndpoint;
import com.obric.assistant.session.endpoint.DoraSessionEndpoint;
import com.obric.assistant.session.endpoint.LaunchMethodReporterEndpoint;
import com.obric.assistant.session.endpoint.LostModeEndpoint;
import com.obric.assistant.session.endpoint.OAutoEndPoint;
import com.obric.assistant.session.endpoint.ObricChatServiceEndpoint;
import com.obric.assistant.session.endpoint.PowerKeyWakeupEndpoint;
import com.obric.assistant.session.endpoint.SystemServiceEndpoint;
import com.obric.assistant.session.endpoint.VoiceWakeupSessionEndpoint;
import com.obric.assistant.session.singleton.SessionMaintainer;
import com.obric.assistant.settings.AILabServiceImpl;
import com.obric.assistant.settings.ObricRouteServiceImpl;
import com.obric.assistant.settings.OrionSettingComponentRegistry;
import com.obric.assistant.settings.provider.AILabSettingProvider;
import com.obric.assistant.settings.provider.AlwaysRespondWakeupSettingProvider;
import com.obric.assistant.settings.provider.AutoEndConversationSettingProvider;
import com.obric.assistant.settings.provider.AutoGuiSettingProvider;
import com.obric.assistant.settings.provider.AutoImageUploadSettingProvider;
import com.obric.assistant.settings.provider.CocreationReviewSettingProvider;
import com.obric.assistant.settings.provider.ContinueSpeakNoiseReductionSettingProvider;
import com.obric.assistant.settings.provider.ContinueSpeakSettingProvider;
import com.obric.assistant.settings.provider.DesktopIconSettingProvider;
import com.obric.assistant.settings.provider.DoraSettingProvider;
import com.obric.assistant.settings.provider.DoubaoWhisperSettingProvider;
import com.obric.assistant.settings.provider.LockedScreenUseSettingProvider;
import com.obric.assistant.settings.provider.MemoryDataMigrationSettingProvider;
import com.obric.assistant.settings.provider.MemoryDataSettingProvider;
import com.obric.assistant.settings.provider.MemorySettingProvider;
import com.obric.assistant.settings.provider.ObricUserExperiencePlanSettingProvider;
import com.obric.assistant.settings.provider.PcInAsrSettingProvider;
import com.obric.assistant.settings.provider.ReferenceMemorySettingProvider;
import com.obric.assistant.settings.provider.TtsPlayBackgroundSettingProvider;
import com.obric.assistant.settings.provider.VoicePrintManagementSettingProvider;
import com.obric.assistant.settings.provider.VoiceWakeupSettingProvider;
import com.obric.assistant.settings.provider.WakeupSoundEffectSettingProvider;
import com.obric.assistant.special_input.SpecialInputBehavior;
import com.obric.assistant.special_input.SpecialInputTaskImpl;
import com.obric.assistant.state.ShareStateServiceImpl;
import com.obric.assistant.state.impl.multitask.ObricStateMultitaskServiceImpl;
import com.obric.assistant.state.impl.multitask.consumer.InteractionProjectionServiceImpl;
import com.obric.assistant.state.impl.multitask.consumer.ObricAigcGenerationSceneProjector;
import com.obric.assistant.state.impl.multitask.consumer.ObricTaskFlowActiveStateResolver;
import com.obric.assistant.state.impl.multitask.consumer.ObricTaskFlowActiveStateServiceImpl;
import com.obric.assistant.state.impl.multitask.consumer.ObricTaskFlowPowerResolver;
import com.obric.assistant.state.impl.multitask.producer.AiNoteStateProducer;
import com.obric.assistant.state.impl.multitask.producer.ComplexTaskStateProducer;
import com.obric.assistant.state.impl.multitask.producer.InteractionModeStateProducer;
import com.obric.assistant.state.impl.multitask.producer.MessageStateProducer;
import com.obric.assistant.state.impl.multitask.producer.ObricAigcGenerationStateProducer;
import com.obric.assistant.state.impl.multitask.producer.ObricAlarmTtsStateProducer;
import com.obric.assistant.state.impl.multitask.producer.ObricInteractionStateProducer;
import com.obric.assistant.state.impl.multitask.producer.ObricWakeupStateProducer;
import com.obric.assistant.state.impl.multitask.producer.RealtimeCallStateProducer;
import com.obric.assistant.state.impl.multitask.producer.SelfUpdateDownloadStateProducer;
import com.obric.assistant.state.impl.multitask.producer.TtsStateProducer;
import com.obric.assistant.state.impl.multitask.producer.VoiceCaptureStateProducer;
import com.obric.assistant.state.impl.v2.ObricStateImpl;
import com.obric.assistant.state.impl.v2.core.ObricStateDispatcherServiceImpl;
import com.obric.assistant.state.impl.v2.core.ObricStateIDLStub;
import com.obric.assistant.state.impl.v2.power.ObricDeviceStateServiceImpl;
import com.obric.assistant.storage.ObricLowStorageServiceImpl;
import com.obric.assistant.system.DeviceLockedStateServiceImpl;
import com.obric.assistant.system.TaskStackServiceImpl;
import com.obric.assistant.task.ObricTaskStatusManagerImpl;
import com.obric.assistant.task.TaskManager;
import com.obric.assistant.task.skill.ObricTaskSkillServiceImpl;
import com.obric.assistant.tipoff.ObricTipOffServiceImpl;
import com.obric.assistant.trace.ObricTraceImpl;
import com.obric.assistant.ttnet.ObricTTNetImpl;
import com.obric.assistant.upload.ObricUploadService;
import com.obric.assistant.util.ObricAssistantUtilHelperServiceImpl;
import com.obric.assistant.util.ObricPersonalContextSettingServiceImpl;
import com.obric.assistant.util.ObricSensitiveEraseImpl;
import com.obric.assistant.utils.ObricShowArgServiceImpl;
import com.obric.assistant.voice.DoraWakeupServiceImpl;
import com.obric.assistant.voice.ObricVoiceServiceImpl;
import com.obric.assistant.voice.presentation.ListeningPresentationWindowBehavior;
import com.obric.assistant.wakeup.bluetooth_headset.impl.BluetoothHeadSetImpl;
import com.obric.assistant.wakeup.co_wakeup.dora.service.CoWakeupService;
import com.obric.assistant.wakeup.statistics.impl.BluetoothScoEstablishStatisticsImpl;
import com.obric.assistant.wakeup.statistics.impl.WakeupLatencyTrackImpl;
import com.obric.assistant.wakeup.statistics.impl.WakeupStatisticsImpl;
import com.obric.assistant.window.ObricWindowComponentRegistry;
import com.obric.assistant.window.WindowInteractionServiceImpl;
import com.obric.assistant.window.materials.services.impl.OWindowMaterialServiceImpl;
import com.obric.assistant.zeus.plugin.ObricZeusServiceImpl;
import com.obric.assistant.zeus.plugin.ZeusPluginServiceImpl;
import com.obric.assistant.zeus.plugin.impl.ZeusObricAlogServiceImpl;
import com.obric.audio.continuous_talk.ObricAudioComponentRegistry;
import com.obric.audio.continuous_talk.ObricBackTraceLogServiceImpl;
import com.obric.audio.continuous_talk.ObricContinuousTalkServiceImpl;
import com.obric.audio.continuous_talk.ObricVadServiceImpl;
import com.obric.audio.dora.ObricDoraPluginProvider;
import com.obric.audio.enroll.sami.EnrollServiceImpl;
import com.obric.audio.enroll.sami.ObricSamiService;
import com.obric.audio.rtc_context.ObricDoraContextProvider;
import com.obric.audio.tts.ObricChainTtsServiceImpl;
import com.obric.audio.wakeupcapture.WakeupAudioCaptureServiceImpl;
import com.obric.capabilitykit.common.intent.BaseAppFuncExecuteIntent;
import com.obric.capabilitykit.common.intent.BaseAudioControlPauseIntent;
import com.obric.capabilitykit.common.intent.BaseAudioControlPlayFromScratchIntent;
import com.obric.capabilitykit.common.intent.BaseAudioControlPlayIntent;
import com.obric.capabilitykit.common.intent.BaseAudioControlPlayNextIntent;
import com.obric.capabilitykit.common.intent.BaseAudioControlPlayPreviousIntent;
import com.obric.capabilitykit.common.intent.BaseAudioControlSeekToIntent;
import com.obric.capabilitykit.common.intent.BaseBrowserUseIntent;
import com.obric.capabilitykit.common.intent.BaseCalculatorCalculateIntent;
import com.obric.capabilitykit.common.intent.BaseCalendarShowScheduleIntent;
import com.obric.capabilitykit.common.intent.BaseCameraRotateCameraIntent;
import com.obric.capabilitykit.common.intent.BaseCameraSetAuxiliaryLineIntent;
import com.obric.capabilitykit.common.intent.BaseCameraSetEVIntent;
import com.obric.capabilitykit.common.intent.BaseCameraSetExposureTimeIntent;
import com.obric.capabilitykit.common.intent.BaseCameraSetFilterIntent;
import com.obric.capabilitykit.common.intent.BaseCameraSetFlashModeIntent;
import com.obric.capabilitykit.common.intent.BaseCameraSetFocalIntent;
import com.obric.capabilitykit.common.intent.BaseCameraSetFocusDistanceIntent;
import com.obric.capabilitykit.common.intent.BaseCameraSetISOIntent;
import com.obric.capabilitykit.common.intent.BaseCameraSetImageRatioIntent;
import com.obric.capabilitykit.common.intent.BaseCameraSetMeteringModeIntent;
import com.obric.capabilitykit.common.intent.BaseCameraSetSelfTimerIntent;
import com.obric.capabilitykit.common.intent.BaseCameraSetTouchCaptureIntent;
import com.obric.capabilitykit.common.intent.BaseCameraSetWBIntent;
import com.obric.capabilitykit.common.intent.BaseCameraStartCaptureIntent;
import com.obric.capabilitykit.common.intent.BaseCameraStartRecordingIntent;
import com.obric.capabilitykit.common.intent.BaseCameraStopCaptureIntent;
import com.obric.capabilitykit.common.intent.BaseCameraSwitchCameraModeIntent;
import com.obric.capabilitykit.common.intent.BaseClockCreateAlarmIntent;
import com.obric.capabilitykit.common.intent.BaseClockDeleteAlarmIntent;
import com.obric.capabilitykit.common.intent.BaseClockDeleteCountdownIntent;
import com.obric.capabilitykit.common.intent.BaseClockPauseCountdownIntent;
import com.obric.capabilitykit.common.intent.BaseClockResumeCountdownIntent;
import com.obric.capabilitykit.common.intent.BaseClockSearchAlarmIntent;
import com.obric.capabilitykit.common.intent.BaseClockSearchCountdownIntent;
import com.obric.capabilitykit.common.intent.BaseClockShowAlarmIntent;
import com.obric.capabilitykit.common.intent.BaseClockShowCountdownIntent;
import com.obric.capabilitykit.common.intent.BaseClockStartCountdownIntent;
import com.obric.capabilitykit.common.intent.BaseClockTurnOffAlarmIntent;
import com.obric.capabilitykit.common.intent.BaseClockTurnOnAlarmIntent;
import com.obric.capabilitykit.common.intent.BaseClockUpdateAlarmIntent;
import com.obric.capabilitykit.common.intent.BaseCommonViewEntitiesIntent;
import com.obric.capabilitykit.common.intent.BaseContactsAddToBlocklistIntent;
import com.obric.capabilitykit.common.intent.BaseContactsAddToFavoriteIntent;
import com.obric.capabilitykit.common.intent.BaseContactsCreateIntent;
import com.obric.capabilitykit.common.intent.BaseContactsDeleteIntent;
import com.obric.capabilitykit.common.intent.BaseContactsSearchIntent;
import com.obric.capabilitykit.common.intent.BaseContactsShowContactIntent;
import com.obric.capabilitykit.common.intent.BaseContactsUpdateIntent;
import com.obric.capabilitykit.common.intent.BaseDoubaoRealTimeScreenShareIntent;
import com.obric.capabilitykit.common.intent.BaseDoubaoRealTimeVideoCallIntent;
import com.obric.capabilitykit.common.intent.BaseDoubaoRealTimeVoiceCallIntent;
import com.obric.capabilitykit.common.intent.BaseEventTaskCreateDraftIntent;
import com.obric.capabilitykit.common.intent.BaseEventTaskGetTaskInfoIntent;
import com.obric.capabilitykit.common.intent.BaseEventTaskSubmitTaskIntent;
import com.obric.capabilitykit.common.intent.BaseEventTaskUpdateTaskIntent;
import com.obric.capabilitykit.common.intent.BaseFilesShowFileIntent;
import com.obric.capabilitykit.common.intent.BaseFinanceSearchStockIntent;
import com.obric.capabilitykit.common.intent.BaseGUIActionIntent;
import com.obric.capabilitykit.common.intent.BaseGUIINITIntent;
import com.obric.capabilitykit.common.intent.BaseGUIReplyIntent;
import com.obric.capabilitykit.common.intent.BaseGUIScreenshotIntent;
import com.obric.capabilitykit.common.intent.BaseMapNaviRouteIntent;
import com.obric.capabilitykit.common.intent.BaseMapSearchPOIIntent;
import com.obric.capabilitykit.common.intent.BaseMapTakeTaxiIntent;
import com.obric.capabilitykit.common.intent.BaseMemoryDeleteIntent;
import com.obric.capabilitykit.common.intent.BaseMemoryOperateIntent;
import com.obric.capabilitykit.common.intent.BaseMemoryOperateNewIntent;
import com.obric.capabilitykit.common.intent.BaseMemoryProduceIntent;
import com.obric.capabilitykit.common.intent.BaseMemorySaveDialogueMemoryIntent;
import com.obric.capabilitykit.common.intent.BaseMemorySearchIntent;
import com.obric.capabilitykit.common.intent.BaseMessagesDeleteIntent;
import com.obric.capabilitykit.common.intent.BaseMessagesSearchIntent;
import com.obric.capabilitykit.common.intent.BaseMessagesSendIntent;
import com.obric.capabilitykit.common.intent.BaseMessagesShowMessageIntent;
import com.obric.capabilitykit.common.intent.BaseNetEaseCloudMusicSearchIntent;
import com.obric.capabilitykit.common.intent.BaseNotesCreateIntent;
import com.obric.capabilitykit.common.intent.BaseNotesSearchIntent;
import com.obric.capabilitykit.common.intent.BaseNotesShowNoteIntent;
import com.obric.capabilitykit.common.intent.BaseNotesUpdateIntent;
import com.obric.capabilitykit.common.intent.BaseOfficeBookMeetingIntent;
import com.obric.capabilitykit.common.intent.BaseOfficeCheckLoginIntent;
import com.obric.capabilitykit.common.intent.BaseOfficeJumpToLarkUrlIntent;
import com.obric.capabilitykit.common.intent.BaseOfficeKnowledgeAIAuthIntent;
import com.obric.capabilitykit.common.intent.BaseOfficeKnowledgeAIIntent;
import com.obric.capabilitykit.common.intent.BaseOfficeLarkCLICheckLoginIntent;
import com.obric.capabilitykit.common.intent.BaseOfficeLarkCLIEnsureAuthIntent;
import com.obric.capabilitykit.common.intent.BaseOfficeSearchLarkContactInfoByAsrIntent;
import com.obric.capabilitykit.common.intent.BaseOfficeSearchLarkContactInfoByNameIntent;
import com.obric.capabilitykit.common.intent.BaseOfficeSearchMeetingIntent;
import com.obric.capabilitykit.common.intent.BaseOfficeSendMessageIntent;
import com.obric.capabilitykit.common.intent.BasePCAppFcEntitySearchIntent;
import com.obric.capabilitykit.common.intent.BasePCCommonGlobalSearchIntent;
import com.obric.capabilitykit.common.intent.BasePCDoubaoGlobalSearchIntent;
import com.obric.capabilitykit.common.intent.BasePCEntityPoisonLabelIntent;
import com.obric.capabilitykit.common.intent.BasePCGetImageUrlIntent;
import com.obric.capabilitykit.common.intent.BasePCGlobalSearchIntent;
import com.obric.capabilitykit.common.intent.BasePCGlobalSearchIntentIntent;
import com.obric.capabilitykit.common.intent.BasePCIntentGlobalSearchIntent;
import com.obric.capabilitykit.common.intent.BasePCPersonalContextFetchIntent;
import com.obric.capabilitykit.common.intent.BasePCPersonalContextSearchIntent;
import com.obric.capabilitykit.common.intent.BasePCProactiveEventsIntent;
import com.obric.capabilitykit.common.intent.BasePCSearchAppEntityIntent;
import com.obric.capabilitykit.common.intent.BasePhoneCallIntent;
import com.obric.capabilitykit.common.intent.BasePhoneDeleteIntent;
import com.obric.capabilitykit.common.intent.BasePhoneGetSimIntent;
import com.obric.capabilitykit.common.intent.BasePhoneOpenPageIntent;
import com.obric.capabilitykit.common.intent.BasePhoneProxyCallIntent;
import com.obric.capabilitykit.common.intent.BasePhoneSearchIntent;
import com.obric.capabilitykit.common.intent.BasePhoneShowCallHistoryIntent;
import com.obric.capabilitykit.common.intent.BasePhotoAddPhotosToAlbumIntent;
import com.obric.capabilitykit.common.intent.BasePhotoAddToFavoriteIntent;
import com.obric.capabilitykit.common.intent.BasePhotoCreateAlbumIntent;
import com.obric.capabilitykit.common.intent.BasePhotoCropIntent;
import com.obric.capabilitykit.common.intent.BasePhotoDeleteAlbumIntent;
import com.obric.capabilitykit.common.intent.BasePhotoDeletePhotoIntent;
import com.obric.capabilitykit.common.intent.BasePhotoGenerateVideoIntent;
import com.obric.capabilitykit.common.intent.BasePhotoOpenAlbumIntent;
import com.obric.capabilitykit.common.intent.BasePhotoPaintPhotoIntent;
import com.obric.capabilitykit.common.intent.BasePhotoRemovePhotosFromAlbumIntent;
import com.obric.capabilitykit.common.intent.BasePhotoSearchAlbumIntent;
import com.obric.capabilitykit.common.intent.BasePhotoSearchIntent;
import com.obric.capabilitykit.common.intent.BasePhotoSetBrightnessIntent;
import com.obric.capabilitykit.common.intent.BasePhotoSetClarityIntent;
import com.obric.capabilitykit.common.intent.BasePhotoSetContrastIntent;
import com.obric.capabilitykit.common.intent.BasePhotoSetExposureIntent;
import com.obric.capabilitykit.common.intent.BasePhotoSetFadeIntent;
import com.obric.capabilitykit.common.intent.BasePhotoSetFilterIntent;
import com.obric.capabilitykit.common.intent.BasePhotoSetRotationIntent;
import com.obric.capabilitykit.common.intent.BasePhotoSetSaturationIntent;
import com.obric.capabilitykit.common.intent.BasePhotoSetShadowIntent;
import com.obric.capabilitykit.common.intent.BasePhotoSetSharpnessIntent;
import com.obric.capabilitykit.common.intent.BasePhotoSetToneIntent;
import com.obric.capabilitykit.common.intent.BasePhotoSetWarmIntent;
import com.obric.capabilitykit.common.intent.BasePhotoShowAlbumIntent;
import com.obric.capabilitykit.common.intent.BasePhotoShowPhotoIntent;
import com.obric.capabilitykit.common.intent.BasePhotoUpdateAlbumIntent;
import com.obric.capabilitykit.common.intent.BaseRCComplexTaskContextIntent;
import com.obric.capabilitykit.common.intent.BaseRCDeviceStateIntent;
import com.obric.capabilitykit.common.intent.BaseRCSearchIntent;
import com.obric.capabilitykit.common.intent.BaseRecorderDeleteIntent;
import com.obric.capabilitykit.common.intent.BaseRecorderOperateIntent;
import com.obric.capabilitykit.common.intent.BaseRecorderShowRecordingIntent;
import com.obric.capabilitykit.common.intent.BaseSemanticSupplementIntent;
import com.obric.capabilitykit.common.intent.BaseShortVideoSearchIntent;
import com.obric.capabilitykit.common.intent.BaseSystemAdjustBrightnessIntent;
import com.obric.capabilitykit.common.intent.BaseSystemAdjustVolumeIntent;
import com.obric.capabilitykit.common.intent.BaseSystemAskUserIntent;
import com.obric.capabilitykit.common.intent.BaseSystemAutoActionIntent;
import com.obric.capabilitykit.common.intent.BaseSystemCheckPermissionsIntent;
import com.obric.capabilitykit.common.intent.BaseSystemDataSyncTriggerIntent;
import com.obric.capabilitykit.common.intent.BaseSystemDeviceStateIntent;
import com.obric.capabilitykit.common.intent.BaseSystemDownloadAppIntent;
import com.obric.capabilitykit.common.intent.BaseSystemFindPhoneIntent;
import com.obric.capabilitykit.common.intent.BaseSystemGetAppLatestVersionIntent;
import com.obric.capabilitykit.common.intent.BaseSystemGetLocationIntent;
import com.obric.capabilitykit.common.intent.BaseSystemGetWebUrlIntent;
import com.obric.capabilitykit.common.intent.BaseSystemHeartBeatIntent;
import com.obric.capabilitykit.common.intent.BaseSystemInAppSearchIntent;
import com.obric.capabilitykit.common.intent.BaseSystemJumpAppStoreIntent;
import com.obric.capabilitykit.common.intent.BaseSystemLocationRequestIntent;
import com.obric.capabilitykit.common.intent.BaseSystemMultiUserSelectIntent;
import com.obric.capabilitykit.common.intent.BaseSystemOpenAppIntent;
import com.obric.capabilitykit.common.intent.BaseSystemOpenPageIntent;
import com.obric.capabilitykit.common.intent.BaseSystemPowerLockControlIntent;
import com.obric.capabilitykit.common.intent.BaseSystemQAWithSearchIntent;
import com.obric.capabilitykit.common.intent.BaseSystemRebootIntent;
import com.obric.capabilitykit.common.intent.BaseSystemRequestPermissionsIntent;
import com.obric.capabilitykit.common.intent.BaseSystemScreenRecordIntent;
import com.obric.capabilitykit.common.intent.BaseSystemScreenshotIntent;
import com.obric.capabilitykit.common.intent.BaseSystemSetBrightnessIntent;
import com.obric.capabilitykit.common.intent.BaseSystemSetVolumeIntent;
import com.obric.capabilitykit.common.intent.BaseSystemSettingsAvailableIntent;
import com.obric.capabilitykit.common.intent.BaseSystemShellIntent;
import com.obric.capabilitykit.common.intent.BaseSystemShowEntitiesIntent;
import com.obric.capabilitykit.common.intent.BaseSystemShutdownIntent;
import com.obric.capabilitykit.common.intent.BaseSystemSkillIntent;
import com.obric.capabilitykit.common.intent.BaseSystemStopActionIntent;
import com.obric.capabilitykit.common.intent.BaseSystemSwitchModeIntent;
import com.obric.capabilitykit.common.intent.BaseSystemSwitchNotificationIntent;
import com.obric.capabilitykit.common.intent.BaseSystemUpdatePermissionsIntent;
import com.obric.capabilitykit.common.intent.BaseSystemUserAuthorizeIntent;
import com.obric.capabilitykit.common.intent.BaseSystemUserConfirmIntent;
import com.obric.capabilitykit.common.intent.BaseSystemUserRemindIntent;
import com.obric.capabilitykit.common.intent.BaseSystemUserSelectIntent;
import com.obric.capabilitykit.common.intent.BaseTravelSearchFlightIntent;
import com.obric.capabilitykit.common.intent.BaseTravelSearchHotelIntent;
import com.obric.capabilitykit.common.intent.BaseTravelSearchTrainIntent;
import com.obric.capabilitykit.common.intent.BaseWeatherSearchIntent;
import com.obric.capabilitykit.common.intent.BaseWeatherShowIntent;
import com.obric.miniapp.impl.AppletExtServiceImpl;
import com.obric.miniapp.intent.ObricIntentWidgetPolicyImpl;
import com.obric.sva.framework.impl.SvaFrameworkImpl;
import com.obric.sva.sdk.notification.ObricPackageSignatureCacheServiceImpl;
import com.obric.update.impl.ObricUpdateImpl;
import com.obric.update.impl.v2.ObricUpdateBitImpl;
import com.obric.update.impl.v2.ObricUpdateSPIImplService;
import com.obric.update.impl.v2.ObricUpdateSettingServiceImpl;
import com.ss.android.ugc.aweme.discover.dynamic.ability.ecommerce.DRFallBackAbilityFactory;
import com.ss.android.ugc.aweme.discover.dynamic.ability.ecommerce.EcomPitayaAbilityFactory;
import com.ss.android.ugc.aweme.discover.dynamic.ability.ecommerce.EcomSearchBannerAnimAbilityFactory;
import com.ss.android.ugc.aweme.discover.dynamic.ability.ecommerce.LongPressAbilityFactory;
import com.ss.android.ugc.aweme.discover.dynamic.gecko.ECSearchGrowMarketingServiceImpl;
import com.ss.android.ugc.aweme.live.plugin.LivePluginContext;
import com.ss.android.ugc.aweme.live.plugin.LivePluginImpl;
import com.ss.android.ugc.aweme.search.common.service.ECSearchServiceImpl;
import com.ss.aweme.paas.APDefaultTarget;
import com.ss.aweme.paas.APDouyinTarget;
import com.ss.aweme.paas.APDyliteTarget;
import com.ss.aweme.paas.APHubbleTarget;
import com.ss.aweme.paas.APHuoShanTarget;
import com.ss.aweme.paas.APJingxuanTarget;
import com.ss.aweme.paas.APLegouTarget;
import com.ss.cast.plugin.dy.source.SourceManager;
import com.story.ai.biz.comment.CommentServiceImpl;
import component.ChatConversationComponentRegistry;
import component.ChatInputMultimodalRegistry;
import component.ChatMessageSendComponentRegistry;
import component.ChatModeSwitchComponentRegistry;
import component.ChatUiComponentRegistry;
import component.CreationSendMessageComponentRegistry;
import component.ServiceBotComponentRegistry;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class StaticServiceImplManager {
    private Map<String, Object> serviceImplCache;
    final Set<String> serviceImplNotExistSet;
    private Map<String, Set<Object>> serviceImplSetCache;
    final Set<String> serviceImplSetNotExistSet;

    public static class SingleInstanceHolder {
        private static final StaticServiceImplManager INSTANCE = null;

        private SingleInstanceHolder() {
        }

        static {
            INSTANCE = new StaticServiceImplManager();
        }

        public static /* synthetic */ StaticServiceImplManager access$000() {
            return INSTANCE;
        }
    }

    private Set getStaticServiceImplSetRealStub0(Class r2) {
        switch(r2.getName().hashCode()) {
            case -2113648773: goto L767;
            case -2103105871: goto L764;
            case -2086116425: goto L761;
            case -2064565899: goto L758;
            case -2053014790: goto L755;
            case -2017810094: goto L752;
            case -2016407209: goto L749;
            case -1999609349: goto L746;
            case -1969118622: goto L743;
            case -1927556761: goto L740;
            case -1904645091: goto L737;
            case -1816609618: goto L734;
            case -1806625901: goto L731;
            case -1804281075: goto L728;
            case -1795228449: goto L725;
            case -1784724874: goto L722;
            case -1780725501: goto L719;
            case -1758245390: goto L716;
            case -1751371519: goto L713;
            case -1748441402: goto L710;
            case -1744531954: goto L707;
            case -1698052040: goto L704;
            case -1684423728: goto L701;
            case -1657056325: goto L698;
            case -1646146182: goto L695;
            case -1622164797: goto L692;
            case -1575792756: goto L689;
            case -1566623059: goto L686;
            case -1562564369: goto L683;
            case -1549499957: goto L680;
            case -1528628784: goto L677;
            case -1503532648: goto L674;
            case -1484749994: goto L671;
            case -1481674212: goto L668;
            case -1468161943: goto L665;
            case -1447794062: goto L662;
            case -1446372015: goto L659;
            case -1420487376: goto L656;
            case -1419161643: goto L653;
            case -1418949249: goto L650;
            case -1405961720: goto L647;
            case -1392181677: goto L644;
            case -1365223279: goto L641;
            case -1356679394: goto L638;
            case -1334000955: goto L635;
            case -1279525760: goto L632;
            case -1265760599: goto L629;
            case -1219976780: goto L626;
            case -1207703304: goto L623;
            case -1207659565: goto L620;
            case -1177536076: goto L617;
            case -1171299282: goto L614;
            case -1154027116: goto L611;
            case -1134688967: goto L608;
            case -1132334996: goto L605;
            case -1130948299: goto L602;
            case -1121318656: goto L599;
            case -1106349759: goto L596;
            case -1099868708: goto L593;
            case -1073933745: goto L590;
            case -1056517536: goto L587;
            case -1055264810: goto L584;
            case -1003926119: goto L581;
            case -992962032: goto L578;
            case -949468937: goto L575;
            case -949279935: goto L572;
            case -936687621: goto L569;
            case -931933289: goto L566;
            case -926706298: goto L563;
            case -925540162: goto L560;
            case -921963023: goto L557;
            case -898103695: goto L554;
            case -896837652: goto L551;
            case -887614667: goto L548;
            case -875511953: goto L545;
            case -838416547: goto L542;
            case -833883996: goto L539;
            case -819602143: goto L536;
            case -791784203: goto L533;
            case -791736954: goto L530;
            case -776336870: goto L527;
            case -744327845: goto L524;
            case -739662166: goto L521;
            case -709191812: goto L518;
            case -697686902: goto L515;
            case -681839542: goto L512;
            case -663893918: goto L509;
            case -652332012: goto L506;
            case -650575155: goto L503;
            case -635372463: goto L500;
            case -618108667: goto L497;
            case -603858248: goto L494;
            case -592560279: goto L491;
            case -590883705: goto L488;
            case -497207862: goto L485;
            case -482608882: goto L482;
            case -480909286: goto L479;
            case -459006949: goto L476;
            case -457545893: goto L473;
            case -443968843: goto L470;
            case -431950148: goto L467;
            case -428685136: goto L464;
            case -404512413: goto L461;
            case -351073084: goto L458;
            case -342295247: goto L455;
            case -324088735: goto L452;
            case -314126932: goto L449;
            case -311584524: goto L446;
            case -291278819: goto L443;
            case -288791285: goto L440;
            case -277422657: goto L437;
            case -270038016: goto L434;
            case -265177061: goto L431;
            case -243252896: goto L428;
            case -201771400: goto L425;
            case -196446112: goto L422;
            case -189628749: goto L419;
            case -164104686: goto L416;
            case -161386568: goto L413;
            case -120856821: goto L410;
            case -106587468: goto L407;
            case -100812230: goto L404;
            case -100647297: goto L401;
            case -87116144: goto L398;
            case -57712139: goto L395;
            case -56499017: goto L392;
            case 3709278: goto L389;
            case 26285802: goto L386;
            case 61846759: goto L383;
            case 81961524: goto L380;
            case 83542673: goto L377;
            case 86526548: goto L374;
            case 99667420: goto L371;
            case 104277105: goto L368;
            case 124117792: goto L365;
            case 128932886: goto L362;
            case 175037926: goto L359;
            case 184208914: goto L356;
            case 193339506: goto L353;
            case 207350110: goto L350;
            case 270607638: goto L347;
            case 271922053: goto L344;
            case 275179258: goto L341;
            case 307174616: goto L338;
            case 359285192: goto L335;
            case 373878781: goto L332;
            case 380401512: goto L329;
            case 389894777: goto L326;
            case 404499219: goto L323;
            case 431273295: goto L320;
            case 457914255: goto L317;
            case 462091934: goto L314;
            case 467808293: goto L311;
            case 476847054: goto L308;
            case 490057634: goto L305;
            case 512942821: goto L302;
            case 512959996: goto L299;
            case 520850945: goto L296;
            case 528638324: goto L293;
            case 557789413: goto L290;
            case 610418217: goto L287;
            case 619224470: goto L284;
            case 624888608: goto L281;
            case 645956074: goto L278;
            case 670776753: goto L275;
            case 676556710: goto L272;
            case 687671950: goto L269;
            case 696575600: goto L266;
            case 696594811: goto L263;
            case 715181266: goto L260;
            case 751247275: goto L257;
            case 765027543: goto L254;
            case 780473211: goto L251;
            case 794271924: goto L248;
            case 797419702: goto L245;
            case 832699802: goto L242;
            case 851785726: goto L239;
            case 869779052: goto L236;
            case 870259929: goto L233;
            case 884171435: goto L230;
            case 889853846: goto L227;
            case 893852899: goto L224;
            case 905641289: goto L221;
            case 911443743: goto L218;
            case 915927358: goto L215;
            case 920095985: goto L212;
            case 935593269: goto L209;
            case 944179490: goto L206;
            case 970640090: goto L203;
            case 978461681: goto L200;
            case 1045698427: goto L197;
            case 1064333680: goto L194;
            case 1076512045: goto L191;
            case 1080469848: goto L188;
            case 1089103330: goto L185;
            case 1108156197: goto L182;
            case 1123896552: goto L179;
            case 1124973035: goto L176;
            case 1189945176: goto L173;
            case 1212902995: goto L170;
            case 1213582276: goto L167;
            case 1217768893: goto L164;
            case 1225765567: goto L161;
            case 1232421045: goto L158;
            case 1239487704: goto L155;
            case 1279759164: goto L152;
            case 1285417703: goto L149;
            case 1315677434: goto L146;
            case 1370701273: goto L143;
            case 1374719809: goto L140;
            case 1388051794: goto L137;
            case 1389779032: goto L134;
            case 1420842870: goto L131;
            case 1424720620: goto L128;
            case 1473760512: goto L125;
            case 1560996419: goto L122;
            case 1580477573: goto L119;
            case 1596521083: goto L116;
            case 1638510252: goto L113;
            case 1640961909: goto L110;
            case 1661381569: goto L107;
            case 1707528187: goto L104;
            case 1709711518: goto L101;
            case 1713016610: goto L98;
            case 1715797404: goto L95;
            case 1773512851: goto L92;
            case 1774753789: goto L89;
            case 1798840933: goto L86;
            case 1815559181: goto L83;
            case 1839465161: goto L80;
            case 1853813930: goto L77;
            case 1857803902: goto L74;
            case 1870235262: goto L71;
            case 1898814761: goto L68;
            case 1914864429: goto L65;
            case 1937721948: goto L62;
            case 1945067155: goto L59;
            case 1981652765: goto L56;
            case 1987262224: goto L53;
            case 1991873331: goto L50;
            case 2016350987: goto L47;
            case 2023707249: goto L44;
            case 2036393887: goto L41;
            case 2044149834: goto L38;
            case 2046021411: goto L35;
            case 2047767798: goto L32;
            case 2077453872: goto L29;
            case 2085582352: goto L26;
            case 2098293800: goto L23;
            case 2108608656: goto L20;
            case 2126006304: goto L17;
            case 2128877553: goto L14;
            case 2129071903: goto L11;
            case 2133712806: goto L6;
            default: goto L1024;
        };
    L1024:
        return null;
    L6:
        if (r2.getName().equals("com.larus.office.container.api.IOfficeContainerService") == false) goto L769;
        HashSet r3 = new HashSet();
        r3.add(new OfficeContainerService());
        String r0 = "com.larus.office.container.api.IOfficeContainerService";
    L8:
        putStaticServiceImplSetCache(r0, r3);
        return r3;
    L769:
        return null;
    L11:
        if (r2.getName().equals("com.obric.assistant.interaction.api.IAssistantChatWindow") == false) goto L771;
        r3 = new HashSet();
        r3.add(new AssistantChatWindowImpl());
        r0 = "com.obric.assistant.interaction.api.IAssistantChatWindow";
        goto L8
    L771:
        return null;
    L14:
        if (r2.getName().equals("com.larus.reach.api.ReachService") == false) goto L772;
        r3 = new HashSet();
        r3.add(new ReachServiceImpl());
        r0 = "com.larus.reach.api.ReachService";
        goto L8
    L772:
        return null;
    L17:
        if (r2.getName().equals("com.obric.assistant.performance.IObricMemoryReportService") == false) goto L773;
        r3 = new HashSet();
        r3.add(new ObricMemoryReportServiceImpl());
        r0 = "com.obric.assistant.performance.IObricMemoryReportService";
        goto L8
    L773:
        return null;
    L20:
        if (r2.getName().equals("com.larus.timonkit.api.ITimonKitService") == false) goto L774;
        r3 = new HashSet();
        r3.add(new TimonKitService());
        r0 = "com.larus.timonkit.api.ITimonKitService";
        goto L8
    L774:
        return null;
    L23:
        if (r2.getName().equals("com.larus.share.service.IShareShortUrlCreateService") == false) goto L775;
        r3 = new HashSet();
        r3.add(new ShareShortUrlCreateServiceImpl());
        r0 = "com.larus.share.service.IShareShortUrlCreateService";
        goto L8
    L775:
        return null;
    L26:
        if (r2.getName().equals("com.obric.aiagent.product.platform.api.rom.IRomInfo") == false) goto L776;
        r3 = new HashSet();
        r3.add(new CommonRomInfoImpl());
        r0 = "com.obric.aiagent.product.platform.api.rom.IRomInfo";
        goto L8
    L776:
        return null;
    L29:
        if (r2.getName().equals("com.obric.assistant.common.spi.IObricConfigService") == false) goto L777;
        r3 = new HashSet();
        r3.add(new ObricConfigServiceImpl());
        r0 = "com.obric.assistant.common.spi.IObricConfigService";
        goto L8
    L777:
        return null;
    L32:
        if (r2.getName().equals("com.larus.audio.audiov3.audio.player.factory.IAudioPlayerFactory") == false) goto L778;
        r3 = new HashSet();
        r3.add(new AudioPlayerFactory());
        r0 = "com.larus.audio.audiov3.audio.player.factory.IAudioPlayerFactory";
        goto L8
    L778:
        return null;
    L35:
        if (r2.getName().equals("com.obric.aiagent.messenger.IObricPccService") == false) goto L779;
        r3 = new HashSet();
        r3.add(new ObricPccServiceImpl());
        r0 = "com.obric.aiagent.messenger.IObricPccService";
        goto L8
    L779:
        return null;
    L38:
        if (r2.getName().equals("com.obric.assistant.common.spi.network.IObricSecurityNetworkService") == false) goto L780;
        r3 = new HashSet();
        r3.add(new ObricSecurityNetworkServiceImpl());
        r0 = "com.obric.assistant.common.spi.network.IObricSecurityNetworkService";
        goto L8
    L780:
        return null;
    L41:
        if (r2.getName().equals("com.larus.bmhome.chat.messagetransfer.IFlowMergeForwardService") == false) goto L781;
        r3 = new HashSet();
        r3.add(new FlowMergeForwardServiceImpl());
        r0 = "com.larus.bmhome.chat.messagetransfer.IFlowMergeForwardService";
        goto L8
    L781:
        return null;
    L44:
        if (r2.getName().equals("com.larus.account.saas.ttaccount.api.IAccountGroupAuthServerService") == false) goto L782;
        r3 = new HashSet();
        r3.add(new AccountGroupAuthServerService());
        r0 = "com.larus.account.saas.ttaccount.api.IAccountGroupAuthServerService";
        goto L8
    L782:
        return null;
    L47:
        if (r2.getName().equals("com.larus.audio.IFlowTtsClientFactory") == false) goto L783;
        r3 = new HashSet();
        r3.add(new FlowTtsClientFactoryImpl());
        r0 = "com.larus.audio.IFlowTtsClientFactory";
        goto L8
    L783:
        return null;
    L50:
        if (r2.getName().equals("com.larus.bmhome.chat.api.IAppletPayloadProviderService") == false) goto L784;
        r3 = new HashSet();
        r3.add(new CommonBusinessProvider());
        r3.add(new SystemPermissionStatusProvider());
        r3.add(new AppletPayloadProviderServiceImpl());
        r3.add(new AppletMediaPlayerContextProvider());
        r0 = "com.larus.bmhome.chat.api.IAppletPayloadProviderService";
        goto L8
    L784:
        return null;
    L53:
        if (r2.getName().equals("com.larus.share.impl.panel.ISharePanelService") == false) goto L785;
        r3 = new HashSet();
        r3.add(new SharePanelService());
        r0 = "com.larus.share.impl.panel.ISharePanelService";
        goto L8
    L785:
        return null;
    L56:
        if (r2.getName().equals("com.larus.sync.api.SyncSDKService") == false) goto L786;
        r3 = new HashSet();
        r3.add(new SyncSDKServiceImpl());
        r0 = "com.larus.sync.api.SyncSDKService";
        goto L8
    L786:
        return null;
    L59:
        if (r2.getName().equals("com.obric.assistant.trace.IObricTraceParam") == false) goto L787;
        r3 = new HashSet();
        r3.add(new ObricTraceParamImpl());
        r0 = "com.obric.assistant.trace.IObricTraceParam";
        goto L8
    L787:
        return null;
    L62:
        if (r2.getName().equals("com.larus.extension.aggregate_search_ui.api.kmp.KmpISearchCellProvider") == false) goto L788;
        r3 = new HashSet();
        r3.add(new KmpDriveSearchCellProvider());
        r3.add(new KmpInternalSearchCellDefaultProvider());
        r3.add(new KmpBotSearchCellProvider());
        r3.add(new KmpContactSearchCellProvider());
        r0 = "com.larus.extension.aggregate_search_ui.api.kmp.KmpISearchCellProvider";
        goto L8
    L788:
        return null;
    L65:
        if (r2.getName().equals("com.larus.apm.api.ITTProtector") == false) goto L789;
        r3 = new HashSet();
        r3.add(new TTProtectorImpl());
        r0 = "com.larus.apm.api.ITTProtector";
        goto L8
    L789:
        return null;
    L68:
        if (r2.getName().equals("com.obric.assistant.permission.IObricPermissionService") == false) goto L790;
        r3 = new HashSet();
        r3.add(new IObricPermissionServiceImpl());
        r0 = "com.obric.assistant.permission.IObricPermissionService";
        goto L8
    L790:
        return null;
    L71:
        if (r2.getName().equals("com.larus.podcast.IFlowPodcastService") == false) goto L791;
        r3 = new HashSet();
        r3.add(new FlowPodcastService());
        r0 = "com.larus.podcast.IFlowPodcastService";
        goto L8
    L791:
        return null;
    L74:
        if (r2.getName().equals("com.obric.aiagent.messenger.IObricIPC") == false) goto L792;
        r3 = new HashSet();
        r3.add(new ObricIPCImpl());
        r0 = "com.obric.aiagent.messenger.IObricIPC";
        goto L8
    L792:
        return null;
    L77:
        if (r2.getName().equals("com.obric.assistant.oneshot.api.IOneshotService") == false) goto L793;
        r3 = new HashSet();
        r3.add(new OneshotServiceImpl());
        r0 = "com.obric.assistant.oneshot.api.IOneshotService";
        goto L8
    L793:
        return null;
    L80:
        if (r2.getName().equals("com.larus.im.depend.IAzerothService") == false) goto L794;
        r3 = new HashSet();
        r3.add(new AzerothServiceImpl());
        r0 = "com.larus.im.depend.IAzerothService";
        goto L8
    L794:
        return null;
    L83:
        if (r2.getName().equals("com.larus.common.zlinksdk.api.IZlinkConfigs") == false) goto L795;
        r3 = new HashSet();
        r3.add(new ZlinkConfigs());
        r0 = "com.larus.common.zlinksdk.api.IZlinkConfigs";
        goto L8
    L795:
        return null;
    L86:
        if (r2.getName().equals("com.larus.mirabridge.api.plugin.service.IMiraUtilService") == false) goto L796;
        r3 = new HashSet();
        r3.add(new MiraUtilServiceImpl());
        r0 = "com.larus.mirabridge.api.plugin.service.IMiraUtilService";
        goto L8
    L796:
        return null;
    L89:
        if (r2.getName().equals("com.obric.assistant.spi.security.minormode.IObricMinorModeService") == false) goto L797;
        r3 = new HashSet();
        r3.add(new ObricMinorModeServiceImpl());
        r0 = "com.obric.assistant.spi.security.minormode.IObricMinorModeService";
        goto L8
    L797:
        return null;
    L92:
        if (r2.getName().equals("com.larus.update.IBitsUpdate") == false) goto L798;
        r3 = new HashSet();
        r3.add(new IBitsUpdateImpl());
        r0 = "com.larus.update.IBitsUpdate";
        goto L8
    L798:
        return null;
    L95:
        if (r2.getName().equals("com.larus.discover.api.IDiscoverService") == false) goto L799;
        r3 = new HashSet();
        r3.add(new DiscoverServiceImpl());
        r0 = "com.larus.discover.api.IDiscoverService";
        goto L8
    L799:
        return null;
    L98:
        if (r2.getName().equals("com.larus.tts.ITtsReaderFactory") == false) goto L800;
        r3 = new HashSet();
        r3.add(new TtsReaderFactoryImpl());
        r0 = "com.larus.tts.ITtsReaderFactory";
        goto L8
    L800:
        return null;
    L101:
        if (r2.getName().equals("com.larus.audio.audiov3.config.audio.player.IAudioPlayerConfigFactory") == false) goto L801;
        r3 = new HashSet();
        r3.add(new AudioPlayerConfigFactory());
        r0 = "com.larus.audio.audiov3.config.audio.player.IAudioPlayerConfigFactory";
        goto L8
    L801:
        return null;
    L104:
        if (r2.getName().equals("com.larus.extension.chat_extension.api.IDouyinRecommendService") == false) goto L802;
        r3 = new HashSet();
        r3.add(new DouyinRecommendServiceImpl());
        r0 = "com.larus.extension.chat_extension.api.IDouyinRecommendService";
        goto L8
    L802:
        return null;
    L107:
        if (r2.getName().equals("com.larus.map.api.IMapApi") == false) goto L803;
        r3 = new HashSet();
        r3.add(new MapServiceImpl());
        r0 = "com.larus.map.api.IMapApi";
        goto L8
    L803:
        return null;
    L110:
        if (r2.getName().equals("com.larus.voice.output.volume.IVolumeService") == false) goto L804;
        r3 = new HashSet();
        r3.add(new VolumeServiceImpl());
        r0 = "com.larus.voice.output.volume.IVolumeService";
        goto L8
    L804:
        return null;
    L113:
        if (r2.getName().equals("com.larus.tts.IUserSettingRepoService") == false) goto L805;
        r3 = new HashSet();
        r3.add(new UserSettingImpl());
        r0 = "com.larus.tts.IUserSettingRepoService";
        goto L8
    L805:
        return null;
    L116:
        if (r2.getName().equals("com.obric.assistant.network.api.INetworkInterceptorService") == false) goto L806;
        r3 = new HashSet();
        r3.add(new NetworkInterceptorServiceImpl());
        r0 = "com.obric.assistant.network.api.INetworkInterceptorService";
        goto L8
    L806:
        return null;
    L119:
        if (r2.getName().equals("com.larus.ui.arch.modulizer.di.IComponentRegistry") == false) goto L807;
        r3 = new HashSet();
        r3.add(new AsrAutoFillComponentRegistry());
        r3.add(new AudioComponentRegistry());
        r3.add(new HandsfreeComponentRegistry());
        r3.add(new LiveTutorAudioComponentRegistry());
        r3.add(new NoOAudioComponentRegistry());
        r3.add(new OAudioComponentRegistry());
        r3.add(new ChatSettingComponentRegistry());
        r3.add(new ChatCommonComponentRegistry());
        r3.add(new ActiveSwitchBannerComponentRegistry());
        r3.add(new BubbleBannerComponentRegistry());
        r3.add(new InputComponentRegistry());
        r3.add(new ChatUIBlockComponentRegistry());
        r3.add(new ChatCommonPageStateComponentRegistry());
        r3.add(new NestMenuComponentRegistry());
        r3.add(new ClarificationComponentRegistry());
        r3.add(new InputAreaBlockComponentRegistry());
        r3.add(new MainConversationInteractionPanelComponentRegistry());
        r3.add(new TextCellComponentRegistry());
        r3.add(new InputOnlyContainerRegistry());
        r3.add(new FloatComponentRegistry());
        r3.add(new ChatLegacyCardComponentRegistry());
        r3.add(new ChatLegacyChatBottomComponentRegistry());
        r3.add(new ChatLegacyChatTitleComponentRegistry());
        r3.add(new ChatLegacyCloudTestComponentRegistry());
        r3.add(new ChatLegacyComponentRegistry());
        r3.add(new ChatLegacyFastSendImageComponentRegistry());
        r3.add(new ChatLegacyListComponentRegistry());
        r3.add(new ChatLegacyNonNecessaryComponentRegistry());
        r3.add(new MsgOnlyContainerRegistry());
        r3.add(new ServiceBotNecessaryComponentRegistry());
        r3.add(new SkillComponentRegistry());
        r3.add(new ChatTopComponentRegistry());
        r3.add(new AIFloatChatComponentRegistry());
        r3.add(new ChatJobComponentRegistry());
        r3.add(new ChatCommerceCreditComponentRegistry());
        r3.add(new ChatCommerceMembershipComponentRegistry());
        r3.add(new CreationUserLandingComponentRegister());
        r3.add(new ContextWindowEntryComponentRegistry());
        r3.add(new HybridCardsComponentRegistry());
        r3.add(new DocFloatChatComponentRegistry());
        r3.add(new DriveChatComponentRegistry());
        r3.add(new ChatOrderSettingsComponentRegistry());
        r3.add(new ServiceBotBtmRegistry());
        r3.add(new SummaryCardComponentRegistry());
        r3.add(new SmartReplyComponentRegistry());
        r3.add(new LuckyDogComponentRegistry());
        r3.add(new ChatMinorComponentRegistry());
        r3.add(new ChatMinorSettingsComponentRegistry());
        r3.add(new ChatMinorTipsComponentRegistry());
        r3.add(new ChatWalletSettingsComponentRegistry());
        r3.add(new SheetFloatChatComponentRegistry());
        r3.add(new SlidesFloatChatComponentRegistry());
        r3.add(new ChatSuggestComponentRegistry());
        r3.add(new AudioLegacyComponentRegistry());
        r3.add(new ChatCreationComponentRegistry());
        r3.add(new CreationSendUiEventComponentRegistry());
        r3.add(new RealtimeCallComponentRegistry());
        r3.add(new QuicInterpretComponentRegistry());
        r3.add(new ContinuesSpeakComponentRegistry());
        r3.add(new OrionCardComponentRegistry());
        r3.add(new ObricChatCommonRegistry());
        r3.add(new ObricChatInputComponentRegistry());
        r3.add(new ObricComponentRegistry());
        r3.add(new ObricInputComponentRegistry());
        r3.add(new com.obric.assistant.chat.component.interaction.RealtimeCallComponentRegistry());
        r3.add(new OrionSettingComponentRegistry());
        r3.add(new ObricWindowComponentRegistry());
        r3.add(new ObricAudioComponentRegistry());
        r3.add(new ChatConversationComponentRegistry());
        r3.add(new ChatInputMultimodalRegistry());
        r3.add(new ChatMessageSendComponentRegistry());
        r3.add(new ChatModeSwitchComponentRegistry());
        r3.add(new ChatUiComponentRegistry());
        r3.add(new CreationSendMessageComponentRegistry());
        r3.add(new ServiceBotComponentRegistry());
        r0 = "com.larus.ui.arch.modulizer.di.IComponentRegistry";
        goto L8
    L807:
        return null;
    L122:
        if (r2.getName().equals("com.bytedance.flow_audio.api.service.common.IKMPLoggerService") == false) goto L808;
        r3 = new HashSet();
        r3.add(new LoggerInject());
        r0 = "com.bytedance.flow_audio.api.service.common.IKMPLoggerService";
        goto L8
    L808:
        return null;
    L125:
        if (r2.getName().equals("com.obric.assistant.state.api.multitask.IObricTaskFlowActiveStateService") == false) goto L809;
        r3 = new HashSet();
        r3.add(new ObricTaskFlowActiveStateServiceImpl());
        r0 = "com.obric.assistant.state.api.multitask.IObricTaskFlowActiveStateService";
        goto L8
    L809:
        return null;
    L128:
        if (r2.getName().equals("com.larus.apm.api.IApmTrace") == false) goto L810;
        r3 = new HashSet();
        r3.add(new ApmTraceImpl());
        r0 = "com.larus.apm.api.IApmTrace";
        goto L8
    L810:
        return null;
    L131:
        if (r2.getName().equals("com.larus.business.floatchat.api.IAIFloatChatService") == false) goto L811;
        r3 = new HashSet();
        r3.add(new AIFloatChatServiceImpl());
        r0 = "com.larus.business.floatchat.api.IAIFloatChatService";
        goto L8
    L811:
        return null;
    L134:
        if (r2.getName().equals("com.larus.bmhome.chat.larkforward.IFlowLarkToDoubaoService") == false) goto L812;
        r3 = new HashSet();
        r3.add(new FlowLarkToDoubaoServiceImpl());
        r0 = "com.larus.bmhome.chat.larkforward.IFlowLarkToDoubaoService";
        goto L8
    L812:
        return null;
    L137:
        if (r2.getName().equals("com.larus.lbs.trace.api.ILbsTraceService") == false) goto L813;
        r3 = new HashSet();
        r3.add(new LbsTraceServiceImpl());
        r0 = "com.larus.lbs.trace.api.ILbsTraceService";
        goto L8
    L813:
        return null;
    L140:
        if (r2.getName().equals("com.larus.common.apphost.AppHost") == false) goto L814;
        r3 = new HashSet();
        r3.add(new AppHostImpl());
        r0 = "com.larus.common.apphost.AppHost";
        goto L8
    L814:
        return null;
    L143:
        if (r2.getName().equals("com.larus.apm.api.IApm") == false) goto L815;
        r3 = new HashSet();
        r3.add(new ApmImpl());
        r0 = "com.larus.apm.api.IApm";
        goto L8
    L815:
        return null;
    L146:
        if (r2.getName().equals("com.obric.assistant.security.provision.check.api.ISecurityProvisionChecker") == false) goto L816;
        r3 = new HashSet();
        r3.add(new SecurityProvisionCheckerImpl());
        r0 = "com.obric.assistant.security.provision.check.api.ISecurityProvisionChecker";
        goto L8
    L816:
        return null;
    L149:
        if (r2.getName().equals("com.larus.bootprotector.IBootProtectorDebugService") == false) goto L817;
        r3 = new HashSet();
        r3.add(new BootProtectorDebugServiceImpl());
        r0 = "com.larus.bootprotector.IBootProtectorDebugService";
        goto L8
    L817:
        return null;
    L152:
        if (r2.getName().equals("com.larus.disk.api.IAppDiskDebugService") == false) goto L818;
        r3 = new HashSet();
        r3.add(new IAppDiskServiceImpl());
        r0 = "com.larus.disk.api.IAppDiskDebugService";
        goto L8
    L818:
        return null;
    L155:
        if (r2.getName().equals("com.larus.chat.search.api.ISdkSearchService") == false) goto L819;
        r3 = new HashSet();
        r3.add(new NewSearchServiceImpl());
        r0 = "com.larus.chat.search.api.ISdkSearchService";
        goto L8
    L819:
        return null;
    L158:
        if (r2.getName().equals("com.obric.assistant.automic.IObricAutoMicService") == false) goto L820;
        r3 = new HashSet();
        r3.add(new ObricAutoMicServiceImpl());
        r0 = "com.obric.assistant.automic.IObricAutoMicService";
        goto L8
    L820:
        return null;
    L161:
        if (r2.getName().equals("com.larus.bmhome.larkinput.api.service.ILarkInputService") == false) goto L821;
        r3 = new HashSet();
        r3.add(new LarkInputServiceImpl());
        r0 = "com.larus.bmhome.larkinput.api.service.ILarkInputService";
        goto L8
    L821:
        return null;
    L164:
        if (r2.getName().equals("com.larus.receive.contract.IReceiveTextDiff") == false) goto L822;
        r3 = new HashSet();
        r3.add(new ObricReceiveTextDiffImpl());
        r0 = "com.larus.receive.contract.IReceiveTextDiff";
        goto L8
    L822:
        return null;
    L167:
        if (r2.getName().equals("com.larus.platform.api.IImageUploadPreheatService") == false) goto L823;
        r3 = new HashSet();
        r3.add(new ImageUploadPreheatServiceImpl());
        r0 = "com.larus.platform.api.IImageUploadPreheatService";
        goto L8
    L823:
        return null;
    L170:
        if (r2.getName().equals("com.larus.navigation.api.NavigationService") == false) goto L824;
        r3 = new HashSet();
        r3.add(new NavigationDispatcher());
        r0 = "com.larus.navigation.api.NavigationService";
        goto L8
    L824:
        return null;
    L173:
        if (r2.getName().equals("com.larus.utils.logger.ILogger") == false) goto L825;
        r3 = new HashSet();
        r3.add(new LoggerImpl());
        r0 = "com.larus.utils.logger.ILogger";
        goto L8
    L825:
        return null;
    L176:
        if (r2.getName().equals("com.larus.platform.spi.IAIChatTtsPlayTraceService") == false) goto L826;
        r3 = new HashSet();
        r3.add(new AIChatTTSPlayTraceImpl());
        r0 = "com.larus.platform.spi.IAIChatTtsPlayTraceService";
        goto L8
    L826:
        return null;
    L179:
        if (r2.getName().equals("com.larus.platform.api.creation.IBachService") == false) goto L827;
        r3 = new HashSet();
        r3.add(new BachServiceImpl());
        r0 = "com.larus.platform.api.creation.IBachService";
        goto L8
    L827:
        return null;
    L182:
        if (r2.getName().equals("com.obric.assistant.state.api.multitask.IObricStateMultitaskService") == false) goto L828;
        r3 = new HashSet();
        r3.add(new ObricStateMultitaskServiceImpl());
        r0 = "com.obric.assistant.state.api.multitask.IObricStateMultitaskService";
        goto L8
    L828:
        return null;
    L185:
        if (r2.getName().equals("com.larus.mirabridge.api.plugin.service.IPrePluginService") == false) goto L829;
        r3 = new HashSet();
        r3.add(new PrePluginServiceImpl());
        r0 = "com.larus.mirabridge.api.plugin.service.IPrePluginService";
        goto L8
    L829:
        return null;
    L188:
        if (r2.getName().equals("com.larus.apm.api.IApmConfigs") == false) goto L830;
        r3 = new HashSet();
        r3.add(new ApmConfigs());
        r0 = "com.larus.apm.api.IApmConfigs";
        goto L8
    L830:
        return null;
    L191:
        if (r2.getName().equals("com.larus.bmhome.auth.ILaunchCacheService") == false) goto L831;
        r3 = new HashSet();
        r3.add(new LaunchCacheImpl());
        r0 = "com.larus.bmhome.auth.ILaunchCacheService";
        goto L8
    L831:
        return null;
    L194:
        if (r2.getName().equals("com.larus.audio.audiov3.connection.ISamiConnectionPool") == false) goto L832;
        r3 = new HashSet();
        r3.add(new SamiConnectionPoolImpl());
        r0 = "com.larus.audio.audiov3.connection.ISamiConnectionPool";
        goto L8
    L832:
        return null;
    L197:
        if (r2.getName().equals("com.larus.reach.api.IReachDebugService") == false) goto L833;
        r3 = new HashSet();
        r3.add(new ReachDebugServiceImpl());
        r0 = "com.larus.reach.api.IReachDebugService";
        goto L8
    L833:
        return null;
    L200:
        if (r2.getName().equals("com.enroll.audio.enroll.IVoiceEnrollService") == false) goto L834;
        r3 = new HashSet();
        r3.add(new VoiceEnrollServiceImpl());
        r0 = "com.enroll.audio.enroll.IVoiceEnrollService";
        goto L8
    L834:
        return null;
    L203:
        if (r2.getName().equals("com.obric.assistant.product.api.IObricProduct") == false) goto L835;
        r3 = new HashSet();
        r3.add(new ObricProductImpl());
        r0 = "com.obric.assistant.product.api.IObricProduct";
        goto L8
    L835:
        return null;
    L206:
        if (r2.getName().equals("com.larus.deeplink.api.IDeeplinkService") == false) goto L836;
        r3 = new HashSet();
        r3.add(new DeeplinkServiceImpl());
        r0 = "com.larus.deeplink.api.IDeeplinkService";
        goto L8
    L836:
        return null;
    L209:
        if (r2.getName().equals("com.bytedance.ai.api.AppletHealthService") == false) goto L837;
        r3 = new HashSet();
        r3.add(new AppletHealthServiceImpl());
        r0 = "com.bytedance.ai.api.AppletHealthService";
        goto L8
    L837:
        return null;
    L212:
        if (r2.getName().equals("com.larus.hotpatch.IHotPatch") == false) goto L838;
        r3 = new HashSet();
        r3.add(new ReparoHotPatchImpl());
        r0 = "com.larus.hotpatch.IHotPatch";
        goto L8
    L838:
        return null;
    L215:
        if (r2.getName().equals("com.bytedance.flow_audio.api.service.common.IKMPAppInfoProvider") == false) goto L839;
        r3 = new HashSet();
        r3.add(new FlowAudioKmpAppInfoProvider());
        r0 = "com.bytedance.flow_audio.api.service.common.IKMPAppInfoProvider";
        goto L8
    L839:
        return null;
    L218:
        if (r2.getName().equals("com.larus.mirabridge.api.plugin.service.IPluginService") == false) goto L840;
        r3 = new HashSet();
        r3.add(new PluginServiceImpl());
        r0 = "com.larus.mirabridge.api.plugin.service.IPluginService";
        goto L8
    L840:
        return null;
    L221:
        if (r2.getName().equals("com.larus.audio.IFlowAsrClientService") == false) goto L841;
        r3 = new HashSet();
        r3.add(new FlowAsrClientImpl());
        r0 = "com.larus.audio.IFlowAsrClientService";
        goto L8
    L841:
        return null;
    L224:
        if (r2.getName().equals("com.larus.account.saas.coreapi.IAccountQrCodeService") == false) goto L842;
        r3 = new HashSet();
        r3.add(new AccountQrCodeService());
        r0 = "com.larus.account.saas.coreapi.IAccountQrCodeService";
        goto L8
    L842:
        return null;
    L227:
        if (r2.getName().equals("com.larus.bmhome.chat.api.ICrossPlatformMarkdownService") == false) goto L843;
        r3 = new HashSet();
        r3.add(new CrossPlatformMarkdownServiceImpl());
        r0 = "com.larus.bmhome.chat.api.ICrossPlatformMarkdownService";
        goto L8
    L843:
        return null;
    L230:
        if (r2.getName().equals("com.obric.assistant.spi.zeus.IObricZeusService") == false) goto L844;
        r3 = new HashSet();
        r3.add(new ObricZeusServiceImpl());
        r0 = "com.obric.assistant.spi.zeus.IObricZeusService";
        goto L8
    L844:
        return null;
    L233:
        if (r2.getName().equals("com.larus.vesdk.api.IVeSDK") == false) goto L845;
        r3 = new HashSet();
        r3.add(new VeSDKImpl());
        r0 = "com.larus.vesdk.api.IVeSDK";
        goto L8
    L845:
        return null;
    L236:
        if (r2.getName().equals("com.obric.assistant.processesmanager.IObricProcessesManager") == false) goto L846;
        r3 = new HashSet();
        r3.add(new ObricProcessesManagerImpl());
        r0 = "com.obric.assistant.processesmanager.IObricProcessesManager";
        goto L8
    L846:
        return null;
    L239:
        if (r2.getName().equals("com.obric.assistant.spi.office.IOfficeSdkLazyInitService") == false) goto L847;
        r3 = new HashSet();
        r3.add(new OfficeSdkLazyInitServiceImpl());
        r0 = "com.obric.assistant.spi.office.IOfficeSdkLazyInitService";
        goto L8
    L847:
        return null;
    L242:
        if (r2.getName().equals("com.larus.aweme.api.video.service.IVideoFragmentProvider") == false) goto L848;
        r3 = new HashSet();
        r3.add(new VideoFragmentProviderImpl());
        r0 = "com.larus.aweme.api.video.service.IVideoFragmentProvider";
        goto L8
    L848:
        return null;
    L245:
        if (r2.getName().equals("com.larus.audio.IFlowTtsClientService") == false) goto L849;
        r3 = new HashSet();
        r3.add(new FlowTtsClientImpl());
        r0 = "com.larus.audio.IFlowTtsClientService";
        goto L8
    L849:
        return null;
    L248:
        if (r2.getName().equals("com.larus.account.saas.coreapi.ISecShareDataService") == false) goto L850;
        r3 = new HashSet();
        r3.add(new SecShareDataService());
        r0 = "com.larus.account.saas.coreapi.ISecShareDataService";
        goto L8
    L850:
        return null;
    L251:
        if (r2.getName().equals("com.obric.assistant.reporter.IObricSystemReporter") == false) goto L851;
        r3 = new HashSet();
        r3.add(new ObricSystemReporterImpl());
        r0 = "com.obric.assistant.reporter.IObricSystemReporter";
        goto L8
    L851:
        return null;
    L254:
        if (r2.getName().equals("com.larus.share.service.IShareService") == false) goto L852;
        r3 = new HashSet();
        r3.add(new ShareServiceImpl());
        r0 = "com.larus.share.service.IShareService";
        goto L8
    L852:
        return null;
    L257:
        if (r2.getName().equals("com.larus.jato.api.IJato") == false) goto L853;
        r3 = new HashSet();
        r3.add(new JatoImpl());
        r0 = "com.larus.jato.api.IJato";
        goto L8
    L853:
        return null;
    L260:
        if (r2.getName().equals("com.larus.network.IHttpConst") == false) goto L854;
        r3 = new HashSet();
        r3.add(new HttpConstImpl());
        r0 = "com.larus.network.IHttpConst";
        goto L8
    L854:
        return null;
    L263:
        if (r2.getName().equals("com.larus.platform.api.IAppLaunchReporter") == false) goto L855;
        r3 = new HashSet();
        r3.add(new AppLaunchReporterDelegate());
        r0 = "com.larus.platform.api.IAppLaunchReporter";
        goto L8
    L855:
        return null;
    L266:
        if (r2.getName().equals("com.larus.platform.spi.MarkdownDataHandlersProvider") == false) goto L856;
        r3 = new HashSet();
        r3.add(new CustomDataHandlerProvider());
        r3.add(new CrossPlatformMDDataHandlerProvider());
        r3.add(new CreationDataHandlerProvider());
        r0 = "com.larus.platform.spi.MarkdownDataHandlersProvider";
        goto L8
    L856:
        return null;
    L269:
        if (r2.getName().equals("com.larus.ivykit.forest.IFlowForestService") == false) goto L857;
        r3 = new HashSet();
        r3.add(new FlowGeckoResourceService());
        r0 = "com.larus.ivykit.forest.IFlowForestService";
        goto L8
    L857:
        return null;
    L272:
        if (r2.getName().equals("com.larus.common.mssdk.api.ISecPrivacyService") == false) goto L858;
        r3 = new HashSet();
        r3.add(new ISecPrivacyServiceImpl());
        r0 = "com.larus.common.mssdk.api.ISecPrivacyService";
        goto L8
    L858:
        return null;
    L275:
        if (r2.getName().equals("com.larus.multitask_management.api.customize.ITaskUIFactory") == false) goto L859;
        r3 = new HashSet();
        r3.add(new DefaultTaskUIFactory());
        r3.add(new MultiComplexTaskUIFactory());
        r0 = "com.larus.multitask_management.api.customize.ITaskUIFactory";
        goto L8
    L859:
        return null;
    L278:
        if (r2.getName().equals("com.larus.video.api.IVideoEngineInitService") == false) goto L860;
        r3 = new HashSet();
        r3.add(new VideoEngineInitServiceImpl());
        r0 = "com.larus.video.api.IVideoEngineInitService";
        goto L8
    L860:
        return null;
    L281:
        if (r2.getName().equals("com.obric.assistant.spi.wakeup.IObricOneshotService") == false) goto L861;
        r3 = new HashSet();
        r3.add(new ObricOneshotServiceImpl());
        r0 = "com.obric.assistant.spi.wakeup.IObricOneshotService";
        goto L8
    L861:
        return null;
    L284:
        if (r2.getName().equals("com.larus.audio.record.factory.IAudioRecorderFactory") == false) goto L862;
        r3 = new HashSet();
        r3.add(new AudioRecorderFactory());
        r0 = "com.larus.audio.record.factory.IAudioRecorderFactory";
        goto L8
    L862:
        return null;
    L287:
        if (r2.getName().equals("com.larus.business.accessbility.api.IAccessibilityService") == false) goto L863;
        r3 = new HashSet();
        r3.add(new AccessibilityServiceImpl());
        r0 = "com.larus.business.accessbility.api.IAccessibilityService";
        goto L8
    L863:
        return null;
    L290:
        if (r2.getName().equals("com.larus.dora.api.IByteCastManager") == false) goto L864;
        r3 = new HashSet();
        r3.add(new DoraByteCastManager());
        r0 = "com.larus.dora.api.IByteCastManager";
        goto L8
    L864:
        return null;
    L293:
        if (r2.getName().equals("com.larus.share.service.IShareDoubaoForwardService") == false) goto L865;
        r3 = new HashSet();
        r3.add(new ShareDoubaoForwardService());
        r0 = "com.larus.share.service.IShareDoubaoForwardService";
        goto L8
    L865:
        return null;
    L296:
        if (r2.getName().equals("com.larus.init.IAppLogInitiator") == false) goto L866;
        r3 = new HashSet();
        r3.add(new AppLogInitiator());
        r0 = "com.larus.init.IAppLogInitiator";
        goto L8
    L866:
        return null;
    L299:
        if (r2.getName().equals("com.larus.btm.api.IBTMService") == false) goto L867;
        r3 = new HashSet();
        r3.add(new BTMServiceImpl());
        r0 = "com.larus.btm.api.IBTMService";
        goto L8
    L867:
        return null;
    L302:
        if (r2.getName().equals("com.larus.platform.api.creation.IBachDetectCenterAbility") == false) goto L868;
        r3 = new HashSet();
        r3.add(new BachDetectCenterAbilityImpl());
        r0 = "com.larus.platform.api.creation.IBachDetectCenterAbility";
        goto L8
    L868:
        return null;
    L305:
        if (r2.getName().equals("com.larus.mirabridge.api.plugin.service.IPluginInternalService") == false) goto L869;
        r3 = new HashSet();
        r3.add(new PluginInternalServiceImpl());
        r0 = "com.larus.mirabridge.api.plugin.service.IPluginInternalService";
        goto L8
    L869:
        return null;
    L308:
        if (r2.getName().equals("com.larus.business.debug.api.DebugBaseService") == false) goto L870;
        r3 = new HashSet();
        r3.add(new DebugBaseServiceImpl());
        r0 = "com.larus.business.debug.api.DebugBaseService";
        goto L8
    L870:
        return null;
    L311:
        if (r2.getName().equals("com.larus.bootprotector.IBootProtectorLauncher") == false) goto L871;
        r3 = new HashSet();
        r3.add(new BootProtectorLauncher());
        r0 = "com.larus.bootprotector.IBootProtectorLauncher";
        goto L8
    L871:
        return null;
    L314:
        if (r2.getName().equals("com.obric.aiagent.ipc.idl.IFileIDLSPI") == false) goto L872;
        r3 = new HashSet();
        r3.add(new FileIDLStubImpl());
        r0 = "com.obric.aiagent.ipc.idl.IFileIDLSPI";
        goto L8
    L872:
        return null;
    L317:
        if (r2.getName().equals("com.larus.bmhome.view.actionbar.api.IActionBarProvider") == false) goto L873;
        r3 = new HashSet();
        r3.add(new ContextWindowActionBarProvider());
        r3.add(new TaskSkillActionBarProvider());
        r0 = "com.larus.bmhome.view.actionbar.api.IActionBarProvider";
        goto L8
    L873:
        return null;
    L320:
        if (r2.getName().equals("com.larus.multitask_management.api.IMultiTaskHostAbility") == false) goto L874;
        r3 = new HashSet();
        r3.add(new MultiTaskHostAbilityImpl());
        r0 = "com.larus.multitask_management.api.IMultiTaskHostAbility";
        goto L8
    L874:
        return null;
    L323:
        if (r2.getName().equals("com.obric.assistant.performance.IObricThresholdDumpHprofService") == false) goto L875;
        r3 = new HashSet();
        r3.add(new ObricThresholdDumpHprofServiceImpl());
        r0 = "com.obric.assistant.performance.IObricThresholdDumpHprofService";
        goto L8
    L875:
        return null;
    L326:
        if (r2.getName().equals("com.obric.assistant.activation.presentation.contract.feedback.ObricActivationFeedback") == false) goto L876;
        r3 = new HashSet();
        r3.add(new ObricActivationFeedbackImpl());
        r0 = "com.obric.assistant.activation.presentation.contract.feedback.ObricActivationFeedback";
        goto L8
    L876:
        return null;
    L329:
        if (r2.getName().equals("com.obric.assistant.state.multitask.core.TaskFlowCriticalResolver") == false) goto L877;
        r3 = new HashSet();
        r3.add(new ObricTaskFlowActiveStateResolver());
        r3.add(new ObricTaskFlowPowerResolver());
        r0 = "com.obric.assistant.state.multitask.core.TaskFlowCriticalResolver";
        goto L8
    L877:
        return null;
    L332:
        if (r2.getName().equals("com.obric.assistant.network.api.IObricNetworkService") == false) goto L878;
        r3 = new HashSet();
        r3.add(new ObricNetworkServiceImpl());
        r0 = "com.obric.assistant.network.api.IObricNetworkService";
        goto L8
    L878:
        return null;
    L335:
        if (r2.getName().equals("com.larus.tts.IChatTtsService") == false) goto L879;
        r3 = new HashSet();
        r3.add(new ChatTtsServiceImpl());
        r0 = "com.larus.tts.IChatTtsService";
        goto L8
    L879:
        return null;
    L338:
        if (r2.getName().equals("com.larus.common.baidunavi.api.BaiduNaviService") == false) goto L880;
        r3 = new HashSet();
        r3.add(new BaiduNaviServiceImpl());
        r0 = "com.larus.common.baidunavi.api.BaiduNaviService";
        goto L8
    L880:
        return null;
    L341:
        if (r2.getName().equals("com.obric.assistant.interaction.api.IAssistantInteractionService") == false) goto L881;
        r3 = new HashSet();
        r3.add(new AssistantInteractionService());
        r0 = "com.obric.assistant.interaction.api.IAssistantInteractionService";
        goto L8
    L881:
        return null;
    L344:
        if (r2.getName().equals("com.larus.im.config.IMessengerConfigs") == false) goto L882;
        r3 = new HashSet();
        r3.add(new MessengerConfigsImpl());
        r0 = "com.larus.im.config.IMessengerConfigs";
        goto L8
    L882:
        return null;
    L347:
        if (r2.getName().equals("com.obric.assistant.spi.startup.IAssistantStartupTelemetry") == false) goto L883;
        r3 = new HashSet();
        r3.add(new AssistantStartupTelemetryImpl());
        r0 = "com.obric.assistant.spi.startup.IAssistantStartupTelemetry";
        goto L8
    L883:
        return null;
    L350:
        if (r2.getName().equals("com.larus.home.api.privacy.ICustomPrivacyService") == false) goto L884;
        r3 = new HashSet();
        r3.add(new ObricPrivacyService());
        r0 = "com.larus.home.api.privacy.ICustomPrivacyService";
        goto L8
    L884:
        return null;
    L353:
        if (r2.getName().equals("com.obric.assistant.common.spi.network.IObricTTNetMonitorHookService") == false) goto L885;
        r3 = new HashSet();
        r3.add(new ObricTTNetMonitorHookServiceImpl());
        r0 = "com.obric.assistant.common.spi.network.IObricTTNetMonitorHookService";
        goto L8
    L885:
        return null;
    L356:
        if (r2.getName().equals("com.larus.im.depend.IAIJobExperimentProvider") == false) goto L886;
        r3 = new HashSet();
        r3.add(new ChatJobExperimentProvider());
        r0 = "com.larus.im.depend.IAIJobExperimentProvider";
        goto L8
    L886:
        return null;
    L359:
        if (r2.getName().equals("com.larus.audio.IFlowTtsClientKmpService") == false) goto L887;
        r3 = new HashSet();
        r3.add(new FlowTtsClientKmpManagerDelegate());
        r0 = "com.larus.audio.IFlowTtsClientKmpService";
        goto L8
    L887:
        return null;
    L362:
        if (r2.getName().equals("com.larus.office.card.doc.content.IOfficeCardDocContentService") == false) goto L888;
        r3 = new HashSet();
        r3.add(new OfficeCardDocContentServiceImpl());
        r0 = "com.larus.office.card.doc.content.IOfficeCardDocContentService";
        goto L8
    L888:
        return null;
    L365:
        if (r2.getName().equals("com.obric.assistant.spi.performance.IObricMemoryReportSPIService") == false) goto L889;
        r3 = new HashSet();
        r3.add(new ObricMemoryReportSPIServiceImpl());
        r0 = "com.obric.assistant.spi.performance.IObricMemoryReportSPIService";
        goto L8
    L889:
        return null;
    L368:
        if (r2.getName().equals("com.obric.assistant.spi.app.IObricLaunchService") == false) goto L890;
        r3 = new HashSet();
        r3.add(new AppLaunchServiceImpl());
        r0 = "com.obric.assistant.spi.app.IObricLaunchService";
        goto L8
    L890:
        return null;
    L371:
        if (r2.getName().equals("com.larus.browsertakeover.api.IBrowserTakeoverService") == false) goto L891;
        r3 = new HashSet();
        r3.add(new BrowserTakeoverServiceImpl());
        r0 = "com.larus.browsertakeover.api.IBrowserTakeoverService";
        goto L8
    L891:
        return null;
    L374:
        if (r2.getName().equals("com.bytedance.locallife.ILocalLifeLiveService") == false) goto L892;
        r3 = new HashSet();
        r3.add(new LocalLifeLiveServiceImpl());
        r0 = "com.bytedance.locallife.ILocalLifeLiveService";
        goto L8
    L892:
        return null;
    L377:
        if (r2.getName().equals("com.obric.assistant.wakeup.statistics.api.IWakeupStatisticsAPI") == false) goto L893;
        r3 = new HashSet();
        r3.add(new WakeupStatisticsImpl());
        r0 = "com.obric.assistant.wakeup.statistics.api.IWakeupStatisticsAPI";
        goto L8
    L893:
        return null;
    L380:
        if (r2.getName().equals("com.larus.account.saas.coreapi.IAccountBindingService") == false) goto L894;
        r3 = new HashSet();
        r3.add(new AccountBindingService());
        r0 = "com.larus.account.saas.coreapi.IAccountBindingService";
        goto L8
    L894:
        return null;
    L383:
        if (r2.getName().equals("com.larus.account.saas.coreapi.IAccountTouristService") == false) goto L895;
        r3 = new HashSet();
        r3.add(new AccountTouristService());
        r0 = "com.larus.account.saas.coreapi.IAccountTouristService";
        goto L8
    L895:
        return null;
    L386:
        if (r2.getName().equals("com.larus.audio.audiov3.util.IAudioDeviceHelper") == false) goto L896;
        r3 = new HashSet();
        r3.add(new AudioDeviceHelperImpl());
        r0 = "com.larus.audio.audiov3.util.IAudioDeviceHelper";
        goto L8
    L896:
        return null;
    L389:
        if (r2.getName().equals("com.larus.extension.summary_card.api.ISummaryCardService") == false) goto L897;
        r3 = new HashSet();
        r3.add(new SummaryCardServiceImpl());
        r0 = "com.larus.extension.summary_card.api.ISummaryCardService";
        goto L8
    L897:
        return null;
    L392:
        if (r2.getName().equals("com.larus.bmhome.chat.component.list.pipeline.PipelineTaskProvider") == false) goto L898;
        r3 = new HashSet();
        r3.add(new DoraEPicDividerTaskProvider());
        r3.add(new AddEduCameraContinuerShootTaskProvider());
        r3.add(new AddLoadingTaskProvider());
        r3.add(new AddSpacerTaskProvider());
        r3.add(new AddSuggestPromptTaskProvider());
        r3.add(new AiDisclaimerTaskProvider());
        r3.add(new AwemeOnboardingTaskProvider());
        r3.add(new AwemeVideoSuggestFilterTaskProvider());
        r3.add(new BigAvatarTaskProvider());
        r3.add(new ClearContextTaskProvider());
        r3.add(new FilterTaskProvider());
        r3.add(new ForceLoadingWhenStreamingTaskProvider());
        r3.add(new ImmerseCutTaskProvider());
        r3.add(new OfflineMessageTaskProvider());
        r3.add(new PreDependentFilterTaskProvider());
        r3.add(new PreviewRoundMessageFilterTaskProvider());
        r3.add(new PromptFilterTaskProvider());
        r3.add(new RecommendDividerTaskProvider());
        r3.add(new TimeStampDividerTaskProvider());
        r3.add(new UpdatePromptLoadingTaskProvider());
        r3.add(new UserActiveDeleteTipTaskProvider());
        r3.add(new CrowdTestTaskProvider());
        r3.add(new DeviceOrRuntimeChangedTaskProvider());
        r3.add(new WcbLoadingHandoffTaskProvider());
        r3.add(new WcbLoadingTaskProvider());
        r3.add(new IntentCardRoundStateTaskProvider());
        r3.add(new OKeyguardCutTaskProvider());
        r3.add(new OSemanticCutTaskProvider());
        r0 = "com.larus.bmhome.chat.component.list.pipeline.PipelineTaskProvider";
        goto L8
    L898:
        return null;
    L395:
        if (r2.getName().equals("com.obric.assistant.privacy.IObricPrivacyService") == false) goto L899;
        r3 = new HashSet();
        r3.add(new ObricPrivacyService());
        r0 = "com.obric.assistant.privacy.IObricPrivacyService";
        goto L8
    L899:
        return null;
    L398:
        if (r2.getName().equals("com.larus.account.saas.coreapi.IAccountProfileService") == false) goto L900;
        r3 = new HashSet();
        r3.add(new AccountProfileService());
        r0 = "com.larus.account.saas.coreapi.IAccountProfileService";
        goto L8
    L900:
        return null;
    L401:
        if (r2.getName().equals("com.larus.init.IImageInitiator") == false) goto L901;
        r3 = new HashSet();
        r3.add(new ImageInitiator());
        r0 = "com.larus.init.IImageInitiator";
        goto L8
    L901:
        return null;
    L404:
        if (r2.getName().equals("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDLSPI") == false) goto L902;
        r3 = new HashSet();
        r3.add(new AppLogIDLStub());
        r0 = "com.obric.aiagent.flow.applog.idl.IFlowAppLogIDLSPI";
        goto L8
    L902:
        return null;
    L407:
        if (r2.getName().equals("com.obric.assistant.state.multitask.core.TaskFlowAutoInitProducer") == false) goto L903;
        r3 = new HashSet();
        r3.add(new ObricAigcGenerationSceneProjector());
        r3.add(new AiNoteStateProducer());
        r3.add(new ComplexTaskStateProducer());
        r3.add(new MessageStateProducer());
        r3.add(new ObricAigcGenerationStateProducer());
        r3.add(new SelfUpdateDownloadStateProducer());
        r3.add(new TtsStateProducer());
        r0 = "com.obric.assistant.state.multitask.core.TaskFlowAutoInitProducer";
        goto L8
    L903:
        return null;
    L410:
        if (r2.getName().equals("com.obric.assistant.wakeup.bluetooth_headset.api.IBluetoothHeadSetAPI") == false) goto L904;
        r3 = new HashSet();
        r3.add(new BluetoothHeadSetImpl());
        r0 = "com.obric.assistant.wakeup.bluetooth_headset.api.IBluetoothHeadSetAPI";
        goto L8
    L904:
        return null;
    L413:
        if (r2.getName().equals("com.larus.init.task.publishtest.IPublishDrillService") == false) goto L905;
        r3 = new HashSet();
        r3.add(new PublishDrillServiceImpl());
        r0 = "com.larus.init.task.publishtest.IPublishDrillService";
        goto L8
    L905:
        return null;
    L416:
        if (r2.getName().equals("com.larus.uploader.api.IUploaderService") == false) goto L906;
        r3 = new HashSet();
        r3.add(new UploaderServiceImpl());
        r0 = "com.larus.uploader.api.IUploaderService";
        goto L8
    L906:
        return null;
    L419:
        if (r2.getName().equals("com.obric.assistant.performance.IObricMemoryUploadService") == false) goto L907;
        r3 = new HashSet();
        r3.add(new ObricMemoryUploadServiceImpl());
        r0 = "com.obric.assistant.performance.IObricMemoryUploadService";
        goto L8
    L907:
        return null;
    L422:
        if (r2.getName().equals("com.larus.cdm.IFlowCompanionDeviceManager") == false) goto L908;
        r3 = new HashSet();
        r3.add(new FlowCompanionDeviceManagerImpl());
        r0 = "com.larus.cdm.IFlowCompanionDeviceManager";
        goto L8
    L908:
        return null;
    L425:
        if (r2.getName().equals("com.larus.bmhome.chat.api.IMessageExtService") == false) goto L909;
        r3 = new HashSet();
        r3.add(new AppletDebugMessageExtServiceImpl());
        r3.add(new CotDetailMessageExtServiceImpl());
        r3.add(new PcLocalDispatcherMessageExtService());
        r3.add(new DocMessageExtServiceImpl());
        r3.add(new ECommerceMessageExtServiceImpl());
        r3.add(new OfficeMessageExtService());
        r3.add(new SheetMessageExtServiceImpl());
        r3.add(new SlidesMessageExtServiceImpl());
        r3.add(new MessageExtCollector());
        r0 = "com.larus.bmhome.chat.api.IMessageExtService";
        goto L8
    L909:
        return null;
    L428:
        if (r2.getName().equals("com.larus.platform.api.IAccountRemovedCacheService") == false) goto L910;
        r3 = new HashSet();
        r3.add(new LaunchAccountRemovedCacheServiceImpl());
        r3.add(new OfficeConversationCacheAccountRemovedServiceImpl());
        r0 = "com.larus.platform.api.IAccountRemovedCacheService";
        goto L8
    L910:
        return null;
    L431:
        if (r2.getName().equals("com.larus.disk.api.IAppDiskService") == false) goto L911;
        r3 = new HashSet();
        r3.add(new IAppDiskServiceImpl());
        r0 = "com.larus.disk.api.IAppDiskService";
        goto L8
    L911:
        return null;
    L434:
        if (r2.getName().equals("com.larus.audio.controller.IGlobalAudioController") == false) goto L912;
        r3 = new HashSet();
        r3.add(new GlobalAudioControllerImpl());
        r0 = "com.larus.audio.controller.IGlobalAudioController";
        goto L8
    L912:
        return null;
    L437:
        if (r2.getName().equals("com.larus.bmhome.chat.block.base.IBlockProvider") == false) goto L913;
        r3 = new HashSet();
        r3.add(new PermissionApplyBlockProvider());
        r3.add(new DiaryImageBlockProvider());
        r3.add(new DiarySummaryBlockProvider());
        r3.add(new ArtifactOpBlockProvider());
        r3.add(new AuthIdentityBlockProvider());
        r3.add(new BizMergeForwardBlockProvider());
        r3.add(new CommerceCreditBlockProvider());
        r3.add(new ContentWebSearchBlockProvider());
        r3.add(new DeepThinkBlockProvider());
        r3.add(new DeepThinkCodeBlockProvider());
        r3.add(new DeepThinkImageAnalysisBlockProvider());
        r3.add(new DeepThinkImageSearchBlockProvider());
        r3.add(new DeepThinkSearchCotBlockProvider());
        r3.add(new ElapsedBlockProvider());
        r3.add(new GenImageBlockProvider());
        r3.add(new LinkReaderBlockProvider());
        r3.add(new LynxCardBlockProvider());
        r3.add(new MetaInfoBlockProvider());
        r3.add(new PoiBlockProvider());
        r3.add(new ResearchWebpageBlockProvider());
        r3.add(new RiskTipsBlockProvider());
        r3.add(new RoutePlanBlockProvider());
        r3.add(new SpringLynxBlockProvider());
        r3.add(new TextBlockProvider());
        r3.add(new PureVideoBlockProvider());
        r3.add(new ArtifactFallbackBlockProvider());
        r3.add(new BotReferenceTextBlockProvider());
        r3.add(new BrowserControlBlockProvider());
        r3.add(new InteractionAskBlockProvider());
        r3.add(new CodeArtifactBlockProvider());
        r3.add(new ContentCodeBlockProvider());
        r3.add(new CommonButtonBlockProvider());
        r3.add(new CommonButtonV2BlockProvider());
        r3.add(new ComplexTaskBlockProvider());
        r3.add(new ComputerUseToolResultBlockProvider());
        r3.add(new ResearchBlockProvider());
        r3.add(new ResearchProcessBlockProvider());
        r3.add(new FileBlockProvider());
        r3.add(new FileOperationBlockProvider());
        r3.add(new FileOperateBlockProvider());
        r3.add(new GuiToolBlockProvider());
        r3.add(new LinkBlockHolderProvider());
        r3.add(new LocalFileBlockProvider());
        r3.add(new PcLocalFileBlockProvider());
        r3.add(new LyricsToSongBlockProvider());
        r3.add(new MemoryBlockProvider());
        r3.add(new MiaodaArtifactBlockProvider());
        r3.add(new QuickReplyBlockProvider());
        r3.add(new QuickReplyInputPanelBlockProvider());
        r3.add(new QuickReplyThinkingBlockProvider());
        r3.add(new RealNameBlockProvider());
        r3.add(new ReplyTextLoadingBlockProvider());
        r3.add(new RichMediaLayoutBlockProvider());
        r3.add(new SearchMixedMediaBlockProvider());
        r3.add(new SplitLineBlockProvider());
        r3.add(new TaskCardBlockProvider());
        r3.add(new RelatedVideoBlockProvider());
        r3.add(new WidgetBlockProvider());
        r3.add(new SmartReplyBlockProvider());
        r3.add(new BitableArtifactBlockProvider());
        r3.add(new DocArtifactBlockProvider());
        r3.add(new AudioRecordBlockProvider());
        r3.add(new PPTArtifactBlockProvider());
        r3.add(new SheetArtifactBlockProvider());
        r3.add(new OfficeUrlPreviewArtifactBlockProvider());
        r3.add(new OfficeUrlPreviewFileBlockProvider());
        r3.add(new CreationBlockProvider());
        r3.add(new CreationLoadingBlockProvider());
        r3.add(new ButtonGroupBlockProvider());
        r3.add(new ClickIntentBlockProvider());
        r3.add(new LoadingBlockProvider());
        r3.add(new ProgressCardBlockProvider());
        r3.add(new ReferenceMsgBlockProvider());
        r3.add(new TipBlockProvider());
        r3.add(new UserSelectBlockProvider());
        r3.add(new ComplexCallForMeBlockProvider());
        r3.add(new LarkKnowledgeAuthorizedBlockProvider());
        r3.add(new LocalSearchBlockProvider());
        r0 = "com.larus.bmhome.chat.block.base.IBlockProvider";
        goto L8
    L913:
        return null;
    L440:
        if (r2.getName().equals("com.obric.assistant.performance.IObricPerformanceMonitorService") == false) goto L914;
        r3 = new HashSet();
        r3.add(new ObricPerformanceMonitorServiceImpl());
        r0 = "com.obric.assistant.performance.IObricPerformanceMonitorService";
        goto L8
    L914:
        return null;
    L443:
        if (r2.getName().equals("com.larus.bootprotector.BootProtectorDependency") == false) goto L915;
        r3 = new HashSet();
        r3.add(new BootProtectorDependencyImpl());
        r0 = "com.larus.bootprotector.BootProtectorDependency";
        goto L8
    L915:
        return null;
    L446:
        if (r2.getName().equals("com.obric.assistant.wakeup.co_wakeup.dora.CoWakeupApi") == false) goto L916;
        r3 = new HashSet();
        r3.add(new CoWakeupService());
        r0 = "com.obric.assistant.wakeup.co_wakeup.dora.CoWakeupApi";
        goto L8
    L916:
        return null;
    L449:
        if (r2.getName().equals("com.larus.api.LocationService") == false) goto L917;
        r3 = new HashSet();
        r3.add(new LocationClient());
        r0 = "com.larus.api.LocationService";
        goto L8
    L917:
        return null;
    L452:
        if (r2.getName().equals("com.larus.video.api.IVideoApi") == false) goto L918;
        r3 = new HashSet();
        r3.add(new VideoServiceImpl());
        r0 = "com.larus.video.api.IVideoApi";
        goto L8
    L918:
        return null;
    L455:
        if (r2.getName().equals("com.larus.showcase.api.ICaseService") == false) goto L919;
        r3 = new HashSet();
        r3.add(new CaseServiceImpl());
        r0 = "com.larus.showcase.api.ICaseService";
        goto L8
    L919:
        return null;
    L458:
        if (r2.getName().equals("com.larus.audio.report.IAsrTracerFactory") == false) goto L920;
        r3 = new HashSet();
        r3.add(new AsrTracerFactory());
        r0 = "com.larus.audio.report.IAsrTracerFactory";
        goto L8
    L920:
        return null;
    L461:
        if (r2.getName().equals("com.larus.audioplayer.api.manager.IAudioStopTimerManager") == false) goto L921;
        r3 = new HashSet();
        r3.add(new AudioStopTimerManagerService());
        r0 = "com.larus.audioplayer.api.manager.IAudioStopTimerManager";
        goto L8
    L921:
        return null;
    L464:
        if (r2.getName().equals("com.larus.avlink.api.IDoraGResourceService") == false) goto L922;
        r3 = new HashSet();
        r3.add(new DoraGResourceServiceImpl());
        r0 = "com.larus.avlink.api.IDoraGResourceService";
        goto L8
    L922:
        return null;
    L467:
        if (r2.getName().equals("com.larus.shortcuts.api.IShortcutsService") == false) goto L923;
        r3 = new HashSet();
        r3.add(new ShortcutsServiceImpl());
        r0 = "com.larus.shortcuts.api.IShortcutsService";
        goto L8
    L923:
        return null;
    L470:
        if (r2.getName().equals("com.larus.share.service.IAppletSharePanelService") == false) goto L924;
        r3 = new HashSet();
        r3.add(new AppletSharePanelServiceImpl());
        r0 = "com.larus.share.service.IAppletSharePanelService";
        goto L8
    L924:
        return null;
    L473:
        if (r2.getName().equals("com.larus.apm.api.INpth") == false) goto L925;
        r3 = new HashSet();
        r3.add(new NpthImpl());
        r0 = "com.larus.apm.api.INpth";
        goto L8
    L925:
        return null;
    L476:
        if (r2.getName().equals("com.larus.account.saas.ttaccount.api.IAccountSwitchService") == false) goto L926;
        r3 = new HashSet();
        r3.add(new AccountSwitchService());
        r0 = "com.larus.account.saas.ttaccount.api.IAccountSwitchService";
        goto L8
    L926:
        return null;
    L479:
        if (r2.getName().equals("com.larus.bmhome.share.api.IShareRuntimeService") == false) goto L927;
        r3 = new HashSet();
        r3.add(new MainlandShareRuntimeServiceImpl());
        r0 = "com.larus.bmhome.share.api.IShareRuntimeService";
        goto L8
    L927:
        return null;
    L482:
        if (r2.getName().equals("com.larus.bmhome.chat.component.list.pipeline.PipelineStageProvider") == false) goto L928;
        r3 = new HashSet();
        r3.add(new DeleteStageProvider());
        r3.add(new DirectAddStageProvider());
        r3.add(new FinalFilterStageProvider());
        r3.add(new NeedTraversalStageProvider());
        r3.add(new PreDependentStageProvider());
        r3.add(new UpdateStageProvider());
        r3.add(new MarkWidgetStageProvider());
        r0 = "com.larus.bmhome.chat.component.list.pipeline.PipelineStageProvider";
        goto L8
    L928:
        return null;
    L485:
        if (r2.getName().equals("com.obric.assistant.ttnet.IObricTTNet") == false) goto L929;
        r3 = new HashSet();
        r3.add(new ObricTTNetImpl());
        r0 = "com.obric.assistant.ttnet.IObricTTNet";
        goto L8
    L929:
        return null;
    L488:
        if (r2.getName().equals("com.larus.larkfeed.IFlowFeedApi") == false) goto L930;
        r3 = new HashSet();
        r3.add(new FlowFeedImpl());
        r0 = "com.larus.larkfeed.IFlowFeedApi";
        goto L8
    L930:
        return null;
    L491:
        if (r2.getName().equals("com.larus.voice_setting.INativeVoiceSettingPlatformEntryService") == false) goto L931;
        r3 = new HashSet();
        r3.add(new VoiceSettingPlatformEntryServiceImpl());
        r0 = "com.larus.voice_setting.INativeVoiceSettingPlatformEntryService";
        goto L8
    L931:
        return null;
    L494:
        if (r2.getName().equals("com.larus.bmhome.upload.sdk.api.ext.IImageUploadSdkBuilderFactory") == false) goto L932;
        r3 = new HashSet();
        r3.add(new ImageUploadSdkBuilderFactoryImpl());
        r0 = "com.larus.bmhome.upload.sdk.api.ext.IImageUploadSdkBuilderFactory";
        goto L8
    L932:
        return null;
    L497:
        if (r2.getName().equals("com.obric.assistant.common.spi.network.IObricBackgroundNetworkBlockService") == false) goto L933;
        r3 = new HashSet();
        r3.add(new ObricBackgroundNetworkBlockServiceImpl());
        r0 = "com.obric.assistant.common.spi.network.IObricBackgroundNetworkBlockService";
        goto L8
    L933:
        return null;
    L500:
        if (r2.getName().equals("com.larus.perfdegrade.api.IPerfDegradeAbility") == false) goto L934;
        r3 = new HashSet();
        r3.add(new PerfDegradeAbilityImpl());
        r0 = "com.larus.perfdegrade.api.IPerfDegradeAbility";
        goto L8
    L934:
        return null;
    L503:
        if (r2.getName().equals("com.larus.home.api.main.IInitPeriodService") == false) goto L935;
        r3 = new HashSet();
        r3.add(new InitPeriodServiceImpl());
        r0 = "com.larus.home.api.main.IInitPeriodService";
        goto L8
    L935:
        return null;
    L506:
        if (r2.getName().equals("com.larus.audioplayer.api.stream.IAudioSteamPlayerService") == false) goto L936;
        r3 = new HashSet();
        r3.add(new AudioStreamPlayerServiceImpl());
        r0 = "com.larus.audioplayer.api.stream.IAudioSteamPlayerService";
        goto L8
    L936:
        return null;
    L509:
        if (r2.getName().equals("com.larus.platform.api.IShortcutPlatformService") == false) goto L937;
        r3 = new HashSet();
        r3.add(new ShortcutPlatfomServiceImpl());
        r0 = "com.larus.platform.api.IShortcutPlatformService";
        goto L8
    L937:
        return null;
    L512:
        if (r2.getName().equals("com.larus.bmhome.bot.ltm.IChatBotLtmService") == false) goto L938;
        r3 = new HashSet();
        r3.add(new FlowSaaSBotLtmServiceImpl());
        r0 = "com.larus.bmhome.bot.ltm.IChatBotLtmService";
        goto L8
    L938:
        return null;
    L515:
        if (r2.getName().equals("com.obric.assistant.common.spi.security.IObricSecurityService") == false) goto L939;
        r3 = new HashSet();
        r3.add(new ObricSecurityServiceImpl());
        r0 = "com.obric.assistant.common.spi.security.IObricSecurityService";
        goto L8
    L939:
        return null;
    L518:
        if (r2.getName().equals("com.larus.audioplayer.api.utils.IMusicActionUtil") == false) goto L940;
        r3 = new HashSet();
        r3.add(new MusicActionUtilService());
        r0 = "com.larus.audioplayer.api.utils.IMusicActionUtil";
        goto L8
    L940:
        return null;
    L521:
        if (r2.getName().equals("com.larus.bootprotector.hotfix.IBootProtectorHotPatch") == false) goto L941;
        r3 = new HashSet();
        r3.add(new BootProtectorHotPatchImpl());
        r0 = "com.larus.bootprotector.hotfix.IBootProtectorHotPatch";
        goto L8
    L941:
        return null;
    L524:
        if (r2.getName().equals("com.obric.assistant.spi.share.IShareChannelExtraConfigurator") == false) goto L942;
        r3 = new HashSet();
        r3.add(new MainlandShareChannelExtraConfigurator());
        r0 = "com.obric.assistant.spi.share.IShareChannelExtraConfigurator";
        goto L8
    L942:
        return null;
    L527:
        if (r2.getName().equals("com.obric.assistant.trace.IObricTrace") == false) goto L943;
        r3 = new HashSet();
        r3.add(new ObricTraceImpl());
        r0 = "com.obric.assistant.trace.IObricTrace";
        goto L8
    L943:
        return null;
    L530:
        if (r2.getName().equals("com.larus.basic.experience.downgrade.api.IFlowDowngradeService") == false) goto L944;
        r3 = new HashSet();
        r3.add(new FlowDowngradeServiceImpl());
        r0 = "com.larus.basic.experience.downgrade.api.IFlowDowngradeService";
        goto L8
    L944:
        return null;
    L533:
        if (r2.getName().equals("com.larus.audio.sami.IFlowSamiFactory") == false) goto L945;
        r3 = new HashSet();
        r3.add(new FlowSamiFactory());
        r0 = "com.larus.audio.sami.IFlowSamiFactory";
        goto L8
    L945:
        return null;
    L536:
        if (r2.getName().equals("com.obric.assistant.spi.chat.IReceiveStreamMessageTypeOverrider") == false) goto L946;
        r3 = new HashSet();
        r3.add(new ObricReceiveStreamMessageTypeOverriderImpl());
        r0 = "com.obric.assistant.spi.chat.IReceiveStreamMessageTypeOverrider";
        goto L8
    L946:
        return null;
    L539:
        if (r2.getName().equals("com.larus.common.mssdk.api.SecurityService") == false) goto L947;
        r3 = new HashSet();
        r3.add(new SecurityServiceImpl());
        r0 = "com.larus.common.mssdk.api.SecurityService";
        goto L8
    L947:
        return null;
    L542:
        if (r2.getName().equals("com.larus.extension.aggregate_search_ui.api.IAggregateSearchUiService") == false) goto L948;
        r3 = new HashSet();
        r3.add(new AggregateSearchUiServiceImpl());
        r0 = "com.larus.extension.aggregate_search_ui.api.IAggregateSearchUiService";
        goto L8
    L948:
        return null;
    L545:
        if (r2.getName().equals("com.obric.aiagent.platform.IAIAgentPlatform") == false) goto L949;
        r3 = new HashSet();
        r3.add(new ObricAIAgentPlatformImpl());
        r0 = "com.obric.aiagent.platform.IAIAgentPlatform";
        goto L8
    L949:
        return null;
    L548:
        if (r2.getName().equals("com.larus.bmhome.chat.require.IMainBotService") == false) goto L950;
        r3 = new HashSet();
        r3.add(new MainBotServiceImpl());
        r0 = "com.larus.bmhome.chat.require.IMainBotService";
        goto L8
    L950:
        return null;
    L551:
        if (r2.getName().equals("com.larus.flowsdk.common.experiment.IFlowClientExperimentRegistry") == false) goto L951;
        r3 = new HashSet();
        r3.add(new BusinessECommerceImplFlowClientExperimentRegistry());
        r3.add(new BusinessOfficeDriveDriveSdkImplFlowClientExperimentRegistry());
        r3.add(new FlowSDKBusinessBrowserTakeoverImplFlowClientExperimentRegistry());
        r3.add(new FlowSDKBusinessChatImplFlowClientExperimentRegistry());
        r3.add(new FlowSDKBusinessChatGalleryApiFlowClientExperimentRegistry());
        r3.add(new FlowSDKBusinessChatGalleryImplFlowClientExperimentRegistry());
        r3.add(new FlowSDKBusinessChatJobImplFlowClientExperimentRegistry());
        r3.add(new FlowSDKBusinessContextWindowImplFlowClientExperimentRegistry());
        r3.add(new FlowSDKBusinessEnterpriseImplFlowClientExperimentRegistry());
        r3.add(new FlowSDKBusinessFlowSkillApiFlowClientExperimentRegistry());
        r3.add(new FlowSDKBusinessModulesChatCommonFlowClientExperimentRegistry());
        r3.add(new FlowSDKBusinessModulesInputImplFlowClientExperimentRegistry());
        r3.add(new FlowSDKBusinessModulesMessageTransferImplFlowClientExperimentRegistry());
        r3.add(new FlowSDKBusinessOfficeApiFlowClientExperimentRegistry());
        r3.add(new FlowSDKBusinessOfficeImplFlowClientExperimentRegistry());
        r3.add(new FlowSDKBusinessPlatformFlowClientExperimentRegistry());
        r3.add(new FlowSDKBusinessReachImplFlowClientExperimentRegistry());
        r0 = "com.larus.flowsdk.common.experiment.IFlowClientExperimentRegistry";
        goto L8
    L951:
        return null;
    L554:
        if (r2.getName().equals("com.larus.apm.api.IExtraParams") == false) goto L952;
        r3 = new HashSet();
        r3.add(new ExtraParamsImpl());
        r0 = "com.larus.apm.api.IExtraParams";
        goto L8
    L952:
        return null;
    L557:
        if (r2.getName().equals("com.larus.im.IInstantMessenger") == false) goto L953;
        r3 = new HashSet();
        r3.add(new InstantMessengerImpl());
        r0 = "com.larus.im.IInstantMessenger";
        goto L8
    L953:
        return null;
    L560:
        if (r2.getName().equals("com.larus.pipo.pay.api.IPipoPayService") == false) goto L954;
        r3 = new HashSet();
        r3.add(new PipoPayServiceImpl());
        r0 = "com.larus.pipo.pay.api.IPipoPayService";
        goto L8
    L954:
        return null;
    L563:
        if (r2.getName().equals("com.larus.office.card.doc.create.IOfficeCardDocCreateService") == false) goto L955;
        r3 = new HashSet();
        r3.add(new OfficeCardDocCreateServiceImpl());
        r0 = "com.larus.office.card.doc.create.IOfficeCardDocCreateService";
        goto L8
    L955:
        return null;
    L566:
        if (r2.getName().equals("com.larus.account.saas.coreapi.IAccountDispatchService") == false) goto L956;
        r3 = new HashSet();
        r3.add(new AccountDispatchService());
        r0 = "com.larus.account.saas.coreapi.IAccountDispatchService";
        goto L8
    L956:
        return null;
    L569:
        if (r2.getName().equals("com.obric.assistant.spi.wakeup.IWakeupLatencyTrackService") == false) goto L957;
        r3 = new HashSet();
        r3.add(new WakeupLatencyTrackImpl());
        r0 = "com.obric.assistant.spi.wakeup.IWakeupLatencyTrackService";
        goto L8
    L957:
        return null;
    L572:
        if (r2.getName().equals("com.larus.receive.contract.IReceiveCustomDiff") == false) goto L958;
        r3 = new HashSet();
        r3.add(new ObricReceiveCustomDiffImpl());
        r0 = "com.larus.receive.contract.IReceiveCustomDiff";
        goto L8
    L958:
        return null;
    L575:
        if (r2.getName().equals("com.obric.assistant.state.api.multitask.IObricInteractionProjectionService") == false) goto L959;
        r3 = new HashSet();
        r3.add(new InteractionProjectionServiceImpl());
        r0 = "com.obric.assistant.state.api.multitask.IObricInteractionProjectionService";
        goto L8
    L959:
        return null;
    L578:
        if (r2.getName().equals("com.larus.platform.model.comment.ICommentService") == false) goto L960;
        r3 = new HashSet();
        r3.add(new CommentServiceImpl());
        r0 = "com.larus.platform.model.comment.ICommentService";
        goto L8
    L960:
        return null;
    L581:
        if (r2.getName().equals("com.obric.assistant.frontier.IObricFrontierStatusMonitorService") == false) goto L961;
        r3 = new HashSet();
        r3.add(new ObricFrontierStatusMonitorService());
        r0 = "com.obric.assistant.frontier.IObricFrontierStatusMonitorService";
        goto L8
    L961:
        return null;
    L584:
        if (r2.getName().equals("com.bytedance.timon.clipboard.suite.ITMClipboardSuiteInitService") == false) goto L962;
        r3 = new HashSet();
        r3.add(new ClipboardSuiteInitServiceImpl());
        r0 = "com.bytedance.timon.clipboard.suite.ITMClipboardSuiteInitService";
        goto L8
    L962:
        return null;
    L587:
        if (r2.getName().equals("com.bytedance.locallife.ILocalLifeService") == false) goto L963;
        r3 = new HashSet();
        r3.add(new LocalLifeServiceImpl());
        r0 = "com.bytedance.locallife.ILocalLifeService";
        goto L8
    L963:
        return null;
    L590:
        if (r2.getName().equals("com.obric.assistant.performance.IObricCrashDumpHprofService") == false) goto L964;
        r3 = new HashSet();
        r3.add(new ObricCrashDumpHprofServiceImpl());
        r0 = "com.obric.assistant.performance.IObricCrashDumpHprofService";
        goto L8
    L964:
        return null;
    L593:
        if (r2.getName().equals("com.larus.platform.api.ISdkVideoFeedService") == false) goto L965;
        r3 = new HashSet();
        r3.add(new SdkVideoFeedProvider());
        r0 = "com.larus.platform.api.ISdkVideoFeedService";
        goto L8
    L965:
        return null;
    L596:
        if (r2.getName().equals("com.larus.aweme.api.video.service.IAwemeVideoFeedService") == false) goto L966;
        r3 = new HashSet();
        r3.add(new AwemeVideoFeed());
        r0 = "com.larus.aweme.api.video.service.IAwemeVideoFeedService";
        goto L8
    L966:
        return null;
    L599:
        if (r2.getName().equals("com.obric.assistant.system.IDeviceLockedStateService") == false) goto L967;
        r3 = new HashSet();
        r3.add(new DeviceLockedStateServiceImpl());
        r0 = "com.obric.assistant.system.IDeviceLockedStateService";
        goto L8
    L967:
        return null;
    L602:
        if (r2.getName().equals("com.larus.common.pollingconfig.api.PollingConfigApi") == false) goto L968;
        r3 = new HashSet();
        r3.add(new PollingConfigImpl());
        r0 = "com.larus.common.pollingconfig.api.PollingConfigApi";
        goto L8
    L968:
        return null;
    L605:
        if (r2.getName().equals("com.obric.assistant.reporter.IObricReporter") == false) goto L969;
        r3 = new HashSet();
        r3.add(new ObricReporterImpl());
        r0 = "com.obric.assistant.reporter.IObricReporter";
        goto L8
    L969:
        return null;
    L608:
        if (r2.getName().equals("com.larus.account.saas.coreapi.IAccountInitManager") == false) goto L970;
        r3 = new HashSet();
        r3.add(new AccountInitManager());
        r0 = "com.larus.account.saas.coreapi.IAccountInitManager";
        goto L8
    L970:
        return null;
    L611:
        if (r2.getName().equals("com.larus.platform.api.IBtmHostDependency") == false) goto L971;
        r3 = new HashSet();
        r3.add(new DoubaoBtmHostDependency());
        r0 = "com.larus.platform.api.IBtmHostDependency";
        goto L8
    L971:
        return null;
    L614:
        if (r2.getName().equals("com.obric.assistant.system.ITaskStackService") == false) goto L972;
        r3 = new HashSet();
        r3.add(new TaskStackServiceImpl());
        r0 = "com.obric.assistant.system.ITaskStackService";
        goto L8
    L972:
        return null;
    L617:
        if (r2.getName().equals("com.obric.assistant.spi.account.IObricXttTokenSyncService") == false) goto L973;
        r3 = new HashSet();
        r3.add(new ObricXttTokenSyncServiceImpl());
        r0 = "com.obric.assistant.spi.account.IObricXttTokenSyncService";
        goto L8
    L973:
        return null;
    L620:
        if (r2.getName().equals("com.larus.bootprotector.IBootProtectorBizCallback") == false) goto L974;
        r3 = new HashSet();
        r3.add(new BootProtectorDefaultBizCallback());
        r3.add(new MarkdownCrashRecovery());
        r0 = "com.larus.bootprotector.IBootProtectorBizCallback";
        goto L8
    L974:
        return null;
    L623:
        if (r2.getName().equals("com.larus.bmhome.share.api.IShareService") == false) goto L975;
        r3 = new HashSet();
        r3.add(new ShareImpl());
        r0 = "com.larus.bmhome.share.api.IShareService";
        goto L8
    L975:
        return null;
    L626:
        if (r2.getName().equals("com.larus.launch.ILaunchService") == false) goto L976;
        r3 = new HashSet();
        r3.add(new LaunchImpl());
        r0 = "com.larus.launch.ILaunchService";
        goto L8
    L976:
        return null;
    L629:
        if (r2.getName().equals("com.larus.audioplayer.api.music.IMusicPlayManager") == false) goto L977;
        r3 = new HashSet();
        r3.add(new MusicPlayManagerService());
        r0 = "com.larus.audioplayer.api.music.IMusicPlayManager";
        goto L8
    L977:
        return null;
    L632:
        if (r2.getName().equals("com.larus.receive.api.IReceiveIntentService") == false) goto L978;
        r3 = new HashSet();
        r3.add(new ReceiveIntentServiceImpl());
        r0 = "com.larus.receive.api.IReceiveIntentService";
        goto L8
    L978:
        return null;
    L635:
        if (r2.getName().equals("com.obric.assistant.spi.app.IObricAppService") == false) goto L979;
        r3 = new HashSet();
        r3.add(new ObricAppServiceImpl());
        r0 = "com.obric.assistant.spi.app.IObricAppService";
        goto L8
    L979:
        return null;
    L638:
        if (r2.getName().equals("com.larus.photopicker.api.PhotoPicker") == false) goto L980;
        r3 = new HashSet();
        r3.add(new PhotoPickerImpl());
        r0 = "com.larus.photopicker.api.PhotoPicker";
        goto L8
    L980:
        return null;
    L641:
        if (r2.getName().equals("com.larus.office.base.service.ISdkLifecycleV2") == false) goto L981;
        r3 = new HashSet();
        r3.add(new BitableLifecycleAdapter());
        r3.add(new DocLifecycleAdapter());
        r3.add(new DriveLifecycleAdapter());
        r3.add(new OfficeLifecycleAdapter());
        r3.add(new OfficeWatermarkLifecycleAdapter());
        r3.add(new MinutesSdkLifecycleAdapter());
        r3.add(new SheetLifecycleAdapter());
        r3.add(new SlidesLifecycleAdapter());
        r0 = "com.larus.office.base.service.ISdkLifecycleV2";
        goto L8
    L981:
        return null;
    L644:
        if (r2.getName().equals("com.larus.permission.api.IPermissionX") == false) goto L982;
        r3 = new HashSet();
        r3.add(new IPermissionXImpl());
        r0 = "com.larus.permission.api.IPermissionX";
        goto L8
    L982:
        return null;
    L647:
        if (r2.getName().equals("com.larus.platform.api.IXBridgeEventSender") == false) goto L983;
        r3 = new HashSet();
        r3.add(new XBridgeEventSender());
        r0 = "com.larus.platform.api.IXBridgeEventSender";
        goto L8
    L983:
        return null;
    L650:
        if (r2.getName().equals("com.obric.assistant.interaction.api.window.IBehavior") == false) goto L984;
        r3 = new HashSet();
        r3.add(new ActivityStartBehavior());
        r3.add(new AutoDelayedDestroyBehavior());
        r3.add(new AutoDismissOverlaysBehavior());
        r3.add(new ClearNotificationBehavior());
        r3.add(new ClearTaskBehavior());
        r3.add(new LockscreenBehavior());
        r3.add(new MainBotActivityResumeDestroyBehavior());
        r3.add(new MemoryPressureDestroyBehavior());
        r3.add(new RemoveTopChatActivityBehavior());
        r3.add(new ScreenRotationBehavior());
        r3.add(new TaskStackChangeBehavior());
        r3.add(new TurnScreenOnBehavior());
        r3.add(new WindowKeyguardBiometricSettingBehavior());
        r3.add(new WindowLaunchRecoveryBehavior());
        r3.add(new WindowMultimodalInputClearBehavior());
        r3.add(new SpecialInputBehavior());
        r3.add(new ListeningPresentationWindowBehavior());
        r0 = "com.obric.assistant.interaction.api.window.IBehavior";
        goto L8
    L984:
        return null;
    L653:
        if (r2.getName().equals("com.larus.bmhome.chat.messagetransfer.IDoubaoToLarkForwardLimitService") == false) goto L985;
        r3 = new HashSet();
        r3.add(new DoubaoToLarkForwardLimitServiceImpl());
        r0 = "com.larus.bmhome.chat.messagetransfer.IDoubaoToLarkForwardLimitService";
        goto L8
    L985:
        return null;
    L656:
        if (r2.getName().equals("com.larus.audio.IAudioService") == false) goto L986;
        r3 = new HashSet();
        r3.add(new AudioServiceImpl());
        r0 = "com.larus.audio.IAudioService";
        goto L8
    L986:
        return null;
    L659:
        if (r2.getName().equals("com.larus.common.zlinksdk.api.IZlinkService") == false) goto L987;
        r3 = new HashSet();
        r3.add(new ZlinkServiceImpl());
        r0 = "com.larus.common.zlinksdk.api.IZlinkService";
        goto L8
    L987:
        return null;
    L662:
        if (r2.getName().equals("com.larus.ivykit.anniex.IContainerRedirectService") == false) goto L988;
        r3 = new HashSet();
        r3.add(new ContainerRedirectServiceImpl());
        r0 = "com.larus.ivykit.anniex.IContainerRedirectService";
        goto L8
    L988:
        return null;
    L665:
        if (r2.getName().equals("com.obric.assistant.audio.IObricAudioStatusMonitorService") == false) goto L989;
        r3 = new HashSet();
        r3.add(new ObricAudioConnectionStatusMonitorService());
        r0 = "com.obric.assistant.audio.IObricAudioStatusMonitorService";
        goto L8
    L989:
        return null;
    L668:
        if (r2.getName().equals("com.larus.platform.model.video.business.IVideoFeedProvider") == false) goto L990;
        r3 = new HashSet();
        r3.add(new VideoFeedProviderImpl());
        r0 = "com.larus.platform.model.video.business.IVideoFeedProvider";
        goto L8
    L990:
        return null;
    L671:
        if (r2.getName().equals("com.larus.feedback.api.IFlowFeedbackService") == false) goto L991;
        r3 = new HashSet();
        r3.add(new FlowFeedbackServiceImpl());
        r0 = "com.larus.feedback.api.IFlowFeedbackService";
        goto L8
    L991:
        return null;
    L674:
        if (r2.getName().equals("com.bytedance.kmp.router.IRouterService") == false) goto L992;
        r3 = new HashSet();
        r3.add(new KmpRouterServiceImpl());
        r0 = "com.bytedance.kmp.router.IRouterService";
        goto L8
    L992:
        return null;
    L677:
        if (r2.getName().equals("com.larus.account.saas.coreapi.IAccountLoginService") == false) goto L993;
        r3 = new HashSet();
        r3.add(new AccountLoginService());
        r0 = "com.larus.account.saas.coreapi.IAccountLoginService";
        goto L8
    L993:
        return null;
    L680:
        if (r2.getName().equals("com.larus.bmhome.auth.ILaunchMetricService") == false) goto L994;
        r3 = new HashSet();
        r3.add(new LaunchMetricImpl());
        r0 = "com.larus.bmhome.auth.ILaunchMetricService";
        goto L8
    L994:
        return null;
    L683:
        if (r2.getName().equals("com.larus.power.state.api.PowerStateService") == false) goto L995;
        r3 = new HashSet();
        r3.add(new PowerStateServiceImpl());
        r0 = "com.larus.power.state.api.PowerStateService";
        goto L8
    L995:
        return null;
    L686:
        if (r2.getName().equals("com.obric.assistant.spi.share.IShareKeyConfigService") == false) goto L996;
        r3 = new HashSet();
        r3.add(new MainlandShareKeyConfigService());
        r0 = "com.obric.assistant.spi.share.IShareKeyConfigService";
        goto L8
    L996:
        return null;
    L689:
        if (r2.getName().equals("com.larus.common.mssdk.api.IAppOpsService") == false) goto L997;
        r3 = new HashSet();
        r3.add(new AppOpsService());
        r0 = "com.larus.common.mssdk.api.IAppOpsService";
        goto L8
    L997:
        return null;
    L692:
        if (r2.getName().equals("com.larus.chat.job.api.IChatJobFragmentFactory") == false) goto L998;
        r3 = new HashSet();
        r3.add(new ChatJobFragmentFactoryImpl());
        r0 = "com.larus.chat.job.api.IChatJobFragmentFactory";
        goto L8
    L998:
        return null;
    L695:
        if (r2.getName().equals("com.larus.platform.model.video.business.IVideoArticleProvider") == false) goto L999;
        r3 = new HashSet();
        r3.add(new VideoArticleProviderImpl());
        r0 = "com.larus.platform.model.video.business.IVideoArticleProvider";
        goto L8
    L999:
        return null;
    L698:
        if (r2.getName().equals("com.larus.superthread.api.FlowSuperThreadService") == false) goto L1000;
        r3 = new HashSet();
        r3.add(new SuperThreadServiceImpl());
        r0 = "com.larus.superthread.api.FlowSuperThreadService";
        goto L8
    L1000:
        return null;
    L701:
        if (r2.getName().equals("com.larus.business.multitask_management.api.IMultiTaskService") == false) goto L1001;
        r3 = new HashSet();
        r3.add(new MultiTaskServiceImpl());
        r0 = "com.larus.business.multitask_management.api.IMultiTaskService";
        goto L8
    L1001:
        return null;
    L704:
        if (r2.getName().equals("com.larus.reach.api.ReachBannerHost") == false) goto L1002;
        r3 = new HashSet();
        r3.add(new ChatBottomReachHost());
        r3.add(new ReachGlobalTopHost());
        r0 = "com.larus.reach.api.ReachBannerHost";
        goto L8
    L1002:
        return null;
    L707:
        if (r2.getName().equals("com.larus.applog.api.IMultiInstanceAppLogService") == false) goto L1003;
        r3 = new HashSet();
        r3.add(new MultiInstanceAppLogServiceImpl());
        r0 = "com.larus.applog.api.IMultiInstanceAppLogService";
        goto L8
    L1003:
        return null;
    L710:
        if (r2.getName().equals("com.ss.android.ugc.quota.IBDNetworkTagConfig") == false) goto L1004;
        r3 = new HashSet();
        r3.add(new BDNetworkTagConfigImpl());
        r0 = "com.ss.android.ugc.quota.IBDNetworkTagConfig";
        goto L8
    L1004:
        return null;
    L713:
        if (r2.getName().equals("com.obric.aiagent.assistant.idl.IFlowAppIntentIDLSPI") == false) goto L1005;
        r3 = new HashSet();
        r3.add(new AppIntentIDLStub());
        r0 = "com.obric.aiagent.assistant.idl.IFlowAppIntentIDLSPI";
        goto L8
    L1005:
        return null;
    L716:
        if (r2.getName().equals("com.larus.bmhome.auth.feature_config.model.IFeatureKitService") == false) goto L1006;
        r3 = new HashSet();
        r3.add(new FeatureKitImpl());
        r0 = "com.larus.bmhome.auth.feature_config.model.IFeatureKitService";
        goto L8
    L1006:
        return null;
    L719:
        if (r2.getName().equals("com.larus.account.saas.coreapi.IAccountSessionService") == false) goto L1007;
        r3 = new HashSet();
        r3.add(new AccountSessionService());
        r0 = "com.larus.account.saas.coreapi.IAccountSessionService";
        goto L8
    L1007:
        return null;
    L722:
        if (r2.getName().equals("com.obric.assistant.wakeup.statistics.api.IBluetoothScoEstablishStatisticsAPI") == false) goto L1008;
        r3 = new HashSet();
        r3.add(new BluetoothScoEstablishStatisticsImpl());
        r0 = "com.obric.assistant.wakeup.statistics.api.IBluetoothScoEstablishStatisticsAPI";
        goto L8
    L1008:
        return null;
    L725:
        if (r2.getName().equals("com.bytedance.flow_audio.api.service.common.IKMPTrackerService") == false) goto L1009;
        r3 = new HashSet();
        r3.add(new TrackerService());
        r0 = "com.bytedance.flow_audio.api.service.common.IKMPTrackerService";
        goto L8
    L1009:
        return null;
    L728:
        if (r2.getName().equals("com.larus.applog.api.IApplog") == false) goto L1010;
        r3 = new HashSet();
        r3.add(new ApplogImpl());
        r0 = "com.larus.applog.api.IApplog";
        goto L8
    L1010:
        return null;
    L731:
        if (r2.getName().equals("com.larus.multitask_management.api.spi.IMultiTaskFrontierService") == false) goto L1011;
        r3 = new HashSet();
        r3.add(new MultiTaskFrontierServiceImpl());
        r0 = "com.larus.multitask_management.api.spi.IMultiTaskFrontierService";
        goto L8
    L1011:
        return null;
    L734:
        if (r2.getName().equals("com.larus.account.saas.coreapi.IAccountManagementService") == false) goto L1012;
        r3 = new HashSet();
        r3.add(new AccountManagementService());
        r0 = "com.larus.account.saas.coreapi.IAccountManagementService";
        goto L8
    L1012:
        return null;
    L737:
        if (r2.getName().equals("com.larus.urlplayer.IAudioUrlPlayService") == false) goto L1013;
        r3 = new HashSet();
        r3.add(new AudioUrlPlayImpl());
        r0 = "com.larus.urlplayer.IAudioUrlPlayService";
        goto L8
    L1013:
        return null;
    L740:
        if (r2.getName().equals("com.bytedance.flow_audio.api.business.asr.source.FlowAsrFileAudioDataProvider") == false) goto L1014;
        r3 = new HashSet();
        r3.add(new AsrFileAudioDataProvider());
        r0 = "com.bytedance.flow_audio.api.business.asr.source.FlowAsrFileAudioDataProvider";
        goto L8
    L1014:
        return null;
    L743:
        if (r2.getName().equals("com.larus.voice_setting.INativeVoiceSettingService") == false) goto L1015;
        r3 = new HashSet();
        r3.add(new VoiceSettingServiceImpl());
        r0 = "com.larus.voice_setting.INativeVoiceSettingService";
        goto L8
    L1015:
        return null;
    L746:
        if (r2.getName().equals("com.obric.assistant.feedback.IObricSystemFeedback") == false) goto L1016;
        r3 = new HashSet();
        r3.add(new ObricSystemFeedbackImpl());
        r0 = "com.obric.assistant.feedback.IObricSystemFeedback";
        goto L8
    L1016:
        return null;
    L749:
        if (r2.getName().equals("com.obric.activeness.IObricActivenessMonitorService") == false) goto L1017;
        r3 = new HashSet();
        r3.add(new ObricActivenessMonitorServiceImpl());
        r0 = "com.obric.activeness.IObricActivenessMonitorService";
        goto L8
    L1017:
        return null;
    L752:
        if (r2.getName().equals("com.larus.flowsdk.security.api.FlowFileProtectionService") == false) goto L1018;
        r3 = new HashSet();
        r3.add(new FlowFileProtectionServiceImpl());
        r0 = "com.larus.flowsdk.security.api.FlowFileProtectionService";
        goto L8
    L1018:
        return null;
    L755:
        if (r2.getName().equals("com.bytedance.locallife.poi.IPoiFeedPlayerService") == false) goto L1019;
        r3 = new HashSet();
        r3.add(new PoiFeedPlayerServiceImpl());
        r0 = "com.bytedance.locallife.poi.IPoiFeedPlayerService";
        goto L8
    L1019:
        return null;
    L758:
        if (r2.getName().equals("com.larus.navigation.api.baidu.BaiduNaviService") == false) goto L1020;
        r3 = new HashSet();
        r3.add(new com.larus.navigation.impl.baidu.BaiduNaviServiceImpl());
        r0 = "com.larus.navigation.api.baidu.BaiduNaviService";
        goto L8
    L1020:
        return null;
    L761:
        if (r2.getName().equals("com.larus.bmhome.chat.api.IAuthModelService") == false) goto L1021;
        r3 = new HashSet();
        r3.add(new AuthViewModel());
        r0 = "com.larus.bmhome.chat.api.IAuthModelService";
        goto L8
    L1021:
        return null;
    L764:
        if (r2.getName().equals("com.obric.assistant.multiuser.api.IObricMultiUserService") == false) goto L1022;
        r3 = new HashSet();
        r3.add(new ObricMultiUserServiceImpl());
        r0 = "com.obric.assistant.multiuser.api.IObricMultiUserService";
        goto L8
    L1022:
        return null;
    L767:
        if (r2.getName().equals("com.larus.apm.api.IGodzilla") == false) goto L1023;
        r3 = new HashSet();
        r3.add(new GodzillaImpl());
        r0 = "com.larus.apm.api.IGodzilla";
        goto L8
    L1023:
        return null;
    }

    private Set getStaticServiceImplSetRealStub1(Class r2) {
        switch(r2.getName().hashCode()) {
            case -2135705261: goto L1271;
            case -2131928770: goto L1268;
            case -2120899756: goto L1265;
            case -2097483563: goto L1262;
            case -2094097622: goto L1259;
            case -2085431499: goto L1256;
            case -2066816065: goto L1253;
            case -2066224157: goto L1250;
            case -2062817289: goto L1247;
            case -2054012694: goto L1244;
            case -2053967284: goto L1241;
            case -2029880294: goto L1238;
            case -1994470027: goto L1235;
            case -1990371402: goto L1232;
            case -1980474687: goto L1229;
            case -1963376984: goto L1226;
            case -1952289749: goto L1223;
            case -1951826950: goto L1220;
            case -1942362411: goto L1217;
            case -1927986983: goto L1214;
            case -1910561307: goto L1211;
            case -1872362390: goto L1208;
            case -1862270395: goto L1205;
            case -1856311186: goto L1202;
            case -1852853852: goto L1199;
            case -1839658133: goto L1196;
            case -1827506087: goto L1193;
            case -1819643756: goto L1190;
            case -1810424474: goto L1187;
            case -1787177589: goto L1184;
            case -1772930888: goto L1181;
            case -1770754477: goto L1178;
            case -1770660597: goto L1175;
            case -1763635384: goto L1172;
            case -1760346682: goto L1169;
            case -1742279710: goto L1166;
            case -1730623406: goto L1163;
            case -1730273559: goto L1160;
            case -1700950436: goto L1157;
            case -1678261478: goto L1154;
            case -1672350436: goto L1151;
            case -1669907137: goto L1148;
            case -1669398587: goto L1145;
            case -1667294112: goto L1142;
            case -1663738657: goto L1139;
            case -1660195918: goto L1136;
            case -1654314805: goto L1133;
            case -1646057095: goto L1130;
            case -1642343718: goto L1127;
            case -1638708405: goto L1124;
            case -1626857626: goto L1121;
            case -1592006006: goto L1118;
            case -1568323663: goto L1115;
            case -1562927334: goto L1112;
            case -1560151109: goto L1109;
            case -1554322779: goto L1106;
            case -1546470126: goto L1103;
            case -1544686869: goto L1100;
            case -1541334195: goto L1097;
            case -1537610516: goto L1094;
            case -1537548942: goto L1091;
            case -1533531698: goto L1088;
            case -1532634484: goto L1085;
            case -1522778936: goto L1082;
            case -1521688678: goto L1079;
            case -1521454165: goto L1076;
            case -1486015631: goto L1073;
            case -1485737841: goto L1070;
            case -1482174954: goto L1067;
            case -1440195385: goto L1064;
            case -1420214558: goto L1061;
            case -1413199463: goto L1058;
            case -1412924983: goto L1055;
            case -1411335068: goto L1052;
            case -1390574968: goto L1049;
            case -1388130943: goto L1046;
            case -1361530436: goto L1043;
            case -1359176164: goto L1040;
            case -1354693781: goto L1037;
            case -1305658159: goto L1034;
            case -1305182431: goto L1031;
            case -1290446764: goto L1028;
            case -1284683404: goto L1025;
            case -1283548607: goto L1022;
            case -1280178145: goto L1019;
            case -1277551192: goto L1016;
            case -1267374852: goto L1013;
            case -1266788291: goto L1010;
            case -1266329929: goto L1007;
            case -1244858184: goto L1004;
            case -1236788349: goto L1001;
            case -1234204939: goto L998;
            case -1233363435: goto L995;
            case -1227566724: goto L992;
            case -1219945557: goto L989;
            case -1196531969: goto L986;
            case -1194808148: goto L983;
            case -1190611502: goto L980;
            case -1179030023: goto L977;
            case -1178495282: goto L974;
            case -1172929124: goto L971;
            case -1162538804: goto L968;
            case -1130743528: goto L965;
            case -1105721093: goto L962;
            case -1093910477: goto L959;
            case -1092373153: goto L956;
            case -1090728989: goto L953;
            case -1079109577: goto L950;
            case -1074333559: goto L947;
            case -1066186536: goto L944;
            case -1065737689: goto L941;
            case -1058467059: goto L938;
            case -1052601877: goto L935;
            case -1037756562: goto L932;
            case -1032790918: goto L929;
            case -1015468205: goto L926;
            case -1014873039: goto L923;
            case -1013996331: goto L920;
            case -1012848786: goto L917;
            case -975594662: goto L914;
            case -965490233: goto L911;
            case -953429453: goto L908;
            case -952615364: goto L905;
            case -950911620: goto L902;
            case -949443588: goto L899;
            case -922518018: goto L896;
            case -920697538: goto L893;
            case -892378171: goto L890;
            case -882375621: goto L887;
            case -878116883: goto L884;
            case -861799206: goto L881;
            case -850770334: goto L878;
            case -842912892: goto L875;
            case -828329002: goto L872;
            case -814281480: goto L869;
            case -806884317: goto L866;
            case -775158495: goto L863;
            case -773418898: goto L860;
            case -770192981: goto L857;
            case -726371143: goto L854;
            case -725248186: goto L851;
            case -723621112: goto L848;
            case -718642108: goto L845;
            case -717415349: goto L842;
            case -717124080: goto L839;
            case -716343418: goto L836;
            case -699329961: goto L833;
            case -699122158: goto L830;
            case -697316947: goto L827;
            case -696514880: goto L824;
            case -696438536: goto L821;
            case -686698581: goto L818;
            case -686103597: goto L815;
            case -605252540: goto L812;
            case -594196599: goto L809;
            case -593290696: goto L806;
            case -580044984: goto L803;
            case -575105251: goto L800;
            case -541154163: goto L797;
            case -539725956: goto L794;
            case -538369605: goto L791;
            case -532050866: goto L788;
            case -530452330: goto L785;
            case -520691330: goto L782;
            case -520612502: goto L779;
            case -514820097: goto L776;
            case -509975298: goto L773;
            case -508010128: goto L770;
            case -488965141: goto L767;
            case -466384168: goto L764;
            case -431761888: goto L761;
            case -429443635: goto L758;
            case -424896684: goto L755;
            case -405603167: goto L752;
            case -402458327: goto L749;
            case -395076556: goto L746;
            case -385102981: goto L743;
            case -364335646: goto L740;
            case -360824169: goto L737;
            case -355073772: goto L734;
            case -349004789: goto L731;
            case -341434991: goto L728;
            case -325929818: goto L725;
            case -321159462: goto L722;
            case -267815326: goto L719;
            case -254963767: goto L716;
            case -243180263: goto L713;
            case -240731871: goto L710;
            case -230625472: goto L707;
            case -222956560: goto L704;
            case -207547325: goto L701;
            case -205477180: goto L698;
            case -198523465: goto L695;
            case -189732549: goto L692;
            case -162447868: goto L689;
            case -158863879: goto L686;
            case -79138012: goto L683;
            case -59265275: goto L680;
            case -51354026: goto L677;
            case -36325472: goto L674;
            case -33601951: goto L671;
            case -31551216: goto L668;
            case -18639460: goto L665;
            case -17049931: goto L662;
            case 653239: goto L659;
            case 2493615: goto L656;
            case 14783547: goto L653;
            case 23852142: goto L650;
            case 32439524: goto L647;
            case 42993889: goto L644;
            case 62032363: goto L641;
            case 75649707: goto L638;
            case 81037948: goto L635;
            case 104492896: goto L632;
            case 108061468: goto L629;
            case 122866336: goto L626;
            case 132308800: goto L623;
            case 132811822: goto L620;
            case 134627017: goto L617;
            case 169574741: goto L614;
            case 181684762: goto L611;
            case 182428856: goto L608;
            case 188951827: goto L605;
            case 197626301: goto L602;
            case 215550315: goto L599;
            case 217420996: goto L596;
            case 225908080: goto L593;
            case 240814001: goto L590;
            case 274368124: goto L587;
            case 295448819: goto L584;
            case 305348146: goto L581;
            case 306185555: goto L578;
            case 317631011: goto L575;
            case 318425643: goto L572;
            case 334230635: goto L569;
            case 351053370: goto L566;
            case 368745660: goto L563;
            case 369010345: goto L560;
            case 384033221: goto L557;
            case 387029053: goto L554;
            case 391354262: goto L551;
            case 395552710: goto L548;
            case 400677579: goto L545;
            case 411356514: goto L542;
            case 414095160: goto L539;
            case 414431551: goto L536;
            case 419548044: goto L533;
            case 425048167: goto L530;
            case 440972134: goto L527;
            case 441252240: goto L524;
            case 458679629: goto L521;
            case 465470881: goto L518;
            case 470417463: goto L515;
            case 484803640: goto L512;
            case 519551985: goto L509;
            case 531551531: goto L506;
            case 547769267: goto L503;
            case 548921605: goto L500;
            case 550457386: goto L497;
            case 551703668: goto L494;
            case 554341076: goto L491;
            case 560184318: goto L488;
            case 563354433: goto L485;
            case 564581500: goto L482;
            case 578008229: goto L479;
            case 578142050: goto L476;
            case 579723823: goto L473;
            case 588013470: goto L470;
            case 608625279: goto L467;
            case 611510291: goto L464;
            case 617411114: goto L461;
            case 635149841: goto L458;
            case 650728761: goto L455;
            case 659624553: goto L452;
            case 671802834: goto L449;
            case 708608273: goto L446;
            case 709896443: goto L443;
            case 720020557: goto L440;
            case 725781529: goto L437;
            case 733609894: goto L434;
            case 740422859: goto L431;
            case 744125743: goto L428;
            case 746141940: goto L425;
            case 752280469: goto L422;
            case 756922154: goto L419;
            case 760417644: goto L416;
            case 762693990: goto L413;
            case 766030613: goto L410;
            case 784862142: goto L407;
            case 787671370: goto L404;
            case 793314947: goto L401;
            case 807452780: goto L398;
            case 811558270: goto L395;
            case 811710005: goto L392;
            case 818691460: goto L389;
            case 826186266: goto L386;
            case 848054525: goto L383;
            case 852138760: goto L380;
            case 868354915: goto L377;
            case 874671584: goto L374;
            case 877026686: goto L371;
            case 882340970: goto L368;
            case 883309897: goto L365;
            case 887853103: goto L362;
            case 890357529: goto L359;
            case 893602150: goto L356;
            case 898647388: goto L353;
            case 932828539: goto L350;
            case 943232628: goto L347;
            case 946495104: goto L344;
            case 959368139: goto L341;
            case 963047830: goto L338;
            case 963281079: goto L335;
            case 978802775: goto L332;
            case 981638030: goto L329;
            case 982489403: goto L326;
            case 1005832321: goto L323;
            case 1019658176: goto L320;
            case 1026571245: goto L317;
            case 1035011924: goto L314;
            case 1035105509: goto L311;
            case 1044098585: goto L308;
            case 1054965772: goto L305;
            case 1070252361: goto L302;
            case 1089207390: goto L299;
            case 1102306945: goto L296;
            case 1117958576: goto L293;
            case 1124703281: goto L290;
            case 1129916878: goto L287;
            case 1140532268: goto L284;
            case 1144220429: goto L281;
            case 1193293156: goto L278;
            case 1194263353: goto L275;
            case 1204031686: goto L272;
            case 1204283773: goto L269;
            case 1216906395: goto L266;
            case 1222729924: goto L263;
            case 1229310383: goto L260;
            case 1246571793: goto L257;
            case 1246824899: goto L254;
            case 1254468849: goto L251;
            case 1267648564: goto L248;
            case 1301813163: goto L245;
            case 1315829408: goto L242;
            case 1330237275: goto L239;
            case 1359323895: goto L236;
            case 1362884033: goto L233;
            case 1366600008: goto L230;
            case 1372357145: goto L227;
            case 1374245972: goto L224;
            case 1408365504: goto L221;
            case 1429207223: goto L218;
            case 1440068978: goto L215;
            case 1445235308: goto L212;
            case 1449146759: goto L209;
            case 1450665400: goto L206;
            case 1463580596: goto L203;
            case 1474927623: goto L200;
            case 1497196213: goto L197;
            case 1502318660: goto L194;
            case 1535351334: goto L191;
            case 1535371503: goto L188;
            case 1538629628: goto L185;
            case 1542525044: goto L182;
            case 1548625678: goto L179;
            case 1557505142: goto L176;
            case 1635142737: goto L173;
            case 1637356637: goto L170;
            case 1640791927: goto L167;
            case 1658895244: goto L164;
            case 1666866494: goto L161;
            case 1668799740: goto L158;
            case 1670921190: goto L155;
            case 1677988877: goto L152;
            case 1678211149: goto L149;
            case 1698137442: goto L146;
            case 1713713546: goto L143;
            case 1719074753: goto L140;
            case 1719360859: goto L137;
            case 1732861459: goto L134;
            case 1740450882: goto L131;
            case 1740859601: goto L128;
            case 1743456981: goto L125;
            case 1780210566: goto L122;
            case 1782053584: goto L119;
            case 1790449112: goto L116;
            case 1801244092: goto L113;
            case 1804946280: goto L110;
            case 1808068559: goto L107;
            case 1831101670: goto L104;
            case 1858048694: goto L101;
            case 1871290568: goto L98;
            case 1874371590: goto L95;
            case 1887765647: goto L92;
            case 1889205363: goto L89;
            case 1907606824: goto L86;
            case 1908914425: goto L83;
            case 1911945362: goto L80;
            case 1916679577: goto L77;
            case 1924369694: goto L74;
            case 1925940414: goto L71;
            case 1940384524: goto L68;
            case 1942194459: goto L65;
            case 1943027642: goto L62;
            case 1943721102: goto L59;
            case 1972364021: goto L56;
            case 1993768222: goto L53;
            case 1998453055: goto L50;
            case 2000368616: goto L47;
            case 2007637472: goto L44;
            case 2019001874: goto L41;
            case 2029515145: goto L38;
            case 2061612085: goto L35;
            case 2074674829: goto L32;
            case 2107888329: goto L29;
            case 2109000016: goto L26;
            case 2112198692: goto L23;
            case 2120306876: goto L20;
            case 2126532256: goto L17;
            case 2130874547: goto L14;
            case 2136808680: goto L11;
            case 2136826694: goto L6;
            default: goto L1696;
        };
    L1696:
        return null;
    L6:
        if (r2.getName().equals("com.larus.office.card.doc.download.IOfficeCardDocDownloadService") == false) goto L1273;
        HashSet r3 = new HashSet();
        r3.add(new OfficeCardDocDownloadServiceImpl());
        String r0 = "com.larus.office.card.doc.download.IOfficeCardDocDownloadService";
    L8:
        putStaticServiceImplSetCache(r0, r3);
        return r3;
    L1273:
        return null;
    L11:
        if (r2.getName().equals("com.obric.assistant.state.api.v2.IObricStateApi") == false) goto L1275;
        r3 = new HashSet();
        r3.add(new ObricStateImpl());
        r0 = "com.obric.assistant.state.api.v2.IObricStateApi";
        goto L8
    L1275:
        return null;
    L14:
        if (r2.getName().equals("com.obric.assistant.spi.login.ILogoutSceneInterceptor") == false) goto L1276;
        r3 = new HashSet();
        r3.add(new LogoutSceneInterceptorImpl());
        r0 = "com.obric.assistant.spi.login.ILogoutSceneInterceptor";
        goto L8
    L1276:
        return null;
    L17:
        if (r2.getName().equals("com.obric.assistant.audio.service.IObricRealtimeCallStateService") == false) goto L1277;
        r3 = new HashSet();
        r3.add(new ObricRealtimeCallStateService());
        r0 = "com.obric.assistant.audio.service.IObricRealtimeCallStateService";
        goto L8
    L1277:
        return null;
    L20:
        if (r2.getName().equals("com.obric.assistant.activation.presentation.contract.session.VoiceInteractionProxySessionFactory") == false) goto L1278;
        r3 = new HashSet();
        r3.add(new ObricVoiceInteractionProxySessionFactory());
        r0 = "com.obric.assistant.activation.presentation.contract.session.VoiceInteractionProxySessionFactory";
        goto L8
    L1278:
        return null;
    L23:
        if (r2.getName().equals("com.larus.account.base.provider.ILarkLoginProvider") == false) goto L1279;
        r3 = new HashSet();
        r3.add(new LarkLogin());
        r0 = "com.larus.account.base.provider.ILarkLoginProvider";
        goto L8
    L1279:
        return null;
    L26:
        if (r2.getName().equals("com.bytedance.flow.search.kmp.api.spi.SearchMixedFeedService") == false) goto L1280;
        r3 = new HashSet();
        r3.add(new KmpSearchMixedFeedServiceImpl());
        r0 = "com.bytedance.flow.search.kmp.api.spi.SearchMixedFeedService";
        goto L8
    L1280:
        return null;
    L29:
        if (r2.getName().equals("com.obric.assistant.attention.IObricAttentionService") == false) goto L1281;
        r3 = new HashSet();
        r3.add(new ObricAttentionServiceImpl());
        r0 = "com.obric.assistant.attention.IObricAttentionService";
        goto L8
    L1281:
        return null;
    L32:
        if (r2.getName().equals("com.larus.uaigc.service.ICreationSpringVenueService") == false) goto L1282;
        r3 = new HashSet();
        r3.add(new CreationSpringVenueServiceImpl());
        r0 = "com.larus.uaigc.service.ICreationSpringVenueService";
        goto L8
    L1282:
        return null;
    L35:
        if (r2.getName().equals("com.obric.aiagent.assistant.idl.IFlowCocreationReviewIDLSPI") == false) goto L1283;
        r3 = new HashSet();
        r3.add(new OmniLabelingFlowIDLStub());
        r0 = "com.obric.aiagent.assistant.idl.IFlowCocreationReviewIDLSPI";
        goto L8
    L1283:
        return null;
    L38:
        if (r2.getName().equals("com.larus.audio.ttsV2.ITtsClientService") == false) goto L1284;
        r3 = new HashSet();
        r3.add(new TtsClientServiceImpl());
        r0 = "com.larus.audio.ttsV2.ITtsClientService";
        goto L8
    L1284:
        return null;
    L41:
        if (r2.getName().equals("com.larus.bmhome.taskskill.service.IProjectListDataSource") == false) goto L1285;
        r3 = new HashSet();
        r3.add(new ProjectListDataSourceImpl());
        r0 = "com.larus.bmhome.taskskill.service.IProjectListDataSource";
        goto L8
    L1285:
        return null;
    L44:
        if (r2.getName().equals("com.larus.extension.aggregate_search_ui.api.ILarkAvatarViewProvider") == false) goto L1286;
        r3 = new HashSet();
        r3.add(new LarkAvatarViewProvider());
        r0 = "com.larus.extension.aggregate_search_ui.api.ILarkAvatarViewProvider";
        goto L8
    L1286:
        return null;
    L47:
        if (r2.getName().equals("com.larus.ugc.perf.api.IUgcPerfService") == false) goto L1287;
        r3 = new HashSet();
        r3.add(new UgcPerfServiceImpl());
        r0 = "com.larus.ugc.perf.api.IUgcPerfService";
        goto L8
    L1287:
        return null;
    L50:
        if (r2.getName().equals("com.larus.bmhome.audio.IRealtimeCallService") == false) goto L1288;
        r3 = new HashSet();
        r3.add(new RealtimeCallService());
        r0 = "com.larus.bmhome.audio.IRealtimeCallService";
        goto L8
    L1288:
        return null;
    L53:
        if (r2.getName().equals("com.obric.audio.tts.IObricChainTtsService") == false) goto L1289;
        r3 = new HashSet();
        r3.add(new ObricChainTtsServiceImpl());
        r0 = "com.obric.audio.tts.IObricChainTtsService";
        goto L8
    L1289:
        return null;
    L56:
        if (r2.getName().equals("com.obric.assistant.IObricSettingsApi") == false) goto L1290;
        r3 = new HashSet();
        r3.add(new ObricSettingsServiceImpl());
        r0 = "com.obric.assistant.IObricSettingsApi";
        goto L8
    L1290:
        return null;
    L59:
        if (r2.getName().equals("com.obric.assistant.spi.window.IChatWindowService") == false) goto L1291;
        r3 = new HashSet();
        r3.add(new WindowInteractionServiceImpl());
        r0 = "com.obric.assistant.spi.window.IChatWindowService";
        goto L8
    L1291:
        return null;
    L62:
        if (r2.getName().equals("com.larus.ivykit.web.TTWebViewService") == false) goto L1292;
        r3 = new HashSet();
        r3.add(new TTWebViewServiceImpl());
        r0 = "com.larus.ivykit.web.TTWebViewService";
        goto L8
    L1292:
        return null;
    L65:
        if (r2.getName().equals("com.obric.assistant.searchqa.IObricSearchQaLabelingService") == false) goto L1293;
        r3 = new HashSet();
        r3.add(new ObricSearchQaLabelingServiceImpl());
        r0 = "com.obric.assistant.searchqa.IObricSearchQaLabelingService";
        goto L8
    L1293:
        return null;
    L68:
        if (r2.getName().equals("com.larus.platform.spi.IAIChatUgcAIGCService") == false) goto L1294;
        r3 = new HashSet();
        r3.add(new AiChatUgcAIGCServiceImpl());
        r0 = "com.larus.platform.spi.IAIChatUgcAIGCService";
        goto L8
    L1294:
        return null;
    L71:
        if (r2.getName().equals("com.obric.assistant.interaction.api.IScreenState") == false) goto L1295;
        r3 = new HashSet();
        r3.add(new ScreenStateImpl());
        r0 = "com.obric.assistant.interaction.api.IScreenState";
        goto L8
    L1295:
        return null;
    L74:
        if (r2.getName().equals("com.larus.uaigc.service.ICreationSaveService") == false) goto L1296;
        r3 = new HashSet();
        r3.add(new CreationSaveServiceImpl());
        r0 = "com.larus.uaigc.service.ICreationSaveService";
        goto L8
    L1296:
        return null;
    L77:
        if (r2.getName().equals("com.larus.account.base.api.IMultiAccountProfileService") == false) goto L1297;
        r3 = new HashSet();
        r3.add(new MultiAccountProfileImpl());
        r0 = "com.larus.account.base.api.IMultiAccountProfileService";
        goto L8
    L1297:
        return null;
    L80:
        if (r2.getName().equals("com.obric.aiagent.assistant.idl.IFlowNetworkIDLSPI") == false) goto L1298;
        r3 = new HashSet();
        r3.add(new FlowNetworkIDLStub());
        r0 = "com.obric.aiagent.assistant.idl.IFlowNetworkIDLSPI";
        goto L8
    L1298:
        return null;
    L83:
        if (r2.getName().equals("com.obric.assistant.state.api.v2.core.IObricMsgInfoSaveService") == false) goto L1299;
        r3 = new HashSet();
        r3.add(new ObricMsgInfoSaveServiceImpl());
        r0 = "com.obric.assistant.state.api.v2.core.IObricMsgInfoSaveService";
        goto L8
    L1299:
        return null;
    L86:
        if (r2.getName().equals("com.larus.bmhome.chat.model.repo.INotifyService") == false) goto L1300;
        r3 = new HashSet();
        r3.add(new NotifyService());
        r0 = "com.larus.bmhome.chat.model.repo.INotifyService";
        goto L8
    L1300:
        return null;
    L89:
        if (r2.getName().equals("com.obric.assistant.spi.update.IObricUpdateSPIService") == false) goto L1301;
        r3 = new HashSet();
        r3.add(new ObricUpdateSPIImplService());
        r0 = "com.obric.assistant.spi.update.IObricUpdateSPIService";
        goto L8
    L1301:
        return null;
    L92:
        if (r2.getName().equals("com.obric.assistant.utils.IObricSensitiveErase") == false) goto L1302;
        r3 = new HashSet();
        r3.add(new ObricSensitiveEraseImpl());
        r0 = "com.obric.assistant.utils.IObricSensitiveErase";
        goto L8
    L1302:
        return null;
    L95:
        if (r2.getName().equals("com.larus.community.api.spi.ICommunityHostBehaviorProvider") == false) goto L1303;
        r3 = new HashSet();
        r3.add(new DoubaoCommunityHostBehaviorProvider());
        r0 = "com.larus.community.api.spi.ICommunityHostBehaviorProvider";
        goto L8
    L1303:
        return null;
    L98:
        if (r2.getName().equals("com.obric.assistant.spi.message.IObricForegroundWidgetSyncService") == false) goto L1304;
        r3 = new HashSet();
        r3.add(new ObricForegroundWidgetSyncServiceImpl());
        r0 = "com.obric.assistant.spi.message.IObricForegroundWidgetSyncService";
        goto L8
    L1304:
        return null;
    L101:
        if (r2.getName().equals("com.larus.avlink.api.IDoraAVLinkService") == false) goto L1305;
        r3 = new HashSet();
        r3.add(new DoraAVLinkServiceImpl());
        r0 = "com.larus.avlink.api.IDoraAVLinkService";
        goto L8
    L1305:
        return null;
    L104:
        if (r2.getName().equals("com.larus.commercecredit.api.ICommerceCreditService") == false) goto L1306;
        r3 = new HashSet();
        r3.add(new CommerceCreditService());
        r0 = "com.larus.commercecredit.api.ICommerceCreditService";
        goto L8
    L1306:
        return null;
    L107:
        if (r2.getName().equals("com.obric.assistant.login.IObricAccountInfoMonitorService") == false) goto L1307;
        r3 = new HashSet();
        r3.add(new ObricAccountInfoMonitorServiceImpl());
        r0 = "com.obric.assistant.login.IObricAccountInfoMonitorService";
        goto L8
    L1307:
        return null;
    L110:
        if (r2.getName().equals("com.obric.assistant.session.model.IObricChatSessionOperation") == false) goto L1308;
        r3 = new HashSet();
        r3.add(new ObricChatServiceEndpoint());
        r0 = "com.obric.assistant.session.model.IObricChatSessionOperation";
        goto L8
    L1308:
        return null;
    L113:
        if (r2.getName().equals("com.larus.minor.api.IMinorService") == false) goto L1309;
        r3 = new HashSet();
        r3.add(new MinorServiceImpl());
        r0 = "com.larus.minor.api.IMinorService";
        goto L8
    L1309:
        return null;
    L116:
        if (r2.getName().equals("com.larus.platform.api.IFlowOfficeThemeConfigProvider") == false) goto L1310;
        r3 = new HashSet();
        r3.add(new FlowOfficeThemeConfigProvider());
        r0 = "com.larus.platform.api.IFlowOfficeThemeConfigProvider";
        goto L8
    L1310:
        return null;
    L119:
        if (r2.getName().equals("com.larus.account.base.provider.IThirdPartyPlatformAuthorizationProvider") == false) goto L1311;
        r3 = new HashSet();
        r3.add(new LarkAuthorization());
        r0 = "com.larus.account.base.provider.IThirdPartyPlatformAuthorizationProvider";
        goto L8
    L1311:
        return null;
    L122:
        if (r2.getName().equals("com.larus.platform.spi.IAIChatConversationService") == false) goto L1312;
        r3 = new HashSet();
        r3.add(new AIChatConversationServiceImpl());
        r0 = "com.larus.platform.spi.IAIChatConversationService";
        goto L8
    L1312:
        return null;
    L125:
        if (r2.getName().equals("com.larus.voicecall.api.autostop.IAutoStopAsrServiceProvider") == false) goto L1313;
        r3 = new HashSet();
        r3.add(new AutoStopAsrServiceProviderImpl());
        r0 = "com.larus.voicecall.api.autostop.IAutoStopAsrServiceProvider";
        goto L8
    L1313:
        return null;
    L128:
        if (r2.getName().equals("com.larus.chat.gallery.api.IFindSimilarClickHandler") == false) goto L1314;
        r3 = new HashSet();
        r3.add(new FindSimilarClickHandlerImpl());
        r0 = "com.larus.chat.gallery.api.IFindSimilarClickHandler";
        goto L8
    L1314:
        return null;
    L131:
        if (r2.getName().equals("com.larus.uaigc.service.ICreationAvatarService") == false) goto L1315;
        r3 = new HashSet();
        r3.add(new CreationAvatarServiceImpl());
        r0 = "com.larus.uaigc.service.ICreationAvatarService";
        goto L8
    L1315:
        return null;
    L134:
        if (r2.getName().equals("com.enroll.audio.enroll.IBtHeadsetEnrollService") == false) goto L1316;
        r3 = new HashSet();
        r3.add(new BtHeadsetEnrollServiceImpl());
        r0 = "com.enroll.audio.enroll.IBtHeadsetEnrollService";
        goto L8
    L1316:
        return null;
    L137:
        if (r2.getName().equals("com.obric.assistant.spi.office.IOfficeSdkLazyInitSettingsService") == false) goto L1317;
        r3 = new HashSet();
        r3.add(new OfficeSdkLazyInitSettingsServiceImpl());
        r0 = "com.obric.assistant.spi.office.IOfficeSdkLazyInitSettingsService";
        goto L8
    L1317:
        return null;
    L140:
        if (r2.getName().equals("com.obric.aiagent.assistant.idl.IFlowPermissionIDLSPI") == false) goto L1318;
        r3 = new HashSet();
        r3.add(new FlowPermissionIDLStub());
        r0 = "com.obric.aiagent.assistant.idl.IFlowPermissionIDLSPI";
        goto L8
    L1318:
        return null;
    L143:
        if (r2.getName().equals("com.obric.assistant.interaction.api.keyguard.ISendMsgExtService") == false) goto L1319;
        r3 = new HashSet();
        r3.add(new SendMsgExtServiceImpl());
        r0 = "com.obric.assistant.interaction.api.keyguard.ISendMsgExtService";
        goto L8
    L1319:
        return null;
    L146:
        if (r2.getName().equals("com.obric.assistant.common.spi.IObricFeatureService") == false) goto L1320;
        r3 = new HashSet();
        r3.add(new ObricFeatureServiceImpl());
        r0 = "com.obric.assistant.common.spi.IObricFeatureService";
        goto L8
    L1320:
        return null;
    L149:
        if (r2.getName().equals("com.larus.bmhome.chat.block.base.config.IRichMediaCreationClickService") == false) goto L1321;
        r3 = new HashSet();
        r3.add(new RichMediaCreationClickServiceImpl());
        r0 = "com.larus.bmhome.chat.block.base.config.IRichMediaCreationClickService";
        goto L8
    L1321:
        return null;
    L152:
        if (r2.getName().equals("com.obric.assistant.state.api.multitask.producer.IObricAlarmTtsStateProducerService") == false) goto L1322;
        r3 = new HashSet();
        r3.add(new ObricAlarmTtsStateProducer());
        r0 = "com.obric.assistant.state.api.multitask.producer.IObricAlarmTtsStateProducerService";
        goto L8
    L1322:
        return null;
    L155:
        if (r2.getName().equals("com.ss.android.lark.biz.officesdk.im.message.menu.IDoubaoTextSelectService") == false) goto L1323;
        r3 = new HashSet();
        r3.add(new DouBaoTextSelectServiceImpl());
        r0 = "com.ss.android.lark.biz.officesdk.im.message.menu.IDoubaoTextSelectService";
        goto L8
    L1323:
        return null;
    L158:
        if (r2.getName().equals("com.larus.home.api.main.ILarkOfficeAppLinkInterceptorProvider") == false) goto L1324;
        r3 = new HashSet();
        r3.add(new LarkOfficeAppLinkInterceptorProvider());
        r0 = "com.larus.home.api.main.ILarkOfficeAppLinkInterceptorProvider";
        goto L8
    L1324:
        return null;
    L161:
        if (r2.getName().equals("com.obric.assistant.common.spi.IObricUIService") == false) goto L1325;
        r3 = new HashSet();
        r3.add(new ObricUIServiceImpl());
        r0 = "com.obric.assistant.common.spi.IObricUIService";
        goto L8
    L1325:
        return null;
    L164:
        if (r2.getName().equals("com.larus.login.api.ILoginInitService") == false) goto L1326;
        r3 = new HashSet();
        r3.add(new LoginInitServiceImpl());
        r0 = "com.larus.login.api.ILoginInitService";
        goto L8
    L1326:
        return null;
    L167:
        if (r2.getName().equals("com.larus.dora.api.IDoraObricService") == false) goto L1327;
        r3 = new HashSet();
        r3.add(new DoraObricServiceImpl());
        r0 = "com.larus.dora.api.IDoraObricService";
        goto L8
    L1327:
        return null;
    L170:
        if (r2.getName().equals("com.larus.bmhome.chat.zoom.IZoomInAnimationProvider") == false) goto L1328;
        r3 = new HashSet();
        r3.add(new CodeBlockZoomInAnimationImpl());
        r3.add(new ImageAnalysisZoomInAnimationImpl());
        r3.add(new ImageSearchZoomInAnimationImpl());
        r3.add(new SearchCotZoomInAnimationImpl());
        r0 = "com.larus.bmhome.chat.zoom.IZoomInAnimationProvider";
        goto L8
    L1328:
        return null;
    L173:
        if (r2.getName().equals("com.obric.assistant.session.model.IAssistActivateOperation") == false) goto L1329;
        r3 = new HashSet();
        r3.add(new AssistActivateEndPoint());
        r0 = "com.obric.assistant.session.model.IAssistActivateOperation";
        goto L8
    L1329:
        return null;
    L176:
        if (r2.getName().equals("com.larus.uaigc.service.ICreationAppletDetailProvider") == false) goto L1330;
        r3 = new HashSet();
        r3.add(new CreationAppletDetailProviderImpl());
        r0 = "com.larus.uaigc.service.ICreationAppletDetailProvider";
        goto L8
    L1330:
        return null;
    L179:
        if (r2.getName().equals("com.larus.dora.o.api.IDoraOUIService") == false) goto L1331;
        r3 = new HashSet();
        r3.add(new DoraOUIServiceImpl());
        r0 = "com.larus.dora.o.api.IDoraOUIService";
        goto L8
    L1331:
        return null;
    L182:
        if (r2.getName().equals("com.obric.assistant.session.model.IPowerKeyWakeupOperation") == false) goto L1332;
        r3 = new HashSet();
        r3.add(new PowerKeyWakeupEndpoint());
        r0 = "com.obric.assistant.session.model.IPowerKeyWakeupOperation";
        goto L8
    L1332:
        return null;
    L185:
        if (r2.getName().equals("com.obric.assistant.state.api.multitask.IVoiceCaptureStateProducerService") == false) goto L1333;
        r3 = new HashSet();
        r3.add(new VoiceCaptureStateProducer());
        r0 = "com.obric.assistant.state.api.multitask.IVoiceCaptureStateProducerService";
        goto L8
    L1333:
        return null;
    L188:
        if (r2.getName().equals("com.larus.feishu.office.im.api.FlowKeyboardConfigExtensionFactoryService") == false) goto L1334;
        r3 = new HashSet();
        r3.add(new FlowKeyboardConfigExtensionFactoryServiceImpl());
        r0 = "com.larus.feishu.office.im.api.FlowKeyboardConfigExtensionFactoryService";
        goto L8
    L1334:
        return null;
    L191:
        if (r2.getName().equals("com.larus.uaigc.service.ICreationAppletProfileProvider") == false) goto L1335;
        r3 = new HashSet();
        r3.add(new CreationAppletProfileProviderImpl());
        r0 = "com.larus.uaigc.service.ICreationAppletProfileProvider";
        goto L8
    L1335:
        return null;
    L194:
        if (r2.getName().equals("com.larus.avatar.api.IDigitalAvatarService") == false) goto L1336;
        r3 = new HashSet();
        r3.add(new DigitalAvatarServiceImpl());
        r0 = "com.larus.avatar.api.IDigitalAvatarService";
        goto L8
    L1336:
        return null;
    L197:
        if (r2.getName().equals("com.obric.assistant.spi.chat.IObricInteractionService") == false) goto L1337;
        r3 = new HashSet();
        r3.add(new ObricInteractionImpl());
        r0 = "com.obric.assistant.spi.chat.IObricInteractionService";
        goto L8
    L1337:
        return null;
    L200:
        if (r2.getName().equals("com.larus.uaigc.service.ICreationReportService") == false) goto L1338;
        r3 = new HashSet();
        r3.add(new CreationReportServiceImpl());
        r0 = "com.larus.uaigc.service.ICreationReportService";
        goto L8
    L1338:
        return null;
    L203:
        if (r2.getName().equals("com.larus.audioplayer.api.news.IUrlAudioPlayerService") == false) goto L1339;
        r3 = new HashSet();
        r3.add(new UrlAudioPlayerService());
        r0 = "com.larus.audioplayer.api.news.IUrlAudioPlayerService";
        goto L8
    L1339:
        return null;
    L206:
        if (r2.getName().equals("com.larus.audio.realtimecall.IRealtimeCallStrategy") == false) goto L1340;
        r3 = new HashSet();
        r3.add(new RealtimeCallStrategy());
        r0 = "com.larus.audio.realtimecall.IRealtimeCallStrategy";
        goto L8
    L1340:
        return null;
    L209:
        if (r2.getName().equals("com.larus.caijing_pay.api.ICJPayService") == false) goto L1341;
        r3 = new HashSet();
        r3.add(new CJPayServiceImpl());
        r0 = "com.larus.caijing_pay.api.ICJPayService";
        goto L8
    L1341:
        return null;
    L212:
        if (r2.getName().equals("com.larus.bmhome.bot.health.IChatBotHealthService") == false) goto L1342;
        r3 = new HashSet();
        r3.add(new BotHealthServiceImpl());
        r0 = "com.larus.bmhome.bot.health.IChatBotHealthService";
        goto L8
    L1342:
        return null;
    L215:
        if (r2.getName().equals("com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDLSPI") == false) goto L1343;
        r3 = new HashSet();
        r3.add(new VoiceInteractionIDLStub());
        r0 = "com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDLSPI";
        goto L8
    L1343:
        return null;
    L218:
        if (r2.getName().equals("com.larus.instruction.service.IInstructionService") == false) goto L1344;
        r3 = new HashSet();
        r3.add(new InstructionServiceImpl());
        r0 = "com.larus.instruction.service.IInstructionService";
        goto L8
    L1344:
        return null;
    L221:
        if (r2.getName().equals("com.larus.app.settings.api.IAppSettingsHostService") == false) goto L1345;
        r3 = new HashSet();
        r3.add(new DoubaoAppSettingsHostService());
        r0 = "com.larus.app.settings.api.IAppSettingsHostService";
        goto L8
    L1345:
        return null;
    L224:
        if (r2.getName().equals("com.obric.audio.enroll.IEnrollService") == false) goto L1346;
        r3 = new HashSet();
        r3.add(new EnrollServiceImpl());
        r0 = "com.obric.audio.enroll.IEnrollService";
        goto L8
    L1346:
        return null;
    L227:
        if (r2.getName().equals("com.larus.larkfeed.IOfficeSocialBridge") == false) goto L1347;
        r3 = new HashSet();
        r3.add(new OfficeSocialBridgeImpl());
        r0 = "com.larus.larkfeed.IOfficeSocialBridge";
        goto L8
    L1347:
        return null;
    L230:
        if (r2.getName().equals("com.larus.uaigc.service.ICreationUploadPolicyService") == false) goto L1348;
        r3 = new HashSet();
        r3.add(new CreationUploadPolicyServiceImpl());
        r0 = "com.larus.uaigc.service.ICreationUploadPolicyService";
        goto L8
    L1348:
        return null;
    L233:
        if (r2.getName().equals("com.larus.setting.api.ISettingApi") == false) goto L1349;
        r3 = new HashSet();
        r3.add(new SettingServiceImpl());
        r0 = "com.larus.setting.api.ISettingApi";
        goto L8
    L1349:
        return null;
    L236:
        if (r2.getName().equals("com.obric.assistant.interaction.base.feedback.IVibratorSmtFeedback") == false) goto L1350;
        r3 = new HashSet();
        r3.add(new VibratorSmtFeedbackImpl());
        r0 = "com.obric.assistant.interaction.base.feedback.IVibratorSmtFeedback";
        goto L8
    L1350:
        return null;
    L239:
        if (r2.getName().equals("com.larus.platform.api.IFlowProfileThemeConfigProvider") == false) goto L1351;
        r3 = new HashSet();
        r3.add(new FlowProfileThemeConfigProvider());
        r0 = "com.larus.platform.api.IFlowProfileThemeConfigProvider";
        goto L8
    L1351:
        return null;
    L242:
        if (r2.getName().equals("com.larus.bmhome.chat.quickreply.IMoaGrantingAppletService") == false) goto L1352;
        r3 = new HashSet();
        r3.add(new MoaGrantingAppletServiceImpl());
        r0 = "com.larus.bmhome.chat.quickreply.IMoaGrantingAppletService";
        goto L8
    L1352:
        return null;
    L245:
        if (r2.getName().equals("com.obric.aiagent.assistant.idl.IFlowMessageIDLSPI") == false) goto L1353;
        r3 = new HashSet();
        r3.add(new MessageIDLStub());
        r0 = "com.obric.aiagent.assistant.idl.IFlowMessageIDLSPI";
        goto L8
    L1353:
        return null;
    L248:
        if (r2.getName().equals("com.larus.platform.api.IFlowThemeConfigProvider") == false) goto L1354;
        r3 = new HashSet();
        r3.add(new FlowThemeConfigProvider());
        r0 = "com.larus.platform.api.IFlowThemeConfigProvider";
        goto L8
    L1354:
        return null;
    L251:
        if (r2.getName().equals("com.obric.assistant.spi.account.IObricAccountSPIService") == false) goto L1355;
        r3 = new HashSet();
        r3.add(new ObricAccountServiceImpl());
        r0 = "com.obric.assistant.spi.account.IObricAccountSPIService";
        goto L8
    L1355:
        return null;
    L254:
        if (r2.getName().equals("com.larus.bmhome.dora.IDoraEService") == false) goto L1356;
        r3 = new HashSet();
        r3.add(new DoraEServiceImpl());
        r0 = "com.larus.bmhome.dora.IDoraEService";
        goto L8
    L1356:
        return null;
    L257:
        if (r2.getName().equals("com.obric.assistant.common.spi.interaction.IObricMessagePopupService") == false) goto L1357;
        r3 = new HashSet();
        r3.add(new ObricMessagePopupServiceImpl());
        r0 = "com.obric.assistant.common.spi.interaction.IObricMessagePopupService";
        goto L8
    L1357:
        return null;
    L260:
        if (r2.getName().equals("com.obric.assistant.state.multitask.core.TaskFlowAsyncObserver") == false) goto L1358;
        r3 = new HashSet();
        r3.add(new ModeTimeoutCleanupObserver());
        r3.add(new ObricAutoHalfDuplexTimeoutCleanupObserver());
        r0 = "com.obric.assistant.state.multitask.core.TaskFlowAsyncObserver";
        goto L8
    L1358:
        return null;
    L263:
        if (r2.getName().equals("com.larus.sheet.sdk.api.ISheetSdkServiceV2") == false) goto L1359;
        r3 = new HashSet();
        r3.add(new SheetSdkServiceImplV2());
        r0 = "com.larus.sheet.sdk.api.ISheetSdkServiceV2";
        goto L8
    L1359:
        return null;
    L266:
        if (r2.getName().equals("com.larus.feishu.office.im.api.FlowInputMenuStateService") == false) goto L1360;
        r3 = new HashSet();
        r3.add(new FlowInputMenuStateServiceImpl());
        r0 = "com.larus.feishu.office.im.api.FlowInputMenuStateService";
        goto L8
    L1360:
        return null;
    L269:
        if (r2.getName().equals("com.larus.bmhome.instruction.suggest.IPromptSelectActionDispatcherService") == false) goto L1361;
        r3 = new HashSet();
        r3.add(new PromptSelectActionDispatcherServiceImpl());
        r0 = "com.larus.bmhome.instruction.suggest.IPromptSelectActionDispatcherService";
        goto L8
    L1361:
        return null;
    L272:
        if (r2.getName().equals("com.obric.assistant.session.model.ILostModeOperation") == false) goto L1362;
        r3 = new HashSet();
        r3.add(new LostModeEndpoint());
        r0 = "com.obric.assistant.session.model.ILostModeOperation";
        goto L8
    L1362:
        return null;
    L275:
        if (r2.getName().equals("com.larus.community.api.spi.ICommunityFeedRequestSourceFactory") == false) goto L1363;
        r3 = new HashSet();
        r3.add(new AICreationCommunityFeedRequestSourceFactory());
        r0 = "com.larus.community.api.spi.ICommunityFeedRequestSourceFactory";
        goto L8
    L1363:
        return null;
    L278:
        if (r2.getName().equals("com.larus.drive.sdk.api.IDriveSdkServiceV2") == false) goto L1364;
        r3 = new HashSet();
        r3.add(new DriveSdkServiceImplV2());
        r0 = "com.larus.drive.sdk.api.IDriveSdkServiceV2";
        goto L8
    L1364:
        return null;
    L281:
        if (r2.getName().equals("com.larus.feishu.office.im.api.FlowAdapterExtensionFactoryService") == false) goto L1365;
        r3 = new HashSet();
        r3.add(new FlowAdapterExtensionFactoryServiceImpl());
        r0 = "com.larus.feishu.office.im.api.FlowAdapterExtensionFactoryService";
        goto L8
    L1365:
        return null;
    L284:
        if (r2.getName().equals("com.larus.uaigc.service.ICreationMetadataService") == false) goto L1366;
        r3 = new HashSet();
        r3.add(new CreationMetadataServiceImpl());
        r0 = "com.larus.uaigc.service.ICreationMetadataService";
        goto L8
    L1366:
        return null;
    L287:
        if (r2.getName().equals("com.larus.bmhome.taskskill.service.TaskModeService") == false) goto L1367;
        r3 = new HashSet();
        r3.add(new TaskModeServiceImpl());
        r0 = "com.larus.bmhome.taskskill.service.TaskModeService";
        goto L8
    L1367:
        return null;
    L290:
        if (r2.getName().equals("com.bytedance.ai.api.AppletService") == false) goto L1368;
        r3 = new HashSet();
        r3.add(new MainlandAppletServiceImpl());
        r0 = "com.bytedance.ai.api.AppletService";
        goto L8
    L1368:
        return null;
    L293:
        if (r2.getName().equals("com.obric.assistant.audio.sessionstate.IAutoHalfDuplexModeService") == false) goto L1369;
        r3 = new HashSet();
        r3.add(new AutoHalfDuplexModeService());
        r0 = "com.obric.assistant.audio.sessionstate.IAutoHalfDuplexModeService";
        goto L8
    L1369:
        return null;
    L296:
        if (r2.getName().equals("com.larus.platform.spi.IAIChatControlTraceService") == false) goto L1370;
        r3 = new HashSet();
        r3.add(new AIChatControlTraceServiceImpl());
        r0 = "com.larus.platform.spi.IAIChatControlTraceService";
        goto L8
    L1370:
        return null;
    L299:
        if (r2.getName().equals("com.larus.home.api.main.IAICreationSidebarLauncher") == false) goto L1371;
        r3 = new HashSet();
        r3.add(new AICreationSidebarLauncher());
        r0 = "com.larus.home.api.main.IAICreationSidebarLauncher";
        goto L8
    L1371:
        return null;
    L302:
        if (r2.getName().equals("com.larus.bmhome.chat.thinkmode.IThinkModeMemoryReportService") == false) goto L1372;
        r3 = new HashSet();
        r3.add(new ThinkModeMemoryReportServiceImpl());
        r0 = "com.larus.bmhome.chat.thinkmode.IThinkModeMemoryReportService";
        goto L8
    L1372:
        return null;
    L305:
        if (r2.getName().equals("com.obric.assistant.onelogin.IObricOneLogin") == false) goto L1373;
        r3 = new HashSet();
        r3.add(new ObricOneLoginImpl());
        r0 = "com.obric.assistant.onelogin.IObricOneLogin";
        goto L8
    L1373:
        return null;
    L308:
        if (r2.getName().equals("com.larus.doc.sdk.api.IDocPermissionService") == false) goto L1374;
        r3 = new HashSet();
        r3.add(new DocPermissionServiceImpl());
        r0 = "com.larus.doc.sdk.api.IDocPermissionService";
        goto L8
    L1374:
        return null;
    L311:
        if (r2.getName().equals("com.larus.dora.o.api.IDoraODiaryService") == false) goto L1375;
        r3 = new HashSet();
        r3.add(new DoraODiaryServiceImpl());
        r0 = "com.larus.dora.o.api.IDoraODiaryService";
        goto L8
    L1375:
        return null;
    L314:
        if (r2.getName().equals("com.larus.bmhome.input.api.officemention.IOfficeMentionService") == false) goto L1376;
        r3 = new HashSet();
        r3.add(new OfficeMentionServiceImpl());
        r0 = "com.larus.bmhome.input.api.officemention.IOfficeMentionService";
        goto L8
    L1376:
        return null;
    L317:
        if (r2.getName().equals("com.larus.setting.api.IOrderMessageNotifySettingsProvider") == false) goto L1377;
        r3 = new HashSet();
        r3.add(new OrderMessageNotifySettingsProviderImpl());
        r0 = "com.larus.setting.api.IOrderMessageNotifySettingsProvider";
        goto L8
    L1377:
        return null;
    L320:
        if (r2.getName().equals("com.larus.account.base.provider.IThirdPartyPlatformLoginProvider") == false) goto L1378;
        r3 = new HashSet();
        r3.add(new DouyinLogin());
        r3.add(new WeixinLogin());
        r0 = "com.larus.account.base.provider.IThirdPartyPlatformLoginProvider";
        goto L8
    L1378:
        return null;
    L323:
        if (r2.getName().equals("com.larus.caijing_pay.api.ICJPayInitiator") == false) goto L1379;
        r3 = new HashSet();
        r3.add(new CJPayInitiator());
        r0 = "com.larus.caijing_pay.api.ICJPayInitiator";
        goto L8
    L1379:
        return null;
    L326:
        if (r2.getName().equals("com.obric.assistant.utils.IObricShowArgService") == false) goto L1380;
        r3 = new HashSet();
        r3.add(new ObricShowArgServiceImpl());
        r0 = "com.obric.assistant.utils.IObricShowArgService";
        goto L8
    L1380:
        return null;
    L329:
        if (r2.getName().equals("com.obric.assistant.interaction.api.IObricChatUILifecycleMonitor") == false) goto L1381;
        r3 = new HashSet();
        r3.add(new ObricChatUILifecycleMonitorImpl());
        r0 = "com.obric.assistant.interaction.api.IObricChatUILifecycleMonitor";
        goto L8
    L1381:
        return null;
    L332:
        if (r2.getName().equals("com.larus.platform.api.IFlowAccountThemeConfigProvider") == false) goto L1382;
        r3 = new HashSet();
        r3.add(new FlowAccountThemeConfigProvider());
        r0 = "com.larus.platform.api.IFlowAccountThemeConfigProvider";
        goto L8
    L1382:
        return null;
    L335:
        if (r2.getName().equals("com.obric.assistant.spi.launch.IObricLazyInitSettingsService") == false) goto L1383;
        r3 = new HashSet();
        r3.add(new ObricLazyInitSettingsServiceImpl());
        r0 = "com.obric.assistant.spi.launch.IObricLazyInitSettingsService";
        goto L8
    L1383:
        return null;
    L338:
        if (r2.getName().equals("com.larus.bmhome.chat.larkforward.IChatLarkForwardService") == false) goto L1384;
        r3 = new HashSet();
        r3.add(new ChatLarkForwardService());
        r0 = "com.larus.bmhome.chat.larkforward.IChatLarkForwardService";
        goto L8
    L1384:
        return null;
    L341:
        if (r2.getName().equals("com.larus.uaigc.service.IZLotteryService") == false) goto L1385;
        r3 = new HashSet();
        r3.add(new ZLotteryServiceImpl());
        r0 = "com.larus.uaigc.service.IZLotteryService";
        goto L8
    L1385:
        return null;
    L344:
        if (r2.getName().equals("com.larus.business.debug.api.ILiveTutorDebugService") == false) goto L1386;
        r3 = new HashSet();
        r3.add(new LiveTutorDebugServiceImpl());
        r0 = "com.larus.business.debug.api.ILiveTutorDebugService";
        goto L8
    L1386:
        return null;
    L347:
        if (r2.getName().equals("com.larus.platform.spi.IAIChatMessageConcatDelegate") == false) goto L1387;
        r3 = new HashSet();
        r3.add(new CreationMessageConcatDelegate());
        r0 = "com.larus.platform.spi.IAIChatMessageConcatDelegate";
        goto L8
    L1387:
        return null;
    L350:
        if (r2.getName().equals("com.larus.blockkit.IBlockKitExperimentProvider") == false) goto L1388;
        r3 = new HashSet();
        r3.add(new MainBotBlockKitExperimentProvider());
        r0 = "com.larus.blockkit.IBlockKitExperimentProvider";
        goto L8
    L1388:
        return null;
    L353:
        if (r2.getName().equals("com.larus.doc.api.IDocService") == false) goto L1389;
        r3 = new HashSet();
        r3.add(new DocServiceImpl());
        r0 = "com.larus.doc.api.IDocService";
        goto L8
    L1389:
        return null;
    L356:
        if (r2.getName().equals("com.larus.account.base.api.IDouyinHeartBeatService") == false) goto L1390;
        r3 = new HashSet();
        r3.add(new DouyinHeartBeatServiceImpl());
        r0 = "com.larus.account.base.api.IDouyinHeartBeatService";
        goto L8
    L1390:
        return null;
    L359:
        if (r2.getName().equals("com.obric.assistant.audio.service.IObricAssistantBaseService") == false) goto L1391;
        r3 = new HashSet();
        r3.add(new ObricAssistantBaseServiceImpl());
        r0 = "com.obric.assistant.audio.service.IObricAssistantBaseService";
        goto L8
    L1391:
        return null;
    L362:
        if (r2.getName().equals("com.larus.bmhome.input.api.IEnterKeyBehaviorService") == false) goto L1392;
        r3 = new HashSet();
        r3.add(new EnterKeyBehaviorServiceImpl());
        r0 = "com.larus.bmhome.input.api.IEnterKeyBehaviorService";
        goto L8
    L1392:
        return null;
    L365:
        if (r2.getName().equals("com.obric.assistant.agent.IObricSemanticApi") == false) goto L1393;
        r3 = new HashSet();
        r3.add(new ObricSemanticServiceImpl());
        r0 = "com.obric.assistant.agent.IObricSemanticApi";
        goto L8
    L1393:
        return null;
    L368:
        if (r2.getName().equals("com.obric.assistant.common.spi.alog.IObricAlogService") == false) goto L1394;
        r3 = new HashSet();
        r3.add(new ZeusObricAlogServiceImpl());
        r0 = "com.obric.assistant.common.spi.alog.IObricAlogService";
        goto L8
    L1394:
        return null;
    L371:
        if (r2.getName().equals("com.larus.office.base.service.IOfficeWatermarkSdkService") == false) goto L1395;
        r3 = new HashSet();
        r3.add(new OfficeWatermarkSdkService());
        r0 = "com.larus.office.base.service.IOfficeWatermarkSdkService";
        goto L8
    L1395:
        return null;
    L374:
        if (r2.getName().equals("com.larus.home.api.main.IHomeApiV2") == false) goto L1396;
        r3 = new HashSet();
        r3.add(new HomeServiceV2Impl());
        r0 = "com.larus.home.api.main.IHomeApiV2";
        goto L8
    L1396:
        return null;
    L377:
        if (r2.getName().equals("com.larus.bmhome.debug.IChatDebugExtItem") == false) goto L1397;
        r3 = new HashSet();
        r3.add(new ObricChatDebugExtItemImpl());
        r0 = "com.larus.bmhome.debug.IChatDebugExtItem";
        goto L8
    L1397:
        return null;
    L380:
        if (r2.getName().equals("com.obric.assistant.spi.home.IObricBottomTabSPIService") == false) goto L1398;
        r3 = new HashSet();
        r3.add(new ObricBottomTabServiceImpl());
        r0 = "com.obric.assistant.spi.home.IObricBottomTabSPIService";
        goto L8
    L1398:
        return null;
    L383:
        if (r2.getName().equals("com.larus.platform.api.IFlowDriveSdkService") == false) goto L1399;
        r3 = new HashSet();
        r3.add(new FlowDriveSdkServiceImpl());
        r0 = "com.larus.platform.api.IFlowDriveSdkService";
        goto L8
    L1399:
        return null;
    L386:
        if (r2.getName().equals("com.larus.voicecall.api.IVoiceCallConfigService") == false) goto L1400;
        r3 = new HashSet();
        r3.add(new IVoiceCallConfigServiceImpl());
        r0 = "com.larus.voicecall.api.IVoiceCallConfigService";
        goto L8
    L1400:
        return null;
    L389:
        if (r2.getName().equals("com.larus.voicecall.api.IRealtimeDebugService") == false) goto L1401;
        r3 = new HashSet();
        r3.add(new RealtimeDebugServiceImpl());
        r0 = "com.larus.voicecall.api.IRealtimeDebugService";
        goto L8
    L1401:
        return null;
    L392:
        if (r2.getName().equals("com.larus.bmhome.IChatAzerothService") == false) goto L1402;
        r3 = new HashSet();
        r3.add(new ChatAzerothServiceImpl());
        r0 = "com.larus.bmhome.IChatAzerothService";
        goto L8
    L1402:
        return null;
    L395:
        if (r2.getName().equals("com.obric.assistant.spi.rtc.IObricRTCCameraConfigService") == false) goto L1403;
        r3 = new HashSet();
        r3.add(new ObricRTCCameraConfigService());
        r0 = "com.obric.assistant.spi.rtc.IObricRTCCameraConfigService";
        goto L8
    L1403:
        return null;
    L398:
        if (r2.getName().equals("com.obric.assistant.interaction.api.ISystemKeySettings") == false) goto L1404;
        r3 = new HashSet();
        r3.add(new SystemKeySettingsImpl());
        r0 = "com.obric.assistant.interaction.api.ISystemKeySettings";
        goto L8
    L1404:
        return null;
    L401:
        if (r2.getName().equals("com.larus.canvas.service.ICanvasService") == false) goto L1405;
        r3 = new HashSet();
        r3.add(new CanvasServiceImpl());
        r0 = "com.larus.canvas.service.ICanvasService";
        goto L8
    L1405:
        return null;
    L404:
        if (r2.getName().equals("com.obric.assistant.session.model.IAiKeyOperation") == false) goto L1406;
        r3 = new HashSet();
        r3.add(new AiKeySessionEndpoint());
        r0 = "com.obric.assistant.session.model.IAiKeyOperation";
        goto L8
    L1406:
        return null;
    L407:
        if (r2.getName().equals("com.larus.feishu.office.im.api.FlowPlusExtensionFactoryService") == false) goto L1407;
        r3 = new HashSet();
        r3.add(new FlowPlusExtensionFactoryServiceImpl());
        r0 = "com.larus.feishu.office.im.api.FlowPlusExtensionFactoryService";
        goto L8
    L1407:
        return null;
    L410:
        if (r2.getName().equals("com.bytedance.ai.api.AppletV2Service") == false) goto L1408;
        r3 = new HashSet();
        r3.add(new AppletV2ServiceImpl());
        r0 = "com.bytedance.ai.api.AppletV2Service";
        goto L8
    L1408:
        return null;
    L413:
        if (r2.getName().equals("com.larus.luckydog.api.ILuckyDogService") == false) goto L1409;
        r3 = new HashSet();
        r3.add(new LuckyDogServiceImpl());
        r0 = "com.larus.luckydog.api.ILuckyDogService";
        goto L8
    L1409:
        return null;
    L416:
        if (r2.getName().equals("com.larus.commercemembership.api.ICommerceMembershipService") == false) goto L1410;
        r3 = new HashSet();
        r3.add(new CommerceMembershipService());
        r0 = "com.larus.commercemembership.api.ICommerceMembershipService";
        goto L8
    L1410:
        return null;
    L419:
        if (r2.getName().equals("com.larus.slides.sdk.api.ISlidesSdkProxyService") == false) goto L1411;
        r3 = new HashSet();
        r3.add(new SlidesSdkProxyServiceImpl());
        r0 = "com.larus.slides.sdk.api.ISlidesSdkProxyService";
        goto L8
    L1411:
        return null;
    L422:
        if (r2.getName().equals("com.larus.feishu.office.im.api.FlowAttachmentExtensionFactoryService") == false) goto L1412;
        r3 = new HashSet();
        r3.add(new FlowAttachmentExtensionFactoryServiceImpl());
        r0 = "com.larus.feishu.office.im.api.FlowAttachmentExtensionFactoryService";
        goto L8
    L1412:
        return null;
    L425:
        if (r2.getName().equals("com.obric.assistant.spi.common.IObricUtilService") == false) goto L1413;
        r3 = new HashSet();
        r3.add(new ObricUtilServiceImpl());
        r0 = "com.obric.assistant.spi.common.IObricUtilService";
        goto L8
    L1413:
        return null;
    L428:
        if (r2.getName().equals("com.bytedance.flow_audio.api.service.common.IKMPFlowAudioSceneService") == false) goto L1414;
        r3 = new HashSet();
        r3.add(new KMPFlowAudioSceneServiceImpl());
        r0 = "com.bytedance.flow_audio.api.service.common.IKMPFlowAudioSceneService";
        goto L8
    L1414:
        return null;
    L431:
        if (r2.getName().equals("com.obric.assistant.spi.interact.IObricInteractService") == false) goto L1415;
        r3 = new HashSet();
        r3.add(new ObricInteractServiceImpl());
        r0 = "com.obric.assistant.spi.interact.IObricInteractService";
        goto L8
    L1415:
        return null;
    L434:
        if (r2.getName().equals("com.larus.dora.o.api.IDoraOHealthService") == false) goto L1416;
        r3 = new HashSet();
        r3.add(new DoraOHealthServiceImpl());
        r0 = "com.larus.dora.o.api.IDoraOHealthService";
        goto L8
    L1416:
        return null;
    L437:
        if (r2.getName().equals("com.larus.search.api.LarkChatServiceProxy") == false) goto L1417;
        r3 = new HashSet();
        r3.add(new LarkChatServiceProxyImpl());
        r0 = "com.larus.search.api.LarkChatServiceProxy";
        goto L8
    L1417:
        return null;
    L440:
        if (r2.getName().equals("com.larus.platform.api.IFlowOfficeFileDownloadService") == false) goto L1418;
        r3 = new HashSet();
        r3.add(new FlowOfficeFileDownloadServiceImpl());
        r0 = "com.larus.platform.api.IFlowOfficeFileDownloadService";
        goto L8
    L1418:
        return null;
    L443:
        if (r2.getName().equals("com.larus.office.base.export.IOfficeDocExportDelegate") == false) goto L1419;
        r3 = new HashSet();
        r3.add(new OfficeDocExportDelegateImpl());
        r0 = "com.larus.office.base.export.IOfficeDocExportDelegate";
        goto L8
    L1419:
        return null;
    L446:
        if (r2.getName().equals("com.larus.init.IAbTestInitiator") == false) goto L1420;
        r3 = new HashSet();
        r3.add(new AbTestInitiator());
        r0 = "com.larus.init.IAbTestInitiator";
        goto L8
    L1420:
        return null;
    L449:
        if (r2.getName().equals("com.larus.common.venue.api.IFlowCommonVenueService") == false) goto L1421;
        r3 = new HashSet();
        r3.add(new FlowCommonVenueServiceImpl());
        r0 = "com.larus.common.venue.api.IFlowCommonVenueService";
        goto L8
    L1421:
        return null;
    L452:
        if (r2.getName().equals("com.larus.uaigc.service.ICreationResourceAccessService") == false) goto L1422;
        r3 = new HashSet();
        r3.add(new CreationResourceAccessServiceImpl());
        r0 = "com.larus.uaigc.service.ICreationResourceAccessService";
        goto L8
    L1422:
        return null;
    L455:
        if (r2.getName().equals("com.larus.home.api.feed.IFlowFeedProvider") == false) goto L1423;
        r3 = new HashSet();
        r3.add(new SideBarLarkFeedProvider());
        r0 = "com.larus.home.api.feed.IFlowFeedProvider";
        goto L8
    L1423:
        return null;
    L458:
        if (r2.getName().equals("com.larus.audio.audiov3.report.IAudioDeviceMonitorReporter") == false) goto L1424;
        r3 = new HashSet();
        r3.add(new AudioDeviceMonitorReporterImpl());
        r0 = "com.larus.audio.audiov3.report.IAudioDeviceMonitorReporter";
        goto L8
    L1424:
        return null;
    L461:
        if (r2.getName().equals("com.larus.account.base.provider.IVerificationCodeLoginProvider") == false) goto L1425;
        r3 = new HashSet();
        r3.add(new PhoneLogin());
        r0 = "com.larus.account.base.provider.IVerificationCodeLoginProvider";
        goto L8
    L1425:
        return null;
    L464:
        if (r2.getName().equals("com.obric.assistant.session.model.IDoraOperation") == false) goto L1426;
        r3 = new HashSet();
        r3.add(new DoraSessionEndpoint());
        r0 = "com.obric.assistant.session.model.IDoraOperation";
        goto L8
    L1426:
        return null;
    L467:
        if (r2.getName().equals("com.obric.audio.rtc_context.IObricDoraContextProvider") == false) goto L1427;
        r3 = new HashSet();
        r3.add(new ObricDoraContextProvider());
        r0 = "com.obric.audio.rtc_context.IObricDoraContextProvider";
        goto L8
    L1427:
        return null;
    L470:
        if (r2.getName().equals("com.larus.feishu.office.im.api.FlowComponentAdaptService") == false) goto L1428;
        r3 = new HashSet();
        r3.add(new FlowComponentAdaptServiceImpl());
        r0 = "com.larus.feishu.office.im.api.FlowComponentAdaptService";
        goto L8
    L1428:
        return null;
    L473:
        if (r2.getName().equals("com.obric.assistant.spi.audio.IObricMmtVideoSettingsService") == false) goto L1429;
        r3 = new HashSet();
        r3.add(new ObricMmtVideoSettingsServiceImpl());
        r0 = "com.obric.assistant.spi.audio.IObricMmtVideoSettingsService";
        goto L8
    L1429:
        return null;
    L476:
        if (r2.getName().equals("com.larus.chat.api.IChatCmdInterceptor") == false) goto L1430;
        r3 = new HashSet();
        r3.add(new ChatCmdInterceptorImpl());
        r0 = "com.larus.chat.api.IChatCmdInterceptor";
        goto L8
    L1430:
        return null;
    L479:
        if (r2.getName().equals("com.larus.bmhome.chat.component.bottom.multimodal.upload.FileUploadService") == false) goto L1431;
        r3 = new HashSet();
        r3.add(new FileUploadServiceImpl());
        r0 = "com.larus.bmhome.chat.component.bottom.multimodal.upload.FileUploadService";
        goto L8
    L1431:
        return null;
    L482:
        if (r2.getName().equals("com.larus.livetutor.api.ILiveTutorService") == false) goto L1432;
        r3 = new HashSet();
        r3.add(new LiveTutorServiceImpl());
        r0 = "com.larus.livetutor.api.ILiveTutorService";
        goto L8
    L1432:
        return null;
    L485:
        if (r2.getName().equals("com.larus.ugc.feed.api.spi.ITemplateCreationFragmentFactory") == false) goto L1433;
        r3 = new HashSet();
        r3.add(new TemplateCreationFragmentFactoryImpl());
        r0 = "com.larus.ugc.feed.api.spi.ITemplateCreationFragmentFactory";
        goto L8
    L1433:
        return null;
    L488:
        if (r2.getName().equals("com.obric.assistant.state.api.multitask.IObricRealtimeCallStateProducerService") == false) goto L1434;
        r3 = new HashSet();
        r3.add(new RealtimeCallStateProducer());
        r0 = "com.obric.assistant.state.api.multitask.IObricRealtimeCallStateProducerService";
        goto L8
    L1434:
        return null;
    L491:
        if (r2.getName().equals("com.larus.sheet.sdk.api.ISheetSdkProxyService") == false) goto L1435;
        r3 = new HashSet();
        r3.add(new SheetSdkProxyServiceImpl());
        r0 = "com.larus.sheet.sdk.api.ISheetSdkProxyService";
        goto L8
    L1435:
        return null;
    L494:
        if (r2.getName().equals("com.larus.account.saas.coreapi.IAccountFrontierMessageHandler") == false) goto L1436;
        r3 = new HashSet();
        r3.add(new SessionExpiredFrontierMessageHandler());
        r3.add(new MfaFrontierMessageHandler());
        r3.add(new KickOutNoticeFrontierMessageHandler());
        r0 = "com.larus.account.saas.coreapi.IAccountFrontierMessageHandler";
        goto L8
    L1436:
        return null;
    L497:
        if (r2.getName().equals("com.obric.assistant.state.api.v2.core.IObricDeviceStateService") == false) goto L1437;
        r3 = new HashSet();
        r3.add(new ObricDeviceStateServiceImpl());
        r0 = "com.obric.assistant.state.api.v2.core.IObricDeviceStateService";
        goto L8
    L1437:
        return null;
    L500:
        if (r2.getName().equals("com.larus.bmhome.chat.component.list.ChatMessageListPageObserver") == false) goto L1438;
        r3 = new HashSet();
        r3.add(new OfficeUrlPreviewMessageListObserver());
        r0 = "com.larus.bmhome.chat.component.list.ChatMessageListPageObserver";
        goto L8
    L1438:
        return null;
    L503:
        if (r2.getName().equals("com.obric.assistant.spi.dora.IDoraWakeupService") == false) goto L1439;
        r3 = new HashSet();
        r3.add(new DoraWakeupServiceImpl());
        r0 = "com.obric.assistant.spi.dora.IDoraWakeupService";
        goto L8
    L1439:
        return null;
    L506:
        if (r2.getName().equals("com.larus.office.card.urlpreview.IOfficeUrlPreviewActionInterceptorProvider") == false) goto L1440;
        r3 = new HashSet();
        r3.add(new OfficeUrlPreviewActionInterceptorProviderImpl());
        r0 = "com.larus.office.card.urlpreview.IOfficeUrlPreviewActionInterceptorProvider";
        goto L8
    L1440:
        return null;
    L509:
        if (r2.getName().equals("com.obric.assistant.voice.IWakeupTruthCaptureSwitchSyncService") == false) goto L1441;
        r3 = new HashSet();
        r3.add(new WakeupTruthCaptureSwitchSyncServiceImpl());
        r0 = "com.obric.assistant.voice.IWakeupTruthCaptureSwitchSyncService";
        goto L8
    L1441:
        return null;
    L512:
        if (r2.getName().equals("com.obric.assistant.audio.service.IObricAssistantForAudio") == false) goto L1442;
        r3 = new HashSet();
        r3.add(new ObricAssistantForAudioImpl());
        r0 = "com.obric.assistant.audio.service.IObricAssistantForAudio";
        goto L8
    L1442:
        return null;
    L515:
        if (r2.getName().equals("com.larus.platform.api.IFlowDocExportConfigProvider") == false) goto L1443;
        r3 = new HashSet();
        r3.add(new FlowDocExportConfigProvider());
        r0 = "com.larus.platform.api.IFlowDocExportConfigProvider";
        goto L8
    L1443:
        return null;
    L518:
        if (r2.getName().equals("com.obric.assistant.voice.IObricVoiceService") == false) goto L1444;
        r3 = new HashSet();
        r3.add(new ObricVoiceServiceImpl());
        r0 = "com.obric.assistant.voice.IObricVoiceService";
        goto L8
    L1444:
        return null;
    L521:
        if (r2.getName().equals("com.larus.account.base.provider.IGooglePhoneLoginProvider") == false) goto L1445;
        r3 = new HashSet();
        r3.add(new GooglePhoneInfo());
        r0 = "com.larus.account.base.provider.IGooglePhoneLoginProvider";
        goto L8
    L1445:
        return null;
    L524:
        if (r2.getName().equals("com.larus.bmhome.chat.bubble.floating.runtime.IBubbleBannerRuntimeService") == false) goto L1446;
        r3 = new HashSet();
        r3.add(new BubbleBannerRuntimeServiceImpl());
        r0 = "com.larus.bmhome.chat.bubble.floating.runtime.IBubbleBannerRuntimeService";
        goto L8
    L1446:
        return null;
    L527:
        if (r2.getName().equals("com.obric.assistant.IObricAvailableManager") == false) goto L1447;
        r3 = new HashSet();
        r3.add(new ObricAvailableManagerImpl());
        r0 = "com.obric.assistant.IObricAvailableManager";
        goto L8
    L1447:
        return null;
    L530:
        if (r2.getName().equals("com.larus.bmhome.input.api.IEnterKeyBehaviorHostService") == false) goto L1448;
        r3 = new HashSet();
        r3.add(new EnterKeyBehaviorServiceImpl());
        r0 = "com.larus.bmhome.input.api.IEnterKeyBehaviorHostService";
        goto L8
    L1448:
        return null;
    L533:
        if (r2.getName().equals("com.larus.bmhome.resource.access.ResourceNodeHandler") == false) goto L1449;
        r3 = new HashSet();
        r3.add(new CreationImageLocalDetectHandler());
        r3.add(new CreationImagePreprocessHandler());
        r3.add(new CreationImageRemoteDetectHandler());
        r3.add(new CreationImageRemoteDownloadHandler());
        r3.add(new CreationImageReviewHandler());
        r3.add(new CreationResourceCacheHandler());
        r3.add(new CreationResourcePostProcessHandler());
        r3.add(new CreationVideoPreprocessHandler());
        r0 = "com.larus.bmhome.resource.access.ResourceNodeHandler";
        goto L8
    L1449:
        return null;
    L536:
        if (r2.getName().equals("com.obric.aiagent.assistant.idl.IFlowFrontierIDLSPI") == false) goto L1450;
        r3 = new HashSet();
        r3.add(new FrontierIDLStub());
        r0 = "com.obric.aiagent.assistant.idl.IFlowFrontierIDLSPI";
        goto L8
    L1450:
        return null;
    L539:
        if (r2.getName().equals("com.obric.assistant.zeus.plugin.IZeusPluginService") == false) goto L1451;
        r3 = new HashSet();
        r3.add(new ZeusPluginServiceImpl());
        r0 = "com.obric.assistant.zeus.plugin.IZeusPluginService";
        goto L8
    L1451:
        return null;
    L542:
        if (r2.getName().equals("com.obric.assistant.session.model.IApplicationActivityOperation") == false) goto L1452;
        r3 = new HashSet();
        r3.add(new ApplicationActivityEndpoint());
        r0 = "com.obric.assistant.session.model.IApplicationActivityOperation";
        goto L8
    L1452:
        return null;
    L545:
        if (r2.getName().equals("com.larus.chat.gallery.api.IFindSimilarAvailabilityChecker") == false) goto L1453;
        r3 = new HashSet();
        r3.add(new FindSimilarAvailabilityCheckerImpl());
        r0 = "com.larus.chat.gallery.api.IFindSimilarAvailabilityChecker";
        goto L8
    L1453:
        return null;
    L548:
        if (r2.getName().equals("com.obric.aiagent.assistant.idl.IFlowUiIDLSPI") == false) goto L1454;
        r3 = new HashSet();
        r3.add(new FlowUIIDLStub());
        r0 = "com.obric.aiagent.assistant.idl.IFlowUiIDLSPI";
        goto L8
    L1454:
        return null;
    L551:
        if (r2.getName().equals("com.obric.assistant.IObricOmniLockscreenStateService") == false) goto L1455;
        r3 = new HashSet();
        r3.add(new ObricOmniLockscreenStateServiceImpl());
        r0 = "com.obric.assistant.IObricOmniLockscreenStateService";
        goto L8
    L1455:
        return null;
    L554:
        if (r2.getName().equals("com.larus.tts.ITtsReaderInterceptor") == false) goto L1456;
        r3 = new HashSet();
        r3.add(new AiNoteTtsInterceptor());
        r3.add(new DoraTtsReaderInterceptor());
        r3.add(new AutoReadTtsInterceptor());
        r3.add(new ManualReadTtsInterceptor());
        r3.add(new OnboardingTtsInterceptor());
        r3.add(new ContinuousTalkTtsInterceptor());
        r3.add(new ObricTtsReaderInterceptor());
        r0 = "com.larus.tts.ITtsReaderInterceptor";
        goto L8
    L1456:
        return null;
    L557:
        if (r2.getName().equals("com.larus.business.multitask_management.api.IMultiTaskInitEvent") == false) goto L1457;
        r3 = new HashSet();
        r3.add(new RecordMultiTaskInitEventImpl());
        r3.add(new AICreationMultiTaskInitEventImpl());
        r0 = "com.larus.business.multitask_management.api.IMultiTaskInitEvent";
        goto L8
    L1457:
        return null;
    L560:
        if (r2.getName().equals("com.obric.assistant.interaction.api.IObricApmService") == false) goto L1458;
        r3 = new HashSet();
        r3.add(new ObricApmServiceImpl());
        r0 = "com.obric.assistant.interaction.api.IObricApmService";
        goto L8
    L1458:
        return null;
    L563:
        if (r2.getName().equals("com.larus.agents.api.IOfficeTaskSettingsService") == false) goto L1459;
        r3 = new HashSet();
        r3.add(new OfficeTaskSettingsServiceImpl());
        r0 = "com.larus.agents.api.IOfficeTaskSettingsService";
        goto L8
    L1459:
        return null;
    L566:
        if (r2.getName().equals("com.larus.push.api.IPushService") == false) goto L1460;
        r3 = new HashSet();
        r3.add(new IPushServiceImpl());
        r0 = "com.larus.push.api.IPushService";
        goto L8
    L1460:
        return null;
    L569:
        if (r2.getName().equals("com.larus.bmhome.share.api.IConversationSharePanelService") == false) goto L1461;
        r3 = new HashSet();
        r3.add(new ConversationSharePanelService());
        r0 = "com.larus.bmhome.share.api.IConversationSharePanelService";
        goto L8
    L1461:
        return null;
    L572:
        if (r2.getName().equals("com.obric.assistant.account.IObricAccountService") == false) goto L1462;
        r3 = new HashSet();
        r3.add(new ObricAccountServiceImpl());
        r0 = "com.obric.assistant.account.IObricAccountService";
        goto L8
    L1462:
        return null;
    L575:
        if (r2.getName().equals("com.larus.xbridge.IXBridgeMethodRegistry") == false) goto L1463;
        r3 = new HashSet();
        r3.add(new OfficeCCMH5JSBRegistry());
        r0 = "com.larus.xbridge.IXBridgeMethodRegistry";
        goto L8
    L1463:
        return null;
    L578:
        if (r2.getName().equals("com.larus.dora.api.IObricEnvAuthSheetService") == false) goto L1464;
        r3 = new HashSet();
        r3.add(new ObricEnvAuthSheetServiceImpl());
        r0 = "com.larus.dora.api.IObricEnvAuthSheetService";
        goto L8
    L1464:
        return null;
    L581:
        if (r2.getName().equals("com.larus.account.base.provider.agegate.IAgeGateManagerInterface") == false) goto L1465;
        r3 = new HashSet();
        r3.add(new AgeGateManager());
        r0 = "com.larus.account.base.provider.agegate.IAgeGateManagerInterface";
        goto L8
    L1465:
        return null;
    L584:
        if (r2.getName().equals("com.larus.bmhome.chat.api.IMusicService") == false) goto L1466;
        r3 = new HashSet();
        r3.add(new MusicService());
        r0 = "com.larus.bmhome.chat.api.IMusicService";
        goto L8
    L1466:
        return null;
    L587:
        if (r2.getName().equals("com.larus.setting.api.ICustomAboutApp") == false) goto L1467;
        r3 = new HashSet();
        r3.add(new ObricAboutAppImpl());
        r0 = "com.larus.setting.api.ICustomAboutApp";
        goto L8
    L1467:
        return null;
    L590:
        if (r2.getName().equals("com.larus.e_commerce.api.IECommerceService") == false) goto L1468;
        r3 = new HashSet();
        r3.add(new ECommerceServiceImpl());
        r0 = "com.larus.e_commerce.api.IECommerceService";
        goto L8
    L1468:
        return null;
    L593:
        if (r2.getName().equals("com.obric.assistant.activity_stack.IObricActivityStackService") == false) goto L1469;
        r3 = new HashSet();
        r3.add(new ObricActivityStackServiceImpl());
        r0 = "com.obric.assistant.activity_stack.IObricActivityStackService";
        goto L8
    L1469:
        return null;
    L596:
        if (r2.getName().equals("com.obric.assistant.spi.audio.IObricWakeupTruthUploadService") == false) goto L1470;
        r3 = new HashSet();
        r3.add(new WakeupTruthUploadManager());
        r0 = "com.obric.assistant.spi.audio.IObricWakeupTruthUploadService";
        goto L8
    L1470:
        return null;
    L599:
        if (r2.getName().equals("com.obric.assistant.spi.audio.IObricEnrollTraceParamService") == false) goto L1471;
        r3 = new HashSet();
        r3.add(new ObricEnrollTraceParamServiceImpl());
        r0 = "com.obric.assistant.spi.audio.IObricEnrollTraceParamService";
        goto L8
    L1471:
        return null;
    L602:
        if (r2.getName().equals("com.larus.platform.api.IFlowOfficeExportService") == false) goto L1472;
        r3 = new HashSet();
        r3.add(new FlowOfficeExportServiceImpl());
        r0 = "com.larus.platform.api.IFlowOfficeExportService";
        goto L8
    L1472:
        return null;
    L605:
        if (r2.getName().equals("com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener") == false) goto L1473;
        r3 = new HashSet();
        r3.add(new BubbleBannerTracker());
        r3.add(new CommerceMembershipCTABubbleBannerSourceListener());
        r3.add(new GuidePcBubbleBannerSourceListener());
        r3.add(new MuseumExtensionBubbleBannerSourceListener());
        r3.add(new NotificationSwitchBubbleBannerSourceListener());
        r3.add(new ResendBubbleBannerSourceListener());
        r0 = "com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener";
        goto L8
    L1473:
        return null;
    L608:
        if (r2.getName().equals("com.larus.office.card.sheet.download.IOfficeCardSheetDownloadService") == false) goto L1474;
        r3 = new HashSet();
        r3.add(new OfficeCardSheetDownloadServiceImpl());
        r0 = "com.larus.office.card.sheet.download.IOfficeCardSheetDownloadService";
        goto L8
    L1474:
        return null;
    L611:
        if (r2.getName().equals("com.larus.bmhome.instruction.kmp.IKmpInstructionWidgetProvider") == false) goto L1475;
        r3 = new HashSet();
        r3.add(new CommandKmpInstructionWidgetProvider());
        r3.add(new AvatarButtonKmpInstructionWidgetProvider());
        r3.add(new DropFeatureSelectorKmpInstructionWidgetProvider());
        r3.add(new ImageListSelectorKmpInstructionWidgetProvider());
        r3.add(new ImageTemplateSelectorWithMoreKmpInstructionWidgetProvider());
        r3.add(new MsgInstructionKmpInstructionWidgetProvider());
        r3.add(new MusicTemplateSelectorKmpInstructionWidgetProvider());
        r0 = "com.larus.bmhome.instruction.kmp.IKmpInstructionWidgetProvider";
        goto L8
    L1475:
        return null;
    L614:
        if (r2.getName().equals("com.larus.xbridge.IXBridgeApi") == false) goto L1476;
        r3 = new HashSet();
        r3.add(new IXBridgeImpl());
        r0 = "com.larus.xbridge.IXBridgeApi";
        goto L8
    L1476:
        return null;
    L617:
        if (r2.getName().equals("com.larus.agents.api.IWebPageFetchService") == false) goto L1477;
        r3 = new HashSet();
        r3.add(new WebPageFetchServiceImpl());
        r0 = "com.larus.agents.api.IWebPageFetchService";
        goto L8
    L1477:
        return null;
    L620:
        if (r2.getName().equals("com.larus.slides.sdk.api.ISlidesSdkServiceV2") == false) goto L1478;
        r3 = new HashSet();
        r3.add(new SlidesSdkServiceImplV2());
        r0 = "com.larus.slides.sdk.api.ISlidesSdkServiceV2";
        goto L8
    L1478:
        return null;
    L623:
        if (r2.getName().equals("com.larus.av_call.service.IRealtimeCallConfigDependency") == false) goto L1479;
        r3 = new HashSet();
        r3.add(new RealtimeCallConfigProvider());
        r0 = "com.larus.av_call.service.IRealtimeCallConfigDependency";
        goto L8
    L1479:
        return null;
    L626:
        if (r2.getName().equals("com.larus.bot.api.IBotCreateService") == false) goto L1480;
        r3 = new HashSet();
        r3.add(new BotCreateServiceImpl());
        r0 = "com.larus.bot.api.IBotCreateService";
        goto L8
    L1480:
        return null;
    L629:
        if (r2.getName().equals("com.obric.assistant.audio.service.IObricAudioInteractService") == false) goto L1481;
        r3 = new HashSet();
        r3.add(new ObricAudioInteractService());
        r0 = "com.obric.assistant.audio.service.IObricAudioInteractService";
        goto L8
    L1481:
        return null;
    L632:
        if (r2.getName().equals("com.larus.feishu.office.im.api.FlowVoiceInputExtensionFactoryService") == false) goto L1482;
        r3 = new HashSet();
        r3.add(new FlowVoiceInputExtensionFactoryServiceImpl());
        r0 = "com.larus.feishu.office.im.api.FlowVoiceInputExtensionFactoryService";
        goto L8
    L1482:
        return null;
    L635:
        if (r2.getName().equals("com.larus.minutes.api.IMinutesService") == false) goto L1483;
        r3 = new HashSet();
        r3.add(new MinutesServiceImpl());
        r0 = "com.larus.minutes.api.IMinutesService";
        goto L8
    L1483:
        return null;
    L638:
        if (r2.getName().equals("com.larus.platform.api.IFlowOfficeWikiTokenResolver") == false) goto L1484;
        r3 = new HashSet();
        r3.add(new OfficeWikiTokenResolverServiceImpl());
        r0 = "com.larus.platform.api.IFlowOfficeWikiTokenResolver";
        goto L8
    L1484:
        return null;
    L641:
        if (r2.getName().equals("com.obric.assistant.interaction.api.IWindowEffects") == false) goto L1485;
        r3 = new HashSet();
        r3.add(new WindowEffectsImpl());
        r0 = "com.obric.assistant.interaction.api.IWindowEffects";
        goto L8
    L1485:
        return null;
    L644:
        if (r2.getName().equals("com.larus.uaigc.service.ICreationInstructionService") == false) goto L1486;
        r3 = new HashSet();
        r3.add(new CreationInstructionServiceImpl());
        r0 = "com.larus.uaigc.service.ICreationInstructionService";
        goto L8
    L1486:
        return null;
    L647:
        if (r2.getName().equals("com.larus.doc.sdk.api.IDocSdkServiceV2") == false) goto L1487;
        r3 = new HashSet();
        r3.add(new DocSdkServiceImplV2());
        r0 = "com.larus.doc.sdk.api.IDocSdkServiceV2";
        goto L8
    L1487:
        return null;
    L650:
        if (r2.getName().equals("com.larus.bmhome.chat.api.IRenderLiteService") == false) goto L1488;
        r3 = new HashSet();
        r3.add(new RenderLiteServiceImpl());
        r0 = "com.larus.bmhome.chat.api.IRenderLiteService";
        goto L8
    L1488:
        return null;
    L653:
        if (r2.getName().equals("com.larus.uaigc.service.IUgcAIGCService") == false) goto L1489;
        r3 = new HashSet();
        r3.add(new UgcAIGCServiceImpl());
        r0 = "com.larus.uaigc.service.IUgcAIGCService";
        goto L8
    L1489:
        return null;
    L656:
        if (r2.getName().equals("com.obric.assistant.appchange.IObricAppChangeListenerService") == false) goto L1490;
        r3 = new HashSet();
        r3.add(new ObricAppChangeListenerServiceImpl());
        r0 = "com.obric.assistant.appchange.IObricAppChangeListenerService";
        goto L8
    L1490:
        return null;
    L659:
        if (r2.getName().equals("com.larus.uaigc.music.ILyricsToSongBoxWrapper") == false) goto L1491;
        r3 = new HashSet();
        r3.add(new LyricsToSongBoxWrapper());
        r0 = "com.larus.uaigc.music.ILyricsToSongBoxWrapper";
        goto L8
    L1491:
        return null;
    L662:
        if (r2.getName().equals("com.larus.bmhome.instruction.IInstructionSubCreator") == false) goto L1492;
        r3 = new HashSet();
        r3.add(new CommandSubCreator());
        r3.add(new ButtonRouterSelectorSubCreator());
        r3.add(new CollaboratedMultiFeatureSelectorSubCreator());
        r3.add(new DropdownSelectorSubCreator());
        r3.add(new FeatureSelectorSubCreator());
        r3.add(new ReferenceImageUploadSubCreator());
        r3.add(new AvatarInstructionCreator());
        r3.add(new DropFeatureSelectorSubCreator());
        r3.add(new MsgInstructionSubCreator());
        r0 = "com.larus.bmhome.instruction.IInstructionSubCreator";
        goto L8
    L1492:
        return null;
    L665:
        if (r2.getName().equals("com.larus.search.api.IBrowserService") == false) goto L1493;
        r3 = new HashSet();
        r3.add(new SearchServiceImpl());
        r0 = "com.larus.search.api.IBrowserService";
        goto L8
    L1493:
        return null;
    L668:
        if (r2.getName().equals("com.obric.assistant.session.model.IVoiceWakeupOperation") == false) goto L1494;
        r3 = new HashSet();
        r3.add(new VoiceWakeupSessionEndpoint());
        r0 = "com.obric.assistant.session.model.IVoiceWakeupOperation";
        goto L8
    L1494:
        return null;
    L671:
        if (r2.getName().equals("com.obric.update.api.v2.IObricUpdateService") == false) goto L1495;
        r3 = new HashSet();
        r3.add(new ObricUpdateBitImpl());
        r0 = "com.obric.update.api.v2.IObricUpdateService";
        goto L8
    L1495:
        return null;
    L674:
        if (r2.getName().equals("com.larus.login.api.IBdauthApi") == false) goto L1496;
        r3 = new HashSet();
        r3.add(new BdauthServiceImpl());
        r0 = "com.larus.login.api.IBdauthApi";
        goto L8
    L1496:
        return null;
    L677:
        if (r2.getName().equals("com.larus.reach.api.ReachSceneLifecycleListener") == false) goto L1497;
        r3 = new HashSet();
        r3.add(new GeneralBannerReachLifecycleListener());
        r3.add(new RealtimeCallQuotaReachSceneHandler());
        r0 = "com.larus.reach.api.ReachSceneLifecycleListener";
        goto L8
    L1497:
        return null;
    L680:
        if (r2.getName().equals("com.larus.bmhome.chat.api.IBotInfoCacheService") == false) goto L1498;
        r3 = new HashSet();
        r3.add(new BotInfoCacheImpl());
        r0 = "com.larus.bmhome.chat.api.IBotInfoCacheService";
        goto L8
    L1498:
        return null;
    L683:
        if (r2.getName().equals("com.larus.bmhome.taskskill.service.IPcDevicePanelService") == false) goto L1499;
        r3 = new HashSet();
        r3.add(new PcDevicePanelServiceImpl());
        r0 = "com.larus.bmhome.taskskill.service.IPcDevicePanelService";
        goto L8
    L1499:
        return null;
    L686:
        if (r2.getName().equals("com.obric.assistant.spi.audio.IObricRealtimeCallExtService") == false) goto L1500;
        r3 = new HashSet();
        r3.add(new ObricRealtimeCallExtServiceImpl());
        r0 = "com.obric.assistant.spi.audio.IObricRealtimeCallExtService";
        goto L8
    L1500:
        return null;
    L689:
        if (r2.getName().equals("com.larus.voicecall.api.IRealtimeCallStateService") == false) goto L1501;
        r3 = new HashSet();
        r3.add(new RealtimeCallStateServiceImpl());
        r0 = "com.larus.voicecall.api.IRealtimeCallStateService";
        goto L8
    L1501:
        return null;
    L692:
        if (r2.getName().equals("com.larus.ivykit.forest.IObricForestService") == false) goto L1502;
        r3 = new HashSet();
        r3.add(new ObricGeckoResourceService());
        r0 = "com.larus.ivykit.forest.IObricForestService";
        goto L8
    L1502:
        return null;
    L695:
        if (r2.getName().equals("com.larus.platform.IFlowSdkService") == false) goto L1503;
        r3 = new HashSet();
        r3.add(new FlowSdkImpl());
        r0 = "com.larus.platform.IFlowSdkService";
        goto L8
    L1503:
        return null;
    L698:
        if (r2.getName().equals("com.larus.bmhome.chat.outerinput.IOuterChatInputProvider") == false) goto L1504;
        r3 = new HashSet();
        r3.add(new OuterChatInputProviderImpl());
        r0 = "com.larus.bmhome.chat.outerinput.IOuterChatInputProvider";
        goto L8
    L1504:
        return null;
    L701:
        if (r2.getName().equals("com.larus.platform.api.IPermissionHelperApi") == false) goto L1505;
        r3 = new HashSet();
        r3.add(new PermissionHelperImpl());
        r0 = "com.larus.platform.api.IPermissionHelperApi";
        goto L8
    L1505:
        return null;
    L704:
        if (r2.getName().equals("com.larus.uaigc.service.ICreationShareService") == false) goto L1506;
        r3 = new HashSet();
        r3.add(new CreationShareServiceImpl());
        r0 = "com.larus.uaigc.service.ICreationShareService";
        goto L8
    L1506:
        return null;
    L707:
        if (r2.getName().equals("com.larus.audio.observer.IGlobalAudioObserver") == false) goto L1507;
        r3 = new HashSet();
        r3.add(new GlobalAudioObserverImpl());
        r0 = "com.larus.audio.observer.IGlobalAudioObserver";
        goto L8
    L1507:
        return null;
    L710:
        if (r2.getName().equals("com.larus.profile.api.IProfileApi") == false) goto L1508;
        r3 = new HashSet();
        r3.add(new ProfileServiceImpl());
        r0 = "com.larus.profile.api.IProfileApi";
        goto L8
    L1508:
        return null;
    L713:
        if (r2.getName().equals("com.obric.update.api.v2.IObricUpdateSettingService") == false) goto L1509;
        r3 = new HashSet();
        r3.add(new ObricUpdateSettingServiceImpl());
        r0 = "com.obric.update.api.v2.IObricUpdateSettingService";
        goto L8
    L1509:
        return null;
    L716:
        if (r2.getName().equals("com.obric.assistant.cocreationreview.IObricCocreationReviewService") == false) goto L1510;
        r3 = new HashSet();
        r3.add(new CocreationReviewServiceImpl());
        r0 = "com.obric.assistant.cocreationreview.IObricCocreationReviewService";
        goto L8
    L1510:
        return null;
    L719:
        if (r2.getName().equals("com.obric.assistant.spi.security.privacypermission.IObricPrivacyAndPermissionUiService") == false) goto L1511;
        r3 = new HashSet();
        r3.add(new ObricPrivacyAndPermissionUiServiceImpl());
        r0 = "com.obric.assistant.spi.security.privacypermission.IObricPrivacyAndPermissionUiService";
        goto L8
    L1511:
        return null;
    L722:
        if (r2.getName().equals("com.larus.photopicker.v2.api.IInnerPhotoPickerService") == false) goto L1512;
        r3 = new HashSet();
        r3.add(new InnerInnerPhotoPickerServiceImpl());
        r0 = "com.larus.photopicker.v2.api.IInnerPhotoPickerService";
        goto L8
    L1512:
        return null;
    L725:
        if (r2.getName().equals("com.obric.assistant.common.spi.toast.IToastHelper") == false) goto L1513;
        r3 = new HashSet();
        r3.add(new ToastHelperImpl());
        r0 = "com.obric.assistant.common.spi.toast.IToastHelper";
        goto L8
    L1513:
        return null;
    L728:
        if (r2.getName().equals("com.larus.setting.api.trace.ISettingTrackApi") == false) goto L1514;
        r3 = new HashSet();
        r3.add(new SettingTrace());
        r0 = "com.larus.setting.api.trace.ISettingTrackApi";
        goto L8
    L1514:
        return null;
    L731:
        if (r2.getName().equals("com.obric.assistant.common.spi.IObricSlardarConfigService") == false) goto L1515;
        r3 = new HashSet();
        r3.add(new ObricSlardarConfigServiceImpl());
        r0 = "com.obric.assistant.common.spi.IObricSlardarConfigService";
        goto L8
    L1515:
        return null;
    L734:
        if (r2.getName().equals("com.larus.bmhome.praise.IAiChatPraiseTriggerService") == false) goto L1516;
        r3 = new HashSet();
        r3.add(new AiChatPraiseTriggerServiceImpl());
        r0 = "com.larus.bmhome.praise.IAiChatPraiseTriggerService";
        goto L8
    L1516:
        return null;
    L737:
        if (r2.getName().equals("com.obric.assistant.window.materials.services.IWindowMaterialService") == false) goto L1517;
        r3 = new HashSet();
        r3.add(new OWindowMaterialServiceImpl());
        r0 = "com.obric.assistant.window.materials.services.IWindowMaterialService";
        goto L8
    L1517:
        return null;
    L740:
        if (r2.getName().equals("com.obric.aiagent.assistant.idl.IFlowAppStateIDLSPI") == false) goto L1518;
        r3 = new HashSet();
        r3.add(new AppStateIDLStub());
        r0 = "com.obric.aiagent.assistant.idl.IFlowAppStateIDLSPI";
        goto L8
    L1518:
        return null;
    L743:
        if (r2.getName().equals("com.larus.bmhome.chat.bubble.floating.datasource.IBubbleBannerDataService") == false) goto L1519;
        r3 = new HashSet();
        r3.add(new BubbleBannerDataServiceImpl());
        r0 = "com.larus.bmhome.chat.bubble.floating.datasource.IBubbleBannerDataService";
        goto L8
    L1519:
        return null;
    L746:
        if (r2.getName().equals("com.larus.platform.spi.IChatTraceService") == false) goto L1520;
        r3 = new HashSet();
        r3.add(new ChatTraceServiceImpl());
        r0 = "com.larus.platform.spi.IChatTraceService";
        goto L8
    L1520:
        return null;
    L749:
        if (r2.getName().equals("com.larus.uaigc.service.ICreationAiEditService") == false) goto L1521;
        r3 = new HashSet();
        r3.add(new CreationAiEditServiceImpl());
        r0 = "com.larus.uaigc.service.ICreationAiEditService";
        goto L8
    L1521:
        return null;
    L752:
        if (r2.getName().equals("com.obric.aiagent.rom.compat.api.IFeatureSettingsConfig") == false) goto L1522;
        r3 = new HashSet();
        r3.add(new FeatureSettingsConfigImpl());
        r0 = "com.obric.aiagent.rom.compat.api.IFeatureSettingsConfig";
        goto L8
    L1522:
        return null;
    L755:
        if (r2.getName().equals("com.larus.feishu.office.im.api.FlowFastAlbumAbilityFactoryService") == false) goto L1523;
        r3 = new HashSet();
        r3.add(new FlowFastAlbumAbilityFactoryServiceImpl());
        r0 = "com.larus.feishu.office.im.api.FlowFastAlbumAbilityFactoryService";
        goto L8
    L1523:
        return null;
    L758:
        if (r2.getName().equals("com.obric.assistant.IRemoteCard") == false) goto L1524;
        r3 = new HashSet();
        r3.add(new RemoteCardImpl());
        r0 = "com.obric.assistant.IRemoteCard";
        goto L8
    L1524:
        return null;
    L761:
        if (r2.getName().equals("com.obric.assistant.agent.IObricAgentApi") == false) goto L1525;
        r3 = new HashSet();
        r3.add(new ObricAgentServiceImpl());
        r0 = "com.obric.assistant.agent.IObricAgentApi";
        goto L8
    L1525:
        return null;
    L764:
        if (r2.getName().equals("com.larus.bmhome.chat.api.IWidgetRenderService") == false) goto L1526;
        r3 = new HashSet();
        r3.add(new WidgetRenderServiceImpl());
        r0 = "com.larus.bmhome.chat.api.IWidgetRenderService";
        goto L8
    L1526:
        return null;
    L767:
        if (r2.getName().equals("com.larus.abtest.api.IGlobalExposureStarter") == false) goto L1527;
        r3 = new HashSet();
        r3.add(new GlobalExposureConfig());
        r3.add(new GlobalExposureTest());
        r0 = "com.larus.abtest.api.IGlobalExposureStarter";
        goto L8
    L1527:
        return null;
    L770:
        if (r2.getName().equals("com.obric.assistant.settings.IObricPersonalContextSettingApi") == false) goto L1528;
        r3 = new HashSet();
        r3.add(new ObricPersonalContextSettingServiceImpl());
        r0 = "com.obric.assistant.settings.IObricPersonalContextSettingApi";
        goto L8
    L1528:
        return null;
    L773:
        if (r2.getName().equals("com.obric.assistant.spi.audio.IObricContinuousTalkService") == false) goto L1529;
        r3 = new HashSet();
        r3.add(new ObricContinuousTalkServiceImpl());
        r0 = "com.obric.assistant.spi.audio.IObricContinuousTalkService";
        goto L8
    L1529:
        return null;
    L776:
        if (r2.getName().equals("com.larus.audio.ttsV2.IHeadsetDetectorService") == false) goto L1530;
        r3 = new HashSet();
        r3.add(new HeadsetDetectorServiceImpl());
        r0 = "com.larus.audio.ttsV2.IHeadsetDetectorService";
        goto L8
    L1530:
        return null;
    L779:
        if (r2.getName().equals("com.obric.assistant.spi.audio.IObricWakeupAudioCaptureService") == false) goto L1531;
        r3 = new HashSet();
        r3.add(new WakeupAudioCaptureServiceImpl());
        r0 = "com.obric.assistant.spi.audio.IObricWakeupAudioCaptureService";
        goto L8
    L1531:
        return null;
    L782:
        if (r2.getName().equals("com.larus.platform.spi.IAIChatUploadMediaService") == false) goto L1532;
        r3 = new HashSet();
        r3.add(new AIChatUploadMediaServiceImpl());
        r0 = "com.larus.platform.spi.IAIChatUploadMediaService";
        goto L8
    L1532:
        return null;
    L785:
        if (r2.getName().equals("com.larus.live.api.ILiveService") == false) goto L1533;
        r3 = new HashSet();
        r3.add(new LiveService());
        r0 = "com.larus.live.api.ILiveService";
        goto L8
    L1533:
        return null;
    L788:
        if (r2.getName().equals("com.larus.office.IOfficeSdkService") == false) goto L1534;
        r3 = new HashSet();
        r3.add(new OfficeSdkServiceImpl());
        r0 = "com.larus.office.IOfficeSdkService";
        goto L8
    L1534:
        return null;
    L791:
        if (r2.getName().equals("com.larus.audio.ttsV2.ITtsBackgroundPlayControlService") == false) goto L1535;
        r3 = new HashSet();
        r3.add(new DefaultTtsBackgroundPlayControlServiceImpl());
        r0 = "com.larus.audio.ttsV2.ITtsBackgroundPlayControlService";
        goto L8
    L1535:
        return null;
    L794:
        if (r2.getName().equals("com.obric.assistant.spi.complextask.IComplexTaskService") == false) goto L1536;
        r3 = new HashSet();
        r3.add(new ObricComplexTaskServiceImpl());
        r0 = "com.obric.assistant.spi.complextask.IComplexTaskService";
        goto L8
    L1536:
        return null;
    L797:
        if (r2.getName().equals("com.larus.abtest.api.IAbTest") == false) goto L1537;
        r3 = new HashSet();
        r3.add(new AbTestImpl());
        r0 = "com.larus.abtest.api.IAbTest";
        goto L8
    L1537:
        return null;
    L800:
        if (r2.getName().equals("com.larus.bot.api.IBotPerfMonitorService") == false) goto L1538;
        r3 = new HashSet();
        r3.add(new BotPerfMonitorServiceImpl());
        r0 = "com.larus.bot.api.IBotPerfMonitorService";
        goto L8
    L1538:
        return null;
    L803:
        if (r2.getName().equals("com.obric.assistant.common.spi.IObricSamiService") == false) goto L1539;
        r3 = new HashSet();
        r3.add(new ObricSamiService());
        r0 = "com.obric.assistant.common.spi.IObricSamiService";
        goto L8
    L1539:
        return null;
    L806:
        if (r2.getName().equals("com.larus.uaigc.service.ICreationAttachmentService") == false) goto L1540;
        r3 = new HashSet();
        r3.add(new CreationAttachmentServiceImpl());
        r0 = "com.larus.uaigc.service.ICreationAttachmentService";
        goto L8
    L1540:
        return null;
    L809:
        if (r2.getName().equals("com.larus.platform.spi.IAIChatService") == false) goto L1541;
        r3 = new HashSet();
        r3.add(new AIChatServiceImpl());
        r0 = "com.larus.platform.spi.IAIChatService";
        goto L8
    L1541:
        return null;
    L812:
        if (r2.getName().equals("com.obric.assistant.interaction.api.service.IObricShowOnLockedService") == false) goto L1542;
        r3 = new HashSet();
        r3.add(new ObricShowOnLockedServiceImpl());
        r0 = "com.obric.assistant.interaction.api.service.IObricShowOnLockedService";
        goto L8
    L1542:
        return null;
    L815:
        if (r2.getName().equals("com.obric.assistant.spi.chat.IObricChatMessageBgService") == false) goto L1543;
        r3 = new HashSet();
        r3.add(new ObricChatMessageBgServiceImpl());
        r0 = "com.obric.assistant.spi.chat.IObricChatMessageBgService";
        goto L8
    L1543:
        return null;
    L818:
        if (r2.getName().equals("com.larus.sheet.sdk.api.ISheetSdkInternalService") == false) goto L1544;
        r3 = new HashSet();
        r3.add(new SheetSdkInternalServiceImpl());
        r0 = "com.larus.sheet.sdk.api.ISheetSdkInternalService";
        goto L8
    L1544:
        return null;
    L821:
        if (r2.getName().equals("com.larus.office.base.service.IOfficeSdkServiceV2") == false) goto L1545;
        r3 = new HashSet();
        r3.add(new OfficeSdkServiceV2());
        r0 = "com.larus.office.base.service.IOfficeSdkServiceV2";
        goto L8
    L1545:
        return null;
    L824:
        if (r2.getName().equals("com.larus.bot.api.IBotRouteInterceptorService") == false) goto L1546;
        r3 = new HashSet();
        r3.add(new BotRouteInterceptorServiceImpl());
        r0 = "com.larus.bot.api.IBotRouteInterceptorService";
        goto L8
    L1546:
        return null;
    L827:
        if (r2.getName().equals("com.larus.avlink.api.IDoraTrackerService") == false) goto L1547;
        r3 = new HashSet();
        r3.add(new DoraTracerService());
        r0 = "com.larus.avlink.api.IDoraTrackerService";
        goto L8
    L1547:
        return null;
    L830:
        if (r2.getName().equals("com.larus.setting.api.ICustomAppIcon") == false) goto L1548;
        r3 = new HashSet();
        r3.add(new ObricCustomAppIconImpl());
        r0 = "com.larus.setting.api.ICustomAppIcon";
        goto L8
    L1548:
        return null;
    L833:
        if (r2.getName().equals("com.larus.share.service.IShareOfficeDocService") == false) goto L1549;
        r3 = new HashSet();
        r3.add(new ShareOfficeDocServiceImpl());
        r0 = "com.larus.share.service.IShareOfficeDocService";
        goto L8
    L1549:
        return null;
    L836:
        if (r2.getName().equals("com.larus.community.api.spi.ICommunityDetailContainerProvider") == false) goto L1550;
        r3 = new HashSet();
        r3.add(new DoubaoCommunityDetailContainerProvider());
        r0 = "com.larus.community.api.spi.ICommunityDetailContainerProvider";
        goto L8
    L1550:
        return null;
    L839:
        if (r2.getName().equals("com.obric.update.api.IObricUpdate") == false) goto L1551;
        r3 = new HashSet();
        r3.add(new ObricUpdateImpl());
        r0 = "com.obric.update.api.IObricUpdate";
        goto L8
    L1551:
        return null;
    L842:
        if (r2.getName().equals("com.larus.uaigc.applet.IAICreationAppletPageProvider") == false) goto L1552;
        r3 = new HashSet();
        r3.add(new AICreationAppletPageProviderImpl());
        r0 = "com.larus.uaigc.applet.IAICreationAppletPageProvider";
        goto L8
    L1552:
        return null;
    L845:
        if (r2.getName().equals("com.larus.home.api.main.IHomeApi") == false) goto L1553;
        r3 = new HashSet();
        r3.add(new HomeServiceImpl());
        r0 = "com.larus.home.api.main.IHomeApi";
        goto L8
    L1553:
        return null;
    L848:
        if (r2.getName().equals("com.larus.account.saas.coreapi.IAccountEventsInterceptor") == false) goto L1554;
        r3 = new HashSet();
        r3.add(new AccountEventsInterceptorImpl());
        r0 = "com.larus.account.saas.coreapi.IAccountEventsInterceptor";
        goto L8
    L1554:
        return null;
    L851:
        if (r2.getName().equals("com.larus.bmhome.block.pipeline.api.IBlockPipelineTask") == false) goto L1555;
        r3 = new HashSet();
        r3.add(new AddBlockBizModelAfterBizModelListTask());
        r3.add(new BlockPipelineDeepThinkTaskModeTask());
        r3.add(new BlockPipelineTaskCotPagePreprocessTask());
        r3.add(new ElapsedBlockPreprocessPipelineTask());
        r3.add(new FilterHiddenQuickReplyBlockTask());
        r3.add(new FlattenDeepThinkContainerPipelineTask());
        r3.add(new FlattenSingleToolPreviewPipelineTask());
        r3.add(new MainBotRenderContextPipelineTask());
        r3.add(new RichMediaLayoutPositionPipelineTask());
        r3.add(new RichMediaLocalFileFallbackTask());
        r3.add(new OfficeUrlPreviewBlockPipelineObserver());
        r3.add(new AudioRecordBlockFunnelPipelineTask());
        r3.add(new AudioRecordBlockPipelineTask());
        r0 = "com.larus.bmhome.block.pipeline.api.IBlockPipelineTask";
        goto L8
    L1555:
        return null;
    L854:
        if (r2.getName().equals("com.larus.larkfeed.IFlowLarkFeedApi") == false) goto L1556;
        r3 = new HashSet();
        r3.add(new FlowLarkFeedImpl());
        r0 = "com.larus.larkfeed.IFlowLarkFeedApi";
        goto L8
    L1556:
        return null;
    L857:
        if (r2.getName().equals("com.larus.platform.spi.IAIChatAudioService") == false) goto L1557;
        r3 = new HashSet();
        r3.add(new AIChatAudioServiceImpl());
        r0 = "com.larus.platform.spi.IAIChatAudioService";
        goto L8
    L1557:
        return null;
    L860:
        if (r2.getName().equals("com.larus.bmhome.chat.list.cell.prompt.ISuggestPromptCellProvider") == false) goto L1558;
        r3 = new HashSet();
        r3.add(new SuggestPromptCellProviderImpl());
        r0 = "com.larus.bmhome.chat.list.cell.prompt.ISuggestPromptCellProvider";
        goto L8
    L1558:
        return null;
    L863:
        if (r2.getName().equals("com.larus.login.api.ILoginApi") == false) goto L1559;
        r3 = new HashSet();
        r3.add(new LonginServiceImpl());
        r0 = "com.larus.login.api.ILoginApi";
        goto L8
    L1559:
        return null;
    L866:
        if (r2.getName().equals("com.obric.assistant.IObricPluginActivityRecordHelper") == false) goto L1560;
        r3 = new HashSet();
        r3.add(new ObricPluginActivityRecordHelper());
        r0 = "com.obric.assistant.IObricPluginActivityRecordHelper";
        goto L8
    L1560:
        return null;
    L869:
        if (r2.getName().equals("com.collection.profile.api.ICollectService") == false) goto L1561;
        r3 = new HashSet();
        r3.add(new CollectImpl());
        r0 = "com.collection.profile.api.ICollectService";
        goto L8
    L1561:
        return null;
    L872:
        if (r2.getName().equals("com.larus.bmhome.chat.input.IChatInputService") == false) goto L1562;
        r3 = new HashSet();
        r3.add(new ChatInputServiceImpl());
        r0 = "com.larus.bmhome.chat.input.IChatInputService";
        goto L8
    L1562:
        return null;
    L875:
        if (r2.getName().equals("com.obric.assistant.interaction.api.IKeyguardState") == false) goto L1563;
        r3 = new HashSet();
        r3.add(new KeyguardStateImpl());
        r0 = "com.obric.assistant.interaction.api.IKeyguardState";
        goto L8
    L1563:
        return null;
    L878:
        if (r2.getName().equals("com.larus.office.base.export.IOfficeSheetExportDelegate") == false) goto L1564;
        r3 = new HashSet();
        r3.add(new OfficeSheetExportDelegateImpl());
        r0 = "com.larus.office.base.export.IOfficeSheetExportDelegate";
        goto L8
    L1564:
        return null;
    L881:
        if (r2.getName().equals("com.obric.assistant.spi.keyguard.IKeyguardService") == false) goto L1565;
        r3 = new HashSet();
        r3.add(new ObricKeyguardServiceImpl());
        r0 = "com.obric.assistant.spi.keyguard.IKeyguardService";
        goto L8
    L1565:
        return null;
    L884:
        if (r2.getName().equals("com.obric.assistant.audio.service.IAssistantTextModeService") == false) goto L1566;
        r3 = new HashSet();
        r3.add(new AssistantTextModeService());
        r0 = "com.obric.assistant.audio.service.IAssistantTextModeService";
        goto L8
    L1566:
        return null;
    L887:
        if (r2.getName().equals("com.obric.assistant.session.model.ISessionMaintaining") == false) goto L1567;
        r3 = new HashSet();
        r3.add(new SessionMaintainer());
        r0 = "com.obric.assistant.session.model.ISessionMaintaining";
        goto L8
    L1567:
        return null;
    L890:
        if (r2.getName().equals("com.larus.account.base.api.ILoginService") == false) goto L1568;
        r3 = new HashSet();
        r3.add(new LoginServiceImpl());
        r0 = "com.larus.account.base.api.ILoginService";
        goto L8
    L1568:
        return null;
    L893:
        if (r2.getName().equals("com.larus.chat.gallery.api.IChatGalleryService") == false) goto L1569;
        r3 = new HashSet();
        r3.add(new ChatGalleryServiceImpl());
        r0 = "com.larus.chat.gallery.api.IChatGalleryService";
        goto L8
    L1569:
        return null;
    L896:
        if (r2.getName().equals("com.larus.platform.api.ILarkConnectorArtifactService") == false) goto L1570;
        r3 = new HashSet();
        r3.add(new LarkConnectorArtifactServiceImpl());
        r0 = "com.larus.platform.api.ILarkConnectorArtifactService";
        goto L8
    L1570:
        return null;
    L899:
        if (r2.getName().equals("com.larus.sheet.api.ISheetService") == false) goto L1571;
        r3 = new HashSet();
        r3.add(new SheetServiceImpl());
        r0 = "com.larus.sheet.api.ISheetService";
        goto L8
    L1571:
        return null;
    L902:
        if (r2.getName().equals("com.larus.bitable.api.IBitableService") == false) goto L1572;
        r3 = new HashSet();
        r3.add(new BitableServiceImpl());
        r0 = "com.larus.bitable.api.IBitableService";
        goto L8
    L1572:
        return null;
    L905:
        if (r2.getName().equals("com.larus.community.api.ICommunityService") == false) goto L1573;
        r3 = new HashSet();
        r3.add(new CreationServiceImpl());
        r0 = "com.larus.community.api.ICommunityService";
        goto L8
    L1573:
        return null;
    L908:
        if (r2.getName().equals("com.obric.assistant.spi.audio.IObricBackTraceLogService") == false) goto L1574;
        r3 = new HashSet();
        r3.add(new ObricBackTraceLogServiceImpl());
        r0 = "com.obric.assistant.spi.audio.IObricBackTraceLogService";
        goto L8
    L1574:
        return null;
    L911:
        if (r2.getName().equals("com.larus.bmhome.community.ICreationPageService") == false) goto L1575;
        r3 = new HashSet();
        r3.add(new CreationPageService());
        r0 = "com.larus.bmhome.community.ICreationPageService";
        goto L8
    L1575:
        return null;
    L914:
        if (r2.getName().equals("com.obric.assistant.chat.IQueryAuthenticationService") == false) goto L1576;
        r3 = new HashSet();
        r3.add(new QueryAuthenticationServiceImpl());
        r0 = "com.obric.assistant.chat.IQueryAuthenticationService";
        goto L8
    L1576:
        return null;
    L917:
        if (r2.getName().equals("com.larus.bmhome.taskskill.service.ISkillService") == false) goto L1577;
        r3 = new HashSet();
        r3.add(new SkillServiceImpl());
        r0 = "com.larus.bmhome.taskskill.service.ISkillService";
        goto L8
    L1577:
        return null;
    L920:
        if (r2.getName().equals("com.larus.bmhome.resource.access.ResourceUploadSceneResolver") == false) goto L1578;
        r3 = new HashSet();
        r3.add(new CreationUploadSceneResolver());
        r0 = "com.larus.bmhome.resource.access.ResourceUploadSceneResolver";
        goto L8
    L1578:
        return null;
    L923:
        if (r2.getName().equals("com.larus.platform.service.IOfficePlatformService") == false) goto L1579;
        r3 = new HashSet();
        r3.add(new OfficePlatformServiceImpl());
        r0 = "com.larus.platform.service.IOfficePlatformService";
        goto L8
    L1579:
        return null;
    L926:
        if (r2.getName().equals("com.obric.assistant.audio.service.IManualHalfDuplexModeService") == false) goto L1580;
        r3 = new HashSet();
        r3.add(new ManualHalfDuplexModeService());
        r0 = "com.obric.assistant.audio.service.IManualHalfDuplexModeService";
        goto L8
    L1580:
        return null;
    L929:
        if (r2.getName().equals("com.larus.dora.api.IDoraService") == false) goto L1581;
        r3 = new HashSet();
        r3.add(new DoraServiceImpl());
        r0 = "com.larus.dora.api.IDoraService";
        goto L8
    L1581:
        return null;
    L932:
        if (r2.getName().equals("com.obric.assistant.common.spi.settings.IObricSettingRequestService") == false) goto L1582;
        r3 = new HashSet();
        r3.add(new ObricRequestSettingsServiceImpl());
        r0 = "com.obric.assistant.common.spi.settings.IObricSettingRequestService";
        goto L8
    L1582:
        return null;
    L935:
        if (r2.getName().equals("com.obric.assistant.spi.router.IObricRouterService") == false) goto L1583;
        r3 = new HashSet();
        r3.add(new ObricRouterServiceImpl());
        r0 = "com.obric.assistant.spi.router.IObricRouterService";
        goto L8
    L1583:
        return null;
    L938:
        if (r2.getName().equals("com.larus.contextwindow.api.IContextWindowUsageService") == false) goto L1584;
        r3 = new HashSet();
        r3.add(new ContextWindowUsageServiceImpl());
        r0 = "com.larus.contextwindow.api.IContextWindowUsageService";
        goto L8
    L1584:
        return null;
    L941:
        if (r2.getName().equals("com.larus.uaigc.creation.ICreationService") == false) goto L1585;
        r3 = new HashSet();
        r3.add(new com.larus.uaigc.createpage.CreationServiceImpl());
        r0 = "com.larus.uaigc.creation.ICreationService";
        goto L8
    L1585:
        return null;
    L944:
        if (r2.getName().equals("com.larus.uaigc.applet.IMusicAppletHostService") == false) goto L1586;
        r3 = new HashSet();
        r3.add(new MusicAppletHostServiceImpl());
        r0 = "com.larus.uaigc.applet.IMusicAppletHostService";
        goto L8
    L1586:
        return null;
    L947:
        if (r2.getName().equals("com.obric.assistant.common.spi.IObricContextService") == false) goto L1587;
        r3 = new HashSet();
        r3.add(new ObricContextServiceImpl());
        r0 = "com.obric.assistant.common.spi.IObricContextService";
        goto L8
    L1587:
        return null;
    L950:
        if (r2.getName().equals("com.larus.enterprise.api.IEnterpriseWhiteListService") == false) goto L1588;
        r3 = new HashSet();
        r3.add(new EnterpriseWhiteListServiceImpl());
        r0 = "com.larus.enterprise.api.IEnterpriseWhiteListService";
        goto L8
    L1588:
        return null;
    L953:
        if (r2.getName().equals("com.larus.bmhome.instruction.IInstructionCreator") == false) goto L1589;
        r3 = new HashSet();
        r3.add(new DropdownListSelectorCreator());
        r3.add(new FeatureSelectorCreator());
        r3.add(new InputBoxCreator());
        r3.add(new MultiSelectorCreator());
        r3.add(new TabSelectorCreator());
        r3.add(new TextListSelectorCreator());
        r3.add(new TranslatorCreator());
        r3.add(new UserMessageSenderCreator());
        r3.add(new DigitalAvatarTemplateListSelectorCreator());
        r3.add(new ImageListSelectorCreator());
        r3.add(new ImageListSelectorWithMoreTemplateCreator());
        r3.add(new MultiAttachmentSelectorCreator());
        r3.add(new MusicTemplateListSelectorCreator());
        r3.add(new ObricSpecialInputCreator());
        r0 = "com.larus.bmhome.instruction.IInstructionCreator";
        goto L8
    L1589:
        return null;
    L956:
        if (r2.getName().equals("com.larus.camera.contract.ICameraServiceDiff") == false) goto L1590;
        r3 = new HashSet();
        r3.add(new ObricCameraServiceDiffImpl());
        r0 = "com.larus.camera.contract.ICameraServiceDiff";
        goto L8
    L1590:
        return null;
    L959:
        if (r2.getName().equals("com.larus.voicecall.api.IVoiceCallRouterService") == false) goto L1591;
        r3 = new HashSet();
        r3.add(new VoiceCallRouterServiceImpl());
        r0 = "com.larus.voicecall.api.IVoiceCallRouterService";
        goto L8
    L1591:
        return null;
    L962:
        if (r2.getName().equals("com.larus.uaigc.service.ICreationDetailImageEditService") == false) goto L1592;
        r3 = new HashSet();
        r3.add(new CreationDetailImageEditServiceImpl());
        r0 = "com.larus.uaigc.service.ICreationDetailImageEditService";
        goto L8
    L1592:
        return null;
    L965:
        if (r2.getName().equals("com.obric.audio.enroll.IVoiceEnrollService") == false) goto L1593;
        r3 = new HashSet();
        r3.add(new com.obric.audio.enroll.VoiceEnrollServiceImpl());
        r0 = "com.obric.audio.enroll.IVoiceEnrollService";
        goto L8
    L1593:
        return null;
    L968:
        if (r2.getName().equals("com.larus.business.debug.api.NmtInjectService") == false) goto L1594;
        r3 = new HashSet();
        r3.add(new NmtInjectServiceImpl());
        r0 = "com.larus.business.debug.api.NmtInjectService";
        goto L8
    L1594:
        return null;
    L971:
        if (r2.getName().equals("com.larus.uaigc.service.ICreationWorkflowService") == false) goto L1595;
        r3 = new HashSet();
        r3.add(new CreationWorkflowServiceImpl());
        r0 = "com.larus.uaigc.service.ICreationWorkflowService";
        goto L8
    L1595:
        return null;
    L974:
        if (r2.getName().equals("com.obric.assistant.settings.IObricAutoBlacklistSettingsNotifier") == false) goto L1596;
        r3 = new HashSet();
        r3.add(new ObricAutoGuiSettingsImpl());
        r0 = "com.obric.assistant.settings.IObricAutoBlacklistSettingsNotifier";
        goto L8
    L1596:
        return null;
    L977:
        if (r2.getName().equals("com.larus.agents.api.ILocalWebFetchService") == false) goto L1597;
        r3 = new HashSet();
        r3.add(new LocalWebFetchServiceImpl());
        r0 = "com.larus.agents.api.ILocalWebFetchService";
        goto L8
    L1597:
        return null;
    L980:
        if (r2.getName().equals("com.obric.aiagent.assistant.idl.IFlowIDLSPI") == false) goto L1598;
        r3 = new HashSet();
        r3.add(new FlowIDLSPIImpl());
        r0 = "com.obric.aiagent.assistant.idl.IFlowIDLSPI";
        goto L8
    L1598:
        return null;
    L983:
        if (r2.getName().equals("com.larus.enterprise.api.IEnterpriseService") == false) goto L1599;
        r3 = new HashSet();
        r3.add(new EnterpriseServiceImpl());
        r0 = "com.larus.enterprise.api.IEnterpriseService";
        goto L8
    L1599:
        return null;
    L986:
        if (r2.getName().equals("com.larus.account.base.provider.agegate.IAgeGateDialogProvider") == false) goto L1600;
        r3 = new HashSet();
        r3.add(new AccountAgeGateDialogProvider());
        r0 = "com.larus.account.base.provider.agegate.IAgeGateDialogProvider";
        goto L8
    L1600:
        return null;
    L989:
        if (r2.getName().equals("com.larus.mainbot.api.IFlowMainBot") == false) goto L1601;
        r3 = new HashSet();
        r3.add(new FlowMainBotImpl());
        r0 = "com.larus.mainbot.api.IFlowMainBot";
        goto L8
    L1601:
        return null;
    L992:
        if (r2.getName().equals("com.larus.bmhome.interactionpanel.IInteractionPanelSidebarService") == false) goto L1602;
        r3 = new HashSet();
        r3.add(new InteractionPanelSidebarServiceImpl());
        r0 = "com.larus.bmhome.interactionpanel.IInteractionPanelSidebarService";
        goto L8
    L1602:
        return null;
    L995:
        if (r2.getName().equals("com.larus.uaigc.applet.IMusicAppletPageProvider") == false) goto L1603;
        r3 = new HashSet();
        r3.add(new MusicAppletPageProviderImpl());
        r0 = "com.larus.uaigc.applet.IMusicAppletPageProvider";
        goto L8
    L1603:
        return null;
    L998:
        if (r2.getName().equals("com.bytedance.flow.search.kmp.api.spi.SearchActionHandlerService") == false) goto L1604;
        r3 = new HashSet();
        r3.add(new KmpDriveSearchActionHandlerServiceImpl());
        r3.add(new KmpChatSearchActionHandlerServiceImpl());
        r3.add(new KmpContactSearchActionHandlerServiceImpl());
        r3.add(new KmpSearchAccountActionHandlerServiceImpl());
        r0 = "com.bytedance.flow.search.kmp.api.spi.SearchActionHandlerService";
        goto L8
    L1604:
        return null;
    L1001:
        if (r2.getName().equals("com.obric.assistant.session.model.IOAutoOperation") == false) goto L1605;
        r3 = new HashSet();
        r3.add(new OAutoEndPoint());
        r0 = "com.obric.assistant.session.model.IOAutoOperation";
        goto L8
    L1605:
        return null;
    L1004:
        if (r2.getName().equals("com.larus.login.api.ITouristApi") == false) goto L1606;
        r3 = new HashSet();
        r3.add(new TouristServiceImpl());
        r0 = "com.larus.login.api.ITouristApi";
        goto L8
    L1606:
        return null;
    L1007:
        if (r2.getName().equals("com.larus.doc.sdk.api.IDocSdkBaseService") == false) goto L1607;
        r3 = new HashSet();
        r3.add(new DocSdkBaseServiceImpl());
        r0 = "com.larus.doc.sdk.api.IDocSdkBaseService";
        goto L8
    L1607:
        return null;
    L1010:
        if (r2.getName().equals("com.larus.reach.api.ReachSceneInterceptor") == false) goto L1608;
        r3 = new HashSet();
        r3.add(new NotificationSwitchBubbleBannerSourceListener());
        r3.add(new SocialImReachSceneInterceptor());
        r3.add(new AiPptReachSceneInterceptor());
        r0 = "com.larus.reach.api.ReachSceneInterceptor";
        goto L8
    L1608:
        return null;
    L1013:
        if (r2.getName().equals("com.larus.voicecall.api.IVoiceCallService") == false) goto L1609;
        r3 = new HashSet();
        r3.add(new IVoiceCallServiceImpl());
        r0 = "com.larus.voicecall.api.IVoiceCallService";
        goto L8
    L1609:
        return null;
    L1016:
        if (r2.getName().equals("com.larus.bitable.sdk.api.IBitableSdkService") == false) goto L1610;
        r3 = new HashSet();
        r3.add(new BitableSdkServiceImpl());
        r0 = "com.larus.bitable.sdk.api.IBitableSdkService";
        goto L8
    L1610:
        return null;
    L1019:
        if (r2.getName().equals("com.larus.camera.api.IFlowCamera") == false) goto L1611;
        r3 = new HashSet();
        r3.add(new FlowCameraImpl());
        r0 = "com.larus.camera.api.IFlowCamera";
        goto L8
    L1611:
        return null;
    L1022:
        if (r2.getName().equals("com.larus.account.base.api.IAccountService") == false) goto L1612;
        r3 = new HashSet();
        r3.add(new AccountServiceImpl());
        r0 = "com.larus.account.base.api.IAccountService";
        goto L8
    L1612:
        return null;
    L1025:
        if (r2.getName().equals("com.larus.bmhome.web.IAiChatHostWebService") == false) goto L1613;
        r3 = new HashSet();
        r3.add(new AiChatHostWebServiceImpl());
        r0 = "com.larus.bmhome.web.IAiChatHostWebService";
        goto L8
    L1613:
        return null;
    L1028:
        if (r2.getName().equals("com.obric.assistant.zeus.plugin.IObricMigrationHandler") == false) goto L1614;
        r3 = new HashSet();
        r3.add(new ObricMigrationHandlerImpl());
        r0 = "com.obric.assistant.zeus.plugin.IObricMigrationHandler";
        goto L8
    L1614:
        return null;
    L1031:
        if (r2.getName().equals("com.obric.assistant.interaction.api.keyguard.IKeyguardBiometricSetting") == false) goto L1615;
        r3 = new HashSet();
        r3.add(new KeyguardBiometricSettingImpl());
        r0 = "com.obric.assistant.interaction.api.keyguard.IKeyguardBiometricSetting";
        goto L8
    L1615:
        return null;
    L1034:
        if (r2.getName().equals("com.larus.bmhome.chat.bubble.floating.report.IBannerShowReportService") == false) goto L1616;
        r3 = new HashSet();
        r3.add(new BannerShowReportServiceImpl());
        r0 = "com.larus.bmhome.chat.bubble.floating.report.IBannerShowReportService";
        goto L8
    L1616:
        return null;
    L1037:
        if (r2.getName().equals("com.larus.drive.sdk.api.IDriveSdkGenericService") == false) goto L1617;
        r3 = new HashSet();
        r3.add(new DriveSdkGenericServiceImpl());
        r0 = "com.larus.drive.sdk.api.IDriveSdkGenericService";
        goto L8
    L1617:
        return null;
    L1040:
        if (r2.getName().equals("com.larus.bmhome.taskskill.service.IProjectCreatePanelService") == false) goto L1618;
        r3 = new HashSet();
        r3.add(new ProjectCreatePanelServiceImpl());
        r0 = "com.larus.bmhome.taskskill.service.IProjectCreatePanelService";
        goto L8
    L1618:
        return null;
    L1043:
        if (r2.getName().equals("com.larus.platform.api.IFlowChatThemeConfigProvider") == false) goto L1619;
        r3 = new HashSet();
        r3.add(new FlowChatThemeConfigProvider());
        r0 = "com.larus.platform.api.IFlowChatThemeConfigProvider";
        goto L8
    L1619:
        return null;
    L1046:
        if (r2.getName().equals("com.obric.assistant.spi.essentialtask.IObricEssentialTaskService") == false) goto L1620;
        r3 = new HashSet();
        r3.add(new ObricEssentialTaskServiceImpl());
        r0 = "com.obric.assistant.spi.essentialtask.IObricEssentialTaskService";
        goto L8
    L1620:
        return null;
    L1049:
        if (r2.getName().equals("com.larus.account.base.api.IMultiAccountService") == false) goto L1621;
        r3 = new HashSet();
        r3.add(new MultiAccountServiceImpl());
        r0 = "com.larus.account.base.api.IMultiAccountService";
        goto L8
    L1621:
        return null;
    L1052:
        if (r2.getName().equals("com.larus.account.base.provider.IOfficeSDKLgwHeaderProvider") == false) goto L1622;
        r3 = new HashSet();
        r3.add(new OfficeSDKLgwHeaderProvider());
        r0 = "com.larus.account.base.provider.IOfficeSDKLgwHeaderProvider";
        goto L8
    L1622:
        return null;
    L1055:
        if (r2.getName().equals("com.obric.assistant.applet.IObricAppletService") == false) goto L1623;
        r3 = new HashSet();
        r3.add(new ObricAppletServiceImpl());
        r0 = "com.obric.assistant.applet.IObricAppletService";
        goto L8
    L1623:
        return null;
    L1058:
        if (r2.getName().equals("com.larus.bmhome.chat.doclink.IMessageDocPreviewService") == false) goto L1624;
        r3 = new HashSet();
        r3.add(new MessageDocPreviewServiceImpl());
        r0 = "com.larus.bmhome.chat.doclink.IMessageDocPreviewService";
        goto L8
    L1624:
        return null;
    L1061:
        if (r2.getName().equals("com.larus.praise.IPraiseService") == false) goto L1625;
        r3 = new HashSet();
        r3.add(new PraiseServiceImpl());
        r0 = "com.larus.praise.IPraiseService";
        goto L8
    L1625:
        return null;
    L1064:
        if (r2.getName().equals("com.obric.assistant.IObricPackageSignatureCacheService") == false) goto L1626;
        r3 = new HashSet();
        r3.add(new ObricPackageSignatureCacheServiceImpl());
        r0 = "com.obric.assistant.IObricPackageSignatureCacheService";
        goto L8
    L1626:
        return null;
    L1067:
        if (r2.getName().equals("com.larus.dora.api.INLService") == false) goto L1627;
        r3 = new HashSet();
        r3.add(new NLServiceImpl());
        r0 = "com.larus.dora.api.INLService";
        goto L8
    L1627:
        return null;
    L1070:
        if (r2.getName().equals("com.obric.assistant.spi.audio.IObricTtsControlService") == false) goto L1628;
        r3 = new HashSet();
        r3.add(new ObricTtsControlServiceImpl());
        r0 = "com.obric.assistant.spi.audio.IObricTtsControlService";
        goto L8
    L1628:
        return null;
    L1073:
        if (r2.getName().equals("com.obric.assistant.spi.audio.IObricAsrService") == false) goto L1629;
        r3 = new HashSet();
        r3.add(new ObricAsrServiceImpl());
        r0 = "com.obric.assistant.spi.audio.IObricAsrService";
        goto L8
    L1629:
        return null;
    L1076:
        if (r2.getName().equals("com.larus.platform.api.IAiFilePreviewService") == false) goto L1630;
        r3 = new HashSet();
        r3.add(new FlowDriveSdkServiceImpl());
        r0 = "com.larus.platform.api.IAiFilePreviewService";
        goto L8
    L1630:
        return null;
    L1079:
        if (r2.getName().equals("com.obric.assistant.spi.miniapp.IObricIntentWidgetPolicy") == false) goto L1631;
        r3 = new HashSet();
        r3.add(new ObricIntentWidgetPolicyImpl());
        r0 = "com.obric.assistant.spi.miniapp.IObricIntentWidgetPolicy";
        goto L8
    L1631:
        return null;
    L1082:
        if (r2.getName().equals("com.larus.drive.sdk.api.IDriveSdkService") == false) goto L1632;
        r3 = new HashSet();
        r3.add(new DriveSdkServiceImpl());
        r0 = "com.larus.drive.sdk.api.IDriveSdkService";
        goto L8
    L1632:
        return null;
    L1085:
        if (r2.getName().equals("com.larus.dora.impl.assistant.AssistantWifiService") == false) goto L1633;
        r3 = new HashSet();
        r3.add(new ObricAssistantWifiServiceImpl());
        r0 = "com.larus.dora.impl.assistant.AssistantWifiService";
        goto L8
    L1633:
        return null;
    L1088:
        if (r2.getName().equals("com.obric.assistant.interaction.api.essentialtask.IEssentialTaskService") == false) goto L1634;
        r3 = new HashSet();
        r3.add(new EssentialTaskServiceImpl());
        r0 = "com.obric.assistant.interaction.api.essentialtask.IEssentialTaskService";
        goto L8
    L1634:
        return null;
    L1091:
        if (r2.getName().equals("com.bytedance.flow.search.kmp.api.spi.SearchDomainGateService") == false) goto L1635;
        r3 = new HashSet();
        r3.add(new KmpAggregateSearchDomainGateServiceImpl());
        r0 = "com.bytedance.flow.search.kmp.api.spi.SearchDomainGateService";
        goto L8
    L1635:
        return null;
    L1094:
        if (r2.getName().equals("com.larus.login.api.IAccountTrackApi") == false) goto L1636;
        r3 = new HashSet();
        r3.add(new AccountTrace());
        r0 = "com.larus.login.api.IAccountTrackApi";
        goto L8
    L1636:
        return null;
    L1097:
        if (r2.getName().equals("com.obric.assistant.state.api.v2.core.IObricStateDispatcherService") == false) goto L1637;
        r3 = new HashSet();
        r3.add(new ObricStateDispatcherServiceImpl());
        r0 = "com.obric.assistant.state.api.v2.core.IObricStateDispatcherService";
        goto L8
    L1637:
        return null;
    L1100:
        if (r2.getName().equals("com.larus.platform.spi.IAIChatSRSaverService") == false) goto L1638;
        r3 = new HashSet();
        r3.add(new AIChatSRSaverImpl());
        r0 = "com.larus.platform.spi.IAIChatSRSaverService";
        goto L8
    L1638:
        return null;
    L1103:
        if (r2.getName().equals("com.larus.platform.spi.IAIChatRenderTraceService") == false) goto L1639;
        r3 = new HashSet();
        r3.add(new AIChatRenderTraceServiceImpl());
        r0 = "com.larus.platform.spi.IAIChatRenderTraceService";
        goto L8
    L1639:
        return null;
    L1106:
        if (r2.getName().equals("com.larus.common_ui.floatwindow.manager.IFloatWindowHostProvider") == false) goto L1640;
        r3 = new HashSet();
        r3.add(new ObricWindowFloatHostProvider());
        r0 = "com.larus.common_ui.floatwindow.manager.IFloatWindowHostProvider";
        goto L8
    L1640:
        return null;
    L1109:
        if (r2.getName().equals("com.obric.assistant.session.model.ISystemServiceOperation") == false) goto L1641;
        r3 = new HashSet();
        r3.add(new SystemServiceEndpoint());
        r0 = "com.obric.assistant.session.model.ISystemServiceOperation";
        goto L8
    L1641:
        return null;
    L1112:
        if (r2.getName().equals("com.larus.audio.ttsV2.ITtsGuideService") == false) goto L1642;
        r3 = new HashSet();
        r3.add(new TtsGuideServiceImpl());
        r0 = "com.larus.audio.ttsV2.ITtsGuideService";
        goto L8
    L1642:
        return null;
    L1115:
        if (r2.getName().equals("com.larus.canvas.service.ICanvasRepoService") == false) goto L1643;
        r3 = new HashSet();
        r3.add(new CanvasRepoServiceImpl());
        r0 = "com.larus.canvas.service.ICanvasRepoService";
        goto L8
    L1643:
        return null;
    L1118:
        if (r2.getName().equals("com.larus.suggest.api.INexPulseDialogService") == false) goto L1644;
        r3 = new HashSet();
        r3.add(new NexPulseDialogServiceImpl());
        r0 = "com.larus.suggest.api.INexPulseDialogService";
        goto L8
    L1644:
        return null;
    L1121:
        if (r2.getName().equals("com.larus.profile.api.ICreationService") == false) goto L1645;
        r3 = new HashSet();
        r3.add(new com.larus.profile.impl.CreationServiceImpl());
        r0 = "com.larus.profile.api.ICreationService";
        goto L8
    L1645:
        return null;
    L1124:
        if (r2.getName().equals("com.larus.office.base.preview.IOfficePreviewOpener") == false) goto L1646;
        r3 = new HashSet();
        r3.add(new BitableOpenerImpl());
        r3.add(new DocOpenerImpl());
        r3.add(new DriveOpenerImpl());
        r3.add(new SheetOpenerImpl());
        r3.add(new SlidesOpenerImpl());
        r0 = "com.larus.office.base.preview.IOfficePreviewOpener";
        goto L8
    L1646:
        return null;
    L1127:
        if (r2.getName().equals("com.obric.assistant.spi.audio.IObricEnrollInteropService") == false) goto L1647;
        r3 = new HashSet();
        r3.add(new ObricEnrollInteropServiceImpl());
        r0 = "com.obric.assistant.spi.audio.IObricEnrollInteropService";
        goto L8
    L1647:
        return null;
    L1130:
        if (r2.getName().equals("com.obric.assistant.spi.message.IObricMessageService") == false) goto L1648;
        r3 = new HashSet();
        r3.add(new ObricMessageServiceImpl());
        r0 = "com.obric.assistant.spi.message.IObricMessageService";
        goto L8
    L1648:
        return null;
    L1133:
        if (r2.getName().equals("com.larus.common_ui.icon.ICommonFileIconProvider") == false) goto L1649;
        r3 = new HashSet();
        r3.add(new OfficeFileIconProvider());
        r0 = "com.larus.common_ui.icon.ICommonFileIconProvider";
        goto L8
    L1649:
        return null;
    L1136:
        if (r2.getName().equals("com.obric.assistant.interaction.api.service.IActivityResultHelperApi") == false) goto L1650;
        r3 = new HashSet();
        r3.add(new ActivityResultHelperImpl());
        r0 = "com.obric.assistant.interaction.api.service.IActivityResultHelperApi";
        goto L8
    L1650:
        return null;
    L1139:
        if (r2.getName().equals("com.bytedance.flow.search.kmp.api.spi.SearchDriveService") == false) goto L1651;
        r3 = new HashSet();
        r3.add(new KmpSearchDriveServiceImpl());
        r0 = "com.bytedance.flow.search.kmp.api.spi.SearchDriveService";
        goto L8
    L1651:
        return null;
    L1142:
        if (r2.getName().equals("com.larus.account.base.api.IDouyinAuthService") == false) goto L1652;
        r3 = new HashSet();
        r3.add(new DouyinAuthServiceImpl());
        r0 = "com.larus.account.base.api.IDouyinAuthService";
        goto L8
    L1652:
        return null;
    L1145:
        if (r2.getName().equals("com.obric.aiagent.assistant.idl.IFlowAssistantStateIDLSPI") == false) goto L1653;
        r3 = new HashSet();
        r3.add(new ObricStateIDLStub());
        r0 = "com.obric.aiagent.assistant.idl.IFlowAssistantStateIDLSPI";
        goto L8
    L1653:
        return null;
    L1148:
        if (r2.getName().equals("com.larus.bmhome.chat.component.list.ChatMessageListUpdateObserver") == false) goto L1654;
        r3 = new HashSet();
        r3.add(new OfficeUrlPreviewMessageListObserver());
        r3.add(new CreationNoWatermarkMessageListObserver());
        r0 = "com.larus.bmhome.chat.component.list.ChatMessageListUpdateObserver";
        goto L8
    L1654:
        return null;
    L1151:
        if (r2.getName().equals("com.obric.assistant.entity.IObricIntentEntityListSheetService") == false) goto L1655;
        r3 = new HashSet();
        r3.add(new ObricIntentEntityListSheetServiceImpl());
        r0 = "com.obric.assistant.entity.IObricIntentEntityListSheetService";
        goto L8
    L1655:
        return null;
    L1154:
        if (r2.getName().equals("com.larus.platform.spi.IChatDebugWranglerProvider") == false) goto L1656;
        r3 = new HashSet();
        r3.add(new ChatDebugWranglerProvider());
        r0 = "com.larus.platform.spi.IChatDebugWranglerProvider";
        goto L8
    L1656:
        return null;
    L1157:
        if (r2.getName().equals("com.obric.assistant.IObricAssistant") == false) goto L1657;
        r3 = new HashSet();
        r3.add(new ObricAssistantImpl());
        r0 = "com.obric.assistant.IObricAssistant";
        goto L8
    L1657:
        return null;
    L1160:
        if (r2.getName().equals("com.obric.assistant.session.model.IAutoMicOperation") == false) goto L1658;
        r3 = new HashSet();
        r3.add(new AutoMicEndpoint());
        r0 = "com.obric.assistant.session.model.IAutoMicOperation";
        goto L8
    L1658:
        return null;
    L1163:
        if (r2.getName().equals("com.larus.uaigc.service.ICreationNotifyService") == false) goto L1659;
        r3 = new HashSet();
        r3.add(new CreationNotifyServiceImpl());
        r0 = "com.larus.uaigc.service.ICreationNotifyService";
        goto L8
    L1659:
        return null;
    L1166:
        if (r2.getName().equals("com.larus.uaigc.applet.IAICreationAppletHostService") == false) goto L1660;
        r3 = new HashSet();
        r3.add(new AICreationAppletHostServiceImpl());
        r0 = "com.larus.uaigc.applet.IAICreationAppletHostService";
        goto L8
    L1660:
        return null;
    L1169:
        if (r2.getName().equals("com.larus.login.api.IDouyinConversationAuthService") == false) goto L1661;
        r3 = new HashSet();
        r3.add(new DouyinConversationAuthServiceImpl());
        r0 = "com.larus.login.api.IDouyinConversationAuthService";
        goto L8
    L1661:
        return null;
    L1172:
        if (r2.getName().equals("com.larus.bmhome.resource.access.ResourceRemoteResolver") == false) goto L1662;
        r3 = new HashSet();
        r3.add(new CreationImageRemoteResolver());
        r0 = "com.larus.bmhome.resource.access.ResourceRemoteResolver";
        goto L8
    L1662:
        return null;
    L1175:
        if (r2.getName().equals("com.obric.assistant.common.spi.IObricEnvService") == false) goto L1663;
        r3 = new HashSet();
        r3.add(new ObricEnvServiceImpl());
        r0 = "com.obric.assistant.common.spi.IObricEnvService";
        goto L8
    L1663:
        return null;
    L1178:
        if (r2.getName().equals("com.larus.feishu.office.im.api.FlowCameraExtensionFactoryService") == false) goto L1664;
        r3 = new HashSet();
        r3.add(new FlowCameraExtensionFactoryServiceImpl());
        r0 = "com.larus.feishu.office.im.api.FlowCameraExtensionFactoryService";
        goto L8
    L1664:
        return null;
    L1181:
        if (r2.getName().equals("com.obric.assistant.spi.audio.IObricVadService") == false) goto L1665;
        r3 = new HashSet();
        r3.add(new ObricVadServiceImpl());
        r0 = "com.obric.assistant.spi.audio.IObricVadService";
        goto L8
    L1665:
        return null;
    L1184:
        if (r2.getName().equals("com.obric.assistant.spi.canvas.IObricCanvasService") == false) goto L1666;
        r3 = new HashSet();
        r3.add(new CanvasServiceImpl());
        r0 = "com.obric.assistant.spi.canvas.IObricCanvasService";
        goto L8
    L1666:
        return null;
    L1187:
        if (r2.getName().equals("com.larus.feishu.office.im.api.FlowFloatExpandExtensionFactoryService") == false) goto L1667;
        r3 = new HashSet();
        r3.add(new FlowFloatExpandExtensionFactoryServiceImpl());
        r0 = "com.larus.feishu.office.im.api.FlowFloatExpandExtensionFactoryService";
        goto L8
    L1667:
        return null;
    L1190:
        if (r2.getName().equals("com.obric.assistant.audio.service.IObricIntentStatusService") == false) goto L1668;
        r3 = new HashSet();
        r3.add(new IObricIntentStatusServiceImpl());
        r0 = "com.obric.assistant.audio.service.IObricIntentStatusService";
        goto L8
    L1668:
        return null;
    L1193:
        if (r2.getName().equals("com.obric.assistant.audio.service.IIdleQuiteService") == false) goto L1669;
        r3 = new HashSet();
        r3.add(new IdleQuiteService());
        r0 = "com.obric.assistant.audio.service.IIdleQuiteService";
        goto L8
    L1669:
        return null;
    L1196:
        if (r2.getName().equals("com.obric.assistant.state.api.multitask.producer.IObricInteractionStateProducerService") == false) goto L1670;
        r3 = new HashSet();
        r3.add(new ObricInteractionStateProducer());
        r0 = "com.obric.assistant.state.api.multitask.producer.IObricInteractionStateProducerService";
        goto L8
    L1670:
        return null;
    L1199:
        if (r2.getName().equals("com.obric.assistant.IObricActivityService") == false) goto L1671;
        r3 = new HashSet();
        r3.add(new ObricActivityServiceImpl());
        r0 = "com.obric.assistant.IObricActivityService";
        goto L8
    L1671:
        return null;
    L1202:
        if (r2.getName().equals("com.larus.bmhome.bot.IBotStatusCacheService") == false) goto L1672;
        r3 = new HashSet();
        r3.add(new BotStatusCache());
        r0 = "com.larus.bmhome.bot.IBotStatusCacheService";
        goto L8
    L1672:
        return null;
    L1205:
        if (r2.getName().equals("com.obric.assistant.spi.rtc.IObricRtcService") == false) goto L1673;
        r3 = new HashSet();
        r3.add(new ObricRtcServiceImpl());
        r3.add(new com.obric.assistant.realtimecall.ObricRtcServiceImpl());
        r0 = "com.obric.assistant.spi.rtc.IObricRtcService";
        goto L8
    L1673:
        return null;
    L1208:
        if (r2.getName().equals("com.larus.bot.api.IBotMakerService") == false) goto L1674;
        r3 = new HashSet();
        r3.add(new BotMakerServiceImpl());
        r0 = "com.larus.bot.api.IBotMakerService";
        goto L8
    L1674:
        return null;
    L1211:
        if (r2.getName().equals("com.larus.account.base.api.IThirdPartyPlatformCallbackService") == false) goto L1675;
        r3 = new HashSet();
        r3.add(new IThirdPartyPlatformCallbackImpl());
        r0 = "com.larus.account.base.api.IThirdPartyPlatformCallbackService";
        goto L8
    L1675:
        return null;
    L1214:
        if (r2.getName().equals("com.obric.assistant.session.model.ILaunchMethodOperation") == false) goto L1676;
        r3 = new HashSet();
        r3.add(new LaunchMethodReporterEndpoint());
        r0 = "com.obric.assistant.session.model.ILaunchMethodOperation";
        goto L8
    L1676:
        return null;
    L1217:
        if (r2.getName().equals("com.larus.platform.api.IFlowCreationThemeConfigProvider") == false) goto L1677;
        r3 = new HashSet();
        r3.add(new FlowCreationThemeConfigProvider());
        r0 = "com.larus.platform.api.IFlowCreationThemeConfigProvider";
        goto L8
    L1677:
        return null;
    L1220:
        if (r2.getName().equals("com.larus.audioplayer.api.news.INewsUrlAudioManager") == false) goto L1678;
        r3 = new HashSet();
        r3.add(new NewsUrlAudioManagerService());
        r0 = "com.larus.audioplayer.api.news.INewsUrlAudioManager";
        goto L8
    L1678:
        return null;
    L1223:
        if (r2.getName().equals("com.larus.ivykit.xbridge.IAnnieXMethodFinderProvider") == false) goto L1679;
        r3 = new HashSet();
        r3.add(new LiveMethodFinderProvider());
        r0 = "com.larus.ivykit.xbridge.IAnnieXMethodFinderProvider";
        goto L8
    L1679:
        return null;
    L1226:
        if (r2.getName().equals("com.obric.audio.dora.IObricDoraPluginProvider") == false) goto L1680;
        r3 = new HashSet();
        r3.add(new ObricDoraPluginProvider());
        r0 = "com.obric.audio.dora.IObricDoraPluginProvider";
        goto L8
    L1680:
        return null;
    L1229:
        if (r2.getName().equals("com.larus.drive.biz.api.IDriveService") == false) goto L1681;
        r3 = new HashSet();
        r3.add(new DriveServiceImpl());
        r0 = "com.larus.drive.biz.api.IDriveService";
        goto L8
    L1681:
        return null;
    L1232:
        if (r2.getName().equals("com.obric.assistant.IDoraAuthTrustService") == false) goto L1682;
        r3 = new HashSet();
        r3.add(new DoraAuthTrustServiceImpl());
        r0 = "com.obric.assistant.IDoraAuthTrustService";
        goto L8
    L1682:
        return null;
    L1235:
        if (r2.getName().equals("com.obric.assistant.entity.IObricEntityNavigationService") == false) goto L1683;
        r3 = new HashSet();
        r3.add(new ObricEntityNavigationServiceImpl());
        r0 = "com.obric.assistant.entity.IObricEntityNavigationService";
        goto L8
    L1683:
        return null;
    L1238:
        if (r2.getName().equals("com.obric.assistant.common.spi.audio.IObricAudioService") == false) goto L1684;
        r3 = new HashSet();
        r3.add(new ObricAudioServiceImpl());
        r0 = "com.obric.assistant.common.spi.audio.IObricAudioService";
        goto L8
    L1684:
        return null;
    L1241:
        if (r2.getName().equals("com.larus.bmhome.floatchat.IFloatChatService") == false) goto L1685;
        r3 = new HashSet();
        r3.add(new FloatChatServiceImpl());
        r0 = "com.larus.bmhome.floatchat.IFloatChatService";
        goto L8
    L1685:
        return null;
    L1244:
        if (r2.getName().equals("com.larus.slides.api.ISlidesService") == false) goto L1686;
        r3 = new HashSet();
        r3.add(new SlidesServiceImpl());
        r0 = "com.larus.slides.api.ISlidesService";
        goto L8
    L1686:
        return null;
    L1247:
        if (r2.getName().equals("com.larus.audio.audiov3.report.IAudioEventCommonParams") == false) goto L1687;
        r3 = new HashSet();
        r3.add(new AudioEventCommonParamsServiceImpl());
        r0 = "com.larus.audio.audiov3.report.IAudioEventCommonParams";
        goto L8
    L1687:
        return null;
    L1250:
        if (r2.getName().equals("com.obric.assistant.state.api.multitask.IObricInteractionModeService") == false) goto L1688;
        r3 = new HashSet();
        r3.add(new InteractionModeStateProducer());
        r0 = "com.obric.assistant.state.api.multitask.IObricInteractionModeService";
        goto L8
    L1688:
        return null;
    L1253:
        if (r2.getName().equals("com.larus.bot.api.IUgcBotRepoService") == false) goto L1689;
        r3 = new HashSet();
        r3.add(new UgcBotRepoServiceImpl());
        r0 = "com.larus.bot.api.IUgcBotRepoService";
        goto L8
    L1689:
        return null;
    L1256:
        if (r2.getName().equals("com.obric.assistant.audio.service.IObricTtsService") == false) goto L1690;
        r3 = new HashSet();
        r3.add(new ObricTtsServiceImpl());
        r0 = "com.obric.assistant.audio.service.IObricTtsService";
        goto L8
    L1690:
        return null;
    L1259:
        if (r2.getName().equals("com.obric.assistant.state.api.multitask.producer.IObricWakeupStateProducerService") == false) goto L1691;
        r3 = new HashSet();
        r3.add(new ObricWakeupStateProducer());
        r0 = "com.obric.assistant.state.api.multitask.producer.IObricWakeupStateProducerService";
        goto L8
    L1691:
        return null;
    L1262:
        if (r2.getName().equals("com.obric.aiagent.assistant.idl.IFlowSettingsIDLSPI") == false) goto L1692;
        r3 = new HashSet();
        r3.add(new SettingsIDLStub());
        r0 = "com.obric.aiagent.assistant.idl.IFlowSettingsIDLSPI";
        goto L8
    L1692:
        return null;
    L1265:
        if (r2.getName().equals("com.larus.platform.api.IFlowSettingThemeConfigProvider") == false) goto L1693;
        r3 = new HashSet();
        r3.add(new FlowSettingThemeConfigProvider());
        r0 = "com.larus.platform.api.IFlowSettingThemeConfigProvider";
        goto L8
    L1693:
        return null;
    L1268:
        if (r2.getName().equals("com.larus.bmhome.auth.douyin.IAiChatOpenDouyinAuthService") == false) goto L1694;
        r3 = new HashSet();
        r3.add(new AiChatOpenDouyinAuthServiceImpl());
        r0 = "com.larus.bmhome.auth.douyin.IAiChatOpenDouyinAuthService";
        goto L8
    L1694:
        return null;
    L1271:
        if (r2.getName().equals("com.larus.bot.api.IBotDiscoverService") == false) goto L1695;
        r3 = new HashSet();
        r3.add(new BotDiscoverServiceImpl());
        r0 = "com.larus.bot.api.IBotDiscoverService";
        goto L8
    L1695:
        return null;
    }

    private Set getStaticServiceImplSetRealStub2(Class r2) {
        switch(r2.getName().hashCode()) {
            case -2123289744: goto L677;
            case -2120641399: goto L674;
            case -2106001016: goto L671;
            case -2079534761: goto L668;
            case -2077434565: goto L665;
            case -2076923937: goto L662;
            case -2062561932: goto L659;
            case -2060489699: goto L656;
            case -2051754747: goto L653;
            case -2029332183: goto L650;
            case -2002071954: goto L647;
            case -1994632656: goto L644;
            case -1987141669: goto L641;
            case -1980112181: goto L638;
            case -1947529177: goto L635;
            case -1921560676: goto L632;
            case -1891048851: goto L629;
            case -1865321834: goto L626;
            case -1863080103: goto L623;
            case -1859502304: goto L620;
            case -1857330358: goto L617;
            case -1808983014: goto L614;
            case -1788325683: goto L611;
            case -1787949654: goto L608;
            case -1781683221: goto L605;
            case -1773014112: goto L602;
            case -1753195049: goto L599;
            case -1689796830: goto L596;
            case -1688844914: goto L593;
            case -1650729581: goto L590;
            case -1647000663: goto L587;
            case -1638934933: goto L584;
            case -1632748644: goto L581;
            case -1620039095: goto L578;
            case -1549947850: goto L575;
            case -1526781787: goto L572;
            case -1508076299: goto L569;
            case -1492966548: goto L566;
            case -1477426834: goto L563;
            case -1472983218: goto L560;
            case -1470016095: goto L557;
            case -1464627302: goto L554;
            case -1427953845: goto L551;
            case -1422611968: goto L548;
            case -1414351944: goto L545;
            case -1408772159: goto L542;
            case -1396846807: goto L539;
            case -1373331879: goto L536;
            case -1364971920: goto L533;
            case -1360319727: goto L530;
            case -1358139226: goto L527;
            case -1334040531: goto L524;
            case -1327493745: goto L521;
            case -1266045789: goto L518;
            case -1255411227: goto L515;
            case -1255399487: goto L512;
            case -1226315320: goto L509;
            case -1219463558: goto L506;
            case -1216973131: goto L503;
            case -1207459585: goto L500;
            case -1205437563: goto L497;
            case -1205085455: goto L494;
            case -1179020113: goto L491;
            case -1087673919: goto L488;
            case -1077200566: goto L485;
            case -1054897407: goto L482;
            case -1052194340: goto L479;
            case -1011449035: goto L476;
            case -977343600: goto L473;
            case -972367967: goto L470;
            case -929732175: goto L467;
            case -897847258: goto L464;
            case -868374699: goto L461;
            case -858681673: goto L458;
            case -851262611: goto L455;
            case -803076562: goto L452;
            case -798441945: goto L449;
            case -776198914: goto L446;
            case -767436525: goto L443;
            case -740826157: goto L440;
            case -719241953: goto L437;
            case -696507843: goto L434;
            case -696046478: goto L431;
            case -689604287: goto L428;
            case -655740289: goto L425;
            case -654887831: goto L422;
            case -628555825: goto L419;
            case -625937929: goto L416;
            case -621977901: goto L413;
            case -615150787: goto L410;
            case -612860388: goto L407;
            case -602084215: goto L404;
            case -594166705: goto L401;
            case -582776969: goto L398;
            case -571933918: goto L395;
            case -539436197: goto L392;
            case -537121159: goto L389;
            case -491875086: goto L386;
            case -448866242: goto L383;
            case -435917014: goto L380;
            case -427385068: goto L377;
            case -379246765: goto L374;
            case -371532681: goto L371;
            case -362091789: goto L368;
            case -349329551: goto L365;
            case -347060727: goto L362;
            case -336304401: goto L359;
            case -318934084: goto L356;
            case -274298599: goto L353;
            case -272000052: goto L350;
            case -265622745: goto L347;
            case -265280401: goto L344;
            case -248948709: goto L341;
            case -232735685: goto L338;
            case -191462075: goto L335;
            case -188774978: goto L332;
            case -173890402: goto L329;
            case -173009607: goto L326;
            case -166380543: goto L323;
            case -127808917: goto L320;
            case -126762897: goto L317;
            case -116817109: goto L314;
            case -113221722: goto L311;
            case -44462226: goto L308;
            case -35642380: goto L305;
            case 26004728: goto L302;
            case 63735150: goto L299;
            case 100148683: goto L296;
            case 108041718: goto L293;
            case 127520821: goto L290;
            case 133053550: goto L287;
            case 141265046: goto L284;
            case 154807953: goto L281;
            case 160922992: goto L278;
            case 165097319: goto L275;
            case 195663544: goto L272;
            case 218309709: goto L269;
            case 225036552: goto L266;
            case 245268781: goto L263;
            case 307336038: goto L260;
            case 320619603: goto L257;
            case 359256246: goto L254;
            case 375149696: goto L251;
            case 389204342: goto L248;
            case 437708184: goto L245;
            case 477254501: goto L242;
            case 489576650: goto L239;
            case 536913917: goto L236;
            case 556149987: goto L233;
            case 576585513: goto L230;
            case 578831028: goto L227;
            case 638465148: goto L224;
            case 655835053: goto L221;
            case 678606883: goto L218;
            case 680522162: goto L215;
            case 685181225: goto L212;
            case 708137663: goto L209;
            case 720508273: goto L206;
            case 772574662: goto L203;
            case 772714756: goto L200;
            case 800642807: goto L197;
            case 809295979: goto L194;
            case 825320480: goto L191;
            case 896257518: goto L188;
            case 908074769: goto L185;
            case 931503455: goto L182;
            case 939806934: goto L179;
            case 940361321: goto L176;
            case 990077711: goto L173;
            case 992898896: goto L170;
            case 1000842558: goto L167;
            case 1017564965: goto L164;
            case 1039963182: goto L161;
            case 1046325534: goto L158;
            case 1050591241: goto L155;
            case 1053771019: goto L152;
            case 1082454878: goto L149;
            case 1083716917: goto L146;
            case 1089953215: goto L143;
            case 1090148925: goto L140;
            case 1100422327: goto L137;
            case 1151578439: goto L134;
            case 1159930051: goto L131;
            case 1175131247: goto L128;
            case 1175659459: goto L125;
            case 1288011390: goto L122;
            case 1290379635: goto L119;
            case 1309034040: goto L116;
            case 1320548620: goto L113;
            case 1331500625: goto L110;
            case 1370313704: goto L107;
            case 1430409564: goto L104;
            case 1431710924: goto L101;
            case 1437344373: goto L98;
            case 1448637083: goto L95;
            case 1449432659: goto L92;
            case 1547314828: goto L89;
            case 1574129454: goto L86;
            case 1584980089: goto L83;
            case 1621592376: goto L80;
            case 1629548198: goto L77;
            case 1659249938: goto L74;
            case 1671139040: goto L71;
            case 1678604719: goto L68;
            case 1681481137: goto L65;
            case 1695721708: goto L62;
            case 1710577680: goto L59;
            case 1712980032: goto L56;
            case 1720079129: goto L53;
            case 1737906817: goto L50;
            case 1738596336: goto L47;
            case 1771368059: goto L44;
            case 1829854820: goto L41;
            case 1832255454: goto L38;
            case 1857603160: goto L35;
            case 1870306505: goto L32;
            case 1883144456: goto L29;
            case 1893784739: goto L26;
            case 1897082165: goto L23;
            case 1913954624: goto L20;
            case 1923297687: goto L17;
            case 1923981014: goto L14;
            case 1968172362: goto L11;
            case 2064064623: goto L6;
            default: goto L904;
        };
    L904:
        return null;
    L6:
        if (r2.getName().equals("com.obric.assistant.obric_action.IObricActionService") == false) goto L679;
        HashSet r3 = new HashSet();
        r3.add(new ObricActionServiceImpl());
        String r0 = "com.obric.assistant.obric_action.IObricActionService";
    L8:
        putStaticServiceImplSetCache(r0, r3);
        return r3;
    L679:
        return null;
    L11:
        if (r2.getName().equals("com.bytedance.ai.api.navi.IAppletNaviService") == false) goto L681;
        r3 = new HashSet();
        r3.add(new AppletNaviServiceImpl());
        r0 = "com.bytedance.ai.api.navi.IAppletNaviService";
        goto L8
    L681:
        return null;
    L14:
        if (r2.getName().equals("com.ivy.ivykit.api.plugin.IIvyWebService") == false) goto L682;
        r3 = new HashSet();
        r3.add(new IvyWebServiceImpl());
        r0 = "com.ivy.ivykit.api.plugin.IIvyWebService";
        goto L8
    L682:
        return null;
    L17:
        if (r2.getName().equals("com.obric.assistant.spi.notification.IObricNotificationListenerService") == false) goto L683;
        r3 = new HashSet();
        r3.add(new ObricNotificationListenerServiceImpl());
        r0 = "com.obric.assistant.spi.notification.IObricNotificationListenerService";
        goto L8
    L683:
        return null;
    L20:
        if (r2.getName().equals("com.ss.android.ugc.aweme.search.common.service.IECSearchService") == false) goto L684;
        r3 = new HashSet();
        r3.add(new ECSearchServiceImpl());
        r0 = "com.ss.android.ugc.aweme.search.common.service.IECSearchService";
        goto L8
    L684:
        return null;
    L23:
        if (r2.getName().equals("com.larus.bmhome.chat.block.base.config.IBlockDetailNavigatorService") == false) goto L685;
        r3 = new HashSet();
        r3.add(new BlockDetailNavigatorServiceImpl());
        r0 = "com.larus.bmhome.chat.block.base.config.IBlockDetailNavigatorService";
        goto L8
    L685:
        return null;
    L26:
        if (r2.getName().equals("com.bytedance.android.ec.hybrid.service.IECEventCenterService") == false) goto L686;
        r3 = new HashSet();
        r3.add(new ECEventCenterSerivceDefaultImpl());
        r0 = "com.bytedance.android.ec.hybrid.service.IECEventCenterService";
        goto L8
    L686:
        return null;
    L29:
        if (r2.getName().equals("com.larus.bmhome.setting.IFragmentProvider") == false) goto L687;
        r3 = new HashSet();
        r3.add(new FragmentProviderImpl());
        r0 = "com.larus.bmhome.setting.IFragmentProvider";
        goto L8
    L687:
        return null;
    L32:
        if (r2.getName().equals("com.ivy.ivykit.api.plugin.IIvyLynxRuntimeService") == false) goto L688;
        r3 = new HashSet();
        r3.add(new IvyLynxRuntimeServiceImpl());
        r0 = "com.ivy.ivykit.api.plugin.IIvyLynxRuntimeService";
        goto L8
    L688:
        return null;
    L35:
        if (r2.getName().equals("com.bytedance.ai.api.AppletExtService") == false) goto L689;
        r3 = new HashSet();
        r3.add(new AppletExtServiceImpl());
        r0 = "com.bytedance.ai.api.AppletExtService";
        goto L8
    L689:
        return null;
    L38:
        if (r2.getName().equals("com.larus.bmhome.monitor.ICommonUIMessageImageLoaderService") == false) goto L690;
        r3 = new HashSet();
        r3.add(new CommonUIMessageImageLoaderImpl());
        r0 = "com.larus.bmhome.monitor.ICommonUIMessageImageLoaderService";
        goto L8
    L690:
        return null;
    L41:
        if (r2.getName().equals("com.larus.home.api.main.IPrivacyService") == false) goto L691;
        r3 = new HashSet();
        r3.add(new PrivacyServiceImpl());
        r0 = "com.larus.home.api.main.IPrivacyService";
        goto L8
    L691:
        return null;
    L44:
        if (r2.getName().equals("com.bytedance.bmf_mods_api.VideoSRLutAPI") == false) goto L692;
        r3 = new HashSet();
        r3.add(new VideoSRLut());
        r0 = "com.bytedance.bmf_mods_api.VideoSRLutAPI";
        goto L8
    L692:
        return null;
    L47:
        if (r2.getName().equals("com.bytedance.bmf_mods_api.MotionSenseAPI") == false) goto L693;
        r3 = new HashSet();
        r3.add(new MotionSense());
        r0 = "com.bytedance.bmf_mods_api.MotionSenseAPI";
        goto L8
    L693:
        return null;
    L50:
        if (r2.getName().equals("com.bytedance.android.ec.slice.adapter.api.IECSliceAdapterService") == false) goto L694;
        r3 = new HashSet();
        r3.add(new ECSliceAdapterServiceImpl());
        r0 = "com.bytedance.android.ec.slice.adapter.api.IECSliceAdapterService";
        goto L8
    L694:
        return null;
    L53:
        if (r2.getName().equals("com.bytedance.timon.foundation.interfaces.ILogger") == false) goto L695;
        r3 = new HashSet();
        r3.add(new AlogLoggerImpl());
        r0 = "com.bytedance.timon.foundation.interfaces.ILogger";
        goto L8
    L695:
        return null;
    L56:
        if (r2.getName().equals("com.larus.account.saas.coreapi.IAccountDeeplinkHandler") == false) goto L696;
        r3 = new HashSet();
        r3.add(new MfaDeeplinkHandler());
        r3.add(new AccountSecurityDeeplinkHandler());
        r0 = "com.larus.account.saas.coreapi.IAccountDeeplinkHandler";
        goto L8
    L696:
        return null;
    L59:
        if (r2.getName().equals("com.ss.android.ugc.aweme.live.ILivePluginApi") == false) goto L697;
        r3 = new HashSet();
        r3.add(new LivePluginImpl());
        r0 = "com.ss.android.ugc.aweme.live.ILivePluginApi";
        goto L8
    L697:
        return null;
    L62:
        if (r2.getName().equals("com.ivy.ivykit.api.plugin.IIvyHybridMonitorService") == false) goto L698;
        r3 = new HashSet();
        r3.add(new IvyHybridMonitorServiceImpl());
        r0 = "com.ivy.ivykit.api.plugin.IIvyHybridMonitorService";
        goto L8
    L698:
        return null;
    L65:
        if (r2.getName().equals("com.ivy.ivykit.api.plugin.IIvyPageService") == false) goto L699;
        r3 = new HashSet();
        r3.add(new IvyPageServiceImpl());
        r0 = "com.ivy.ivykit.api.plugin.IIvyPageService";
        goto L8
    L699:
        return null;
    L68:
        if (r2.getName().equals("com.bytedance.bmf_mods_api.DenoiseAPI") == false) goto L700;
        r3 = new HashSet();
        r3.add(new Denoise());
        r0 = "com.bytedance.bmf_mods_api.DenoiseAPI";
        goto L8
    L700:
        return null;
    L71:
        if (r2.getName().equals("com.obric.assistant.spi.chat.IObricChatExtensionService") == false) goto L701;
        r3 = new HashSet();
        r3.add(new ObricChatExtensionServiceImpl());
        r0 = "com.obric.assistant.spi.chat.IObricChatExtensionService";
        goto L8
    L701:
        return null;
    L74:
        if (r2.getName().equals("com.bytedance.android.shopping.api.mall.ILegouLynxBehaviorService") == false) goto L702;
        r3 = new HashSet();
        r3.add(new LegouLynxBehaviorDefaultService());
        r0 = "com.bytedance.android.shopping.api.mall.ILegouLynxBehaviorService";
        goto L8
    L702:
        return null;
    L77:
        if (r2.getName().equals("com.obric.assistant.actionbar.service.IObricActionBarTrackServiceExt") == false) goto L703;
        r3 = new HashSet();
        r3.add(new ObricActionBarTrackServiceImpl());
        r0 = "com.obric.assistant.actionbar.service.IObricActionBarTrackServiceExt";
        goto L8
    L703:
        return null;
    L80:
        if (r2.getName().equals("com.bytedance.timon.ruler.adapter.impl.IRulerHardCodeValidatorService") == false) goto L704;
        r3 = new HashSet();
        r3.add(new RulerHardCodeValidatorServiceImpl());
        r0 = "com.bytedance.timon.ruler.adapter.impl.IRulerHardCodeValidatorService";
        goto L8
    L704:
        return null;
    L83:
        if (r2.getName().equals("com.larus.account.saas.ui.IAccountSaasUiResourceResolver") == false) goto L705;
        r3 = new HashSet();
        r3.add(new DefaultAccountSaasUiResourceResolver());
        r0 = "com.larus.account.saas.ui.IAccountSaasUiResourceResolver";
        goto L8
    L705:
        return null;
    L86:
        if (r2.getName().equals("com.larus.account.saas.security.api.IAccountSecurityPushUiService") == false) goto L706;
        r3 = new HashSet();
        r3.add(new DefaultAccountSecurityPushUiService());
        r0 = "com.larus.account.saas.security.api.IAccountSecurityPushUiService";
        goto L8
    L706:
        return null;
    L89:
        if (r2.getName().equals("com.larus.bmhome.chat.IMarkdownResolver") == false) goto L707;
        r3 = new HashSet();
        r3.add(new MarkdownResolverServiceImpl());
        r0 = "com.larus.bmhome.chat.IMarkdownResolver";
        goto L8
    L707:
        return null;
    L92:
        if (r2.getName().equals("com.bytedance.timon_monitor_api.IMonitorBusinessService") == false) goto L708;
        r3 = new HashSet();
        r3.add(new MonitorBusinessServiceImpl());
        r0 = "com.bytedance.timon_monitor_api.IMonitorBusinessService";
        goto L8
    L708:
        return null;
    L95:
        if (r2.getName().equals("com.larus.bmhome.chat.api.IConversationFeedActionService") == false) goto L709;
        r3 = new HashSet();
        r3.add(new ConversationFeedActionServiceImpl());
        r0 = "com.larus.bmhome.chat.api.IConversationFeedActionService";
        goto L8
    L709:
        return null;
    L98:
        if (r2.getName().equals("com.larus.platform.IFlowSdkCommonDepend") == false) goto L710;
        r3 = new HashSet();
        r3.add(new FlowSdkCommonDependImpl());
        r0 = "com.larus.platform.IFlowSdkCommonDepend";
        goto L8
    L710:
        return null;
    L101:
        if (r2.getName().equals("com.larus.platform.api.ISdkTitleBarInflate") == false) goto L711;
        r3 = new HashSet();
        r3.add(new WindowSdkTitleBarInflateImpl());
        r0 = "com.larus.platform.api.ISdkTitleBarInflate";
        goto L8
    L711:
        return null;
    L104:
        if (r2.getName().equals("com.larus.bmhome.chat.model.repo.IConversationRepoService") == false) goto L712;
        r3 = new HashSet();
        r3.add(new ConversationRepo());
        r0 = "com.larus.bmhome.chat.model.repo.IConversationRepoService";
        goto L8
    L712:
        return null;
    L107:
        if (r2.getName().equals("com.ivy.ivykit.api.plugin.IvyPluginService") == false) goto L713;
        r3 = new HashSet();
        r3.add(new IvyPluginServiceImpl());
        r0 = "com.ivy.ivykit.api.plugin.IvyPluginService";
        goto L8
    L713:
        return null;
    L110:
        if (r2.getName().equals("com.larus.bmhome.double_post.api.IAwemeDoublePostTrackService") == false) goto L714;
        r3 = new HashSet();
        r3.add(new AwemeDoublePostTrackServiceImpl());
        r0 = "com.larus.bmhome.double_post.api.IAwemeDoublePostTrackService";
        goto L8
    L714:
        return null;
    L113:
        if (r2.getName().equals("com.obric.assistant.task.ITaskCenter") == false) goto L715;
        r3 = new HashSet();
        r3.add(new TaskManager());
        r0 = "com.obric.assistant.task.ITaskCenter";
        goto L8
    L715:
        return null;
    L116:
        if (r2.getName().equals("com.bytedance.timon.foundation.interfaces.IStore") == false) goto L716;
        r3 = new HashSet();
        r3.add(new KevaStoreImpl());
        r0 = "com.bytedance.timon.foundation.interfaces.IStore";
        goto L8
    L716:
        return null;
    L119:
        if (r2.getName().equals("com.bytedance.upc.common.device.IDeviceInfoService") == false) goto L717;
        r3 = new HashSet();
        r3.add(new DeviceInfoService());
        r0 = "com.bytedance.upc.common.device.IDeviceInfoService";
        goto L8
    L717:
        return null;
    L122:
        if (r2.getName().equals("com.larus.bmhome.chat.standarduikit.IStandardUiKitService") == false) goto L718;
        r3 = new HashSet();
        r3.add(new StandardUiKitServiceImpl());
        r0 = "com.larus.bmhome.chat.standarduikit.IStandardUiKitService";
        goto L8
    L718:
        return null;
    L125:
        if (r2.getName().equals("com.obric.assistant.oauto.IOAutoApi") == false) goto L719;
        r3 = new HashSet();
        r3.add(new OAutoImpl());
        r0 = "com.obric.assistant.oauto.IOAutoApi";
        goto L8
    L719:
        return null;
    L128:
        if (r2.getName().equals("com.bytedance.android.shopping.api.mall.mallSession.DeliveryEventApi") == false) goto L720;
        r3 = new HashSet();
        r3.add(new DeliveryEventServiceImpl());
        r0 = "com.bytedance.android.shopping.api.mall.mallSession.DeliveryEventApi";
        goto L8
    L720:
        return null;
    L131:
        if (r2.getName().equals("com.bytedance.bmf_mods_api.ColorHistAPI") == false) goto L721;
        r3 = new HashSet();
        r3.add(new ColorHist());
        r0 = "com.bytedance.bmf_mods_api.ColorHistAPI";
        goto L8
    L721:
        return null;
    L134:
        if (r2.getName().equals("com.larus.bmhome.chat.api.IMultimodalTraceService") == false) goto L722;
        r3 = new HashSet();
        r3.add(new MultimodalTraceService());
        r0 = "com.larus.bmhome.chat.api.IMultimodalTraceService";
        goto L8
    L722:
        return null;
    L137:
        if (r2.getName().equals("com.obric.assistant.spi.bootprotector.IObricBootProtectorSPIService") == false) goto L723;
        r3 = new HashSet();
        r3.add(new ObricBootProtectorServiceImpl());
        r0 = "com.obric.assistant.spi.bootprotector.IObricBootProtectorSPIService";
        goto L8
    L723:
        return null;
    L140:
        if (r2.getName().equals("com.larus.bmhome.chat.api.ILegacyChatUiService") == false) goto L724;
        r3 = new HashSet();
        r3.add(new LegacyChatServiceImpl());
        r0 = "com.larus.bmhome.chat.api.ILegacyChatUiService";
        goto L8
    L724:
        return null;
    L143:
        if (r2.getName().equals("com.obric.assistant.chat.IObricChatPageStateService") == false) goto L725;
        r3 = new HashSet();
        r3.add(new ObricChatPageStateServiceImpl());
        r0 = "com.obric.assistant.chat.IObricChatPageStateService";
        goto L8
    L725:
        return null;
    L146:
        if (r2.getName().equals("com.obric.capabilitykit.common.intent.IntentFunction") == false) goto L726;
        r3 = new HashSet();
        r3.add(new BaseAppFuncExecuteIntent());
        r3.add(new BaseAudioControlPauseIntent());
        r3.add(new BaseAudioControlPlayFromScratchIntent());
        r3.add(new BaseAudioControlPlayIntent());
        r3.add(new BaseAudioControlPlayNextIntent());
        r3.add(new BaseAudioControlPlayPreviousIntent());
        r3.add(new BaseAudioControlSeekToIntent());
        r3.add(new BaseBrowserUseIntent());
        r3.add(new BaseCalculatorCalculateIntent());
        r3.add(new BaseCalendarShowScheduleIntent());
        r3.add(new BaseCameraRotateCameraIntent());
        r3.add(new BaseCameraSetAuxiliaryLineIntent());
        r3.add(new BaseCameraSetEVIntent());
        r3.add(new BaseCameraSetExposureTimeIntent());
        r3.add(new BaseCameraSetFilterIntent());
        r3.add(new BaseCameraSetFlashModeIntent());
        r3.add(new BaseCameraSetFocalIntent());
        r3.add(new BaseCameraSetFocusDistanceIntent());
        r3.add(new BaseCameraSetISOIntent());
        r3.add(new BaseCameraSetImageRatioIntent());
        r3.add(new BaseCameraSetMeteringModeIntent());
        r3.add(new BaseCameraSetSelfTimerIntent());
        r3.add(new BaseCameraSetTouchCaptureIntent());
        r3.add(new BaseCameraSetWBIntent());
        r3.add(new BaseCameraStartCaptureIntent());
        r3.add(new BaseCameraStartRecordingIntent());
        r3.add(new BaseCameraStopCaptureIntent());
        r3.add(new BaseCameraSwitchCameraModeIntent());
        r3.add(new BaseClockCreateAlarmIntent());
        r3.add(new BaseClockDeleteAlarmIntent());
        r3.add(new BaseClockDeleteCountdownIntent());
        r3.add(new BaseClockPauseCountdownIntent());
        r3.add(new BaseClockResumeCountdownIntent());
        r3.add(new BaseClockSearchAlarmIntent());
        r3.add(new BaseClockSearchCountdownIntent());
        r3.add(new BaseClockShowAlarmIntent());
        r3.add(new BaseClockShowCountdownIntent());
        r3.add(new BaseClockStartCountdownIntent());
        r3.add(new BaseClockTurnOffAlarmIntent());
        r3.add(new BaseClockTurnOnAlarmIntent());
        r3.add(new BaseClockUpdateAlarmIntent());
        r3.add(new BaseCommonViewEntitiesIntent());
        r3.add(new BaseContactsAddToBlocklistIntent());
        r3.add(new BaseContactsAddToFavoriteIntent());
        r3.add(new BaseContactsCreateIntent());
        r3.add(new BaseContactsDeleteIntent());
        r3.add(new BaseContactsSearchIntent());
        r3.add(new BaseContactsShowContactIntent());
        r3.add(new BaseContactsUpdateIntent());
        r3.add(new BaseDoubaoRealTimeScreenShareIntent());
        r3.add(new BaseDoubaoRealTimeVideoCallIntent());
        r3.add(new BaseDoubaoRealTimeVoiceCallIntent());
        r3.add(new BaseEventTaskCreateDraftIntent());
        r3.add(new BaseEventTaskGetTaskInfoIntent());
        r3.add(new BaseEventTaskSubmitTaskIntent());
        r3.add(new BaseEventTaskUpdateTaskIntent());
        r3.add(new BaseFilesShowFileIntent());
        r3.add(new BaseFinanceSearchStockIntent());
        r3.add(new BaseGUIActionIntent());
        r3.add(new BaseGUIINITIntent());
        r3.add(new BaseGUIReplyIntent());
        r3.add(new BaseGUIScreenshotIntent());
        r3.add(new BaseMapNaviRouteIntent());
        r3.add(new BaseMapSearchPOIIntent());
        r3.add(new BaseMapTakeTaxiIntent());
        r3.add(new BaseMemoryDeleteIntent());
        r3.add(new BaseMemoryOperateIntent());
        r3.add(new BaseMemoryOperateNewIntent());
        r3.add(new BaseMemoryProduceIntent());
        r3.add(new BaseMemorySaveDialogueMemoryIntent());
        r3.add(new BaseMemorySearchIntent());
        r3.add(new BaseMessagesDeleteIntent());
        r3.add(new BaseMessagesSearchIntent());
        r3.add(new BaseMessagesSendIntent());
        r3.add(new BaseMessagesShowMessageIntent());
        r3.add(new BaseNetEaseCloudMusicSearchIntent());
        r3.add(new BaseNotesCreateIntent());
        r3.add(new BaseNotesSearchIntent());
        r3.add(new BaseNotesShowNoteIntent());
        r3.add(new BaseNotesUpdateIntent());
        r3.add(new BaseOfficeBookMeetingIntent());
        r3.add(new BaseOfficeCheckLoginIntent());
        r3.add(new BaseOfficeJumpToLarkUrlIntent());
        r3.add(new BaseOfficeKnowledgeAIAuthIntent());
        r3.add(new BaseOfficeKnowledgeAIIntent());
        r3.add(new BaseOfficeLarkCLICheckLoginIntent());
        r3.add(new BaseOfficeLarkCLIEnsureAuthIntent());
        r3.add(new BaseOfficeSearchLarkContactInfoByAsrIntent());
        r3.add(new BaseOfficeSearchLarkContactInfoByNameIntent());
        r3.add(new BaseOfficeSearchMeetingIntent());
        r3.add(new BaseOfficeSendMessageIntent());
        r3.add(new BasePCAppFcEntitySearchIntent());
        r3.add(new BasePCCommonGlobalSearchIntent());
        r3.add(new BasePCDoubaoGlobalSearchIntent());
        r3.add(new BasePCEntityPoisonLabelIntent());
        r3.add(new BasePCGetImageUrlIntent());
        r3.add(new BasePCGlobalSearchIntent());
        r3.add(new BasePCGlobalSearchIntentIntent());
        r3.add(new BasePCIntentGlobalSearchIntent());
        r3.add(new BasePCPersonalContextFetchIntent());
        r3.add(new BasePCPersonalContextSearchIntent());
        r3.add(new BasePCProactiveEventsIntent());
        r3.add(new BasePCSearchAppEntityIntent());
        r3.add(new BasePhoneCallIntent());
        r3.add(new BasePhoneDeleteIntent());
        r3.add(new BasePhoneGetSimIntent());
        r3.add(new BasePhoneOpenPageIntent());
        r3.add(new BasePhoneProxyCallIntent());
        r3.add(new BasePhoneSearchIntent());
        r3.add(new BasePhoneShowCallHistoryIntent());
        r3.add(new BasePhotoAddPhotosToAlbumIntent());
        r3.add(new BasePhotoAddToFavoriteIntent());
        r3.add(new BasePhotoCreateAlbumIntent());
        r3.add(new BasePhotoCropIntent());
        r3.add(new BasePhotoDeleteAlbumIntent());
        r3.add(new BasePhotoDeletePhotoIntent());
        r3.add(new BasePhotoGenerateVideoIntent());
        r3.add(new BasePhotoOpenAlbumIntent());
        r3.add(new BasePhotoPaintPhotoIntent());
        r3.add(new BasePhotoRemovePhotosFromAlbumIntent());
        r3.add(new BasePhotoSearchAlbumIntent());
        r3.add(new BasePhotoSearchIntent());
        r3.add(new BasePhotoSetBrightnessIntent());
        r3.add(new BasePhotoSetClarityIntent());
        r3.add(new BasePhotoSetContrastIntent());
        r3.add(new BasePhotoSetExposureIntent());
        r3.add(new BasePhotoSetFadeIntent());
        r3.add(new BasePhotoSetFilterIntent());
        r3.add(new BasePhotoSetRotationIntent());
        r3.add(new BasePhotoSetSaturationIntent());
        r3.add(new BasePhotoSetShadowIntent());
        r3.add(new BasePhotoSetSharpnessIntent());
        r3.add(new BasePhotoSetToneIntent());
        r3.add(new BasePhotoSetWarmIntent());
        r3.add(new BasePhotoShowAlbumIntent());
        r3.add(new BasePhotoShowPhotoIntent());
        r3.add(new BasePhotoUpdateAlbumIntent());
        r3.add(new BaseRCComplexTaskContextIntent());
        r3.add(new BaseRCDeviceStateIntent());
        r3.add(new BaseRCSearchIntent());
        r3.add(new BaseRecorderDeleteIntent());
        r3.add(new BaseRecorderOperateIntent());
        r3.add(new BaseRecorderShowRecordingIntent());
        r3.add(new BaseSemanticSupplementIntent());
        r3.add(new BaseShortVideoSearchIntent());
        r3.add(new BaseSystemAdjustBrightnessIntent());
        r3.add(new BaseSystemAdjustVolumeIntent());
        r3.add(new BaseSystemAskUserIntent());
        r3.add(new BaseSystemAutoActionIntent());
        r3.add(new BaseSystemCheckPermissionsIntent());
        r3.add(new BaseSystemDataSyncTriggerIntent());
        r3.add(new BaseSystemDeviceStateIntent());
        r3.add(new BaseSystemDownloadAppIntent());
        r3.add(new BaseSystemFindPhoneIntent());
        r3.add(new BaseSystemGetAppLatestVersionIntent());
        r3.add(new BaseSystemGetLocationIntent());
        r3.add(new BaseSystemGetWebUrlIntent());
        r3.add(new BaseSystemHeartBeatIntent());
        r3.add(new BaseSystemInAppSearchIntent());
        r3.add(new BaseSystemJumpAppStoreIntent());
        r3.add(new BaseSystemLocationRequestIntent());
        r3.add(new BaseSystemMultiUserSelectIntent());
        r3.add(new BaseSystemOpenAppIntent());
        r3.add(new BaseSystemOpenPageIntent());
        r3.add(new BaseSystemPowerLockControlIntent());
        r3.add(new BaseSystemQAWithSearchIntent());
        r3.add(new BaseSystemRebootIntent());
        r3.add(new BaseSystemRequestPermissionsIntent());
        r3.add(new BaseSystemScreenRecordIntent());
        r3.add(new BaseSystemScreenshotIntent());
        r3.add(new BaseSystemSetBrightnessIntent());
        r3.add(new BaseSystemSetVolumeIntent());
        r3.add(new BaseSystemSettingsAvailableIntent());
        r3.add(new BaseSystemShellIntent());
        r3.add(new BaseSystemShowEntitiesIntent());
        r3.add(new BaseSystemShutdownIntent());
        r3.add(new BaseSystemSkillIntent());
        r3.add(new BaseSystemStopActionIntent());
        r3.add(new BaseSystemSwitchModeIntent());
        r3.add(new BaseSystemSwitchNotificationIntent());
        r3.add(new BaseSystemUpdatePermissionsIntent());
        r3.add(new BaseSystemUserAuthorizeIntent());
        r3.add(new BaseSystemUserConfirmIntent());
        r3.add(new BaseSystemUserRemindIntent());
        r3.add(new BaseSystemUserSelectIntent());
        r3.add(new BaseTravelSearchFlightIntent());
        r3.add(new BaseTravelSearchHotelIntent());
        r3.add(new BaseTravelSearchTrainIntent());
        r3.add(new BaseWeatherSearchIntent());
        r3.add(new BaseWeatherShowIntent());
        r0 = "com.obric.capabilitykit.common.intent.IntentFunction";
        goto L8
    L726:
        return null;
    L149:
        if (r2.getName().equals("com.larus.bmhome.chat.actionbar.IActionBarService") == false) goto L727;
        r3 = new HashSet();
        r3.add(new ActionBarServiceImpl());
        r0 = "com.larus.bmhome.chat.actionbar.IActionBarService";
        goto L8
    L727:
        return null;
    L152:
        if (r2.getName().equals("com.bytedance.bmf_mods_api.NoiseDetectAPI") == false) goto L728;
        r3 = new HashSet();
        r3.add(new NoiseDetect());
        r0 = "com.bytedance.bmf_mods_api.NoiseDetectAPI";
        goto L8
    L728:
        return null;
    L155:
        if (r2.getName().equals("com.larus.voicecall.obric.IObricRealtimeCallService") == false) goto L729;
        r3 = new HashSet();
        r3.add(new ObricRealtimeCallServiceImpl());
        r0 = "com.larus.voicecall.obric.IObricRealtimeCallService";
        goto L8
    L729:
        return null;
    L158:
        if (r2.getName().equals("com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService") == false) goto L730;
        r3 = new HashSet();
        r3.add(new IvyAIPackageResourceServiceImpl());
        r0 = "com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService";
        goto L8
    L730:
        return null;
    L161:
        if (r2.getName().equals("com.bytedance.timon.upc.upc_adapter_api.IUpcBusinessService") == false) goto L731;
        r3 = new HashSet();
        r3.add(new UpcBusinessServiceImpl());
        r0 = "com.bytedance.timon.upc.upc_adapter_api.IUpcBusinessService";
        goto L8
    L731:
        return null;
    L164:
        if (r2.getName().equals("com.obric.assistant.actionbar.service.IObricActionBarSendServiceExt") == false) goto L732;
        r3 = new HashSet();
        r3.add(new ObricActionBarSendServiceImpl());
        r0 = "com.obric.assistant.actionbar.service.IObricActionBarSendServiceExt";
        goto L8
    L732:
        return null;
    L167:
        if (r2.getName().equals("com.larus.platform.api.IOfficeUrlPreviewHostService") == false) goto L733;
        r3 = new HashSet();
        r3.add(new FlowOfficeUrlPreviewHostService());
        r0 = "com.larus.platform.api.IOfficeUrlPreviewHostService";
        goto L8
    L733:
        return null;
    L170:
        if (r2.getName().equals("com.obric.assistant.spi.dora.IObricVendorPrivateLinkService") == false) goto L734;
        r3 = new HashSet();
        r3.add(new VendorPrivateLinkServiceImpl());
        r0 = "com.obric.assistant.spi.dora.IObricVendorPrivateLinkService";
        goto L8
    L734:
        return null;
    L173:
        if (r2.getName().equals("com.larus.bmhome.utils.ILandingRedBadgeHelper") == false) goto L735;
        r3 = new HashSet();
        r3.add(new LandingRedBadgeHelper());
        r0 = "com.larus.bmhome.utils.ILandingRedBadgeHelper";
        goto L8
    L735:
        return null;
    L176:
        if (r2.getName().equals("com.obric.assistant.upload.IObricUploadService") == false) goto L736;
        r3 = new HashSet();
        r3.add(new ObricUploadService());
        r0 = "com.obric.assistant.upload.IObricUploadService";
        goto L8
    L736:
        return null;
    L179:
        if (r2.getName().equals("com.larus.account.saas.ui.IAccountLoadingUiService") == false) goto L737;
        r3 = new HashSet();
        r3.add(new DefaultAccountLoadingUiService());
        r0 = "com.larus.account.saas.ui.IAccountLoadingUiService";
        goto L8
    L737:
        return null;
    L182:
        if (r2.getName().equals("com.larus.dora.api.offline.record.IDoraOfflineRecordSyncService") == false) goto L738;
        r3 = new HashSet();
        r3.add(new DoraOfflineRecordSyncServiceImpl());
        r0 = "com.larus.dora.api.offline.record.IDoraOfflineRecordSyncService";
        goto L8
    L738:
        return null;
    L185:
        if (r2.getName().equals("com.larus.account.saas.security.api.IAccountRiskDialogUiService") == false) goto L739;
        r3 = new HashSet();
        r3.add(new DefaultAccountRiskDialogUiService());
        r0 = "com.larus.account.saas.security.api.IAccountRiskDialogUiService";
        goto L8
    L739:
        return null;
    L188:
        if (r2.getName().equals("com.bytedance.android.ec.hybrid.service.IMallDeepFeedAnimationService") == false) goto L740;
        r3 = new HashSet();
        r3.add(new MallDeepFeedAnimationServiceImpl());
        r0 = "com.bytedance.android.ec.hybrid.service.IMallDeepFeedAnimationService";
        goto L8
    L740:
        return null;
    L191:
        if (r2.getName().equals("com.larus.bmhome.chat.model.repo.IBotRepoService") == false) goto L741;
        r3 = new HashSet();
        r3.add(new BotRepo());
        r0 = "com.larus.bmhome.chat.model.repo.IBotRepoService";
        goto L8
    L741:
        return null;
    L194:
        if (r2.getName().equals("com.obric.assistant.login.ILoginReport") == false) goto L742;
        r3 = new HashSet();
        r3.add(new LoginReportImpl());
        r0 = "com.obric.assistant.login.ILoginReport";
        goto L8
    L742:
        return null;
    L197:
        if (r2.getName().equals("com.bytedance.timonbase.ITMLifecycleService") == false) goto L743;
        r3 = new HashSet();
        r3.add(new TMClipboardLifecycleServiceImpl());
        r3.add(new RulerServiceImpl());
        r3.add(new UpcLifecycleServiceImpl());
        r3.add(new CacheLifecycleServiceImpl());
        r3.add(new MonitorLifecycleServiceImpl());
        r3.add(new TMBaseLifecycleService());
        r0 = "com.bytedance.timonbase.ITMLifecycleService";
        goto L8
    L743:
        return null;
    L200:
        if (r2.getName().equals("com.obric.assistant.obric_action.IObricActionHandler") == false) goto L744;
        r3 = new HashSet();
        r3.add(new ObricOpenEventTaskDetailHandler());
        r3.add(new OpenAutoGuiSettingsActionHandler());
        r3.add(new OpenCreateShortcutHandler());
        r3.add(new OpenSkillDetailActionHandler());
        r3.add(new FinishCurrentPageHandler());
        r3.add(new ActivityActionHandler());
        r3.add(new BroadcastActionHandler());
        r3.add(new ServiceActionHandler());
        r3.add(new DismissKeyguardActionHandler());
        r3.add(new KeyguardStatusActionHandler());
        r3.add(new RequestBiometricAuthActionHandler());
        r3.add(new RequestDeviceCredentialAuthActionHandler());
        r3.add(new RequestVoicePrintAuthActionHandler());
        r3.add(new SessionAuthStatusActionHandler());
        r3.add(new HideKeyboardActionHandler());
        r3.add(new OpenAdditionInputPanelHandler());
        r3.add(new OpenClarifyInputPanelHandler());
        r3.add(new OpenNewTaskPanelHandler());
        r3.add(new OpenWindowActionHandler());
        r3.add(new PopWindowActionHandler());
        r3.add(new ShowKeyboardActionHandler());
        r3.add(new StashWindowActionHandler());
        r3.add(new FeedbackHapticActionHandler());
        r3.add(new FeedbackSoundActionHandler());
        r3.add(new FeedbackToastActionHandler());
        r3.add(new ResendMessageActionHandler());
        r3.add(new SendMessageActionHandler());
        r3.add(new OmniTaskFeedbackHandler());
        r3.add(new StopOmniTaskHandler());
        r3.add(new PromptConfirmDialogActionHandler());
        r3.add(new PromptOptionsDialogActionHandler());
        r3.add(new DeepLinkActionHandler());
        r3.add(new ShortLinkApiActionHandler());
        r0 = "com.obric.assistant.obric_action.IObricActionHandler";
        goto L8
    L744:
        return null;
    L203:
        if (r2.getName().equals("com.larus.bmhome.chat.feedback.IChatFeedbackService") == false) goto L745;
        r3 = new HashSet();
        r3.add(new ChatFeedbackServiceImpl());
        r0 = "com.larus.bmhome.chat.feedback.IChatFeedbackService";
        goto L8
    L745:
        return null;
    L206:
        if (r2.getName().equals("com.obric.assistant.desktop_icon.IObricAddDesktopIconService") == false) goto L746;
        r3 = new HashSet();
        r3.add(new ObricAddDesktopIconServiceImpl());
        r0 = "com.obric.assistant.desktop_icon.IObricAddDesktopIconService";
        goto L8
    L746:
        return null;
    L209:
        if (r2.getName().equals("com.larus.bmhome.chat.deepthink.IDeepThinkBlockService") == false) goto L747;
        r3 = new HashSet();
        r3.add(new DeepThinkBlockServiceImpl());
        r0 = "com.larus.bmhome.chat.deepthink.IDeepThinkBlockService";
        goto L8
    L747:
        return null;
    L212:
        if (r2.getName().equals("com.obric.assistant.feedback.IObricFeedbackService") == false) goto L748;
        r3 = new HashSet();
        r3.add(new ObricFeedbackService());
        r0 = "com.obric.assistant.feedback.IObricFeedbackService";
        goto L8
    L748:
        return null;
    L215:
        if (r2.getName().equals("com.obric.assistant.chat.IObricChatContextService") == false) goto L749;
        r3 = new HashSet();
        r3.add(new ObricChatContextServiceImpl());
        r0 = "com.obric.assistant.chat.IObricChatContextService";
        goto L8
    L749:
        return null;
    L218:
        if (r2.getName().equals("com.obric.assistant.spi.dora.IObricVendorBluetoothQueryService") == false) goto L750;
        r3 = new HashSet();
        r3.add(new ObricVendorBluetoothQueryServiceImpl());
        r0 = "com.obric.assistant.spi.dora.IObricVendorBluetoothQueryService";
        goto L8
    L750:
        return null;
    L221:
        if (r2.getName().equals("com.ss.android.ugc.aweme.search.ecommerce.api.IECSearchGrowMarketingService") == false) goto L751;
        r3 = new HashSet();
        r3.add(new ECSearchGrowMarketingServiceImpl());
        r0 = "com.ss.android.ugc.aweme.search.ecommerce.api.IECSearchGrowMarketingService";
        goto L8
    L751:
        return null;
    L224:
        if (r2.getName().equals("com.larus.avlink.api.IAlbumService") == false) goto L752;
        r3 = new HashSet();
        r3.add(new AlbumImpl());
        r0 = "com.larus.avlink.api.IAlbumService";
        goto L8
    L752:
        return null;
    L227:
        if (r2.getName().equals("com.larus.bmhome.chat.nestedmenu.IMainBotNestedMenuService") == false) goto L753;
        r3 = new HashSet();
        r3.add(new NestMenuServiceImpl());
        r0 = "com.larus.bmhome.chat.nestedmenu.IMainBotNestedMenuService";
        goto L8
    L753:
        return null;
    L230:
        if (r2.getName().equals("com.bytedance.android.ec.hybrid.service.IECMallFeedServiceAdApter") == false) goto L754;
        r3 = new HashSet();
        r3.add(new ECMallFeedServiceAdapter());
        r0 = "com.bytedance.android.ec.hybrid.service.IECMallFeedServiceAdApter";
        goto L8
    L754:
        return null;
    L233:
        if (r2.getName().equals("com.obric.assistant.state.ISharedStateService") == false) goto L755;
        r3 = new HashSet();
        r3.add(new ShareStateServiceImpl());
        r0 = "com.obric.assistant.state.ISharedStateService";
        goto L8
    L755:
        return null;
    L236:
        if (r2.getName().equals("com.obric.assistant.guide.IObricUserGuide") == false) goto L756;
        r3 = new HashSet();
        r3.add(new ObricUserGuideImpl());
        r0 = "com.obric.assistant.guide.IObricUserGuide";
        goto L8
    L756:
        return null;
    L239:
        if (r2.getName().equals("com.larus.bmhome.chat.headerinfo.IDeepThinkHeaderService") == false) goto L757;
        r3 = new HashSet();
        r3.add(new DeepThinkHeaderServiceImpl());
        r0 = "com.larus.bmhome.chat.headerinfo.IDeepThinkHeaderService";
        goto L8
    L757:
        return null;
    L242:
        if (r2.getName().equals("com.bytedance.bmf_mods_api.VqscoreLiveAPI") == false) goto L758;
        r3 = new HashSet();
        r3.add(new VqscoreLive());
        r0 = "com.bytedance.bmf_mods_api.VqscoreLiveAPI";
        goto L8
    L758:
        return null;
    L245:
        if (r2.getName().equals("com.bytedance.timon.ruler.adapter.impl.IRulerBusinessService") == false) goto L759;
        r3 = new HashSet();
        r3.add(new RulerBusinessServiceImpl());
        r0 = "com.bytedance.timon.ruler.adapter.impl.IRulerBusinessService";
        goto L8
    L759:
        return null;
    L248:
        if (r2.getName().equals("com.larus.bmhome.chat.camera.command.CameraCommandSideEffectFactory") == false) goto L760;
        r3 = new HashSet();
        r3.add(new CameraCommandSideEffectFactoryImpl());
        r0 = "com.larus.bmhome.chat.camera.command.CameraCommandSideEffectFactory";
        goto L8
    L760:
        return null;
    L251:
        if (r2.getName().equals("com.bytedance.upc.IUpcBusinessService") == false) goto L761;
        r3 = new HashSet();
        r3.add(new CommonBusinessService());
        r3.add(new DeviceInfoService());
        r0 = "com.bytedance.upc.IUpcBusinessService";
        goto L8
    L761:
        return null;
    L254:
        if (r2.getName().equals("com.bytedance.android.shopping.api.mall.mallSession.IDeliveryCompatApi") == false) goto L762;
        r3 = new HashSet();
        r3.add(new DeliveryCompatImpl());
        r0 = "com.bytedance.android.shopping.api.mall.mallSession.IDeliveryCompatApi";
        goto L8
    L762:
        return null;
    L257:
        if (r2.getName().equals("com.obric.assistant.spi.chat.IObricChatSPIService") == false) goto L763;
        r3 = new HashSet();
        r3.add(new ObricChatSPIServiceImpl());
        r0 = "com.obric.assistant.spi.chat.IObricChatSPIService";
        goto L8
    L763:
        return null;
    L260:
        if (r2.getName().equals("com.obric.assistant.utils.IObricAssistantUtilHelperService") == false) goto L764;
        r3 = new HashSet();
        r3.add(new ObricAssistantUtilHelperServiceImpl());
        r0 = "com.obric.assistant.utils.IObricAssistantUtilHelperService";
        goto L8
    L764:
        return null;
    L263:
        if (r2.getName().equals("com.ivy.ivykit.api.plugin.IvyResourceService") == false) goto L765;
        r3 = new HashSet();
        r3.add(new IvyResourceServiceImpl());
        r0 = "com.ivy.ivykit.api.plugin.IvyResourceService";
        goto L8
    L765:
        return null;
    L266:
        if (r2.getName().equals("com.bytedance.bmf_mods_api.ByteStreamHDAPI") == false) goto L766;
        r3 = new HashSet();
        r3.add(new ByteStreamHD());
        r0 = "com.bytedance.bmf_mods_api.ByteStreamHDAPI";
        goto L8
    L766:
        return null;
    L269:
        if (r2.getName().equals("com.larus.bmhome.chat.component.list.pipeline.TimestampTaskProvider") == false) goto L767;
        r3 = new HashSet();
        r3.add(new SpecialProvider());
        r0 = "com.larus.bmhome.chat.component.list.pipeline.TimestampTaskProvider";
        goto L8
    L767:
        return null;
    L272:
        if (r2.getName().equals("com.larus.bmhome.chat.model.repo.IRepoDispatcherService") == false) goto L768;
        r3 = new HashSet();
        r3.add(new RepoDispatcherImpl());
        r0 = "com.larus.bmhome.chat.model.repo.IRepoDispatcherService";
        goto L8
    L768:
        return null;
    L275:
        if (r2.getName().equals("com.larus.bmhome.chat.model.repo.IChatRepoService") == false) goto L769;
        r3 = new HashSet();
        r3.add(new ChatRepo());
        r0 = "com.larus.bmhome.chat.model.repo.IChatRepoService";
        goto L8
    L769:
        return null;
    L278:
        if (r2.getName().equals("com.larus.dora.api.config.IDoraPageConfig") == false) goto L770;
        r3 = new HashSet();
        r3.add(new DoraPageConfigServiceImpl());
        r0 = "com.larus.dora.api.config.IDoraPageConfig";
        goto L8
    L770:
        return null;
    L281:
        if (r2.getName().equals("com.larus.navigation.api.INavigationTestEntry") == false) goto L771;
        r3 = new HashSet();
        r3.add(new NavigationTestEntry());
        r0 = "com.larus.navigation.api.INavigationTestEntry";
        goto L8
    L771:
        return null;
    L284:
        if (r2.getName().equals("com.obric.assistant.audio.service.IObricLiveService") == false) goto L772;
        r3 = new HashSet();
        r3.add(new ObricLiveService());
        r0 = "com.obric.assistant.audio.service.IObricLiveService";
        goto L8
    L772:
        return null;
    L287:
        if (r2.getName().equals("com.obric.assistant.shortcut.IObricShortCutsService") == false) goto L773;
        r3 = new HashSet();
        r3.add(new ObricShortCutsServiceImpl());
        r0 = "com.obric.assistant.shortcut.IObricShortCutsService";
        goto L8
    L773:
        return null;
    L290:
        if (r2.getName().equals("com.ss.aweme.paas.IAwemePaasTarget") == false) goto L774;
        r3 = new HashSet();
        r3.add(new APDefaultTarget());
        r3.add(new APDouyinTarget());
        r3.add(new APDyliteTarget());
        r3.add(new APHubbleTarget());
        r3.add(new APHuoShanTarget());
        r3.add(new APJingxuanTarget());
        r3.add(new APLegouTarget());
        r0 = "com.ss.aweme.paas.IAwemePaasTarget";
        goto L8
    L774:
        return null;
    L293:
        if (r2.getName().equals("com.obric.assistant.settings.spi.IObricSettingProvider") == false) goto L775;
        r3 = new HashSet();
        r3.add(new AILabSettingProvider());
        r3.add(new AlwaysRespondWakeupSettingProvider());
        r3.add(new AutoEndConversationSettingProvider());
        r3.add(new AutoGuiSettingProvider());
        r3.add(new AutoImageUploadSettingProvider());
        r3.add(new CocreationReviewSettingProvider());
        r3.add(new ContinueSpeakNoiseReductionSettingProvider());
        r3.add(new ContinueSpeakSettingProvider());
        r3.add(new DesktopIconSettingProvider());
        r3.add(new DoraSettingProvider());
        r3.add(new DoubaoWhisperSettingProvider());
        r3.add(new LockedScreenUseSettingProvider());
        r3.add(new MemoryDataMigrationSettingProvider());
        r3.add(new MemoryDataSettingProvider());
        r3.add(new MemorySettingProvider());
        r3.add(new ObricUserExperiencePlanSettingProvider());
        r3.add(new PcInAsrSettingProvider());
        r3.add(new ReferenceMemorySettingProvider());
        r3.add(new TtsPlayBackgroundSettingProvider());
        r3.add(new VoicePrintManagementSettingProvider());
        r3.add(new VoiceWakeupSettingProvider());
        r3.add(new WakeupSoundEffectSettingProvider());
        r0 = "com.obric.assistant.settings.spi.IObricSettingProvider";
        goto L8
    L775:
        return null;
    L296:
        if (r2.getName().equals("com.larus.bmhome.instruction.helper.IConvReplyModeRecordHelper") == false) goto L776;
        r3 = new HashSet();
        r3.add(new ConvReplyModeRecordHelper());
        r0 = "com.larus.bmhome.instruction.helper.IConvReplyModeRecordHelper";
        goto L8
    L776:
        return null;
    L299:
        if (r2.getName().equals("com.larus.bmhome.chat.api.IAppletGrantingWidgetService") == false) goto L777;
        r3 = new HashSet();
        r3.add(new AppletGrantingWidgetServiceImpl());
        r0 = "com.larus.bmhome.chat.api.IAppletGrantingWidgetService";
        goto L8
    L777:
        return null;
    L302:
        if (r2.getName().equals("com.bytedance.bmf_mods_api.HydraHDRAPI") == false) goto L778;
        r3 = new HashSet();
        r3.add(new HydraHDR());
        r0 = "com.bytedance.bmf_mods_api.HydraHDRAPI";
        goto L8
    L778:
        return null;
    L305:
        if (r2.getName().equals("com.larus.home.api.keva.IKevaPreloadService") == false) goto L779;
        r3 = new HashSet();
        r3.add(new KevaPreloadServiceImpl());
        r0 = "com.larus.home.api.keva.IKevaPreloadService";
        goto L8
    L779:
        return null;
    L308:
        if (r2.getName().equals("com.obric.assistant.spi.task.IObricTaskSkillService") == false) goto L780;
        r3 = new HashSet();
        r3.add(new ObricTaskSkillServiceImpl());
        r0 = "com.obric.assistant.spi.task.IObricTaskSkillService";
        goto L8
    L780:
        return null;
    L311:
        if (r2.getName().equals("com.larus.bmhome.chat.tips.IGuideTipsService") == false) goto L781;
        r3 = new HashSet();
        r3.add(new GuideTipsService());
        r0 = "com.larus.bmhome.chat.tips.IGuideTipsService";
        goto L8
    L781:
        return null;
    L314:
        if (r2.getName().equals("com.bytedance.android.btm.impl.provider.IBtmConfigFromEcom") == false) goto L782;
        r3 = new HashSet();
        r3.add(new EcomConfigForBtmImpl());
        r0 = "com.bytedance.android.btm.impl.provider.IBtmConfigFromEcom";
        goto L8
    L782:
        return null;
    L317:
        if (r2.getName().equals("com.larus.multitask_management.api.customize.ITaskActionHandler") == false) goto L783;
        r3 = new HashSet();
        r3.add(new MultiComplexTaskActionHandler());
        r0 = "com.larus.multitask_management.api.customize.ITaskActionHandler";
        goto L8
    L783:
        return null;
    L320:
        if (r2.getName().equals("com.larus.bmhome.chat.input.swipe.InputSwipePanelService") == false) goto L784;
        r3 = new HashSet();
        r3.add(new InputSwipePanelServiceImpl());
        r0 = "com.larus.bmhome.chat.input.swipe.InputSwipePanelService";
        goto L8
    L784:
        return null;
    L323:
        if (r2.getName().equals("com.bytedance.bmf_mods_api.SitiAPI") == false) goto L785;
        r3 = new HashSet();
        r3.add(new Siti());
        r0 = "com.bytedance.bmf_mods_api.SitiAPI";
        goto L8
    L785:
        return null;
    L326:
        if (r2.getName().equals("com.obric.assistant.storage.IObricLowStorageService") == false) goto L786;
        r3 = new HashSet();
        r3.add(new ObricLowStorageServiceImpl());
        r0 = "com.obric.assistant.storage.IObricLowStorageService";
        goto L8
    L786:
        return null;
    L329:
        if (r2.getName().equals("com.larus.bmhome.chat.cotdetail.ICotDetailService") == false) goto L787;
        r3 = new HashSet();
        r3.add(new CotDetailServiceImpl());
        r0 = "com.larus.bmhome.chat.cotdetail.ICotDetailService";
        goto L8
    L787:
        return null;
    L332:
        if (r2.getName().equals("com.obric.assistant.ISessionAuthenticationService") == false) goto L788;
        r3 = new HashSet();
        r3.add(new SessionAuthenticationServiceImpl());
        r0 = "com.obric.assistant.ISessionAuthenticationService";
        goto L8
    L788:
        return null;
    L335:
        if (r2.getName().equals("com.larus.bmhome.nestedfile.INestedFileCacheManagerService") == false) goto L789;
        r3 = new HashSet();
        r3.add(new NestedFileCacheManagerServiceImpl());
        r0 = "com.larus.bmhome.nestedfile.INestedFileCacheManagerService";
        goto L8
    L789:
        return null;
    L338:
        if (r2.getName().equals("com.bytedance.ai.api.IAppletDebuggerService") == false) goto L790;
        r3 = new HashSet();
        r3.add(new AppletDebuggerServiceImpl());
        r0 = "com.bytedance.ai.api.IAppletDebuggerService";
        goto L8
    L790:
        return null;
    L341:
        if (r2.getName().equals("com.larus.bmhome.dora.IDoraProxy") == false) goto L791;
        r3 = new HashSet();
        r3.add(new DoraProxyImpl());
        r0 = "com.larus.bmhome.dora.IDoraProxy";
        goto L8
    L791:
        return null;
    L344:
        if (r2.getName().equals("com.larus.bootprotector.IBootProtectorProcessDiff") == false) goto L792;
        r3 = new HashSet();
        r3.add(new ObricBootProtectorProcessDiffImpl());
        r0 = "com.larus.bootprotector.IBootProtectorProcessDiff";
        goto L8
    L792:
        return null;
    L347:
        if (r2.getName().equals("com.larus.reach.api.ReachPresentationCapabilityProvider") == false) goto L793;
        r3 = new HashSet();
        r3.add(new RealtimeCallQuotaReachSceneHandler());
        r0 = "com.larus.reach.api.ReachPresentationCapabilityProvider";
        goto L8
    L793:
        return null;
    L350:
        if (r2.getName().equals("com.larus.bmhome.utils.ILaunchLandingConfigHelper") == false) goto L794;
        r3 = new HashSet();
        r3.add(new LaunchLandingConfigHelper());
        r0 = "com.larus.bmhome.utils.ILaunchLandingConfigHelper";
        goto L8
    L794:
        return null;
    L353:
        if (r2.getName().equals("com.bytedance.android.live.browser.rts.jsbridge.api.IIESLiveRTSJSBService") == false) goto L795;
        r3 = new HashSet();
        r3.add(new IESLiveRTSJSBService());
        r0 = "com.bytedance.android.live.browser.rts.jsbridge.api.IIESLiveRTSJSBService";
        goto L8
    L795:
        return null;
    L356:
        if (r2.getName().equals("com.larus.platform.api.ISdkDouyinAuth") == false) goto L796;
        r3 = new HashSet();
        r3.add(new MainDouyinAuthService());
        r0 = "com.larus.platform.api.ISdkDouyinAuth";
        goto L8
    L796:
        return null;
    L359:
        if (r2.getName().equals("com.larus.bmhome.video.IAwemeDoublePostService") == false) goto L797;
        r3 = new HashSet();
        r3.add(new DoublePostServiceImpl());
        r0 = "com.larus.bmhome.video.IAwemeDoublePostService";
        goto L8
    L797:
        return null;
    L362:
        if (r2.getName().equals("com.larus.multitask_management.api.spi.IMultiTaskSortComparator") == false) goto L798;
        r3 = new HashSet();
        r3.add(new ComplexTaskSortComparator());
        r0 = "com.larus.multitask_management.api.spi.IMultiTaskSortComparator";
        goto L8
    L798:
        return null;
    L365:
        if (r2.getName().equals("com.larus.account.saas.coreapi.IAccountMfaService") == false) goto L799;
        r3 = new HashSet();
        r3.add(new AccountMfaService());
        r0 = "com.larus.account.saas.coreapi.IAccountMfaService";
        goto L8
    L799:
        return null;
    L368:
        if (r2.getName().equals("com.obric.assistant.settings.IObricSettingRouteService") == false) goto L800;
        r3 = new HashSet();
        r3.add(new ObricRouteServiceImpl());
        r0 = "com.obric.assistant.settings.IObricSettingRouteService";
        goto L8
    L800:
        return null;
    L371:
        if (r2.getName().equals("com.ivy.ivykit.api.plugin.IIvyLynxBehaviorService") == false) goto L801;
        r3 = new HashSet();
        r3.add(new IvyLynxBehaviorServiceImpl());
        r0 = "com.ivy.ivykit.api.plugin.IIvyLynxBehaviorService";
        goto L8
    L801:
        return null;
    L374:
        if (r2.getName().equals("com.larus.bmhome.chat.api.IAiChatTraceService") == false) goto L802;
        r3 = new HashSet();
        r3.add(new AiChatTraceImpl());
        r0 = "com.larus.bmhome.chat.api.IAiChatTraceService";
        goto L8
    L802:
        return null;
    L377:
        if (r2.getName().equals("com.obric.assistant.settings.IObricAutoGuiSettingsApi") == false) goto L803;
        r3 = new HashSet();
        r3.add(new com.obric.assistant.settings.autogui.ObricAutoGuiSettingsImpl());
        r0 = "com.obric.assistant.settings.IObricAutoGuiSettingsApi";
        goto L8
    L803:
        return null;
    L380:
        if (r2.getName().equals("com.larus.platform.IFlowSdkDepend") == false) goto L804;
        r3 = new HashSet();
        r3.add(new FlowSdkDependImpl());
        r0 = "com.larus.platform.IFlowSdkDepend";
        goto L8
    L804:
        return null;
    L383:
        if (r2.getName().equals("com.ivy.ivykit.api.bridge.IBridgeMethodService") == false) goto L805;
        r3 = new HashSet();
        r3.add(new BridgeMethodServiceImpl());
        r0 = "com.ivy.ivykit.api.bridge.IBridgeMethodService";
        goto L8
    L805:
        return null;
    L386:
        if (r2.getName().equals("com.larus.bmhome.chat.mainbot.IAiChatMainBotModuleService") == false) goto L806;
        r3 = new HashSet();
        r3.add(new AiChatMainBotModuleServiceImpl());
        r0 = "com.larus.bmhome.chat.mainbot.IAiChatMainBotModuleService";
        goto L8
    L806:
        return null;
    L389:
        if (r2.getName().equals("com.ss.cast.plugin.dy.source.ISourceController") == false) goto L807;
        r3 = new HashSet();
        r3.add(new SourceManager());
        r0 = "com.ss.cast.plugin.dy.source.ISourceController";
        goto L8
    L807:
        return null;
    L392:
        if (r2.getName().equals("com.larus.home.api.sidebar.IConversationGroupConfigProvider") == false) goto L808;
        r3 = new HashSet();
        r3.add(new ConversationGroupConfigProviderImpl());
        r0 = "com.larus.home.api.sidebar.IConversationGroupConfigProvider";
        goto L8
    L808:
        return null;
    L395:
        if (r2.getName().equals("com.larus.bmhome.chat.model.repo.IUserSettingRepoService") == false) goto L809;
        r3 = new HashSet();
        r3.add(new com.larus.bmhome.setting.UserSettingImpl());
        r0 = "com.larus.bmhome.chat.model.repo.IUserSettingRepoService";
        goto L8
    L809:
        return null;
    L398:
        if (r2.getName().equals("com.obric.assistant.spi.chat.IObricChatUIService") == false) goto L810;
        r3 = new HashSet();
        r3.add(new ObricChatUIServiceImpl());
        r0 = "com.obric.assistant.spi.chat.IObricChatUIService";
        goto L8
    L810:
        return null;
    L401:
        if (r2.getName().equals("com.obric.assistant.task.IObricTaskStatusManager") == false) goto L811;
        r3 = new HashSet();
        r3.add(new ObricTaskStatusManagerImpl());
        r0 = "com.obric.assistant.task.IObricTaskStatusManager";
        goto L8
    L811:
        return null;
    L404:
        if (r2.getName().equals("com.obric.assistant.banner.IObricBannerService") == false) goto L812;
        r3 = new HashSet();
        r3.add(new ObricBannerService());
        r0 = "com.obric.assistant.banner.IObricBannerService";
        goto L8
    L812:
        return null;
    L407:
        if (r2.getName().equals("com.obric.assistant.spi.feedback.IFeedbackService") == false) goto L813;
        r3 = new HashSet();
        r3.add(new FeedbackServiceImpl());
        r0 = "com.obric.assistant.spi.feedback.IFeedbackService";
        goto L8
    L813:
        return null;
    L410:
        if (r2.getName().equals("com.bytedance.android.shopping.api.mall.feed.IECMallFeedService") == false) goto L814;
        r3 = new HashSet();
        r3.add(new ECMallFeedService());
        r0 = "com.bytedance.android.shopping.api.mall.feed.IECMallFeedService";
        goto L8
    L814:
        return null;
    L413:
        if (r2.getName().equals("com.larus.bmhome.chat.api.IGaokaoPreferenceService") == false) goto L815;
        r3 = new HashSet();
        r3.add(new GaokaoPreferenceServiceImpl());
        r0 = "com.larus.bmhome.chat.api.IGaokaoPreferenceService";
        goto L8
    L815:
        return null;
    L416:
        if (r2.getName().equals("com.larus.bmhome.chat.model.repo.ISettingRepoService") == false) goto L816;
        r3 = new HashSet();
        r3.add(new SettingRepo());
        r0 = "com.larus.bmhome.chat.model.repo.ISettingRepoService";
        goto L8
    L816:
        return null;
    L419:
        if (r2.getName().equals("com.larus.dora.device.api.IDoraDeviceInfo") == false) goto L817;
        r3 = new HashSet();
        r3.add(new DoraDeviceInfoImpl());
        r0 = "com.larus.dora.device.api.IDoraDeviceInfo";
        goto L8
    L817:
        return null;
    L422:
        if (r2.getName().equals("com.larus.bmhome.chat.component.bottom.core.InputViewCreatorService") == false) goto L818;
        r3 = new HashSet();
        r3.add(new InputViewCreator());
        r0 = "com.larus.bmhome.chat.component.bottom.core.InputViewCreatorService";
        goto L8
    L818:
        return null;
    L425:
        if (r2.getName().equals("com.larus.bmhome.chat.interceptor.IMessageRenderInterceptorService") == false) goto L819;
        r3 = new HashSet();
        r3.add(new MarkdownRenderInterceptorImpl());
        r0 = "com.larus.bmhome.chat.interceptor.IMessageRenderInterceptorService";
        goto L8
    L819:
        return null;
    L428:
        if (r2.getName().equals("com.obric.assistant.device.IObricDeviceManager") == false) goto L820;
        r3 = new HashSet();
        r3.add(new ObricDeviceManagerImpl());
        r0 = "com.obric.assistant.device.IObricDeviceManager";
        goto L8
    L820:
        return null;
    L431:
        if (r2.getName().equals("com.obric.assistant.spi.actionbar.IObricActionBarTrackService") == false) goto L821;
        r3 = new HashSet();
        r3.add(new ObricActionBarTrackServiceImpl());
        r0 = "com.obric.assistant.spi.actionbar.IObricActionBarTrackService";
        goto L8
    L821:
        return null;
    L434:
        if (r2.getName().equals("com.bytedance.android.btm.impl.provider.IBtmConfigFromBcm") == false) goto L822;
        r3 = new HashSet();
        r3.add(new BcmConfigForBtmImpl());
        r0 = "com.bytedance.android.btm.impl.provider.IBtmConfigFromBcm";
        goto L8
    L822:
        return null;
    L437:
        if (r2.getName().equals("com.bytedance.android.live.openplatform.impl.base.awemepaas_adapt.IOpenPlatformFlavorService") == false) goto L823;
        r3 = new HashSet();
        r3.add(new OpenPlatformFlavorServiceDefault());
        r3.add(new OpenPlatformFlavorServiceForDouyin());
        r0 = "com.bytedance.android.live.openplatform.impl.base.awemepaas_adapt.IOpenPlatformFlavorService";
        goto L8
    L823:
        return null;
    L440:
        if (r2.getName().equals("com.larus.bmhome.chat.block.base.renderer.IFileStyleArtifactRendererService") == false) goto L824;
        r3 = new HashSet();
        r3.add(new FileStyleArtifactRendererServiceImpl());
        r0 = "com.larus.bmhome.chat.block.base.renderer.IFileStyleArtifactRendererService";
        goto L8
    L824:
        return null;
    L443:
        if (r2.getName().equals("com.bytedance.bmf_mods_api.VideoBrightAPI") == false) goto L825;
        r3 = new HashSet();
        r3.add(new VideoBright());
        r0 = "com.bytedance.bmf_mods_api.VideoBrightAPI";
        goto L8
    L825:
        return null;
    L446:
        if (r2.getName().equals("com.bytedance.timon.foundation.interfaces.ITimonLogger") == false) goto L826;
        r3 = new HashSet();
        r3.add(new LocalTimonLogger());
        r0 = "com.bytedance.timon.foundation.interfaces.ITimonLogger";
        goto L8
    L826:
        return null;
    L449:
        if (r2.getName().equals("com.bytedance.android.shopping.api.mall.ILegouMallService") == false) goto L827;
        r3 = new HashSet();
        r3.add(new LegouMallServiceDefaultImpl());
        r0 = "com.bytedance.android.shopping.api.mall.ILegouMallService";
        goto L8
    L827:
        return null;
    L452:
        if (r2.getName().equals("com.larus.dora.api.awareness.IAwarenessEventReporter") == false) goto L828;
        r3 = new HashSet();
        r3.add(new AwarenessEventReporter());
        r0 = "com.larus.dora.api.awareness.IAwarenessEventReporter";
        goto L8
    L828:
        return null;
    L455:
        if (r2.getName().equals("com.larus.bmhome.instruction.IInstructionUtilsService") == false) goto L829;
        r3 = new HashSet();
        r3.add(new InstructionUtilsService());
        r0 = "com.larus.bmhome.instruction.IInstructionUtilsService";
        goto L8
    L829:
        return null;
    L458:
        if (r2.getName().equals("com.obric.aiagent.assistant.idl.IFlowFeedbackIDLSPI") == false) goto L830;
        r3 = new HashSet();
        r3.add(new FlowFeedbackIDLStub());
        r0 = "com.obric.aiagent.assistant.idl.IFlowFeedbackIDLSPI";
        goto L8
    L830:
        return null;
    L461:
        if (r2.getName().equals("com.larus.platform.audit.IFlowBehaviorAuditService") == false) goto L831;
        r3 = new HashSet();
        r3.add(new FlowBehaviorAuditServiceImpl());
        r0 = "com.larus.platform.audit.IFlowBehaviorAuditService";
        goto L8
    L831:
        return null;
    L464:
        if (r2.getName().equals("com.larus.bmhome.chat.trace.api.IChatImTraceService") == false) goto L832;
        r3 = new HashSet();
        r3.add(new ChatImTraceServiceImpl());
        r0 = "com.larus.bmhome.chat.trace.api.IChatImTraceService";
        goto L8
    L832:
        return null;
    L467:
        if (r2.getName().equals("com.bytedance.android.bcm.api.provider.IBcmExtraCheckerProvider") == false) goto L833;
        r3 = new HashSet();
        r3.add(new BcmExtraCheckerProviderImpl());
        r0 = "com.bytedance.android.bcm.api.provider.IBcmExtraCheckerProvider";
        goto L8
    L833:
        return null;
    L470:
        if (r2.getName().equals("com.larus.bmhome.chat.api.IAppreciableTraceService") == false) goto L834;
        r3 = new HashSet();
        r3.add(new AppreciableTraceService());
        r0 = "com.larus.bmhome.chat.api.IAppreciableTraceService";
        goto L8
    L834:
        return null;
    L473:
        if (r2.getName().equals("com.bytedance.android.marketing.sdk.api.IMarketingBridgeService") == false) goto L835;
        r3 = new HashSet();
        r3.add(new MarketingBridgeServiceImpl());
        r0 = "com.bytedance.android.marketing.sdk.api.IMarketingBridgeService";
        goto L8
    L835:
        return null;
    L476:
        if (r2.getName().equals("com.larus.bmhome.chat.reddot.IConversationRedDotService") == false) goto L836;
        r3 = new HashSet();
        r3.add(new ConversationRedDotServiceImpl());
        r0 = "com.larus.bmhome.chat.reddot.IConversationRedDotService";
        goto L8
    L836:
        return null;
    L479:
        if (r2.getName().equals("com.larus.bmhome.chat.dora.IChatDoraService") == false) goto L837;
        r3 = new HashSet();
        r3.add(new ChatDoraServiceImpl());
        r0 = "com.larus.bmhome.chat.dora.IChatDoraService";
        goto L8
    L837:
        return null;
    L482:
        if (r2.getName().equals("com.larus.account.saas.ui.IAccountCommonAlertUiService") == false) goto L838;
        r3 = new HashSet();
        r3.add(new DefaultAccountCommonAlertUiService());
        r0 = "com.larus.account.saas.ui.IAccountCommonAlertUiService";
        goto L8
    L838:
        return null;
    L485:
        if (r2.getName().equals("com.bytedance.bmf_mods_api.AdaptiveGradingAPI") == false) goto L839;
        r3 = new HashSet();
        r3.add(new AdaptiveGrading());
        r0 = "com.bytedance.bmf_mods_api.AdaptiveGradingAPI";
        goto L8
    L839:
        return null;
    L488:
        if (r2.getName().equals("com.larus.bmhome.chat.api.ITtsPlayInterceptor") == false) goto L840;
        r3 = new HashSet();
        r3.add(new TtsSilentInterceptor());
        r0 = "com.larus.bmhome.chat.api.ITtsPlayInterceptor";
        goto L8
    L840:
        return null;
    L491:
        if (r2.getName().equals("com.larus.bmhome.collection.ICollectionReport") == false) goto L841;
        r3 = new HashSet();
        r3.add(new CollectionEventHelper());
        r0 = "com.larus.bmhome.collection.ICollectionReport";
        goto L8
    L841:
        return null;
    L494:
        if (r2.getName().equals("com.bytedance.android.shopping.api.mall.IECMallPerformanceService") == false) goto L842;
        r3 = new HashSet();
        r3.add(new ECMallPerformanceService());
        r0 = "com.bytedance.android.shopping.api.mall.IECMallPerformanceService";
        goto L8
    L842:
        return null;
    L497:
        if (r2.getName().equals("com.obric.assistant.spi.actionbar.IObricActionBarSendService") == false) goto L843;
        r3 = new HashSet();
        r3.add(new ObricActionBarSendServiceImpl());
        r0 = "com.obric.assistant.spi.actionbar.IObricActionBarSendService";
        goto L8
    L843:
        return null;
    L500:
        if (r2.getName().equals("com.larus.bmhome.chat.setting.IUserSettingCacheService") == false) goto L844;
        r3 = new HashSet();
        r3.add(new UserSettingCacheImpl());
        r0 = "com.larus.bmhome.chat.setting.IUserSettingCacheService";
        goto L8
    L844:
        return null;
    L503:
        if (r2.getName().equals("com.bytedance.android.marketing.sdk.api.IMarketingServiceV2") == false) goto L845;
        r3 = new HashSet();
        r3.add(new MarketingServiceImplV2());
        r0 = "com.bytedance.android.marketing.sdk.api.IMarketingServiceV2";
        goto L8
    L845:
        return null;
    L506:
        if (r2.getName().equals("com.obric.assistant.login.ILoginState") == false) goto L846;
        r3 = new HashSet();
        r3.add(new LoginStateImpl());
        r0 = "com.obric.assistant.login.ILoginState";
        goto L8
    L846:
        return null;
    L509:
        if (r2.getName().equals("com.larus.camera.api.IInputServiceProvider") == false) goto L847;
        r3 = new HashSet();
        r3.add(new InputServiceProviderImpl());
        r0 = "com.larus.camera.api.IInputServiceProvider";
        goto L8
    L847:
        return null;
    L512:
        if (r2.getName().equals("com.larus.bmhome.chat.nita.IChatNitaPreloadService") == false) goto L848;
        r3 = new HashSet();
        r3.add(new ChatNitaPreloadServiceImpl());
        r0 = "com.larus.bmhome.chat.nita.IChatNitaPreloadService";
        goto L8
    L848:
        return null;
    L515:
        if (r2.getName().equals("com.larus.platform.api.IECommerceProductCardPreloadService") == false) goto L849;
        r3 = new HashSet();
        r3.add(new ECommerceProductCardPreloadService());
        r0 = "com.larus.platform.api.IECommerceProductCardPreloadService";
        goto L8
    L849:
        return null;
    L518:
        if (r2.getName().equals("com.obric.assistant.special_input.ISpecialInputTask") == false) goto L850;
        r3 = new HashSet();
        r3.add(new SpecialInputTaskImpl());
        r0 = "com.obric.assistant.special_input.ISpecialInputTask";
        goto L8
    L850:
        return null;
    L521:
        if (r2.getName().equals("com.larus.bmhome.nestedfile.INestFileService") == false) goto L851;
        r3 = new HashSet();
        r3.add(new NestFileServiceImpl());
        r0 = "com.larus.bmhome.nestedfile.INestFileService";
        goto L8
    L851:
        return null;
    L524:
        if (r2.getName().equals("com.bytedance.android.livesdkapi.bytecast.ILiveByteCastService") == false) goto L852;
        r3 = new HashSet();
        r3.add(new LiveByteCastService());
        r0 = "com.bytedance.android.livesdkapi.bytecast.ILiveByteCastService";
        goto L8
    L852:
        return null;
    L527:
        if (r2.getName().equals("com.larus.bmhome.code.IAiChatCodePreviewService") == false) goto L853;
        r3 = new HashSet();
        r3.add(new AiChatCodePreviewServiceImpl());
        r0 = "com.larus.bmhome.code.IAiChatCodePreviewService";
        goto L8
    L853:
        return null;
    L530:
        if (r2.getName().equals("com.obric.assistant.IClearContextInKeyguardService") == false) goto L854;
        r3 = new HashSet();
        r3.add(new ClearContextInKeyguardServiceImpl());
        r0 = "com.obric.assistant.IClearContextInKeyguardService";
        goto L8
    L854:
        return null;
    L533:
        if (r2.getName().equals("com.bytedance.bmf_mods_api.VideoOCLSRAPI") == false) goto L855;
        r3 = new HashSet();
        r3.add(new VideoOCLSR());
        r0 = "com.bytedance.bmf_mods_api.VideoOCLSRAPI";
        goto L8
    L855:
        return null;
    L536:
        if (r2.getName().equals("com.bytedance.android.marketing.sdk.api.IMarketingService") == false) goto L856;
        r3 = new HashSet();
        r3.add(new MarketingServiceImpl());
        r0 = "com.bytedance.android.marketing.sdk.api.IMarketingService";
        goto L8
    L856:
        return null;
    L539:
        if (r2.getName().equals("com.larus.bmhome.utils.IVideoShareService") == false) goto L857;
        r3 = new HashSet();
        r3.add(new VideoShareService());
        r0 = "com.larus.bmhome.utils.IVideoShareService";
        goto L8
    L857:
        return null;
    L542:
        if (r2.getName().equals("com.fackbook.imagepipeline.IImagePipelineOutService") == false) goto L858;
        r3 = new HashSet();
        r3.add(new ImagePipelineOutService());
        r0 = "com.fackbook.imagepipeline.IImagePipelineOutService";
        goto L8
    L858:
        return null;
    L545:
        if (r2.getName().equals("com.obric.assistant.special_input.IObricSpecialInputService") == false) goto L859;
        r3 = new HashSet();
        r3.add(new ObricSpecialInputServiceImpl());
        r0 = "com.obric.assistant.special_input.IObricSpecialInputService";
        goto L8
    L859:
        return null;
    L548:
        if (r2.getName().equals("com.obric.assistant.settings.IAILabService") == false) goto L860;
        r3 = new HashSet();
        r3.add(new AILabServiceImpl());
        r0 = "com.obric.assistant.settings.IAILabService";
        goto L8
    L860:
        return null;
    L551:
        if (r2.getName().equals("com.obric.assistant.spi.dora.IObricDoraService") == false) goto L861;
        r3 = new HashSet();
        r3.add(new ObricDoraServiceImpl());
        r0 = "com.obric.assistant.spi.dora.IObricDoraService";
        goto L8
    L861:
        return null;
    L554:
        if (r2.getName().equals("com.larus.bmhome.chat.api.require.IPostLaunchInfoService") == false) goto L862;
        r3 = new HashSet();
        r3.add(new PostLaunchInfoService());
        r0 = "com.larus.bmhome.chat.api.require.IPostLaunchInfoService";
        goto L8
    L862:
        return null;
    L557:
        if (r2.getName().equals("com.bytedance.android.shopping.api.mall.mallSession.IMallSessionService") == false) goto L863;
        r3 = new HashSet();
        r3.add(new MallSessionServiceImpl());
        r0 = "com.bytedance.android.shopping.api.mall.mallSession.IMallSessionService";
        goto L8
    L863:
        return null;
    L560:
        if (r2.getName().equals("com.bytedance.upc.common.ICommonBusinessService") == false) goto L864;
        r3 = new HashSet();
        r3.add(new CommonBusinessService());
        r0 = "com.bytedance.upc.common.ICommonBusinessService";
        goto L8
    L864:
        return null;
    L563:
        if (r2.getName().equals("com.larus.bmhome.chat.api.sidebar.ISideBarConversationIconService") == false) goto L865;
        r3 = new HashSet();
        r3.add(new SideBarConversationIconServiceImpl());
        r0 = "com.larus.bmhome.chat.api.sidebar.ISideBarConversationIconService";
        goto L8
    L865:
        return null;
    L566:
        if (r2.getName().equals("com.larus.home.api.route.IHomeRouterService") == false) goto L866;
        r3 = new HashSet();
        r3.add(new HomeRouterServiceImpl());
        r0 = "com.larus.home.api.route.IHomeRouterService";
        goto L8
    L866:
        return null;
    L569:
        if (r2.getName().equals("com.obric.assistant.spi.login.IObricLoginService") == false) goto L867;
        r3 = new HashSet();
        r3.add(new ObricLoginServiceImpl());
        r0 = "com.obric.assistant.spi.login.IObricLoginService";
        goto L8
    L867:
        return null;
    L572:
        if (r2.getName().equals("com.ss.android.ugc.aweme.live.ILivePluginContext") == false) goto L868;
        r3 = new HashSet();
        r3.add(new LivePluginContext());
        r0 = "com.ss.android.ugc.aweme.live.ILivePluginContext";
        goto L8
    L868:
        return null;
    L575:
        if (r2.getName().equals("com.ivy.ivykit.api.bridge.IIvyLynxBridgeService") == false) goto L869;
        r3 = new HashSet();
        r3.add(new IvyLynxBridgeServiceImpl());
        r0 = "com.ivy.ivykit.api.bridge.IIvyLynxBridgeService";
        goto L8
    L869:
        return null;
    L578:
        if (r2.getName().equals("com.bytedance.timonbase.ITMBusinessService") == false) goto L870;
        r3 = new HashSet();
        r3.add(new MonitorBusinessServiceImpl());
        r0 = "com.bytedance.timonbase.ITMBusinessService";
        goto L8
    L870:
        return null;
    L581:
        if (r2.getName().equals("com.obric.assistant.spi.mediaplay.IMediaPlayStateChangeListener") == false) goto L871;
        r3 = new HashSet();
        r3.add(new ObricMediaPlayStateChangeListenerUtils());
        r0 = "com.obric.assistant.spi.mediaplay.IMediaPlayStateChangeListener";
        goto L8
    L871:
        return null;
    L584:
        if (r2.getName().equals("com.larus.bmhome.chat.monitor.IMessageImageLoaderService") == false) goto L872;
        r3 = new HashSet();
        r3.add(new MessageImageLoaderServiceImpl());
        r0 = "com.larus.bmhome.chat.monitor.IMessageImageLoaderService";
        goto L8
    L872:
        return null;
    L587:
        if (r2.getName().equals("com.obric.assistant.tipoff.IObricTipOffService") == false) goto L873;
        r3 = new HashSet();
        r3.add(new ObricTipOffServiceImpl());
        r0 = "com.obric.assistant.tipoff.IObricTipOffService";
        goto L8
    L873:
        return null;
    L590:
        if (r2.getName().equals("com.obric.sva.framework.api.ISvaFramework") == false) goto L874;
        r3 = new HashSet();
        r3.add(new SvaFrameworkImpl());
        r0 = "com.obric.sva.framework.api.ISvaFramework";
        goto L8
    L874:
        return null;
    L593:
        if (r2.getName().equals("com.bytedance.android.bcm.api.provider.IBcmConfigBusinessProvider") == false) goto L875;
        r3 = new HashSet();
        r3.add(new BcmConfigBusinessProviderImpl());
        r0 = "com.bytedance.android.bcm.api.provider.IBcmConfigBusinessProvider";
        goto L8
    L875:
        return null;
    L596:
        if (r2.getName().equals("com.bytedance.bmf_mods_api.NoiseLiveAPI") == false) goto L876;
        r3 = new HashSet();
        r3.add(new NoiseLive());
        r0 = "com.bytedance.bmf_mods_api.NoiseLiveAPI";
        goto L8
    L876:
        return null;
    L599:
        if (r2.getName().equals("com.obric.assistant.security.ICertificateCheckService") == false) goto L877;
        r3 = new HashSet();
        r3.add(new CertificateCheckServiceImpl());
        r0 = "com.obric.assistant.security.ICertificateCheckService";
        goto L8
    L877:
        return null;
    L602:
        if (r2.getName().equals("com.bytedance.upc.IUpcLifecycleService") == false) goto L878;
        r3 = new HashSet();
        r3.add(new CommonService());
        r0 = "com.bytedance.upc.IUpcLifecycleService";
        goto L8
    L878:
        return null;
    L605:
        if (r2.getName().equals("com.bytedance.android.shopping.api.mall.IECMallTabOptService") == false) goto L879;
        r3 = new HashSet();
        r3.add(new ECMallTabOptService());
        r0 = "com.bytedance.android.shopping.api.mall.IECMallTabOptService";
        goto L8
    L879:
        return null;
    L608:
        if (r2.getName().equals("com.larus.office.card.urlpreview.IOfficeHtmlFileDownloadService") == false) goto L880;
        r3 = new HashSet();
        r3.add(new OfficeHtmlFileDownloadServiceImpl());
        r0 = "com.larus.office.card.urlpreview.IOfficeHtmlFileDownloadService";
        goto L8
    L880:
        return null;
    L611:
        if (r2.getName().equals("com.bytedance.bmf_mods_api.VideoSRRaisrAPI") == false) goto L881;
        r3 = new HashSet();
        r3.add(new VideoSRRaisr());
        r0 = "com.bytedance.bmf_mods_api.VideoSRRaisrAPI";
        goto L8
    L881:
        return null;
    L614:
        if (r2.getName().equals("com.larus.bmhome.chat.service.IMainBotCommonService") == false) goto L882;
        r3 = new HashSet();
        r3.add(new MainBotCommonServiceImpl());
        r0 = "com.larus.bmhome.chat.service.IMainBotCommonService";
        goto L8
    L882:
        return null;
    L617:
        if (r2.getName().equals("com.larus.platform.IFlowMessageService") == false) goto L883;
        r3 = new HashSet();
        r3.add(new FlowMessageImpl());
        r0 = "com.larus.platform.IFlowMessageService";
        goto L8
    L883:
        return null;
    L620:
        if (r2.getName().equals("com.bytedance.bmf_mods_api.VideoSuperResolutionAPI") == false) goto L884;
        r3 = new HashSet();
        r3.add(new VideoSuperResolution());
        r0 = "com.bytedance.bmf_mods_api.VideoSuperResolutionAPI";
        goto L8
    L884:
        return null;
    L623:
        if (r2.getName().equals("com.larus.ugc.feed.api.detail.spi.ICreationDetailFragmentFactory") == false) goto L885;
        r3 = new HashSet();
        r3.add(new CreationDetailFragmentFactoryImpl());
        r0 = "com.larus.ugc.feed.api.detail.spi.ICreationDetailFragmentFactory";
        goto L8
    L885:
        return null;
    L626:
        if (r2.getName().equals("com.obric.assistant.spi.notification.IObricNotificationIslandService") == false) goto L886;
        r3 = new HashSet();
        r3.add(new ObricNotificationIslandService());
        r0 = "com.obric.assistant.spi.notification.IObricNotificationIslandService";
        goto L8
    L886:
        return null;
    L629:
        if (r2.getName().equals("com.bytedance.bmf_mods_api.ColorShiftAPI") == false) goto L887;
        r3 = new HashSet();
        r3.add(new ColorShift());
        r0 = "com.bytedance.bmf_mods_api.ColorShiftAPI";
        goto L8
    L887:
        return null;
    L632:
        if (r2.getName().equals("com.larus.account.saas.security.api.IAccountSecurityService") == false) goto L888;
        r3 = new HashSet();
        r3.add(new AccountSecurityServiceImpl());
        r0 = "com.larus.account.saas.security.api.IAccountSecurityService";
        goto L8
    L888:
        return null;
    L635:
        if (r2.getName().equals("com.obric.assistant.spi.message.IObricAppreciablePoint") == false) goto L889;
        r3 = new HashSet();
        r3.add(new ObricAppreciablePoint());
        r0 = "com.obric.assistant.spi.message.IObricAppreciablePoint";
        goto L8
    L889:
        return null;
    L638:
        if (r2.getName().equals("com.ss.android.ugc.aweme.search.dynamic.core.ability.ISearchDynamicAbility$IFactory") == false) goto L890;
        r3 = new HashSet();
        r3.add(new DRFallBackAbilityFactory());
        r3.add(new EcomPitayaAbilityFactory());
        r3.add(new EcomSearchBannerAnimAbilityFactory());
        r3.add(new LongPressAbilityFactory());
        r0 = "com.ss.android.ugc.aweme.search.dynamic.core.ability.ISearchDynamicAbility$IFactory";
        goto L8
    L890:
        return null;
    L641:
        if (r2.getName().equals("com.obric.assistant.spi.feedback.IObricFeedbackPanelService") == false) goto L891;
        r3 = new HashSet();
        r3.add(new ObricFeedbackPanelServiceImpl());
        r0 = "com.obric.assistant.spi.feedback.IObricFeedbackPanelService";
        goto L8
    L891:
        return null;
    L644:
        if (r2.getName().equals("com.larus.platform.IObricMessageExtService") == false) goto L892;
        r3 = new HashSet();
        r3.add(new ObricMessageExtImpl());
        r0 = "com.larus.platform.IObricMessageExtService";
        goto L8
    L892:
        return null;
    L647:
        if (r2.getName().equals("com.bytedance.bmf_mods_api.TdiLiteStrategyAPI") == false) goto L893;
        r3 = new HashSet();
        r3.add(new TdiLiteStrategy());
        r0 = "com.bytedance.bmf_mods_api.TdiLiteStrategyAPI";
        goto L8
    L893:
        return null;
    L650:
        if (r2.getName().equals("com.obric.assistant.spi.push.IObricPushConfigService") == false) goto L894;
        r3 = new HashSet();
        r3.add(new ObricPushConfigServiceImpl());
        r0 = "com.obric.assistant.spi.push.IObricPushConfigService";
        goto L8
    L894:
        return null;
    L653:
        if (r2.getName().equals("com.obric.assistant.spi.markdown.IObricMarkdownResolverService") == false) goto L895;
        r3 = new HashSet();
        r3.add(new ObricMarkdownResolverServiceImpl());
        r0 = "com.obric.assistant.spi.markdown.IObricMarkdownResolverService";
        goto L8
    L895:
        return null;
    L656:
        if (r2.getName().equals("com.larus.chat.api.nita.IChatBottomNitaView") == false) goto L896;
        r3 = new HashSet();
        r3.add(new ChatBottomNitaViewImpl());
        r0 = "com.larus.chat.api.nita.IChatBottomNitaView";
        goto L8
    L896:
        return null;
    L659:
        if (r2.getName().equals("com.larus.dora.api.IDoraGuideService") == false) goto L897;
        r3 = new HashSet();
        r3.add(new DoraGuideServiceImpl());
        r0 = "com.larus.dora.api.IDoraGuideService";
        goto L8
    L897:
        return null;
    L662:
        if (r2.getName().equals("com.ivy.ivykit.api.bridge.IBridgeService") == false) goto L898;
        r3 = new HashSet();
        r3.add(new BridgeServiceImpl());
        r0 = "com.ivy.ivykit.api.bridge.IBridgeService";
        goto L8
    L898:
        return null;
    L665:
        if (r2.getName().equals("com.larus.bmhome.chat.standarduikit.computerusetool.api.ICuaApi") == false) goto L899;
        r3 = new HashSet();
        r3.add(new CuaApiImpl());
        r0 = "com.larus.bmhome.chat.standarduikit.computerusetool.api.ICuaApi";
        goto L8
    L899:
        return null;
    L668:
        if (r2.getName().equals("com.larus.bmhome.social.userchat.messagelist.model.IMessageContentConvertor") == false) goto L900;
        r3 = new HashSet();
        r3.add(new AIImageContentConvertor());
        r3.add(new AudioTextContentConverter());
        r3.add(new TextContentConvertor());
        r3.add(new UserImageContentConvertor());
        r0 = "com.larus.bmhome.social.userchat.messagelist.model.IMessageContentConvertor";
        goto L8
    L900:
        return null;
    L671:
        if (r2.getName().equals("com.larus.bmhome.video.IVideoDownloadLoadingMgrService") == false) goto L901;
        r3 = new HashSet();
        r3.add(new VideoDownloadLoadingMgr());
        r0 = "com.larus.bmhome.video.IVideoDownloadLoadingMgrService";
        goto L8
    L901:
        return null;
    L674:
        if (r2.getName().equals("com.obric.assistant.chat.IObricChatService") == false) goto L902;
        r3 = new HashSet();
        r3.add(new ObricChatService());
        r0 = "com.obric.assistant.chat.IObricChatService";
        goto L8
    L902:
        return null;
    L677:
        if (r2.getName().equals("com.bytedance.timonbase.ITMBasicModeLifecycleService") == false) goto L903;
        r3 = new HashSet();
        r3.add(new RulerBasicLifecycleServiceImpl());
        r0 = "com.bytedance.timonbase.ITMBasicModeLifecycleService";
        goto L8
    L903:
        return null;
    }

    public StaticServiceImplManager() {
        this.serviceImplCache = new ConcurrentHashMap();
        this.serviceImplNotExistSet = Collections.synchronizedSet(new HashSet());
        this.serviceImplSetCache = new ConcurrentHashMap();
        this.serviceImplSetNotExistSet = Collections.synchronizedSet(new HashSet());
    }

    public static StaticServiceImplManager getInstance() {
        return SingleInstanceHolder.access$000();
    }

    private <T> T getStaticServiceImplReal(Class<T> r3) {
        switch(r3.getName().hashCode()) {
            case -2135705261: goto L3602;
            case -2131928770: goto L3598;
            case -2123289744: goto L3594;
            case -2120899756: goto L3590;
            case -2120641399: goto L3586;
            case -2113648773: goto L3582;
            case -2106001016: goto L3578;
            case -2103105871: goto L3574;
            case -2097483563: goto L3570;
            case -2094097622: goto L3566;
            case -2086116425: goto L3562;
            case -2085431499: goto L3558;
            case -2079534761: goto L3554;
            case -2077434565: goto L3550;
            case -2076923937: goto L3546;
            case -2066816065: goto L3542;
            case -2066224157: goto L3538;
            case -2064565899: goto L3534;
            case -2062817289: goto L3530;
            case -2062561932: goto L3526;
            case -2060489699: goto L3522;
            case -2054012694: goto L3518;
            case -2053967284: goto L3514;
            case -2053014790: goto L3510;
            case -2051754747: goto L3506;
            case -2029880294: goto L3502;
            case -2029332183: goto L3498;
            case -2017810094: goto L3494;
            case -2016407209: goto L3490;
            case -2002071954: goto L3486;
            case -1999609349: goto L3482;
            case -1994632656: goto L3478;
            case -1994470027: goto L3474;
            case -1990371402: goto L3470;
            case -1987141669: goto L3466;
            case -1980474687: goto L3462;
            case -1980112181: goto L3458;
            case -1969118622: goto L3454;
            case -1963376984: goto L3450;
            case -1952289749: goto L3446;
            case -1951826950: goto L3442;
            case -1947529177: goto L3438;
            case -1942362411: goto L3434;
            case -1927986983: goto L3430;
            case -1927556761: goto L3426;
            case -1921560676: goto L3422;
            case -1910561307: goto L3418;
            case -1904645091: goto L3414;
            case -1891048851: goto L3410;
            case -1872362390: goto L3406;
            case -1865321834: goto L3402;
            case -1863080103: goto L3398;
            case -1862270395: goto L3394;
            case -1859502304: goto L3390;
            case -1857330358: goto L3386;
            case -1856311186: goto L3382;
            case -1852853852: goto L3378;
            case -1839658133: goto L3374;
            case -1827506087: goto L3370;
            case -1819643756: goto L3366;
            case -1816609618: goto L3362;
            case -1810424474: goto L3358;
            case -1808983014: goto L3354;
            case -1806625901: goto L3350;
            case -1804281075: goto L3346;
            case -1795228449: goto L3342;
            case -1788325683: goto L3338;
            case -1787949654: goto L3334;
            case -1787177589: goto L3330;
            case -1784724874: goto L3326;
            case -1781683221: goto L3322;
            case -1780725501: goto L3318;
            case -1773014112: goto L3314;
            case -1772930888: goto L3310;
            case -1770754477: goto L3306;
            case -1770660597: goto L3302;
            case -1763635384: goto L3298;
            case -1760346682: goto L3294;
            case -1758245390: goto L3290;
            case -1753195049: goto L3286;
            case -1751371519: goto L3282;
            case -1748441402: goto L3278;
            case -1744531954: goto L3274;
            case -1742279710: goto L3270;
            case -1730623406: goto L3266;
            case -1730273559: goto L3262;
            case -1700950436: goto L3258;
            case -1698052040: goto L3254;
            case -1689796830: goto L3250;
            case -1688844914: goto L3246;
            case -1684423728: goto L3242;
            case -1678261478: goto L3238;
            case -1672350436: goto L3234;
            case -1669907137: goto L3230;
            case -1669398587: goto L3226;
            case -1667294112: goto L3222;
            case -1663738657: goto L3218;
            case -1660195918: goto L3214;
            case -1657056325: goto L3210;
            case -1654314805: goto L3206;
            case -1650729581: goto L3202;
            case -1647000663: goto L3198;
            case -1646146182: goto L3194;
            case -1646057095: goto L3190;
            case -1642343718: goto L3186;
            case -1638934933: goto L3182;
            case -1638708405: goto L3178;
            case -1632748644: goto L3174;
            case -1626857626: goto L3170;
            case -1622164797: goto L3166;
            case -1620039095: goto L3162;
            case -1592006006: goto L3158;
            case -1575792756: goto L3154;
            case -1568323663: goto L3150;
            case -1566623059: goto L3146;
            case -1562927334: goto L3142;
            case -1562564369: goto L3138;
            case -1560151109: goto L3134;
            case -1554322779: goto L3130;
            case -1549947850: goto L3126;
            case -1549499957: goto L3122;
            case -1546470126: goto L3118;
            case -1544686869: goto L3114;
            case -1541334195: goto L3110;
            case -1537610516: goto L3106;
            case -1537548942: goto L3102;
            case -1533531698: goto L3098;
            case -1532634484: goto L3094;
            case -1528628784: goto L3090;
            case -1526781787: goto L3086;
            case -1522778936: goto L3082;
            case -1521688678: goto L3078;
            case -1521454165: goto L3074;
            case -1508076299: goto L3070;
            case -1503532648: goto L3066;
            case -1492966548: goto L3062;
            case -1486015631: goto L3058;
            case -1485737841: goto L3054;
            case -1484749994: goto L3050;
            case -1482174954: goto L3046;
            case -1481674212: goto L3042;
            case -1477426834: goto L3038;
            case -1472983218: goto L3034;
            case -1470016095: goto L3030;
            case -1468161943: goto L3026;
            case -1464627302: goto L3022;
            case -1447794062: goto L3018;
            case -1446372015: goto L3014;
            case -1440195385: goto L3010;
            case -1427953845: goto L3006;
            case -1422611968: goto L3002;
            case -1420487376: goto L2998;
            case -1420214558: goto L2994;
            case -1419161643: goto L2990;
            case -1418949249: goto L2986;
            case -1414351944: goto L2982;
            case -1413199463: goto L2978;
            case -1412924983: goto L2974;
            case -1411335068: goto L2970;
            case -1408772159: goto L2966;
            case -1405961720: goto L2962;
            case -1396846807: goto L2958;
            case -1392181677: goto L2954;
            case -1390574968: goto L2950;
            case -1388130943: goto L2946;
            case -1373331879: goto L2942;
            case -1365223279: goto L2938;
            case -1364971920: goto L2934;
            case -1361530436: goto L2930;
            case -1360319727: goto L2926;
            case -1359176164: goto L2922;
            case -1358139226: goto L2918;
            case -1356679394: goto L2914;
            case -1354693781: goto L2910;
            case -1334040531: goto L2906;
            case -1334000955: goto L2902;
            case -1327493745: goto L2898;
            case -1305658159: goto L2894;
            case -1305182431: goto L2890;
            case -1290446764: goto L2886;
            case -1284683404: goto L2882;
            case -1283548607: goto L2878;
            case -1280178145: goto L2874;
            case -1279525760: goto L2870;
            case -1277551192: goto L2866;
            case -1267374852: goto L2862;
            case -1266788291: goto L2858;
            case -1266329929: goto L2854;
            case -1266045789: goto L2850;
            case -1265760599: goto L2846;
            case -1255411227: goto L2842;
            case -1255399487: goto L2838;
            case -1244858184: goto L2834;
            case -1236788349: goto L2830;
            case -1234204939: goto L2826;
            case -1233363435: goto L2822;
            case -1227566724: goto L2818;
            case -1226315320: goto L2814;
            case -1219976780: goto L2810;
            case -1219945557: goto L2806;
            case -1219463558: goto L2802;
            case -1216973131: goto L2798;
            case -1207703304: goto L2794;
            case -1207659565: goto L2790;
            case -1207459585: goto L2786;
            case -1205437563: goto L2782;
            case -1205085455: goto L2778;
            case -1196531969: goto L2774;
            case -1194808148: goto L2770;
            case -1190611502: goto L2766;
            case -1179030023: goto L2762;
            case -1179020113: goto L2758;
            case -1178495282: goto L2754;
            case -1177536076: goto L2750;
            case -1172929124: goto L2746;
            case -1171299282: goto L2742;
            case -1162538804: goto L2738;
            case -1154027116: goto L2734;
            case -1134688967: goto L2730;
            case -1132334996: goto L2726;
            case -1130948299: goto L2722;
            case -1130743528: goto L2718;
            case -1121318656: goto L2714;
            case -1106349759: goto L2710;
            case -1105721093: goto L2706;
            case -1099868708: goto L2702;
            case -1093910477: goto L2698;
            case -1092373153: goto L2694;
            case -1090728989: goto L2690;
            case -1087673919: goto L2686;
            case -1079109577: goto L2682;
            case -1077200566: goto L2678;
            case -1074333559: goto L2674;
            case -1073933745: goto L2670;
            case -1066186536: goto L2666;
            case -1065737689: goto L2662;
            case -1058467059: goto L2658;
            case -1056517536: goto L2654;
            case -1055264810: goto L2650;
            case -1054897407: goto L2646;
            case -1052601877: goto L2642;
            case -1052194340: goto L2638;
            case -1037756562: goto L2634;
            case -1032790918: goto L2630;
            case -1015468205: goto L2626;
            case -1014873039: goto L2622;
            case -1013996331: goto L2618;
            case -1012848786: goto L2614;
            case -1011449035: goto L2610;
            case -1003926119: goto L2606;
            case -992962032: goto L2602;
            case -977343600: goto L2598;
            case -975594662: goto L2594;
            case -972367967: goto L2590;
            case -965490233: goto L2586;
            case -953429453: goto L2582;
            case -952615364: goto L2578;
            case -950911620: goto L2574;
            case -949468937: goto L2570;
            case -949443588: goto L2566;
            case -949279935: goto L2562;
            case -936687621: goto L2558;
            case -931933289: goto L2554;
            case -929732175: goto L2550;
            case -926706298: goto L2546;
            case -925540162: goto L2542;
            case -922518018: goto L2538;
            case -921963023: goto L2534;
            case -920697538: goto L2530;
            case -898103695: goto L2526;
            case -897847258: goto L2522;
            case -896837652: goto L2518;
            case -892378171: goto L2514;
            case -887614667: goto L2510;
            case -882375621: goto L2506;
            case -878116883: goto L2502;
            case -875511953: goto L2498;
            case -868374699: goto L2494;
            case -861799206: goto L2490;
            case -858681673: goto L2486;
            case -851262611: goto L2482;
            case -850770334: goto L2478;
            case -842912892: goto L2474;
            case -838416547: goto L2470;
            case -833883996: goto L2466;
            case -828329002: goto L2462;
            case -819602143: goto L2458;
            case -814281480: goto L2454;
            case -806884317: goto L2450;
            case -803076562: goto L2446;
            case -798441945: goto L2442;
            case -791784203: goto L2438;
            case -791736954: goto L2434;
            case -776336870: goto L2430;
            case -776198914: goto L2426;
            case -775158495: goto L2422;
            case -773418898: goto L2418;
            case -770192981: goto L2414;
            case -767436525: goto L2410;
            case -744327845: goto L2406;
            case -740826157: goto L2402;
            case -739662166: goto L2398;
            case -726371143: goto L2394;
            case -725248186: goto L2390;
            case -723621112: goto L2386;
            case -719241953: goto L2382;
            case -718642108: goto L2378;
            case -717415349: goto L2374;
            case -717124080: goto L2370;
            case -716343418: goto L2366;
            case -709191812: goto L2362;
            case -699329961: goto L2358;
            case -699122158: goto L2354;
            case -697686902: goto L2350;
            case -697316947: goto L2346;
            case -696514880: goto L2342;
            case -696507843: goto L2338;
            case -696438536: goto L2334;
            case -696046478: goto L2330;
            case -689604287: goto L2326;
            case -686698581: goto L2322;
            case -686103597: goto L2318;
            case -681839542: goto L2314;
            case -663893918: goto L2310;
            case -655740289: goto L2306;
            case -654887831: goto L2302;
            case -652332012: goto L2298;
            case -650575155: goto L2294;
            case -635372463: goto L2290;
            case -628555825: goto L2286;
            case -625937929: goto L2282;
            case -621977901: goto L2278;
            case -618108667: goto L2274;
            case -615150787: goto L2270;
            case -612860388: goto L2266;
            case -605252540: goto L2262;
            case -603858248: goto L2258;
            case -602084215: goto L2254;
            case -594196599: goto L2250;
            case -594166705: goto L2246;
            case -593290696: goto L2242;
            case -592560279: goto L2238;
            case -590883705: goto L2234;
            case -582776969: goto L2230;
            case -580044984: goto L2226;
            case -575105251: goto L2222;
            case -571933918: goto L2218;
            case -541154163: goto L2214;
            case -539725956: goto L2210;
            case -539436197: goto L2206;
            case -538369605: goto L2202;
            case -537121159: goto L2198;
            case -532050866: goto L2194;
            case -530452330: goto L2190;
            case -520691330: goto L2186;
            case -520612502: goto L2182;
            case -514820097: goto L2178;
            case -509975298: goto L2174;
            case -508010128: goto L2170;
            case -497207862: goto L2166;
            case -491875086: goto L2162;
            case -488965141: goto L2158;
            case -482608882: goto L2154;
            case -480909286: goto L2150;
            case -466384168: goto L2146;
            case -459006949: goto L2142;
            case -457545893: goto L2138;
            case -448866242: goto L2134;
            case -443968843: goto L2130;
            case -435917014: goto L2126;
            case -431950148: goto L2122;
            case -431761888: goto L2118;
            case -429443635: goto L2114;
            case -428685136: goto L2110;
            case -427385068: goto L2106;
            case -424896684: goto L2102;
            case -405603167: goto L2098;
            case -404512413: goto L2094;
            case -402458327: goto L2090;
            case -395076556: goto L2086;
            case -385102981: goto L2082;
            case -379246765: goto L2078;
            case -371532681: goto L2074;
            case -364335646: goto L2070;
            case -362091789: goto L2066;
            case -360824169: goto L2062;
            case -355073772: goto L2058;
            case -351073084: goto L2054;
            case -349329551: goto L2050;
            case -349004789: goto L2046;
            case -347060727: goto L2042;
            case -342295247: goto L2038;
            case -341434991: goto L2034;
            case -336304401: goto L2030;
            case -325929818: goto L2026;
            case -324088735: goto L2022;
            case -321159462: goto L2018;
            case -318934084: goto L2014;
            case -314126932: goto L2010;
            case -311584524: goto L2006;
            case -291278819: goto L2002;
            case -288791285: goto L1998;
            case -277422657: goto L1994;
            case -274298599: goto L1990;
            case -272000052: goto L1986;
            case -270038016: goto L1982;
            case -267815326: goto L1978;
            case -265622745: goto L1974;
            case -265280401: goto L1970;
            case -265177061: goto L1966;
            case -254963767: goto L1962;
            case -248948709: goto L1958;
            case -243252896: goto L1954;
            case -243180263: goto L1950;
            case -240731871: goto L1946;
            case -232735685: goto L1942;
            case -230625472: goto L1938;
            case -222956560: goto L1934;
            case -207547325: goto L1930;
            case -205477180: goto L1926;
            case -201771400: goto L1922;
            case -198523465: goto L1918;
            case -196446112: goto L1914;
            case -191462075: goto L1910;
            case -189732549: goto L1906;
            case -189628749: goto L1902;
            case -188774978: goto L1898;
            case -173890402: goto L1894;
            case -173009607: goto L1890;
            case -166380543: goto L1886;
            case -164104686: goto L1882;
            case -162447868: goto L1878;
            case -161386568: goto L1874;
            case -158863879: goto L1870;
            case -127808917: goto L1866;
            case -126762897: goto L1862;
            case -120856821: goto L1858;
            case -116817109: goto L1854;
            case -113221722: goto L1850;
            case -106587468: goto L1846;
            case -100812230: goto L1842;
            case -100647297: goto L1838;
            case -87116144: goto L1834;
            case -79138012: goto L1830;
            case -59265275: goto L1826;
            case -57712139: goto L1822;
            case -56499017: goto L1818;
            case -51354026: goto L1814;
            case -44462226: goto L1810;
            case -36325472: goto L1806;
            case -35642380: goto L1802;
            case -33601951: goto L1798;
            case -31551216: goto L1794;
            case -18639460: goto L1790;
            case -17049931: goto L1786;
            case 653239: goto L1782;
            case 2493615: goto L1778;
            case 3709278: goto L1774;
            case 14783547: goto L1770;
            case 23852142: goto L1766;
            case 26004728: goto L1762;
            case 26285802: goto L1758;
            case 32439524: goto L1754;
            case 42993889: goto L1750;
            case 61846759: goto L1746;
            case 62032363: goto L1742;
            case 63735150: goto L1738;
            case 75649707: goto L1734;
            case 81037948: goto L1730;
            case 81961524: goto L1726;
            case 83542673: goto L1722;
            case 86526548: goto L1718;
            case 99667420: goto L1714;
            case 100148683: goto L1710;
            case 104277105: goto L1706;
            case 104492896: goto L1702;
            case 108041718: goto L1698;
            case 108061468: goto L1694;
            case 122866336: goto L1690;
            case 124117792: goto L1686;
            case 127520821: goto L1682;
            case 128932886: goto L1678;
            case 132308800: goto L1674;
            case 132811822: goto L1670;
            case 133053550: goto L1666;
            case 134627017: goto L1662;
            case 141265046: goto L1658;
            case 154807953: goto L1654;
            case 160922992: goto L1650;
            case 165097319: goto L1646;
            case 169574741: goto L1642;
            case 175037926: goto L1638;
            case 181684762: goto L1634;
            case 182428856: goto L1630;
            case 184208914: goto L1626;
            case 188951827: goto L1622;
            case 193339506: goto L1618;
            case 195663544: goto L1614;
            case 197626301: goto L1610;
            case 207350110: goto L1606;
            case 215550315: goto L1602;
            case 217420996: goto L1598;
            case 218309709: goto L1594;
            case 225036552: goto L1590;
            case 225908080: goto L1586;
            case 240814001: goto L1582;
            case 245268781: goto L1578;
            case 270607638: goto L1574;
            case 271922053: goto L1570;
            case 274368124: goto L1566;
            case 275179258: goto L1562;
            case 295448819: goto L1558;
            case 305348146: goto L1554;
            case 306185555: goto L1550;
            case 307174616: goto L1546;
            case 307336038: goto L1542;
            case 317631011: goto L1538;
            case 318425643: goto L1534;
            case 320619603: goto L1530;
            case 334230635: goto L1526;
            case 351053370: goto L1522;
            case 359256246: goto L1518;
            case 359285192: goto L1514;
            case 368745660: goto L1510;
            case 369010345: goto L1506;
            case 373878781: goto L1502;
            case 375149696: goto L1498;
            case 380401512: goto L1494;
            case 384033221: goto L1490;
            case 387029053: goto L1486;
            case 389204342: goto L1482;
            case 389894777: goto L1478;
            case 391354262: goto L1474;
            case 395552710: goto L1470;
            case 400677579: goto L1466;
            case 404499219: goto L1462;
            case 411356514: goto L1458;
            case 414095160: goto L1454;
            case 414431551: goto L1450;
            case 419548044: goto L1446;
            case 425048167: goto L1442;
            case 431273295: goto L1438;
            case 437708184: goto L1434;
            case 440972134: goto L1430;
            case 441252240: goto L1426;
            case 457914255: goto L1422;
            case 458679629: goto L1418;
            case 462091934: goto L1414;
            case 465470881: goto L1410;
            case 467808293: goto L1406;
            case 470417463: goto L1402;
            case 476847054: goto L1398;
            case 477254501: goto L1394;
            case 484803640: goto L1390;
            case 489576650: goto L1386;
            case 490057634: goto L1382;
            case 512942821: goto L1378;
            case 512959996: goto L1374;
            case 519551985: goto L1370;
            case 520850945: goto L1366;
            case 528638324: goto L1362;
            case 531551531: goto L1358;
            case 536913917: goto L1354;
            case 547769267: goto L1350;
            case 548921605: goto L1346;
            case 550457386: goto L1342;
            case 551703668: goto L1338;
            case 554341076: goto L1334;
            case 556149987: goto L1330;
            case 557789413: goto L1326;
            case 560184318: goto L1322;
            case 563354433: goto L1318;
            case 564581500: goto L1314;
            case 576585513: goto L1310;
            case 578008229: goto L1306;
            case 578142050: goto L1302;
            case 578831028: goto L1298;
            case 579723823: goto L1294;
            case 588013470: goto L1290;
            case 608625279: goto L1286;
            case 610418217: goto L1282;
            case 611510291: goto L1278;
            case 617411114: goto L1274;
            case 619224470: goto L1270;
            case 624888608: goto L1266;
            case 635149841: goto L1262;
            case 638465148: goto L1258;
            case 645956074: goto L1254;
            case 650728761: goto L1250;
            case 655835053: goto L1246;
            case 659624553: goto L1242;
            case 670776753: goto L1238;
            case 671802834: goto L1234;
            case 676556710: goto L1230;
            case 678606883: goto L1226;
            case 680522162: goto L1222;
            case 685181225: goto L1218;
            case 687671950: goto L1214;
            case 696575600: goto L1210;
            case 696594811: goto L1206;
            case 708137663: goto L1202;
            case 708608273: goto L1198;
            case 709896443: goto L1194;
            case 715181266: goto L1190;
            case 720020557: goto L1186;
            case 720508273: goto L1182;
            case 725781529: goto L1178;
            case 733609894: goto L1174;
            case 740422859: goto L1170;
            case 744125743: goto L1166;
            case 746141940: goto L1162;
            case 751247275: goto L1158;
            case 752280469: goto L1154;
            case 756922154: goto L1150;
            case 760417644: goto L1146;
            case 762693990: goto L1142;
            case 765027543: goto L1138;
            case 766030613: goto L1134;
            case 772574662: goto L1130;
            case 772714756: goto L1126;
            case 780473211: goto L1122;
            case 784862142: goto L1118;
            case 787671370: goto L1114;
            case 793314947: goto L1110;
            case 794271924: goto L1106;
            case 797419702: goto L1102;
            case 800642807: goto L1098;
            case 807452780: goto L1094;
            case 809295979: goto L1090;
            case 811558270: goto L1086;
            case 811710005: goto L1082;
            case 818691460: goto L1078;
            case 825320480: goto L1074;
            case 826186266: goto L1070;
            case 832699802: goto L1066;
            case 848054525: goto L1062;
            case 851785726: goto L1058;
            case 852138760: goto L1054;
            case 868354915: goto L1050;
            case 869779052: goto L1046;
            case 870259929: goto L1042;
            case 874671584: goto L1038;
            case 877026686: goto L1034;
            case 882340970: goto L1030;
            case 883309897: goto L1026;
            case 884171435: goto L1022;
            case 887853103: goto L1018;
            case 889853846: goto L1014;
            case 890357529: goto L1010;
            case 893602150: goto L1006;
            case 893852899: goto L1002;
            case 896257518: goto L998;
            case 898647388: goto L994;
            case 905641289: goto L990;
            case 908074769: goto L986;
            case 911443743: goto L982;
            case 915927358: goto L978;
            case 920095985: goto L974;
            case 931503455: goto L970;
            case 932828539: goto L966;
            case 935593269: goto L962;
            case 939806934: goto L958;
            case 940361321: goto L954;
            case 943232628: goto L950;
            case 944179490: goto L946;
            case 946495104: goto L942;
            case 959368139: goto L938;
            case 963047830: goto L934;
            case 963281079: goto L930;
            case 970640090: goto L926;
            case 978461681: goto L922;
            case 978802775: goto L918;
            case 981638030: goto L914;
            case 982489403: goto L910;
            case 990077711: goto L906;
            case 992898896: goto L902;
            case 1000842558: goto L898;
            case 1005832321: goto L894;
            case 1017564965: goto L890;
            case 1019658176: goto L886;
            case 1026571245: goto L882;
            case 1035011924: goto L878;
            case 1035105509: goto L874;
            case 1039963182: goto L870;
            case 1044098585: goto L866;
            case 1045698427: goto L862;
            case 1046325534: goto L858;
            case 1050591241: goto L854;
            case 1053771019: goto L850;
            case 1054965772: goto L846;
            case 1064333680: goto L842;
            case 1070252361: goto L838;
            case 1076512045: goto L834;
            case 1080469848: goto L830;
            case 1082454878: goto L826;
            case 1083716917: goto L822;
            case 1089103330: goto L818;
            case 1089207390: goto L814;
            case 1089953215: goto L810;
            case 1090148925: goto L806;
            case 1100422327: goto L802;
            case 1102306945: goto L798;
            case 1108156197: goto L794;
            case 1117958576: goto L790;
            case 1123896552: goto L786;
            case 1124703281: goto L782;
            case 1124973035: goto L778;
            case 1129916878: goto L774;
            case 1140532268: goto L770;
            case 1144220429: goto L766;
            case 1151578439: goto L762;
            case 1159930051: goto L758;
            case 1175131247: goto L754;
            case 1175659459: goto L750;
            case 1189945176: goto L746;
            case 1193293156: goto L742;
            case 1194263353: goto L738;
            case 1204031686: goto L734;
            case 1204283773: goto L730;
            case 1212902995: goto L726;
            case 1213582276: goto L722;
            case 1216906395: goto L718;
            case 1217768893: goto L714;
            case 1222729924: goto L710;
            case 1225765567: goto L706;
            case 1229310383: goto L702;
            case 1232421045: goto L698;
            case 1239487704: goto L694;
            case 1246571793: goto L690;
            case 1246824899: goto L686;
            case 1254468849: goto L682;
            case 1267648564: goto L678;
            case 1279759164: goto L674;
            case 1285417703: goto L670;
            case 1288011390: goto L666;
            case 1290379635: goto L662;
            case 1301813163: goto L658;
            case 1309034040: goto L654;
            case 1315677434: goto L650;
            case 1315829408: goto L646;
            case 1320548620: goto L642;
            case 1330237275: goto L638;
            case 1331500625: goto L634;
            case 1359323895: goto L630;
            case 1362884033: goto L626;
            case 1366600008: goto L622;
            case 1370313704: goto L618;
            case 1370701273: goto L614;
            case 1372357145: goto L610;
            case 1374245972: goto L606;
            case 1374719809: goto L602;
            case 1388051794: goto L598;
            case 1389779032: goto L594;
            case 1408365504: goto L590;
            case 1420842870: goto L586;
            case 1424720620: goto L582;
            case 1429207223: goto L578;
            case 1430409564: goto L574;
            case 1431710924: goto L570;
            case 1437344373: goto L566;
            case 1440068978: goto L562;
            case 1445235308: goto L558;
            case 1448637083: goto L554;
            case 1449146759: goto L550;
            case 1449432659: goto L546;
            case 1450665400: goto L542;
            case 1463580596: goto L538;
            case 1473760512: goto L534;
            case 1474927623: goto L530;
            case 1497196213: goto L526;
            case 1502318660: goto L522;
            case 1535351334: goto L518;
            case 1535371503: goto L514;
            case 1538629628: goto L510;
            case 1542525044: goto L506;
            case 1547314828: goto L502;
            case 1548625678: goto L498;
            case 1557505142: goto L494;
            case 1560996419: goto L490;
            case 1574129454: goto L486;
            case 1580477573: goto L482;
            case 1584980089: goto L478;
            case 1596521083: goto L474;
            case 1621592376: goto L470;
            case 1629548198: goto L466;
            case 1635142737: goto L462;
            case 1637356637: goto L458;
            case 1638510252: goto L454;
            case 1640791927: goto L450;
            case 1640961909: goto L446;
            case 1658895244: goto L442;
            case 1659249938: goto L438;
            case 1661381569: goto L434;
            case 1666866494: goto L430;
            case 1668799740: goto L426;
            case 1670921190: goto L422;
            case 1671139040: goto L418;
            case 1677988877: goto L414;
            case 1678211149: goto L410;
            case 1678604719: goto L406;
            case 1681481137: goto L402;
            case 1695721708: goto L398;
            case 1698137442: goto L394;
            case 1707528187: goto L390;
            case 1709711518: goto L386;
            case 1710577680: goto L382;
            case 1712980032: goto L378;
            case 1713016610: goto L374;
            case 1713713546: goto L370;
            case 1715797404: goto L366;
            case 1719074753: goto L362;
            case 1719360859: goto L358;
            case 1720079129: goto L354;
            case 1732861459: goto L350;
            case 1737906817: goto L346;
            case 1738596336: goto L342;
            case 1740450882: goto L338;
            case 1740859601: goto L334;
            case 1743456981: goto L330;
            case 1771368059: goto L326;
            case 1773512851: goto L322;
            case 1774753789: goto L318;
            case 1780210566: goto L314;
            case 1782053584: goto L310;
            case 1790449112: goto L306;
            case 1798840933: goto L302;
            case 1801244092: goto L298;
            case 1804946280: goto L294;
            case 1808068559: goto L290;
            case 1815559181: goto L286;
            case 1829854820: goto L282;
            case 1831101670: goto L278;
            case 1832255454: goto L274;
            case 1839465161: goto L270;
            case 1853813930: goto L266;
            case 1857603160: goto L262;
            case 1857803902: goto L258;
            case 1858048694: goto L254;
            case 1870235262: goto L250;
            case 1870306505: goto L246;
            case 1871290568: goto L242;
            case 1874371590: goto L238;
            case 1883144456: goto L234;
            case 1887765647: goto L230;
            case 1889205363: goto L226;
            case 1893784739: goto L222;
            case 1897082165: goto L218;
            case 1898814761: goto L214;
            case 1907606824: goto L210;
            case 1908914425: goto L206;
            case 1911945362: goto L202;
            case 1913954624: goto L198;
            case 1914864429: goto L194;
            case 1916679577: goto L190;
            case 1923297687: goto L186;
            case 1923981014: goto L182;
            case 1924369694: goto L178;
            case 1925940414: goto L174;
            case 1937721948: goto L170;
            case 1940384524: goto L166;
            case 1942194459: goto L162;
            case 1943027642: goto L158;
            case 1943721102: goto L154;
            case 1945067155: goto L150;
            case 1968172362: goto L146;
            case 1972364021: goto L142;
            case 1981652765: goto L138;
            case 1987262224: goto L134;
            case 1991873331: goto L130;
            case 1993768222: goto L126;
            case 1998453055: goto L122;
            case 2000368616: goto L118;
            case 2007637472: goto L114;
            case 2016350987: goto L110;
            case 2019001874: goto L106;
            case 2023707249: goto L102;
            case 2029515145: goto L98;
            case 2036393887: goto L94;
            case 2044149834: goto L90;
            case 2046021411: goto L86;
            case 2047767798: goto L82;
            case 2061612085: goto L78;
            case 2064064623: goto L74;
            case 2074674829: goto L70;
            case 2077453872: goto L66;
            case 2085582352: goto L62;
            case 2098293800: goto L58;
            case 2107888329: goto L54;
            case 2108608656: goto L50;
            case 2109000016: goto L46;
            case 2112198692: goto L42;
            case 2120306876: goto L38;
            case 2126006304: goto L34;
            case 2126532256: goto L30;
            case 2128877553: goto L26;
            case 2129071903: goto L22;
            case 2130874547: goto L18;
            case 2133712806: goto L14;
            case 2136808680: goto L10;
            case 2136826694: goto L6;
            default: goto L3605;
        };
    L3605:
        this.serviceImplNotExistSet.add(r3.getName());
        return null;
    L6:
        if (r3.getName().equals("com.larus.office.card.doc.download.IOfficeCardDocDownloadService") == false) goto L3605;
        T r4 = (T) new OfficeCardDocDownloadServiceImpl();
        putStaticServiceImplCache("com.larus.office.card.doc.download.IOfficeCardDocDownloadService", r4);
        return r4;
    L10:
        if (r3.getName().equals("com.obric.assistant.state.api.v2.IObricStateApi") == false) goto L3605;
        T r5 = (T) new ObricStateImpl();
        putStaticServiceImplCache("com.obric.assistant.state.api.v2.IObricStateApi", r5);
        return r5;
    L14:
        if (r3.getName().equals("com.larus.office.container.api.IOfficeContainerService") == false) goto L3605;
        T r6 = (T) new OfficeContainerService();
        putStaticServiceImplCache("com.larus.office.container.api.IOfficeContainerService", r6);
        return r6;
    L18:
        if (r3.getName().equals("com.obric.assistant.spi.login.ILogoutSceneInterceptor") == false) goto L3605;
        T r7 = (T) new LogoutSceneInterceptorImpl();
        putStaticServiceImplCache("com.obric.assistant.spi.login.ILogoutSceneInterceptor", r7);
        return r7;
    L22:
        if (r3.getName().equals("com.obric.assistant.interaction.api.IAssistantChatWindow") == false) goto L3605;
        T r8 = (T) new AssistantChatWindowImpl();
        putStaticServiceImplCache("com.obric.assistant.interaction.api.IAssistantChatWindow", r8);
        return r8;
    L26:
        if (r3.getName().equals("com.larus.reach.api.ReachService") == false) goto L3605;
        T r9 = (T) new ReachServiceImpl();
        putStaticServiceImplCache("com.larus.reach.api.ReachService", r9);
        return r9;
    L30:
        if (r3.getName().equals("com.obric.assistant.audio.service.IObricRealtimeCallStateService") == false) goto L3605;
        T r10 = (T) new ObricRealtimeCallStateService();
        putStaticServiceImplCache("com.obric.assistant.audio.service.IObricRealtimeCallStateService", r10);
        return r10;
    L34:
        if (r3.getName().equals("com.obric.assistant.performance.IObricMemoryReportService") == false) goto L3605;
        T r11 = (T) new ObricMemoryReportServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.performance.IObricMemoryReportService", r11);
        return r11;
    L38:
        if (r3.getName().equals("com.obric.assistant.activation.presentation.contract.session.VoiceInteractionProxySessionFactory") == false) goto L3605;
        T r12 = (T) new ObricVoiceInteractionProxySessionFactory();
        putStaticServiceImplCache("com.obric.assistant.activation.presentation.contract.session.VoiceInteractionProxySessionFactory", r12);
        return r12;
    L42:
        if (r3.getName().equals("com.larus.account.base.provider.ILarkLoginProvider") == false) goto L3605;
        T r13 = (T) new LarkLogin();
        putStaticServiceImplCache("com.larus.account.base.provider.ILarkLoginProvider", r13);
        return r13;
    L46:
        if (r3.getName().equals("com.bytedance.flow.search.kmp.api.spi.SearchMixedFeedService") == false) goto L3605;
        T r14 = (T) new KmpSearchMixedFeedServiceImpl();
        putStaticServiceImplCache("com.bytedance.flow.search.kmp.api.spi.SearchMixedFeedService", r14);
        return r14;
    L50:
        if (r3.getName().equals("com.larus.timonkit.api.ITimonKitService") == false) goto L3605;
        T r15 = (T) new TimonKitService();
        putStaticServiceImplCache("com.larus.timonkit.api.ITimonKitService", r15);
        return r15;
    L54:
        if (r3.getName().equals("com.obric.assistant.attention.IObricAttentionService") == false) goto L3605;
        T r16 = (T) new ObricAttentionServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.attention.IObricAttentionService", r16);
        return r16;
    L58:
        if (r3.getName().equals("com.larus.share.service.IShareShortUrlCreateService") == false) goto L3605;
        T r17 = (T) new ShareShortUrlCreateServiceImpl();
        putStaticServiceImplCache("com.larus.share.service.IShareShortUrlCreateService", r17);
        return r17;
    L62:
        if (r3.getName().equals("com.obric.aiagent.product.platform.api.rom.IRomInfo") == false) goto L3605;
        T r18 = (T) new CommonRomInfoImpl();
        putStaticServiceImplCache("com.obric.aiagent.product.platform.api.rom.IRomInfo", r18);
        return r18;
    L66:
        if (r3.getName().equals("com.obric.assistant.common.spi.IObricConfigService") == false) goto L3605;
        T r19 = (T) new ObricConfigServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.common.spi.IObricConfigService", r19);
        return r19;
    L70:
        if (r3.getName().equals("com.larus.uaigc.service.ICreationSpringVenueService") == false) goto L3605;
        T r20 = (T) new CreationSpringVenueServiceImpl();
        putStaticServiceImplCache("com.larus.uaigc.service.ICreationSpringVenueService", r20);
        return r20;
    L74:
        if (r3.getName().equals("com.obric.assistant.obric_action.IObricActionService") == false) goto L3605;
        T r21 = (T) new ObricActionServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.obric_action.IObricActionService", r21);
        return r21;
    L78:
        if (r3.getName().equals("com.obric.aiagent.assistant.idl.IFlowCocreationReviewIDLSPI") == false) goto L3605;
        T r22 = (T) new OmniLabelingFlowIDLStub();
        putStaticServiceImplCache("com.obric.aiagent.assistant.idl.IFlowCocreationReviewIDLSPI", r22);
        return r22;
    L82:
        if (r3.getName().equals("com.larus.audio.audiov3.audio.player.factory.IAudioPlayerFactory") == false) goto L3605;
        T r23 = (T) new AudioPlayerFactory();
        putStaticServiceImplCache("com.larus.audio.audiov3.audio.player.factory.IAudioPlayerFactory", r23);
        return r23;
    L86:
        if (r3.getName().equals("com.obric.aiagent.messenger.IObricPccService") == false) goto L3605;
        T r24 = (T) new ObricPccServiceImpl();
        putStaticServiceImplCache("com.obric.aiagent.messenger.IObricPccService", r24);
        return r24;
    L90:
        if (r3.getName().equals("com.obric.assistant.common.spi.network.IObricSecurityNetworkService") == false) goto L3605;
        T r25 = (T) new ObricSecurityNetworkServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.common.spi.network.IObricSecurityNetworkService", r25);
        return r25;
    L94:
        if (r3.getName().equals("com.larus.bmhome.chat.messagetransfer.IFlowMergeForwardService") == false) goto L3605;
        T r26 = (T) new FlowMergeForwardServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.chat.messagetransfer.IFlowMergeForwardService", r26);
        return r26;
    L98:
        if (r3.getName().equals("com.larus.audio.ttsV2.ITtsClientService") == false) goto L3605;
        T r28 = (T) new TtsClientServiceImpl();
        putStaticServiceImplCache("com.larus.audio.ttsV2.ITtsClientService", r28);
        return r28;
    L102:
        if (r3.getName().equals("com.larus.account.saas.ttaccount.api.IAccountGroupAuthServerService") == false) goto L3605;
        T r29 = (T) new AccountGroupAuthServerService();
        putStaticServiceImplCache("com.larus.account.saas.ttaccount.api.IAccountGroupAuthServerService", r29);
        return r29;
    L106:
        if (r3.getName().equals("com.larus.bmhome.taskskill.service.IProjectListDataSource") == false) goto L3605;
        T r30 = (T) new ProjectListDataSourceImpl();
        putStaticServiceImplCache("com.larus.bmhome.taskskill.service.IProjectListDataSource", r30);
        return r30;
    L110:
        if (r3.getName().equals("com.larus.audio.IFlowTtsClientFactory") == false) goto L3605;
        T r31 = (T) new FlowTtsClientFactoryImpl();
        putStaticServiceImplCache("com.larus.audio.IFlowTtsClientFactory", r31);
        return r31;
    L114:
        if (r3.getName().equals("com.larus.extension.aggregate_search_ui.api.ILarkAvatarViewProvider") == false) goto L3605;
        T r32 = (T) new LarkAvatarViewProvider();
        putStaticServiceImplCache("com.larus.extension.aggregate_search_ui.api.ILarkAvatarViewProvider", r32);
        return r32;
    L118:
        if (r3.getName().equals("com.larus.ugc.perf.api.IUgcPerfService") == false) goto L3605;
        T r33 = (T) new UgcPerfServiceImpl();
        putStaticServiceImplCache("com.larus.ugc.perf.api.IUgcPerfService", r33);
        return r33;
    L122:
        if (r3.getName().equals("com.larus.bmhome.audio.IRealtimeCallService") == false) goto L3605;
        T r34 = (T) new RealtimeCallService();
        putStaticServiceImplCache("com.larus.bmhome.audio.IRealtimeCallService", r34);
        return r34;
    L126:
        if (r3.getName().equals("com.obric.audio.tts.IObricChainTtsService") == false) goto L3605;
        T r35 = (T) new ObricChainTtsServiceImpl();
        putStaticServiceImplCache("com.obric.audio.tts.IObricChainTtsService", r35);
        return r35;
    L130:
        if (r3.getName().equals("com.larus.bmhome.chat.api.IAppletPayloadProviderService") == false) goto L3605;
        T r36 = (T) new AppletPayloadProviderServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.chat.api.IAppletPayloadProviderService", r36);
        return r36;
    L134:
        if (r3.getName().equals("com.larus.share.impl.panel.ISharePanelService") == false) goto L3605;
        T r37 = (T) new SharePanelService();
        putStaticServiceImplCache("com.larus.share.impl.panel.ISharePanelService", r37);
        return r37;
    L138:
        if (r3.getName().equals("com.larus.sync.api.SyncSDKService") == false) goto L3605;
        T r38 = (T) new SyncSDKServiceImpl();
        putStaticServiceImplCache("com.larus.sync.api.SyncSDKService", r38);
        return r38;
    L142:
        if (r3.getName().equals("com.obric.assistant.IObricSettingsApi") == false) goto L3605;
        T r39 = (T) new ObricSettingsServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.IObricSettingsApi", r39);
        return r39;
    L146:
        if (r3.getName().equals("com.bytedance.ai.api.navi.IAppletNaviService") == false) goto L3605;
        T r40 = (T) new AppletNaviServiceImpl();
        putStaticServiceImplCache("com.bytedance.ai.api.navi.IAppletNaviService", r40);
        return r40;
    L150:
        if (r3.getName().equals("com.obric.assistant.trace.IObricTraceParam") == false) goto L3605;
        T r41 = (T) new ObricTraceParamImpl();
        putStaticServiceImplCache("com.obric.assistant.trace.IObricTraceParam", r41);
        return r41;
    L154:
        if (r3.getName().equals("com.obric.assistant.spi.window.IChatWindowService") == false) goto L3605;
        T r42 = (T) new WindowInteractionServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.spi.window.IChatWindowService", r42);
        return r42;
    L158:
        if (r3.getName().equals("com.larus.ivykit.web.TTWebViewService") == false) goto L3605;
        T r43 = (T) new TTWebViewServiceImpl();
        putStaticServiceImplCache("com.larus.ivykit.web.TTWebViewService", r43);
        return r43;
    L162:
        if (r3.getName().equals("com.obric.assistant.searchqa.IObricSearchQaLabelingService") == false) goto L3605;
        T r44 = (T) new ObricSearchQaLabelingServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.searchqa.IObricSearchQaLabelingService", r44);
        return r44;
    L166:
        if (r3.getName().equals("com.larus.platform.spi.IAIChatUgcAIGCService") == false) goto L3605;
        T r45 = (T) new AiChatUgcAIGCServiceImpl();
        putStaticServiceImplCache("com.larus.platform.spi.IAIChatUgcAIGCService", r45);
        return r45;
    L170:
        if (r3.getName().equals("com.larus.extension.aggregate_search_ui.api.kmp.KmpISearchCellProvider") == false) goto L3605;
        T r46 = (T) new KmpContactSearchCellProvider();
        putStaticServiceImplCache("com.larus.extension.aggregate_search_ui.api.kmp.KmpISearchCellProvider", r46);
        return r46;
    L174:
        if (r3.getName().equals("com.obric.assistant.interaction.api.IScreenState") == false) goto L3605;
        T r47 = (T) new ScreenStateImpl();
        putStaticServiceImplCache("com.obric.assistant.interaction.api.IScreenState", r47);
        return r47;
    L178:
        if (r3.getName().equals("com.larus.uaigc.service.ICreationSaveService") == false) goto L3605;
        T r48 = (T) new CreationSaveServiceImpl();
        putStaticServiceImplCache("com.larus.uaigc.service.ICreationSaveService", r48);
        return r48;
    L182:
        if (r3.getName().equals("com.ivy.ivykit.api.plugin.IIvyWebService") == false) goto L3605;
        T r49 = (T) new IvyWebServiceImpl();
        putStaticServiceImplCache("com.ivy.ivykit.api.plugin.IIvyWebService", r49);
        return r49;
    L186:
        if (r3.getName().equals("com.obric.assistant.spi.notification.IObricNotificationListenerService") == false) goto L3605;
        T r50 = (T) new ObricNotificationListenerServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.spi.notification.IObricNotificationListenerService", r50);
        return r50;
    L190:
        if (r3.getName().equals("com.larus.account.base.api.IMultiAccountProfileService") == false) goto L3605;
        T r51 = (T) new MultiAccountProfileImpl();
        putStaticServiceImplCache("com.larus.account.base.api.IMultiAccountProfileService", r51);
        return r51;
    L194:
        if (r3.getName().equals("com.larus.apm.api.ITTProtector") == false) goto L3605;
        T r52 = (T) new TTProtectorImpl();
        putStaticServiceImplCache("com.larus.apm.api.ITTProtector", r52);
        return r52;
    L198:
        if (r3.getName().equals("com.ss.android.ugc.aweme.search.common.service.IECSearchService") == false) goto L3605;
        T r53 = (T) new ECSearchServiceImpl();
        putStaticServiceImplCache("com.ss.android.ugc.aweme.search.common.service.IECSearchService", r53);
        return r53;
    L202:
        if (r3.getName().equals("com.obric.aiagent.assistant.idl.IFlowNetworkIDLSPI") == false) goto L3605;
        T r54 = (T) new FlowNetworkIDLStub();
        putStaticServiceImplCache("com.obric.aiagent.assistant.idl.IFlowNetworkIDLSPI", r54);
        return r54;
    L206:
        if (r3.getName().equals("com.obric.assistant.state.api.v2.core.IObricMsgInfoSaveService") == false) goto L3605;
        T r55 = (T) new ObricMsgInfoSaveServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.state.api.v2.core.IObricMsgInfoSaveService", r55);
        return r55;
    L210:
        if (r3.getName().equals("com.larus.bmhome.chat.model.repo.INotifyService") == false) goto L3605;
        T r56 = (T) new NotifyService();
        putStaticServiceImplCache("com.larus.bmhome.chat.model.repo.INotifyService", r56);
        return r56;
    L214:
        if (r3.getName().equals("com.obric.assistant.permission.IObricPermissionService") == false) goto L3605;
        T r57 = (T) new IObricPermissionServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.permission.IObricPermissionService", r57);
        return r57;
    L218:
        if (r3.getName().equals("com.larus.bmhome.chat.block.base.config.IBlockDetailNavigatorService") == false) goto L3605;
        T r58 = (T) new BlockDetailNavigatorServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.chat.block.base.config.IBlockDetailNavigatorService", r58);
        return r58;
    L222:
        if (r3.getName().equals("com.bytedance.android.ec.hybrid.service.IECEventCenterService") == false) goto L3605;
        T r59 = (T) new ECEventCenterSerivceDefaultImpl();
        putStaticServiceImplCache("com.bytedance.android.ec.hybrid.service.IECEventCenterService", r59);
        return r59;
    L226:
        if (r3.getName().equals("com.obric.assistant.spi.update.IObricUpdateSPIService") == false) goto L3605;
        T r60 = (T) new ObricUpdateSPIImplService();
        putStaticServiceImplCache("com.obric.assistant.spi.update.IObricUpdateSPIService", r60);
        return r60;
    L230:
        if (r3.getName().equals("com.obric.assistant.utils.IObricSensitiveErase") == false) goto L3605;
        T r61 = (T) new ObricSensitiveEraseImpl();
        putStaticServiceImplCache("com.obric.assistant.utils.IObricSensitiveErase", r61);
        return r61;
    L234:
        if (r3.getName().equals("com.larus.bmhome.setting.IFragmentProvider") == false) goto L3605;
        T r62 = (T) new FragmentProviderImpl();
        putStaticServiceImplCache("com.larus.bmhome.setting.IFragmentProvider", r62);
        return r62;
    L238:
        if (r3.getName().equals("com.larus.community.api.spi.ICommunityHostBehaviorProvider") == false) goto L3605;
        T r63 = (T) new DoubaoCommunityHostBehaviorProvider();
        putStaticServiceImplCache("com.larus.community.api.spi.ICommunityHostBehaviorProvider", r63);
        return r63;
    L242:
        if (r3.getName().equals("com.obric.assistant.spi.message.IObricForegroundWidgetSyncService") == false) goto L3605;
        T r64 = (T) new ObricForegroundWidgetSyncServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.spi.message.IObricForegroundWidgetSyncService", r64);
        return r64;
    L246:
        if (r3.getName().equals("com.ivy.ivykit.api.plugin.IIvyLynxRuntimeService") == false) goto L3605;
        T r65 = (T) new IvyLynxRuntimeServiceImpl();
        putStaticServiceImplCache("com.ivy.ivykit.api.plugin.IIvyLynxRuntimeService", r65);
        return r65;
    L250:
        if (r3.getName().equals("com.larus.podcast.IFlowPodcastService") == false) goto L3605;
        T r66 = (T) new FlowPodcastService();
        putStaticServiceImplCache("com.larus.podcast.IFlowPodcastService", r66);
        return r66;
    L254:
        if (r3.getName().equals("com.larus.avlink.api.IDoraAVLinkService") == false) goto L3605;
        T r67 = (T) new DoraAVLinkServiceImpl();
        putStaticServiceImplCache("com.larus.avlink.api.IDoraAVLinkService", r67);
        return r67;
    L258:
        if (r3.getName().equals("com.obric.aiagent.messenger.IObricIPC") == false) goto L3605;
        T r68 = (T) new ObricIPCImpl();
        putStaticServiceImplCache("com.obric.aiagent.messenger.IObricIPC", r68);
        return r68;
    L262:
        if (r3.getName().equals("com.bytedance.ai.api.AppletExtService") == false) goto L3605;
        T r69 = (T) new AppletExtServiceImpl();
        putStaticServiceImplCache("com.bytedance.ai.api.AppletExtService", r69);
        return r69;
    L266:
        if (r3.getName().equals("com.obric.assistant.oneshot.api.IOneshotService") == false) goto L3605;
        T r70 = (T) new OneshotServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.oneshot.api.IOneshotService", r70);
        return r70;
    L270:
        if (r3.getName().equals("com.larus.im.depend.IAzerothService") == false) goto L3605;
        T r71 = (T) new AzerothServiceImpl();
        putStaticServiceImplCache("com.larus.im.depend.IAzerothService", r71);
        return r71;
    L274:
        if (r3.getName().equals("com.larus.bmhome.monitor.ICommonUIMessageImageLoaderService") == false) goto L3605;
        T r72 = (T) new CommonUIMessageImageLoaderImpl();
        putStaticServiceImplCache("com.larus.bmhome.monitor.ICommonUIMessageImageLoaderService", r72);
        return r72;
    L278:
        if (r3.getName().equals("com.larus.commercecredit.api.ICommerceCreditService") == false) goto L3605;
        T r73 = (T) new CommerceCreditService();
        putStaticServiceImplCache("com.larus.commercecredit.api.ICommerceCreditService", r73);
        return r73;
    L282:
        if (r3.getName().equals("com.larus.home.api.main.IPrivacyService") == false) goto L3605;
        T r74 = (T) new PrivacyServiceImpl();
        putStaticServiceImplCache("com.larus.home.api.main.IPrivacyService", r74);
        return r74;
    L286:
        if (r3.getName().equals("com.larus.common.zlinksdk.api.IZlinkConfigs") == false) goto L3605;
        T r75 = (T) new ZlinkConfigs();
        putStaticServiceImplCache("com.larus.common.zlinksdk.api.IZlinkConfigs", r75);
        return r75;
    L290:
        if (r3.getName().equals("com.obric.assistant.login.IObricAccountInfoMonitorService") == false) goto L3605;
        T r76 = (T) new ObricAccountInfoMonitorServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.login.IObricAccountInfoMonitorService", r76);
        return r76;
    L294:
        if (r3.getName().equals("com.obric.assistant.session.model.IObricChatSessionOperation") == false) goto L3605;
        T r77 = (T) new ObricChatServiceEndpoint();
        putStaticServiceImplCache("com.obric.assistant.session.model.IObricChatSessionOperation", r77);
        return r77;
    L298:
        if (r3.getName().equals("com.larus.minor.api.IMinorService") == false) goto L3605;
        T r78 = (T) new MinorServiceImpl();
        putStaticServiceImplCache("com.larus.minor.api.IMinorService", r78);
        return r78;
    L302:
        if (r3.getName().equals("com.larus.mirabridge.api.plugin.service.IMiraUtilService") == false) goto L3605;
        T r79 = (T) new MiraUtilServiceImpl();
        putStaticServiceImplCache("com.larus.mirabridge.api.plugin.service.IMiraUtilService", r79);
        return r79;
    L306:
        if (r3.getName().equals("com.larus.platform.api.IFlowOfficeThemeConfigProvider") == false) goto L3605;
        T r80 = (T) new FlowOfficeThemeConfigProvider();
        putStaticServiceImplCache("com.larus.platform.api.IFlowOfficeThemeConfigProvider", r80);
        return r80;
    L310:
        if (r3.getName().equals("com.larus.account.base.provider.IThirdPartyPlatformAuthorizationProvider") == false) goto L3605;
        T r81 = (T) new LarkAuthorization();
        putStaticServiceImplCache("com.larus.account.base.provider.IThirdPartyPlatformAuthorizationProvider", r81);
        return r81;
    L314:
        if (r3.getName().equals("com.larus.platform.spi.IAIChatConversationService") == false) goto L3605;
        T r82 = (T) new AIChatConversationServiceImpl();
        putStaticServiceImplCache("com.larus.platform.spi.IAIChatConversationService", r82);
        return r82;
    L318:
        if (r3.getName().equals("com.obric.assistant.spi.security.minormode.IObricMinorModeService") == false) goto L3605;
        T r83 = (T) new ObricMinorModeServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.spi.security.minormode.IObricMinorModeService", r83);
        return r83;
    L322:
        if (r3.getName().equals("com.larus.update.IBitsUpdate") == false) goto L3605;
        T r84 = (T) new IBitsUpdateImpl();
        putStaticServiceImplCache("com.larus.update.IBitsUpdate", r84);
        return r84;
    L326:
        if (r3.getName().equals("com.bytedance.bmf_mods_api.VideoSRLutAPI") == false) goto L3605;
        T r85 = (T) new VideoSRLut();
        putStaticServiceImplCache("com.bytedance.bmf_mods_api.VideoSRLutAPI", r85);
        return r85;
    L330:
        if (r3.getName().equals("com.larus.voicecall.api.autostop.IAutoStopAsrServiceProvider") == false) goto L3605;
        T r86 = (T) new AutoStopAsrServiceProviderImpl();
        putStaticServiceImplCache("com.larus.voicecall.api.autostop.IAutoStopAsrServiceProvider", r86);
        return r86;
    L334:
        if (r3.getName().equals("com.larus.chat.gallery.api.IFindSimilarClickHandler") == false) goto L3605;
        T r87 = (T) new FindSimilarClickHandlerImpl();
        putStaticServiceImplCache("com.larus.chat.gallery.api.IFindSimilarClickHandler", r87);
        return r87;
    L338:
        if (r3.getName().equals("com.larus.uaigc.service.ICreationAvatarService") == false) goto L3605;
        T r88 = (T) new CreationAvatarServiceImpl();
        putStaticServiceImplCache("com.larus.uaigc.service.ICreationAvatarService", r88);
        return r88;
    L342:
        if (r3.getName().equals("com.bytedance.bmf_mods_api.MotionSenseAPI") == false) goto L3605;
        return (T) new MotionSense();
    L346:
        if (r3.getName().equals("com.bytedance.android.ec.slice.adapter.api.IECSliceAdapterService") == false) goto L3605;
        T r89 = (T) new ECSliceAdapterServiceImpl();
        putStaticServiceImplCache("com.bytedance.android.ec.slice.adapter.api.IECSliceAdapterService", r89);
        return r89;
    L350:
        if (r3.getName().equals("com.enroll.audio.enroll.IBtHeadsetEnrollService") == false) goto L3605;
        T r90 = (T) new BtHeadsetEnrollServiceImpl();
        putStaticServiceImplCache("com.enroll.audio.enroll.IBtHeadsetEnrollService", r90);
        return r90;
    L354:
        if (r3.getName().equals("com.bytedance.timon.foundation.interfaces.ILogger") == false) goto L3605;
        T r91 = (T) new AlogLoggerImpl();
        putStaticServiceImplCache("com.bytedance.timon.foundation.interfaces.ILogger", r91);
        return r91;
    L358:
        if (r3.getName().equals("com.obric.assistant.spi.office.IOfficeSdkLazyInitSettingsService") == false) goto L3605;
        T r92 = (T) new OfficeSdkLazyInitSettingsServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.spi.office.IOfficeSdkLazyInitSettingsService", r92);
        return r92;
    L362:
        if (r3.getName().equals("com.obric.aiagent.assistant.idl.IFlowPermissionIDLSPI") == false) goto L3605;
        T r93 = (T) new FlowPermissionIDLStub();
        putStaticServiceImplCache("com.obric.aiagent.assistant.idl.IFlowPermissionIDLSPI", r93);
        return r93;
    L366:
        if (r3.getName().equals("com.larus.discover.api.IDiscoverService") == false) goto L3605;
        T r94 = (T) new DiscoverServiceImpl();
        putStaticServiceImplCache("com.larus.discover.api.IDiscoverService", r94);
        return r94;
    L370:
        if (r3.getName().equals("com.obric.assistant.interaction.api.keyguard.ISendMsgExtService") == false) goto L3605;
        T r95 = (T) new SendMsgExtServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.interaction.api.keyguard.ISendMsgExtService", r95);
        return r95;
    L374:
        if (r3.getName().equals("com.larus.tts.ITtsReaderFactory") == false) goto L3605;
        T r96 = (T) new TtsReaderFactoryImpl();
        putStaticServiceImplCache("com.larus.tts.ITtsReaderFactory", r96);
        return r96;
    L378:
        if (r3.getName().equals("com.larus.account.saas.coreapi.IAccountDeeplinkHandler") == false) goto L3605;
        T r97 = (T) new MfaDeeplinkHandler();
        putStaticServiceImplCache("com.larus.account.saas.coreapi.IAccountDeeplinkHandler", r97);
        return r97;
    L382:
        if (r3.getName().equals("com.ss.android.ugc.aweme.live.ILivePluginApi") == false) goto L3605;
        T r98 = (T) new LivePluginImpl();
        putStaticServiceImplCache("com.ss.android.ugc.aweme.live.ILivePluginApi", r98);
        return r98;
    L386:
        if (r3.getName().equals("com.larus.audio.audiov3.config.audio.player.IAudioPlayerConfigFactory") == false) goto L3605;
        T r99 = (T) new AudioPlayerConfigFactory();
        putStaticServiceImplCache("com.larus.audio.audiov3.config.audio.player.IAudioPlayerConfigFactory", r99);
        return r99;
    L390:
        if (r3.getName().equals("com.larus.extension.chat_extension.api.IDouyinRecommendService") == false) goto L3605;
        T r100 = (T) new DouyinRecommendServiceImpl();
        putStaticServiceImplCache("com.larus.extension.chat_extension.api.IDouyinRecommendService", r100);
        return r100;
    L394:
        if (r3.getName().equals("com.obric.assistant.common.spi.IObricFeatureService") == false) goto L3605;
        T r101 = (T) new ObricFeatureServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.common.spi.IObricFeatureService", r101);
        return r101;
    L398:
        if (r3.getName().equals("com.ivy.ivykit.api.plugin.IIvyHybridMonitorService") == false) goto L3605;
        T r102 = (T) new IvyHybridMonitorServiceImpl();
        putStaticServiceImplCache("com.ivy.ivykit.api.plugin.IIvyHybridMonitorService", r102);
        return r102;
    L402:
        if (r3.getName().equals("com.ivy.ivykit.api.plugin.IIvyPageService") == false) goto L3605;
        T r103 = (T) new IvyPageServiceImpl();
        putStaticServiceImplCache("com.ivy.ivykit.api.plugin.IIvyPageService", r103);
        return r103;
    L406:
        if (r3.getName().equals("com.bytedance.bmf_mods_api.DenoiseAPI") == false) goto L3605;
        return (T) new Denoise();
    L410:
        if (r3.getName().equals("com.larus.bmhome.chat.block.base.config.IRichMediaCreationClickService") == false) goto L3605;
        T r104 = (T) new RichMediaCreationClickServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.chat.block.base.config.IRichMediaCreationClickService", r104);
        return r104;
    L414:
        if (r3.getName().equals("com.obric.assistant.state.api.multitask.producer.IObricAlarmTtsStateProducerService") == false) goto L3605;
        T r105 = (T) new ObricAlarmTtsStateProducer();
        putStaticServiceImplCache("com.obric.assistant.state.api.multitask.producer.IObricAlarmTtsStateProducerService", r105);
        return r105;
    L418:
        if (r3.getName().equals("com.obric.assistant.spi.chat.IObricChatExtensionService") == false) goto L3605;
        T r106 = (T) new ObricChatExtensionServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.spi.chat.IObricChatExtensionService", r106);
        return r106;
    L422:
        if (r3.getName().equals("com.ss.android.lark.biz.officesdk.im.message.menu.IDoubaoTextSelectService") == false) goto L3605;
        T r107 = (T) new DouBaoTextSelectServiceImpl();
        putStaticServiceImplCache("com.ss.android.lark.biz.officesdk.im.message.menu.IDoubaoTextSelectService", r107);
        return r107;
    L426:
        if (r3.getName().equals("com.larus.home.api.main.ILarkOfficeAppLinkInterceptorProvider") == false) goto L3605;
        T r108 = (T) new LarkOfficeAppLinkInterceptorProvider();
        putStaticServiceImplCache("com.larus.home.api.main.ILarkOfficeAppLinkInterceptorProvider", r108);
        return r108;
    L430:
        if (r3.getName().equals("com.obric.assistant.common.spi.IObricUIService") == false) goto L3605;
        T r109 = (T) new ObricUIServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.common.spi.IObricUIService", r109);
        return r109;
    L434:
        if (r3.getName().equals("com.larus.map.api.IMapApi") == false) goto L3605;
        T r110 = (T) new MapServiceImpl();
        putStaticServiceImplCache("com.larus.map.api.IMapApi", r110);
        return r110;
    L438:
        if (r3.getName().equals("com.bytedance.android.shopping.api.mall.ILegouLynxBehaviorService") == false) goto L3605;
        T r111 = (T) new LegouLynxBehaviorDefaultService();
        putStaticServiceImplCache("com.bytedance.android.shopping.api.mall.ILegouLynxBehaviorService", r111);
        return r111;
    L442:
        if (r3.getName().equals("com.larus.login.api.ILoginInitService") == false) goto L3605;
        T r112 = (T) new LoginInitServiceImpl();
        putStaticServiceImplCache("com.larus.login.api.ILoginInitService", r112);
        return r112;
    L446:
        if (r3.getName().equals("com.larus.voice.output.volume.IVolumeService") == false) goto L3605;
        T r113 = (T) new VolumeServiceImpl();
        putStaticServiceImplCache("com.larus.voice.output.volume.IVolumeService", r113);
        return r113;
    L450:
        if (r3.getName().equals("com.larus.dora.api.IDoraObricService") == false) goto L3605;
        T r114 = (T) new DoraObricServiceImpl();
        putStaticServiceImplCache("com.larus.dora.api.IDoraObricService", r114);
        return r114;
    L454:
        if (r3.getName().equals("com.larus.tts.IUserSettingRepoService") == false) goto L3605;
        T r115 = (T) new UserSettingImpl();
        putStaticServiceImplCache("com.larus.tts.IUserSettingRepoService", r115);
        return r115;
    L458:
        if (r3.getName().equals("com.larus.bmhome.chat.zoom.IZoomInAnimationProvider") == false) goto L3605;
        T r116 = (T) new ImageAnalysisZoomInAnimationImpl();
        putStaticServiceImplCache("com.larus.bmhome.chat.zoom.IZoomInAnimationProvider", r116);
        return r116;
    L462:
        if (r3.getName().equals("com.obric.assistant.session.model.IAssistActivateOperation") == false) goto L3605;
        T r117 = (T) new AssistActivateEndPoint();
        putStaticServiceImplCache("com.obric.assistant.session.model.IAssistActivateOperation", r117);
        return r117;
    L466:
        if (r3.getName().equals("com.obric.assistant.actionbar.service.IObricActionBarTrackServiceExt") == false) goto L3605;
        T r118 = (T) new ObricActionBarTrackServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.actionbar.service.IObricActionBarTrackServiceExt", r118);
        return r118;
    L470:
        if (r3.getName().equals("com.bytedance.timon.ruler.adapter.impl.IRulerHardCodeValidatorService") == false) goto L3605;
        T r119 = (T) new RulerHardCodeValidatorServiceImpl();
        putStaticServiceImplCache("com.bytedance.timon.ruler.adapter.impl.IRulerHardCodeValidatorService", r119);
        return r119;
    L474:
        if (r3.getName().equals("com.obric.assistant.network.api.INetworkInterceptorService") == false) goto L3605;
        T r120 = (T) new NetworkInterceptorServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.network.api.INetworkInterceptorService", r120);
        return r120;
    L478:
        if (r3.getName().equals("com.larus.account.saas.ui.IAccountSaasUiResourceResolver") == false) goto L3605;
        T r121 = (T) new DefaultAccountSaasUiResourceResolver();
        putStaticServiceImplCache("com.larus.account.saas.ui.IAccountSaasUiResourceResolver", r121);
        return r121;
    L482:
        if (r3.getName().equals("com.larus.ui.arch.modulizer.di.IComponentRegistry") == false) goto L3605;
        T r122 = (T) new ChatCommerceMembershipComponentRegistry();
        putStaticServiceImplCache("com.larus.ui.arch.modulizer.di.IComponentRegistry", r122);
        return r122;
    L486:
        if (r3.getName().equals("com.larus.account.saas.security.api.IAccountSecurityPushUiService") == false) goto L3605;
        T r123 = (T) new DefaultAccountSecurityPushUiService();
        putStaticServiceImplCache("com.larus.account.saas.security.api.IAccountSecurityPushUiService", r123);
        return r123;
    L490:
        if (r3.getName().equals("com.bytedance.flow_audio.api.service.common.IKMPLoggerService") == false) goto L3605;
        T r124 = (T) new LoggerInject();
        putStaticServiceImplCache("com.bytedance.flow_audio.api.service.common.IKMPLoggerService", r124);
        return r124;
    L494:
        if (r3.getName().equals("com.larus.uaigc.service.ICreationAppletDetailProvider") == false) goto L3605;
        T r125 = (T) new CreationAppletDetailProviderImpl();
        putStaticServiceImplCache("com.larus.uaigc.service.ICreationAppletDetailProvider", r125);
        return r125;
    L498:
        if (r3.getName().equals("com.larus.dora.o.api.IDoraOUIService") == false) goto L3605;
        T r126 = (T) new DoraOUIServiceImpl();
        putStaticServiceImplCache("com.larus.dora.o.api.IDoraOUIService", r126);
        return r126;
    L502:
        if (r3.getName().equals("com.larus.bmhome.chat.IMarkdownResolver") == false) goto L3605;
        T r127 = (T) new MarkdownResolverServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.chat.IMarkdownResolver", r127);
        return r127;
    L506:
        if (r3.getName().equals("com.obric.assistant.session.model.IPowerKeyWakeupOperation") == false) goto L3605;
        T r128 = (T) new PowerKeyWakeupEndpoint();
        putStaticServiceImplCache("com.obric.assistant.session.model.IPowerKeyWakeupOperation", r128);
        return r128;
    L510:
        if (r3.getName().equals("com.obric.assistant.state.api.multitask.IVoiceCaptureStateProducerService") == false) goto L3605;
        T r129 = (T) new VoiceCaptureStateProducer();
        putStaticServiceImplCache("com.obric.assistant.state.api.multitask.IVoiceCaptureStateProducerService", r129);
        return r129;
    L514:
        if (r3.getName().equals("com.larus.feishu.office.im.api.FlowKeyboardConfigExtensionFactoryService") == false) goto L3605;
        T r130 = (T) new FlowKeyboardConfigExtensionFactoryServiceImpl();
        putStaticServiceImplCache("com.larus.feishu.office.im.api.FlowKeyboardConfigExtensionFactoryService", r130);
        return r130;
    L518:
        if (r3.getName().equals("com.larus.uaigc.service.ICreationAppletProfileProvider") == false) goto L3605;
        T r131 = (T) new CreationAppletProfileProviderImpl();
        putStaticServiceImplCache("com.larus.uaigc.service.ICreationAppletProfileProvider", r131);
        return r131;
    L522:
        if (r3.getName().equals("com.larus.avatar.api.IDigitalAvatarService") == false) goto L3605;
        T r132 = (T) new DigitalAvatarServiceImpl();
        putStaticServiceImplCache("com.larus.avatar.api.IDigitalAvatarService", r132);
        return r132;
    L526:
        if (r3.getName().equals("com.obric.assistant.spi.chat.IObricInteractionService") == false) goto L3605;
        T r133 = (T) new ObricInteractionImpl();
        putStaticServiceImplCache("com.obric.assistant.spi.chat.IObricInteractionService", r133);
        return r133;
    L530:
        if (r3.getName().equals("com.larus.uaigc.service.ICreationReportService") == false) goto L3605;
        T r134 = (T) new CreationReportServiceImpl();
        putStaticServiceImplCache("com.larus.uaigc.service.ICreationReportService", r134);
        return r134;
    L534:
        if (r3.getName().equals("com.obric.assistant.state.api.multitask.IObricTaskFlowActiveStateService") == false) goto L3605;
        T r135 = (T) new ObricTaskFlowActiveStateServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.state.api.multitask.IObricTaskFlowActiveStateService", r135);
        return r135;
    L538:
        if (r3.getName().equals("com.larus.audioplayer.api.news.IUrlAudioPlayerService") == false) goto L3605;
        T r136 = (T) new UrlAudioPlayerService();
        putStaticServiceImplCache("com.larus.audioplayer.api.news.IUrlAudioPlayerService", r136);
        return r136;
    L542:
        if (r3.getName().equals("com.larus.audio.realtimecall.IRealtimeCallStrategy") == false) goto L3605;
        T r137 = (T) new RealtimeCallStrategy();
        putStaticServiceImplCache("com.larus.audio.realtimecall.IRealtimeCallStrategy", r137);
        return r137;
    L546:
        if (r3.getName().equals("com.bytedance.timon_monitor_api.IMonitorBusinessService") == false) goto L3605;
        T r138 = (T) new MonitorBusinessServiceImpl();
        putStaticServiceImplCache("com.bytedance.timon_monitor_api.IMonitorBusinessService", r138);
        return r138;
    L550:
        if (r3.getName().equals("com.larus.caijing_pay.api.ICJPayService") == false) goto L3605;
        T r139 = (T) new CJPayServiceImpl();
        putStaticServiceImplCache("com.larus.caijing_pay.api.ICJPayService", r139);
        return r139;
    L554:
        if (r3.getName().equals("com.larus.bmhome.chat.api.IConversationFeedActionService") == false) goto L3605;
        T r140 = (T) new ConversationFeedActionServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.chat.api.IConversationFeedActionService", r140);
        return r140;
    L558:
        if (r3.getName().equals("com.larus.bmhome.bot.health.IChatBotHealthService") == false) goto L3605;
        T r141 = (T) new BotHealthServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.bot.health.IChatBotHealthService", r141);
        return r141;
    L562:
        if (r3.getName().equals("com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDLSPI") == false) goto L3605;
        T r142 = (T) new VoiceInteractionIDLStub();
        putStaticServiceImplCache("com.obric.aiagent.assistant.idl.IFlowVoiceInteractionIDLSPI", r142);
        return r142;
    L566:
        if (r3.getName().equals("com.larus.platform.IFlowSdkCommonDepend") == false) goto L3605;
        T r143 = (T) new FlowSdkCommonDependImpl();
        putStaticServiceImplCache("com.larus.platform.IFlowSdkCommonDepend", r143);
        return r143;
    L570:
        if (r3.getName().equals("com.larus.platform.api.ISdkTitleBarInflate") == false) goto L3605;
        T r144 = (T) new WindowSdkTitleBarInflateImpl();
        putStaticServiceImplCache("com.larus.platform.api.ISdkTitleBarInflate", r144);
        return r144;
    L574:
        if (r3.getName().equals("com.larus.bmhome.chat.model.repo.IConversationRepoService") == false) goto L3605;
        T r145 = (T) new ConversationRepo();
        putStaticServiceImplCache("com.larus.bmhome.chat.model.repo.IConversationRepoService", r145);
        return r145;
    L578:
        if (r3.getName().equals("com.larus.instruction.service.IInstructionService") == false) goto L3605;
        T r146 = (T) new InstructionServiceImpl();
        putStaticServiceImplCache("com.larus.instruction.service.IInstructionService", r146);
        return r146;
    L582:
        if (r3.getName().equals("com.larus.apm.api.IApmTrace") == false) goto L3605;
        T r147 = (T) new ApmTraceImpl();
        putStaticServiceImplCache("com.larus.apm.api.IApmTrace", r147);
        return r147;
    L586:
        if (r3.getName().equals("com.larus.business.floatchat.api.IAIFloatChatService") == false) goto L3605;
        T r148 = (T) new AIFloatChatServiceImpl();
        putStaticServiceImplCache("com.larus.business.floatchat.api.IAIFloatChatService", r148);
        return r148;
    L590:
        if (r3.getName().equals("com.larus.app.settings.api.IAppSettingsHostService") == false) goto L3605;
        T r149 = (T) new DoubaoAppSettingsHostService();
        putStaticServiceImplCache("com.larus.app.settings.api.IAppSettingsHostService", r149);
        return r149;
    L594:
        if (r3.getName().equals("com.larus.bmhome.chat.larkforward.IFlowLarkToDoubaoService") == false) goto L3605;
        T r150 = (T) new FlowLarkToDoubaoServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.chat.larkforward.IFlowLarkToDoubaoService", r150);
        return r150;
    L598:
        if (r3.getName().equals("com.larus.lbs.trace.api.ILbsTraceService") == false) goto L3605;
        T r151 = (T) new LbsTraceServiceImpl();
        putStaticServiceImplCache("com.larus.lbs.trace.api.ILbsTraceService", r151);
        return r151;
    L602:
        if (r3.getName().equals("com.larus.common.apphost.AppHost") == false) goto L3605;
        T r152 = (T) new AppHostImpl();
        putStaticServiceImplCache("com.larus.common.apphost.AppHost", r152);
        return r152;
    L606:
        if (r3.getName().equals("com.obric.audio.enroll.IEnrollService") == false) goto L3605;
        T r153 = (T) new EnrollServiceImpl();
        putStaticServiceImplCache("com.obric.audio.enroll.IEnrollService", r153);
        return r153;
    L610:
        if (r3.getName().equals("com.larus.larkfeed.IOfficeSocialBridge") == false) goto L3605;
        T r154 = (T) new OfficeSocialBridgeImpl();
        putStaticServiceImplCache("com.larus.larkfeed.IOfficeSocialBridge", r154);
        return r154;
    L614:
        if (r3.getName().equals("com.larus.apm.api.IApm") == false) goto L3605;
        T r155 = (T) new ApmImpl();
        putStaticServiceImplCache("com.larus.apm.api.IApm", r155);
        return r155;
    L618:
        if (r3.getName().equals("com.ivy.ivykit.api.plugin.IvyPluginService") == false) goto L3605;
        T r156 = (T) new IvyPluginServiceImpl();
        putStaticServiceImplCache("com.ivy.ivykit.api.plugin.IvyPluginService", r156);
        return r156;
    L622:
        if (r3.getName().equals("com.larus.uaigc.service.ICreationUploadPolicyService") == false) goto L3605;
        T r157 = (T) new CreationUploadPolicyServiceImpl();
        putStaticServiceImplCache("com.larus.uaigc.service.ICreationUploadPolicyService", r157);
        return r157;
    L626:
        if (r3.getName().equals("com.larus.setting.api.ISettingApi") == false) goto L3605;
        T r158 = (T) new SettingServiceImpl();
        putStaticServiceImplCache("com.larus.setting.api.ISettingApi", r158);
        return r158;
    L630:
        if (r3.getName().equals("com.obric.assistant.interaction.base.feedback.IVibratorSmtFeedback") == false) goto L3605;
        T r159 = (T) new VibratorSmtFeedbackImpl();
        putStaticServiceImplCache("com.obric.assistant.interaction.base.feedback.IVibratorSmtFeedback", r159);
        return r159;
    L634:
        if (r3.getName().equals("com.larus.bmhome.double_post.api.IAwemeDoublePostTrackService") == false) goto L3605;
        T r160 = (T) new AwemeDoublePostTrackServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.double_post.api.IAwemeDoublePostTrackService", r160);
        return r160;
    L638:
        if (r3.getName().equals("com.larus.platform.api.IFlowProfileThemeConfigProvider") == false) goto L3605;
        T r161 = (T) new FlowProfileThemeConfigProvider();
        putStaticServiceImplCache("com.larus.platform.api.IFlowProfileThemeConfigProvider", r161);
        return r161;
    L642:
        if (r3.getName().equals("com.obric.assistant.task.ITaskCenter") == false) goto L3605;
        T r162 = (T) new TaskManager();
        putStaticServiceImplCache("com.obric.assistant.task.ITaskCenter", r162);
        return r162;
    L646:
        if (r3.getName().equals("com.larus.bmhome.chat.quickreply.IMoaGrantingAppletService") == false) goto L3605;
        T r163 = (T) new MoaGrantingAppletServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.chat.quickreply.IMoaGrantingAppletService", r163);
        return r163;
    L650:
        if (r3.getName().equals("com.obric.assistant.security.provision.check.api.ISecurityProvisionChecker") == false) goto L3605;
        T r164 = (T) new SecurityProvisionCheckerImpl();
        putStaticServiceImplCache("com.obric.assistant.security.provision.check.api.ISecurityProvisionChecker", r164);
        return r164;
    L654:
        if (r3.getName().equals("com.bytedance.timon.foundation.interfaces.IStore") == false) goto L3605;
        T r165 = (T) new KevaStoreImpl();
        putStaticServiceImplCache("com.bytedance.timon.foundation.interfaces.IStore", r165);
        return r165;
    L658:
        if (r3.getName().equals("com.obric.aiagent.assistant.idl.IFlowMessageIDLSPI") == false) goto L3605;
        T r166 = (T) new MessageIDLStub();
        putStaticServiceImplCache("com.obric.aiagent.assistant.idl.IFlowMessageIDLSPI", r166);
        return r166;
    L662:
        if (r3.getName().equals("com.bytedance.upc.common.device.IDeviceInfoService") == false) goto L3605;
        T r167 = (T) new DeviceInfoService();
        putStaticServiceImplCache("com.bytedance.upc.common.device.IDeviceInfoService", r167);
        return r167;
    L666:
        if (r3.getName().equals("com.larus.bmhome.chat.standarduikit.IStandardUiKitService") == false) goto L3605;
        T r168 = (T) new StandardUiKitServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.chat.standarduikit.IStandardUiKitService", r168);
        return r168;
    L670:
        if (r3.getName().equals("com.larus.bootprotector.IBootProtectorDebugService") == false) goto L3605;
        T r169 = (T) new BootProtectorDebugServiceImpl();
        putStaticServiceImplCache("com.larus.bootprotector.IBootProtectorDebugService", r169);
        return r169;
    L674:
        if (r3.getName().equals("com.larus.disk.api.IAppDiskDebugService") == false) goto L3605;
        T r170 = (T) new IAppDiskServiceImpl();
        putStaticServiceImplCache("com.larus.disk.api.IAppDiskDebugService", r170);
        return r170;
    L678:
        if (r3.getName().equals("com.larus.platform.api.IFlowThemeConfigProvider") == false) goto L3605;
        T r171 = (T) new FlowThemeConfigProvider();
        putStaticServiceImplCache("com.larus.platform.api.IFlowThemeConfigProvider", r171);
        return r171;
    L682:
        if (r3.getName().equals("com.obric.assistant.spi.account.IObricAccountSPIService") == false) goto L3605;
        T r172 = (T) new ObricAccountServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.spi.account.IObricAccountSPIService", r172);
        return r172;
    L686:
        if (r3.getName().equals("com.larus.bmhome.dora.IDoraEService") == false) goto L3605;
        T r173 = (T) new DoraEServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.dora.IDoraEService", r173);
        return r173;
    L690:
        if (r3.getName().equals("com.obric.assistant.common.spi.interaction.IObricMessagePopupService") == false) goto L3605;
        T r174 = (T) new ObricMessagePopupServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.common.spi.interaction.IObricMessagePopupService", r174);
        return r174;
    L694:
        if (r3.getName().equals("com.larus.chat.search.api.ISdkSearchService") == false) goto L3605;
        T r175 = (T) new NewSearchServiceImpl();
        putStaticServiceImplCache("com.larus.chat.search.api.ISdkSearchService", r175);
        return r175;
    L698:
        if (r3.getName().equals("com.obric.assistant.automic.IObricAutoMicService") == false) goto L3605;
        T r176 = (T) new ObricAutoMicServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.automic.IObricAutoMicService", r176);
        return r176;
    L702:
        if (r3.getName().equals("com.obric.assistant.state.multitask.core.TaskFlowAsyncObserver") == false) goto L3605;
        T r177 = (T) new ModeTimeoutCleanupObserver();
        putStaticServiceImplCache("com.obric.assistant.state.multitask.core.TaskFlowAsyncObserver", r177);
        return r177;
    L706:
        if (r3.getName().equals("com.larus.bmhome.larkinput.api.service.ILarkInputService") == false) goto L3605;
        T r178 = (T) new LarkInputServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.larkinput.api.service.ILarkInputService", r178);
        return r178;
    L710:
        if (r3.getName().equals("com.larus.sheet.sdk.api.ISheetSdkServiceV2") == false) goto L3605;
        T r179 = (T) new SheetSdkServiceImplV2();
        putStaticServiceImplCache("com.larus.sheet.sdk.api.ISheetSdkServiceV2", r179);
        return r179;
    L714:
        if (r3.getName().equals("com.larus.receive.contract.IReceiveTextDiff") == false) goto L3605;
        T r180 = (T) new ObricReceiveTextDiffImpl();
        putStaticServiceImplCache("com.larus.receive.contract.IReceiveTextDiff", r180);
        return r180;
    L718:
        if (r3.getName().equals("com.larus.feishu.office.im.api.FlowInputMenuStateService") == false) goto L3605;
        T r181 = (T) new FlowInputMenuStateServiceImpl();
        putStaticServiceImplCache("com.larus.feishu.office.im.api.FlowInputMenuStateService", r181);
        return r181;
    L722:
        if (r3.getName().equals("com.larus.platform.api.IImageUploadPreheatService") == false) goto L3605;
        T r182 = (T) new ImageUploadPreheatServiceImpl();
        putStaticServiceImplCache("com.larus.platform.api.IImageUploadPreheatService", r182);
        return r182;
    L726:
        if (r3.getName().equals("com.larus.navigation.api.NavigationService") == false) goto L3605;
        T r183 = (T) new NavigationDispatcher();
        putStaticServiceImplCache("com.larus.navigation.api.NavigationService", r183);
        return r183;
    L730:
        if (r3.getName().equals("com.larus.bmhome.instruction.suggest.IPromptSelectActionDispatcherService") == false) goto L3605;
        T r184 = (T) new PromptSelectActionDispatcherServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.instruction.suggest.IPromptSelectActionDispatcherService", r184);
        return r184;
    L734:
        if (r3.getName().equals("com.obric.assistant.session.model.ILostModeOperation") == false) goto L3605;
        T r185 = (T) new LostModeEndpoint();
        putStaticServiceImplCache("com.obric.assistant.session.model.ILostModeOperation", r185);
        return r185;
    L738:
        if (r3.getName().equals("com.larus.community.api.spi.ICommunityFeedRequestSourceFactory") == false) goto L3605;
        T r186 = (T) new AICreationCommunityFeedRequestSourceFactory();
        putStaticServiceImplCache("com.larus.community.api.spi.ICommunityFeedRequestSourceFactory", r186);
        return r186;
    L742:
        if (r3.getName().equals("com.larus.drive.sdk.api.IDriveSdkServiceV2") == false) goto L3605;
        T r187 = (T) new DriveSdkServiceImplV2();
        putStaticServiceImplCache("com.larus.drive.sdk.api.IDriveSdkServiceV2", r187);
        return r187;
    L746:
        if (r3.getName().equals("com.larus.utils.logger.ILogger") == false) goto L3605;
        T r188 = (T) new LoggerImpl();
        putStaticServiceImplCache("com.larus.utils.logger.ILogger", r188);
        return r188;
    L750:
        if (r3.getName().equals("com.obric.assistant.oauto.IOAutoApi") == false) goto L3605;
        T r189 = (T) new OAutoImpl();
        putStaticServiceImplCache("com.obric.assistant.oauto.IOAutoApi", r189);
        return r189;
    L754:
        if (r3.getName().equals("com.bytedance.android.shopping.api.mall.mallSession.DeliveryEventApi") == false) goto L3605;
        T r190 = (T) new DeliveryEventServiceImpl();
        putStaticServiceImplCache("com.bytedance.android.shopping.api.mall.mallSession.DeliveryEventApi", r190);
        return r190;
    L758:
        if (r3.getName().equals("com.bytedance.bmf_mods_api.ColorHistAPI") == false) goto L3605;
        return (T) new ColorHist();
    L762:
        if (r3.getName().equals("com.larus.bmhome.chat.api.IMultimodalTraceService") == false) goto L3605;
        T r191 = (T) new MultimodalTraceService();
        putStaticServiceImplCache("com.larus.bmhome.chat.api.IMultimodalTraceService", r191);
        return r191;
    L766:
        if (r3.getName().equals("com.larus.feishu.office.im.api.FlowAdapterExtensionFactoryService") == false) goto L3605;
        T r192 = (T) new FlowAdapterExtensionFactoryServiceImpl();
        putStaticServiceImplCache("com.larus.feishu.office.im.api.FlowAdapterExtensionFactoryService", r192);
        return r192;
    L770:
        if (r3.getName().equals("com.larus.uaigc.service.ICreationMetadataService") == false) goto L3605;
        T r193 = (T) new CreationMetadataServiceImpl();
        putStaticServiceImplCache("com.larus.uaigc.service.ICreationMetadataService", r193);
        return r193;
    L774:
        if (r3.getName().equals("com.larus.bmhome.taskskill.service.TaskModeService") == false) goto L3605;
        T r194 = (T) new TaskModeServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.taskskill.service.TaskModeService", r194);
        return r194;
    L778:
        if (r3.getName().equals("com.larus.platform.spi.IAIChatTtsPlayTraceService") == false) goto L3605;
        T r195 = (T) new AIChatTTSPlayTraceImpl();
        putStaticServiceImplCache("com.larus.platform.spi.IAIChatTtsPlayTraceService", r195);
        return r195;
    L782:
        if (r3.getName().equals("com.bytedance.ai.api.AppletService") == false) goto L3605;
        T r196 = (T) new MainlandAppletServiceImpl();
        putStaticServiceImplCache("com.bytedance.ai.api.AppletService", r196);
        return r196;
    L786:
        if (r3.getName().equals("com.larus.platform.api.creation.IBachService") == false) goto L3605;
        T r197 = (T) new BachServiceImpl();
        putStaticServiceImplCache("com.larus.platform.api.creation.IBachService", r197);
        return r197;
    L790:
        if (r3.getName().equals("com.obric.assistant.audio.sessionstate.IAutoHalfDuplexModeService") == false) goto L3605;
        T r198 = (T) new AutoHalfDuplexModeService();
        putStaticServiceImplCache("com.obric.assistant.audio.sessionstate.IAutoHalfDuplexModeService", r198);
        return r198;
    L794:
        if (r3.getName().equals("com.obric.assistant.state.api.multitask.IObricStateMultitaskService") == false) goto L3605;
        T r199 = (T) new ObricStateMultitaskServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.state.api.multitask.IObricStateMultitaskService", r199);
        return r199;
    L798:
        if (r3.getName().equals("com.larus.platform.spi.IAIChatControlTraceService") == false) goto L3605;
        T r200 = (T) new AIChatControlTraceServiceImpl();
        putStaticServiceImplCache("com.larus.platform.spi.IAIChatControlTraceService", r200);
        return r200;
    L802:
        if (r3.getName().equals("com.obric.assistant.spi.bootprotector.IObricBootProtectorSPIService") == false) goto L3605;
        T r201 = (T) new ObricBootProtectorServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.spi.bootprotector.IObricBootProtectorSPIService", r201);
        return r201;
    L806:
        if (r3.getName().equals("com.larus.bmhome.chat.api.ILegacyChatUiService") == false) goto L3605;
        T r202 = (T) new LegacyChatServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.chat.api.ILegacyChatUiService", r202);
        return r202;
    L810:
        if (r3.getName().equals("com.obric.assistant.chat.IObricChatPageStateService") == false) goto L3605;
        T r203 = (T) new ObricChatPageStateServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.chat.IObricChatPageStateService", r203);
        return r203;
    L814:
        if (r3.getName().equals("com.larus.home.api.main.IAICreationSidebarLauncher") == false) goto L3605;
        T r204 = (T) new AICreationSidebarLauncher();
        putStaticServiceImplCache("com.larus.home.api.main.IAICreationSidebarLauncher", r204);
        return r204;
    L818:
        if (r3.getName().equals("com.larus.mirabridge.api.plugin.service.IPrePluginService") == false) goto L3605;
        T r205 = (T) new PrePluginServiceImpl();
        putStaticServiceImplCache("com.larus.mirabridge.api.plugin.service.IPrePluginService", r205);
        return r205;
    L822:
        if (r3.getName().equals("com.obric.capabilitykit.common.intent.IntentFunction") == false) goto L3605;
        T r206 = (T) new BaseAppFuncExecuteIntent();
        putStaticServiceImplCache("com.obric.capabilitykit.common.intent.IntentFunction", r206);
        return r206;
    L826:
        if (r3.getName().equals("com.larus.bmhome.chat.actionbar.IActionBarService") == false) goto L3605;
        T r207 = (T) new ActionBarServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.chat.actionbar.IActionBarService", r207);
        return r207;
    L830:
        if (r3.getName().equals("com.larus.apm.api.IApmConfigs") == false) goto L3605;
        T r208 = (T) new ApmConfigs();
        putStaticServiceImplCache("com.larus.apm.api.IApmConfigs", r208);
        return r208;
    L834:
        if (r3.getName().equals("com.larus.bmhome.auth.ILaunchCacheService") == false) goto L3605;
        T r209 = (T) new LaunchCacheImpl();
        putStaticServiceImplCache("com.larus.bmhome.auth.ILaunchCacheService", r209);
        return r209;
    L838:
        if (r3.getName().equals("com.larus.bmhome.chat.thinkmode.IThinkModeMemoryReportService") == false) goto L3605;
        T r210 = (T) new ThinkModeMemoryReportServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.chat.thinkmode.IThinkModeMemoryReportService", r210);
        return r210;
    L842:
        if (r3.getName().equals("com.larus.audio.audiov3.connection.ISamiConnectionPool") == false) goto L3605;
        T r211 = (T) new SamiConnectionPoolImpl();
        putStaticServiceImplCache("com.larus.audio.audiov3.connection.ISamiConnectionPool", r211);
        return r211;
    L846:
        if (r3.getName().equals("com.obric.assistant.onelogin.IObricOneLogin") == false) goto L3605;
        T r212 = (T) new ObricOneLoginImpl();
        putStaticServiceImplCache("com.obric.assistant.onelogin.IObricOneLogin", r212);
        return r212;
    L850:
        if (r3.getName().equals("com.bytedance.bmf_mods_api.NoiseDetectAPI") == false) goto L3605;
        T r213 = (T) new NoiseDetect();
        putStaticServiceImplCache("com.bytedance.bmf_mods_api.NoiseDetectAPI", r213);
        return r213;
    L854:
        if (r3.getName().equals("com.larus.voicecall.obric.IObricRealtimeCallService") == false) goto L3605;
        T r214 = (T) new ObricRealtimeCallServiceImpl();
        putStaticServiceImplCache("com.larus.voicecall.obric.IObricRealtimeCallService", r214);
        return r214;
    L858:
        if (r3.getName().equals("com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService") == false) goto L3605;
        T r215 = (T) new IvyAIPackageResourceServiceImpl();
        putStaticServiceImplCache("com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService", r215);
        return r215;
    L862:
        if (r3.getName().equals("com.larus.reach.api.IReachDebugService") == false) goto L3605;
        T r216 = (T) new ReachDebugServiceImpl();
        putStaticServiceImplCache("com.larus.reach.api.IReachDebugService", r216);
        return r216;
    L866:
        if (r3.getName().equals("com.larus.doc.sdk.api.IDocPermissionService") == false) goto L3605;
        T r217 = (T) new DocPermissionServiceImpl();
        putStaticServiceImplCache("com.larus.doc.sdk.api.IDocPermissionService", r217);
        return r217;
    L870:
        if (r3.getName().equals("com.bytedance.timon.upc.upc_adapter_api.IUpcBusinessService") == false) goto L3605;
        T r218 = (T) new UpcBusinessServiceImpl();
        putStaticServiceImplCache("com.bytedance.timon.upc.upc_adapter_api.IUpcBusinessService", r218);
        return r218;
    L874:
        if (r3.getName().equals("com.larus.dora.o.api.IDoraODiaryService") == false) goto L3605;
        T r219 = (T) new DoraODiaryServiceImpl();
        putStaticServiceImplCache("com.larus.dora.o.api.IDoraODiaryService", r219);
        return r219;
    L878:
        if (r3.getName().equals("com.larus.bmhome.input.api.officemention.IOfficeMentionService") == false) goto L3605;
        T r220 = (T) new OfficeMentionServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.input.api.officemention.IOfficeMentionService", r220);
        return r220;
    L882:
        if (r3.getName().equals("com.larus.setting.api.IOrderMessageNotifySettingsProvider") == false) goto L3605;
        T r221 = (T) new OrderMessageNotifySettingsProviderImpl();
        putStaticServiceImplCache("com.larus.setting.api.IOrderMessageNotifySettingsProvider", r221);
        return r221;
    L886:
        if (r3.getName().equals("com.larus.account.base.provider.IThirdPartyPlatformLoginProvider") == false) goto L3605;
        T r222 = (T) new DouyinLogin();
        putStaticServiceImplCache("com.larus.account.base.provider.IThirdPartyPlatformLoginProvider", r222);
        return r222;
    L890:
        if (r3.getName().equals("com.obric.assistant.actionbar.service.IObricActionBarSendServiceExt") == false) goto L3605;
        T r223 = (T) new ObricActionBarSendServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.actionbar.service.IObricActionBarSendServiceExt", r223);
        return r223;
    L894:
        if (r3.getName().equals("com.larus.caijing_pay.api.ICJPayInitiator") == false) goto L3605;
        T r224 = (T) new CJPayInitiator();
        putStaticServiceImplCache("com.larus.caijing_pay.api.ICJPayInitiator", r224);
        return r224;
    L898:
        if (r3.getName().equals("com.larus.platform.api.IOfficeUrlPreviewHostService") == false) goto L3605;
        T r225 = (T) new FlowOfficeUrlPreviewHostService();
        putStaticServiceImplCache("com.larus.platform.api.IOfficeUrlPreviewHostService", r225);
        return r225;
    L902:
        if (r3.getName().equals("com.obric.assistant.spi.dora.IObricVendorPrivateLinkService") == false) goto L3605;
        T r226 = (T) new VendorPrivateLinkServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.spi.dora.IObricVendorPrivateLinkService", r226);
        return r226;
    L906:
        if (r3.getName().equals("com.larus.bmhome.utils.ILandingRedBadgeHelper") == false) goto L3605;
        T r227 = (T) new LandingRedBadgeHelper();
        putStaticServiceImplCache("com.larus.bmhome.utils.ILandingRedBadgeHelper", r227);
        return r227;
    L910:
        if (r3.getName().equals("com.obric.assistant.utils.IObricShowArgService") == false) goto L3605;
        T r228 = (T) new ObricShowArgServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.utils.IObricShowArgService", r228);
        return r228;
    L914:
        if (r3.getName().equals("com.obric.assistant.interaction.api.IObricChatUILifecycleMonitor") == false) goto L3605;
        T r229 = (T) new ObricChatUILifecycleMonitorImpl();
        putStaticServiceImplCache("com.obric.assistant.interaction.api.IObricChatUILifecycleMonitor", r229);
        return r229;
    L918:
        if (r3.getName().equals("com.larus.platform.api.IFlowAccountThemeConfigProvider") == false) goto L3605;
        T r230 = (T) new FlowAccountThemeConfigProvider();
        putStaticServiceImplCache("com.larus.platform.api.IFlowAccountThemeConfigProvider", r230);
        return r230;
    L922:
        if (r3.getName().equals("com.enroll.audio.enroll.IVoiceEnrollService") == false) goto L3605;
        T r231 = (T) new VoiceEnrollServiceImpl();
        putStaticServiceImplCache("com.enroll.audio.enroll.IVoiceEnrollService", r231);
        return r231;
    L926:
        if (r3.getName().equals("com.obric.assistant.product.api.IObricProduct") == false) goto L3605;
        T r232 = (T) new ObricProductImpl();
        putStaticServiceImplCache("com.obric.assistant.product.api.IObricProduct", r232);
        return r232;
    L930:
        if (r3.getName().equals("com.obric.assistant.spi.launch.IObricLazyInitSettingsService") == false) goto L3605;
        T r233 = (T) new ObricLazyInitSettingsServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.spi.launch.IObricLazyInitSettingsService", r233);
        return r233;
    L934:
        if (r3.getName().equals("com.larus.bmhome.chat.larkforward.IChatLarkForwardService") == false) goto L3605;
        T r234 = (T) new ChatLarkForwardService();
        putStaticServiceImplCache("com.larus.bmhome.chat.larkforward.IChatLarkForwardService", r234);
        return r234;
    L938:
        if (r3.getName().equals("com.larus.uaigc.service.IZLotteryService") == false) goto L3605;
        T r235 = (T) new ZLotteryServiceImpl();
        putStaticServiceImplCache("com.larus.uaigc.service.IZLotteryService", r235);
        return r235;
    L942:
        if (r3.getName().equals("com.larus.business.debug.api.ILiveTutorDebugService") == false) goto L3605;
        T r236 = (T) new LiveTutorDebugServiceImpl();
        putStaticServiceImplCache("com.larus.business.debug.api.ILiveTutorDebugService", r236);
        return r236;
    L946:
        if (r3.getName().equals("com.larus.deeplink.api.IDeeplinkService") == false) goto L3605;
        T r237 = (T) new DeeplinkServiceImpl();
        putStaticServiceImplCache("com.larus.deeplink.api.IDeeplinkService", r237);
        return r237;
    L950:
        if (r3.getName().equals("com.larus.platform.spi.IAIChatMessageConcatDelegate") == false) goto L3605;
        T r238 = (T) new CreationMessageConcatDelegate();
        putStaticServiceImplCache("com.larus.platform.spi.IAIChatMessageConcatDelegate", r238);
        return r238;
    L954:
        if (r3.getName().equals("com.obric.assistant.upload.IObricUploadService") == false) goto L3605;
        T r239 = (T) new ObricUploadService();
        putStaticServiceImplCache("com.obric.assistant.upload.IObricUploadService", r239);
        return r239;
    L958:
        if (r3.getName().equals("com.larus.account.saas.ui.IAccountLoadingUiService") == false) goto L3605;
        T r240 = (T) new DefaultAccountLoadingUiService();
        putStaticServiceImplCache("com.larus.account.saas.ui.IAccountLoadingUiService", r240);
        return r240;
    L962:
        if (r3.getName().equals("com.bytedance.ai.api.AppletHealthService") == false) goto L3605;
        T r241 = (T) new AppletHealthServiceImpl();
        putStaticServiceImplCache("com.bytedance.ai.api.AppletHealthService", r241);
        return r241;
    L966:
        if (r3.getName().equals("com.larus.blockkit.IBlockKitExperimentProvider") == false) goto L3605;
        T r242 = (T) new MainBotBlockKitExperimentProvider();
        putStaticServiceImplCache("com.larus.blockkit.IBlockKitExperimentProvider", r242);
        return r242;
    L970:
        if (r3.getName().equals("com.larus.dora.api.offline.record.IDoraOfflineRecordSyncService") == false) goto L3605;
        T r243 = (T) new DoraOfflineRecordSyncServiceImpl();
        putStaticServiceImplCache("com.larus.dora.api.offline.record.IDoraOfflineRecordSyncService", r243);
        return r243;
    L974:
        if (r3.getName().equals("com.larus.hotpatch.IHotPatch") == false) goto L3605;
        T r244 = (T) new ReparoHotPatchImpl();
        putStaticServiceImplCache("com.larus.hotpatch.IHotPatch", r244);
        return r244;
    L978:
        if (r3.getName().equals("com.bytedance.flow_audio.api.service.common.IKMPAppInfoProvider") == false) goto L3605;
        T r245 = (T) new FlowAudioKmpAppInfoProvider();
        putStaticServiceImplCache("com.bytedance.flow_audio.api.service.common.IKMPAppInfoProvider", r245);
        return r245;
    L982:
        if (r3.getName().equals("com.larus.mirabridge.api.plugin.service.IPluginService") == false) goto L3605;
        T r246 = (T) new PluginServiceImpl();
        putStaticServiceImplCache("com.larus.mirabridge.api.plugin.service.IPluginService", r246);
        return r246;
    L986:
        if (r3.getName().equals("com.larus.account.saas.security.api.IAccountRiskDialogUiService") == false) goto L3605;
        T r247 = (T) new DefaultAccountRiskDialogUiService();
        putStaticServiceImplCache("com.larus.account.saas.security.api.IAccountRiskDialogUiService", r247);
        return r247;
    L990:
        if (r3.getName().equals("com.larus.audio.IFlowAsrClientService") == false) goto L3605;
        T r248 = (T) new FlowAsrClientImpl();
        putStaticServiceImplCache("com.larus.audio.IFlowAsrClientService", r248);
        return r248;
    L994:
        if (r3.getName().equals("com.larus.doc.api.IDocService") == false) goto L3605;
        T r249 = (T) new DocServiceImpl();
        putStaticServiceImplCache("com.larus.doc.api.IDocService", r249);
        return r249;
    L998:
        if (r3.getName().equals("com.bytedance.android.ec.hybrid.service.IMallDeepFeedAnimationService") == false) goto L3605;
        T r250 = (T) new MallDeepFeedAnimationServiceImpl();
        putStaticServiceImplCache("com.bytedance.android.ec.hybrid.service.IMallDeepFeedAnimationService", r250);
        return r250;
    L1002:
        if (r3.getName().equals("com.larus.account.saas.coreapi.IAccountQrCodeService") == false) goto L3605;
        T r251 = (T) new AccountQrCodeService();
        putStaticServiceImplCache("com.larus.account.saas.coreapi.IAccountQrCodeService", r251);
        return r251;
    L1006:
        if (r3.getName().equals("com.larus.account.base.api.IDouyinHeartBeatService") == false) goto L3605;
        T r252 = (T) new DouyinHeartBeatServiceImpl();
        putStaticServiceImplCache("com.larus.account.base.api.IDouyinHeartBeatService", r252);
        return r252;
    L1010:
        if (r3.getName().equals("com.obric.assistant.audio.service.IObricAssistantBaseService") == false) goto L3605;
        T r253 = (T) new ObricAssistantBaseServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.audio.service.IObricAssistantBaseService", r253);
        return r253;
    L1014:
        if (r3.getName().equals("com.larus.bmhome.chat.api.ICrossPlatformMarkdownService") == false) goto L3605;
        T r254 = (T) new CrossPlatformMarkdownServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.chat.api.ICrossPlatformMarkdownService", r254);
        return r254;
    L1018:
        if (r3.getName().equals("com.larus.bmhome.input.api.IEnterKeyBehaviorService") == false) goto L3605;
        T r255 = (T) new EnterKeyBehaviorServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.input.api.IEnterKeyBehaviorService", r255);
        return r255;
    L1022:
        if (r3.getName().equals("com.obric.assistant.spi.zeus.IObricZeusService") == false) goto L3605;
        T r256 = (T) new ObricZeusServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.spi.zeus.IObricZeusService", r256);
        return r256;
    L1026:
        if (r3.getName().equals("com.obric.assistant.agent.IObricSemanticApi") == false) goto L3605;
        T r257 = (T) new ObricSemanticServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.agent.IObricSemanticApi", r257);
        return r257;
    L1030:
        if (r3.getName().equals("com.obric.assistant.common.spi.alog.IObricAlogService") == false) goto L3605;
        T r258 = (T) new ZeusObricAlogServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.common.spi.alog.IObricAlogService", r258);
        return r258;
    L1034:
        if (r3.getName().equals("com.larus.office.base.service.IOfficeWatermarkSdkService") == false) goto L3605;
        T r259 = (T) new OfficeWatermarkSdkService();
        putStaticServiceImplCache("com.larus.office.base.service.IOfficeWatermarkSdkService", r259);
        return r259;
    L1038:
        if (r3.getName().equals("com.larus.home.api.main.IHomeApiV2") == false) goto L3605;
        T r260 = (T) new HomeServiceV2Impl();
        putStaticServiceImplCache("com.larus.home.api.main.IHomeApiV2", r260);
        return r260;
    L1042:
        if (r3.getName().equals("com.larus.vesdk.api.IVeSDK") == false) goto L3605;
        T r261 = (T) new VeSDKImpl();
        putStaticServiceImplCache("com.larus.vesdk.api.IVeSDK", r261);
        return r261;
    L1046:
        if (r3.getName().equals("com.obric.assistant.processesmanager.IObricProcessesManager") == false) goto L3605;
        T r262 = (T) new ObricProcessesManagerImpl();
        putStaticServiceImplCache("com.obric.assistant.processesmanager.IObricProcessesManager", r262);
        return r262;
    L1050:
        if (r3.getName().equals("com.larus.bmhome.debug.IChatDebugExtItem") == false) goto L3605;
        T r263 = (T) new ObricChatDebugExtItemImpl();
        putStaticServiceImplCache("com.larus.bmhome.debug.IChatDebugExtItem", r263);
        return r263;
    L1054:
        if (r3.getName().equals("com.obric.assistant.spi.home.IObricBottomTabSPIService") == false) goto L3605;
        T r264 = (T) new ObricBottomTabServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.spi.home.IObricBottomTabSPIService", r264);
        return r264;
    L1058:
        if (r3.getName().equals("com.obric.assistant.spi.office.IOfficeSdkLazyInitService") == false) goto L3605;
        T r265 = (T) new OfficeSdkLazyInitServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.spi.office.IOfficeSdkLazyInitService", r265);
        return r265;
    L1062:
        if (r3.getName().equals("com.larus.platform.api.IFlowDriveSdkService") == false) goto L3605;
        T r266 = (T) new FlowDriveSdkServiceImpl();
        putStaticServiceImplCache("com.larus.platform.api.IFlowDriveSdkService", r266);
        return r266;
    L1066:
        if (r3.getName().equals("com.larus.aweme.api.video.service.IVideoFragmentProvider") == false) goto L3605;
        T r267 = (T) new VideoFragmentProviderImpl();
        putStaticServiceImplCache("com.larus.aweme.api.video.service.IVideoFragmentProvider", r267);
        return r267;
    L1070:
        if (r3.getName().equals("com.larus.voicecall.api.IVoiceCallConfigService") == false) goto L3605;
        T r268 = (T) new IVoiceCallConfigServiceImpl();
        putStaticServiceImplCache("com.larus.voicecall.api.IVoiceCallConfigService", r268);
        return r268;
    L1074:
        if (r3.getName().equals("com.larus.bmhome.chat.model.repo.IBotRepoService") == false) goto L3605;
        T r269 = (T) new BotRepo();
        putStaticServiceImplCache("com.larus.bmhome.chat.model.repo.IBotRepoService", r269);
        return r269;
    L1078:
        if (r3.getName().equals("com.larus.voicecall.api.IRealtimeDebugService") == false) goto L3605;
        T r270 = (T) new RealtimeDebugServiceImpl();
        putStaticServiceImplCache("com.larus.voicecall.api.IRealtimeDebugService", r270);
        return r270;
    L1082:
        if (r3.getName().equals("com.larus.bmhome.IChatAzerothService") == false) goto L3605;
        T r271 = (T) new ChatAzerothServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.IChatAzerothService", r271);
        return r271;
    L1086:
        if (r3.getName().equals("com.obric.assistant.spi.rtc.IObricRTCCameraConfigService") == false) goto L3605;
        T r272 = (T) new ObricRTCCameraConfigService();
        putStaticServiceImplCache("com.obric.assistant.spi.rtc.IObricRTCCameraConfigService", r272);
        return r272;
    L1090:
        if (r3.getName().equals("com.obric.assistant.login.ILoginReport") == false) goto L3605;
        T r273 = (T) new LoginReportImpl();
        putStaticServiceImplCache("com.obric.assistant.login.ILoginReport", r273);
        return r273;
    L1094:
        if (r3.getName().equals("com.obric.assistant.interaction.api.ISystemKeySettings") == false) goto L3605;
        T r274 = (T) new SystemKeySettingsImpl();
        putStaticServiceImplCache("com.obric.assistant.interaction.api.ISystemKeySettings", r274);
        return r274;
    L1098:
        if (r3.getName().equals("com.bytedance.timonbase.ITMLifecycleService") == false) goto L3605;
        T r275 = (T) new MonitorLifecycleServiceImpl();
        putStaticServiceImplCache("com.bytedance.timonbase.ITMLifecycleService", r275);
        return r275;
    L1102:
        if (r3.getName().equals("com.larus.audio.IFlowTtsClientService") == false) goto L3605;
        T r276 = (T) new FlowTtsClientImpl();
        putStaticServiceImplCache("com.larus.audio.IFlowTtsClientService", r276);
        return r276;
    L1106:
        if (r3.getName().equals("com.larus.account.saas.coreapi.ISecShareDataService") == false) goto L3605;
        T r277 = (T) new SecShareDataService();
        putStaticServiceImplCache("com.larus.account.saas.coreapi.ISecShareDataService", r277);
        return r277;
    L1110:
        if (r3.getName().equals("com.larus.canvas.service.ICanvasService") == false) goto L3605;
        T r278 = (T) new CanvasServiceImpl();
        putStaticServiceImplCache("com.larus.canvas.service.ICanvasService", r278);
        return r278;
    L1114:
        if (r3.getName().equals("com.obric.assistant.session.model.IAiKeyOperation") == false) goto L3605;
        T r279 = (T) new AiKeySessionEndpoint();
        putStaticServiceImplCache("com.obric.assistant.session.model.IAiKeyOperation", r279);
        return r279;
    L1118:
        if (r3.getName().equals("com.larus.feishu.office.im.api.FlowPlusExtensionFactoryService") == false) goto L3605;
        T r280 = (T) new FlowPlusExtensionFactoryServiceImpl();
        putStaticServiceImplCache("com.larus.feishu.office.im.api.FlowPlusExtensionFactoryService", r280);
        return r280;
    L1122:
        if (r3.getName().equals("com.obric.assistant.reporter.IObricSystemReporter") == false) goto L3605;
        T r281 = (T) new ObricSystemReporterImpl();
        putStaticServiceImplCache("com.obric.assistant.reporter.IObricSystemReporter", r281);
        return r281;
    L1126:
        if (r3.getName().equals("com.obric.assistant.obric_action.IObricActionHandler") == false) goto L3605;
        T r282 = (T) new OpenClarifyInputPanelHandler();
        putStaticServiceImplCache("com.obric.assistant.obric_action.IObricActionHandler", r282);
        return r282;
    L1130:
        if (r3.getName().equals("com.larus.bmhome.chat.feedback.IChatFeedbackService") == false) goto L3605;
        T r283 = (T) new ChatFeedbackServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.chat.feedback.IChatFeedbackService", r283);
        return r283;
    L1134:
        if (r3.getName().equals("com.bytedance.ai.api.AppletV2Service") == false) goto L3605;
        T r284 = (T) new AppletV2ServiceImpl();
        putStaticServiceImplCache("com.bytedance.ai.api.AppletV2Service", r284);
        return r284;
    L1138:
        if (r3.getName().equals("com.larus.share.service.IShareService") == false) goto L3605;
        T r285 = (T) new ShareServiceImpl();
        putStaticServiceImplCache("com.larus.share.service.IShareService", r285);
        return r285;
    L1142:
        if (r3.getName().equals("com.larus.luckydog.api.ILuckyDogService") == false) goto L3605;
        T r286 = (T) new LuckyDogServiceImpl();
        putStaticServiceImplCache("com.larus.luckydog.api.ILuckyDogService", r286);
        return r286;
    L1146:
        if (r3.getName().equals("com.larus.commercemembership.api.ICommerceMembershipService") == false) goto L3605;
        T r287 = (T) new CommerceMembershipService();
        putStaticServiceImplCache("com.larus.commercemembership.api.ICommerceMembershipService", r287);
        return r287;
    L1150:
        if (r3.getName().equals("com.larus.slides.sdk.api.ISlidesSdkProxyService") == false) goto L3605;
        T r288 = (T) new SlidesSdkProxyServiceImpl();
        putStaticServiceImplCache("com.larus.slides.sdk.api.ISlidesSdkProxyService", r288);
        return r288;
    L1154:
        if (r3.getName().equals("com.larus.feishu.office.im.api.FlowAttachmentExtensionFactoryService") == false) goto L3605;
        T r289 = (T) new FlowAttachmentExtensionFactoryServiceImpl();
        putStaticServiceImplCache("com.larus.feishu.office.im.api.FlowAttachmentExtensionFactoryService", r289);
        return r289;
    L1158:
        if (r3.getName().equals("com.larus.jato.api.IJato") == false) goto L3605;
        T r290 = (T) new JatoImpl();
        putStaticServiceImplCache("com.larus.jato.api.IJato", r290);
        return r290;
    L1162:
        if (r3.getName().equals("com.obric.assistant.spi.common.IObricUtilService") == false) goto L3605;
        T r291 = (T) new ObricUtilServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.spi.common.IObricUtilService", r291);
        return r291;
    L1166:
        if (r3.getName().equals("com.bytedance.flow_audio.api.service.common.IKMPFlowAudioSceneService") == false) goto L3605;
        T r292 = (T) new KMPFlowAudioSceneServiceImpl();
        putStaticServiceImplCache("com.bytedance.flow_audio.api.service.common.IKMPFlowAudioSceneService", r292);
        return r292;
    L1170:
        if (r3.getName().equals("com.obric.assistant.spi.interact.IObricInteractService") == false) goto L3605;
        T r293 = (T) new ObricInteractServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.spi.interact.IObricInteractService", r293);
        return r293;
    L1174:
        if (r3.getName().equals("com.larus.dora.o.api.IDoraOHealthService") == false) goto L3605;
        T r294 = (T) new DoraOHealthServiceImpl();
        putStaticServiceImplCache("com.larus.dora.o.api.IDoraOHealthService", r294);
        return r294;
    L1178:
        if (r3.getName().equals("com.larus.search.api.LarkChatServiceProxy") == false) goto L3605;
        T r295 = (T) new LarkChatServiceProxyImpl();
        putStaticServiceImplCache("com.larus.search.api.LarkChatServiceProxy", r295);
        return r295;
    L1182:
        if (r3.getName().equals("com.obric.assistant.desktop_icon.IObricAddDesktopIconService") == false) goto L3605;
        T r296 = (T) new ObricAddDesktopIconServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.desktop_icon.IObricAddDesktopIconService", r296);
        return r296;
    L1186:
        if (r3.getName().equals("com.larus.platform.api.IFlowOfficeFileDownloadService") == false) goto L3605;
        T r297 = (T) new FlowOfficeFileDownloadServiceImpl();
        putStaticServiceImplCache("com.larus.platform.api.IFlowOfficeFileDownloadService", r297);
        return r297;
    L1190:
        if (r3.getName().equals("com.larus.network.IHttpConst") == false) goto L3605;
        T r298 = (T) new HttpConstImpl();
        putStaticServiceImplCache("com.larus.network.IHttpConst", r298);
        return r298;
    L1194:
        if (r3.getName().equals("com.larus.office.base.export.IOfficeDocExportDelegate") == false) goto L3605;
        T r299 = (T) new OfficeDocExportDelegateImpl();
        putStaticServiceImplCache("com.larus.office.base.export.IOfficeDocExportDelegate", r299);
        return r299;
    L1198:
        if (r3.getName().equals("com.larus.init.IAbTestInitiator") == false) goto L3605;
        T r300 = (T) new AbTestInitiator();
        putStaticServiceImplCache("com.larus.init.IAbTestInitiator", r300);
        return r300;
    L1202:
        if (r3.getName().equals("com.larus.bmhome.chat.deepthink.IDeepThinkBlockService") == false) goto L3605;
        T r301 = (T) new DeepThinkBlockServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.chat.deepthink.IDeepThinkBlockService", r301);
        return r301;
    L1206:
        if (r3.getName().equals("com.larus.platform.api.IAppLaunchReporter") == false) goto L3605;
        T r302 = (T) new AppLaunchReporterDelegate();
        putStaticServiceImplCache("com.larus.platform.api.IAppLaunchReporter", r302);
        return r302;
    L1210:
        if (r3.getName().equals("com.larus.platform.spi.MarkdownDataHandlersProvider") == false) goto L3605;
        T r303 = (T) new CustomDataHandlerProvider();
        putStaticServiceImplCache("com.larus.platform.spi.MarkdownDataHandlersProvider", r303);
        return r303;
    L1214:
        if (r3.getName().equals("com.larus.ivykit.forest.IFlowForestService") == false) goto L3605;
        T r304 = (T) new FlowGeckoResourceService();
        putStaticServiceImplCache("com.larus.ivykit.forest.IFlowForestService", r304);
        return r304;
    L1218:
        if (r3.getName().equals("com.obric.assistant.feedback.IObricFeedbackService") == false) goto L3605;
        T r305 = (T) new ObricFeedbackService();
        putStaticServiceImplCache("com.obric.assistant.feedback.IObricFeedbackService", r305);
        return r305;
    L1222:
        if (r3.getName().equals("com.obric.assistant.chat.IObricChatContextService") == false) goto L3605;
        T r306 = (T) new ObricChatContextServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.chat.IObricChatContextService", r306);
        return r306;
    L1226:
        if (r3.getName().equals("com.obric.assistant.spi.dora.IObricVendorBluetoothQueryService") == false) goto L3605;
        T r307 = (T) new ObricVendorBluetoothQueryServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.spi.dora.IObricVendorBluetoothQueryService", r307);
        return r307;
    L1230:
        if (r3.getName().equals("com.larus.common.mssdk.api.ISecPrivacyService") == false) goto L3605;
        T r308 = (T) new ISecPrivacyServiceImpl();
        putStaticServiceImplCache("com.larus.common.mssdk.api.ISecPrivacyService", r308);
        return r308;
    L1234:
        if (r3.getName().equals("com.larus.common.venue.api.IFlowCommonVenueService") == false) goto L3605;
        T r309 = (T) new FlowCommonVenueServiceImpl();
        putStaticServiceImplCache("com.larus.common.venue.api.IFlowCommonVenueService", r309);
        return r309;
    L1238:
        if (r3.getName().equals("com.larus.multitask_management.api.customize.ITaskUIFactory") == false) goto L3605;
        T r310 = (T) new DefaultTaskUIFactory();
        putStaticServiceImplCache("com.larus.multitask_management.api.customize.ITaskUIFactory", r310);
        return r310;
    L1242:
        if (r3.getName().equals("com.larus.uaigc.service.ICreationResourceAccessService") == false) goto L3605;
        T r311 = (T) new CreationResourceAccessServiceImpl();
        putStaticServiceImplCache("com.larus.uaigc.service.ICreationResourceAccessService", r311);
        return r311;
    L1246:
        if (r3.getName().equals("com.ss.android.ugc.aweme.search.ecommerce.api.IECSearchGrowMarketingService") == false) goto L3605;
        T r312 = (T) new ECSearchGrowMarketingServiceImpl();
        putStaticServiceImplCache("com.ss.android.ugc.aweme.search.ecommerce.api.IECSearchGrowMarketingService", r312);
        return r312;
    L1250:
        if (r3.getName().equals("com.larus.home.api.feed.IFlowFeedProvider") == false) goto L3605;
        T r313 = (T) new SideBarLarkFeedProvider();
        putStaticServiceImplCache("com.larus.home.api.feed.IFlowFeedProvider", r313);
        return r313;
    L1254:
        if (r3.getName().equals("com.larus.video.api.IVideoEngineInitService") == false) goto L3605;
        T r314 = (T) new VideoEngineInitServiceImpl();
        putStaticServiceImplCache("com.larus.video.api.IVideoEngineInitService", r314);
        return r314;
    L1258:
        if (r3.getName().equals("com.larus.avlink.api.IAlbumService") == false) goto L3605;
        T r315 = (T) new AlbumImpl();
        putStaticServiceImplCache("com.larus.avlink.api.IAlbumService", r315);
        return r315;
    L1262:
        if (r3.getName().equals("com.larus.audio.audiov3.report.IAudioDeviceMonitorReporter") == false) goto L3605;
        T r316 = (T) new AudioDeviceMonitorReporterImpl();
        putStaticServiceImplCache("com.larus.audio.audiov3.report.IAudioDeviceMonitorReporter", r316);
        return r316;
    L1266:
        if (r3.getName().equals("com.obric.assistant.spi.wakeup.IObricOneshotService") == false) goto L3605;
        T r317 = (T) new ObricOneshotServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.spi.wakeup.IObricOneshotService", r317);
        return r317;
    L1270:
        if (r3.getName().equals("com.larus.audio.record.factory.IAudioRecorderFactory") == false) goto L3605;
        T r318 = (T) new AudioRecorderFactory();
        putStaticServiceImplCache("com.larus.audio.record.factory.IAudioRecorderFactory", r318);
        return r318;
    L1274:
        if (r3.getName().equals("com.larus.account.base.provider.IVerificationCodeLoginProvider") == false) goto L3605;
        T r319 = (T) new PhoneLogin();
        putStaticServiceImplCache("com.larus.account.base.provider.IVerificationCodeLoginProvider", r319);
        return r319;
    L1278:
        if (r3.getName().equals("com.obric.assistant.session.model.IDoraOperation") == false) goto L3605;
        T r320 = (T) new DoraSessionEndpoint();
        putStaticServiceImplCache("com.obric.assistant.session.model.IDoraOperation", r320);
        return r320;
    L1282:
        if (r3.getName().equals("com.larus.business.accessbility.api.IAccessibilityService") == false) goto L3605;
        T r321 = (T) new AccessibilityServiceImpl();
        putStaticServiceImplCache("com.larus.business.accessbility.api.IAccessibilityService", r321);
        return r321;
    L1286:
        if (r3.getName().equals("com.obric.audio.rtc_context.IObricDoraContextProvider") == false) goto L3605;
        T r322 = (T) new ObricDoraContextProvider();
        putStaticServiceImplCache("com.obric.audio.rtc_context.IObricDoraContextProvider", r322);
        return r322;
    L1290:
        if (r3.getName().equals("com.larus.feishu.office.im.api.FlowComponentAdaptService") == false) goto L3605;
        T r323 = (T) new FlowComponentAdaptServiceImpl();
        putStaticServiceImplCache("com.larus.feishu.office.im.api.FlowComponentAdaptService", r323);
        return r323;
    L1294:
        if (r3.getName().equals("com.obric.assistant.spi.audio.IObricMmtVideoSettingsService") == false) goto L3605;
        T r324 = (T) new ObricMmtVideoSettingsServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.spi.audio.IObricMmtVideoSettingsService", r324);
        return r324;
    L1298:
        if (r3.getName().equals("com.larus.bmhome.chat.nestedmenu.IMainBotNestedMenuService") == false) goto L3605;
        T r325 = (T) new NestMenuServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.chat.nestedmenu.IMainBotNestedMenuService", r325);
        return r325;
    L1302:
        if (r3.getName().equals("com.larus.chat.api.IChatCmdInterceptor") == false) goto L3605;
        T r326 = (T) new ChatCmdInterceptorImpl();
        putStaticServiceImplCache("com.larus.chat.api.IChatCmdInterceptor", r326);
        return r326;
    L1306:
        if (r3.getName().equals("com.larus.bmhome.chat.component.bottom.multimodal.upload.FileUploadService") == false) goto L3605;
        T r327 = (T) new FileUploadServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.chat.component.bottom.multimodal.upload.FileUploadService", r327);
        return r327;
    L1310:
        if (r3.getName().equals("com.bytedance.android.ec.hybrid.service.IECMallFeedServiceAdApter") == false) goto L3605;
        T r328 = (T) new ECMallFeedServiceAdapter();
        putStaticServiceImplCache("com.bytedance.android.ec.hybrid.service.IECMallFeedServiceAdApter", r328);
        return r328;
    L1314:
        if (r3.getName().equals("com.larus.livetutor.api.ILiveTutorService") == false) goto L3605;
        T r329 = (T) new LiveTutorServiceImpl();
        putStaticServiceImplCache("com.larus.livetutor.api.ILiveTutorService", r329);
        return r329;
    L1318:
        if (r3.getName().equals("com.larus.ugc.feed.api.spi.ITemplateCreationFragmentFactory") == false) goto L3605;
        T r330 = (T) new TemplateCreationFragmentFactoryImpl();
        putStaticServiceImplCache("com.larus.ugc.feed.api.spi.ITemplateCreationFragmentFactory", r330);
        return r330;
    L1322:
        if (r3.getName().equals("com.obric.assistant.state.api.multitask.IObricRealtimeCallStateProducerService") == false) goto L3605;
        T r331 = (T) new RealtimeCallStateProducer();
        putStaticServiceImplCache("com.obric.assistant.state.api.multitask.IObricRealtimeCallStateProducerService", r331);
        return r331;
    L1326:
        if (r3.getName().equals("com.larus.dora.api.IByteCastManager") == false) goto L3605;
        T r332 = (T) new DoraByteCastManager();
        putStaticServiceImplCache("com.larus.dora.api.IByteCastManager", r332);
        return r332;
    L1330:
        if (r3.getName().equals("com.obric.assistant.state.ISharedStateService") == false) goto L3605;
        T r333 = (T) new ShareStateServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.state.ISharedStateService", r333);
        return r333;
    L1334:
        if (r3.getName().equals("com.larus.sheet.sdk.api.ISheetSdkProxyService") == false) goto L3605;
        T r334 = (T) new SheetSdkProxyServiceImpl();
        putStaticServiceImplCache("com.larus.sheet.sdk.api.ISheetSdkProxyService", r334);
        return r334;
    L1338:
        if (r3.getName().equals("com.larus.account.saas.coreapi.IAccountFrontierMessageHandler") == false) goto L3605;
        T r335 = (T) new MfaFrontierMessageHandler();
        putStaticServiceImplCache("com.larus.account.saas.coreapi.IAccountFrontierMessageHandler", r335);
        return r335;
    L1342:
        if (r3.getName().equals("com.obric.assistant.state.api.v2.core.IObricDeviceStateService") == false) goto L3605;
        T r336 = (T) new ObricDeviceStateServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.state.api.v2.core.IObricDeviceStateService", r336);
        return r336;
    L1346:
        if (r3.getName().equals("com.larus.bmhome.chat.component.list.ChatMessageListPageObserver") == false) goto L3605;
        T r337 = (T) new OfficeUrlPreviewMessageListObserver();
        putStaticServiceImplCache("com.larus.bmhome.chat.component.list.ChatMessageListPageObserver", r337);
        return r337;
    L1350:
        if (r3.getName().equals("com.obric.assistant.spi.dora.IDoraWakeupService") == false) goto L3605;
        T r338 = (T) new DoraWakeupServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.spi.dora.IDoraWakeupService", r338);
        return r338;
    L1354:
        if (r3.getName().equals("com.obric.assistant.guide.IObricUserGuide") == false) goto L3605;
        T r339 = (T) new ObricUserGuideImpl();
        putStaticServiceImplCache("com.obric.assistant.guide.IObricUserGuide", r339);
        return r339;
    L1358:
        if (r3.getName().equals("com.larus.office.card.urlpreview.IOfficeUrlPreviewActionInterceptorProvider") == false) goto L3605;
        T r340 = (T) new OfficeUrlPreviewActionInterceptorProviderImpl();
        putStaticServiceImplCache("com.larus.office.card.urlpreview.IOfficeUrlPreviewActionInterceptorProvider", r340);
        return r340;
    L1362:
        if (r3.getName().equals("com.larus.share.service.IShareDoubaoForwardService") == false) goto L3605;
        T r341 = (T) new ShareDoubaoForwardService();
        putStaticServiceImplCache("com.larus.share.service.IShareDoubaoForwardService", r341);
        return r341;
    L1366:
        if (r3.getName().equals("com.larus.init.IAppLogInitiator") == false) goto L3605;
        T r342 = (T) new AppLogInitiator();
        putStaticServiceImplCache("com.larus.init.IAppLogInitiator", r342);
        return r342;
    L1370:
        if (r3.getName().equals("com.obric.assistant.voice.IWakeupTruthCaptureSwitchSyncService") == false) goto L3605;
        T r343 = (T) new WakeupTruthCaptureSwitchSyncServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.voice.IWakeupTruthCaptureSwitchSyncService", r343);
        return r343;
    L1374:
        if (r3.getName().equals("com.larus.btm.api.IBTMService") == false) goto L3605;
        T r344 = (T) new BTMServiceImpl();
        putStaticServiceImplCache("com.larus.btm.api.IBTMService", r344);
        return r344;
    L1378:
        if (r3.getName().equals("com.larus.platform.api.creation.IBachDetectCenterAbility") == false) goto L3605;
        T r345 = (T) new BachDetectCenterAbilityImpl();
        putStaticServiceImplCache("com.larus.platform.api.creation.IBachDetectCenterAbility", r345);
        return r345;
    L1382:
        if (r3.getName().equals("com.larus.mirabridge.api.plugin.service.IPluginInternalService") == false) goto L3605;
        T r346 = (T) new PluginInternalServiceImpl();
        putStaticServiceImplCache("com.larus.mirabridge.api.plugin.service.IPluginInternalService", r346);
        return r346;
    L1386:
        if (r3.getName().equals("com.larus.bmhome.chat.headerinfo.IDeepThinkHeaderService") == false) goto L3605;
        T r347 = (T) new DeepThinkHeaderServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.chat.headerinfo.IDeepThinkHeaderService", r347);
        return r347;
    L1390:
        if (r3.getName().equals("com.obric.assistant.audio.service.IObricAssistantForAudio") == false) goto L3605;
        T r348 = (T) new ObricAssistantForAudioImpl();
        putStaticServiceImplCache("com.obric.assistant.audio.service.IObricAssistantForAudio", r348);
        return r348;
    L1394:
        if (r3.getName().equals("com.bytedance.bmf_mods_api.VqscoreLiveAPI") == false) goto L3605;
        T r349 = (T) new VqscoreLive();
        putStaticServiceImplCache("com.bytedance.bmf_mods_api.VqscoreLiveAPI", r349);
        return r349;
    L1398:
        if (r3.getName().equals("com.larus.business.debug.api.DebugBaseService") == false) goto L3605;
        T r350 = (T) new DebugBaseServiceImpl();
        putStaticServiceImplCache("com.larus.business.debug.api.DebugBaseService", r350);
        return r350;
    L1402:
        if (r3.getName().equals("com.larus.platform.api.IFlowDocExportConfigProvider") == false) goto L3605;
        T r351 = (T) new FlowDocExportConfigProvider();
        putStaticServiceImplCache("com.larus.platform.api.IFlowDocExportConfigProvider", r351);
        return r351;
    L1406:
        if (r3.getName().equals("com.larus.bootprotector.IBootProtectorLauncher") == false) goto L3605;
        T r352 = (T) new BootProtectorLauncher();
        putStaticServiceImplCache("com.larus.bootprotector.IBootProtectorLauncher", r352);
        return r352;
    L1410:
        if (r3.getName().equals("com.obric.assistant.voice.IObricVoiceService") == false) goto L3605;
        T r353 = (T) new ObricVoiceServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.voice.IObricVoiceService", r353);
        return r353;
    L1414:
        if (r3.getName().equals("com.obric.aiagent.ipc.idl.IFileIDLSPI") == false) goto L3605;
        T r354 = (T) new FileIDLStubImpl();
        putStaticServiceImplCache("com.obric.aiagent.ipc.idl.IFileIDLSPI", r354);
        return r354;
    L1418:
        if (r3.getName().equals("com.larus.account.base.provider.IGooglePhoneLoginProvider") == false) goto L3605;
        T r355 = (T) new GooglePhoneInfo();
        putStaticServiceImplCache("com.larus.account.base.provider.IGooglePhoneLoginProvider", r355);
        return r355;
    L1422:
        if (r3.getName().equals("com.larus.bmhome.view.actionbar.api.IActionBarProvider") == false) goto L3605;
        T r356 = (T) new TaskSkillActionBarProvider();
        putStaticServiceImplCache("com.larus.bmhome.view.actionbar.api.IActionBarProvider", r356);
        return r356;
    L1426:
        if (r3.getName().equals("com.larus.bmhome.chat.bubble.floating.runtime.IBubbleBannerRuntimeService") == false) goto L3605;
        T r357 = (T) new BubbleBannerRuntimeServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.chat.bubble.floating.runtime.IBubbleBannerRuntimeService", r357);
        return r357;
    L1430:
        if (r3.getName().equals("com.obric.assistant.IObricAvailableManager") == false) goto L3605;
        T r358 = (T) new ObricAvailableManagerImpl();
        putStaticServiceImplCache("com.obric.assistant.IObricAvailableManager", r358);
        return r358;
    L1434:
        if (r3.getName().equals("com.bytedance.timon.ruler.adapter.impl.IRulerBusinessService") == false) goto L3605;
        T r359 = (T) new RulerBusinessServiceImpl();
        putStaticServiceImplCache("com.bytedance.timon.ruler.adapter.impl.IRulerBusinessService", r359);
        return r359;
    L1438:
        if (r3.getName().equals("com.larus.multitask_management.api.IMultiTaskHostAbility") == false) goto L3605;
        T r360 = (T) new MultiTaskHostAbilityImpl();
        putStaticServiceImplCache("com.larus.multitask_management.api.IMultiTaskHostAbility", r360);
        return r360;
    L1442:
        if (r3.getName().equals("com.larus.bmhome.input.api.IEnterKeyBehaviorHostService") == false) goto L3605;
        T r361 = (T) new EnterKeyBehaviorServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.input.api.IEnterKeyBehaviorHostService", r361);
        return r361;
    L1446:
        if (r3.getName().equals("com.larus.bmhome.resource.access.ResourceNodeHandler") == false) goto L3605;
        T r362 = (T) new CreationImageReviewHandler();
        putStaticServiceImplCache("com.larus.bmhome.resource.access.ResourceNodeHandler", r362);
        return r362;
    L1450:
        if (r3.getName().equals("com.obric.aiagent.assistant.idl.IFlowFrontierIDLSPI") == false) goto L3605;
        T r363 = (T) new FrontierIDLStub();
        putStaticServiceImplCache("com.obric.aiagent.assistant.idl.IFlowFrontierIDLSPI", r363);
        return r363;
    L1454:
        if (r3.getName().equals("com.obric.assistant.zeus.plugin.IZeusPluginService") == false) goto L3605;
        T r364 = (T) new ZeusPluginServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.zeus.plugin.IZeusPluginService", r364);
        return r364;
    L1458:
        if (r3.getName().equals("com.obric.assistant.session.model.IApplicationActivityOperation") == false) goto L3605;
        T r365 = (T) new ApplicationActivityEndpoint();
        putStaticServiceImplCache("com.obric.assistant.session.model.IApplicationActivityOperation", r365);
        return r365;
    L1462:
        if (r3.getName().equals("com.obric.assistant.performance.IObricThresholdDumpHprofService") == false) goto L3605;
        T r366 = (T) new ObricThresholdDumpHprofServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.performance.IObricThresholdDumpHprofService", r366);
        return r366;
    L1466:
        if (r3.getName().equals("com.larus.chat.gallery.api.IFindSimilarAvailabilityChecker") == false) goto L3605;
        T r367 = (T) new FindSimilarAvailabilityCheckerImpl();
        putStaticServiceImplCache("com.larus.chat.gallery.api.IFindSimilarAvailabilityChecker", r367);
        return r367;
    L1470:
        if (r3.getName().equals("com.obric.aiagent.assistant.idl.IFlowUiIDLSPI") == false) goto L3605;
        T r368 = (T) new FlowUIIDLStub();
        putStaticServiceImplCache("com.obric.aiagent.assistant.idl.IFlowUiIDLSPI", r368);
        return r368;
    L1474:
        if (r3.getName().equals("com.obric.assistant.IObricOmniLockscreenStateService") == false) goto L3605;
        T r369 = (T) new ObricOmniLockscreenStateServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.IObricOmniLockscreenStateService", r369);
        return r369;
    L1478:
        if (r3.getName().equals("com.obric.assistant.activation.presentation.contract.feedback.ObricActivationFeedback") == false) goto L3605;
        T r370 = (T) new ObricActivationFeedbackImpl();
        putStaticServiceImplCache("com.obric.assistant.activation.presentation.contract.feedback.ObricActivationFeedback", r370);
        return r370;
    L1482:
        if (r3.getName().equals("com.larus.bmhome.chat.camera.command.CameraCommandSideEffectFactory") == false) goto L3605;
        T r371 = (T) new CameraCommandSideEffectFactoryImpl();
        putStaticServiceImplCache("com.larus.bmhome.chat.camera.command.CameraCommandSideEffectFactory", r371);
        return r371;
    L1486:
        if (r3.getName().equals("com.larus.tts.ITtsReaderInterceptor") == false) goto L3605;
        T r372 = (T) new DoraTtsReaderInterceptor();
        putStaticServiceImplCache("com.larus.tts.ITtsReaderInterceptor", r372);
        return r372;
    L1490:
        if (r3.getName().equals("com.larus.business.multitask_management.api.IMultiTaskInitEvent") == false) goto L3605;
        T r373 = (T) new AICreationMultiTaskInitEventImpl();
        putStaticServiceImplCache("com.larus.business.multitask_management.api.IMultiTaskInitEvent", r373);
        return r373;
    L1494:
        if (r3.getName().equals("com.obric.assistant.state.multitask.core.TaskFlowCriticalResolver") == false) goto L3605;
        T r374 = (T) new ObricTaskFlowActiveStateResolver();
        putStaticServiceImplCache("com.obric.assistant.state.multitask.core.TaskFlowCriticalResolver", r374);
        return r374;
    L1498:
        if (r3.getName().equals("com.bytedance.upc.IUpcBusinessService") == false) goto L3605;
        T r375 = (T) new DeviceInfoService();
        putStaticServiceImplCache("com.bytedance.upc.IUpcBusinessService", r375);
        return r375;
    L1502:
        if (r3.getName().equals("com.obric.assistant.network.api.IObricNetworkService") == false) goto L3605;
        T r376 = (T) new ObricNetworkServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.network.api.IObricNetworkService", r376);
        return r376;
    L1506:
        if (r3.getName().equals("com.obric.assistant.interaction.api.IObricApmService") == false) goto L3605;
        T r377 = (T) new ObricApmServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.interaction.api.IObricApmService", r377);
        return r377;
    L1510:
        if (r3.getName().equals("com.larus.agents.api.IOfficeTaskSettingsService") == false) goto L3605;
        T r378 = (T) new OfficeTaskSettingsServiceImpl();
        putStaticServiceImplCache("com.larus.agents.api.IOfficeTaskSettingsService", r378);
        return r378;
    L1514:
        if (r3.getName().equals("com.larus.tts.IChatTtsService") == false) goto L3605;
        T r379 = (T) new ChatTtsServiceImpl();
        putStaticServiceImplCache("com.larus.tts.IChatTtsService", r379);
        return r379;
    L1518:
        if (r3.getName().equals("com.bytedance.android.shopping.api.mall.mallSession.IDeliveryCompatApi") == false) goto L3605;
        T r380 = (T) new DeliveryCompatImpl();
        putStaticServiceImplCache("com.bytedance.android.shopping.api.mall.mallSession.IDeliveryCompatApi", r380);
        return r380;
    L1522:
        if (r3.getName().equals("com.larus.push.api.IPushService") == false) goto L3605;
        T r381 = (T) new IPushServiceImpl();
        putStaticServiceImplCache("com.larus.push.api.IPushService", r381);
        return r381;
    L1526:
        if (r3.getName().equals("com.larus.bmhome.share.api.IConversationSharePanelService") == false) goto L3605;
        T r382 = (T) new ConversationSharePanelService();
        putStaticServiceImplCache("com.larus.bmhome.share.api.IConversationSharePanelService", r382);
        return r382;
    L1530:
        if (r3.getName().equals("com.obric.assistant.spi.chat.IObricChatSPIService") == false) goto L3605;
        T r383 = (T) new ObricChatSPIServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.spi.chat.IObricChatSPIService", r383);
        return r383;
    L1534:
        if (r3.getName().equals("com.obric.assistant.account.IObricAccountService") == false) goto L3605;
        T r384 = (T) new ObricAccountServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.account.IObricAccountService", r384);
        return r384;
    L1538:
        if (r3.getName().equals("com.larus.xbridge.IXBridgeMethodRegistry") == false) goto L3605;
        T r385 = (T) new OfficeCCMH5JSBRegistry();
        putStaticServiceImplCache("com.larus.xbridge.IXBridgeMethodRegistry", r385);
        return r385;
    L1542:
        if (r3.getName().equals("com.obric.assistant.utils.IObricAssistantUtilHelperService") == false) goto L3605;
        T r386 = (T) new ObricAssistantUtilHelperServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.utils.IObricAssistantUtilHelperService", r386);
        return r386;
    L1546:
        if (r3.getName().equals("com.larus.common.baidunavi.api.BaiduNaviService") == false) goto L3605;
        T r387 = (T) new BaiduNaviServiceImpl();
        putStaticServiceImplCache("com.larus.common.baidunavi.api.BaiduNaviService", r387);
        return r387;
    L1550:
        if (r3.getName().equals("com.larus.dora.api.IObricEnvAuthSheetService") == false) goto L3605;
        T r388 = (T) new ObricEnvAuthSheetServiceImpl();
        putStaticServiceImplCache("com.larus.dora.api.IObricEnvAuthSheetService", r388);
        return r388;
    L1554:
        if (r3.getName().equals("com.larus.account.base.provider.agegate.IAgeGateManagerInterface") == false) goto L3605;
        T r389 = (T) new AgeGateManager();
        putStaticServiceImplCache("com.larus.account.base.provider.agegate.IAgeGateManagerInterface", r389);
        return r389;
    L1558:
        if (r3.getName().equals("com.larus.bmhome.chat.api.IMusicService") == false) goto L3605;
        T r390 = (T) new MusicService();
        putStaticServiceImplCache("com.larus.bmhome.chat.api.IMusicService", r390);
        return r390;
    L1562:
        if (r3.getName().equals("com.obric.assistant.interaction.api.IAssistantInteractionService") == false) goto L3605;
        T r391 = (T) new AssistantInteractionService();
        putStaticServiceImplCache("com.obric.assistant.interaction.api.IAssistantInteractionService", r391);
        return r391;
    L1566:
        if (r3.getName().equals("com.larus.setting.api.ICustomAboutApp") == false) goto L3605;
        T r392 = (T) new ObricAboutAppImpl();
        putStaticServiceImplCache("com.larus.setting.api.ICustomAboutApp", r392);
        return r392;
    L1570:
        if (r3.getName().equals("com.larus.im.config.IMessengerConfigs") == false) goto L3605;
        T r393 = (T) new MessengerConfigsImpl();
        putStaticServiceImplCache("com.larus.im.config.IMessengerConfigs", r393);
        return r393;
    L1574:
        if (r3.getName().equals("com.obric.assistant.spi.startup.IAssistantStartupTelemetry") == false) goto L3605;
        T r394 = (T) new AssistantStartupTelemetryImpl();
        putStaticServiceImplCache("com.obric.assistant.spi.startup.IAssistantStartupTelemetry", r394);
        return r394;
    L1578:
        if (r3.getName().equals("com.ivy.ivykit.api.plugin.IvyResourceService") == false) goto L3605;
        T r395 = (T) new IvyResourceServiceImpl();
        putStaticServiceImplCache("com.ivy.ivykit.api.plugin.IvyResourceService", r395);
        return r395;
    L1582:
        if (r3.getName().equals("com.larus.e_commerce.api.IECommerceService") == false) goto L3605;
        T r396 = (T) new ECommerceServiceImpl();
        putStaticServiceImplCache("com.larus.e_commerce.api.IECommerceService", r396);
        return r396;
    L1586:
        if (r3.getName().equals("com.obric.assistant.activity_stack.IObricActivityStackService") == false) goto L3605;
        T r397 = (T) new ObricActivityStackServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.activity_stack.IObricActivityStackService", r397);
        return r397;
    L1590:
        if (r3.getName().equals("com.bytedance.bmf_mods_api.ByteStreamHDAPI") == false) goto L3605;
        return (T) new ByteStreamHD();
    L1594:
        if (r3.getName().equals("com.larus.bmhome.chat.component.list.pipeline.TimestampTaskProvider") == false) goto L3605;
        T r398 = (T) new SpecialProvider();
        putStaticServiceImplCache("com.larus.bmhome.chat.component.list.pipeline.TimestampTaskProvider", r398);
        return r398;
    L1598:
        if (r3.getName().equals("com.obric.assistant.spi.audio.IObricWakeupTruthUploadService") == false) goto L3605;
        T r399 = (T) new WakeupTruthUploadManager();
        putStaticServiceImplCache("com.obric.assistant.spi.audio.IObricWakeupTruthUploadService", r399);
        return r399;
    L1602:
        if (r3.getName().equals("com.obric.assistant.spi.audio.IObricEnrollTraceParamService") == false) goto L3605;
        T r400 = (T) new ObricEnrollTraceParamServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.spi.audio.IObricEnrollTraceParamService", r400);
        return r400;
    L1606:
        if (r3.getName().equals("com.larus.home.api.privacy.ICustomPrivacyService") == false) goto L3605;
        T r401 = (T) new ObricPrivacyService();
        putStaticServiceImplCache("com.larus.home.api.privacy.ICustomPrivacyService", r401);
        return r401;
    L1610:
        if (r3.getName().equals("com.larus.platform.api.IFlowOfficeExportService") == false) goto L3605;
        T r402 = (T) new FlowOfficeExportServiceImpl();
        putStaticServiceImplCache("com.larus.platform.api.IFlowOfficeExportService", r402);
        return r402;
    L1614:
        if (r3.getName().equals("com.larus.bmhome.chat.model.repo.IRepoDispatcherService") == false) goto L3605;
        T r403 = (T) new RepoDispatcherImpl();
        putStaticServiceImplCache("com.larus.bmhome.chat.model.repo.IRepoDispatcherService", r403);
        return r403;
    L1618:
        if (r3.getName().equals("com.obric.assistant.common.spi.network.IObricTTNetMonitorHookService") == false) goto L3605;
        T r404 = (T) new ObricTTNetMonitorHookServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.common.spi.network.IObricTTNetMonitorHookService", r404);
        return r404;
    L1622:
        if (r3.getName().equals("com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener") == false) goto L3605;
        T r405 = (T) new NotificationSwitchBubbleBannerSourceListener();
        putStaticServiceImplCache("com.larus.bmhome.chat.bubble.floating.event.BubbleBannerSourceListener", r405);
        return r405;
    L1626:
        if (r3.getName().equals("com.larus.im.depend.IAIJobExperimentProvider") == false) goto L3605;
        T r406 = (T) new ChatJobExperimentProvider();
        putStaticServiceImplCache("com.larus.im.depend.IAIJobExperimentProvider", r406);
        return r406;
    L1630:
        if (r3.getName().equals("com.larus.office.card.sheet.download.IOfficeCardSheetDownloadService") == false) goto L3605;
        T r407 = (T) new OfficeCardSheetDownloadServiceImpl();
        putStaticServiceImplCache("com.larus.office.card.sheet.download.IOfficeCardSheetDownloadService", r407);
        return r407;
    L1634:
        if (r3.getName().equals("com.larus.bmhome.instruction.kmp.IKmpInstructionWidgetProvider") == false) goto L3605;
        T r408 = (T) new CommandKmpInstructionWidgetProvider();
        putStaticServiceImplCache("com.larus.bmhome.instruction.kmp.IKmpInstructionWidgetProvider", r408);
        return r408;
    L1638:
        if (r3.getName().equals("com.larus.audio.IFlowTtsClientKmpService") == false) goto L3605;
        T r409 = (T) new FlowTtsClientKmpManagerDelegate();
        putStaticServiceImplCache("com.larus.audio.IFlowTtsClientKmpService", r409);
        return r409;
    L1642:
        if (r3.getName().equals("com.larus.xbridge.IXBridgeApi") == false) goto L3605;
        T r410 = (T) new IXBridgeImpl();
        putStaticServiceImplCache("com.larus.xbridge.IXBridgeApi", r410);
        return r410;
    L1646:
        if (r3.getName().equals("com.larus.bmhome.chat.model.repo.IChatRepoService") == false) goto L3605;
        T r411 = (T) new ChatRepo();
        putStaticServiceImplCache("com.larus.bmhome.chat.model.repo.IChatRepoService", r411);
        return r411;
    L1650:
        if (r3.getName().equals("com.larus.dora.api.config.IDoraPageConfig") == false) goto L3605;
        T r412 = (T) new DoraPageConfigServiceImpl();
        putStaticServiceImplCache("com.larus.dora.api.config.IDoraPageConfig", r412);
        return r412;
    L1654:
        if (r3.getName().equals("com.larus.navigation.api.INavigationTestEntry") == false) goto L3605;
        T r413 = (T) new NavigationTestEntry();
        putStaticServiceImplCache("com.larus.navigation.api.INavigationTestEntry", r413);
        return r413;
    L1658:
        if (r3.getName().equals("com.obric.assistant.audio.service.IObricLiveService") == false) goto L3605;
        T r414 = (T) new ObricLiveService();
        putStaticServiceImplCache("com.obric.assistant.audio.service.IObricLiveService", r414);
        return r414;
    L1662:
        if (r3.getName().equals("com.larus.agents.api.IWebPageFetchService") == false) goto L3605;
        T r415 = (T) new WebPageFetchServiceImpl();
        putStaticServiceImplCache("com.larus.agents.api.IWebPageFetchService", r415);
        return r415;
    L1666:
        if (r3.getName().equals("com.obric.assistant.shortcut.IObricShortCutsService") == false) goto L3605;
        T r416 = (T) new ObricShortCutsServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.shortcut.IObricShortCutsService", r416);
        return r416;
    L1670:
        if (r3.getName().equals("com.larus.slides.sdk.api.ISlidesSdkServiceV2") == false) goto L3605;
        T r417 = (T) new SlidesSdkServiceImplV2();
        putStaticServiceImplCache("com.larus.slides.sdk.api.ISlidesSdkServiceV2", r417);
        return r417;
    L1674:
        if (r3.getName().equals("com.larus.av_call.service.IRealtimeCallConfigDependency") == false) goto L3605;
        T r418 = (T) new RealtimeCallConfigProvider();
        putStaticServiceImplCache("com.larus.av_call.service.IRealtimeCallConfigDependency", r418);
        return r418;
    L1678:
        if (r3.getName().equals("com.larus.office.card.doc.content.IOfficeCardDocContentService") == false) goto L3605;
        T r419 = (T) new OfficeCardDocContentServiceImpl();
        putStaticServiceImplCache("com.larus.office.card.doc.content.IOfficeCardDocContentService", r419);
        return r419;
    L1682:
        if (r3.getName().equals("com.ss.aweme.paas.IAwemePaasTarget") == false) goto L3605;
        T r420 = (T) new APHubbleTarget();
        putStaticServiceImplCache("com.ss.aweme.paas.IAwemePaasTarget", r420);
        return r420;
    L1686:
        if (r3.getName().equals("com.obric.assistant.spi.performance.IObricMemoryReportSPIService") == false) goto L3605;
        T r421 = (T) new ObricMemoryReportSPIServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.spi.performance.IObricMemoryReportSPIService", r421);
        return r421;
    L1690:
        if (r3.getName().equals("com.larus.bot.api.IBotCreateService") == false) goto L3605;
        T r422 = (T) new BotCreateServiceImpl();
        putStaticServiceImplCache("com.larus.bot.api.IBotCreateService", r422);
        return r422;
    L1694:
        if (r3.getName().equals("com.obric.assistant.audio.service.IObricAudioInteractService") == false) goto L3605;
        T r423 = (T) new ObricAudioInteractService();
        putStaticServiceImplCache("com.obric.assistant.audio.service.IObricAudioInteractService", r423);
        return r423;
    L1698:
        if (r3.getName().equals("com.obric.assistant.settings.spi.IObricSettingProvider") == false) goto L3605;
        T r424 = (T) new DoraSettingProvider();
        putStaticServiceImplCache("com.obric.assistant.settings.spi.IObricSettingProvider", r424);
        return r424;
    L1702:
        if (r3.getName().equals("com.larus.feishu.office.im.api.FlowVoiceInputExtensionFactoryService") == false) goto L3605;
        T r425 = (T) new FlowVoiceInputExtensionFactoryServiceImpl();
        putStaticServiceImplCache("com.larus.feishu.office.im.api.FlowVoiceInputExtensionFactoryService", r425);
        return r425;
    L1706:
        if (r3.getName().equals("com.obric.assistant.spi.app.IObricLaunchService") == false) goto L3605;
        T r426 = (T) new AppLaunchServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.spi.app.IObricLaunchService", r426);
        return r426;
    L1710:
        if (r3.getName().equals("com.larus.bmhome.instruction.helper.IConvReplyModeRecordHelper") == false) goto L3605;
        T r427 = (T) new ConvReplyModeRecordHelper();
        putStaticServiceImplCache("com.larus.bmhome.instruction.helper.IConvReplyModeRecordHelper", r427);
        return r427;
    L1714:
        if (r3.getName().equals("com.larus.browsertakeover.api.IBrowserTakeoverService") == false) goto L3605;
        T r428 = (T) new BrowserTakeoverServiceImpl();
        putStaticServiceImplCache("com.larus.browsertakeover.api.IBrowserTakeoverService", r428);
        return r428;
    L1718:
        if (r3.getName().equals("com.bytedance.locallife.ILocalLifeLiveService") == false) goto L3605;
        T r429 = (T) new LocalLifeLiveServiceImpl();
        putStaticServiceImplCache("com.bytedance.locallife.ILocalLifeLiveService", r429);
        return r429;
    L1722:
        if (r3.getName().equals("com.obric.assistant.wakeup.statistics.api.IWakeupStatisticsAPI") == false) goto L3605;
        T r430 = (T) new WakeupStatisticsImpl();
        putStaticServiceImplCache("com.obric.assistant.wakeup.statistics.api.IWakeupStatisticsAPI", r430);
        return r430;
    L1726:
        if (r3.getName().equals("com.larus.account.saas.coreapi.IAccountBindingService") == false) goto L3605;
        T r431 = (T) new AccountBindingService();
        putStaticServiceImplCache("com.larus.account.saas.coreapi.IAccountBindingService", r431);
        return r431;
    L1730:
        if (r3.getName().equals("com.larus.minutes.api.IMinutesService") == false) goto L3605;
        T r432 = (T) new MinutesServiceImpl();
        putStaticServiceImplCache("com.larus.minutes.api.IMinutesService", r432);
        return r432;
    L1734:
        if (r3.getName().equals("com.larus.platform.api.IFlowOfficeWikiTokenResolver") == false) goto L3605;
        T r433 = (T) new OfficeWikiTokenResolverServiceImpl();
        putStaticServiceImplCache("com.larus.platform.api.IFlowOfficeWikiTokenResolver", r433);
        return r433;
    L1738:
        if (r3.getName().equals("com.larus.bmhome.chat.api.IAppletGrantingWidgetService") == false) goto L3605;
        T r434 = (T) new AppletGrantingWidgetServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.chat.api.IAppletGrantingWidgetService", r434);
        return r434;
    L1742:
        if (r3.getName().equals("com.obric.assistant.interaction.api.IWindowEffects") == false) goto L3605;
        T r435 = (T) new WindowEffectsImpl();
        putStaticServiceImplCache("com.obric.assistant.interaction.api.IWindowEffects", r435);
        return r435;
    L1746:
        if (r3.getName().equals("com.larus.account.saas.coreapi.IAccountTouristService") == false) goto L3605;
        T r436 = (T) new AccountTouristService();
        putStaticServiceImplCache("com.larus.account.saas.coreapi.IAccountTouristService", r436);
        return r436;
    L1750:
        if (r3.getName().equals("com.larus.uaigc.service.ICreationInstructionService") == false) goto L3605;
        T r437 = (T) new CreationInstructionServiceImpl();
        putStaticServiceImplCache("com.larus.uaigc.service.ICreationInstructionService", r437);
        return r437;
    L1754:
        if (r3.getName().equals("com.larus.doc.sdk.api.IDocSdkServiceV2") == false) goto L3605;
        T r438 = (T) new DocSdkServiceImplV2();
        putStaticServiceImplCache("com.larus.doc.sdk.api.IDocSdkServiceV2", r438);
        return r438;
    L1758:
        if (r3.getName().equals("com.larus.audio.audiov3.util.IAudioDeviceHelper") == false) goto L3605;
        T r439 = (T) new AudioDeviceHelperImpl();
        putStaticServiceImplCache("com.larus.audio.audiov3.util.IAudioDeviceHelper", r439);
        return r439;
    L1762:
        if (r3.getName().equals("com.bytedance.bmf_mods_api.HydraHDRAPI") == false) goto L3605;
        T r440 = (T) new HydraHDR();
        putStaticServiceImplCache("com.bytedance.bmf_mods_api.HydraHDRAPI", r440);
        return r440;
    L1766:
        if (r3.getName().equals("com.larus.bmhome.chat.api.IRenderLiteService") == false) goto L3605;
        T r441 = (T) new RenderLiteServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.chat.api.IRenderLiteService", r441);
        return r441;
    L1770:
        if (r3.getName().equals("com.larus.uaigc.service.IUgcAIGCService") == false) goto L3605;
        T r442 = (T) new UgcAIGCServiceImpl();
        putStaticServiceImplCache("com.larus.uaigc.service.IUgcAIGCService", r442);
        return r442;
    L1774:
        if (r3.getName().equals("com.larus.extension.summary_card.api.ISummaryCardService") == false) goto L3605;
        T r443 = (T) new SummaryCardServiceImpl();
        putStaticServiceImplCache("com.larus.extension.summary_card.api.ISummaryCardService", r443);
        return r443;
    L1778:
        if (r3.getName().equals("com.obric.assistant.appchange.IObricAppChangeListenerService") == false) goto L3605;
        T r444 = (T) new ObricAppChangeListenerServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.appchange.IObricAppChangeListenerService", r444);
        return r444;
    L1782:
        if (r3.getName().equals("com.larus.uaigc.music.ILyricsToSongBoxWrapper") == false) goto L3605;
        return (T) new LyricsToSongBoxWrapper();
    L1786:
        if (r3.getName().equals("com.larus.bmhome.instruction.IInstructionSubCreator") == false) goto L3605;
        T r445 = (T) new CollaboratedMultiFeatureSelectorSubCreator();
        putStaticServiceImplCache("com.larus.bmhome.instruction.IInstructionSubCreator", r445);
        return r445;
    L1790:
        if (r3.getName().equals("com.larus.search.api.IBrowserService") == false) goto L3605;
        T r446 = (T) new SearchServiceImpl();
        putStaticServiceImplCache("com.larus.search.api.IBrowserService", r446);
        return r446;
    L1794:
        if (r3.getName().equals("com.obric.assistant.session.model.IVoiceWakeupOperation") == false) goto L3605;
        T r447 = (T) new VoiceWakeupSessionEndpoint();
        putStaticServiceImplCache("com.obric.assistant.session.model.IVoiceWakeupOperation", r447);
        return r447;
    L1798:
        if (r3.getName().equals("com.obric.update.api.v2.IObricUpdateService") == false) goto L3605;
        T r448 = (T) new ObricUpdateBitImpl();
        putStaticServiceImplCache("com.obric.update.api.v2.IObricUpdateService", r448);
        return r448;
    L1802:
        if (r3.getName().equals("com.larus.home.api.keva.IKevaPreloadService") == false) goto L3605;
        T r449 = (T) new KevaPreloadServiceImpl();
        putStaticServiceImplCache("com.larus.home.api.keva.IKevaPreloadService", r449);
        return r449;
    L1806:
        if (r3.getName().equals("com.larus.login.api.IBdauthApi") == false) goto L3605;
        T r450 = (T) new BdauthServiceImpl();
        putStaticServiceImplCache("com.larus.login.api.IBdauthApi", r450);
        return r450;
    L1810:
        if (r3.getName().equals("com.obric.assistant.spi.task.IObricTaskSkillService") == false) goto L3605;
        T r451 = (T) new ObricTaskSkillServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.spi.task.IObricTaskSkillService", r451);
        return r451;
    L1814:
        if (r3.getName().equals("com.larus.reach.api.ReachSceneLifecycleListener") == false) goto L3605;
        T r452 = (T) new RealtimeCallQuotaReachSceneHandler();
        putStaticServiceImplCache("com.larus.reach.api.ReachSceneLifecycleListener", r452);
        return r452;
    L1818:
        if (r3.getName().equals("com.larus.bmhome.chat.component.list.pipeline.PipelineTaskProvider") == false) goto L3605;
        T r453 = (T) new ImmerseCutTaskProvider();
        putStaticServiceImplCache("com.larus.bmhome.chat.component.list.pipeline.PipelineTaskProvider", r453);
        return r453;
    L1822:
        if (r3.getName().equals("com.obric.assistant.privacy.IObricPrivacyService") == false) goto L3605;
        T r454 = (T) new ObricPrivacyService();
        putStaticServiceImplCache("com.obric.assistant.privacy.IObricPrivacyService", r454);
        return r454;
    L1826:
        if (r3.getName().equals("com.larus.bmhome.chat.api.IBotInfoCacheService") == false) goto L3605;
        T r455 = (T) new BotInfoCacheImpl();
        putStaticServiceImplCache("com.larus.bmhome.chat.api.IBotInfoCacheService", r455);
        return r455;
    L1830:
        if (r3.getName().equals("com.larus.bmhome.taskskill.service.IPcDevicePanelService") == false) goto L3605;
        T r456 = (T) new PcDevicePanelServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.taskskill.service.IPcDevicePanelService", r456);
        return r456;
    L1834:
        if (r3.getName().equals("com.larus.account.saas.coreapi.IAccountProfileService") == false) goto L3605;
        T r457 = (T) new AccountProfileService();
        putStaticServiceImplCache("com.larus.account.saas.coreapi.IAccountProfileService", r457);
        return r457;
    L1838:
        if (r3.getName().equals("com.larus.init.IImageInitiator") == false) goto L3605;
        T r458 = (T) new ImageInitiator();
        putStaticServiceImplCache("com.larus.init.IImageInitiator", r458);
        return r458;
    L1842:
        if (r3.getName().equals("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDLSPI") == false) goto L3605;
        T r459 = (T) new AppLogIDLStub();
        putStaticServiceImplCache("com.obric.aiagent.flow.applog.idl.IFlowAppLogIDLSPI", r459);
        return r459;
    L1846:
        if (r3.getName().equals("com.obric.assistant.state.multitask.core.TaskFlowAutoInitProducer") == false) goto L3605;
        T r460 = (T) new ObricAigcGenerationStateProducer();
        putStaticServiceImplCache("com.obric.assistant.state.multitask.core.TaskFlowAutoInitProducer", r460);
        return r460;
    L1850:
        if (r3.getName().equals("com.larus.bmhome.chat.tips.IGuideTipsService") == false) goto L3605;
        T r461 = (T) new GuideTipsService();
        putStaticServiceImplCache("com.larus.bmhome.chat.tips.IGuideTipsService", r461);
        return r461;
    L1854:
        if (r3.getName().equals("com.bytedance.android.btm.impl.provider.IBtmConfigFromEcom") == false) goto L3605;
        return (T) new EcomConfigForBtmImpl();
    L1858:
        if (r3.getName().equals("com.obric.assistant.wakeup.bluetooth_headset.api.IBluetoothHeadSetAPI") == false) goto L3605;
        T r462 = (T) new BluetoothHeadSetImpl();
        putStaticServiceImplCache("com.obric.assistant.wakeup.bluetooth_headset.api.IBluetoothHeadSetAPI", r462);
        return r462;
    L1862:
        if (r3.getName().equals("com.larus.multitask_management.api.customize.ITaskActionHandler") == false) goto L3605;
        T r463 = (T) new MultiComplexTaskActionHandler();
        putStaticServiceImplCache("com.larus.multitask_management.api.customize.ITaskActionHandler", r463);
        return r463;
    L1866:
        if (r3.getName().equals("com.larus.bmhome.chat.input.swipe.InputSwipePanelService") == false) goto L3605;
        T r464 = (T) new InputSwipePanelServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.chat.input.swipe.InputSwipePanelService", r464);
        return r464;
    L1870:
        if (r3.getName().equals("com.obric.assistant.spi.audio.IObricRealtimeCallExtService") == false) goto L3605;
        T r465 = (T) new ObricRealtimeCallExtServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.spi.audio.IObricRealtimeCallExtService", r465);
        return r465;
    L1874:
        if (r3.getName().equals("com.larus.init.task.publishtest.IPublishDrillService") == false) goto L3605;
        return (T) new PublishDrillServiceImpl();
    L1878:
        if (r3.getName().equals("com.larus.voicecall.api.IRealtimeCallStateService") == false) goto L3605;
        T r466 = (T) new RealtimeCallStateServiceImpl();
        putStaticServiceImplCache("com.larus.voicecall.api.IRealtimeCallStateService", r466);
        return r466;
    L1882:
        if (r3.getName().equals("com.larus.uploader.api.IUploaderService") == false) goto L3605;
        T r467 = (T) new UploaderServiceImpl();
        putStaticServiceImplCache("com.larus.uploader.api.IUploaderService", r467);
        return r467;
    L1886:
        if (r3.getName().equals("com.bytedance.bmf_mods_api.SitiAPI") == false) goto L3605;
        return (T) new Siti();
    L1890:
        if (r3.getName().equals("com.obric.assistant.storage.IObricLowStorageService") == false) goto L3605;
        T r468 = (T) new ObricLowStorageServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.storage.IObricLowStorageService", r468);
        return r468;
    L1894:
        if (r3.getName().equals("com.larus.bmhome.chat.cotdetail.ICotDetailService") == false) goto L3605;
        T r469 = (T) new CotDetailServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.chat.cotdetail.ICotDetailService", r469);
        return r469;
    L1898:
        if (r3.getName().equals("com.obric.assistant.ISessionAuthenticationService") == false) goto L3605;
        T r470 = (T) new SessionAuthenticationServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.ISessionAuthenticationService", r470);
        return r470;
    L1902:
        if (r3.getName().equals("com.obric.assistant.performance.IObricMemoryUploadService") == false) goto L3605;
        T r471 = (T) new ObricMemoryUploadServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.performance.IObricMemoryUploadService", r471);
        return r471;
    L1906:
        if (r3.getName().equals("com.larus.ivykit.forest.IObricForestService") == false) goto L3605;
        T r472 = (T) new ObricGeckoResourceService();
        putStaticServiceImplCache("com.larus.ivykit.forest.IObricForestService", r472);
        return r472;
    L1910:
        if (r3.getName().equals("com.larus.bmhome.nestedfile.INestedFileCacheManagerService") == false) goto L3605;
        T r473 = (T) new NestedFileCacheManagerServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.nestedfile.INestedFileCacheManagerService", r473);
        return r473;
    L1914:
        if (r3.getName().equals("com.larus.cdm.IFlowCompanionDeviceManager") == false) goto L3605;
        T r474 = (T) new FlowCompanionDeviceManagerImpl();
        putStaticServiceImplCache("com.larus.cdm.IFlowCompanionDeviceManager", r474);
        return r474;
    L1918:
        if (r3.getName().equals("com.larus.platform.IFlowSdkService") == false) goto L3605;
        T r475 = (T) new FlowSdkImpl();
        putStaticServiceImplCache("com.larus.platform.IFlowSdkService", r475);
        return r475;
    L1922:
        if (r3.getName().equals("com.larus.bmhome.chat.api.IMessageExtService") == false) goto L3605;
        T r476 = (T) new AppletDebugMessageExtServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.chat.api.IMessageExtService", r476);
        return r476;
    L1926:
        if (r3.getName().equals("com.larus.bmhome.chat.outerinput.IOuterChatInputProvider") == false) goto L3605;
        T r477 = (T) new OuterChatInputProviderImpl();
        putStaticServiceImplCache("com.larus.bmhome.chat.outerinput.IOuterChatInputProvider", r477);
        return r477;
    L1930:
        if (r3.getName().equals("com.larus.platform.api.IPermissionHelperApi") == false) goto L3605;
        T r478 = (T) new PermissionHelperImpl();
        putStaticServiceImplCache("com.larus.platform.api.IPermissionHelperApi", r478);
        return r478;
    L1934:
        if (r3.getName().equals("com.larus.uaigc.service.ICreationShareService") == false) goto L3605;
        T r479 = (T) new CreationShareServiceImpl();
        putStaticServiceImplCache("com.larus.uaigc.service.ICreationShareService", r479);
        return r479;
    L1938:
        if (r3.getName().equals("com.larus.audio.observer.IGlobalAudioObserver") == false) goto L3605;
        T r480 = (T) new GlobalAudioObserverImpl();
        putStaticServiceImplCache("com.larus.audio.observer.IGlobalAudioObserver", r480);
        return r480;
    L1942:
        if (r3.getName().equals("com.bytedance.ai.api.IAppletDebuggerService") == false) goto L3605;
        T r481 = (T) new AppletDebuggerServiceImpl();
        putStaticServiceImplCache("com.bytedance.ai.api.IAppletDebuggerService", r481);
        return r481;
    L1946:
        if (r3.getName().equals("com.larus.profile.api.IProfileApi") == false) goto L3605;
        T r482 = (T) new ProfileServiceImpl();
        putStaticServiceImplCache("com.larus.profile.api.IProfileApi", r482);
        return r482;
    L1950:
        if (r3.getName().equals("com.obric.update.api.v2.IObricUpdateSettingService") == false) goto L3605;
        T r483 = (T) new ObricUpdateSettingServiceImpl();
        putStaticServiceImplCache("com.obric.update.api.v2.IObricUpdateSettingService", r483);
        return r483;
    L1954:
        if (r3.getName().equals("com.larus.platform.api.IAccountRemovedCacheService") == false) goto L3605;
        T r484 = (T) new LaunchAccountRemovedCacheServiceImpl();
        putStaticServiceImplCache("com.larus.platform.api.IAccountRemovedCacheService", r484);
        return r484;
    L1958:
        if (r3.getName().equals("com.larus.bmhome.dora.IDoraProxy") == false) goto L3605;
        T r485 = (T) new DoraProxyImpl();
        putStaticServiceImplCache("com.larus.bmhome.dora.IDoraProxy", r485);
        return r485;
    L1962:
        if (r3.getName().equals("com.obric.assistant.cocreationreview.IObricCocreationReviewService") == false) goto L3605;
        T r486 = (T) new CocreationReviewServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.cocreationreview.IObricCocreationReviewService", r486);
        return r486;
    L1966:
        if (r3.getName().equals("com.larus.disk.api.IAppDiskService") == false) goto L3605;
        T r487 = (T) new IAppDiskServiceImpl();
        putStaticServiceImplCache("com.larus.disk.api.IAppDiskService", r487);
        return r487;
    L1970:
        if (r3.getName().equals("com.larus.bootprotector.IBootProtectorProcessDiff") == false) goto L3605;
        T r488 = (T) new ObricBootProtectorProcessDiffImpl();
        putStaticServiceImplCache("com.larus.bootprotector.IBootProtectorProcessDiff", r488);
        return r488;
    L1974:
        if (r3.getName().equals("com.larus.reach.api.ReachPresentationCapabilityProvider") == false) goto L3605;
        T r489 = (T) new RealtimeCallQuotaReachSceneHandler();
        putStaticServiceImplCache("com.larus.reach.api.ReachPresentationCapabilityProvider", r489);
        return r489;
    L1978:
        if (r3.getName().equals("com.obric.assistant.spi.security.privacypermission.IObricPrivacyAndPermissionUiService") == false) goto L3605;
        T r490 = (T) new ObricPrivacyAndPermissionUiServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.spi.security.privacypermission.IObricPrivacyAndPermissionUiService", r490);
        return r490;
    L1982:
        if (r3.getName().equals("com.larus.audio.controller.IGlobalAudioController") == false) goto L3605;
        T r491 = (T) new GlobalAudioControllerImpl();
        putStaticServiceImplCache("com.larus.audio.controller.IGlobalAudioController", r491);
        return r491;
    L1986:
        if (r3.getName().equals("com.larus.bmhome.utils.ILaunchLandingConfigHelper") == false) goto L3605;
        T r492 = (T) new LaunchLandingConfigHelper();
        putStaticServiceImplCache("com.larus.bmhome.utils.ILaunchLandingConfigHelper", r492);
        return r492;
    L1990:
        if (r3.getName().equals("com.bytedance.android.live.browser.rts.jsbridge.api.IIESLiveRTSJSBService") == false) goto L3605;
        T r493 = (T) new IESLiveRTSJSBService();
        putStaticServiceImplCache("com.bytedance.android.live.browser.rts.jsbridge.api.IIESLiveRTSJSBService", r493);
        return r493;
    L1994:
        if (r3.getName().equals("com.larus.bmhome.chat.block.base.IBlockProvider") == false) goto L3605;
        T r494 = (T) new PoiBlockProvider();
        putStaticServiceImplCache("com.larus.bmhome.chat.block.base.IBlockProvider", r494);
        return r494;
    L1998:
        if (r3.getName().equals("com.obric.assistant.performance.IObricPerformanceMonitorService") == false) goto L3605;
        T r495 = (T) new ObricPerformanceMonitorServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.performance.IObricPerformanceMonitorService", r495);
        return r495;
    L2002:
        if (r3.getName().equals("com.larus.bootprotector.BootProtectorDependency") == false) goto L3605;
        T r496 = (T) new BootProtectorDependencyImpl();
        putStaticServiceImplCache("com.larus.bootprotector.BootProtectorDependency", r496);
        return r496;
    L2006:
        if (r3.getName().equals("com.obric.assistant.wakeup.co_wakeup.dora.CoWakeupApi") == false) goto L3605;
        T r497 = (T) new CoWakeupService();
        putStaticServiceImplCache("com.obric.assistant.wakeup.co_wakeup.dora.CoWakeupApi", r497);
        return r497;
    L2010:
        if (r3.getName().equals("com.larus.api.LocationService") == false) goto L3605;
        T r498 = (T) new LocationClient();
        putStaticServiceImplCache("com.larus.api.LocationService", r498);
        return r498;
    L2014:
        if (r3.getName().equals("com.larus.platform.api.ISdkDouyinAuth") == false) goto L3605;
        T r499 = (T) new MainDouyinAuthService();
        putStaticServiceImplCache("com.larus.platform.api.ISdkDouyinAuth", r499);
        return r499;
    L2018:
        if (r3.getName().equals("com.larus.photopicker.v2.api.IInnerPhotoPickerService") == false) goto L3605;
        T r500 = (T) new InnerInnerPhotoPickerServiceImpl();
        putStaticServiceImplCache("com.larus.photopicker.v2.api.IInnerPhotoPickerService", r500);
        return r500;
    L2022:
        if (r3.getName().equals("com.larus.video.api.IVideoApi") == false) goto L3605;
        T r501 = (T) new VideoServiceImpl();
        putStaticServiceImplCache("com.larus.video.api.IVideoApi", r501);
        return r501;
    L2026:
        if (r3.getName().equals("com.obric.assistant.common.spi.toast.IToastHelper") == false) goto L3605;
        T r502 = (T) new ToastHelperImpl();
        putStaticServiceImplCache("com.obric.assistant.common.spi.toast.IToastHelper", r502);
        return r502;
    L2030:
        if (r3.getName().equals("com.larus.bmhome.video.IAwemeDoublePostService") == false) goto L3605;
        T r503 = (T) new DoublePostServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.video.IAwemeDoublePostService", r503);
        return r503;
    L2034:
        if (r3.getName().equals("com.larus.setting.api.trace.ISettingTrackApi") == false) goto L3605;
        T r504 = (T) new SettingTrace();
        putStaticServiceImplCache("com.larus.setting.api.trace.ISettingTrackApi", r504);
        return r504;
    L2038:
        if (r3.getName().equals("com.larus.showcase.api.ICaseService") == false) goto L3605;
        T r505 = (T) new CaseServiceImpl();
        putStaticServiceImplCache("com.larus.showcase.api.ICaseService", r505);
        return r505;
    L2042:
        if (r3.getName().equals("com.larus.multitask_management.api.spi.IMultiTaskSortComparator") == false) goto L3605;
        T r506 = (T) new ComplexTaskSortComparator();
        putStaticServiceImplCache("com.larus.multitask_management.api.spi.IMultiTaskSortComparator", r506);
        return r506;
    L2046:
        if (r3.getName().equals("com.obric.assistant.common.spi.IObricSlardarConfigService") == false) goto L3605;
        T r507 = (T) new ObricSlardarConfigServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.common.spi.IObricSlardarConfigService", r507);
        return r507;
    L2050:
        if (r3.getName().equals("com.larus.account.saas.coreapi.IAccountMfaService") == false) goto L3605;
        T r508 = (T) new AccountMfaService();
        putStaticServiceImplCache("com.larus.account.saas.coreapi.IAccountMfaService", r508);
        return r508;
    L2054:
        if (r3.getName().equals("com.larus.audio.report.IAsrTracerFactory") == false) goto L3605;
        T r509 = (T) new AsrTracerFactory();
        putStaticServiceImplCache("com.larus.audio.report.IAsrTracerFactory", r509);
        return r509;
    L2058:
        if (r3.getName().equals("com.larus.bmhome.praise.IAiChatPraiseTriggerService") == false) goto L3605;
        T r510 = (T) new AiChatPraiseTriggerServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.praise.IAiChatPraiseTriggerService", r510);
        return r510;
    L2062:
        if (r3.getName().equals("com.obric.assistant.window.materials.services.IWindowMaterialService") == false) goto L3605;
        T r511 = (T) new OWindowMaterialServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.window.materials.services.IWindowMaterialService", r511);
        return r511;
    L2066:
        if (r3.getName().equals("com.obric.assistant.settings.IObricSettingRouteService") == false) goto L3605;
        T r512 = (T) new ObricRouteServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.settings.IObricSettingRouteService", r512);
        return r512;
    L2070:
        if (r3.getName().equals("com.obric.aiagent.assistant.idl.IFlowAppStateIDLSPI") == false) goto L3605;
        T r513 = (T) new AppStateIDLStub();
        putStaticServiceImplCache("com.obric.aiagent.assistant.idl.IFlowAppStateIDLSPI", r513);
        return r513;
    L2074:
        if (r3.getName().equals("com.ivy.ivykit.api.plugin.IIvyLynxBehaviorService") == false) goto L3605;
        T r514 = (T) new IvyLynxBehaviorServiceImpl();
        putStaticServiceImplCache("com.ivy.ivykit.api.plugin.IIvyLynxBehaviorService", r514);
        return r514;
    L2078:
        if (r3.getName().equals("com.larus.bmhome.chat.api.IAiChatTraceService") == false) goto L3605;
        T r515 = (T) new AiChatTraceImpl();
        putStaticServiceImplCache("com.larus.bmhome.chat.api.IAiChatTraceService", r515);
        return r515;
    L2082:
        if (r3.getName().equals("com.larus.bmhome.chat.bubble.floating.datasource.IBubbleBannerDataService") == false) goto L3605;
        T r516 = (T) new BubbleBannerDataServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.chat.bubble.floating.datasource.IBubbleBannerDataService", r516);
        return r516;
    L2086:
        if (r3.getName().equals("com.larus.platform.spi.IChatTraceService") == false) goto L3605;
        T r517 = (T) new ChatTraceServiceImpl();
        putStaticServiceImplCache("com.larus.platform.spi.IChatTraceService", r517);
        return r517;
    L2090:
        if (r3.getName().equals("com.larus.uaigc.service.ICreationAiEditService") == false) goto L3605;
        T r518 = (T) new CreationAiEditServiceImpl();
        putStaticServiceImplCache("com.larus.uaigc.service.ICreationAiEditService", r518);
        return r518;
    L2094:
        if (r3.getName().equals("com.larus.audioplayer.api.manager.IAudioStopTimerManager") == false) goto L3605;
        T r519 = (T) new AudioStopTimerManagerService();
        putStaticServiceImplCache("com.larus.audioplayer.api.manager.IAudioStopTimerManager", r519);
        return r519;
    L2098:
        if (r3.getName().equals("com.obric.aiagent.rom.compat.api.IFeatureSettingsConfig") == false) goto L3605;
        T r520 = (T) new FeatureSettingsConfigImpl();
        putStaticServiceImplCache("com.obric.aiagent.rom.compat.api.IFeatureSettingsConfig", r520);
        return r520;
    L2102:
        if (r3.getName().equals("com.larus.feishu.office.im.api.FlowFastAlbumAbilityFactoryService") == false) goto L3605;
        T r521 = (T) new FlowFastAlbumAbilityFactoryServiceImpl();
        putStaticServiceImplCache("com.larus.feishu.office.im.api.FlowFastAlbumAbilityFactoryService", r521);
        return r521;
    L2106:
        if (r3.getName().equals("com.obric.assistant.settings.IObricAutoGuiSettingsApi") == false) goto L3605;
        T r522 = (T) new com.obric.assistant.settings.autogui.ObricAutoGuiSettingsImpl();
        putStaticServiceImplCache("com.obric.assistant.settings.IObricAutoGuiSettingsApi", r522);
        return r522;
    L2110:
        if (r3.getName().equals("com.larus.avlink.api.IDoraGResourceService") == false) goto L3605;
        T r523 = (T) new DoraGResourceServiceImpl();
        putStaticServiceImplCache("com.larus.avlink.api.IDoraGResourceService", r523);
        return r523;
    L2114:
        if (r3.getName().equals("com.obric.assistant.IRemoteCard") == false) goto L3605;
        T r524 = (T) new RemoteCardImpl();
        putStaticServiceImplCache("com.obric.assistant.IRemoteCard", r524);
        return r524;
    L2118:
        if (r3.getName().equals("com.obric.assistant.agent.IObricAgentApi") == false) goto L3605;
        T r525 = (T) new ObricAgentServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.agent.IObricAgentApi", r525);
        return r525;
    L2122:
        if (r3.getName().equals("com.larus.shortcuts.api.IShortcutsService") == false) goto L3605;
        T r526 = (T) new ShortcutsServiceImpl();
        putStaticServiceImplCache("com.larus.shortcuts.api.IShortcutsService", r526);
        return r526;
    L2126:
        if (r3.getName().equals("com.larus.platform.IFlowSdkDepend") == false) goto L3605;
        T r527 = (T) new FlowSdkDependImpl();
        putStaticServiceImplCache("com.larus.platform.IFlowSdkDepend", r527);
        return r527;
    L2130:
        if (r3.getName().equals("com.larus.share.service.IAppletSharePanelService") == false) goto L3605;
        T r528 = (T) new AppletSharePanelServiceImpl();
        putStaticServiceImplCache("com.larus.share.service.IAppletSharePanelService", r528);
        return r528;
    L2134:
        if (r3.getName().equals("com.ivy.ivykit.api.bridge.IBridgeMethodService") == false) goto L3605;
        T r529 = (T) new BridgeMethodServiceImpl();
        putStaticServiceImplCache("com.ivy.ivykit.api.bridge.IBridgeMethodService", r529);
        return r529;
    L2138:
        if (r3.getName().equals("com.larus.apm.api.INpth") == false) goto L3605;
        T r530 = (T) new NpthImpl();
        putStaticServiceImplCache("com.larus.apm.api.INpth", r530);
        return r530;
    L2142:
        if (r3.getName().equals("com.larus.account.saas.ttaccount.api.IAccountSwitchService") == false) goto L3605;
        T r531 = (T) new AccountSwitchService();
        putStaticServiceImplCache("com.larus.account.saas.ttaccount.api.IAccountSwitchService", r531);
        return r531;
    L2146:
        if (r3.getName().equals("com.larus.bmhome.chat.api.IWidgetRenderService") == false) goto L3605;
        T r532 = (T) new WidgetRenderServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.chat.api.IWidgetRenderService", r532);
        return r532;
    L2150:
        if (r3.getName().equals("com.larus.bmhome.share.api.IShareRuntimeService") == false) goto L3605;
        T r533 = (T) new MainlandShareRuntimeServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.share.api.IShareRuntimeService", r533);
        return r533;
    L2154:
        if (r3.getName().equals("com.larus.bmhome.chat.component.list.pipeline.PipelineStageProvider") == false) goto L3605;
        T r534 = (T) new UpdateStageProvider();
        putStaticServiceImplCache("com.larus.bmhome.chat.component.list.pipeline.PipelineStageProvider", r534);
        return r534;
    L2158:
        if (r3.getName().equals("com.larus.abtest.api.IGlobalExposureStarter") == false) goto L3605;
        T r535 = (T) new GlobalExposureTest();
        putStaticServiceImplCache("com.larus.abtest.api.IGlobalExposureStarter", r535);
        return r535;
    L2162:
        if (r3.getName().equals("com.larus.bmhome.chat.mainbot.IAiChatMainBotModuleService") == false) goto L3605;
        T r536 = (T) new AiChatMainBotModuleServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.chat.mainbot.IAiChatMainBotModuleService", r536);
        return r536;
    L2166:
        if (r3.getName().equals("com.obric.assistant.ttnet.IObricTTNet") == false) goto L3605;
        T r537 = (T) new ObricTTNetImpl();
        putStaticServiceImplCache("com.obric.assistant.ttnet.IObricTTNet", r537);
        return r537;
    L2170:
        if (r3.getName().equals("com.obric.assistant.settings.IObricPersonalContextSettingApi") == false) goto L3605;
        T r538 = (T) new ObricPersonalContextSettingServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.settings.IObricPersonalContextSettingApi", r538);
        return r538;
    L2174:
        if (r3.getName().equals("com.obric.assistant.spi.audio.IObricContinuousTalkService") == false) goto L3605;
        T r539 = (T) new ObricContinuousTalkServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.spi.audio.IObricContinuousTalkService", r539);
        return r539;
    L2178:
        if (r3.getName().equals("com.larus.audio.ttsV2.IHeadsetDetectorService") == false) goto L3605;
        T r540 = (T) new HeadsetDetectorServiceImpl();
        putStaticServiceImplCache("com.larus.audio.ttsV2.IHeadsetDetectorService", r540);
        return r540;
    L2182:
        if (r3.getName().equals("com.obric.assistant.spi.audio.IObricWakeupAudioCaptureService") == false) goto L3605;
        T r541 = (T) new WakeupAudioCaptureServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.spi.audio.IObricWakeupAudioCaptureService", r541);
        return r541;
    L2186:
        if (r3.getName().equals("com.larus.platform.spi.IAIChatUploadMediaService") == false) goto L3605;
        T r542 = (T) new AIChatUploadMediaServiceImpl();
        putStaticServiceImplCache("com.larus.platform.spi.IAIChatUploadMediaService", r542);
        return r542;
    L2190:
        if (r3.getName().equals("com.larus.live.api.ILiveService") == false) goto L3605;
        T r543 = (T) new LiveService();
        putStaticServiceImplCache("com.larus.live.api.ILiveService", r543);
        return r543;
    L2194:
        if (r3.getName().equals("com.larus.office.IOfficeSdkService") == false) goto L3605;
        T r544 = (T) new OfficeSdkServiceImpl();
        putStaticServiceImplCache("com.larus.office.IOfficeSdkService", r544);
        return r544;
    L2198:
        if (r3.getName().equals("com.ss.cast.plugin.dy.source.ISourceController") == false) goto L3605;
        return (T) new SourceManager();
    L2202:
        if (r3.getName().equals("com.larus.audio.ttsV2.ITtsBackgroundPlayControlService") == false) goto L3605;
        T r545 = (T) new DefaultTtsBackgroundPlayControlServiceImpl();
        putStaticServiceImplCache("com.larus.audio.ttsV2.ITtsBackgroundPlayControlService", r545);
        return r545;
    L2206:
        if (r3.getName().equals("com.larus.home.api.sidebar.IConversationGroupConfigProvider") == false) goto L3605;
        T r546 = (T) new ConversationGroupConfigProviderImpl();
        putStaticServiceImplCache("com.larus.home.api.sidebar.IConversationGroupConfigProvider", r546);
        return r546;
    L2210:
        if (r3.getName().equals("com.obric.assistant.spi.complextask.IComplexTaskService") == false) goto L3605;
        T r547 = (T) new ObricComplexTaskServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.spi.complextask.IComplexTaskService", r547);
        return r547;
    L2214:
        if (r3.getName().equals("com.larus.abtest.api.IAbTest") == false) goto L3605;
        T r548 = (T) new AbTestImpl();
        putStaticServiceImplCache("com.larus.abtest.api.IAbTest", r548);
        return r548;
    L2218:
        if (r3.getName().equals("com.larus.bmhome.chat.model.repo.IUserSettingRepoService") == false) goto L3605;
        T r549 = (T) new com.larus.bmhome.setting.UserSettingImpl();
        putStaticServiceImplCache("com.larus.bmhome.chat.model.repo.IUserSettingRepoService", r549);
        return r549;
    L2222:
        if (r3.getName().equals("com.larus.bot.api.IBotPerfMonitorService") == false) goto L3605;
        T r550 = (T) new BotPerfMonitorServiceImpl();
        putStaticServiceImplCache("com.larus.bot.api.IBotPerfMonitorService", r550);
        return r550;
    L2226:
        if (r3.getName().equals("com.obric.assistant.common.spi.IObricSamiService") == false) goto L3605;
        T r551 = (T) new ObricSamiService();
        putStaticServiceImplCache("com.obric.assistant.common.spi.IObricSamiService", r551);
        return r551;
    L2230:
        if (r3.getName().equals("com.obric.assistant.spi.chat.IObricChatUIService") == false) goto L3605;
        T r552 = (T) new ObricChatUIServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.spi.chat.IObricChatUIService", r552);
        return r552;
    L2234:
        if (r3.getName().equals("com.larus.larkfeed.IFlowFeedApi") == false) goto L3605;
        T r553 = (T) new FlowFeedImpl();
        putStaticServiceImplCache("com.larus.larkfeed.IFlowFeedApi", r553);
        return r553;
    L2238:
        if (r3.getName().equals("com.larus.voice_setting.INativeVoiceSettingPlatformEntryService") == false) goto L3605;
        T r554 = (T) new VoiceSettingPlatformEntryServiceImpl();
        putStaticServiceImplCache("com.larus.voice_setting.INativeVoiceSettingPlatformEntryService", r554);
        return r554;
    L2242:
        if (r3.getName().equals("com.larus.uaigc.service.ICreationAttachmentService") == false) goto L3605;
        T r555 = (T) new CreationAttachmentServiceImpl();
        putStaticServiceImplCache("com.larus.uaigc.service.ICreationAttachmentService", r555);
        return r555;
    L2246:
        if (r3.getName().equals("com.obric.assistant.task.IObricTaskStatusManager") == false) goto L3605;
        T r556 = (T) new ObricTaskStatusManagerImpl();
        putStaticServiceImplCache("com.obric.assistant.task.IObricTaskStatusManager", r556);
        return r556;
    L2250:
        if (r3.getName().equals("com.larus.platform.spi.IAIChatService") == false) goto L3605;
        T r557 = (T) new AIChatServiceImpl();
        putStaticServiceImplCache("com.larus.platform.spi.IAIChatService", r557);
        return r557;
    L2254:
        if (r3.getName().equals("com.obric.assistant.banner.IObricBannerService") == false) goto L3605;
        T r558 = (T) new ObricBannerService();
        putStaticServiceImplCache("com.obric.assistant.banner.IObricBannerService", r558);
        return r558;
    L2258:
        if (r3.getName().equals("com.larus.bmhome.upload.sdk.api.ext.IImageUploadSdkBuilderFactory") == false) goto L3605;
        T r559 = (T) new ImageUploadSdkBuilderFactoryImpl();
        putStaticServiceImplCache("com.larus.bmhome.upload.sdk.api.ext.IImageUploadSdkBuilderFactory", r559);
        return r559;
    L2262:
        if (r3.getName().equals("com.obric.assistant.interaction.api.service.IObricShowOnLockedService") == false) goto L3605;
        T r560 = (T) new ObricShowOnLockedServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.interaction.api.service.IObricShowOnLockedService", r560);
        return r560;
    L2266:
        if (r3.getName().equals("com.obric.assistant.spi.feedback.IFeedbackService") == false) goto L3605;
        T r561 = (T) new FeedbackServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.spi.feedback.IFeedbackService", r561);
        return r561;
    L2270:
        if (r3.getName().equals("com.bytedance.android.shopping.api.mall.feed.IECMallFeedService") == false) goto L3605;
        T r562 = (T) new ECMallFeedService();
        putStaticServiceImplCache("com.bytedance.android.shopping.api.mall.feed.IECMallFeedService", r562);
        return r562;
    L2274:
        if (r3.getName().equals("com.obric.assistant.common.spi.network.IObricBackgroundNetworkBlockService") == false) goto L3605;
        T r563 = (T) new ObricBackgroundNetworkBlockServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.common.spi.network.IObricBackgroundNetworkBlockService", r563);
        return r563;
    L2278:
        if (r3.getName().equals("com.larus.bmhome.chat.api.IGaokaoPreferenceService") == false) goto L3605;
        T r564 = (T) new GaokaoPreferenceServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.chat.api.IGaokaoPreferenceService", r564);
        return r564;
    L2282:
        if (r3.getName().equals("com.larus.bmhome.chat.model.repo.ISettingRepoService") == false) goto L3605;
        T r565 = (T) new SettingRepo();
        putStaticServiceImplCache("com.larus.bmhome.chat.model.repo.ISettingRepoService", r565);
        return r565;
    L2286:
        if (r3.getName().equals("com.larus.dora.device.api.IDoraDeviceInfo") == false) goto L3605;
        T r566 = (T) new DoraDeviceInfoImpl();
        putStaticServiceImplCache("com.larus.dora.device.api.IDoraDeviceInfo", r566);
        return r566;
    L2290:
        if (r3.getName().equals("com.larus.perfdegrade.api.IPerfDegradeAbility") == false) goto L3605;
        T r567 = (T) new PerfDegradeAbilityImpl();
        putStaticServiceImplCache("com.larus.perfdegrade.api.IPerfDegradeAbility", r567);
        return r567;
    L2294:
        if (r3.getName().equals("com.larus.home.api.main.IInitPeriodService") == false) goto L3605;
        T r568 = (T) new InitPeriodServiceImpl();
        putStaticServiceImplCache("com.larus.home.api.main.IInitPeriodService", r568);
        return r568;
    L2298:
        if (r3.getName().equals("com.larus.audioplayer.api.stream.IAudioSteamPlayerService") == false) goto L3605;
        T r569 = (T) new AudioStreamPlayerServiceImpl();
        putStaticServiceImplCache("com.larus.audioplayer.api.stream.IAudioSteamPlayerService", r569);
        return r569;
    L2302:
        if (r3.getName().equals("com.larus.bmhome.chat.component.bottom.core.InputViewCreatorService") == false) goto L3605;
        T r570 = (T) new InputViewCreator();
        putStaticServiceImplCache("com.larus.bmhome.chat.component.bottom.core.InputViewCreatorService", r570);
        return r570;
    L2306:
        if (r3.getName().equals("com.larus.bmhome.chat.interceptor.IMessageRenderInterceptorService") == false) goto L3605;
        T r571 = (T) new MarkdownRenderInterceptorImpl();
        putStaticServiceImplCache("com.larus.bmhome.chat.interceptor.IMessageRenderInterceptorService", r571);
        return r571;
    L2310:
        if (r3.getName().equals("com.larus.platform.api.IShortcutPlatformService") == false) goto L3605;
        T r572 = (T) new ShortcutPlatfomServiceImpl();
        putStaticServiceImplCache("com.larus.platform.api.IShortcutPlatformService", r572);
        return r572;
    L2314:
        if (r3.getName().equals("com.larus.bmhome.bot.ltm.IChatBotLtmService") == false) goto L3605;
        T r573 = (T) new FlowSaaSBotLtmServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.bot.ltm.IChatBotLtmService", r573);
        return r573;
    L2318:
        if (r3.getName().equals("com.obric.assistant.spi.chat.IObricChatMessageBgService") == false) goto L3605;
        T r574 = (T) new ObricChatMessageBgServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.spi.chat.IObricChatMessageBgService", r574);
        return r574;
    L2322:
        if (r3.getName().equals("com.larus.sheet.sdk.api.ISheetSdkInternalService") == false) goto L3605;
        T r575 = (T) new SheetSdkInternalServiceImpl();
        putStaticServiceImplCache("com.larus.sheet.sdk.api.ISheetSdkInternalService", r575);
        return r575;
    L2326:
        if (r3.getName().equals("com.obric.assistant.device.IObricDeviceManager") == false) goto L3605;
        T r576 = (T) new ObricDeviceManagerImpl();
        putStaticServiceImplCache("com.obric.assistant.device.IObricDeviceManager", r576);
        return r576;
    L2330:
        if (r3.getName().equals("com.obric.assistant.spi.actionbar.IObricActionBarTrackService") == false) goto L3605;
        T r577 = (T) new ObricActionBarTrackServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.spi.actionbar.IObricActionBarTrackService", r577);
        return r577;
    L2334:
        if (r3.getName().equals("com.larus.office.base.service.IOfficeSdkServiceV2") == false) goto L3605;
        T r578 = (T) new OfficeSdkServiceV2();
        putStaticServiceImplCache("com.larus.office.base.service.IOfficeSdkServiceV2", r578);
        return r578;
    L2338:
        if (r3.getName().equals("com.bytedance.android.btm.impl.provider.IBtmConfigFromBcm") == false) goto L3605;
        return (T) new BcmConfigForBtmImpl();
    L2342:
        if (r3.getName().equals("com.larus.bot.api.IBotRouteInterceptorService") == false) goto L3605;
        T r579 = (T) new BotRouteInterceptorServiceImpl();
        putStaticServiceImplCache("com.larus.bot.api.IBotRouteInterceptorService", r579);
        return r579;
    L2346:
        if (r3.getName().equals("com.larus.avlink.api.IDoraTrackerService") == false) goto L3605;
        T r580 = (T) new DoraTracerService();
        putStaticServiceImplCache("com.larus.avlink.api.IDoraTrackerService", r580);
        return r580;
    L2350:
        if (r3.getName().equals("com.obric.assistant.common.spi.security.IObricSecurityService") == false) goto L3605;
        T r581 = (T) new ObricSecurityServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.common.spi.security.IObricSecurityService", r581);
        return r581;
    L2354:
        if (r3.getName().equals("com.larus.setting.api.ICustomAppIcon") == false) goto L3605;
        T r582 = (T) new ObricCustomAppIconImpl();
        putStaticServiceImplCache("com.larus.setting.api.ICustomAppIcon", r582);
        return r582;
    L2358:
        if (r3.getName().equals("com.larus.share.service.IShareOfficeDocService") == false) goto L3605;
        T r583 = (T) new ShareOfficeDocServiceImpl();
        putStaticServiceImplCache("com.larus.share.service.IShareOfficeDocService", r583);
        return r583;
    L2362:
        if (r3.getName().equals("com.larus.audioplayer.api.utils.IMusicActionUtil") == false) goto L3605;
        T r584 = (T) new MusicActionUtilService();
        putStaticServiceImplCache("com.larus.audioplayer.api.utils.IMusicActionUtil", r584);
        return r584;
    L2366:
        if (r3.getName().equals("com.larus.community.api.spi.ICommunityDetailContainerProvider") == false) goto L3605;
        T r585 = (T) new DoubaoCommunityDetailContainerProvider();
        putStaticServiceImplCache("com.larus.community.api.spi.ICommunityDetailContainerProvider", r585);
        return r585;
    L2370:
        if (r3.getName().equals("com.obric.update.api.IObricUpdate") == false) goto L3605;
        T r586 = (T) new ObricUpdateImpl();
        putStaticServiceImplCache("com.obric.update.api.IObricUpdate", r586);
        return r586;
    L2374:
        if (r3.getName().equals("com.larus.uaigc.applet.IAICreationAppletPageProvider") == false) goto L3605;
        T r587 = (T) new AICreationAppletPageProviderImpl();
        putStaticServiceImplCache("com.larus.uaigc.applet.IAICreationAppletPageProvider", r587);
        return r587;
    L2378:
        if (r3.getName().equals("com.larus.home.api.main.IHomeApi") == false) goto L3605;
        T r588 = (T) new HomeServiceImpl();
        putStaticServiceImplCache("com.larus.home.api.main.IHomeApi", r588);
        return r588;
    L2382:
        if (r3.getName().equals("com.bytedance.android.live.openplatform.impl.base.awemepaas_adapt.IOpenPlatformFlavorService") == false) goto L3605;
        T r589 = (T) new OpenPlatformFlavorServiceDefault();
        putStaticServiceImplCache("com.bytedance.android.live.openplatform.impl.base.awemepaas_adapt.IOpenPlatformFlavorService", r589);
        return r589;
    L2386:
        if (r3.getName().equals("com.larus.account.saas.coreapi.IAccountEventsInterceptor") == false) goto L3605;
        T r590 = (T) new AccountEventsInterceptorImpl();
        putStaticServiceImplCache("com.larus.account.saas.coreapi.IAccountEventsInterceptor", r590);
        return r590;
    L2390:
        if (r3.getName().equals("com.larus.bmhome.block.pipeline.api.IBlockPipelineTask") == false) goto L3605;
        T r591 = (T) new RichMediaLayoutPositionPipelineTask();
        putStaticServiceImplCache("com.larus.bmhome.block.pipeline.api.IBlockPipelineTask", r591);
        return r591;
    L2394:
        if (r3.getName().equals("com.larus.larkfeed.IFlowLarkFeedApi") == false) goto L3605;
        T r592 = (T) new FlowLarkFeedImpl();
        putStaticServiceImplCache("com.larus.larkfeed.IFlowLarkFeedApi", r592);
        return r592;
    L2398:
        if (r3.getName().equals("com.larus.bootprotector.hotfix.IBootProtectorHotPatch") == false) goto L3605;
        T r593 = (T) new BootProtectorHotPatchImpl();
        putStaticServiceImplCache("com.larus.bootprotector.hotfix.IBootProtectorHotPatch", r593);
        return r593;
    L2402:
        if (r3.getName().equals("com.larus.bmhome.chat.block.base.renderer.IFileStyleArtifactRendererService") == false) goto L3605;
        T r594 = (T) new FileStyleArtifactRendererServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.chat.block.base.renderer.IFileStyleArtifactRendererService", r594);
        return r594;
    L2406:
        if (r3.getName().equals("com.obric.assistant.spi.share.IShareChannelExtraConfigurator") == false) goto L3605;
        T r595 = (T) new MainlandShareChannelExtraConfigurator();
        putStaticServiceImplCache("com.obric.assistant.spi.share.IShareChannelExtraConfigurator", r595);
        return r595;
    L2410:
        if (r3.getName().equals("com.bytedance.bmf_mods_api.VideoBrightAPI") == false) goto L3605;
        T r596 = (T) new VideoBright();
        putStaticServiceImplCache("com.bytedance.bmf_mods_api.VideoBrightAPI", r596);
        return r596;
    L2414:
        if (r3.getName().equals("com.larus.platform.spi.IAIChatAudioService") == false) goto L3605;
        T r597 = (T) new AIChatAudioServiceImpl();
        putStaticServiceImplCache("com.larus.platform.spi.IAIChatAudioService", r597);
        return r597;
    L2418:
        if (r3.getName().equals("com.larus.bmhome.chat.list.cell.prompt.ISuggestPromptCellProvider") == false) goto L3605;
        T r598 = (T) new SuggestPromptCellProviderImpl();
        putStaticServiceImplCache("com.larus.bmhome.chat.list.cell.prompt.ISuggestPromptCellProvider", r598);
        return r598;
    L2422:
        if (r3.getName().equals("com.larus.login.api.ILoginApi") == false) goto L3605;
        T r599 = (T) new LonginServiceImpl();
        putStaticServiceImplCache("com.larus.login.api.ILoginApi", r599);
        return r599;
    L2426:
        if (r3.getName().equals("com.bytedance.timon.foundation.interfaces.ITimonLogger") == false) goto L3605;
        T r600 = (T) new LocalTimonLogger();
        putStaticServiceImplCache("com.bytedance.timon.foundation.interfaces.ITimonLogger", r600);
        return r600;
    L2430:
        if (r3.getName().equals("com.obric.assistant.trace.IObricTrace") == false) goto L3605;
        T r601 = (T) new ObricTraceImpl();
        putStaticServiceImplCache("com.obric.assistant.trace.IObricTrace", r601);
        return r601;
    L2434:
        if (r3.getName().equals("com.larus.basic.experience.downgrade.api.IFlowDowngradeService") == false) goto L3605;
        T r602 = (T) new FlowDowngradeServiceImpl();
        putStaticServiceImplCache("com.larus.basic.experience.downgrade.api.IFlowDowngradeService", r602);
        return r602;
    L2438:
        if (r3.getName().equals("com.larus.audio.sami.IFlowSamiFactory") == false) goto L3605;
        T r603 = (T) new FlowSamiFactory();
        putStaticServiceImplCache("com.larus.audio.sami.IFlowSamiFactory", r603);
        return r603;
    L2442:
        if (r3.getName().equals("com.bytedance.android.shopping.api.mall.ILegouMallService") == false) goto L3605;
        T r604 = (T) new LegouMallServiceDefaultImpl();
        putStaticServiceImplCache("com.bytedance.android.shopping.api.mall.ILegouMallService", r604);
        return r604;
    L2446:
        if (r3.getName().equals("com.larus.dora.api.awareness.IAwarenessEventReporter") == false) goto L3605;
        T r605 = (T) new AwarenessEventReporter();
        putStaticServiceImplCache("com.larus.dora.api.awareness.IAwarenessEventReporter", r605);
        return r605;
    L2450:
        if (r3.getName().equals("com.obric.assistant.IObricPluginActivityRecordHelper") == false) goto L3605;
        T r606 = (T) new ObricPluginActivityRecordHelper();
        putStaticServiceImplCache("com.obric.assistant.IObricPluginActivityRecordHelper", r606);
        return r606;
    L2454:
        if (r3.getName().equals("com.collection.profile.api.ICollectService") == false) goto L3605;
        T r607 = (T) new CollectImpl();
        putStaticServiceImplCache("com.collection.profile.api.ICollectService", r607);
        return r607;
    L2458:
        if (r3.getName().equals("com.obric.assistant.spi.chat.IReceiveStreamMessageTypeOverrider") == false) goto L3605;
        T r608 = (T) new ObricReceiveStreamMessageTypeOverriderImpl();
        putStaticServiceImplCache("com.obric.assistant.spi.chat.IReceiveStreamMessageTypeOverrider", r608);
        return r608;
    L2462:
        if (r3.getName().equals("com.larus.bmhome.chat.input.IChatInputService") == false) goto L3605;
        T r609 = (T) new ChatInputServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.chat.input.IChatInputService", r609);
        return r609;
    L2466:
        if (r3.getName().equals("com.larus.common.mssdk.api.SecurityService") == false) goto L3605;
        T r610 = (T) new SecurityServiceImpl();
        putStaticServiceImplCache("com.larus.common.mssdk.api.SecurityService", r610);
        return r610;
    L2470:
        if (r3.getName().equals("com.larus.extension.aggregate_search_ui.api.IAggregateSearchUiService") == false) goto L3605;
        T r611 = (T) new AggregateSearchUiServiceImpl();
        putStaticServiceImplCache("com.larus.extension.aggregate_search_ui.api.IAggregateSearchUiService", r611);
        return r611;
    L2474:
        if (r3.getName().equals("com.obric.assistant.interaction.api.IKeyguardState") == false) goto L3605;
        T r612 = (T) new KeyguardStateImpl();
        putStaticServiceImplCache("com.obric.assistant.interaction.api.IKeyguardState", r612);
        return r612;
    L2478:
        if (r3.getName().equals("com.larus.office.base.export.IOfficeSheetExportDelegate") == false) goto L3605;
        T r613 = (T) new OfficeSheetExportDelegateImpl();
        putStaticServiceImplCache("com.larus.office.base.export.IOfficeSheetExportDelegate", r613);
        return r613;
    L2482:
        if (r3.getName().equals("com.larus.bmhome.instruction.IInstructionUtilsService") == false) goto L3605;
        T r614 = (T) new InstructionUtilsService();
        putStaticServiceImplCache("com.larus.bmhome.instruction.IInstructionUtilsService", r614);
        return r614;
    L2486:
        if (r3.getName().equals("com.obric.aiagent.assistant.idl.IFlowFeedbackIDLSPI") == false) goto L3605;
        T r615 = (T) new FlowFeedbackIDLStub();
        putStaticServiceImplCache("com.obric.aiagent.assistant.idl.IFlowFeedbackIDLSPI", r615);
        return r615;
    L2490:
        if (r3.getName().equals("com.obric.assistant.spi.keyguard.IKeyguardService") == false) goto L3605;
        T r616 = (T) new ObricKeyguardServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.spi.keyguard.IKeyguardService", r616);
        return r616;
    L2494:
        if (r3.getName().equals("com.larus.platform.audit.IFlowBehaviorAuditService") == false) goto L3605;
        T r617 = (T) new FlowBehaviorAuditServiceImpl();
        putStaticServiceImplCache("com.larus.platform.audit.IFlowBehaviorAuditService", r617);
        return r617;
    L2498:
        if (r3.getName().equals("com.obric.aiagent.platform.IAIAgentPlatform") == false) goto L3605;
        T r618 = (T) new ObricAIAgentPlatformImpl();
        putStaticServiceImplCache("com.obric.aiagent.platform.IAIAgentPlatform", r618);
        return r618;
    L2502:
        if (r3.getName().equals("com.obric.assistant.audio.service.IAssistantTextModeService") == false) goto L3605;
        T r619 = (T) new AssistantTextModeService();
        putStaticServiceImplCache("com.obric.assistant.audio.service.IAssistantTextModeService", r619);
        return r619;
    L2506:
        if (r3.getName().equals("com.obric.assistant.session.model.ISessionMaintaining") == false) goto L3605;
        T r620 = (T) new SessionMaintainer();
        putStaticServiceImplCache("com.obric.assistant.session.model.ISessionMaintaining", r620);
        return r620;
    L2510:
        if (r3.getName().equals("com.larus.bmhome.chat.require.IMainBotService") == false) goto L3605;
        T r621 = (T) new MainBotServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.chat.require.IMainBotService", r621);
        return r621;
    L2514:
        if (r3.getName().equals("com.larus.account.base.api.ILoginService") == false) goto L3605;
        T r622 = (T) new LoginServiceImpl();
        putStaticServiceImplCache("com.larus.account.base.api.ILoginService", r622);
        return r622;
    L2518:
        if (r3.getName().equals("com.larus.flowsdk.common.experiment.IFlowClientExperimentRegistry") == false) goto L3605;
        T r623 = (T) new FlowSDKBusinessModulesInputImplFlowClientExperimentRegistry();
        putStaticServiceImplCache("com.larus.flowsdk.common.experiment.IFlowClientExperimentRegistry", r623);
        return r623;
    L2522:
        if (r3.getName().equals("com.larus.bmhome.chat.trace.api.IChatImTraceService") == false) goto L3605;
        T r624 = (T) new ChatImTraceServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.chat.trace.api.IChatImTraceService", r624);
        return r624;
    L2526:
        if (r3.getName().equals("com.larus.apm.api.IExtraParams") == false) goto L3605;
        T r625 = (T) new ExtraParamsImpl();
        putStaticServiceImplCache("com.larus.apm.api.IExtraParams", r625);
        return r625;
    L2530:
        if (r3.getName().equals("com.larus.chat.gallery.api.IChatGalleryService") == false) goto L3605;
        T r626 = (T) new ChatGalleryServiceImpl();
        putStaticServiceImplCache("com.larus.chat.gallery.api.IChatGalleryService", r626);
        return r626;
    L2534:
        if (r3.getName().equals("com.larus.im.IInstantMessenger") == false) goto L3605;
        T r627 = (T) new InstantMessengerImpl();
        putStaticServiceImplCache("com.larus.im.IInstantMessenger", r627);
        return r627;
    L2538:
        if (r3.getName().equals("com.larus.platform.api.ILarkConnectorArtifactService") == false) goto L3605;
        T r628 = (T) new LarkConnectorArtifactServiceImpl();
        putStaticServiceImplCache("com.larus.platform.api.ILarkConnectorArtifactService", r628);
        return r628;
    L2542:
        if (r3.getName().equals("com.larus.pipo.pay.api.IPipoPayService") == false) goto L3605;
        T r629 = (T) new PipoPayServiceImpl();
        putStaticServiceImplCache("com.larus.pipo.pay.api.IPipoPayService", r629);
        return r629;
    L2546:
        if (r3.getName().equals("com.larus.office.card.doc.create.IOfficeCardDocCreateService") == false) goto L3605;
        T r630 = (T) new OfficeCardDocCreateServiceImpl();
        putStaticServiceImplCache("com.larus.office.card.doc.create.IOfficeCardDocCreateService", r630);
        return r630;
    L2550:
        if (r3.getName().equals("com.bytedance.android.bcm.api.provider.IBcmExtraCheckerProvider") == false) goto L3605;
        return (T) new BcmExtraCheckerProviderImpl();
    L2554:
        if (r3.getName().equals("com.larus.account.saas.coreapi.IAccountDispatchService") == false) goto L3605;
        T r631 = (T) new AccountDispatchService();
        putStaticServiceImplCache("com.larus.account.saas.coreapi.IAccountDispatchService", r631);
        return r631;
    L2558:
        if (r3.getName().equals("com.obric.assistant.spi.wakeup.IWakeupLatencyTrackService") == false) goto L3605;
        T r632 = (T) new WakeupLatencyTrackImpl();
        putStaticServiceImplCache("com.obric.assistant.spi.wakeup.IWakeupLatencyTrackService", r632);
        return r632;
    L2562:
        if (r3.getName().equals("com.larus.receive.contract.IReceiveCustomDiff") == false) goto L3605;
        T r633 = (T) new ObricReceiveCustomDiffImpl();
        putStaticServiceImplCache("com.larus.receive.contract.IReceiveCustomDiff", r633);
        return r633;
    L2566:
        if (r3.getName().equals("com.larus.sheet.api.ISheetService") == false) goto L3605;
        T r634 = (T) new SheetServiceImpl();
        putStaticServiceImplCache("com.larus.sheet.api.ISheetService", r634);
        return r634;
    L2570:
        if (r3.getName().equals("com.obric.assistant.state.api.multitask.IObricInteractionProjectionService") == false) goto L3605;
        T r635 = (T) new InteractionProjectionServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.state.api.multitask.IObricInteractionProjectionService", r635);
        return r635;
    L2574:
        if (r3.getName().equals("com.larus.bitable.api.IBitableService") == false) goto L3605;
        T r636 = (T) new BitableServiceImpl();
        putStaticServiceImplCache("com.larus.bitable.api.IBitableService", r636);
        return r636;
    L2578:
        if (r3.getName().equals("com.larus.community.api.ICommunityService") == false) goto L3605;
        T r637 = (T) new CreationServiceImpl();
        putStaticServiceImplCache("com.larus.community.api.ICommunityService", r637);
        return r637;
    L2582:
        if (r3.getName().equals("com.obric.assistant.spi.audio.IObricBackTraceLogService") == false) goto L3605;
        T r638 = (T) new ObricBackTraceLogServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.spi.audio.IObricBackTraceLogService", r638);
        return r638;
    L2586:
        if (r3.getName().equals("com.larus.bmhome.community.ICreationPageService") == false) goto L3605;
        T r639 = (T) new CreationPageService();
        putStaticServiceImplCache("com.larus.bmhome.community.ICreationPageService", r639);
        return r639;
    L2590:
        if (r3.getName().equals("com.larus.bmhome.chat.api.IAppreciableTraceService") == false) goto L3605;
        T r640 = (T) new AppreciableTraceService();
        putStaticServiceImplCache("com.larus.bmhome.chat.api.IAppreciableTraceService", r640);
        return r640;
    L2594:
        if (r3.getName().equals("com.obric.assistant.chat.IQueryAuthenticationService") == false) goto L3605;
        T r641 = (T) new QueryAuthenticationServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.chat.IQueryAuthenticationService", r641);
        return r641;
    L2598:
        if (r3.getName().equals("com.bytedance.android.marketing.sdk.api.IMarketingBridgeService") == false) goto L3605;
        T r642 = (T) new MarketingBridgeServiceImpl();
        putStaticServiceImplCache("com.bytedance.android.marketing.sdk.api.IMarketingBridgeService", r642);
        return r642;
    L2602:
        if (r3.getName().equals("com.larus.platform.model.comment.ICommentService") == false) goto L3605;
        T r643 = (T) new CommentServiceImpl();
        putStaticServiceImplCache("com.larus.platform.model.comment.ICommentService", r643);
        return r643;
    L2606:
        if (r3.getName().equals("com.obric.assistant.frontier.IObricFrontierStatusMonitorService") == false) goto L3605;
        T r644 = (T) new ObricFrontierStatusMonitorService();
        putStaticServiceImplCache("com.obric.assistant.frontier.IObricFrontierStatusMonitorService", r644);
        return r644;
    L2610:
        if (r3.getName().equals("com.larus.bmhome.chat.reddot.IConversationRedDotService") == false) goto L3605;
        T r645 = (T) new ConversationRedDotServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.chat.reddot.IConversationRedDotService", r645);
        return r645;
    L2614:
        if (r3.getName().equals("com.larus.bmhome.taskskill.service.ISkillService") == false) goto L3605;
        T r646 = (T) new SkillServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.taskskill.service.ISkillService", r646);
        return r646;
    L2618:
        if (r3.getName().equals("com.larus.bmhome.resource.access.ResourceUploadSceneResolver") == false) goto L3605;
        T r647 = (T) new CreationUploadSceneResolver();
        putStaticServiceImplCache("com.larus.bmhome.resource.access.ResourceUploadSceneResolver", r647);
        return r647;
    L2622:
        if (r3.getName().equals("com.larus.platform.service.IOfficePlatformService") == false) goto L3605;
        T r648 = (T) new OfficePlatformServiceImpl();
        putStaticServiceImplCache("com.larus.platform.service.IOfficePlatformService", r648);
        return r648;
    L2626:
        if (r3.getName().equals("com.obric.assistant.audio.service.IManualHalfDuplexModeService") == false) goto L3605;
        T r649 = (T) new ManualHalfDuplexModeService();
        putStaticServiceImplCache("com.obric.assistant.audio.service.IManualHalfDuplexModeService", r649);
        return r649;
    L2630:
        if (r3.getName().equals("com.larus.dora.api.IDoraService") == false) goto L3605;
        T r650 = (T) new DoraServiceImpl();
        putStaticServiceImplCache("com.larus.dora.api.IDoraService", r650);
        return r650;
    L2634:
        if (r3.getName().equals("com.obric.assistant.common.spi.settings.IObricSettingRequestService") == false) goto L3605;
        T r651 = (T) new ObricRequestSettingsServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.common.spi.settings.IObricSettingRequestService", r651);
        return r651;
    L2638:
        if (r3.getName().equals("com.larus.bmhome.chat.dora.IChatDoraService") == false) goto L3605;
        T r652 = (T) new ChatDoraServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.chat.dora.IChatDoraService", r652);
        return r652;
    L2642:
        if (r3.getName().equals("com.obric.assistant.spi.router.IObricRouterService") == false) goto L3605;
        T r653 = (T) new ObricRouterServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.spi.router.IObricRouterService", r653);
        return r653;
    L2646:
        if (r3.getName().equals("com.larus.account.saas.ui.IAccountCommonAlertUiService") == false) goto L3605;
        T r654 = (T) new DefaultAccountCommonAlertUiService();
        putStaticServiceImplCache("com.larus.account.saas.ui.IAccountCommonAlertUiService", r654);
        return r654;
    L2650:
        if (r3.getName().equals("com.bytedance.timon.clipboard.suite.ITMClipboardSuiteInitService") == false) goto L3605;
        T r655 = (T) new ClipboardSuiteInitServiceImpl();
        putStaticServiceImplCache("com.bytedance.timon.clipboard.suite.ITMClipboardSuiteInitService", r655);
        return r655;
    L2654:
        if (r3.getName().equals("com.bytedance.locallife.ILocalLifeService") == false) goto L3605;
        T r656 = (T) new LocalLifeServiceImpl();
        putStaticServiceImplCache("com.bytedance.locallife.ILocalLifeService", r656);
        return r656;
    L2658:
        if (r3.getName().equals("com.larus.contextwindow.api.IContextWindowUsageService") == false) goto L3605;
        T r657 = (T) new ContextWindowUsageServiceImpl();
        putStaticServiceImplCache("com.larus.contextwindow.api.IContextWindowUsageService", r657);
        return r657;
    L2662:
        if (r3.getName().equals("com.larus.uaigc.creation.ICreationService") == false) goto L3605;
        T r658 = (T) new com.larus.uaigc.createpage.CreationServiceImpl();
        putStaticServiceImplCache("com.larus.uaigc.creation.ICreationService", r658);
        return r658;
    L2666:
        if (r3.getName().equals("com.larus.uaigc.applet.IMusicAppletHostService") == false) goto L3605;
        T r659 = (T) new MusicAppletHostServiceImpl();
        putStaticServiceImplCache("com.larus.uaigc.applet.IMusicAppletHostService", r659);
        return r659;
    L2670:
        if (r3.getName().equals("com.obric.assistant.performance.IObricCrashDumpHprofService") == false) goto L3605;
        T r660 = (T) new ObricCrashDumpHprofServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.performance.IObricCrashDumpHprofService", r660);
        return r660;
    L2674:
        if (r3.getName().equals("com.obric.assistant.common.spi.IObricContextService") == false) goto L3605;
        T r661 = (T) new ObricContextServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.common.spi.IObricContextService", r661);
        return r661;
    L2678:
        if (r3.getName().equals("com.bytedance.bmf_mods_api.AdaptiveGradingAPI") == false) goto L3605;
        return (T) new AdaptiveGrading();
    L2682:
        if (r3.getName().equals("com.larus.enterprise.api.IEnterpriseWhiteListService") == false) goto L3605;
        T r662 = (T) new EnterpriseWhiteListServiceImpl();
        putStaticServiceImplCache("com.larus.enterprise.api.IEnterpriseWhiteListService", r662);
        return r662;
    L2686:
        if (r3.getName().equals("com.larus.bmhome.chat.api.ITtsPlayInterceptor") == false) goto L3605;
        T r663 = (T) new TtsSilentInterceptor();
        putStaticServiceImplCache("com.larus.bmhome.chat.api.ITtsPlayInterceptor", r663);
        return r663;
    L2690:
        if (r3.getName().equals("com.larus.bmhome.instruction.IInstructionCreator") == false) goto L3605;
        T r664 = (T) new TabSelectorCreator();
        putStaticServiceImplCache("com.larus.bmhome.instruction.IInstructionCreator", r664);
        return r664;
    L2694:
        if (r3.getName().equals("com.larus.camera.contract.ICameraServiceDiff") == false) goto L3605;
        T r665 = (T) new ObricCameraServiceDiffImpl();
        putStaticServiceImplCache("com.larus.camera.contract.ICameraServiceDiff", r665);
        return r665;
    L2698:
        if (r3.getName().equals("com.larus.voicecall.api.IVoiceCallRouterService") == false) goto L3605;
        T r666 = (T) new VoiceCallRouterServiceImpl();
        putStaticServiceImplCache("com.larus.voicecall.api.IVoiceCallRouterService", r666);
        return r666;
    L2702:
        if (r3.getName().equals("com.larus.platform.api.ISdkVideoFeedService") == false) goto L3605;
        T r667 = (T) new SdkVideoFeedProvider();
        putStaticServiceImplCache("com.larus.platform.api.ISdkVideoFeedService", r667);
        return r667;
    L2706:
        if (r3.getName().equals("com.larus.uaigc.service.ICreationDetailImageEditService") == false) goto L3605;
        T r668 = (T) new CreationDetailImageEditServiceImpl();
        putStaticServiceImplCache("com.larus.uaigc.service.ICreationDetailImageEditService", r668);
        return r668;
    L2710:
        if (r3.getName().equals("com.larus.aweme.api.video.service.IAwemeVideoFeedService") == false) goto L3605;
        T r669 = (T) new AwemeVideoFeed();
        putStaticServiceImplCache("com.larus.aweme.api.video.service.IAwemeVideoFeedService", r669);
        return r669;
    L2714:
        if (r3.getName().equals("com.obric.assistant.system.IDeviceLockedStateService") == false) goto L3605;
        T r670 = (T) new DeviceLockedStateServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.system.IDeviceLockedStateService", r670);
        return r670;
    L2718:
        if (r3.getName().equals("com.obric.audio.enroll.IVoiceEnrollService") == false) goto L3605;
        T r671 = (T) new com.obric.audio.enroll.VoiceEnrollServiceImpl();
        putStaticServiceImplCache("com.obric.audio.enroll.IVoiceEnrollService", r671);
        return r671;
    L2722:
        if (r3.getName().equals("com.larus.common.pollingconfig.api.PollingConfigApi") == false) goto L3605;
        T r672 = (T) new PollingConfigImpl();
        putStaticServiceImplCache("com.larus.common.pollingconfig.api.PollingConfigApi", r672);
        return r672;
    L2726:
        if (r3.getName().equals("com.obric.assistant.reporter.IObricReporter") == false) goto L3605;
        T r673 = (T) new ObricReporterImpl();
        putStaticServiceImplCache("com.obric.assistant.reporter.IObricReporter", r673);
        return r673;
    L2730:
        if (r3.getName().equals("com.larus.account.saas.coreapi.IAccountInitManager") == false) goto L3605;
        T r674 = (T) new AccountInitManager();
        putStaticServiceImplCache("com.larus.account.saas.coreapi.IAccountInitManager", r674);
        return r674;
    L2734:
        if (r3.getName().equals("com.larus.platform.api.IBtmHostDependency") == false) goto L3605;
        T r675 = (T) new DoubaoBtmHostDependency();
        putStaticServiceImplCache("com.larus.platform.api.IBtmHostDependency", r675);
        return r675;
    L2738:
        if (r3.getName().equals("com.larus.business.debug.api.NmtInjectService") == false) goto L3605;
        T r676 = (T) new NmtInjectServiceImpl();
        putStaticServiceImplCache("com.larus.business.debug.api.NmtInjectService", r676);
        return r676;
    L2742:
        if (r3.getName().equals("com.obric.assistant.system.ITaskStackService") == false) goto L3605;
        T r677 = (T) new TaskStackServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.system.ITaskStackService", r677);
        return r677;
    L2746:
        if (r3.getName().equals("com.larus.uaigc.service.ICreationWorkflowService") == false) goto L3605;
        T r678 = (T) new CreationWorkflowServiceImpl();
        putStaticServiceImplCache("com.larus.uaigc.service.ICreationWorkflowService", r678);
        return r678;
    L2750:
        if (r3.getName().equals("com.obric.assistant.spi.account.IObricXttTokenSyncService") == false) goto L3605;
        T r679 = (T) new ObricXttTokenSyncServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.spi.account.IObricXttTokenSyncService", r679);
        return r679;
    L2754:
        if (r3.getName().equals("com.obric.assistant.settings.IObricAutoBlacklistSettingsNotifier") == false) goto L3605;
        T r680 = (T) new ObricAutoGuiSettingsImpl();
        putStaticServiceImplCache("com.obric.assistant.settings.IObricAutoBlacklistSettingsNotifier", r680);
        return r680;
    L2758:
        if (r3.getName().equals("com.larus.bmhome.collection.ICollectionReport") == false) goto L3605;
        T r681 = (T) new CollectionEventHelper();
        putStaticServiceImplCache("com.larus.bmhome.collection.ICollectionReport", r681);
        return r681;
    L2762:
        if (r3.getName().equals("com.larus.agents.api.ILocalWebFetchService") == false) goto L3605;
        T r682 = (T) new LocalWebFetchServiceImpl();
        putStaticServiceImplCache("com.larus.agents.api.ILocalWebFetchService", r682);
        return r682;
    L2766:
        if (r3.getName().equals("com.obric.aiagent.assistant.idl.IFlowIDLSPI") == false) goto L3605;
        T r683 = (T) new FlowIDLSPIImpl();
        putStaticServiceImplCache("com.obric.aiagent.assistant.idl.IFlowIDLSPI", r683);
        return r683;
    L2770:
        if (r3.getName().equals("com.larus.enterprise.api.IEnterpriseService") == false) goto L3605;
        T r684 = (T) new EnterpriseServiceImpl();
        putStaticServiceImplCache("com.larus.enterprise.api.IEnterpriseService", r684);
        return r684;
    L2774:
        if (r3.getName().equals("com.larus.account.base.provider.agegate.IAgeGateDialogProvider") == false) goto L3605;
        T r685 = (T) new AccountAgeGateDialogProvider();
        putStaticServiceImplCache("com.larus.account.base.provider.agegate.IAgeGateDialogProvider", r685);
        return r685;
    L2778:
        if (r3.getName().equals("com.bytedance.android.shopping.api.mall.IECMallPerformanceService") == false) goto L3605;
        T r686 = (T) new ECMallPerformanceService();
        putStaticServiceImplCache("com.bytedance.android.shopping.api.mall.IECMallPerformanceService", r686);
        return r686;
    L2782:
        if (r3.getName().equals("com.obric.assistant.spi.actionbar.IObricActionBarSendService") == false) goto L3605;
        T r687 = (T) new ObricActionBarSendServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.spi.actionbar.IObricActionBarSendService", r687);
        return r687;
    L2786:
        if (r3.getName().equals("com.larus.bmhome.chat.setting.IUserSettingCacheService") == false) goto L3605;
        T r688 = (T) new UserSettingCacheImpl();
        putStaticServiceImplCache("com.larus.bmhome.chat.setting.IUserSettingCacheService", r688);
        return r688;
    L2790:
        if (r3.getName().equals("com.larus.bootprotector.IBootProtectorBizCallback") == false) goto L3605;
        T r689 = (T) new BootProtectorDefaultBizCallback();
        putStaticServiceImplCache("com.larus.bootprotector.IBootProtectorBizCallback", r689);
        return r689;
    L2794:
        if (r3.getName().equals("com.larus.bmhome.share.api.IShareService") == false) goto L3605;
        T r690 = (T) new ShareImpl();
        putStaticServiceImplCache("com.larus.bmhome.share.api.IShareService", r690);
        return r690;
    L2798:
        if (r3.getName().equals("com.bytedance.android.marketing.sdk.api.IMarketingServiceV2") == false) goto L3605;
        T r691 = (T) new MarketingServiceImplV2();
        putStaticServiceImplCache("com.bytedance.android.marketing.sdk.api.IMarketingServiceV2", r691);
        return r691;
    L2802:
        if (r3.getName().equals("com.obric.assistant.login.ILoginState") == false) goto L3605;
        T r692 = (T) new LoginStateImpl();
        putStaticServiceImplCache("com.obric.assistant.login.ILoginState", r692);
        return r692;
    L2806:
        if (r3.getName().equals("com.larus.mainbot.api.IFlowMainBot") == false) goto L3605;
        T r693 = (T) new FlowMainBotImpl();
        putStaticServiceImplCache("com.larus.mainbot.api.IFlowMainBot", r693);
        return r693;
    L2810:
        if (r3.getName().equals("com.larus.launch.ILaunchService") == false) goto L3605;
        T r694 = (T) new LaunchImpl();
        putStaticServiceImplCache("com.larus.launch.ILaunchService", r694);
        return r694;
    L2814:
        if (r3.getName().equals("com.larus.camera.api.IInputServiceProvider") == false) goto L3605;
        T r695 = (T) new InputServiceProviderImpl();
        putStaticServiceImplCache("com.larus.camera.api.IInputServiceProvider", r695);
        return r695;
    L2818:
        if (r3.getName().equals("com.larus.bmhome.interactionpanel.IInteractionPanelSidebarService") == false) goto L3605;
        T r696 = (T) new InteractionPanelSidebarServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.interactionpanel.IInteractionPanelSidebarService", r696);
        return r696;
    L2822:
        if (r3.getName().equals("com.larus.uaigc.applet.IMusicAppletPageProvider") == false) goto L3605;
        T r697 = (T) new MusicAppletPageProviderImpl();
        putStaticServiceImplCache("com.larus.uaigc.applet.IMusicAppletPageProvider", r697);
        return r697;
    L2826:
        if (r3.getName().equals("com.bytedance.flow.search.kmp.api.spi.SearchActionHandlerService") == false) goto L3605;
        T r698 = (T) new KmpContactSearchActionHandlerServiceImpl();
        putStaticServiceImplCache("com.bytedance.flow.search.kmp.api.spi.SearchActionHandlerService", r698);
        return r698;
    L2830:
        if (r3.getName().equals("com.obric.assistant.session.model.IOAutoOperation") == false) goto L3605;
        T r699 = (T) new OAutoEndPoint();
        putStaticServiceImplCache("com.obric.assistant.session.model.IOAutoOperation", r699);
        return r699;
    L2834:
        if (r3.getName().equals("com.larus.login.api.ITouristApi") == false) goto L3605;
        T r700 = (T) new TouristServiceImpl();
        putStaticServiceImplCache("com.larus.login.api.ITouristApi", r700);
        return r700;
    L2838:
        if (r3.getName().equals("com.larus.bmhome.chat.nita.IChatNitaPreloadService") == false) goto L3605;
        T r701 = (T) new ChatNitaPreloadServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.chat.nita.IChatNitaPreloadService", r701);
        return r701;
    L2842:
        if (r3.getName().equals("com.larus.platform.api.IECommerceProductCardPreloadService") == false) goto L3605;
        T r702 = (T) new ECommerceProductCardPreloadService();
        putStaticServiceImplCache("com.larus.platform.api.IECommerceProductCardPreloadService", r702);
        return r702;
    L2846:
        if (r3.getName().equals("com.larus.audioplayer.api.music.IMusicPlayManager") == false) goto L3605;
        T r703 = (T) new MusicPlayManagerService();
        putStaticServiceImplCache("com.larus.audioplayer.api.music.IMusicPlayManager", r703);
        return r703;
    L2850:
        if (r3.getName().equals("com.obric.assistant.special_input.ISpecialInputTask") == false) goto L3605;
        T r704 = (T) new SpecialInputTaskImpl();
        putStaticServiceImplCache("com.obric.assistant.special_input.ISpecialInputTask", r704);
        return r704;
    L2854:
        if (r3.getName().equals("com.larus.doc.sdk.api.IDocSdkBaseService") == false) goto L3605;
        T r705 = (T) new DocSdkBaseServiceImpl();
        putStaticServiceImplCache("com.larus.doc.sdk.api.IDocSdkBaseService", r705);
        return r705;
    L2858:
        if (r3.getName().equals("com.larus.reach.api.ReachSceneInterceptor") == false) goto L3605;
        T r706 = (T) new NotificationSwitchBubbleBannerSourceListener();
        putStaticServiceImplCache("com.larus.reach.api.ReachSceneInterceptor", r706);
        return r706;
    L2862:
        if (r3.getName().equals("com.larus.voicecall.api.IVoiceCallService") == false) goto L3605;
        T r707 = (T) new IVoiceCallServiceImpl();
        putStaticServiceImplCache("com.larus.voicecall.api.IVoiceCallService", r707);
        return r707;
    L2866:
        if (r3.getName().equals("com.larus.bitable.sdk.api.IBitableSdkService") == false) goto L3605;
        T r708 = (T) new BitableSdkServiceImpl();
        putStaticServiceImplCache("com.larus.bitable.sdk.api.IBitableSdkService", r708);
        return r708;
    L2870:
        if (r3.getName().equals("com.larus.receive.api.IReceiveIntentService") == false) goto L3605;
        T r709 = (T) new ReceiveIntentServiceImpl();
        putStaticServiceImplCache("com.larus.receive.api.IReceiveIntentService", r709);
        return r709;
    L2874:
        if (r3.getName().equals("com.larus.camera.api.IFlowCamera") == false) goto L3605;
        T r710 = (T) new FlowCameraImpl();
        putStaticServiceImplCache("com.larus.camera.api.IFlowCamera", r710);
        return r710;
    L2878:
        if (r3.getName().equals("com.larus.account.base.api.IAccountService") == false) goto L3605;
        T r711 = (T) new AccountServiceImpl();
        putStaticServiceImplCache("com.larus.account.base.api.IAccountService", r711);
        return r711;
    L2882:
        if (r3.getName().equals("com.larus.bmhome.web.IAiChatHostWebService") == false) goto L3605;
        T r712 = (T) new AiChatHostWebServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.web.IAiChatHostWebService", r712);
        return r712;
    L2886:
        if (r3.getName().equals("com.obric.assistant.zeus.plugin.IObricMigrationHandler") == false) goto L3605;
        T r713 = (T) new ObricMigrationHandlerImpl();
        putStaticServiceImplCache("com.obric.assistant.zeus.plugin.IObricMigrationHandler", r713);
        return r713;
    L2890:
        if (r3.getName().equals("com.obric.assistant.interaction.api.keyguard.IKeyguardBiometricSetting") == false) goto L3605;
        T r714 = (T) new KeyguardBiometricSettingImpl();
        putStaticServiceImplCache("com.obric.assistant.interaction.api.keyguard.IKeyguardBiometricSetting", r714);
        return r714;
    L2894:
        if (r3.getName().equals("com.larus.bmhome.chat.bubble.floating.report.IBannerShowReportService") == false) goto L3605;
        T r715 = (T) new BannerShowReportServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.chat.bubble.floating.report.IBannerShowReportService", r715);
        return r715;
    L2898:
        if (r3.getName().equals("com.larus.bmhome.nestedfile.INestFileService") == false) goto L3605;
        T r716 = (T) new NestFileServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.nestedfile.INestFileService", r716);
        return r716;
    L2902:
        if (r3.getName().equals("com.obric.assistant.spi.app.IObricAppService") == false) goto L3605;
        T r717 = (T) new ObricAppServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.spi.app.IObricAppService", r717);
        return r717;
    L2906:
        if (r3.getName().equals("com.bytedance.android.livesdkapi.bytecast.ILiveByteCastService") == false) goto L3605;
        T r718 = (T) new LiveByteCastService();
        putStaticServiceImplCache("com.bytedance.android.livesdkapi.bytecast.ILiveByteCastService", r718);
        return r718;
    L2910:
        if (r3.getName().equals("com.larus.drive.sdk.api.IDriveSdkGenericService") == false) goto L3605;
        T r719 = (T) new DriveSdkGenericServiceImpl();
        putStaticServiceImplCache("com.larus.drive.sdk.api.IDriveSdkGenericService", r719);
        return r719;
    L2914:
        if (r3.getName().equals("com.larus.photopicker.api.PhotoPicker") == false) goto L3605;
        T r720 = (T) new PhotoPickerImpl();
        putStaticServiceImplCache("com.larus.photopicker.api.PhotoPicker", r720);
        return r720;
    L2918:
        if (r3.getName().equals("com.larus.bmhome.code.IAiChatCodePreviewService") == false) goto L3605;
        T r721 = (T) new AiChatCodePreviewServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.code.IAiChatCodePreviewService", r721);
        return r721;
    L2922:
        if (r3.getName().equals("com.larus.bmhome.taskskill.service.IProjectCreatePanelService") == false) goto L3605;
        T r722 = (T) new ProjectCreatePanelServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.taskskill.service.IProjectCreatePanelService", r722);
        return r722;
    L2926:
        if (r3.getName().equals("com.obric.assistant.IClearContextInKeyguardService") == false) goto L3605;
        T r723 = (T) new ClearContextInKeyguardServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.IClearContextInKeyguardService", r723);
        return r723;
    L2930:
        if (r3.getName().equals("com.larus.platform.api.IFlowChatThemeConfigProvider") == false) goto L3605;
        T r724 = (T) new FlowChatThemeConfigProvider();
        putStaticServiceImplCache("com.larus.platform.api.IFlowChatThemeConfigProvider", r724);
        return r724;
    L2934:
        if (r3.getName().equals("com.bytedance.bmf_mods_api.VideoOCLSRAPI") == false) goto L3605;
        T r725 = (T) new VideoOCLSR();
        putStaticServiceImplCache("com.bytedance.bmf_mods_api.VideoOCLSRAPI", r725);
        return r725;
    L2938:
        if (r3.getName().equals("com.larus.office.base.service.ISdkLifecycleV2") == false) goto L3605;
        T r726 = (T) new DriveLifecycleAdapter();
        putStaticServiceImplCache("com.larus.office.base.service.ISdkLifecycleV2", r726);
        return r726;
    L2942:
        if (r3.getName().equals("com.bytedance.android.marketing.sdk.api.IMarketingService") == false) goto L3605;
        T r727 = (T) new MarketingServiceImpl();
        putStaticServiceImplCache("com.bytedance.android.marketing.sdk.api.IMarketingService", r727);
        return r727;
    L2946:
        if (r3.getName().equals("com.obric.assistant.spi.essentialtask.IObricEssentialTaskService") == false) goto L3605;
        T r728 = (T) new ObricEssentialTaskServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.spi.essentialtask.IObricEssentialTaskService", r728);
        return r728;
    L2950:
        if (r3.getName().equals("com.larus.account.base.api.IMultiAccountService") == false) goto L3605;
        T r729 = (T) new MultiAccountServiceImpl();
        putStaticServiceImplCache("com.larus.account.base.api.IMultiAccountService", r729);
        return r729;
    L2954:
        if (r3.getName().equals("com.larus.permission.api.IPermissionX") == false) goto L3605;
        T r730 = (T) new IPermissionXImpl();
        putStaticServiceImplCache("com.larus.permission.api.IPermissionX", r730);
        return r730;
    L2958:
        if (r3.getName().equals("com.larus.bmhome.utils.IVideoShareService") == false) goto L3605;
        T r731 = (T) new VideoShareService();
        putStaticServiceImplCache("com.larus.bmhome.utils.IVideoShareService", r731);
        return r731;
    L2962:
        if (r3.getName().equals("com.larus.platform.api.IXBridgeEventSender") == false) goto L3605;
        T r732 = (T) new XBridgeEventSender();
        putStaticServiceImplCache("com.larus.platform.api.IXBridgeEventSender", r732);
        return r732;
    L2966:
        if (r3.getName().equals("com.fackbook.imagepipeline.IImagePipelineOutService") == false) goto L3605;
        T r733 = (T) new ImagePipelineOutService();
        putStaticServiceImplCache("com.fackbook.imagepipeline.IImagePipelineOutService", r733);
        return r733;
    L2970:
        if (r3.getName().equals("com.larus.account.base.provider.IOfficeSDKLgwHeaderProvider") == false) goto L3605;
        T r734 = (T) new OfficeSDKLgwHeaderProvider();
        putStaticServiceImplCache("com.larus.account.base.provider.IOfficeSDKLgwHeaderProvider", r734);
        return r734;
    L2974:
        if (r3.getName().equals("com.obric.assistant.applet.IObricAppletService") == false) goto L3605;
        T r735 = (T) new ObricAppletServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.applet.IObricAppletService", r735);
        return r735;
    L2978:
        if (r3.getName().equals("com.larus.bmhome.chat.doclink.IMessageDocPreviewService") == false) goto L3605;
        T r736 = (T) new MessageDocPreviewServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.chat.doclink.IMessageDocPreviewService", r736);
        return r736;
    L2982:
        if (r3.getName().equals("com.obric.assistant.special_input.IObricSpecialInputService") == false) goto L3605;
        T r737 = (T) new ObricSpecialInputServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.special_input.IObricSpecialInputService", r737);
        return r737;
    L2986:
        if (r3.getName().equals("com.obric.assistant.interaction.api.window.IBehavior") == false) goto L3605;
        T r738 = (T) new RemoveTopChatActivityBehavior();
        putStaticServiceImplCache("com.obric.assistant.interaction.api.window.IBehavior", r738);
        return r738;
    L2990:
        if (r3.getName().equals("com.larus.bmhome.chat.messagetransfer.IDoubaoToLarkForwardLimitService") == false) goto L3605;
        T r739 = (T) new DoubaoToLarkForwardLimitServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.chat.messagetransfer.IDoubaoToLarkForwardLimitService", r739);
        return r739;
    L2994:
        if (r3.getName().equals("com.larus.praise.IPraiseService") == false) goto L3605;
        T r740 = (T) new PraiseServiceImpl();
        putStaticServiceImplCache("com.larus.praise.IPraiseService", r740);
        return r740;
    L2998:
        if (r3.getName().equals("com.larus.audio.IAudioService") == false) goto L3605;
        T r741 = (T) new AudioServiceImpl();
        putStaticServiceImplCache("com.larus.audio.IAudioService", r741);
        return r741;
    L3002:
        if (r3.getName().equals("com.obric.assistant.settings.IAILabService") == false) goto L3605;
        T r742 = (T) new AILabServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.settings.IAILabService", r742);
        return r742;
    L3006:
        if (r3.getName().equals("com.obric.assistant.spi.dora.IObricDoraService") == false) goto L3605;
        T r743 = (T) new ObricDoraServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.spi.dora.IObricDoraService", r743);
        return r743;
    L3010:
        if (r3.getName().equals("com.obric.assistant.IObricPackageSignatureCacheService") == false) goto L3605;
        T r744 = (T) new ObricPackageSignatureCacheServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.IObricPackageSignatureCacheService", r744);
        return r744;
    L3014:
        if (r3.getName().equals("com.larus.common.zlinksdk.api.IZlinkService") == false) goto L3605;
        T r745 = (T) new ZlinkServiceImpl();
        putStaticServiceImplCache("com.larus.common.zlinksdk.api.IZlinkService", r745);
        return r745;
    L3018:
        if (r3.getName().equals("com.larus.ivykit.anniex.IContainerRedirectService") == false) goto L3605;
        T r746 = (T) new ContainerRedirectServiceImpl();
        putStaticServiceImplCache("com.larus.ivykit.anniex.IContainerRedirectService", r746);
        return r746;
    L3022:
        if (r3.getName().equals("com.larus.bmhome.chat.api.require.IPostLaunchInfoService") == false) goto L3605;
        T r747 = (T) new PostLaunchInfoService();
        putStaticServiceImplCache("com.larus.bmhome.chat.api.require.IPostLaunchInfoService", r747);
        return r747;
    L3026:
        if (r3.getName().equals("com.obric.assistant.audio.IObricAudioStatusMonitorService") == false) goto L3605;
        T r748 = (T) new ObricAudioConnectionStatusMonitorService();
        putStaticServiceImplCache("com.obric.assistant.audio.IObricAudioStatusMonitorService", r748);
        return r748;
    L3030:
        if (r3.getName().equals("com.bytedance.android.shopping.api.mall.mallSession.IMallSessionService") == false) goto L3605;
        T r749 = (T) new MallSessionServiceImpl();
        putStaticServiceImplCache("com.bytedance.android.shopping.api.mall.mallSession.IMallSessionService", r749);
        return r749;
    L3034:
        if (r3.getName().equals("com.bytedance.upc.common.ICommonBusinessService") == false) goto L3605;
        T r750 = (T) new CommonBusinessService();
        putStaticServiceImplCache("com.bytedance.upc.common.ICommonBusinessService", r750);
        return r750;
    L3038:
        if (r3.getName().equals("com.larus.bmhome.chat.api.sidebar.ISideBarConversationIconService") == false) goto L3605;
        T r751 = (T) new SideBarConversationIconServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.chat.api.sidebar.ISideBarConversationIconService", r751);
        return r751;
    L3042:
        if (r3.getName().equals("com.larus.platform.model.video.business.IVideoFeedProvider") == false) goto L3605;
        T r752 = (T) new VideoFeedProviderImpl();
        putStaticServiceImplCache("com.larus.platform.model.video.business.IVideoFeedProvider", r752);
        return r752;
    L3046:
        if (r3.getName().equals("com.larus.dora.api.INLService") == false) goto L3605;
        T r753 = (T) new NLServiceImpl();
        putStaticServiceImplCache("com.larus.dora.api.INLService", r753);
        return r753;
    L3050:
        if (r3.getName().equals("com.larus.feedback.api.IFlowFeedbackService") == false) goto L3605;
        T r754 = (T) new FlowFeedbackServiceImpl();
        putStaticServiceImplCache("com.larus.feedback.api.IFlowFeedbackService", r754);
        return r754;
    L3054:
        if (r3.getName().equals("com.obric.assistant.spi.audio.IObricTtsControlService") == false) goto L3605;
        T r755 = (T) new ObricTtsControlServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.spi.audio.IObricTtsControlService", r755);
        return r755;
    L3058:
        if (r3.getName().equals("com.obric.assistant.spi.audio.IObricAsrService") == false) goto L3605;
        T r756 = (T) new ObricAsrServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.spi.audio.IObricAsrService", r756);
        return r756;
    L3062:
        if (r3.getName().equals("com.larus.home.api.route.IHomeRouterService") == false) goto L3605;
        T r757 = (T) new HomeRouterServiceImpl();
        putStaticServiceImplCache("com.larus.home.api.route.IHomeRouterService", r757);
        return r757;
    L3066:
        if (r3.getName().equals("com.bytedance.kmp.router.IRouterService") == false) goto L3605;
        T r758 = (T) new KmpRouterServiceImpl();
        putStaticServiceImplCache("com.bytedance.kmp.router.IRouterService", r758);
        return r758;
    L3070:
        if (r3.getName().equals("com.obric.assistant.spi.login.IObricLoginService") == false) goto L3605;
        T r759 = (T) new ObricLoginServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.spi.login.IObricLoginService", r759);
        return r759;
    L3074:
        if (r3.getName().equals("com.larus.platform.api.IAiFilePreviewService") == false) goto L3605;
        T r760 = (T) new FlowDriveSdkServiceImpl();
        putStaticServiceImplCache("com.larus.platform.api.IAiFilePreviewService", r760);
        return r760;
    L3078:
        if (r3.getName().equals("com.obric.assistant.spi.miniapp.IObricIntentWidgetPolicy") == false) goto L3605;
        T r761 = (T) new ObricIntentWidgetPolicyImpl();
        putStaticServiceImplCache("com.obric.assistant.spi.miniapp.IObricIntentWidgetPolicy", r761);
        return r761;
    L3082:
        if (r3.getName().equals("com.larus.drive.sdk.api.IDriveSdkService") == false) goto L3605;
        T r762 = (T) new DriveSdkServiceImpl();
        putStaticServiceImplCache("com.larus.drive.sdk.api.IDriveSdkService", r762);
        return r762;
    L3086:
        if (r3.getName().equals("com.ss.android.ugc.aweme.live.ILivePluginContext") == false) goto L3605;
        T r763 = (T) new LivePluginContext();
        putStaticServiceImplCache("com.ss.android.ugc.aweme.live.ILivePluginContext", r763);
        return r763;
    L3090:
        if (r3.getName().equals("com.larus.account.saas.coreapi.IAccountLoginService") == false) goto L3605;
        T r764 = (T) new AccountLoginService();
        putStaticServiceImplCache("com.larus.account.saas.coreapi.IAccountLoginService", r764);
        return r764;
    L3094:
        if (r3.getName().equals("com.larus.dora.impl.assistant.AssistantWifiService") == false) goto L3605;
        T r765 = (T) new ObricAssistantWifiServiceImpl();
        putStaticServiceImplCache("com.larus.dora.impl.assistant.AssistantWifiService", r765);
        return r765;
    L3098:
        if (r3.getName().equals("com.obric.assistant.interaction.api.essentialtask.IEssentialTaskService") == false) goto L3605;
        T r766 = (T) new EssentialTaskServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.interaction.api.essentialtask.IEssentialTaskService", r766);
        return r766;
    L3102:
        if (r3.getName().equals("com.bytedance.flow.search.kmp.api.spi.SearchDomainGateService") == false) goto L3605;
        T r767 = (T) new KmpAggregateSearchDomainGateServiceImpl();
        putStaticServiceImplCache("com.bytedance.flow.search.kmp.api.spi.SearchDomainGateService", r767);
        return r767;
    L3106:
        if (r3.getName().equals("com.larus.login.api.IAccountTrackApi") == false) goto L3605;
        T r768 = (T) new AccountTrace();
        putStaticServiceImplCache("com.larus.login.api.IAccountTrackApi", r768);
        return r768;
    L3110:
        if (r3.getName().equals("com.obric.assistant.state.api.v2.core.IObricStateDispatcherService") == false) goto L3605;
        T r769 = (T) new ObricStateDispatcherServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.state.api.v2.core.IObricStateDispatcherService", r769);
        return r769;
    L3114:
        if (r3.getName().equals("com.larus.platform.spi.IAIChatSRSaverService") == false) goto L3605;
        T r770 = (T) new AIChatSRSaverImpl();
        putStaticServiceImplCache("com.larus.platform.spi.IAIChatSRSaverService", r770);
        return r770;
    L3118:
        if (r3.getName().equals("com.larus.platform.spi.IAIChatRenderTraceService") == false) goto L3605;
        T r771 = (T) new AIChatRenderTraceServiceImpl();
        putStaticServiceImplCache("com.larus.platform.spi.IAIChatRenderTraceService", r771);
        return r771;
    L3122:
        if (r3.getName().equals("com.larus.bmhome.auth.ILaunchMetricService") == false) goto L3605;
        T r772 = (T) new LaunchMetricImpl();
        putStaticServiceImplCache("com.larus.bmhome.auth.ILaunchMetricService", r772);
        return r772;
    L3126:
        if (r3.getName().equals("com.ivy.ivykit.api.bridge.IIvyLynxBridgeService") == false) goto L3605;
        T r773 = (T) new IvyLynxBridgeServiceImpl();
        putStaticServiceImplCache("com.ivy.ivykit.api.bridge.IIvyLynxBridgeService", r773);
        return r773;
    L3130:
        if (r3.getName().equals("com.larus.common_ui.floatwindow.manager.IFloatWindowHostProvider") == false) goto L3605;
        T r774 = (T) new ObricWindowFloatHostProvider();
        putStaticServiceImplCache("com.larus.common_ui.floatwindow.manager.IFloatWindowHostProvider", r774);
        return r774;
    L3134:
        if (r3.getName().equals("com.obric.assistant.session.model.ISystemServiceOperation") == false) goto L3605;
        T r775 = (T) new SystemServiceEndpoint();
        putStaticServiceImplCache("com.obric.assistant.session.model.ISystemServiceOperation", r775);
        return r775;
    L3138:
        if (r3.getName().equals("com.larus.power.state.api.PowerStateService") == false) goto L3605;
        T r776 = (T) new PowerStateServiceImpl();
        putStaticServiceImplCache("com.larus.power.state.api.PowerStateService", r776);
        return r776;
    L3142:
        if (r3.getName().equals("com.larus.audio.ttsV2.ITtsGuideService") == false) goto L3605;
        T r777 = (T) new TtsGuideServiceImpl();
        putStaticServiceImplCache("com.larus.audio.ttsV2.ITtsGuideService", r777);
        return r777;
    L3146:
        if (r3.getName().equals("com.obric.assistant.spi.share.IShareKeyConfigService") == false) goto L3605;
        T r778 = (T) new MainlandShareKeyConfigService();
        putStaticServiceImplCache("com.obric.assistant.spi.share.IShareKeyConfigService", r778);
        return r778;
    L3150:
        if (r3.getName().equals("com.larus.canvas.service.ICanvasRepoService") == false) goto L3605;
        T r779 = (T) new CanvasRepoServiceImpl();
        putStaticServiceImplCache("com.larus.canvas.service.ICanvasRepoService", r779);
        return r779;
    L3154:
        if (r3.getName().equals("com.larus.common.mssdk.api.IAppOpsService") == false) goto L3605;
        T r780 = (T) new AppOpsService();
        putStaticServiceImplCache("com.larus.common.mssdk.api.IAppOpsService", r780);
        return r780;
    L3158:
        if (r3.getName().equals("com.larus.suggest.api.INexPulseDialogService") == false) goto L3605;
        T r781 = (T) new NexPulseDialogServiceImpl();
        putStaticServiceImplCache("com.larus.suggest.api.INexPulseDialogService", r781);
        return r781;
    L3162:
        if (r3.getName().equals("com.bytedance.timonbase.ITMBusinessService") == false) goto L3605;
        T r782 = (T) new MonitorBusinessServiceImpl();
        putStaticServiceImplCache("com.bytedance.timonbase.ITMBusinessService", r782);
        return r782;
    L3166:
        if (r3.getName().equals("com.larus.chat.job.api.IChatJobFragmentFactory") == false) goto L3605;
        T r783 = (T) new ChatJobFragmentFactoryImpl();
        putStaticServiceImplCache("com.larus.chat.job.api.IChatJobFragmentFactory", r783);
        return r783;
    L3170:
        if (r3.getName().equals("com.larus.profile.api.ICreationService") == false) goto L3605;
        T r784 = (T) new com.larus.profile.impl.CreationServiceImpl();
        putStaticServiceImplCache("com.larus.profile.api.ICreationService", r784);
        return r784;
    L3174:
        if (r3.getName().equals("com.obric.assistant.spi.mediaplay.IMediaPlayStateChangeListener") == false) goto L3605;
        T r785 = (T) new ObricMediaPlayStateChangeListenerUtils();
        putStaticServiceImplCache("com.obric.assistant.spi.mediaplay.IMediaPlayStateChangeListener", r785);
        return r785;
    L3178:
        if (r3.getName().equals("com.larus.office.base.preview.IOfficePreviewOpener") == false) goto L3605;
        T r786 = (T) new DriveOpenerImpl();
        putStaticServiceImplCache("com.larus.office.base.preview.IOfficePreviewOpener", r786);
        return r786;
    L3182:
        if (r3.getName().equals("com.larus.bmhome.chat.monitor.IMessageImageLoaderService") == false) goto L3605;
        T r787 = (T) new MessageImageLoaderServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.chat.monitor.IMessageImageLoaderService", r787);
        return r787;
    L3186:
        if (r3.getName().equals("com.obric.assistant.spi.audio.IObricEnrollInteropService") == false) goto L3605;
        T r788 = (T) new ObricEnrollInteropServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.spi.audio.IObricEnrollInteropService", r788);
        return r788;
    L3190:
        if (r3.getName().equals("com.obric.assistant.spi.message.IObricMessageService") == false) goto L3605;
        T r789 = (T) new ObricMessageServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.spi.message.IObricMessageService", r789);
        return r789;
    L3194:
        if (r3.getName().equals("com.larus.platform.model.video.business.IVideoArticleProvider") == false) goto L3605;
        T r790 = (T) new VideoArticleProviderImpl();
        putStaticServiceImplCache("com.larus.platform.model.video.business.IVideoArticleProvider", r790);
        return r790;
    L3198:
        if (r3.getName().equals("com.obric.assistant.tipoff.IObricTipOffService") == false) goto L3605;
        T r791 = (T) new ObricTipOffServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.tipoff.IObricTipOffService", r791);
        return r791;
    L3202:
        if (r3.getName().equals("com.obric.sva.framework.api.ISvaFramework") == false) goto L3605;
        T r792 = (T) new SvaFrameworkImpl();
        putStaticServiceImplCache("com.obric.sva.framework.api.ISvaFramework", r792);
        return r792;
    L3206:
        if (r3.getName().equals("com.larus.common_ui.icon.ICommonFileIconProvider") == false) goto L3605;
        T r793 = (T) new OfficeFileIconProvider();
        putStaticServiceImplCache("com.larus.common_ui.icon.ICommonFileIconProvider", r793);
        return r793;
    L3210:
        if (r3.getName().equals("com.larus.superthread.api.FlowSuperThreadService") == false) goto L3605;
        T r794 = (T) new SuperThreadServiceImpl();
        putStaticServiceImplCache("com.larus.superthread.api.FlowSuperThreadService", r794);
        return r794;
    L3214:
        if (r3.getName().equals("com.obric.assistant.interaction.api.service.IActivityResultHelperApi") == false) goto L3605;
        T r795 = (T) new ActivityResultHelperImpl();
        putStaticServiceImplCache("com.obric.assistant.interaction.api.service.IActivityResultHelperApi", r795);
        return r795;
    L3218:
        if (r3.getName().equals("com.bytedance.flow.search.kmp.api.spi.SearchDriveService") == false) goto L3605;
        T r796 = (T) new KmpSearchDriveServiceImpl();
        putStaticServiceImplCache("com.bytedance.flow.search.kmp.api.spi.SearchDriveService", r796);
        return r796;
    L3222:
        if (r3.getName().equals("com.larus.account.base.api.IDouyinAuthService") == false) goto L3605;
        T r797 = (T) new DouyinAuthServiceImpl();
        putStaticServiceImplCache("com.larus.account.base.api.IDouyinAuthService", r797);
        return r797;
    L3226:
        if (r3.getName().equals("com.obric.aiagent.assistant.idl.IFlowAssistantStateIDLSPI") == false) goto L3605;
        T r798 = (T) new ObricStateIDLStub();
        putStaticServiceImplCache("com.obric.aiagent.assistant.idl.IFlowAssistantStateIDLSPI", r798);
        return r798;
    L3230:
        if (r3.getName().equals("com.larus.bmhome.chat.component.list.ChatMessageListUpdateObserver") == false) goto L3605;
        T r799 = (T) new OfficeUrlPreviewMessageListObserver();
        putStaticServiceImplCache("com.larus.bmhome.chat.component.list.ChatMessageListUpdateObserver", r799);
        return r799;
    L3234:
        if (r3.getName().equals("com.obric.assistant.entity.IObricIntentEntityListSheetService") == false) goto L3605;
        T r800 = (T) new ObricIntentEntityListSheetServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.entity.IObricIntentEntityListSheetService", r800);
        return r800;
    L3238:
        if (r3.getName().equals("com.larus.platform.spi.IChatDebugWranglerProvider") == false) goto L3605;
        T r801 = (T) new ChatDebugWranglerProvider();
        putStaticServiceImplCache("com.larus.platform.spi.IChatDebugWranglerProvider", r801);
        return r801;
    L3242:
        if (r3.getName().equals("com.larus.business.multitask_management.api.IMultiTaskService") == false) goto L3605;
        T r802 = (T) new MultiTaskServiceImpl();
        putStaticServiceImplCache("com.larus.business.multitask_management.api.IMultiTaskService", r802);
        return r802;
    L3246:
        if (r3.getName().equals("com.bytedance.android.bcm.api.provider.IBcmConfigBusinessProvider") == false) goto L3605;
        return (T) new BcmConfigBusinessProviderImpl();
    L3250:
        if (r3.getName().equals("com.bytedance.bmf_mods_api.NoiseLiveAPI") == false) goto L3605;
        T r803 = (T) new NoiseLive();
        putStaticServiceImplCache("com.bytedance.bmf_mods_api.NoiseLiveAPI", r803);
        return r803;
    L3254:
        if (r3.getName().equals("com.larus.reach.api.ReachBannerHost") == false) goto L3605;
        T r804 = (T) new ChatBottomReachHost();
        putStaticServiceImplCache("com.larus.reach.api.ReachBannerHost", r804);
        return r804;
    L3258:
        if (r3.getName().equals("com.obric.assistant.IObricAssistant") == false) goto L3605;
        T r805 = (T) new ObricAssistantImpl();
        putStaticServiceImplCache("com.obric.assistant.IObricAssistant", r805);
        return r805;
    L3262:
        if (r3.getName().equals("com.obric.assistant.session.model.IAutoMicOperation") == false) goto L3605;
        T r806 = (T) new AutoMicEndpoint();
        putStaticServiceImplCache("com.obric.assistant.session.model.IAutoMicOperation", r806);
        return r806;
    L3266:
        if (r3.getName().equals("com.larus.uaigc.service.ICreationNotifyService") == false) goto L3605;
        T r807 = (T) new CreationNotifyServiceImpl();
        putStaticServiceImplCache("com.larus.uaigc.service.ICreationNotifyService", r807);
        return r807;
    L3270:
        if (r3.getName().equals("com.larus.uaigc.applet.IAICreationAppletHostService") == false) goto L3605;
        T r808 = (T) new AICreationAppletHostServiceImpl();
        putStaticServiceImplCache("com.larus.uaigc.applet.IAICreationAppletHostService", r808);
        return r808;
    L3274:
        if (r3.getName().equals("com.larus.applog.api.IMultiInstanceAppLogService") == false) goto L3605;
        T r809 = (T) new MultiInstanceAppLogServiceImpl();
        putStaticServiceImplCache("com.larus.applog.api.IMultiInstanceAppLogService", r809);
        return r809;
    L3278:
        if (r3.getName().equals("com.ss.android.ugc.quota.IBDNetworkTagConfig") == false) goto L3605;
        return (T) new BDNetworkTagConfigImpl();
    L3282:
        if (r3.getName().equals("com.obric.aiagent.assistant.idl.IFlowAppIntentIDLSPI") == false) goto L3605;
        T r810 = (T) new AppIntentIDLStub();
        putStaticServiceImplCache("com.obric.aiagent.assistant.idl.IFlowAppIntentIDLSPI", r810);
        return r810;
    L3286:
        if (r3.getName().equals("com.obric.assistant.security.ICertificateCheckService") == false) goto L3605;
        T r811 = (T) new CertificateCheckServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.security.ICertificateCheckService", r811);
        return r811;
    L3290:
        if (r3.getName().equals("com.larus.bmhome.auth.feature_config.model.IFeatureKitService") == false) goto L3605;
        T r812 = (T) new FeatureKitImpl();
        putStaticServiceImplCache("com.larus.bmhome.auth.feature_config.model.IFeatureKitService", r812);
        return r812;
    L3294:
        if (r3.getName().equals("com.larus.login.api.IDouyinConversationAuthService") == false) goto L3605;
        T r813 = (T) new DouyinConversationAuthServiceImpl();
        putStaticServiceImplCache("com.larus.login.api.IDouyinConversationAuthService", r813);
        return r813;
    L3298:
        if (r3.getName().equals("com.larus.bmhome.resource.access.ResourceRemoteResolver") == false) goto L3605;
        T r814 = (T) new CreationImageRemoteResolver();
        putStaticServiceImplCache("com.larus.bmhome.resource.access.ResourceRemoteResolver", r814);
        return r814;
    L3302:
        if (r3.getName().equals("com.obric.assistant.common.spi.IObricEnvService") == false) goto L3605;
        T r815 = (T) new ObricEnvServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.common.spi.IObricEnvService", r815);
        return r815;
    L3306:
        if (r3.getName().equals("com.larus.feishu.office.im.api.FlowCameraExtensionFactoryService") == false) goto L3605;
        T r816 = (T) new FlowCameraExtensionFactoryServiceImpl();
        putStaticServiceImplCache("com.larus.feishu.office.im.api.FlowCameraExtensionFactoryService", r816);
        return r816;
    L3310:
        if (r3.getName().equals("com.obric.assistant.spi.audio.IObricVadService") == false) goto L3605;
        T r817 = (T) new ObricVadServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.spi.audio.IObricVadService", r817);
        return r817;
    L3314:
        if (r3.getName().equals("com.bytedance.upc.IUpcLifecycleService") == false) goto L3605;
        T r818 = (T) new CommonService();
        putStaticServiceImplCache("com.bytedance.upc.IUpcLifecycleService", r818);
        return r818;
    L3318:
        if (r3.getName().equals("com.larus.account.saas.coreapi.IAccountSessionService") == false) goto L3605;
        T r819 = (T) new AccountSessionService();
        putStaticServiceImplCache("com.larus.account.saas.coreapi.IAccountSessionService", r819);
        return r819;
    L3322:
        if (r3.getName().equals("com.bytedance.android.shopping.api.mall.IECMallTabOptService") == false) goto L3605;
        T r820 = (T) new ECMallTabOptService();
        putStaticServiceImplCache("com.bytedance.android.shopping.api.mall.IECMallTabOptService", r820);
        return r820;
    L3326:
        if (r3.getName().equals("com.obric.assistant.wakeup.statistics.api.IBluetoothScoEstablishStatisticsAPI") == false) goto L3605;
        T r821 = (T) new BluetoothScoEstablishStatisticsImpl();
        putStaticServiceImplCache("com.obric.assistant.wakeup.statistics.api.IBluetoothScoEstablishStatisticsAPI", r821);
        return r821;
    L3330:
        if (r3.getName().equals("com.obric.assistant.spi.canvas.IObricCanvasService") == false) goto L3605;
        T r822 = (T) new CanvasServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.spi.canvas.IObricCanvasService", r822);
        return r822;
    L3334:
        if (r3.getName().equals("com.larus.office.card.urlpreview.IOfficeHtmlFileDownloadService") == false) goto L3605;
        T r823 = (T) new OfficeHtmlFileDownloadServiceImpl();
        putStaticServiceImplCache("com.larus.office.card.urlpreview.IOfficeHtmlFileDownloadService", r823);
        return r823;
    L3338:
        if (r3.getName().equals("com.bytedance.bmf_mods_api.VideoSRRaisrAPI") == false) goto L3605;
        T r824 = (T) new VideoSRRaisr();
        putStaticServiceImplCache("com.bytedance.bmf_mods_api.VideoSRRaisrAPI", r824);
        return r824;
    L3342:
        if (r3.getName().equals("com.bytedance.flow_audio.api.service.common.IKMPTrackerService") == false) goto L3605;
        T r825 = (T) new TrackerService();
        putStaticServiceImplCache("com.bytedance.flow_audio.api.service.common.IKMPTrackerService", r825);
        return r825;
    L3346:
        if (r3.getName().equals("com.larus.applog.api.IApplog") == false) goto L3605;
        T r826 = (T) new ApplogImpl();
        putStaticServiceImplCache("com.larus.applog.api.IApplog", r826);
        return r826;
    L3350:
        if (r3.getName().equals("com.larus.multitask_management.api.spi.IMultiTaskFrontierService") == false) goto L3605;
        T r827 = (T) new MultiTaskFrontierServiceImpl();
        putStaticServiceImplCache("com.larus.multitask_management.api.spi.IMultiTaskFrontierService", r827);
        return r827;
    L3354:
        if (r3.getName().equals("com.larus.bmhome.chat.service.IMainBotCommonService") == false) goto L3605;
        T r828 = (T) new MainBotCommonServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.chat.service.IMainBotCommonService", r828);
        return r828;
    L3358:
        if (r3.getName().equals("com.larus.feishu.office.im.api.FlowFloatExpandExtensionFactoryService") == false) goto L3605;
        T r829 = (T) new FlowFloatExpandExtensionFactoryServiceImpl();
        putStaticServiceImplCache("com.larus.feishu.office.im.api.FlowFloatExpandExtensionFactoryService", r829);
        return r829;
    L3362:
        if (r3.getName().equals("com.larus.account.saas.coreapi.IAccountManagementService") == false) goto L3605;
        T r830 = (T) new AccountManagementService();
        putStaticServiceImplCache("com.larus.account.saas.coreapi.IAccountManagementService", r830);
        return r830;
    L3366:
        if (r3.getName().equals("com.obric.assistant.audio.service.IObricIntentStatusService") == false) goto L3605;
        T r831 = (T) new IObricIntentStatusServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.audio.service.IObricIntentStatusService", r831);
        return r831;
    L3370:
        if (r3.getName().equals("com.obric.assistant.audio.service.IIdleQuiteService") == false) goto L3605;
        T r832 = (T) new IdleQuiteService();
        putStaticServiceImplCache("com.obric.assistant.audio.service.IIdleQuiteService", r832);
        return r832;
    L3374:
        if (r3.getName().equals("com.obric.assistant.state.api.multitask.producer.IObricInteractionStateProducerService") == false) goto L3605;
        T r833 = (T) new ObricInteractionStateProducer();
        putStaticServiceImplCache("com.obric.assistant.state.api.multitask.producer.IObricInteractionStateProducerService", r833);
        return r833;
    L3378:
        if (r3.getName().equals("com.obric.assistant.IObricActivityService") == false) goto L3605;
        T r834 = (T) new ObricActivityServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.IObricActivityService", r834);
        return r834;
    L3382:
        if (r3.getName().equals("com.larus.bmhome.bot.IBotStatusCacheService") == false) goto L3605;
        T r835 = (T) new BotStatusCache();
        putStaticServiceImplCache("com.larus.bmhome.bot.IBotStatusCacheService", r835);
        return r835;
    L3386:
        if (r3.getName().equals("com.larus.platform.IFlowMessageService") == false) goto L3605;
        T r836 = (T) new FlowMessageImpl();
        putStaticServiceImplCache("com.larus.platform.IFlowMessageService", r836);
        return r836;
    L3390:
        if (r3.getName().equals("com.bytedance.bmf_mods_api.VideoSuperResolutionAPI") == false) goto L3605;
        T r837 = (T) new VideoSuperResolution();
        putStaticServiceImplCache("com.bytedance.bmf_mods_api.VideoSuperResolutionAPI", r837);
        return r837;
    L3394:
        if (r3.getName().equals("com.obric.assistant.spi.rtc.IObricRtcService") == false) goto L3605;
        T r838 = (T) new ObricRtcServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.spi.rtc.IObricRtcService", r838);
        return r838;
    L3398:
        if (r3.getName().equals("com.larus.ugc.feed.api.detail.spi.ICreationDetailFragmentFactory") == false) goto L3605;
        T r839 = (T) new CreationDetailFragmentFactoryImpl();
        putStaticServiceImplCache("com.larus.ugc.feed.api.detail.spi.ICreationDetailFragmentFactory", r839);
        return r839;
    L3402:
        if (r3.getName().equals("com.obric.assistant.spi.notification.IObricNotificationIslandService") == false) goto L3605;
        T r840 = (T) new ObricNotificationIslandService();
        putStaticServiceImplCache("com.obric.assistant.spi.notification.IObricNotificationIslandService", r840);
        return r840;
    L3406:
        if (r3.getName().equals("com.larus.bot.api.IBotMakerService") == false) goto L3605;
        T r841 = (T) new BotMakerServiceImpl();
        putStaticServiceImplCache("com.larus.bot.api.IBotMakerService", r841);
        return r841;
    L3410:
        if (r3.getName().equals("com.bytedance.bmf_mods_api.ColorShiftAPI") == false) goto L3605;
        T r842 = (T) new ColorShift();
        putStaticServiceImplCache("com.bytedance.bmf_mods_api.ColorShiftAPI", r842);
        return r842;
    L3414:
        if (r3.getName().equals("com.larus.urlplayer.IAudioUrlPlayService") == false) goto L3605;
        T r843 = (T) new AudioUrlPlayImpl();
        putStaticServiceImplCache("com.larus.urlplayer.IAudioUrlPlayService", r843);
        return r843;
    L3418:
        if (r3.getName().equals("com.larus.account.base.api.IThirdPartyPlatformCallbackService") == false) goto L3605;
        T r844 = (T) new IThirdPartyPlatformCallbackImpl();
        putStaticServiceImplCache("com.larus.account.base.api.IThirdPartyPlatformCallbackService", r844);
        return r844;
    L3422:
        if (r3.getName().equals("com.larus.account.saas.security.api.IAccountSecurityService") == false) goto L3605;
        T r845 = (T) new AccountSecurityServiceImpl();
        putStaticServiceImplCache("com.larus.account.saas.security.api.IAccountSecurityService", r845);
        return r845;
    L3426:
        if (r3.getName().equals("com.bytedance.flow_audio.api.business.asr.source.FlowAsrFileAudioDataProvider") == false) goto L3605;
        T r846 = (T) new AsrFileAudioDataProvider();
        putStaticServiceImplCache("com.bytedance.flow_audio.api.business.asr.source.FlowAsrFileAudioDataProvider", r846);
        return r846;
    L3430:
        if (r3.getName().equals("com.obric.assistant.session.model.ILaunchMethodOperation") == false) goto L3605;
        T r847 = (T) new LaunchMethodReporterEndpoint();
        putStaticServiceImplCache("com.obric.assistant.session.model.ILaunchMethodOperation", r847);
        return r847;
    L3434:
        if (r3.getName().equals("com.larus.platform.api.IFlowCreationThemeConfigProvider") == false) goto L3605;
        T r848 = (T) new FlowCreationThemeConfigProvider();
        putStaticServiceImplCache("com.larus.platform.api.IFlowCreationThemeConfigProvider", r848);
        return r848;
    L3438:
        if (r3.getName().equals("com.obric.assistant.spi.message.IObricAppreciablePoint") == false) goto L3605;
        T r849 = (T) new ObricAppreciablePoint();
        putStaticServiceImplCache("com.obric.assistant.spi.message.IObricAppreciablePoint", r849);
        return r849;
    L3442:
        if (r3.getName().equals("com.larus.audioplayer.api.news.INewsUrlAudioManager") == false) goto L3605;
        T r850 = (T) new NewsUrlAudioManagerService();
        putStaticServiceImplCache("com.larus.audioplayer.api.news.INewsUrlAudioManager", r850);
        return r850;
    L3446:
        if (r3.getName().equals("com.larus.ivykit.xbridge.IAnnieXMethodFinderProvider") == false) goto L3605;
        T r851 = (T) new LiveMethodFinderProvider();
        putStaticServiceImplCache("com.larus.ivykit.xbridge.IAnnieXMethodFinderProvider", r851);
        return r851;
    L3450:
        if (r3.getName().equals("com.obric.audio.dora.IObricDoraPluginProvider") == false) goto L3605;
        T r852 = (T) new ObricDoraPluginProvider();
        putStaticServiceImplCache("com.obric.audio.dora.IObricDoraPluginProvider", r852);
        return r852;
    L3454:
        if (r3.getName().equals("com.larus.voice_setting.INativeVoiceSettingService") == false) goto L3605;
        T r853 = (T) new VoiceSettingServiceImpl();
        putStaticServiceImplCache("com.larus.voice_setting.INativeVoiceSettingService", r853);
        return r853;
    L3458:
        if (r3.getName().equals("com.ss.android.ugc.aweme.search.dynamic.core.ability.ISearchDynamicAbility$IFactory") == false) goto L3605;
        T r854 = (T) new EcomSearchBannerAnimAbilityFactory();
        putStaticServiceImplCache("com.ss.android.ugc.aweme.search.dynamic.core.ability.ISearchDynamicAbility$IFactory", r854);
        return r854;
    L3462:
        if (r3.getName().equals("com.larus.drive.biz.api.IDriveService") == false) goto L3605;
        T r855 = (T) new DriveServiceImpl();
        putStaticServiceImplCache("com.larus.drive.biz.api.IDriveService", r855);
        return r855;
    L3466:
        if (r3.getName().equals("com.obric.assistant.spi.feedback.IObricFeedbackPanelService") == false) goto L3605;
        T r856 = (T) new ObricFeedbackPanelServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.spi.feedback.IObricFeedbackPanelService", r856);
        return r856;
    L3470:
        if (r3.getName().equals("com.obric.assistant.IDoraAuthTrustService") == false) goto L3605;
        T r857 = (T) new DoraAuthTrustServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.IDoraAuthTrustService", r857);
        return r857;
    L3474:
        if (r3.getName().equals("com.obric.assistant.entity.IObricEntityNavigationService") == false) goto L3605;
        T r858 = (T) new ObricEntityNavigationServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.entity.IObricEntityNavigationService", r858);
        return r858;
    L3478:
        if (r3.getName().equals("com.larus.platform.IObricMessageExtService") == false) goto L3605;
        T r859 = (T) new ObricMessageExtImpl();
        putStaticServiceImplCache("com.larus.platform.IObricMessageExtService", r859);
        return r859;
    L3482:
        if (r3.getName().equals("com.obric.assistant.feedback.IObricSystemFeedback") == false) goto L3605;
        T r860 = (T) new ObricSystemFeedbackImpl();
        putStaticServiceImplCache("com.obric.assistant.feedback.IObricSystemFeedback", r860);
        return r860;
    L3486:
        if (r3.getName().equals("com.bytedance.bmf_mods_api.TdiLiteStrategyAPI") == false) goto L3605;
        return (T) new TdiLiteStrategy();
    L3490:
        if (r3.getName().equals("com.obric.activeness.IObricActivenessMonitorService") == false) goto L3605;
        T r861 = (T) new ObricActivenessMonitorServiceImpl();
        putStaticServiceImplCache("com.obric.activeness.IObricActivenessMonitorService", r861);
        return r861;
    L3494:
        if (r3.getName().equals("com.larus.flowsdk.security.api.FlowFileProtectionService") == false) goto L3605;
        T r862 = (T) new FlowFileProtectionServiceImpl();
        putStaticServiceImplCache("com.larus.flowsdk.security.api.FlowFileProtectionService", r862);
        return r862;
    L3498:
        if (r3.getName().equals("com.obric.assistant.spi.push.IObricPushConfigService") == false) goto L3605;
        T r863 = (T) new ObricPushConfigServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.spi.push.IObricPushConfigService", r863);
        return r863;
    L3502:
        if (r3.getName().equals("com.obric.assistant.common.spi.audio.IObricAudioService") == false) goto L3605;
        T r864 = (T) new ObricAudioServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.common.spi.audio.IObricAudioService", r864);
        return r864;
    L3506:
        if (r3.getName().equals("com.obric.assistant.spi.markdown.IObricMarkdownResolverService") == false) goto L3605;
        T r865 = (T) new ObricMarkdownResolverServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.spi.markdown.IObricMarkdownResolverService", r865);
        return r865;
    L3510:
        if (r3.getName().equals("com.bytedance.locallife.poi.IPoiFeedPlayerService") == false) goto L3605;
        T r866 = (T) new PoiFeedPlayerServiceImpl();
        putStaticServiceImplCache("com.bytedance.locallife.poi.IPoiFeedPlayerService", r866);
        return r866;
    L3514:
        if (r3.getName().equals("com.larus.bmhome.floatchat.IFloatChatService") == false) goto L3605;
        T r867 = (T) new FloatChatServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.floatchat.IFloatChatService", r867);
        return r867;
    L3518:
        if (r3.getName().equals("com.larus.slides.api.ISlidesService") == false) goto L3605;
        T r868 = (T) new SlidesServiceImpl();
        putStaticServiceImplCache("com.larus.slides.api.ISlidesService", r868);
        return r868;
    L3522:
        if (r3.getName().equals("com.larus.chat.api.nita.IChatBottomNitaView") == false) goto L3605;
        T r869 = (T) new ChatBottomNitaViewImpl();
        putStaticServiceImplCache("com.larus.chat.api.nita.IChatBottomNitaView", r869);
        return r869;
    L3526:
        if (r3.getName().equals("com.larus.dora.api.IDoraGuideService") == false) goto L3605;
        T r870 = (T) new DoraGuideServiceImpl();
        putStaticServiceImplCache("com.larus.dora.api.IDoraGuideService", r870);
        return r870;
    L3530:
        if (r3.getName().equals("com.larus.audio.audiov3.report.IAudioEventCommonParams") == false) goto L3605;
        T r871 = (T) new AudioEventCommonParamsServiceImpl();
        putStaticServiceImplCache("com.larus.audio.audiov3.report.IAudioEventCommonParams", r871);
        return r871;
    L3534:
        if (r3.getName().equals("com.larus.navigation.api.baidu.BaiduNaviService") == false) goto L3605;
        T r872 = (T) new com.larus.navigation.impl.baidu.BaiduNaviServiceImpl();
        putStaticServiceImplCache("com.larus.navigation.api.baidu.BaiduNaviService", r872);
        return r872;
    L3538:
        if (r3.getName().equals("com.obric.assistant.state.api.multitask.IObricInteractionModeService") == false) goto L3605;
        T r873 = (T) new InteractionModeStateProducer();
        putStaticServiceImplCache("com.obric.assistant.state.api.multitask.IObricInteractionModeService", r873);
        return r873;
    L3542:
        if (r3.getName().equals("com.larus.bot.api.IUgcBotRepoService") == false) goto L3605;
        T r874 = (T) new UgcBotRepoServiceImpl();
        putStaticServiceImplCache("com.larus.bot.api.IUgcBotRepoService", r874);
        return r874;
    L3546:
        if (r3.getName().equals("com.ivy.ivykit.api.bridge.IBridgeService") == false) goto L3605;
        T r875 = (T) new BridgeServiceImpl();
        putStaticServiceImplCache("com.ivy.ivykit.api.bridge.IBridgeService", r875);
        return r875;
    L3550:
        if (r3.getName().equals("com.larus.bmhome.chat.standarduikit.computerusetool.api.ICuaApi") == false) goto L3605;
        T r876 = (T) new CuaApiImpl();
        putStaticServiceImplCache("com.larus.bmhome.chat.standarduikit.computerusetool.api.ICuaApi", r876);
        return r876;
    L3554:
        if (r3.getName().equals("com.larus.bmhome.social.userchat.messagelist.model.IMessageContentConvertor") == false) goto L3605;
        T r877 = (T) new TextContentConvertor();
        putStaticServiceImplCache("com.larus.bmhome.social.userchat.messagelist.model.IMessageContentConvertor", r877);
        return r877;
    L3558:
        if (r3.getName().equals("com.obric.assistant.audio.service.IObricTtsService") == false) goto L3605;
        T r878 = (T) new ObricTtsServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.audio.service.IObricTtsService", r878);
        return r878;
    L3562:
        if (r3.getName().equals("com.larus.bmhome.chat.api.IAuthModelService") == false) goto L3605;
        T r879 = (T) new AuthViewModel();
        putStaticServiceImplCache("com.larus.bmhome.chat.api.IAuthModelService", r879);
        return r879;
    L3566:
        if (r3.getName().equals("com.obric.assistant.state.api.multitask.producer.IObricWakeupStateProducerService") == false) goto L3605;
        T r880 = (T) new ObricWakeupStateProducer();
        putStaticServiceImplCache("com.obric.assistant.state.api.multitask.producer.IObricWakeupStateProducerService", r880);
        return r880;
    L3570:
        if (r3.getName().equals("com.obric.aiagent.assistant.idl.IFlowSettingsIDLSPI") == false) goto L3605;
        T r881 = (T) new SettingsIDLStub();
        putStaticServiceImplCache("com.obric.aiagent.assistant.idl.IFlowSettingsIDLSPI", r881);
        return r881;
    L3574:
        if (r3.getName().equals("com.obric.assistant.multiuser.api.IObricMultiUserService") == false) goto L3605;
        T r882 = (T) new ObricMultiUserServiceImpl();
        putStaticServiceImplCache("com.obric.assistant.multiuser.api.IObricMultiUserService", r882);
        return r882;
    L3578:
        if (r3.getName().equals("com.larus.bmhome.video.IVideoDownloadLoadingMgrService") == false) goto L3605;
        T r883 = (T) new VideoDownloadLoadingMgr();
        putStaticServiceImplCache("com.larus.bmhome.video.IVideoDownloadLoadingMgrService", r883);
        return r883;
    L3582:
        if (r3.getName().equals("com.larus.apm.api.IGodzilla") == false) goto L3605;
        T r884 = (T) new GodzillaImpl();
        putStaticServiceImplCache("com.larus.apm.api.IGodzilla", r884);
        return r884;
    L3586:
        if (r3.getName().equals("com.obric.assistant.chat.IObricChatService") == false) goto L3605;
        T r885 = (T) new ObricChatService();
        putStaticServiceImplCache("com.obric.assistant.chat.IObricChatService", r885);
        return r885;
    L3590:
        if (r3.getName().equals("com.larus.platform.api.IFlowSettingThemeConfigProvider") == false) goto L3605;
        T r886 = (T) new FlowSettingThemeConfigProvider();
        putStaticServiceImplCache("com.larus.platform.api.IFlowSettingThemeConfigProvider", r886);
        return r886;
    L3594:
        if (r3.getName().equals("com.bytedance.timonbase.ITMBasicModeLifecycleService") == false) goto L3605;
        T r887 = (T) new RulerBasicLifecycleServiceImpl();
        putStaticServiceImplCache("com.bytedance.timonbase.ITMBasicModeLifecycleService", r887);
        return r887;
    L3598:
        if (r3.getName().equals("com.larus.bmhome.auth.douyin.IAiChatOpenDouyinAuthService") == false) goto L3605;
        T r888 = (T) new AiChatOpenDouyinAuthServiceImpl();
        putStaticServiceImplCache("com.larus.bmhome.auth.douyin.IAiChatOpenDouyinAuthService", r888);
        return r888;
    L3602:
        if (r3.getName().equals("com.larus.bot.api.IBotDiscoverService") == false) goto L3605;
        T r889 = (T) new BotDiscoverServiceImpl();
        putStaticServiceImplCache("com.larus.bot.api.IBotDiscoverService", r889);
        return r889;
    }

    private <T> Set<T> getStaticServiceImplSetReal(Class<T> r2) {
        Set<T> r0 = getStaticServiceImplSetRealStub0(r2);
        if (r0 != null) goto L10;
        r0 = getStaticServiceImplSetRealStub1(r2);
        if (r0 != null) goto L10;
        r0 = getStaticServiceImplSetRealStub2(r2);
        if (r0 != null) goto L10;
        this.serviceImplSetNotExistSet.add(r2.getName());
        return null;
    L10:
        return r0;
    }

    public <T> T getStaticServiceImpl(Class<T> r4) {
        String r0 = r4.getName();
        T r1 = (T) this.serviceImplCache.get(r0);
        if (r1 == null) goto L5;
        return r1;
    L5:
        if (this.serviceImplNotExistSet.contains(r0) == false) goto L7;
        return r1;
    L7:
        return (T) getStaticServiceImplReal(r4);
    }

    public <T> Set<T> getStaticServiceImplSet(Class<T> r4) {
        String r0 = r4.getName();
        Set<T> r1 = (Set) this.serviceImplSetCache.get(r0);
        if (r1 == null) goto L5;
        return r1;
    L5:
        if (this.serviceImplSetNotExistSet.contains(r0) == false) goto L7;
        return r1;
    L7:
        return getStaticServiceImplSetReal(r4);
    }

    private void putStaticServiceImplCache(String r2, Object r3) {
        this.serviceImplCache.put(r2, r3);
    }

    private void putStaticServiceImplSetCache(String r2, Set<Object> r3) {
        this.serviceImplSetCache.put(r2, r3);
    }
}
