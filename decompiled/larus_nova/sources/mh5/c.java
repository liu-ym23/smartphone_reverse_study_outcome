package mh5;

import io.reactivex.functions.Consumer;
import java.util.Set;

/* JADX INFO: loaded from: classes18.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Set<String> f513958a;

    public c(Set<String> r100) {
        this.f513958a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        String r101 = (String) r100;
        if (hu5.a.f(this.f513958a) == false) goto L6;
        e.f513960a.b("cache_new_document", this.f513958a);
        return;
    }
}
