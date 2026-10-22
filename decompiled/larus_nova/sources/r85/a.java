package r85;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.drive.view.preview.wps.WpsView;
import com.bytedance.ee.bear.drive.view.widget.j;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;
import q85.d;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public q85.a f536510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f536511b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f536512c;

    /* JADX INFO: renamed from: r85.a$a, reason: collision with other inner class name */
    public static final class C7447a {
    }

    public static final class b implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f536513a;

        public b(a r100) {
            this.f536513a = r100;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            this.f536513a.f536511b = true;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            this.f536513a.f536511b = false;
        }
    }

    public static final class c extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f536514a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ WpsView f536515b;

        public c(a r100, WpsView r101) {
            this.f536514a = r100;
            this.f536515b = r101;
        }

        @Override // com.bytedance.ee.bear.drive.view.widget.j
        public final void a(WebView r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r101, "url");
            q85.a r102 = this.f536514a.f536510a;
            if (r102 == null) goto L5;
            r102.f532024b = true;
        L5:
            tt5.a.h("WpsTemplatePreloader", "preload webview load finish");
        }

        @Override // com.bytedance.ee.bear.drive.view.widget.j
        public final void c(WebView r100, int r101) {
            this.f536514a.f536510a = null;
            tt5.a.h("WpsTemplatePreloader", "onRenderProcessGone");
        }

        @Override // com.bytedance.ee.bear.drive.view.widget.j
        public final void b(int r100, String r101, String r102) {
            tt5.a.h("WpsTemplatePreloader", "onReceivedError errorcode is " + r100 + " description is " + r101);
            if (this.f536514a.f536512c == false) goto L5;
            return;
        L5:
            if (TextUtils.isEmpty(r101) == false) goto L7;
            boolean r103 = false;
        L8:
            if (r103 == false) goto L12;
            tt5.a.h("WpsTemplatePreloader", "onReceivedError reload ");
            this.f536515b.getWebView().reload();
            this.f536514a.f536512c = true;
            return;
        L12:
            return;
        L7:
            r103 = r101.contains("ERR_FILE_NOT_FOUND");
            goto L8
        }
    }

    static {
    }

    public a() {
    }

    @Override // q85.d
    public final void reset() {
        this.f536510a = null;
    }

    @Override // q85.d
    public final q85.a b() {
        if (this.f536511b == false) goto L7;
        return null;
    L7:
        return this.f536510a;
    }

    @Override // q85.d
    public final void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        tt5.a.h("WpsTemplatePreloader", "preload");
        WpsView r101 = new WpsView(r100.getApplicationContext());
        this.f536510a = new q85.a(r101);
        new n45.c(r101.getWebView().getSettings(), (b0) org.koin.java.a.c(b0.class, null, null, 6)).a(r101.getWebView());
        r101.getWebView().addJavascriptInterface(r101.getJavascriptInterface(), "jsObj");
        r101.getWebView().loadUrl("file:///android_asset/wps/wps.html");
        r101.addOnAttachStateChangeListener(new b(this));
        r101.getWebView().f(new c(this, r101));
    }
}
