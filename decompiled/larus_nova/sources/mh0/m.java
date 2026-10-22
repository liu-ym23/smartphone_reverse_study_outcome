package mh0;

import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: classes46.dex */
public final class m<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f513838a;

    public m(p r100) {
        this.f513838a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        List<? extends tf0.e> r101 = (List) r100;
        this.f513838a.k(r101);
        this.f513838a.l(r101);
        this.f513838a.j(r101);
    }
}
