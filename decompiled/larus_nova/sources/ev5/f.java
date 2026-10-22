package ev5;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.ruler.base.models.ExprException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends v97.a {
    public f() {
        super("indexOf");
    }

    @Override // v97.b
    public final Object a(List<? extends Object> r100) {
        if (((ArrayList) r100).size() != 2) goto L23;
        if ((ListProtector.get(r100, 0) instanceof Collection) == false) goto L23;
        Object r101 = ListProtector.get(r100, 0);
        if ((r101 instanceof Collection) == true) goto L9;
        r101 = null;
    L9:
        Collection r102 = (Collection) r101;
        if (r102 == null) goto L21;
        Object r103 = ListProtector.get(r100, 1);
        if ((r103 instanceof Number) == false) goto L14;
        int r104 = ((Number) r103).intValue();
    L15:
        if (r104 < 0) goto L21;
        if (r104 >= r102.size()) goto L21;
        return CollectionsKt.elementAt(r102, r104);
    L14:
        r104 = -1;
    L21:
        return null;
    L23:
        throw new ExprException(101, "");
    }
}
