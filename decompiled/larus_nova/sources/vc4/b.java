package vc4;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import com.alipay.sdk.m.p.e;
import com.alipay.sdk.m.x.d;
import com.android.ttcjpaysdk.base.adapter.ICJExternalEventCenterAdapter;
import com.android.ttcjpaysdk.base.adapter.ICJExternalLynxServiceAdapter;
import com.android.ttcjpaysdk.base.adapter.TTCJPayLoadingAdapter;
import com.android.ttcjpaysdk.base.adapter.TTCJPayNetworkErrorAdapter;
import com.android.ttcjpaysdk.base.adapter.TTCJPayToastAdapter;
import com.android.ttcjpaysdk.base.service.CJPayServiceManager;
import com.android.ttcjpaysdk.base.service.ICJPayBasisPaymentService;
import com.android.ttcjpaysdk.base.service.ICJPayIntegratedCounterService;
import com.android.ttcjpaysdk.base.service.ICJPayServiceRetCallBack;
import com.android.ttcjpaysdk.base.service.IPayLifecycle;
import com.android.ttcjpaysdk.base.service.ITTCJPayComponent;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.android.ttcjpaysdk.ttcjpayapi.IBasicMode;
import com.android.ttcjpaysdk.ttcjpayapi.IBlockDialog;
import com.android.ttcjpaysdk.ttcjpayapi.ICJHostLoginService;
import com.android.ttcjpaysdk.ttcjpayapi.ICJHostPrivacyService;
import com.android.ttcjpaysdk.ttcjpayapi.ICJPayXBridgeCallback;
import com.android.ttcjpaysdk.ttcjpayapi.ICustomActionListener;
import com.android.ttcjpaysdk.ttcjpayapi.ICustomerServiceCallback;
import com.android.ttcjpaysdk.ttcjpayapi.IH5NotificationCallback;
import com.android.ttcjpaysdk.ttcjpayapi.IH5PayCallback;
import com.android.ttcjpaysdk.ttcjpayapi.ITTCJPayPhoneCarrierService;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayAlipayAuthCallback;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayDoFaceLive;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayEvent;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayHostJSBMethodsInterface;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayMonitor;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayObserver;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayOpenSchemeInterface;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayOpenSchemeWithContextInterface;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayRealNameAuthCallback;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayRealNamePasswordCallback;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayUtilsInner;
import com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.open.SocialConstants;
import faceverify.w;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements ITTCJPayUtilsCompat {
    public b() {
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void openTestPage(Activity r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "schema");
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void bdPay() {
        TTCJPayUtilsInner.bdPay$default(TTCJPayUtilsInner.Companion.getInstance(), null, 1, null);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void closeSDK() {
        TTCJPayUtilsInner.Companion.getInstance().closeSDK();
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void doRefreshOnNetworkError() {
        TTCJPayUtilsInner.Companion.getInstance().doRefreshOnNetworkError();
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void execute() {
        TTCJPayUtilsInner.Companion.getInstance().execute();
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void executeWithdraw() {
        TTCJPayUtilsInner.Companion.getInstance().executeWithdraw();
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void fastPayHideLoading() {
        TTCJPayUtilsInner.Companion.getInstance().fastPayHideLoading();
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void fastPayOnlySendRequest() {
        TTCJPayUtilsInner.Companion.getInstance().fastPayOnlySendRequest();
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final String getBioType() {
        return TTCJPayUtilsInner.Companion.getInstance().getBioType();
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final Map<String, Class<? extends Object>> getCJPayXBridgeMethods() {
        return TTCJPayUtilsInner.Companion.getInstance().getCJPayXBridgeMethods();
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final String getJailBreak() {
        return TTCJPayUtilsInner.Companion.getInstance().getJailBreak();
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final String getSDKVersion() {
        return TTCJPayUtilsInner.Companion.getInstance().getSDKVersion();
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void init() {
        TTCJPayUtilsInner.Companion.getInstance().init();
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void initMini() {
        TTCJPayUtilsInner.Companion.getInstance().initMini();
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void preLoadFinanceRisk() {
        TTCJPayUtilsInner.Companion.getInstance().preLoadFinanceRisk();
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void preLoadYuefuTemplate() {
        TTCJPayUtilsInner.Companion.getInstance().preLoadYuefuTemplate();
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void recharge() {
        TTCJPayUtilsInner.Companion.getInstance().recharge();
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void registerCJPayXbridge() {
        TTCJPayUtilsInner.Companion.getInstance().registerCJPayXbridge();
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void releaseAll() {
        TTCJPayUtilsInner.Companion.getInstance().releaseAll();
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void releaseAllFromSubProcess() {
        TTCJPayUtilsInner.Companion.getInstance().releaseAllFromSubProcess();
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void sign() {
        TTCJPayUtilsInner.Companion.getInstance().sign();
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final JSONObject getCJPassThroughInfo() {
        return CJPayBasicUtils.getCJPassThroughInfo();
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void bdPayForImRedPacket(String r100) {
        TTCJPayUtilsInner.Companion.getInstance().bdPayForImRedPacket(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void fastPay(int r100) {
        TTCJPayUtilsInner.Companion.getInstance().fastPay(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void fastPayShowLoading(int r100) {
        TTCJPayUtilsInner.Companion.getInstance().fastPayShowLoading(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final int getAppVersionCode(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "applicationContext");
        return CJPayBasicUtils.getAppVersionCode(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final JSONObject getCJPayInfo(HashMap<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "sceneContext");
        return TTCJPayUtilsInner.Companion.getInstance().getCJPayInfo(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final ITTCJPayComponent getPayComponent(IPayLifecycle r100) {
        return TTCJPayUtilsInner.Companion.getInstance().getPayComponent(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final String getSettingsInfo(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return TTCJPayUtilsInner.Companion.getInstance().getSettingsInfo(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final boolean isCloudUnionPayInstalled(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return TTCJPayUtilsInner.Companion.getInstance().isCloudUnionPayInstalled(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void myBankCard(String r100) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        TTCJPayUtilsInner.Companion.getInstance().myBankCard(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void openH5ByScheme(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scheme");
        TTCJPayUtilsInner.Companion.getInstance().openH5ByScheme(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void openOCR(ICJPayServiceRetCallBack r100) {
        TTCJPayUtilsInner.Companion.getInstance().openOCR(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void setAid(String r100) {
        TTCJPayUtilsInner.Companion.getInstance().setAid(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void setAnimationResourceMap(Map<String, Integer> r100) {
        TTCJPayUtilsInner.Companion.getInstance().setAnimationResourceMap(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void setAppId(String r100) {
        TTCJPayUtilsInner.Companion.getInstance().setAppId(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void setAppUpdateVersion(String r100) {
        TTCJPayUtilsInner.Companion.getInstance().setAppUpdateVersion(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void setBackEnable(boolean r100) {
        TTCJPayUtilsInner.Companion.getInstance().setBackEnable(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void setBasicModeCallback(IBasicMode r100) {
        Intrinsics.checkNotNullParameter(r100, "basicModeCallback");
        TTCJPayUtilsInner.Companion.getInstance().setBasicModeCallback(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void setBlockDialog(IBlockDialog r100) {
        Intrinsics.checkNotNullParameter(r100, "blockDialog");
        TTCJPayUtilsInner.Companion.getInstance().setBlockDialog(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void setBoeEnv(String r100) {
        TTCJPayUtilsInner.Companion.getInstance().setBoeEnv(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void setContext(Context r100) {
        TTCJPayUtilsInner.Companion.getInstance().setContext(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void setCustomActionListener(ICustomActionListener r100) {
        TTCJPayUtilsInner.Companion.getInstance().setCustomActionListener(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void setCustomerServiceCallback(ICustomerServiceCallback r100) {
        Intrinsics.checkNotNullParameter(r100, "customerServiceCallback");
        TTCJPayUtilsInner.Companion.getInstance().setCustomerServiceCallback(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void setDid(String r100) {
        TTCJPayUtilsInner.Companion.getInstance().setDid(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void setEnvChannel(String r100) {
        TTCJPayUtilsInner.Companion.getInstance().setEnvChannel(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void setEvent(TTCJPayEvent r100) {
        TTCJPayUtilsInner.Companion.getInstance().setEvent(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void setExternalEventCenterAdapter(ICJExternalEventCenterAdapter r100) {
        TTCJPayUtilsInner.Companion.getInstance().setExternalEventCenterAdapter(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void setExternalLynxServiceAdapter(ICJExternalLynxServiceAdapter r100) {
        TTCJPayUtilsInner.Companion.getInstance().setExternalLynxServiceAdapter(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void setExtraHeaderMap(HashMap<String, String> r100) {
        TTCJPayUtilsInner.Companion.getInstance().setExtraHeaderMap(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void setFaceLive(TTCJPayDoFaceLive r100) {
        TTCJPayUtilsInner.Companion.getInstance().setFaceLive(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void setFollowSystemTheme(boolean r100) {
        TTCJPayUtilsInner.Companion.getInstance().setFollowSystemTheme(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void setFontScale(float r100) {
        TTCJPayUtilsInner.Companion.getInstance().setFontScale(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void setFromImRedPacket(boolean r100) {
        TTCJPayUtilsInner.Companion.getInstance().setFromImRedPacket(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void setGameNewCounterStyle(boolean r100) {
        TTCJPayUtilsInner.Companion.getInstance().setGameNewCounterStyle(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void setGameNewStyle(boolean r100) {
        TTCJPayUtilsInner.Companion.getInstance().setGameNewStyle(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void setH5NotificationCallback(IH5NotificationCallback r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        TTCJPayUtilsInner.Companion.getInstance().setH5NotificationCallback(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void setHostJSBMethodsInterface(TTCJPayHostJSBMethodsInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "hostJSBMethodsInterface");
        TTCJPayUtilsInner.Companion.getInstance().setHostJSBMethodsInterface(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void setHostLoginService(ICJHostLoginService r100) {
        Intrinsics.checkNotNullParameter(r100, "loginService");
        TTCJPayUtilsInner.Companion.getInstance().setHostLoginService(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void setHostPrivacyService(ICJHostPrivacyService r100) {
        Intrinsics.checkNotNullParameter(r100, "service");
        TTCJPayUtilsInner.Companion.getInstance().setHostPrivacyService(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void setInheritTheme(String r100) {
        TTCJPayUtilsInner.Companion.getInstance().setInheritTheme(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void setIntegratedHostDomain(String r100) {
        TTCJPayUtilsInner.Companion.getInstance().setIntegratedHostDomain(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void setIsTransCheckoutCounterActivityWhenLoading(boolean r100) {
        TTCJPayUtilsInner.Companion.getInstance().setIsTransCheckoutCounterActivityWhenLoading(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void setIsUsingGecko(boolean r100) {
        TTCJPayUtilsInner.Companion.getInstance().setIsUsingGecko(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void setIsUsingTTNet(boolean r100) {
        TTCJPayUtilsInner.Companion.getInstance().setIsUsingTTNet(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void setJSBridgeAuth(boolean r100) {
        TTCJPayUtilsInner.Companion.getInstance().setJSBridgeAuth(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void setLanguageTypeStr(String r100) {
        TTCJPayUtilsInner.Companion.getInstance().setLanguageTypeStr(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final <T> void setLoadingAdapter(TTCJPayLoadingAdapter<T> r100) {
        TTCJPayUtilsInner.Companion.getInstance().setLoadingAdapter(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void setLoginToken(Map<String, String> r100) {
        TTCJPayUtilsInner.Companion.getInstance().setLoginToken(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void setMerchantId(String r100) {
        TTCJPayUtilsInner.Companion.getInstance().setMerchantId(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void setMonitor(TTCJPayMonitor r100) {
        TTCJPayUtilsInner.Companion.getInstance().setMonitor(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void setNeedLoading(boolean r100) {
        TTCJPayUtilsInner.Companion.getInstance().setNeedLoading(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void setNetworkErrorAdapter(TTCJPayNetworkErrorAdapter r100) {
        TTCJPayUtilsInner.Companion.getInstance().setNetworkErrorAdapter(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void setNetworkInterceptor(Object r100) {
        TTCJPayUtilsInner.Companion.getInstance().setNetworkInterceptor(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void setObserver(TTCJPayObserver r100) {
        TTCJPayUtilsInner.Companion.getInstance().setObserver(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void setOpenSchemeCallback(TTCJPayOpenSchemeInterface r100) {
        TTCJPayUtilsInner.Companion.getInstance().setOpenSchemeCallback(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void setOpenSchemeWithContextCallback(TTCJPayOpenSchemeWithContextInterface r100) {
        TTCJPayUtilsInner.Companion.getInstance().setOpenSchemeWithContextCallback(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void setPhoneCarrierService(ITTCJPayPhoneCarrierService r100) {
        Intrinsics.checkNotNullParameter(r100, "phoneCarrierService");
        TTCJPayUtilsInner.Companion.getInstance().setPhoneCarrierService(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void setRequestParams(Map<String, String> r100) {
        TTCJPayUtilsInner.Companion.getInstance().setRequestParams(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void setRiskInfoParams(Map<String, String> r100) {
        TTCJPayUtilsInner.Companion.getInstance().setRiskInfoParams(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void setScreenOrientationType(int r100) {
        TTCJPayUtilsInner.Companion.getInstance().setScreenOrientationType(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void setServerType(int r100) {
        TTCJPayUtilsInner.Companion.getInstance().setServerType(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void setTitleBitmap(Bitmap r100) {
        Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
        TTCJPayUtilsInner.Companion.getInstance().setTitleBitmap(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void setTitleStr(String r100) {
        Intrinsics.checkNotNullParameter(r100, "titleStr");
        TTCJPayUtilsInner.Companion.getInstance().setTitleStr(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void setToastAdapter(TTCJPayToastAdapter r100) {
        TTCJPayUtilsInner.Companion.getInstance().setToastAdapter(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void setTrackInfo(JSONObject r100) {
        TTCJPayUtilsInner.Companion.getInstance().setTrackInfo(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void setUid(String r100) {
        TTCJPayUtilsInner.Companion.getInstance().setUid(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void setUnifyHideLoading(boolean r100) {
        TTCJPayUtilsInner.Companion.getInstance().setUnifyHideLoading(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void tradeManager(String r100) {
        Intrinsics.checkNotNullParameter(r100, "smchId");
        TTCJPayUtilsInner.Companion.getInstance().tradeManager(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void tradeRecord(String r100) {
        Intrinsics.checkNotNullParameter(r100, "smchId");
        TTCJPayUtilsInner.Companion.getInstance().tradeRecord(r100);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void openOCR(String r100, ICJPayServiceRetCallBack r101) {
        Intrinsics.checkNotNullParameter(r100, com.heytap.mcssdk.constant.b.f276366p);
        TTCJPayUtilsInner.Companion.getInstance().openOCR(r100, r101);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final String readString(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "defaultValue");
        return TTCJPayUtilsInner.Companion.getInstance().readString(r100, r101);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void storeString(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        TTCJPayUtilsInner.Companion.getInstance().storeString(r100, r101);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final boolean verifyScanResultSync(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "url");
        ICJPayIntegratedCounterService r102 = (ICJPayIntegratedCounterService) CJPayServiceManager.getInstance().getIService(ICJPayIntegratedCounterService.class);
        Boolean r103 = null;
        Activity r104 = null;
        if (r102 != null) goto L5;
    L8:
        if (r103 != null) goto L11;
        return false;
    L11:
        return r103.booleanValue();
    L5:
        if ((r100 instanceof Activity) == false) goto L7;
        r104 = (Activity) r100;
    L7:
        r103 = r102.verifyScanResultSync(r104, r101);
        goto L8
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void aliPay(Context r100, String r101, ICJPayBasisPaymentService.OnPayResultCallback r102) {
        TTCJPayUtilsInner.Companion.getInstance().aliPay(r100, r101, "", r102);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void cloudUnionPay(Context r100, String r101, ICJPayBasisPaymentService.OnPayResultCallback r102) {
        TTCJPayUtilsInner.Companion.getInstance().cloudUnionPay(r100, r101, "", r102);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void executeCloseAndCallback(Context r100, String r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, e.f25671s);
        Intrinsics.checkNotNullParameter(r102, "params");
        TTCJPayUtilsInner.Companion.getInstance().executeCloseAndCallback(r100, r101, r102);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final JSONObject getFinanceRiskWithScene(String r100, String r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "triggerAction");
        return TTCJPayUtilsInner.Companion.getInstance().getFinanceRiskWithScene(r100, r101, r102);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void openPayScoreWithParams(Context r100, JSONObject r101, ICJPayXBridgeCallback r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        TTCJPayUtilsInner.Companion.getInstance().openPayScoreWithParams(r100, r101, r102);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void outerBDPay(Context r110, String r111, wc4.a r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r112, "payCallback");
        TTCJPayUtilsInner.outerBDPay$default(TTCJPayUtilsInner.Companion.getInstance(), r110, r111, null, null, null, false, r112, 60, null);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void aliPay(Context r100, String r101, ICJPayBasisPaymentService.OnPayResultCallback r110, ICJPayBasisPaymentService.OnResultCallback r111) {
        TTCJPayUtilsInner.Companion.getInstance().aliPay(r100, r101, "", r110, r111);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void authAlipay(Activity r100, String r101, boolean r102, TTCJPayAlipayAuthCallback r103) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, w.META_COLL_KEY_AUTH_INFO);
        Intrinsics.checkNotNullParameter(r103, "callback");
        TTCJPayUtilsInner.Companion.getInstance().authAlipay(r100, r101, r102, r103);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void cloudUnionPay(Context r110, String r111, ICJPayBasisPaymentService.OnPayResultCallback r112, ICJPayBasisPaymentService.OnResultCallback r113) {
        TTCJPayUtilsInner.cloudUnionPay$default(TTCJPayUtilsInner.Companion.getInstance(), r110, r111, "", r112, r113, null, 32, null);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void executeAggregatePayment(int r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "tradeName");
        Intrinsics.checkNotNullParameter(r102, "appId");
        Intrinsics.checkNotNullParameter(r103, "merchantId");
        TTCJPayUtilsInner.Companion.getInstance().executeAggregatePayment(r100, r102, r101, r103);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void handleXBridgeMethod(Context r100, String r101, JSONObject r102, ICJPayXBridgeCallback r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, e.f25671s);
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r103, "callback");
        TTCJPayUtilsInner.Companion.getInstance().handleXBridgeMethod(r100, r101, r102, r103);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void routeSign(Context r100, Map<String, String> r101, Map<String, ? extends Object> r102, wc4.a r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, d.D);
        TTCJPayUtilsInner.Companion.getInstance().routeSign(r100, r101, r102, r103);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void wxPay(Context r100, String r101, String r102, ICJPayBasisPaymentService.OnPayResultCallback r103) {
        Intrinsics.checkNotNullParameter(r102, "wxPayType");
        TTCJPayUtilsInner.Companion.getInstance().wxPay(r100, r101, r102, r103);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void externalBizReport(String r100, String r110, long r111, String r112, JSONObject r113) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r110, "name");
        Intrinsics.checkNotNullParameter(r112, SocialConstants.PARAM_APP_DESC);
        TTCJPayUtilsInner.Companion.getInstance().externalBizReport(r100, r110, r111, r112, r113);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void openH5(String r100, String r101, String r110, String r111, String r112) {
        TTCJPayUtilsInner.Companion.getInstance().openH5(r100, r101, r110, r111, r112);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void openH5CashDesk(String r100, JSONObject r101, JSONObject r110, int r111, String r112) {
        TTCJPayUtilsInner.Companion.getInstance().openH5CashDesk(r100, r101, r110, r111, r112);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void openH5ModalView(String r100, int r101, boolean r110, String r111, int r112) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r111, "bgColor");
        TTCJPayUtilsInner.Companion.getInstance().openH5ModalView(r100, r101, r110, r111, r112);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void openRealNameAuth(Activity r100, String r101, String r110, String r111, TTCJPayRealNameAuthCallback r112) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "merchantId");
        Intrinsics.checkNotNullParameter(r110, "appId");
        Intrinsics.checkNotNullParameter(r111, "eventTrack");
        Intrinsics.checkNotNullParameter(r112, "callback");
        TTCJPayUtilsInner.Companion.getInstance().openRealNameAuth(r100, r101, r110, r111, r112);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void openRealNameSetPassword(Activity r100, String r101, String r110, String r111, TTCJPayRealNamePasswordCallback r112) {
        TTCJPayUtilsInner.Companion.getInstance().openRealNameSetPassword(r100, r101, r110, r111, r112);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void wxPay(Context r100, String r101, String r110, ICJPayBasisPaymentService.OnPayResultCallback r111, ICJPayBasisPaymentService.OnResultCallback r112) {
        Intrinsics.checkNotNullParameter(r110, "wxPayType");
        TTCJPayUtilsInner.Companion.getInstance().wxPay(r100, r101, r110, r111, r112);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void openH5ModalView(Context r100, String r110, int r111, boolean r112, String r113, int r114) {
        Intrinsics.checkNotNullParameter(r110, "url");
        Intrinsics.checkNotNullParameter(r113, "bgColor");
        TTCJPayUtilsInner.Companion.getInstance().openH5ModalView(r100, r110, r111, r112, r113, r114);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void pay(String r100, int r110, String r111, String r112, String r113, IH5PayCallback r114) {
        TTCJPayUtilsInner.Companion.getInstance().pay(r100, r110, r111, r112, r113, r114);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void payFromSubProcess(String r100, int r110, String r111, String r112, String r113, IH5PayCallback r114) {
        TTCJPayUtilsInner.Companion.getInstance().payFromSubProcess(r100, r110, r111, r112, r113, r114);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void openH5ModalView(Context r110, String r111, int r112, boolean r113, String r114, int r115, Uri r116) {
        Intrinsics.checkNotNullParameter(r111, "url");
        Intrinsics.checkNotNullParameter(r114, "bgColor");
        Intrinsics.checkNotNullParameter(r116, "uri");
        TTCJPayUtilsInner.Companion.getInstance().openH5ModalView(r110, r111, r112, r113, r114, r115, r116);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void openRealNameAuth(Activity r110, String r111, String r112, String r113, String r114, String r115, TTCJPayRealNameAuthCallback r116) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "merchantId");
        Intrinsics.checkNotNullParameter(r112, "appId");
        Intrinsics.checkNotNullParameter(r113, "eventTrack");
        Intrinsics.checkNotNullParameter(r114, "theme");
        Intrinsics.checkNotNullParameter(r115, "scene");
        Intrinsics.checkNotNullParameter(r116, "callback");
        TTCJPayUtilsInner.Companion.getInstance().openRealNameAuth(r110, r111, r112, r113, r114, r115, r116);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void outerBDPay(Context r110, String r111, Map<String, String> r112, String r113, String r114, boolean r115, wc4.a r116) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r116, "payCallback");
        TTCJPayUtilsInner.Companion.getInstance().outerBDPay(r110, r111, r112, r113, r114, r115, r116);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void pay(String r110, int r111, String r112, String r113, String r114, String r115, IH5PayCallback r116) {
        TTCJPayUtilsInner.Companion.getInstance().pay(r110, r111, r112, r113, r114, r115, r116);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void openRealNameAuth(Activity r110, String r111, String r112, String r113, String r114, String r115, String r116, TTCJPayRealNameAuthCallback r117) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "merchantId");
        Intrinsics.checkNotNullParameter(r112, "appId");
        Intrinsics.checkNotNullParameter(r113, "eventTrack");
        Intrinsics.checkNotNullParameter(r114, "theme");
        Intrinsics.checkNotNullParameter(r115, "scene");
        Intrinsics.checkNotNullParameter(r116, "style");
        Intrinsics.checkNotNullParameter(r117, "callback");
        TTCJPayUtilsInner.Companion.getInstance().openRealNameAuth(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    @Override // com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat
    public final void pay(String r110, int r111, String r112, String r113, String r114, String r115, Boolean r116, IH5PayCallback r117) {
        TTCJPayUtilsInner.Companion.getInstance().pay(r110, r111, r112, r113, r114, r115, r116, r117, null);
    }
}
