package s00;

import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes45.dex */
public abstract class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f540005a;

    public a() {
    }

    public abstract Disposable a();

    @Override // s00.c
    public final void run() {
        this.f540005a = a();
    }
}
