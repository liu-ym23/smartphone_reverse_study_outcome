package xr7;

import com.cronutils.model.field.CronField;
import com.cronutils.model.field.expression.FieldExpression;
import com.cronutils.model.time.generator.NoSuchValueException;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CronField f564873a;

    public abstract List<Integer> b(int r100, int r101);

    public abstract int c(int r100) throws NoSuchValueException;

    public abstract boolean d(int r100);

    public abstract boolean e(FieldExpression r100);

    public i(CronField r100) {
        zr7.a.b(r100, "CronField must not be null");
        this.f564873a = r100;
        zr7.a.a(e(r100.getExpression()), "FieldExpression does not match required class");
    }

    public final List<Integer> a(int r100, int r101) {
        List<Integer> r102 = b(r100, r101);
        if (d(r100) == false) goto L6;
        r102.add(Integer.valueOf(r100));
    L6:
        if (d(r101) == false) goto L8;
        r102.add(Integer.valueOf(r101));
    L8:
        LinkedList r103 = new LinkedList(new HashSet(r102));
        Collections.sort(r103);
        return r103;
    }
}
