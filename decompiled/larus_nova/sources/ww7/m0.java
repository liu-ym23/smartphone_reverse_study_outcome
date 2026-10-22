package ww7;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes23.dex */
public final class m0<TResult> implements y<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f561679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z<TResult> f561680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f561681c;

    @Override // ww7.y
    public final void a(e r100) {
        this.f561679a.execute(new l0(this, r100));
    }

    public m0(Executor r100, f r101) {
        this.f561681c = new Object();
        this.f561680b = r101;
        this.f561679a = r100;
    }
}
