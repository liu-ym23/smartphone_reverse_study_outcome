package com.larus.home.impl.sdk;

import android.util.EventsUtils;
import b2a.b;
import com.larus.api.LocationService;
import com.larus.bmhome.FlowLarkSocialServiceImpl;
import com.larus.business.debug.api.IDebugService;
import com.larus.e_commerce.api.IECommerceService;
import com.larus.minor.api.IMinorService;
import com.larus.music.applet.qqmusic.impl.AddQQMusicFavouriteMethod;
import com.larus.music.applet.qqmusic.impl.CheckQQMusicAuthStatusMethod;
import com.larus.music.applet.qqmusic.impl.GetQQDayRecommendSongListMethod;
import com.larus.music.applet.qqmusic.impl.GetQQFolderListMethod;
import com.larus.music.applet.qqmusic.impl.GetQQMusicCurrentSongMethod;
import com.larus.music.applet.qqmusic.impl.GetQQMusicFavouriteListMethod;
import com.larus.music.applet.qqmusic.impl.GetQQMusicIsFavouriteMidMethod;
import com.larus.music.applet.qqmusic.impl.GetQQMusicLyricMethod;
import com.larus.music.applet.qqmusic.impl.GetQQMusicStatusMethod;
import com.larus.music.applet.qqmusic.impl.GetQQPlaybackTimeMethod;
import com.larus.music.applet.qqmusic.impl.GetQQSongListMethod;
import com.larus.music.applet.qqmusic.impl.OpenMusicAuthModalMethod;
import com.larus.music.applet.qqmusic.impl.PauseQQMusicMethod;
import com.larus.music.applet.qqmusic.impl.PlayQQMusicMethod;
import com.larus.music.applet.qqmusic.impl.RemoveQQMusicFavouriteMethod;
import com.larus.music.applet.qqmusic.impl.ReplayMethod;
import com.larus.music.applet.qqmusic.impl.ResumeQQMusicMethod;
import com.larus.music.applet.qqmusic.impl.SearchQQMusicMethod;
import com.larus.music.applet.qqmusic.impl.SetQQMusicPlayModeMethod;
import com.larus.music.applet.qqmusic.impl.SetQQMusicPlaybackTimeMethod;
import com.larus.music.applet.qqmusic.impl.StopQQMusicMethod;
import com.larus.music.i;
import com.larus.office.base.host.o;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.ISdkTitleBarInflate;
import com.larus.platform.api.r2;
import com.larus.platform.api.v2;
import com.larus.platform.api.z2;
import com.larus.platform.api.z3;
import com.larus.video.api.VideoService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import f3.k;
import java.util.ArrayList;
import java.util.Iterator;
import jm9.c;
import kc9.e;
import kotlin.Metadata;
import ml9.a;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000Ê\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020+H\u0016J\n\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0010\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0016J\n\u00102\u001a\u0004\u0018\u000103H\u0016J\b\u00104\u001a\u000205H\u0016J\b\u00106\u001a\u000207H\u0016J\b\u00108\u001a\u000209H\u0016J\n\u0010:\u001a\u0004\u0018\u00010;H\u0016J\b\u0010<\u001a\u00020=H\u0016J\b\u0010>\u001a\u00020?H\u0016J\b\u0010@\u001a\u00020AH\u0016J\b\u0010B\u001a\u00020CH\u0016J\b\u0010D\u001a\u00020EH\u0016J\b\u0010F\u001a\u00020GH\u0016J\b\u0010H\u001a\u00020IH\u0016J\b\u0010J\u001a\u00020KH\u0016J\b\u0010L\u001a\u00020MH\u0016J\n\u0010N\u001a\u0004\u0018\u00010OH\u0016J\n\u0010P\u001a\u0004\u0018\u00010QH\u0016J\n\u0010R\u001a\u0004\u0018\u00010SH\u0016J\n\u0010T\u001a\u0004\u0018\u00010UH\u0016J\n\u0010V\u001a\u0004\u0018\u00010WH\u0016J\n\u0010X\u001a\u0004\u0018\u00010YH\u0016J\n\u0010Z\u001a\u0004\u0018\u00010[H\u0016J\b\u0010\\\u001a\u00020]H\u0016J\n\u0010^\u001a\u0004\u0018\u00010_H\u0016J\b\u0010`\u001a\u00020aH\u0016J\n\u0010b\u001a\u0004\u0018\u00010cH\u0016J\n\u0010d\u001a\u0004\u0018\u00010eH\u0016J\b\u0010f\u001a\u00020gH\u0016J\b\u0010h\u001a\u00020iH\u0016J\b\u0010j\u001a\u00020kH\u0016J\n\u0010l\u001a\u0004\u0018\u00010mH\u0016J\b\u0010n\u001a\u00020oH\u0016J\b\u0010p\u001a\u00020qH\u0016J\b\u0010r\u001a\u00020sH\u0016J\b\u0010t\u001a\u00020uH\u0016J\b\u0010v\u001a\u00020wH\u0016J\b\u0010x\u001a\u00020yH\u0016J\b\u0010z\u001a\u00020{H\u0016J\b\u0010|\u001a\u00020}H\u0016J\b\u0010~\u001a\u00020\u007fH\u0016J\n\u0010\u0080\u0001\u001a\u00030\u0081\u0001H\u0016J\n\u0010\u0082\u0001\u001a\u00030\u0083\u0001H\u0016J\n\u0010\u0084\u0001\u001a\u00030\u0085\u0001H\u0016J\n\u0010\u0086\u0001\u001a\u00030\u0087\u0001H\u0016J\n\u0010\u0088\u0001\u001a\u00030\u0089\u0001H\u0016J\n\u0010\u008a\u0001\u001a\u00030\u008b\u0001H\u0016J\n\u0010\u008c\u0001\u001a\u00030\u008d\u0001H\u0016J\n\u0010\u008e\u0001\u001a\u00030\u008f\u0001H\u0016J\t\u0010\u0090\u0001\u001a\u00020qH\u0016J\t\u0010\u0091\u0001\u001a\u00020qH\u0016J\f\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u0001H\u0016J\f\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0095\u0001H\u0016J\f\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0097\u0001H\u0016J\f\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0099\u0001H\u0016J\f\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u009b\u0001H\u0016J\f\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u009d\u0001H\u0016J\f\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009f\u0001H\u0016J\n\u0010 \u0001\u001a\u00030¡\u0001H\u0016J\n\u0010¢\u0001\u001a\u00030£\u0001H\u0016J\f\u0010¤\u0001\u001a\u0005\u0018\u00010¥\u0001H\u0016J\f\u0010¦\u0001\u001a\u0005\u0018\u00010§\u0001H\u0016J\f\u0010¨\u0001\u001a\u0005\u0018\u00010©\u0001H\u0016J\f\u0010ª\u0001\u001a\u0005\u0018\u00010«\u0001H\u0016J\f\u0010¬\u0001\u001a\u0005\u0018\u00010\u00ad\u0001H\u0016J\f\u0010®\u0001\u001a\u0005\u0018\u00010¯\u0001H\u0016J\f\u0010°\u0001\u001a\u0005\u0018\u00010±\u0001H\u0016J\f\u0010²\u0001\u001a\u0005\u0018\u00010³\u0001H\u0016J\f\u0010´\u0001\u001a\u0005\u0018\u00010µ\u0001H\u0016J\f\u0010¶\u0001\u001a\u0005\u0018\u00010·\u0001H\u0016J\f\u0010¸\u0001\u001a\u0005\u0018\u00010¹\u0001H\u0016J\f\u0010º\u0001\u001a\u0005\u0018\u00010»\u0001H\u0016J\n\u0010¼\u0001\u001a\u00030½\u0001H\u0016J\n\u0010¾\u0001\u001a\u00030¿\u0001H\u0016J\n\u0010À\u0001\u001a\u00030Á\u0001H\u0016J\f\u0010Â\u0001\u001a\u0005\u0018\u00010Ã\u0001H\u0016J\n\u0010Ä\u0001\u001a\u00030§\u0001H\u0016¨\u0006Å\u0001"}, d2 = {"Lcom/larus/home/impl/sdk/FlowSdkDependImpl;", "Lcom/larus/platform/IFlowSdkDepend;", "<init>", "()V", "getChatListHostAbilityService", "Lcom/larus/home/impl/sdk/chat/ChatListHostAbilityImpl;", "getHolderService", "Lcom/larus/platform/api/ISdkHolderHanlder;", "getClipBoardService", "Lcom/larus/home/impl/sdk/SdkClipboardImpl;", "getLinkService", "Lcom/larus/platform/api/ISdkLinkHanlder;", "getMessageFilter", "Lcom/larus/platform/api/ISdkMessageFilter;", "getAccountService", "Lcom/larus/home/impl/sdk/AccountServiceImpl;", "getCommerceCreditService", "Lcom/larus/home/impl/sdk/CommerceCreditServiceImpl;", "getCommerceMembershipService", "Lcom/larus/home/impl/sdk/CommerceMembershipServiceImpl;", "getMinorService", "Lcom/larus/home/impl/sdk/MinorModeServiceImpl;", "getPrivacyService", "Lcom/larus/home/impl/sdk/PrivacySdkServiceImpl;", "getSecuritySdkService", "Lcom/larus/home/impl/sdk/SecuritySdkServiceImpl;", "getSettingsService", "Lcom/larus/home/impl/sdk/SettingsServiceImpl;", "getPerformanceService", "Lcom/larus/home/impl/sdk/SdkPerformanceImpl;", "getResourceService", "Lcom/larus/home/impl/sdk/ResourceServiceImpl;", "getBuildConfigService", "Lcom/larus/home/impl/sdk/BuildConfigServiceImpl;", "getDebugService", "Lcom/larus/home/impl/sdk/DebugServiceImpl;", "getNavigationService", "Lcom/larus/home/impl/sdk/NavigationServiceImpl;", "getHttpConfigService", "Lcom/larus/home/impl/sdk/HttpConfigServiceImpl;", "getAccessibilityService", "Lcom/larus/platform/api/ISdkAccessibility;", "getLocationService", "Lcom/larus/home/impl/sdk/LocationServiceImpl;", "getAppletLocationService", "Lcom/larus/home/impl/sdk/AppletLocationServiceImpl;", "getFrontierService", "Lcom/larus/home/impl/sdk/SdkFrontierService;", "serviceId", XmlPullParser.NO_NAMESPACE, "getTitleBarInflateService", "Lcom/larus/platform/api/ISdkTitleBarInflate;", "getTouristService", "Lcom/larus/home/impl/sdk/TouristServiceImpl;", "getAudioSdkDepend", "Lcom/larus/home/impl/sdk/AudioSdkDependImpl;", "getAudioService", "Lcom/larus/platform/api/IAudioService;", "getCameraSdkDepend", XmlPullParser.NO_NAMESPACE, "getLottieCompatService", "Lcom/larus/home/impl/sdk/LottieCompatServiceImpl;", "getSamiServerParamService", "Lcom/larus/home/impl/sdk/SamiServerParamServiceImpl;", "getTtcnpaInitService", "Lcom/larus/home/impl/sdk/TtcnpaInitServiceImpl;", "getPermissionService", "Lcom/larus/platform/api/IPermission;", "getMainPageLifecycleCallbackService", "Lcom/larus/platform/api/IMainPageLifecycleCallback;", "getMapService", "Lcom/larus/platform/api/ISdkMap;", "getAMapNaviService", "Lcom/larus/home/impl/sdk/AMapNaviServiceImpl;", "getIvykitService", "Lcom/larus/platform/api/ISdkIvykit;", "getTTVideoEngineStaticService", "Lcom/larus/platform/api/ITTVideoEngineStaticService;", "getSettingsConfigService", "Lcom/larus/platform/api/ISdkSettingsConfig;", "getGeckoService", "Lcom/larus/platform/api/ISdkGecko;", "getUgcBotService", "Lcom/larus/platform/api/ISdkUgcBotService;", "getCreationService", "Lcom/larus/platform/api/ISdkCreationService;", "getUgService", "Lcom/larus/platform/api/ISdkUg;", "getOverseaPayService", "Lcom/larus/platform/api/IOverseaPay;", "getBottomTabService", "Lcom/larus/platform/api/ISdkBottomTab;", "getVideoPlayer", "Lcom/larus/platform/api/IAudioPlayController;", "getMediaEngine", "Lcom/larus/platform/api/IMediaEngine;", "getNotifyService", "Lcom/larus/home/impl/sdk/SdkNotifyServiceImpl;", "getCaseService", "Lcom/larus/platform/api/ISdkCaseService;", "getLogoutService", "Lcom/larus/platform/api/ILogoutService;", "getSearchService", "Lcom/larus/home/impl/sdk/SdkSearchServiceImpl;", "getSdkBusinessSettingService", "Lcom/larus/setting/api/BusinessSettingServiceImpl;", "getSdkMainBotSettingService", "Lcom/larus/home/impl/sdk/MainBotSettingsServiceImpl;", "getAppletService", "Lcom/larus/platform/api/IFlowAppletService;", "getSdkBusinessMusicService", "Lcom/larus/music/BusinessMusicServiceImpl;", "registerQQMusicAppletBridges", XmlPullParser.NO_NAMESPACE, "getDoraAudioManager", "Lcom/larus/platform/api/ISdkDoraApi;", "getTickService", "Lcom/larus/home/impl/sdk/TickServiceImpl;", "getCollectService", "Lcom/larus/platform/api/ISdkCollectService;", "getAppletJsbEventService", "Lcom/larus/platform/api/IAppletJsbEventService;", "getPhotoPickerService", "Lcom/larus/platform/api/ISdkPhotoPicker;", "getSlidesService", "Lcom/larus/platform/api/ISdkSlides;", "getCJPayService", "Lcom/larus/platform/api/ISdkCJPay;", "getEnterpriseService", "Lcom/larus/platform/api/ISdkEnterprise;", "getStoreRegionService", "Lcom/larus/platform/api/ISdkStoreRegion;", "getSheetsService", "Lcom/larus/platform/api/ISdkSheets;", "getBitableService", "Lcom/larus/platform/api/ISdkBitable;", "getMarkdownService", "Lcom/larus/platform/api/ISdkMarkdown;", "getPadService", "Lcom/larus/platform/api/ISdkPadService;", "getPerfDegradeService", "Lcom/larus/home/impl/sdk/SdkPerfDegradeServiceImpl;", "getPushService", "Lcom/larus/platform/api/ISdkPushService;", "isDoraNotifyEnabled", "isFirstStartApp", "getAlbumService", "Lcom/larus/platform/api/ISdkAlbumService;", "getFlowTraceService", "Lcom/larus/platform/api/IFlowTraceService;", "getEffectPlatformService", "Lcom/larus/platform/api/IFlowEffectPlatformService;", "getVeSdkService", "Lcom/larus/platform/api/IVeSdkService;", "getSdkDocService", "Lcom/larus/platform/api/ISdkDocService;", "getLarkSocialService", "Lcom/larus/platform/api/ILarkSocialService;", "getLarkofficeService", "Lcom/larus/platform/api/ILarkofficeService;", "getSdkBrowserService", "Lcom/larus/platform/api/ISdkBrowserService;", "getSdkUploaderService", "Lcom/larus/platform/api/ISdkUploaderService;", "getChatService", "Lcom/larus/platform/api/IChatService;", "getDebugVipFeatureKey", XmlPullParser.NO_NAMESPACE, "getDiskService", "Lcom/larus/platform/api/ISdkDiskService;", "getHomeSdkService", "Lcom/larus/platform/api/IHomeSdkService;", "getDigitalAvatarService", "Lcom/larus/platform/api/creation/ISdkDigitalAvatarService;", "getFontService", "Lcom/larus/platform/api/ISdkFontService;", "getSuggestActionService", "Lcom/larus/platform/api/ISdkSuggestActionService;", "getSdkMinutesService", "Lcom/larus/platform/api/ISdkMinutesService;", "getOfficeAuthService", "Lcom/larus/platform/api/IFlowOfficeAuthService;", "getSdkOfficeService", "Lcom/larus/platform/api/ISdkOfficeService;", "getSdkWatermarkService", "Lcom/larus/platform/api/ISdkWatermarkService;", "getAIGCMetadataCheckService", "Lcom/larus/platform/api/ISdkAIGCMetadataCheck;", "getLocalLifeService", "Lcom/larus/home/impl/sdk/LocalLifeServiceImpl;", "getCalendarService", "Lcom/larus/home/impl/sdk/CalendarServiceImpl;", "getXBridgeService", "Lcom/larus/home/impl/sdk/SdkXBridgeServiceImpl;", "getECommerceService", "Lcom/larus/home/impl/sdk/ECommerceServiceImpl;", "getECommerceLearnMoreUrl", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class FlowSdkDependImpl implements IFlowSdkDepend {
    public FlowSdkDependImpl() {
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void G() {
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void M() {
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void X() {
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void c0() {
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void m() {
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void v() {
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final /* bridge */ /* synthetic */ void x() {
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final r2 A0() {
        return VideoService.a.g();
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final String F0() {
        IDebugService r0 = (IDebugService) ServiceManager.get().getService(IDebugService.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.B();
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final FlowLarkSocialServiceImpl J() {
        return new FlowLarkSocialServiceImpl();
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final z2 O() {
        return IMinorService.a.e();
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final v2 Y() {
        return IMinorService.a.g();
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final z3 c() {
        return VideoService.a.c();
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void n0() {
        ArrayList r0 = new ArrayList();
        r0.add(AddQQMusicFavouriteMethod.class);
        r0.add(GetQQFolderListMethod.class);
        r0.add(CheckQQMusicAuthStatusMethod.class);
        r0.add(GetQQMusicCurrentSongMethod.class);
        r0.add(GetQQMusicFavouriteListMethod.class);
        r0.add(GetQQMusicIsFavouriteMidMethod.class);
        r0.add(GetQQMusicLyricMethod.class);
        r0.add(GetQQMusicStatusMethod.class);
        r0.add(GetQQPlaybackTimeMethod.class);
        r0.add(ReplayMethod.class);
        r0.add(GetQQSongListMethod.class);
        r0.add(OpenMusicAuthModalMethod.class);
        r0.add(PauseQQMusicMethod.class);
        r0.add(PlayQQMusicMethod.class);
        r0.add(RemoveQQMusicFavouriteMethod.class);
        r0.add(ResumeQQMusicMethod.class);
        r0.add(SearchQQMusicMethod.class);
        r0.add(SetQQMusicPlaybackTimeMethod.class);
        r0.add(SetQQMusicPlayModeMethod.class);
        r0.add(StopQQMusicMethod.class);
        r0.add(GetQQDayRecommendSongListMethod.class);
        int r1 = a.a;
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        Class r3 = (Class) r2.next();
        k.b.b(r3);
        goto L4
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final boolean o0() {
        c r0 = c.a;
        return c.b();
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final r0 p0() {
        return new r0();
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final s s0() {
        return new s();
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final ISdkTitleBarInflate t0() {
        return (ISdkTitleBarInflate) ServiceManager.get().getService(ISdkTitleBarInflate.class);
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final o u() {
        int r0 = e.a;
        return new o();
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final f w0() {
        if (ServiceManager.get().getService(LocationService.class) != null) goto L7;
        return null;
    L7:
        return f.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final v z0() {
        if (ServiceManager.get().getService(IECommerceService.class) != null) goto L7;
        return null;
    L7:
        return v.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void A() {
        m1 r0 = m1.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void B0() {
        x0 r0 = x0.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void C() {
        z r0 = z.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void C0() {
        hc9.d r0 = hc9.d.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void D() {
        x1 r0 = x1.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void D0() {
        b1 r0 = b1.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void E() {
        w1 r0 = w1.b;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void E0() {
        SdkSlidesServiceImpl r0 = SdkSlidesServiceImpl.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final OfficeAuthServiceImpl F() {
        return OfficeAuthServiceImpl.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void G0() {
        b r0 = b.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void H() {
        l1 r0 = l1.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void H0() {
        z1 r0 = z1.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void I() {
        com.larus.setting.api.a r0 = com.larus.setting.api.a.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void I0() {
        q1 r0 = q1.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void J0() {
        m r0 = m.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void K() {
        e0 r0 = e0.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void K0() {
        i r0 = i.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void L() {
        t0 r0 = t0.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void N() {
        n1 r0 = n1.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void P() {
        ChatServiceImpl r0 = ChatServiceImpl.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void Q() {
        g2 r0 = g2.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void R() {
        d2 r0 = d2.b;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void S() {
        c1 r0 = c1.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void T() {
        h2 r0 = h2.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void U() {
        s0 r0 = s0.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void V() {
        g0 r0 = g0.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void W() {
        a1 r0 = a1.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void Z() {
        h0 r0 = h0.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void a() {
        o r0 = o.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void a0() {
        g r0 = g.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void b() {
        a2 r0 = a2.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void b0() {
        ap9.a r0 = ap9.a.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void d() {
        h r0 = h.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void d0() {
        i1 r0 = i1.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void e0() {
        f1 r0 = f1.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void f() {
        y0 r0 = y0.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void f0() {
        i r0 = i.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void g() {
        d1 r0 = d1.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final FlowAppletServiceImpl g0() {
        return FlowAppletServiceImpl.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void getAccountService() {
        d r0 = d.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void getCalendarService() {
        k r0 = k.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void getCollectService() {
        j1 r0 = j1.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void getLocationService() {
        f0 r0 = f0.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final w0 getPermissionService() {
        return w0.b;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void getPhotoPickerService() {
        b2 r0 = b2.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void h() {
        SdkSheetsServiceImpl r0 = SdkSheetsServiceImpl.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void h0() {
        h1 r0 = h1.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void i() {
        u2 r0 = u2.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void i0() {
        y r0 = y.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void j() {
        r1 r0 = r1.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void j0() {
        y1 r0 = y1.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void k() {
        n r0 = n.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void k0() {
        g1 r0 = g1.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void l() {
        q0 r0 = q0.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void l0() {
        s2 r0 = s2.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void m0() {
        SdkWatermarkServiceImpl r0 = SdkWatermarkServiceImpl.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void n() {
        i2a.b r0 = i2a.b.b;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void o() {
        c2 r0 = c2.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void p() {
        j r0 = j.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void q() {
        a r0 = a.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void q0() {
        b0 r0 = b0.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void r() {
        mc9.a r0 = mc9.a.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void r0() {
        e2 r0 = e2.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void s() {
        e r0 = e.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void t() {
        o1 r0 = o1.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void u0() {
        r2 r0 = r2.b;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void v0() {
        t2 r0 = t2.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void w() {
        k1 r0 = k1.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final o2 x0() {
        return o2.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void y() {
        t1 r0 = t1.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void y0() {
        q2 r0 = q2.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final void z() {
        p0 r0 = p0.a;
    }

    @Override // com.larus.platform.IFlowSdkDepend
    public final p1 B(int r2) {
        return new p1(r2);
    }
}
