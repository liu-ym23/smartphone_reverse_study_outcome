package com.bytedance.ies.bullet.kit.web;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import com.amap.api.col.s.ce;
import com.bytedance.android.anniex.base.monitor.MonitorCenter;
import com.bytedance.android.anniex.container.util.AnnieXContainerManager;
import com.bytedance.android.anniex.monitor.MonitorManager;
import com.bytedance.ies.argus.api.ArgusWebDelegate;
import com.bytedance.ies.argus.aspect.eventCenter.BaseEventCenter;
import com.bytedance.ies.argus.base.ArgusReportPlatform;
import com.bytedance.ies.argus.bean.ArgusCommonVerifyReason;
import com.bytedance.ies.argus.bean.ArgusGlobalAspect;
import com.bytedance.ies.argus.bean.AspectContext;
import com.bytedance.ies.argus.repository.ArgusConfigManager;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.secure.ArgusWebDelegateAdapter;
import com.bytedance.ies.bullet.service.base.YieldError;
import com.bytedance.ies.bullet.service.base.m0;
import com.bytedance.ies.bullet.web.scc.SccDelegate;
import com.bytedance.ies.web.jsbridge2.x;
import com.bytedance.sdk.xbridge.cn.protocol.auth.AuthUrlSourceType;
import com.bytedance.webx.core.webview.WebViewContainer;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0007defgAhiB'\b\u0007\u0012\u0006\u0010^\u001a\u00020]\u0012\n\b\u0002\u0010`\u001a\u0004\u0018\u00010_\u0012\b\b\u0002\u0010a\u001a\u00020\u0011¢\u0006\u0004\bb\u0010cJ\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0017\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0010\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\tH\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0018\u001a\u00020\u0011H\u0016J\b\u0010\u0019\u001a\u00020\u0011H\u0016J\u0010\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0012\u0010\u001f\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010!\u001a\u00020\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010#\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u0011H\u0016J\u000e\u0010&\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020$J\u0010\u0010(\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020'H\u0007J\u0010\u0010*\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010)J\u0010\u0010,\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010+J\b\u0010-\u001a\u0004\u0018\u00010\u0004J\u0006\u0010/\u001a\u00020.J\u0006\u00100\u001a\u00020\u0011J\u000e\u00102\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u0011J\u000e\u00104\u001a\u00020\u000b2\u0006\u00103\u001a\u00020\tJ\u0017\u00109\u001a\u00020\u000b2\u0006\u00106\u001a\u000205H\u0000¢\u0006\u0004\b7\u00108J\u0017\u0010>\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020:H\u0000¢\u0006\u0004\b<\u0010=J\b\u0010@\u001a\u0004\u0018\u00010?R\u0017\u0010E\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR*\u0010O\u001a\u0004\u0018\u00010F8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\bG\u0010H\u0012\u0004\bM\u0010N\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR$\u0010T\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bP\u0010B\u001a\u0004\bQ\u0010D\"\u0004\bR\u0010SR$\u0010\\\u001a\u0004\u0018\u00010U8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[¨\u0006j"}, d2 = {"Lcom/bytedance/ies/bullet/kit/web/SSWebView;", "Lcom/bytedance/webx/core/webview/WebViewContainer;", "Lcom/bytedance/ies/web/jsbridge2/x;", "Lke7/b;", "", "getSafeUrl", "getXSafeUrl", "Lcom/bytedance/sdk/xbridge/cn/protocol/auth/AuthUrlSourceType;", "getAuthUrlSourceType", "", "enable", "", "setEnableSafeWebJSBAuth", "(Ljava/lang/Boolean;)V", "url", "setPageCommitVisibleUrl", "setPageStartUrl", "", "mode", "setOverScrollMode", "networkUp", "setNetworkAvailable", "getUrl", "getOriginalUrl", "getProgress", "getContentHeight", "Landroid/webkit/WebViewClient;", "client", "setWebViewClient", "Landroid/webkit/DownloadListener;", "listener", "setDownloadListener", "Landroid/webkit/WebChromeClient;", "setWebChromeClient", "color", "setBackgroundColor", "Lcom/bytedance/ies/bullet/kit/web/SSWebView$f;", "delegate", "setWebViewEventDelegate", "Lcom/bytedance/ies/bullet/kit/web/SSWebView$g;", "setWebViewScrollDelegate", "Lcom/bytedance/ies/bullet/kit/web/SSWebView$e;", "setWebScrollListener", "Lcom/bytedance/ies/bullet/kit/web/SSWebView$d;", "setWebOverScrollByListener", "getSecLinkScene", "", "getLastClickTime", "getTimeInterval", "timeInterval", "setTimeInterval", "canTouch", "setCanTouch", "Lcom/bytedance/ies/bullet/web/pia/g;", "piaLifeCycle", "setPiaLifeCycle$anniex_release", "(Lcom/bytedance/ies/bullet/web/pia/g;)V", "setPiaLifeCycle", "Lcom/bytedance/ies/bullet/web/scc/SccDelegate;", "sccDelegate", "setSccDelegate$anniex_release", "(Lcom/bytedance/ies/bullet/web/scc/SccDelegate;)V", "setSccDelegate", "Lh16/b;", "getSearchMode", "e", "Ljava/lang/String;", "getMInstanceId", "()Ljava/lang/String;", "mInstanceId", "Lcom/bytedance/ies/bullet/kit/web/d;", "t", "Lcom/bytedance/ies/bullet/kit/web/d;", "getSecureDelegate", "()Lcom/bytedance/ies/bullet/kit/web/d;", "setSecureDelegate", "(Lcom/bytedance/ies/bullet/kit/web/d;)V", "getSecureDelegate$annotations", "()V", "secureDelegate", "u", "getSecureLinkScene", "setSecureLinkScene", "(Ljava/lang/String;)V", "secureLinkScene", "Lcom/bytedance/ies/bullet/secure/ArgusWebDelegateAdapter;", "x", "Lcom/bytedance/ies/bullet/secure/ArgusWebDelegateAdapter;", "getArgusAdapter$anniex_release", "()Lcom/bytedance/ies/bullet/secure/ArgusWebDelegateAdapter;", "setArgusAdapter$anniex_release", "(Lcom/bytedance/ies/bullet/secure/ArgusWebDelegateAdapter;)V", "argusAdapter", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "d", "f", ce.f26391f, "anniex_release"}, k = 1, mv = {1, 4, 3})
public class SSWebView extends WebViewContainer implements x, ke7.b {
    public String A;
    public AuthUrlSourceType B;
    public final c C;
    public final CopyOnWriteArrayList<g> D;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f246878e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f246879f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f246880g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f246881h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f246882i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f246883j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f246884k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f246885l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f246886m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public h16.b f246887n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final a f246888o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public e f246889p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public d f246890q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public f f246891r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public g f246892s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public com.bytedance.ies.bullet.kit.web.d f246893t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f246894u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public com.bytedance.ies.bullet.web.pia.g f246895v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public SccDelegate f246896w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ArgusWebDelegateAdapter f246897x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f246898y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f246899z;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f246900a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Handler f246901b;

