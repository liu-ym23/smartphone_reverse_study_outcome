package xr7;

import com.cronutils.model.field.CronField;
import com.cronutils.model.field.expression.FieldExpression;
import com.cronutils.model.time.generator.NoSuchValueException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public final class k extends i {
    @Override // xr7.i
    public final boolean d(int r100) {
        return false;
    }

    @Override // xr7.i
    public final boolean e(FieldExpression r100) {
        return true;
    }

    public k(CronField r100) {
        super(r100);
    }

    @Override // xr7.i
    public final int c(int r100) throws NoSuchValueException {
        throw new NoSuchValueException();
    }

    @Override // xr7.i
    public final List<Integer> b(int r100, int r101) {
        return new ArrayList();
    }
}
