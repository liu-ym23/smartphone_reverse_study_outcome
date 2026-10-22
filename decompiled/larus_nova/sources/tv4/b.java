package tv4;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: classes16.dex */
public final class b<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f547694a;

    public b(a r100) {
        this.f547694a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        int r101 = ((Number) r100).intValue();
        this.f547694a.b(r101);
    }
}
