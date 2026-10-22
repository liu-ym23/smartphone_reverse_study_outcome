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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class TuringLiveDetectWebActivity extends AppCompatActivity implements View.OnClickListener {
    public static final /* synthetic */ int i = 0;
    public WebView a;
    public TextView b;
    public String c;
    public boolean d;
    public long e;
    public long f;
    public final a g;
    public final b h;

    public class a extends WebChromeClient {
        public final /* synthetic */ TuringLiveDetectWebActivity a;

        public a(TuringLiveDetectWebActivity r1) {
            this.a = r1;
        }

        @Override // android.webkit.WebChromeClient
        public final boolean onConsoleMessage(ConsoleMessage r7) {
            TuringLiveDetectWebActivity r0 = this.a;
            int r1 = TuringLiveDetectWebActivity.i;
            r0.getClass();
            if (e.a().equals(r0.c) == false) goto L12;
            TuringLiveDetectWebActivity r2 = this.a;
            if (r2.d == true) goto L12;
            long r3 = System.currentTimeMillis();
            TuringLiveDetectWebActivity r4 = this.a;
            r2.f = r3 - r4.e;
            if (r7 == null) goto L9;
            String r5 = r7.message();
        L10:
            r4.d = "loadProtocolSuc".equals(r5);
            goto L12
        L9:
            r5 = "";
        L12:
            return super.onConsoleMessage(r7);
        }
    }

    public class b extends WebViewClient {
        public final /* synthetic */ TuringLiveDetectWebActivity a;

        public b(TuringLiveDetectWebActivity r1) {
            this.a = r1;
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView r2, String r3) {
            int r0 = n.a;
            super.onLoadResource(r2, r3);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView r5, String r6) {
            super.onPageFinished(r5, r6);
            TuringLiveDetectWebActivity r7 = this.a;
            int r8 = TuringLiveDetectWebActivity.i;
            r7.getClass();
            if (e.a().equals(r7.c) == true) goto L7;
            TuringLiveDetectWebActivity r9 = this.a;
            if (r9.d == true) goto L7;
            r9.d = true;
            r9.f = System.currentTimeMillis() - this.a.e;
        L7:
            int r10 = n.a;
        }

        @Override // android.webkit.WebViewClient
        public final WebResourceResponse shouldInterceptRequest(WebView r4, String r5) {
            if (r5.toLowerCase().contains("/favicon.ico") == false) goto L9;
            return new WebResourceResponse("image/png", null, null);
        L6:
            e = move-exception;
            e.printStackTrace();
        L9:
            return super.shouldInterceptRequest(r4, r5);
        }
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
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

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
        if (e.a().equals(this.c) == false) goto L19;
        boolean r0 = this.d;
        long r1 = this.f;
        jc4.a r3 = LiveDetectService.getInstance().getRequest();
        JSONObject r4 = new JSONObject();     // Catch: Exception -> L14
        r4.put("key", "live_agreement_load_result");     // Catch: Exception -> L14
        r4.put("duration", r1);     // Catch: Exception -> L14
        if (r0 == false) goto L11;
        int r2 = 0;
    L12:
        r4.put("result", r2);     // Catch: Exception -> L14
        EventReport.w("turing_verify_sdk", r4, r3);     // Catch: Exception -> L14
        return;
    L11:
        r2 = 1;
    L14:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public TuringLiveDetectWebActivity() {
        this.a = null;
        this.g = new a(this);
        this.h = new b(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r0 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (com.larus.home.impl.utils.c.e == false) goto L9;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r1 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r1 == com.larus.home.impl.utils.c.a) goto L9;
        com.larus.home.impl.utils.c.a(r1, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r0.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        if (r2.getId() != 2131376031) goto L6;
        finish();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r5) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L25
    L6:
        if (f.f(this) == false) goto L8;
        f.c(getTheme());     // Catch: Throwable -> L25
    L8:
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(r5);
        setContentView(2131558524);
        this.d = false;
        ((ImageView) findViewById(2131376031)).setOnClickListener(this);
        this.b = (TextView) findViewById(2131391606);
        WebView r0 = (WebView) findViewById(2131393025);
        this.a = r0;
        WebSettings r1 = r0.getSettings();
        boolean r2 = true;
        r1.setLoadWithOverviewMode(true);
        r1.setUseWideViewPort(true);
        r1.setSupportZoom(false);
        r1.setAllowFileAccessFromFileURLs(false);
        r1.setAllowFileAccess(false);
        r1.setLoadsImagesAutomatically(true);
        r1.setJavaScriptEnabled(true);
        r1.setDefaultTextEncodingName("utf-8");
        r1.setCacheMode(2);
        r1.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        r1.setTextZoom(100);
        this.a.setOverScrollMode(2);     // Catch: Throwable -> L11
    L13:
        this.a.setScrollContainer(false);
        this.a.setHorizontalScrollBarEnabled(false);
        this.a.setVerticalScrollBarEnabled(false);
        this.a.setWebViewClient(this.h);
        this.a.setWebChromeClient(this.g);
        this.c = getIntent().getStringExtra("url");
        String r3 = getIntent().getStringExtra("title");
        this.b.setText(r3);
        String r4 = this.c;
        if (TextUtils.isEmpty(r4) == false) goto L16;
    L20:
        r2 = false;
    L21:
        if (r2 == false) goto L23;
        this.e = System.currentTimeMillis();
        this.a.loadUrl(this.c);
        return;
    L23:
        Toast.makeText(this, "illegal params error", 0).show();
        finish();
        return;
    L16:
        if (e.a().equals(r4) == true) goto L21;
        if (e.b().equals(r4) == false) goto L20;
    L11:
        th = move-exception;
        th.printStackTrace();
        goto L13
    }

    public static void startActivity(Activity r2, String r3, String r4) {
        Intent r0 = new Intent(r2, TuringLiveDetectWebActivity.class);
        r0.putExtra("url", r3);
        r0.putExtra("title", r4);
        r2.startActivity(r0);
    }
}
