package df1;

import io.reactivex.functions.Consumer;
import zg1.h1;

/* JADX INFO: loaded from: classes7.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f468208a;

    public g(boolean r100) {
        this.f468208a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        if (((h1) r100).f571836a != 7) goto L6;
        e r101 = e.f468206g;
        boolean r102 = this.f468208a;
        r101.getClass();
        e.d(r102, "live_end");
        return;
    }
}
