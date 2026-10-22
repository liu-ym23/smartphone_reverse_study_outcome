package er7;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f473623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f473624b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Map f473625c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f473626d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ e f473627e;

    public final void a() {
        String r100 = this.f473623a;
        if (r100 == null) goto L10;
        e r101 = this.f473627e;
        if (r101.f473628a != null) goto L7;
        return;
    L7:
        if (r100.equals(r101.f473631d) == false) goto L12;
        String r102 = this.f473623a;
        e r103 = this.f473627e;
        ir7.c.c(r102, r103.f473635h, r103.f473629b, this.f473624b, this.f473625c, "sec_link_strategy_v2", r103.f473636i, this.f473626d);
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

    public d(e r100, String r101, int r102, boolean r103) {
        this.f473627e = r100;
        this.f473623a = r101;
        this.f473624b = r102;
        this.f473625c = null;
        this.f473626d = r103;
    }
}
