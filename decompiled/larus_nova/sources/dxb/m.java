package dxb;

import android.net.Uri;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes37.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ cxb.a f470488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f470489b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f470490c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Uri f470491d;

    public m(cxb.a r100, boolean r101, String r102, Uri r103) {
        this.f470488a = r100;
        this.f470489b = r101;
        this.f470490c = r102;
        this.f470491d = r103;
    }

    public final void a() {
        g r100 = new g("wb_override_url_loading", c.f470466k, this.f470488a);
        r100.a("is_first_page", Boolean.valueOf(this.f470489b));
        r100.a("override_loading_type", "end");
        r100.a("override_loading_end_point", this.f470490c);
        t.b(r100, this.f470491d);
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
