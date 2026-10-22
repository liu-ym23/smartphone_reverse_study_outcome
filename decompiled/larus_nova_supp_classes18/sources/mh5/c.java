package mh5;

import io.reactivex.functions.Consumer;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ Set<String> a;

    public c(Set<String> r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        String r4 = (String) r3;
        if (hu5.a.f(this.a) == false) goto L6;
        e.a.b("cache_new_document", this.a);
        return;
    }
}
