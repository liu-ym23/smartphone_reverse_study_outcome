package com.larus.platform;

import com.larus.bmhome.FlowLarkSocialServiceImpl;
import com.larus.home.impl.sdk.FlowAppletServiceImpl;
import com.larus.home.impl.sdk.OfficeAuthServiceImpl;
import com.larus.home.impl.sdk.f;
import com.larus.home.impl.sdk.o2;
import com.larus.home.impl.sdk.p1;
import com.larus.home.impl.sdk.r0;
import com.larus.home.impl.sdk.s;
import com.larus.home.impl.sdk.v;
import com.larus.home.impl.sdk.w0;
import com.larus.office.base.host.o;
import com.larus.platform.api.ISdkTitleBarInflate;
import com.larus.platform.api.r2;
import com.larus.platform.api.v2;
import com.larus.platform.api.z2;
import com.larus.platform.api.z3;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000Ð\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\n\u0010\b\u001a\u0004\u0018\u00010\tH&J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\n\u0010\f\u001a\u0004\u0018\u00010\rH&J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H&J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H&J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H&J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H&J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH&J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001dH&J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001fH&J\n\u0010 \u001a\u0004\u0018\u00010!H&J\n\u0010\"\u001a\u0004\u0018\u00010#H&J\n\u0010$\u001a\u0004\u0018\u00010%H&J\n\u0010&\u001a\u0004\u0018\u00010'H&J\n\u0010(\u001a\u0004\u0018\u00010)H&J\n\u0010*\u001a\u0004\u0018\u00010+H&J\n\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0012\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u000201H&J\n\u00102\u001a\u0004\u0018\u000103H&J\n\u00104\u001a\u0004\u0018\u000105H&J\n\u00106\u001a\u0004\u0018\u000107H&J\n\u00108\u001a\u0004\u0018\u000109H&J\n\u0010:\u001a\u0004\u0018\u00010;H\u0016J\n\u0010<\u001a\u0004\u0018\u00010=H\u0016J\n\u0010>\u001a\u0004\u0018\u00010?H\u0016J\n\u0010@\u001a\u0004\u0018\u00010AH\u0016J\n\u0010B\u001a\u0004\u0018\u00010CH&J\n\u0010D\u001a\u0004\u0018\u00010EH&J\n\u0010F\u001a\u0004\u0018\u00010GH&J\n\u0010H\u001a\u0004\u0018\u00010IH\u0016J\n\u0010J\u001a\u0004\u0018\u00010KH\u0016J\n\u0010L\u001a\u0004\u0018\u00010MH&J\n\u0010N\u001a\u0004\u0018\u00010OH&J\n\u0010P\u001a\u0004\u0018\u00010QH&J\n\u0010R\u001a\u0004\u0018\u00010SH\u0016J\n\u0010T\u001a\u0004\u0018\u00010UH\u0016J\n\u0010V\u001a\u0004\u0018\u00010WH&J\n\u0010X\u001a\u0004\u0018\u00010YH&J\n\u0010Z\u001a\u0004\u0018\u00010[H&J\n\u0010\\\u001a\u0004\u0018\u00010]H\u0016J\n\u0010^\u001a\u0004\u0018\u00010_H\u0016J\n\u0010`\u001a\u0004\u0018\u00010aH\u0016J\n\u0010b\u001a\u0004\u0018\u00010cH\u0016J\n\u0010d\u001a\u0004\u0018\u00010eH\u0016J\n\u0010f\u001a\u0004\u0018\u00010gH\u0016J\n\u0010h\u001a\u0004\u0018\u00010iH\u0016J\n\u0010j\u001a\u0004\u0018\u00010kH\u0016J\n\u0010l\u001a\u0004\u0018\u00010mH\u0016J\n\u0010n\u001a\u0004\u0018\u00010oH\u0016J\n\u0010p\u001a\u0004\u0018\u00010qH\u0016J\n\u0010r\u001a\u0004\u0018\u00010sH\u0016J\n\u0010t\u001a\u0004\u0018\u00010uH\u0016J\n\u0010v\u001a\u0004\u0018\u00010wH\u0016J\n\u0010x\u001a\u0004\u0018\u00010yH\u0016J\n\u0010z\u001a\u0004\u0018\u00010{H\u0016J\n\u0010|\u001a\u0004\u0018\u00010}H\u0016J\n\u0010~\u001a\u0004\u0018\u00010\u007fH\u0016J\f\u0010\u0080\u0001\u001a\u0005\u0018\u00010\u0081\u0001H\u0016J\f\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0083\u0001H\u0016J\f\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0085\u0001H\u0016J\f\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0087\u0001H\u0016J\f\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0089\u0001H\u0016J\f\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u008b\u0001H\u0016J\f\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008d\u0001H\u0016J\f\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008f\u0001H\u0016J\n\u0010\u0090\u0001\u001a\u00030\u0091\u0001H&J\n\u0010\u0092\u0001\u001a\u00030\u0091\u0001H&J\f\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0094\u0001H\u0016J\f\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0096\u0001H\u0016J\f\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0098\u0001H\u0016J\f\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u009a\u0001H\u0016J\f\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009c\u0001H\u0016J\f\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009e\u0001H\u0016J\f\u0010\u009f\u0001\u001a\u0005\u0018\u00010 \u0001H\u0016J\n\u0010¡\u0001\u001a\u00030¢\u0001H&J\n\u0010£\u0001\u001a\u00030¤\u0001H&J\f\u0010¥\u0001\u001a\u0005\u0018\u00010¦\u0001H\u0016J\f\u0010§\u0001\u001a\u0005\u0018\u00010¨\u0001H\u0016J\f\u0010©\u0001\u001a\u0005\u0018\u00010ª\u0001H\u0016J\f\u0010«\u0001\u001a\u0005\u0018\u00010¬\u0001H\u0016J\f\u0010\u00ad\u0001\u001a\u0005\u0018\u00010®\u0001H\u0016J\f\u0010¯\u0001\u001a\u0005\u0018\u00010°\u0001H\u0016J\f\u0010±\u0001\u001a\u0005\u0018\u00010²\u0001H\u0016J\f\u0010³\u0001\u001a\u0005\u0018\u00010´\u0001H\u0016J\f\u0010µ\u0001\u001a\u0005\u0018\u00010¶\u0001H\u0016J\f\u0010·\u0001\u001a\u0005\u0018\u00010¸\u0001H\u0016J\f\u0010¹\u0001\u001a\u0005\u0018\u00010º\u0001H\u0016J\f\u0010»\u0001\u001a\u0005\u0018\u00010¼\u0001H\u0016J\f\u0010½\u0001\u001a\u0005\u0018\u00010¾\u0001H\u0016J\n\u0010¿\u0001\u001a\u00030\u0091\u0001H\u0016J\f\u0010À\u0001\u001a\u0005\u0018\u00010Á\u0001H\u0016J\f\u0010Â\u0001\u001a\u0005\u0018\u00010Ã\u0001H\u0016J\f\u0010Ä\u0001\u001a\u0005\u0018\u00010¦\u0001H\u0016¨\u0006Å\u0001"}, d2 = {"Lcom/larus/platform/IFlowSdkDepend;", "", "getEffectPlatformService", "Lcom/larus/platform/api/IFlowEffectPlatformService;", "getChatListHostAbilityService", "Lcom/larus/platform/api/IChatListHostAbility;", "getHolderService", "Lcom/larus/platform/api/ISdkHolderHanlder;", "getClipBoardService", "Lcom/larus/platform/api/ISdkClipboard;", "getLinkService", "Lcom/larus/platform/api/ISdkLinkHanlder;", "getMessageFilter", "Lcom/larus/platform/api/ISdkMessageFilter;", "getAccountService", "Lcom/larus/platform/api/ISdkAccount;", "getCommerceCreditService", "Lcom/larus/platform/api/ISdkCommerceCredit;", "getCommerceMembershipService", "Lcom/larus/platform/api/ISdkCommerceMembership;", "getMinorService", "Lcom/larus/platform/api/ISdkMinorMode;", "getPrivacyService", "Lcom/larus/platform/api/ISdkPrivacy;", "getSecuritySdkService", "Lcom/larus/platform/api/ISecuritySdk;", "getSettingsService", "Lcom/larus/platform/api/ISdkSettings;", "getPerformanceService", "Lcom/larus/platform/api/IPerformanceService;", "getResourceService", "Lcom/larus/platform/api/ISdkResource;", "getBuildConfigService", "Lcom/larus/platform/api/ISdkBuildConfig;", "getDebugService", "Lcom/larus/platform/api/ISdkDebug;", "getNavigationService", "Lcom/larus/platform/api/ISdkNavigation;", "getAccessibilityService", "Lcom/larus/platform/api/ISdkAccessibility;", "getHttpConfigService", "Lcom/larus/platform/api/ISdkHttpConfig;", "getLocationService", "Lcom/larus/platform/api/ISdkLocation;", "getAppletLocationService", "Lcom/larus/platform/api/ISdkAppletLocation;", "getFrontierService", "Lcom/larus/platform/api/ISdkFrontierService;", "serviceId", "", "getTitleBarInflateService", "Lcom/larus/platform/api/ISdkTitleBarInflate;", "getTouristService", "Lcom/larus/platform/api/ISdkTourist;", "getAudioSdkDepend", "Lcom/larus/platform/api/IAudioSdkDepend;", "getAudioService", "Lcom/larus/platform/api/IAudioService;", "getCameraSdkDepend", "Lcom/larus/platform/api/ICameraSdkDepend;", "getLottieCompatService", "Lcom/larus/platform/api/ILottieCompatService;", "getSamiServerParamService", "Lcom/larus/platform/api/ISamiServerParamService;", "getTtcnpaInitService", "Lcom/larus/platform/api/ITtcnpaInitService;", "getPermissionService", "Lcom/larus/platform/api/IPermission;", "getMainPageLifecycleCallbackService", "Lcom/larus/platform/api/IMainPageLifecycleCallback;", "getMapService", "Lcom/larus/platform/api/ISdkMap;", "getAMapNaviService", "Lcom/larus/platform/api/ISdkAMapNavi;", "getIvykitService", "Lcom/larus/platform/api/ISdkIvykit;", "getTTVideoEngineStaticService", "Lcom/larus/platform/api/ITTVideoEngineStaticService;", "getSettingsConfigService", "Lcom/larus/platform/api/ISdkSettingsConfig;", "getGeckoService", "Lcom/larus/platform/api/ISdkGecko;", "getUgcBotService", "Lcom/larus/platform/api/ISdkUgcBotService;", "getCreationService", "Lcom/larus/platform/api/ISdkCreationService;", "getUgService", "Lcom/larus/platform/api/ISdkUg;", "getOverseaPayService", "Lcom/larus/platform/api/IOverseaPay;", "getBottomTabService", "Lcom/larus/platform/api/ISdkBottomTab;", "getVideoPlayer", "Lcom/larus/platform/api/IAudioPlayController;", "getMediaEngine", "Lcom/larus/platform/api/IMediaEngine;", "getNotifyService", "Lcom/larus/platform/api/ISdkNotify;", "getSearchService", "Lcom/larus/platform/api/ISdkSearch;", "getSearchConversationProvider", "Lcom/larus/platform/api/ISearchConversationProvider;", "getSdkBusinessSettingService", "Lcom/larus/platform/api/IBusinessSettingService;", "getSdkMainBotSettingService", "Lcom/larus/platform/api/IMainBotSettingsService;", "getAppletService", "Lcom/larus/platform/api/IFlowAppletService;", "getSdkBusinessMusicService", "Lcom/larus/platform/api/IBusinessMusicService;", "getDoraAudioManager", "Lcom/larus/platform/api/ISdkDoraApi;", "getTickService", "Lcom/larus/platform/api/ISdkTick;", "getCollectService", "Lcom/larus/platform/api/ISdkCollectService;", "getCaseService", "Lcom/larus/platform/api/ISdkCaseService;", "getAlbumService", "Lcom/larus/platform/api/ISdkAlbumService;", "getAppletJsbEventService", "Lcom/larus/platform/api/IAppletJsbEventService;", "getPhotoPickerService", "Lcom/larus/platform/api/ISdkPhotoPicker;", "getSlidesService", "Lcom/larus/platform/api/ISdkSlides;", "getCJPayService", "Lcom/larus/platform/api/ISdkCJPay;", "getEnterpriseService", "Lcom/larus/platform/api/ISdkEnterprise;", "getStoreRegionService", "Lcom/larus/platform/api/ISdkStoreRegion;", "getSheetsService", "Lcom/larus/platform/api/ISdkSheets;", "getBitableService", "Lcom/larus/platform/api/ISdkBitable;", "getMarkdownService", "Lcom/larus/platform/api/ISdkMarkdown;", "getPadService", "Lcom/larus/platform/api/ISdkPadService;", "getPerfDegradeService", "Lcom/larus/platform/api/ISdkPerfDegradeService;", "getPushService", "Lcom/larus/platform/api/ISdkPushService;", "isDoraNotifyEnabled", "", "isFirstStartApp", "getFlowTraceService", "Lcom/larus/platform/api/IFlowTraceService;", "getVeSdkService", "Lcom/larus/platform/api/IVeSdkService;", "getSdkDocService", "Lcom/larus/platform/api/ISdkDocService;", "getLarkSocialService", "Lcom/larus/platform/api/ILarkSocialService;", "getLarkofficeService", "Lcom/larus/platform/api/ILarkofficeService;", "getOfficeAuthService", "Lcom/larus/platform/api/IFlowOfficeAuthService;", "getChatService", "Lcom/larus/platform/api/IChatService;", "getSdkBrowserService", "Lcom/larus/platform/api/ISdkBrowserService;", "getSdkUploaderService", "Lcom/larus/platform/api/ISdkUploaderService;", "getDebugVipFeatureKey", "", "getDiskService", "Lcom/larus/platform/api/ISdkDiskService;", "getHomeSdkService", "Lcom/larus/platform/api/IHomeSdkService;", "getLogoutService", "Lcom/larus/platform/api/ILogoutService;", "getDigitalAvatarService", "Lcom/larus/platform/api/creation/ISdkDigitalAvatarService;", "getFontService", "Lcom/larus/platform/api/ISdkFontService;", "getSuggestActionService", "Lcom/larus/platform/api/ISdkSuggestActionService;", "getSdkMinutesService", "Lcom/larus/platform/api/ISdkMinutesService;", "getSdkOfficeService", "Lcom/larus/platform/api/ISdkOfficeService;", "getSdkWatermarkService", "Lcom/larus/platform/api/ISdkWatermarkService;", "getAIGCMetadataCheckService", "Lcom/larus/platform/api/ISdkAIGCMetadataCheck;", "getLocalLifeService", "Lcom/larus/platform/api/ISdkLocalLife;", "getCalendarService", "Lcom/larus/platform/api/ISdkCalendarService;", "registerQQMusicAppletBridges", "getXBridgeService", "Lcom/larus/platform/api/ISdkXBridge;", "getECommerceService", "Lcom/larus/platform/api/ISdkECommerce;", "getECommerceLearnMoreUrl", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IFlowSdkDepend {
    void A();

    r2 A0();

    p1 B(int r100);

    void B0();

    void C();

    void C0();

    void D();

    void D0();

    void E();

    void E0();

    OfficeAuthServiceImpl F();

    String F0();

    void G();

    void G0();

    void H();

    void H0();

    void I();

    void I0();

    FlowLarkSocialServiceImpl J();

    void J0();

    void K();

    void K0();

    void L();

    void M();

    void N();

    z2 O();

    void P();

    void Q();

    void R();

    void S();

    void T();

    void U();

    void V();

    void W();

    void X();

    v2 Y();

    void Z();

    void a();

    void a0();

    void b();

    void b0();

    z3 c();

    void c0();

    void d();

    void d0();

    void e0();

    void f();

    void f0();

    void g();

    FlowAppletServiceImpl g0();

    void getAccountService();

    void getCalendarService();

    void getCollectService();

    void getLocationService();

    w0 getPermissionService();

    void getPhotoPickerService();

    void h();

    void h0();

    void i();

    void i0();

    void j();

    void j0();

    void k();

    void k0();

    void l();

    void l0();

    void m();

    void m0();

    void n();

    void n0();

    void o();

    boolean o0();

    void p();

    r0 p0();

    void q();

    void q0();

    void r();

    void r0();

    void s();

    s s0();

    void t();

    ISdkTitleBarInflate t0();

    o u();

    void u0();

    void v();

    void v0();

    void w();

    f w0();

    void x();

    o2 x0();

    void y();

    void y0();

    void z();

    v z0();
}
