package fm3;

import android.view.View;

/* JADX INFO: loaded from: classes14.dex */
public abstract class b implements View.OnClickListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f477806b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f477807c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f477808a;

    public abstract void a(View r100);

    /* JADX WARN: Type inference failed for: r0v0, types: [fm3.a] */
    static {
        f477807c = new a();
    }

    public b(int r100) {
        this.f477808a = 500;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (f477806b == false) goto L6;
        f477806b = false;
        r100.postDelayed(f477807c, this.f477808a);
        a(r100);
        return;
    }
}
