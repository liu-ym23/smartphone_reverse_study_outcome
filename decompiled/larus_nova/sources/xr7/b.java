package xr7;

import com.cronutils.mapper.WeekDay;
import com.cronutils.model.field.CronField;
import com.cronutils.model.field.CronFieldName;
import com.cronutils.model.field.expression.And;
import com.cronutils.model.field.expression.FieldExpression;
import com.cronutils.model.time.generator.NoSuchValueException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public final class b extends i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f564858b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f564859c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WeekDay f564860d;

    @Override // xr7.i
    public final int c(int r100) throws NoSuchValueException {
        return 0;
    }

    @Override // xr7.i
    public final boolean d(int r100) {
        return false;
    }

    @Override // xr7.i
    public final boolean e(FieldExpression r100) {
        return r100 instanceof And;
    }

    @Override // xr7.i
    public final List<Integer> b(int r100, int r101) {
        ArrayList r102 = new ArrayList();
        Iterator<FieldExpression> r103 = ((And) this.f564873a.getExpression()).getExpressions().iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        FieldExpression r104 = r103.next();
        List<Integer> r105 = j.b(new CronField(CronFieldName.DAY_OF_WEEK, r104, this.f564873a.getConstraints()), this.f564858b, this.f564859c, this.f564860d).a(r100, r101);
        if (r105 == null) goto L4;
        r102.addAll(r105);
        goto L4
    L8:
        return r102;
    }

    public b(CronField r100, int r101, int r102, WeekDay r103) {
        super(r100);
        zr7.a.a(CronFieldName.DAY_OF_WEEK.equals(r100.getField()), "CronField does not belong to day of week");
        this.f564858b = r101;
        this.f564859c = r102;
        this.f564860d = r103;
    }
}
