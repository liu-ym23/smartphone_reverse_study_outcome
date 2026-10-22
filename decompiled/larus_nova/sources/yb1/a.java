package yb1;

import com.bytedance.android.live.uikit.menu.SlidingMenu;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes7.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f567060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SlidingMenu f567061b;

    public final void a() {
        this.f567061b.getContent().setLayerType(this.f567060a, null);
        this.f567061b.getMenu().setLayerType(this.f567060a, null);
        if (this.f567061b.getSecondaryMenu() == null) goto L6;
        this.f567061b.getSecondaryMenu().setLayerType(this.f567060a, null);
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
        this.f567061b = r100;
        this.f567060a = r101;
    }
}
