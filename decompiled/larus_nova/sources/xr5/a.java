package xr5;

import android.view.View;
import android.view.ViewGroup;
import rxb.d;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f564856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final cs5.a f564857b;

    @Override // rxb.d
    public final void destroy() {
    }

    @Override // rxb.d
    public final String viewId() {
        return this.f564856a;
    }

    @Override // rxb.d
    public final View a(ViewGroup r100) {
        return (View) this.f564857b;
    }

    @Override // rxb.d
    public final View b(String r100) {
        return (View) this.f564857b;
    }

    public a(String r100, cs5.a r101) {
        this.f564856a = r100;
        this.f564857b = r101;
    }
}
