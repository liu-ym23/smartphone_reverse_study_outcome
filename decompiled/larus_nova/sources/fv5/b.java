package fv5;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.ruler.base.models.ExprException;
import java.util.List;
import kotlin.TypeCastException;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends v97.e {
    public b() {
        super("&&", 200, 2);
    }

    @Override // v97.e
    public final Object a(List<? extends Object> r100) {
        boolean r101 = true;
        c(r100, true);
        if ((ListProtector.get(r100, 0) instanceof Boolean) == false) goto L23;
        if ((ListProtector.get(r100, 1) instanceof Boolean) == false) goto L23;
        Object r102 = ListProtector.get(r100, 0);
        if (r102 == null) goto L21;
        if (((Boolean) r102).booleanValue() == false) goto L17;
        Object r103 = ListProtector.get(r100, 1);
        if (r103 == null) goto L16;
        if (((Boolean) r103).booleanValue() == false) goto L17;
    L19:
        return Boolean.valueOf(r101);
    L16:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Boolean");
    L17:
        r101 = false;
        goto L19
    L21:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Boolean");
    L23:
        throw new ExprException(101, "params invalid");
    }
}
