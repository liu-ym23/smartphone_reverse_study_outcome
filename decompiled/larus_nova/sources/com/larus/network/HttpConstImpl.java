package com.larus.network;

import android.util.Base64;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0003\b\u0084\u0001\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\"\n\u0002\b\u0017\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010`\u001a\u00020\u0005H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0014\u0010\u000e\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0014\u0010\u0010\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007R\u0014\u0010\u0012\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0007R\u0014\u0010\u0014\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0007R\u0014\u0010\u0016\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0007R\u0014\u0010\u0018\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0007R\u0014\u0010\u001a\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0007R\u0014\u0010\u001c\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0007R\u0014\u0010\u001e\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0007R\u0014\u0010 \u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0007R\u0014\u0010\"\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0007R\u0014\u0010$\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0007R\u0014\u0010&\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0007R\u0014\u0010(\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0007R\u0014\u0010*\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0007R\u0014\u0010,\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0007R\u0014\u0010.\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0007R\u0014\u00100\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0007R\u0014\u00102\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u0007R\u0014\u00104\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u0007R\u0014\u00106\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u0007R\u0014\u00108\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u0007R\u0014\u0010:\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u0007R\u0014\u0010<\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\u0007R\u0014\u0010>\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\u0007R\u0014\u0010@\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\u0007R\u0014\u0010B\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\bC\u0010\u0007R\u0014\u0010D\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\bE\u0010\u0007R\u0014\u0010F\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010\u0007R\u0014\u0010H\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\bI\u0010\u0007R\u0014\u0010J\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u0010\u0007R\u0014\u0010L\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u0010\u0007R\u0014\u0010N\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bO\u0010\u0007R\u0014\u0010P\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010\u0007R\u0014\u0010R\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bS\u0010\u0007R\u0014\u0010T\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\bU\u0010\u0007R\u0014\u0010V\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bW\u0010\u0007R\u0014\u0010X\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bY\u0010\u0007R\u0014\u0010Z\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b[\u0010\u0007R\u0014\u0010\\\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b]\u0010\u0007R\u0014\u0010^\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b_\u0010\u0007R\u0014\u0010a\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\bb\u0010\u0007R\u0014\u0010c\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\bd\u0010\u0007R\u0014\u0010e\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bf\u0010\u0007R\u0014\u0010g\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bh\u0010\u0007R\u0014\u0010i\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\bj\u0010\u0007R\u0014\u0010k\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\bl\u0010\u0007R\u0014\u0010m\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\bn\u0010\u0007R\u0014\u0010o\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\bp\u0010\u0007R\u0014\u0010q\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\br\u0010\u0007R\u0014\u0010s\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\bt\u0010\u0007R\u0014\u0010u\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\bv\u0010\u0007R\u0014\u0010w\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\bx\u0010\u0007R\u0014\u0010y\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bz\u0010\u0007R\u0014\u0010{\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b|\u0010\u0007R\u0014\u0010}\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b~\u0010\u0007R\u0015\u0010\u007f\u001a\u00020\u0005X\u0096D¢\u0006\t\n\u0000\u001a\u0005\b\u0080\u0001\u0010\u0007R\u0016\u0010\u0081\u0001\u001a\u00020\u0005X\u0096D¢\u0006\t\n\u0000\u001a\u0005\b\u0082\u0001\u0010\u0007R\u0016\u0010\u0083\u0001\u001a\u00020\u0005X\u0096D¢\u0006\t\n\u0000\u001a\u0005\b\u0084\u0001\u0010\u0007R\u0016\u0010\u0085\u0001\u001a\u00020\u0005X\u0096D¢\u0006\t\n\u0000\u001a\u0005\b\u0086\u0001\u0010\u0007R\u0016\u0010\u0087\u0001\u001a\u00020\u0005X\u0096D¢\u0006\t\n\u0000\u001a\u0005\b\u0088\u0001\u0010\u0007R\u001e\u0010\u0089\u0001\u001a\t\u0012\u0004\u0012\u00020\u00050\u008a\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001R\u001e\u0010\u008d\u0001\u001a\t\u0012\u0004\u0012\u00020\u00050\u008a\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u008e\u0001\u0010\u008c\u0001R\u0016\u0010\u008f\u0001\u001a\u00020\u0005X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0090\u0001\u0010\u0007R\u0016\u0010\u0091\u0001\u001a\u00020\u0005X\u0096D¢\u0006\t\n\u0000\u001a\u0005\b\u0092\u0001\u0010\u0007R\u001e\u0010\u0093\u0001\u001a\t\u0012\u0004\u0012\u00020\u00050\u0094\u0001X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001R\u0016\u0010\u0097\u0001\u001a\u00020\u0005X\u0096D¢\u0006\t\n\u0000\u001a\u0005\b\u0098\u0001\u0010\u0007R\u0016\u0010\u0099\u0001\u001a\u00020\u0005X\u0096D¢\u0006\t\n\u0000\u001a\u0005\b\u009a\u0001\u0010\u0007R\u0016\u0010\u009b\u0001\u001a\u00020\u0005X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u009c\u0001\u0010\u0007R\u0016\u0010\u009d\u0001\u001a\u00020\u0005X\u0096D¢\u0006\t\n\u0000\u001a\u0005\b\u009e\u0001\u0010\u0007R\u0016\u0010\u009f\u0001\u001a\u00020\u0005X\u0096D¢\u0006\t\n\u0000\u001a\u0005\b \u0001\u0010\u0007R\u0016\u0010¡\u0001\u001a\u00020\u0005X\u0096D¢\u0006\t\n\u0000\u001a\u0005\b¢\u0001\u0010\u0007R\u0016\u0010£\u0001\u001a\u00020\u0005X\u0096D¢\u0006\t\n\u0000\u001a\u0005\b¤\u0001\u0010\u0007R\u0016\u0010¥\u0001\u001a\u00020\u0005X\u0096D¢\u0006\t\n\u0000\u001a\u0005\b¦\u0001\u0010\u0007R\u0016\u0010§\u0001\u001a\u00020\u0005X\u0096D¢\u0006\t\n\u0000\u001a\u0005\b¨\u0001\u0010\u0007R\u0016\u0010©\u0001\u001a\u00020\u0005X\u0096D¢\u0006\t\n\u0000\u001a\u0005\bª\u0001\u0010\u0007¨\u0006«\u0001"}, d2 = {"Lcom/larus/network/HttpConstImpl;", "Lcom/larus/network/IHttpConst;", "<init>", "()V", "ONLINE_BASE_HOST", "", "getONLINE_BASE_HOST", "()Ljava/lang/String;", "ONLINE_BASE_HOST_API", "getONLINE_BASE_HOST_API", "ONLINE_WWW_HOST", "getONLINE_WWW_HOST", "ONLINE_WWW_HOST_API", "getONLINE_WWW_HOST_API", "ONLINE_WWW", "getONLINE_WWW", "ONLINE_WWW_API", "getONLINE_WWW_API", "ONLINE_HOST", "getONLINE_HOST", "ONLINE_HOST_API", "getONLINE_HOST_API", "ONLINE", "getONLINE", "ONLINE_API", "getONLINE_API", "APPLET_DEBUGGER_BASE_URL", "getAPPLET_DEBUGGER_BASE_URL", "BOE_HOST", "getBOE_HOST", "BOE", "getBOE", "SAMI_WSS_HOST", "getSAMI_WSS_HOST", "ENTERPRISE_SAMI_WSS_HOST", "getENTERPRISE_SAMI_WSS_HOST", "SAMI_WSS_QUIC_HOST", "getSAMI_WSS_QUIC_HOST", "ENTERPRISE_SAMI_WSS_QUIC_HOST", "getENTERPRISE_SAMI_WSS_QUIC_HOST", "SHARE_PASSPORT_LOGIN_TOKEN", "getSHARE_PASSPORT_LOGIN_TOKEN", "MSSDK_PASSPORT_TOKEN", "getMSSDK_PASSPORT_TOKEN", "MSSDK_PASSPORT_TOKEN_Z", "getMSSDK_PASSPORT_TOKEN_Z", "PRAISE_DIALOG_SDK_HOST", "getPRAISE_DIALOG_SDK_HOST", "COZE_PLATFORM_HOST", "getCOZE_PLATFORM_HOST", "ASSIST_CENTER_HOST", "getASSIST_CENTER_HOST", "AI_APPLET_JSB_HOST", "getAI_APPLET_JSB_HOST", "BAIKE_JSB_HOST", "getBAIKE_JSB_HOST", "FEEDBACK_BASE_URL", "getFEEDBACK_BASE_URL", "FEEDBACK_SOURCE_LOGIN", "getFEEDBACK_SOURCE_LOGIN", "FEEDBACK_SOURCE_SETTING", "getFEEDBACK_SOURCE_SETTING", "FEEDBACK_SOURCE_PAYMENT", "getFEEDBACK_SOURCE_PAYMENT", "FEEDBACK_SOURCE_PRAISE", "getFEEDBACK_SOURCE_PRAISE", "FEEDBACK_SOURCE_REBIND_PHONE_NUMBER", "getFEEDBACK_SOURCE_REBIND_PHONE_NUMBER", "FEEDBACK_SOURCE_PHONE_NUMBER_INACTIVE", "getFEEDBACK_SOURCE_PHONE_NUMBER_INACTIVE", "configLibraUrl", "getConfigLibraUrl", "configDeepLinkUrl", "getConfigDeepLinkUrl", "termsUrl", "getTermsUrl", "privacyUrl", "getPrivacyUrl", "privacyAccountUrl", "getPrivacyAccountUrl", "privacyAbsUrl", "getPrivacyAbsUrl", "memoryFaqUrl", "getMemoryFaqUrl", "legalFaqUrl", "getLegalFaqUrl", "faceMemoryPrivacyUrl", "getFaceMemoryPrivacyUrl", "privacyNewUrl", "getPrivacyNewUrl", "trustCenterUrl", "getTrustCenterUrl", "ONLINE_RTC_SERVER_MESSAGE_DOMAIN", "getONLINE_RTC_SERVER_MESSAGE_DOMAIN", "TEST_RTC_SERVER_MESSAGE_DOMAIN", "getTEST_RTC_SERVER_MESSAGE_DOMAIN", "secLink", "ALICE_BOE_HOST", "getALICE_BOE_HOST", "ACCOUNTT_BOE_HOST", "getACCOUNTT_BOE_HOST", "accountSettingUrl", "getAccountSettingUrl", "deviceManagementUrl", "getDeviceManagementUrl", "personUrl", "getPersonUrl", "denoisePrivacyUrl", "getDenoisePrivacyUrl", "accessibilitySdkDebugUrl", "getAccessibilitySdkDebugUrl", "doubaoOfficialWebsite", "getDoubaoOfficialWebsite", "toutiaoArticleUrl", "getToutiaoArticleUrl", "avatarOnboardingVideoModelString", "getAvatarOnboardingVideoModelString", "avatarOnboardingVideoCoverUrl", "getAvatarOnboardingVideoCoverUrl", "avatarTutorialAudioUrl", "getAvatarTutorialAudioUrl", "loggingDLPUrl", "getLoggingDLPUrl", "accountBanAppealUrl", "getAccountBanAppealUrl", "ecommerceQualificationRulesUrl", "getEcommerceQualificationRulesUrl", "shoppingPaymentFaqUrl", "getShoppingPaymentFaqUrl", "locallifePlatformQualificationUrl", "getLocallifePlatformQualificationUrl", "locallifeUserAgreementUrl", "getLocallifeUserAgreementUrl", "locallifePrivacyAgreementUrl", "getLocallifePrivacyAgreementUrl", "locallifeRuleCenterUrl", "getLocallifeRuleCenterUrl", "authorizationWhiteList", "", "getAuthorizationWhiteList", "()Ljava/util/List;", "authorizationPathWhiteList", "getAuthorizationPathWhiteList", "thirdAppSettingsUrl", "getThirdAppSettingsUrl", "BASE_LARK_HOST", "getBASE_LARK_HOST", "ENV_HEADER_EXCLUDED_HOSTS", "", "getENV_HEADER_EXCLUDED_HOSTS", "()Ljava/util/Set;", "GECKO_HOST", "getGECKO_HOST", "BYTEGECKO_HOST_SUFFIX", "getBYTEGECKO_HOST_SUFFIX", "MAIN_APP_HOST_SUFFIX", "getMAIN_APP_HOST_SUFFIX", "SAMI_BOE_HOST", "getSAMI_BOE_HOST", "BOE_WWW_HOST", "getBOE_WWW_HOST", "WSS_NORMAL_HOST", "getWSS_NORMAL_HOST", "WSS100_NORMAL_HOST", "getWSS100_NORMAL_HOST", "WSS_NORMAL_BOE_HOST", "getWSS_NORMAL_BOE_HOST", "WS_SAMANTHA_HOST", "getWS_SAMANTHA_HOST", "WS_SAMANTHA_BOE_HOST", "getWS_SAMANTHA_BOE_HOST", "ttnet_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HttpConstImpl implements IHttpConst {
    public final String A;
    public final String A0;
    public final String B;
    public final String B0;
    public final String C;
    public final String D;
    public final String E;
    public final String F;
    public final String G;
    public final String H;
    public final String I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final String f360031J;
    public final String K;
    public final String L;
    public final String M;
    public final String N;
    public final String O;
    public final String P;
    public final String Q;
    public final String R;
    public final String S;
    public final String T;
    public final String U;
    public final String V;
    public final String W;
    public final String X;
    public final String Y;
    public final String Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f360032a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public final String f360033a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f360034b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public final String f360035b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f360036c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public final String f360037c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f360038d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public final String f360039d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f360040e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public final String f360041e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f360042f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public final String f360043f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f360044g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public final String f360045g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f360046h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public final String f360047h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f360048i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public final String f360049i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f360050j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public final String f360051j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f360052k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final String f360053k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f360054l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public final String f360055l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f360056m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public final String f360057m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f360058n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public final List<String> f360059n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f360060o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public final List<String> f360061o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f360062p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public final String f360063p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f360064q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public final String f360065q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f360066r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public final Set<String> f360067r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f360068s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public final String f360069s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final String f360070t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public final String f360071t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f360072u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public final String f360073u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f360074v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public final String f360075v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f360076w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public final String f360077w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final String f360078x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public final String f360079x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final String f360080y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public final String f360081y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final String f360082z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public final String f360083z0;

    @Override // com.larus.network.IHttpConst
    public final String X() {
        return "https://link.wtturl.cn/";
    }

    public HttpConstImpl() {
        this.f360032a = "doubao.com";
        this.f360034b = "doubao.com";
        String r100 = "www.doubao.com";
        this.f360036c = r100;
        this.f360038d = "www.doubao.com";
        String r101 = "https://" + r100;
        this.f360040e = r101;
        this.f360042f = "https://" + r100;
        String r102 = "api-normal.doubao.com";
        this.f360044g = r102;
        this.f360046h = "api-normal.doubao.com";
        this.f360048i = "https://" + r102;
        this.f360050j = "https://" + r102;
        this.f360052k = "https://developer.doubao.com";
        this.f360054l = "alice-boe.bytedance.net";
        this.f360056m = "https://alice-boe.bytedance.net";
        this.f360058n = "wss://audio.doubao.com";
        this.f360060o = "wss://frontier-audio-ws.doubao.com";
        this.f360062p = "wss://frontier-audio-q.doubao.com";
        this.f360064q = "wss://frontier-audio-q.doubao.com";
        this.f360066r = "snssdk.com";
        this.f360068s = "mssdk.bytedance.com";
        this.f360070t = "mssdk.doubao.com";
        this.f360072u = "https://praisewindow.ugsdk.cn";
        this.f360074v = "https://bot-open-api.oceancloudapi.com";
        this.f360076w = "helpdesk.bytedance.com";
        this.f360078x = "app.aisdk.local";
        this.f360080y = "baike.com";
        this.f360082z = "https://helpdesk.bytedance.com/sites/standalone/helpcenter/home-aweme/index.html?biz_id=65&should_full_screen=1&ske=1";
        this.A = "doubao_login_feedback";
        this.B = "doubao_setting_feedback";
        this.C = "doubao_payment_feedback";
        this.D = "praise_dialog_feedback";
        this.E = "rebind_phone_number";
        this.F = "phone_number_inactive";
        this.G = "https://ttch54.apps.bytedance.net/client/libra/";
        this.H = "doubao";
        this.I = r101 + "/legal/terms";
        this.f360031J = r101 + "/legal/privacy";
        this.K = "https://lf9-cdn-tos.draftstatic.com/obj/ies-hotsoon-draft/grace_legal/835f4b90-a0be-4ef0-bf4c-72e120ed97f4.html";
        this.L = "https://lf3-cdn-tos.draftstatic.com/obj/ies-hotsoon-draft/grace_legal/privacy_policy_abs.html";
        this.M = r101 + "/legal/memory_faq";
        this.N = "";
        this.O = "https://lf9-cdn-tos.draftstatic.com/obj/ies-hotsoon-draft/grace_legal/videocallmemoryfaq.html";
        this.P = r101 + "/legal/model_training_faq";
        this.Q = "";
        this.R = "https://rtc-inner.zijieapi.com/adapter/servermessage";
        this.S = "https://rtc-test.bytedance.com/adapter/servermessage";
        this.T = "alice-boe.bytedance.net";
        this.U = "alice-boe.bytedance.net";
        this.V = r101 + "/flow-account/setting-flow-app";
        this.W = r101 + "/inapp/device-management?hide_title_bar=1";
        this.X = "https://www.doubao.com/inapp/personal-information-list";
        this.Y = "https://www.doubao.com/legal/CNR_faq";
        this.Z = "https://a11y.bytedance.net/";
        this.f360033a0 = "https://www.doubao.com/product";
        this.f360035b0 = "https://m.toutiao.com/article/";
        this.f360037c0 = "{\"status\":10,\"message\":\"success\",\"enable_ssl\":true,\"auto_definition\":\"360p\",\"enable_adaptive\":false,\"video_id\":\"v0269cg10004d5i9ml7og65vj8h5otug\",\"video_duration\":9.283,\"media_type\":\"video\",\"url_expire\":2079243325,\"fallback_api\":\"https://vas-lf-x.snssdk.com/video/fplay/1/9c2117f7664a8c0f814f451a347bfd51/v0269cg10004d5i9ml7og65vj8h5otug?aid=0&codec_type=3&device_platform=unknown&force_fids=b3R1Zw%3D%3D&imp=false&key_seed=wsHvwrtUyLIiUDdEMrfop9my8qJ3Mrq5EHdxvUuW4i0%3D&logo_type=unwatermarked&multi_rate_audios=true&vps=0\",\"video_list\":{\"video_1\":{\"definition\":\"1080p\",\"quality\":\"original\",\"vtype\":\"mp4\",\"vwidth\":1170,\"vheight\":960,\"bitrate\":2666986,\"real_bitrate\":2666986,\"fps\":60,\"codec_type\":\"hevc\",\"size\":3094816,\"main_url\":\"aHR0cHM6Ly92MTEtZGVmYXVsdC4zNjV5Zy5jb20vNWUxY2Q1OWQzMDVjMTJhZTQ3MTYyMzhhMDdiZTQwNzgvN2JlZWJjM2QvdmlkZW8vdG9zL2NuL3Rvcy1jbi12LTllY2Q1NC9vWVFERkJKbUpwZjhkNXRrRVFDMUVmOVVDbVpBcEVSaUpBY3hnaS8/YT0wJmNoPTAmY3I9NyZkcj0wJmxyPXVud2F0ZXJtYXJrZWQmY2Q9MCU3QzAlN0MwJTdDMSZicj0yNjA0JmJ0PTI2MDQmZHM9NCZmdD1PaS5waTc3SldINkJNRUlVRXZyMFBEMUlOJm1pbWVfdHlwZT12aWRlb19tcDQmcXM9MTMmcmM9YW5jNE8zazVjbTg4T0Rjek5HWTVNMEJwYW5jNE8zazVjbTg4T0Rjek5HWTVNMEJ5YkdWbk1tUTBhbVpoTFMxa05pOXpZU055YkdWbk1tUTBhbVpoTFMxa05pOXpjdyUzRCUzRCZidGFnPTgwMDAwZTAwMDA4MDAwJmNxdWVyeT0xMDBUJmR5X3E9MTc2ODIwMzMxNiZsPTIwMjYwMTEyMTUzNTE1REY0OTc2QjFFQUVGQ0Q3NzZBQjY=\",\"backup_url_1\":\"aHR0cHM6Ly92NS1kZWZhdWx0LjM2NXlnLmNvbS82MTliMTgwNzdkNDg3ZDFlNGIxZmYxOGMxZTBkYmVjMC83YmVlYmMzZC92aWRlby90b3MvY24vdG9zLWNuLXYtOWVjZDU0L29ZUURGQkptSnBmOGQ1dGtFUUMxRWY5VUNtWkFwRVJpSkFjeGdpLz9hPTAmY2g9MCZjcj03JmRyPTAmbHI9dW53YXRlcm1hcmtlZCZjZD0wJTdDMCU3QzAlN0MxJmJyPTI2MDQmYnQ9MjYwNCZkcz00JmZ0PU9pLnBpNzdKV0g2Qk1FSVVFdnIwUEQxSU4mbWltZV90eXBlPXZpZGVvX21wNCZxcz0xMyZyYz1hbmM0TzNrNWNtODhPRGN6TkdZNU0wQnBhbmM0TzNrNWNtODhPRGN6TkdZNU0wQnliR1ZuTW1RMGFtWmhMUzFrTmk5ellTTnliR1ZuTW1RMGFtWmhMUzFrTmk5emN3JTNEJTNEJmJ0YWc9ODAwMDBlMDAwMDgwMDAmY3F1ZXJ5PTEwMFQmZHlfcT0xNzY4MjAzMzE2Jmw9MjAyNjAxMTIxNTM1MTVERjQ5NzZCMUVBRUZDRDc3NkFCNg==\",\"file_id\":\"v0269cg10004d5i9ml7og65vj8h5otug\",\"quality_type\":0,\"encryption_method\":\"\",\"gear_des_key\":\"0:MP4|1:default|2:hevc|4:unknown|5:normal|13:0|10000:105\",\"audio_sample_rate\":\"48000\",\"url_expire\":2079243325,\"preload_size\":327680,\"preload_interval\":60,\"preload_min_step\":5,\"preload_max_step\":10,\"file_hash\":\"e57a02707490e98f62f126cab1115e2c\"}},\"popularity_level\":0,\"has_embedded_subtitle\":false,\"poster_url\":\"https://p3-sign.douyinpic.com/tos-cn-p-9ecd54/ooi1kRc6JCAXJEIpNZFfABgEdmFNt9EmxgDfpU~tplv-noop.image?cquery=100T&dy_q=1768203316&l=20260112153515DF4976B1EAEFCD776AB6&x-expires=2079243325&x-signature=ChE26bKq44WYwZpfhrwOIwIPdEM%3D\",\"key_seed\":\"wsHvwrtUyLIiUDdEMrfop9my8qJ3Mrq5EHdxvUuW4i0=\"}";
        this.f360039d0 = "https://p3-flow-op.byteimg.com/tos-cn-i-55yens32bg/%E8%A7%86%E9%A2%91%E5%B0%81%E9%9D%A2.png~tplv-55yens32bg-image.image";
        this.f360041e0 = "https://v6-default.365yg.com/e42ef53b9e08f5ac5c1eca7eca67dff5/7bee9df9/video/tos/cn/tos-cn-v-9ecd54/o0QOQCBgjgfxjeMSiX218iepUFVT3Q6AaX0uC1/?a=0&ch=0&cr=7&dr=0&lr=unwatermarked&cd=0%257C0%257C0%257C1&br=145&bt=145&ds=5&ft=Oi.pi77JWH6BMCNSEvr0PD1IN&mime_type=audio_mpeg&qs=13&rc=anJ5OHQ5cmh0ODczNGY5M0BpanJ5OHQ5cmh0ODczNGY5M0BmXzZqMmRzLmVhLS1kNmFzYSNmXzZqMmRzLmVhLS1kNmFzcw%253D%253D&btag=80000e00008000&cquery=100T&dy_q=1768195575&l=20260112132615958B17808619AC82F076%25";
        this.f360043f0 = "https://logging-client-flow-cn.byted.org/api/dlp/collect";
        this.f360045g0 = "";
        this.f360047h0 = "https://lf-ecom-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/ecom/mix/offline/mix_page/index.html?__live_platform__=webcast&_pia_=1&activity_tag=%E5%85%B6%E4%BB%96&allowMediaAutoPlay=1&disable_host_jsb_method=1&disable_thread_spread=1&enable_pull_down_refresh=1&enter_from=others&hide_nav_bar=0&hide_system_video_poster=1&id=7117178766052294949&is_mix_half_screen=0&mix_container_type=annie&origin_type=others&page_type_opt=lite_page&pia_mixrender=1&should_full_screen=0&show_loading=0&trans_status_bar=0&ttwebview_extension_mixrender=1&web_bg_color=%23F5F6F9";
        this.f360049i0 = "https://lf9-cdn-tos.draftstatic.com/obj/ies-hotsoon-draft/grace_legal/Shopping-Payment-FAQ.html";
        this.f360051j0 = "https://api.amemv.com/magic/eco/runtime/release/63e0a539dd0b880364c89b91?appType=douyin";
        this.f360053k0 = "https://aweme.snssdk.com/magic/eco/runtime/release/607012494eee1a031be5747b?appType=douyin";
        this.f360055l0 = "https://aweme.snssdk.com/magic/eco/runtime/release/60701be79839570322bc753d?appType=douyin";
        this.f360057m0 = "https://lifexue.com/rule?enter_method=tab&selected=93484032002";
        this.f360059n0 = CollectionsKt.listOf(new String[]{".ecombdapi.com", ".snssdk.com", ".scsjsd.com", "dypay.douyin.com", ".zijieapi.com"});
        this.f360061o0 = CollectionsKt.listOf(new String[]{"/alice/commerce/sale/trade/create/", "/alice/commercial/trade/reservation_recall"});
        this.f360063p0 = r101 + "/flow-account/setting-flow-app/third-app-setting";
        this.f360065q0 = "bytedance.larkoffice.com";
        this.f360067r0 = SetsKt.setOf(new String[]{"byteimg.com", "pstatp.com", "ibytedtos.com", "tosv.byted.org", "douyinpic.com", "douyinvod.com", "douyincdn.com", "tiktokcdn.com"});
        this.f360069s0 = "gecko.doubao.com";
        this.f360071t0 = "bytegecko.com";
        this.f360073u0 = new String(Base64.decode("ZG91eWluLmNvbQ==", 2), Charsets.UTF_8);
        this.f360075v0 = "bytesec.bytedance.com";
        this.f360077w0 = "www-doubao.bytedance.net";
        this.f360079x0 = "wss-normal.doubao.com";
        this.f360081y0 = "wss100-normal.doubao.com";
        this.f360083z0 = "wss-normal-doubao-boe.bytedance.net";
        this.A0 = "ws-samantha.doubao.com";
        this.B0 = "ws-samantha-doubao.bytedance.net";
    }

    @Override // com.larus.network.IHttpConst
    public final String V() {
        return P();
    }

    @Override // com.larus.network.IHttpConst
    public final String A() {
        return this.f360076w;
    }

    @Override // com.larus.network.IHttpConst
    public final String A0() {
        return this.f360040e;
    }

    @Override // com.larus.network.IHttpConst
    public final String B() {
        return this.f360054l;
    }

    @Override // com.larus.network.IHttpConst
    public final String B0() {
        return this.f360083z0;
    }

    @Override // com.larus.network.IHttpConst
    public final String C() {
        return this.K;
    }

    @Override // com.larus.network.IHttpConst
    public final String C0() {
        return this.f360045g0;
    }

    @Override // com.larus.network.IHttpConst
    public final String D() {
        return this.S;
    }

    @Override // com.larus.network.IHttpConst
    public final String D0() {
        return this.f360055l0;
    }

    @Override // com.larus.network.IHttpConst
    public final String E() {
        return this.B0;
    }

    @Override // com.larus.network.IHttpConst
    public final List<String> F() {
        return this.f360059n0;
    }

    @Override // com.larus.network.IHttpConst
    public final String G() {
        return this.f360077w0;
    }

    @Override // com.larus.network.IHttpConst
    public final String H() {
        return this.f360037c0;
    }

    @Override // com.larus.network.IHttpConst
    public final String I() {
        return this.f360071t0;
    }

    @Override // com.larus.network.IHttpConst
    public final String J() {
        return this.L;
    }

    @Override // com.larus.network.IHttpConst
    public final String K() {
        return this.f360039d0;
    }

    @Override // com.larus.network.IHttpConst
    public final String L() {
        return this.f360053k0;
    }

    @Override // com.larus.network.IHttpConst
    public final String M() {
        return this.H;
    }

    @Override // com.larus.network.IHttpConst
    public final String N() {
        return this.O;
    }

    @Override // com.larus.network.IHttpConst
    public final String O() {
        return this.f360073u0;
    }

    @Override // com.larus.network.IHttpConst
    public final String P() {
        return this.f360044g;
    }

    @Override // com.larus.network.IHttpConst
    public final String Q() {
        return this.f360058n;
    }

    @Override // com.larus.network.IHttpConst
    public final String R() {
        return this.C;
    }

    @Override // com.larus.network.IHttpConst
    public final String S() {
        return this.V;
    }

    @Override // com.larus.network.IHttpConst
    public final String T() {
        return this.D;
    }

    @Override // com.larus.network.IHttpConst
    public final String U() {
        return this.f360051j0;
    }

    @Override // com.larus.network.IHttpConst
    public final String W() {
        return this.f360063p0;
    }

    @Override // com.larus.network.IHttpConst
    public final String Y() {
        return this.f360072u;
    }

    @Override // com.larus.network.IHttpConst
    public final String Z() {
        return this.f360080y;
    }

    @Override // com.larus.network.IHttpConst
    public final String a() {
        return this.Y;
    }

    @Override // com.larus.network.IHttpConst
    public final List<String> a0() {
        return this.f360061o0;
    }

    @Override // com.larus.network.IHttpConst
    public final String b() {
        return this.Z;
    }

    @Override // com.larus.network.IHttpConst
    public final String b0() {
        return this.E;
    }

    @Override // com.larus.network.IHttpConst
    public final String c() {
        return this.f360050j;
    }

    @Override // com.larus.network.IHttpConst
    public final String c0() {
        return this.T;
    }

    @Override // com.larus.network.IHttpConst
    public final String d() {
        return this.f360032a;
    }

    @Override // com.larus.network.IHttpConst
    public final String d0() {
        return this.R;
    }

    @Override // com.larus.network.IHttpConst
    public final String e() {
        return this.f360056m;
    }

    @Override // com.larus.network.IHttpConst
    public final String e0() {
        return this.f360066r;
    }

    @Override // com.larus.network.IHttpConst
    public final String f() {
        return this.f360070t;
    }

    @Override // com.larus.network.IHttpConst
    public final String f0() {
        return this.U;
    }

    @Override // com.larus.network.IHttpConst
    public final String g() {
        return this.P;
    }

    @Override // com.larus.network.IHttpConst
    public final String g0() {
        return this.f360081y0;
    }

    @Override // com.larus.network.IHttpConst
    public final String h() {
        return this.f360036c;
    }

    @Override // com.larus.network.IHttpConst
    public final String h0() {
        return this.f360064q;
    }

    @Override // com.larus.network.IHttpConst
    public final String i() {
        return this.G;
    }

    @Override // com.larus.network.IHttpConst
    public final String i0() {
        return this.f360062p;
    }

    @Override // com.larus.network.IHttpConst
    public final String j() {
        return this.f360079x0;
    }

    @Override // com.larus.network.IHttpConst
    public final String j0() {
        return this.f360069s0;
    }

    @Override // com.larus.network.IHttpConst
    public final String k() {
        return this.f360078x;
    }

    @Override // com.larus.network.IHttpConst
    public final String k0() {
        return this.f360060o;
    }

    @Override // com.larus.network.IHttpConst
    public final String l() {
        return this.A;
    }

    @Override // com.larus.network.IHttpConst
    public final String l0() {
        return this.f360082z;
    }

    @Override // com.larus.network.IHttpConst
    public final String m() {
        return this.f360075v0;
    }

    @Override // com.larus.network.IHttpConst
    public final String m0() {
        return this.B;
    }

    @Override // com.larus.network.IHttpConst
    public final String n() {
        return this.f360038d;
    }

    @Override // com.larus.network.IHttpConst
    public final String n0() {
        return this.f360046h;
    }

    @Override // com.larus.network.IHttpConst
    public final String o() {
        return this.f360049i0;
    }

    @Override // com.larus.network.IHttpConst
    public final String o0() {
        return this.W;
    }

    @Override // com.larus.network.IHttpConst
    public final String p() {
        return this.f360065q0;
    }

    @Override // com.larus.network.IHttpConst
    public final String p0() {
        return this.f360074v;
    }

    @Override // com.larus.network.IHttpConst
    public final String q() {
        return this.f360034b;
    }

    @Override // com.larus.network.IHttpConst
    public final String q0() {
        return this.f360043f0;
    }

    @Override // com.larus.network.IHttpConst
    public final String r() {
        return this.f360041e0;
    }

    @Override // com.larus.network.IHttpConst
    public final String r0() {
        return this.f360047h0;
    }

    @Override // com.larus.network.IHttpConst
    public final String s() {
        return this.f360052k;
    }

    @Override // com.larus.network.IHttpConst
    public final String s0() {
        return this.M;
    }

    @Override // com.larus.network.IHttpConst
    public final String t() {
        return this.X;
    }

    @Override // com.larus.network.IHttpConst
    public final String t0() {
        return this.f360031J;
    }

    @Override // com.larus.network.IHttpConst
    public final String u() {
        return this.A0;
    }

    @Override // com.larus.network.IHttpConst
    public final String u0() {
        return this.f360057m0;
    }

    @Override // com.larus.network.IHttpConst
    public final String v() {
        return this.f360068s;
    }

    @Override // com.larus.network.IHttpConst
    public final String v0() {
        return this.I;
    }

    @Override // com.larus.network.IHttpConst
    public final String w() {
        return this.N;
    }

    @Override // com.larus.network.IHttpConst
    public final String w0() {
        return this.Q;
    }

    @Override // com.larus.network.IHttpConst
    public final String x() {
        return this.f360042f;
    }

    @Override // com.larus.network.IHttpConst
    public final String x0() {
        return this.f360048i;
    }

    @Override // com.larus.network.IHttpConst
    public final String y() {
        return this.F;
    }

    @Override // com.larus.network.IHttpConst
    public final String y0() {
        return this.f360033a0;
    }

    @Override // com.larus.network.IHttpConst
    public final Set<String> z() {
        return this.f360067r0;
    }

    @Override // com.larus.network.IHttpConst
    public final String z0() {
        return this.f360035b0;
    }
}