        /* JADX INFO: renamed from: com.bytedance.ies.bullet.kit.web.SSWebView$a$a, reason: collision with other inner class name */
        public interface InterfaceC3530a {
            boolean onActionItemClicked(ActionMode r100, MenuItem r101);

            boolean onCreateActionMode(ActionMode r100, Menu r101);

            void onDestroyActionMode(ActionMode r100);

            boolean onGetContentRect(ActionMode r100, View r101, Rect r102);

            boolean onPrepareActionMode(ActionMode r100, Menu r101);
        }

        public static final class b implements InterfaceC3530a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ActionMode.Callback f246902a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ boolean f246903b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ h16.b f246904c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ a f246905d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ SSWebView f246906e;

            @Override // com.bytedance.ies.bullet.kit.web.SSWebView.a.InterfaceC3530a
            public final void onDestroyActionMode(ActionMode r100) {
                this.f246902a.onDestroyActionMode(r100);
            }

            @Override // com.bytedance.ies.bullet.kit.web.SSWebView.a.InterfaceC3530a
            public final boolean onActionItemClicked(ActionMode r100, MenuItem r101) {
                return this.f246902a.onActionItemClicked(r100, r101);
            }

            @Override // com.bytedance.ies.bullet.kit.web.SSWebView.a.InterfaceC3530a
            public final boolean onCreateActionMode(ActionMode r100, Menu r101) {
                return this.f246902a.onCreateActionMode(r100, r101);
            }

            @Override // com.bytedance.ies.bullet.kit.web.SSWebView.a.InterfaceC3530a
            public final boolean onPrepareActionMode(ActionMode r110, Menu r111) {
                boolean r100 = this.f246902a.onPrepareActionMode(r110, r111);
                if (this.f246903b == false) goto L29;
                if (r111 == null) goto L29;
                h16.b r101 = this.f246904c;
                if (r101 == null) goto L8;
                List<h16.b.a> r112 = r101.Z0(r111);
            L9:
                List<h16.b.a> r102 = r112;
                if (r102 != null) goto L12;
            L15:
                boolean r103 = true;
            L16:
                if (r103 == true) goto L29;
                if (r110 == null) goto L29;
                a r104 = this.f246905d;
                SSWebView r105 = this.f246906e;
                r104.getClass();
                MonitorCenter.f40289c.a(r104.f246900a, MapsKt.mapOf(new Pair[]{TuplesKt.to("event_type", "event_type_ui"), TuplesKt.to("event_source", "event_source_press_text_panel")}), null);
                Menu r106 = r110.getMenu();
                if (r106 == null) goto L21;
                r106.clear();
            L21:
                Iterator<T> r113 = r112.iterator();
            L23:
                if (r113.hasNext() == false) goto L29;
                h16.b.a r107 = (h16.b.a) r113.next();
                Menu r108 = r110.getMenu();
                if (r108 == null) goto L23;
                r107.getClass();
                MenuItem r109 = r108.add(null);
                if (r109 == null) goto L23;
                r109.setOnMenuItemClickListener(new i(r105, r104, r110, r107));
                goto L23
            L12:
                if (r102.isEmpty() == true) goto L15;
                r103 = false;
                goto L16
            L8:
                r112 = null;
            L29:
                return r100;
            }

