package xr7;

import com.cronutils.model.field.CronField;
import com.cronutils.model.field.expression.Between;
import com.cronutils.model.field.expression.Every;
import com.cronutils.model.field.expression.FieldExpression;
import com.cronutils.model.field.expression.On;
import com.cronutils.model.time.generator.NoSuchValueException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public class h extends i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f564871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f564872c;

    public final int f() {
        FieldExpression r100 = ((Every) this.f564873a.getExpression()).getExpression();
        if ((r100 instanceof On) == false) goto L7;
        return ((On) r100).getTime().getValue().intValue();
    L7:
        return this.f564871b;
    }

    public h(CronField r100) {
        super(r100);
        FieldExpression r101 = ((Every) r100.getExpression()).getExpression();
        if ((r101 instanceof Between) == false) goto L6;
        Between r102 = (Between) r101;
        this.f564871b = Math.max(r100.getConstraints().getStartRange(), f.f(r102.getFrom()));
        this.f564872c = Math.min(r100.getConstraints().getEndRange(), f.f(r102.getTo()));
        return;
    L6:
        if ((r101 instanceof On) == false) goto L8;
        this.f564871b = ((On) r101).getTime().getValue().intValue();
        this.f564872c = r100.getConstraints().getEndRange();
        return;
    L8:
        this.f564871b = r100.getConstraints().getStartRange();
        this.f564872c = r100.getConstraints().getEndRange();
    }

    @Override // xr7.i
    public int c(int r100) throws NoSuchValueException {
        if (r100 >= this.f564872c) goto L16;
        Every r101 = (Every) this.f564873a.getExpression();
        int r102 = f();
        if (r100 < r102) goto L7;
        int r103 = r101.getPeriod().getValue().intValue();
        r102 = r100 + (r103 - ((r100 - r102) % r103));
    L7:
        int r104 = this.f564871b;
        if (r102 >= r104) goto L11;
        return r104;
    L11:
        if (r102 > this.f564872c) goto L14;
        return r102;
    L14:
        throw new NoSuchValueException();
    L16:
        throw new NoSuchValueException();
    }

    @Override // xr7.i
    public boolean d(int r100) {
        Every r101 = (Every) this.f564873a.getExpression();
        int r102 = f();
        if (r100 >= r102) goto L5;
    L11:
        return false;
    L5:
        if (((r100 - r102) % r101.getPeriod().getValue().intValue()) != 0) goto L11;
        if (r100 < this.f564871b) goto L11;
        if (r100 > this.f564872c) goto L11;
        return true;
    }

    @Override // xr7.i
    public final boolean e(FieldExpression r100) {
        return r100 instanceof Every;
    }

    @Override // xr7.i
    public List<Integer> b(int r100, int r101) {
        ArrayList r102 = new ArrayList();
        int r103 = f();     // Catch: NoSuchValueException -> L14
        if (r100 >= r103) goto L7;
        if (r103 >= r101) goto L7;
        r102.add(Integer.valueOf(r103));     // Catch: NoSuchValueException -> L14
    L7:
        int r104 = c(r100);     // Catch: NoSuchValueException -> L14
    L8:
        if (r104 >= r101) goto L13;
        if (r104 == r103) goto L11;
        r102.add(Integer.valueOf(r104));     // Catch: NoSuchValueException -> L14
    L11:
        r104 = c(r104);     // Catch: NoSuchValueException -> L14
    L13:
        return r102;
    }
}
