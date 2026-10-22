package w35;

import android.text.TextUtils;
import com.bytedance.ee.bear.domain.BearUrl;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ a b;

    public c(String r1, a r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        String r0 = this.a;
        if (r0 == null) goto L5;
        Map<String, Boolean> r1 = this.b.A;
        HashMap r2 = (HashMap) r1;
        r2.put(r0, Boolean.TRUE);
    L5:
        boolean r3 = true;
        if (this.b.isAttachedToWindow() == false) goto L26;
        BearUrl r4 = this.b.H;
        if (r4 == null) goto L26;
        if (r4 == null) goto L11;
        String r5 = r4.a;
    L13:
        if (TextUtils.equals(r5, this.a) == false) goto L26;
        String r6 = this.b.I;
        if (r6 != null) goto L17;
    L20:
        boolean r7 = true;
    L21:
        if (r7 == true) goto L26;
        a r8 = this.b;
        String r9 = r8.I;
        if (r9 == null) goto L39;
        r8.G.j("render_cache", "value_render_cache_ssrwebview_wait_preload_time", Long.valueOf(System.currentTimeMillis() - r8.E));
        r8.o(r9, r8.H);
        int r10 = a.K;
        tt5.a.h("SSR_REN_SSRWebView", "render cache after biz ready");
        return;
    L39:
        return;
    L17:
        if (r6.length() == 0) goto L20;
        r7 = false;
        goto L21
    L11:
        r5 = null;
    L26:
        if (TextUtils.equals(this.a, sbb.e.o.getType()) == false) goto L41;
        int r11 = a.K;
        StringBuilder r12 = new StringBuilder("isAttachedToWindow = ");
        r12.append(this.b.isAttachedToWindow());
        r12.append(", mBearUrl is null ? ");
        if (this.b.H != null) goto L30;
        boolean r13 = true;
    L31:
        r12.append(r13);
        r12.append(", mHtmlCache isNullOrEmpty? ");
        String r14 = this.b.I;
        if (r14 != null) goto L34;
    L37:
        r12.append(r3);
        r12.append(' ');
        tt5.a.h("SSR_REN_SSRWebView", r12.toString());
        return;
    L34:
        if (r14.length() == 0) goto L37;
        r3 = false;
        goto L37
    L30:
        r13 = false;
        goto L31
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
