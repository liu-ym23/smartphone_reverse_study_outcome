package gt5;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.opmonitor.service.OPMonitor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ft5.a f482547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f482548b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f482549c;

    public k(ft5.a r100, boolean r101, String r102) {
        this.f482547a = r100;
        this.f482548b = r101;
        this.f482549c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        OPMonitor r100 = new g("wb_load_resource", null, this.f482547a).addCategoryValue("is_first_page", Boolean.valueOf(this.f482548b));     // Catch: Throwable -> L4
        String r101 = this.f482549c;     // Catch: Throwable -> L4
        int r102 = p.f482566a;     // Catch: Throwable -> L4
        Intrinsics.checkNotNull(r100);     // Catch: Throwable -> L4
        p.c(r100, r101);     // Catch: Throwable -> L4
        r100.flush();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
