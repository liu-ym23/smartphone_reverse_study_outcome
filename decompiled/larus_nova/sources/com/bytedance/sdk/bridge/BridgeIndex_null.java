package com.bytedance.sdk.bridge;

import com.android.ttcjpaysdk.base.ui.dialog.CJPayLynxStandardKeepActivity;
import com.android.ttcjpaysdk.bdpay.counter.outer.bean.CJDyPayResult;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.sdk.bridge.annotation.BridgeSyncType;
import com.bytedance.sdk.bridge.model.IBridgeContext;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.open.SocialConstants;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public class BridgeIndex_null implements h {
    private static Map<String, Class<?>> sClassNameMap;
    private static Map<Class<?>, i> sSubscriberInfoMap;

    public BridgeIndex_null() {
    }

    static {
        sSubscriberInfoMap = new HashMap();
        sClassNameMap = new HashMap();
    }

    private void getSubscriberClassMap() {
        sClassNameMap.put("ttcjpay.preconnect", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.publishEvent", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.checkLivePlugin", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("pia.rendering.execute", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.setShareInfo", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.getMegaObject", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.deviceInfo", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.closeWebview", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.disallowCapture", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.CJModalView", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.goH5", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.setWebviewInfo", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.disableDragBack", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.backBlock", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.setVisible", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.closeCallback", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.pay", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.showLoading", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.hideLoading", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.openPage", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.isAppInstalled", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.checkAppInstalled", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.openAppByScheme", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.disableHistory", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.sendNotification", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.close", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.sendLog", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.abTest", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.request", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.callHostApp", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.notifyOrderResult", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.encrypt", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.decrypt", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.login", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.goSettings", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.payInfo", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.updatePayTypeInfo", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.requestWXH5Payment", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.supportFile", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.setTitle", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.authAlipay", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.showToast", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.goRecharge", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.goMyBankCard", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.switchBioPaymentState", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.bioPaymentShowState", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.prefetchData", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.ocr", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.sendMonitor", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.faceVerification", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.loginAPI", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.CJAuth", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.ttpay", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.getPhoneInfo", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.blockNativeBack", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.signAlipay", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.facepp", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.sendPageStatus", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.sendDeviceInfo", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.setDeviceInfo", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.downloadFile", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.chooseMedia", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.uploadMedia", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.alog", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.getH5InitTime", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.vipInfo", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.getAppInfo", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.dypay", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.saveImgToAlbum", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.copyToClipboard", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.faceVerifyFullPage", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.ai", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.dnsPrefetch", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.performanceTracker", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.ccmGetEntryInfo", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.dyVerify", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("createBtmChain", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("registerBtmPage", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.operateCert", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.certPluginPreload", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.iDaaSAuth", of4.a.class);     // Catch: Exception -> L4
        sClassNameMap.put("ttcjpay.voiceVerify", of4.a.class);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public void putSubscriberInfoMap(Class<?> r410) {
        if (r410.equals(of4.a.class) == false) goto L11;
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("preConnect", new Class[]{IBridgeContext.class, String.class}), "ttcjpay.preconnect", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(String.class, "urls", "", false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("publishEvent", new Class[]{IBridgeContext.class, String.class, String.class, String.class}), "ttcjpay.publishEvent", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(String.class, ReportCardMonitorPlugin.EVENT_NAME, "", false), new d(String.class, "params", "", false), new d(String.class, "timestamp", "", false)});     // Catch: NoSuchMethodException -> L6
        Class r110 = Boolean.TYPE;     // Catch: NoSuchMethodException -> L6
        Method r210 = of4.a.class.getDeclaredMethod("checkLivePlugin", new Class[]{IBridgeContext.class, r110, r110});     // Catch: NoSuchMethodException -> L6
        Boolean r111 = Boolean.FALSE;     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, r210, "ttcjpay.checkLivePlugin", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(r110, "is_install_background", r111, false), new d(r110, "is_only_check", r111, false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("piaMethod", new Class[]{IBridgeContext.class, String.class, JSONObject.class}), "pia.rendering.execute", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(String.class, "url", "", false), new d(JSONObject.class, PerfLog.PARAM_KEY_CONTEXT_ID, null, false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("setShareInfo", new Class[]{IBridgeContext.class, String.class, String.class, String.class, String.class, String.class}), "ttcjpay.setShareInfo", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(String.class, "platform", "share_native", false), new d(String.class, "title", "", false), new d(String.class, SocialConstants.PARAM_APP_DESC, "", false), new d(String.class, "image", "", false), new d(String.class, "url", "", false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("getMegaObject", new Class[]{IBridgeContext.class, String.class}), "ttcjpay.getMegaObject", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(String.class, "id", "", false)});     // Catch: NoSuchMethodException -> L6
        Class r112 = Integer.TYPE;     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("deviceInfo", new Class[]{IBridgeContext.class, r112}), "ttcjpay.deviceInfo", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(r112, "type", 0, false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("closeWebView", new Class[]{IBridgeContext.class, String.class}), "ttcjpay.closeWebview", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(String.class, "id", "", false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("disallowCapture", new Class[]{IBridgeContext.class, r112}), "ttcjpay.disallowCapture", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(r112, "disallow", 0, false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("openModalView", new Class[]{IBridgeContext.class, String.class, r112, r112, String.class, r112}), "ttcjpay.CJModalView", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(String.class, "url", "", false), new d(r112, "enable_animation", 0, false), new d(r112, "fullpage", 0, false), new d(String.class, "background_color", "", false), new d(r112, "show_loading", 0, false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("openH5", new Class[]{IBridgeContext.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, r112, String.class, String.class}), "ttcjpay.goH5", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(String.class, "title", "", false), new d(String.class, "url", "", false), new d(String.class, "hide_status_bar", "", false), new d(String.class, "background_color", "", false), new d(String.class, "status_bar_text_style", "", false), new d(String.class, "back_button_color", "", false), new d(String.class, "back_button_icon", "", false), new d(String.class, "title_text_color", "", false), new d(String.class, "title_bar_bg_color", "", false), new d(String.class, "hide_title_bar", "", false), new d(String.class, "canvas_mode", "", false), new d(r112, "show_loading", 0, false), new d(String.class, "enable_font_scale", "", false), new d(String.class, "is_caijing_saas", "", false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("setWebViewInfo", new Class[]{IBridgeContext.class, String.class}), "ttcjpay.setWebviewInfo", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(String.class, "id", "", false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("switchDragBack", new Class[]{IBridgeContext.class, r112}), "ttcjpay.disableDragBack", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(r112, "disable", 0, false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("executeBackBlock", new Class[]{IBridgeContext.class, String.class, String.class, r112, String.class, String.class, String.class}), "ttcjpay.backBlock", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(String.class, "title", "", false), new d(String.class, PerfLog.PARAM_KEY_CONTEXT_ID, "", false), new d(r112, "policy", 0, false), new d(String.class, "confirm", "", false), new d(String.class, "cancel", "", false), new d(String.class, "enable_animation", "", false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("notifyWebViewVisibility", new Class[]{IBridgeContext.class}), "ttcjpay.setVisible", "protected", BridgeSyncType.ASYNC, new d[]{new d()});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("executeCloseAndCallback", new Class[]{IBridgeContext.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class}), "ttcjpay.closeCallback", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(String.class, "service", "", false), new d(String.class, "code", "", false), new d(String.class, "data", "", false), new d(String.class, "amount", "", false), new d(String.class, "success_desc", "", false), new d(String.class, "fail_desc", "", false), new d(String.class, CJPayLynxStandardKeepActivity.INTENT_CALLBACK_ID, "", false), new d(String.class, "ext", "", false), new d(String.class, "style", "", false), new d(String.class, "pay_token", "", false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("executePay", new Class[]{IBridgeContext.class, String.class}), "ttcjpay.pay", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(String.class, "data", "", false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod(DyPayConstant.KEY_SHOW_LOADING, new Class[]{IBridgeContext.class}), "ttcjpay.showLoading", "protected", BridgeSyncType.ASYNC, new d[]{new d()});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("hideLoading", new Class[]{IBridgeContext.class}), "ttcjpay.hideLoading", "protected", BridgeSyncType.ASYNC, new d[]{new d()});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod(SendEventContainerMethodParamModel.EventKinds.openPage, new Class[]{IBridgeContext.class, String.class, String.class}), "ttcjpay.openPage", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(String.class, "goto_type", "", false), new d(String.class, "url", "", false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("getAppIsInstalled", new Class[]{IBridgeContext.class, String.class}), "ttcjpay.isAppInstalled", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(String.class, "open_url", "", false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("checkAppInstalled", new Class[]{IBridgeContext.class, String.class}), "ttcjpay.checkAppInstalled", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(String.class, "open_url", "", false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("openAppByScheme", new Class[]{IBridgeContext.class, String.class}), "ttcjpay.openAppByScheme", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(String.class, "app_scheme", "", false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("setDisableHistory", new Class[]{IBridgeContext.class}), "ttcjpay.disableHistory", "protected", BridgeSyncType.ASYNC, new d[]{new d()});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("executeSendNotification", new Class[]{IBridgeContext.class, String.class, String.class}), "ttcjpay.sendNotification", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(String.class, "data", "", false), new d(String.class, "type", "", false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("closeCurrentActivity", new Class[]{IBridgeContext.class, r112}), "ttcjpay.close", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(r112, "disable_animation", 0, false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("sendLog", new Class[]{IBridgeContext.class, String.class, String.class}), "ttcjpay.sendLog", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(String.class, "event", "", false), new d(String.class, "params", "", false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("getABTest", new Class[]{IBridgeContext.class, String.class, String.class}), "ttcjpay.abTest", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(String.class, "ab_setting_key", "", false), new d(String.class, "isExposure", "", false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("request", new Class[]{IBridgeContext.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class}), "ttcjpay.request", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(String.class, "url", "", false), new d(String.class, com.alipay.sdk.m.p.e.f25671s, "", false), new d(String.class, "dataType", "", false), new d(String.class, "params", "", false), new d(String.class, "header", "", false), new d(String.class, "need_cj_jsb_timestamp", "", false), new d(String.class, "cj_jsb_fe_invoke_timestamp", "", false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("callHostApp", new Class[]{IBridgeContext.class, String.class, String.class}), "ttcjpay.callHostApp", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(String.class, com.alipay.sdk.m.p.e.f25671s, "", false), new d(String.class, "data", "", false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("notifyOrderResult", new Class[]{IBridgeContext.class, String.class, String.class, String.class, String.class, String.class}), "ttcjpay.notifyOrderResult", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(String.class, "service", "", false), new d(String.class, "data", "", false), new d(String.class, "response", "", false), new d(String.class, "sign", "", false), new d(String.class, "sign_type", "", false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("executeEncrypt", new Class[]{IBridgeContext.class, String.class, String.class, String.class}), "ttcjpay.encrypt", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(String.class, "data", "", false), new d(String.class, "public_key", "", false), new d(String.class, "isec_key", "", false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("executeDecrypt", new Class[]{IBridgeContext.class, String.class}), "ttcjpay.decrypt", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(String.class, "data", "", false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("loginFailure", new Class[]{IBridgeContext.class}), "ttcjpay.login", "protected", BridgeSyncType.ASYNC, new d[]{new d()});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("goSettings", new Class[]{IBridgeContext.class}), "ttcjpay.goSettings", "protected", BridgeSyncType.ASYNC, new d[]{new d()});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("payInfo", new Class[]{IBridgeContext.class}), "ttcjpay.payInfo", "protected", BridgeSyncType.ASYNC, new d[]{new d()});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("updatePayTypeInfo", new Class[]{IBridgeContext.class, String.class, String.class, String.class, String.class}), "ttcjpay.updatePayTypeInfo", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(String.class, "default_pay_channel", "", false), new d(String.class, "pay_channels", "", false), new d(String.class, "app_id", "", false), new d(String.class, "merchant_id", "", false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("requestWXH5Payment", new Class[]{IBridgeContext.class, String.class, String.class}), "ttcjpay.requestWXH5Payment", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(String.class, "url", "", false), new d(String.class, AppConstants.BUNDLE_REFERER, "", false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("supportFile", new Class[]{IBridgeContext.class}), "ttcjpay.supportFile", "protected", BridgeSyncType.ASYNC, new d[]{new d()});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("setWebViewText", new Class[]{IBridgeContext.class, String.class, String.class}), "ttcjpay.setTitle", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(String.class, "title", "", false), new d(String.class, "subTitle", "", false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("authAlipay", new Class[]{IBridgeContext.class, String.class}), "ttcjpay.authAlipay", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(String.class, "infoStr", "", false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("showToast", new Class[]{IBridgeContext.class, String.class}), "ttcjpay.showToast", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(String.class, "message", "", false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("goRecharge", new Class[]{IBridgeContext.class, String.class}), "ttcjpay.goRecharge", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(String.class, "params", "", false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("goMyBankCard", new Class[]{IBridgeContext.class, String.class}), "ttcjpay.goMyBankCard", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(String.class, "params", "", false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("switchBioPaymentState", new Class[]{IBridgeContext.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class}), "ttcjpay.switchBioPaymentState", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(String.class, "appId", "", false), new d(String.class, "signType", "", false), new d(String.class, "sign", "", false), new d(String.class, "uid", "", false), new d(String.class, "merchantId", "", false), new d(String.class, com.bytedance.android.ec.core.event.a.KEY_DID, "", false), new d(String.class, "timestamp", "", false), new d(String.class, "open", "", false), new d(String.class, "member_biz_order_no", "", false), new d(String.class, "verify_type", "", false), new d(String.class, "verify_info", "", false), new d(String.class, "is_caijing_saas", "", false), new d(String.class, "source", "", false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("bioPaymentShowState", new Class[]{IBridgeContext.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, r110}), "ttcjpay.bioPaymentShowState", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(String.class, "appId", "", false), new d(String.class, "signType", "", false), new d(String.class, "sign", "", false), new d(String.class, "uid", "", false), new d(String.class, "merchantId", "", false), new d(String.class, com.bytedance.android.ec.core.event.a.KEY_DID, "", false), new d(String.class, "timestamp", "", false), new d(String.class, "is_caijing_saas", "", false), new d(r110, "onlyReturnDeviceType", r111, false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("prefetchData", new Class[]{IBridgeContext.class, String.class}), "ttcjpay.prefetchData", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(String.class, "path", "", false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("doOCR", new Class[]{IBridgeContext.class, String.class, String.class, String.class, String.class, r112, String.class, String.class, String.class, String.class, String.class, String.class}), "ttcjpay.ocr", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(String.class, "type", "", false), new d(String.class, "merchant_id", "", false), new d(String.class, "app_id", "", false), new d(String.class, com.heytap.mcssdk.constant.b.f276366p, "", false), new d(r112, "compress_size", 0, false), new d(String.class, "track_base_param", "", false), new d(String.class, "frontUploadInteface", "", false), new d(String.class, "backUploadInteface", "", false), new d(String.class, "publicKey", "", false), new d(String.class, "is_caijing_saas", "", false), new d(String.class, "params", "", false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("sendMonitor", new Class[]{IBridgeContext.class, String.class, String.class, String.class, String.class}), "ttcjpay.sendMonitor", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(String.class, "event", "", false), new d(String.class, "params", "", false), new d(String.class, "category", "", false), new d(String.class, "metric", "", false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("faceVerification", new Class[]{IBridgeContext.class, String.class, String.class, String.class, String.class, String.class}), "ttcjpay.faceVerification", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(String.class, "scene", "", false), new d(String.class, "ticket", "", false), new d(String.class, "mode", "", false), new d(String.class, "cert_app_id", "", false), new d(String.class, "eventParams", "", false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("loginAPI", new Class[]{IBridgeContext.class, String.class, String.class, String.class, String.class, String.class, String.class}), "ttcjpay.loginAPI", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(String.class, "merchant_id", "", false), new d(String.class, "app_id", "", false), new d(String.class, "tagAid", "", false), new d(String.class, "loginMode", "", false), new d(String.class, "loginExt", "", false), new d(String.class, "track_base_params", "", false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("authRealName", new Class[]{IBridgeContext.class, String.class, String.class, String.class, String.class, String.class, String.class}), "ttcjpay.CJAuth", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(String.class, "app_id", "", false), new d(String.class, "merchant_id", "", false), new d(String.class, "log_data", "", false), new d(String.class, "theme", "", false), new d(String.class, "scene", "", false), new d(String.class, "style", "", false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("pay", new Class[]{IBridgeContext.class, String.class, String.class, r112, String.class, String.class}), "ttcjpay.ttpay", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(String.class, "sdk_info", "", false), new d(String.class, "ext", "", false), new d(r112, "service", 0, false), new d(String.class, "sub_way", "", false), new d(String.class, AppConstants.BUNDLE_REFERER, "", false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("getPhoneInfo", new Class[]{IBridgeContext.class, String.class}), "ttcjpay.getPhoneInfo", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(String.class, ReportConstant.COMMON_ACTION_TYPE, "", false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("blockNativeBack", new Class[]{IBridgeContext.class}), "ttcjpay.blockNativeBack", "protected", BridgeSyncType.ASYNC, new d[]{new d()});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("signAliPay", new Class[]{IBridgeContext.class, String.class}), "ttcjpay.signAlipay", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(String.class, "sign_params", "", false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("doFaceWithKS", new Class[]{IBridgeContext.class, String.class, String.class}), "ttcjpay.facepp", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(String.class, "url", "", false), new d(String.class, CJDyPayResult.EXT_K_RETURN_URL, "", false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("sendPageStatus", new Class[]{IBridgeContext.class, r112, String.class, String.class}), "ttcjpay.sendPageStatus", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(r112, "code", 0, false), new d(String.class, "url", "", false), new d(String.class, LocationMonitorConst.ERR_MSG, "", false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("sendDeviceInfo", new Class[]{IBridgeContext.class, String.class}), "ttcjpay.sendDeviceInfo", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(String.class, "scene", "", false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("setDeviceInfo", new Class[]{IBridgeContext.class, r112, String.class}), "ttcjpay.setDeviceInfo", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(r112, "page", 0, false), new d(String.class, "action", "", false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("downloadPdfFile", new Class[]{IBridgeContext.class, String.class, String.class}), "ttcjpay.downloadFile", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(String.class, "download_url", "", false), new d(String.class, "file_name", "", false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("chooseMedia", new Class[]{IBridgeContext.class, String.class, String.class, r112, String.class, r112}), "ttcjpay.chooseMedia", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(String.class, "camera_type", "", false), new d(String.class, "source_type", "", false), new d(r112, "compress_size", 0, false), new d(String.class, "save_to_dcim", "", false), new d(r112, "maxCount", 0, false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("uploadMedia", new Class[]{IBridgeContext.class, String.class, String.class, String.class, String.class, String.class, r112, String.class, String.class}), "ttcjpay.uploadMedia", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(String.class, "file_path", "", false), new d(String.class, "header", "", false), new d(String.class, "params", "", false), new d(String.class, "public_key", "", false), new d(String.class, "isec_key", "", false), new d(r112, "compress_limit", 0, false), new d(String.class, "url", "", false), new d(String.class, "is_caijing_saas", "", false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod(CloudControlInf.ALOG, new Class[]{IBridgeContext.class, String.class, String.class, String.class}), "ttcjpay.alog", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(String.class, "level", "", false), new d(String.class, "tag", "", false), new d(String.class, "log", "", false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("getH5InitTime", new Class[]{IBridgeContext.class}), "ttcjpay.getH5InitTime", "protected", BridgeSyncType.ASYNC, new d[]{new d()});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("getVipInfo", new Class[]{IBridgeContext.class}), "ttcjpay.vipInfo", "protected", BridgeSyncType.ASYNC, new d[]{new d()});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("getAppInfo", new Class[]{IBridgeContext.class}), "ttcjpay.getAppInfo", "protected", BridgeSyncType.ASYNC, new d[]{new d()});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("dypay", new Class[]{IBridgeContext.class, String.class}), "ttcjpay.dypay", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(String.class, "sdk_info", "", false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("saveImgToAlbum", new Class[]{IBridgeContext.class, String.class, String.class}), "ttcjpay.saveImgToAlbum", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(String.class, "dataURL", "", false), new d(String.class, "extension", "", false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("copyToClipboard", new Class[]{IBridgeContext.class, String.class}), "ttcjpay.copyToClipboard", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(String.class, "text", "", false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("copyToClipboard", new Class[]{IBridgeContext.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class}), "ttcjpay.faceVerifyFullPage", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(String.class, "app_id", "", false), new d(String.class, "merchant_id", "", false), new d(String.class, "order_id", "", false), new d(String.class, "server_source", "", false), new d(String.class, "risk_source", "", false), new d(String.class, "live_route", "", false), new d(String.class, "is_signed", "", false), new d(String.class, "configuration_params", "", false), new d(String.class, "ext_params", "", false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("cjAi", new Class[]{IBridgeContext.class, String.class, JSONObject.class}), "ttcjpay.ai", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(String.class, "biz", "", false), new d(JSONObject.class, "params", null, false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("dnsPrefetch", new Class[]{IBridgeContext.class, String.class}), "ttcjpay.dnsPrefetch", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(String.class, "host", "", false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("performanceTracker", new Class[]{IBridgeContext.class, String.class}), "ttcjpay.performanceTracker", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(String.class, "event_list", "", false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("ccmGetEntryInfo", new Class[]{IBridgeContext.class}), "ttcjpay.ccmGetEntryInfo", "protected", BridgeSyncType.ASYNC, new d[]{new d()});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("dyVerify", new Class[]{IBridgeContext.class, String.class, String.class}), "ttcjpay.dyVerify", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(String.class, "verify_id", "", false), new d(String.class, "verify_token", "", false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("createBtmChain", new Class[]{IBridgeContext.class, String.class, r110}), "createBtmChain", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(String.class, "btm", "", false), new d(r110, "enter_new_page", r111, false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("registerBtmPage", new Class[]{IBridgeContext.class, String.class}), "registerBtmPage", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(String.class, "btm", "", false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("operateCert", new Class[]{IBridgeContext.class, String.class, JSONObject.class}), "ttcjpay.operateCert", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(String.class, "action_type", "", false), new d(JSONObject.class, "action_params", null, false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("certPluginPreload", new Class[]{IBridgeContext.class, String.class, Boolean.class, String.class}), "ttcjpay.certPluginPreload", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(String.class, "risk_source", "", false), new d(Boolean.class, "silent_install", null, false), new d(String.class, "merchant_id", "", false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("iDaaSAuth", new Class[]{IBridgeContext.class, String.class, String.class, Boolean.class, Long.class}), "ttcjpay.iDaaSAuth", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(String.class, "cmccAppId", "", false), new d(String.class, "cmccParams", "", false), new d(Boolean.class, "needLoading", null, false), new d(Long.class, "overTime", null, false)});     // Catch: NoSuchMethodException -> L6
        putSubscriberInfo(of4.a.class, of4.a.class.getDeclaredMethod("voiceVerify", new Class[]{IBridgeContext.class, String.class, String.class, String.class, String.class, String.class, r112, Boolean.class, JSONObject.class}), "ttcjpay.voiceVerify", "protected", BridgeSyncType.ASYNC, new d[]{new d(), new d(String.class, "merchantId", "", false), new d(String.class, "appId", "", false), new d(String.class, "verifyType", "", false), new d(String.class, "memberBizOrderNo", "", false), new d(String.class, "voiceText", "", false), new d(r112, "verifyGroupNum", 0, false), new d(Boolean.class, "useDenoise", null, false), new d(JSONObject.class, "extParams", null, false)});     // Catch: NoSuchMethodException -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        sSubscriberInfoMap.remove(of4.a.class);
        return;
    }

    @Override // com.bytedance.sdk.bridge.h
    public void getSubscriberClassMap(Map<String, Class<?>> r100) {
        getSubscriberClassMap();
        r100.putAll(sClassNameMap);
    }

    @Override // com.bytedance.sdk.bridge.h
    public void getSubscriberInfoMap(Map<Class<?>, i> r100, String r101) {
        if (sClassNameMap.isEmpty() == false) goto L6;
        getSubscriberClassMap();
    L6:
        if (sClassNameMap.containsKey(r101) == false) goto L8;
        putSubscriberInfoMap(sClassNameMap.get(r101));
    L8:
        r100.putAll(sSubscriberInfoMap);
    }

    private static void putSubscriberInfo(Class<?> r100, Method r101, String r102, String r110, String r111, d[] r112) {
        r101.setAccessible(true);
        if (sSubscriberInfoMap.containsKey(r100) == false) goto L5;
        i r103 = sSubscriberInfoMap.get(r100);
    L6:
        r103.b(r102, new BridgeMethodInfo(r101, r102, r110, r111, r112));
        return;
    L5:
        i r104 = new i();
        sSubscriberInfoMap.put(r100, r104);
        r103 = r104;
        goto L6
    }
}
