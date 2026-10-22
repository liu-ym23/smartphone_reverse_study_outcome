package gt5;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.opmonitor.service.OPMonitor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ft5.a f482542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f482543b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f482544c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f482545d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f482546e;

    public j(ft5.a r100, boolean r101, int r102, String r103, String r104) {
        this.f482542a = r100;
        this.f482543b = r101;
        this.f482544c = r102;
        this.f482545d = r103;
        this.f482546e = r104;
    }

    public final void a() {
        OPMonitor r100 = new g("wb_load_duration", e.f482533q, this.f482542a).addCategoryValue("is_first_page", Boolean.valueOf(this.f482543b)).addCategoryValue("result_code", Integer.valueOf(this.f482544c)).addCategoryValue("duration", this.f482545d);
        String r101 = this.f482546e;
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
