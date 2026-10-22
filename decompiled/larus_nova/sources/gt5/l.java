package gt5;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.opmonitor.service.OPMonitor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ft5.a f482550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f482551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f482552c;

    public l(ft5.a r100, boolean r101, String r102) {
        this.f482550a = r100;
        this.f482551b = r101;
        this.f482552c = r102;
    }

    public final void a() {
        OPMonitor r100 = new g("wb_load_url_start", e.f482517a, this.f482550a).addCategoryValue("is_first_page", Boolean.valueOf(this.f482551b));
        String r101 = this.f482552c;
        int r102 = p.f482566a;
        Intrinsics.checkNotNull(r100);
        p.c(r100, r101);
        r100.flush();
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
