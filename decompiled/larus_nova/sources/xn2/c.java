package xn2;

import com.bytedance.android.livesdk.t0;

/* JADX INFO: loaded from: classes11.dex */
public final class c implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f564616b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f564617a;

    @Override // xn2.b
    public final void optimize() {
        this.f564617a.optimize();
    }

    @Override // xn2.b
    public final void reset() {
        this.f564617a.reset();
    }

    static {
        f564616b = new c();
    }

    public c() {
        if (t0.f158503a.getValue().getEnableHeapOpt() == false) goto L5;
        b r100 = new a();
    L6:
        this.f564617a = r100;
        return;
    L5:
        r100 = new d();
        goto L6
    }
}
