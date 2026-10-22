package vt0;

import android.view.View;

/* JADX INFO: loaded from: classes47.dex */
public abstract class b implements View.OnClickListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f557183b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f557184c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f557185a;

    public abstract void a(View r100);

    /* JADX WARN: Type inference failed for: r0v0, types: [vt0.a] */
    static {
        f557184c = new a();
    }

    public b() {
        this.f557185a = 500;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (f557183b == false) goto L6;
        f557183b = false;
        r100.postDelayed(f557184c, this.f557185a);
        a(r100);
        return;
    }
}
