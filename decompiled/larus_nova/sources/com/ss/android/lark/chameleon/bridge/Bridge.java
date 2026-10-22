package com.ss.android.lark.chameleon.bridge;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.ss.android.lark.chameleon.basewebview.LarkWebView;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.util.JsonUtils;
import com.ss.android.lark.chameleon.util.UIExecutor;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0085\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005*\u00014\u0018\u0000 G2\u00020\u0001:\u0001GB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u001dJ\u0010\u0010#\u001a\u00020!2\b\b\u0002\u0010$\u001a\u00020\u0017J\u001c\u0010%\u001a\u0004\u0018\u00010\u00182\b\u0010&\u001a\u0004\u0018\u00010\u00012\u0006\u0010'\u001a\u00020\u0017H\u0002J*\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020\u00172\b\u0010*\u001a\u0004\u0018\u00010+2\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010-J\u0006\u0010.\u001a\u00020!J\u0006\u0010/\u001a\u00020!J\u0010\u00100\u001a\u00020!2\u0006\u00101\u001a\u000202H\u0002J'\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u00172\b\u00106\u001a\u0004\u0018\u00010\u00172\u0006\u00107\u001a\u00020\u0017H\u0002¢\u0006\u0002\u00108J\u0010\u00109\u001a\u00020!2\u0006\u0010:\u001a\u00020\u0017H\u0017J\u0018\u0010;\u001a\u00020<2\u0006\u00101\u001a\u0002022\u0006\u0010=\u001a\u00020>H\u0002J\u0016\u0010?\u001a\u00020!2\u0006\u00105\u001a\u00020\u00172\u0006\u0010@\u001a\u00020\u0018J \u0010A\u001a\u00020!2\u0006\u00105\u001a\u00020\u00172\u0010\u0010B\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00030CJ\u000e\u0010D\u001a\u00020!2\u0006\u0010\"\u001a\u00020\u001dJ\u0010\u0010E\u001a\u00020!2\b\b\u0002\u0010$\u001a\u00020\u0017J\u000e\u0010F\u001a\u00020!2\u0006\u00105\u001a\u00020\u0017R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/ss/android/lark/chameleon/bridge/Bridge;", "", "webView", "Lcom/ss/android/lark/chameleon/basewebview/LarkWebView;", "(Lcom/ss/android/lark/chameleon/basewebview/LarkWebView;)V", "value", "Lcom/ss/android/lark/chameleon/bridge/BridgeExetension;", "bridgeExtension", "getBridgeExtension", "()Lcom/ss/android/lark/chameleon/bridge/BridgeExetension;", "setBridgeExtension", "(Lcom/ss/android/lark/chameleon/bridge/BridgeExetension;)V", "bridgeInfoPrinter", "Lcom/ss/android/lark/chameleon/bridge/BridgeInfoPrinter;", "gson", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "Lkotlin/Lazy;", "handlerNameToExtraMap", "", "", "Lorg/json/JSONObject;", "handlerRepository", "Lcom/ss/android/lark/chameleon/bridge/HandlerRepository;", "jsMsgInterceptors", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/ss/android/lark/chameleon/bridge/JsMsgInterceptor;", "scheduler", "Lio/reactivex/Scheduler;", "addJSMsgInterceptor", "", "interceptor", "addJavascriptInterface", "bridgeName", "buildExtraObject", "extensionExtra", "defaultExtraStr", "callJSFun", "apiName", "param", "Ljava/io/Serializable;", "callback", "Landroid/webkit/ValueCallback;", "clearAllHandler", MapMonitorConst.EVENT_DESTROY, "dispatchMsgFromJS", "msg", "Lcom/ss/android/lark/chameleon/bridge/Message;", "getCallback", "com/ss/android/lark/chameleon/bridge/Bridge$getCallback$1", "handlerName", "callbackId", "extraStr", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/ss/android/lark/chameleon/bridge/Bridge$getCallback$1;", "invokeNative", "jsMessage", "onInterceptJSMsg", "", "callBack", "Lcom/ss/android/lark/chameleon/bridge/JsCallBack;", "registerExtra", "extra", "registerHandler", "handler", "Lcom/ss/android/lark/chameleon/bridge/BridgeHandler;", "removeJSMsgInterceptor", "removeJavascriptInterface", "unRegisterHandler", "Companion", "chameleon-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Bridge {
    public static final String API_HAS_NO_AUTH = "api has no auth";
    public static final String BRIDGE_NAME = "Lark_Bridge";
    public static final String CALLBACK_FUN = "LarkWebViewJavaScriptBridge.nativeCallBack(%s);";
    public static final Companion Companion = null;
    public static final String ERRMSG = "errMsg";
    public static final String FIND_NO_HANDLER = "find no handler";
    public static final String TAG = "JSBridge";
    public static final int TRANSFER_MAX_SIZE = 2097152;
    private volatile BridgeExetension bridgeExtension;
    private final BridgeInfoPrinter bridgeInfoPrinter;
    private final Lazy gson$delegate;
    private final Map<String, JSONObject> handlerNameToExtraMap;
    private final HandlerRepository handlerRepository;
    private final CopyOnWriteArrayList<JsMsgInterceptor> jsMsgInterceptors;
    private final Scheduler scheduler;
    private final LarkWebView webView;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chameleon/bridge/Bridge$Companion;", "", "()V", "API_HAS_NO_AUTH", "", "BRIDGE_NAME", "CALLBACK_FUN", "ERRMSG", "FIND_NO_HANDLER", "TAG", "TRANSFER_MAX_SIZE", "", "chameleon-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chameleon.bridge.Bridge$getCallback$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"com/ss/android/lark/chameleon/bridge/Bridge$getCallback$1", "Lcom/ss/android/lark/chameleon/bridge/JsCallBack;", "handleTimeStart", "", "getHandleTimeStart", "()J", "setHandleTimeStart", "(J)V", "onCallBack", "", "status", "Lcom/ss/android/lark/chameleon/bridge/Status;", "param", "", "chameleon-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class AnonymousClass1 implements JsCallBack {
        final /* synthetic */ String $callbackId;
        final /* synthetic */ String $extraStr;
        final /* synthetic */ String $handlerName;
        private long handleTimeStart;
        final /* synthetic */ Bridge this$0;

        public final long getHandleTimeStart() {
            return this.handleTimeStart;
        }

        public final void setHandleTimeStart(long r100) {
            this.handleTimeStart = r100;
        }

        @Override // com.ss.android.lark.chameleon.bridge.JsCallBack
        public void onCallBack(Status r100, Object r101) {
            Intrinsics.checkNotNullParameter(r100, "status");
            String r102 = this.$callbackId;
            if (r102 != null) goto L5;
        L8:
            boolean r103 = true;
        L9:
            if (r103 == false) goto L11;
            return;
        L11:
            if (this.this$0.getBridgeExtension().shouldMonitorHandlerConsumTime() == false) goto L13;
            System.currentTimeMillis();
        L13:
            ResponseJsData r104 = this.this$0.getBridgeExtension().getResponseJSData(r100, this.$callbackId, r101, this.$extraStr);
            HashMap<String, Object> r105 = new HashMap();
            if (r104 == null) goto L17;
            String r106 = r104.getCallbackId();
            if (r106 == null) goto L17;
        L18:
            r105.put("callbackID", r106);
            if (r104 == null) goto L24;
            Object r107 = r104.getData();
            if (r107 == null) goto L24;
            r101 = r107;
        L24:
            r105.put("data", r101);
            if (r104 == null) goto L30;
            Status r108 = r104.getStatus();
            if (r108 == null) goto L30;
            String r109 = r108.getStatus();
            if (r109 == null) goto L30;
        L31:
            r105.put("callbackType", r109);
            Bridge r110 = this.this$0;
            if (r104 == null) goto L34;
            Object r111 = r104.getExtraStr();
        L35:
            JSONObject r112 = Bridge.access$buildExtraObject(r110, r111, this.$extraStr);
            if ((r101 instanceof JSONObject) == false) goto L42;
            JSONObject r113 = (JSONObject) Bridge.access$getHandlerNameToExtraMap$p(this.this$0).get(this.$handlerName);
            if (r113 == null) goto L41;
            r112 = r113;
        L41:
            r105.put("extra", r112);
            StringCompanionObject r114 = StringCompanionObject.INSTANCE;
            String r115 = String.format(Bridge.CALLBACK_FUN, Arrays.copyOf(new Object[]{new JSONObject(r105).toString()}, 1));
        L48:
            Log.d("JSBridge", "evaluateJavascript for jsapi callback, script = " + r115);
            Bridge.access$getWebView$p(this.this$0).evaluateJavascript(r115, null);
            return;
        L42:
            Object r116 = (JSONObject) Bridge.access$getHandlerNameToExtraMap$p(this.this$0).get(this.$handlerName);
            if (r116 != null) goto L47;
            if (r112 == null) goto L46;
            r116 = r112.toString();
            goto L47
        L46:
            r116 = null;
        L47:
            r105.put("extra", r116);
            String r117 = GsonProtectorUtils.toJson(Bridge.access$getGson(this.this$0), r105);
            Bridge.access$getBridgeInfoPrinter$p(this.this$0).printInfo(r105, r117);
            StringCompanionObject r118 = StringCompanionObject.INSTANCE;
            r115 = String.format(Bridge.CALLBACK_FUN, Arrays.copyOf(new Object[]{r117}, 1));
            goto L48
        L34:
            r111 = null;
        L30:
            r109 = r100.getStatus();
        L17:
            r106 = this.$callbackId;
            goto L18
        L5:
            if (r102.length() == 0) goto L8;
            r103 = false;
            goto L9
        }

        public AnonymousClass1(String r100, Bridge r101, String r102, String r103) {
            this.$callbackId = r100;
            this.this$0 = r101;
            this.$extraStr = r102;
            this.$handlerName = r103;
            this.handleTimeStart = System.currentTimeMillis();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ void a(BridgeHandler r100, Object r101, AnonymousClass1 r102, Message r103, Bridge r104) {
        dispatchMsgFromJS$lambda$3(r100, r101, r102, r103, r104);
    }

    public static /* synthetic */ Unit b(Function1 r100, Object r101) {
        return invokeNative$lambda$0(r100, r101);
    }

    public static /* synthetic */ void c(Function1 r100, Object r101) {
        invokeNative$lambda$2(r100, r101);
    }

    public static /* synthetic */ void d(Function1 r100, Object r101) {
        invokeNative$lambda$1(r100, r101);
    }

    private final Gson getGson() {
        return (Gson) this.gson$delegate.getValue();
    }

    public final void clearAllHandler() {
        this.handlerRepository.handlers.clear();
    }

    public final void destroy() {
        Log.i("JSBridge", MapMonitorConst.EVENT_DESTROY);
        clearAllHandler();
        this.scheduler.shutdown();
    }

    public final BridgeExetension getBridgeExtension() {
        return this.bridgeExtension;
    }

    public Bridge(LarkWebView r100) {
        Intrinsics.checkNotNullParameter(r100, "webView");
        this.webView = r100;
        this.handlerRepository = new HandlerRepository();
        this.scheduler = Schedulers.from(PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("bridge/Bridge")));
        this.jsMsgInterceptors = new CopyOnWriteArrayList();
        this.handlerNameToExtraMap = new ConcurrentHashMap();
        this.gson$delegate = LazyKt.lazy(Bridge$gson$2.INSTANCE);
        this.bridgeExtension = new BridgeExetension();
        addJavascriptInterface$default(this, null, 1, null);
        this.bridgeInfoPrinter = new BridgeInfoPrinter();
    }

    public static final /* synthetic */ BridgeInfoPrinter access$getBridgeInfoPrinter$p(Bridge r100) {
        return r100.bridgeInfoPrinter;
    }

    public static final /* synthetic */ Gson access$getGson(Bridge r100) {
        return r100.getGson();
    }

    public static final /* synthetic */ Map access$getHandlerNameToExtraMap$p(Bridge r100) {
        return r100.handlerNameToExtraMap;
    }

    public static final /* synthetic */ LarkWebView access$getWebView$p(Bridge r100) {
        return r100.webView;
    }

    private final void dispatchMsgFromJS(final Message r110) {
        String r100 = r110.getApiName();
        Log.d("JSBridge", "dispatchMsgFromJS, handlerName: " + r100);
        boolean r101 = false;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        return;
    L11:
        final BridgeHandler r103 = this.handlerRepository.handlers.get(r100);
        String r104 = r110.getCallbackID();
        String r105 = r110.getExtra();
        if (r105 != null) goto L14;
        r105 = "";
    L14:
        final AnonymousClass1 r106 = getCallback(r100, r104, r105);
        if (onInterceptJSMsg(r110, r106) == false) goto L18;
        Log.d("JSBridge", "msg " + r100 + " onInterceptJSMsg");
        return;
    L18:
        if (r103 != null) goto L21;
        r106.onCallBack(Status.FAILURE, MapsKt.mapOf(new Pair("errMsg", FIND_NO_HANDLER)));
        Log.e("JSBridge", "handler not found: " + r100 + "  web info :, scene: " + this.webView.getBizScene$chameleon_base_release());
        return;
    L21:
        Class<?> r107 = Utils.INSTANCE.getGenericClass(r103);
        if (r107 != null) goto L24;
    L43:
        final Object r108 = null;
    L44:
        Log.i("JSBridge", "handlerName: " + r100 + ", result: " + r108);
        if (r103.shouldRunInUIThread() == false) goto L47;
        Log.d("JSBridge", r100 + " handled on UIThread");
        UIExecutor.executor().post(new a(r103, r108, r106, r110, this));
        return;
    L47:
        Log.d("JSBridge", r100 + " not handled on UIThread");
        r103.handle(r108, r106, r110.getExtra(), this.webView);
        return;
    L24:
        if (r110.getData() == null) goto L43;
        if (Intrinsics.areEqual(r110.getData(), "") == true) goto L43;
        if (Intrinsics.areEqual(r107, String.class) == false) goto L33;
        Object r109 = r110.getData();
    L31:
        r108 = r109;
        goto L44
    L33:
        if (r110.getData() == null) goto L35;
        String r111 = r110.getData();
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type kotlin.String");
    L36:
        if (r111 != null) goto L38;
    L39:
        r101 = true;
    L40:
        if (r101 == true) goto L43;
        r109 = GsonProtectorUtils.fromJson(getGson(), r111, r107);
        goto L31
    L38:
        if (StringsKt.isBlank(r111) == false) goto L40;
    L35:
        r111 = JsonUtils.INSTANCE.toJsonString(r110.getData());
        goto L36
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r102 = false;
        goto L9
    }

    public final void addJSMsgInterceptor(JsMsgInterceptor r100) {
        Intrinsics.checkNotNullParameter(r100, "interceptor");
        if (this.jsMsgInterceptors.contains(r100) == true) goto L6;
        this.jsMsgInterceptors.add(r100);
        return;
    }

    public final void addJavascriptInterface(String r100) {
        Intrinsics.checkNotNullParameter(r100, "bridgeName");
        this.webView.addJavascriptInterface(this, r100);
    }

    @JavascriptInterface
    public void invokeNative(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "jsMessage");
        Flowable r101 = Flowable.just(r100).subscribeOn(this.scheduler);
        final Function1<String, Unit> r102 = new C117131(r100, this);
        Flowable r103 = r101.map(new b(r102));
        final AnonymousClass2 r104 = AnonymousClass2.INSTANCE;
        Consumer r105 = new c(r104);
        final Function1<Throwable, Unit> r106 = new AnonymousClass3(this);
        r103.subscribe(r105, new d(r106));
    }

    public final void removeJSMsgInterceptor(JsMsgInterceptor r100) {
        Intrinsics.checkNotNullParameter(r100, "interceptor");
        this.jsMsgInterceptors.remove(r100);
    }

    public final void removeJavascriptInterface(String r100) {
        Intrinsics.checkNotNullParameter(r100, "bridgeName");
        this.webView.removeJavascriptInterface(r100);
    }

    public final void setBridgeExtension(BridgeExetension r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.bridgeExtension = r100;
    }

    public final void unRegisterHandler(String r100) {
        Intrinsics.checkNotNullParameter(r100, "handlerName");
        Log.i("JSBridge", "unRegisterHandler handlerName = " + r100);
        this.handlerRepository.handlers.remove(r100);
    }

    public static final /* synthetic */ void access$dispatchMsgFromJS(Bridge r100, Message r101) {
        r100.dispatchMsgFromJS(r101);
    }

    private final JSONObject buildExtraObject(Object r100, String r101) {
    L21:
        e = move-exception;
        Log.e("JSBridge", e.toString());
        return new JSONObject();
    L4:
        if ((r100 instanceof JSONObject) == false) goto L8;
        Log.d("JSBridge", "extensionExtra is JSONObject");     // Catch: JSONException -> L21
        return (JSONObject) r100;
    L8:
        if ((r100 instanceof JsonObject) == false) goto L12;
        Log.d("JSBridge", "extensionExtra is gson.JSONObject");     // Catch: JSONException -> L21
        return new JSONObject(((JsonObject) r100).toString());
    L12:
        if ((r100 instanceof String) == false) goto L20;
        if (TextUtils.isEmpty((CharSequence) r100) == false) goto L18;
        Log.d("JSBridge", "extensionExtra is empty , will return defaultExtraStr");     // Catch: JSONException -> L21
        return new JSONObject(r101);
    L18:
        return new JSONObject((String) r100);
    L20:
        return new JSONObject();
    }

    private static final Unit invokeNative$lambda$0(Function1 r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "$tmp0");
        return (Unit) r100.invoke(r101);
    }

    private static final void invokeNative$lambda$1(Function1 r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "$tmp0");
        r100.invoke(r101);
    }

    private static final void invokeNative$lambda$2(Function1 r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "$tmp0");
        r100.invoke(r101);
    }

    private final boolean onInterceptJSMsg(Message r100, JsCallBack r101) {
        Iterator<T> r102 = this.jsMsgInterceptors.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        if (((JsMsgInterceptor) r103).onInterceptJSMsg(r100, r101) == false) goto L4;
    L9:
        if (r103 == null) goto L11;
        return true;
    L11:
        return false;
    L8:
        r103 = null;
        goto L9
    }

    public final void registerExtra(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "handlerName");
        Intrinsics.checkNotNullParameter(r101, "extra");
        this.handlerNameToExtraMap.put(r100, r101);
    }

    public final void registerHandler(String r100, BridgeHandler<?, LarkWebView> r101) {
        Intrinsics.checkNotNullParameter(r100, "handlerName");
        Intrinsics.checkNotNullParameter(r101, "handler");
        if (StringsKt.isBlank(r100) == true) goto L7;
        Log.i("JSBridge", "registerHandler handlerName = " + r100);
        this.handlerRepository.handlers.put(r100, r101);
        return;
    L7:
        throw new IllegalArgumentException("handlerName should not blank");
    }

    public static final /* synthetic */ JSONObject access$buildExtraObject(Bridge r100, Object r101, String r102) {
        return r100.buildExtraObject(r101, r102);
    }

    private final AnonymousClass1 getCallback(String r100, String r101, String r102) {
        return new AnonymousClass1(r101, this, r102, r100);
    }

    public final void callJSFun(String r100, Serializable r101, ValueCallback<String> r102) {
        Intrinsics.checkNotNullParameter(r100, "apiName");
        String r103 = Utils.INSTANCE.combineRequestContent(r100, r101);
        this.webView.evaluateJavascript(r103, r102);
    }

    public static final /* synthetic */ AnonymousClass1 access$getCallback(Bridge r100, String r101, String r102, String r103) {
        return r100.getCallback(r101, r102, r103);
    }

    public static /* synthetic */ void addJavascriptInterface$default(Bridge r100, String r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = BRIDGE_NAME;
    L5:
        r100.addJavascriptInterface(r101);
    }

    public static /* synthetic */ void removeJavascriptInterface$default(Bridge r100, String r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = BRIDGE_NAME;
    L5:
        r100.removeJavascriptInterface(r101);
    }

    private static final void dispatchMsgFromJS$lambda$3(BridgeHandler r100, Object r101, AnonymousClass1 r102, Message r103, Bridge r104) {
        Intrinsics.checkNotNullParameter(r102, "$callback");
        Intrinsics.checkNotNullParameter(r103, "$msg");
        Intrinsics.checkNotNullParameter(r104, "this$0");
        r100.handle(r101, r102, r103.getExtra(), r104.webView);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void callJSFun$default(Bridge r100, String r101, Serializable r102, ValueCallback r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L5;
        r103 = null;
    L5:
        r100.callJSFun(r101, r102, r103);
    }
}
