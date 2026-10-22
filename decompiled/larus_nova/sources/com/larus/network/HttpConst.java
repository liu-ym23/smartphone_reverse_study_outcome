package com.larus.network;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\bp\n\u0002\u0010 \n\u0002\b\u001f\n\u0002\u0010\"\n\u0002\b\u0017\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010c\u001a\u00020\u0006H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0014\u0010\u000f\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\bR\u0014\u0010\u0011\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\bR\u0014\u0010\u0013\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\bR\u0014\u0010\u0015\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\bR\u0014\u0010\u0017\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\bR\u0014\u0010\u0019\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\bR\u0014\u0010\u001b\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\bR\u0014\u0010\u001d\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\bR\u0014\u0010\u001f\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\bR\u0014\u0010!\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\bR\u0014\u0010#\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\bR\u0014\u0010%\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\bR\u0014\u0010'\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\bR\u0014\u0010)\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\bR\u0014\u0010+\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\bR\u0014\u0010-\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\bR\u0014\u0010/\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\bR\u0014\u00101\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\bR\u0014\u00103\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\bR\u0014\u00105\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\bR\u0014\u00107\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\bR\u0014\u00109\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\bR\u0014\u0010;\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\bR\u0014\u0010=\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\bR\u0014\u0010?\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010\bR\u0014\u0010A\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010\bR\u0014\u0010C\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010\bR\u0014\u0010E\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010\bR\u0014\u0010G\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010\bR\u0014\u0010I\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010\bR\u0014\u0010K\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u0010\bR\u0014\u0010M\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bN\u0010\bR\u0014\u0010O\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bP\u0010\bR\u0014\u0010Q\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bR\u0010\bR\u0014\u0010S\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bT\u0010\bR\u0014\u0010U\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bV\u0010\bR\u0014\u0010W\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bX\u0010\bR\u0014\u0010Y\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010\bR\u0014\u0010[\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010\bR\u0014\u0010]\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b^\u0010\bR\u0014\u0010_\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b`\u0010\bR\u0014\u0010a\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bb\u0010\bR\u0014\u0010d\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\be\u0010\bR\u0014\u0010f\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bg\u0010\bR\u0014\u0010h\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bi\u0010\bR\u0014\u0010j\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bk\u0010\bR\u0014\u0010l\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bm\u0010\bR\u0014\u0010n\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bo\u0010\bR\u0014\u0010p\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bq\u0010\bR\u0014\u0010r\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bs\u0010\bR\u0014\u0010t\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bu\u0010\bR\u001a\u0010v\u001a\b\u0012\u0004\u0012\u00020\u00060wX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bx\u0010yR\u001a\u0010z\u001a\b\u0012\u0004\u0012\u00020\u00060wX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b{\u0010yR\u0014\u0010|\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b}\u0010\bR\u0014\u0010~\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u007f\u0010\bR\u0016\u0010\u0080\u0001\u001a\u00020\u0006X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0081\u0001\u0010\bR\u0016\u0010\u0082\u0001\u001a\u00020\u0006X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0083\u0001\u0010\bR\u0016\u0010\u0084\u0001\u001a\u00020\u0006X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0085\u0001\u0010\bR\u0016\u0010\u0086\u0001\u001a\u00020\u0006X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0087\u0001\u0010\bR\u0016\u0010\u0088\u0001\u001a\u00020\u0006X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0089\u0001\u0010\bR\u0016\u0010\u008a\u0001\u001a\u00020\u0006X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u008b\u0001\u0010\bR\u0016\u0010\u008c\u0001\u001a\u00020\u0006X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u008d\u0001\u0010\bR\u0016\u0010\u008e\u0001\u001a\u00020\u0006X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u008f\u0001\u0010\bR\u0016\u0010\u0090\u0001\u001a\u00020\u0006X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0091\u0001\u0010\bR\u0016\u0010\u0092\u0001\u001a\u00020\u0006X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0093\u0001\u0010\bR\u0016\u0010\u0094\u0001\u001a\u00020\u0006X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0095\u0001\u0010\bR\u001e\u0010\u0096\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060\u0097\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001R\u0016\u0010\u009a\u0001\u001a\u00020\u0006X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u009b\u0001\u0010\bR\u0016\u0010\u009c\u0001\u001a\u00020\u0006X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u009d\u0001\u0010\bR\u0016\u0010\u009e\u0001\u001a\u00020\u0006X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u009f\u0001\u0010\bR\u0016\u0010 \u0001\u001a\u00020\u0006X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b¡\u0001\u0010\bR\u0016\u0010¢\u0001\u001a\u00020\u0006X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b£\u0001\u0010\bR\u0016\u0010¤\u0001\u001a\u00020\u0006X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b¥\u0001\u0010\bR\u0016\u0010¦\u0001\u001a\u00020\u0006X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b§\u0001\u0010\bR\u0016\u0010¨\u0001\u001a\u00020\u0006X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b©\u0001\u0010\bR\u0016\u0010ª\u0001\u001a\u00020\u0006X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b«\u0001\u0010\bR\u0016\u0010¬\u0001\u001a\u00020\u0006X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u00ad\u0001\u0010\b¨\u0006®\u0001"}, d2 = {"Lcom/larus/network/HttpConst;", "Lcom/larus/network/IHttpConst;", "<init>", "()V", "inst", "ONLINE_BASE_HOST", "", "getONLINE_BASE_HOST", "()Ljava/lang/String;", "ONLINE_BASE_HOST_API", "getONLINE_BASE_HOST_API", "ONLINE_WWW_HOST", "getONLINE_WWW_HOST", "ONLINE_WWW_HOST_API", "getONLINE_WWW_HOST_API", "ONLINE_WWW", "getONLINE_WWW", "ONLINE_WWW_API", "getONLINE_WWW_API", "ONLINE_HOST", "getONLINE_HOST", "ONLINE_HOST_API", "getONLINE_HOST_API", "ONLINE_HOST_FOR_SETTINGS", "getONLINE_HOST_FOR_SETTINGS", "ONLINE", "getONLINE", "ONLINE_API", "getONLINE_API", "APPLET_DEBUGGER_BASE_URL", "getAPPLET_DEBUGGER_BASE_URL", "BOE_HOST", "getBOE_HOST", "BOE", "getBOE", "SAMI_WSS_HOST", "getSAMI_WSS_HOST", "ENTERPRISE_SAMI_WSS_HOST", "getENTERPRISE_SAMI_WSS_HOST", "SAMI_WSS_QUIC_HOST", "getSAMI_WSS_QUIC_HOST", "ENTERPRISE_SAMI_WSS_QUIC_HOST", "getENTERPRISE_SAMI_WSS_QUIC_HOST", "SHARE_PASSPORT_LOGIN_TOKEN", "getSHARE_PASSPORT_LOGIN_TOKEN", "MSSDK_PASSPORT_TOKEN", "getMSSDK_PASSPORT_TOKEN", "MSSDK_PASSPORT_TOKEN_Z", "getMSSDK_PASSPORT_TOKEN_Z", "PRAISE_DIALOG_SDK_HOST", "getPRAISE_DIALOG_SDK_HOST", "COZE_PLATFORM_HOST", "getCOZE_PLATFORM_HOST", "ASSIST_CENTER_HOST", "getASSIST_CENTER_HOST", "AI_APPLET_JSB_HOST", "getAI_APPLET_JSB_HOST", "BAIKE_JSB_HOST", "getBAIKE_JSB_HOST", "FEEDBACK_BASE_URL", "getFEEDBACK_BASE_URL", "FEEDBACK_SOURCE_LOGIN", "getFEEDBACK_SOURCE_LOGIN", "FEEDBACK_SOURCE_SETTING", "getFEEDBACK_SOURCE_SETTING", "FEEDBACK_SOURCE_PAYMENT", "getFEEDBACK_SOURCE_PAYMENT", "FEEDBACK_SOURCE_PRAISE", "getFEEDBACK_SOURCE_PRAISE", "FEEDBACK_SOURCE_REBIND_PHONE_NUMBER", "getFEEDBACK_SOURCE_REBIND_PHONE_NUMBER", "FEEDBACK_SOURCE_PHONE_NUMBER_INACTIVE", "getFEEDBACK_SOURCE_PHONE_NUMBER_INACTIVE", "configLibraUrl", "getConfigLibraUrl", "configDeepLinkUrl", "getConfigDeepLinkUrl", "termsUrl", "getTermsUrl", "privacyUrl", "getPrivacyUrl", "privacyAccountUrl", "getPrivacyAccountUrl", "privacyAbsUrl", "getPrivacyAbsUrl", "memoryFaqUrl", "getMemoryFaqUrl", "legalFaqUrl", "getLegalFaqUrl", "faceMemoryPrivacyUrl", "getFaceMemoryPrivacyUrl", "privacyNewUrl", "getPrivacyNewUrl", "trustCenterUrl", "getTrustCenterUrl", "ONLINE_RTC_SERVER_MESSAGE_DOMAIN", "getONLINE_RTC_SERVER_MESSAGE_DOMAIN", "TEST_RTC_SERVER_MESSAGE_DOMAIN", "getTEST_RTC_SERVER_MESSAGE_DOMAIN", "secLink", "ALICE_BOE_HOST", "getALICE_BOE_HOST", "ACCOUNTT_BOE_HOST", "getACCOUNTT_BOE_HOST", "accountSettingUrl", "getAccountSettingUrl", "deviceManagementUrl", "getDeviceManagementUrl", "personUrl", "getPersonUrl", "denoisePrivacyUrl", "getDenoisePrivacyUrl", "accessibilitySdkDebugUrl", "getAccessibilitySdkDebugUrl", "doubaoOfficialWebsite", "getDoubaoOfficialWebsite", "toutiaoArticleUrl", "getToutiaoArticleUrl", "authorizationWhiteList", "", "getAuthorizationWhiteList", "()Ljava/util/List;", "authorizationPathWhiteList", "getAuthorizationPathWhiteList", "ecommerceQualificationRulesUrl", "getEcommerceQualificationRulesUrl", "shoppingPaymentFaqUrl", "getShoppingPaymentFaqUrl", "locallifePlatformQualificationUrl", "getLocallifePlatformQualificationUrl", "locallifeUserAgreementUrl", "getLocallifeUserAgreementUrl", "locallifePrivacyAgreementUrl", "getLocallifePrivacyAgreementUrl", "locallifeRuleCenterUrl", "getLocallifeRuleCenterUrl", "avatarOnboardingVideoModelString", "getAvatarOnboardingVideoModelString", "avatarOnboardingVideoCoverUrl", "getAvatarOnboardingVideoCoverUrl", "avatarTutorialAudioUrl", "getAvatarTutorialAudioUrl", "loggingDLPUrl", "getLoggingDLPUrl", "accountBanAppealUrl", "getAccountBanAppealUrl", "thirdAppSettingsUrl", "getThirdAppSettingsUrl", "BASE_LARK_HOST", "getBASE_LARK_HOST", "ENV_HEADER_EXCLUDED_HOSTS", "", "getENV_HEADER_EXCLUDED_HOSTS", "()Ljava/util/Set;", "GECKO_HOST", "getGECKO_HOST", "BYTEGECKO_HOST_SUFFIX", "getBYTEGECKO_HOST_SUFFIX", "MAIN_APP_HOST_SUFFIX", "getMAIN_APP_HOST_SUFFIX", "SAMI_BOE_HOST", "getSAMI_BOE_HOST", "BOE_WWW_HOST", "getBOE_WWW_HOST", "WSS_NORMAL_HOST", "getWSS_NORMAL_HOST", "WSS100_NORMAL_HOST", "getWSS100_NORMAL_HOST", "WSS_NORMAL_BOE_HOST", "getWSS_NORMAL_BOE_HOST", "WS_SAMANTHA_HOST", "getWS_SAMANTHA_HOST", "WS_SAMANTHA_BOE_HOST", "getWS_SAMANTHA_BOE_HOST", "ttnet_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HttpConst implements IHttpConst {
    public static final String A = null;
    public static final String A0 = null;
    public static final String B = null;
    public static final String B0 = null;
    public static final String C = null;
    public static final String C0 = null;
    public static final String D = null;
    public static final String D0 = null;
    public static final String E = null;
    public static final String E0 = null;
    public static final String F = null;
    public static final String G = null;
    public static final String H = null;
    public static final String I = null;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final String f359978J = null;
    public static final String K = null;
    public static final String L = null;
    public static final String M = null;
    public static final String N = null;
    public static final String O = null;
    public static final String P = null;
    public static final String Q = null;
    public static final String R = null;
    public static final String S = null;
    public static final String T = null;
    public static final String U = null;
    public static final String V = null;
    public static final String W = null;
    public static final String X = null;
    public static final String Y = null;
    public static final String Z = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HttpConst f359979a = null;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final String f359980a0 = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final IHttpConst f359981b = null;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final String f359982b0 = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f359983c = null;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final String f359984c0 = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f359985d = null;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final String f359986d0 = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f359987e = null;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final String f359988e0 = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f359989f = null;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final List<String> f359990f0 = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f359991g = null;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final List<String> f359992g0 = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f359993h = null;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final String f359994h0 = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f359995i = null;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final String f359996i0 = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f359997j = null;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final String f359998j0 = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f359999k = null;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final String f360000k0 = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f360001l = null;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public static final String f360002l0 = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f360003m = null;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final String f360004m0 = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f360005n = null;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static final String f360006n0 = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f360007o = null;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public static final String f360008o0 = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f360009p = null;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final String f360010p0 = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f360011q = null;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public static final String f360012q0 = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f360013r = null;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public static final String f360014r0 = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f360015s = null;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public static final String f360016s0 = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f360017t = null;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public static final String f360018t0 = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f360019u = null;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public static final Set<String> f360020u0 = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f360021v = null;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public static final String f360022v0 = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f360023w = null;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public static final String f360024w0 = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f360025x = null;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public static final String f360026x0 = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f360027y = null;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public static final String f360028y0 = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f360029z = null;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public static final String f360030z0 = null;

    private HttpConst() {
    }

    static {
        f359979a = new HttpConst();
        IHttpConst r100 = (IHttpConst) ServiceManager.get().getService(IHttpConst.class);
        f359981b = r100;
        String r101 = "";
        if (r100 == null) goto L6;
        String r102 = r100.d();
        if (r102 == null) goto L6;
    L7:
        f359983c = r102;
        if (r100 == null) goto L11;
        String r103 = r100.q();
        if (r103 == null) goto L11;
    L12:
        f359985d = r103;
        if (r100 == null) goto L16;
        String r104 = r100.h();
        if (r104 == null) goto L16;
    L17:
        f359987e = r104;
        if (r100 == null) goto L21;
        String r105 = r100.n();
        if (r105 == null) goto L21;
    L22:
        f359989f = r105;
        if (r100 == null) goto L26;
        String r106 = r100.A0();
        if (r106 == null) goto L26;
    L27:
        f359991g = r106;
        if (r100 == null) goto L31;
        String r107 = r100.x();
        if (r107 == null) goto L31;
    L32:
        f359993h = r107;
        if (r100 == null) goto L36;
        String r108 = r100.P();
        if (r108 == null) goto L36;
    L37:
        f359995i = r108;
        if (r100 == null) goto L41;
        String r109 = r100.n0();
        if (r109 == null) goto L41;
    L42:
        f359997j = r109;
        if (r100 == null) goto L48;
        String r110 = r100.V();
        if (r110 == null) goto L48;
        r108 = r110;
    L48:
        f359999k = r108;
        if (r100 == null) goto L52;
        String r111 = r100.x0();
        if (r111 == null) goto L52;
    L53:
        f360001l = r111;
        if (r100 == null) goto L57;
        String r112 = r100.c();
        if (r112 == null) goto L57;
    L58:
        f360003m = r112;
        if (r100 == null) goto L62;
        String r113 = r100.s();
        if (r113 == null) goto L62;
    L63:
        f360005n = r113;
        if (r100 == null) goto L67;
        String r114 = r100.B();
        if (r114 == null) goto L67;
    L68:
        f360007o = r114;
        if (r100 == null) goto L72;
        String r115 = r100.e();
        if (r115 == null) goto L72;
    L73:
        f360009p = r115;
        if (r100 == null) goto L77;
        String r116 = r100.Q();
        if (r116 == null) goto L77;
    L78:
        f360011q = r116;
        if (r100 == null) goto L82;
        String r117 = r100.k0();
        if (r117 == null) goto L82;
    L83:
        f360013r = r117;
        if (r100 == null) goto L87;
        String r118 = r100.i0();
        if (r118 == null) goto L87;
    L88:
        f360015s = r118;
        if (r100 == null) goto L92;
        String r119 = r100.h0();
        if (r119 == null) goto L92;
    L93:
        f360017t = r119;
        if (r100 == null) goto L97;
        String r120 = r100.e0();
        if (r120 == null) goto L97;
    L98:
        f360019u = r120;
        if (r100 == null) goto L102;
        String r121 = r100.v();
        if (r121 == null) goto L102;
    L103:
        f360021v = r121;
        if (r100 == null) goto L107;
        String r122 = r100.f();
        if (r122 == null) goto L107;
    L108:
        f360023w = r122;
        if (r100 == null) goto L112;
        String r123 = r100.Y();
        if (r123 == null) goto L112;
    L113:
        f360025x = r123;
        if (r100 == null) goto L117;
        String r124 = r100.p0();
        if (r124 == null) goto L117;
    L118:
        f360027y = r124;
        if (r100 == null) goto L122;
        String r125 = r100.A();
        if (r125 == null) goto L122;
    L123:
        f360029z = r125;
        if (r100 == null) goto L127;
        String r126 = r100.k();
        if (r126 == null) goto L127;
    L128:
        A = r126;
        if (r100 == null) goto L132;
        String r127 = r100.Z();
        if (r127 == null) goto L132;
    L133:
        B = r127;
        if (r100 == null) goto L137;
        String r128 = r100.l0();
        if (r128 == null) goto L137;
    L138:
        C = r128;
        if (r100 == null) goto L142;
        String r129 = r100.l();
        if (r129 == null) goto L142;
    L143:
        D = r129;
        if (r100 == null) goto L147;
        String r130 = r100.m0();
        if (r130 == null) goto L147;
    L148:
        E = r130;
        if (r100 == null) goto L152;
        String r131 = r100.R();
        if (r131 == null) goto L152;
    L153:
        F = r131;
        if (r100 == null) goto L157;
        String r132 = r100.T();
        if (r132 == null) goto L157;
    L158:
        G = r132;
        if (r100 == null) goto L162;
        String r133 = r100.b0();
        if (r133 == null) goto L162;
    L163:
        H = r133;
        if (r100 == null) goto L167;
        String r134 = r100.y();
        if (r134 == null) goto L167;
    L168:
        I = r134;
        if (r100 == null) goto L172;
        String r135 = r100.i();
        if (r135 == null) goto L172;
    L173:
        f359978J = r135;
        if (r100 == null) goto L177;
        String r136 = r100.M();
        if (r136 == null) goto L177;
    L178:
        K = r136;
        if (r100 == null) goto L182;
        String r137 = r100.v0();
        if (r137 == null) goto L182;
    L183:
        L = r137;
        if (r100 == null) goto L187;
        String r138 = r100.t0();
        if (r138 == null) goto L187;
    L188:
        M = r138;
        if (r100 == null) goto L192;
        String r139 = r100.C();
        if (r139 == null) goto L192;
    L193:
        N = r139;
        if (r100 == null) goto L197;
        String r140 = r100.J();
        if (r140 == null) goto L197;
    L198:
        O = r140;
        if (r100 == null) goto L202;
        String r141 = r100.s0();
        if (r141 == null) goto L202;
    L203:
        P = r141;
        if (r100 == null) goto L207;
        String r142 = r100.w();
        if (r142 == null) goto L207;
    L208:
        Q = r142;
        if (r100 == null) goto L212;
        String r143 = r100.N();
        if (r143 == null) goto L212;
    L213:
        R = r143;
        if (r100 == null) goto L217;
        String r144 = r100.g();
        if (r144 == null) goto L217;
    L218:
        S = r144;
        if (r100 == null) goto L222;
        String r145 = r100.w0();
        if (r145 == null) goto L222;
    L223:
        T = r145;
        if (r100 == null) goto L227;
        String r146 = r100.d0();
        if (r146 == null) goto L227;
    L228:
        U = r146;
        if (r100 == null) goto L232;
        String r147 = r100.D();
        if (r147 == null) goto L232;
    L233:
        V = r147;
        if (r100 == null) goto L237;
        String r148 = r100.c0();
        if (r148 == null) goto L237;
    L238:
        W = r148;
        if (r100 == null) goto L242;
        String r149 = r100.f0();
        if (r149 == null) goto L242;
    L243:
        X = r149;
        if (r100 == null) goto L247;
        String r150 = r100.S();
        if (r150 == null) goto L247;
    L248:
        Y = r150;
        IHttpConst r151 = f359981b;
        if (r151 == null) goto L252;
        String r152 = r151.o0();
        if (r152 == null) goto L252;
    L253:
        Z = r152;
        if (r151 == null) goto L257;
        String r153 = r151.t();
        if (r153 == null) goto L257;
    L258:
        f359980a0 = r153;
        if (r151 == null) goto L262;
        String r154 = r151.a();
        if (r154 == null) goto L262;
    L263:
        f359982b0 = r154;
        if (r151 == null) goto L267;
        String r155 = r151.b();
        if (r155 == null) goto L267;
    L268:
        f359984c0 = r155;
        if (r151 == null) goto L272;
        String r156 = r151.y0();
        if (r156 == null) goto L272;
    L273:
        f359986d0 = r156;
        if (r151 == null) goto L277;
        String r157 = r151.z0();
        if (r157 == null) goto L277;
    L278:
        f359988e0 = r157;
        if (r151 == null) goto L282;
        List<String> r158 = r151.F();
        if (r158 == null) goto L282;
    L283:
        f359990f0 = r158;
        if (r151 == null) goto L287;
        List<String> r159 = r151.a0();
        if (r159 == null) goto L287;
    L288:
        f359992g0 = r159;
        if (r151 == null) goto L292;
        String r160 = r151.r0();
        if (r160 == null) goto L292;
    L293:
        f359994h0 = r160;
        if (r151 == null) goto L297;
        String r161 = r151.o();
        if (r161 == null) goto L297;
    L298:
        f359996i0 = r161;
        if (r151 == null) goto L302;
        String r162 = r151.U();
        if (r162 == null) goto L302;
    L303:
        f359998j0 = r162;
        if (r151 == null) goto L307;
        String r163 = r151.L();
        if (r163 == null) goto L307;
    L308:
        f360000k0 = r163;
        if (r151 == null) goto L312;
        String r164 = r151.D0();
        if (r164 == null) goto L312;
    L313:
        f360002l0 = r164;
        if (r151 == null) goto L317;
        String r165 = r151.u0();
        if (r165 == null) goto L317;
    L318:
        f360004m0 = r165;
        if (r151 == null) goto L322;
        String r166 = r151.H();
        if (r166 == null) goto L322;
    L323:
        f360006n0 = r166;
        if (r151 == null) goto L327;
        String r167 = r151.K();
        if (r167 == null) goto L327;
    L328:
        f360008o0 = r167;
        if (r151 == null) goto L332;
        String r168 = r151.r();
        if (r168 == null) goto L332;
    L333:
        f360010p0 = r168;
        if (r151 == null) goto L337;
        String r169 = r151.q0();
        if (r169 == null) goto L337;
    L338:
        f360012q0 = r169;
        if (r151 == null) goto L342;
        String r170 = r151.C0();
        if (r170 == null) goto L342;
    L343:
        f360014r0 = r170;
        if (r151 == null) goto L347;
        String r171 = r151.W();
        if (r171 == null) goto L347;
    L348:
        f360016s0 = r171;
        if (r151 == null) goto L352;
        String r172 = r151.p();
        if (r172 == null) goto L352;
    L353:
        f360018t0 = r172;
        if (r151 == null) goto L357;
        Set<String> r173 = r151.z();
        if (r173 == null) goto L357;
    L358:
        f360020u0 = r173;
        if (r151 == null) goto L362;
        String r174 = r151.j0();
        if (r174 == null) goto L362;
    L363:
        f360022v0 = r174;
        if (r151 == null) goto L367;
        String r175 = r151.I();
        if (r175 == null) goto L367;
    L368:
        f360024w0 = r175;
        if (r151 == null) goto L372;
        String r176 = r151.O();
        if (r176 == null) goto L372;
    L373:
        f360026x0 = r176;
        if (r151 == null) goto L377;
        String r177 = r151.m();
        if (r177 == null) goto L377;
    L378:
        f360028y0 = r177;
        if (r151 == null) goto L382;
        String r178 = r151.G();
        if (r178 == null) goto L382;
    L383:
        f360030z0 = r178;
        if (r151 == null) goto L387;
        String r179 = r151.j();
        if (r179 == null) goto L387;
    L388:
        A0 = r179;
        if (r151 == null) goto L392;
        String r180 = r151.g0();
        if (r180 == null) goto L392;
    L393:
        B0 = r180;
        if (r151 == null) goto L397;
        String r181 = r151.B0();
        if (r181 == null) goto L397;
    L398:
        C0 = r181;
        if (r151 == null) goto L402;
        String r182 = r151.u();
        if (r182 == null) goto L402;
    L403:
        D0 = r182;
        if (r151 == null) goto L409;
        String r183 = r151.E();
        if (r183 == null) goto L409;
        r101 = r183;
    L409:
        E0 = r101;
        return;
    L402:
        r182 = "";
    L397:
        r181 = "";
    L392:
        r180 = "";
    L387:
        r179 = "";
    L382:
        r178 = "";
    L377:
        r177 = "";
    L372:
        r176 = "";
    L367:
        r175 = "";
    L362:
        r174 = "";
    L357:
        r173 = SetsKt.emptySet();
    L352:
        r172 = "";
    L347:
        r171 = "";
    L342:
        r170 = "";
    L337:
        r169 = "";
    L332:
        r168 = "";
    L327:
        r167 = "";
    L322:
        r166 = "";
    L317:
        r165 = "";
    L312:
        r164 = "";
    L307:
        r163 = "";
    L302:
        r162 = "";
    L297:
        r161 = "";
    L292:
        r160 = "";
    L287:
        r159 = CollectionsKt.emptyList();
    L282:
        r158 = CollectionsKt.emptyList();
    L277:
        r157 = "";
    L272:
        r156 = "";
    L267:
        r155 = "";
    L262:
        r154 = "";
    L257:
        r153 = "";
    L252:
        r152 = "";
    L247:
        r150 = "";
    L242:
        r149 = "";
    L237:
        r148 = "";
    L232:
        r147 = "";
    L227:
        r146 = "";
    L222:
        r145 = "";
    L217:
        r144 = "";
    L212:
        r143 = "";
    L207:
        r142 = "";
    L202:
        r141 = "";
    L197:
        r140 = "";
    L192:
        r139 = "";
    L187:
        r138 = "";
    L182:
        r137 = "";
    L177:
        r136 = "";
    L172:
        r135 = "";
    L167:
        r134 = "";
    L162:
        r133 = "";
    L157:
        r132 = "";
    L152:
        r131 = "";
    L147:
        r130 = "";
    L142:
        r129 = "";
    L137:
        r128 = "";
    L132:
        r127 = "";
    L127:
        r126 = "";
    L122:
        r125 = "";
    L117:
        r124 = "";
    L112:
        r123 = "";
    L107:
        r122 = "";
    L102:
        r121 = "";
    L97:
        r120 = "";
    L92:
        r119 = "";
    L87:
        r118 = "";
    L82:
        r117 = "";
    L77:
        r116 = "";
    L72:
        r115 = "";
    L67:
        r114 = "";
    L62:
        r113 = "";
    L57:
        r112 = "";
    L52:
        r111 = "";
    L41:
        r109 = "";
    L36:
        r108 = "";
    L31:
        r107 = "";
    L26:
        r106 = "";
    L21:
        r105 = "";
    L16:
        r104 = "";
    L11:
        r103 = "";
    L6:
        r102 = "";
        goto L7
    }

    @Override // com.larus.network.IHttpConst
    public final String X() {
        IHttpConst r100 = f359981b;
        if (r100 == null) goto L6;
        String r101 = r100.X();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.larus.network.IHttpConst
    public final String A() {
        return f360029z;
    }

    @Override // com.larus.network.IHttpConst
    public final String A0() {
        return f359991g;
    }

    @Override // com.larus.network.IHttpConst
    public final String B() {
        return f360007o;
    }

    @Override // com.larus.network.IHttpConst
    public final String B0() {
        return C0;
    }

    @Override // com.larus.network.IHttpConst
    public final String C() {
        return N;
    }

    @Override // com.larus.network.IHttpConst
    public final String C0() {
        return f360014r0;
    }

    @Override // com.larus.network.IHttpConst
    public final String D() {
        return V;
    }

    @Override // com.larus.network.IHttpConst
    public final String D0() {
        return f360002l0;
    }

    @Override // com.larus.network.IHttpConst
    public final String E() {
        return E0;
    }

    @Override // com.larus.network.IHttpConst
    public final List<String> F() {
        return f359990f0;
    }

    @Override // com.larus.network.IHttpConst
    public final String G() {
        return f360030z0;
    }

    @Override // com.larus.network.IHttpConst
    public final String H() {
        return f360006n0;
    }

    @Override // com.larus.network.IHttpConst
    public final String I() {
        return f360024w0;
    }

    @Override // com.larus.network.IHttpConst
    public final String J() {
        return O;
    }

    @Override // com.larus.network.IHttpConst
    public final String K() {
        return f360008o0;
    }

    @Override // com.larus.network.IHttpConst
    public final String L() {
        return f360000k0;
    }

    @Override // com.larus.network.IHttpConst
    public final String M() {
        return K;
    }

    @Override // com.larus.network.IHttpConst
    public final String N() {
        return R;
    }

    @Override // com.larus.network.IHttpConst
    public final String O() {
        return f360026x0;
    }

    @Override // com.larus.network.IHttpConst
    public final String P() {
        return f359995i;
    }

    @Override // com.larus.network.IHttpConst
    public final String Q() {
        return f360011q;
    }

    @Override // com.larus.network.IHttpConst
    public final String R() {
        return F;
    }

    @Override // com.larus.network.IHttpConst
    public final String S() {
        return Y;
    }

    @Override // com.larus.network.IHttpConst
    public final String T() {
        return G;
    }

    @Override // com.larus.network.IHttpConst
    public final String U() {
        return f359998j0;
    }

    @Override // com.larus.network.IHttpConst
    public final String V() {
        return f359999k;
    }

    @Override // com.larus.network.IHttpConst
    public final String W() {
        return f360016s0;
    }

    @Override // com.larus.network.IHttpConst
    public final String Y() {
        return f360025x;
    }

    @Override // com.larus.network.IHttpConst
    public final String Z() {
        return B;
    }

    @Override // com.larus.network.IHttpConst
    public final String a() {
        return f359982b0;
    }

    @Override // com.larus.network.IHttpConst
    public final List<String> a0() {
        return f359992g0;
    }

    @Override // com.larus.network.IHttpConst
    public final String b() {
        return f359984c0;
    }

    @Override // com.larus.network.IHttpConst
    public final String b0() {
        return H;
    }

    @Override // com.larus.network.IHttpConst
    public final String c() {
        return f360003m;
    }

    @Override // com.larus.network.IHttpConst
    public final String c0() {
        return W;
    }

    @Override // com.larus.network.IHttpConst
    public final String d() {
        return f359983c;
    }

    @Override // com.larus.network.IHttpConst
    public final String d0() {
        return U;
    }

    @Override // com.larus.network.IHttpConst
    public final String e() {
        return f360009p;
    }

    @Override // com.larus.network.IHttpConst
    public final String e0() {
        return f360019u;
    }

    @Override // com.larus.network.IHttpConst
    public final String f() {
        return f360023w;
    }

    @Override // com.larus.network.IHttpConst
    public final String f0() {
        return X;
    }

    @Override // com.larus.network.IHttpConst
    public final String g() {
        return S;
    }

    @Override // com.larus.network.IHttpConst
    public final String g0() {
        return B0;
    }

    @Override // com.larus.network.IHttpConst
    public final String h() {
        return f359987e;
    }

    @Override // com.larus.network.IHttpConst
    public final String h0() {
        return f360017t;
    }

    @Override // com.larus.network.IHttpConst
    public final String i() {
        return f359978J;
    }

    @Override // com.larus.network.IHttpConst
    public final String i0() {
        return f360015s;
    }

    @Override // com.larus.network.IHttpConst
    public final String j() {
        return A0;
    }

    @Override // com.larus.network.IHttpConst
    public final String j0() {
        return f360022v0;
    }

    @Override // com.larus.network.IHttpConst
    public final String k() {
        return A;
    }

    @Override // com.larus.network.IHttpConst
    public final String k0() {
        return f360013r;
    }

    @Override // com.larus.network.IHttpConst
    public final String l() {
        return D;
    }

    @Override // com.larus.network.IHttpConst
    public final String l0() {
        return C;
    }

    @Override // com.larus.network.IHttpConst
    public final String m() {
        return f360028y0;
    }

    @Override // com.larus.network.IHttpConst
    public final String m0() {
        return E;
    }

    @Override // com.larus.network.IHttpConst
    public final String n() {
        return f359989f;
    }

    @Override // com.larus.network.IHttpConst
    public final String n0() {
        return f359997j;
    }

    @Override // com.larus.network.IHttpConst
    public final String o() {
        return f359996i0;
    }

    @Override // com.larus.network.IHttpConst
    public final String o0() {
        return Z;
    }

    @Override // com.larus.network.IHttpConst
    public final String p() {
        return f360018t0;
    }

    @Override // com.larus.network.IHttpConst
    public final String p0() {
        return f360027y;
    }

    @Override // com.larus.network.IHttpConst
    public final String q() {
        return f359985d;
    }

    @Override // com.larus.network.IHttpConst
    public final String q0() {
        return f360012q0;
    }

    @Override // com.larus.network.IHttpConst
    public final String r() {
        return f360010p0;
    }

    @Override // com.larus.network.IHttpConst
    public final String r0() {
        return f359994h0;
    }

    @Override // com.larus.network.IHttpConst
    public final String s() {
        return f360005n;
    }

    @Override // com.larus.network.IHttpConst
    public final String s0() {
        return P;
    }

    @Override // com.larus.network.IHttpConst
    public final String t() {
        return f359980a0;
    }

    @Override // com.larus.network.IHttpConst
    public final String t0() {
        return M;
    }

    @Override // com.larus.network.IHttpConst
    public final String u() {
        return D0;
    }

    @Override // com.larus.network.IHttpConst
    public final String u0() {
        return f360004m0;
    }

    @Override // com.larus.network.IHttpConst
    public final String v() {
        return f360021v;
    }

    @Override // com.larus.network.IHttpConst
    public final String v0() {
        return L;
    }

    @Override // com.larus.network.IHttpConst
    public final String w() {
        return Q;
    }

    @Override // com.larus.network.IHttpConst
    public final String w0() {
        return T;
    }

    @Override // com.larus.network.IHttpConst
    public final String x() {
        return f359993h;
    }

    @Override // com.larus.network.IHttpConst
    public final String x0() {
        return f360001l;
    }

    @Override // com.larus.network.IHttpConst
    public final String y() {
        return I;
    }

    @Override // com.larus.network.IHttpConst
    public final String y0() {
        return f359986d0;
    }

    @Override // com.larus.network.IHttpConst
    public final Set<String> z() {
        return f360020u0;
    }

    @Override // com.larus.network.IHttpConst
    public final String z0() {
        return f359988e0;
    }
}
