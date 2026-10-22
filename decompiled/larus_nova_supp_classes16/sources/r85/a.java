package r85;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.drive.view.preview.wps.WpsView;
import com.bytedance.ee.bear.drive.view.widget.j;
import kotlin.jvm.internal.Intrinsics;
import q85.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements d {
    public q85.a a;
    public boolean b;
    public boolean c;

    /* JADX INFO: renamed from: r85.a$a, reason: collision with other inner class name */
    public static final class C0286a {
    }

    public static final class b implements View.OnAttachStateChangeListener {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
            this.a.b = true;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
            this.a.b = false;
        }
    }

    public static final class c extends j {
        public final /* synthetic */ a a;
        public final /* synthetic */ WpsView b;

        public c(a r1, WpsView r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // com.bytedance.ee.bear.drive.view.widget.j
        public final void a(WebView r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "view");
            Intrinsics.checkNotNullParameter(r3, "url");
            q85.a r4 = this.a.a;
            if (r4 == null) goto L5;
            r4.b = true;
        L5:
            tt5.a.h("WpsTemplatePreloader", "preload webview load finish");
        }

        @Override // com.bytedance.ee.bear.drive.view.widget.j
        public final void c(WebView r1, int r2) {
            this.a.a = null;
            tt5.a.h("WpsTemplatePreloader", "onRenderProcessGone");
        }

        @Override // com.bytedance.ee.bear.drive.view.widget.j
        public final void b(int r2, String r3, String r4) {
            tt5.a.h("WpsTemplatePreloader", "onReceivedError errorcode is " + r2 + " description is " + r3);
            if (this.a.c == false) goto L5;
            return;
        L5:
            if (TextUtils.isEmpty(r3) == false) goto L7;
            boolean r5 = false;
        L8:
            if (r5 == false) goto L12;
            tt5.a.h("WpsTemplatePreloader", "onReceivedError reload ");
            this.b.getWebView().reload();
            this.a.c = true;
            return;
        L12:
            return;
        L7:
            r5 = r3.contains("ERR_FILE_NOT_FOUND");
            goto L8
        }
    }

    static {
    }

    public a() {
    }

    @Override // q85.d
    public final void reset() {
        this.a = null;
    }

    @Override // q85.d
    public final q85.a b() {
        if (this.b == false) goto L7;
        return null;
    L7:
        return this.a;
    }

    @Override // q85.d
    public final void a(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        tt5.a.h("WpsTemplatePreloader", "preload");
        WpsView r0 = new WpsView(r6.getApplicationContext());
        this.a = new q85.a(r0);
        new n45.c(r0.getWebView().getSettings(), (b0) org.koin.java.a.c(b0.class, null, null, 6)).a(r0.getWebView());
        r0.getWebView().addJavascriptInterface(r0.getJavascriptInterface(), "jsObj");
        r0.getWebView().loadUrl("file:///android_asset/wps/wps.html");
        r0.addOnAttachStateChangeListener(new b(this));
        r0.getWebView().f(new c(this, r0));
    }
}
