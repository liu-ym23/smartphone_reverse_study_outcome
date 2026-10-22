package ev5;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.ruler.base.models.ExprException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends v97.a {
    public l() {
        super("isNull");
    }

    @Override // v97.b
    public final Object a(List r100) {
        if (((ArrayList) r100).size() != 1) goto L10;
        if (ListProtector.get(r100, 0) != null) goto L8;
        return Boolean.TRUE;
    L8:
        return Boolean.FALSE;
    L10:
        throw new ExprException(105, "params error");
    }
}
