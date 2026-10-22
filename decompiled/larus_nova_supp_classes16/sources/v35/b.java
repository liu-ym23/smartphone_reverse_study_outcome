package v35;

import android.text.TextUtils;
import android.webkit.WebView;
import com.bytedance.ee.bear.domain.BearUrl;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.Map;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ a b;

    public b(String r1, a r2) {
        this.a = r1;
        this.b = r2;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [v35.a, vv4.a] */
    public final void a() {
        String r0 = this.a;
        if (r0 == null) goto L5;
        Map<String, Boolean> r1 = this.b.b;
        HashMap r2 = (HashMap) r1;
        r2.put(r0, Boolean.TRUE);
    L5:
        ?? r3 = this.b;
        BearUrl r4 = r3.c;
        String r5 = r3.d;
        k r6 = r3.getWeb();
        boolean r7 = true;
        if (r6 == null) goto L12;
        WebView r8 = r6.getWebView();
        if (r8 == null) goto L12;
        if (r8.isAttachedToWindow() != true) goto L12;
        boolean r9 = true;
    L13:
        if (r9 == false) goto L25;
        if (r4 == null) goto L26;
        if (r5 != null) goto L17;
    L20:
        if (r7 == false) goto L22;
        return;
    L22:
        if (TextUtils.equals(r4.a, this.a) == false) goto L28;
        this.b.a.j("render_cache", "value_render_cache_ssrwebview_wait_preload_time", Long.valueOf(System.currentTimeMillis() - this.b.f));
        this.b.e(r5);
        return;
    L28:
        return;
    L17:
        if (r5.length() == 0) goto L20;
        r7 = false;
        goto L20
    L26:
        return;
    L25:
        return;
    L12:
        r9 = false;
        goto L13
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
