package vd6;

import com.bytedance.lark.express.exception.ExprException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
public final class h extends o {
    public h() {
        super("in", 700, 2);
    }

    @Override // vd6.o
    public final Object a(List<? extends Object> r100) {
        c(r100, false);
        Intrinsics.checkNotNull(r100);
        if ((ListProtector.get(r100, 0) instanceof sd6.e) == true) goto L34;
        if ((ListProtector.get(r100, 1) instanceof sd6.e) == true) goto L34;
        Object r101 = ListProtector.get(r100, 1);
        if ((r101 instanceof Collection) == false) goto L32;
        if ((ListProtector.get(r100, 0) instanceof sd6.f) == false) goto L19;
        Iterator r102 = ((Iterable) r101).iterator();
    L13:
        if (r102.hasNext() == false) goto L19;
        if ((r102.next() instanceof sd6.f) == false) goto L13;
        return Boolean.TRUE;
    L19:
        if (((Collection) r101).contains(ListProtector.get(r100, 0)) == true) goto L21;
        Iterator r103 = ((Iterable) r101).iterator();
    L24:
        if (r103.hasNext() == false) goto L30;
        if ((r103.next() instanceof sd6.e) == false) goto L24;
        return new sd6.e(0);
    L30:
        return Boolean.FALSE;
    L21:
        return Boolean.TRUE;
    L32:
        throw new ExprException(101, "not support");
    L34:
        return new sd6.e(0);
    }
}
