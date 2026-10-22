package xr7;

import com.cronutils.model.field.CronField;
import com.cronutils.model.field.CronFieldName;
import com.cronutils.model.field.expression.Always;
import com.cronutils.model.field.expression.FieldExpression;
import com.cronutils.model.time.generator.NoSuchValueException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public final class a extends i {
    public a(CronField r100) {
        super(r100);
    }

    @Override // xr7.i
    public final int c(int r100) throws NoSuchValueException {
        int r101 = r100 + 1;
        if (r101 > this.f564873a.getConstraints().getEndRange()) goto L6;
        return r101;
    L6:
        throw new NoSuchValueException();
    }

    @Override // xr7.i
    public final boolean d(int r100) {
        if (this.f564873a.getField() != CronFieldName.DAY_OF_WEEK) goto L5;
    L8:
        return true;
    L5:
        if (this.f564873a.getConstraints().isInRange(r100) == true) goto L8;
        return false;
    }

    @Override // xr7.i
    public final boolean e(FieldExpression r100) {
        return r100 instanceof Always;
    }

    @Override // xr7.i
    public final List<Integer> b(int r100, int r101) {
        ArrayList r102 = new ArrayList();
    L3:
        r100 = r100 + 1;
        if (r100 >= r101) goto L6;
        r102.add(Integer.valueOf(r100));
        goto L3
    L6:
        return r102;
    }
}
