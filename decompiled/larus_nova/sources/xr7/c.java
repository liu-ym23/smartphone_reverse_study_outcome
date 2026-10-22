package xr7;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.cronutils.model.field.CronField;
import com.cronutils.model.field.expression.Always;
import com.cronutils.model.field.expression.And;
import com.cronutils.model.field.expression.Between;
import com.cronutils.model.field.expression.Every;
import com.cronutils.model.field.expression.FieldExpression;
import com.cronutils.model.field.expression.On;
import com.cronutils.model.time.generator.NoSuchValueException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public final class c extends i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final xwc.c f564861b = null;

    static {
        f564861b = xwc.e.b(c.class);
    }

    public c(CronField r100) {
        super(r100);
    }

    public static i f(CronField r100) {
        FieldExpression r101 = r100.getExpression();
        if ((r101 instanceof Always) == false) goto L7;
        return new a(r100);
    L7:
        if ((r101 instanceof Between) == false) goto L11;
        return new f(r100);
    L11:
        if ((r101 instanceof Every) == false) goto L15;
        return new h(r100);
    L15:
        if ((r101 instanceof On) == false) goto L19;
        return new o(r100);
    L19:
        throw new IllegalArgumentException(String.format("FieldExpression %s not supported!", new Object[]{r101.getClass()}));
    }

    @Override // xr7.i
    public final int c(int r100) throws NoSuchValueException {
        And r101 = (And) this.f564873a.getExpression();
        ArrayList r102 = new ArrayList();
        Iterator<FieldExpression> r103 = r101.getExpressions().iterator();
    L4:
        if (r103.hasNext() == false) goto L10;
        FieldExpression r104 = r103.next();
        int r105 = Integer.valueOf(f(new CronField(this.f564873a.getField(), r104, this.f564873a.getConstraints())).c(r100));     // Catch: NoSuchValueException -> L8
    L9:
        r102.add(r105);
    L8:
        r105 = Integer.MIN_VALUE;
        goto L9
    L10:
        ArrayList r106 = new ArrayList();
        Iterator r107 = r102.iterator();
    L12:
        if (r107.hasNext() == false) goto L16;
        Integer r108 = (Integer) r107.next();
        if (r108.intValue() < 0) goto L12;
        r106.add(r108);
        goto L12
    L16:
        Collections.sort(r106);
        if (r106.isEmpty() == true) goto L21;
        return ((Integer) ListProtector.get(r106, 0)).intValue();
    L21:
        throw new NoSuchValueException();
    }

    @Override // xr7.i
    public final boolean d(int r100) {
        Iterator<FieldExpression> r101 = ((And) this.f564873a.getExpression()).getExpressions().iterator();
    L3:
        boolean r102 = false;
    L5:
        if (r101.hasNext() == false) goto L11;
        FieldExpression r103 = r101.next();
        if (r102 == true) goto L10;
        if (f(new CronField(this.f564873a.getField(), r103, this.f564873a.getConstraints())).d(r100) == false) goto L3;
    L10:
        r102 = true;
        goto L5
    L11:
        return r102;
    }

    @Override // xr7.i
    public final boolean e(FieldExpression r100) {
        return r100 instanceof And;
    }

    @Override // xr7.i
    public final List<Integer> b(int r100, int r101) {
        ArrayList r102 = new ArrayList();
        int r103 = c(r100);     // Catch: NoSuchValueException -> L7
    L4:
        if (r103 >= r101) goto L9;
        r102.add(Integer.valueOf(r103));     // Catch: NoSuchValueException -> L7
        r103 = c(r103);     // Catch: NoSuchValueException -> L7
    L9:
        return r102;
    L7:
        e = move-exception;
        f564861b.debug("Catched expected exception while generating candidates", e);
        goto L9
    }
}
