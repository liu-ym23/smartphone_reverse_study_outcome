package f7a;

import android.view.Choreographer;

/* JADX INFO: loaded from: classes32.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f475802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f475803b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f475804c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f475805d;

    public abstract boolean a(int r100);

    public final void b() {
        if (this.f475805d == null) goto L6;
        Choreographer.getInstance().removeFrameCallback(this.f475805d);
        this.f475805d = null;
        return;
    }

    public c() {
        this.f475802a = false;
        this.f475803b = 0;
        this.f475804c = true;
        this.f475805d = null;
    }
}
