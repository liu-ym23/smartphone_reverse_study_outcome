package er7;

import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import com.bytedance.webx.seclink.util.ReportUtil;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Objects;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes22.dex */
public final class c extends er7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WebView f473610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f473611b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f473612c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f473613d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f473614e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f473615f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public dr7.a f473616g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public dr7.d f473617h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Handler f473618i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final a f473619j;

    public class a implements hr7.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f473620a;

        /* JADX INFO: renamed from: er7.c$a$a, reason: collision with other inner class name */
        public class RunnableC5806a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f473621a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a f473622b;

            public final void a() {
                c r100 = this.f473622b.f473620a;     // Catch: Exception -> L9
                if (r100.f473610a != null) goto L5;
            L7:
                String r101 = this.f473622b.f473620a.f473615f;     // Catch: Exception -> L9
            L10:
                return;
            L5:
                if (this.f473621a.equals(r100.f473615f) == false) goto L7;
                c r102 = this.f473622b.f473620a;     // Catch: Exception -> L9
                r102.f473610a.loadUrl(ir7.c.a(this.f473621a, r102.f473612c, r102.f473611b, -1, "sec_link_strategy"));     // Catch: Exception -> L9
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

            public RunnableC5806a(a r100, String r101) {
                this.f473622b = r100;
                this.f473621a = r101;
            }
        }

        @Override // hr7.b
        public final void onFail() {
        }

        public a(c r100) {
            this.f473620a = r100;
        }

        @Override // hr7.b
        public final void a(String r100, hr7.c r101) {
            if (r101 == null) goto L6;
            dr7.d r102 = this.f473620a.f473617h;
            if (r102 == null) goto L6;
            r102.a(r101);
        L6:
            if (r101 != null) goto L8;
        L10:
            Objects.toString(r101);
            return;
        L8:
            if (r101.f486897c == false) goto L10;
            this.f473620a.j(r100, r101);
            this.f473620a.f473618i.post(new RunnableC5806a(this, r100));
            goto L10
        }
    }

    @Override // dr7.c
    public final boolean b() {
        if (er7.a.e(this.f473610a, false) == false) goto L6;
        this.f473610a.goBackOrForward(-2);
        this.f473616g = null;
        return true;
    L6:
        return false;
    }

    @Override // dr7.c
    public final boolean canGoBack() {
        return er7.a.e(this.f473610a, true);
    }

    @Override // dr7.c
    public final void a(String r100) {
        i(r100);     // Catch: Exception -> L21
        int r101 = f(r100, this.f473611b);     // Catch: Exception -> L21
        ReportUtil.c(r100, this.f473611b, r101, "sec_link_strategy", 0);     // Catch: Exception -> L21
        if (r101 == 0) goto L6;
        return;
    L6:
        dr7.a r102 = this.f473616g;     // Catch: Exception -> L21
        if (r102 == null) goto L9;
        String r103 = r102.f469777a;     // Catch: Exception -> L21
    L11:
        if (ir7.c.e(r103, r100) == true) goto L13;
        g(r100, h(r100), false);     // Catch: Exception -> L21
        return;
    L13:
        dr7.a r104 = this.f473616g;     // Catch: Exception -> L21
        if (r104 == null) goto L24;
        hr7.c r105 = r104.f469778b;     // Catch: Exception -> L21
        if (r105 != null) goto L18;
        return;
    L18:
        if (r105.f486896b != 9) goto L26;
        g(r100, h(r100), false);     // Catch: Exception -> L21
        return;
    L26:
        return;
    L24:
        return;
    L9:
        r103 = "";
        goto L11
    }

    @Override // dr7.c
    public final void c(dr7.d r100) {
        this.f473617h = r100;
    }

    @Override // dr7.c
    public final String d(String r100) {
        this.f473614e = r100;
        j(r100, null);
        int r101 = f(r100, this.f473611b);
        ReportUtil.b(r100, this.f473611b, r101, "sec_link_strategy", 2);
        if (r101 != 0) goto L5;
        r100 = ir7.c.a(r100, this.f473612c, this.f473611b, -1, "sec_link_strategy");
    L5:
        this.f473613d = true;
        return r100;
    }

    public final int h(String r100) {
        if (ir7.c.e(this.f473614e, r100) == false) goto L7;
        return 1;
    L7:
        if (this.f473613d == false) goto L10;
        this.f473613d = false;
        return 2;
    L10:
        return 3;
    }

    public final void i(String r100) {
        dr7.a r101 = this.f473616g;
        if (r101 == null) goto L5;
        String r102 = r101.f469777a;
    L7:
        if (ir7.c.e(r102, r100) == false) goto L12;
        if (ir7.c.e(this.f473614e, r100) == false) goto L12;
        hr7.c r103 = new hr7.c(0);
        r103.f486897c = false;
        r103.f486896b = 0;
        fr7.a.a().d(this.f473611b, r100, r103);
    L12:
        if (ir7.c.f(r100, this.f473611b) == false) goto L15;
        this.f473615f = r100;
        return;
    L15:
        return;
    L5:
        r102 = "";
        goto L7
    }

    public c(WebView r100, String r101) {
        this.f473613d = true;
        this.f473618i = new Handler(Looper.getMainLooper());
        this.f473619j = new a(this);
        this.f473610a = r100;
        this.f473611b = r101;
        this.f473612c = "";
    }

    public final void j(String r100, hr7.c r101) {
        if (this.f473616g != null) goto L5;
        this.f473616g = new dr7.a();
    L5:
        dr7.a r102 = this.f473616g;
        r102.f469777a = r100;
        r102.f469778b = r101;
    }

    public final boolean g(String r110, int r111, boolean r112) {
        hr7.c r100 = fr7.a.a().b(this.f473611b, r110);
        if (r100 == null) goto L5;
    L22:
        if (r100 == null) goto L31;
        dr7.d r113 = this.f473617h;
        if (r113 == null) goto L26;
        r113.a(r100);
    L26:
        ReportUtil.d(r110, this.f473611b, "sec_link_strategy", r100.f486897c, "url_verify");
        if (r100.f486897c == false) goto L31;
        j(r110, r100);
        this.f473610a.loadUrl(ir7.c.a(r110, this.f473612c, this.f473611b, -1, "sec_link_strategy"));
        return true;
    L31:
        return false;
    L5:
        if (f(r110, this.f473611b) != 0) goto L22;
        if (r112 == false) goto L20;
        String r101 = this.f473611b;
        Future<hr7.c> r114 = ir7.c.b(r110, this.f473612c, r101, r111, null, true, "sec_link_strategy");
        hr7.c r115 = r114.get(com.bytedance.webx.seclink.setting.c.d().f(), TimeUnit.MILLISECONDS);     // Catch: Exception -> L32
        dr7.d r116 = this.f473617h;     // Catch: Exception -> L32
        if (r116 == null) goto L13;
        if (r115 == null) goto L13;
        r116.a(r115);     // Catch: Exception -> L32
    L13:
        if (r115.f486895a == false) goto L18;
        if (r115.f486897c == false) goto L18;
        j(r110, r115);     // Catch: Exception -> L32
        this.f473610a.loadUrl(ir7.c.a(r110, this.f473612c, this.f473611b, r115.f486896b, "sec_link_strategy"));     // Catch: Exception -> L32
        r115.toString();     // Catch: Exception -> L32
        return true;
    L18:
        return false;
    L20:
        this.f473618i.postDelayed(new b(this, r110, r111), 100);
        return false;
    }
}
