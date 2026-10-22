package fv5;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.ruler.base.models.ExprException;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.List;
import kotlin.TypeCastException;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends v97.e {
    public d() {
        super(HiAnalyticsConstant.REPORT_VAL_SEPARATOR, 200, 2);
    }

    @Override // v97.e
    public final Object a(List<? extends Object> r100) {
        c(r100, true);
        if ((ListProtector.get(r100, 0) instanceof Integer) == false) goto L17;
        if ((ListProtector.get(r100, 1) instanceof Integer) == false) goto L17;
        Object r101 = ListProtector.get(r100, 0);
        if (r101 == null) goto L15;
        int r102 = ((Integer) r101).intValue();
        Object r103 = ListProtector.get(r100, 1);
        if (r103 == null) goto L13;
        return Integer.valueOf(((Integer) r103).intValue() | r102);
    L13:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
    L15:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
    L17:
        if ((ListProtector.get(r100, 0) instanceof Long) == false) goto L31;
        if ((ListProtector.get(r100, 1) instanceof Long) == false) goto L31;
        Object r104 = ListProtector.get(r100, 0);
        if (r104 == null) goto L29;
        long r105 = ((Long) r104).longValue();
        Object r106 = ListProtector.get(r100, 1);
        if (r106 == null) goto L27;
        return Long.valueOf(((Long) r106).longValue() | r105);
    L27:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Long");
    L29:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Long");
    L31:
        if ((ListProtector.get(r100, 0) instanceof Boolean) == false) goto L45;
        if ((ListProtector.get(r100, 1) instanceof Boolean) == false) goto L45;
        Object r107 = ListProtector.get(r100, 0);
        if (r107 == null) goto L43;
        boolean r108 = ((Boolean) r107).booleanValue();
        Object r109 = ListProtector.get(r100, 1);
        if (r109 == null) goto L41;
        return Boolean.valueOf(((Boolean) r109).booleanValue() | r108);
    L41:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Boolean");
    L43:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Boolean");
    L45:
        throw new ExprException(101, "not support");
    }
}
