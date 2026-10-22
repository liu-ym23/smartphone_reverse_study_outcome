package tt3;

import android.app.Activity;
import android.os.Process;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements uu3.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f547543a;

    @Override // uu3.c
    public final void onActivityCreated(Activity r100) {
    }

    @Override // uu3.c
    public final void onActivityPause(Activity r100) {
    }

    @Override // uu3.c
    public final void onActivityResume(Activity r100) {
    }

    @Override // uu3.c
    public final void onActivityStarted(Activity r100) {
    }

    public b(c r100) {
        this.f547543a = r100;
    }

    @Override // uu3.c
    public final void onBackground(Activity r100) {
        this.f547543a.f547547d.edit().putString(du3.a.e(), Process.myPid() + ",false").apply();
    }

    @Override // uu3.c
    public final void onFront(Activity r100) {
        this.f547543a.f547547d.edit().putString(du3.a.e(), Process.myPid() + ",true").apply();
    }
}
