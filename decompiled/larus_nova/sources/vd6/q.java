package vd6;

import com.bytedance.lark.express.exception.ExprException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
public final class q extends o {
    public q() {
        super("||", 200, 2);
    }

    @Override // vd6.o
    public final Object a(List<? extends Object> r100) {
        boolean r101 = true;
        c(r100, true);
        Intrinsics.checkNotNull(r100);
        if ((ListProtector.get(r100, 0) instanceof sd6.e) == false) goto L10;
        Object r102 = ListProtector.get(r100, 1);
        Boolean r103 = Boolean.TRUE;
        if (Intrinsics.areEqual(r102, r103) == false) goto L8;
        return r103;
    L8:
        return new sd6.e(0);
    L10:
        if ((ListProtector.get(r100, 1) instanceof sd6.e) == false) goto L17;
        Object r104 = ListProtector.get(r100, 0);
        Boolean r105 = Boolean.TRUE;
        if (Intrinsics.areEqual(r104, r105) == false) goto L15;
        return r105;
    L15:
        return new sd6.e(0);
    L17:
        if ((ListProtector.get(r100, 0) instanceof Boolean) == false) goto L29;
        if ((ListProtector.get(r100, 1) instanceof Boolean) == false) goto L29;
        Object r106 = ListProtector.get(r100, 0);
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type kotlin.Boolean");
        if (((Boolean) r106).booleanValue() == true) goto L27;
        Object r107 = ListProtector.get(r100, 1);
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type kotlin.Boolean");
        if (((Boolean) r107).booleanValue() == true) goto L27;
        r101 = false;
    L27:
        return Boolean.valueOf(r101);
    L29:
        throw new ExprException(101, "params invalid");
    }
}
