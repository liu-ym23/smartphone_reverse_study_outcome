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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u0003\b\u0016\u0018\u0000 72\u00020\u00012\u00020\u0002:\u000278B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0014J\b\u0010'\u001a\u00020$H\u0014J\b\u0010(\u001a\u00020$H\u0014J\u0012\u0010)\u001a\u00020$2\b\u0010*\u001a\u0004\u0018\u00010&H\u0014J\b\u0010+\u001a\u00020$H\u0014J\b\u0010,\u001a\u00020$H\u0014J\b\u0010-\u001a\u00020$H\u0014J\u001c\u0010.\u001a\u00020\"2\b\u0010/\u001a\u0004\u0018\u00010\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\u001c\u00100\u001a\u00020\"2\b\u0010/\u001a\u0004\u0018\u00010\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J8\u00101\u001a\u00020$2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u00102\u001a\u0004\u0018\u00010\u00062\b\u00103\u001a\u0004\u0018\u00010\u00062\b\u00104\u001a\u0004\u0018\u00010\u00062\u0006\u00105\u001a\u000206H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\u001cX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/bytedance/ee/bear/document/web/CommonWebActivity;", "Lcom/bytedance/ee/bear/facade/common/BaseActivity;", "Landroid/webkit/DownloadListener;", "<init>", "()V", "url", "", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "mWebView", "Landroid/webkit/WebView;", "getMWebView", "()Landroid/webkit/WebView;", "setMWebView", "(Landroid/webkit/WebView;)V", "mTitle", "Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "getMTitle", "()Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "setMTitle", "(Lcom/bytedance/ee/bear/widgets/BaseTitleBar;)V", "mErrorLayout", "Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEmptyState;", "mFrameLayout", "Landroid/widget/FrameLayout;", "mLoadingView", "Lcom/bytedance/ee/bear/document/loading/LoadingLayout;", "getMLoadingView", "()Lcom/bytedance/ee/bear/document/loading/LoadingLayout;", "setMLoadingView", "(Lcom/bytedance/ee/bear/document/loading/LoadingLayout;)V", "mConnect", "", "onDoCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "initNotNetTip", "initWebview", "bundle", "initWebSettings", "initUserAgent", "startWeb", "handleLink", "view", "isRedirect", "onDownloadStart", "userAgent", "contentDisposition", "mimetype", "contentLength", "", "Companion", "WebviewActivityClient", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class CommonWebActivity extends BaseActivity implements DownloadListener {
    public static c5 j;
    public String c;
    public WebView d;
    public BaseTitleBar e;
    public SpaceEmptyState f;
    public FrameLayout g;
    public LoadingLayout h;
    public boolean i;

    public static final class a {
    }

    public final class b extends WebViewClient {
        public final /* synthetic */ CommonWebActivity a;

        public static final class a<T, R> implements Function {
            public static final a<T, R> a = null;

            static {
                a = new a();
            }

            public a() {
            }

            public final Object apply(Object r3) {
                Intrinsics.checkNotNullParameter((String) r3, "it");
                return (x) org.koin.java.a.c(x.class, null, null, 6);
            }
        }

        /* JADX INFO: renamed from: com.bytedance.ee.bear.document.web.CommonWebActivity$b$b, reason: collision with other inner class name */
        public static final class C0115b<T, R> implements Function {
            public static final C0115b<T, R> a = null;

            static {
                a = new C0115b();
            }

            public C0115b() {
            }

            public final Object apply(Object r2) {
                x r3 = (x) r2;
                Intrinsics.checkNotNullParameter(r3, "hostService");
                r3.x();
                return "";
            }
        }

        public static final class c<T> implements Consumer {
            public final /* synthetic */ CommonWebActivity a;

            public c(CommonWebActivity r1) {
                this.a = r1;
            }

            public final void accept(Object r2) {
                String r3 = (String) r2;
                this.a.finish();
                tt5.a.b("CommonWebActivity", "hostService routeToLarkAbout success ");
            }
        }

        public static final class d<T> implements Consumer {
            public static final d<T> a = null;

            static {
                a = new d();
            }

            public d() {
            }

            public final void accept(Object r4) {
                tt5.a.e("CommonWebActivity", "hostService routeToLarkAbout fail", (Throwable) r4, false);
            }
        }

        public b(CommonWebActivity r1) {
            this.a = r1;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView r1, String r2) {
            super.onPageFinished(r1, r2);
            tt5.a.h("CommonWebActivity", "onPageFinished:");
        }

        @Override // android.webkit.WebViewClient
        public final boolean shouldOverrideUrlLoading(WebView r7, WebResourceRequest r8) {
            String r0 = null;
            if (r8 == null) goto L7;
            Uri r1 = r8.getUrl();
            if (r1 == null) goto L7;
            String r2 = r1.toString();
        L8:
            boolean r3 = false;
            if (r2 != null) goto L11;
        L14:
            boolean r4 = true;
        L15:
            if (r4 == false) goto L18;
            return false;
        L18:
            if ("lark://inner/mine/about".equals(r2) == false) goto L51;
            Flowable.just("").subscribeOn(fo5.d.b()).map(a.a).map(C0115b.a).observeOn(fo5.d.d()).subscribe(new c(this.a), d.a);
            return true;
        L51:
            r2 = URLDecoder.decode(r2, "UTF-8");     // Catch: Throwable -> L23
        L25:
            if (r8 == null) goto L30;
            Uri r5 = r8.getUrl();
            if (r5 == null) goto L30;
            r0 = r5.getHost();
        L30:
            if (TextUtils.isEmpty(r0) == false) goto L32;
        L40:
            boolean r6 = false;
        L41:
            if (r6 == true) goto L43;
        L45:
            if (r3 == true) goto L50;
            CommonWebActivity r9 = this.a;
            c5 r10 = CommonWebActivity.j;
            if (r9.D1(r7, r2) == false) goto L50;
            return true;
        L50:
            return super.shouldOverrideUrlLoading(r7, r8);
        L43:
            if (p.a().v6(r2) == true) goto L45;
            r3 = true;
            goto L45
        L32:
            if (t.c(r0, "feishu.cn") == false) goto L34;
        L39:
            r6 = true;
            goto L41
        L34:
            if (t.c(r0, "larksuite.com") == true) goto L39;
            if (t.c(r0, "feishu.net") == true) goto L39;
            if (t.c(r0, "larkoffice.com") == false) goto L40;
        L23:
            th = move-exception;
            tt5.a.f("CommonWebActivity", th, false);
            goto L25
        L11:
            if (StringsKt.isBlank(r2) == true) goto L14;
            r4 = false;
        L7:
            r2 = null;
            goto L8
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView r1, String r2, Bitmap r3) {
            super.onPageStarted(r1, r2, r3);
            tt5.a.h("CommonWebActivity", "onPageStarted:");
        }
    }

    static {
    }

    public void F1() {
    }

    public final WebView C1() {
        WebView r0 = this.d;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mWebView");
        return null;
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.facade.common.BaseActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity
    public void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(getClass().getName()));
        long r3 = SystemClock.uptimeMillis();
        Map r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = (Long) r5.get(this);     // Catch: Throwable -> L45
        if (r6 != null) goto L10;
    L13:
        r5.put(this, Long.valueOf(r3));     // Catch: Throwable -> L45
        monitor-exit(r5);     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L50:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r2.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L50
    L19:
        if (isFinishing() == true) goto L22;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L50
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L50
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L50
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L50
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L50
    L33:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r1 == null) goto L50;
        r1.addFlags(268435456);     // Catch: Throwable -> L42
        r1.addFlags(2097152);     // Catch: Throwable -> L42
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r1);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L50
    L10:
        if ((r3 - r6.longValue()) >= 800) goto L13;
        monitor-exit(r5);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity
    public void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
    }

    public CommonWebActivity() {
        this.c = "file:///android_asset/html/default_web.html";
        this.i = true;
    }

    public void G1() {
        WebView r0 = C1();
        String r1 = this.c;
        Intrinsics.checkNotNull(r1);
        r0.loadUrl(r1);
    }

    public final void onResume() {
        super/*androidx.fragment.app.FragmentActivity*/.onResume();
        C1().resumeTimers();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.facade.common.BaseActivity
    public final void B1(Bundle r3) {
        setContentView(2131560072);
        Bundle r0 = null;
        ((h) org.koin.java.a.c(h.class, null, null, 6)).X8(this);
        Intent r4 = getIntent();
        if (r4 == null) goto L5;
        r0 = r4.getExtras();
    L5:
        this.f = findViewById(2131367554);
        this.g = (FrameLayout) findViewById(2131367559);
        j.a.a.a().observe(this, new n45.a(this));
        if (r0 == null) goto L9;
        String r5 = r0.getString("web_url");
        if (r5 == null) goto L9;
    L10:
        this.c = r5;
        if (r5.length() != 0) goto L13;
        boolean r6 = true;
    L14:
        if (r6 == false) goto L16;
        this.c = "file:///android_asset/html/default_web.html";
    L16:
        WebView r7 = (WebView) findViewById(2131367584);
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        this.d = r7;
        if (j == null) goto L19;
        C1();
    L19:
        LoadingLayout r8 = (LoadingLayout) findViewById(2131367564);
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        this.h = r8;
        BaseTitleBar r9 = findViewById(2131367578);
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        this.e = r9;
        tt5.a.b("CommonWebActivity", "initWebview: url= ");
        C1().setWebViewClient(new b(this));
        C1().setWebChromeClient(new n45.b(this));
        C1().setDownloadListener(this);
        WebSettings r10 = C1().getSettings();
        r10.setAllowFileAccess(true);
        r10.setJavaScriptCanOpenWindowsAutomatically(true);
        r10.setJavaScriptEnabled(true);
        r10.setSupportZoom(true);
        r10.setBuiltInZoomControls(true);
        r10.setUseWideViewPort(true);
        r10.setLoadWithOverviewMode(true);
        r10.setCacheMode(-1);
        r10.setDomStorageEnabled(true);
        F1();
        G1();
        return;
    L13:
        r6 = false;
    L9:
        r5 = "";
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean D1(WebView r8, String r9) {
        String r0 = null;
        if (r8 == null) goto L5;
        WebView.HitTestResult r10 = r8.getHitTestResult();
    L7:
        if (r10 != null) goto L9;
    L12:
        boolean r11 = true;
    L14:
        if (r11 == false) goto L40;
        h r12 = (h) org.koin.java.a.c(h.class, null, null, 6);
        if (r12 == null) goto L38;
        RouteBean r4 = new RouteBean();
        Serializable r5 = getIntent().getSerializableExtra("extra_data_map");
        if (r5 == null) goto L20;
        r4.k = (Map) r5;
    L20:
        r12.m9(r9, r4);
        Activity r13 = r12.getCurrentActivity();
        if (r13 == null) goto L25;
        ComponentName r14 = r13.getComponentName();
        if (r14 == null) goto L25;
        String r16 = r14.getClassName();
    L26:
        Intent r17 = r12.W0();
        if (r17 == null) goto L31;
        ComponentName r18 = r17.getComponent();
        if (r18 == null) goto L31;
        r0 = r18.getClassName();
    L31:
        if (r16 != null) goto L34;
        if (r0 != null) goto L34;
    L35:
        finish();
        return true;
    L34:
        if (Objects.equals(r16, r0) == false) goto L35;
        tt5.a.h("CommonWebActivity", "shouldOverrideUrlLoading: same activity");
    L39:
        return false;
    L25:
        r16 = null;
        goto L26
    L38:
        tt5.a.h("CommonWebActivity", "shouldOverrideUrlLoading: routeService = null");
        goto L39
    L40:
        ((k) org.koin.java.a.c(k.class, null, null, 6)).d(r9);
        return true;
    L9:
        if (r10.getType() == 0) goto L12;
        r11 = false;
        goto L14
    L5:
        r10 = null;
        goto L7
    }

    @Override // android.webkit.DownloadListener
    public final void onDownloadStart(String r1, String r2, String r3, String r4, long r5) {
        D1(C1(), r1);
    }
}
