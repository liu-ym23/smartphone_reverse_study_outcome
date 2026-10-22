package com.bytedance.android.shopping.buynow.viewmodel;

import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.bytedance.android.ec.core.buynow.BuyNowPerformanceOpt;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.shopping.api.ultimate.UltimateBuyParams;
import com.bytedance.android.shopping.buynow.controller.s;
import com.bytedance.android.shopping.buynow.data.model.CheckPointType;
import com.bytedance.android.shopping.buynow.data.model.CheckStatus;
import com.bytedance.android.shopping.buynow.tracker.BuyNowLog;
import com.bytedance.android.shopping.sku.common.ability.SkuAbilityType;
import com.bytedance.android.shopping.sku.common.ability.SkuCommonAbility;
import com.bytedance.jedi.arch.JediViewModel;
import com.bytedance.jedi.arch.State;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.kmp.ec.yata.common.protocol.data.c;
import com.bytedance.kmp.ec.yata.event.common.e;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;
import ul.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t¢\u0006\u0006\b¬\u0001\u0010\u00ad\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0018\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\nJ\u0006\u0010\u000e\u001a\u00020\bJ\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0012\u001a\u00020\u000fJ)\u0010\u0016\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00062\u0010\u0010\u0015\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u001a\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018J\u0018\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\nJG\u0010%\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010 \u001a\u0004\u0018\u00010\n2\b\u0010\"\u001a\u0004\u0018\u00010!2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#¢\u0006\u0004\b%\u0010&J\b\u0010'\u001a\u00020\bH\u0014R\u0017\u0010)\u001a\u00020(8\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0017\u0010.\u001a\u00020-8\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0017\u00103\u001a\u0002028\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u0017\u00108\u001a\u0002078\u0006¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R*\u0010>\u001a\n\u0018\u00010<j\u0004\u0018\u0001`=8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\"\u0010D\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bD\u0010F\"\u0004\bG\u0010HR\"\u0010I\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\"\u0010O\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR$\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010U\u001a\u0004\b\u0013\u0010V\"\u0004\bW\u0010XR,\u0010\u0015\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u0016\u0010^\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010PR$\u0010_\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\"\u0010e\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\be\u0010P\u001a\u0004\bf\u0010R\"\u0004\bg\u0010TR(\u0010i\u001a\b\u0012\u0004\u0012\u00020\n0h8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bi\u0010j\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\"\u0010o\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bo\u0010E\u001a\u0004\bp\u0010F\"\u0004\bq\u0010HR$\u0010r\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\br\u0010P\u001a\u0004\bs\u0010R\"\u0004\bt\u0010TR$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010u\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR\"\u0010z\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bz\u0010E\u001a\u0004\bz\u0010F\"\u0004\b{\u0010HR%\u0010}\u001a\u00020|8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0004\b}\u0010~\u001a\u0005\b\u007f\u0010\u0080\u0001\"\u0006\b\u0081\u0001\u0010\u0082\u0001R&\u0010 \u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b \u0010P\u001a\u0005\b\u0083\u0001\u0010R\"\u0005\b\u0084\u0001\u0010TR\u0018\u0010\u0085\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0085\u0001\u0010JR&\u0010\u0086\u0001\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0086\u0001\u0010E\u001a\u0005\b\u0087\u0001\u0010F\"\u0005\b\u0088\u0001\u0010HR,\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u0089\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u008a\u0001\u0010\u008b\u0001\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001\"\u0006\b\u008e\u0001\u0010\u008f\u0001R*\u0010\u0091\u0001\u001a\u00030\u0090\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0091\u0001\u0010\u0092\u0001\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001\"\u0006\b\u0095\u0001\u0010\u0096\u0001R&\u0010\u0097\u0001\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0097\u0001\u0010E\u001a\u0005\b\u0098\u0001\u0010F\"\u0005\b\u0099\u0001\u0010HR\u001a\u0010\u009a\u0001\u001a\u00020\n8\u0006¢\u0006\u000e\n\u0005\b\u009a\u0001\u0010P\u001a\u0005\b\u009b\u0001\u0010RR&\u0010\u009c\u0001\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u009c\u0001\u0010E\u001a\u0005\b\u009d\u0001\u0010F\"\u0005\b\u009e\u0001\u0010HR\u001d\u0010 \u0001\u001a\u00030\u009f\u00018\u0006¢\u0006\u0010\n\u0006\b \u0001\u0010¡\u0001\u001a\u0006\b¢\u0001\u0010£\u0001R)\u0010¤\u0001\u001a\u00020!8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¤\u0001\u0010¥\u0001\u001a\u0006\b¦\u0001\u0010§\u0001\"\u0006\b¨\u0001\u0010©\u0001R&\u0010ª\u0001\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bª\u0001\u0010E\u001a\u0005\bª\u0001\u0010F\"\u0005\b«\u0001\u0010H¨\u0006®\u0001"}, d2 = {"Lcom/bytedance/android/shopping/buynow/viewmodel/BuyNowViewModel;", "Lcom/bytedance/jedi/arch/JediViewModel;", "Lcom/bytedance/android/shopping/buynow/viewmodel/BuyNowState;", "defaultState", "Lcom/bytedance/kmp/ec/yata/common/protocol/data/c;", "yataData", "", "isQuery", "", "updateTrackerCommonParams", "", "status", "updateCheckStatus", "getCheckStatus", "handleAsyncEvent", "Lorg/json/JSONObject;", "param", "saveAsyncEventParam", "getAsyncEventparam", "isNoPwdCombined", "", "sdkInfo", "setCreateOrderLoadingData", "(Ljava/lang/Boolean;Ljava/util/Map;)V", "Lcom/bytedance/android/shopping/buynow/eventcenter/handle/a;", "checkParams", "setCurCheckParams", "triggerOrigin", "trackRequestStartCheckPoint", "success", "Lma3/b;", "response", "editOperatorType", "", "httpExceptionStatusCode", "", "throwable", "trackRequestEndCheckPoint", "(ZZLma3/b;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Throwable;)V", "onCleared", "Lcom/bytedance/android/shopping/buynow/viewmodel/a;", "staticState", "Lcom/bytedance/android/shopping/buynow/viewmodel/a;", "getStaticState", "()Lcom/bytedance/android/shopping/buynow/viewmodel/a;", "Lul/f;", "skuPageState", "Lul/f;", "getSkuPageState", "()Lul/f;", "Lcom/bytedance/android/shopping/buynow/tracker/a;", "tracker", "Lcom/bytedance/android/shopping/buynow/tracker/a;", "getTracker", "()Lcom/bytedance/android/shopping/buynow/tracker/a;", "Lcom/bytedance/android/shopping/sku/common/ability/b;", "skuService", "Lcom/bytedance/android/shopping/sku/common/ability/b;", "getSkuService", "()Lcom/bytedance/android/shopping/sku/common/ability/b;", "Lcom/bytedance/kmp/ec/yata/AndroidYaTaInstance;", "Lcom/bytedance/kmp/ec/yata/YaTaInstance;", "yataInstance", "Lcom/bytedance/kmp/ec/yata/AndroidYaTaInstance;", "getYataInstance", "()Lcom/bytedance/kmp/ec/yata/AndroidYaTaInstance;", "setYataInstance", "(Lcom/bytedance/kmp/ec/yata/AndroidYaTaInstance;)V", "isResumed", "Z", "()Z", "setResumed", "(Z)V", "addOnParams", "Lorg/json/JSONObject;", "getAddOnParams", "()Lorg/json/JSONObject;", "setAddOnParams", "(Lorg/json/JSONObject;)V", "addOnType", "Ljava/lang/String;", "getAddOnType", "()Ljava/lang/String;", "setAddOnType", "(Ljava/lang/String;)V", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "setNoPwdCombined", "(Ljava/lang/Boolean;)V", "Ljava/util/Map;", "getSdkInfo", "()Ljava/util/Map;", "setSdkInfo", "(Ljava/util/Map;)V", "curCheckStatus", "availability", "Ljava/lang/Integer;", "getAvailability", "()Ljava/lang/Integer;", "setAvailability", "(Ljava/lang/Integer;)V", "pageStartupStatus", "getPageStartupStatus", "setPageStartupStatus", "Ljava/util/Stack;", "currentShownPopupCodes", "Ljava/util/Stack;", "getCurrentShownPopupCodes", "()Ljava/util/Stack;", "setCurrentShownPopupCodes", "(Ljava/util/Stack;)V", "needToast", "getNeedToast", "setNeedToast", "failMsg", "getFailMsg", "setFailMsg", "Lcom/bytedance/android/shopping/buynow/eventcenter/handle/a;", "getCheckParams", "()Lcom/bytedance/android/shopping/buynow/eventcenter/handle/a;", "setCheckParams", "(Lcom/bytedance/android/shopping/buynow/eventcenter/handle/a;)V", "isPageLoading", "setPageLoading", "", "editStartTime", "J", "getEditStartTime", "()J", "setEditStartTime", "(J)V", "getEditOperatorType", "setEditOperatorType", "asyncTradeEventParam", "submitStatusFlag", "getSubmitStatusFlag", "setSubmitStatusFlag", "Lcom/bytedance/android/shopping/api/ultimate/UltimateBuyParams;", "ultimateBuyParams", "Lcom/bytedance/android/shopping/api/ultimate/UltimateBuyParams;", "getUltimateBuyParams", "()Lcom/bytedance/android/shopping/api/ultimate/UltimateBuyParams;", "setUltimateBuyParams", "(Lcom/bytedance/android/shopping/api/ultimate/UltimateBuyParams;)V", "Lcom/bytedance/android/shopping/buynow/starter/b;", "buyNowPageConfig", "Lcom/bytedance/android/shopping/buynow/starter/b;", "getBuyNowPageConfig", "()Lcom/bytedance/android/shopping/buynow/starter/b;", "setBuyNowPageConfig", "(Lcom/bytedance/android/shopping/buynow/starter/b;)V", "hasCheck", "getHasCheck", "setHasCheck", "continuePayPreSessionId", "getContinuePayPreSessionId", "hasReportDismiss", "getHasReportDismiss", "setHasReportDismiss", "Lcom/bytedance/android/shopping/sku/common/controller/a;", "asyncTwoStageController", "Lcom/bytedance/android/shopping/sku/common/controller/a;", "getAsyncTwoStageController", "()Lcom/bytedance/android/shopping/sku/common/controller/a;", "retryCount", "I", "getRetryCount", "()I", "setRetryCount", "(I)V", "isAutoRetry", "setAutoRetry", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BuyNowViewModel extends JediViewModel<BuyNowState> {
    private JSONObject addOnParams;
    private String addOnType;
    private JSONObject asyncTradeEventParam;
    private final com.bytedance.android.shopping.sku.common.controller.a asyncTwoStageController;
    private Integer availability;
    private com.bytedance.android.shopping.buynow.starter.b buyNowPageConfig;
    private com.bytedance.android.shopping.buynow.eventcenter.handle.a checkParams;
    private final String continuePayPreSessionId;
    private String curCheckStatus;
    private Stack<String> currentShownPopupCodes;
    private String editOperatorType;
    private long editStartTime;
    private String failMsg;
    private boolean hasCheck;
    private boolean hasReportDismiss;
    private boolean isAutoRetry;
    private Boolean isNoPwdCombined;
    private boolean isPageLoading;
    private boolean isResumed;
    private boolean needToast;
    private String pageStartupStatus;
    private int retryCount;
    private Map<?, ?> sdkInfo;
    private final f skuPageState;
    private final com.bytedance.android.shopping.sku.common.ability.b skuService;
    private final a staticState;
    private boolean submitStatusFlag;
    private final com.bytedance.android.shopping.buynow.tracker.a tracker;
    private UltimateBuyParams ultimateBuyParams;
    private AndroidYaTaInstance yataInstance;

    public BuyNowState defaultState() {
        return new BuyNowState(null);
    }

    public void onCleared() {
        com.bytedance.android.shopping.buynow.monitor.firstscreen.a.e.getClass();
        com.bytedance.android.shopping.buynow.monitor.firstscreen.a.d = null;
        super.onCleared();
    }

    public BuyNowViewModel() {
        this.staticState = new a(0);
        this.skuPageState = new f();
        this.tracker = new com.bytedance.android.shopping.buynow.tracker.a(this);
        int r0 = SkuCommonAbility.j;
        SkuAbilityType r1 = SkuAbilityType.BUYNOW;
        Intrinsics.checkNotNullParameter(r1, "type");
        this.skuService = new SkuCommonAbility(r1);
        this.addOnParams = new JSONObject();
        this.addOnType = "";
        this.curCheckStatus = CheckStatus.INIT;
        this.pageStartupStatus = "loading";
        this.currentShownPopupCodes = new Stack();
        this.needToast = true;
        this.editOperatorType = "";
        this.asyncTradeEventParam = new JSONObject();
        this.submitStatusFlag = true;
        this.buyNowPageConfig = new com.bytedance.android.shopping.buynow.starter.b(false, false, false, 0.0f, 15);
        this.continuePayPreSessionId = UUID.randomUUID().toString();
        this.asyncTwoStageController = new com.bytedance.android.shopping.sku.common.controller.a();
    }

    public final void handleAsyncEvent() {
        if (getAsyncEventparam().length() > 0) goto L5;
        return;
    L5:
        final Ref.ObjectRef r0 = new Ref.ObjectRef();
        r0.element = MapsKt.emptyMap();
        com.bytedance.android.shopping.buynow.monitor.error.a.f(this.tracker, "receive_params_from_jsb", null, new AnonymousClass1(this, r0));
        AndroidYaTaInstance r6 = this.yataInstance;
        if (r6 == null) goto L8;
        r6.k().d(e.a.a(r6, null, com.bytedance.android.shopping.buynow.controller.e.a, getAsyncEventparam().optString("type"), (Map) r0.element, "handleAsyncEvent"));
    L8:
        saveAsyncEventParam(new JSONObject());
    }

    public final JSONObject getAddOnParams() {
        return this.addOnParams;
    }

    public final String getAddOnType() {
        return this.addOnType;
    }

    public final JSONObject getAsyncEventparam() {
        return this.asyncTradeEventParam;
    }

    public final com.bytedance.android.shopping.sku.common.controller.a getAsyncTwoStageController() {
        return this.asyncTwoStageController;
    }

    public final Integer getAvailability() {
        return this.availability;
    }

    public final com.bytedance.android.shopping.buynow.starter.b getBuyNowPageConfig() {
        return this.buyNowPageConfig;
    }

    public final com.bytedance.android.shopping.buynow.eventcenter.handle.a getCheckParams() {
        return this.checkParams;
    }

    public final String getCheckStatus() {
        return this.curCheckStatus;
    }

    public final String getContinuePayPreSessionId() {
        return this.continuePayPreSessionId;
    }

    public final Stack<String> getCurrentShownPopupCodes() {
        return this.currentShownPopupCodes;
    }

    public final String getEditOperatorType() {
        return this.editOperatorType;
    }

    public final long getEditStartTime() {
        return this.editStartTime;
    }

    public final String getFailMsg() {
        return this.failMsg;
    }

    public final boolean getHasCheck() {
        return this.hasCheck;
    }

    public final boolean getHasReportDismiss() {
        return this.hasReportDismiss;
    }

    public final boolean getNeedToast() {
        return this.needToast;
    }

    public final String getPageStartupStatus() {
        return this.pageStartupStatus;
    }

    public final int getRetryCount() {
        return this.retryCount;
    }

    public final Map<?, ?> getSdkInfo() {
        return this.sdkInfo;
    }

    public final f getSkuPageState() {
        return this.skuPageState;
    }

    public final com.bytedance.android.shopping.sku.common.ability.b getSkuService() {
        return this.skuService;
    }

    public final a getStaticState() {
        return this.staticState;
    }

    public final boolean getSubmitStatusFlag() {
        return this.submitStatusFlag;
    }

    public final com.bytedance.android.shopping.buynow.tracker.a getTracker() {
        return this.tracker;
    }

    public final UltimateBuyParams getUltimateBuyParams() {
        return this.ultimateBuyParams;
    }

    public final AndroidYaTaInstance getYataInstance() {
        return this.yataInstance;
    }

    public final boolean isAutoRetry() {
        return this.isAutoRetry;
    }

    public final Boolean isNoPwdCombined() {
        return this.isNoPwdCombined;
    }

    public final boolean isPageLoading() {
        return this.isPageLoading;
    }

    public final boolean isResumed() {
        return this.isResumed;
    }

    /* JADX INFO: renamed from: defaultState, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ State m296defaultState() {
        return defaultState();
    }

    public final void saveAsyncEventParam(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "param");
        this.asyncTradeEventParam = r2;
    }

    public final void setAddOnParams(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.addOnParams = r2;
    }

    public final void setAddOnType(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.addOnType = r2;
    }

    public final void setAutoRetry(boolean r1) {
        this.isAutoRetry = r1;
    }

    public final void setAvailability(Integer r1) {
        this.availability = r1;
    }

    public final void setBuyNowPageConfig(com.bytedance.android.shopping.buynow.starter.b r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.buyNowPageConfig = r2;
    }

    public final void setCheckParams(com.bytedance.android.shopping.buynow.eventcenter.handle.a r1) {
        this.checkParams = r1;
    }

    public final void setCurCheckParams(com.bytedance.android.shopping.buynow.eventcenter.handle.a r1) {
        this.checkParams = r1;
        if (r1 == null) goto L8;
        String r2 = r1.d;
        if (r2 == null) goto L9;
        updateCheckStatus(r2);
        return;
    L9:
        return;
    }

    public final void setCurrentShownPopupCodes(Stack<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.currentShownPopupCodes = r2;
    }

    public final void setEditOperatorType(String r1) {
        this.editOperatorType = r1;
    }

    public final void setEditStartTime(long r1) {
        this.editStartTime = r1;
    }

    public final void setFailMsg(String r1) {
        this.failMsg = r1;
    }

    public final void setHasCheck(boolean r1) {
        this.hasCheck = r1;
    }

    public final void setHasReportDismiss(boolean r1) {
        this.hasReportDismiss = r1;
    }

    public final void setNeedToast(boolean r1) {
        this.needToast = r1;
    }

    public final void setNoPwdCombined(Boolean r1) {
        this.isNoPwdCombined = r1;
    }

    public final void setPageLoading(boolean r1) {
        this.isPageLoading = r1;
    }

    public final void setPageStartupStatus(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.pageStartupStatus = r2;
    }

    public final void setResumed(boolean r1) {
        this.isResumed = r1;
    }

    public final void setRetryCount(int r1) {
        this.retryCount = r1;
    }

    public final void setSdkInfo(Map<?, ?> r1) {
        this.sdkInfo = r1;
    }

    public final void setSubmitStatusFlag(boolean r1) {
        this.submitStatusFlag = r1;
    }

    public final void setUltimateBuyParams(UltimateBuyParams r1) {
        this.ultimateBuyParams = r1;
    }

    public final void setYataInstance(AndroidYaTaInstance r1) {
        this.yataInstance = r1;
    }

    public final void updateCheckStatus(String r2) {
        Intrinsics.checkNotNullParameter(r2, "status");
        this.curCheckStatus = r2;
    }

    public final void setCreateOrderLoadingData(Boolean r1, Map<?, ?> r2) {
        this.isNoPwdCombined = r1;
        this.sdkInfo = r2;
    }

    public final void trackRequestStartCheckPoint(boolean r6, String r7) {
        if (r6 == false) goto L5;
        this.tracker.k(CheckPointType.RENDER_REQUEST_START, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("desc", b.c(this.staticState))}));
        return;
    L5:
        this.tracker.k(CheckPointType.EDIT_REQUEST_START, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("desc", b.b(this.staticState)), TuplesKt.to("trigger_origin", r7)}));
    }

    public final void updateTrackerCommonParams(c r6, boolean r7) {
        Object r1 = null;
        JSONObject r2 = null;
        if (r7 == true) goto L5;
    L34:
        if (r6 == null) goto L38;
        Map r8 = r6.g();
        if (r8 == null) goto L38;
        Object r9 = r8.get("tracker_common_params");
    L40:
        if ((r9 instanceof Map) == false) goto L43;
        r1 = r9;
    L43:
        Map<String, ? extends Object> r10 = (Map) r1;
        if (r10 != null) goto L47;
        r10 = new LinkedHashMap();
    L47:
        if (mq.b.c(r10, "all_forbidden", false) == false) goto L49;
        int r11 = 1;
    L50:
        this.availability = r11;
        Lazy r12 = BuyNowLog.a;
        BuyNowLog.d("BuyNowFragment", "updateTrackerCommonParams " + this.availability);
        if ((!r10.isEmpty()) == false) goto L54;
        com.bytedance.android.shopping.buynow.tracker.a r13 = this.tracker;
        r13.getClass();
        Intrinsics.checkNotNullParameter(r10, "paramsMap");
        r13.d.appendEventParams(r10);
        return;
    L54:
        return;
    L49:
        r11 = 2;
    L38:
        r9 = null;
        goto L40
    L5:
        if (this.staticState.c() == false) goto L34;
        BuyNowPerformanceOpt.l();
        if (r6 == null) goto L11;
        Map r14 = r6.g();
        if (r14 == null) goto L11;
        Object r15 = r14.get("tracker_common_params");
    L13:
        if ((r15 instanceof Map) == true) goto L15;
        r15 = null;
    L15:
        r10 = (Map) r15;
        s.a r16 = s.d;
        a r0 = this.staticState;
        Map<String, ? extends Object> r3 = r0.j;
        String r4 = r0.k;
        r16.getClass();
        if (r3 == null) goto L32;
        if (r10 != null) goto L20;
        r10 = r3;
        goto L32
    L20:
        Map<String, ? extends Object> r17 = MapsKt.toMutableMap(r3);
        s.a.a(r17, r3, r10);
        if (BuyNowPerformanceOpt.b() == false) goto L31;
        if (r4 == null) goto L31;
        r17.put("recommend_info", r4);
        Object r5 = r17.get("entrance_info");
        if ((r5 instanceof String) == true) goto L26;
        r5 = null;
    L26:
        String r18 = (String) r5;
        if (r18 == null) goto L29;
        r2 = z1.g(r18);
    L29:
        if (r2 == null) goto L31;
        KtSafeMethodExtensionKt.safePut(r2, "recommend_info", r4);
        r17.put("entrance_info", r2.toString());
    L31:
        r10 = r17;
    L32:
        if (r10 != null) goto L47;
        r10 = MapsKt.emptyMap();
    L11:
        r15 = null;
        goto L13
    }

    public final void trackRequestEndCheckPoint(boolean r18, boolean r19, ma3.b r20, String r21, Integer r22, Throwable r23) {
        String r2 = "网络响应异常";
        if (r19 == false) goto L30;
        if (r18 == false) goto L6;
        this.tracker.k(CheckPointType.RENDER_REQUEST_SUCCESS, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("desc", b.c(this.staticState))}));
        return;
    L6:
        com.bytedance.android.shopping.buynow.tracker.a r1 = this.tracker;
        Pair[] r9 = new Pair[4];
        r9[0] = TuplesKt.to("desc", b.c(this.staticState));
        if (r20 == null) goto L10;
        Integer r8 = r20.a();
        if (r8 == null) goto L10;
    L11:
        if (r8 == null) goto L13;
        int r10 = r8.intValue();
    L14:
        r9[1] = TuplesKt.to("code", Integer.valueOf(r10));
        if (r20 == null) goto L18;
        String r11 = r20.b();
        if (r11 == null) goto L18;
    L21:
        if (r11 == null) goto L24;
        r2 = r11;
    L24:
        r9[2] = TuplesKt.to("message", r2);
        if (r23 == null) goto L27;
        String r12 = r23.getMessage();
    L28:
        r9[3] = TuplesKt.to("throwable_message", r12);
        r1.k(CheckPointType.RENDER_REQUEST_FAILED, MapsKt.mutableMapOf(r9));
        return;
    L27:
        r12 = null;
    L18:
        if (r22 == null) goto L20;
        r11 = "HTTP Error(" + r22.intValue() + ')';
        goto L21
    L20:
        r11 = null;
        goto L21
    L13:
        r10 = -9998;
    L10:
        r8 = r22;
        goto L11
    L30:
        if (r18 == false) goto L32;
        this.tracker.k(CheckPointType.EDIT_REQUEST_SUCCESS, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("desc", b.b(this.staticState)), TuplesKt.to("trigger_origin", r21)}));
        return;
    L32:
        com.bytedance.android.shopping.buynow.tracker.a r13 = this.tracker;
        Pair[] r14 = new Pair[5];
        r14[0] = TuplesKt.to("desc", b.b(this.staticState));
        if (r20 == null) goto L36;
        Integer r4 = r20.a();
        if (r4 == null) goto L36;
    L37:
        if (r4 == null) goto L39;
        int r16 = r4.intValue();
    L40:
        r14[1] = TuplesKt.to("code", Integer.valueOf(r16));
        if (r20 == null) goto L44;
        String r5 = r20.b();
        if (r5 == null) goto L44;
    L47:
        if (r5 == null) goto L50;
        r2 = r5;
    L50:
        r14[2] = TuplesKt.to("message", r2);
        if (r23 == null) goto L53;
        String r3 = r23.getMessage();
    L54:
        r14[3] = TuplesKt.to("throwable_message", r3);
        r14[4] = TuplesKt.to("trigger_origin", r21);
        r13.k(CheckPointType.EDIT_REQUEST_FAILED, MapsKt.mutableMapOf(r14));
        return;
    L53:
        r3 = null;
    L44:
        if (r22 == null) goto L46;
        r5 = "HTTP Error(" + r22.intValue() + ')';
        goto L47
    L46:
        r5 = null;
        goto L47
    L39:
        r16 = -9998;
    L36:
        r4 = r22;
        goto L37
    }

    public static /* synthetic */ void trackRequestEndCheckPoint$default(BuyNowViewModel r7, boolean r8, boolean r9, ma3.b r10, String r11, Integer r12, Throwable r13, int r14, Object r15) {
        if ((r14 & 32) == 0) goto L5;
        r13 = null;
    L5:
        r7.trackRequestEndCheckPoint(r8, r9, r10, r11, r12, r13);
    }
}
