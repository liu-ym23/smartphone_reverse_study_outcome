package gt5;

import android.net.Uri;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.opmonitor.service.OPMonitor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ft5.a f482553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f482554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f482555c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Uri f482556d;

    public m(ft5.a r100, boolean r101, String r102, Uri r103) {
        this.f482553a = r100;
        this.f482554b = r101;
        this.f482555c = r102;
        this.f482556d = r103;
    }

    public final void a() {
        OPMonitor r100 = new g("wb_override_url_loading", e.f482531o, this.f482553a).addCategoryValue("is_first_page", Boolean.valueOf(this.f482554b)).addCategoryValue("override_loading_type", "end").addCategoryValue("override_loading_end_point", this.f482555c);
        Uri r101 = this.f482556d;
        int r102 = p.f482566a;
        Intrinsics.checkNotNull(r100);
        p.b(r100, r101);
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
