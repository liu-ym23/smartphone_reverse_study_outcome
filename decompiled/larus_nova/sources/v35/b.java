package v35;

import android.text.TextUtils;
import android.webkit.WebView;
import com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle;
import com.bytedance.ee.bear.domain.BearUrl;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.Map;
import vv4.k;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f552839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f552840b;

    public b(String r100, a r101) {
        this.f552839a = r100;
        this.f552840b = r101;
    }

    public final void a() {
        String r100 = this.f552839a;
        if (r100 == null) goto L5;
        Map<String, Boolean> r101 = this.f552840b.f552828b;
        HashMap r102 = (HashMap) r101;
        r102.put(r100, Boolean.TRUE);
    L5:
        a r103 = this.f552840b;
        BearUrl r104 = r103.f552829c;
        String r105 = r103.f552830d;
        k r106 = r103.getWeb();
        boolean r107 = true;
        if (r106 == null) goto L12;
        WebView r108 = r106.getWebView();
        if (r108 == null) goto L12;
        if (r108.isAttachedToWindow() != true) goto L12;
        boolean r109 = true;
    L13:
        if (r109 == false) goto L25;
        if (r104 == null) goto L26;
        if (r105 != null) goto L17;
    L20:
        if (r107 == false) goto L22;
        return;
    L22:
        if (TextUtils.equals(r104.f222560a, this.f552839a) == false) goto L28;
        this.f552840b.f552827a.j(IECLynxCardLifeCycle.ECLynxCardCacheType.RENDER_CACHE, "value_render_cache_ssrwebview_wait_preload_time", Long.valueOf(System.currentTimeMillis() - this.f552840b.f552832f));
        this.f552840b.e(r105);
        return;
    L28:
        return;
    L17:
        if (r105.length() == 0) goto L20;
        r107 = false;
        goto L20
    L26:
        return;
    L25:
        return;
    L12:
        r109 = false;
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
