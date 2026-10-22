package fv5;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.ruler.base.models.ExprException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes3.dex */
public final class q extends v97.e {
    public q() {
        super("matches", 800, 2);
    }

    @Override // v97.e
    public final Object a(List<? extends Object> r100) {
        c(r100, true);
        Object r101 = ListProtector.get(r100, 0);
        Object r102 = ListProtector.get(r100, 1);
        if ((r101 instanceof String) == false) goto L24;
        if ((r102 instanceof Collection) == false) goto L18;
        Iterator r103 = ((Iterable) r102).iterator();
    L8:
        if (r103.hasNext() == false) goto L16;
        Object r104 = r103.next();
        if (r104 == null) goto L8;
        Regex r105 = new Regex(r104.toString());
        if (r105.matches((CharSequence) r101) == false) goto L8;
        return Boolean.TRUE;
    L16:
        return Boolean.FALSE;
    L18:
        if ((r102 instanceof String) == false) goto L22;
        Regex r106 = new Regex((String) r102);
        return Boolean.valueOf(r106.matches((CharSequence) r101));
    L22:
        throw new ExprException(101, "params invalid");
    L24:
        throw new ExprException(101, "params invalid");
    }
}
