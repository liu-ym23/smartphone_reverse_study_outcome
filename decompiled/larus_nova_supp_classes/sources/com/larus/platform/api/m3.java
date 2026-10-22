package com.larus.platform.api;

import android.os.Bundle;
import android.view.View;
import com.larus.im.bean.message.block.Block;
import com.larus.platform.model.AigcMetadataConfig;
import com.larus.platform.model.AudioDebugConfig;
import com.larus.platform.model.ExportFileConfig;
import com.larus.platform.model.FlowMarkdownSettings;
import com.larus.platform.model.GlobalFeedbackConfig;
import com.larus.platform.model.HandsfreeExperimentConfig;
import com.larus.platform.model.HoverActionConfig;
import com.larus.platform.model.InputComponentConfig;
import com.larus.platform.model.KmpInstructionCoreOptConfig;
import com.larus.platform.model.MarkDownSelectorSettings;
import com.larus.platform.model.MessageMarkdownSettingsConfig;
import com.larus.platform.model.ProfileLikeCollectListConfig;
import com.larus.platform.model.SlashMentionConfig;
import com.larus.platform.model.SpeakStyleConfig;
import com.larus.platform.model.audio.ASRStrengthenConfig;
import com.larus.platform.model.audio.AudioConnectionPoolConfig;
import com.larus.platform.model.audio.AudioFeedbackFrequencyConfig;
import com.larus.platform.model.audio.AudioFeedbackSwitch;
import com.larus.platform.model.audio.AudioHostConfig;
import com.larus.platform.model.audio.AudioPendingWaitConfig;
import com.larus.platform.model.audio.AudioRetransmitStrategyModel;
import com.larus.platform.model.audio.AudioSyncCallConfig;
import com.larus.platform.model.audio.AutoReadTtsOptConfig;
import com.larus.platform.model.audio.CloseAudioConnectionAppBackgroundConfig;
import com.larus.platform.model.audio.ContinuousSpeechUIConfig;
import com.larus.platform.model.audio.FlowDoraSamiConfigModel;
import com.larus.platform.model.audio.OboeOptConfig;
import com.larus.platform.model.audio.RealtimeCallAddEventConfig;
import com.larus.platform.model.audio.RealtimeCallBtnPositionConfig;
import com.larus.platform.model.audio.RealtimeCallHelloConfig;
import com.larus.platform.model.audio.RealtimeCallSceneConfig;
import com.larus.platform.model.audio.RealtimeCallSceneModeConfig;
import com.larus.platform.model.audio.RealtimeCallSceneModeHelloConfig;
import com.larus.platform.model.audio.RealtimeSuggestUIConfig;
import com.larus.platform.model.audio.SimultaneousInterpretationClientConfig;
import com.larus.platform.model.audio.TtsOpenGuideConfig;
import com.larus.platform.model.audio.VoiceRecommendConfig;
import com.larus.platform.model.bot.MultiBotsCapability;
import com.larus.platform.model.bot.MultiBotsStatusUIFixConfig;
import com.larus.platform.model.camera.AppImageAutoOptConfig;
import com.larus.platform.model.camera.AppImageUploadPerfOptConf;
import com.larus.platform.model.camera.CameraSettings;
import com.larus.platform.model.camera.MainCameraFocusFrame;
import com.larus.platform.model.chat.AttachmentEditConfig;
import com.larus.platform.model.chat.ChatAwemeFeedConfig;
import com.larus.platform.model.chat.ObricWindowMessageBubbleConfig;
import com.larus.platform.model.chat.b0;
import com.larus.platform.model.chat.c0;
import com.larus.platform.model.chat.d0;
import com.larus.platform.model.chat.g;
import com.larus.platform.model.chat.i0;
import com.larus.platform.model.chat.j;
import com.larus.platform.model.chat.j0;
import com.larus.platform.model.chat.o;
import com.larus.platform.model.chat.o0;
import com.larus.platform.model.chat.p0;
import com.larus.platform.model.chat.q0;
import com.larus.platform.model.chat.s;
import com.larus.platform.model.chat.v;
import com.larus.platform.model.chat.w0;
import com.larus.platform.model.chat.x;
import com.larus.platform.model.chat.x0;
import com.larus.platform.model.chat.y;
import com.larus.platform.model.downgrade.BlockRequestDowngradeConfig;
import com.larus.platform.model.downgrade.DelayRequestDowngradeConfig;
import com.larus.platform.model.downgrade.FlowDowngradeToastConfig;
import com.larus.platform.model.downgrade.MockRequestDowngradeConfig;
import com.larus.platform.model.downgrade.ToastRequestDowngradeConfig;
import com.larus.platform.model.mainbot.ECommerceProductCardPreloadConfig;
import com.larus.platform.model.mainbot.ECommerceSettingsConfig;
import com.larus.platform.model.office.LarkMinutesRecordingConfig;
import com.larus.platform.model.office.OfficeRecordingAIInterpreterConfig;
import com.larus.platform.model.office.RecordingPersonalNotesConfig;
import com.larus.platform.model.video.VideoPortraitConfig;
import hq9.a0;
import hq9.a2;
import hq9.a4;
import hq9.b;
import hq9.b2;
import hq9.b4;
import hq9.c2;
import hq9.c3;
import hq9.c5;
import hq9.d1;
import hq9.d2;
import hq9.d3;
import hq9.d5;
import hq9.e0;
import hq9.e1;
import hq9.e3;
import hq9.f;
import hq9.f0;
import hq9.f1;
import hq9.f3;
import hq9.f4;
import hq9.f5;
import hq9.g0;
import hq9.g1;
import hq9.g5;
import hq9.h0;
import hq9.h1;
import hq9.h4;
import hq9.h5;
import hq9.i1;
import hq9.i2;
import hq9.i3;
import hq9.j2;
import hq9.j3;
import hq9.k1;
import hq9.k2;
import hq9.k3;
import hq9.k4;
import hq9.l0;
import hq9.l1;
import hq9.l3;
import hq9.l4;
import hq9.m;
import hq9.m0;
import hq9.m4;
import hq9.n0;
import hq9.n2;
import hq9.n4;
import hq9.o1;
import hq9.o4;
import hq9.p;
import hq9.p1;
import hq9.p4;
import hq9.q;
import hq9.q4;
import hq9.r;
import hq9.r0;
import hq9.r1;
import hq9.s0;
import hq9.s1;
import hq9.t;
import hq9.t0;
import hq9.t2;
import hq9.t4;
import hq9.u;
import hq9.u0;
import hq9.u1;
import hq9.u3;
import hq9.u4;
import hq9.v0;
import hq9.v2;
import hq9.v3;
import hq9.v4;
import hq9.w;
import hq9.w1;
import hq9.w3;
import hq9.x1;
import hq9.x2;
import hq9.x3;
import hq9.x4;
import hq9.y1;
import hq9.y3;
import hq9.z;
import hq9.z0;
import hq9.z1;
import hq9.z3;
import hq9.z4;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jq9.c;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.flow.Flow;
import kq9.a;
import kq9.h;
import kq9.i;
import lq9.k;
import lq9.k0;
import lq9.l;
import mq9.n;
import nq9.d;
import oq9.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public interface m3 {
    j0 A();

    boolean A0();

    boolean A1();

    SimultaneousInterpretationClientConfig A2();

    boolean A3();

    String B();

    a2 B0();

    int B1();

    i1 B2();

    boolean B3();

    w0 C();

    boolean C0();

    boolean C1();

    List<String> C2();

    y3 C3();

    int D();

    boolean D0();

    String D1();

    boolean D2();

    boolean D3();

    c0 E();

    List<String> E0();

    boolean E1();

    MainCameraFocusFrame E2();

    boolean E3();

    List<String> F();

    List<String> F0();

    String F1();

    boolean F2();

    boolean F3();

    String G();

    boolean G0();

    boolean G1();

    boolean G2();

    boolean G3();

    boolean H();

    u H0();

    boolean H1();

    boolean H2();

    x H3();

    int I();

    String I0();

    boolean I1();

    boolean I2();

    boolean I3();

    boolean J();

    boolean J0();

    boolean J1();

    int J2();

    boolean J3();

    boolean K();

    AudioSyncCallConfig K0();

    g0 K1();

    boolean K2();

    boolean K3();

    boolean L();

    VideoPortraitConfig L0();

    boolean L1();

    boolean L2();

    float L3();

    boolean M();

    i0 M0();

    FlowMarkdownSettings M1();

    boolean M2();

    OboeOptConfig M3();

    boolean N();

    boolean N0();

    boolean N1();

    int N2();

    TtsOpenGuideConfig N3();

    w O();

    m0 O0();

    boolean O1();

    int O2();

    String O3();

    h5 P();

    RealtimeCallSceneModeHelloConfig P0();

    Object P1(String r1);

    int P2();

    int P3();

    Flow<Unit> Q();

    List<String> Q0();

    String Q1();

    List<String> Q2();

    boolean Q3();

    boolean R();

    boolean R0();

    RealtimeCallBtnPositionConfig R1();

    boolean R2();

    boolean R3();

    boolean S();

    boolean S0();

    SpeakStyleConfig S1();

    int S2();

    g5 S3();

    boolean T();

    List<String> T0();

    boolean T1();

    int T2();

    b T3();

    y U();

    p U0();

    boolean U1();

    n U2();

    RealtimeCallAddEventConfig U3();

    boolean V();

    boolean V0();

    boolean V1();

    AudioRetransmitStrategyModel V2();

    boolean V3();

    List<String> W();

    com.larus.platform.model.chat.p W0();

    boolean W1();

    long W2();

    List<String> W3();

    l X();

    int X0();

    String X1();

    i3 X2();

    boolean X3();

    int Y();

    v3 Y0();

    int Y1();

    boolean Y2();

    boolean Y3();

    int Z();

    List<String> Z0();

    String Z1();

    boolean Z2();

    String Z3();

    boolean a();

    boolean a0();

    boolean a1();

    boolean a2();

    s a3();

    boolean a4(List<Block> r1);

    boolean actionBarSecondMenuShowFix();

    boolean actionBarShowDurationOpt();

    boolean adjustPageBottomSpaceOnlyAndroid();

    HashMap<String, Object> aecMicSelectorConfig();

    AigcMetadataConfig aigcMetadataConfig();

    boolean albumSdkEnable();

    boolean albumUnifiedAgent();

    boolean androidPreprocessOptFileSize();

    boolean applyAudioFocusNew();

    boolean applyMmtUnpublish();

    boolean asrSessionComponentSplit();

    ASRStrengthenConfig asrStrengthenConfig();

    boolean asrUseGainTransientFocusType();

    AttachmentEditConfig attachmentEditConfig();

    boolean audioConnectionPoolRecreateEnable();

    q audioDebugAutoDumpConfig();

    AudioDebugConfig audioDebugDumpConfig();

    AudioFeedbackFrequencyConfig audioFeedbackFrequencyConfig();

    AudioFeedbackSwitch audioFeedbackSwitch();

    r audioSoundsQualityConfig();

    boolean audioTtsUseSceneVerify();

    AutoReadTtsOptConfig autoReadTtsOptConfig();

    a b();

    boolean b0();

    RealtimeCallSceneModeConfig b1();

    boolean b2();

    int b3();

    er9.a b4();

    boolean botCreateEnable();

    d botSettingShareBtnConfig();

    boolean c();

    v2 c0();

    boolean c1();

    g c2();

    boolean c3();

    boolean callDisableSwitchAvatar();

    e cameraFreeInputConfig();

    ir9.b cameraInitOptConfig();

    hq9.c0 cameraInputOptimizeConfig();

    boolean canLongActionAddRegenerate();

    boolean canShowAnswerActionBar();

    int centerActionStyle();

    boolean chatImmerseEnable();

    e0 chatInputEditTextOptConfig();

    f0 chatInputOptConfig();

    int chatInputType();

    boolean chatListLoginGuideBannerEnabled();

    long chatTopFloatButtonShowTime();

    boolean clipTableHtmlEnabled();

    CloseAudioConnectionAppBackgroundConfig closeAudioConnectionAppBackgroundConfig();

    hq9.j0 cognitiveConfig();

    boolean collectEnable();

    boolean configListReorder();

    boolean connectionCreateBeforeUseEnable();

    boolean consumePushSDKSettings();

    k continueTalkV2Config();

    int continuousTalkClickAlignment();

    int continuousTalkLeftButtonStyle();

    boolean coroutinesOptV1();

    boolean coroutinesOptV2();

    boolean createBotAutoFillEnable();

    boolean createNewConversationNewIcon();

    int creationDetailClickAction();

    boolean creationDetailVideoEngineLeakFix();

    boolean creationDetailVideoFocusFix();

    boolean creationFeedEntranceReverse();

    boolean creationFeedHolderOpt();

    boolean creationFeedThumbRatioLimit43();

    boolean creationFeedVideoAutoPlay();

    kq9.g creationImageReviewOptConfig();

    h creationImageUploadReuseConfig();

    boolean creationInstructionKmpEnabled();

    i creationNoWatermarkConfig();

    kq9.k creationResourceAccessOptConfig();

    boolean creationSendMessageOpt();

    HashMap<String, String> crowdTestFeedbackReason();

    int d();

    int d0();

    int d1();

    boolean d2();

    JSONObject d3();

    int deepResearchPodcastLoadingTimeoutInterval();

    int deepResearchPodcastUseIconType();

    int deepThinkActionBarTipDismissDuration();

    o deepThinkOptimizeConfig();

    boolean delayPromptShowReport();

    boolean disableAudioTraceSpan();

    boolean disableCommonSettingsVoiceCreate();

    boolean disableCreationOriImageLoad();

    boolean disableFix1340InputSendProblem();

    boolean disableMoaStartCall();

    boolean disablePuzzleSizeLimit();

    boolean disableReUploadGeneratedImg();

    boolean disableRealtimeCallSubtitleOpenControlForMainBot();

    boolean disableRealtimeCallSubtitleOpenControlForUgcBot();

    boolean disableTouristActionBarCreation();

    boolean disableVoiceInput();

    int docDetailPageEditIconStyle();

    boolean downgradeCreationFeedVideoFix();

    boolean e();

    t e0();

    void e1(View r1, Bundle r2);

    boolean e2();

    lq9.n e3();

    uq9.b ecActivityThemeConfig();

    List<String> ecommerceAuthorizationWhiteList();

    boolean eduUploadOriginImage();

    boolean enableAICreationApplet();

    boolean enableAICreationAppletKmpFeed();

    boolean enableASRTimeoutTaskTrace();

    boolean enableAddAlbumCreationInput();

    boolean enableAddLoadingViewToCaijing();

    boolean enableAddPartImageOnlyAndroid();

    boolean enableAnnieXLiveMethodProviderFirst();

    boolean enableAnswerActionExposurePriority();

    boolean enableAsrFailedBeforeACKTraceAsync();

    boolean enableAsrInputViewMarginFix();

    boolean enableAsrNewAnim();

    boolean enableAsrWithImageQueryInfo();

    boolean enableAsyncCallLifecycleDispatch();

    boolean enableAudioBgSimpleColor();

    AudioConnectionPoolConfig enableAudioConnectionPoolConfig();

    int enableAudioInputWithAttachment();

    boolean enableAudioNewTheme();

    boolean enableAudioPlayerFlushWithSilence();

    boolean enableAudioPlayerTimeoutCheck();

    boolean enableAudioRecordSilencedCheck();

    boolean enableAutoOpenSubtitle();

    boolean enableAutoPlayAudioZeroVolumeToast();

    boolean enableAutoStartByNoSilentFrame();

    boolean enableBackUpToPreviousReadPosition();

    int enableBioInChatTop();

    boolean enableBlockImagePreviewResize();

    boolean enableBluetoothDevicesReportEvent();

    boolean enableBlurRoundRectDraw();

    boolean enableBootNetOpt();

    int enableBootNqeOpt();

    HashMap<String, Integer> enableBootPathOpt();

    boolean enableCamera2();

    boolean enableCameraEffectOpt();

    boolean enableCameraFrameSyncDispatch();

    boolean enableCameraLumaDetectOpt();

    boolean enableChatInputDeleteOverflowFix();

    boolean enableChatInputIconCompat();

    boolean enableChatSpeakerBuilder();

    boolean enableChatTimestampNoLeadingZero();

    boolean enableChatWithTab();

    boolean enableClientAvatarDetectAlgorithm();

    boolean enableCollectionForceRefresh();

    boolean enableCreationActionbarConfig();

    boolean enableCreationFileWatermark();

    boolean enableCreationMixSkillAlbumMultiSelect();

    boolean enableCreationMsgExportFile();

    boolean enableCreationResourceAccessPipeline();

    boolean enableCreationVideoDownloadOpt();

    boolean enableDataTagOptimize();

    boolean enableDirectJumpCameraCaptureFirst();

    boolean enableDoraLarkRecord();

    boolean enableEduVlmMigration();

    boolean enableEnterKeyBehaviorSetting();

    boolean enableEnterpriseDownloadWatermark();

    boolean enableFastAlbumSmallWindowAdapt();

    boolean enableFilterDeletedBotConversation();

    boolean enableFixCidUidMismatch();

    boolean enableForceBindDouyinV2();

    boolean enableGeneralInternetCodeHeaderIcon();

    boolean enableGetBotListAfterSaveVoice();

    boolean enableGlobalActivityTheme();

    boolean enableHasHumanTag();

    boolean enableImagePreprocessCacheFallback();

    boolean enableImageUploadConvertToSrgb();

    boolean enableInterpretAutoStartByFrame();

    boolean enableIvyWebviewDecode();

    boolean enableKeepInputLeftIcon();

    boolean enableKeepScreenOnDuringTTS();

    boolean enableKeepScreenOnGuardLegacyScenes();

    boolean enableKeepScreenOnReply();

    boolean enableKmpAsr();

    boolean enableKmpTts();

    boolean enableKmpTtsCancelTaskIdCheck();

    boolean enableKmpVoiceSetting();

    boolean enableLeftActionCameraShow();

    boolean enableLocalFaceDetect();

    boolean enableLogoutAll();

    boolean enableLogoutOpt();

    boolean enableLongImageAutoFit();

    boolean enableMainBotNewSetting();

    boolean enableMarkdownContainerAppletLastBlockInset();

    boolean enableMdWidgetsMixedArrangement();

    boolean enableMessageHover();

    boolean enableMessageListClipBottomToMaxHeight();

    boolean enableMessageMention();

    boolean enableMessageMenuTimestamp();

    boolean enableMessageScrollFreezeAfterFirstInput();

    boolean enableMessageSkillDetailPage();

    boolean enableMessageUrlPreview();

    boolean enableMiaodaArtifactCommonWebContainer();

    boolean enableMiaodaPrewarm();

    boolean enableMixSkillReeditHalfScreen();

    boolean enableMoaAudioRecordStreamOptimizeInterceptor();

    boolean enableModeSwitchTitleIcon();

    boolean enableMuseumExtensionPack();

    boolean enableMusicSaveTtcnpa();

    boolean enableMusicVideoSizeDowngradeFix();

    boolean enableNewActionShown();

    boolean enableNewAddLocalMessageStrategy();

    boolean enableNewSamiEndpoint();

    boolean enableNonLotteryShuffle();

    boolean enableObricIndependentTts();

    boolean enableOfficeDataPrefetch();

    boolean enableOfficeSdkInitOnEnterpriseOnline();

    boolean enableOfficeSdkLifecycleAsyncInit();

    boolean enableOfficeUrlPreview();

    boolean enableOfficialWebsite();

    boolean enableOptAsrNullableBotId();

    boolean enableOptAsrRetry();

    boolean enableOptAsrSamiNotReady();

    boolean enablePocketDataLaunchReq();

    hq9.k enablePreloadChatPageView();

    boolean enablePromptFilter();

    boolean enablePromptLoading();

    boolean enableQuotaExceededPerformBackAtFront();

    boolean enableRealtimeCallDowngrade();

    boolean enableRealtimeCallEarphoneSwitchToast();

    boolean enableRealtimeCallGroup();

    boolean enableRealtimeCallInterpretForceReportMessage();

    boolean enableRealtimeCallOptSelfInterrupt();

    boolean enableRealtimeCallSubtitle();

    boolean enableRealtimeCallSubtitleASR();

    boolean enableRealtimeCallSubtitleAutoOpen();

    boolean enableRealtimeCallSubtitleOpt();

    boolean enableRealtimeCallSubtitleRecordOpen();

    boolean enableRealtimeCallTakePhoto();

    boolean enableRealtimeCallTakePhotoSkipBotCheck();

    boolean enableRealtimeMmtCameraOesDirectPush();

    boolean enableReceiveMsgBubbleExpand();

    boolean enableRecommendBotAgain();

    boolean enableReferenceMessageWithAttachment();

    boolean enableRenameRenewSection();

    boolean enableRuyiLynxViewRecycle();

    boolean enableSaveInputStatusToKeva();

    boolean enableScanToPayInApp();

    boolean enableScreenShareNewTheme();

    boolean enableShareStreaming();

    boolean enableShowDisclaimer();

    boolean enableSlidesPresentation();

    boolean enableStandardLinkNavigation();

    boolean enableSubSmallAvatar();

    boolean enableSubscribeTitleEntrance();

    boolean enableSubscriberMainBotNewSkin();

    boolean enableSubscriberMultiBotNewSkin();

    boolean enableSubscription();

    boolean enableSwDpOffline();

    boolean enableSyncClientInfo();

    boolean enableTTSZeroVolumeOpt();

    boolean enableTableCopyExcelStyle();

    boolean enableTopBeautyButton();

    boolean enableTopLeftMainBotUnclick();

    boolean enableTraceCollectOpt();

    boolean enableTrackerOptimize();

    boolean enableTtsCache();

    boolean enableTtsMarkOpt();

    boolean enableTtsMediaSession();

    boolean enableTtsStateCheckBeforeCancel();

    boolean enableTtsWhenStreaming();

    boolean enableTypingAsyncOptimize();

    boolean enableUgcBotBlockSwitch();

    boolean enableUseOlympusAccountParam();

    boolean enableVeCameraLogOpt();

    boolean enableVeCaptureRtcSetting();

    boolean enableVeCaptureTargetSize();

    boolean enableVeInitSerialization();

    boolean enableVideoCaptureStartStatusAlignRtc();

    boolean enableVideoDownloadMdl();

    boolean enableVideoPinch();

    boolean enableVoiceMixInput();

    boolean enableVoiceMixInputTwoPass();

    boolean enableVoiceSettingTalkback();

    boolean enableZeroVolumeToastFrequencyControl();

    boolean enableZlinkCheckClipboardNotOnlyAppStart();

    ExportFileConfig exportFileConfig();

    boolean f();

    String f0();

    sq9.o f1();

    int f2();

    List<String> f3();

    boolean fastAlbumSingleUploadAttachmentSyncEnable();

    boolean fastButtonEnable();

    d1 firstFeedOptConfig();

    boolean fixAnrOnAudioPluginStart();

    boolean fixAudioPlayManagerPlayEnd();

    boolean fixFrontierConnect();

    boolean fixRealtimeCameraPadRotationEnable();

    boolean fixRealtimeCameraStopPreviewBeforeDestroyEnable();

    boolean fixRealtimeTalkbackEnable();

    boolean fixTouristRealtimeCallEnable();

    boolean forceOpenFusionDoc();

    boolean g();

    List<String> g0();

    boolean g1();

    boolean g2();

    boolean g3();

    hq9.n1 genImageLoadingAnimationConfig();

    hq9.a getAIBeautifyConfig();

    jq9.a getActionBarConnectorConfig();

    jq9.k getActionBarEntryConfig();

    c getActionBarGradientConfig();

    com.larus.platform.model.chat.a getActionBarOptConfig();

    tq9.a getAiDocCellExposeConfig();

    tq9.b getAiDocConfig();

    tq9.c getAiDocDdxmlConfig();

    String getAiDocFEConfig();

    f getAllowTrainingConfig();

    AppImageAutoOptConfig getAppImageAutoOptConfig();

    oq9.b getAppImageUploadConfig();

    hq9.h getAppLaunchFeedOptConfig();

    hq9.l getAppsAIChatFrameworkConfig();

    m getAppsFrameworkConfig();

    nq9.a getAppsSdkUgcBotConfig();

    long getAsrAnimDuration();

    g1 getAsrCheckAudioConfig();

    lq9.b getAsrInputEntranceConfig();

    String getAsrStreamPostProcess();

    oq9.c getAttachmentAlbumDetectConfig();

    int getAudioCaptionDisplayChatContentScene();

    AudioPendingWaitConfig getAudioPendingWaitConfig();

    fr9.a getAudioRecordConfig();

    hq9.s getAudioStreamPlayerMechanismConfig();

    com.larus.platform.model.chat.b getAutoQuoteConfig();

    or9.c getAwemeVideoFeedConfig();

    com.larus.platform.model.chat.c getBDImageXUploadOptConfig();

    com.larus.platform.model.chat.d getBDImageXUploaderConfig();

    com.larus.platform.model.chat.e getBDVideoUploaderConfig();

    hq9.x getBasicExperienceAnrOptConfig();

    hq9.y getBasicExperienceBugFixConfig();

    z getBasicExperienceCrashOptConfig();

    a0 getBasicExperienceFeatureConfig();

    vq9.a getBlockRefactorConfig();

    BlockRequestDowngradeConfig getBlockRequestDowngradeConfig();

    oq9.d getCameraCommonConfig();

    oq9.f getCameraRecordFeatureConfig();

    oq9.g getCameraResultTabConfig();

    CameraSettings getCameraSettings();

    boolean getCameraTopPaddingFixConfig();

    ChatAwemeFeedConfig getChatAwemeFeedConfig();

    com.larus.platform.model.chat.h getChatBlankScreenMonitorConfig();

    com.larus.platform.model.chat.i getChatFirstScreenOptConfig();

    gr9.a getChatListSearchConfig();

    h0 getChatNavigatorConfig();

    j getChatPageLoadOptConfig();

    com.larus.platform.model.chat.k getChatReadPositionBugfixConfig();

    l0 getCommentClientConfig();

    HashMap<String, n0> getCommonButtonV2AICreationConfig();

    sq9.a getCommunityRecommendRequestConfig();

    ContinuousSpeechUIConfig getContinuousSpeechUIConfig();

    r0 getCreationCanvasClientConfig();

    s0 getCreationCanvasConfig();

    sq9.d getCreationCommentConfig();

    sq9.e getCreationDetailLayoutConfig();

    int getCreationDosameLandingType();

    t0 getCreationDownloaderConfig();

    sq9.f getCreationEditControlConfig();

    sq9.h getCreationExtendVideoConfig();

    boolean getCreationFeedLandingTabOptConfig();

    sq9.k getCreationMakeSameConfig();

    sq9.l getCreationMakeSameConfigV2();

    u0 getCreationNotificationConfig();

    sq9.m getCreationPageSwipeAuthorConfig();

    com.larus.platform.model.chat.n getCreationPreviewPerformanceOptConfig();

    sq9.n getCreationPublishConfig();

    v0 getCreationShareSettings();

    hu9.s getCreationUpdateDialogConfig();

    long getCreationVideoMdlDownloadTimeoutMs();

    kq9.l getCreationWeakNetworkConfig();

    int getDarkModeDefault();

    String getDefaultNewConversationMode();

    DelayRequestDowngradeConfig getDelayRequestDowngradeConfig();

    String getDeviceId();

    mq9.a getDigitalAvatarAuthStyleConfigV2();

    mq9.c getDigitalAvatarVideoRecordingConfig();

    mq9.d getDigitalAvatarVideoRecordingConfigV2();

    tq9.d getDocFeatureEntranceConfig();

    tq9.e getDocFusionConfig();

    tq9.f getDocFusionConfigV2();

    tq9.g getDocOfflineCreateConfig();

    boolean getDoraCdmDisableConfig();

    boolean getDoraCdmFeatureSwitchConfig();

    lq9.o getDoraGUpdateConfig();

    boolean getDoraKeepAliveMethodsConfig();

    FlowDoraSamiConfigModel getDoraSamiConfig();

    List<z0> getDoraSimulSupportLangConfigList();

    com.larus.platform.model.chat.q getDoubaoDisclaimerConfig();

    uq9.f getECommerceAuthConfig();

    ECommerceProductCardPreloadConfig getECommerceProductCardPreloadConfig();

    ECommerceSettingsConfig getECommerceSettingsConfig();

    JSONObject getEcomBcmSettings();

    uq9.j getEcomSaaSAIInputConfig();

    oq9.h getEduCameraConfig();

    int getEduDefaultQuestionMode();

    oq9.i getEduIntentionCameraConfig();

    int getEnableModelTrainingBySpecificType();

    List<String> getEnterVideoCallWhiteList();

    kq9.n getFastAlbumMultiSelectConfig();

    e1 getFirstInstallOptConfig();

    f1 getFloatWindowConfig();

    h1 getFlowAsrClientRetryStrategy();

    String getFlowDeviceModelScore();

    FlowDowngradeToastConfig getFlowDowngradeToastConfig();

    uq9.k getFlowECommerceSaasSdkConfig();

    com.larus.platform.model.chat.t getFlowMultiUploadConfig();

    com.larus.platform.model.chat.u getFlowVideoComprehendConfig();

    ir9.c getFontSizeAllowConfig();

    k1 getFrequentMethodCallOptConfig();

    l1 getFrontierConnectInfo();

    hq9.m1 getFrontierOptConfig();

    GlobalFeedbackConfig getGlobalFeedbackConfig();

    v getGoMaxReadPositionConfig();

    boolean getHitCallDirectEnable();

    r1 getI2iImageStyleConfig();

    s1 getImageEditUploadConfig();

    sq9.w getImageInspireConfig();

    u1 getImageInstantUploadConfig();

    kq9.r getImageUploadDuplicateStatConfig();

    String getImgCreationFallbackAnchorName();

    com.larus.platform.model.chat.w getInputBottomAlbumHeightConfig();

    y1 getInstructionEntranceShowConfig();

    b2 getLarkBitableConfig();

    String getLarkCliAppId();

    c2 getLarkDriveConfig();

    d2 getLarkDriveConfigV2();

    i2 getLarkMixedFeedConfig();

    j2 getLarkMixedFeedMonitorConfig();

    Map<String, String> getLarkOfficeAppLinkMapping();

    k2 getLarkSocialBlockConfig();

    t2 getLarkSocialInitConfig();

    List<String> getLarkSocialTenantIdList();

    xq9.a getLatexEngineConfig();

    vq9.b getLocalLifeConfig();

    lq9.r getLoudnessConfig();

    c3 getLynxVerifyConfig();

    d3 getMainBotSloMonitorConfig();

    oq9.j getMainCameraDetectConfig();

    e3 getMarkdownCodeRenderConfig();

    Map<String, Object> getMarkdownCssConfig();

    f3 getMarkdownOptimizeConfig();

    xq9.b getMarkdownTableRenderConfig();

    d0 getMessageListOptConfig();

    MessageMarkdownSettingsConfig getMessageMarkdownSettingsConfig();

    long getMessageRenderHangInterval();

    MockRequestDowngradeConfig getMockRequestDowngradeConfig();

    hq9.h3 getModelFilingInfoConfig();

    int getMultiCameraCaptureScene();

    j3 getMultiTaskEntranceConfig();

    zq9.a getMultiTaskManagementConfig();

    com.larus.platform.model.chat.g0 getMultimodalConfig();

    k3 getMusicCreateConfig();

    l3 getMusicSaveConfig();

    kq9.s getNewAlbumMediaFilterConfig();

    AppImageUploadPerfOptConf getNewImageUploadPerfOpt();

    com.larus.platform.model.chat.h0 getNewPreviewConfig();

    ObricWindowMessageBubbleConfig getObricWindowMessageBubbleConfig();

    u3 getPicGroupStyleConfig();

    com.larus.platform.model.chat.l0 getPushMainBotOptConfig();

    w3 getReachConfig();

    x3 getRealCallSoundConfig();

    int getRealtimeCallCamera2Override();

    lq9.u getRealtimeCallDowngradeConfig();

    lq9.w getRealtimeCallNewStyleConfig();

    lq9.x getRealtimeCallPreloadConfig();

    lq9.y getRealtimeCallTranslatorConfig();

    List<Integer> getRealtimeCameraRetryAllowErrorCodes();

    int getRedDotShowLimitDays();

    List<Integer> getReportWhiteList();

    b4 getResourceCenterConfig();

    f4 getRouterConfig();

    Boolean getSAMICoreAbBoolConfig(String r1);

    Float getSAMICoreAbFloatConfig(String r1);

    Integer getSAMICoreAbIntConfig(String r1);

    String getSAMICoreAbStringConfig(String r1);

    h4 getSaasShareConfig();

    com.larus.platform.model.chat.m0 getSelectAutoRefConfig();

    int getSelfMessageMenuStyle();

    k4 getSendEntityConfig();

    l4 getSendMessageNetworkToastConfig();

    com.larus.platform.model.chat.n0 getSendMsgPerfOptConfig();

    int getSessionMemoryDuration();

    n4 getShareConfig();

    boolean getShareUnifyOpt();

    o4 getSidebarCaseConfig();

    p4 getSlardarCrashNestedFileCmeConfig();

    SlashMentionConfig getSlashMentionConfig();

    q4 getStreamAsrConfig();

    boolean getSubConversationNewOnboardingStyle();

    boolean getSubConversationNewShowSuggest();

    boolean getSubConversationNewSimplifySettings();

    boolean getSuggestPromptFoldCoCo();

    int getSuggestPromptFoldType();

    ToastRequestDowngradeConfig getToastRequestDowngradeConfig();

    int getTtsBackgroundPlayExperimentMode();

    u4 getUgcMarkdownStyleConfig();

    v4 getUgcTimeStampConfig();

    mq9.l getUserAvatarAuthStyleConfig();

    z4 getVibrateConfig();

    String getVideoCreationFallbackAnchorName();

    nr9.h getVideoStyleAnimConfig();

    String getVoiceCallAbServerTestDid();

    String getVoiceCallAbServerTestUid();

    String getVoiceCallAbTestDid();

    String getVoiceCallAbTestUid();

    c5 getVoiceCallEntranceConfig();

    int getVoiceEditPanelExpandByDefault();

    int getVoiceMixInputScene();

    d5 getVoiceSettingConvenienceConfig();

    long getWatermarkPollInterval();

    int getWatermarkPollMaxCount();

    int getWcbMinConsumedDurationSec();

    f5 getWechatLoginConfig();

    boolean getZMainInputBoxShow();

    String h();

    boolean h0();

    hq9.w0 h1();

    boolean h2();

    boolean h3();

    boolean hasAvatarModelUpdate();

    boolean hasFaceMemoryFunc();

    boolean hideAudioVoiceSettingsName();

    long hideWcbBeforeTimestamp();

    boolean i();

    boolean i0();

    boolean i1();

    void i2(Function0<Unit> r1);

    x2 i3();

    hq9.t1 imageGenerateHeicConfig();

    w1 imageUploadOptConfig();

    boolean immerseBgDynamicEnable();

    InputComponentConfig inputComponentConfig();

    x1 inputEnhance();

    boolean inputMarginWithKeyboardOpt();

    boolean isAccessibilitySdkInitEnable();

    boolean isAutoSayHelloInCallBot();

    boolean isBotProfileShowLLMDisclaimerPoweredHint();

    boolean isCameraAlbumMultiSelectEnable();

    boolean isCommentRemoveInitLoadingDelay();

    boolean isDisableLatex();

    boolean isDoraAudioControlEnabled();

    boolean isDoraSummaryQuicEnabled();

    boolean isFixSamiRequestNoDid();

    boolean isLazyMainComponentEnable();

    boolean isMarkdownStreamOptimized();

    boolean isOfficeDocNewConversationEnable();

    boolean isPinEncryptionDiscontinue();

    boolean isRealtimeCameraOpenAsyncEnable();

    boolean isRealtimeCameraOpenDeduplicationEnable();

    boolean isRealtimeCameraRetryEnable();

    boolean isRealtimeVeCameraEnable();

    boolean isRealtimeVeSdkPreInitEnable();

    boolean isRealtimeVideoBackgroundPublishEnable();

    boolean isSubConvCreateOptEnable();

    boolean isThreadSleepBugFixEnable();

    boolean isTimonClipboardEnabled();

    boolean j();

    boolean j0();

    boolean j1();

    p1 j2();

    boolean j3();

    void k(String r1);

    List<hq9.d> k0();

    boolean k1();

    x0 k2();

    boolean k3();

    z1 kevaAnrOptConfig();

    KmpInstructionCoreOptConfig kmpInstructionCoreOptConfig();

    boolean l();

    boolean l0();

    boolean l1();

    RealtimeCallHelloConfig l2();

    String l3();

    List<String> larkAuthInjectHostList();

    LarkMinutesRecordingConfig larkMinutesRecordingConfig();

    boolean larkScanCodeLoginEnabled();

    com.larus.platform.model.chat.z latestPhotoShortcutConfig();

    boolean longPressShowMultiSelect();

    boolean m();

    void m0();

    int m1();

    boolean m2();

    boolean m3();

    boolean manualInterruptEnableRTCAec();

    boolean markSelectModeEnable();

    com.larus.platform.model.chat.a0 messageBlockConfig();

    b0 messageInputMenuConfig();

    com.larus.platform.model.chat.f0 messageModifyConfig();

    int messageRegenMaxCount();

    boolean messageVoicePlay();

    MultiBotsStatusUIFixConfig multiBotsStatusUIFixConfig();

    String musicCreateStreamingHost();

    boolean musicCreateSupportCoverEdit();

    boolean musicCreateSupportDetail();

    boolean musicCreateSupportStreaming();

    hq9.j n();

    String n0();

    kq9.p n1();

    boolean n2();

    long n3();

    hq9.m3 networkAutoSwitch();

    boolean o();

    hq9.i0 o0();

    List<Integer> o1();

    com.larus.platform.model.chat.f o2();

    lq9.f0 o3();

    List<String> officeDocShareHorizontalItems();

    OfficeRecordingAIInterpreterConfig officeRecordingAIInterpreterConfig();

    String officeUrlPreviewBaseUrl();

    long openTraceExecuteThreshold();

    boolean optDialogDismiss();

    boolean optPasteFile();

    boolean optPushAnr();

    boolean optRedundantDecoderInVideoCall();

    boolean optRequestMyUgcVoiceList();

    boolean optimizeMarkdownListParse();

    boolean optimizeMessageListPrepend();

    boolean optimizeMessageListPrependHotLaunch();

    int p();

    int p0();

    AudioHostConfig p1();

    boolean p2();

    void p3(Function0<Unit> r1);

    int positiveMsgSplitTimeInterval();

    boolean preferBottomOverlaySheetTapTarget();

    kq9.t preprocessAlbumImgOptConfig();

    ProfileLikeCollectListConfig profileLikeCollectListConfig();

    int promptCacheMaxSize();

    boolean pushHotShowQuestion();

    m4 q();

    boolean q0();

    n2 q1();

    boolean q2();

    boolean q3();

    HoverActionConfig r();

    boolean r0();

    boolean r1();

    String r2();

    boolean r3();

    boolean realtimeCallAllSceneMixEnable();

    boolean realtimeCallAutoInterrupt();

    boolean realtimeCallImageTriggerFix();

    lq9.v realtimeCallLanguageConfig();

    RealtimeCallSceneConfig realtimeCallSceneConfig();

    HashMap<String, List<Integer>> realtimeCallServerLimitErrorInfo();

    int realtimeCallSwitchMicForPseudoConnectInterval();

    boolean realtimeCallUseEndCallBgModeSnapshot();

    boolean realtimeCallUseTwoLineStyle();

    boolean realtimeCallUseUplinkHangUp();

    lq9.z realtimeClientRetryConfig();

    boolean realtimeFixRTCNoticePauseEnable();

    int realtimeMaxAliveDuration();

    boolean realtimeSceneMixEnable();

    lq9.e0 realtimeScreenShareEncoderConfig();

    RealtimeSuggestUIConfig realtimeSuggestUIConfig();

    boolean realtimeTalkbackOptEnable();

    lq9.a0 realtimeVLMOfficialConfig();

    lq9.b0 realtimeVLMOfficialNoticeConfig();

    RecordingPersonalNotesConfig recordingPersonalNotesConfig();

    boolean rememberCameraPositionEnable();

    a4 renderFreezeOptConfig();

    boolean reverseEnterImageDetailOpt();

    boolean s();

    boolean s0();

    boolean s1();

    boolean s2();

    Pair<Boolean, Long> s3();

    int samiConnectTimeout();

    lq9.c0 samiEventBlockConfig();

    boolean searchForceByLike();

    boolean sendMsgShowAiBeautifyBtn();

    boolean setupPreInstallChannels();

    boolean shareQrCodeUseCustomStyle();

    boolean shareScreenEnableDualAec();

    boolean shareScreenUseSoftAec();

    boolean showDisclaimer();

    boolean showNetworkStatusInTitle();

    boolean showNewTopicMainBotEnable();

    boolean showPodcastsTopBanner();

    long showWCBMinIntervalBeforePrevMessage();

    boolean skipUpdateIndexWhenLoading();

    String speechAecForceMicSelect();

    boolean startTtsWhenReceiveContent();

    boolean streamPlayerUseMediaSession();

    q0 subConvKeyboardConfig();

    int subMessageAutoRequestNum();

    boolean supportLarusThemeTag();

    boolean switchReadyToSpeakOnHideIme();

    nr9.b t();

    List<String> t0();

    String t1();

    boolean t2();

    boolean t3();

    int ttsMaxCacheCount();

    lq9.j0 ttsSwitchConfig();

    k0 ttsSwitchLongPressConfig();

    boolean ttsUseGainTransientFocusType();

    boolean ttsUseLocalStatus();

    boolean u();

    o0 u0();

    boolean u1();

    String u2();

    boolean u3();

    t4 ugReturnConfig();

    boolean ugcPreviewUseARGB();

    VoiceRecommendConfig ugcVoiceRecommend();

    boolean updateNetInfoAndSubtitleStatusEnabled();

    boolean uploaderUseCachedTokenEnable();

    boolean useDuplexStateForCallConsumer();

    boolean useNewAecProcessor();

    boolean useOldVoiceInputIcon();

    boolean usePreCreateWebView();

    boolean useSafeAudioTrackEnable();

    int useVoiceToCompleteTimeout();

    x4 userAvatarImgConfig();

    boolean v();

    boolean v0();

    List<String> v1();

    kq9.q v2();

    z3 v3();

    String videoGenerateShareHost();

    boolean voiceGlobalSwitchEnable();

    boolean voiceInputDirectFillInput();

    HandsfreeExperimentConfig voiceInputHandsfreeConfig();

    boolean voiceItemCreatorEnable();

    boolean voiceItemHotEnable();

    boolean voiceMultiTabEnable();

    o1 w();

    boolean w0();

    String w1();

    int w2();

    void w3();

    kq9.u watermarkRemovalConfig();

    boolean webviewAddThemeQuery();

    String x();

    boolean x0();

    int x1();

    boolean x2();

    MultiBotsCapability x3();

    JSONObject y();

    boolean y0(int r1);

    boolean y1();

    int y2();

    boolean y3();

    boolean z();

    String z0();

    MarkDownSelectorSettings z1();

    lq9.a z2();

    p0 z3();

    long zlinkStartDelayCheckTimeMills();
}
