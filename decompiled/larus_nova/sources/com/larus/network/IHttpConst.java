package com.larus.network;

import java.util.List;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b~\n\u0002\u0010 \n\u0002\b\u0015\n\u0002\u0010\"\n\u0002\b\u0017\bg\u0018\u00002\u00020\u0001J\b\u0010h\u001a\u00020\u0003H&R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0012\u0010\n\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0012\u0010\f\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005R\u0012\u0010\u000e\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005R\u0012\u0010\u0010\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0005R\u0012\u0010\u0012\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0005R\u0012\u0010\u0014\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0005R\u0012\u0010\u0016\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0005R\u0014\u0010\u0018\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0005R\u0012\u0010\u001a\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0005R\u0012\u0010\u001c\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0005R\u0012\u0010\u001e\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0005R\u0012\u0010 \u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0005R\u0012\u0010\"\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0005R\u0012\u0010$\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u0005R\u0012\u0010&\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u0005R\u0012\u0010(\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u0005R\u0012\u0010*\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\u0005R\u0012\u0010,\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b-\u0010\u0005R\u0012\u0010.\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b/\u0010\u0005R\u0012\u00100\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b1\u0010\u0005R\u0012\u00102\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b3\u0010\u0005R\u0012\u00104\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b5\u0010\u0005R\u0012\u00106\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b7\u0010\u0005R\u0012\u00108\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b9\u0010\u0005R\u0012\u0010:\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b;\u0010\u0005R\u0012\u0010<\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b=\u0010\u0005R\u0012\u0010>\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b?\u0010\u0005R\u0012\u0010@\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\bA\u0010\u0005R\u0012\u0010B\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\bC\u0010\u0005R\u0012\u0010D\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\bE\u0010\u0005R\u0012\u0010F\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\bG\u0010\u0005R\u0012\u0010H\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\bI\u0010\u0005R\u0012\u0010J\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\bK\u0010\u0005R\u0012\u0010L\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\bM\u0010\u0005R\u0012\u0010N\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\bO\u0010\u0005R\u0012\u0010P\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010\u0005R\u0012\u0010R\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\bS\u0010\u0005R\u0012\u0010T\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\bU\u0010\u0005R\u0012\u0010V\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\bW\u0010\u0005R\u0012\u0010X\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\bY\u0010\u0005R\u0012\u0010Z\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b[\u0010\u0005R\u0012\u0010\\\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b]\u0010\u0005R\u0012\u0010^\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b_\u0010\u0005R\u0012\u0010`\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\ba\u0010\u0005R\u0012\u0010b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\bc\u0010\u0005R\u0012\u0010d\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\be\u0010\u0005R\u0012\u0010f\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\bg\u0010\u0005R\u0012\u0010i\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\bj\u0010\u0005R\u0012\u0010k\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\bl\u0010\u0005R\u0012\u0010m\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\bn\u0010\u0005R\u0012\u0010o\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\bp\u0010\u0005R\u0012\u0010q\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\br\u0010\u0005R\u0012\u0010s\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\bt\u0010\u0005R\u0012\u0010u\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\bv\u0010\u0005R\u0012\u0010w\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\bx\u0010\u0005R\u0012\u0010y\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\bz\u0010\u0005R\u0012\u0010{\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b|\u0010\u0005R\u0012\u0010}\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b~\u0010\u0005R\u0013\u0010\u007f\u001a\u00020\u0003X¦\u0004¢\u0006\u0007\u001a\u0005\b\u0080\u0001\u0010\u0005R\u001c\u0010\u0081\u0001\u001a\t\u0012\u0004\u0012\u00020\u00030\u0082\u0001X¦\u0004¢\u0006\b\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001R\u001c\u0010\u0085\u0001\u001a\t\u0012\u0004\u0012\u00020\u00030\u0082\u0001X¦\u0004¢\u0006\b\u001a\u0006\b\u0086\u0001\u0010\u0084\u0001R\u0014\u0010\u0087\u0001\u001a\u00020\u0003X¦\u0004¢\u0006\u0007\u001a\u0005\b\u0088\u0001\u0010\u0005R\u0014\u0010\u0089\u0001\u001a\u00020\u0003X¦\u0004¢\u0006\u0007\u001a\u0005\b\u008a\u0001\u0010\u0005R\u0014\u0010\u008b\u0001\u001a\u00020\u0003X¦\u0004¢\u0006\u0007\u001a\u0005\b\u008c\u0001\u0010\u0005R\u0014\u0010\u008d\u0001\u001a\u00020\u0003X¦\u0004¢\u0006\u0007\u001a\u0005\b\u008e\u0001\u0010\u0005R\u0014\u0010\u008f\u0001\u001a\u00020\u0003X¦\u0004¢\u0006\u0007\u001a\u0005\b\u0090\u0001\u0010\u0005R\u0014\u0010\u0091\u0001\u001a\u00020\u0003X¦\u0004¢\u0006\u0007\u001a\u0005\b\u0092\u0001\u0010\u0005R\u0014\u0010\u0093\u0001\u001a\u00020\u0003X¦\u0004¢\u0006\u0007\u001a\u0005\b\u0094\u0001\u0010\u0005R\u0014\u0010\u0095\u0001\u001a\u00020\u0003X¦\u0004¢\u0006\u0007\u001a\u0005\b\u0096\u0001\u0010\u0005R\u001c\u0010\u0097\u0001\u001a\t\u0012\u0004\u0012\u00020\u00030\u0098\u0001X¦\u0004¢\u0006\b\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001R\u0014\u0010\u009b\u0001\u001a\u00020\u0003X¦\u0004¢\u0006\u0007\u001a\u0005\b\u009c\u0001\u0010\u0005R\u0014\u0010\u009d\u0001\u001a\u00020\u0003X¦\u0004¢\u0006\u0007\u001a\u0005\b\u009e\u0001\u0010\u0005R\u0014\u0010\u009f\u0001\u001a\u00020\u0003X¦\u0004¢\u0006\u0007\u001a\u0005\b \u0001\u0010\u0005R\u0014\u0010¡\u0001\u001a\u00020\u0003X¦\u0004¢\u0006\u0007\u001a\u0005\b¢\u0001\u0010\u0005R\u0014\u0010£\u0001\u001a\u00020\u0003X¦\u0004¢\u0006\u0007\u001a\u0005\b¤\u0001\u0010\u0005R\u0014\u0010¥\u0001\u001a\u00020\u0003X¦\u0004¢\u0006\u0007\u001a\u0005\b¦\u0001\u0010\u0005R\u0014\u0010§\u0001\u001a\u00020\u0003X¦\u0004¢\u0006\u0007\u001a\u0005\b¨\u0001\u0010\u0005R\u0014\u0010©\u0001\u001a\u00020\u0003X¦\u0004¢\u0006\u0007\u001a\u0005\bª\u0001\u0010\u0005R\u0014\u0010«\u0001\u001a\u00020\u0003X¦\u0004¢\u0006\u0007\u001a\u0005\b¬\u0001\u0010\u0005R\u0014\u0010\u00ad\u0001\u001a\u00020\u0003X¦\u0004¢\u0006\u0007\u001a\u0005\b®\u0001\u0010\u0005¨\u0006¯\u0001"}, d2 = {"Lcom/larus/network/IHttpConst;", "", "WSS", "", "getWSS", "()Ljava/lang/String;", "HTTPS", "getHTTPS", "ONLINE_BASE_HOST_API", "getONLINE_BASE_HOST_API", "ONLINE_BASE_HOST", "getONLINE_BASE_HOST", "ONLINE_WWW_HOST", "getONLINE_WWW_HOST", "ONLINE_WWW_HOST_API", "getONLINE_WWW_HOST_API", "ONLINE_WWW", "getONLINE_WWW", "ONLINE_WWW_API", "getONLINE_WWW_API", "ONLINE_HOST", "getONLINE_HOST", "ONLINE_HOST_API", "getONLINE_HOST_API", "ONLINE_HOST_FOR_SETTINGS", "getONLINE_HOST_FOR_SETTINGS", "ONLINE", "getONLINE", "ONLINE_API", "getONLINE_API", "APPLET_DEBUGGER_BASE_URL", "getAPPLET_DEBUGGER_BASE_URL", "BOE_HOST", "getBOE_HOST", "BOE", "getBOE", "SAMI_WSS_HOST", "getSAMI_WSS_HOST", "ENTERPRISE_SAMI_WSS_HOST", "getENTERPRISE_SAMI_WSS_HOST", "SAMI_WSS_QUIC_HOST", "getSAMI_WSS_QUIC_HOST", "ENTERPRISE_SAMI_WSS_QUIC_HOST", "getENTERPRISE_SAMI_WSS_QUIC_HOST", "SHARE_PASSPORT_LOGIN_TOKEN", "getSHARE_PASSPORT_LOGIN_TOKEN", "MSSDK_PASSPORT_TOKEN", "getMSSDK_PASSPORT_TOKEN", "MSSDK_PASSPORT_TOKEN_Z", "getMSSDK_PASSPORT_TOKEN_Z", "PRAISE_DIALOG_SDK_HOST", "getPRAISE_DIALOG_SDK_HOST", "COZE_PLATFORM_HOST", "getCOZE_PLATFORM_HOST", "ASSIST_CENTER_HOST", "getASSIST_CENTER_HOST", "AI_APPLET_JSB_HOST", "getAI_APPLET_JSB_HOST", "BAIKE_JSB_HOST", "getBAIKE_JSB_HOST", "FEEDBACK_BASE_URL", "getFEEDBACK_BASE_URL", "FEEDBACK_SOURCE_LOGIN", "getFEEDBACK_SOURCE_LOGIN", "FEEDBACK_SOURCE_SETTING", "getFEEDBACK_SOURCE_SETTING", "FEEDBACK_SOURCE_PAYMENT", "getFEEDBACK_SOURCE_PAYMENT", "FEEDBACK_SOURCE_PRAISE", "getFEEDBACK_SOURCE_PRAISE", "FEEDBACK_SOURCE_REBIND_PHONE_NUMBER", "getFEEDBACK_SOURCE_REBIND_PHONE_NUMBER", "FEEDBACK_SOURCE_PHONE_NUMBER_INACTIVE", "getFEEDBACK_SOURCE_PHONE_NUMBER_INACTIVE", "configLibraUrl", "getConfigLibraUrl", "configDeepLinkUrl", "getConfigDeepLinkUrl", "termsUrl", "getTermsUrl", "privacyUrl", "getPrivacyUrl", "privacyAccountUrl", "getPrivacyAccountUrl", "privacyAbsUrl", "getPrivacyAbsUrl", "memoryFaqUrl", "getMemoryFaqUrl", "legalFaqUrl", "getLegalFaqUrl", "faceMemoryPrivacyUrl", "getFaceMemoryPrivacyUrl", "privacyNewUrl", "getPrivacyNewUrl", "loggingDLPUrl", "getLoggingDLPUrl", "accountBanAppealUrl", "getAccountBanAppealUrl", "trustCenterUrl", "getTrustCenterUrl", "ONLINE_RTC_SERVER_MESSAGE_DOMAIN", "getONLINE_RTC_SERVER_MESSAGE_DOMAIN", "TEST_RTC_SERVER_MESSAGE_DOMAIN", "getTEST_RTC_SERVER_MESSAGE_DOMAIN", "secLink", "ALICE_BOE_HOST", "getALICE_BOE_HOST", "ACCOUNTT_BOE_HOST", "getACCOUNTT_BOE_HOST", "accountSettingUrl", "getAccountSettingUrl", "deviceManagementUrl", "getDeviceManagementUrl", "personUrl", "getPersonUrl", "denoisePrivacyUrl", "getDenoisePrivacyUrl", "accessibilitySdkDebugUrl", "getAccessibilitySdkDebugUrl", "doubaoOfficialWebsite", "getDoubaoOfficialWebsite", "toutiaoArticleUrl", "getToutiaoArticleUrl", "avatarOnboardingVideoModelString", "getAvatarOnboardingVideoModelString", "avatarOnboardingVideoCoverUrl", "getAvatarOnboardingVideoCoverUrl", "avatarTutorialAudioUrl", "getAvatarTutorialAudioUrl", "authorizationWhiteList", "", "getAuthorizationWhiteList", "()Ljava/util/List;", "authorizationPathWhiteList", "getAuthorizationPathWhiteList", "ecommerceQualificationRulesUrl", "getEcommerceQualificationRulesUrl", "shoppingPaymentFaqUrl", "getShoppingPaymentFaqUrl", "locallifePlatformQualificationUrl", "getLocallifePlatformQualificationUrl", "locallifeUserAgreementUrl", "getLocallifeUserAgreementUrl", "locallifePrivacyAgreementUrl", "getLocallifePrivacyAgreementUrl", "locallifeRuleCenterUrl", "getLocallifeRuleCenterUrl", "thirdAppSettingsUrl", "getThirdAppSettingsUrl", "BASE_LARK_HOST", "getBASE_LARK_HOST", "ENV_HEADER_EXCLUDED_HOSTS", "", "getENV_HEADER_EXCLUDED_HOSTS", "()Ljava/util/Set;", "GECKO_HOST", "getGECKO_HOST", "BYTEGECKO_HOST_SUFFIX", "getBYTEGECKO_HOST_SUFFIX", "MAIN_APP_HOST_SUFFIX", "getMAIN_APP_HOST_SUFFIX", "SAMI_BOE_HOST", "getSAMI_BOE_HOST", "BOE_WWW_HOST", "getBOE_WWW_HOST", "WSS_NORMAL_HOST", "getWSS_NORMAL_HOST", "WSS100_NORMAL_HOST", "getWSS100_NORMAL_HOST", "WSS_NORMAL_BOE_HOST", "getWSS_NORMAL_BOE_HOST", "WS_SAMANTHA_HOST", "getWS_SAMANTHA_HOST", "WS_SAMANTHA_BOE_HOST", "getWS_SAMANTHA_BOE_HOST", "ttnet_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IHttpConst {
    String A();

    String A0();

    String B();

    String B0();

    String C();

    String C0();

    String D();

    String D0();

    String E();

    List<String> F();

    String G();

    String H();

    String I();

    String J();

    String K();

    String L();

    String M();

    String N();

    String O();

    String P();

    String Q();

    String R();

    String S();

    String T();

    String U();

    String V();

    String W();

    String X();

    String Y();

    String Z();

    String a();

    List<String> a0();

    String b();

    String b0();

    String c();

    String c0();

    String d();

    String d0();

    String e();

    String e0();

    String f();

    String f0();

    String g();

    String g0();

    String h();

    String h0();

    String i();

    String i0();

    String j();

    String j0();

    String k();

    String k0();

    String l();

    String l0();

    String m();

    String m0();

    String n();

    String n0();

    String o();

    String o0();

    String p();

    String p0();

    String q();

    String q0();

    String r();

    String r0();

    String s();

    String s0();

    String t();

    String t0();

    String u();

    String u0();

    String v();

    String v0();

    String w();

    String w0();

    String x();

    String x0();

    String y();

    String y0();

    Set<String> z();

    String z0();
}
