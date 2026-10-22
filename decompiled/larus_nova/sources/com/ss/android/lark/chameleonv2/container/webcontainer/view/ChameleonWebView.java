package com.ss.android.lark.chameleonv2.container.webcontainer.view;

import android.content.Context;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.webkit.ConsoleMessage;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.ViewKt;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.google.gson.Gson;
import com.ss.android.lark.chameleon.AbsChameleonPlugin;
import com.ss.android.lark.chameleon.AbsChameleonService;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.IChameleonHandlerContext;
import com.ss.android.lark.chameleon.IWebService;
import com.ss.android.lark.chameleon.JsbAuthConfig;
import com.ss.android.lark.chameleon.OpenConfig;
import com.ss.android.lark.chameleon.WebviewConfig;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chameleon.pluginapi.IChameleonLoader;
import com.ss.android.lark.chameleon.pluginapi.OpenStatus;
import com.ss.android.lark.chameleon.pluginapi.RouterState;
import com.ss.android.lark.chameleon.pluginapi.WebviewStatus;
import com.ss.android.lark.chameleonv2.container.webcontainer.ChameleonWebViewManager;
import com.ss.android.lark.chameleonv2.container.webcontainer.plugin.UIThreadCallbackAdapter;
import com.ss.android.lark.chameleonv2.container.webcontainer.preload.ChameleonPreloader;
import com.ss.android.lark.chameleonv2.container.webcontainer.res.ChameleonOfflineResourceInterceptor;
import com.ss.android.lark.chameleonv2.container.webcontainer.res.ProxyChameleonOfflineResourceInterceptor;
import com.ss.android.lark.chameleonv2.lkapi.webview.IWebview$Ipc$EventType;
import com.ss.android.lark.chameleonv2.lkapi.webview.IWebview$Ipc$RouterStateChangeEvent;
import com.ss.android.lark.chameleonv2.lkapi.webview.IWebview$Ipc$StateChangeEvent;
import com.ss.android.lark.chameleonv2.lkapi.webview.IWebview$Ipc$VisibilityChangeEvent;
import com.ss.android.lark.chameleonv2.lkapi.webview.IWebview$Status;
import com.ss.android.lark.chameleonv2.lkapi.webview.IWebview$VisibilityState;
import com.ss.android.lark.officesdk.di.core.DependencyContainer;
import com.ss.android.lark.officesdk.utils.AppInfoUtils;
import com.ss.android.lark.officewebview.base.OfficeWebView;
import com.ss.android.lark.officewebview.quality.hang.HangDetectStrategy;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vfs.VFSPath;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ntb.l;
import vv4.m;
import vv4.n;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u009e\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0002IV\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0004®\u0001¯\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u00100\u001a\u00020'J\u000e\u00101\u001a\u0002022\u0006\u00103\u001a\u00020'J\u0006\u00104\u001a\u00020\u000fJ\u000e\u00105\u001a\u0002022\u0006\u00103\u001a\u00020\u000fJ\u0006\u00106\u001a\u00020\u000fJ\u000e\u00107\u001a\u0002022\u0006\u00103\u001a\u00020\u000fJ\f\u00108\u001a\b\u0012\u0004\u0012\u00020,0+J\u0014\u00109\u001a\u0002022\f\u00103\u001a\b\u0012\u0004\u0012\u00020,0+J\u0006\u0010:\u001a\u00020.J\u000e\u0010;\u001a\u0002022\u0006\u00103\u001a\u00020.J\u0006\u0010<\u001a\u00020\u000fJ\u000e\u0010=\u001a\u0002022\u0006\u00103\u001a\u00020\u000fJ\b\u0010\\\u001a\u000202H\u0016J\b\u0010]\u001a\u000202H\u0016J\b\u0010^\u001a\u000202H\u0016J\b\u0010_\u001a\u00020YH\u0002J\b\u0010`\u001a\u000202H\u0002J\u0010\u0010a\u001a\u0002022\b\u0010K\u001a\u0004\u0018\u00010\nJ\n\u0010b\u001a\u0004\u0018\u00010cH\u0016J\n\u0010d\u001a\u0004\u0018\u00010\u0004H\u0016J'\u0010e\u001a\u0004\u0018\u0001Hf\"\b\b\u0000\u0010f*\u00020g2\f\u0010h\u001a\b\u0012\u0004\u0012\u0002Hf0iH\u0016¢\u0006\u0002\u0010jJ\n\u0010k\u001a\u0004\u0018\u00010lH\u0016J\u0014\u0010m\u001a\b\u0012\u0002\b\u0003\u0018\u00010n2\u0006\u0010o\u001a\u00020\nJ\b\u0010p\u001a\u000202H\u0016J\b\u0010q\u001a\u000202H\u0016J\b\u0010v\u001a\u00020\nH\u0016J\b\u0010w\u001a\u00020\nH\u0016J'\u0010z\u001a\u000202\"\b\b\u0000\u0010f*\u00020,2\u0006\u0010{\u001a\u00020\n2\u0006\u0010|\u001a\u0002HfH\u0016¢\u0006\u0002\u0010}J\b\u0010~\u001a\u00020\u0006H\u0016J\u0006\u0010\u007f\u001a\u00020\rJ\u0007\u0010\u0080\u0001\u001a\u000202J\u0007\u0010\u0081\u0001\u001a\u00020TJ\u0010\u0010\u0082\u0001\u001a\u00020C2\u0007\u0010\u0083\u0001\u001a\u00020\u000fJ\t\u0010\u0084\u0001\u001a\u000202H\u0014J\t\u0010\u0085\u0001\u001a\u000202H\u0014J\u0013\u0010\u0086\u0001\u001a\u0002022\n\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0088\u0001J\u001c\u0010\u0086\u0001\u001a\u0002022\u0007\u0010\u0089\u0001\u001a\u00020.2\n\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0088\u0001J\u0013\u0010\u008a\u0001\u001a\u0002022\n\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0088\u0001J\u0013\u0010\u008b\u0001\u001a\u0002022\n\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u008c\u0001J\u001c\u0010\u008b\u0001\u001a\u0002022\u0007\u0010\u0089\u0001\u001a\u00020.2\n\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u008c\u0001J\u0013\u0010\u008d\u0001\u001a\u0002022\n\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u008c\u0001J\u0011\u0010\u008e\u0001\u001a\u0002022\b\u0010\u008f\u0001\u001a\u00030\u0090\u0001J\u0011\u0010\u0091\u0001\u001a\u0002022\b\u0010\u008f\u0001\u001a\u00030\u0090\u0001J\u0011\u0010\u0092\u0001\u001a\u0002022\b\u0010\u0093\u0001\u001a\u00030\u0094\u0001J\u0011\u0010\u0095\u0001\u001a\u0002022\b\u0010\u0093\u0001\u001a\u00030\u0094\u0001J\u0012\u0010\u0096\u0001\u001a\u0002022\t\u0010\u0097\u0001\u001a\u0004\u0018\u00010GJ\u0012\u0010\u0098\u0001\u001a\u0002022\t\u0010\u0097\u0001\u001a\u0004\u0018\u00010GJ-\u0010\u0099\u0001\u001a\u0002022\u0007\u0010\u009a\u0001\u001a\u00020.2\u0007\u0010\u009b\u0001\u001a\u00020.2\u0007\u0010\u009c\u0001\u001a\u00020.2\u0007\u0010\u009d\u0001\u001a\u00020.H\u0016J\u0018\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009f\u00012\n\u0010 \u0001\u001a\u0005\u0018\u00010¡\u0001H\u0016J\u0011\u0010¢\u0001\u001a\u0002022\b\u0010\u0093\u0001\u001a\u00030£\u0001J\u0011\u0010¤\u0001\u001a\u0002022\b\u0010\u0093\u0001\u001a\u00030£\u0001J\u0007\u0010¥\u0001\u001a\u000202J\u001a\u0010¦\u0001\u001a\u0002022\b\u0010§\u0001\u001a\u00030¨\u00012\u0007\u0010©\u0001\u001a\u00020.J\b\u0010A\u001a\u00020\u000fH\u0002J\u0015\u0010ª\u0001\u001a\u00020\n2\n\u0010«\u0001\u001a\u0005\u0018\u00010¬\u0001H\u0002J\t\u0010\u00ad\u0001\u001a\u000202H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010CX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010D\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020G0FR\u00020\u00000EX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u00020IX\u0082\u0004¢\u0006\u0004\n\u0002\u0010JR\u0010\u0010K\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010L\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bL\u0010\u0011R\u000e\u0010O\u001a\u00020PX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020RX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020TX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010U\u001a\u00020VX\u0082\u0004¢\u0006\u0004\n\u0002\u0010WR\u0011\u0010X\u001a\u00020Y¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010[R\u0016\u0010r\u001a\u0004\u0018\u00010s8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bt\u0010uR\u000e\u0010x\u001a\u00020yX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006°\u0001"}, d2 = {"Lcom/ss/android/lark/chameleonv2/container/webcontainer/view/ChameleonWebView;", "Lcom/ss/android/lark/chameleonv2/container/webcontainer/view/DecorateWebViewV2;", "Lcom/ss/android/lark/chameleon/IChameleonHandlerContext;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "config", "Lcom/ss/android/lark/chameleon/ChameleonConfig;", "<init>", "(Landroid/content/Context;Lcom/ss/android/lark/chameleon/ChameleonConfig;)V", "mTAG", "", "chameleonConfig", "mWebServiceManager", "Lcom/bytedance/ee/bear/browser/WebServiceManager;", "onLoadSuccess", "", "getOnLoadSuccess", "()Z", "setOnLoadSuccess", "(Z)V", "callbackAdapter", "Lcom/ss/android/lark/chameleonv2/container/webcontainer/plugin/UIThreadCallbackAdapter;", "getCallbackAdapter", "()Lcom/ss/android/lark/chameleonv2/container/webcontainer/plugin/UIThreadCallbackAdapter;", "startLoadUrlTime", "", "getStartLoadUrlTime", "()J", "setStartLoadUrlTime", "(J)V", "preloadUrl", "getPreloadUrl", "()Ljava/lang/String;", "setPreloadUrl", "(Ljava/lang/String;)V", "loadUrl", "getLoadUrl", "setLoadUrl", "status", "Lcom/ss/android/lark/chameleon/pluginapi/WebviewStatus;", "isAttach", "isVisible", "routerState", "Lcom/ss/android/lark/chameleon/pluginapi/RouterState;", "Ljava/io/Serializable;", "usedCount", "", "isReady", "getStatus", "setStatus", "", "value", "getIsAttach", "setIsAttach", "getIsVisible", "setIsVisible", "getRouterState", "setRouterState", "getUsedCount", "setUsedCount", "getIsReady", "setIsReady", "hangDetected", "hangDetectStrategy", "Lcom/ss/android/lark/officewebview/quality/hang/HangDetectStrategy;", "enableForceDark", "chameleonResource", "Lcom/ss/android/lark/chameleonv2/container/webcontainer/res/resupdate/ChameleonResource;", "mScrollChangeListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/ss/android/lark/chameleonv2/container/webcontainer/view/ChameleonWebView$WeakReferenceCallbackWrapper;", "Lcom/bytedance/ee/bear/browser/view/OnScrollChangeListener;", "larkWebViewContext", "com/ss/android/lark/chameleonv2/container/webcontainer/view/ChameleonWebView$larkWebViewContext$1", "Lcom/ss/android/lark/chameleonv2/container/webcontainer/view/ChameleonWebView$larkWebViewContext$1;", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "isProxyEnabled", "isProxyEnabled$delegate", "Lkotlin/Lazy;", "webViewClient", "Lcom/ss/android/lark/chameleonv2/container/webcontainer/ExtendableWebViewClientV2;", "webChromeClient", "Lcom/ss/android/lark/chameleonv2/container/webcontainer/ExtendableWebChromeClient;", "chameleonPreloader", "Lcom/ss/android/lark/chameleonv2/container/webcontainer/preload/ChameleonPreloader;", "webviewHangCallback", "com/ss/android/lark/chameleonv2/container/webcontainer/view/ChameleonWebView$webviewHangCallback$1", "Lcom/ss/android/lark/chameleonv2/container/webcontainer/view/ChameleonWebView$webviewHangCallback$1;", "jsbAuthManager", "Lcom/ss/android/lark/chameleonv2/container/webcontainer/jsbauth/JsbAuthManager;", "getJsbAuthManager", "()Lcom/ss/android/lark/chameleonv2/container/webcontainer/jsbauth/JsbAuthManager;", "onResume", "onPause", "onStop", "obtainJsbAuthManager", "addWebService", "injectSession", "getWebview", "Landroid/webkit/WebView;", "getCmlContext", "getWebService", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/ee/bear/browser/WebService;", "service", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/bytedance/ee/bear/browser/WebService;", "getFragment", "Landroidx/fragment/app/Fragment;", "getFragmentHandler", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "handlerName", "destroyWebview", "reloadWebview", "webviewLoader", "Lcom/ss/android/lark/chameleon/pluginapi/IChameleonLoader;", "getWebviewLoader", "()Lcom/ss/android/lark/chameleon/pluginapi/IChameleonLoader;", "getSession", "getBizName", "gson", "Lcom/google/gson/Gson;", "sendEvent", "type", "data", "(Ljava/lang/String;Ljava/io/Serializable;)V", "getChameleonConfig", "getWebServiceManager", "preload", "getPreloader", "getResource", DocumentType.DOCX_SYNC_BLOCK_NAME, "onAttachedToWindow", "onDetachedFromWindow", "addWebViewClientDelegate", "clientDelegate", "Landroid/webkit/WebViewClient;", "index", "removeWebViewClientDelegate", "addWebChromeClientDelegate", "Landroid/webkit/WebChromeClient;", "removeWebChromeClientDelegate", "addRenderGoneListener", "renderGoneListener", "Lcom/bytedance/ee/bear/browser/Web$IRenderGoneListener;", "removeRenderGoneListener", "addLoadCallback", "cb", "Lcom/ss/android/lark/chameleon/pluginapi/IChameleonLoader$LoadingCallback;", "removeLoadCallback", "addScrollChangeListener", "scrollChangeListener", "removeScrollChangeListener", "onScrollChanged", "l", "t", "oldl", "oldt", "onCreateInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "addTitleBarCallback", "Lcom/ss/android/lark/chameleon/pluginapi/IChameleonLoader$IChameleonTitleBarCallback;", "removeTitleBarCallback", "release", "reportOpenStatus", "result", "Lcom/ss/android/lark/chameleon/pluginapi/OpenStatus;", "code", "jsbAuthInjectScript", "request", "Landroid/webkit/WebResourceRequest;", "reportHangDetect", "WeakReferenceCallbackWrapper", "InputConnWrapper", "chameleon_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChameleonWebView extends DecorateWebViewV2 implements IChameleonHandlerContext {

    /* JADX INFO: renamed from: y2, reason: collision with root package name */
    public static final /* synthetic */ int f411313y2 = 0;
    public boolean G1;
    public RouterState<Serializable> H1;
    public int L1;
    public boolean M1;
    public final String P0;
    public boolean P1;
    public HangDetectStrategy Q1;
    public volatile com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.d S1;
    public final CopyOnWriteArrayList<d<zv4.f>> T1;
    public final ChameleonConfig V0;
    public String V1;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public final n f411314b1;

    /* JADX INFO: renamed from: b2, reason: collision with root package name */
    public final Lazy f411315b2;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public boolean f411316g1;

    /* JADX INFO: renamed from: g2, reason: collision with root package name */
    public final com.ss.android.lark.chameleonv2.container.webcontainer.i f411317g2;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public final UIThreadCallbackAdapter f411318h1;

    /* JADX INFO: renamed from: h2, reason: collision with root package name */
    public final com.ss.android.lark.chameleonv2.container.webcontainer.h f411319h2;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public long f411320k1;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public String f411321p1;

    /* JADX INFO: renamed from: p2, reason: collision with root package name */
    public final ChameleonPreloader f411322p2;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public String f411323v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public final g f411324v2;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    public WebviewStatus f411325x1;

    /* JADX INFO: renamed from: x2, reason: collision with root package name */
    public final p0b.a f411326x2;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    public boolean f411327y1;

    public static final class a implements com.ss.android.lark.chameleonv2.container.webcontainer.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChameleonWebView f411328a;

        public a(ChameleonWebView r100) {
            this.f411328a = r100;
        }

        @Override // com.ss.android.lark.chameleonv2.container.webcontainer.j
        public final String a(WebResourceRequest r100) {
            ChameleonWebView r101 = this.f411328a;
            int r102 = ChameleonWebView.f411313y2;
            r101.getClass();
            if (r100 != null) goto L6;
        L13:
            return "";
        L6:
            if (r100.isForMainFrame() == false) goto L13;
            p0b.a r103 = r101.f411326x2;
            if (r103 == null) goto L13;
            if (r103.a() == false) goto L13;
            String r104 = r100.getUrl().toString();
            p0b.a r105 = r101.f411326x2;
            r105.getClass();
            Intrinsics.checkNotNullParameter(r104, "url");
            String r106 = UUID.randomUUID().toString();
            r105.f527309c.put(r106, r104);
            com.ss.android.lark.officesdk.utils.di.j.e("CML_TAG_JsbAuthManager", "getScripTextForInject url: " + r104 + ", token: " + r106);
            Intrinsics.checkNotNullParameter(r106, "token");
            return "<script> var chameleonJsbAuthToken = '" + r106 + "'; </script>";
        }
    }

    public static final class b extends WebChromeClient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChameleonWebView f411329a;

        @Override // android.webkit.WebChromeClient
        public final boolean onJsTimeout() {
            com.ss.android.lark.officesdk.utils.di.j.b(this.f411329a.P0, "onJsTimeout");
            return super.onJsTimeout();
        }

        public b(ChameleonWebView r100) {
            this.f411329a = r100;
        }

        @Override // android.webkit.WebChromeClient
        public final boolean onConsoleMessage(ConsoleMessage r100) {
            if (r100 != null) goto L4;
            return true;
        L4:
            if (r100.messageLevel().ordinal() <= ConsoleMessage.MessageLevel.LOG.ordinal()) goto L9;
            com.ss.android.lark.officesdk.utils.di.j.e(this.f411329a.P0 + "_js", "onConsoleMessage->" + swb.i.a(r100.message()) + " -- From line " + r100.lineNumber() + swb.i.a(r100.sourceId()));
            return true;
        L9:
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public final void onProgressChanged(WebView r100, int r101) {
            super.onProgressChanged(r100, r101);
            if (r101 != 100) goto L22;
            String r102 = this.f411329a.V0.getBizName();
            if (r102 == null) goto L11;
            int r103 = com.ss.android.lark.officesdk.utils.di.d.f437220a;
            v1b.a r104 = (v1b.a) e0c.k.a(com.ss.android.lark.officesdk.utils.di.d.a.a(), v1b.a.class);
            if (r104 == null) goto L11;
            ChameleonWebViewManager r105 = r104.F2();
            if (r105 == null) goto L11;
            Intrinsics.checkNotNullParameter(r102, "bizName");
            ((ArrayList) r105.f411139c).remove(r102);
        L11:
            OpenConfig r106 = this.f411329a.getChameleonConfig().getOpenConfig();
            if (r106 != null) goto L14;
        L16:
            boolean r107 = false;
        L17:
            if (r107 == false) goto L20;
            return;
        L20:
            if (this.f411329a.getOnLoadSuccess() == true) goto L22;
            this.f411329a.setOnLoadSuccess(true);
            this.f411329a.getCallbackAdapter().onLoadSuccess();
            goto L22
        L14:
            if (r106.getHideLoadingByJS() != true) goto L16;
            r107 = true;
        L22:
            this.f411329a.getCallbackAdapter().onLeftBackAndCloseChange();
        }

        @Override // android.webkit.WebChromeClient
        public final void onReceivedTitle(WebView r100, String r101) {
            super.onReceivedTitle(r100, r101);
            this.f411329a.getCallbackAdapter().onReceivedTitle(r100, r101);
        }

        @Override // android.webkit.WebChromeClient
        public final boolean onCreateWindow(WebView r100, boolean r101, boolean r102, Message r103) {
            Intrinsics.checkNotNullParameter(r103, "resultMsg");
            com.ss.android.lark.officesdk.utils.di.j.e(this.f411329a.P0, "onCreateWindow");
            if (r100 != null) goto L5;
            r100 = this.f411329a;
        L5:
            WebView r104 = new WebView(r100.getContext());
            r104.setWebViewClient(this.f411329a.f411317g2);
            Object r105 = r103.obj;
            if ((r105 instanceof WebView.WebViewTransport) == false) goto L8;
            WebView.WebViewTransport r106 = (WebView.WebViewTransport) r105;
        L9:
            if (r106 != null) goto L12;
            return false;
        L12:
            r106.setWebView(r104);
            r103.sendToTarget();
            return true;
        L8:
            r106 = null;
            goto L9
        }
    }

    public final class c extends InputConnectionWrapper {
        public c(InputConnection r100) {
            super(r100, true);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public final boolean sendKeyEvent(KeyEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            return super.sendKeyEvent(r100);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public final boolean deleteSurroundingText(int r110, int r111) {
            if ((r110 - r111) != 1) goto L7;
            long r112 = SystemClock.uptimeMillis();
            sendKeyEvent(new KeyEvent(r112, r112, 0, 67, 0, 0, -1, 0, 22));
            sendKeyEvent(new KeyEvent(SystemClock.uptimeMillis(), r112, 1, 67, 0, 0, -1, 0, 22));
            return true;
        L7:
            return super.deleteSurroundingText(r110, r111);
        }
    }

    public final class d<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<T> f411330a;

        public final int hashCode() {
            T r100 = this.f411330a.get();
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public d(Object r100) {
            this.f411330a = new WeakReference(r100);
        }

        public final boolean equals(Object r100) {
            T r101 = this.f411330a.get();
            if (r101 != null) goto L6;
            return false;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            T r102 = ((d) r100).f411330a.get();
            if (r102 != null) goto L11;
            return false;
        L11:
            if (r101 != r102) goto L14;
            return true;
        L14:
            return false;
        }
    }

    public /* synthetic */ class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f411331a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f411332b = null;

        static {
            int[] r100 = new int[WebviewStatus.values().length];
            r100[WebviewStatus.Attached.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L29:
            r100[WebviewStatus.Visible.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L39:
            r100[WebviewStatus.Hidden.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L31:
            r100[WebviewStatus.Detached.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
        L10:
            f411331a = r100;
            int[] r101 = new int[OpenStatus.values().length];
            r101[OpenStatus.SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L35:
            r101[OpenStatus.FAILED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L25:
            r101[OpenStatus.TIMEOUT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L33:
            r101[OpenStatus.CANCEL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L15:
            f411332b = r101;
        }
    }

    public static final class f implements wwb.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChameleonWebView f411333a;

        @Override // wwb.c
        public final oxb.n getServiceManager() {
            return new oxb.n();
        }

        @Override // wwb.c
        public final Context getWebViewContext() {
            return this.f411333a.getContext();
        }

        @Override // wwb.c
        public final OfficeWebView getWebView() {
            return this.f411333a;
        }

        public f(ChameleonWebView r100) {
            this.f411333a = r100;
        }
    }

    public static final class g implements jxb.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChameleonWebView f411334a;

        public g(ChameleonWebView r100) {
            this.f411334a = r100;
        }

        @Override // jxb.b
        public final void a(Boolean r100) {
            u1b.a.f548360b = r100;
        }

        @Override // jxb.b
        public final void b(HangDetectStrategy r100) {
            Intrinsics.checkNotNullParameter(r100, "detectStrategy");
            ChameleonWebView r101 = this.f411334a;
            r101.P1 = true;
            r101.Q1 = r100;
        }
    }

    public static final class h implements IChameleonLoader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChameleonWebView f411335a;

        @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader
        public final void addTitleBarCallback(IChameleonLoader.IChameleonTitleBarCallback r100) {
            Intrinsics.checkNotNullParameter(r100, "cb");
        }

        @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader
        public final void load(String r100) {
            Intrinsics.checkNotNullParameter(r100, "url");
        }

        @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader
        public final void release() {
        }

        @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader
        public final void reload() {
        }

        @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader
        public final void removeTitleBarCallback(IChameleonLoader.IChameleonTitleBarCallback r100) {
            Intrinsics.checkNotNullParameter(r100, "cb");
        }

        @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader
        public final void reportOpenStatus(OpenStatus r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "result");
        }

        @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader
        public final RouterState<Serializable> getRouterState() {
            return this.f411335a.getRouterState();
        }

        @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader
        public final WebviewStatus getStatus() {
            return this.f411335a.getStatus();
        }

        @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader
        public final boolean getVisible() {
            return this.f411335a.getIsVisible();
        }

        @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader
        public final void onLoadSuccess() {
            this.f411335a.setIsReady(true);
            this.f411335a.getCallbackAdapter().onLoadSuccess();
        }

        public h(ChameleonWebView r100) {
            this.f411335a = r100;
        }

        @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader
        public final void addLoadCallback(IChameleonLoader.LoadingCallback r100) {
            Intrinsics.checkNotNullParameter(r100, "cb");
            this.f411335a.w(r100);
        }

        @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader
        public final void removeLoadCallback(IChameleonLoader.LoadingCallback r100) {
            Intrinsics.checkNotNullParameter(r100, "cb");
            this.f411335a.A(r100);
        }

        @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader
        public final void setRouteState(RouterState<Serializable> r100) {
            Intrinsics.checkNotNullParameter(r100, "state");
            this.f411335a.setRouterState(r100);
        }

        @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader
        public final void onLoadFailed(int r100, Throwable r101) {
            this.f411335a.getCallbackAdapter().onLoadFail(r100, r101);
        }
    }

    @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
    public WebView getWebview() {
        return this;
    }

    @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
    public final void destroyWebview() {
        int r100 = com.ss.android.lark.officesdk.utils.di.d.f437220a;
        v1b.a r101 = (v1b.a) e0c.k.a(com.ss.android.lark.officesdk.utils.di.d.a.a(), v1b.a.class);
        if (r101 == null) goto L8;
        ChameleonWebViewManager r102 = r101.F2();
        if (r102 == null) goto L9;
        r102.c(this);
        return;
    L9:
        return;
    }

    public final boolean getIsAttach() {
        com.ss.android.lark.officesdk.utils.di.j.e(this.P0, "getIsAttach: " + this.f411327y1);
        return this.f411327y1;
    }

    public final boolean getIsReady() {
        com.ss.android.lark.officesdk.utils.di.j.e(this.P0, "getIsReady: " + this.M1);
        return this.M1;
    }

    public final boolean getIsVisible() {
        com.ss.android.lark.officesdk.utils.di.j.e(this.P0, "getIsVisible: " + this.G1);
        return this.G1;
    }

    public final RouterState<Serializable> getRouterState() {
        com.ss.android.lark.officesdk.utils.di.j.e(this.P0, "getRouterState: " + this.H1);
        return this.H1;
    }

    @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
    public String getSession() {
        String r100 = this.V1;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final WebviewStatus getStatus() {
        com.ss.android.lark.officesdk.utils.di.j.e(this.P0, "getStatus: " + this.f411325x1);
        return this.f411325x1;
    }

    public final int getUsedCount() {
        com.ss.android.lark.officesdk.utils.di.j.e(this.P0, "getUsedCount: " + this.L1);
        return this.L1;
    }

    @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
    public IChameleonLoader getWebviewLoader() {
        return new h(this);
    }

    @Override // com.ss.android.lark.chameleonv2.container.webcontainer.view.DecorateWebViewV2, com.ss.android.lark.officewebview.base.OfficeWebView, com.ss.android.lark.officewebview.base.g, android.webkit.WebView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        com.ss.android.lark.officesdk.utils.di.j.e(this.P0, "onAttachedToWindow");
        super.onAttachedToWindow();
        setIsAttach(true);
        jxb.a r100 = (jxb.a) this.f437458a.a(jxb.a.class);
        if (r100 == null) goto L6;
        r100.H(this.f411324v2);
        return;
    }

    @Override // com.ss.android.lark.chameleonv2.container.webcontainer.view.DecorateWebViewV2, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        com.ss.android.lark.officesdk.utils.di.j.e(this.P0, "onDetachedFromWindow");
        super.onDetachedFromWindow();
        setIsAttach(false);
        jxb.a r100 = (jxb.a) this.f437458a.a(jxb.a.class);
        if (r100 == null) goto L5;
        r100.N(this.f411324v2);
    L5:
        c();
    }

    @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
    public final void reloadWebview() {
        int r100 = com.ss.android.lark.officesdk.utils.di.d.f437220a;
        v1b.a r101 = (v1b.a) e0c.k.a(com.ss.android.lark.officesdk.utils.di.d.a.a(), v1b.a.class);
        if (r101 == null) goto L8;
        ChameleonWebViewManager r102 = r101.F2();
        if (r102 == null) goto L9;
        Intrinsics.checkNotNullParameter(this, "webView");
        com.ss.android.lark.officesdk.utils.di.j.e(r102.f411137a, "reloadWebview()... webView = " + hashCode());
        stopLoading();
        clearHistory();
        z();
        return;
    L9:
        return;
    }

    public final void z() {
        this.f411322p2.d();
    }

    @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
    public String getBizName() {
        String r100 = getChameleonConfig().getBizName();
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
    public Context getCmlContext() {
        Fragment r100 = getFragment();
        if (r100 == null) goto L10;
        FragmentActivity r101 = r100.getActivity();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return getContext();
    L10:
        return getContext();
    }

    @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
    public Fragment getFragment() {
        return ViewKt.findFragment(this);
    L4:
        return null;
    }

    @Override // com.ss.android.lark.officewebview.base.OfficeWebView, com.ss.android.lark.officewebview.base.g, android.webkit.WebView
    public final void onPause() {
        super.onPause();
        com.ss.android.lark.officesdk.utils.di.j.e(this.P0, "onPause");
    }

    @Override // com.ss.android.lark.officewebview.base.OfficeWebView, com.ss.android.lark.officewebview.base.g, android.webkit.WebView
    public final void onResume() {
        super.onResume();
        com.ss.android.lark.officesdk.utils.di.j.e(this.P0, "onResume");
        this.P1 = false;
    }

    public final UIThreadCallbackAdapter getCallbackAdapter() {
        return this.f411318h1;
    }

    @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
    public ChameleonConfig getChameleonConfig() {
        return this.V0;
    }

    public final p0b.a getJsbAuthManager() {
        return this.f411326x2;
    }

    public final String getLoadUrl() {
        return this.f411323v1;
    }

    public final boolean getOnLoadSuccess() {
        return this.f411316g1;
    }

    public final String getPreloadUrl() {
        return this.f411321p1;
    }

    public final ChameleonPreloader getPreloader() {
        return this.f411322p2;
    }

    public final long getStartLoadUrlTime() {
        return this.f411320k1;
    }

    public final n getWebServiceManager() {
        return this.f411314b1;
    }

    public final void A(IChameleonLoader.LoadingCallback r100) {
        Intrinsics.checkNotNullParameter(r100, "cb");
        UIThreadCallbackAdapter r101 = this.f411318h1;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "cb");
        r101.f411178a.remove(r100);
    }

    public final void B(zv4.f r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.T1.remove(new d(r100));
    }

    @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
    public final <T extends m> T getWebService(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "service");
        return (T) this.f411314b1.a(r100);
    }

    @Override // android.webkit.WebView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo r100) {
        InputConnection r101 = super.onCreateInputConnection(r100);
        if (r101 != null) goto L6;
        return null;
    L6:
        return new c(r101);
    }

    public final void setIsAttach(boolean r100) {
        com.ss.android.lark.officesdk.utils.di.j.e(this.P0, "setIsAttach: " + r100);
        this.f411327y1 = r100;
        if (r100 == false) goto L5;
        setStatus(WebviewStatus.Attached);
        return;
    L5:
        setStatus(WebviewStatus.Detached);
    }

    public final void setIsReady(boolean r100) {
        com.ss.android.lark.officesdk.utils.di.j.e(this.P0, "setIsReady: " + r100);
        this.M1 = r100;
    }

    public final void setIsVisible(boolean r100) {
        com.ss.android.lark.officesdk.utils.di.j.e(this.P0, "setIsVisible: " + r100);
        this.G1 = r100;
        String r101 = IWebview$Ipc$EventType.VisibilityChange.getValue();
        if (r100 == false) goto L5;
        IWebview$VisibilityState r102 = IWebview$VisibilityState.Visible;
    L6:
        sendEvent(r101, new IWebview$Ipc$VisibilityChangeEvent(r102));
        if (r100 == false) goto L9;
        setStatus(WebviewStatus.Visible);
        return;
    L9:
        setStatus(WebviewStatus.Hidden);
        return;
    L5:
        r102 = IWebview$VisibilityState.Hidden;
        goto L6
    }

    public final void setLoadUrl(String r100) {
        this.f411323v1 = r100;
    }

    public final void setOnLoadSuccess(boolean r100) {
        this.f411316g1 = r100;
    }

    public final void setPreloadUrl(String r100) {
        this.f411321p1 = r100;
    }

    public final void setRouterState(RouterState<Serializable> r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        com.ss.android.lark.officesdk.utils.di.j.e(this.P0, "setRouterState: " + r100);
        this.H1 = r100;
        sendEvent(IWebview$Ipc$EventType.WebviewRouterStateChange.getValue(), new IWebview$Ipc$RouterStateChangeEvent(r100.getPath(), r100.getParams()));
    }

    public final void setStartLoadUrlTime(long r100) {
        this.f411320k1 = r100;
    }

    public final void setStatus(WebviewStatus r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        com.ss.android.lark.officesdk.utils.di.j.e(this.P0, "setStatus: " + r100);
        this.f411325x1 = r100;
        int r101 = e.f411331a[r100.ordinal()];
        if (r101 != 1) goto L5;
        IWebview$Status r102 = IWebview$Status.Attached;
    L16:
        sendEvent(IWebview$Ipc$EventType.WebviewLifecycleStateChange.getValue(), new IWebview$Ipc$StateChangeEvent(r102));
        return;
    L5:
        if (r101 != 2) goto L7;
        r102 = IWebview$Status.Visible;
        goto L16
    L7:
        if (r101 != 3) goto L9;
        r102 = IWebview$Status.Hidden;
        goto L16
    L9:
        if (r101 != 4) goto L12;
        r102 = IWebview$Status.Detached;
        goto L16
    L12:
        throw new NoWhenBranchMatchedException();
    }

    public final void setUsedCount(int r100) {
        com.ss.android.lark.officesdk.utils.di.j.e(this.P0, "setUsedCount: " + r100);
        this.L1 = r100;
    }

    public final void w(IChameleonLoader.LoadingCallback r100) {
        Intrinsics.checkNotNullParameter(r100, "cb");
        UIThreadCallbackAdapter r101 = this.f411318h1;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "cb");
        r101.f411178a.add(r100);
    }

    public final void x(zv4.f r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        d<zv4.f> r101 = new d(r100);
        if (this.T1.contains(r101) == true) goto L8;
        this.T1.add(r101);
        return;
    }

    public final com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.d y(boolean r100) {
        com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.d r101 = this.S1;
        if (r101 != null) goto L25;
        monitor-enter(this);
        r101 = this.S1;     // Catch: Throwable -> L22
        if (r101 != null) goto L20;
        List<? extends u0b.a> r102 = t0b.a.f544132a;     // Catch: Throwable -> L22
        r101 = t0b.a.a(getContext(), this.V0, r100, this.V1);     // Catch: Throwable -> L22
        String r103 = this.P0;     // Catch: Throwable -> L22
        StringBuilder r104 = new StringBuilder("get resource, sync = ");     // Catch: Throwable -> L22
        r104.append(r100);     // Catch: Throwable -> L22
        r104.append(", path = ");     // Catch: Throwable -> L22
        VFSPath r105 = r101.f411279a;     // Catch: Throwable -> L22
        if (r105 == null) goto L10;
        String r106 = r105.getAbsolutePath();     // Catch: Throwable -> L22
    L11:
        r104.append(r106);     // Catch: Throwable -> L22
        r104.append(", version = ");     // Catch: Throwable -> L22
        r104.append(r101.f411280b);     // Catch: Throwable -> L22
        com.ss.android.lark.officesdk.utils.di.j.e(r103, r104.toString());     // Catch: Throwable -> L22
        Map<String, u1b.a.C7822a> r107 = u1b.a.f548359a;     // Catch: Throwable -> L22
        u1b.a.C7822a r108 = u1b.a.a(this.V1);     // Catch: Throwable -> L22
        if (r108 == null) goto L18;
        String r109 = r101.f411280b;     // Catch: Throwable -> L22
        if (r109 != null) goto L16;
        r109 = "";
    L16:
        Intrinsics.checkNotNullParameter(ChameleonOpenTracker.ParamKey.RES_VERSION, "key");     // Catch: Throwable -> L22
        Intrinsics.checkNotNullParameter(r109, "value");     // Catch: Throwable -> L22
        r108.f548365e.put(ChameleonOpenTracker.ParamKey.RES_VERSION, r109);     // Catch: Throwable -> L22
    L18:
        if (r101.f411279a == null) goto L20;
        this.S1 = r101;     // Catch: Throwable -> L22
        goto L20
    L10:
        r106 = null;
    L20:
        monitor-exit(this);
    L22:
        th = move-exception;
        throw th;
    L25:
        return r101;
    }

    public ChameleonWebView(Context r110, ChameleonConfig r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "config");
        OpenConfig r100 = r111.getOpenConfig();
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        super(r110, r102);
        String r103 = "CML_TAG_ChameleonWebView_" + hashCode();
        this.P0 = r103;
        ChameleonConfig r112 = r111.copy();
        this.V0 = r112;
        this.f411314b1 = new n();
        UIThreadCallbackAdapter r104 = new UIThreadCallbackAdapter();
        this.f411318h1 = r104;
        this.f411320k1 = System.currentTimeMillis();
        this.f411325x1 = WebviewStatus.Detached;
        this.H1 = new RouterState("", "");
        int r105 = com.ss.android.lark.officesdk.utils.di.g.f437223a;
        boolean r106 = com.ss.android.lark.officesdk.utils.di.g.a.a("lark.cml.webview_force_dark");
        this.T1 = new CopyOnWriteArrayList();
        f r107 = new f(this);
        Lazy r108 = LazyKt.lazy(new ChameleonWebView$isProxyEnabled$2(this));
        this.f411315b2 = r108;
        com.ss.android.lark.chameleonv2.container.webcontainer.i r109 = new com.ss.android.lark.chameleonv2.container.webcontainer.i(r107);
        this.f411317g2 = r109;
        com.ss.android.lark.chameleonv2.container.webcontainer.h r113 = new com.ss.android.lark.chameleonv2.container.webcontainer.h(r107);
        this.f411319h2 = r113;
        this.f411322p2 = new ChameleonPreloader(this, r112, r104);
        this.f411324v2 = new g(this);
        setBizType(dxb.b.f470453c);
        OpenConfig r114 = r112.getOpenConfig();
        if (r114 == null) goto L11;
        r114.setPluginProvider(null);
    L11:
        String r115 = r112.getBizName();
        if (r115 == null) goto L18;
        setBizScene(r115);
        int r116 = com.ss.android.lark.officesdk.utils.di.d.f437220a;
        v1b.a r117 = (v1b.a) e0c.k.a(com.ss.android.lark.officesdk.utils.di.d.a.a(), v1b.a.class);
        if (r117 == null) goto L18;
        ChameleonWebViewManager r118 = r117.F2();
        if (r118 == null) goto L18;
        Intrinsics.checkNotNullParameter(r115, "bizName");
        ((ArrayList) r118.f411139c).add(r115);
    L18:
        setBackgroundColor(0);
        if (r106 == false) goto L21;
        l(h18.f.a(r110));
    L21:
        setWebViewClient(r109);
        ((CopyOnWriteArrayList) r109.f411167f).add(new a(this));
        setWebChromeClient(r113);
        com.ss.android.lark.chameleonv2.container.webcontainer.res.a r119 = new com.ss.android.lark.chameleonv2.container.webcontainer.res.a();
        if (((Boolean) r108.getValue()).booleanValue() == false) goto L24;
        y0b.b r120 = new ProxyChameleonOfflineResourceInterceptor(this, r112);
    L25:
        Intrinsics.checkNotNullParameter(r120, "interceptor");
        r119.f411269a.add(r120);
        y0b.a r121 = new y0b.a(this, r112);
        Intrinsics.checkNotNullParameter(r121, "interceptor");
        r119.f411269a.add(r121);
        z0b.j r122 = new z0b.j(this, r112);
        Intrinsics.checkNotNullParameter(r122, "interceptor");
        r119.f411269a.add(r122);
        com.ss.android.lark.chameleonv2.container.webcontainer.plugin.b r123 = new com.ss.android.lark.chameleonv2.container.webcontainer.plugin.b(r119, this, r104);
        if (((CopyOnWriteArrayList) r109.f411166e).contains(r123) == true) goto L28;
        ((CopyOnWriteArrayList) r109.f411166e).add(r123);
    L28:
        r113.f411165e = new com.ss.android.lark.chameleonv2.container.webcontainer.view.e(this);
        b r124 = new b(this);
        if (((CopyOnWriteArrayList) r113.f411164d).contains(r124) == true) goto L31;
        ((CopyOnWriteArrayList) r113.f411164d).add(r124);
    L31:
        int r125 = com.ss.android.lark.chameleonv2.container.webcontainer.view.h.f411361a;
        Intrinsics.checkNotNullParameter(this, "webView");
        OpenConfig r126 = getChameleonConfig().getOpenConfig();
        if (r126 != null) goto L34;
    L36:
        boolean r127 = false;
    L37:
        if (r127 == false) goto L39;
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
    L39:
        CookieManager.getInstance().setAcceptThirdPartyCookies(this, true);
        WebSettings r128 = getSettings();
        r128.setLoadWithOverviewMode(true);
        r128.setUseWideViewPort(true);
        r128.setJavaScriptEnabled(true);
        r128.setDomStorageEnabled(true);
        r128.setSupportMultipleWindows(false);
        r128.setJavaScriptCanOpenWindowsAutomatically(true);
        r128.setCacheMode(-1);
        r128.setAllowFileAccess(true);
        r128.setDatabaseEnabled(true);
        r128.setMixedContentMode(2);
        Context r129 = getContext();
        Intrinsics.checkNotNullParameter(r129, PerfLog.PARAM_KEY_CONTEXT_ID);
        StringBuilder r130 = new StringBuilder();
        String r131 = com.ss.android.lark.officewebview.util.j.a(r129);
        if (r131.length() != 0) goto L42;
        boolean r132 = true;
    L43:
        if (r132 == false) goto L45;
        r131 = "Mozilla/5.0 (Linux; Android 7.0; FRD-AL00 Build/HUAWEIFRD-AL00; wv) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.91 Mobile Safari/537.36";
    L45:
        r130.append(r131);
        r130.append(" Chameleon");
        r130.append(" Lark/" + AppInfoUtils.a(r129));
        r130.append(" platform/android okhttp/3.2");
        String r133 = r130.toString();
        WebviewConfig r134 = getChameleonConfig().getWebviewConfig();
        if (r134 == null) goto L48;
        String r135 = r134.getBizUAgent();
    L50:
        if (TextUtils.isEmpty(r135) == true) goto L56;
        StringBuilder r136 = new StringBuilder();
        r136.append(r133);
        r136.append(' ');
        WebviewConfig r137 = getChameleonConfig().getWebviewConfig();
        if (r137 == null) goto L54;
        String r138 = r137.getBizUAgent();
    L55:
        r136.append(r138);
        r133 = r136.toString();
        goto L56
    L54:
        r138 = null;
    L56:
        r128.setUserAgentString(r133);
        com.ss.android.lark.officesdk.utils.di.j.e("CML_TAG_ChameleonWebSettings", "initSettings: ua = " + r133);
        ArrayList r139 = new ArrayList();
        WebviewConfig r140 = r112.getWebviewConfig();
        if (r140 != null) goto L59;
    L61:
        if (r101 == true) goto L68;
        DependencyContainer r141 = DependencyContainer.f433166a;
        l r142 = (l) DependencyContainer.a(l.class, null);
        if (r142 != null) goto L65;
    L67:
        com.ss.android.lark.officesdk.utils.di.j.b(r103, "addWebService, LKAPIDependency is null");
        goto L68
    L65:
        if ((r142.m() instanceof AbsChameleonService) == false) goto L67;
        z0b.i r143 = r142.m();
        Intrinsics.checkNotNull(r143, "null cannot be cast to non-null type com.ss.android.lark.chameleon.AbsChameleonService");
        r139.add(r143);
    L68:
        WebviewConfig r144 = r112.getWebviewConfig();
        if (r144 == null) goto L80;
        IWebService r145 = r144.getWebService();
        if (r145 == null) goto L80;
        List<? extends m> r146 = r145.getWebService();
        if (r146 == null) goto L80;
        com.ss.android.lark.officesdk.utils.di.j.e(r103, "webService size = " + r146.size());
        if ((!r146.isEmpty()) == false) goto L80;
        Iterator<T> r147 = r146.iterator();
    L78:
        if (r147.hasNext() == false) goto L80;
        r139.add((m) r147.next());
    L80:
        this.f411314b1.b(new com.ss.android.lark.chameleonv2.container.webcontainer.view.g(this, getBridge(), this), r139);
        WebviewConfig r148 = this.V0.getWebviewConfig();
        if (r148 == null) goto L84;
        JsbAuthConfig r149 = r148.getJsbAuthConfig();
        if (r149 == null) goto L84;
    L85:
        this.f411326x2 = new p0b.a(r149, this);
        xwb.a r150 = getBridge();
        com.ss.android.lark.chameleonv2.container.webcontainer.util.a r151 = new com.ss.android.lark.chameleonv2.container.webcontainer.util.a(this);
        r150.getClass();
        Intrinsics.checkNotNullParameter(r151, "extension");
        Intrinsics.checkNotNullParameter(r151, "value");
        r150.f565295i = r151;
        new Gson();
        return;
    L84:
        r149 = new JsbAuthConfig(false, false, null, 7, null);
        goto L85
    L59:
        if (r140.getLarkApiEnable() == true) goto L61;
        r101 = true;
        goto L61
    L48:
        r135 = null;
        goto L50
    L42:
        r132 = false;
        goto L43
    L34:
        if (r126.getHideScrollBar() != true) goto L36;
        r127 = true;
        goto L37
    L24:
        r120 = new ChameleonOfflineResourceInterceptor(this, r112);
        goto L25
    L5:
        if (r100.isNestedEnable() != true) goto L7;
        r102 = true;
        goto L8
    }

    @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
    public final <T extends Serializable> void sendEvent(String r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "data");
        WebviewConfig r102 = this.V0.getWebviewConfig();
        boolean r103 = false;
        if (r102 != null) goto L5;
    L7:
        if (r103 == false) goto L9;
        return;
    L9:
        evaluateJavascript(StringsKt.trimIndent("\n                javascript:LarkWebViewJavaScriptBridge.nativeCallBack({\n                  callbackID: 'LarkAPI.ipc.event',\n                  callbackType: 'continued',\n                  data: " + swb.k.b(new AbsChameleonPlugin.LKAPIEvent(r100, -1, r101)) + ",\n                })\n            "), null);
        return;
    L5:
        if (r102.getLarkApiEnable() == true) goto L7;
        r103 = true;
        goto L7
    }

    @Override // com.ss.android.lark.officewebview.base.OfficeWebView, android.webkit.WebView, android.view.View
    public final void onScrollChanged(int r100, int r110, int r111, int r112) {
        super.onScrollChanged(r100, r110, r111, r112);
        Iterator<d<zv4.f>> r101 = this.T1.iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        d<zv4.f> r102 = r101.next();
        if (r102.f411330a.get() != null) goto L7;
        this.T1.remove(r102);
        goto L4
    L7:
        zv4.f r103 = r102.f411330a.get();
        if (r103 == null) goto L4;
        r103.onScrollChange(this, r100, r110, r111, r112);
        goto L4
    }
}
