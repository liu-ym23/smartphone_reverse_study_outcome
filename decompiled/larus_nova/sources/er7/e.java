package er7;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebView;
import com.bytedance.webx.seclink.util.ReportUtil;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Objects;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes22.dex */
public final class e extends er7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WebView f473628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f473629b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f473630c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f473631d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public dr7.d f473632e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Handler f473633f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public dr7.a f473634g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f473635h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f473636i;

    public class a implements hr7.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f473637a;

        /* JADX INFO: renamed from: er7.e$a$a, reason: collision with other inner class name */
        public class RunnableC5807a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f473638a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ hr7.c f473639b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ a f473640c;

            public final void a() {
                e r100 = this.f473640c.f473637a;     // Catch: Exception -> L8
                if (r100.f473628a != null) goto L5;
                return;
            L5:
                if (this.f473638a.equals(r100.f473631d) == false) goto L12;
                e r101 = this.f473640c.f473637a;     // Catch: Exception -> L8
                r101.f473628a.loadUrl(ir7.c.a(this.f473638a, r101.f473635h, r101.f473629b, this.f473639b.f486896b, "sec_link_strategy_v2"));     // Catch: Exception -> L8
                return;
            L12:
                return;
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

            public RunnableC5807a(a r100, String r101, hr7.c r102) {
                this.f473640c = r100;
                this.f473638a = r101;
                this.f473639b = r102;
            }
        }

        @Override // hr7.b
        public final void onFail() {
        }

        public a(e r100) {
            this.f473637a = r100;
        }

        @Override // hr7.b
        public final void a(String r100, hr7.c r101) {
            if (r101 == null) goto L6;
            dr7.d r102 = this.f473637a.f473632e;
            if (r102 == null) goto L6;
            r102.a(r101);
        L6:
            if (r101 != null) goto L8;
        L10:
            Objects.toString(r101);
            return;
        L8:
            if (r101.f486897c == false) goto L10;
            this.f473637a.i(r100, r101);
            this.f473637a.f473633f.post(new RunnableC5807a(this, r100, r101));
            goto L10
        }
    }

    @Override // dr7.c
    public final boolean b() {
        if (er7.a.e(this.f473628a, false) == false) goto L6;
        this.f473628a.goBackOrForward(-2);
        this.f473634g = null;
        return true;
    L6:
        return false;
    }

    @Override // dr7.c
    public final boolean canGoBack() {
        return er7.a.e(this.f473628a, true);
    }

    @Override // dr7.c
    public final void a(String r100) {
        if (ir7.c.f(r100, this.f473629b) == false) goto L6;
        this.f473631d = r100;     // Catch: Exception -> L45
    L6:
        int r101 = f(r100, this.f473629b);     // Catch: Exception -> L45
        com.bytedance.webx.seclink.setting.c r102 = com.bytedance.webx.seclink.setting.c.d();     // Catch: Exception -> L45
        com.bytedance.webx.seclink.setting.a.c r103 = r102.e(this.f473629b);     // Catch: Exception -> L45
        boolean r104 = true;
        if (r103 == null) goto L9;
        boolean r105 = r103.f272623c;     // Catch: Exception -> L45
    L15:
        String r106 = this.f473629b;     // Catch: Exception -> L45
        if (r105 == false) goto L18;
        int r107 = 0;
    L19:
        ReportUtil.c(r100, r106, r101, "sec_link_strategy_v2", r107);     // Catch: Exception -> L45
        if (r101 == 0) goto L22;
        return;
    L22:
        dr7.a r108 = this.f473634g;     // Catch: Exception -> L45
        if (r108 == null) goto L25;
        String r109 = r108.f469777a;     // Catch: Exception -> L45
    L27:
        if (ir7.c.e(r109, r100) == true) goto L33;
        int r110 = h(r100);     // Catch: Exception -> L45
        if (r105 == false) goto L32;
        r104 = false;
    L32:
        g(r100, r110, r104, false);     // Catch: Exception -> L45
        return;
    L33:
        dr7.a r111 = this.f473634g;     // Catch: Exception -> L45
        if (r111 == null) goto L48;
        hr7.c r112 = r111.f469778b;     // Catch: Exception -> L45
        if (r112 != null) goto L38;
        return;
    L38:
        if (r112.f486896b != 9) goto L50;
        int r113 = h(r100);     // Catch: Exception -> L45
        if (r105 == false) goto L43;
        r104 = false;
    L43:
        g(r100, r113, r104, false);     // Catch: Exception -> L45
        return;
    L50:
        return;
    L48:
        return;
    L25:
        r109 = "";
        goto L27
    L18:
        r107 = 1;
        goto L19
    L9:
        com.bytedance.webx.seclink.setting.a r114 = r102.c();     // Catch: Exception -> L45
        if (r114 == null) goto L14;
        com.bytedance.webx.seclink.setting.a.b r115 = r114.f272607c;     // Catch: Exception -> L45
        if (r115 == null) goto L14;
        r105 = r115.f272618b;     // Catch: Exception -> L45
    L14:
        r105 = true;
        goto L15
    }

    @Override // dr7.c
    public final void c(dr7.d r100) {
        this.f473632e = r100;
    }

    @Override // dr7.c
    public final String d(String r100) {
        if (this.f473630c != null) goto L5;
        this.f473630c = r100;
    L5:
        int r101 = f(r100, this.f473629b);
        com.bytedance.webx.seclink.setting.c r102 = com.bytedance.webx.seclink.setting.c.d();
        com.bytedance.webx.seclink.setting.a.c r103 = r102.e(this.f473629b);
        if (r103 == null) goto L8;
        boolean r104 = r103.f272623c;
    L14:
        boolean r105 = !r104;
        ReportUtil.b(r100, this.f473629b, r101, "sec_link_strategy_v2", r105 ? 1 : 0);
        if (r101 != 0) goto L17;
        this.f473631d = r100;
        i(r100, null);
        g(r100, h(r100), r105, true);
    L17:
        return r100;
    L8:
        com.bytedance.webx.seclink.setting.a r106 = r102.c();
        if (r106 == null) goto L13;
        com.bytedance.webx.seclink.setting.a.b r107 = r106.f272607c;
        if (r107 == null) goto L13;
        r104 = r107.f272618b;
    L13:
        r104 = true;
        goto L14
    }

    public final int h(String r100) {
        if (ir7.c.e(this.f473630c, r100) == false) goto L6;
        return 1;
    L6:
        return 3;
    }

    public e(WebView r100, String r101) {
        this.f473633f = new Handler(Looper.getMainLooper());
        this.f473636i = new a(this);
        this.f473628a = r100;
        this.f473629b = r101;
        this.f473635h = "";
    }

    @Override // er7.a
    public final int f(String r100, String r101) {
        if (com.bytedance.webx.seclink.setting.c.i(r101) == true) goto L7;
        return 6;
    L7:
        return super.f(r100, r101);
    }

    public final void i(String r100, hr7.c r101) {
        if (this.f473634g != null) goto L5;
        this.f473634g = new dr7.a();
    L5:
        dr7.a r102 = this.f473634g;
        r102.f469777a = r100;
        r102.f469778b = r101;
    }

    public final boolean g(String r100, int r110, boolean r111, boolean r112) {
        if (r111 == false) goto L18;
        String r101 = this.f473629b;
        Future<hr7.c> r113 = ir7.c.b(r100, this.f473635h, r101, r110, null, r112, "sec_link_strategy_v2");
        hr7.c r114 = r113.get(com.bytedance.webx.seclink.setting.c.d().f(), TimeUnit.MILLISECONDS);     // Catch: Exception -> L22
        dr7.d r115 = this.f473632e;     // Catch: Exception -> L22
        if (r115 == null) goto L9;
        if (r114 == null) goto L9;
        r115.a(r114);     // Catch: Exception -> L22
    L9:
        if (r114 != null) goto L11;
        return false;
    L11:
        if (r114.f486895a == true) goto L13;
        return false;
    L13:
        if (r114.f486897c == false) goto L27;
        i(r100, r114);     // Catch: Exception -> L22
        this.f473628a.loadUrl(ir7.c.a(r100, this.f473635h, this.f473629b, r114.f486896b, "sec_link_strategy_v2"));     // Catch: Exception -> L22
        return true;
    L27:
        return false;
    L28:
        return false;
    L18:
        if (TextUtils.isEmpty(r100) == true) goto L21;
        this.f473633f.postDelayed(new d(this, r100, r110, r112), 100);
    L21:
        return false;
    }
}
