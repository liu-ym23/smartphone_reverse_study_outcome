package ij7;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ug.sdk.luckycat.impl.browser.LuckyCatBrowserActivity;
import com.bytedance.ug.sdk.luckycat.impl.manager.m;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f490073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vi7.b f490074b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile PthreadTimer f490075c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f490076d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f490077e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f490078f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f490079g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Activity f490080h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final pi7.i f490081i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f490082j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f490083k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile boolean f490084l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public WebView f490085m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public i f490086n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile boolean f490087o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final HandlerC6276a f490088p;

    /* JADX INFO: renamed from: ij7.a$a, reason: collision with other inner class name */
    public class HandlerC6276a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f490089a;

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            switch(r100.what) {
                case 90010: goto L6;
                case 90011: goto L5;
                default: goto L15;
            };
        L5:
            m r101 = m.a.f271349a;
            WebView r102 = this.f490089a.f490085m;
            return;
        L6:
            vi7.b r103 = this.f490089a.f490074b;
            if (r103 != null) goto L9;
            return;
        L9:
            if (r103.c() == true) goto L14;
            this.f490089a.f490078f = true;
            return;
        L14:
            return;
        }

        public HandlerC6276a(a r100, Looper r101) {
            this.f490089a = r100;
            super(r101);
        }
    }

    public final void b() {
        vi7.b r100 = this.f490074b;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.c() == false) goto L13;
        this.f490074b.g();
        Activity r101 = this.f490080h;
        if (r101 != null) goto L9;
        return;
    L9:
        if ((r101 instanceof LuckyCatBrowserActivity) == false) goto L15;
        ((LuckyCatBrowserActivity) r101).B1("back_btn");
        return;
    L15:
        return;
    }

    public final void d() {
        if (this.f490075c == null) goto L6;
        this.f490075c.cancel();
        this.f490075c.purge();
        this.f490075c = null;
        return;
    }

    public final void a(String r100) {
        m r101 = m.a.f271349a;
        vi7.b r102 = this.f490074b;
        if (r102 != null) goto L5;
    L9:
        Activity r103 = this.f490080h;
        if (r103 != null) goto L12;
        return;
    L12:
        if ((r103 instanceof LuckyCatBrowserActivity) == false) goto L16;
        ((LuckyCatBrowserActivity) r103).C1();
        return;
    L16:
        return;
    L5:
        if (r102.a() == false) goto L9;
        this.f490074b.b();
        i r104 = this.f490086n;
        if (r104 == null) goto L9;
        r104.b(r100);
        goto L9
    }

    public final void c(WebView r100, int r101, String r102) {
        m.a.f271349a.q();
        d();
        if (this.f490074b == null) goto L27;
        a("show_error_view");
        this.f490082j = r101;
        vi7.b r103 = this.f490074b;
        if (r103 != null) goto L7;
    L25:
        r100.stopLoading();     // Catch: Throwable -> L22
        r100.loadUrl("about:blank");     // Catch: Throwable -> L22
        return;
    L22:
        th = move-exception;
        th.getMessage();
        com.bytedance.ug.sdk.luckycat.impl.utils.a.a("ErrorViewHelper", th.getMessage());
        return;
    L7:
        if (r103.c() == true) goto L25;
        vi7.b r104 = this.f490074b;
        if ((r104 instanceof com.bytedance.ug.sdk.luckycat.impl.tiger.widget.a) == false) goto L11;
        ((com.bytedance.ug.sdk.luckycat.impl.tiger.widget.a) r104).e();
    L12:
        Activity r105 = this.f490080h;
        if (r105 != null) goto L15;
    L17:
        i r106 = this.f490086n;
        if (r106 == null) goto L25;
        r106.d(r101, r102);
        goto L25
    L15:
        if ((r105 instanceof LuckyCatBrowserActivity) == false) goto L17;
        ((LuckyCatBrowserActivity) r105).C1();
        goto L17
    L11:
        r104.f();
        goto L12
    }

    public a(FragmentActivity r100, vi7.b r101, pi7.i r102, boolean r103) {
        this.f490078f = false;
        this.f490082j = 0;
        this.f490084l = false;
        this.f490088p = new HandlerC6276a(this, Looper.getMainLooper());
        this.f490080h = r100;
        this.f490081i = r102;
        this.f490074b = r101;
        this.f490073a = r103;
        r101.setOnRetryClickListener(new b(this));
        if ((!(r100 instanceof LuckyCatBrowserActivity)) == true) goto L5;
    L7:
        r101.setOnCloseClickListener(new c(this));
        return;
    L5:
        if (m.a.f271349a.g() != 2329) goto L7;
        r101.j();
        goto L7
    }
}
