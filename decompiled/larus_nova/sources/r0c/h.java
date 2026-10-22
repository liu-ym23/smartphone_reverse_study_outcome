package r0c;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

/* JADX INFO: loaded from: classes37.dex */
public final class h implements LifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Lifecycle f535524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k f535525b;

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        this.f535525b.c();
        this.f535524a.removeObserver(this);
    }

    public h(k r100, Lifecycle r101) {
        this.f535525b = r100;
        this.f535524a = r101;
    }
}
