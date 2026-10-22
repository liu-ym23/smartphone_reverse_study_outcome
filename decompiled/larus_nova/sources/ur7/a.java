package ur7;

import com.cronutils.mapper.WeekDay;
import com.cronutils.model.field.CronFieldName;
import com.cronutils.model.field.definition.DayOfWeekFieldDefinition;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public final class a extends e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f551382d;

    @Override // ur7.e
    public final e e(int r100, int r101) {
        throw null;
    }

    @Override // ur7.c
    public final com.cronutils.model.definition.a a() {
        boolean r100 = this.f551385c.a().isInRange(0);
        this.f551383a.c(new DayOfWeekFieldDefinition(this.f551384b, this.f551385c.a(), false, new WeekDay(this.f551382d, r100)));
        return this.f551383a;
    }

    public final void f() {
        ((HashMap) this.f551385c.f547311b).put(7, 0);
    }

    public final void g(int r100) {
        tr7.a r101 = this.f551385c;
        int r102 = r100 - this.f551382d;
        if (r102 <= 0) goto L5;
    L6:
        Iterator r103 = ((HashMap) r101.f547310a).entrySet().iterator();
    L8:
        if (r103.hasNext() == false) goto L16;
        Map.Entry r104 = (Map.Entry) r103.next();
        int r105 = ((Integer) r104.getValue()).intValue() + r102;
        int r106 = r101.f547313d;
        if (r105 <= r106) goto L12;
        r105 = r105 - ((HashMap) r101.f547310a).size();
    L15:
        Map<String, Integer> r107 = r101.f547310a;
        HashMap r108 = (HashMap) r107;
        r108.put(r104.getKey(), Integer.valueOf(r105));
        goto L8
    L12:
        int r109 = r101.f547312c;
        if (r105 >= r109) goto L15;
        r105 = r105 + (r109 - r106);
    L16:
        this.f551382d = r100;
        return;
    L5:
        if (r101.f547313d >= ((HashMap) r101.f547310a).size()) goto L16;
        goto L6
    }

    public a(com.cronutils.model.definition.a r100, CronFieldName r101) {
        super(r100, r101);
        this.f551382d = 1;
        zr7.a.a(CronFieldName.DAY_OF_WEEK.equals(r101), "CronFieldName must be DAY_OF_WEEK");
    }

    public final void h(int r100, int r101) {
        super.e(r100, r101);
    }
}
