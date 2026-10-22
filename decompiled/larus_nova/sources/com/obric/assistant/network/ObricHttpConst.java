package com.obric.assistant.network;

import com.larus.network.IHttpConst;
import com.ss.android.ugc.aweme.framework.services.DynamicProxy;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\"\n\u0002\u0010\"\n\u0002\bQ\n\u0002\u0010 \n\u0002\b7\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\n\u001a\u00020\u0005H\u0096\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0012\u0010\u000b\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\f\u0010\u0007R\u0012\u0010\r\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0007R\u0012\u0010\u000f\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0007R\u0012\u0010\u0011\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0007R\u0012\u0010\u0013\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0007R\u0012\u0010\u0015\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0007R\u0012\u0010\u0017\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0007R\u0012\u0010\u0019\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0007R\u0012\u0010\u001b\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0007R\u0012\u0010\u001d\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0007R\u0012\u0010\u001f\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b \u0010\u0007R\u0012\u0010!\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\"\u0010\u0007R\u0012\u0010#\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b$\u0010\u0007R\u0012\u0010%\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b&\u0010\u0007R\u0018\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00050(X\u0096\u0005¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0012\u0010+\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b,\u0010\u0007R\u0012\u0010-\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b.\u0010\u0007R\u0012\u0010/\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b0\u0010\u0007R\u0012\u00101\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b2\u0010\u0007R\u0012\u00103\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b4\u0010\u0007R\u0012\u00105\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b6\u0010\u0007R\u0012\u00107\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b8\u0010\u0007R\u0012\u00109\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b:\u0010\u0007R\u0014\u0010;\u001a\u00020\u00058VX\u0096\u0005¢\u0006\u0006\u001a\u0004\b<\u0010\u0007R\u0012\u0010=\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b>\u0010\u0007R\u0012\u0010?\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b@\u0010\u0007R\u0012\u0010A\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\bB\u0010\u0007R\u0012\u0010C\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\bD\u0010\u0007R\u0012\u0010E\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\bF\u0010\u0007R\u0012\u0010G\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\bH\u0010\u0007R\u0012\u0010I\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\bJ\u0010\u0007R\u0012\u0010K\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\bL\u0010\u0007R\u0012\u0010M\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\bN\u0010\u0007R\u0014\u0010O\u001a\u00020\u00058VX\u0096\u0005¢\u0006\u0006\u001a\u0004\bP\u0010\u0007R\u0012\u0010Q\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\bR\u0010\u0007R\u0012\u0010S\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\bT\u0010\u0007R\u0012\u0010U\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\bV\u0010\u0007R\u0012\u0010W\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\bX\u0010\u0007R\u0012\u0010Y\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\bZ\u0010\u0007R\u0012\u0010[\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\\\u0010\u0007R\u0012\u0010]\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b^\u0010\u0007R\u0012\u0010_\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b`\u0010\u0007R\u0012\u0010a\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\bb\u0010\u0007R\u0012\u0010c\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\bd\u0010\u0007R\u0012\u0010e\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\bf\u0010\u0007R\u0014\u0010g\u001a\u00020\u00058VX\u0096\u0005¢\u0006\u0006\u001a\u0004\bh\u0010\u0007R\u0012\u0010i\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\bj\u0010\u0007R\u0012\u0010k\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\bl\u0010\u0007R\u0012\u0010m\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\bn\u0010\u0007R\u0012\u0010o\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\bp\u0010\u0007R\u0012\u0010q\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\br\u0010\u0007R\u0012\u0010s\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\bt\u0010\u0007R\u0012\u0010u\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\bv\u0010\u0007R\u0012\u0010w\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\bx\u0010\u0007R\u0018\u0010y\u001a\b\u0012\u0004\u0012\u00020\u00050zX\u0096\u0005¢\u0006\u0006\u001a\u0004\b{\u0010|R\u0018\u0010}\u001a\b\u0012\u0004\u0012\u00020\u00050zX\u0096\u0005¢\u0006\u0006\u001a\u0004\b~\u0010|R\u0013\u0010\u007f\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0007\u001a\u0005\b\u0080\u0001\u0010\u0007R\u0014\u0010\u0081\u0001\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0007\u001a\u0005\b\u0082\u0001\u0010\u0007R\u0014\u0010\u0083\u0001\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0007\u001a\u0005\b\u0084\u0001\u0010\u0007R\u0014\u0010\u0085\u0001\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0007\u001a\u0005\b\u0086\u0001\u0010\u0007R\u0014\u0010\u0087\u0001\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0007\u001a\u0005\b\u0088\u0001\u0010\u0007R\u0014\u0010\u0089\u0001\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0007\u001a\u0005\b\u008a\u0001\u0010\u0007R\u0014\u0010\u008b\u0001\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0007\u001a\u0005\b\u008c\u0001\u0010\u0007R\u0014\u0010\u008d\u0001\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0007\u001a\u0005\b\u008e\u0001\u0010\u0007R\u0014\u0010\u008f\u0001\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0007\u001a\u0005\b\u0090\u0001\u0010\u0007R\u0014\u0010\u0091\u0001\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0007\u001a\u0005\b\u0092\u0001\u0010\u0007R\u0014\u0010\u0093\u0001\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0007\u001a\u0005\b\u0094\u0001\u0010\u0007R\u0014\u0010\u0095\u0001\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0007\u001a\u0005\b\u0096\u0001\u0010\u0007R\u0014\u0010\u0097\u0001\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0007\u001a\u0005\b\u0098\u0001\u0010\u0007R\u0014\u0010\u0099\u0001\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0007\u001a\u0005\b\u009a\u0001\u0010\u0007R\u0014\u0010\u009b\u0001\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0007\u001a\u0005\b\u009c\u0001\u0010\u0007R\u0014\u0010\u009d\u0001\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0007\u001a\u0005\b\u009e\u0001\u0010\u0007R\u0014\u0010\u009f\u0001\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0007\u001a\u0005\b \u0001\u0010\u0007R\u0014\u0010¡\u0001\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0007\u001a\u0005\b¢\u0001\u0010\u0007R\u0014\u0010£\u0001\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0007\u001a\u0005\b¤\u0001\u0010\u0007R\u0014\u0010¥\u0001\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0007\u001a\u0005\b¦\u0001\u0010\u0007R\u0014\u0010§\u0001\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0007\u001a\u0005\b¨\u0001\u0010\u0007R\u0014\u0010©\u0001\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0007\u001a\u0005\bª\u0001\u0010\u0007R\u0014\u0010«\u0001\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0007\u001a\u0005\b¬\u0001\u0010\u0007R\u0014\u0010\u00ad\u0001\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0007\u001a\u0005\b®\u0001\u0010\u0007R\u0014\u0010¯\u0001\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0007\u001a\u0005\b°\u0001\u0010\u0007¨\u0006±\u0001"}, d2 = {"Lcom/obric/assistant/network/ObricHttpConst;", "Lcom/larus/network/IHttpConst;", "<init>", "()V", "privacyUrl", "", "getPrivacyUrl", "()Ljava/lang/String;", "privacyNewUrl", "getPrivacyNewUrl", "secLink", "ACCOUNTT_BOE_HOST", "getACCOUNTT_BOE_HOST", "AI_APPLET_JSB_HOST", "getAI_APPLET_JSB_HOST", "ALICE_BOE_HOST", "getALICE_BOE_HOST", "APPLET_DEBUGGER_BASE_URL", "getAPPLET_DEBUGGER_BASE_URL", "ASSIST_CENTER_HOST", "getASSIST_CENTER_HOST", "BAIKE_JSB_HOST", "getBAIKE_JSB_HOST", "BASE_LARK_HOST", "getBASE_LARK_HOST", "BOE", "getBOE", "BOE_HOST", "getBOE_HOST", "BOE_WWW_HOST", "getBOE_WWW_HOST", "BYTEGECKO_HOST_SUFFIX", "getBYTEGECKO_HOST_SUFFIX", "COZE_PLATFORM_HOST", "getCOZE_PLATFORM_HOST", "ENTERPRISE_SAMI_WSS_HOST", "getENTERPRISE_SAMI_WSS_HOST", "ENTERPRISE_SAMI_WSS_QUIC_HOST", "getENTERPRISE_SAMI_WSS_QUIC_HOST", "ENV_HEADER_EXCLUDED_HOSTS", "", "getENV_HEADER_EXCLUDED_HOSTS", "()Ljava/util/Set;", "FEEDBACK_BASE_URL", "getFEEDBACK_BASE_URL", "FEEDBACK_SOURCE_LOGIN", "getFEEDBACK_SOURCE_LOGIN", "FEEDBACK_SOURCE_PAYMENT", "getFEEDBACK_SOURCE_PAYMENT", "FEEDBACK_SOURCE_PHONE_NUMBER_INACTIVE", "getFEEDBACK_SOURCE_PHONE_NUMBER_INACTIVE", "FEEDBACK_SOURCE_PRAISE", "getFEEDBACK_SOURCE_PRAISE", "FEEDBACK_SOURCE_REBIND_PHONE_NUMBER", "getFEEDBACK_SOURCE_REBIND_PHONE_NUMBER", "FEEDBACK_SOURCE_SETTING", "getFEEDBACK_SOURCE_SETTING", "GECKO_HOST", "getGECKO_HOST", "HTTPS", "getHTTPS", "MAIN_APP_HOST_SUFFIX", "getMAIN_APP_HOST_SUFFIX", "MSSDK_PASSPORT_TOKEN", "getMSSDK_PASSPORT_TOKEN", "MSSDK_PASSPORT_TOKEN_Z", "getMSSDK_PASSPORT_TOKEN_Z", "ONLINE", "getONLINE", "ONLINE_API", "getONLINE_API", "ONLINE_BASE_HOST", "getONLINE_BASE_HOST", "ONLINE_BASE_HOST_API", "getONLINE_BASE_HOST_API", "ONLINE_HOST", "getONLINE_HOST", "ONLINE_HOST_API", "getONLINE_HOST_API", "ONLINE_HOST_FOR_SETTINGS", "getONLINE_HOST_FOR_SETTINGS", "ONLINE_RTC_SERVER_MESSAGE_DOMAIN", "getONLINE_RTC_SERVER_MESSAGE_DOMAIN", "ONLINE_WWW", "getONLINE_WWW", "ONLINE_WWW_API", "getONLINE_WWW_API", "ONLINE_WWW_HOST", "getONLINE_WWW_HOST", "ONLINE_WWW_HOST_API", "getONLINE_WWW_HOST_API", "PRAISE_DIALOG_SDK_HOST", "getPRAISE_DIALOG_SDK_HOST", "SAMI_BOE_HOST", "getSAMI_BOE_HOST", "SAMI_WSS_HOST", "getSAMI_WSS_HOST", "SAMI_WSS_QUIC_HOST", "getSAMI_WSS_QUIC_HOST", "SHARE_PASSPORT_LOGIN_TOKEN", "getSHARE_PASSPORT_LOGIN_TOKEN", "TEST_RTC_SERVER_MESSAGE_DOMAIN", "getTEST_RTC_SERVER_MESSAGE_DOMAIN", "WSS", "getWSS", "WSS100_NORMAL_HOST", "getWSS100_NORMAL_HOST", "WSS_NORMAL_BOE_HOST", "getWSS_NORMAL_BOE_HOST", "WSS_NORMAL_HOST", "getWSS_NORMAL_HOST", "WS_SAMANTHA_BOE_HOST", "getWS_SAMANTHA_BOE_HOST", "WS_SAMANTHA_HOST", "getWS_SAMANTHA_HOST", "accessibilitySdkDebugUrl", "getAccessibilitySdkDebugUrl", "accountBanAppealUrl", "getAccountBanAppealUrl", "accountSettingUrl", "getAccountSettingUrl", "authorizationPathWhiteList", "", "getAuthorizationPathWhiteList", "()Ljava/util/List;", "authorizationWhiteList", "getAuthorizationWhiteList", "avatarOnboardingVideoCoverUrl", "getAvatarOnboardingVideoCoverUrl", "avatarOnboardingVideoModelString", "getAvatarOnboardingVideoModelString", "avatarTutorialAudioUrl", "getAvatarTutorialAudioUrl", "configDeepLinkUrl", "getConfigDeepLinkUrl", "configLibraUrl", "getConfigLibraUrl", "denoisePrivacyUrl", "getDenoisePrivacyUrl", "deviceManagementUrl", "getDeviceManagementUrl", "doubaoOfficialWebsite", "getDoubaoOfficialWebsite", "ecommerceQualificationRulesUrl", "getEcommerceQualificationRulesUrl", "faceMemoryPrivacyUrl", "getFaceMemoryPrivacyUrl", "legalFaqUrl", "getLegalFaqUrl", "locallifePlatformQualificationUrl", "getLocallifePlatformQualificationUrl", "locallifePrivacyAgreementUrl", "getLocallifePrivacyAgreementUrl", "locallifeRuleCenterUrl", "getLocallifeRuleCenterUrl", "locallifeUserAgreementUrl", "getLocallifeUserAgreementUrl", "loggingDLPUrl", "getLoggingDLPUrl", "memoryFaqUrl", "getMemoryFaqUrl", "personUrl", "getPersonUrl", "privacyAbsUrl", "getPrivacyAbsUrl", "privacyAccountUrl", "getPrivacyAccountUrl", "shoppingPaymentFaqUrl", "getShoppingPaymentFaqUrl", "termsUrl", "getTermsUrl", "thirdAppSettingsUrl", "getThirdAppSettingsUrl", "toutiaoArticleUrl", "getToutiaoArticleUrl", "trustCenterUrl", "getTrustCenterUrl", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricHttpConst implements IHttpConst {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IHttpConst f390304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f390305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f390306c;

    @Override // com.larus.network.IHttpConst
    public final String A() {
        return this.f390304a.A();
    }

    @Override // com.larus.network.IHttpConst
    public final String A0() {
        return this.f390304a.A0();
    }

    @Override // com.larus.network.IHttpConst
    public final String B() {
        return this.f390304a.B();
    }

    @Override // com.larus.network.IHttpConst
    public final String B0() {
        return this.f390304a.B0();
    }

    @Override // com.larus.network.IHttpConst
    public final String C() {
        return this.f390304a.C();
    }

    @Override // com.larus.network.IHttpConst
    public final String C0() {
        return this.f390304a.C0();
    }

    @Override // com.larus.network.IHttpConst
    public final String D() {
        return this.f390304a.D();
    }

    @Override // com.larus.network.IHttpConst
    public final String D0() {
        return this.f390304a.D0();
    }

    @Override // com.larus.network.IHttpConst
    public final String E() {
        return this.f390304a.E();
    }

    @Override // com.larus.network.IHttpConst
    public final List<String> F() {
        return this.f390304a.F();
    }

    @Override // com.larus.network.IHttpConst
    public final String G() {
        return this.f390304a.G();
    }

    @Override // com.larus.network.IHttpConst
    public final String H() {
        return this.f390304a.H();
    }

    @Override // com.larus.network.IHttpConst
    public final String I() {
        return this.f390304a.I();
    }

    @Override // com.larus.network.IHttpConst
    public final String J() {
        return this.f390304a.J();
    }

    @Override // com.larus.network.IHttpConst
    public final String K() {
        return this.f390304a.K();
    }

    @Override // com.larus.network.IHttpConst
    public final String L() {
        return this.f390304a.L();
    }

    @Override // com.larus.network.IHttpConst
    public final String M() {
        return this.f390304a.M();
    }

    @Override // com.larus.network.IHttpConst
    public final String N() {
        return this.f390304a.N();
    }

    @Override // com.larus.network.IHttpConst
    public final String O() {
        return this.f390304a.O();
    }

    @Override // com.larus.network.IHttpConst
    public final String P() {
        return this.f390304a.P();
    }

    @Override // com.larus.network.IHttpConst
    public final String Q() {
        return this.f390304a.Q();
    }

    @Override // com.larus.network.IHttpConst
    public final String R() {
        return this.f390304a.R();
    }

    @Override // com.larus.network.IHttpConst
    public final String S() {
        return this.f390304a.S();
    }

    @Override // com.larus.network.IHttpConst
    public final String T() {
        return this.f390304a.T();
    }

    @Override // com.larus.network.IHttpConst
    public final String U() {
        return this.f390304a.U();
    }

    @Override // com.larus.network.IHttpConst
    public final String V() {
        return this.f390304a.V();
    }

    @Override // com.larus.network.IHttpConst
    public final String W() {
        return this.f390304a.W();
    }

    @Override // com.larus.network.IHttpConst
    public final String X() {
        return this.f390304a.X();
    }

    @Override // com.larus.network.IHttpConst
    public final String Y() {
        return this.f390304a.Y();
    }

    @Override // com.larus.network.IHttpConst
    public final String Z() {
        return this.f390304a.Z();
    }

    @Override // com.larus.network.IHttpConst
    public final String a() {
        return this.f390304a.a();
    }

    @Override // com.larus.network.IHttpConst
    public final List<String> a0() {
        return this.f390304a.a0();
    }

    @Override // com.larus.network.IHttpConst
    public final String b() {
        return this.f390304a.b();
    }

    @Override // com.larus.network.IHttpConst
    public final String b0() {
        return this.f390304a.b0();
    }

    @Override // com.larus.network.IHttpConst
    public final String c() {
        return this.f390304a.c();
    }

    @Override // com.larus.network.IHttpConst
    public final String c0() {
        return this.f390304a.c0();
    }

    @Override // com.larus.network.IHttpConst
    public final String d() {
        return this.f390304a.d();
    }

    @Override // com.larus.network.IHttpConst
    public final String d0() {
        return this.f390304a.d0();
    }

    @Override // com.larus.network.IHttpConst
    public final String e() {
        return this.f390304a.e();
    }

    @Override // com.larus.network.IHttpConst
    public final String e0() {
        return this.f390304a.e0();
    }

    @Override // com.larus.network.IHttpConst
    public final String f() {
        return this.f390304a.f();
    }

    @Override // com.larus.network.IHttpConst
    public final String f0() {
        return this.f390304a.f0();
    }

    @Override // com.larus.network.IHttpConst
    public final String g0() {
        return this.f390304a.g0();
    }

    @Override // com.larus.network.IHttpConst
    public final String h() {
        return this.f390304a.h();
    }

    @Override // com.larus.network.IHttpConst
    public final String h0() {
        return this.f390304a.h0();
    }

    @Override // com.larus.network.IHttpConst
    public final String i() {
        return this.f390304a.i();
    }

    @Override // com.larus.network.IHttpConst
    public final String i0() {
        return this.f390304a.i0();
    }

    @Override // com.larus.network.IHttpConst
    public final String j() {
        return this.f390304a.j();
    }

    @Override // com.larus.network.IHttpConst
    public final String j0() {
        return this.f390304a.j0();
    }

    @Override // com.larus.network.IHttpConst
    public final String k() {
        return this.f390304a.k();
    }

    @Override // com.larus.network.IHttpConst
    public final String k0() {
        return this.f390304a.k0();
    }

    @Override // com.larus.network.IHttpConst
    public final String l() {
        return this.f390304a.l();
    }

    @Override // com.larus.network.IHttpConst
    public final String l0() {
        return this.f390304a.l0();
    }

    @Override // com.larus.network.IHttpConst
    public final String m() {
        return this.f390304a.m();
    }

    @Override // com.larus.network.IHttpConst
    public final String m0() {
        return this.f390304a.m0();
    }

    @Override // com.larus.network.IHttpConst
    public final String n() {
        return this.f390304a.n();
    }

    @Override // com.larus.network.IHttpConst
    public final String n0() {
        return this.f390304a.n0();
    }

    @Override // com.larus.network.IHttpConst
    public final String o() {
        return this.f390304a.o();
    }

    @Override // com.larus.network.IHttpConst
    public final String o0() {
        return this.f390304a.o0();
    }

    @Override // com.larus.network.IHttpConst
    public final String p() {
        return this.f390304a.p();
    }

    @Override // com.larus.network.IHttpConst
    public final String p0() {
        return this.f390304a.p0();
    }

    @Override // com.larus.network.IHttpConst
    public final String q() {
        return this.f390304a.q();
    }

    @Override // com.larus.network.IHttpConst
    public final String q0() {
        return this.f390304a.q0();
    }

    @Override // com.larus.network.IHttpConst
    public final String r() {
        return this.f390304a.r();
    }

    @Override // com.larus.network.IHttpConst
    public final String r0() {
        return this.f390304a.r0();
    }

    @Override // com.larus.network.IHttpConst
    public final String s() {
        return this.f390304a.s();
    }

    @Override // com.larus.network.IHttpConst
    public final String s0() {
        return this.f390304a.s0();
    }

    @Override // com.larus.network.IHttpConst
    public final String t() {
        return this.f390304a.t();
    }

    @Override // com.larus.network.IHttpConst
    public final String u() {
        return this.f390304a.u();
    }

    @Override // com.larus.network.IHttpConst
    public final String u0() {
        return this.f390304a.u0();
    }

    @Override // com.larus.network.IHttpConst
    public final String v() {
        return this.f390304a.v();
    }

    @Override // com.larus.network.IHttpConst
    public final String v0() {
        return this.f390304a.v0();
    }

    @Override // com.larus.network.IHttpConst
    public final String w() {
        return this.f390304a.w();
    }

    @Override // com.larus.network.IHttpConst
    public final String w0() {
        return this.f390304a.w0();
    }

    @Override // com.larus.network.IHttpConst
    public final String x() {
        return this.f390304a.x();
    }

    @Override // com.larus.network.IHttpConst
    public final String x0() {
        return this.f390304a.x0();
    }

    @Override // com.larus.network.IHttpConst
    public final String y() {
        return this.f390304a.y();
    }

    @Override // com.larus.network.IHttpConst
    public final String y0() {
        return this.f390304a.y0();
    }

    @Override // com.larus.network.IHttpConst
    public final Set<String> z() {
        return this.f390304a.z();
    }

    @Override // com.larus.network.IHttpConst
    public final String z0() {
        return this.f390304a.z0();
    }

    public ObricHttpConst() {
        IHttpConst r100 = (IHttpConst) ServiceManager.get().getServiceForReal(IHttpConst.class);
        if (r100 != null) goto L5;
        r100 = (IHttpConst) DynamicProxy.get(IHttpConst.class);
    L5:
        this.f390304a = r100;
        this.f390305b = A0() + "/ocean_legal/privacy";
        this.f390306c = "https://os.obriccloud.com/agreement/model_training_faq";
    }

    @Override // com.larus.network.IHttpConst
    public final String g() {
        return this.f390306c;
    }

    @Override // com.larus.network.IHttpConst
    public final String t0() {
        return this.f390305b;
    }
}
