package com.bytedance.android.shopping.store.tabkit;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.ec.core.hybrid.prefetch.NativePrefetchUtil;
import com.bytedance.android.ec.core.hybrid.prefetch.q;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil$createLiveHybridComponentForSaaS$;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.j1;
import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.marketing.sdk.api.ECMarketingSDK;
import com.bytedance.android.marketing.sdk.api.IMarketingServiceV2;
import com.bytedance.android.shopping.api.IEShoppingService;
import com.bytedance.android.shopping.api.mall.mallSession.IMallSessionService;
import com.bytedance.android.shopping.store.tabkit.anniex.TabKitAnnieXTabFragment;
import com.bytedance.android.shopping.store.tabkit.brandmall.TabkitPrefetch;
import com.bytedance.android.shopping.store.tabkit.container.TabKitDialogFragment;
import com.bytedance.android.shopping.store.tabkit.container.TabKitFoldFragment;
import com.bytedance.android.shopping.store.tabkit.model.TabVisibleFrom;
import com.bytedance.android.shopping.store.tabkit.model.p;
import com.bytedance.android.shopping.store.tabkit.model.s;
import com.bytedance.android.shopping.store.tabkit.model.v;
import com.bytedance.android.shopping.store.tabkit.model.y;
import com.bytedance.android.shopping.store.tabkit.monitor.TabKitAppMonitor;
import com.bytedance.android.shopping.store.tabkit.monitor.TabkitFirstFramePref;
import com.bytedance.android.shopping.store.tabkit.monitor.TabkitFramePref;
import com.bytedance.android.shopping.store.tabkit.monitor.TabkitSwitchTabPref;
import com.bytedance.android.shopping.store.tabkit.router.TabKitRouterParams;
import com.bytedance.android.shopping.store.tabkit.view.TopTabItemView;
import com.bytedance.android.shopping.store.utils.n;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.Gson;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.q1;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f*\u0004h}\u0080\u0001\b\u0016\u0018\u0000 \u0094\u00012\u00020\u0001:\u0002\u0095\u0001B\t¢\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\u0018\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0010H\u0002J\b\u0010\u0015\u001a\u00020\u0004H\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0002J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0007H\u0002J\b\u0010\u0019\u001a\u00020\u0004H\u0002J#\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00072\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ&\u0010\"\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00072\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010 0\u001fH\u0002J\u0018\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010 \u0018\u00010#H\u0002J\u0018\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010 \u0018\u00010#H\u0002J\u0018\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010 \u0018\u00010#H\u0002J\u0018\u0010'\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010)\u001a\u0004\u0018\u00010(2\u0006\u0010\u000f\u001a\u00020\u0007H\u0002J\b\u0010*\u001a\u00020\u0004H\u0002J\u0016\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010 0\u001fH\u0002J\u0010\u0010-\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0010H\u0002J\u0018\u00101\u001a\u00020\u00042\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020.H\u0002J\u0012\u00104\u001a\u00020\u00042\b\u00103\u001a\u0004\u0018\u000102H\u0016J\u0012\u00105\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0004J$\u0010;\u001a\u00020:2\u0006\u00107\u001a\u0002062\b\u00109\u001a\u0004\u0018\u0001082\b\u00103\u001a\u0004\u0018\u000102H\u0016J\u001a\u0010=\u001a\u00020\u00042\u0006\u0010<\u001a\u00020:2\b\u00103\u001a\u0004\u0018\u000102H\u0016J\b\u0010>\u001a\u00020\u0004H\u0016J\b\u0010?\u001a\u00020\u0004H\u0016J\u001a\u0010B\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u00102\b\b\u0002\u0010A\u001a\u00020@H\u0016J\u0006\u0010C\u001a\u00020\u0004J\u001e\u0010F\u001a\u00020\u00042\u0016\b\u0002\u0010E\u001a\u0010\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020.\u0018\u00010DR$\u0010G\u001a\u0004\u0018\u0001088\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u0018\u0010M\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010O\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\"\u0010Q\u001a\u00020\u00108\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bQ\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u0018\u0010V\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\"\u0010X\u001a\u00020\u00108\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bX\u0010P\u001a\u0004\bX\u0010R\"\u0004\bY\u0010TR$\u0010Z\u001a\u0004\u0018\u0001088\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bZ\u0010H\u001a\u0004\b[\u0010J\"\u0004\b\\\u0010LR\u0016\u0010]\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010PR\u0016\u0010^\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010PR\u0016\u0010_\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010PR\u0016\u0010`\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010PR\u0016\u0010a\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010PR\u0018\u0010b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010cR\u0018\u0010d\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010cR\u0018\u0010e\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010cR\u0016\u0010f\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010PR\u0016\u0010g\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010PR\u0014\u0010i\u001a\u00020h8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bi\u0010jR\u0014\u0010l\u001a\u00020k8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bl\u0010mR\u001b\u0010r\u001a\u00020k8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bn\u0010o\u001a\u0004\bp\u0010qR\u0018\u0010t\u001a\u0004\u0018\u00010s8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bt\u0010uR$\u0010w\u001a\u0004\u0018\u00010v8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bw\u0010x\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R\u0014\u0010~\u001a\u00020}8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b~\u0010\u007fR\u0018\u0010\u0081\u0001\u001a\u00030\u0080\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u0016\u0010\u0084\u0001\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0083\u0001\u0010RR\u0016\u0010\u0085\u0001\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0085\u0001\u0010RR\u0016\u0010\u0087\u0001\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0086\u0001\u0010RR\u0016\u0010\u0089\u0001\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0088\u0001\u0010RR\u0018\u0010\u008d\u0001\u001a\u00030\u008a\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001R\u0016\u0010\u008e\u0001\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u008e\u0001\u0010RR\u0016\u0010\u0091\u0001\u001a\u0004\u0018\u00010:8F¢\u0006\b\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001¨\u0006\u0096\u0001"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/TabKitHybridTabFragment;", "Lcom/bytedance/android/shopping/store/tabkit/TabKitTabFragment;", "Lti/l;", "component", "", "addLynxViewClient", "onHybridTemplateLoaded", "", "msg", "onLoadFailed", "onLoadSuccess", "updateBackGroundColor", "initTitleView", "updateTitleViewStyle", "initObserver", "url", "", "updateLepusSync", "appendParams", "isFromNetEnd", "setUpdateDataSource", "createHybridComponent", "ensureLiveLynxInitialized", "bundleUrl", "parseBundleUrlParams", "recordPrefetchTiming", "key", "", "tick", "recordTime", "(Ljava/lang/String;Ljava/lang/Long;)V", "", "", "initialData", "injectPurePrefetchData", "", "getPurePrefetchDataSync", "getPurePrefetchDataSyncV2", "getPrefetchInfoSyncV2", "updateGlobalProps", "Lorg/json/JSONObject;", "getNaPrefetchData", "beforeHybridComponentCreate", "buildInitialData", "visible", "notifyMarketingVisibleChange", "", "width", "height", "updateLynxScreenMetrics", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "onHybridLoadFailed", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "view", "onViewCreated", "onPause", "onResume", "Lcom/bytedance/android/shopping/store/tabkit/model/TabVisibleFrom;", "showFrom", "sendVisibleEvent", "retrieveWebView", "Lkotlin/Pair;", "screenInfo", "updateFoldScreenMetrics", "rootView", "Landroid/view/ViewGroup;", "getRootView", "()Landroid/view/ViewGroup;", "setRootView", "(Landroid/view/ViewGroup;)V", "hybridComponent", "Lti/l;", "needTitle", "Z", "isVisibility", "()Z", "setVisibility", "(Z)V", "Landroid/webkit/WebView;", "webView", "Landroid/webkit/WebView;", "isLandingTab", "setLandingTab", "webLandingRoot", "getWebLandingRoot", "setWebLandingRoot", "_isAppInBackground", "updateDataLepus", "updateDataLepusV2", "genTemplateDataOpt", "updateDataLepusOpt", "ecPrefetchRequestId", "Ljava/lang/String;", "ecPrefetchApiKey", "ecPrefetchBffFlag", "tabkitBridgeV2", "setupReport", "com/bytedance/android/shopping/store/tabkit/TabKitHybridTabFragment$c", "lynxViewClient", "Lcom/bytedance/android/shopping/store/tabkit/TabKitHybridTabFragment$c;", "Lti/k;", "lynxCallback", "Lti/k;", "h5Callback$delegate", "Lkotlin/Lazy;", "getH5Callback", "()Lti/k;", "h5Callback", "Lcom/bytedance/android/shopping/store/tabkit/view/TopTabItemView;", "titleViewTop", "Lcom/bytedance/android/shopping/store/tabkit/view/TopTabItemView;", "Landroid/widget/FrameLayout;", "titleContainer", "Landroid/widget/FrameLayout;", "getTitleContainer", "()Landroid/widget/FrameLayout;", "setTitleContainer", "(Landroid/widget/FrameLayout;)V", "com/bytedance/android/shopping/store/tabkit/TabKitHybridTabFragment$prefetchCallback$1", "prefetchCallback", "Lcom/bytedance/android/shopping/store/tabkit/TabKitHybridTabFragment$prefetchCallback$1;", "com/bytedance/android/shopping/store/tabkit/TabKitHybridTabFragment$prefetchCallbackV2$1", "prefetchCallbackV2", "Lcom/bytedance/android/shopping/store/tabkit/TabKitHybridTabFragment$prefetchCallbackV2$1;", "getUseWebLandingOpt1", "useWebLandingOpt1", "isCurrentTabShow", "getLandingFinished", "landingFinished", "getUseWebLandingRoot", "useWebLandingRoot", "Ldm/a$a;", "getLogger", "()Ldm/a$a;", "logger", "isAnchorTab", "getHybridView", "()Landroid/view/View;", "hybridView", "<init>", "()V", "Companion", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class TabKitHybridTabFragment extends TabKitTabFragment {
    public static final a Companion = null;
    private static final String TAG = "TabKitHybridTabFragment";
    private boolean _isAppInBackground;
    private String ecPrefetchApiKey;
    private String ecPrefetchBffFlag;
    private String ecPrefetchRequestId;
    private boolean genTemplateDataOpt;
    private final Lazy h5Callback$delegate;
    private ti.l hybridComponent;
    private boolean isLandingTab;
    private boolean isVisibility;
    private final ti.k lynxCallback;
    private final c lynxViewClient;
    private boolean needTitle;
    private final TabKitHybridTabFragment$prefetchCallback$1 prefetchCallback;
    private final TabKitHybridTabFragment$prefetchCallbackV2$1 prefetchCallbackV2;
    private ViewGroup rootView;
    private boolean setupReport;
    private boolean tabkitBridgeV2;
    private FrameLayout titleContainer;
    private TopTabItemView titleViewTop;
    private boolean updateDataLepus;
    private boolean updateDataLepusOpt;
    private boolean updateDataLepusV2;
    private ViewGroup webLandingRoot;
    private WebView webView;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements ti.k {
        public final /* synthetic */ TabKitHybridTabFragment a;

        public final void b() {
            Intrinsics.checkNotNullParameter("", "errorMessage");
            Intrinsics.checkNotNullParameter("", "errorMessage");
        }

        public b(TabKitHybridTabFragment r1) {
            this.a = r1;
        }

        public final void onFirstScreen(View r2) {
            Intrinsics.checkNotNullParameter(r2, "lynxView");
            Intrinsics.checkNotNullParameter(r2, "lynxView");
        }

        public final void onLoadSuccess(View r2) {
            Intrinsics.checkNotNullParameter(r2, "lynxView");
            TabKitHybridTabFragment.access$onLoadSuccess(this.a);
        }

        public final void onRuntimeReady(View r2) {
            Intrinsics.checkNotNullParameter(r2, "lynxView");
            Intrinsics.checkNotNullParameter(r2, "lynxView");
        }

        public final void g(View r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "view");
            Intrinsics.checkNotNullParameter(r1, "view");
        }

        public final void onLoadFailed(View r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "lynxView");
            TabKitHybridTabFragment.access$onLoadFailed(this.a, r3);
            this.a.onHybridLoadFailed(r3);
        }

        public final void onPageStart(View r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "lynxView");
            Intrinsics.checkNotNullParameter(r1, "lynxView");
        }

        public final void s(View r1, String r2, String r3) {
            Intrinsics.checkNotNullParameter(r1, "view");
            Intrinsics.checkNotNullParameter(r1, "view");
        }
    }

    public static final class c extends q1 {
        public final /* synthetic */ TabKitHybridTabFragment a;

        public final void onLoadSuccess() {
            super.onLoadSuccess();
            if (TabKitHybridTabFragment.access$isAnchorTab$p(this.a) == false) goto L10;
            Lazy r0 = MallSessionMonitor.a;
            String r1 = this.a.getTabKitViewModel().getRouterParams().getAnchorUrl();
            if (r1 != null) goto L7;
            r1 = "";
        L7:
            double r2 = System.currentTimeMillis();
            Intrinsics.checkNotNullParameter(r1, "schema");
            IMallSessionService r3 = (IMallSessionService) MallSessionMonitor.a.getValue();
            if (r3 == null) goto L10;
            r3.a("finish_load_main_url", r1, r2);
        L10:
            TabKitHybridTabFragment.recordTime$default(this.a, TabkitSwitchTabPref.T_TAB_CONTAINER_LOAD_SUCCESS, null, 2, null);
            TabKitHybridTabFragment.access$getLogger$p(this.a).i("load success, sync_update_v1:" + TabKitHybridTabFragment.access$getUpdateDataLepus$p(this.a) + ", sync_update_v2:" + TabKitHybridTabFragment.access$getUpdateDataLepusV2$p(this.a));
            if (TabKitHybridTabFragment.access$getUpdateDataLepusOpt$p(this.a) == true) goto L13;
            return;
        L13:
            if (TabKitHybridTabFragment.access$getUpdateDataLepusV2$p(this.a) == false) goto L16;
            ConcurrentHashMap r4 = NativePrefetchUtil.a;
            NativePrefetchUtil.e(TabKitHybridTabFragment.access$getEcPrefetchRequestId$p(this.a), TabKitHybridTabFragment.access$getEcPrefetchApiKey$p(this.a), TabKitHybridTabFragment.access$getPrefetchCallbackV2$p(this.a));
            return;
        L16:
            if (TabKitHybridTabFragment.access$getUpdateDataLepus$p(this.a) == false) goto L21;
            ConcurrentHashMap r5 = NativePrefetchUtil.a;
            NativePrefetchUtil.e(TabKitHybridTabFragment.access$getEcPrefetchRequestId$p(this.a), TabKitHybridTabFragment.access$getEcPrefetchApiKey$p(this.a), TabKitHybridTabFragment.access$getPrefetchCallback$p(this.a));
            return;
        }

        public final void onLynxViewAndJSRuntimeDestroy() {
            super.onLynxViewAndJSRuntimeDestroy();
            TabKitHybridTabFragment.access$getLogger$p(this.a).i("runtime destroy, sync_update_v1:" + TabKitHybridTabFragment.access$getUpdateDataLepus$p(this.a) + ", sync_update_v2:" + TabKitHybridTabFragment.access$getUpdateDataLepusV2$p(this.a));
            if (TabKitHybridTabFragment.access$getUpdateDataLepus$p(this.a) == false) goto L5;
        L6:
            ConcurrentHashMap r0 = NativePrefetchUtil.a;
            NativePrefetchUtil.o(TabKitHybridTabFragment.access$getEcPrefetchRequestId$p(this.a), TabKitHybridTabFragment.access$getEcPrefetchApiKey$p(this.a));
            return;
        L5:
            if (TabKitHybridTabFragment.access$getUpdateDataLepusV2$p(this.a) == true) goto L6;
        }

        public final void onRuntimeReady() {
            super.onRuntimeReady();
            if (TabKitHybridTabFragment.access$isAnchorTab$p(this.a) == false) goto L10;
            Lazy r0 = MallSessionMonitor.a;
            String r1 = this.a.getTabKitViewModel().getRouterParams().getAnchorUrl();
            if (r1 != null) goto L7;
            r1 = "";
        L7:
            double r2 = System.currentTimeMillis();
            Intrinsics.checkNotNullParameter(r1, "schema");
            IMallSessionService r3 = (IMallSessionService) MallSessionMonitor.a.getValue();
            if (r3 == null) goto L10;
            r3.a("lynx_js_runtime_ready", r1, r2);
        L10:
            TabKitHybridTabFragment.recordTime$default(this.a, TabkitSwitchTabPref.T_TAB_CONTAINER_RUNTIME_READY, null, 2, null);
            TabKitHybridTabFragment.access$getLogger$p(this.a).i("runtime ready, sync_update_v1:" + TabKitHybridTabFragment.access$getUpdateDataLepus$p(this.a) + ", sync_update_v2:" + TabKitHybridTabFragment.access$getUpdateDataLepusV2$p(this.a));
            if (TabKitHybridTabFragment.access$getUpdateDataLepusOpt$p(this.a) == false) goto L13;
            return;
        L13:
            if (TabKitHybridTabFragment.access$getUpdateDataLepusV2$p(this.a) == false) goto L16;
            ConcurrentHashMap r4 = NativePrefetchUtil.a;
            NativePrefetchUtil.e(TabKitHybridTabFragment.access$getEcPrefetchRequestId$p(this.a), TabKitHybridTabFragment.access$getEcPrefetchApiKey$p(this.a), TabKitHybridTabFragment.access$getPrefetchCallbackV2$p(this.a));
            return;
        L16:
            if (TabKitHybridTabFragment.access$getUpdateDataLepus$p(this.a) == false) goto L21;
            ConcurrentHashMap r5 = NativePrefetchUtil.a;
            NativePrefetchUtil.e(TabKitHybridTabFragment.access$getEcPrefetchRequestId$p(this.a), TabKitHybridTabFragment.access$getEcPrefetchApiKey$p(this.a), TabKitHybridTabFragment.access$getPrefetchCallback$p(this.a));
            return;
        }

        public c(TabKitHybridTabFragment r1) {
            this.a = r1;
        }

        public final void onTimingSetup(Map<String, Object> r5) {
            if (TabKitHybridTabFragment.access$isAnchorTab$p(this.a) == true) goto L5;
            return;
        L5:
            if (TabKitHybridTabFragment.access$getSetupReport$p(this.a) == true) goto L15;
            Lazy r6 = MallSessionMonitor.a;
            String r7 = this.a.getTabKitViewModel().getRouterParams().getAnchorUrl();
            if (r7 != null) goto L9;
            r7 = "";
        L9:
            double r0 = System.currentTimeMillis();
            Intrinsics.checkNotNullParameter(r7, "schema");
            IMallSessionService r2 = (IMallSessionService) MallSessionMonitor.a.getValue();
            if (r2 == null) goto L12;
            r2.a("lynx_first_setup", r7, r0);
        L12:
            TabKitHybridTabFragment.access$setSetupReport$p(this.a, true);
            return;
        }
    }

    public static final class d extends FrameLayout {
        public final /* synthetic */ TabKitHybridTabFragment a;

        public d(TabKitHybridTabFragment r1, Context r2) {
            this.a = r1;
            super(r2);
        }

        @Override // android.widget.FrameLayout, android.view.View
        public final void onMeasure(int r2, int r3) {
            super.onMeasure(r2, r3);
            TabKitHybridTabFragment.access$updateLynxScreenMetrics(this.a, getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ TabKitHybridTabFragment a;
        public final /* synthetic */ boolean b;

        public e(TabKitHybridTabFragment r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            if (this.b == false) goto L8;
            if (this.a.isResumed() == true) goto L8;
            return;
        L8:
            if (this.b == this.a.isVisibility()) goto L29;
            ti.l r0 = TabKitHybridTabFragment.access$getHybridComponent$p(this.a);
            if (r0 == null) goto L12;
            r0.sendJsEvent("H5_visibilityChange", new JSONObject().put("visible", this.b));
        L12:
            int r1 = ECSdk.a;
            IEShoppingService r2 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
            if (r2 == null) goto L18;
            n83.a r3 = r2.getAppLifecycleObserver();
            if (r3 == null) goto L18;
            r3.isAppInBackground();
        L18:
            if (TabKitHybridTabFragment.access$get_isAppInBackground$p(this.a) == false) goto L20;
            TabKitHybridTabFragment.access$set_isAppInBackground$p(this.a, false);
            String r4 = "app";
        L21:
            ti.l r5 = TabKitHybridTabFragment.access$getHybridComponent$p(this.a);
            if (r5 == null) goto L25;
            JSONObject r6 = new JSONObject();
            r6.put("visible", this.b);
            r6.put("source", r4);
            Unit r7 = Unit.INSTANCE;
            r5.sendJsEvent("pageVisibilityChange", r6);
        L25:
            if ((!Intrinsics.areEqual(r4, "app")) == false) goto L27;
            TabKitHybridTabFragment.access$notifyMarketingVisibleChange(this.a, this.b);
        L27:
            this.a.setVisibility(this.b);
            return;
        L20:
            r4 = "page";
            goto L21
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.shopping.store.tabkit.TabKitHybridTabFragment$initObserver$5, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/android/shopping/store/tabkit/TabKitHybridTabFragment$initObserver$5", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class AnonymousClass5 implements Observer<Boolean> {
        public final /* synthetic */ TabKitHybridTabFragment a;

        public AnonymousClass5(TabKitHybridTabFragment r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            if (((Boolean) r2).booleanValue() == false) goto L8;
            WebView r3 = TabKitHybridTabFragment.access$getWebView$p(this.a);
            if (r3 == null) goto L9;
            r3.post(new j(this));
            return;
        L9:
            return;
        }
    }

    static {
        Companion = new a();
    }

    private final ti.k getH5Callback() {
        return (ti.k) this.h5Callback$delegate.getValue();
    }

    private final void beforeHybridComponentCreate() {
        if (this.isLandingTab == false) goto L9;
        ok3.a r0 = getTabKitViewModel().getTabKitMonitor();
        if (r0 == null) goto L12;
        TabkitFirstFramePref r1 = r0.d;
        if (r1 == null) goto L12;
        TabkitFramePref.recordTime$default(r1, "t_tab_container_init_start", null, 2, null);
    L12:
        ok3.a r2 = getTabKitViewModel().getTabKitMonitor();
        if (r2 == null) goto L16;
        r2.g(getTabId(), this.isLandingTab);
        return;
    L16:
        return;
    L9:
        ok3.a r3 = getTabKitViewModel().getTabKitMonitor();
        if (r3 == null) goto L12;
        TabkitFramePref.recordTime$default(r3.c(getTabId()), "t_tab_container_init_start", null, 2, null);
        goto L12
    }

    private final Map<String, Object> buildInitialData() {
        TabKitRouterParams r1 = getTabKitViewModel().getRouterParams();
        Integer r2 = null;
        if (r1 == null) goto L5;
        HashMap<String, String> r3 = r1.getParamsMap();
    L7:
        if ((r3 instanceof Map) == true) goto L9;
        r3 = null;
    L9:
        JSONObject r0 = new JSONObject(r3);
        int r4 = !getTabKitViewModel().isAnchorFinished() ? 1 : 0;
        HashMap r5 = new HashMap();
        r5.put("frame_data", GsonProtectorUtils.toJson(new Gson(), getTabKitViewModel().getTabResponse().getValue()));
        r5.put("tab_data", GsonProtectorUtils.toJson(new Gson(), getTab()));
        r5.put("router_params", r0);
        r5.put("screen_state", getTabKitViewModel().getScreenState().getValue());
        r5.put("monitor_enter_type", Integer.valueOf(r4 ^ 1));
        if (r4 == 0) goto L12;
        r5.put("monitor_page_begin_time", k.a);
        getTabKitViewModel().setAnchorFinished(true);
    L12:
        Long r6 = k.a;
        com.bytedance.android.shopping.store.tabkit.model.k r7 = getTab();
        if (r7 == null) goto L15;
        r2 = r7.n();
    L15:
        r5.put("monitor_tab_begin_time", k.a(r2));
        HashMap r8 = new HashMap();
        r8.put("meta_info", r5);
        r8.put("tabs_container_id", getTabKitViewModel().getTabsContainerId());
        return r8;
    L5:
        r3 = null;
        goto L7
    }

    private final void createHybridComponent() {
        cl.d.a.getClass();
        cl.d r0 = cl.d.a.b();
        if (r0 == null) goto L6;
        r0.n();
    L6:
        if (this.hybridComponent == null) goto L8;
        return;
    L8:
        com.bytedance.android.shopping.store.tabkit.model.k r13 = getTab();
        if (r13 != null) goto L11;
        return;
    L11:
        FragmentActivity r1 = getContext();
        if (r1 != null) goto L14;
        return;
    L14:
        final Ref.ObjectRef r14 = new Ref.ObjectRef();
        s r2 = r13.f();
        if (r2 == null) goto L210;
        String r3 = r2.b();
        if (r3 == null) goto L212;
        r14.element = r3;
        beforeHybridComponentCreate();
        boolean r15 = com.bytedance.android.shopping.store.tabkit.e.l(r13);
        Integer r4 = r13.n();
        if (r4 == null) goto L24;
        int r5 = r4.intValue();
        SparseArray<Long> r6 = k.b;
        if (r6.get(r5) != null) goto L24;
        r6.put(r5, Long.valueOf(System.currentTimeMillis()));
    L24:
        Map<String, Object> r11 = buildInitialData();
        if (r15 == false) goto L27;
        ti.k r7 = this.lynxCallback;
    L28:
        ti.k r8 = r7;
        if (getTabKitViewModel().getAbilityConfig().b("na_prefetch_opt") == false) goto L31;
        Map<String, Long> r9 = TabkitPrefetch.a;
        TabkitPrefetch.c(getTabKitViewModel().getRouterParams().getBizTag());
    L31:
        dm.a.a("ECTabKitDebug").i("before container init NA Prefetch ---> " + System.currentTimeMillis());
        boolean r10 = getTabKitViewModel().getAbilityConfig().b("na_prefetch_thread_opt");
        boolean r12 = getTabKitViewModel().getAbilityConfig().b("na_prefetch_sync_update");
        String r16 = appendParams((String) r14.element, r12);
        r14.element = r16;
        this.updateDataLepusV2 = hk3.b.c(r16);
        this.genTemplateDataOpt = hk3.b.e((String) r14.element);
        Map<String, Long> r17 = TabkitPrefetch.a;
        String r18 = (String) r14.element;
        if (r12 == false) goto L34;
    L37:
        boolean r19 = true;
    L38:
        r14.element = TabkitPrefetch.a(r18, r15, null, r10, r19, 36).a;
        getLogger().i("create hybrid component, url:" + ((String) r14.element));
        parseBundleUrlParams((String) r14.element);
        if (this.updateDataLepus == true) goto L43;
        if (this.updateDataLepusV2 == true) goto L43;
    L47:
        injectPurePrefetchData((String) r14.element, r11);
        if (hk3.b.a((String) r14.element) == false) goto L50;
    L53:
        boolean r20 = true;
    L54:
        if (r20 == false) goto L56;
        r14.element = n.a((String) r14.element);
    L56:
        Fragment r21 = getParentFragment();
        ti.l r22 = null;
        if (r21 == null) goto L59;
        Fragment r23 = r21.getParentFragment();
    L61:
        if ((r23 instanceof TabKitDialogFragment) == true) goto L63;
        r23 = null;
    L63:
        TabKitDialogFragment r24 = (TabKitDialogFragment) r23;
        if (r24 == null) goto L67;
        Lifecycle r25 = r24.getLifecycle();
        if (r25 == null) goto L67;
    L78:
        if (r25 == null) goto L80;
    L87:
        Lifecycle r26 = r25;
    L89:
        if (isAnchorTab() == false) goto L96;
        Lazy r27 = MallSessionMonitor.a;
        String r28 = getTabKitViewModel().getRouterParams().getAnchorUrl();
        if (r28 != null) goto L93;
        r28 = "";
    L93:
        double r29 = System.currentTimeMillis();
        Intrinsics.checkNotNullParameter(r28, "schema");
        IMallSessionService r30 = (IMallSessionService) MallSessionMonitor.a.getValue();
        if (r30 == null) goto L96;
        r30.a("start_load_main_url", r28, r29);
    L96:
        Lazy r31 = ECAppInfoService.a;
        if (we.a.a == false) goto L132;
        String r32 = (String) r14.element;
        if (getUseWebLandingRoot() == false) goto L101;
        ViewGroup r33 = this.webLandingRoot;
    L102:
        if (r15 == false) goto L104;
        ECLiveHybridUtil.HybridType r34 = ECLiveHybridUtil.HybridType.LYNX;
    L105:
        ECLiveHybridUtil.a r35 = ECLiveHybridUtil.a;
        if ((r1 instanceof FragmentActivity) == true) goto L108;
        FragmentActivity r36 = null;
    L109:
        FragmentActivity r37 = r36;
        if (r37 == null) goto L112;
        Lifecycle r38 = r37.getLifecycle();
    L113:
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r32, "url");
        if (StringsKt.startsWith$default(r32, "http", false, 2, null) == true) goto L116;
        String r39 = r32;
    L120:
        Ref.ObjectRef r40 = new Ref.ObjectRef();
        pd.b r41 = ECLiveHybridUtil.a(r1, r39, new com.bytedance.android.ec.core.hybrid.utils.d());
        r40.element = r41;
        if (r41 != null) goto L123;
        ti.l r42 = null;
    L131:
        this.hybridComponent = r42;
        r11 = r11;
    L174:
        if (r15 == false) goto L178;
        ti.l r43 = this.hybridComponent;
        if (r43 == null) goto L181;
        r43.updateData(r11);
    L181:
        ti.l r44 = this.hybridComponent;
        if (r44 == null) goto L185;
        getTabKitViewModel().getHybridComponents().add(r44);
        com.bytedance.android.shopping.store.tabkit.e.n(r44, getTabKitViewModel().getJsBridge(), r13, this.tabkitBridgeV2);
    L185:
        if (this.isLandingTab == false) goto L197;
        ok3.a r45 = getTabKitViewModel().getTabKitMonitor();
        if (r45 == null) goto L206;
        TabkitFirstFramePref r46 = r45.d;
        if (r46 == null) goto L206;
        ti.f r47 = null;
        TabkitFramePref.recordTime$default(r46, "t_tab_container_init_end", null, 2, null);
        ti.f r48 = this.hybridComponent;
        if ((r48 instanceof ti.f) == false) goto L194;
        r47 = r48;
    L194:
        ti.f r49 = r47;
        if (r49 == null) goto L206;
        r46.recordEvent("hit_pre_create_annie_model_cache", Boolean.valueOf(r49.d()));
        r46.recordEvent("hit_pre_create_annie_web_cache", Boolean.valueOf(r49.c()));
        r46.recordTime("t_finish_pre_create_annie_model", Long.valueOf(r49.e()));
        r46.recordTime("t_finish_pre_create_annie_web", Long.valueOf(r49.a()));
    L206:
        FrameLayout r50 = this.titleContainer;
        if (r50 == null) goto L211;
        r50.bringToFront();
        return;
    L211:
        return;
    L197:
        ti.f r51 = null;
        ok3.a r52 = getTabKitViewModel().getTabKitMonitor();
        if (r52 == null) goto L206;
        TabkitSwitchTabPref r53 = r52.c(getTabId());
        TabkitFramePref.recordTime$default(r53, "t_tab_container_init_end", null, 2, null);
        ti.f r54 = this.hybridComponent;
        if ((r54 instanceof ti.f) == false) goto L203;
        r51 = r54;
    L203:
        ti.f r55 = r51;
        if (r55 == null) goto L206;
        r53.recordEvent("hit_pre_create_annie_model_cache", Boolean.valueOf(r55.d()));
        r53.recordEvent("hit_pre_create_annie_web_cache", Boolean.valueOf(r55.c()));
        r53.recordTime("t_finish_pre_create_annie_model", Long.valueOf(r55.e()));
        r53.recordTime("t_finish_pre_create_annie_web", Long.valueOf(r55.a()));
        goto L206
    L178:
        Map<String, Object> r56 = r11;
        ti.l r57 = this.hybridComponent;
        if (r57 == null) goto L181;
        r57.updateBusinessGlobalProps(r56);
        goto L181
    L123:
        View r58 = r41.getHybridView();
        if (r58 == null) goto L126;
        r58.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    L126:
        if (r33 == null) goto L128;
        r33.addView(((pd.b) r40.element).getHybridView());
    L128:
        r42 = new com.bytedance.android.ec.core.hybrid.utils.e(r40);
        r42.renderTemplate(r32, r11);
        if (r38 == null) goto L131;
        r38.addObserver(new ECLiveHybridUtil$createLiveHybridComponentForSaaS$.inlined.let.lambda.1(r38, r42));
        goto L131
    L116:
        if (r34 != ECLiveHybridUtil.HybridType.LYNX) goto L118;
        r39 = "sslocal://webcast_lynxview?hybrid_type=lynx&url=" + r32;
        goto L120
    L118:
        r39 = "sslocal://webcast_webview?hybrid_type=h5&url=" + r32;
        goto L120
    L112:
        r38 = null;
        goto L113
    L108:
        r36 = r1;
        goto L109
    L104:
        r34 = ECLiveHybridUtil.HybridType.WEB;
        goto L105
    L101:
        r33 = this.rootView;
        goto L102
    L132:
        if (r15 == true) goto L147;
        s r59 = r13.f();
        if (r59 == null) goto L136;
        Integer r60 = r59.d();
    L137:
        if (r60 == null) goto L147;
        if (r60.intValue() != 1) goto L147;
        if (getTabKitViewModel().getAbilityConfig().b("disable_anniex_container") == true) goto L147;
        int r61 = ECSdk.a;
        IECHostService r62 = (IECHostService) ECSdk.a(IECHostService.class);
        if (r62 == null) goto L158;
        r62.getECAnnieXHostService();
    L158:
        this.hybridComponent = r22;
        if (r22 != null) goto L165;
        StringBuilder r63 = new StringBuilder("createAnnieXWebComponent return null, type:");
        s r64 = r13.f();
        if (r64 == null) goto L163;
        Integer r65 = r64.d();
    L164:
        r63.append(r65);
        ECExceptionMonitor.c(r63.toString());
        goto L165
    L163:
        r65 = null;
    L165:
        int r66 = lk3.a.a;
        String r67 = (String) r14.element;
        if (r15 == false) goto L168;
        String r68 = "lynx";
    L170:
        if (this.hybridComponent == null) goto L172;
        boolean r110 = true;
    L173:
        lk3.a.a(r67, r68, r110);
        goto L174
    L172:
        r110 = false;
        goto L173
    L168:
        r68 = "web";
        goto L170
    L136:
        r60 = null;
    L147:
        if (r15 == false) goto L149;
        ensureLiveLynxInitialized();
    L149:
        String r69 = (String) r14.element;
        if (getUseWebLandingRoot() == false) goto L152;
        ViewGroup r70 = this.webLandingRoot;
    L153:
        ViewGroup r71 = r70;
        if (r15 == false) goto L156;
        ECLiveHybridUtil.HybridType r72 = ECLiveHybridUtil.HybridType.LYNX;
    L157:
        r22 = ECLiveHybridUtil.b(r1, r69, r11, r71, r8, r72, r26, true, this, new AnonymousClass3(this, r14), false, 2176);
        goto L158
    L156:
        r72 = ECLiveHybridUtil.HybridType.WEB;
        goto L157
    L152:
        r70 = this.rootView;
        goto L153
    L80:
        if ((r1 instanceof FragmentActivity) == true) goto L82;
        FragmentActivity r73 = null;
    L83:
        FragmentActivity r74 = r73;
        if (r74 == null) goto L86;
        r25 = r74.getLifecycle();
        goto L87
    L86:
        r26 = null;
        goto L89
    L82:
        r73 = r1;
    L67:
        Fragment r75 = getParentFragment();
        if (r75 == null) goto L70;
        Fragment r76 = r75.getParentFragment();
    L72:
        if ((r76 instanceof TabKitFoldFragment) == true) goto L74;
        r76 = null;
    L74:
        TabKitFoldFragment r77 = (TabKitFoldFragment) r76;
        if (r77 == null) goto L77;
        r25 = r77.getLifecycle();
        goto L78
    L77:
        r25 = null;
        goto L78
    L70:
        r76 = null;
        goto L72
    L59:
        r23 = null;
        goto L61
    L50:
        if (hk3.b.b((String) r14.element) == true) goto L53;
        r20 = false;
    L43:
        if (hk3.b.f((String) r14.element) <= 0) goto L45;
        boolean r78 = true;
    L46:
        this.updateDataLepusOpt = r78;
        goto L47
    L45:
        r78 = false;
        goto L46
    L34:
        if (this.updateDataLepusV2 == true) goto L37;
        r19 = false;
        goto L38
    L27:
        r7 = getH5Callback();
        goto L28
    L212:
        return;
    }

    private final void ensureLiveLynxInitialized() {
        recordTime$default(this, TabkitSwitchTabPref.T_TAB_CHECK_ENV_START_TIME, null, 2, null);
        int r0 = ECSdk.a;
        IECHostService r1 = (IECHostService) ECSdk.a(IECHostService.class);
        if (r1 == null) goto L5;
        r1.getECAnnieXHostService();
    L5:
        recordTime$default(this, TabkitSwitchTabPref.T_TAB_CHECK_ENV_END_TIME, null, 2, null);
    }

    private final dm.a.a getLogger() {
        return dm.a.a(TAG);
    }

    private final Map<String, Object> getPrefetchInfoSyncV2() {
        if (this.updateDataLepusV2 == true) goto L6;
        return null;
    L6:
        LinkedHashMap r0 = new LinkedHashMap();
        ConcurrentHashMap r1 = NativePrefetchUtil.a;
        q r2 = NativePrefetchUtil.h(this.ecPrefetchRequestId, this.ecPrefetchApiKey);
        if (r2 == null) goto L9;
        r0.put("perf_timing", r2.a());
        r0.put("net_detail", r2.a);
    L9:
        JSONObject r3 = NativePrefetchUtil.g(this.ecPrefetchRequestId, this.ecPrefetchApiKey);
        if (r3 == null) goto L12;
        r0.put("extra_info", r3);
    L12:
        return r0;
    }

    private final Map<String, Object> getPurePrefetchDataSync() {
        if (this.updateDataLepus == true) goto L5;
        return null;
    L5:
        ConcurrentHashMap r0 = NativePrefetchUtil.a;
        String r1 = NativePrefetchUtil.d(this.ecPrefetchRequestId, this.ecPrefetchApiKey);
        if (r1 == null) goto L21;
        Map<String, Object> r2 = com.bytedance.android.shopping.store.utils.f.c(r1);
        if (r2 == null) goto L25;
        String r3 = this.ecPrefetchBffFlag;
        if (r3 == null) goto L22;
        Object r4 = r2.get(r3);
        if (r4 != null) goto L15;
        return null;
    L15:
        if (Intrinsics.areEqual(r4, CommentScene.COMMENTSCENE_NO_AWEME) == true) goto L18;
        r4 = null;
    L18:
        if (r4 != null) goto L20;
        return null;
    L20:
        return r2;
    L22:
        return null;
    L25:
        return null;
    L21:
        return null;
    }

    private final Map<String, Object> getPurePrefetchDataSyncV2() {
        if (this.updateDataLepusV2 == true) goto L5;
        return null;
    L5:
        ConcurrentHashMap r0 = NativePrefetchUtil.a;
        String r1 = NativePrefetchUtil.d(this.ecPrefetchRequestId, this.ecPrefetchApiKey);
        if (r1 != null) goto L8;
        return null;
    L8:
        return com.bytedance.android.shopping.store.utils.f.c(r1);
    }

    private final boolean getUseWebLandingRoot() {
        if (this.isLandingTab == false) goto L13;
        com.bytedance.android.shopping.store.tabkit.model.k r0 = getTab();
        if (r0 == null) goto L13;
        if (com.bytedance.android.shopping.store.tabkit.e.m(r0) != true) goto L13;
        if (getLandingFinished() == false) goto L13;
        if (this.webLandingRoot == null) goto L13;
        return true;
    L13:
        return false;
    }

    private final void initTitleView() {
        if (this.needTitle == false) goto L14;
        TopTabItemView r0 = new TopTabItemView(requireContext(), null, 6, 0);
        r0.setEnableImageIcon(false);
        FrameLayout.LayoutParams r1 = new FrameLayout.LayoutParams(-2, -2);
        r1.gravity = 17;
        Unit r3 = Unit.INSTANCE;
        r0.setLayoutParams(r1);
        this.titleViewTop = r0;
        r0.setTab(getTab());
        TopTabItemView r2 = this.titleViewTop;
        if (r2 == null) goto L7;
        r2.setSelected(true);
    L7:
        updateTitleViewStyle();
        FrameLayout r4 = new FrameLayout(requireContext());
        FrameLayout.LayoutParams r5 = new FrameLayout.LayoutParams(-2, com.bytedance.android.shopping.extensions.b.b(44));
        r5.gravity = 49;
        if (getTabKitViewModel().isFullScreen() == false) goto L10;
        r5.setMargins(r5.leftMargin, UIUtils.getStatusBarHeight(r4.getContext()), r5.rightMargin, r5.bottomMargin);
    L10:
        r4.setLayoutParams(r5);
        r4.addView(this.titleViewTop);
        this.titleContainer = r4;
        ViewGroup r6 = this.rootView;
        if (r6 == null) goto L15;
        r6.addView(r4);
        return;
    L15:
        return;
    }

    private final void onHybridTemplateLoaded() {
        if (this.isLandingTab == true) goto L8;
        ok3.a r0 = getTabKitViewModel().getTabKitMonitor();
        if (r0 == null) goto L9;
        TabkitFramePref.recordTime$default(r0.c(getTabId()), "t_render_tab_end", null, 2, null);
        return;
    L9:
        return;
    }

    private final void onLoadSuccess() {
        ViewGroup r0 = this.rootView;
        if (r0 == null) goto L6;
        r0.setVisibility(0);
        return;
    }

    private final void recordPrefetchTiming() {
        ConcurrentHashMap r0 = NativePrefetchUtil.a;
        q r1 = NativePrefetchUtil.h(this.ecPrefetchRequestId, this.ecPrefetchApiKey);
        if (r1 == null) goto L18;
        Long r2 = r1.c();
        if (r2 == null) goto L7;
        recordTime(TabkitSwitchTabPref.T_TAB_NET_START_TIME, Long.valueOf(r2.longValue()));
    L7:
        Long r3 = r1.b();
        if (r3 == null) goto L10;
        recordTime(TabkitSwitchTabPref.T_TAB_NET_END_TIME, Long.valueOf(r3.longValue()));
    L10:
        JSONObject r4 = r1.a();
        v r5 = getTabState();
        if (r5 == null) goto L13;
        r5.a = r4;
    L13:
        JSONObject r6 = r1.a;
        if (r6 == null) goto L18;
        v r7 = getTabState();
        if (r7 == null) goto L18;
        r7.b = r6;
    L18:
        JSONObject r8 = NativePrefetchUtil.g(this.ecPrefetchRequestId, this.ecPrefetchApiKey);
        if (r8 == null) goto L24;
        v r9 = getTabState();
        if (r9 == null) goto L25;
        r9.c = r8;
        return;
    L25:
        return;
    }

    public final View getHybridView() {
        ti.l r0 = this.hybridComponent;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getHybridView();
    }

    public TabKitHybridTabFragment() {
        this.isVisibility = true;
        this.lynxViewClient = new c(this);
        this.lynxCallback = new b(this);
        this.h5Callback$delegate = LazyKt.lazy(new TabKitHybridTabFragment$h5Callback$2(this));
        this.prefetchCallback = new TabKitHybridTabFragment$prefetchCallback$1(this);
        this.prefetchCallbackV2 = new TabKitHybridTabFragment$prefetchCallbackV2$1(this);
    }

    private final boolean getLandingFinished() {
        if (getTabKitViewModel().getLandingFinishedOpt() == false) goto L11;
        if (com.bytedance.android.shopping.extensions.k.c(getTabKitViewModel().getRouterParams().getAnchorUrl()) == true) goto L7;
    L9:
        return false;
    L7:
        if (Intrinsics.areEqual((Boolean) getTabKitViewModel().getPageLandingFinished().getValue(), Boolean.FALSE) == false) goto L9;
        return true;
    L11:
        return Intrinsics.areEqual((Boolean) getTabKitViewModel().isLandingFinished().getValue(), Boolean.FALSE);
    }

    private final boolean getUseWebLandingOpt1() {
        if (getTabKitViewModel().getAbilityConfig().a("web_landing_opt") == 1) goto L5;
    L7:
        return false;
    L5:
        if (this.isLandingTab == false) goto L7;
        return true;
    }

    private final void initObserver() {
        getTabKitViewModel().getScreenOffsetFactor().observe(getViewLifecycleOwner(), new AnonymousClass1(this));
        getTabKitViewModel().getCurrentTab().observe(getViewLifecycleOwner(), new AnonymousClass2(this));
        getTabKitViewModel().getScreenState().observe(getViewLifecycleOwner(), new C01973(this));
        getTabKitViewModel().isUseNativeTopBar().observe(getViewLifecycleOwner(), new AnonymousClass4(this));
        if (getUseWebLandingOpt1() == true) goto L5;
        return;
    L5:
        if (getTabKitViewModel().getLandingFinishedOpt() == false) goto L7;
        MutableLiveData<Boolean> r0 = getTabKitViewModel().getPageLandingFinished();
    L8:
        r0.observe(getViewLifecycleOwner(), new AnonymousClass5(this));
        return;
    L7:
        r0 = getTabKitViewModel().isLandingFinished();
        goto L8
    }

    private final boolean isAnchorTab() {
        Integer r0 = getTabKitViewModel().getAnchorTabId();
        com.bytedance.android.shopping.store.tabkit.model.k r1 = getTab();
        if (r1 == null) goto L5;
        Integer r2 = r1.n();
    L7:
        return Intrinsics.areEqual(r0, r2);
    L5:
        r2 = null;
        goto L7
    }

    private final boolean isCurrentTabShow() {
        y r0 = (y) getTabKitViewModel().getCurrentTab().getValue();
        if (r0 == null) goto L5;
        com.bytedance.android.shopping.store.tabkit.model.k r1 = r0.a;
    L7:
        return Intrinsics.areEqual(r1, getTab());
    L5:
        r1 = null;
        goto L7
    }

    private final void updateBackGroundColor() {
        com.bytedance.android.shopping.store.tabkit.model.k r0 = getTab();
        Unit r1 = null;
        if (r0 == null) goto L5;
        Integer r2 = r0.n();
    L7:
        if (Intrinsics.areEqual(r2, getTabKitViewModel().getRouterParams().getAnchorTabId()) == true) goto L35;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L30
        com.bytedance.android.shopping.store.tabkit.model.k r4 = getTab();     // Catch: Throwable -> L30
        if (r4 == null) goto L28;
        String r5 = r4.e();     // Catch: Throwable -> L30
        if (r5 == null) goto L28;
        ViewGroup r6 = this.rootView;     // Catch: Throwable -> L30
        if (r6 == null) goto L28;
        r6.setBackgroundColor(Color.parseColor(r5));     // Catch: Throwable -> L30
        r1 = Unit.INSTANCE;     // Catch: Throwable -> L30
    L28:
        Result.constructor-impl(r1);     // Catch: Throwable -> L30
        return;
    L30:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L35:
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L19
        com.bytedance.android.shopping.store.tabkit.model.k r9 = getTab();     // Catch: Throwable -> L19
        if (r9 == null) goto L12;
        String r10 = r9.e();     // Catch: Throwable -> L19
        if (r10 == null) goto L12;
    L13:
        if (r10 == null) goto L17;
        ViewGroup r11 = this.rootView;     // Catch: Throwable -> L19
        if (r11 == null) goto L17;
        r11.setBackgroundColor(Color.parseColor(r10));     // Catch: Throwable -> L19
        r1 = Unit.INSTANCE;     // Catch: Throwable -> L19
    L17:
        Result.constructor-impl(r1);     // Catch: Throwable -> L19
        return;
    L12:
        r10 = getTabKitViewModel().getRouterParams().getAnchorBGColor();     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L5:
        r2 = null;
        goto L7
    }

    private final void updateTitleViewStyle() {
        Boolean r0 = (Boolean) getTabKitViewModel().isUseNativeTopBar().getValue();
        Boolean r1 = Boolean.TRUE;
        if (Intrinsics.areEqual(r0, r1) == false) goto L58;
        com.bytedance.android.shopping.store.tabkit.model.k r2 = getTab();
        Integer r3 = null;
        if (r2 == null) goto L9;
        com.bytedance.android.shopping.store.tabkit.model.q r4 = r2.p();
        if (r4 == null) goto L9;
        p r5 = com.bytedance.android.shopping.store.tabkit.e.o(r4, getTabKitViewModel());
    L10:
        TopTabItemView r6 = this.titleViewTop;
        if (r6 == null) goto L13;
        r6.setTabBarStyleConfig(r5);
    L13:
        TopTabItemView r7 = this.titleViewTop;
        if (r7 == null) goto L16;
        r7.setFullScreenState(getTabKitViewModel().isFullScreen());
    L16:
        if (r5 == null) goto L18;
        Integer r8 = r5.c();
    L20:
        if (r8 != null) goto L23;
    L27:
        if (r8 != null) goto L30;
    L34:
        FrameLayout r9 = this.titleContainer;
        if (r9 == null) goto L37;
        r9.setVisibility(0);
    L37:
        com.bytedance.android.shopping.store.tabkit.model.d r10 = getTabKitViewModel().getTopTabBarVisibilityMap().get(getTab());
        if (getTabKitViewModel().isFullScreen() == true) goto L41;
        if (r10 == null) goto L43;
        Boolean r11 = r10.a;
    L45:
        if (Intrinsics.areEqual(r11, r1) == false) goto L50;
        FrameLayout r12 = this.titleContainer;
        if (r12 == null) goto L54;
        r12.setVisibility(0);
    L54:
        FrameLayout r13 = this.titleContainer;
        if (r5 == null) goto L57;
        r3 = r5.a();
    L57:
        com.bytedance.android.shopping.store.tabkit.e.b(r13, r3, getTabKitFragment().Mc().k, getTabKitFragment().Mc().j);
        return;
    L50:
        if (Intrinsics.areEqual(r11, Boolean.FALSE) == false) goto L54;
        FrameLayout r14 = this.titleContainer;
        if (r14 == null) goto L54;
        ExtensionsKt.gone(r14);
    L43:
        r11 = null;
        goto L45
    L41:
        if (r10 == null) goto L43;
        r11 = r10.b;
        goto L45
    L30:
        if (r8.intValue() != 1) goto L34;
        FrameLayout r15 = this.titleContainer;
        if (r15 == null) goto L37;
        r15.setVisibility(0);
        goto L37
    L23:
        if (r8.intValue() != 2) goto L27;
        FrameLayout r16 = this.titleContainer;
        if (r16 == null) goto L37;
        ExtensionsKt.gone(r16);
        goto L37
    L18:
        r8 = null;
    L9:
        r5 = null;
        goto L10
    L58:
        FrameLayout r17 = this.titleContainer;
        if (r17 == null) goto L63;
        ExtensionsKt.gone(r17);
        return;
    }

    public void onPause() {
        super.onPause();
        boolean r2 = true;
        if (getTabKitViewModel().getLandingFinishedOpt() == false) goto L16;
        String r0 = getTabKitViewModel().getRouterParams().getAnchorUrl();
        if (r0 != null) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == true) goto L18;
        if ((!Intrinsics.areEqual((Boolean) getTabKitViewModel().getPageLandingFinished().getValue(), Boolean.FALSE)) == true) goto L18;
        r2 = false;
    L18:
        if (isCurrentTabShow() == false) goto L22;
        if (r2 == false) goto L23;
        sendVisibleEvent$default(this, false, null, 2, null);
        return;
    L23:
        return;
    L22:
        return;
    L7:
        if (r0.length() == 0) goto L10;
        r1 = false;
        goto L11
    L16:
        r2 = true ^ Intrinsics.areEqual((Boolean) getTabKitViewModel().isLandingFinished().getValue(), Boolean.FALSE);
        goto L18
    }

    public void onResume() {
        super.onResume();
        if (isCurrentTabShow() == false) goto L6;
        sendVisibleEvent$default(this, true, null, 2, null);
        return;
    }

    public final void retrieveWebView() {
        if (getHybridView() != null) goto L5;
        return;
    L5:
        ViewGroup r0 = this.rootView;
        if (r0 != null) goto L9;
        return;
    L9:
        if (CollectionsKt.contains(com.bytedance.commerce.base.view.b.a(r0), getHybridView()) == true) goto L22;
        final View r1 = getHybridView();
        if (r1 == null) goto L20;
        Intrinsics.checkNotNullParameter(r1, "$this$removeParent");
        Function1<ViewGroup, Unit> r2 = new ExtensionsKt$removeParent$1(r1);
        Intrinsics.checkNotNullParameter(r1, "$this$withParent");
        Intrinsics.checkNotNullParameter(r2, "resolve");
        ViewParent r3 = r1.getParent();
        if (r3 == null) goto L20;
        if ((r3 instanceof ViewGroup) == true) goto L18;
        r3 = null;
    L18:
        if (r3 == null) goto L20;
        r2.invoke((ViewGroup) r3);
    L20:
        r0.addView(getHybridView());
        return;
    }

    public final ViewGroup getRootView() {
        return this.rootView;
    }

    public final FrameLayout getTitleContainer() {
        return this.titleContainer;
    }

    public final ViewGroup getWebLandingRoot() {
        return this.webLandingRoot;
    }

    public final boolean isLandingTab() {
        return this.isLandingTab;
    }

    public final boolean isVisibility() {
        return this.isVisibility;
    }

    public static final /* synthetic */ Map access$buildInitialData(TabKitHybridTabFragment r0) {
        return r0.buildInitialData();
    }

    public static final /* synthetic */ void access$createHybridComponent(TabKitHybridTabFragment r0) {
        r0.createHybridComponent();
    }

    public static final /* synthetic */ String access$getEcPrefetchApiKey$p(TabKitHybridTabFragment r0) {
        return r0.ecPrefetchApiKey;
    }

    public static final /* synthetic */ String access$getEcPrefetchBffFlag$p(TabKitHybridTabFragment r0) {
        return r0.ecPrefetchBffFlag;
    }

    public static final /* synthetic */ String access$getEcPrefetchRequestId$p(TabKitHybridTabFragment r0) {
        return r0.ecPrefetchRequestId;
    }

    public static final /* synthetic */ boolean access$getGenTemplateDataOpt$p(TabKitHybridTabFragment r0) {
        return r0.genTemplateDataOpt;
    }

    public static final /* synthetic */ ti.l access$getHybridComponent$p(TabKitHybridTabFragment r0) {
        return r0.hybridComponent;
    }

    public static final /* synthetic */ dm.a.a access$getLogger$p(TabKitHybridTabFragment r0) {
        return r0.getLogger();
    }

    public static final /* synthetic */ TabKitHybridTabFragment$prefetchCallback$1 access$getPrefetchCallback$p(TabKitHybridTabFragment r0) {
        return r0.prefetchCallback;
    }

    public static final /* synthetic */ TabKitHybridTabFragment$prefetchCallbackV2$1 access$getPrefetchCallbackV2$p(TabKitHybridTabFragment r0) {
        return r0.prefetchCallbackV2;
    }

    public static final /* synthetic */ Map access$getPrefetchInfoSyncV2(TabKitHybridTabFragment r0) {
        return r0.getPrefetchInfoSyncV2();
    }

    public static final /* synthetic */ boolean access$getSetupReport$p(TabKitHybridTabFragment r0) {
        return r0.setupReport;
    }

    public static final /* synthetic */ TopTabItemView access$getTitleViewTop$p(TabKitHybridTabFragment r0) {
        return r0.titleViewTop;
    }

    public static final /* synthetic */ boolean access$getUpdateDataLepus$p(TabKitHybridTabFragment r0) {
        return r0.updateDataLepus;
    }

    public static final /* synthetic */ boolean access$getUpdateDataLepusOpt$p(TabKitHybridTabFragment r0) {
        return r0.updateDataLepusOpt;
    }

    public static final /* synthetic */ boolean access$getUpdateDataLepusV2$p(TabKitHybridTabFragment r0) {
        return r0.updateDataLepusV2;
    }

    public static final /* synthetic */ boolean access$getUseWebLandingOpt1$p(TabKitHybridTabFragment r0) {
        return r0.getUseWebLandingOpt1();
    }

    public static final /* synthetic */ WebView access$getWebView$p(TabKitHybridTabFragment r0) {
        return r0.webView;
    }

    public static final /* synthetic */ boolean access$get_isAppInBackground$p(TabKitHybridTabFragment r0) {
        return r0._isAppInBackground;
    }

    public static final /* synthetic */ boolean access$isAnchorTab$p(TabKitHybridTabFragment r0) {
        return r0.isAnchorTab();
    }

    public static final /* synthetic */ void access$onHybridTemplateLoaded(TabKitHybridTabFragment r0) {
        r0.onHybridTemplateLoaded();
    }

    public static final /* synthetic */ void access$onLoadSuccess(TabKitHybridTabFragment r0) {
        r0.onLoadSuccess();
    }

    public static final /* synthetic */ void access$recordPrefetchTiming(TabKitHybridTabFragment r0) {
        r0.recordPrefetchTiming();
    }

    public static final /* synthetic */ void access$updateTitleViewStyle(TabKitHybridTabFragment r0) {
        r0.updateTitleViewStyle();
    }

    private final void addLynxViewClient(ti.l r2) {
        View r3 = r2.b();
        if ((r3 instanceof LynxView) == true) goto L5;
        r3 = null;
    L5:
        LynxView r4 = (LynxView) r3;
        if (r4 == null) goto L9;
        r4.addLynxViewClient(this.lynxViewClient);
        return;
    }

    private final JSONObject getNaPrefetchData(String r7) {
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L23
        Uri r8 = UriProtector.parse(r7);     // Catch: Throwable -> L23
        String r2 = UriProtector.getQueryParameter(r8, "ec_request_id");     // Catch: Throwable -> L23
        String r3 = UriProtector.getQueryParameter(r8, "ec_prefetch_api_key");     // Catch: Throwable -> L23
        String r4 = getTabKitViewModel().getRouterParams().getBizTag();     // Catch: Throwable -> L23
        int r5 = com.bytedance.android.shopping.store.tabkit.drainageprefetch.b.a;     // Catch: Throwable -> L23
        Intrinsics.checkNotNullParameter(r8, "uri");     // Catch: Throwable -> L23
        String r9 = j1.c(r8, "na_prefetch_strategy");     // Catch: Throwable -> L23
        boolean r6 = false;
        if (r9 == null) goto L8;
        Integer r10 = StringsKt.toIntOrNull(r9);     // Catch: Throwable -> L23
        if (r10 == null) goto L8;
        int r11 = r10.intValue();     // Catch: Throwable -> L23
    L10:
        if ((r11 & 1) <= 0) goto L12;
        boolean r12 = true;
    L13:
        if (r12 == false) goto L15;
    L16:
        r6 = true;
    L17:
        ConcurrentHashMap r13 = NativePrefetchUtil.a;     // Catch: Throwable -> L23
        JSONObject r14 = NativePrefetchUtil.f(r4, r2, r3, r6);     // Catch: Throwable -> L23
        if (r14 == null) goto L20;
        JSONObject r15 = new JSONObject();     // Catch: Throwable -> L23
        r15.putOpt("data", r14);     // Catch: Throwable -> L23
        r15.putOpt("status", 1);     // Catch: Throwable -> L23
    L21:
        Object r16 = Result.constructor-impl(r15);     // Catch: Throwable -> L23
    L26:
        if (Result.isFailure-impl(r16) == true) goto L30;
        r0 = r16;
    L30:
        return (JSONObject) r0;
    L20:
        r15 = null;
        goto L21
    L15:
        if (hk3.a.a(r4) == false) goto L17;
    L12:
        r12 = false;
    L8:
        r11 = 0;
    L23:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    }

    private final void notifyMarketingVisibleChange(boolean r9) {
        String r6 = getTabKitViewModel().getMarketingPageId();
        if (r6 == null) goto L25;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L19
        IMarketingServiceV2 r1 = ECMarketingSDK.c();     // Catch: Throwable -> L19
        if (r1 == null) goto L16;
        JSONObject r3 = new JSONObject();     // Catch: Throwable -> L19
        if (r9 == false) goto L9;
        int r10 = 1;
    L10:
        r3.putOpt("visible", Integer.valueOf(r10));     // Catch: Throwable -> L19
        r3.putOpt("source", "page");     // Catch: Throwable -> L19
        com.bytedance.android.shopping.store.tabkit.model.k r2 = getTab();     // Catch: Throwable -> L19
        if (r2 == null) goto L14;
        Object r4 = r2.n();     // Catch: Throwable -> L19
        if (r4 == null) goto L14;
    L15:
        r3.putOpt("tab_id", r4);     // Catch: Throwable -> L19
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L19
        IMarketingServiceV2.a.b(r1, "ecom.marketing.event.pageVisibilityChange", r3, null, null, r6, 25);     // Catch: Throwable -> L19
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L19
    L17:
        Object r13 = Result.constructor-impl(r12);     // Catch: Throwable -> L19
    L21:
        Result.box-impl(r13);
        return;
    L14:
        r4 = "";
        goto L15
    L9:
        r10 = 0;
        goto L10
    L16:
        r12 = null;
    L19:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L21
    }

    private final void onLoadFailed(String r2) {
        ViewGroup r3 = this.rootView;
        if (r3 == null) goto L5;
        r3.setVisibility(4);
    L5:
        ti.l r4 = this.hybridComponent;
        if (r4 == null) goto L9;
        r4.release();
        return;
    }

    private final void parseBundleUrlParams(String r7) {
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L5
        Uri r4 = UriProtector.parse(r7);     // Catch: Throwable -> L5
        this.updateDataLepus = Intrinsics.areEqual(UriProtector.getQueryParameter(r4, "na_prefetch_sync_update"), CommentScene.COMMENTSCENE_NO_AWEME);     // Catch: Throwable -> L5
        this.ecPrefetchRequestId = UriProtector.getQueryParameter(r4, "ec_request_id");     // Catch: Throwable -> L5
        this.ecPrefetchApiKey = UriProtector.getQueryParameter(r4, "ec_prefetch_api_key");     // Catch: Throwable -> L5
        this.ecPrefetchBffFlag = UriProtector.getQueryParameter(r4, "ec_prefetch_bff_flag");     // Catch: Throwable -> L5
        this.tabkitBridgeV2 = r4.getBooleanQueryParameter("tabkit_bridge_v2", false);     // Catch: Throwable -> L5
        getLogger().i("parse prefetch params: sync_update:" + this.updateDataLepus + ", request_id:" + this.ecPrefetchRequestId + ", api_key:" + this.ecPrefetchApiKey + ", bff_flag:" + this.ecPrefetchBffFlag + ", jsb2:" + this.tabkitBridgeV2 + ", url:" + r7);     // Catch: Throwable -> L5
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    private final void setUpdateDataSource(boolean r2) {
        v r0 = getTabState();
        if (r0 == null) goto L12;
        if (r2 == false) goto L7;
        String r3 = "net_end";
    L10:
        r0.e = r3;
        return;
    L7:
        if (this.updateDataLepusOpt == false) goto L9;
        r3 = "load_success";
        goto L10
    L9:
        r3 = "runtime_ready";
        goto L10
    }

    public void onCreate(Bundle r4) {
        super.onCreate(r4);
        Long r5 = getTabKitViewModel().getTabKitMonitorId();
        Observable<Boolean> r0 = TabKitAppMonitor.a;
        com.bytedance.android.shopping.store.tabkit.model.k r1 = getTab();
        if (r1 == null) goto L5;
        Integer r2 = r1.n();
    L6:
        TabKitAppMonitor.c(r5, r2);
        ok3.a r6 = getTabKitViewModel().getTabKitMonitor();
        if (r6 == null) goto L9;
        TabkitFramePref.recordTime$default(r6.c(getTabId()), "t_tab_init", null, 2, null);
    L9:
        Bundle r7 = getArguments();
        if (r7 == null) goto L12;
        boolean r8 = r7.getBoolean(TabKitAnnieXTabFragment.KEY_ARGUMENT_NEED_TITLE);
    L13:
        this.needTitle = r8;
        return;
    L12:
        r8 = false;
        goto L13
    L5:
        r2 = null;
        goto L6
    }

    public final void onHybridLoadFailed(String r3) {
        if (this.isLandingTab == false) goto L8;
        ok3.a r4 = getTabKitViewModel().getTabKitMonitor();
        if (r4 == null) goto L9;
        Map<Long, TabkitFirstFramePref> r0 = ok3.a.e;
        r4.e(3, null, null);
        return;
    L9:
        return;
    }

    public final void setLandingTab(boolean r1) {
        this.isLandingTab = r1;
    }

    public final void setRootView(ViewGroup r1) {
        this.rootView = r1;
    }

    public final void setTitleContainer(FrameLayout r1) {
        this.titleContainer = r1;
    }

    public final void setVisibility(boolean r1) {
        this.isVisibility = r1;
    }

    public final void setWebLandingRoot(ViewGroup r1) {
        this.webLandingRoot = r1;
    }

    public final void updateFoldScreenMetrics(Pair<Integer, Integer> r5) {
        if (getTabKitViewModel().isFoldPage() == true) goto L5;
        return;
    L5:
        View r0 = null;
        if (r5 != null) goto L8;
        int r6 = TabKitFoldFragment.f;
        TabKitFoldFragment.a.a(getActivity());
        r5 = null;
    L8:
        if (r5 == null) goto L42;
        LinkedHashMap r1 = new LinkedHashMap();
        com.bytedance.android.shopping.store.utils.g.a(r1, "ec_split_screen_width", com.bytedance.android.shopping.extensions.b.f((Number) r5.getFirst()));
        String r2 = getTabKitViewModel().getFoldType();
        if (r2 != null) goto L12;
        r2 = "";
    L12:
        com.bytedance.android.shopping.store.utils.g.a(r1, "split_screen_type", r2);
        com.bytedance.android.shopping.store.utils.g.a(r1, "is_split", Boolean.TRUE);
        ti.l r3 = this.hybridComponent;
        if (r3 == null) goto L15;
        View r4 = r3.b();
    L17:
        if ((r4 instanceof LynxView) == true) goto L19;
        r4 = null;
    L19:
        LynxView r7 = (LynxView) r4;
        if (r7 == null) goto L22;
        r7.updateGlobalProps(r1);
    L22:
        ti.l r8 = this.hybridComponent;
        if (r8 == null) goto L25;
        View r9 = r8.b();
    L27:
        if ((r9 instanceof LynxView) == false) goto L30;
        r0 = r9;
    L30:
        LynxView r10 = (LynxView) r0;
        if (r10 == null) goto L33;
        r10.updateScreenMetrics(((Number) r5.getFirst()).intValue(), ((Number) r5.getSecond()).intValue());
    L33:
        ViewGroup r11 = this.rootView;
        if (r11 == null) goto L38;
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        if (r12 == null) goto L38;
        r12.width = ((Number) r5.getFirst()).intValue();
    L38:
        ViewGroup r13 = this.rootView;
        if (r13 == null) goto L43;
        r13.requestLayout();
        return;
    L43:
        return;
    L25:
        r9 = null;
        goto L27
    L15:
        r4 = null;
        goto L17
    }

    public static final /* synthetic */ void access$addLynxViewClient(TabKitHybridTabFragment r0, ti.l r1) {
        r0.addLynxViewClient(r1);
    }

    public static final /* synthetic */ void access$notifyMarketingVisibleChange(TabKitHybridTabFragment r0, boolean r1) {
        r0.notifyMarketingVisibleChange(r1);
    }

    public static final /* synthetic */ void access$onLoadFailed(TabKitHybridTabFragment r0, String r1) {
        r0.onLoadFailed(r1);
    }

    public static final /* synthetic */ void access$setEcPrefetchApiKey$p(TabKitHybridTabFragment r0, String r1) {
        r0.ecPrefetchApiKey = r1;
    }

    public static final /* synthetic */ void access$setEcPrefetchBffFlag$p(TabKitHybridTabFragment r0, String r1) {
        r0.ecPrefetchBffFlag = r1;
    }

    public static final /* synthetic */ void access$setEcPrefetchRequestId$p(TabKitHybridTabFragment r0, String r1) {
        r0.ecPrefetchRequestId = r1;
    }

    public static final /* synthetic */ void access$setGenTemplateDataOpt$p(TabKitHybridTabFragment r0, boolean r1) {
        r0.genTemplateDataOpt = r1;
    }

    public static final /* synthetic */ void access$setHybridComponent$p(TabKitHybridTabFragment r0, ti.l r1) {
        r0.hybridComponent = r1;
    }

    public static final /* synthetic */ void access$setSetupReport$p(TabKitHybridTabFragment r0, boolean r1) {
        r0.setupReport = r1;
    }

    public static final /* synthetic */ void access$setTitleViewTop$p(TabKitHybridTabFragment r0, TopTabItemView r1) {
        r0.titleViewTop = r1;
    }

    public static final /* synthetic */ void access$setUpdateDataLepus$p(TabKitHybridTabFragment r0, boolean r1) {
        r0.updateDataLepus = r1;
    }

    public static final /* synthetic */ void access$setUpdateDataLepusOpt$p(TabKitHybridTabFragment r0, boolean r1) {
        r0.updateDataLepusOpt = r1;
    }

    public static final /* synthetic */ void access$setUpdateDataLepusV2$p(TabKitHybridTabFragment r0, boolean r1) {
        r0.updateDataLepusV2 = r1;
    }

    public static final /* synthetic */ void access$setUpdateDataSource(TabKitHybridTabFragment r0, boolean r1) {
        r0.setUpdateDataSource(r1);
    }

    public static final /* synthetic */ void access$setWebView$p(TabKitHybridTabFragment r0, WebView r1) {
        r0.webView = r1;
    }

    public static final /* synthetic */ void access$set_isAppInBackground$p(TabKitHybridTabFragment r0, boolean r1) {
        r0._isAppInBackground = r1;
    }

    private final String appendParams(String r4, boolean r5) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L16
        Uri r2 = UriProtector.parse(r4);     // Catch: Throwable -> L16
        Uri.Builder r3 = r2.buildUpon();     // Catch: Throwable -> L16
        if (r5 == false) goto L14;
        String r6 = UriProtector.getQueryParameter(r2, "na_prefetch_sync_update");     // Catch: Throwable -> L16
        if (r6 != null) goto L8;
    L11:
        boolean r7 = true;
    L12:
        if (r7 == false) goto L14;
        r3.appendQueryParameter("na_prefetch_sync_update", CommentScene.COMMENTSCENE_NO_AWEME);     // Catch: Throwable -> L16
        goto L14
    L8:
        if (StringsKt.isBlank(r6) == true) goto L11;
        r7 = false;
    L14:
        return r3.build().toString();
    L16:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return r4;
    }

    private final void injectPurePrefetchData(String r9, Map<String, Object> r10) {
        if (this.updateDataLepusV2 == false) goto L11;
        Map<String, Object> r0 = getPurePrefetchDataSyncV2();
        if (r0 == null) goto L19;
        recordPrefetchTiming();
        long r5 = System.currentTimeMillis();
        recordTime(TabkitSwitchTabPref.T_TAB_UPDATE_START_TIME, Long.valueOf(r5));
        recordTime(TabkitSwitchTabPref.T_TAB_UPDATE_END_TIME, Long.valueOf(r5));
        v r3 = getTabState();
        if (r3 == null) goto L9;
        r3.e = "init_data";
    L9:
        r10.put("na_prefetch_inject_raw", r0);
        r10.put("na_prefetch_inject_info", getPrefetchInfoSyncV2());
        getLogger().i("put prefetch data, url:" + r9);
        return;
    L19:
        return;
    L11:
        if (this.updateDataLepus == false) goto L21;
        Map<String, Object> r1 = getPurePrefetchDataSync();
        if (r1 == null) goto L22;
        recordPrefetchTiming();
        long r6 = System.currentTimeMillis();
        recordTime(TabkitSwitchTabPref.T_TAB_UPDATE_START_TIME, Long.valueOf(r6));
        recordTime(TabkitSwitchTabPref.T_TAB_UPDATE_END_TIME, Long.valueOf(r6));
        v r4 = getTabState();
        if (r4 == null) goto L17;
        r4.e = "init_data";
    L17:
        r10.putAll(r1);
        getLogger().i("put prefetch data, url:" + r9);
        return;
    L22:
        return;
    }

    private final void recordTime(String r3, Long r4) {
        if (this.isLandingTab == false) goto L9;
        ok3.a r0 = getTabKitViewModel().getTabKitMonitor();
        if (r0 == null) goto L13;
        TabkitFirstFramePref r1 = r0.d;
        if (r1 == null) goto L14;
        r1.recordTime(r3, r4);
        return;
    L14:
        return;
    L13:
        return;
    L9:
        ok3.a r2 = getTabKitViewModel().getTabKitMonitor();
        if (r2 == null) goto L16;
        r2.c(getTabId()).recordTime(r3, r4);
        return;
    }

    private final void updateGlobalProps(String r5, ti.l r6) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L20
        LinkedHashMap r1 = new LinkedHashMap();     // Catch: Throwable -> L20
        com.bytedance.android.shopping.store.utils.g.a(r1, "ec_marketing_page_id", getTabKitViewModel().getMarketingPageId());     // Catch: Throwable -> L20
        if (this.updateDataLepusV2 == false) goto L5;
    L7:
        com.bytedance.android.shopping.store.utils.g.a(r1, "performance_sampling_rate", hk3.b.i(r5));     // Catch: Throwable -> L20
        if (this.updateDataLepusV2 == false) goto L11;
        String r2 = CommentScene.COMMENTSCENE_NO_AWEME;
    L12:
        com.bytedance.android.shopping.store.utils.g.a(r1, "na_prefetch_sync_update", r2);     // Catch: Throwable -> L20
        com.bytedance.android.shopping.store.utils.g.a(r1, "enable_height_percent", CommentScene.COMMENTSCENE_NO_AWEME);     // Catch: Throwable -> L20
        com.bytedance.android.shopping.store.utils.g.a(r1, "enable_page_recreate_opt", Boolean.valueOf(hk3.b.d(r5)));     // Catch: Throwable -> L20
        com.bytedance.android.shopping.store.utils.g.a(r1, "tabs_container_id", getTabKitViewModel().getTabsContainerId());     // Catch: Throwable -> L20
        View r7 = r6.b();     // Catch: Throwable -> L20
        Unit r3 = null;
        if ((r7 instanceof LynxView) == true) goto L15;
        r7 = null;
    L15:
        LynxView r8 = (LynxView) r7;     // Catch: Throwable -> L20
        if (r8 == null) goto L18;
        r8.updateGlobalProps(r1);     // Catch: Throwable -> L20
        r3 = Unit.INSTANCE;     // Catch: Throwable -> L20
    L18:
        Result.constructor-impl(r3);     // Catch: Throwable -> L20
        return;
    L11:
        r2 = "0";
        goto L12
    L5:
        if (this.updateDataLepus == true) goto L7;
        com.bytedance.android.shopping.store.utils.g.a(r1, "_native_prefetch_result", getNaPrefetchData(r5));     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    private final void updateLynxScreenMetrics(int r4, int r5) {
        if (((Boolean) DeviceUtil.a.getValue()).booleanValue() == false) goto L16;
        ti.l r0 = this.hybridComponent;
        View r1 = null;
        if (r0 == null) goto L7;
        View r2 = r0.b();
    L9:
        if ((r2 instanceof LynxView) == false) goto L12;
        r1 = r2;
    L12:
        LynxView r3 = (LynxView) r1;
        if (r3 == null) goto L17;
        r3.updateScreenMetrics(r4, r5);
        return;
    L17:
        return;
    L7:
        r2 = null;
        goto L9
    }

    @Override // com.bytedance.android.shopping.store.tabkit.TabKitTabFragment
    public void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        initObserver();
    }

    public void sendVisibleEvent(boolean r2, TabVisibleFrom r3) {
        Intrinsics.checkNotNullParameter(r3, "showFrom");
        View r4 = getView();
        if (r4 == null) goto L6;
        r4.post(new e(this, r2));
        return;
    }

    public static final /* synthetic */ void access$updateGlobalProps(TabKitHybridTabFragment r0, String r1, ti.l r2) {
        r0.updateGlobalProps(r1, r2);
    }

    public static final /* synthetic */ void access$updateLynxScreenMetrics(TabKitHybridTabFragment r0, int r1, int r2) {
        r0.updateLynxScreenMetrics(r1, r2);
    }

    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        Context r4 = r1.getContext();
        if (this.rootView != null) goto L13;
        this.rootView = new d(this, r4);
        if (this.isLandingTab == false) goto L12;
        int r5 = com.bytedance.android.ec.store.utils.h.a;
        if (hk3.e.a() == 0) goto L9;
        boolean r6 = true;
    L10:
        if (r6 == false) goto L12;
        createHybridComponent();
        goto L12
    L9:
        r6 = false;
    L12:
        initTitleView();
        updateBackGroundColor();
    L13:
        ViewGroup r7 = this.rootView;
        Intrinsics.checkNotNull(r7);
        return r7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void updateFoldScreenMetrics$default(TabKitHybridTabFragment r0, Pair r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L6;
        r1 = null;
    L6:
        r0.updateFoldScreenMetrics(r1);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateFoldScreenMetrics");
    }

    public static /* synthetic */ void recordTime$default(TabKitHybridTabFragment r0, String r1, Long r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        r0.recordTime(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: recordTime");
    }

    public static /* synthetic */ void sendVisibleEvent$default(TabKitHybridTabFragment r0, boolean r1, TabVisibleFrom r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = TabVisibleFrom.Unknown;
    L6:
        r0.sendVisibleEvent(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendVisibleEvent");
    }
}
