package h56;

import com.bytedance.ies.uikit.menu.SlidingMenu;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f483877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SlidingMenu f483878b;

    public final void a() {
        this.f483878b.getContent().setLayerType(this.f483877a, null);
        this.f483878b.getMenu().setLayerType(this.f483877a, null);
        if (this.f483878b.getSecondaryMenu() == null) goto L6;
        this.f483878b.getSecondaryMenu().setLayerType(this.f483877a, null);
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

    public a(SlidingMenu r100, int r101) {
        this.f483878b = r100;
        this.f483877a = r101;
    }
}
