package nuc;

import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public abstract class w<E, C extends Collection<? extends E>, B> extends v<E, C, B> {
    public w(juc.d<E> r100) {
        Intrinsics.checkNotNullParameter(r100, "element");
        super(r100);
    }

    @Override // nuc.a
    public final Iterator d(Object r100) {
        Collection r101 = (Collection) r100;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        return r101.iterator();
    }

    @Override // nuc.a
    public final int e(Object r100) {
        Collection r101 = (Collection) r100;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        return r101.size();
    }
}
