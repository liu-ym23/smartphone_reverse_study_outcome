package j83;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: classes13.dex */
public final class h<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f497702a;

    public h(a r100) {
        this.f497702a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        this.f497702a.g();
    }
}