            @Override // com.bytedance.ies.bullet.kit.web.SSWebView.a.InterfaceC3530a
            public final boolean onGetContentRect(ActionMode r100, View r101, Rect r102) {
                ActionMode.Callback r103 = this.f246902a;
                if ((r103 instanceof ActionMode.Callback2) == false) goto L5;
                ((ActionMode.Callback2) r103).onGetContentRect(r100, r101, r102);
                return true;
            L5:
                return false;
            }

            public b(ActionMode.Callback r100, boolean r101, h16.b r102, a r103, SSWebView r104) {
                this.f246902a = r100;
                this.f246903b = r101;
                this.f246904c = r102;
                this.f246905d = r103;
                this.f246906e = r104;
            }
        }

        public a() {
            this.f246900a = "";
            this.f246901b = new Handler(Looper.getMainLooper());
        }

        public final void b(boolean r100) {
            if (r100 == false) goto L5;
            MonitorCenter.f40289c.a(this.f246900a, MapsKt.mapOf(new Pair[]{TuplesKt.to("event_type", "event_type_press"), TuplesKt.to("event_source", "event_source_press_text_panel")}), null);
            return;
        }

        public final ActionMode.Callback a(ActionMode.Callback r100, SSWebView r101, h16.b r102, boolean r110, boolean r111) {
            Intrinsics.checkNotNullParameter(r101, "webView");
            if (r110 == true) goto L5;
            if (r100 != null) goto L9;
            return null;
        L9:
            b r112 = new b(r100, r111, r102, this, r101);
            if (Build.VERSION.SDK_INT < 23) goto L13;
            return new j(r112);
        L13:
            return new k(r112);
        L5:
            return new l();
        }
    }

    public static final class b {
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CopyOnWriteArrayList<a> f246907a;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f246908a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final String f246909b;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof a) == true) goto L8;
                return false;
            L8:
                a r101 = (a) r100;
                if (Intrinsics.areEqual(this.f246908a, r101.f246908a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f246909b, r101.f246909b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                return (this.f246908a.hashCode() * 31) + this.f246909b.hashCode();
            }

            public final String toString() {
                return "RedirectRecordPair(from=" + this.f246908a + ", to=" + this.f246909b + ')';
            }

            public a(String r100, String r101) {
                Intrinsics.checkNotNullParameter(r100, "from");
                Intrinsics.checkNotNullParameter(r101, RemoteMessageConst.TO);
                this.f246908a = r100;
                this.f246909b = r101;
            }
        }

        public c() {
            this.f246907a = new CopyOnWriteArrayList();
        }
    }

    public interface d {
        void b(int r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, boolean r108);
    }

    public interface e {
        void onScrollChanged(int r100, int r101, int r102, int r103);
    }

    public interface f {
        boolean a(int r100, boolean r101);

        boolean onTouchEvent(MotionEvent r100);
    }

    public interface g {
        void a(int r100, int r101, boolean r102, boolean r103);
    }

    public static final class h implements MenuItem.OnMenuItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SSWebView f246910a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ActionMode f246911b;

        public static final class a<T> implements ValueCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ SSWebView f246912a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ActionMode f246913b;

            public a(SSWebView r100, ActionMode r101) {
                this.f246912a = r100;
                this.f246913b = r101;
            }

            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object r100) {
                SSWebView r101 = this.f246912a;
                ActionMode r102 = this.f246913b;
                r101.post(new m(r102, r101, (String) r100));
            }
        }

        public h(SSWebView r100, ActionMode r101) {
            this.f246910a = r100;
            this.f246911b = r101;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public final boolean onMenuItemClick(MenuItem r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            SSWebView r101 = this.f246910a;
            r101.evaluateJavascript("javascript:(function getSelectedText() {return window.getSelection().toString();})()", new a(r101, this.f246911b));
            return true;
        }
    }

    static {
    }

    public SSWebView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SSWebView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Deprecated(message = "废弃，内部收敛统一到internal argusAdapter避免外部随意修改，请不要主动调用")
    public static /* synthetic */ void getSecureDelegate$annotations() {
    }

    @Override // com.bytedance.webx.core.webview.WebViewContainer, android.webkit.WebView
    public final boolean canGoBack() {
        this.C.getClass();     // Catch: Exception -> L16
        Intrinsics.checkNotNullParameter(this, "webView");     // Catch: Exception -> L16
        s26.d r100 = s26.d.f540305c;     // Catch: Exception -> L16
        m0 r101 = (m0) s26.d.f540305c.c(m0.class);     // Catch: Exception -> L16
        if (r101 == null) goto L5;
        r101.a0();     // Catch: Exception -> L16
    L5:
        ArgusWebDelegateAdapter r102 = this.f246897x;     // Catch: Exception -> L16
        if (r102 == null) goto L19;
        if (r102.a(this) == false) goto L14;
        if (super.canGoBack() == false) goto L14;
        return true;
    L19:
        return super.canGoBack();
    L14:
        return false;
    }

    @Override // com.bytedance.webx.core.webview.WebViewContainer, android.webkit.WebView
    public final void destroy() {
        com.bytedance.android.monitorV2.webview.m.f163358f.k(this);     // Catch: Throwable -> L7
        AnnieXContainerManager.INSTANCE.getEngineAliveUrlMap().remove(this.f246878e);     // Catch: Throwable -> L7
        this.f246887n = null;     // Catch: Throwable -> L7
        a r100 = this.f246888o;     // Catch: Throwable -> L7
        r100.f246900a = "";     // Catch: Throwable -> L7
        r100.f246901b.removeCallbacksAndMessages(null);     // Catch: Throwable -> L7
        com.bytedance.ies.bullet.web.pia.g r101 = this.f246895v;     // Catch: Throwable -> L7
        if (r101 == null) goto L5;
        r101.f248318a.onDestroy();     // Catch: Throwable -> L7
    L5:
        this.f246896w = null;     // Catch: Throwable -> L7
        this.f246893t = null;     // Catch: Throwable -> L7
        this.f246897x = null;     // Catch: Throwable -> L7
        super.destroy();     // Catch: Throwable -> L7
        return;
    }

    @Override // com.bytedance.ies.web.jsbridge2.x
    public String getSafeUrl() {
        if (this.f246898y == true) goto L7;
        this.B = AuthUrlSourceType.DisableSafeAuthInXBridge2;
        return this.f246899z;
    L7:
        return getXSafeUrl();
    }

    public final int getTimeInterval() {
        int r100 = this.f246879f;
        if (r100 > 0) goto L7;
        return 500;
    L7:
        return r100;
    }

    @Override // ke7.b
    public String getXSafeUrl() {
        if (TextUtils.isEmpty(this.A) == true) goto L6;
        this.B = AuthUrlSourceType.PageCommitVisibleUrl;
        String r100 = this.A;
    L12:
        HybridLogger r101 = HybridLogger.f246343a;
        HybridLogger.m("SSWebView", "GetXSafeUrl: return " + r100 + ", type is " + this.B, null, null, 12);
        return r100;
    L6:
        if (TextUtils.isEmpty(this.f246899z) == true) goto L9;
        this.B = AuthUrlSourceType.PageStartedUrl;
        r100 = this.f246899z;
        goto L12
    L9:
        if (TextUtils.isEmpty(getUrl()) == true) goto L11;
        this.B = AuthUrlSourceType.WebViewUrl;
        r100 = getUrl();
        goto L12
    L11:
        this.B = AuthUrlSourceType.AbnormalUrl;
        r100 = null;
        goto L12
    }

    @Override // com.bytedance.webx.core.webview.WebViewContainer, android.webkit.WebView
    public final void goBack() {
        com.bytedance.android.monitorV2.webview.m.f163358f.l(this);     // Catch: Exception -> L12
        this.C.getClass();     // Catch: Exception -> L12
        Intrinsics.checkNotNullParameter(this, "webView");     // Catch: Exception -> L12
        s26.d r100 = s26.d.f540305c;     // Catch: Exception -> L12
        m0 r101 = (m0) s26.d.f540305c.c(m0.class);     // Catch: Exception -> L12
        if (r101 == null) goto L5;
        r101.a0();     // Catch: Exception -> L12
    L5:
        ArgusWebDelegateAdapter r102 = this.f246897x;     // Catch: Exception -> L12
        if (r102 != null) goto L8;
    L10:
        super.goBack();     // Catch: Exception -> L12
        return;
    L8:
        if (r102.b(this) == false) goto L10;
        return;
    }

    @Override // com.bytedance.webx.core.webview.WebViewContainer, android.webkit.WebView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        com.bytedance.android.monitorV2.webview.m.f163358f.E(this);     // Catch: Throwable -> L4
        Map<String, i36.d> r100 = MonitorManager.f40977a;     // Catch: Throwable -> L4
        MonitorManager.g(this.f246884k, getUrl());     // Catch: Throwable -> L4
        super.onAttachedToWindow();     // Catch: Throwable -> L4
        return;
    }

    @Override // com.bytedance.webx.core.webview.WebViewContainer, android.webkit.WebView
    public final void reload() {
        com.bytedance.android.monitorV2.webview.m.f163358f.M(this);     // Catch: Exception -> L9
        SccDelegate r100 = this.f246896w;     // Catch: Exception -> L9
        if (r100 == null) goto L7;
        String r101 = getUrl();     // Catch: Exception -> L9
        if (r101 == null) goto L7;
        r100.b(r101);     // Catch: Exception -> L9
    L7:
        super.reload();     // Catch: Exception -> L9
        return;
    }

    @Override // com.bytedance.webx.core.webview.WebViewContainer, android.webkit.WebView
    public final boolean canGoForward() {
        return super.canGoForward();
    L4:
        return false;
    }

    @Override // android.webkit.WebView
    public int getContentHeight() {
        return super.getContentHeight();
    L4:
        return 1;
    }

    @Override // android.webkit.WebView
    public String getOriginalUrl() {
        return super.getOriginalUrl();
    L4:
        return null;
    }

    @Override // android.webkit.WebView
    public int getProgress() {
        return super.getProgress();
    L4:
        return 100;
    }

    @Override // android.webkit.WebView
    public String getUrl() {
        return super.getUrl();
    L4:
        return null;
    }

    @Override // ke7.b
    public final boolean a() {
        return this.f246898y;
    }

    @Override // android.webkit.WebView
    public final void clearFormData() {
        super.clearFormData();     // Catch: Exception -> L4
        return;
    }

    @Override // android.webkit.WebView
    public final void clearHistory() {
        super.clearHistory();     // Catch: Exception -> L4
        return;
    }

    @Override // android.webkit.WebView, android.view.View
    public void computeScroll() {
        super.computeScroll();     // Catch: Exception -> L4
        return;
    }

    public final ArgusWebDelegateAdapter getArgusAdapter$anniex_release() {
        return this.f246897x;
    }

    @Override // ke7.b
    public AuthUrlSourceType getAuthUrlSourceType() {
        return this.B;
    }

    public final long getLastClickTime() {
        return this.f246881h;
    }

    public final String getMInstanceId() {
        return this.f246878e;
    }

    public final h16.b getSearchMode() {
        return this.f246887n;
    }

    public final String getSecLinkScene() {
        return this.f246894u;
    }

    public final com.bytedance.ies.bullet.kit.web.d getSecureDelegate() {
        return this.f246893t;
    }

    public final String getSecureLinkScene() {
        return this.f246894u;
    }

    @Override // com.bytedance.webx.core.webview.WebViewContainer, android.webkit.WebView
    public final void goForward() {
        super.goForward();     // Catch: Exception -> L4
        return;
    }

    @Override // com.bytedance.webx.core.webview.WebViewContainer, android.webkit.WebView
    public final void onPause() {
        super.onPause();     // Catch: Exception -> L4
        return;
    }

    @Override // com.bytedance.webx.core.webview.WebViewContainer, android.webkit.WebView
    public final void onResume() {
        super.onResume();     // Catch: Exception -> L4
        return;
    }

    @Override // com.bytedance.webx.core.webview.WebViewContainer, android.webkit.WebView
    public final void stopLoading() {
        super.stopLoading();     // Catch: Exception -> L4
        return;
    }

    public final void E0(ActionMode r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L16
        int r102 = r100.getMenu().size() - 1;     // Catch: Throwable -> L16
    L5:
        if ((-1) >= r102) goto L14;
        CharSequence r103 = r100.getMenu().getItem(r102).getTitle();     // Catch: Throwable -> L16
        boolean r104 = false;
        if (r103 != null) goto L9;
    L11:
        if (r104 == false) goto L13;
        r100.getMenu().removeItem(r100.getMenu().getItem(r102).getItemId());     // Catch: Throwable -> L16
    L13:
        r102 = r102 - 1;     // Catch: Throwable -> L16
        goto L5
    L9:
        if (StringsKt.contains$default(r103, "搜索", false, 2, null) != true) goto L11;
        r104 = true;
        goto L11
    L14:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L18:
        r100.getMenu().add("搜索").setOnMenuItemClickListener(new h(this, r100));
        return;
    L16:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L18
    }

    public final String F0(String r100) {
        ArgusWebDelegateAdapter r101 = this.f246897x;
        if (r101 == null) goto L9;
        Intrinsics.checkNotNullParameter(this, "webView");
        Intrinsics.checkNotNullParameter(r100, "url");
        String r102 = r101.f(this, r100, MapsKt.emptyMap()).getFirst();
        if (r102 != null) goto L8;
        return r100;
    L8:
        return r102;
    L9:
        return r100;
    }

    @Override // com.bytedance.webx.core.webview.WebViewContainer, android.webkit.WebView
    public final boolean canGoBackOrForward(int r100) {
        return super.canGoBackOrForward(r100);
    L4:
        return false;
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int r100) {
        f r101 = this.f246891r;
        if (r101 == null) goto L7;
        return r101.a(r100, super.canScrollVertically(r100));
    L7:
        return super.canScrollVertically(r100);
    }

    @Override // android.webkit.WebView
    public final void clearCache(boolean r100) {
        super.clearCache(r100);     // Catch: Exception -> L4
        return;
    }

    @Override // com.bytedance.webx.core.webview.WebViewContainer, android.webkit.WebView
    public final void goBackOrForward(int r100) {
        super.goBackOrForward(r100);     // Catch: Exception -> L4
        return;
    }

    @Override // com.bytedance.webx.core.webview.WebViewContainer, android.webkit.WebView
    public final void loadUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        com.bytedance.android.monitorV2.webview.m.f163358f.F(this, r100);     // Catch: Exception -> L11
        AnnieXContainerManager.INSTANCE.saveTemplateUrlFromEngineHashCode(this.f246878e, r100);     // Catch: Exception -> L11
        com.bytedance.ies.bullet.web.pia.g r101 = this.f246895v;     // Catch: Exception -> L11
        if (r101 == null) goto L6;
        r101.b(r100);     // Catch: Exception -> L11
    L6:
        SccDelegate r102 = this.f246896w;     // Catch: Exception -> L11
        if (r102 == null) goto L9;
        r102.b(r100);     // Catch: Exception -> L11
    L9:
        super.loadUrl(F0(r100));     // Catch: Exception -> L11
        return;
    }

    @Override // com.bytedance.webx.core.webview.WebViewContainer, android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        ArgusWebDelegateAdapter r100 = this.f246897x;
        if (r100 == null) goto L27;
        ArgusWebDelegate r101 = r100.f247734a;
        if (r101 == null) goto L27;
        com.bytedance.ies.argus.api.params.f r102 = new com.bytedance.ies.argus.api.params.f(r110, getUrl());
        Intrinsics.checkNotNullParameter(r102, "params");
        r102.f245740c = r101.f245631c.f245874l;
        BaseEventCenter.b<PARAMS, REWRITE_PAYLOAD> r103 = r101.e(ArgusGlobalAspect.MOTION_ON_TOUCH, r102);
        ArgusReportPlatform r104 = ArgusReportPlatform.NONE;
        Intrinsics.checkNotNullParameter(r104, "type");
        com.bytedance.ies.argus.base.e r105 = r103.f245824b.f245999n;
        r105.getClass();
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r105.f245945c = r104;
        Lazy<ArgusConfigManager> r106 = ArgusConfigManager.f246083j;
        if (ArgusConfigManager.a.a().a(r103.f245823a, r103.getContext().b()) == false) goto L10;
        int r107 = com.bytedance.ies.argus.base.d.f245942a;
        com.bytedance.ies.argus.base.d.c("BaseEventCenter", "argusBizId " + r103.getContext().b() + ", aspect: " + r103.f245823a.getStringValue() + " is disabled by recovery.");
        com.bytedance.ies.argus.bean.i.i(new com.bytedance.ies.argus.bean.k(), ArgusCommonVerifyReason.ASPECT_DISABLE_BY_RECOVERY, null, 6);
        goto L27
    L10:
        if (r103.getContext().d() != null) goto L13;
        com.bytedance.ies.argus.bean.i.i(r103.b(), ArgusCommonVerifyReason.ASPECT_CONFIG_IS_NULL, null, 6);
        goto L27
    L13:
        if (r103.getContext().e().f246020b == true) goto L15;
        com.bytedance.ies.argus.bean.i.i(r103.b(), ArgusCommonVerifyReason.ASPECT_IS_OFF, null, 6);
        goto L27
    L15:
        long r108 = System.currentTimeMillis();
        r103.getContext().f245990e = false;
        AspectContext r109 = r103.getContext();
        AspectContext.Companion.TraceType r111 = AspectContext.Companion.TraceType.ASPECT_VERIFY;
        r109.h(r111, AspectContext.Companion.TraceStage.START, null);
        AspectContext<?, ?> r112 = r103.getContext();
        r103.b();
        r101.b(r112, null);
        if (r103.f245826d == false) goto L24;
        ConcurrentHashMap<com.bytedance.ies.argus.bean.n, CopyOnWriteArrayList<AspectContext<?, ?>>> r113 = r103.f245827e.f245821f;
        com.bytedance.ies.argus.bean.n r114 = r103.f245823a;
        CopyOnWriteArrayList<AspectContext<?, ?>> r115 = r113.get(r114);
        if (r115 != null) goto L23;
        r115 = new CopyOnWriteArrayList();
        CopyOnWriteArrayList<AspectContext<?, ?>> r116 = r113.putIfAbsent(r114, r115);
        if (r116 == null) goto L23;
        r115 = r116;
    L23:
        r115.add(r103.getContext());
    L24:
        r103.getContext().h(r111, AspectContext.Companion.TraceStage.END, null);
        BaseEventCenter.b.a(r103, null);
        r103.b();
        r103.getContext().f().a("trigger_time", Long.valueOf(r108));
        Function1<? super AspectContext<?, ?>, Unit> r117 = r103.f245827e.f245822g;
        if (r117 == null) goto L27;
        r117.invoke(r103.getContext());
    L27:
        f r118 = this.f246891r;
        if (r118 == null) goto L33;
        return r118.onTouchEvent(r110);
    L33:
        if (this.f246882i == false) goto L50;
        int r119 = r110.getAction();
        if (r119 != 0) goto L37;
        this.f246880g = System.currentTimeMillis();
    L46:
        return super.onTouchEvent(r110);
    L51:
        return false;
    L37:
        if (r119 != 1) goto L46;
        if ((System.currentTimeMillis() - this.f246880g) >= 100) goto L46;
        this.f246881h = System.currentTimeMillis();
        ViewConfiguration.getTapTimeout();
        goto L46
    L50:
        return false;
    }

    public final void setArgusAdapter$anniex_release(ArgusWebDelegateAdapter r100) {
        this.f246897x = r100;
    }

    @Override // android.webkit.WebView, android.view.View
    public void setBackgroundColor(int r100) {
        super.setBackgroundColor(r100);     // Catch: Exception -> L4
        return;
    }

    public final void setCanTouch(boolean r100) {
        this.f246882i = r100;
    }

    @Override // com.bytedance.webx.core.webview.WebViewContainer, android.webkit.WebView
    public void setDownloadListener(DownloadListener r100) {
        super.setDownloadListener(r100);     // Catch: Exception -> L4
        return;
    }

    public final void setEnableSafeWebJSBAuth(Boolean r100) {
        if (r100 == null) goto L4;
        boolean r101 = r100.booleanValue();
    L5:
        this.f246898y = r101;
        return;
    L4:
        r101 = false;
        goto L5
    }

    @Override // android.webkit.WebView
    public void setNetworkAvailable(boolean r100) {
        super.setNetworkAvailable(r100);     // Catch: Exception -> L4
        return;
    }

    @Override // android.webkit.WebView, android.view.View
    public void setOverScrollMode(int r100) {
        super.setOverScrollMode(r100);     // Catch: Throwable -> L4
        return;
    }

    public final void setPageCommitVisibleUrl(String r100) {
        this.A = r100;
    }

    public final void setPageStartUrl(String r100) {
        this.f246899z = r100;
    }

    public final void setPiaLifeCycle$anniex_release(com.bytedance.ies.bullet.web.pia.g r100) {
        Intrinsics.checkNotNullParameter(r100, "piaLifeCycle");
        this.f246895v = r100;
    }

    public final void setSccDelegate$anniex_release(SccDelegate r100) {
        Intrinsics.checkNotNullParameter(r100, "sccDelegate");
        this.f246896w = r100;
    }

    public final void setSecureDelegate(com.bytedance.ies.bullet.kit.web.d r100) {
        this.f246893t = r100;
    }

    public final void setSecureLinkScene(String r100) {
        this.f246894u = r100;
    }

    public final void setTimeInterval(int r100) {
        this.f246879f = r100;
    }

    @Override // com.bytedance.webx.core.webview.WebViewContainer, com.bytedance.webx.core.webview.inner.WebViewContainerInner, android.webkit.WebView
    public void setWebChromeClient(WebChromeClient r100) {
        super.setWebChromeClient(r100);     // Catch: Exception -> L4
        return;
    }

    public final void setWebOverScrollByListener(d r100) {
        this.f246890q = r100;
    }

    public final void setWebScrollListener(e r100) {
        this.f246889p = r100;
    }

    @Override // com.bytedance.webx.core.webview.WebViewContainer, com.bytedance.webx.core.webview.inner.WebViewContainerInner, android.webkit.WebView
    public void setWebViewClient(WebViewClient r100) {
        Intrinsics.checkNotNullParameter(r100, "client");
        super.setWebViewClient(r100);     // Catch: Exception -> L5
        return;
    }

    public final void setWebViewEventDelegate(f r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        this.f246891r = r100;
    }

    @Deprecated(message = "use addWebViewScrollDelegate instead", replaceWith = @ReplaceWith(expression = "addWebViewScrollDelegate & removeWebViewScrollDelegate", imports = {}))
    public final void setWebViewScrollDelegate(g r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        this.f246892s = r100;
    }

    @Override // android.view.View
    public final ActionMode startActionMode(ActionMode.Callback r100) {
        this.f246888o.b(this.f246886m);
        ActionMode r101 = super.startActionMode(this.f246888o.a(r100, this, this.f246887n, this.f246885l, this.f246886m));
        if (this.f246883j == true) goto L5;
    L9:
        return r101;
    L5:
        if (this.f246885l == true) goto L9;
        if (this.f246886m == true) goto L9;
        E0(r101);
        goto L9
    }

    @Override // com.bytedance.webx.core.webview.WebViewContainer, android.webkit.WebView
    public final void evaluateJavascript(String r100, ValueCallback<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "script");
        super.evaluateJavascript(r100, r101);
        com.bytedance.ies.bullet.web.pia.g r102 = this.f246895v;
        if (r102 == null) goto L7;
        if (r100 == null) goto L8;
        com.bytedance.ies.bullet.web.pia.i r103 = r102.f248319b;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, "script");
        r103.b(r100);
        return;
    L8:
        return;
    }

    @Override // com.bytedance.webx.core.webview.WebViewContainer, android.webkit.WebView
    public final void loadUrl(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "additionalHttpHeaders");
        com.bytedance.android.monitorV2.webview.m.f163358f.F(this, r100);     // Catch: Exception -> L15
        com.bytedance.ies.bullet.web.pia.g r102 = this.f246895v;     // Catch: Exception -> L15
        if (r102 == null) goto L6;
        r102.b(r100);     // Catch: Exception -> L15
    L6:
        SccDelegate r103 = this.f246896w;     // Catch: Exception -> L15
        if (r103 == null) goto L9;
        r103.b(r100);     // Catch: Exception -> L15
    L9:
        ArgusWebDelegateAdapter r104 = this.f246897x;     // Catch: Exception -> L15
        if (r104 == null) goto L12;
        Pair<String, Map<String, String>> r105 = r104.f(this, r100, r101);     // Catch: Exception -> L15
    L13:
        super.loadUrl(r105.component1(), r105.component2());     // Catch: Exception -> L15
        return;
    L12:
        r105 = new Pair(r100, r101);     // Catch: Exception -> L15
    }

    @Override // com.bytedance.webx.core.webview.WebViewContainer, android.webkit.WebView
    public final void postUrl(String r100, byte[] r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "postData");
        super.postUrl(F0(r100), r101);     // Catch: Exception -> L5
        return;
    }

    @Override // android.view.View
    public final ActionMode startActionMode(ActionMode.Callback r100, int r110) {
        this.f246888o.b(this.f246886m);
        ActionMode r101 = super.startActionMode(this.f246888o.a(r100, this, this.f246887n, this.f246885l, this.f246886m), r110);
        if (this.f246883j == true) goto L5;
    L9:
        return r101;
    L5:
        if (this.f246885l == true) goto L9;
        if (this.f246886m == true) goto L9;
        E0(r101);
        goto L9
    }

    public SSWebView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f246878e = UUID.randomUUID().toString();
        this.f246879f = 500;
        this.f246882i = true;
        this.f246884k = "";
        this.f246888o = new a();
        this.B = AuthUrlSourceType.Unset;
        this.C = new c();
        this.D = new CopyOnWriteArrayList();
    }

    @Override // com.bytedance.webx.core.webview.WebViewContainer, android.webkit.WebView
    public final void loadData(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "data");
        super.loadData(r100, r101, r102);     // Catch: Exception -> L5
        return;
    }

    public /* synthetic */ SSWebView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // com.bytedance.webx.core.webview.WebViewContainer, android.webkit.WebView, android.view.View
    public final void onOverScrolled(int r100, int r101, boolean r102, boolean r103) {
        g r104 = this.f246892s;
        if (r104 != null) goto L17;
    L5:
        Iterator<T> r105 = this.D.iterator();
    L7:
        if (r105.hasNext() == false) goto L12;
        ((g) r105.next()).a(r100, r101, r102, r103);     // Catch: YieldError -> L11
        goto L7
    L12:
        super.onOverScrolled(r100, r101, r102, r103);
        return;
    L17:
        r104.a(r100, r101, r102, r103);     // Catch: YieldError -> L14
        goto L5
    }

    @Override // com.bytedance.webx.core.webview.WebViewContainer, android.webkit.WebView, android.view.View
    public final void onScrollChanged(int r100, int r101, int r102, int r103) {
        super.onScrollChanged(r100, r101, r102, r103);
        e r104 = this.f246889p;
        if (r104 == null) goto L6;
        r104.onScrollChanged(r100, r101, r102, r103);
        return;
    }

    @Override // com.bytedance.webx.core.webview.WebViewContainer, android.webkit.WebView
    public final void loadDataWithBaseURL(String r100, String r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r101, "data");
        super.loadDataWithBaseURL(r100, r101, r102, r103, r104);     // Catch: Exception -> L5
        return;
    }

    @Override // com.bytedance.webx.core.webview.WebViewContainer, android.view.View
    public boolean overScrollBy(int r110, int r111, int r112, int r113, int r114, int r115, int r116, int r117, boolean r210) {
        d r100 = this.f246890q;
        if (r100 == null) goto L6;
        r100.b(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    L6:
        return super.overScrollBy(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }
}
