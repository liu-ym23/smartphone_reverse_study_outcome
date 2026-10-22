package tq7;

import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.bytedance.webx.core.webview.WebViewContainer;
import com.bytedance.webx.event.EventManager;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public final class a extends iq7.a<WebViewContainer> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f547216k = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f547217e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f547218f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f547219g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f547220h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final C7762a f547221i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public jq7.b f547222j;

    /* JADX INFO: renamed from: tq7.a$a, reason: collision with other inner class name */
    public class C7762a extends WebViewContainer.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a f547223c;

        @Override // com.bytedance.webx.event.a
        public final iq7.a d() {
            return this.f547223c;
        }

        public C7762a(a r100) {
            this.f547223c = r100;
        }

        @Override // com.bytedance.webx.core.webview.WebViewContainer.a
        public final void D(String r100) {
            a r101 = this.f547223c;
            if (r101.f547217e == false) goto L5;
        L7:
            boolean r102 = false;
        L8:
            r101.f547217e = true;
            if (r102 == true) goto L22;
        L14:
            super.D(r100);     // Catch: Throwable -> L19
            if (r102 == false) goto L17;
            this.f547223c.getClass();     // Catch: Throwable -> L19
        L19:
            th = move-exception;
            this.f547223c.f547217e = false;
            throw th;
        L17:
            this.f547223c.f547217e = false;
            return;
        L22:
            jq7.b r103 = r101.f547222j;     // Catch: Throwable -> L19
            if (r103 != null) goto L13;
            jq7.b r104 = new jq7.b(r101.getContext());     // Catch: Throwable -> L19
            r101.f547222j = r104;     // Catch: Throwable -> L19
            r104.a(r100, 0);     // Catch: Throwable -> L19
            goto L14
        L13:
            r103.a(r100, 1);     // Catch: Throwable -> L19
            goto L14
        L5:
            if (r101.f547218f == true) goto L7;
            r102 = true;
            goto L8
        }

        @Override // com.bytedance.webx.core.webview.WebViewContainer.a
        public final void E(String r100, Map<String, String> r101) {
            a r102 = this.f547223c;
            if (r102.f547217e == false) goto L5;
        L7:
            boolean r103 = false;
        L8:
            r102.f547218f = true;
            if (r103 == true) goto L22;
        L14:
            super.E(r100, r101);     // Catch: Throwable -> L19
            if (r103 == false) goto L17;
            this.f547223c.getClass();     // Catch: Throwable -> L19
        L19:
            th = move-exception;
            this.f547223c.f547218f = false;
            throw th;
        L17:
            this.f547223c.f547218f = false;
            return;
        L22:
            jq7.b r104 = r102.f547222j;     // Catch: Throwable -> L19
            if (r104 != null) goto L13;
            jq7.b r105 = new jq7.b(r102.getContext());     // Catch: Throwable -> L19
            r102.f547222j = r105;     // Catch: Throwable -> L19
            r105.a(r100, 0);     // Catch: Throwable -> L19
            goto L14
        L13:
            r104.a(r100, 1);     // Catch: Throwable -> L19
            goto L14
        L5:
            if (r102.f547218f == true) goto L7;
            r103 = true;
            goto L8
        }
    }

    public class b extends iq7.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final C7763a f547224e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ a f547225f;

        /* JADX INFO: renamed from: tq7.a$b$a, reason: collision with other inner class name */
        public class C7763a extends rq7.a.AbstractC7520a {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ b f547226c;

            @Override // com.bytedance.webx.event.a
            public final iq7.a d() {
                return this.f547226c;
            }

            public C7763a(b r100) {
                this.f547226c = r100;
            }

            @Override // rq7.a.AbstractC7520a
            public final void w(WebView r100, int r101) {
                a r102 = this.f547226c.f547225f;
                int r103 = a.f547216k;
                r102.getClass();
                super.w(r100, r101);
            }
        }

        @Override // iq7.a
        public final void a() {
            C7763a r100 = this.f547224e;
            EventManager.c(this.f495385a, "onProgressChanged", r100);
        }

        public b(a r100) {
            this.f547225f = r100;
            this.f547224e = new C7763a(this);
        }
    }

    public class c extends iq7.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final C7764a f547227e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ a f547228f;

        /* JADX INFO: renamed from: tq7.a$c$a, reason: collision with other inner class name */
        public class C7764a extends rq7.b.a {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ c f547229c;

            @Override // com.bytedance.webx.event.a
            public final iq7.a d() {
                return this.f547229c;
            }

            public C7764a(c r100) {
                this.f547229c = r100;
            }

            @Override // rq7.b.a
            public final boolean A(WebView r100, String r101) {
                a r102 = this.f547229c.f547228f;
                if (r102.f547219g == false) goto L5;
            L7:
                boolean r103 = false;
            L8:
                r102.f547219g = true;
                boolean r104 = super.A(r100, r101);     // Catch: Throwable -> L18
                if (r103 == false) goto L16;
                if (r104 == true) goto L15;
                jq7.b r105 = this.f547229c.f547228f.f547222j;     // Catch: Throwable -> L18
                if (r105 == null) goto L15;
                r105.a(r101, 1);     // Catch: Throwable -> L18
            L15:
                this.f547229c.f547228f.getClass();     // Catch: Throwable -> L18
            L16:
                this.f547229c.f547228f.f547219g = false;
                return r104;
            L18:
                th = move-exception;
                this.f547229c.f547228f.f547219g = false;
                throw th;
            L5:
                if (r102.f547220h == true) goto L7;
                r103 = true;
                goto L8
            }

            @Override // rq7.b.a
            public final boolean z(WebView r100, WebResourceRequest r101) {
                a r102 = this.f547229c.f547228f;
                if (r102.f547219g == false) goto L5;
            L7:
                boolean r103 = false;
            L8:
                r102.f547220h = true;
                boolean r104 = super.z(r100, r101);     // Catch: Throwable -> L18
                if (r103 == false) goto L16;
                if (r104 == true) goto L15;
                a r105 = this.f547229c.f547228f;     // Catch: Throwable -> L18
                String r106 = r101.getUrl().toString();     // Catch: Throwable -> L18
                jq7.b r107 = r105.f547222j;     // Catch: Throwable -> L18
                if (r107 == null) goto L15;
                r107.a(r106, 1);     // Catch: Throwable -> L18
            L15:
                this.f547229c.f547228f.getClass();     // Catch: Throwable -> L18
            L16:
                this.f547229c.f547228f.f547220h = false;
                return r104;
            L18:
                th = move-exception;
                this.f547229c.f547228f.f547220h = false;
                throw th;
            L5:
                if (r102.f547220h == true) goto L7;
                r103 = true;
                goto L8
            }

            @Override // rq7.b.a
            public final void e(WebView r100, String r101, boolean r102) {
                jq7.b r103 = this.f547229c.f547228f.f547222j;
                if (r103 == null) goto L5;
                r103.a(r101, 1);
            L5:
                this.f547229c.f547228f.getClass();
                super.e(r100, r101, r102);
            }
        }

        @Override // iq7.a
        public final void a() {
            C7764a r100 = this.f547227e;
            EventManager.c(this.f495385a, "shouldOverrideUrlLoading", r100);
            C7764a r101 = this.f547227e;
            EventManager.c(this.f495385a, "doUpdateVisitedHistory", r101);
        }

        public c(a r100) {
            this.f547228f = r100;
            this.f547227e = new C7764a(this);
        }
    }

    public a() {
        this.f547217e = false;
        this.f547218f = false;
        this.f547219g = false;
        this.f547220h = false;
        this.f547221i = new C7762a(this);
    }

    @Override // iq7.a
    public final void a() {
        iq7.a.C6348a.a(((WebViewContainer) ((oq7.c) ((oq7.a) getContext()).f524890b)).getExtendableWebViewClient(), new c(this));
        iq7.a.C6348a.a(((WebViewContainer) ((oq7.c) ((oq7.a) getContext()).f524890b)).getExtendableWebChromeClient(), new b(this));
        C7762a r100 = this.f547221i;
        EventManager.c(this.f495385a, "loadUrl", r100);
    }
}
