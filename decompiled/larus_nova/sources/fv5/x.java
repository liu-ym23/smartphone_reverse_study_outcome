package fv5;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.ruler.base.models.ExprException;
import java.util.List;
import kotlin.TypeCastException;

/* JADX INFO: loaded from: classes3.dex */
public final class x extends v97.e {
    public x() {
        super("||", 200, 2);
    }

    @Override // v97.e
    public final Object a(List<? extends Object> r100) {
        boolean r101 = true;
        c(r100, true);
        if ((ListProtector.get(r100, 0) instanceof Boolean) == false) goto L23;
        if ((ListProtector.get(r100, 1) instanceof Boolean) == false) goto L23;
        Object r102 = ListProtector.get(r100, 0);
        if (r102 == null) goto L21;
        if (((Boolean) r102).booleanValue() == true) goto L19;
        Object r103 = ListProtector.get(r100, 1);
        if (r103 == null) goto L17;
        if (((Boolean) r103).booleanValue() == true) goto L19;
        r101 = false;
        goto L19
    L17:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Boolean");
    L19:
        return Boolean.valueOf(r101);
    L21:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Boolean");
    L23:
        throw new ExprException(101, "params invalid");
    }
}
