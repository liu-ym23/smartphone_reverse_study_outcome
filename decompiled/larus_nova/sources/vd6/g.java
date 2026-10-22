package vd6;

import com.bytedance.lark.express.exception.ExprException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
public final class g extends o {
    public g() {
        super("hasIn", 700, 2);
    }

    @Override // vd6.o
    public final Object a(List<? extends Object> r100) {
        c(r100, false);
        Intrinsics.checkNotNull(r100);
        if ((ListProtector.get(r100, 0) instanceof sd6.e) == true) goto L61;
        if ((ListProtector.get(r100, 1) instanceof sd6.e) == true) goto L61;
        Object r101 = ListProtector.get(r100, 1);
        if ((r101 instanceof Collection) == false) goto L59;
        Object r102 = ListProtector.get(r100, 0);
        if ((r102 instanceof Collection) == false) goto L37;
        Collection r103 = (Collection) r102;
        Iterator r104 = r103.iterator();
    L13:
        if (r104.hasNext() == false) goto L20;
        Object r105 = r104.next();
        if ((r105 instanceof sd6.e) == true) goto L13;
        if (((Collection) r101).contains(r105) == false) goto L13;
        return Boolean.TRUE;
    L20:
        Iterator r106 = ((Collection) r101).iterator();
    L22:
        if (r106.hasNext() == false) goto L27;
        if ((r106.next() instanceof sd6.e) == false) goto L22;
        return new sd6.e(0);
    L27:
        Iterator r107 = r103.iterator();
    L29:
        if (r107.hasNext() == false) goto L35;
        if ((r107.next() instanceof sd6.e) == false) goto L29;
        return new sd6.e(0);
    L35:
        return Boolean.FALSE;
    L37:
        if ((ListProtector.get(r100, 0) instanceof sd6.f) == false) goto L46;
        Iterator r108 = ((Iterable) r101).iterator();
    L40:
        if (r108.hasNext() == false) goto L46;
        if ((r108.next() instanceof sd6.f) == false) goto L40;
        return Boolean.TRUE;
    L46:
        if (((Collection) r101).contains(ListProtector.get(r100, 0)) == true) goto L48;
        Iterator r109 = ((Iterable) r101).iterator();
    L51:
        if (r109.hasNext() == false) goto L57;
        if ((r109.next() instanceof sd6.e) == false) goto L51;
        return new sd6.e(0);
    L57:
        return Boolean.FALSE;
    L48:
        return Boolean.TRUE;
    L59:
        throw new ExprException(101, "not support");
    L61:
        return new sd6.e(0);
    }
}
