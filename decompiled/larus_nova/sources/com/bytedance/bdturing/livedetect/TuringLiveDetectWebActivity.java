package com.bytedance.bdturing.livedetect;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.bdturing.EventReport;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import org.json.JSONObject;
import qb4.n;
import v19.f;
import vb4.e;

/* JADX INFO: loaded from: classes14.dex */
public class TuringLiveDetectWebActivity extends AppCompatActivity implements View.OnClickListener {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f201880i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WebView f201881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f201882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f201883c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f201884d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f201885e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f201886f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f201887g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b f201888h;

    public class a extends WebChromeClient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TuringLiveDetectWebActivity f201889a;

        public a(TuringLiveDetectWebActivity r100) {
            this.f201889a = r100;
        }

        @Override // android.webkit.WebChromeClient
        public final boolean onConsoleMessage(ConsoleMessage r100) {
            TuringLiveDetectWebActivity r101 = this.f201889a;
            int r102 = TuringLiveDetectWebActivity.f201880i;
            r101.getClass();
            if (e.a().equals(r101.f201883c) == false) goto L12;
            TuringLiveDetectWebActivity r103 = this.f201889a;
            if (r103.f201884d == true) goto L12;
            long r104 = System.currentTimeMillis();
            TuringLiveDetectWebActivity r105 = this.f201889a;
            r103.f201886f = r104 - r105.f201885e;
            if (r100 == null) goto L9;
            String r106 = r100.message();
        L10:
            r105.f201884d = "loadProtocolSuc".equals(r106);
            goto L12
        L9:
            r106 = "";
        L12:
            return super.onConsoleMessage(r100);
        }
    }

    public class b extends WebViewClient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TuringLiveDetectWebActivity f201890a;

        public b(TuringLiveDetectWebActivity r100) {
            this.f201890a = r100;
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView r100, String r101) {
            int r102 = n.f532367a;
            super.onLoadResource(r100, r101);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView r100, String r101) {
            super.onPageFinished(r100, r101);
            TuringLiveDetectWebActivity r102 = this.f201890a;
            int r103 = TuringLiveDetectWebActivity.f201880i;
            r102.getClass();
            if (e.a().equals(r102.f201883c) == true) goto L7;
            TuringLiveDetectWebActivity r104 = this.f201890a;
            if (r104.f201884d == true) goto L7;
            r104.f201884d = true;
            r104.f201886f = System.currentTimeMillis() - this.f201890a.f201885e;
        L7:
            int r105 = n.f532367a;
        }

        @Override // android.webkit.WebViewClient
        public final WebResourceResponse shouldInterceptRequest(WebView r100, String r101) {
            if (r101.toLowerCase().contains("/favicon.ico") == false) goto L9;
            return new WebResourceResponse("image/png", null, null);
        L6:
            e = move-exception;
            e.printStackTrace();
        L9:
            return super.shouldInterceptRequest(r100, r101);
        }
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
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

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
        if (e.a().equals(this.f201883c) == false) goto L19;
        boolean r100 = this.f201884d;
        long r101 = this.f201886f;
        jc4.a r102 = LiveDetectService.getInstance().getRequest();
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L14
        r103.put("key", "live_agreement_load_result");     // Catch: Exception -> L14
        r103.put("duration", r101);     // Catch: Exception -> L14
        if (r100 == false) goto L11;
        int r104 = 0;
    L12:
        r103.put("result", r104);     // Catch: Exception -> L14
        EventReport.w("turing_verify_sdk", r103, r102);     // Catch: Exception -> L14
        return;
    L11:
        r104 = 1;
    L14:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public TuringLiveDetectWebActivity() {
        this.f201881a = null;
        this.f201887g = new a(this);
        this.f201888h = new b(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r100 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (com.larus.home.impl.utils.c.f346345e == false) goto L9;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r101 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r101 == com.larus.home.impl.utils.c.f346341a) goto L9;
        com.larus.home.impl.utils.c.a(r101, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r100.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r100) {
        if (r100.getId() != com.larus.nova.R.id.iv_back) goto L6;
        finish();
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r100) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L25
    L6:
        if (f.f(this) == false) goto L8;
        f.c(getTheme());     // Catch: Throwable -> L25
    L8:
        super.onCreate(r100);
        setContentView(com.larus.nova.R.layout.activity_turing_live_detect_web);
        this.f201884d = false;
        ((ImageView) findViewById(com.larus.nova.R.id.iv_back)).setOnClickListener(this);
        this.f201882b = (TextView) findViewById(com.larus.nova.R.id.tv_title);
        WebView r101 = (WebView) findViewById(com.larus.nova.R.id.wb_live_detect);
        this.f201881a = r101;
        WebSettings r102 = r101.getSettings();
        boolean r103 = true;
        r102.setLoadWithOverviewMode(true);
        r102.setUseWideViewPort(true);
        r102.setSupportZoom(false);
        r102.setAllowFileAccessFromFileURLs(false);
        r102.setAllowFileAccess(false);
        r102.setLoadsImagesAutomatically(true);
        r102.setJavaScriptEnabled(true);
        r102.setDefaultTextEncodingName(XML.CHARSET_UTF8);
        r102.setCacheMode(2);
        r102.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        r102.setTextZoom(100);
        this.f201881a.setOverScrollMode(2);     // Catch: Throwable -> L11
    L13:
        this.f201881a.setScrollContainer(false);
        this.f201881a.setHorizontalScrollBarEnabled(false);
        this.f201881a.setVerticalScrollBarEnabled(false);
        this.f201881a.setWebViewClient(this.f201888h);
        this.f201881a.setWebChromeClient(this.f201887g);
        this.f201883c = getIntent().getStringExtra("url");
        String r104 = getIntent().getStringExtra("title");
        this.f201882b.setText(r104);
        String r105 = this.f201883c;
        if (TextUtils.isEmpty(r105) == false) goto L16;
    L20:
        r103 = false;
    L21:
        if (r103 == false) goto L23;
        this.f201885e = System.currentTimeMillis();
        this.f201881a.loadUrl(this.f201883c);
        return;
    L23:
        Toast.makeText(this, "illegal params error", 0).show();
        finish();
        return;
    L16:
        if (e.a().equals(r105) == true) goto L21;
        if (e.b().equals(r105) == false) goto L20;
    L11:
        th = move-exception;
        th.printStackTrace();
        goto L13
    }

    public static void startActivity(Activity r100, String r101, String r102) {
        Intent r103 = new Intent(r100, TuringLiveDetectWebActivity.class);
        r103.putExtra("url", r101);
        r103.putExtra("title", r102);
        r100.startActivity(r103);
    }
}
