package com.bytedance.ug.sdk.luckycat.impl.browser;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.widget.ProgressBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.sdk.bridge.js.JsBridgeManager;
import com.bytedance.ug.sdk.luckycat.impl.browser.bridge.LuckyCatLoginBridge;
import com.bytedance.ug.sdk.luckycat.impl.browser.bridge.LuckyCatPermissionBridge;
import com.bytedance.ug.sdk.luckycat.impl.browser.bridge.LuckyCatStepBridge;
import com.bytedance.ug.sdk.luckycat.impl.browser.webview.ErrorView;
import com.bytedance.ug.sdk.luckycat.impl.browser.webview.LuckyCatWebView;
import com.bytedance.ug.sdk.luckycat.impl.browser.webview.PageInfo;
import com.bytedance.ug.sdk.luckycat.impl.lynx.LuckyCatContainerIDManager;
import com.bytedance.ug.sdk.luckycat.impl.lynx.c;
import com.bytedance.ug.sdk.luckycat.impl.manager.LuckyCatSettingsManger;
import com.bytedance.ug.sdk.luckycat.impl.manager.d;
import com.bytedance.ug.sdk.luckycat.impl.manager.m;
import com.bytedance.ug.sdk.luckycat.impl.manager.q;
import com.bytedance.ug.sdk.luckycat.impl.model.ContainerType;
import com.bytedance.ug.sdk.luckycat.impl.model.PageLoadReason;
import com.bytedance.ug.sdk.luckycat.impl.utils.LuckyCatUtils;
import com.bytedance.ug.sdk.luckycat.impl.view.TaskTabFragment;
import com.larus.nova.R;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import hj7.e;
import hj7.f;
import hj7.j;
import hj7.k;
import hj7.l;
import hj7.n;
import hj7.o;
import hj7.p;
import ij7.a;
import ij7.g;
import ij7.h;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
import pi7.i;
import rk7.u;
import vi7.b;

