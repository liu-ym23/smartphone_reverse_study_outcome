package com.tencent.connect.auth;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.tencent.connect.common.Constants;
import com.tencent.open.b.h;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.m;
import com.tencent.open.web.security.SecureJsInterface;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public class a extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f461447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b f461448b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private IUiListener f461449c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Handler f461450d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private FrameLayout f461451e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private LinearLayout f461452f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private FrameLayout f461453g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ProgressBar f461454h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f461455i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private com.tencent.open.c.d f461456j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Context f461457k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private com.tencent.open.web.security.b f461458l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f461459m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f461460n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f461461o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f461462p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f461463q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private long f461464r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private HashMap<String, Runnable> f461465s;

    /* JADX INFO: renamed from: com.tencent.connect.auth.a$a, reason: collision with other inner class name */
    public class C5537a extends WebViewClient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f461470a;

        private C5537a(a r100) {
            this.f461470a = r100;
        }

        public static void INVOKEVIRTUAL_com_tencent_connect_auth_a$a_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(a r100) {
            Handler r101 = DialogLancet.resolveDialogHandler(r100);
            if (r101 != null) goto L5;
        L8:
            DialogLancet.beforeDialogDismiss(r100);
            r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
        L10:
            DialogLancet.afterDialogDismiss(r100);
            return;
        L11:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r100);
            throw th;
        L13:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
            Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
            if (r102 == null) goto L10;
            com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
            goto L10
        L5:
            if (Looper.myLooper() == r101.getLooper()) goto L8;
            r101.post(DialogLancet.createDismissRunnable(r100));
        }

        public /* synthetic */ C5537a(a r100, AnonymousClass1 r101) {
            this(r100);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView r100, String r101) {
            super.onPageFinished(r100, r101);
            SLog.v("openSDK_LOG.AuthDialog", "-->onPageFinished, url: " + r101);
            a.g(this.f461470a).setVisibility(8);
            if (a.e(this.f461470a) == null) goto L6;
            a.e(this.f461470a).setVisibility(0);
        L6:
            if (TextUtils.isEmpty(r101) == true) goto L9;
            a.n(this.f461470a).removeCallbacks((Runnable) a.p(this.f461470a).remove(r101));
            return;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView r100, String r101) {
            SLog.v("openSDK_LOG.AuthDialog", "-->Redirect URL: " + r101);
            if (r101.startsWith("auth://browser") == false) goto L21;
            JSONObject r102 = m.c(r101);
            a r103 = this.f461470a;
            a.a(r103, a.b(r103));
            if (a.c(this.f461470a) == false) goto L8;
        L19:
            return true;
        L8:
            if (r102.optString("fail_cb", null) == null) goto L11;
            this.f461470a.a(r102.optString("fail_cb"), "");
            goto L19
        L11:
            if (r102.optInt("fall_to_wv") != 1) goto L16;
            a r104 = this.f461470a;
            StringBuilder r105 = new StringBuilder();
            r105.append(a.d(this.f461470a));
            String r106 = "?";
            if (a.d(this.f461470a).indexOf("?") <= (-1)) goto L15;
            r106 = "&";
        L15:
            r105.append(r106);
            a.b(r104, r105.toString());
            a.b(this.f461470a, a.d(this.f461470a) + "browser_error=1");
            a.e(this.f461470a).loadUrl(a.d(this.f461470a));
            goto L19
        L16:
            String r107 = r102.optString("redir", null);
            if (r107 == null) goto L19;
            a.e(this.f461470a).loadUrl(r107);
            goto L19
        L21:
            if (r101.startsWith("auth://tauth.qq.com/") == false) goto L25;
            a.f(this.f461470a).onComplete(m.c(r101));
            INVOKEVIRTUAL_com_tencent_connect_auth_a$a_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(this.f461470a);
            return true;
        L25:
            if (r101.startsWith(Constants.CANCEL_URI) == false) goto L29;
            a.f(this.f461470a).onCancel();
            INVOKEVIRTUAL_com_tencent_connect_auth_a$a_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(this.f461470a);
            return true;
        L29:
            if (r101.startsWith(Constants.CLOSE_URI) == false) goto L33;
            INVOKEVIRTUAL_com_tencent_connect_auth_a$a_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(this.f461470a);
            return true;
        L33:
            if (r101.startsWith(Constants.DOWNLOAD_URI) == false) goto L35;
        L75:
        L65:
            e = move-exception;
            SLog.e("openSDK_LOG.AuthDialog", "-->start download activity exception, e: ", e);
        L67:
            return true;
        L60:
            if (r101.startsWith(Constants.DOWNLOAD_URI) == false) goto L62;
            Uri r108 = UriProtector.parse(Uri.decode(r101.substring(11)));     // Catch: Exception -> L65
        L63:
            Intent r109 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, r108);     // Catch: Exception -> L65
            r109.addFlags(268435456);     // Catch: Exception -> L65
            a.a(this.f461470a).startActivity(r109);     // Catch: Exception -> L65
            goto L67
        L62:
            r108 = UriProtector.parse(Uri.decode(r101));     // Catch: Exception -> L65
            goto L63
        L35:
            if (r101.endsWith(".apk") == true) goto L75;
            if (r101.startsWith("auth://progress") == false) goto L49;
            List<String> r110 = UriProtector.parse(r101).getPathSegments();     // Catch: Exception -> L69
            if (r110.isEmpty() == false) goto L42;
            return true;
        L42:
            int r111 = CastIntegerProtector.valueOf((String) ListProtector.get(r110, 0)).intValue();     // Catch: Exception -> L69
            if (r111 != 0) goto L45;
            a.g(this.f461470a).setVisibility(8);     // Catch: Exception -> L69
            a.e(this.f461470a).setVisibility(0);     // Catch: Exception -> L69
        L72:
            goto L47
        L45:
            if (r111 != 1) goto L72;
            a.g(this.f461470a).setVisibility(0);     // Catch: Exception -> L69
        L47:
            return true;
        L49:
            if (r101.startsWith("auth://onLoginSubmit") == false) goto L55;
            List<String> r112 = UriProtector.parse(r101).getPathSegments();     // Catch: Exception -> L68
            if (r112.isEmpty() == true) goto L53;
            a.c(this.f461470a, (String) ListProtector.get(r112, 0));     // Catch: Exception -> L68
        L53:
            return true;
        L55:
            if (a.h(this.f461470a).a(a.e(this.f461470a), r101) == false) goto L57;
            return true;
        L57:
            SLog.i("openSDK_LOG.AuthDialog", "-->Redirect URL: return false");
            return false;
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView r100, String r101, Bitmap r102) {
            SLog.v("openSDK_LOG.AuthDialog", "-->onPageStarted, url: " + r101);
            super.onPageStarted(r100, r101, r102);
            a.g(this.f461470a).setVisibility(0);
            a.a(this.f461470a, SystemClock.elapsedRealtime());
            if (TextUtils.isEmpty(a.i(this.f461470a)) == true) goto L5;
            a.n(this.f461470a).removeCallbacks((Runnable) a.p(this.f461470a).remove(a.i(this.f461470a)));
        L5:
            a.d(this.f461470a, r101);
            a r103 = this.f461470a;
            d r104 = new d(r103, a.i(r103));
            a.p(this.f461470a).put(r101, r104);
            a.n(this.f461470a).postDelayed(r104, 120000);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView r100, SslErrorHandler r101, SslError r102) {
            SLog.e("openSDK_LOG.AuthDialog", "-->onReceivedSslError " + r102.getPrimaryError() + "请求不合法，请检查手机安全设置，如系统时间、代理等");
            r101.cancel();
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView r100, int r101, String r102, String r103) {
            super.onReceivedError(r100, r101, r102, r103);
            SLog.i("openSDK_LOG.AuthDialog", "-->onReceivedError, errorCode: " + r101 + " | description: " + r102);
            if (m.b(a.a(this.f461470a)) == true) goto L7;
            a.f(this.f461470a).onError(new UiError(9001, "当前网络不可用，请稍后重试！", r103));
            INVOKEVIRTUAL_com_tencent_connect_auth_a$a_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(this.f461470a);
            return;
        L7:
            if (a.i(this.f461470a).startsWith("https://imgcache.qq.com/ptlogin/static/qzsjump.html?") == true) goto L15;
            long r104 = SystemClock.elapsedRealtime() - a.j(this.f461470a);
            if (a.k(this.f461470a) < 1) goto L11;
        L13:
            a.e(this.f461470a).loadUrl(a.o(this.f461470a));
            return;
        L11:
            if (r104 >= a.l(this.f461470a)) goto L13;
            a.m(this.f461470a);
            a.n(this.f461470a).postDelayed(new AnonymousClass1(this), 500);
            return;
        L15:
            a.f(this.f461470a).onError(new UiError(r101, r102, r103));
            INVOKEVIRTUAL_com_tencent_connect_auth_a$a_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(this.f461470a);
        }
    }

    public class b extends DefaultUiListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f461472a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f461473b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f461474c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f461475d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private IUiListener f461476e;

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            IUiListener r100 = this.f461476e;
            if (r100 == null) goto L6;
            r100.onCancel();
            this.f461476e = null;
            return;
        }

        private void a(String r100) {
            onComplete(m.d(r100));     // Catch: JSONException -> L4
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
            onError(new UiError(-4, Constants.MSG_JSON_ERROR, r100));
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object r110) {
            JSONObject r111 = (JSONObject) r110;
            h.a().a(this.f461475d + "_H5", SystemClock.elapsedRealtime(), 0, 0, r111.optInt("ret", -6), this.f461472a, false);
            IUiListener r100 = this.f461476e;
            if (r100 == null) goto L6;
            r100.onComplete(r111);
            this.f461476e = null;
            return;
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError r110) {
            if (r110.errorMessage == null) goto L5;
            String r100 = r110.errorMessage + this.f461472a;
        L6:
            h.a().a(this.f461475d + "_H5", SystemClock.elapsedRealtime(), 0, 0, r110.errorCode, r100, false);
            a.a(this.f461474c, r100);
            IUiListener r101 = this.f461476e;
            if (r101 == null) goto L10;
            r101.onError(r110);
            this.f461476e = null;
            return;
        L10:
            return;
        L5:
            r100 = this.f461472a;
            goto L6
        }

        public static /* synthetic */ void a(b r100, String r101) {
            r100.a(r101);
        }

        public b(a r100, String r101, String r102, String r103, IUiListener r104) {
            this.f461474c = r100;
            this.f461475d = r101;
            this.f461472a = r102;
            this.f461473b = r103;
            this.f461476e = r104;
        }
    }

    public class c extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f461477a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private b f461478b;

        @Override // android.os.Handler
        public void handleMessage(Message r100) {
            int r101 = r100.what;
            if (r101 != 1) goto L5;
            b.a(this.f461478b, (String) r100.obj);
            return;
        L5:
            if (r101 != 2) goto L7;
            this.f461478b.onCancel();
            return;
        L7:
            if (r101 != 3) goto L15;
            a.a(a.a(this.f461477a), (String) r100.obj);
            return;
        }

        public c(a r100, b r101, Looper r102) {
            this.f461477a = r100;
            super(r102);
            this.f461478b = r101;
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f461479a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f461480b;

        @Override // java.lang.Runnable
        public void run() {
            com_tencent_connect_auth_a$d_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_tencent_connect_auth_a$d__run$___twin___() {
            SLog.v("openSDK_LOG.AuthDialog", "-->timeoutUrl: " + this.f461479a + " | mRetryUrl: " + a.i(this.f461480b));
            if (this.f461479a.equals(a.i(this.f461480b)) == false) goto L6;
            a.f(this.f461480b).onError(new UiError(9002, "请求页面超时，请稍后重试！", a.i(this.f461480b)));
            INVOKEVIRTUAL_com_tencent_connect_auth_a$d_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(this.f461480b);
            return;
        }

        public static void INVOKEVIRTUAL_com_tencent_connect_auth_a$d_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(a r100) {
            Handler r101 = DialogLancet.resolveDialogHandler(r100);
            if (r101 != null) goto L5;
        L8:
            DialogLancet.beforeDialogDismiss(r100);
            r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
        L10:
            DialogLancet.afterDialogDismiss(r100);
            return;
        L11:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r100);
            throw th;
        L13:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
            Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
            if (r102 == null) goto L10;
            com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
            goto L10
        L5:
            if (Looper.myLooper() == r101.getLooper()) goto L8;
            r101.post(DialogLancet.createDismissRunnable(r100));
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_tencent_connect_auth_a$d_com_larus_apm_impl_protector_RunnableLancet_run(d r100) {
            r100.com_tencent_connect_auth_a$d__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public d(a r100, String r101) {
            this.f461480b = r100;
            this.f461479a = r101;
        }
    }

    public static /* synthetic */ void access$000(Dialog r100) {
        super.dismiss();
    }

    private String a() {
        String r100 = this.f461447a;
        String r101 = "https://imgcache.qq.com/ptlogin/static/qzsjump.html?" + r100.substring(r100.indexOf("?") + 1);
        SLog.i("openSDK_LOG.AuthDialog", "-->generateDownloadUrl, url: https://imgcache.qq.com/ptlogin/static/qzsjump.html?");
        return r101;
    }

    private void c() {
        this.f461454h = new ProgressBar(this.f461457k);
        LinearLayout.LayoutParams r100 = new LinearLayout.LayoutParams(-2, -2);
        this.f461454h.setLayoutParams(r100);
        this.f461452f = new LinearLayout(this.f461457k);
        if (this.f461455i.equals("action_login") == false) goto L9;
        LinearLayout.LayoutParams r101 = new LinearLayout.LayoutParams(-2, -2);
        r101.gravity = 16;
        r101.leftMargin = 5;
        TextView r102 = new TextView(this.f461457k);
        if (Locale.getDefault().getLanguage().equals("zh") == false) goto L7;
        r102.setText("登录中...");
    L8:
        r102.setTextColor(Color.rgb(255, 255, 255));
        r102.setTextSize(18.0f);
        r102.setLayoutParams(r101);
    L10:
        FrameLayout.LayoutParams r103 = new FrameLayout.LayoutParams(-2, -2);
        r103.gravity = 17;
        this.f461452f.setLayoutParams(r103);
        this.f461452f.addView(this.f461454h);
        if (r102 == null) goto L13;
        this.f461452f.addView(r102);
    L13:
        this.f461453g = new FrameLayout(this.f461457k);
        FrameLayout.LayoutParams r104 = new FrameLayout.LayoutParams(-1, -1);
        r104.gravity = 17;
        this.f461453g.setLayoutParams(r104);
        this.f461453g.setBackgroundColor(ColorProtector.parseColor("#B3000000"));
        this.f461453g.addView(this.f461452f);
        return;
    L7:
        r102.setText("Logging in...");
        goto L8
    L9:
        r102 = null;
        goto L10
    }

    private void d() {
        this.f461456j.setVerticalScrollBarEnabled(false);
        this.f461456j.setHorizontalScrollBarEnabled(false);
        this.f461456j.setWebViewClient(new C5537a(this, null));
        this.f461456j.setWebChromeClient(new WebChromeClient());
        this.f461456j.clearFormData();
        this.f461456j.clearSslPreferences();
        this.f461456j.setOnLongClickListener(new AnonymousClass2(this));
        this.f461456j.setOnTouchListener(new AnonymousClass3(this));
        WebSettings r100 = this.f461456j.getSettings();
        com.tencent.open.web.a.a(this.f461456j);
        r100.setSaveFormData(false);
        r100.setCacheMode(-1);
        r100.setNeedInitialFocus(false);
        r100.setBuiltInZoomControls(true);
        r100.setSupportZoom(true);
        r100.setRenderPriority(WebSettings.RenderPriority.HIGH);
        r100.setDatabaseEnabled(true);
        r100.setDatabasePath(this.f461457k.getDir("databases", 0).getPath());
        r100.setDomStorageEnabled(true);
        SLog.v("openSDK_LOG.AuthDialog", "-->mUrl : " + this.f461447a);
        String r101 = this.f461447a;
        this.f461461o = r101;
        this.f461456j.loadUrl(r101);
        this.f461456j.setVisibility(4);
        this.f461458l.a(new SecureJsInterface(), "SecureJsInterface");
        SecureJsInterface.isPWDEdit = false;
        super.setOnDismissListener(new AnonymousClass4(this));
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        if (this.f461459m == true) goto L5;
        this.f461448b.onCancel();
    L5:
        super.onBackPressed();
    }

    private void b() {
        c();
        FrameLayout.LayoutParams r100 = new FrameLayout.LayoutParams(-1, -1);
        com.tencent.open.c.d r101 = new com.tencent.open.c.d(this.f461457k);
        this.f461456j = r101;
        r101.setLayerType(1, null);
        this.f461456j.setLayoutParams(r100);
        r100.gravity = 17;
        com.tencent.open.c.c r102 = new com.tencent.open.c.c(this.f461457k);
        r102.setLayoutParams(r100);
        r102.addView(this.f461456j);
        FrameLayout r103 = new FrameLayout(this.f461457k);
        this.f461451e = r103;
        r103.addView(r102);
        this.f461451e.setBackgroundColor(-1);
        this.f461451e.addView(this.f461453g);
        String r104 = m.b(this.f461447a).getString("style");
        if (r104 != null) goto L5;
    L7:
        setContentView(this.f461451e);
        return;
    L5:
        if ("qr".equals(r104) == false) goto L7;
        a(this.f461451e);
        goto L7
    }

    private boolean e() {
        com.tencent.connect.auth.b r100 = com.tencent.connect.auth.b.a();
        String r101 = r100.c();
        com.tencent.connect.auth.b.a r102 = new com.tencent.connect.auth.b.a();
        r102.f461486a = this.f461449c;
        r102.f461487b = this;
        r102.f461488c = r101;
        String r103 = r100.a(r102);
        String r104 = this.f461447a;
        String r105 = r104.substring(0, r104.indexOf("?"));
        Bundle r106 = m.b(this.f461447a);
        r106.putString("token_key", r101);
        r106.putString("serial", r103);
        r106.putString("browser", "1");
        String r107 = r105 + "?" + HttpUtils.encodeUrl(r106);
        this.f461447a = r107;
        return m.a(this.f461457k, r107);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        this.f461465s.clear();
        this.f461450d.removeCallbacksAndMessages(null);
        Context r100 = this.f461457k;     // Catch: Exception -> L11
        if ((r100 instanceof Activity) == true) goto L6;
    L13:
        com.tencent.open.c.d r101 = this.f461456j;
        if (r101 == null) goto L19;
        r101.destroy();
        this.f461456j = null;
        return;
    L19:
        return;
    L6:
        if (((Activity) r100).isFinishing() == true) goto L13;
        if (isShowing() == false) goto L13;
        INVOKESPECIAL_com_tencent_connect_auth_a_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(this);     // Catch: Exception -> L11
        SLog.i("openSDK_LOG.AuthDialog", "-->dismiss dialog");     // Catch: Exception -> L11
    L11:
        e = move-exception;
        SLog.e("openSDK_LOG.AuthDialog", "-->dismiss dialog exception:", e);
        goto L13
    }

    @Override // android.app.Dialog
    public void onStop() {
        super.onStop();
    }

    public static void INVOKESPECIAL_com_tencent_connect_auth_a_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(Dialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        access$000(r100);     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    private void a(ViewGroup r100) {
        ImageView r101 = new ImageView(this.f461457k);
        int r102 = com.tencent.connect.avatar.a.a(this.f461457k, 15.6f);
        int r103 = com.tencent.connect.avatar.a.a(this.f461457k, 25.2f);
        int r104 = com.tencent.connect.avatar.a.a(this.f461457k, 10.0f);
        int r105 = r104 * 2;
        FrameLayout.LayoutParams r106 = new FrameLayout.LayoutParams(r102 + r105, r103 + r105);
        r106.leftMargin = r104;
        r101.setLayoutParams(r106);
        r101.setPadding(r104, r104, r104, r104);
        r101.setImageDrawable(m.a("h5_qr_back.png", this.f461457k));
        r101.setScaleType(ImageView.ScaleType.FIT_CENTER);
        r101.setOnClickListener(new AnonymousClass1(this));
        r100.addView(r101);
    }

    public static /* synthetic */ boolean b(a r100) {
        return r100.e();
    }

    public static /* synthetic */ boolean c(a r100) {
        return r100.f461459m;
    }

    public static /* synthetic */ String d(a r100) {
        return r100.f461447a;
    }

    public static /* synthetic */ com.tencent.open.c.d e(a r100) {
        return r100.f461456j;
    }

    public static /* synthetic */ b f(a r100) {
        return r100.f461448b;
    }

    public static /* synthetic */ FrameLayout g(a r100) {
        return r100.f461453g;
    }

    public static /* synthetic */ com.tencent.open.web.security.b h(a r100) {
        return r100.f461458l;
    }

    public static /* synthetic */ String i(a r100) {
        return r100.f461461o;
    }

    public static /* synthetic */ long j(a r100) {
        return r100.f461463q;
    }

    public static /* synthetic */ int k(a r100) {
        return r100.f461460n;
    }

    public static /* synthetic */ long l(a r100) {
        return r100.f461464r;
    }

    public static /* synthetic */ int m(a r100) {
        int r101 = r100.f461460n;
        r100.f461460n = r101 + 1;
        return r101;
    }

    public static /* synthetic */ Handler n(a r100) {
        return r100.f461450d;
    }

    public static /* synthetic */ String o(a r100) {
        return r100.a();
    }

    public static /* synthetic */ HashMap p(a r100) {
        return r100.f461465s;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle r100) {
        requestWindowFeature(1);
        super.onCreate(r100);
        com.tencent.open.a.a(getWindow());
        b();
        d();
        this.f461465s = new HashMap();
    }

    private String a(String r100) {
        StringBuilder r101 = new StringBuilder(r100);
        if (TextUtils.isEmpty(this.f461462p) == true) goto L8;
        if (this.f461462p.length() < 4) goto L8;
        String r102 = this.f461462p;
        String r103 = r102.substring(r102.length() - 4);
        r101.append("_u_");
        r101.append(r103);
    L8:
        return r101.toString();
    }

    public static /* synthetic */ Context a(a r100) {
        return r100.f461457k;
    }

    private static void b(Context r100, String r101) {
        JSONObject r102 = m.d(r101);     // Catch: JSONException -> L4
        int r103 = JSONObjectProtectorUtils.getInt(r102, "type");     // Catch: JSONException -> L4
        String r104 = JSONObjectProtectorUtils.getString(r102, "msg");     // Catch: JSONException -> L4
        Toast.makeText(r100.getApplicationContext(), r104, r103).show();     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static /* synthetic */ String c(a r100, String r101) {
        r100.f461462p = r101;
        return r101;
    }

    public static /* synthetic */ String d(a r100, String r101) {
        r100.f461461o = r101;
        return r101;
    }

    public void a(String r100, String r101) {
        this.f461456j.loadUrl("javascript:" + r100 + "(" + r101 + ");void(" + System.currentTimeMillis() + ");");
    }

    public static /* synthetic */ String a(a r100, String r101) {
        return r100.a(r101);
    }

    public static /* synthetic */ String b(a r100, String r101) {
        r100.f461447a = r101;
        return r101;
    }

    public static /* synthetic */ void a(Context r100, String r101) {
        b(r100, r101);
    }

    public static /* synthetic */ long a(a r100, long r101) {
        r100.f461463q = r101;
        return r101;
    }

    public static /* synthetic */ boolean a(a r100, boolean r101) {
        r100.f461459m = r101;
        return r101;
    }

    public a(Context r100, String r110, String r111, IUiListener r112, QQToken r113) {
        super(r100, R.style.Theme.Translucent.NoTitleBar);
        this.f461459m = false;
        this.f461463q = 0;
        this.f461464r = 30000;
        this.f461457k = r100;
        this.f461447a = r111;
        this.f461448b = new b(this, r110, r111, r113.getAppId(), r112);
        this.f461450d = new c(this, this.f461448b, r100.getMainLooper());
        this.f461449c = r112;
        this.f461455i = r110;
        this.f461458l = new com.tencent.open.web.security.b();
        getWindow().setSoftInputMode(32);
    }
}
