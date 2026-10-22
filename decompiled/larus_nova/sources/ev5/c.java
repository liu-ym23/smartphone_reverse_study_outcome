package ev5;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.ruler.base.models.ExprException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.TypeCastException;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends v97.a {
    public c() {
        super("dot");
    }

    @Override // v97.b
    public final Object a(List<? extends Object> r100) {
        if (((ArrayList) r100).size() != 2) goto L17;
        Object r101 = ListProtector.get(r100, 0);
        if ((r101 instanceof Map) == true) goto L7;
        r101 = null;
    L7:
        Map r102 = (Map) r101;
        if (r102 == null) goto L15;
        Object r103 = ListProtector.get(r100, 1);
        if (r103 == null) goto L14;
        return r102.get((String) r103);
    L14:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
    L15:
        return null;
    L17:
        throw new ExprException(101, "");
    }
}