/* JADX INFO: loaded from: classes22.dex */
public class LuckyCatBrowserFragment extends Fragment implements i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WebView f271096d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ProgressBar f271097e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public h f271098f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f271099g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f271100h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public PageLoadReason f271101i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public a f271102j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public b f271103k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ViewGroup f271104l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public f f271105m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ij7.i f271106n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Uri f271107o;

    @Override // pi7.i
    public boolean Q3() {
        return this instanceof TaskTabFragment;
    }

    @Override // pi7.i
    public final void Ue() {
        a r100 = this.f271102j;
        if (r100 == null) goto L5;
        r100.f490084l = true;
    L5:
        ij7.i r101 = this.f271106n;
        if (r101 == null) goto L20;
        PageInfo r102 = r101.f490107c;
        if (r102 == null) goto L21;
        r102.F = PageInfo.PAGE_LOAD_STATUS.LOAD_TEMPLATE_SUCCESS;
        if (r102.f271136t == (-1)) goto L12;
        r102.E = true;
        return;
    L12:
        long r103 = System.currentTimeMillis();
        r102.f271136t = r103;
        long r104 = r102.f271134r;
        if (r104 != (-1)) goto L15;
        r102.E = true;
        return;
    L15:
        r102.f271137u = r103 - r104;
        long r105 = r102.C;
        if (r105 == (-1)) goto L24;
        r102.D = r103 - r105;
        return;
    L24:
        return;
    L21:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        WebView r100 = this.f271096d;
        if (r100 == null) goto L8;
        ViewParent r101 = r100.getParent();
        if (r101 == null) goto L7;
        ((ViewGroup) r101).removeView(this.f271096d);
    L7:
        this.f271096d.stopLoading();
        this.f271096d.getSettings().setJavaScriptEnabled(false);
        this.f271096d.clearHistory();
        this.f271096d.clearView();
        this.f271096d.removeAllViews();
        this.f271096d.destroy();
    L8:
        super.onDestroy();
        if (this.f271106n == null) goto L15;
        b r102 = this.f271103k;
        if (r102 == null) goto L15;
        if (r102.a() == false) goto L15;
        this.f271106n.h(false, 90101, "page closed by user");
    L15:
        f r103 = this.f271105m;
        if (r103 != null) goto L18;
    L22:
        a r104 = this.f271102j;
        if (r104 == null) goto L28;
        r104.d();
        a.HandlerC6276a r105 = r104.f490088p;
        if (r105 == null) goto L29;
        r105.removeCallbacksAndMessages(null);
        return;
    L29:
        return;
    L28:
        return;
    L18:
        if (r103.f485447c == null) goto L22;
        ViewParent r106 = r103.f485445a;
        boolean r107 = r106 instanceof cd7.a;
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyCatBridge3", "onDestroy: " + r107);
        if (r107 == false) goto L22;
        JsBridgeManager.INSTANCE.unregisterJsBridgeWithWebView((cd7.a) r106);
        goto L22
    }

    @Override // pi7.i
    public final void qZ() {
        a r100 = this.f271102j;
        if (r100 != null) goto L5;
    L11:
        ij7.i r101 = this.f271106n;
        if (r101 == null) goto L26;
        PageInfo r102 = r101.f490107c;
        if (r102 != null) goto L16;
        return;
    L16:
        if (r102.f271138v == (-1)) goto L18;
        r102.E = true;
        return;
    L18:
        long r103 = System.currentTimeMillis();
        r102.f271138v = r103;
        long r104 = r102.f271134r;
        if (r104 != (-1)) goto L21;
        r102.E = true;
        return;
    L21:
        r102.f271135s = r103 - r104;
        long r105 = r102.f271136t;
        if (r105 != (-1)) goto L24;
        r102.E = true;
        return;
    L24:
        r102.f271139w = r103 - r105;
        return;
    L26:
        return;
    L5:
        if (r100.f490084l == false) goto L11;
        m.a.f271349a.q();
        r100.d();
        if (LuckyCatUtils.a(r100.f490079g) == true) goto L10;
        r100.a("on_page_finished");
    L10:
        r100.f490084l = false;
        goto L11
    }

    public LuckyCatBrowserFragment() {
        this.f271099g = false;
        Map<String, WeakReference<c>> r100 = LuckyCatContainerIDManager.f271169a;
        this.f271106n = new ij7.i(UUID.randomUUID().toString());
    }

    public final void initViewData() {
        Bundle r100 = getArguments();
        if (r100 == null) goto L5;
        boolean r101 = r100.getBoolean(AppConstants.BUNDLE_USE_WEBVIEW_TITLE, false);
    L7:
        if (this.f271096d != null) goto L9;
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyCatBrowserFragment", "initWebSettingData mWebView == null");
    L24:
        boolean r102 = true;
        CookieManager.getInstance().setAcceptCookie(true);     // Catch: Throwable -> L27
    L29:
        if (this.f271096d == null) goto L32;
        g r103 = new g(this.f271096d, getActivity(), this.f271105m, this);
        this.f271096d.setWebChromeClient(r103);
        r103.f490097b = r101;
    L32:
        a r104 = this.f271102j;
        if (r104 == null) goto L37;
        r104.d();
        a.HandlerC6276a r105 = r104.f490088p;
        if (r105 == null) goto L37;
        r105.removeCallbacksAndMessages(null);
    L37:
        Bundle r106 = getArguments();
        FragmentActivity r107 = getActivity();
        b r108 = this.f271103k;
        if (r106 != null) goto L40;
    L42:
        r102 = false;
    L43:
        a r109 = new a(r107, r108, this, r102);
        this.f271102j = r109;
        r109.f490086n = this.f271106n;
        if (r106 == null) goto L46;
        this.f271102j.f490076d = r106.getBoolean("page_keep_alive", false);
    L46:
        a r110 = this.f271102j;
        r110.f490083k = this.f271099g;
        return;
    L40:
        if (r106.getBoolean("hide_loading") == false) goto L42;
    L9:
        if (r100 == null) goto L11;
        String r111 = r100.getString("webview_bg_color");
        String r112 = r100.getString("webview_text_zoom");
    L13:
        if (TextUtils.isEmpty(r111) == false) goto L49;
    L17:
        m r113 = m.a.f271349a;
        if (TextUtils.isEmpty(r112) == true) goto L24;
        int r114 = CastIntegerProtector.valueOf(r112).intValue();     // Catch: Throwable -> L48
        if (r114 <= 0) goto L24;
        if (r114 > 100) goto L24;
        this.f271096d.getSettings().setTextZoom(r114);     // Catch: Throwable -> L48
        goto L24
    L49:
        this.f271096d.setBackgroundColor(Color.parseColor(r111));     // Catch: Throwable -> L16
        goto L17
    L11:
        r111 = "#ffffff";
        r112 = "";
        goto L13
    L5:
        r101 = false;
        goto L7
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        if (this.f271096d == null) goto L18;
        if (LuckyCatUtils.b(this.f271100h) == true) goto L7;
        this.f271096d.onPause();
        goto L18
    L7:
        f r100 = this.f271105m;
        if (r100 == null) goto L18;
        e r101 = r100.f485447c;
        if (r101 == null) goto L14;
        p r102 = r101.f485438b;
        if (r102 == null) goto L14;
        boolean r103 = r102.f485466b;
    L15:
        if (r103 == false) goto L18;
        this.f271096d.onPause();
    L14:
        r103 = false;
    L18:
        if (this.f271099g == true) goto L33;
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyCatBrowserFragment", "onPageInVisible");
        f r104 = this.f271105m;
        if (r104 == null) goto L29;
        e r105 = r104.f485447c;
        if (r105 == null) goto L29;
        WebView r106 = r104.f485445a;
        if (r105.f485437a == null) goto L26;
        hj7.i r107 = r105.f485437a;
        r107.b(false, r106);
        r107.a(false, r106);
    L26:
        p r108 = r105.f485438b;
        if (r108 == null) goto L29;
        r108.f485467c = true;
    L29:
        ij7.i r109 = this.f271106n;
        if (r109 == null) goto L34;
        r109.f();
        return;
    L34:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        this.f271096d.onResume();     // Catch: Throwable -> L5
    L8:
        if (this.f271099g == true) goto L42;
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyCatBrowserFragment", "onPageVisible");
        f r100 = this.f271105m;
        if (r100 != null) goto L12;
    L22:
        a r101 = this.f271102j;
        if (r101 != null) goto L25;
    L36:
        ij7.i r102 = this.f271106n;
        if (r102 == null) goto L43;
        r102.g();
        return;
    L43:
        return;
    L25:
        if (r101.f490076d == false) goto L36;
        if (r101.f490078f == false) goto L36;
        i r103 = r101.f490081i;
        if (r103 == null) goto L36;
        if (r101.f490077e == true) goto L36;
        r103.Kn(r101.f490079g, PageLoadReason.KEEP_LIVE_RETRY);
        goto L36
    L12:
        if (r100.f485447c == null) goto L22;
        q r104 = q.b.f271365a;
        r104.f271359d = new WeakReference(r100.f485445a);
        e r105 = r100.f485447c;
        WebView r106 = r100.f485445a;
        if (r105.f485437a == null) goto L16;
        hj7.i r107 = r105.f485437a;
        r107.b(true, r106);
        r107.a(true, r106);
    L16:
        p r108 = r105.f485438b;
        if (r108 == null) goto L19;
        r108.f485467c = false;
    L19:
        LuckyCatLoginBridge r109 = r105.f485439c;
        if (r109 == null) goto L22;
        r109.onResume();
        goto L22
    L42:
        return;
    L5:
        th = move-exception;
        th.getMessage();
        goto L8
    }

    public static String S90(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L20;
        return r100;
    L20:
        Uri r101 = UriProtector.parse(r100);     // Catch: Throwable -> L17
        Set<String> r102 = UriProtector.getQueryParameterNames(r101);     // Catch: Throwable -> L17
        if (r102 != null) goto L9;
    L12:
        float r103 = xj7.a.a().f564105b;     // Catch: Throwable -> L17
        if (r103 != (-1.0f)) goto L16;
        return r100;
    L16:
        return r101.buildUpon().appendQueryParameter("device_score", String.valueOf(r103)).build().toString();
    L9:
        if (r102.contains("device_score") == false) goto L12;
        return r100;
    L17:
        th = move-exception;
        th.printStackTrace();
        return r100;
    }

    @Override // pi7.i
    public final void I7(int r100) {
        if (this.f271097e != null) goto L6;
        return;
    L6:
        if (this.f271106n == null) goto L16;
        m r101 = m.a.f271349a;
        int[] r102 = {0, 10, 20, 30, 40, 50, 60, 70, 80, 90};
        int r103 = 0;
    L9:
        if (r103 >= 10) goto L14;
        if (r102[r103] != r100) goto L13;
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("UG_SDK_LUCKYCAT_PAGE_HOOK_TAG", "ug_sdk_luckycat_webview_on_progress_changed_;progress:" + r100);
    L13:
        r103 = r103 + 1;
        goto L9
    L14:
        if (r100 < 100) goto L16;
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("UG_SDK_LUCKYCAT_PAGE_HOOK_TAG", "ug_sdk_luckycat_webview_on_progress_changed");
    L16:
        this.f271097e.setProgress(r100);
        if (r100 < 100) goto L24;
        this.f271097e.postDelayed(new gj7.a(this), 500);
        if (this.f271102j == null) goto L24;
        if (LuckyCatUtils.a(this.f271100h) == true) goto L24;
        this.f271102j.a("progress_finished");
    L24:
        if (this.f271097e.getVisibility() != 0) goto L26;
        return;
    L26:
        this.f271097e.setVisibility(0);
    }

    public final void T90(ViewGroup r110) {
        long r100 = System.currentTimeMillis();
        m.a.f271349a.t();
        if (this.f271096d != null) goto L44;
        String r101 = this.f271100h;
        LuckyCatSettingsManger r102 = LuckyCatSettingsManger.b.f271283a;
        d r103 = r102.f271282a;
        r103.m();
        if (r103.f271315c == null) goto L7;
        boolean r104 = true;
    L8:
        if (r104 == false) goto L21;
        d r105 = r102.f271282a;
        r105.m();
        if (r105.f271315c == null) goto L12;
        boolean r106 = true;
    L13:
        if (r106 == true) goto L15;
        boolean r107 = true;
    L19:
        if (r107 == true) goto L21;
        boolean r108 = false;
    L22:
        if (r108 == true) goto L24;
    L32:
        boolean r109 = false;
    L33:
        if (r109 == false) goto L36;
        this.f271096d = sj7.a.b(getContext());
    L36:
        if (this.f271096d != null) goto L44;
        this.f271096d = new LuckyCatWebView(getContext());     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        th.printStackTrace();
        com.bytedance.ug.sdk.luckycat.impl.utils.a.b("LuckyCatBrowserFragment", Log.getStackTraceString(th));
        FragmentActivity r111 = getActivity();
        if ((r111 instanceof LuckyCatBrowserActivity) == false) goto L44;
        r111.finish();
        return;
    L24:
        if (TextUtils.isEmpty(r101) == false) goto L27;
    L29:
        boolean r112 = false;
    L30:
        if (r112 == false) goto L32;
        r109 = true;
        goto L33
    L27:
        if (TextUtils.isEmpty(UriProtector.getQueryParameter(UriProtector.parse(r101), "__pia_manifest__")) == true) goto L29;
        r112 = true;
        goto L30
    L15:
        Object r113 = r102.c(new String[]{"pia_config", "enable_luckycat_pia_webview"});
        if ((r113 instanceof Boolean) == false) goto L18;
        r107 = ((Boolean) r113).booleanValue();
        goto L19
    L18:
        r107 = false;
        goto L19
    L12:
        r106 = false;
    L21:
        r108 = true;
        goto L22
    L7:
        r104 = false;
    L44:
        ij7.i r114 = this.f271106n;
        if (r114 == null) goto L107;
        boolean r115 = !(this.f271096d instanceof LuckyCatWebView);
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("UG_SDK_LUCKYCAT_PAGE_HOOK_TAG", "ug_sdk_luckycat_webview_create_start_;common_params:" + r114.e(r114.f490107c));
        PageInfo r116 = r114.f490107c;
        if (r116 == null) goto L107;
        r116.f271120d = r100;
        r116.f271121e = r115;
        r116.f271132p = "webview_create_start";
    L107:
        this.f271096d.setOverScrollMode(2);     // Catch: Throwable -> L51
    L53:
        ViewParent r117 = this.f271096d;
        if ((r117 instanceof ij7.e) == false) goto L56;
        ij7.e r118 = (ij7.e) r117;
        this.f271096d.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        int r119 = com.bytedance.ug.sdk.luckycat.utils.h.b(getContext());
        int r120 = com.bytedance.ug.sdk.luckycat.utils.h.a(getContext());
        r118.e(r119, r120);
        r118.setWidthAndHeight(r119, r120);
        r118.d(this.f271106n);
    L56:
        ij7.i r121 = this.f271106n;
        if (r121 == null) goto L111;
        WebView r122 = this.f271096d;
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("UG_SDK_LUCKYCAT_PAGE_HOOK_TAG", "ug_sdk_luckycat_webview_create_start_end_;common_params:" + r121.e(r121.f490107c));
        long r123 = System.currentTimeMillis() - r121.f490107c.f271120d;
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("UG_SDK_LUCKYCAT_PAGE_HOOK_TAG", "ug_sdk_luckycat_webview_create_time_;common_params:" + r121.e(r121.f490107c));
        JSONObject r124 = new JSONObject(r121.e(r121.f490107c).toString());     // Catch: JSONException -> L73
        r124.put("duration", r123);     // Catch: JSONException -> L66
        if (r122 != null) goto L63;
    L62:
        boolean r125 = false;
    L68:
        if (r125 == false) goto L70;
        int r126 = 1;
    L71:
        r124.put("is_webview_cache", r126);     // Catch: JSONException -> L66
    L76:
        com.bytedance.ug.sdk.luckycat.impl.model.d.a("ug_sdk_luckycat_webview_create_time", r124, true);
        PageInfo r127 = r121.f490107c;
        if (r127 == null) goto L111;
        r127.f271132p = "webview_create_end";
        goto L111
    L70:
        r126 = 0;
        goto L71
    L63:
        Object r128 = r122.getTag(R.id.webx_precreate_is_precreate);     // Catch: JSONException -> L66
        if ((r128 instanceof Boolean) == false) goto L62;
        r125 = ((Boolean) r128).booleanValue();     // Catch: JSONException -> L66
    L66:
        e = e;
    L75:
        e.printStackTrace();
    L73:
        e = e;
        r124 = null;
    L111:
        r110.addView(this.f271096d, 0, new ViewGroup.LayoutParams(-1, -1));     // Catch: Exception -> L81
    L83:
        ViewParent r129 = this.f271096d;
        if ((r129 instanceof ij7.e) == false) goto L86;
        ((ij7.e) r129).a(getActivity());
    L86:
        WebView r130 = this.f271096d;
        Lifecycle r131 = getLifecycle();
        f r132 = new f(r130, r131, this.f271100h);
        this.f271105m = r132;
        boolean r133 = this.f271099g;
        r132.f485446b = this;
        ij7.i r134 = this.f271106n;
        e r135 = new e();
        r132.f485447c = r135;
        r135.f485443g = r134;
        r135.f485444h = r133;
        r135.f485442f = this;
        WebView r136 = r132.f485445a;
        m r137 = m.a.f271349a;
        com.bytedance.ug.sdk.luckycat.api.depend.d r138 = r137.f271337e;
        if (r138 == null) goto L89;
        ((cn7.a) r138).a();
    L89:
        JsBridgeManager.INSTANCE.delegateJavaScriptInterface(r136);
        if (r137.f271340h == null) goto L101;
        AtomicBoolean r139 = u.f538372v;
        u.c.f538395a.getClass();
        int r140 = ok7.f.f523690a;
        if (r136 == null) goto L95;
        JsBridgeManager.INSTANCE.registerJsBridgeWithWebView(new pk7.c(), r136);
        JsBridgeManager.INSTANCE.registerJsBridgeWithWebView(new pk7.b(), r136);
        JsBridgeManager.INSTANCE.registerJsBridgeWithWebView(new pk7.d(), r136);
        JsBridgeManager.INSTANCE.registerJsBridgeWithWebView(new pk7.e(), r136);
        JsBridgeManager.INSTANCE.registerJsBridgeWithWebView(new ok7.e(), r136);
        JsBridgeManager.INSTANCE.registerJsBridgeWithWebView(new ok7.d(), r136);
        JsBridgeManager.INSTANCE.registerJsBridgeWithWebView(new ok7.h(), r136);
    L95:
        int r141 = bl7.c.f19499a;
        bl7.b r142 = rk7.f.d();
        if (r142 == null) goto L98;
        r142.registerBridgeV3(r136, r131);
    L98:
        ek7.a r143 = rk7.f.c();
        if (r143 == null) goto L101;
        r143.registerBridgeV3(r136, r131);
    L101:
        hj7.i r144 = new hj7.i();
        r135.f485437a = r144;
        r144.f485454a = r135.f485444h;
        JsBridgeManager.INSTANCE.registerJsBridgeWithWebView(r135.f485437a, r136);
        p r145 = new p();
        r135.f485438b = r145;
        r145.f485465a = new WeakReference(r135.f485442f);
        JsBridgeManager.INSTANCE.registerJsBridgeWithWebView(r135.f485438b, r136);
        r135.f485439c = new LuckyCatLoginBridge();
        JsBridgeManager.INSTANCE.registerJsBridgeWithWebView(r135.f485439c, r136);
        r135.f485440d = new l();
        new WeakReference(r136);
        JsBridgeManager.INSTANCE.registerJsBridgeWithWebView(r135.f485440d, r136);
        JsBridgeManager.INSTANCE.registerJsBridgeWithWebView(new hj7.b(), r136);
        JsBridgeManager.INSTANCE.registerJsBridgeWithWebView(new hj7.c(), r136);
        JsBridgeManager.INSTANCE.registerJsBridgeWithWebView(new hj7.g(), r136);
        hj7.m r146 = new hj7.m();
        r146.f485457a = new WeakReference(r135.f485443g);
        JsBridgeManager.INSTANCE.registerJsBridgeWithWebView(r146, r136);
        JsBridgeManager.INSTANCE.registerJsBridgeWithWebView(new n(), r136);
        LuckyCatStepBridge r147 = new LuckyCatStepBridge();
        r131.addObserver(r147);
        JsBridgeManager.INSTANCE.registerJsBridgeWithWebView(r147, r136);
        JsBridgeManager.INSTANCE.registerJsBridgeWithWebView(new j(), r136);
        JsBridgeManager.INSTANCE.registerJsBridgeWithWebView(new k(), r136);
        JsBridgeManager.INSTANCE.registerJsBridgeWithWebView(new hj7.q(), r136);
        JsBridgeManager.INSTANCE.registerJsBridgeWithWebView(new o(), r136);
        JsBridgeManager.INSTANCE.registerJsBridgeWithWebView(new LuckyCatPermissionBridge(), r136);
        r135.f485441e = new hj7.d();
        JsBridgeManager.INSTANCE.registerJsBridgeWithWebView(r135.f485441e, r136);
        JsBridgeManager r148 = JsBridgeManager.INSTANCE;
        r148.registerJsBridgeWithWebView(new hj7.h(), r136);
        r148.registerJsEvent("luckycatCurrentStepChange", "protected");
        r148.registerJsEvent("luckycatSubscribeGeckoUpdate", "protected");
        r148.registerJsEvent("luckycatVisible", "protected");
        r148.registerJsEvent("luckycatInvisible", "protected");
        r148.registerJsEvent("visible", "protected");
        r148.registerJsEvent("invisible", "protected");
        r148.registerJsEvent("luckycatOnBackKeyPressed", "protected");
        q.b.f271365a.f271359d = new WeakReference(r132.f485445a);
        h r149 = new h(getActivity(), this.f271105m, this);
        this.f271098f = r149;
        r149.f490103d = this.f271106n;
        this.f271096d.setWebViewClient(r149);
        this.f271096d.setScrollBarStyle(0);
        return;
    L81:
        e = move-exception;
        e.printStackTrace();
    L51:
        th = move-exception;
        th.getMessage();
        goto L53
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        initViewData();
        Kn(this.f271100h, this.f271101i);
        if (com.bytedance.ug.sdk.luckycat.impl.utils.u.a().d("load_task_url_flag", Boolean.FALSE) == true) goto L7;
        com.bytedance.ug.sdk.luckycat.impl.utils.u.a().h("load_task_url_flag", true);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle r100) {
        Bundle r101 = getArguments();
        String r102 = "";
        if (r101 == null) goto L7;
        String r103 = r101.getString("task_tab_fragment_hashcode");
        if (TextUtils.isEmpty(r103) == true) goto L7;
        boolean r104 = r103.equals(hashCode() + "");
    L9:
        if (r104 == true) goto L13;
        ij7.i r105 = this.f271106n;
        r105.f490110f = true;
        PageInfo r106 = r105.f490107c;
        if (r106 == null) goto L13;
        r106.f271133q = true;
    L13:
        super.onCreate(r100);
        Bundle r107 = getArguments();
        if (r107 == null) goto L19;
        String r108 = r107.getString("bundle_url");
        if (r108 == null) goto L19;
        r102 = r108;
    L19:
        String r109 = S90(r102);
        this.f271100h = r109;
        this.f271107o = UriProtector.parse(r109);     // Catch: Exception -> L22
    L24:
        boolean r110 = this.f271099g;
        if (r110 == false) goto L27;
        PageLoadReason r111 = PageLoadReason.TAB_CLICK;
    L28:
        this.f271101i = r111;
        ij7.i r112 = this.f271106n;
        if (r112 == null) goto L34;
        ContainerType r113 = ContainerType.H5;
        r112.f490108d = r110;
        r112.f490109e = r113;
        r112.i(this.f271100h, r111);
        return;
    L34:
        return;
    L27:
        r111 = PageLoadReason.NEW_PAGE;
    L22:
        e = move-exception;
        e.printStackTrace();
    L7:
        r104 = true;
        goto L9
    }

    @Override // pi7.i
    public final void ua(boolean r100) {
        a r101 = this.f271102j;
        if (r101 != null) goto L5;
    L10:
        if (r100 == false) goto L23;
        ij7.i r102 = this.f271106n;
        if (r102 == null) goto L31;
        r102.getClass();
        long r103 = System.currentTimeMillis() - r102.f490107c.f271122f;
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("UG_SDK_LUCKYCAT_PAGE_HOOK_TAG", "ug_sdk_luckycat_page_show_success;common_params:" + r102.e(r102.f490107c));
        JSONObject r104 = new JSONObject(r102.e(r102.f490107c).toString());     // Catch: JSONException -> L19
        r104.put("duration", r103);     // Catch: JSONException -> L17
    L22:
        com.bytedance.ug.sdk.luckycat.impl.model.d.a("ug_sdk_luckycat_page_show_success", r104, true);
        r102.h(true, 0, "");
        return;
    L17:
        e = e;
    L21:
        e.printStackTrace();
    L19:
        e = e;
        r104 = null;
        goto L21
    L31:
        return;
    L23:
        ij7.i r105 = this.f271106n;
        if (r105 == null) goto L33;
        r105.d(90100, "fe_page_load_error");
        return;
    L33:
        return;
    L5:
        if (r101.f490087o == true) goto L10;
        r101.f490077e = r100;
        if (r100 == false) goto L10;
        r101.b();
        r101.a("page_ready");
        goto L10
    }

    @Override // pi7.i
    public final void Kn(String r110, PageLoadReason r111) {
        if (r110 != null) goto L4;
        String r100 = "";
    L5:
        String.format("reportLuckServiceUsed call, type: %s, schema: %s", new Object[]{"ug_container_old_h5", r100});
        JSONObject r101 = new JSONObject();
        r101.put("type", "ug_container_old_h5");     // Catch: Throwable -> L8
        com.bytedance.ug.sdk.luckycat.impl.model.d.a("luckydog_service_rate", r101, true);     // Catch: Throwable -> L8
    L11:
        if (this.f271096d != null) goto L13;
        return;
    L13:
        String r112 = S90(r110);
        this.f271100h = r112;
        this.f271107o = UriProtector.parse(r112);     // Catch: Exception -> L16
    L18:
        this.f271101i = r111;
        if (PageLoadReason.PAGE_RELOAD != r111) goto L21;
    L89:
        m r113 = m.a.f271349a;     // Catch: Throwable -> L28
    L30:
        m r114 = m.a.f271349a;
        ij7.i r115 = this.f271106n;
        if (r115 != null) goto L33;
    L52:
        h r116 = this.f271098f;
        if (r116 == null) goto L55;
        r116.loadUrl(this.f271096d, this.f271100h);
    L55:
        StringBuilder r117 = new StringBuilder("load reason : ");
        if (r111 == null) goto L58;
        String r118 = r111.reason;
    L59:
        r117.append(r118);
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyCatBrowserFragment", r117.toString());
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyCatBrowserFragment", "load url : " + this.f271100h);
        a r119 = this.f271102j;
        if (r119 == null) goto L93;
        WebView r120 = this.f271096d;
        r119.f490079g = this.f271100h;
        r119.f490085m = r120;
        r119.f490087o = false;
        m.a.f271349a.q();
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("ErrorViewHelper", "startTimer");
        if (r120 == null) goto L65;
        r119.d();
        r119.f490075c = new PthreadTimer("ErrorViewHelper");
        r119.f490075c.schedule(new ij7.d(r119, r120), 10000, 86400000);
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("ErrorViewHelper", "startTimer start task");
    L65:
        r119.b();
        if (r119.f490076d == false) goto L69;
        r119.f490078f = false;
        r119.f490088p.removeMessages(90010);
        r119.f490088p.sendEmptyMessageDelayed(90010, ((long) 10) * 1000);
    L69:
        if (r119.f490083k == false) goto L75;
        if (r119.f490088p.hasMessages(90011) == false) goto L73;
        r119.f490088p.removeMessages(90011);
    L73:
        r119.f490088p.sendEmptyMessageDelayed(90011, ((long) 5) * 1000);
    L75:
        if (r119.f490073a == true) goto L97;
        b r121 = r119.f490074b;
        if (r121 != null) goto L80;
        return;
    L80:
        if (r121.a() == true) goto L95;
        r119.f490074b.showLoadingView();
        ij7.i r122 = r119.f490086n;
        if (r122 == null) goto L96;
        r122.k();
        return;
    L96:
        return;
    L95:
        return;
    L97:
        return;
    L93:
        return;
    L58:
        r118 = "null";
        goto L59
    L33:
        if (PageLoadReason.TAB_CLICK != r111) goto L35;
    L37:
        ij7.i r123 = this.f271106n;
        ContainerType r102 = r123.f490107c.f271125i;
        ContainerType r103 = ContainerType.H5;
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("UG_SDK_LUCKYCAT_PAGE_HOOK_TAG", "ug_sdk_luckycat_page_load_url_;common_params:" + r123.e(r123.f490107c));
        JSONObject r104 = new JSONObject(r123.e(r123.f490107c).toString());     // Catch: JSONException -> L40
    L42:
        com.bytedance.ug.sdk.luckycat.impl.model.d.a("ug_sdk_luckycat_page_load_url", r104, true);
        PageInfo r105 = r123.f490107c;
        if (r105 == null) goto L52;
        if (r105.f271134r == (-1)) goto L47;
        r105.E = true;
    L51:
        r123.f490107c.f271132p = "load_url";
        goto L52
    L47:
        long r106 = System.currentTimeMillis();
        r105.f271134r = r106;
        long r107 = r105.f271122f;
        if (r107 != (-1)) goto L50;
        r105.E = true;
        goto L51
    L50:
        r105.f271141y = r106 - r107;
    L40:
        e = move-exception;
        e.printStackTrace();
        r104 = null;
        goto L42
    L35:
        if (PageLoadReason.NEW_PAGE == r111) goto L37;
        r115.i(this.f271100h, r111);
    L28:
        th = move-exception;
        th.getMessage();
        goto L30
    L21:
        if (PageLoadReason.TAB_REFRESH == r111) goto L89;
        if (PageLoadReason.TAB_CLICK == r111) goto L89;
        if (PageLoadReason.NEW_PAGE != r111) goto L30;
    L16:
        e = move-exception;
        e.printStackTrace();
    L8:
        th = move-exception;
        th.getLocalizedMessage();
        goto L11
    L4:
        r100 = r110;
        goto L5
    }

    @Override // pi7.i
    public final void T00(WebView r100, int r101, String r102) {
        a r103 = this.f271102j;
        if (r103 == null) goto L6;
        r103.c(r100, r101, r102);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("LuckyCatBrowserFragment", "onCreateView");
        ViewGroup r103 = (ViewGroup) r100.inflate(R.layout.luckycat_browser_fragment, r101, false);
        this.f271104l = r103;
        this.f271097e = (ProgressBar) r103.findViewById(R.id.ss_htmlprogessbar);
        T90(r103);
        if (this.f271104l != null) goto L6;
    L15:
        return r103;
    L6:
        if (getContext() == null) goto L15;
        m r104 = m.a.f271349a;
        Context r105 = getContext();
        com.bytedance.ug.sdk.luckycat.api.depend.l r106 = r104.f271339g;
        if (r106 == null) goto L11;
        b r107 = r106.a();
    L12:
        if (r107 != null) goto L14;
        r107 = new ErrorView(r105);
    L14:
        this.f271103k = r107;
        ViewGroup r108 = r107.getView();
        this.f271104l.addView(r108, 1, new ViewGroup.LayoutParams(-1, -1));
        goto L15
    L11:
        r107 = null;
        goto L12
    }
}
