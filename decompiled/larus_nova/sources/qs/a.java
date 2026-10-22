package qs;

import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f534634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f534635b;

    /* JADX INFO: renamed from: qs.a$a, reason: collision with other inner class name */
    public static final class C7385a {
    }

    static {
    }

    public a() {
    }

    @Override // qs.f
    public final void a() {
    }

    @Override // qs.f
    public final void cancel() {
        Disposable r100 = this.f534634a;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        Disposable r101 = this.f534635b;
        if (r101 == null) goto L9;
        r101.dispose();
        return;
    }
}
