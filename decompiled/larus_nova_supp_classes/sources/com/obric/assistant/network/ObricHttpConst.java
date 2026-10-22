package com.obric.assistant.network;

import android.util.EventsUtils;
import com.larus.network.IHttpConst;
import com.ss.android.ugc.aweme.framework.services.DynamicProxy;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\"\n\u0002\u0010\"\n\u0002\bQ\n\u0002\u0010 \n\u0002\b7\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\n\u001a\u00020\u0005H\u0096\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0012\u0010\u000b\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\f\u0010\u0007R\u0012\u0010\r\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0007R\u0012\u0010\u000f\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0007R\u0012\u0010\u0011\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0007R\u0012\u0010\u0013\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0007R\u0012\u0010\u0015\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0007R\u0012\u0010\u0017\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0007R\u0012\u0010\u0019\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0007R\u0012\u0010\u001b\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0007R\u0012\u0010\u001d\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0007R\u0012\u0010\u001f\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b \u0010\u0007R\u0012\u0010!\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\"\u0010\u0007R\u0012\u0010#\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b$\u0010\u0007R\u0012\u0010%\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b&\u0010\u0007R\u0018\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00050(X\u0096\u0005¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0012\u0010+\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b,\u0010\u0007R\u0012\u0010-\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b.\u0010\u0007R\u0012\u0010/\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b0\u0010\u0007R\u0012\u00101\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b2\u0010\u0007R\u0012\u00103\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b4\u0010\u0007R\u0012\u00105\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b6\u0010\u0007R\u0012\u00107\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b8\u0010\u0007R\u0012\u00109\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b:\u0010\u0007R\u0014\u0010;\u001a\u00020\u00058VX\u0096\u0005¢\u0006\u0006\u001a\u0004\b<\u0010\u0007R\u0012\u0010=\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b>\u0010\u0007R\u0012\u0010?\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b@\u0010\u0007R\u0012\u0010A\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\bB\u0010\u0007R\u0012\u0010C\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\bD\u0010\u0007R\u0012\u0010E\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\bF\u0010\u0007R\u0012\u0010G\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\bH\u0010\u0007R\u0012\u0010I\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\bJ\u0010\u0007R\u0012\u0010K\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\bL\u0010\u0007R\u0012\u0010M\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\bN\u0010\u0007R\u0014\u0010O\u001a\u00020\u00058VX\u0096\u0005¢\u0006\u0006\u001a\u0004\bP\u0010\u0007R\u0012\u0010Q\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\bR\u0010\u0007R\u0012\u0010S\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\bT\u0010\u0007R\u0012\u0010U\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\bV\u0010\u0007R\u0012\u0010W\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\bX\u0010\u0007R\u0012\u0010Y\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\bZ\u0010\u0007R\u0012\u0010[\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\\\u0010\u0007R\u0012\u0010]\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b^\u0010\u0007R\u0012\u0010_\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b`\u0010\u0007R\u0012\u0010a\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\bb\u0010\u0007R\u0012\u0010c\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\bd\u0010\u0007R\u0012\u0010e\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\bf\u0010\u0007R\u0014\u0010g\u001a\u00020\u00058VX\u0096\u0005¢\u0006\u0006\u001a\u0004\bh\u0010\u0007R\u0012\u0010i\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\bj\u0010\u0007R\u0012\u0010k\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\bl\u0010\u0007R\u0012\u0010m\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\bn\u0010\u0007R\u0012\u0010o\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\bp\u0010\u0007R\u0012\u0010q\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\br\u0010\u0007R\u0012\u0010s\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\bt\u0010\u0007R\u0012\u0010u\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\bv\u0010\u0007R\u0012\u0010w\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\bx\u0010\u0007R\u0018\u0010y\u001a\b\u0012\u0004\u0012\u00020\u00050zX\u0096\u0005¢\u0006\u0006\u001a\u0004\b{\u0010|R\u0018\u0010}\u001a\b\u0012\u0004\u0012\u00020\u00050zX\u0096\u0005¢\u0006\u0006\u001a\u0004\b~\u0010|R\u0013\u0010\u007f\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0007\u001a\u0005\b\u0080\u0001\u0010\u0007R\u0014\u0010\u0081\u0001\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0007\u001a\u0005\b\u0082\u0001\u0010\u0007R\u0014\u0010\u0083\u0001\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0007\u001a\u0005\b\u0084\u0001\u0010\u0007R\u0014\u0010\u0085\u0001\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0007\u001a\u0005\b\u0086\u0001\u0010\u0007R\u0014\u0010\u0087\u0001\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0007\u001a\u0005\b\u0088\u0001\u0010\u0007R\u0014\u0010\u0089\u0001\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0007\u001a\u0005\b\u008a\u0001\u0010\u0007R\u0014\u0010\u008b\u0001\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0007\u001a\u0005\b\u008c\u0001\u0010\u0007R\u0014\u0010\u008d\u0001\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0007\u001a\u0005\b\u008e\u0001\u0010\u0007R\u0014\u0010\u008f\u0001\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0007\u001a\u0005\b\u0090\u0001\u0010\u0007R\u0014\u0010\u0091\u0001\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0007\u001a\u0005\b\u0092\u0001\u0010\u0007R\u0014\u0010\u0093\u0001\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0007\u001a\u0005\b\u0094\u0001\u0010\u0007R\u0014\u0010\u0095\u0001\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0007\u001a\u0005\b\u0096\u0001\u0010\u0007R\u0014\u0010\u0097\u0001\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0007\u001a\u0005\b\u0098\u0001\u0010\u0007R\u0014\u0010\u0099\u0001\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0007\u001a\u0005\b\u009a\u0001\u0010\u0007R\u0014\u0010\u009b\u0001\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0007\u001a\u0005\b\u009c\u0001\u0010\u0007R\u0014\u0010\u009d\u0001\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0007\u001a\u0005\b\u009e\u0001\u0010\u0007R\u0014\u0010\u009f\u0001\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0007\u001a\u0005\b \u0001\u0010\u0007R\u0014\u0010¡\u0001\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0007\u001a\u0005\b¢\u0001\u0010\u0007R\u0014\u0010£\u0001\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0007\u001a\u0005\b¤\u0001\u0010\u0007R\u0014\u0010¥\u0001\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0007\u001a\u0005\b¦\u0001\u0010\u0007R\u0014\u0010§\u0001\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0007\u001a\u0005\b¨\u0001\u0010\u0007R\u0014\u0010©\u0001\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0007\u001a\u0005\bª\u0001\u0010\u0007R\u0014\u0010«\u0001\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0007\u001a\u0005\b¬\u0001\u0010\u0007R\u0014\u0010\u00ad\u0001\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0007\u001a\u0005\b®\u0001\u0010\u0007R\u0014\u0010¯\u0001\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0007\u001a\u0005\b°\u0001\u0010\u0007¨\u0006±\u0001"}, d2 = {"Lcom/obric/assistant/network/ObricHttpConst;", "Lcom/larus/network/IHttpConst;", "<init>", "()V", "privacyUrl", XmlPullParser.NO_NAMESPACE, "getPrivacyUrl", "()Ljava/lang/String;", "privacyNewUrl", "getPrivacyNewUrl", "secLink", "ACCOUNTT_BOE_HOST", "getACCOUNTT_BOE_HOST", "AI_APPLET_JSB_HOST", "getAI_APPLET_JSB_HOST", "ALICE_BOE_HOST", "getALICE_BOE_HOST", "APPLET_DEBUGGER_BASE_URL", "getAPPLET_DEBUGGER_BASE_URL", "ASSIST_CENTER_HOST", "getASSIST_CENTER_HOST", "BAIKE_JSB_HOST", "getBAIKE_JSB_HOST", "BASE_LARK_HOST", "getBASE_LARK_HOST", "BOE", "getBOE", "BOE_HOST", "getBOE_HOST", "BOE_WWW_HOST", "getBOE_WWW_HOST", "BYTEGECKO_HOST_SUFFIX", "getBYTEGECKO_HOST_SUFFIX", "COZE_PLATFORM_HOST", "getCOZE_PLATFORM_HOST", "ENTERPRISE_SAMI_WSS_HOST", "getENTERPRISE_SAMI_WSS_HOST", "ENTERPRISE_SAMI_WSS_QUIC_HOST", "getENTERPRISE_SAMI_WSS_QUIC_HOST", "ENV_HEADER_EXCLUDED_HOSTS", XmlPullParser.NO_NAMESPACE, "getENV_HEADER_EXCLUDED_HOSTS", "()Ljava/util/Set;", "FEEDBACK_BASE_URL", "getFEEDBACK_BASE_URL", "FEEDBACK_SOURCE_LOGIN", "getFEEDBACK_SOURCE_LOGIN", "FEEDBACK_SOURCE_PAYMENT", "getFEEDBACK_SOURCE_PAYMENT", "FEEDBACK_SOURCE_PHONE_NUMBER_INACTIVE", "getFEEDBACK_SOURCE_PHONE_NUMBER_INACTIVE", "FEEDBACK_SOURCE_PRAISE", "getFEEDBACK_SOURCE_PRAISE", "FEEDBACK_SOURCE_REBIND_PHONE_NUMBER", "getFEEDBACK_SOURCE_REBIND_PHONE_NUMBER", "FEEDBACK_SOURCE_SETTING", "getFEEDBACK_SOURCE_SETTING", "GECKO_HOST", "getGECKO_HOST", "HTTPS", "getHTTPS", "MAIN_APP_HOST_SUFFIX", "getMAIN_APP_HOST_SUFFIX", "MSSDK_PASSPORT_TOKEN", "getMSSDK_PASSPORT_TOKEN", "MSSDK_PASSPORT_TOKEN_Z", "getMSSDK_PASSPORT_TOKEN_Z", "ONLINE", "getONLINE", "ONLINE_API", "getONLINE_API", "ONLINE_BASE_HOST", "getONLINE_BASE_HOST", "ONLINE_BASE_HOST_API", "getONLINE_BASE_HOST_API", "ONLINE_HOST", "getONLINE_HOST", "ONLINE_HOST_API", "getONLINE_HOST_API", "ONLINE_HOST_FOR_SETTINGS", "getONLINE_HOST_FOR_SETTINGS", "ONLINE_RTC_SERVER_MESSAGE_DOMAIN", "getONLINE_RTC_SERVER_MESSAGE_DOMAIN", "ONLINE_WWW", "getONLINE_WWW", "ONLINE_WWW_API", "getONLINE_WWW_API", "ONLINE_WWW_HOST", "getONLINE_WWW_HOST", "ONLINE_WWW_HOST_API", "getONLINE_WWW_HOST_API", "PRAISE_DIALOG_SDK_HOST", "getPRAISE_DIALOG_SDK_HOST", "SAMI_BOE_HOST", "getSAMI_BOE_HOST", "SAMI_WSS_HOST", "getSAMI_WSS_HOST", "SAMI_WSS_QUIC_HOST", "getSAMI_WSS_QUIC_HOST", "SHARE_PASSPORT_LOGIN_TOKEN", "getSHARE_PASSPORT_LOGIN_TOKEN", "TEST_RTC_SERVER_MESSAGE_DOMAIN", "getTEST_RTC_SERVER_MESSAGE_DOMAIN", "WSS", "getWSS", "WSS100_NORMAL_HOST", "getWSS100_NORMAL_HOST", "WSS_NORMAL_BOE_HOST", "getWSS_NORMAL_BOE_HOST", "WSS_NORMAL_HOST", "getWSS_NORMAL_HOST", "WS_SAMANTHA_BOE_HOST", "getWS_SAMANTHA_BOE_HOST", "WS_SAMANTHA_HOST", "getWS_SAMANTHA_HOST", "accessibilitySdkDebugUrl", "getAccessibilitySdkDebugUrl", "accountBanAppealUrl", "getAccountBanAppealUrl", "accountSettingUrl", "getAccountSettingUrl", "authorizationPathWhiteList", XmlPullParser.NO_NAMESPACE, "getAuthorizationPathWhiteList", "()Ljava/util/List;", "authorizationWhiteList", "getAuthorizationWhiteList", "avatarOnboardingVideoCoverUrl", "getAvatarOnboardingVideoCoverUrl", "avatarOnboardingVideoModelString", "getAvatarOnboardingVideoModelString", "avatarTutorialAudioUrl", "getAvatarTutorialAudioUrl", "configDeepLinkUrl", "getConfigDeepLinkUrl", "configLibraUrl", "getConfigLibraUrl", "denoisePrivacyUrl", "getDenoisePrivacyUrl", "deviceManagementUrl", "getDeviceManagementUrl", "doubaoOfficialWebsite", "getDoubaoOfficialWebsite", "ecommerceQualificationRulesUrl", "getEcommerceQualificationRulesUrl", "faceMemoryPrivacyUrl", "getFaceMemoryPrivacyUrl", "legalFaqUrl", "getLegalFaqUrl", "locallifePlatformQualificationUrl", "getLocallifePlatformQualificationUrl", "locallifePrivacyAgreementUrl", "getLocallifePrivacyAgreementUrl", "locallifeRuleCenterUrl", "getLocallifeRuleCenterUrl", "locallifeUserAgreementUrl", "getLocallifeUserAgreementUrl", "loggingDLPUrl", "getLoggingDLPUrl", "memoryFaqUrl", "getMemoryFaqUrl", "personUrl", "getPersonUrl", "privacyAbsUrl", "getPrivacyAbsUrl", "privacyAccountUrl", "getPrivacyAccountUrl", "shoppingPaymentFaqUrl", "getShoppingPaymentFaqUrl", "termsUrl", "getTermsUrl", "thirdAppSettingsUrl", "getThirdAppSettingsUrl", "toutiaoArticleUrl", "getToutiaoArticleUrl", "trustCenterUrl", "getTrustCenterUrl", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class ObricHttpConst implements IHttpConst {
    public final /* synthetic */ IHttpConst a;
    public final String b;
    public final String c;

    @Override // com.larus.network.IHttpConst
    public final String A() {
        return this.a.A();
    }

    @Override // com.larus.network.IHttpConst
    public final String A0() {
        return this.a.A0();
    }

    @Override // com.larus.network.IHttpConst
    public final String B() {
        return this.a.B();
    }

    @Override // com.larus.network.IHttpConst
    public final String B0() {
        return this.a.B0();
    }

    @Override // com.larus.network.IHttpConst
    public final String C() {
        return this.a.C();
    }

    @Override // com.larus.network.IHttpConst
    public final String C0() {
        return this.a.C0();
    }

    @Override // com.larus.network.IHttpConst
    public final String D() {
        return this.a.D();
    }

    @Override // com.larus.network.IHttpConst
    public final String D0() {
        return this.a.D0();
    }

    @Override // com.larus.network.IHttpConst
    public final String E() {
        return this.a.E();
    }

    @Override // com.larus.network.IHttpConst
    public final List<String> F() {
        return this.a.F();
    }

    @Override // com.larus.network.IHttpConst
    public final String G() {
        return this.a.G();
    }

    @Override // com.larus.network.IHttpConst
    public final String H() {
        return this.a.H();
    }

    @Override // com.larus.network.IHttpConst
    public final String I() {
        return this.a.I();
    }

    @Override // com.larus.network.IHttpConst
    public final String J() {
        return this.a.J();
    }

    @Override // com.larus.network.IHttpConst
    public final String K() {
        return this.a.K();
    }

    @Override // com.larus.network.IHttpConst
    public final String L() {
        return this.a.L();
    }

    @Override // com.larus.network.IHttpConst
    public final String M() {
        return this.a.M();
    }

    @Override // com.larus.network.IHttpConst
    public final String N() {
        return this.a.N();
    }

    @Override // com.larus.network.IHttpConst
    public final String O() {
        return this.a.O();
    }

    @Override // com.larus.network.IHttpConst
    public final String P() {
        return this.a.P();
    }

    @Override // com.larus.network.IHttpConst
    public final String Q() {
        return this.a.Q();
    }

    @Override // com.larus.network.IHttpConst
    public final String R() {
        return this.a.R();
    }

    @Override // com.larus.network.IHttpConst
    public final String S() {
        return this.a.S();
    }

    @Override // com.larus.network.IHttpConst
    public final String T() {
        return this.a.T();
    }

    @Override // com.larus.network.IHttpConst
    public final String U() {
        return this.a.U();
    }

    @Override // com.larus.network.IHttpConst
    public final String V() {
        return this.a.V();
    }

    @Override // com.larus.network.IHttpConst
    public final String W() {
        return this.a.W();
    }

    @Override // com.larus.network.IHttpConst
    public final String X() {
        return this.a.X();
    }

    @Override // com.larus.network.IHttpConst
    public final String Y() {
        return this.a.Y();
    }

    @Override // com.larus.network.IHttpConst
    public final String Z() {
        return this.a.Z();
    }

    @Override // com.larus.network.IHttpConst
    public final String a() {
        return this.a.a();
    }

    @Override // com.larus.network.IHttpConst
    public final List<String> a0() {
        return this.a.a0();
    }

    @Override // com.larus.network.IHttpConst
    public final String b() {
        return this.a.b();
    }

    @Override // com.larus.network.IHttpConst
    public final String b0() {
        return this.a.b0();
    }

    @Override // com.larus.network.IHttpConst
    public final String c() {
        return this.a.c();
    }

    @Override // com.larus.network.IHttpConst
    public final String c0() {
        return this.a.c0();
    }

    @Override // com.larus.network.IHttpConst
    public final String d() {
        return this.a.d();
    }

    @Override // com.larus.network.IHttpConst
    public final String d0() {
        return this.a.d0();
    }

    @Override // com.larus.network.IHttpConst
    public final String e() {
        return this.a.e();
    }

    @Override // com.larus.network.IHttpConst
    public final String e0() {
        return this.a.e0();
    }

    @Override // com.larus.network.IHttpConst
    public final String f() {
        return this.a.f();
    }

    @Override // com.larus.network.IHttpConst
    public final String f0() {
        return this.a.f0();
    }

    @Override // com.larus.network.IHttpConst
    public final String g0() {
        return this.a.g0();
    }

    @Override // com.larus.network.IHttpConst
    public final String h() {
        return this.a.h();
    }

    @Override // com.larus.network.IHttpConst
    public final String h0() {
        return this.a.h0();
    }

    @Override // com.larus.network.IHttpConst
    public final String i() {
        return this.a.i();
    }

    @Override // com.larus.network.IHttpConst
    public final String i0() {
        return this.a.i0();
    }

    @Override // com.larus.network.IHttpConst
    public final String j() {
        return this.a.j();
    }

    @Override // com.larus.network.IHttpConst
    public final String j0() {
        return this.a.j0();
    }

    @Override // com.larus.network.IHttpConst
    public final String k() {
        return this.a.k();
    }

    @Override // com.larus.network.IHttpConst
    public final String k0() {
        return this.a.k0();
    }

    @Override // com.larus.network.IHttpConst
    public final String l() {
        return this.a.l();
    }

    @Override // com.larus.network.IHttpConst
    public final String l0() {
        return this.a.l0();
    }

    @Override // com.larus.network.IHttpConst
    public final String m() {
        return this.a.m();
    }

    @Override // com.larus.network.IHttpConst
    public final String m0() {
        return this.a.m0();
    }

    @Override // com.larus.network.IHttpConst
    public final String n() {
        return this.a.n();
    }

    @Override // com.larus.network.IHttpConst
    public final String n0() {
        return this.a.n0();
    }

    @Override // com.larus.network.IHttpConst
    public final String o() {
        return this.a.o();
    }

    @Override // com.larus.network.IHttpConst
    public final String o0() {
        return this.a.o0();
    }

    @Override // com.larus.network.IHttpConst
    public final String p() {
        return this.a.p();
    }

    @Override // com.larus.network.IHttpConst
    public final String p0() {
        return this.a.p0();
    }

    @Override // com.larus.network.IHttpConst
    public final String q() {
        return this.a.q();
    }

    @Override // com.larus.network.IHttpConst
    public final String q0() {
        return this.a.q0();
    }

    @Override // com.larus.network.IHttpConst
    public final String r() {
        return this.a.r();
    }

    @Override // com.larus.network.IHttpConst
    public final String r0() {
        return this.a.r0();
    }

    @Override // com.larus.network.IHttpConst
    public final String s() {
        return this.a.s();
    }

    @Override // com.larus.network.IHttpConst
    public final String s0() {
        return this.a.s0();
    }

    @Override // com.larus.network.IHttpConst
    public final String t() {
        return this.a.t();
    }

    @Override // com.larus.network.IHttpConst
    public final String u() {
        return this.a.u();
    }

    @Override // com.larus.network.IHttpConst
    public final String u0() {
        return this.a.u0();
    }

    @Override // com.larus.network.IHttpConst
    public final String v() {
        return this.a.v();
    }

    @Override // com.larus.network.IHttpConst
    public final String v0() {
        return this.a.v0();
    }

    @Override // com.larus.network.IHttpConst
    public final String w() {
        return this.a.w();
    }

    @Override // com.larus.network.IHttpConst
    public final String w0() {
        return this.a.w0();
    }

    @Override // com.larus.network.IHttpConst
    public final String x() {
        return this.a.x();
    }

    @Override // com.larus.network.IHttpConst
    public final String x0() {
        return this.a.x0();
    }

    @Override // com.larus.network.IHttpConst
    public final String y() {
        return this.a.y();
    }

    @Override // com.larus.network.IHttpConst
    public final String y0() {
        return this.a.y0();
    }

    @Override // com.larus.network.IHttpConst
    public final Set<String> z() {
        return this.a.z();
    }

    @Override // com.larus.network.IHttpConst
    public final String z0() {
        return this.a.z0();
    }

    public ObricHttpConst() {
        IHttpConst r0 = (IHttpConst) ServiceManager.get().getServiceForReal(IHttpConst.class);
        if (r0 != null) goto L5;
        r0 = (IHttpConst) DynamicProxy.get(IHttpConst.class);
    L5:
        this.a = r0;
        this.b = A0() + "/ocean_legal/privacy";
        this.c = "https://os.obriccloud.com/agreement/model_training_faq";
    }

    @Override // com.larus.network.IHttpConst
    public final String g() {
        return this.c;
    }

    @Override // com.larus.network.IHttpConst
    public final String t0() {
        return this.b;
    }
}
