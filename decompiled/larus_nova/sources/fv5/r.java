package fv5;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.ruler.base.models.ExprException;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class r extends v97.e {
    public r() {
        super(GXTemplateKey.GAIAX_PE, 700, 2);
    }

    @Override // v97.e
    public final Object a(List<? extends Object> r100) {
        c(r100, true);
        if (Intrinsics.areEqual(b(r100), "param_type_number") == false) goto L15;
        Object r101 = ListProtector.get(r100, 0);
        if (r101 == null) goto L13;
        long r102 = ((Number) r101).longValue();
        Object r103 = ListProtector.get(r100, 1);
        if (r103 == null) goto L11;
        return Long.valueOf(r102 % ((Number) r103).longValue());
    L11:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Number");
    L13:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Number");
    L15:
        throw new ExprException(101, "not support");
    }
}
