package w35;

import android.text.TextUtils;
import com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle;
import com.bytedance.ee.bear.domain.BearUrl;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f558154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f558155b;

    public c(String r100, a r101) {
        this.f558154a = r100;
        this.f558155b = r101;
    }

    public final void a() {
        String r100 = this.f558154a;
        if (r100 == null) goto L5;
        Map<String, Boolean> r101 = this.f558155b.A;
        HashMap r102 = (HashMap) r101;
        r102.put(r100, Boolean.TRUE);
    L5:
        boolean r103 = true;
        if (this.f558155b.isAttachedToWindow() == false) goto L26;
        BearUrl r104 = this.f558155b.H;
        if (r104 == null) goto L26;
        if (r104 == null) goto L11;
        String r105 = r104.f222560a;
    L13:
        if (TextUtils.equals(r105, this.f558154a) == false) goto L26;
        String r106 = this.f558155b.I;
        if (r106 != null) goto L17;
    L20:
        boolean r107 = true;
    L21:
        if (r107 == true) goto L26;
        a r108 = this.f558155b;
        String r109 = r108.I;
        if (r109 == null) goto L39;
        r108.G.j(IECLynxCardLifeCycle.ECLynxCardCacheType.RENDER_CACHE, "value_render_cache_ssrwebview_wait_preload_time", Long.valueOf(System.currentTimeMillis() - r108.E));
        r108.o(r109, r108.H);
        int r110 = a.K;
        tt5.a.h("SSR_REN_SSRWebView", "render cache after biz ready");
        return;
    L39:
        return;
    L17:
        if (r106.length() == 0) goto L20;
        r107 = false;
        goto L21
    L11:
        r105 = null;
    L26:
        if (TextUtils.equals(this.f558154a, sbb.e.f541304o.getType()) == false) goto L41;
        int r111 = a.K;
        StringBuilder r112 = new StringBuilder("isAttachedToWindow = ");
        r112.append(this.f558155b.isAttachedToWindow());
        r112.append(", mBearUrl is null ? ");
        if (this.f558155b.H != null) goto L30;
        boolean r113 = true;
    L31:
        r112.append(r113);
        r112.append(", mHtmlCache isNullOrEmpty? ");
        String r114 = this.f558155b.I;
        if (r114 != null) goto L34;
    L37:
        r112.append(r103);
        r112.append(' ');
        tt5.a.h("SSR_REN_SSRWebView", r112.toString());
        return;
    L34:
        if (r114.length() == 0) goto L37;
        r103 = false;
        goto L37
    L30:
        r113 = false;
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
