package com.ss.android.dypay.activity;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.animation.LinearInterpolator;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.android.ttcjpaysdk.base.ui.dialog.CJPayLynxStandardKeepActivity;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.common.applog.EventVerify;
import com.ss.android.downloadlib.constants.DownloadConstants;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.dypay.views.g;
import com.ss.android.dypay.webview.DyJsWebView;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import v19.f;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/ss/android/dypay/activity/DyPayH5Activity;", "Lcom/ss/android/dypay/activity/a;", "Lcom/ss/android/dypay/webview/e;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "dy-pay-sdk_withoutLogRelease"}, k = 1, mv = {1, 4, 0})
public final class DyPayH5Activity extends com.ss.android.dypay.activity.a implements com.ss.android.dypay.webview.e {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ int f408351v = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DyJsWebView f408352c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f408353d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f408354e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f408355f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f408356g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ObjectAnimator f408357h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f408358i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f408359j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f408360k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f408361l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f408362m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f408363n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f408364o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f408365p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f408366q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String[] f408367r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f408368s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ConcurrentHashMap<String, Long> f408369t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final AtomicBoolean f408370u;

    public static final class a {
        public static String a(String r100) {
            JSONObject r101 = new JSONObject(r100);     // Catch: JSONException -> L22
            if (Intrinsics.areEqual(r101.optString("pay_source"), DyPayConstant.V_PAY_SOURCE_OUTER_BDPAY) == false) goto L27;
            JSONObject r102 = new JSONObject(r101.optString("token"));     // Catch: JSONException -> L22
            String r103 = r101.optString("sign");     // Catch: JSONException -> L22
            boolean r104 = false;
            if (r103.length() <= 0) goto L9;
            boolean r105 = true;
        L10:
            if (r105 == true) goto L13;
            r103 = null;
        L13:
            if (r103 != null) goto L23;
        L15:
            String r106 = r102.toString();     // Catch: JSONException -> L22
            if (r106.length() <= 0) goto L18;
            r104 = true;
        L18:
            if (r104 == true) goto L20;
            return r100;
        L20:
            return r106;
        L23:
            r102.put("sign", r103);     // Catch: Exception -> L21
            goto L15
        L9:
            r105 = false;
            goto L10
        L27:
            return r100;
        L29:
            return r100;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DyPayH5Activity f408371a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f408372b;

        public static final class a<T> implements ValueCallback<String> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f408373a = null;

            static {
                f408373a = new a();
            }

            public a() {
            }

            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(String r100) {
            }
        }

