package ac4;

import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONException;
import org.json.JSONObject;
import qb4.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b {
    public WebView a;
    public Handler b;

    public class a implements Runnable {
        public final WebView a;
        public final /* synthetic */ String b;

        @Override // java.lang.Runnable
        public final void run() {
            WebView r0 = this.a;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.evaluateJavascript("javascript:window.Native2JSBridge._handleMessageFromApp(" + this.b + ")", null);     // Catch: Throwable -> L6
            int r1 = n.a;     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public a(b r1, String r2) {
            this.b = r2;
            this.a = r1.a;
        }
    }

    /* JADX INFO: renamed from: ac4.b$b, reason: collision with other inner class name */
    public class RunnableC0000b implements Runnable {
        public final WebView a;

        public final void a() {
            WebView r0 = this.a;
            if (r0 == null) goto L11;
            r0.stopLoading();
            this.a.loadUrl("about:blank");
            this.a.clearCache(true);
            this.a.clearHistory();
            ViewParent r1 = this.a.getParent();
            if (r1 != null) goto L7;
        L9:
            this.a.destroy();
            return;
        L7:
            if ((r1 instanceof ViewGroup) == false) goto L9;
            ((ViewGroup) r1).removeView(this.a);
            goto L9
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

        public RunnableC0000b(b r1) {
            this.a = r1.a;
        }
    }

    public class c {
        public final ac4.a a;
        public final /* synthetic */ b b;

        public class a implements Runnable {
            public final /* synthetic */ String a;
            public final /* synthetic */ c b;

            @Override // java.lang.Runnable
            public final void run() {
                ac4.c r0 = new ac4.c(this.b.b, this.a);     // Catch: Throwable -> L4
                this.b.a.a(r0);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public a(c r1, String r2) {
                this.b = r1;
                this.a = r2;
            }
        }

        @JavascriptInterface
        public void callMethodParams(String r3) {
            int r0 = n.a;
            Handler r1 = this.b.b;
            if (r1 != null) goto L5;
            return;
        L5:
            r1.post(new a(this, r3));
        }

        @JavascriptInterface
        public void offMethodParams(String r1) {
            int r2 = n.a;
        }

        @JavascriptInterface
        public void onMethodParams(String r2) {
            int r0 = n.a;
            JSONObjectProtectorUtils.getString(new JSONObject(r2), "__callback_id");     // Catch: JSONException -> L5
            return;
        L5:
            e = move-exception;
            e.printStackTrace();
        }

        public c(b r1, ac4.a r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public final void b() {
        if (this.a != null) goto L5;
        return;
    L5:
        this.b.post(new RunnableC0000b(this));
        this.b = null;
        this.a = null;
    }

    public final void a(String r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (this.a == null) goto L11;
        Handler r0 = this.b;
        if (r0 == null) goto L12;
        r0.post(new a(this, r3));
        int r4 = n.a;
        return;
    L12:
        return;
    }

    public b(ac4.a r2, WebView r3) {
        this.b = null;
        this.a = r3;
        if (r3 != null) goto L5;
        return;
    L5:
        r3.getSettings().setJavaScriptEnabled(true);
        this.a.addJavascriptInterface(new c(this, r2), "androidJsBridge");
        this.b = new Handler(Looper.getMainLooper());
    }
}
