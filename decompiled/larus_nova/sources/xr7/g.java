package xr7;

import com.cronutils.mapper.WeekDay;
import com.cronutils.model.field.CronField;
import com.cronutils.model.field.CronFieldName;
import com.cronutils.model.field.expression.Every;
import com.cronutils.model.time.generator.NoSuchValueException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes22.dex */
public final class g extends h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f564867d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f564868e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f564869f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Set<DayOfWeek> f564870g;

    @Override // xr7.h, xr7.i
    public final int c(int r100) throws NoSuchValueException {
    L2:
        r100 = r100 + 1;
        if (d(r100) == true) goto L7;
        if (r100 <= this.f564867d) goto L2;
    L7:
        if (r100 > this.f564867d) goto L10;
        return r100;
    L10:
        throw new NoSuchValueException();
    }

    @Override // xr7.h, xr7.i
    public final boolean d(int r100) {
        if (r100 <= this.f564867d) goto L5;
        return false;
    L5:
        if (r100 < 1) goto L11;
        DayOfWeek r101 = LocalDate.of(this.f564868e, this.f564869f, r100).getDayOfWeek();
        return this.f564870g.contains(r101);
    L11:
        return false;
    }

    @Override // xr7.h, xr7.i
    public final List<Integer> b(int r100, int r101) {
        ArrayList r102 = new ArrayList();
    L3:
        if (r100 >= r101) goto L8;
        r100 = c(r100);     // Catch: NoSuchValueException -> L9
        if (r100 >= r101) goto L3;
        r102.add(Integer.valueOf(r100));     // Catch: NoSuchValueException -> L9
    L8:
        return r102;
    }

    public g(CronField r100, int r101, int r102, WeekDay r103) {
        super(r100);
        zr7.a.a(CronFieldName.DAY_OF_WEEK.equals(r100.getField()), "CronField does not belong to day of week");
        this.f564868e = r101;
        this.f564869f = r102;
        boolean r104 = true;
        this.f564867d = LocalDate.of(r101, r102, 1).lengthOfMonth();
        int r105 = ((Every) r100.getExpression()).getPeriod().getValue().intValue();
        if (r105 > 0) goto L5;
    L7:
        r104 = false;
    L8:
        zr7.a.a(r104, "Cron Expression for day of week has an invalid period.");
        int r106 = this.f564871b;
        int r107 = this.f564872c;
        ArrayList r108 = new ArrayList(7);
    L9:
        if (r106 > r107) goto L11;
        r108.add(DayOfWeek.of(r103.mapTo(r106, qr7.a.f534620a)));
        r106 = r106 + r105;
        goto L9
    L11:
        this.f564870g = EnumSet.copyOf(r108);
        return;
    L5:
        if (r105 >= 8) goto L7;
        goto L7
    }
}
