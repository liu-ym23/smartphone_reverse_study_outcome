package com.bytedance.ee.bear.document.web;

import android.R;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.DownloadListener;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.contract.x;
import com.bytedance.ee.bear.docshost.k;
import com.bytedance.ee.bear.document.c5;
import com.bytedance.ee.bear.document.loading.LoadingLayout;
import com.bytedance.ee.bear.facade.common.BaseActivity;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.bear.route.h;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import f25.t;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.io.Serializable;
import java.net.URLDecoder;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import s45.p;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u0003\b\u0016\u0018\u0000 72\u00020\u00012\u00020\u0002:\u000278B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0014J\b\u0010'\u001a\u00020$H\u0014J\b\u0010(\u001a\u00020$H\u0014J\u0012\u0010)\u001a\u00020$2\b\u0010*\u001a\u0004\u0018\u00010&H\u0014J\b\u0010+\u001a\u00020$H\u0014J\b\u0010,\u001a\u00020$H\u0014J\b\u0010-\u001a\u00020$H\u0014J\u001c\u0010.\u001a\u00020\"2\b\u0010/\u001a\u0004\u0018\u00010\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\u001c\u00100\u001a\u00020\"2\b\u0010/\u001a\u0004\u0018\u00010\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J8\u00101\u001a\u00020$2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u00102\u001a\u0004\u0018\u00010\u00062\b\u00103\u001a\u0004\u0018\u00010\u00062\b\u00104\u001a\u0004\u0018\u00010\u00062\u0006\u00105\u001a\u000206H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\u001cX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/bytedance/ee/bear/document/web/CommonWebActivity;", "Lcom/bytedance/ee/bear/facade/common/BaseActivity;", "Landroid/webkit/DownloadListener;", "<init>", "()V", "url", "", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "mWebView", "Landroid/webkit/WebView;", "getMWebView", "()Landroid/webkit/WebView;", "setMWebView", "(Landroid/webkit/WebView;)V", "mTitle", "Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "getMTitle", "()Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "setMTitle", "(Lcom/bytedance/ee/bear/widgets/BaseTitleBar;)V", "mErrorLayout", "Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEmptyState;", "mFrameLayout", "Landroid/widget/FrameLayout;", "mLoadingView", "Lcom/bytedance/ee/bear/document/loading/LoadingLayout;", "getMLoadingView", "()Lcom/bytedance/ee/bear/document/loading/LoadingLayout;", "setMLoadingView", "(Lcom/bytedance/ee/bear/document/loading/LoadingLayout;)V", "mConnect", "", "onDoCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "initNotNetTip", "initWebview", "bundle", "initWebSettings", "initUserAgent", "startWeb", "handleLink", "view", "isRedirect", "onDownloadStart", "userAgent", "contentDisposition", "mimetype", "contentLength", "", "Companion", "WebviewActivityClient", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class CommonWebActivity extends BaseActivity implements DownloadListener {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static c5 f222468j;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f222469c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WebView f222470d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BaseTitleBar f222471e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SpaceEmptyState f222472f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public FrameLayout f222473g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LoadingLayout f222474h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f222475i;

    public static final class a {
    }

    public final class b extends WebViewClient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommonWebActivity f222476a;

        public static final class a<T, R> implements Function {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a<T, R> f222477a = null;

            static {
                f222477a = new a();
            }

            public a() {
            }

            @Override // io.reactivex.functions.Function
            public final Object apply(Object r100) {
                Intrinsics.checkNotNullParameter((String) r100, "it");
                return (x) org.koin.java.a.c(x.class, null, null, 6);
            }
        }

        /* JADX INFO: renamed from: com.bytedance.ee.bear.document.web.CommonWebActivity$b$b, reason: collision with other inner class name */
        public static final class C3171b<T, R> implements Function {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C3171b<T, R> f222478a = null;

            static {
                f222478a = new C3171b();
            }

            public C3171b() {
            }

            @Override // io.reactivex.functions.Function
            public final Object apply(Object r100) {
                x r101 = (x) r100;
                Intrinsics.checkNotNullParameter(r101, "hostService");
                r101.x();
                return "";
            }
        }

        public static final class c<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CommonWebActivity f222479a;

            public c(CommonWebActivity r100) {
                this.f222479a = r100;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                String r101 = (String) r100;
                this.f222479a.finish();
                tt5.a.b("CommonWebActivity", "hostService routeToLarkAbout success ");
            }
        }

        public static final class d<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final d<T> f222480a = null;

            static {
                f222480a = new d();
            }

            public d() {
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                tt5.a.e("CommonWebActivity", "hostService routeToLarkAbout fail", (Throwable) r100, false);
            }
        }

        public b(CommonWebActivity r100) {
            this.f222476a = r100;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView r100, String r101) {
            super.onPageFinished(r100, r101);
            tt5.a.h("CommonWebActivity", "onPageFinished:");
        }

        @Override // android.webkit.WebViewClient
        public final boolean shouldOverrideUrlLoading(WebView r100, WebResourceRequest r101) {
            String r102 = null;
            if (r101 == null) goto L7;
            Uri r103 = r101.getUrl();
            if (r103 == null) goto L7;
            String r104 = r103.toString();
        L8:
            boolean r105 = false;
            if (r104 != null) goto L11;
        L14:
            boolean r106 = true;
        L15:
            if (r106 == false) goto L18;
            return false;
        L18:
            if ("lark://inner/mine/about".equals(r104) == false) goto L51;
            Flowable.just("").subscribeOn(fo5.d.b()).map(a.f222477a).map(C3171b.f222478a).observeOn(fo5.d.d()).subscribe(new c(this.f222476a), d.f222480a);
            return true;
        L51:
            r104 = URLDecoder.decode(r104, "UTF-8");     // Catch: Throwable -> L23
        L25:
            if (r101 == null) goto L30;
            Uri r107 = r101.getUrl();
            if (r107 == null) goto L30;
            r102 = r107.getHost();
        L30:
            if (TextUtils.isEmpty(r102) == false) goto L32;
        L40:
            boolean r108 = false;
        L41:
            if (r108 == true) goto L43;
        L45:
            if (r105 == true) goto L50;
            CommonWebActivity r109 = this.f222476a;
            c5 r110 = CommonWebActivity.f222468j;
            if (r109.D1(r100, r104) == false) goto L50;
            return true;
        L50:
            return super.shouldOverrideUrlLoading(r100, r101);
        L43:
            if (p.a().v6(r104) == true) goto L45;
            r105 = true;
            goto L45
        L32:
            if (t.c(r102, "feishu.cn") == false) goto L34;
        L39:
            r108 = true;
            goto L41
        L34:
            if (t.c(r102, "larksuite.com") == true) goto L39;
            if (t.c(r102, "feishu.net") == true) goto L39;
            if (t.c(r102, "larkoffice.com") == false) goto L40;
        L23:
            th = move-exception;
            tt5.a.f("CommonWebActivity", th, false);
            goto L25
        L11:
            if (StringsKt.isBlank(r104) == true) goto L14;
            r106 = false;
        L7:
            r104 = null;
            goto L8
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView r100, String r101, Bitmap r102) {
            super.onPageStarted(r100, r101, r102);
            tt5.a.h("CommonWebActivity", "onPageStarted:");
        }
    }

    static {
    }

    public void F1() {
    }

    public final WebView C1() {
        WebView r100 = this.f222470d;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mWebView");
        return null;
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    @Override // com.bytedance.ee.bear.facade.common.BaseActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(getClass().getName()));
        long r101 = SystemClock.uptimeMillis();
        Map<Activity, Long> r102 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r102);
        Long r103 = r102.get(this);     // Catch: Throwable -> L45
        if (r103 != null) goto L10;
    L13:
        r102.put(this, Long.valueOf(r101));     // Catch: Throwable -> L45
        monitor-exit(r102);     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L50:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r100.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L50
    L19:
        if (isFinishing() == true) goto L22;
        r100.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L50
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r100.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L50
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r100.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L50
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r100.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L50
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L50
    L33:
        Intent r104 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r104 == null) goto L50;
        r104.addFlags(268435456);     // Catch: Throwable -> L42
        r104.addFlags(2097152);     // Catch: Throwable -> L42
        r100.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r104);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L50
    L10:
        if ((r101 - r103.longValue()) >= 800) goto L13;
        monitor-exit(r102);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
    }

    public CommonWebActivity() {
        this.f222469c = "file:///android_asset/html/default_web.html";
        this.f222475i = true;
    }

    public void G1() {
        WebView r100 = C1();
        String r101 = this.f222469c;
        Intrinsics.checkNotNull(r101);
        r100.loadUrl(r101);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        C1().resumeTimers();
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseActivity
    public final void B1(Bundle r100) {
        setContentView(com.larus.nova.R.layout.doc_common_web_activity);
        Bundle r101 = null;
        ((h) org.koin.java.a.c(h.class, null, null, 6)).X8(this);
        Intent r102 = getIntent();
        if (r102 == null) goto L5;
        r101 = r102.getExtras();
    L5:
        this.f222472f = (SpaceEmptyState) findViewById(com.larus.nova.R.id.common_empty_state);
        this.f222473g = (FrameLayout) findViewById(com.larus.nova.R.id.common_fl_webview);
        j.a.f217090a.a().observe(this, new n45.a(this));
        if (r101 == null) goto L9;
        String r103 = r101.getString("web_url");
        if (r103 == null) goto L9;
    L10:
        this.f222469c = r103;
        if (r103.length() != 0) goto L13;
        boolean r104 = true;
    L14:
        if (r104 == false) goto L16;
        this.f222469c = "file:///android_asset/html/default_web.html";
    L16:
        WebView r105 = (WebView) findViewById(com.larus.nova.R.id.common_webview);
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        this.f222470d = r105;
        if (f222468j == null) goto L19;
        C1();
    L19:
        LoadingLayout r106 = (LoadingLayout) findViewById(com.larus.nova.R.id.common_loading);
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        this.f222474h = r106;
        BaseTitleBar r107 = (BaseTitleBar) findViewById(com.larus.nova.R.id.common_title);
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        this.f222471e = r107;
        tt5.a.b("CommonWebActivity", "initWebview: url= ");
        C1().setWebViewClient(new b(this));
        C1().setWebChromeClient(new n45.b(this));
        C1().setDownloadListener(this);
        WebSettings r108 = C1().getSettings();
        r108.setAllowFileAccess(true);
        r108.setJavaScriptCanOpenWindowsAutomatically(true);
        r108.setJavaScriptEnabled(true);
        r108.setSupportZoom(true);
        r108.setBuiltInZoomControls(true);
        r108.setUseWideViewPort(true);
        r108.setLoadWithOverviewMode(true);
        r108.setCacheMode(-1);
        r108.setDomStorageEnabled(true);
        F1();
        G1();
        return;
    L13:
        r104 = false;
    L9:
        r103 = "";
        goto L10
    }

    public final boolean D1(WebView r100, String r101) {
        String r102 = null;
        if (r100 == null) goto L5;
        WebView.HitTestResult r103 = r100.getHitTestResult();
    L7:
        if (r103 != null) goto L9;
    L12:
        boolean r104 = true;
    L14:
        if (r104 == false) goto L40;
        h r105 = (h) org.koin.java.a.c(h.class, null, null, 6);
        if (r105 == null) goto L38;
        RouteBean r106 = new RouteBean();
        Serializable r107 = getIntent().getSerializableExtra("extra_data_map");
        if (r107 == null) goto L20;
        r106.f236646k = (Map) r107;
    L20:
        r105.m9(r101, r106);
        Activity r108 = r105.getCurrentActivity();
        if (r108 == null) goto L25;
        ComponentName r109 = r108.getComponentName();
        if (r109 == null) goto L25;
        String r110 = r109.getClassName();
    L26:
        Intent r111 = r105.W0();
        if (r111 == null) goto L31;
        ComponentName r112 = r111.getComponent();
        if (r112 == null) goto L31;
        r102 = r112.getClassName();
    L31:
        if (r110 != null) goto L34;
        if (r102 != null) goto L34;
    L35:
        finish();
        return true;
    L34:
        if (Objects.equals(r110, r102) == false) goto L35;
        tt5.a.h("CommonWebActivity", "shouldOverrideUrlLoading: same activity");
    L39:
        return false;
    L25:
        r110 = null;
        goto L26
    L38:
        tt5.a.h("CommonWebActivity", "shouldOverrideUrlLoading: routeService = null");
        goto L39
    L40:
        ((k) org.koin.java.a.c(k.class, null, null, 6)).d(r101);
        return true;
    L9:
        if (r103.getType() == 0) goto L12;
        r104 = false;
        goto L14
    L5:
        r103 = null;
        goto L7
    }

    @Override // android.webkit.DownloadListener
    public final void onDownloadStart(String r100, String r101, String r102, String r103, long r104) {
        D1(C1(), r100);
    }
}
