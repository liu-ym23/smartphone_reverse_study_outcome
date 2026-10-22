package ja7;

import android.view.View;
import com.bytedance.scene.State;
import com.bytedance.scene.navigation.NavigationScene;
import com.bytedance.scene.view.NavigationFrameLayout;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes19.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NavigationScene f497891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f497892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f497893c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Runnable f497894d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ i f497895e;

    public final void a() {
        ((NavigationFrameLayout) this.f497891a.f268586d).setTouchEnabled(true);
        if (this.f497892b.f497889b.value >= State.VIEW_CREATED.value) goto L5;
        this.f497895e.f497918a.getOverlay().remove(this.f497893c);
    L5:
        this.f497894d.run();
        this.f497895e.getClass();
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

    public c(i r100, NavigationScene r101, a r102, View r103, com.bytedance.scene.navigation.h r104) {
        this.f497895e = r100;
        this.f497891a = r101;
        this.f497892b = r102;
        this.f497893c = r103;
        this.f497894d = r104;
    }
}
