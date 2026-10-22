package ud6;

import com.bytedance.lark.express.exception.ExprException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
public final class f extends b {
    public f() {
        super("SecondsFromNow");
    }

    @Override // ud6.b
    public final Object a(List<? extends Object> r100) {
        if (((ArrayList) r100).size() != 1) goto L15;
        if ((ListProtector.get(r100, 0) instanceof sd6.e) == false) goto L9;
        return new sd6.e(0);
    L9:
        if ((ListProtector.get(r100, 0) instanceof Number) == false) goto L13;
        Object r101 = ListProtector.get(r100, 0);
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Long");
        long r102 = ((Long) r101).longValue();
        return Long.valueOf((System.currentTimeMillis() / ((long) 1000)) - r102);
    L13:
        throw new ExprException(101, "param type must be int");
    L15:
        throw new ExprException(105, "params error");
    }
}
