package wx1;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ hw.a f561758a;

    public c(hw.a r100) {
        this.f561758a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        hw.a r102 = this.f561758a;
        if (r102 == null) goto L6;
        r102.onCancel(new Throwable("login fail"));
        return;
    }
}
