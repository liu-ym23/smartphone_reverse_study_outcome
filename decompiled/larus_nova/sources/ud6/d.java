package ud6;

import com.bytedance.lark.express.exception.ExprException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public final class d extends b {
    public d() {
        super("IsExisted");
    }

    @Override // ud6.b
    public final Object a(List<? extends Object> r100) {
        if (((ArrayList) r100).size() != 1) goto L7;
        return Boolean.valueOf(!(ListProtector.get(r100, 0) instanceof sd6.e));
    L7:
        throw new ExprException(105, "params error");
    }
}
