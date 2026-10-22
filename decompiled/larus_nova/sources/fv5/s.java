package fv5;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.ruler.base.models.ExprException;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class s extends v97.e {
    public s() {
        super("*", 700, 2);
    }

    @Override // v97.e
    public final Object a(List<? extends Object> r100) {
        c(r100, true);
        String r101 = b(r100);
        if (Intrinsics.areEqual(r101, "param_type_double") == false) goto L15;
        Object r102 = ListProtector.get(r100, 0);
        if (r102 == null) goto L13;
        double r103 = ((Number) r102).doubleValue();
        Object r104 = ListProtector.get(r100, 1);
        if (r104 == null) goto L11;
        return Double.valueOf(r103 * ((Number) r104).doubleValue());
    L11:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Number");
    L13:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Number");
    L15:
        if (Intrinsics.areEqual(r101, "param_type_number") == false) goto L27;
        Object r105 = ListProtector.get(r100, 0);
        if (r105 == null) goto L25;
        long r106 = ((Number) r105).longValue();
        Object r107 = ListProtector.get(r100, 1);
        if (r107 == null) goto L23;
        return Long.valueOf(r106 * ((Number) r107).longValue());
    L23:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Number");
    L25:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Number");
    L27:
        throw new ExprException(101, "not support");
    }
}
