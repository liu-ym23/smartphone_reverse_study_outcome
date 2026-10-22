package mh5;

import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes18.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a<T> f513956a = null;

    static {
        f513956a = new a();
    }

    public a() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        String r101 = (String) r100;
        Set r102 = (Set) e.f513960a.a("cache_new_document", new LinkedHashSet());
        if (hu5.a.f(r102) == false) goto L8;
        Iterator r103 = r102.iterator();
    L6:
        if (r103.hasNext() == false) goto L10;
        String r104 = (String) r103.next();
        e.f513962c.put(r104, Boolean.TRUE);
        goto L6
    L10:
        return;
    }
}
