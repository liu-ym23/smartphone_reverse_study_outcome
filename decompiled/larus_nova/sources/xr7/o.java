package xr7;

import com.cronutils.model.field.CronField;
import com.cronutils.model.field.expression.FieldExpression;
import com.cronutils.model.field.expression.On;
import com.cronutils.model.time.generator.NoSuchValueException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public final class o extends i {
    public o(CronField r100) {
        super(r100);
    }

    @Override // xr7.i
    public final int c(int r100) throws NoSuchValueException {
        int r101 = ((On) this.f564873a.getExpression()).getTime().getValue().intValue();
        if (r101 <= r100) goto L6;
        return r101;
    L6:
        throw new NoSuchValueException();
    }

    @Override // xr7.i
    public final boolean d(int r100) {
        if (((On) this.f564873a.getExpression()).getTime().getValue().intValue() != r100) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // xr7.i
    public final boolean e(FieldExpression r100) {
        return r100 instanceof On;
    }

    @Override // xr7.i
    public final List<Integer> b(int r100, int r101) {
        ArrayList r102 = new ArrayList();
        int r103 = ((On) this.f564873a.getExpression()).getTime().getValue().intValue();
        if (r103 <= r100) goto L6;
        if (r103 >= r101) goto L6;
        r102.add(Integer.valueOf(r103));
    L6:
        return r102;
    }
}
