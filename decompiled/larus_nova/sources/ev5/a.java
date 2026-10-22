package ev5;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.TypeCastException;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends v97.a {
    public a() {
        super("add");
    }

    @Override // v97.b
    public final Object a(List<? extends Object> r100) {
        if ((ListProtector.get(r100, 0) instanceof Integer) == false) goto L17;
        if ((ListProtector.get(r100, 1) instanceof Integer) == false) goto L17;
        Object r101 = ListProtector.get(r100, 0);
        if (r101 == null) goto L15;
        int r102 = ((Integer) r101).intValue();
        Object r103 = ListProtector.get(r100, 1);
        if (r103 == null) goto L13;
        return Integer.valueOf(r102 + ((Integer) r103).intValue());
    L13:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
    L15:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
    L17:
        return String.valueOf(ListProtector.get(r100, 0)).concat(String.valueOf(ListProtector.get(r100, 1)));
    }
}
