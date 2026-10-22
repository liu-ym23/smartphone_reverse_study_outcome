package dxb;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes37.dex */
public final class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ cxb.a f470501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f470502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f470503c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f470504d;

    public p(cxb.a r100, boolean r101, String r102, String r103) {
        this.f470501a = r100;
        this.f470502b = r101;
        this.f470503c = r102;
        this.f470504d = r103;
    }

    public final void a() {
        g r100 = new g("webview_container_report", c.f470457b, this.f470501a);
        r100.a("is_first_page", Boolean.valueOf(this.f470502b));
        r100.a("scene", "performance_timing");
        String r101 = this.f470503c;
        String r102 = this.f470504d;
        t.c(r100, r101);
        JSONObject r103 = new JSONObject(r102);     // Catch: Throwable -> L8
        Iterator<String> r104 = r103.keys();     // Catch: Throwable -> L8
    L5:
        if (r104.hasNext() == false) goto L10;
        String r105 = r104.next();     // Catch: Throwable -> L8
        r100.a(r105, r103.opt(r105));     // Catch: Throwable -> L8
    L10:
        r100.b();
        return;
    L8:
        th = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.d("WebMonitorManager", th);
        goto L10
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
