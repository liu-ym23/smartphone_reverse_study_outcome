package com.larus.search.impl;

import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.apm.ApmAgent;
import com.bytedance.awemeopen.servicesapi.network.ByteNetEnvHeaderName;
import com.bytedance.ies.bullet.ui.common.BulletContainerView;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.pia.core.metrics.ErrorType;
import com.bytedance.router.SmartRouter;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.ivy.ivykit.api.plugin.IIvyWebService;
import com.ivy.ivykit.plugin.impl.web.PluginWebView;
import com.ixigua.lib.track.TrackParams;
import com.larus.applog.api.IApplog;
import com.larus.bmhome.view.screenmenu.CommonMenu;
import com.larus.caijing_pay.impl.config.CJHostRouterServiceImpl;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.dialog.CommonLoadDialogFragment;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.home.impl.sdk.x1;
import com.larus.ivykit.IvyKitInitializer;
import com.larus.ivykit.web.TTWebViewService;
import com.larus.network.http.HttpExtKt;
import com.larus.nova.R;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.b2;
import com.larus.platform.api.e1;
import com.larus.platform.model.webview.AbsWebFragment;
import com.larus.platform.service.i2;
import com.larus.platform.service.z2;
import com.larus.search.api.event.HybridEventParams;
import com.larus.search.api.model.SchemaSuffixMap;
import com.larus.search.impl.databinding.LarusSearchWebBrowserBinding;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.skydoves.balloon.Balloon;
import com.ss.android.lark.chameleon.WebMediaPermissionResources;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.ttvideoengine.selector.strategy.GearStrategy;
import com.ttnet.org.chromium.net.NetError;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u0084\u00012\u00020\u0001:\u0002\u0084\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010/J\u0012\u0010E\u001a\u00020C2\b\u0010F\u001a\u0004\u0018\u00010GH\u0016J\u0012\u0010H\u001a\u00020\u001b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010I\u001a\u00020CH\u0002J\u001c\u0010J\u001a\u00020C2\u0006\u0010K\u001a\u00020\u000b2\n\b\u0002\u0010L\u001a\u0004\u0018\u00010MH\u0002J\u0010\u0010N\u001a\u00020\u001b2\u0006\u0010O\u001a\u00020PH\u0002J\u0010\u0010Q\u001a\u00020C2\u0006\u0010R\u001a\u00020\u001bH\u0002J\u0012\u0010S\u001a\u0004\u0018\u00010\u000b2\u0006\u0010T\u001a\u00020\u000bH\u0002J\u0012\u0010U\u001a\u00020C2\b\u0010V\u001a\u0004\u0018\u000108H\u0002J&\u0010W\u001a\u0004\u0018\u00010\u00192\u0006\u0010X\u001a\u00020Y2\b\u0010Z\u001a\u0004\u0018\u00010[2\b\u0010F\u001a\u0004\u0018\u00010GH\u0016J\u001a\u0010\\\u001a\u00020C2\u0006\u0010]\u001a\u00020\u00192\b\u0010F\u001a\u0004\u0018\u00010GH\u0016J\n\u0010^\u001a\u0004\u0018\u00010\rH\u0002J\u001c\u0010_\u001a\u00020C2\b\u0010]\u001a\u0004\u0018\u00010\u00192\b\u0010`\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010a\u001a\u00020C2\u0006\u0010b\u001a\u00020\u001bH\u0002J\b\u0010c\u001a\u00020CH\u0002J\b\u0010d\u001a\u00020CH\u0002J\b\u0010e\u001a\u00020\u001bH\u0002J\b\u0010f\u001a\u00020CH\u0002J\b\u0010g\u001a\u00020CH\u0002J\b\u0010h\u001a\u00020iH\u0002J\b\u0010j\u001a\u00020CH\u0002J\u0012\u0010k\u001a\u00020C2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010l\u001a\u00020CH\u0002J\u0010\u0010m\u001a\u00020\u001b2\u0006\u0010\u000e\u001a\u00020\u000bH\u0002J\u0012\u0010n\u001a\u00020\u001b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010o\u001a\u00020CH\u0002J\b\u0010p\u001a\u00020CH\u0002J\b\u0010q\u001a\u00020CH\u0002J\b\u0010r\u001a\u00020CH\u0016J\b\u0010s\u001a\u00020CH\u0016J\b\u0010t\u001a\u00020CH\u0016J&\u0010u\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b01H\u0002J\u0012\u0010w\u001a\u00020\u001b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0002J&\u0010x\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b01H\u0002J\f\u0010y\u001a\u00020z*\u00020zH\u0002J2\u0010{\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b01H\u0002J&\u0010|\u001a\u00020\u001b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b01H\u0002J\u000e\u0010}\u001a\u00020\u001b*\u0004\u0018\u00010\u000bH\u0002J\b\u0010~\u001a\u00020CH\u0016J\u0006\u0010\u007f\u001a\u00020CJ\u001b\u0010\u0080\u0001\u001a\u00020C2\u0007\u0010\u0081\u0001\u001a\u00020\u000b2\u0007\u0010\u0082\u0001\u001a\u00020MH\u0016J\u000b\u0010\u0083\u0001\u001a\u0004\u0018\u00010AH\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0004\n\u0002\u0010 R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u001b01X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u00102\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020504\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010<\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u0010\t\u001a\u0004\b=\u0010>R\u0010\u0010@\u001a\u0004\u0018\u00010AX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0085\u0001"}, d2 = {"Lcom/larus/search/impl/WebFragment;", "Lcom/larus/platform/model/webview/AbsWebFragment;", "<init>", "()V", "localFileTaker", "Lcom/larus/search/impl/LocalFileTaker;", "getLocalFileTaker", "()Lcom/larus/search/impl/LocalFileTaker;", "localFileTaker$delegate", "Lkotlin/Lazy;", "schema", "", "binding", "Lcom/larus/search/impl/databinding/LarusSearchWebBrowserBinding;", "url", "schemeTitle", "morePopup", "Lcom/skydoves/balloon/Balloon;", "trace", "Lcom/larus/platform/api/IPageLoadTrace;", "ivyWebViewClient", "Lcom/ivy/ivykit/api/plugin/web/IvyWebClient;", "ivyWebView", "Lcom/ivy/ivykit/api/plugin/render/WebViewPluginView;", "webViewClientCustomView", "Landroid/view/View;", "isCurrentFullScreen", "", "originalPaddingTop", "", "originalPaddingBottom", "originalRequestedOrientation", "Ljava/lang/Integer;", "hybridEventParams", "Lcom/larus/search/api/event/HybridEventParams;", "onCreateTimeStamp", "", "isNotFullPage", "isShowProgressBar", "isShowCenterProgressBar", "disableGoForwardAndBack", "isNeedSchemaPremix", "schemaSuffix", "Lcom/larus/search/api/model/SchemaSuffixMap;", "enterLoadingDialog", "Lcom/larus/common_ui/dialog/CommonLoadDialogFragment;", "webViewProxyCallback", "Lcom/larus/bmhome/web/IWebViewProxyCallback;", "haveAgreeRequestPermission", "", "fileChooserCallback", "Landroid/webkit/ValueCallback;", "", "Landroid/net/Uri;", "fileChooserResultDelivered", "pendingPermissionRequest", "Lcom/ivy/ivykit/api/plugin/callback/IIvyPermissionRequest;", "needTrace", "needLarkAuthCookieSync", "hasTraced", "enableAddingFragmentQueryCompact", "getEnableAddingFragmentQueryCompact", "()Z", "enableAddingFragmentQueryCompact$delegate", "preloadContextWrapper", "Landroid/content/MutableContextWrapper;", "setInterceptWebViewScrollCallback", "", "interceptWebViewScrollCallback", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", "tryOpenOfficePreviewUrl", "ensureSDKInit", "doWhenReceivedError", "scene", "eventExtraInfo", "Lorg/json/JSONObject;", "isUriIntentValid", "intent", "Landroid/content/Intent;", "handleFullScreen", "isFullScreen", "transformManifestToPermissionName", ErrorType.MANIFEST, "createRequestPermissionDialog", "request", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "initTitle", "innerSetViewColor", "rawColor", "handleTransStatusBar", "transParent", "initBottomBar", "tryShowLoading", "enableBottomShareStyle", "forwardWebPage", "doRefresh", "getWebViewContext", "Landroid/content/Context;", "createHybridKit", "interceptLoadIvykit", "setWebViewBgColor", "notUseForest", "isDomStorageEnabled", "backWebPage", "refreshCloseAllButton", "refreshBottomBar", "onResume", "onDestroyView", LiveCommonConstants.REASON_ON_DEDTROY, "addCommonQuery", "requestHeaders", "needsAddCommonQueryCompact", "addCommonQueryCompact", "addThemeQuery", "Landroid/net/Uri$Builder;", "addCommonHeaders", "checkWhiteList", "urlCheck", "onPause", "onBackPressed", "sendEvent", "name", "params", "getPreloadContextWrapper", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WebFragment extends AbsWebFragment {
    public static final HashMap<String, String> K = null;
    public zt8.c A;
    public final Map<String, Boolean> B;
    public ValueCallback<Uri[]> C;
    public boolean D;
    public ix7.a E;
    public boolean F;
    public boolean G;
    public boolean H;
    public final Lazy I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public MutableContextWrapper f367429J;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f367430d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f367431e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LarusSearchWebBrowserBinding f367432f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f367433g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f367434h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Balloon f367435i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final e1 f367436j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public lx7.a f367437k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public kx7.c f367438l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View f367439m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f367440n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f367441o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f367442p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Integer f367443q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public HybridEventParams f367444r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f367445s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f367446t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f367447u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f367448v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f367449w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f367450x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public SchemaSuffixMap f367451y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public CommonLoadDialogFragment f367452z;

    public static final class a {
    }

    public static final class b implements com.larus.common_ui.dialog.p0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WebFragment f367453a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List<String> f367454b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f367455c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ix7.a f367456d;

        @Override // com.larus.common_ui.dialog.p0
        public final void confirm() {
            i2 r100 = i2.f365748b;
            final WebFragment r101 = this.f367453a;
            List<String> r102 = this.f367454b;
            final String r103 = this.f367455c;
            final ix7.a r104 = this.f367456d;
            i2.q(r101, r102, new y0(r101, r103, r104));
        }

        public b(WebFragment r100, List<String> r101, String r102, ix7.a r103) {
            this.f367453a = r100;
            this.f367454b = r101;
            this.f367455c = r102;
            this.f367456d = r103;
        }
    }

    public static final class c implements com.larus.common_ui.dialog.u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WebFragment f367457a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f367458b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ix7.a f367459c;

        @Override // com.larus.common_ui.dialog.u
        public final void cancel() {
            this.f367457a.B.put(this.f367458b, Boolean.FALSE);
            ix7.a r100 = this.f367459c;
            if (r100 == null) goto L6;
            r100.a();
            return;
        }

        public c(WebFragment r100, String r101, ix7.a r102) {
            this.f367457a = r100;
            this.f367458b = r101;
            this.f367459c = r102;
        }
    }

    public static final class d implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f367460a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LinearLayout f367461b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f367462c;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r110) {
            this.f367460a.removeOnAttachStateChangeListener(this);
            WindowInsetsCompat r111 = ViewCompat.getRootWindowInsets(this.f367461b);
            if (r111 == null) goto L7;
            Insets r112 = r111.getInsets(WindowInsetsCompat.Type.navigationBars());
            if (r112 == null) goto L7;
            int r113 = r112.bottom;
        L8:
            WindowInsetsCompat r100 = ViewCompat.getRootWindowInsets(this.f367461b);
            if (r100 == null) goto L13;
            Insets r101 = r100.getInsets(WindowInsetsCompat.Type.statusBars());
            if (r101 == null) goto L13;
            int r102 = r101.top;
        L15:
            if (this.f367462c == false) goto L17;
            LinearLayout r103 = this.f367461b;
            int r104 = r103.getPaddingStart();
            int r105 = r103.getPaddingEnd();
            FLogger.f375446a.i("updatePaddingRelative", "view:" + r103.getClass().getSimpleName() + ",source:onWebViewCreated,start:" + r104 + ",top:0,end:" + r105 + ",bottom:" + r113);
            r103.setPaddingRelative(r104, 0, r105, r113);
            return;
        L17:
            LinearLayout r106 = this.f367461b;
            int r107 = r106.getPaddingStart();
            int r108 = r106.getPaddingEnd();
            FLogger.f375446a.i("updatePaddingRelative", "view:" + r106.getClass().getSimpleName() + ",source:onWebViewCreated,start:" + r107 + ",top:" + r102 + ",end:" + r108 + ",bottom:" + r113);
            r106.setPaddingRelative(r107, r102, r108, r113);
            return;
        L13:
            r102 = 0;
        L7:
            r113 = 0;
            goto L8
        }

        public d(View r100, LinearLayout r101, boolean r102) {
            this.f367460a = r100;
            this.f367461b = r101;
            this.f367462c = r102;
        }
    }

    public static final class e implements ix7.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f367463a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ WebFragment f367464b;

        @Override // ix7.e
        public final void h(String r100, int r101, String r102) {
        }

        @Override // ix7.e
        public final void f() {
            WebFragment r100 = this.f367464b;
            HashMap<String, String> r101 = WebFragment.K;
            r100.da0(false);
            WebFragment r102 = this.f367464b;
            View r103 = r102.f367439m;
            if (r103 != null) goto L5;
            return;
        L5:
            LarusSearchWebBrowserBinding r104 = r102.f367432f;
            if (r104 == null) goto L10;
            FrameLayout r105 = r104.f367635a;
            if (r105 == null) goto L10;
            r105.removeView(r103);
        L10:
            this.f367464b.f367439m = null;
        }

        public e(WebFragment r100) {
            this.f367464b = r100;
        }

        @Override // ix7.e
        public final void b(SslError r100) {
            FLogger.f375446a.w("WebFragment", "onReceivedSslError " + r100 + " url:" + this.f367464b.f367433g);
            WebFragment r101 = this.f367464b;
            JSONObject r102 = new JSONObject();
            if (r100 == null) goto L5;
            String r103 = r100.toString();
        L6:
            r102.put("error", r103);
            Unit r104 = Unit.INSTANCE;
            WebFragment.U90(r101, "onReceivedSslError", r102);
            return;
        L5:
            r103 = null;
            goto L6
        }

        @Override // ix7.e
        public final lx7.b c(lx7.b r110) {
            Intrinsics.checkNotNullParameter(r110, "before");
            WebFragment r100 = this.f367464b;
            String r101 = r110.f511231a;
            Map<String, String> r102 = r110.f511232b;
            Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.String>");
            Map<String, String> r111 = TypeIntrinsics.asMutableMap(r102);
            boolean r112 = true;
            if (((Boolean) r100.I.getValue()).booleanValue() == false) goto L16;
            if (r101 != null) goto L6;
        L9:
            boolean r103 = true;
        L10:
            if (r103 == true) goto L16;
            int r104 = StringsKt.indexOf$default(r101, "#", 0, false, 6, null);
            int r105 = StringsKt.indexOf$default(r101, "?", 0, false, 6, null);
            if (r104 <= 0) goto L16;
            if (r105 <= r104) goto L16;
            boolean r106 = true;
        L17:
            String r107 = "";
            if (r106 == false) goto L40;
            if (r101 != null) goto L21;
            String r108 = "";
        L47:
            WebFragment r109 = this.f367464b;
            String r113 = r110.f511231a;
            Map<String, String> r114 = r110.f511232b;
            Intrinsics.checkNotNull(r114, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.String>");
            Map<String, String> r115 = TypeIntrinsics.asMutableMap(r114);
            if (r109.X90(r113, r115) == false) goto L72;
            FLogger.f375446a.i("WebFragment", "addCommonHeaders: called, in whitelist");
            Function0<String> r116 = SearchServiceImpl.f367426a.f547422a;
            if (r116 == null) goto L55;
            String r117 = r116.invoke();
            if (r117 == null) goto L55;
            r107 = r117;
        L55:
            r115.put("x-tt-token", r107);
            if (HttpExtKt.e().f360166a == false) goto L64;
            r115.put(ByteNetEnvHeaderName.BOE, "1");
            if (HttpExtKt.e().f360167b.length() > 0) goto L61;
            r112 = false;
        L61:
            if (r112 == false) goto L72;
            r115.put("x-tt-env", HttpExtKt.e().f360167b);
            goto L72
        L64:
            if (HttpExtKt.e().f360168c == false) goto L72;
            r115.put(ByteNetEnvHeaderName.PPE, "1");
            if (HttpExtKt.e().f360169d.length() > 0) goto L69;
            r112 = false;
        L69:
            if (r112 == false) goto L72;
            r115.put("x-tt-env", HttpExtKt.e().f360169d);
        L72:
            if (AppHost.f326268a.isDebug() == false) goto L79;
            Iterator<Map.Entry<String, String>> r118 = r115.entrySet().iterator();
            String r119 = "addCommonHeaders: called, headers: ";
        L75:
            if (r118.hasNext() == false) goto L77;
            Map.Entry<String, String> r120 = r118.next();
            r119 = r119 + r120.getKey() + " = " + r120.getValue() + '\n';
            goto L75
        L77:
            FLogger.f375446a.d("WebFragment", r119);
        L79:
            return new lx7.b(r108, r115);
        L21:
            boolean r121 = v19.h.f552477a;
            Context r122 = r100.getContext();
            if (r122 != null) goto L25;
            r122 = AppHost.f326268a.getApplication();
        L25:
            if (v19.h.b(r122) == false) goto L27;
            String r123 = "dark";
        L28:
            String r124 = "?";
            if (StringsKt.contains$default(r101, "?", false, 2, null) == false) goto L32;
            r124 = "&";
        L32:
            if (r100.X90(r101, r111) == true) goto L34;
            r108 = r101 + r124 + "theme=" + r123;
            FLogger.f375446a.i("WebFragment", "addCommonQueryCompact: called, not in white list, result uri = " + r108);
            goto L47
        L34:
            if (HttpExtKt.e().f360166a == false) goto L36;
            String r125 = b2.f364870a.o();
        L37:
            r108 = r101 + r124 + "is_inapp=1&api_host=" + r125 + "&theme=" + r123;
            FLogger.f375446a.i("WebFragment", "addCommonQueryCompact: called, result = " + r108);
            goto L47
        L36:
            r125 = b2.f364870a.h();
            goto L37
        L27:
            r123 = "light";
            goto L28
        L40:
            if (r100.X90(r101, r111) == false) goto L46;
            Uri.Builder r126 = UriProtector.parse(r101).buildUpon().appendQueryParameter("is_inapp", "1");
            if (HttpExtKt.e().f360166a == false) goto L44;
            String r127 = b2.f364870a.o();
        L45:
            Uri r128 = r100.V90(r126.appendQueryParameter("api_host", r127)).build();
            FLogger.f375446a.i("WebFragment", "addCommonQuery: called, result uri = " + r128);
            r108 = r128.toString();
            Intrinsics.checkNotNull(r108);
            goto L47
        L44:
            r127 = b2.f364870a.h();
            goto L45
        L46:
            Uri r129 = r100.V90(UriProtector.parse(r101).buildUpon()).build();
            FLogger.f375446a.i("WebFragment", "addCommonQuery: called, not in white list, result uri = " + r129);
            r108 = r129.toString();
            Intrinsics.checkNotNull(r108);
            goto L47
        L6:
            if (r101.length() == 0) goto L9;
            r103 = false;
        L16:
            r106 = false;
            goto L17
        }

        @Override // ix7.e
        public final boolean d(com.ivy.ivykit.plugin.impl.web.b r110) {
            if (r110 == null) goto L4;
            String[] r100 = r110.getResources();
        L5:
            FLogger r111 = FLogger.f375446a;
            if (r100 == null) goto L9;
            String r101 = ArraysKt.joinToString$default(r100, null, null, null, 0, null, null, 63, null);
            if (r101 == null) goto L9;
        L10:
            r111.i("WebFragment", "onRequestPermission resources=".concat(r101));
            int r102 = 0;
            if (r100 != null) goto L13;
        L19:
            boolean r103 = true;
        L20:
            if (r103 == false) goto L25;
            r111.w("WebFragment", "onRequestPermission: empty resources, deny");
            if (r110 == null) goto L24;
            r110.a();
        L24:
            return true;
        L25:
            ArrayList r104 = new ArrayList();
            int r105 = r100.length;
        L26:
            if (r102 >= r105) goto L32;
            String r106 = WebFragment.K.get(r100[r102]);
            if (r106 == null) goto L30;
            r104.add(r106);
        L30:
            r102 = r102 + 1;
            goto L26
        L32:
            if (CollectionsKt.distinct(r104).isEmpty() == false) goto L36;
            FLogger.f375446a.w("WebFragment", "onRequestPermission: unsupported resources: " + ArraysKt.joinToString$default(r100, null, null, null, 0, null, null, 63, null));
            r110.a();
            return true;
        L36:
            if (this.f367464b.isAdded() == true) goto L40;
            FLogger.f375446a.w("WebFragment", "onRequestPermission: fragment not attached, deny");
            r110.a();
            return true;
        L40:
            if (this.f367464b.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED) == true) goto L42;
        L46:
            FLogger.f375446a.w("WebFragment", "onRequestPermission: not resumed or state saved, postpone");
            this.f367464b.E = r110;
            return true;
        L42:
            if (this.f367464b.getChildFragmentManager().isStateSaved() == true) goto L46;
            WebFragment r107 = this.f367464b;
            HashMap<String, String> r108 = WebFragment.K;
            r107.Z90(r110);
            return true;
        L13:
            if (r100.length != 0) goto L15;
            boolean r109 = true;
        L16:
            if (r109 == true) goto L19;
            r103 = false;
            goto L20
        L15:
            r109 = false;
        L9:
            r101 = "null";
            goto L10
        L4:
            r100 = null;
            goto L5
        }

        @Override // ix7.e
        public final void e(View r100) {
            WebFragment r101 = this.f367464b;
            if (r100 != null) goto L5;
            return;
        L5:
            r101.f367439m = r100;
            r101.da0(true);
            LarusSearchWebBrowserBinding r102 = this.f367464b.f367432f;
            if (r102 == null) goto L11;
            FrameLayout r103 = r102.f367635a;
            if (r103 == null) goto L12;
            r103.addView(r100, new ViewGroup.LayoutParams(-1, -1));
            return;
        L12:
            return;
        }

        @Override // ix7.e
        public final void onPageStarted(String r100) {
            FLogger.f375446a.i("WebFragment", "onPageStarted url:" + r100);
            this.f367463a = r100;
            WebFragment r101 = this.f367464b;
            HashMap<String, String> r102 = WebFragment.K;
            r101.ja0();
            this.f367464b.ia0();
        }

        /* JADX WARN: Type inference failed for: r10v0, types: [com.larus.search.impl.z] */
        /* JADX WARN: Type inference failed for: r15v0, types: [com.larus.search.impl.y] */
        /* JADX WARN: Type inference failed for: r6v0, types: [com.larus.search.impl.a1, java.lang.Object] */
        @Override // ix7.e
        public final boolean g(WebView r110, ValueCallback r111) {
            WebFragment r100 = this.f367464b;
            if (r100.D == true) goto L7;
            ValueCallback<Uri[]> r101 = r100.C;
            if (r101 == null) goto L7;
            r101.onReceiveValue(null);
        L7:
            WebFragment r102 = this.f367464b;
            r102.C = r111;
            r102.D = false;
            if (r110 == null) goto L10;
            String r103 = r110.getUrl();
        L11:
            String r104 = "";
            if (r103 != null) goto L14;
            r103 = "";
        L14:
            Uri r105 = UriProtector.parse(r103);
            final a0 r106 = (a0) this.f367464b.f367430d.getValue();
            String r107 = r105.getHost();
            if (r107 != null) goto L17;
            r107 = "";
        L17:
            final WebFragment r108 = this.f367464b;
            final ?? r109 = new a1(r108);
            r106.getClass();
            Intrinsics.checkNotNullParameter(r107, "originUri");
            Intrinsics.checkNotNullParameter(r108, WidgetService.PARAM_FRAGMENT);
            Intrinsics.checkNotNullParameter(r109, "onFail");
            if (Build.VERSION.SDK_INT >= 33) goto L54;
            FragmentManager r112 = r108.requireFragmentManager();
            Context r113 = r108.requireContext();
            ?? r114 = new y(r109);
            ?? r115 = new z(r106);
            if (r113 == null) goto L22;
            String r116 = r113.getString(R.string.larus_building_artifacts_folder_cn);
        L23:
            if (r116 != null) goto L25;
            r116 = "";
        L25:
            if (r113 == null) goto L27;
            String r117 = r113.getString(R.string.larus_building_artifacts_permission_request_cn, new Object[]{r107, r116});
        L28:
            String r118 = r107.concat("_android.permission.READ_EXTERNAL_STORAGE");
            if (i2.f365748b.d("android.permission.READ_EXTERNAL_STORAGE") == true) goto L31;
        L33:
            boolean r119 = false;
        L34:
            if (r119 == false) goto L37;
            r115.invoke();
        L36:
            return true;
        L37:
            CommonDialog.a r120 = new CommonDialog.a();
            if (r117 == null) goto L41;
            r104 = r117;
        L41:
            Intrinsics.checkNotNullParameter(r104, "message");
            r120.f327180i = r104;
            c0 r121 = new c0(r108, r106, r118, r115, r114);
            if (r113 == null) goto L44;
            String r122 = r113.getString(R.string.larus_confirm_pin_btn);
        L45:
            CommonDialog.a.f(r120, r121, r122, false, 12);
            d0 r123 = new d0(r106, r118, r114);
            if (r113 == null) goto L48;
            String r124 = r113.getString(R.string.larus_update_cancel_cn);
        L49:
            CommonDialog.a.e(r120, r123, r124, 4);
            CommonDialog r125 = r120.a();
            LandscapeRestrictionOperation r126 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r125, null, r126);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r112, r125, r126) == true) goto L36;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L56
        L53:
            r125.show(r112, null);
            goto L36
        L48:
            r124 = null;
            goto L49
        L44:
            r122 = null;
            goto L45
        L31:
            if (Intrinsics.areEqual(((LinkedHashMap) r106.f367469b).get(r118), Boolean.TRUE) == false) goto L33;
            r119 = true;
            goto L34
        L27:
            r117 = null;
            goto L28
        L22:
            r116 = null;
            goto L23
        L54:
            r106.a(true, true, false, true);
            return true;
        L10:
            r103 = null;
            goto L11
        }

        @Override // ix7.e
        public final void i(WebView r100, int r101) {
            FLogger.f375446a.i("WebFragment", "onProgressChanged newProgress:" + r101);
            WebFragment r102 = this.f367464b;
            HashMap<String, String> r103 = WebFragment.K;
            r102.ja0();
            if (r101 != 100) goto L24;
            LarusSearchWebBrowserBinding r104 = this.f367464b.f367432f;
            if (r104 == null) goto L9;
            ProgressBar r105 = r104.f367648n;
            if (r105 == null) goto L9;
            r105.setVisibility(4);
        L9:
            LarusSearchWebBrowserBinding r106 = this.f367464b.f367432f;
            if (r106 == null) goto L14;
            ProgressBar r107 = r106.f367648n;
            if (r107 == null) goto L14;
            r107.setProgress(0);
        L14:
            LarusSearchWebBrowserBinding r108 = this.f367464b.f367432f;
            if (r108 == null) goto L19;
            ProgressBar r109 = r108.f367643i;
            if (r109 == null) goto L19;
            r109.setVisibility(4);
        L19:
            LarusSearchWebBrowserBinding r110 = this.f367464b.f367432f;
            if (r110 == null) goto L71;
            ProgressBar r111 = r110.f367643i;
            if (r111 == null) goto L72;
            r111.setProgress(0);
            return;
        L72:
            return;
        L71:
            return;
        L24:
            WebFragment r112 = this.f367464b;
            if (r112.f367447u == false) goto L31;
            LarusSearchWebBrowserBinding r113 = r112.f367432f;
            if (r113 == null) goto L36;
            ProgressBar r114 = r113.f367648n;
            if (r114 == null) goto L36;
            r114.setVisibility(0);
        L36:
            WebFragment r115 = this.f367464b;
            if (r115.f367448v == false) goto L43;
            LarusSearchWebBrowserBinding r116 = r115.f367432f;
            if (r116 == null) goto L49;
            ProgressBar r117 = r116.f367643i;
            if (r117 == null) goto L49;
            r117.setVisibility(0);
        L49:
            if (Build.VERSION.SDK_INT < 24) goto L60;
            LarusSearchWebBrowserBinding r118 = this.f367464b.f367432f;
            if (r118 == null) goto L55;
            ProgressBar r119 = r118.f367648n;
            if (r119 == null) goto L55;
            r119.setProgress(r101, true);
        L55:
            LarusSearchWebBrowserBinding r120 = this.f367464b.f367432f;
            if (r120 == null) goto L74;
            ProgressBar r121 = r120.f367643i;
            if (r121 == null) goto L75;
            r121.setProgress(r101, true);
            return;
        L75:
            return;
        L74:
            return;
        L60:
            LarusSearchWebBrowserBinding r122 = this.f367464b.f367432f;
            if (r122 == null) goto L65;
            ProgressBar r123 = r122.f367648n;
            if (r123 == null) goto L65;
            r123.setProgress(r101);
        L65:
            LarusSearchWebBrowserBinding r124 = this.f367464b.f367432f;
            if (r124 == null) goto L77;
            ProgressBar r125 = r124.f367643i;
            if (r125 == null) goto L78;
            r125.setProgress(r101);
            return;
        L78:
            return;
        L77:
            return;
        L43:
            LarusSearchWebBrowserBinding r126 = r115.f367432f;
            if (r126 == null) goto L49;
            ProgressBar r127 = r126.f367643i;
            if (r127 == null) goto L49;
            r127.setVisibility(8);
            goto L49
        L31:
            LarusSearchWebBrowserBinding r128 = r112.f367432f;
            if (r128 == null) goto L36;
            ProgressBar r129 = r128.f367648n;
            if (r129 == null) goto L36;
            r129.setVisibility(8);
            goto L36
        }

        @Override // ix7.e
        public final boolean j(WebView r100, com.ivy.ivykit.plugin.impl.web.c r101) {
            if (r101 != null) goto L5;
        L7:
            boolean r102 = false;
        L8:
            if (r102 == false) goto L10;
            String r103 = "crashed";
        L11:
            FLogger r104 = FLogger.f375446a;
            StringBuilder r105 = new StringBuilder("Render process ");
            r105.append(r103);
            r105.append(". WebView URL: ");
            if (r100 == null) goto L14;
            String r106 = r100.getUrl();
        L15:
            r105.append(r106);
            r104.e("WebFragment", r105.toString());
            return true;
        L14:
            r106 = null;
            goto L15
        L10:
            r103 = "killed by system";
            goto L11
        L5:
            if (r101.a() != true) goto L7;
            r102 = true;
            goto L8
        }

        @Override // ix7.e
        public final void k(WebResourceRequest r100, WebResourceError r101) {
            JSONObject r102 = new JSONObject();
            if (Build.VERSION.SDK_INT < 23) goto L20;
            FLogger r103 = FLogger.f375446a;
            StringBuilder r104 = new StringBuilder("onReceivedErrorV2 code:");
            CharSequence r105 = null;
            if (r101 == null) goto L7;
            Integer r106 = Integer.valueOf(r101.getErrorCode());
        L8:
            r104.append(r106);
            r104.append(" desc:");
            if (r101 == null) goto L11;
            CharSequence r107 = r101.getDescription();
        L12:
            r104.append(r107);
            r104.append(" url:");
            r104.append(this.f367464b.f367433g);
            r103.w("WebFragment", r104.toString());
            if (r101 == null) goto L15;
            Integer r108 = Integer.valueOf(r101.getErrorCode());
        L16:
            r102.put("error_code", r108);
            if (r101 == null) goto L19;
            r105 = r101.getDescription();
        L19:
            r102.put(GearStrategy.GEAR_STRATEGY_KEY_ERROR_DESC, r105);
        L21:
            WebFragment r109 = this.f367464b;
            HashMap<String, String> r110 = WebFragment.K;
            r109.ia0();
            if (r100 == null) goto L26;
            boolean r111 = true;
            if (r100.isForMainFrame() != true) goto L26;
        L27:
            if (r111 == false) goto L30;
            WebFragment.U90(this.f367464b, "onReceivedErrorV2", r102);
            return;
        L30:
            return;
        L26:
            r111 = false;
            goto L27
        L15:
            r108 = null;
            goto L16
        L11:
            r107 = null;
            goto L12
        L7:
            r106 = null;
            goto L8
        L20:
            FLogger.f375446a.w("WebFragment", "onReceivedErrorV2 " + r101 + " url:" + this.f367464b.f367433g);
            goto L21
        }

        @Override // ix7.e
        public final void onPageFinished(WebView r100, String r101) {
            FLogger.f375446a.i("WebFragment", "onPageFinished url:" + r101);
            WebFragment r102 = this.f367464b;
            HashMap<String, String> r103 = WebFragment.K;
            r102.ja0();
            LarusSearchWebBrowserBinding r104 = this.f367464b.f367432f;
            if (r104 == null) goto L7;
            ProgressBar r105 = r104.f367648n;
            if (r105 == null) goto L7;
            r105.setVisibility(4);
        L7:
            e1 r106 = this.f367464b.f367436j;
            if (r106 == null) goto L10;
            r106.b("load");
        L10:
            e1 r107 = this.f367464b.f367436j;
            if (r107 == null) goto L13;
            r107.a(1);
        L13:
            HybridEventParams r108 = this.f367464b.f367444r;
            if (r108 == null) goto L16;
            boolean r109 = Intrinsics.areEqual(r108.f367383e, Boolean.TRUE);
        L17:
            if (r109 == false) goto L22;
            int r110 = vs9.a.f557113a;
            vs9.a.b(r101, true, this.f367464b.f367444r);
            HybridEventParams r111 = this.f367464b.f367444r;
            if (r111 == null) goto L23;
            r111.f367383e = Boolean.FALSE;
            return;
        L23:
            return;
        L22:
            return;
        L16:
            r109 = false;
            goto L17
        }

        @Override // ix7.e
        public final void onReceivedTitle(WebView r100, String r101) {
            String r102 = this.f367464b.f367434h;
            FLogger.f375446a.i("WebFragment", "onReceivedTitle title:" + r101 + ", schemeTitle: " + r102);
            LarusSearchWebBrowserBinding r103 = this.f367464b.f367432f;
            if (r103 == null) goto L17;
            TextView r104 = r103.f367651q;
            if (r104 == null) goto L18;
            if (r102 != null) goto L15;
            if (r100 == null) goto L10;
            String r105 = r100.getTitle();
        L11:
            r102 = r105;
            if (r102 != null) goto L15;
            r102 = "";
            goto L15
        L10:
            r105 = null;
        L15:
            r104.setText(r102);
            return;
        L18:
            return;
        }

        @Override // ix7.e
        public final boolean shouldOverrideUrlLoading(WebView r110, String r111) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(r110, true);
            WebFragment r112 = this.f367464b;
            HashMap<String, String> r100 = WebFragment.K;
            if (r111 == null) goto L7;
            r112.getClass();
            if (StringsKt.startsWith(r111, "https://", true) == false) goto L7;
            String r101 = r111;
        L8:
            Bundle r102 = r112.getArguments();
            if (r102 != null) goto L11;
        L13:
            boolean r103 = false;
        L14:
            z2 r104 = z2.f365865a;
            if (r104.getLarkBitableConfig().b() == false) goto L27;
            if (r103 == true) goto L27;
            if (r101 == null) goto L27;
            IFlowSdkDepend r105 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r105 == null) goto L23;
            r105.D();
            if (x1.f346268a.j(r101) != true) goto L23;
            boolean r106 = true;
        L24:
            if (r106 == false) goto L27;
            com.bytedance.router.i r113 = SmartRouter.buildRoute(r112.getContext(), "//flow/webview");
            Bundle r107 = new Bundle();
            r107.putString("link_url", r101);
            r113.f267554c.putExtras(r107);
            r113.d();
            boolean r114 = true;
        L28:
            if (r114 == false) goto L30;
            return true;
        L30:
            Intrinsics.checkNotNull(r111);
            if (StringsKt.startsWith$default(r111, "http", false, 2, null) == false) goto L51;
            return false;
        L51:
            Uri r115 = UriProtector.parse(r111);     // Catch: Exception -> L47
            FLogger.f375446a.i("WebFragment", "shouldOverrideUrlLoading http url:" + r111 + ", host = " + this.f367464b.getHost());     // Catch: Exception -> L47
            int r108 = com.larus.utils.k0.f375428a;     // Catch: Exception -> L47
            if (Intrinsics.areEqual("//flow/open_browser", com.larus.utils.k0.a(r115.toString())) == false) goto L37;
            SmartRouter.buildRoute(this.f367464b.getContext(), r115.toString()).d();     // Catch: Exception -> L47
        L49:
            return true;
        L37:
            if (StringsKt.startsWith$default(r111, "intent", false, 2, null) == false) goto L45;
            Intent r116 = Intent.parseUri(r111, 1);     // Catch: Exception -> L47
            r116.setFlags(r116.getFlags() & NetError.ERR_TTNET_UNSUPPORTED_REDIRECT);     // Catch: Exception -> L47
            WebFragment r109 = this.f367464b;     // Catch: Exception -> L47
            Intrinsics.checkNotNull(r116);     // Catch: Exception -> L47
            r109.getClass();     // Catch: Exception -> L47
            if (Intrinsics.areEqual(r116.getAction(), CommonConstant.ACTION.HWID_SCHEME_URL) == true) goto L41;
            boolean r117 = false;
        L42:
            if (r117 == false) goto L44;
            this.f367464b.requireActivity().startActivity(r116);     // Catch: Exception -> L47
            goto L49
        L44:
            return false;
        L41:
            r117 = CollectionsKt.contains(r104.f3(), r116.getPackage());     // Catch: Exception -> L47
            goto L42
        L45:
            Intent r118 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, r115);     // Catch: Exception -> L47
            r118.setFlags(805306368);     // Catch: Exception -> L47
            this.f367464b.requireActivity().startActivity(r118);     // Catch: Exception -> L47
        L47:
            e = move-exception;
            FLogger.f375446a.w("WebFragment", "shouldOverrideUrlLoading http url:" + r111, e);
        L23:
            r106 = false;
        L27:
            r114 = false;
            goto L28
        L11:
            if (r102.getBoolean("bundle_skip_office_sdk_route", false) != true) goto L13;
            r103 = true;
        L7:
            r101 = null;
            goto L8
        }

        @Override // ix7.e
        public final void a(int r100, String r101, String r102) {
            FLogger.f375446a.w("WebFragment", "onReceivedErrorV1 code:" + r100 + " desc:" + r101 + " url:" + r102);
            if (Intrinsics.areEqual(r102, this.f367463a) == false) goto L6;
            WebFragment r103 = this.f367464b;
            JSONObject r104 = new JSONObject();
            r104.put("error_code", r100);
            r104.put(GearStrategy.GEAR_STRATEGY_KEY_ERROR_DESC, r101);
            Unit r105 = Unit.INSTANCE;
            WebFragment.U90(r103, "onReceivedErrorV1", r104);
            return;
        }
    }

    public static final class f extends ix7.d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WebFragment f367465a;

        public f(WebFragment r100) {
            this.f367465a = r100;
        }

        @Override // ix7.d.a, ix7.d
        public final void d(View r110) {
            Intrinsics.checkNotNullParameter(r110, "view");
            Intrinsics.checkNotNullParameter(r110, "view");
            if ((r110 instanceof WebView) == true) goto L6;
            r110 = null;
        L6:
            Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type android.webkit.WebView");
            WebView r111 = (WebView) r110;
            final WebFragment r100 = this.f367465a;
            zt8.c r101 = r100.A;
            if (r101 == null) goto L9;
            r101.c(r111);
        L9:
            boolean r102 = StringsKt.equals(UriProtector.parse(r100.f367433g).getScheme(), "file", true);
            boolean r103 = StringsKt.equals(UriProtector.parse(r100.f367433g).getScheme(), "content", true);
            r111.getSettings().setAllowFileAccess(true);
            WebSettings r104 = r111.getSettings();
            boolean r105 = false;
            if (r102 == true) goto L13;
            if (r103 == true) goto L13;
            boolean r106 = true;
        L14:
            r104.setJavaScriptEnabled(r106);
            WebSettings r107 = r111.getSettings();
            String r108 = r100.f367433g;
            if (r108 == null) goto L32;
            Uri r109 = UriProtector.parse(r108);
            if (r109 == null) goto L32;
            String r112 = r109.getHost();
            if (r112 == null) goto L32;
            Function0<List<String>> r113 = SearchServiceImpl.f367426a.f547423b;
            if (r113 == null) goto L32;
            List<String> r114 = r113.invoke();
            if (r114 == null) goto L32;
            Iterator<T> r115 = r114.iterator();
        L28:
            if (r115.hasNext() == false) goto L32;
            if (StringsKt.contains$default(r112, (String) r115.next(), false, 2, null) == false) goto L28;
            r105 = true;
        L32:
            r107.setDomStorageEnabled(r105);
            if ((r100.getResources().getConfiguration().uiMode & 48) != 32) goto L35;
            String r116 = "dark";
        L36:
            WebSettings r117 = r111.getSettings();
            r117.setUserAgentString(r117.getUserAgentString() + ";AppTheme/" + r116);
            AppHost.Companion r118 = AppHost.f326268a;
            if (r118.isOversea() == true) goto L39;
            WebSettings r119 = r111.getSettings();
            r119.setUserAgentString(r119.getUserAgentString() + ";doubao");
        L41:
            if (r118.isOversea() == true) goto L43;
            String r120 = "doubao";
        L44:
            WebSettings r121 = r111.getSettings();
            r121.setUserAgentString(r121.getUserAgentString() + ";AppName/" + r120);
            r111.getSettings().setMixedContentMode(2);
            r111.getSettings().setTextZoom(100);
            r111.getSettings().setDisplayZoomControls(z2.f365865a.J0());
            int r122 = Build.VERSION.SDK_INT;
            if (r122 != 24) goto L47;
        L48:
            r111.setLayerType(1, null);
        L49:
            r111.setDownloadListener(new b1(r100));
            return;
        L47:
            if (r122 != 25) goto L49;
        L43:
            r120 = "Dola";
            goto L44
        L39:
            WebSettings r123 = r111.getSettings();
            r123.setUserAgentString(r123.getUserAgentString() + ";cici");
            goto L41
        L35:
            r116 = "light";
        L13:
            r106 = false;
            goto L14
        }
    }

    public static final class g implements ix7.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WebFragment f367466a;

        public g(WebFragment r100) {
            this.f367466a = r100;
        }

        @Override // ix7.h
        public final void a(int r100, int r101, boolean r102, boolean r103) {
            zt8.c r104 = this.f367466a.A;
            if (r104 == null) goto L6;
            r104.a(r100, r101, r102, r103);
            return;
        }

        @Override // ix7.h
        public final void onScrollChanged(int r100, int r101, int r102, int r103) {
            zt8.c r104 = this.f367466a.A;
            if (r104 == null) goto L6;
            r104.onScrollChanged(r100, r101, r102, r103);
            return;
        }

        @Override // ix7.h
        public final void b(int r110, int r111, int r112, int r113, int r114, int r115, int r116, int r117, boolean r210) {
            zt8.c r100 = this.f367466a.A;
            if (r100 == null) goto L6;
            r100.b(r110, r111, r112, r113, r114, r115, r116, r117);
            return;
        }
    }

    static {
        K = MapsKt.hashMapOf(new Pair[]{TuplesKt.to(WebMediaPermissionResources.AUDIO_CAPTURE, "android.permission.RECORD_AUDIO"), TuplesKt.to(WebMediaPermissionResources.VIDEO_CAPTURE, "android.permission.CAMERA")});
    }

    public final void W90() {
        int r100 = vs9.a.f557113a;
        String r101 = this.f367433g;
        HybridEventParams r102 = this.f367444r;
        by7.a r103 = new by7.a("webview_backward_click");
        JSONObject r104 = new JSONObject();
        r104.put("url", r101);
        r104.put("is_ttwebview", vs9.a.a());
        if (r102 == null) goto L5;
        r104.put("enter_method", r102.f367379a);
        r104.put("local_page", r102.f367380b);
        r104.put("chat_type", r102.f367381c);
        r104.put("webview_type", "self_webview");
    L5:
        TrackParams r105 = new TrackParams().merge(r104);
        r103.f21463a.merge(r105);
        r103.b();
        kx7.c r106 = this.f367438l;
        if (r106 == null) goto L8;
        boolean r107 = r106.a();
    L9:
        if (r107 == false) goto L15;
        kx7.c r108 = this.f367438l;
        if (r108 == null) goto L13;
        r108.c();
    L13:
        ia0();
        return;
    L15:
        FragmentActivity r109 = getActivity();
        if (r109 == null) goto L19;
        r109.finish();
        return;
    L19:
        return;
    L8:
        r107 = false;
        goto L9
    }

    public final void Y90() {
        LarusSearchWebBrowserBinding r100 = this.f367432f;     // Catch: Exception -> L28
        if (r100 == null) goto L33;
        kx7.c r101 = this.f367438l;     // Catch: Exception -> L28
        if (r101 == null) goto L7;
        ((PluginWebView) r101).k();     // Catch: Exception -> L28
    L7:
        IIvyWebService.Companion r102 = IIvyWebService.f278339a;     // Catch: Exception -> L28
        String r103 = this.f367431e;     // Catch: Exception -> L28
        lx7.a r104 = this.f367437k;     // Catch: Exception -> L28
        Intrinsics.checkNotNull(r104);     // Catch: Exception -> L28
        kx7.c r105 = r102.b(r103, r104, ca0());     // Catch: Exception -> L28
        this.f367438l = r105;     // Catch: Exception -> L28
        if (r105 == null) goto L12;
        BulletContainerView r106 = r105.f();     // Catch: Exception -> L28
        if (r106 == null) goto L12;
        r100.f367652r.removeAllViews();     // Catch: Exception -> L28
        r100.f367652r.addView(r106, new ViewGroup.LayoutParams(-1, -1));     // Catch: Exception -> L28
        ka0();     // Catch: Exception -> L28
    L12:
        ga0(this.f367433g);     // Catch: Exception -> L28
        if (Build.VERSION.SDK_INT < 23) goto L34;
        Bundle r107 = getArguments();     // Catch: Exception -> L28
        boolean r108 = false;
        if (r107 != null) goto L17;
    L19:
        if (r108 == false) goto L35;
        kx7.c r109 = this.f367438l;     // Catch: Exception -> L28
        if (r109 == null) goto L36;
        WebView r110 = r109.j();     // Catch: Exception -> L28
        if (r110 == null) goto L37;
        WebSettings r111 = r110.getSettings();     // Catch: Exception -> L28
        if (r111 == null) goto L38;
        r111.setOffscreenPreRaster(true);     // Catch: Exception -> L28
        return;
    L38:
        return;
    L37:
        return;
    L36:
        return;
    L35:
        return;
    L17:
        if (r107.getBoolean("bundle_offscreen_pre_raster", false) != true) goto L19;
        r108 = true;
        goto L19
    L34:
        return;
    L33:
        return;
    L28:
        e = move-exception;
        FLogger.f375446a.e("WebFragment", "createHybridKit: " + e);
    }

    public final void aa0() {
        FLogger.f375446a.i("WebFragment", "click reload");     // Catch: Exception -> L26
        kx7.c r100 = this.f367438l;     // Catch: Exception -> L26
        String r101 = null;
        if (r100 == null) goto L6;
        String r102 = r100.i();     // Catch: Exception -> L26
    L8:
        if (Intrinsics.areEqual(r102, this.f367433g) == false) goto L10;
        Y90();     // Catch: Exception -> L26
    L24:
        ia0();     // Catch: Exception -> L26
        return;
    L10:
        kx7.c r103 = this.f367438l;     // Catch: Exception -> L26
        if (r103 == null) goto L13;
        r101 = r103.i();     // Catch: Exception -> L26
    L13:
        if (r101 != null) goto L15;
    L18:
        boolean r104 = true;
    L19:
        if (r104 == false) goto L21;
        ga0(this.f367433g);     // Catch: Exception -> L26
        goto L24
    L21:
        kx7.c r105 = this.f367438l;     // Catch: Exception -> L26
        if (r105 == null) goto L24;
        r105.g();     // Catch: Exception -> L26
        goto L24
    L15:
        if (r101.length() == 0) goto L18;
        r104 = false;
        goto L19
    L6:
        r102 = null;
    L26:
        e = move-exception;
        FLogger.f375446a.i("WebFragment", "click reload error: " + e);
    }

    public final Context ca0() {
        boolean r100 = false;
        if (Build.VERSION.SDK_INT < 23) goto L12;
        Bundle r101 = getArguments();
        if (r101 != null) goto L7;
    L9:
        boolean r102 = false;
    L10:
        if (r102 == false) goto L12;
        r100 = true;
        goto L12
    L7:
        if (r101.getBoolean("bundle_offscreen_pre_raster", false) != true) goto L9;
        r102 = true;
    L12:
        if (r100 == false) goto L19;
        MutableContextWrapper r103 = this.f367429J;
        if (r103 != null) goto L20;
        MutableContextWrapper r104 = new MutableContextWrapper(AppHost.f326268a.getApplication());
        this.f367429J = r104;
        return r104;
    L20:
        return r103;
    L19:
        return requireContext();
    }

    public final void ja0() {
        LarusSearchWebBrowserBinding r100 = this.f367432f;
        if (r100 != null) goto L5;
        return;
    L5:
        Bundle r101 = getArguments();
        if (r101 == null) goto L8;
        String r102 = r101.getString("show_closeall");
    L9:
        int r103 = 0;
        if (Intrinsics.areEqual(r102, "1") == true) goto L12;
    L21:
        boolean r104 = false;
    L22:
        if (r104 == false) goto L24;
        int r105 = 0;
    L26:
        if (r100.f367640f.getVisibility() != r105) goto L28;
        return;
    L28:
        r100.f367640f.setVisibility(r105);
        ViewGroup.LayoutParams r106 = r100.f367637c.getLayoutParams();
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r107 = (ViewGroup.MarginLayoutParams) r106;
        int r108 = r107.getMarginStart() + r107.width;
        if (r104 == false) goto L31;
        r103 = r100.f367640f.getLayoutParams().width;
    L31:
        int r109 = r108 + r103;
        TextView r110 = r100.f367651q;
        ViewGroup.LayoutParams r111 = r110.getLayoutParams();
        if (r111 == null) goto L36;
        ViewGroup.MarginLayoutParams r112 = (ViewGroup.MarginLayoutParams) r111;
        r112.setMarginStart(r109);
        r112.setMarginEnd(r109);
        r110.setLayoutParams(r112);
        return;
    L36:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L24:
        r105 = 8;
        goto L26
    L12:
        if (ba0() == true) goto L21;
        kx7.c r113 = this.f367438l;
        r104 = true;
        if (r113 != null) goto L16;
    L18:
        boolean r114 = false;
    L19:
        if (r114 == false) goto L21;
    L16:
        if (r113.a() != true) goto L18;
        r114 = true;
        goto L19
    L8:
        r102 = null;
        goto L9
    }

    public WebFragment() {
        this.f367430d = LazyKt.lazy(new s0());
        this.f367431e = "aweme://webview/?url=";
        this.f367433g = "";
        this.f367436j = com.larus.platform.service.g.f365738a.h("WebFragment");
        this.f367447u = true;
        this.B = new LinkedHashMap();
        this.I = LazyKt.lazy(new t0());
    }

    public final boolean ba0() {
        Bundle r100 = getArguments();
        if (r100 == null) goto L5;
        String r101 = r100.getString("enable_bottom_share_style");
    L7:
        return Intrinsics.areEqual(r101, "1");
    L5:
        r101 = null;
        goto L7
    }

    public final void ia0() {
        if (ba0() == true) goto L6;
        return;
    L6:
        if (this.f367449w == false) goto L8;
        return;
    L8:
        kx7.c r100 = this.f367438l;
        Boolean r101 = null;
        if (r100 == null) goto L11;
        Boolean r102 = Boolean.valueOf(r100.a());
    L12:
        kx7.c r103 = this.f367438l;
        if (r103 == null) goto L17;
        WebView r104 = r103.j();
        if (r104 == null) goto L17;
        r101 = Boolean.valueOf(r104.canGoForward());
    L17:
        Boolean r105 = Boolean.TRUE;
        if (Intrinsics.areEqual(r102, r105) == false) goto L29;
        LarusSearchWebBrowserBinding r106 = this.f367432f;
        if (r106 == null) goto L24;
        ImageView r107 = r106.f367638d;
        if (r107 == null) goto L24;
        r107.setClickable(true);
    L24:
        LarusSearchWebBrowserBinding r108 = this.f367432f;
        if (r108 == null) goto L40;
        ImageView r109 = r108.f367638d;
        if (r109 == null) goto L40;
        r109.setImageResource(R.drawable.larus_ic_web_bottom_backup);
    L40:
        if (Intrinsics.areEqual(r101, r105) == false) goto L51;
        LarusSearchWebBrowserBinding r110 = this.f367432f;
        if (r110 == null) goto L46;
        ImageView r111 = r110.f367639e;
        if (r111 == null) goto L46;
        r111.setClickable(true);
    L46:
        LarusSearchWebBrowserBinding r112 = this.f367432f;
        if (r112 == null) goto L62;
        ImageView r113 = r112.f367639e;
        if (r113 == null) goto L62;
        r113.setImageResource(R.drawable.larus_ic_web_bottom_forward);
    L62:
        if (Intrinsics.areEqual(r101, r105) == false) goto L64;
    L71:
        LarusSearchWebBrowserBinding r114 = this.f367432f;
        if (r114 == null) goto L80;
        LinearLayout r115 = r114.f367636b;
        if (r115 == null) goto L81;
        r115.setVisibility(0);
        return;
    L81:
        return;
    L80:
        return;
    L64:
        if (Intrinsics.areEqual(r102, r105) == true) goto L71;
        LarusSearchWebBrowserBinding r116 = this.f367432f;
        if (r116 == null) goto L77;
        LinearLayout r117 = r116.f367636b;
        if (r117 == null) goto L78;
        r117.setVisibility(8);
        return;
    L78:
        return;
    L77:
        return;
    L51:
        LarusSearchWebBrowserBinding r118 = this.f367432f;
        if (r118 == null) goto L56;
        ImageView r119 = r118.f367639e;
        if (r119 == null) goto L56;
        r119.setClickable(false);
    L56:
        LarusSearchWebBrowserBinding r120 = this.f367432f;
        if (r120 == null) goto L62;
        ImageView r121 = r120.f367639e;
        if (r121 == null) goto L62;
        r121.setImageResource(R.drawable.larus_ic_web_bottom_forward_unclickable);
        goto L62
    L29:
        LarusSearchWebBrowserBinding r122 = this.f367432f;
        if (r122 == null) goto L34;
        ImageView r123 = r122.f367638d;
        if (r123 == null) goto L34;
        r123.setClickable(false);
    L34:
        LarusSearchWebBrowserBinding r124 = this.f367432f;
        if (r124 == null) goto L40;
        ImageView r125 = r124.f367638d;
        if (r125 == null) goto L40;
        r125.setImageResource(R.drawable.larus_ic_web_bottom_backup_unclickable);
        goto L40
    L11:
        r102 = null;
        goto L12
    }

    public final void ka0() {
        Bundle r100 = getArguments();     // Catch: Exception -> L18
        Integer r101 = null;
        if (r100 != null) goto L6;
    L11:
        if (r101 == null) goto L23;
        kx7.c r102 = this.f367438l;     // Catch: Exception -> L18
        if (r102 == null) goto L24;
        BulletContainerView r103 = r102.f();     // Catch: Exception -> L18
        if (r103 == null) goto L25;
        r103.setBackgroundColor(r101.intValue());     // Catch: Exception -> L18
        return;
    L25:
        return;
    L24:
        return;
    L23:
        return;
    L6:
        if (r100.containsKey("web_view_bg_color") == true) goto L9;
        r100 = null;
    L9:
        if (r100 == null) goto L11;
        r101 = Integer.valueOf(r100.getInt("web_view_bg_color"));     // Catch: Exception -> L18
    L18:
        e = move-exception;
        FLogger.f375446a.e("WebFragment", "fail to setWebViewBgColor " + ExceptionsKt.stackTraceToString(e));
        com.larus.platform.service.g.f365738a.ensureNotReachHere(e);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.C = null;
        da0(false);
        com.larus.platform.service.g.f365738a.g("WebFragment");
        FLogger.f375446a.i("WebFragment", LiveCommonConstants.REASON_ON_DEDTROY);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        if (this.G == false) goto L7;
        IFlowSdkDepend r100 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r100 == null) goto L7;
        r100.D();
        x1.f346268a.o(this.f367433g);
    L7:
        kx7.c r101 = this.f367438l;
        if (r101 == null) goto L10;
        ((PluginWebView) r101).k();
    L10:
        LarusSearchWebBrowserBinding r102 = this.f367432f;
        if (r102 == null) goto L15;
        ImageView r103 = r102.f367641g;
        if (r103 == null) goto L15;
        int r104 = ys9.b.f568996a;
        Intrinsics.checkNotNullParameter(r103, "host");
        com.larus.utils.l.d(r103, "ext_balloon_pop");
    L15:
        HybridEventParams r105 = null;
        this.f367432f = null;
        FLogger.f375446a.i("WebFragment", "onDestroyView");
        int r106 = vs9.a.f557113a;
        String r107 = this.f367433g;
        HybridEventParams r108 = this.f367444r;
        if (r108 == null) goto L18;
        r108.f367382d = Long.valueOf(System.currentTimeMillis() - this.f367445s);
        Unit r109 = Unit.INSTANCE;
        r105 = r108;
    L18:
        by7.a r110 = new by7.a("leave_webviewcontainer");
        JSONObject r111 = new JSONObject();
        r111.put("url", r107);
        r111.put("is_ttwebview", vs9.a.a());
        if (r105 == null) goto L27;
        Map<String, String> r112 = r105.f367384f;
        if (r112 == null) goto L26;
        Iterator<String> r113 = r112.keySet().iterator();
    L24:
        if (r113.hasNext() == false) goto L26;
        String r114 = r113.next();
        r111.put(r114, r112.get(r114));
    L26:
        r111.put("enter_method", r105.f367379a);
        r111.put("local_page", r105.f367380b);
        r111.put("chat_type", r105.f367381c);
        r111.put("webview_type", "self_webview");
        r111.put("duration", r105.f367382d);
    L27:
        TrackParams r115 = new TrackParams().merge(r111);
        r110.f21463a.merge(r115);
        r110.b();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        if (Build.VERSION.SDK_INT < 23) goto L12;
        Bundle r100 = getArguments();
        boolean r101 = false;
        if (r100 != null) goto L7;
    L9:
        if (r101 == false) goto L12;
        FLogger.f375446a.i("WebFragment", "onPause: called, offscreenPreRaster is true");
        return;
    L7:
        if (r100.getBoolean("bundle_offscreen_pre_raster", false) != true) goto L9;
        r101 = true;
    L12:
        kx7.c r102 = this.f367438l;
        if (r102 == null) goto L17;
        com.bytedance.ies.bullet.service.base.o r103 = ((PluginWebView) r102).f278462b.getKitView();
        if (r103 == null) goto L17;
        r103.onHide();
    L17:
        FLogger.f375446a.i("WebFragment", "onPause: called");
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        e1 r100 = this.f367436j;
        if (r100 == null) goto L5;
        r100.b("create");
    L5:
        e1 r101 = this.f367436j;
        if (r101 == null) goto L8;
        r101.c("load");
    L8:
        kx7.c r102 = this.f367438l;
        if (r102 == null) goto L13;
        com.bytedance.ies.bullet.service.base.o r103 = ((PluginWebView) r102).f278462b.getKitView();
        if (r103 == null) goto L13;
        r103.onShow();
    L13:
        FLogger.f375446a.i("WebFragment", "onResume: called");
        ix7.a r104 = this.E;
        if (r104 != null) goto L16;
        return;
    L16:
        if (isAdded() == true) goto L18;
    L22:
        r104.a();
    L23:
        this.E = null;
        return;
    L18:
        if (getChildFragmentManager().isStateSaved() == true) goto L22;
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED) == false) goto L22;
        Z90(r104);
        goto L23
    }

    @Override // com.larus.platform.model.webview.AbsWebFragment
    public final MutableContextWrapper S90() {
        return this.f367429J;
    }

    public final Uri.Builder V90(Uri.Builder r100) {
        if (z2.f365865a.webviewAddThemeQuery() == true) goto L5;
        return r100;
    L5:
        boolean r101 = v19.h.f552477a;
        Context r102 = getContext();
        if (r102 != null) goto L9;
        r102 = AppHost.f326268a.getApplication();
    L9:
        if (v19.h.b(r102) == false) goto L11;
        String r103 = "dark";
    L13:
        return r100.appendQueryParameter("theme", r103);
    L11:
        r103 = "light";
        goto L13
    }

    public final void Z90(ix7.a r210) {
        if (r210 == null) goto L14;
        String[] r100 = r210.getResources();
        if (r100 == null) goto L14;
        ArrayList r101 = new ArrayList();
        int r102 = r100.length;
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L12;
        String r104 = K.get(r100[r103]);
        if (r104 == null) goto L11;
        r101.add(r104);
    L11:
        r103 = r103 + 1;
        goto L7
    L12:
        List r105 = CollectionsKt.toList(r101);
        if (r105 == null) goto L14;
    L15:
        List r106 = r105;
        ArrayList r107 = new ArrayList();
        Iterator r108 = r106.iterator();
    L16:
        String r109 = null;
        if (r108.hasNext() == false) goto L30;
        String r110 = (String) r108.next();
        if (Intrinsics.areEqual(r110, "android.permission.RECORD_AUDIO") == false) goto L24;
        Context r111 = getContext();
        if (r111 == null) goto L28;
        r109 = r111.getString(R.string.larus_building_artifacts_microphone_cn);
    L28:
        if (r109 == null) goto L16;
        r107.add(r109);
        goto L16
    L24:
        if (Intrinsics.areEqual(r110, "android.permission.CAMERA") == false) goto L28;
        Context r112 = getContext();
        if (r112 == null) goto L28;
        r109 = r112.getString(R.string.larus_building_artifacts_camera_cn);
        goto L28
    L30:
        StringBuilder r113 = new StringBuilder();
        if (r210 == null) goto L35;
        Uri r114 = r210.getOrigin();
        if (r114 == null) goto L35;
        String r115 = com.larus.utils.y0.k(r114);
    L36:
        String r116 = "";
        if (r115 != null) goto L39;
        r115 = "";
    L39:
        r113.append(r115);
        if (r210 == null) goto L44;
        String[] r117 = r210.getResources();
        if (r117 == null) goto L44;
        String r118 = ArraysKt.joinToString$default(r117, ",", null, null, 0, null, null, 62, null);
    L45:
        r113.append(r118);
        String r119 = r113.toString();
        Iterator r120 = r106.iterator();
        boolean r121 = true;
    L47:
        if (r120.hasNext() == false) goto L51;
        if (i2.f365748b.d((String) r120.next()) == true) goto L47;
        r121 = false;
        goto L47
    L51:
        if (r121 == true) goto L53;
    L55:
        boolean r122 = false;
    L56:
        if (r122 == false) goto L60;
        if (r210 == null) goto L106;
        r210.b(r210.getResources());
        return;
    L106:
        return;
    L60:
        Context r123 = getContext();
        if (r123 == null) goto L70;
        Object[] r124 = new Object[2];
        if (r210 == null) goto L65;
        Uri r125 = r210.getOrigin();
    L66:
        r124[0] = r125;
        String r126 = (String) CollectionsKt.getOrNull(r107, 0);
        if (r126 != null) goto L69;
        r126 = "";
    L69:
        r124[1] = r126;
        String r127 = r123.getString(R.string.larus_building_artifacts_permission_request_cn, r124);
    L71:
        CommonDialog.a r128 = new CommonDialog.a();
        if (r127 == null) goto L75;
        r116 = r127;
    L75:
        Intrinsics.checkNotNullParameter(r116, "message");
        r128.f327180i = r116;
        CommonDialog.a.f(r128, new b(this, r105, r119, r210), getString(R.string.larus_confirm_pin_btn), false, 12);
        CommonDialog.a.e(r128, new c(this, r119, r210), getString(R.string.larus_update_cancel_cn), 4);
        CommonDialog r129 = r128.a();
        if (isAdded() == true) goto L78;
    L88:
        FLogger.f375446a.w("WebFragment", "createRequestPermissionDialog: cannot show, postpone");
        this.E = r210;
        return;
    L78:
        if (getChildFragmentManager().isStateSaved() == true) goto L88;
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED) == false) goto L88;
        FragmentManager r130 = getChildFragmentManager();
        LandscapeRestrictionOperation r131 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r129, null, r131);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r130, r129, r131) == true) goto L107;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L90
    L86:
        r129.show(r130, null);
        return;
    L107:
        return;
    L65:
        r125 = null;
        goto L66
    L70:
        r127 = null;
        goto L71
    L53:
        if (Intrinsics.areEqual(((LinkedHashMap) this.B).get(r119), Boolean.TRUE) == false) goto L55;
        r122 = true;
    L44:
        r118 = null;
    L35:
        r115 = null;
    L14:
        r105 = CollectionsKt.emptyList();
        goto L15
    }

    public final void da0(boolean r100) {
        if (this.f367446t == false) goto L6;
        return;
    L6:
        if (r100 != this.f367440n) goto L8;
        return;
    L8:
        this.f367440n = r100;
        FragmentActivity r101 = getActivity();
        if (r101 == null) goto L18;
        if (r100 == false) goto L12;
        this.f367443q = Integer.valueOf(r101.getRequestedOrientation());
        r101.setRequestedOrientation(-1);
        goto L18
    L12:
        Integer r102 = this.f367443q;
        if (r102 == null) goto L15;
        int r103 = r102.intValue();
    L16:
        r101.setRequestedOrientation(r103);
        this.f367443q = null;
        goto L18
    L15:
        r103 = 3;
    L18:
        if (r100 == false) goto L41;
        if (Build.VERSION.SDK_INT < 30) goto L35;
        FragmentActivity r104 = getActivity();
        if (r104 == null) goto L28;
        Window r105 = r104.getWindow();
        if (r105 == null) goto L28;
        WindowInsetsController r106 = r105.getInsetsController();
        if (r106 == null) goto L28;
        r106.hide(WindowInsets.Type.statusBars());
    L28:
        FragmentActivity r107 = getActivity();
        if (r107 == null) goto L61;
        Window r108 = r107.getWindow();
        if (r108 == null) goto L61;
        WindowInsetsController r109 = r108.getInsetsController();
        if (r109 == null) goto L61;
        r109.hide(WindowInsets.Type.navigationBars());
    L61:
        LarusSearchWebBrowserBinding r110 = this.f367432f;
        if (r110 == null) goto L81;
        FrameLayout r111 = r110.f367635a;
        if (r111 == null) goto L84;
        if (r100 == false) goto L68;
        this.f367442p = r111.getPaddingBottom();
        this.f367441o = r111.getPaddingTop();
    L68:
        int r112 = 0;
        if (r100 == false) goto L71;
        int r113 = 0;
    L72:
        if (r100 == true) goto L75;
        r112 = this.f367441o;
    L75:
        LarusSearchWebBrowserBinding r114 = this.f367432f;
        if (r114 == null) goto L82;
        FrameLayout r115 = r114.f367635a;
        if (r115 == null) goto L83;
        int r116 = r115.getPaddingStart();
        int r117 = r115.getPaddingEnd();
        FLogger.f375446a.i("updatePaddingRelative", "view:" + r115.getClass().getSimpleName() + ",source:handleFullScreen,start:" + r116 + ",top:" + r112 + ",end:" + r117 + ",bottom:" + r113);
        r115.setPaddingRelative(r116, r112, r117, r113);
        return;
    L83:
        return;
    L82:
        return;
    L71:
        r113 = this.f367442p;
        goto L72
    L84:
        return;
    L81:
        return;
    L35:
        FragmentActivity r118 = getActivity();
        if (r118 == null) goto L61;
        Window r119 = r118.getWindow();
        if (r119 == null) goto L61;
        r119.addFlags(1024);
        goto L61
    L41:
        if (Build.VERSION.SDK_INT < 30) goto L56;
        FragmentActivity r120 = getActivity();
        if (r120 == null) goto L49;
        Window r121 = r120.getWindow();
        if (r121 == null) goto L49;
        WindowInsetsController r122 = r121.getInsetsController();
        if (r122 == null) goto L49;
        r122.show(WindowInsets.Type.statusBars());
    L49:
        FragmentActivity r123 = getActivity();
        if (r123 == null) goto L61;
        Window r124 = r123.getWindow();
        if (r124 == null) goto L61;
        WindowInsetsController r125 = r124.getInsetsController();
        if (r125 == null) goto L61;
        r125.show(WindowInsets.Type.navigationBars());
        goto L61
    L56:
        FragmentActivity r126 = getActivity();
        if (r126 == null) goto L61;
        Window r127 = r126.getWindow();
        if (r127 == null) goto L61;
        r127.clearFlags(1024);
        goto L61
    }

    public final void ea0(boolean r110) {
        if (this.f367446t == false) goto L5;
        return;
    L5:
        LarusSearchWebBrowserBinding r100 = this.f367432f;
        if (r100 == null) goto L30;
        LinearLayout r101 = r100.f367649o;
        if (r101 != null) goto L10;
        return;
    L10:
        if (r101.isAttachedToWindow() == false) goto L27;
        WindowInsetsCompat r102 = ViewCompat.getRootWindowInsets(r101);
        if (r102 == null) goto L16;
        Insets r103 = r102.getInsets(WindowInsetsCompat.Type.navigationBars());
        if (r103 == null) goto L16;
        int r104 = r103.bottom;
    L17:
        WindowInsetsCompat r105 = ViewCompat.getRootWindowInsets(r101);
        if (r105 == null) goto L22;
        Insets r106 = r105.getInsets(WindowInsetsCompat.Type.statusBars());
        if (r106 == null) goto L22;
        int r107 = r106.top;
    L24:
        if (r110 == false) goto L26;
        int r111 = r101.getPaddingStart();
        int r108 = r101.getPaddingEnd();
        FLogger.f375446a.i("updatePaddingRelative", "view:" + r101.getClass().getSimpleName() + ",source:onWebViewCreated,start:" + r111 + ",top:0,end:" + r108 + ",bottom:" + r104);
        r101.setPaddingRelative(r111, 0, r108, r104);
    L28:
        ViewCompat.setOnApplyWindowInsetsListener(r101, new m0());
        ViewCompat.requestApplyInsets(r101);
        return;
    L26:
        int r112 = r101.getPaddingStart();
        int r109 = r101.getPaddingEnd();
        FLogger.f375446a.i("updatePaddingRelative", "view:" + r101.getClass().getSimpleName() + ",source:onWebViewCreated,start:" + r112 + ",top:" + r107 + ",end:" + r109 + ",bottom:" + r104);
        r101.setPaddingRelative(r112, r107, r109, r104);
    L22:
        r107 = 0;
    L16:
        r104 = 0;
        goto L17
    L27:
        r101.addOnAttachStateChangeListener(new d(r101, r101, r110));
        goto L28
    }

    public final void ga0(String r110) {
        if (this.f367450x == false) goto L23;
        if (r110 == null) goto L28;
        boolean r100 = !ha0(r110);
        String r111 = URLEncoder.encode(r110);
        String r101 = "";
        if (r100 == true) goto L8;
        String r102 = "";
    L9:
        SchemaSuffixMap r103 = this.f367451y;
        if (r103 == null) goto L12;
        Map<String, String> r104 = r103.getMap();
    L13:
        if (r104 == null) goto L20;
        Set<Map.Entry<String, String>> r105 = r104.entrySet();
        if (r105 == null) goto L20;
        String r106 = CollectionsKt.joinToString$default(r105, "", null, null, 0, null, new l0(), 30, null);
        if (r106 == null) goto L20;
        r101 = r106;
    L20:
        String r112 = "aweme://webview/?url=" + r111 + "&use_xbridge3=true&need_sec_link=1&sec_link_scene=im" + r102 + r101;
        kx7.c r107 = this.f367438l;
        if (r107 == null) goto L29;
        r107.d(r112);
        return;
    L29:
        return;
    L12:
        r104 = null;
        goto L13
    L8:
        r102 = "&loader_name=forest";
        goto L9
    L28:
        return;
    L23:
        if (r110 == null) goto L31;
        kx7.c r108 = this.f367438l;
        if (r108 == null) goto L32;
        r108.e(r110, !ha0(r110));
        return;
    L32:
        return;
    }

    public final boolean ha0(String r110) {
        Bundle r100 = getArguments();
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L10;
        return true;
    L10:
        ArrayList r102 = new ArrayList();
        r102.addAll(z2.f365865a.F0());
        int r103 = gv8.a.f482839a;
        r102.addAll(CollectionsKt.listOf(new String[]{"www.douyin.com/video", "dcdapp.com", "doubao.com", "y.qq.com", "music.163.com", "piao.cn", "taopiaopiao.com", "taobao.com", "uri.amap.com", "jd.com"}));
        if (r102.isEmpty() == false) goto L13;
        return false;
    L13:
        Iterator r104 = r102.iterator();
    L15:
        if (r104.hasNext() == false) goto L19;
        if (StringsKt.contains$default(r110, (String) r104.next(), false, 2, null) == false) goto L15;
        return true;
    L19:
        return false;
    L5:
        if (r100.getBoolean("bundle_disable_forest", false) != true) goto L7;
        r101 = true;
        goto L8
    }

    public final boolean la0(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        return false;
    L12:
        if (StringsKt.startsWith$default(r100, "http", false, 2, null) == true) goto L14;
        return false;
    L14:
        ts9.a r102 = SearchServiceImpl.f367426a;
        List<String> r103 = SearchServiceImpl.f367426a.f547426e;
        Uri r104 = UriProtector.parse(this.f367433g);
        if (Intrinsics.areEqual(r104.getScheme(), "https") == true) goto L17;
    L19:
        return false;
    L17:
        if (CollectionsKt.contains(r103, r104.getHost()) == false) goto L19;
        return true;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.larus.search.impl.q0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.larus.search.impl.r0, java.lang.Object] */
    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle r110) {
        super.onCreate(r110);
        e1 r111 = this.f367436j;
        if (r111 == null) goto L5;
        r111.startTrace();
    L5:
        e1 r112 = this.f367436j;
        if (r112 == null) goto L8;
        r112.c("create");
    L8:
        com.larus.platform.service.g.f365738a.e("WebFragment");
        IvyKitInitializer r113 = IvyKitInitializer.f351614a;
        if (IvyKitInitializer.c() == true) goto L11;
        r113.b(AppHost.f326268a.getApplication(), new z0());
    L11:
        final a0 r114 = (a0) this.f367430d.getValue();
        final ?? r100 = new q0(this);
        final ?? r101 = new r0(this);
        r114.getClass();
        Intrinsics.checkNotNullParameter(this, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r100, "onSuccess");
        Intrinsics.checkNotNullParameter(r101, "onFail");
        getLifecycle().addObserver(new LocalFileTaker$registerResultForMultiFile$1(r114, this, r100, r101));
        int r115 = ts9.b.f547427a;
        String r116 = ts9.b.a(getArguments());
        if (r116 != null) goto L14;
        r116 = "";
    L14:
        this.f367433g = r116;
        Bundle r117 = getArguments();
        boolean r102 = true;
        boolean r103 = false;
        if (r117 != null) goto L17;
    L19:
        boolean r118 = false;
    L20:
        if (r118 == false) goto L24;
        IFlowSdkDepend r119 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r119 == null) goto L24;
        r119.D();
        x1.f346268a.b(this.f367433g);
    L24:
        Bundle r120 = getArguments();
        if (r120 != null) goto L27;
    L29:
        boolean r121 = false;
    L30:
        this.G = r121;
        if (r121 == false) goto L35;
        IFlowSdkDepend r122 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r122 == null) goto L35;
        r122.D();
        x1.f346268a.n(this.f367433g);
    L35:
        Bundle r123 = getArguments();
        HybridEventParams r104 = null;
        if (r123 == null) goto L38;
        String r124 = r123.getString(CJHostRouterServiceImpl.URI_KEY_USE_ANNIEX);
    L40:
        if (Intrinsics.areEqual(r124, "1") == true) goto L47;
        Bundle r125 = getArguments();
        if (r125 == null) goto L44;
        String r126 = r125.getString(CJHostRouterServiceImpl.URI_KEY_MIX_CONTAINER_TYPE);
    L46:
        if (Intrinsics.areEqual(r126, "anniex") == true) goto L47;
    L71:
        Bundle r127 = getArguments();
        if (r127 == null) goto L76;
        String r128 = r127.getString("is_not_full_page");
        if (r128 == null) goto L76;
        boolean r129 = Intrinsics.areEqual(r128, "1");
    L77:
        this.f367446t = r129;
        Bundle r130 = getArguments();
        if (r130 == null) goto L82;
        String r131 = r130.getString("is_show_progress_bar");
        if (r131 == null) goto L82;
        boolean r132 = Intrinsics.areEqual(r131, "1");
    L83:
        this.f367447u = r132;
        Bundle r133 = getArguments();
        if (r133 == null) goto L88;
        String r134 = r133.getString("is_show_center_progress_bar");
        if (r134 == null) goto L88;
        boolean r135 = Intrinsics.areEqual(r134, "1");
    L89:
        this.f367448v = r135;
        Bundle r136 = getArguments();
        if (r136 == null) goto L94;
        String r137 = r136.getString("need_schema_premix");
        if (r137 == null) goto L94;
        boolean r138 = Intrinsics.areEqual(r137, "1");
    L95:
        this.f367450x = r138;
        Bundle r139 = getArguments();
        if (r139 == null) goto L98;
        Serializable r140 = r139.getSerializable("schema_suffix_map");
    L100:
        if ((r140 instanceof SchemaSuffixMap) == false) goto L102;
        SchemaSuffixMap r141 = (SchemaSuffixMap) r140;
    L103:
        this.f367451y = r141;
        Bundle r142 = getArguments();
        if (r142 == null) goto L108;
        String r143 = r142.getString("hide_go_forward_and_back");
        if (r143 == null) goto L108;
        r103 = Intrinsics.areEqual(r143, "1");
    L108:
        this.f367449w = r103;
        Bundle r144 = getArguments();
        if (r144 == null) goto L111;
        r102 = r144.getBoolean("bundle_need_trace", true);
    L111:
        this.F = r102;
        int r145 = ts9.b.f547427a;
        Bundle r146 = getArguments();
        if (r146 == null) goto L114;
        String r147 = r146.getString("title");
    L115:
        this.f367434h = r147;
        Bundle r148 = getArguments();
        if (r148 == null) goto L118;
        r104 = (HybridEventParams) r148.getParcelable("hybrid_event_param");
    L118:
        this.f367444r = r104;
        int r149 = vs9.a.f557113a;
        String r150 = this.f367433g;
        by7.a r105 = new by7.a("webview_show");
        JSONObject r106 = new JSONObject();
        r106.put("url", r150);
        r106.put("is_ttwebview", vs9.a.a());
        if (r104 == null) goto L127;
        Map<String, String> r151 = r104.f367384f;
        if (r151 == null) goto L126;
        Iterator<String> r107 = r151.keySet().iterator();
    L124:
        if (r107.hasNext() == false) goto L126;
        String r108 = r107.next();
        r106.put(r108, r151.get(r108));
    L126:
        r106.put("enter_method", r104.f367379a);
        r106.put("local_page", r104.f367380b);
        r106.put("chat_type", r104.f367381c);
        r106.put("webview_type", "self_webview");
    L127:
        r105.f21463a.merge(new TrackParams().merge(r106));
        r105.b();
        this.f367445s = System.currentTimeMillis();
        FLogger.f375446a.i("WebFragment", "onCreate url:" + this.f367433g);
        this.f367437k = IIvyWebService.a.a(IIvyWebService.f278339a, com.larus.ivykit.c.a(), this.f367431e, new e(this), new f(this), null, new g(this), null, Bitmap.createBitmap(10, 10, Bitmap.Config.ARGB_8888), 336);
        return;
    L114:
        r147 = null;
        goto L115
    L102:
        r141 = null;
        goto L103
    L98:
        r140 = null;
    L94:
        r138 = false;
    L88:
        r135 = false;
    L82:
        r132 = true;
    L76:
        r129 = false;
        goto L77
    L44:
        r126 = null;
    L47:
        Uri.Builder r152 = UriProtector.parse(this.f367433g).buildUpon();
        Bundle r109 = getArguments();
        if (r109 == null) goto L70;
        Set<String> r153 = r109.keySet();
        if (r153 == null) goto L70;
        ArrayList r154 = new ArrayList();
        Iterator<T> r155 = r153.iterator();
    L53:
        if (r155.hasNext() == false) goto L62;
        Object r156 = r155.next();
        String r157 = (String) r156;
        if (Intrinsics.areEqual(r157, "url") == false) goto L57;
    L59:
        boolean r158 = false;
    L60:
        if (r158 == false) goto L53;
        r154.add(r156);
        goto L53
    L57:
        if (Intrinsics.areEqual(r157, "link_url") == true) goto L59;
        r158 = true;
        goto L60
    L62:
        Iterator r159 = r154.iterator();
    L64:
        if (r159.hasNext() == false) goto L70;
        String r160 = (String) r159.next();
        Bundle r161 = getArguments();
        if (r161 == null) goto L68;
        Object r162 = r161.get(r160);
    L69:
        r152.appendQueryParameter(r160, String.valueOf(r162));
        goto L64
    L68:
        r162 = null;
    L70:
        this.f367433g = r152.build().toString();
        goto L71
    L38:
        r124 = null;
        goto L40
    L27:
        if (r120.getBoolean("bundle_need_lark_auth_cookie_sync", false) != true) goto L29;
        r121 = true;
        goto L30
    L17:
        if (r117.getBoolean("bundle_clear_lark_auth_cookies_once", false) != true) goto L19;
        r118 = true;
        goto L20
    }

    public static void fa0(View r100, String r101) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r101 != null) goto L7;
    L10:
        boolean r102 = true;
    L11:
        if (r102 == false) goto L23;
        return;
    L23:
    L20:
        e = move-exception;
        FLogger.f375446a.e("WebFragment", "Fail to set view color " + r101 + ": " + e.getMessage());
        return;
    L15:
        if (StringsKt.startsWith$default(r101, "#", false, 2, null) == false) goto L17;
        String r103 = r101;
    L18:
        r100.setBackgroundColor(Color.parseColor(r103));     // Catch: Exception -> L20
        return;
    L17:
        r103 = "#" + r101;     // Catch: Exception -> L20
        goto L18
    L7:
        if (r101.length() == 0) goto L10;
        r102 = false;
        goto L11
    }

    @Override // com.larus.platform.model.webview.AbsWebFragment
    public final void T90(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "params");
        kx7.c r102 = this.f367438l;
        if (r102 == null) goto L6;
        r102.h(r100, r101);
        return;
    }

    public final boolean X90(String r100, Map<String, String> r101) {
        String r102 = r101.get(AppConstants.HTTP_H_REFERER);
        if (la0(r100) == false) goto L5;
    L8:
        return true;
    L5:
        if (la0(r102) == true) goto L8;
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r910, Bundle r911) {
        Intrinsics.checkNotNullParameter(r910, "view");
        super.onViewCreated(r910, r911);
        LarusSearchWebBrowserBinding r100 = this.f367432f;
        if (r100 == null) goto L99;
        Uri r101 = UriProtector.parse(this.f367433g);
        String r102 = null;
        Bundle r103 = getArguments();     // Catch: Exception -> L12
        if (r103 == null) goto L10;
        String r104 = r103.getString(AppConstants.BUNDLE_STATUS_BAR_BG_COLOR);     // Catch: Exception -> L12
        if (r104 == null) goto L10;
    L13:
        fa0(r100.f367649o, r104);
        String r105 = "0";
        if (AppHost.f326268a.isOversea() == false) goto L22;
        if (this.f367446t == true) goto L22;
        String r106 = UriProtector.getQueryParameter(r101, AppConstants.TRANS_STATUS_BAR);     // Catch: Exception -> L102
        if (r106 == null) goto L19;
    L20:
        ea0(Intrinsics.areEqual(r106, "1"));
    L27:
        ConstraintLayout r107 = r100.f367650p;
        Bundle r110 = getArguments();
        if (r110 == null) goto L30;
        String r111 = r110.getString("nav_bar_color");
    L31:
        fa0(r107, r111);
        String r108 = UriProtector.getQueryParameter(r101, "hide_title_bar");     // Catch: Exception -> L101
        if (r108 != null) goto L114;
        Bundle r109 = getArguments();     // Catch: Exception -> L101
        if (r109 == null) goto L38;
        r108 = r109.getString("hide_nav_bar", "0");     // Catch: Exception -> L101
    L39:
        if (r108 != null) goto L114;
    L38:
        r108 = null;
    L114:
        String r112 = UriProtector.getQueryParameter(r101, "hide_nav_bar");     // Catch: Exception -> L45
        if (r112 == null) goto L46;
        r105 = r112;
    L46:
        ConstraintLayout r113 = r100.f367650p;
        if (Intrinsics.areEqual(r108, "1") == false) goto L49;
    L58:
        int r114 = 8;
    L59:
        r113.setVisibility(r114);
        ProgressBar r115 = r100.f367648n;
        r115.setVisibility(0);
        r115.setMax(100);
        r115.setProgress(10);
        ProgressBar r116 = r100.f367643i;
        r116.setVisibility(0);
        r116.setMax(100);
        r116.setProgress(10);
        final LarusSearchWebBrowserBinding r117 = this.f367432f;
        if (r117 == null) goto L67;
        if (ba0() == false) goto L64;
        r117.f367637c.setImageResource(R.drawable.larus_ic_web_close);
        r117.f367637c.setContentDescription(getString(R.string.larus_accessibility_icon_close));
        r117.f367637c.setOnClickListener(new u0(this));
        r117.f367642h.setVisibility(0);
    L65:
        r117.f367640f.setOnClickListener(new w0(this));
        ja0();
        com.larus.utils.e1.d(r117.f367642h, new x0(this));
        r117.f367641g.setOnClickListener(new j0(this, r117));
        List r118 = CollectionsKt.listOf(new com.larus.bmhome.view.screenmenu.l0[]{new com.larus.bmhome.view.screenmenu.l0(R.string.larus_webview_menu_copy_link, R.string.larus_webview_menu_copy_link, null, null, null, null, null, null, null, false, false, null, Integer.valueOf(R.drawable.larus_ic_web_link), null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -4100, 127), new com.larus.bmhome.view.screenmenu.l0(R.string.larus_webview_menu_refresh, R.string.larus_webview_menu_refresh, null, null, null, null, null, null, null, false, false, null, Integer.valueOf(R.drawable.larus_ic_web_refresh), null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -4100, 127)});
        CommonMenu r119 = new CommonMenu(ca0());
        r119.g(r118, new k0(this));
        int r120 = ys9.b.f568996a;
        this.f367435i = ys9.b.a(r117.f367641g, r119.i());
        goto L67
    L64:
        r117.f367637c.setImageResource(R.drawable.larus_ic_web_back);
        r117.f367637c.setContentDescription(getString(R.string.larus_accessibility_icon_back));
        r117.f367637c.setOnClickListener(new v0(this));
        r117.f367642h.setVisibility(8);
    L67:
        if (this.f367449w == true) goto L72;
        LarusSearchWebBrowserBinding r121 = this.f367432f;
        if (r121 == null) goto L72;
        com.larus.utils.e1.d(r121.f367638d, new i0(this));
        com.larus.utils.e1.d(r121.f367639e, new p0(this));
        ia0();
    L72:
        Y90();
        Result.Companion r122 = Result.Companion;     // Catch: Throwable -> L75
        Object r123 = Result.m9449constructorimpl(UriProtector.getQueryParameter(r101, "container_bg_color"));     // Catch: Throwable -> L75
    L78:
        if (Result.m9455isFailureimpl(r123) == false) goto L80;
        r123 = null;
    L80:
        String r124 = (String) r123;
        if (r124 != null) goto L86;
        Bundle r125 = getArguments();
        if (r125 == null) goto L85;
        r124 = r125.getString("container_bg_color");
        goto L86
    L85:
        r124 = null;
    L86:
        kx7.c r126 = this.f367438l;
        if (r126 == null) goto L89;
        BulletContainerView r127 = r126.f();
    L90:
        fa0(r127, r124);
        FragmentActivity r128 = getActivity();
        if (r128 == null) goto L99;
        Bundle r129 = getArguments();
        if (r129 == null) goto L97;
        r102 = r129.getString("is_show_loading");
    L97:
        if (Intrinsics.areEqual(r102, "1") == false) goto L99;
        int r130 = CommonLoadDialogFragment.f327234e;
        Bundle r131 = new Bundle();
        r131.putFloat("key_dim", 0.0f);
        CommonLoadDialogFragment r132 = new CommonLoadDialogFragment();
        r132.setArguments(r131);
        this.f367452z = r132;
        r132.S90(r128);
        goto L99
    L89:
        r127 = null;
    L75:
        th = move-exception;
        Result.Companion r133 = Result.Companion;
        r123 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L78
    L49:
        if (Intrinsics.areEqual(r105, "1") == true) goto L58;
        Bundle r134 = getArguments();
        if (r134 == null) goto L53;
        String r135 = r134.getString("hide_title_bar");
    L55:
        if (Intrinsics.areEqual(r135, "1") == true) goto L58;
        r114 = 0;
        goto L59
    L53:
        r135 = null;
    L40:
        r108 = "0";
        goto L114
    L30:
        r111 = null;
    L19:
        r106 = "0";
    L22:
        if (this.f367446t == true) goto L27;
        String r136 = UriProtector.getQueryParameter(r101, "should_full_screen");     // Catch: Exception -> L103
        if (r136 == null) goto L25;
    L26:
        ea0(Intrinsics.areEqual(r136, "1"));
    L25:
        r136 = "0";
    L10:
        r104 = UriProtector.getQueryParameter(r101, AppConstants.BUNDLE_STATUS_BAR_BG_COLOR);     // Catch: Exception -> L12
    L12:
        r104 = null;
    L99:
        FLogger.f375446a.i("WebFragment", "onViewCreated load kitViewDelegate=" + this.f367438l);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [com.larus.applog.api.IApplog$Companion] */
    /* JADX WARN: Type inference failed for: r0v17, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r3v0, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [int] */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final void U90(final WebFragment r100, String r110, JSONObject r111) {
        r100.getClass();
        FLogger.f375446a.i("WebFragment", "isForMainFrame = true, doWhenReceivedError");
        CommonLoadDialogFragment r101 = r100.f367452z;
        if (r101 != null) goto L62;
    L10:
        LarusSearchWebBrowserBinding r102 = r100.f367432f;
        if (r102 == null) goto L15;
        ProgressBar r103 = r102.f367648n;
        if (r103 == null) goto L15;
        r103.setVisibility(4);
    L15:
        LarusSearchWebBrowserBinding r104 = r100.f367432f;
        if (r104 == null) goto L20;
        ProgressBar r105 = r104.f367643i;
        if (r105 == null) goto L20;
        r105.setVisibility(4);
    L20:
        Bundle r106 = r100.getArguments();
        if (r106 == null) goto L23;
        String r107 = r106.getString("enable_error_view");
    L24:
        ?? r108 = 0;
        if (Intrinsics.areEqual(r107, "1") == false) goto L41;
        LarusSearchWebBrowserBinding r109 = r100.f367432f;
        if (r109 == null) goto L31;
        ConstraintLayout r112 = r109.f367646l;
        if (r112 == null) goto L31;
        r112.setVisibility(0);
    L31:
        LarusSearchWebBrowserBinding r113 = r100.f367432f;
        if (r113 == null) goto L36;
        TextView r114 = r113.f367645k;
        if (r114 == null) goto L36;
        com.larus.utils.e1.d(r114, new n0(r100));
    L36:
        LarusSearchWebBrowserBinding r115 = r100.f367432f;
        if (r115 == null) goto L41;
        TextView r116 = r115.f367647m;
        if (r116 == null) goto L41;
        com.larus.utils.e1.d(r116, new o0(r100));
    L41:
        HybridEventParams r117 = r100.f367444r;
        if (r117 == null) goto L44;
        boolean r118 = Intrinsics.areEqual(r117.f367383e, Boolean.TRUE);
    L45:
        if (r118 == false) goto L50;
        int r119 = vs9.a.f557113a;
        vs9.a.b(r100.f367433g, false, r100.f367444r);
        HybridEventParams r120 = r100.f367444r;
        if (r120 == null) goto L50;
        r120.f367383e = Boolean.FALSE;
    L50:
        if (r100.F == true) goto L52;
        return;
    L52:
        if (r100.H == true) goto L65;
        r100.H = true;
        ?? r121 = IApplog.f287053a;
        ?? r122 = new JSONObject();
        r122.put("url", r100.f367433g);
        r122.put("scene", r110);
        r122.put("extra_info", r111);
        TTWebViewService r123 = (TTWebViewService) ServiceManager.get().getService(TTWebViewService.class);
        if (r123 == null) goto L56;
        ?? r124 = r123.a();
    L57:
        r122.put("is_ttwebview", r124);
        Unit r125 = Unit.INSTANCE;
        r121.reportEvent("web_received_error", r122);
        ?? r126 = new JSONObject();
        r126.put("url", r100.f367433g);
        r126.put("scene", r110);
        r126.put("extra_info", r111);
        TTWebViewService r127 = (TTWebViewService) ServiceManager.get().getService(TTWebViewService.class);
        if (r127 == null) goto L60;
        r108 = r127.a();
    L60:
        r126.put("is_ttwebview", r108);
        ApmAgent.monitorEvent("web_received_error", r126, null, null);
        return;
    L56:
        r124 = 0;
        goto L57
    L65:
        return;
    L44:
        r118 = false;
        goto L45
    L23:
        r107 = null;
        goto L24
    L62:
        r101.dismissAllowingStateLoss();     // Catch: Exception -> L6
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r128 = DialogFragmentLancet.sLastShowStack;
        if (r128 == null) goto L10;
        com.bytedance.crash.d.d(r128, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L10
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r210, ViewGroup r211, Bundle r212) {
        Intrinsics.checkNotNullParameter(r210, "inflater");
        if (r211 == null) goto L7;
        boolean r100 = true;
        if (ViewExtKt.h(r211) != true) goto L7;
    L8:
        if (r100 == false) goto L10;
        ViewExtKt.g(r211);
    L10:
        View r101 = r210.inflate(R.layout.larus_search_web_browser, r211, false);
        int r102 = R.id.bottom_action_bar;
        LinearLayout r103 = (LinearLayout) ViewBindings.findChildViewById(r101, R.id.bottom_action_bar);
        if (r103 == null) goto L52;
        r102 = R.id.btn_back;
        ImageView r104 = (ImageView) ViewBindings.findChildViewById(r101, R.id.btn_back);
        if (r104 == null) goto L52;
        r102 = R.id.btn_bottom_go_back;
        ImageView r105 = (ImageView) ViewBindings.findChildViewById(r101, R.id.btn_bottom_go_back);
        if (r105 == null) goto L52;
        r102 = R.id.btn_bottom_go_forward;
        ImageView r106 = (ImageView) ViewBindings.findChildViewById(r101, R.id.btn_bottom_go_forward);
        if (r106 == null) goto L52;
        r102 = R.id.btn_close_all;
        ImageView r110 = (ImageView) ViewBindings.findChildViewById(r101, R.id.btn_close_all);
        if (r110 == null) goto L52;
        r102 = R.id.btn_more;
        ImageView r111 = (ImageView) ViewBindings.findChildViewById(r101, R.id.btn_more);
        if (r111 == null) goto L52;
        r102 = R.id.btn_share;
        ImageView r112 = (ImageView) ViewBindings.findChildViewById(r101, R.id.btn_share);
        if (r112 == null) goto L52;
        r102 = R.id.center_progress;
        ProgressBar r113 = (ProgressBar) ViewBindings.findChildViewById(r101, R.id.center_progress);
        if (r113 == null) goto L52;
        r102 = R.id.divider;
        View r114 = ViewBindings.findChildViewById(r101, R.id.divider);
        if (r114 == null) goto L52;
        r102 = R.id.error_close;
        TextView r115 = (TextView) ViewBindings.findChildViewById(r101, R.id.error_close);
        if (r115 == null) goto L52;
        r102 = R.id.error_container;
        ConstraintLayout r116 = (ConstraintLayout) ViewBindings.findChildViewById(r101, R.id.error_container);
        if (r116 == null) goto L52;
        r102 = R.id.error_desc;
        if (((TextView) ViewBindings.findChildViewById(r101, R.id.error_desc)) == null) goto L52;
        r102 = R.id.error_refresh;
        TextView r117 = (TextView) ViewBindings.findChildViewById(r101, R.id.error_refresh);
        if (r117 == null) goto L52;
        r102 = R.id.progress_bar;
        ProgressBar r118 = (ProgressBar) ViewBindings.findChildViewById(r101, R.id.progress_bar);
        if (r118 == null) goto L52;
        r102 = R.id.root_container;
        LinearLayout r119 = (LinearLayout) ViewBindings.findChildViewById(r101, R.id.root_container);
        if (r119 == null) goto L52;
        r102 = R.id.title_bar;
        ConstraintLayout r213 = (ConstraintLayout) ViewBindings.findChildViewById(r101, R.id.title_bar);
        if (r213 == null) goto L52;
        r102 = R.id.tv_title;
        TextView r214 = (TextView) ViewBindings.findChildViewById(r101, R.id.tv_title);
        if (r214 == null) goto L52;
        r102 = R.id.web_view_parent;
        LinearLayout r215 = (LinearLayout) ViewBindings.findChildViewById(r101, R.id.web_view_parent);
        if (r215 == null) goto L52;
        this.f367432f = new LarusSearchWebBrowserBinding((FrameLayout) r101, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r213, r214, r215);
        FLogger.f375446a.i("WebFragment", "onCreateView");
        LarusSearchWebBrowserBinding r107 = this.f367432f;
        if (r107 != null) goto L53;
        return null;
    L53:
        return r107.f367635a;
    L52:
        throw new NullPointerException("Missing required view with ID: ".concat(r101.getResources().getResourceName(r102)));
    L7:
        r100 = false;
        goto L8
    }
}
