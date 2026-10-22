package ja7;

import com.bytedance.scene.navigation.NavigationScene;
import com.bytedance.scene.view.NavigationFrameLayout;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes19.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NavigationScene f497906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Runnable f497907b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ i f497908c;

    @Override // java.lang.Runnable
    public final void run() {
        ((NavigationFrameLayout) this.f497906a.f268586d).setTouchEnabled(true);     // Catch: Throwable -> L4
        this.f497907b.run();     // Catch: Throwable -> L4
        this.f497908c.getClass();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public f(i r100, NavigationScene r101, com.bytedance.scene.navigation.g r102) {
        this.f497908c = r100;
        this.f497906a = r101;
        this.f497907b = r102;
    }
}
