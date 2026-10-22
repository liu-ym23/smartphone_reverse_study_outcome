package vd6;

import com.bytedance.lark.express.exception.ExprException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
public final class n extends o {
    public n() {
        super("!", 600, 1);
    }

    @Override // vd6.o
    public final Object a(List<? extends Object> r100) {
        c(r100, true);
        Intrinsics.checkNotNull(r100);
        if ((ListProtector.get(r100, 0) instanceof sd6.e) == true) goto L5;
        Object r101 = ListProtector.get(r100, 0);
        if ((r101 instanceof Boolean) == false) goto L11;
        return Boolean.valueOf(!((Boolean) r101).booleanValue());
    L11:
        throw new ExprException(101, "params invalid");
    L5:
        return new sd6.e(0);
    }
}
