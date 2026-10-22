package ev5;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.ruler.base.models.ExprException;
import java.util.ArrayList;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.random.Random;
import kotlin.random.RandomKt;

/* JADX INFO: loaded from: classes3.dex */
public final class m extends v97.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Random f474257b;

    public m() {
        super("is_sample_rate");
    }

    @Override // v97.b
    public final Object a(List<? extends Object> r100) {
        boolean r101 = true;
        if (((ArrayList) r100).size() != 1) goto L24;
        if ((ListProtector.get(r100, 0) instanceof Double) == false) goto L24;
        if (this.f474257b != null) goto L9;
        this.f474257b = RandomKt.Random(System.currentTimeMillis());
    L9:
        Random r102 = this.f474257b;
        if (r102 == null) goto L22;
        double r103 = r102.nextDouble();
        Object r104 = ListProtector.get(r100, 0);
        if (r104 == null) goto L20;
        if (r103 < ((Double) r104).doubleValue()) goto L18;
        r101 = false;
    L18:
        return Boolean.valueOf(r101);
    L20:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Double");
    L22:
        return Boolean.FALSE;
    L24:
        throw new ExprException(105, "params error");
    }
}
