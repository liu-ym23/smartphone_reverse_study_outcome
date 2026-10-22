package ev5;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.ruler.base.models.ExprException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.TypeCastException;

/* JADX INFO: loaded from: classes3.dex */
public final class r extends v97.a {
    public r() {
        super("upcase");
    }

    @Override // v97.b
    public final Object a(List<? extends Object> r100) {
        if (((ArrayList) r100).size() != 1) goto L13;
        if ((ListProtector.get(r100, 0) instanceof String) == false) goto L13;
        Object r101 = ListProtector.get(r100, 0);
        if (r101 == null) goto L11;
        return ((String) r101).toUpperCase(Locale.US);
    L11:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
    L13:
        throw new ExprException(105, "params error");
    }
}
