package ud1;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f549730a;

    public c(a r100) {
        this.f549730a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        wd1.a r102 = this.f549730a.f549723a;
        if (r102 == null) goto L6;
        r102.y0(null, (Exception) r101);
        return;
    }
}
