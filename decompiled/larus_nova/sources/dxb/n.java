package dxb;

import android.net.Uri;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes37.dex */
public final class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ cxb.a f470492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f470493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Uri f470494c;

    public n(cxb.a r100, boolean r101, Uri r102) {
        this.f470492a = r100;
        this.f470493b = r101;
        this.f470494c = r102;
    }

    public final void a() {
        g r100 = new g("wb_override_url_loading", c.f470466k, this.f470492a);
        r100.a("is_first_page", Boolean.valueOf(this.f470493b));
        r100.a("override_loading_type", "start");
        t.b(r100, this.f470494c);
        r100.b();
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
