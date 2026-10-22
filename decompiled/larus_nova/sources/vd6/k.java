package vd6;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.lark.express.exception.ExprException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
public final class k extends o {
    public k() {
        super(GXTemplateKey.GAIAX_PE, 700, 2);
    }

    @Override // vd6.o
    public final Object a(List<? extends Object> r110) {
        c(r110, true);
        Intrinsics.checkNotNull(r110);
        if ((ListProtector.get(r110, 0) instanceof sd6.e) == true) goto L18;
        if ((ListProtector.get(r110, 1) instanceof sd6.e) == true) goto L18;
        if (Intrinsics.areEqual(b(r110), "param_type_number") == false) goto L16;
        Object r100 = ListProtector.get(r110, 1);
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlin.Number");
        if (((Number) r100).longValue() == 0) goto L14;
        Object r101 = ListProtector.get(r110, 0);
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Number");
        long r102 = ((Number) r101).longValue();
        Object r111 = ListProtector.get(r110, 1);
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type kotlin.Number");
        return Long.valueOf(r102 % ((Number) r111).longValue());
    L14:
        throw new ExprException(101, "divisor shouldn't be zero");
    L16:
        throw new ExprException(101, "not support");
    L18:
        return new sd6.e(0);
    }
}
