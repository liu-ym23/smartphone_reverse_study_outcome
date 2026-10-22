package h76;

import com.bytedance.ies.xelement.banner.Banner;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f483989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Banner f483990b;

    public final void a() {
        Banner r100 = this.f483990b;
        if (r100.f249788o == false) goto L5;
        int r101 = r100.A.getCurrentItem();
        Banner r102 = this.f483990b;
        r102.A.setCurrentItem((this.f483989a + r101) - r102.j(r101), this.f483990b.f249792s);
        return;
    L5:
        r100.f249796w = Math.max(Math.min(r100.f249796w, ((CopyOnWriteArrayList) r100.F).size()), 0);
        Banner r103 = this.f483990b;
        r103.A.setCurrentItem(r103.f249796w, r103.f249792s);
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

    public a(Banner r100, int r101) {
        this.f483990b = r100;
        this.f483989a = r101;
    }
}