        public b(DyPayH5Activity r100, String r101) {
            this.f408371a = r100;
            this.f408372b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            String r100 = String.format("javascript:DyPayJsBridge.getMessageFromNative('%s')", new Object[]{this.f408372b});     // Catch: Throwable -> L9
            DyJsWebView r101 = this.f408371a.f408352c;     // Catch: Throwable -> L9
            if (r101 == null) goto L12;
            WebView r102 = r101.getWebView();     // Catch: Throwable -> L9
            if (r102 == null) goto L16;
            r102.evaluateJavascript(r100, a.f408373a);     // Catch: Throwable -> L9
            return;
        L16:
            return;
        L12:
            return;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DyPayH5Activity f408374a;

        public c(DyPayH5Activity r100) {
            this.f408374a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f408374a.onBackPressed();
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DyPayH5Activity f408375a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f408376b;

        public d(DyPayH5Activity r100, boolean r101) {
            this.f408375a = r100;
            this.f408376b = r101;
        }

        public final void a() {
            View r100 = this.f408375a.f408353d;
            if (r100 == null) goto L24;
            int r101 = 0;
            if (this.f408376b == false) goto L7;
            int r102 = 0;
        L8:
            r100.setVisibility(r102);
            if (this.f408376b == true) goto L11;
            return;
        L11:
            if (this.f408375a.f408366q == false) goto L26;
            ViewGroup.LayoutParams r103 = r100.getLayoutParams();
            if ((r103 instanceof ViewGroup.MarginLayoutParams) == true) goto L15;
            r103 = null;
        L15:
            ViewGroup.MarginLayoutParams r104 = (ViewGroup.MarginLayoutParams) r103;
            if (r104 == null) goto L27;
            ViewGroup r105 = this.f408375a.f408377a;
            if (r105 != null) goto L20;
        L22:
            r104.topMargin = r101;
            r100.setLayoutParams(r104);
            return;
        L20:
            if (r105.getFitsSystemWindows() == true) goto L22;
            r101 = qta.a.c(this.f408375a);
            goto L22
        L27:
            return;
        L26:
            return;
        L7:
            r102 = 8;
            goto L8
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

    public DyPayH5Activity() {
        this.f408358i = "0";
        this.f408367r = new String[]{"on_create", "load_url", "intercept_request", "page_started", "commit_visible", "page_finished", "page_ready"};
        this.f408369t = new ConcurrentHashMap();
        this.f408370u = new AtomicBoolean(false);
    }

    @Override // com.ss.android.dypay.webview.e
    public final void a(String r100) {
        runOnUiThread(new b(this, r100));
    }

    @Override // com.ss.android.dypay.webview.e
    public final void a(boolean r100) {
        this.f408363n = r100;
    }

    @Override // com.ss.android.dypay.webview.e
    public final void b(boolean r100) {
        runOnUiThread(new d(this, r100));
    }

    @Override // com.ss.android.dypay.webview.e
    public final void e() {
        boolean r100 = true;
        this.f408364o = true;
        i(this, "page_ready");
        if (this.f408370u.compareAndSet(false, true) == false) goto L45;
        JSONObject r101 = new JSONObject();
        String[] r102 = this.f408367r;
        int r103 = r102.length;
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L13;
        String r105 = r102[r104];
        Long r106 = this.f408369t.get(r105);
        if (r106 == null) goto L12;
        Long r107 = Long.valueOf(r106.longValue() - this.f408368s);
        if (r105 == null) goto L12;
        r101.put(r105, r107);     // Catch: Exception -> L47
    L12:
        r104 = r104 + 1;
        goto L6
    L13:
        JSONObject r108 = new JSONObject();
        int r109 = this.f408367r.length;
        int r110 = 1;
    L14:
        if (r110 >= r109) goto L22;
        String r111 = (String) ArraysKt.getOrNull(this.f408367r, r110 - 1);
        String r112 = (String) ArraysKt.getOrNull(this.f408367r, r110);
        Long r113 = this.f408369t.get(r111);
        Long r114 = this.f408369t.get(r112);
        if (r113 == null) goto L21;
        if (r114 == null) goto L21;
        String r115 = r111 + "_to_" + r112;
        Long r116 = Long.valueOf(r114.longValue() - r113.longValue());
        if (r115 == null) goto L21;
        r108.put(r115, r116);     // Catch: Exception -> L48
    L21:
        r110 = r110 + 1;
        goto L14
    L22:
        Long r117 = this.f408369t.get("page_ready");
        if (r117 != null) goto L26;
        r117 = Long.valueOf(System.currentTimeMillis());
    L26:
        long r118 = r117.longValue() - this.f408368s;
        JSONObject r119 = sta.a.f543575a;
        if (r108.length() > 0) goto L30;
        r100 = false;
    L30:
        if (r100 == true) goto L33;
        r108 = null;
    L33:
        JSONObject r120 = new JSONObject();
        r120.put("scene", "h5_startup");     // Catch: Exception -> L49
    L60:
        r120.put("total_ms", Long.valueOf(r118));     // Catch: Exception -> L50
    L52:
        r120.put("stage_cost", r101);     // Catch: Exception -> L40
    L41:
        if (r108 != null) goto L58;
    L44:
        sta.a.b(com.ss.android.dypay.base.d.f408440g, "out_wallet_cashier_rd_client_perf_stage", r120, -1);
        goto L45
    L58:
        r120.put("stage_interval", r108);     // Catch: Exception -> L51
    L45:
        j(this, "load_finished", "h5_load_finished", 4);
    }

    @Override // com.ss.android.dypay.activity.a
    public final int f() {
        return R.layout.dypay_activity_h5_layout;
    }

    @Override // android.app.Activity
    public final void onBackPressed() {
        if (this.f408363n == false) goto L9;
        long r100 = System.currentTimeMillis();
        String r101 = "dypay_callback_id_" + r100;
        JSONObject r102 = new JSONObject();     // Catch: Throwable -> L28
        r102.put(com.alipay.sdk.m.p.e.f25671s, "containerOnBackPressed");     // Catch: Throwable -> L28
        r102.put(CJPayLynxStandardKeepActivity.INTENT_CALLBACK_ID, r101);     // Catch: Throwable -> L28
        r102.put("timestamp", r100);     // Catch: Throwable -> L28
        r102.put("params", new JSONObject());     // Catch: Throwable -> L28
        a(r102.toString());     // Catch: Throwable -> L28
        return;
    L38:
        return;
    L9:
        DyJsWebView r103 = this.f408352c;
        if (r103 == null) goto L17;
        if (r103.f408526a.canGoBack() != true) goto L17;
        DyJsWebView r104 = this.f408352c;
        if (r104 == null) goto L34;
        r104.f408526a.goBack();
        return;
    L34:
        return;
    L17:
        if (this.f408364o == false) goto L19;
    L26:
        finish();
        j(this, "close", null, 6);
        return;
    L19:
        if (this.f408365p == true) goto L26;
        g r105 = new g(this, new e(this));
        if (DialogLancet.shouldBlockDialogShow(r105) == false) goto L30;
        DialogLancet.handleBlockedDialogShow(r105);
    L25:
        j(this, EventConstant.Value.RETAIN_SHOW, null, 6);
        this.f408365p = true;
        return;
    L30:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L29
    L24:
        DialogLancet.beforeDialogShow(r105);
        r105.show();
        DialogLancet.afterDialogShow(r105);
        goto L25
    }

    /* JADX INFO: Removed unreachable split cross block B:77:0x0174 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.dypay.activity.a, android.app.Activity
    public final void finish() {
        super.finish();
        if ((!Intrinsics.areEqual(this.f408358i, "1")) == false) goto L24;
        int[] r100 = {R.anim.dy_pay_activity_add_in_animation, R.anim.dy_pay_activity_remove_out_animation};
        Map<String, Integer> r101 = com.ss.android.dypay.utils.d.f408483a;
        if (r101 != null) goto L7;
    L23:
        overridePendingTransition(r100[0], r100[1]);
    L26:
        if ((this instanceof FragmentActivity) == true) goto L29;
        return;
    L29:
        if ((this instanceof ChatWindowActivity) == true) goto L82;
        FLogger r102 = FLogger.f375446a;
        r102.i("ActivityLancet", "finish ".concat(DyPayH5Activity.class.getName()));
        long r103 = SystemClock.uptimeMillis();
        Map<Activity, Long> r104 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r104);
        Long r105 = r104.get(this);     // Catch: Throwable -> L71
        if (r105 != null) goto L36;
    L39:
        r104.put(this, Long.valueOf(r103));     // Catch: Throwable -> L71
        monitor-exit(r104);     // Catch: Throwable -> L71
    L68:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L74:
        return;
    L42:
        if (((FragmentActivity) this).getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L45;
        r102.i("ActivityLancet", "quit !resume, current state = " + ((FragmentActivity) this).getLifecycle().getCurrentState());     // Catch: Throwable -> L68
        goto L74
    L45:
        if (isFinishing() == true) goto L48;
        r102.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L68
        goto L74
    L48:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L51;
        r102.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L68
        goto L74
    L51:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L54;
        r102.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L68
        goto L74
    L54:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L57;
        r102.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L68
        goto L74
    L57:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L59;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L68
        goto L74
    L59:
        Intent r106 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L68
        if (r106 == null) goto L74;
        r106.addFlags(268435456);     // Catch: Throwable -> L68
        r106.addFlags(2097152);     // Catch: Throwable -> L68
        r102.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L68
        startActivity(r106);     // Catch: Throwable -> L65
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.slide_out_right);     // Catch: Throwable -> L65
    L65:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L68
        goto L74
    L36:
        if ((r103 - r105.longValue()) >= 800) goto L39;
        monitor-exit(r104);     // Catch: Throwable -> L71
    L71:
        th = move-exception;
        throw th;
    L82:
        return;
    L7:
        if (r101.containsKey(DyPayConstant.DY_PAY_SDK_ACTIVITY_ADD_IN_ANIMATION_KEY) == true) goto L9;
    L11:
        boolean r107 = false;
    L12:
        if (r107 == true) goto L15;
        r101 = null;
    L15:
        if (r101 == null) goto L23;
        Integer r108 = r101.get(DyPayConstant.DY_PAY_SDK_ACTIVITY_ADD_IN_ANIMATION_KEY);
        if (r108 != null) goto L19;
        Intrinsics.throwNpe();
    L19:
        r100[0] = r108.intValue();
        Integer r109 = r101.get(DyPayConstant.DY_PAY_SDK_ACTIVITY_REMOVE_OUT_ANIMATION_KEY);
        if (r109 != null) goto L22;
        Intrinsics.throwNpe();
    L22:
        r100[1] = r109.intValue();
        goto L23
    L9:
        if (r101.containsKey(DyPayConstant.DY_PAY_SDK_ACTIVITY_REMOVE_OUT_ANIMATION_KEY) == false) goto L11;
        r107 = true;
        goto L12
    L24:
        qta.a.d(this);
        goto L26
    }

    @Override // com.ss.android.dypay.activity.a
    public final void g() {
        super.g();
        this.f408352c = (DyJsWebView) findViewById(R.id.dy_pay_webview);
        this.f408353d = findViewById(R.id.dy_pay_webview_title_bar);
        this.f408354e = findViewById(R.id.dy_pay_back_view);
        this.f408355f = findViewById(R.id.dy_pay_loading_view);
        this.f408356g = findViewById(R.id.dy_pay_iv_loading);
        View r100 = this.f408354e;
        if (r100 == null) goto L5;
        r100.setOnClickListener(new c(this));
    L5:
        View r101 = this.f408356g;
        if (r101 == null) goto L8;
        ObjectAnimator r102 = ObjectAnimator.ofFloat(r101, "rotation", new float[]{0.0f, 360.0f});
        r102.setDuration(1000);
        r102.setRepeatMode(1);
        r102.setRepeatCount(-1);
        r102.setInterpolator(new LinearInterpolator());
        this.f408357h = r102;
    L8:
        DyJsWebView r103 = this.f408352c;
        if (r103 == null) goto L11;
        r103.setBackgroundColor(ColorProtector.parseColor("#ffffff"));
    L11:
        DyJsWebView r104 = this.f408352c;
        if (r104 == null) goto L16;
        WebView r105 = r104.getWebView();
        if (r105 == null) goto L16;
        r105.setBackgroundColor(ColorProtector.parseColor("#ffffff"));
        r105.setWebViewClient(new WebViewClient());
        r105.setWebChromeClient(new WebChromeClient());
    L16:
        DyJsWebView r106 = this.f408352c;
        if (r106 == null) goto L19;
        com.ss.android.dypay.webview.a r107 = new com.ss.android.dypay.webview.a(this, this);
        r106.f408526a.addJavascriptInterface(r107, "DyPayJsBridge");
    L19:
        DyJsWebView r108 = this.f408352c;
        if (r108 == null) goto L23;
        r108.setWebViewClient(new com.ss.android.dypay.activity.d(this));
        return;
    }

    @Override // com.ss.android.dypay.activity.a, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        View r100 = this.f408355f;
        if (r100 == null) goto L5;
        r100.setVisibility(8);
    L5:
        ObjectAnimator r101 = this.f408357h;
        if (r101 == null) goto L8;
        r101.cancel();
    L8:
        DyJsWebView r102 = this.f408352c;
        if (r102 == null) goto L15;
        ViewParent r103 = r102.f408526a.getParent();
        if (r103 == null) goto L13;
        ((ViewGroup) r103).removeView(r102.f408526a);
    L13:
        r102.f408526a.stopLoading();
        r102.f408526a.getSettings().setJavaScriptEnabled(false);
        r102.f408526a.clearHistory();
        r102.f408526a.clearView();
        r102.f408526a.removeAllViews();
        return;
    }

    @Override // android.app.Activity
    public final void onPause() {
        super.onPause();
        DyJsWebView r100 = this.f408352c;
        if (r100 == null) goto L6;
        r100.f408526a.onPause();
        return;
    }

    @Override // android.app.Activity
    public final void onResume() {
        super.onResume();
        DyJsWebView r100 = this.f408352c;
        if (r100 == null) goto L6;
        r100.f408526a.onResume();
        return;
    }

    @Override // android.app.Activity
    public final void onStop() {
        super.onStop();
        j(this, "on_stop", null, 6);
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        h(getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public static View h(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    @Override // com.ss.android.dypay.activity.a
    public final void c(Bundle r110) {
        String r100 = getIntent().getStringExtra("url");
        this.f408359j = getIntent().getStringExtra("scene");
        boolean r101 = true;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L13;
        Intent r111 = new Intent();
        r111.putExtra("code", 2);
        setResult(-1, r111);
        finish();
        return;
    L13:
        if (Intrinsics.areEqual(this.f408359j, "try_continue_pay") == false) goto L17;
        this.f408360k = getIntent().getStringExtra("fail_reason");
        this.f408361l = getIntent().getStringExtra("monitor_reason");
        if (getIntent().getBooleanExtra(DownloadConstants.KEY_TOAST, true) == false) goto L17;
        Toast.makeText(this, "唤起抖音APP失败，请重试", 0).show();
    L17:
        Uri r103 = UriProtector.parse(r100);
        String r104 = UriProtector.getQueryParameter(r103, "hide_title_bar");     // Catch: Exception -> L40
        if (Intrinsics.areEqual(r104, "1") == false) goto L24;
        View r105 = this.f408353d;     // Catch: Exception -> L40
        if (r105 == null) goto L24;
        r105.setVisibility(8);     // Catch: Exception -> L40
    L24:
        if (Intrinsics.areEqual(UriProtector.getQueryParameter(r103, AppConstants.TRANS_STATUS_BAR), "1") == false) goto L34;
        this.f408366q = true;     // Catch: Exception -> L40
        if (Intrinsics.areEqual(r104, "1") == false) goto L30;
        ViewGroup r106 = this.f408377a;     // Catch: Exception -> L40
        if (r106 == null) goto L30;
        r106.setFitsSystemWindows(false);     // Catch: Exception -> L40
    L30:
        Window r107 = getWindow();     // Catch: Exception -> L40
        if (r107 == null) goto L33;
        r107.addFlags(Integer.MIN_VALUE);     // Catch: Exception -> L40
        r107.clearFlags(67108864);     // Catch: Exception -> L40
        r107.setStatusBarColor(0);     // Catch: Exception -> L40
        View r108 = h(r107);     // Catch: Exception -> L40
        r108.setSystemUiVisibility(r108.getSystemUiVisibility() | 1280);     // Catch: Exception -> L40
    L33:
        qta.a.e(this, this.f408377a, false);     // Catch: Exception -> L40
    L34:
        String r109 = UriProtector.getQueryParameter(r103, "disable_animation");     // Catch: Exception -> L40
        if (r109 != null) goto L38;
        r109 = "0";
    L38:
        this.f408358i = r109;     // Catch: Exception -> L40
    L42:
        sta.a.f543576b.d("a24331.b53008.c0.d0");
        i(this, "load_url");
        String r112 = getIntent().getStringExtra("payInfo");
        String r113 = getIntent().getStringExtra("sdk_ext");
        Uri.Builder r114 = UriProtector.parse(r100).buildUpon();
        r114.appendQueryParameter("sdk_version", "1.0.0.lite");
        if (com.ss.android.dypay.base.b.f408437b.length() != 0) goto L45;
        boolean r115 = true;
    L46:
        if (r115 == false) goto L48;
        com.ss.android.dypay.base.b.f408437b = "14_" + com.ss.android.dypay.base.b.a();
    L48:
        r114.appendQueryParameter(DyPayConstant.KEY_USER_UNIQUE_ID, com.ss.android.dypay.base.b.f408437b);
        r114.appendQueryParameter("out_pay_info_param", r112);
        int r116 = qta.a.c(this);
        Resources r117 = getResources();
        r114.appendQueryParameter("status_bar_height", String.valueOf((int) ((r116 * 1.0f) / ((double) WindowDisplayMetricsOverride.apply(r117, r117.getDisplayMetrics()).scaledDensity))));
        r114.appendQueryParameter("sdk_ext", r113);
        if (Intrinsics.areEqual(this.f408359j, "try_continue_pay") == false) goto L71;
        r114.appendQueryParameter("try_continue_pay", "1");
        String r118 = this.f408360k;
        String r119 = null;
        if (r118 != null) goto L53;
    L61:
        String r120 = this.f408361l;
        if (r120 == null) goto L71;
        if (r120.length() <= 0) goto L66;
        boolean r121 = true;
    L67:
        if (r121 == false) goto L69;
        r119 = r120;
    L69:
        if (r119 == null) goto L71;
        r114.appendQueryParameter("monitor_reason", r119);
        goto L71
    L66:
        r121 = false;
        goto L67
    L53:
        if (r118.length() <= 0) goto L55;
        boolean r122 = true;
    L56:
        if (r122 == true) goto L59;
        r118 = null;
    L59:
        if (r118 == null) goto L61;
        r114.appendQueryParameter("fail_reason", r118);
        goto L61
    L55:
        r122 = false;
    L71:
        String r123 = r114.toString();
        DyJsWebView r124 = this.f408352c;
        if (r124 == null) goto L84;
        if (r123 != null) goto L75;
    L78:
        if (r101 == true) goto L84;
        Map<String, String> r125 = r124.f408527b;
        com.ss.android.dypay.webview.b r126 = r124.f408526a;
        if (r125 == null) goto L83;
        r126.loadUrl(r123, r125);
        goto L84
    L83:
        r126.loadUrl(r123);
        goto L84
    L75:
        if (r123.length() == 0) goto L78;
        r101 = false;
    L84:
        View r127 = this.f408355f;
        if (r127 == null) goto L87;
        r127.setVisibility(0);
    L87:
        ObjectAnimator r128 = this.f408357h;
        if (r128 == null) goto L93;
        r128.start();
        return;
    L93:
        return;
    L45:
        r115 = false;
    L40:
        e = move-exception;
        JSONObject r129 = sta.a.f543575a;
        sta.a.g("DyPayH5Activity_exception: " + e.getMessage());
        goto L42
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    @Override // com.ss.android.dypay.activity.a, android.app.Activity
    public final void onCreate(Bundle r100) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L10
    L6:
        if (f.f(this) == false) goto L8;
        f.c(getTheme());     // Catch: Throwable -> L10
    L8:
        long r101 = System.currentTimeMillis();
        this.f408368s = r101;
        this.f408369t.putIfAbsent("on_create", Long.valueOf(r101));
        j(this, EventVerify.TYPE_LAUNCH, null, 6);
        super.onCreate(r100);
    }

    public static void i(DyPayH5Activity r100, String r101) {
        long r102 = System.currentTimeMillis();
        r100.f408369t.putIfAbsent(r101, Long.valueOf(r102));
    }

    public static void j(DyPayH5Activity r100, String r101, String r102, int r103) {
        if ((r103 & 2) == 0) goto L5;
        r102 = "";
    L5:
        String r104 = r102;
        r100.getClass();
        JSONObject r105 = new JSONObject();
        r105.put("duration", Long.valueOf(System.currentTimeMillis() - r100.f408368s));     // Catch: Exception -> L9
    L7:
        sta.a.e("h5", r101, r104, r105, null, 48);
    }
}
