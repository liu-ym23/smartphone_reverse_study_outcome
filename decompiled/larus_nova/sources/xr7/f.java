package xr7;

import com.cronutils.model.field.CronField;
import com.cronutils.model.field.expression.Between;
import com.cronutils.model.field.expression.FieldExpression;
import com.cronutils.model.field.value.FieldValue;
import com.cronutils.model.field.value.IntegerFieldValue;
import com.cronutils.model.time.generator.NoSuchValueException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public final class f extends i {
    public f(CronField r100) {
        super(r100);
    }

    public static int f(FieldValue<?> r100) {
        if ((r100 instanceof IntegerFieldValue) == false) goto L7;
        return ((IntegerFieldValue) r100).getValue().intValue();
    L7:
        throw new IllegalArgumentException("Non integer values at intervals are not fully supported yet.");
    }

    @Override // xr7.i
    public final int c(int r100) throws NoSuchValueException {
        Between r101 = (Between) this.f564873a.getExpression();
    L3:
        r100 = r100 + 1;
        if (r100 < f(r101.getFrom())) goto L3;
        if (r100 > f(r101.getTo())) goto L9;
        return r100;
    L9:
        throw new NoSuchValueException();
    }

    @Override // xr7.i
    public final boolean d(int r100) {
        Between r101 = (Between) this.f564873a.getExpression();
        if (r100 >= f(r101.getFrom())) goto L5;
    L7:
        return false;
    L5:
        if (r100 > f(r101.getTo())) goto L7;
        return true;
    }

    @Override // xr7.i
    public final boolean e(FieldExpression r100) {
        return r100 instanceof Between;
    }

    @Override // xr7.i
    public final List<Integer> b(int r100, int r101) {
        ArrayList r102 = new ArrayList();
        Between r103 = (Between) this.f564873a.getExpression();
        int r104 = f(r103.getFrom());
        int r105 = f(r103.getTo());
        if (r100 > r105) goto L19;
        if (r104 > r101) goto L19;
        if (r105 < r101) goto L9;
        r105 = r101;
    L9:
        if (f(r103.getFrom()) > r100) goto L12;
        r104 = r100;
    L12:
        if (r104 != r100) goto L21;
    L14:
        int r106 = c(r104);     // Catch: NoSuchValueException -> L20
    L15:
        if (r106 >= r105) goto L17;
        r102.add(Integer.valueOf(r106));     // Catch: NoSuchValueException -> L20
        r106 = c(r106);     // Catch: NoSuchValueException -> L20
        goto L15
    L17:
        if (r105 == r101) goto L19;
        r102.add(Integer.valueOf(r106));     // Catch: NoSuchValueException -> L20
        goto L19
    L21:
        r102.add(Integer.valueOf(r104));     // Catch: NoSuchValueException -> L20
    L19:
        return r102;
    }
}
