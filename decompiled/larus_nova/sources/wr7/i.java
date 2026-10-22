package wr7;

import com.cronutils.model.Cron;
import com.cronutils.model.field.CronField;
import com.cronutils.model.field.CronFieldName;
import com.cronutils.model.field.constraint.FieldConstraints;
import com.cronutils.model.field.expression.FieldExpression;
import com.cronutils.model.field.expression.On;
import com.cronutils.model.field.value.IntegerFieldValue;

/* JADX INFO: loaded from: classes22.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Cron f560833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public xr7.i f560834b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CronField f560835c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CronField f560836d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CronField f560837e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public r f560838f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public r f560839g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public r f560840h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public r f560841i;

    public i(Cron r100) {
        this.f560833a = r100;
    }

    public final FieldConstraints a(CronFieldName r100) {
        if (this.f560833a.getCronDefinition().getFieldDefinition(r100) != null) goto L7;
        tr7.a r101 = new tr7.a();
        r101.b(r100);
        return r101.a();
    L7:
        return this.f560833a.getCronDefinition().getFieldDefinition(r100).getConstraints();
    }

    public static void d(CronFieldName r100, CronField r101) {
        zr7.a.b(r100, "Reference CronFieldName cannot be null");
        zr7.a.b(r101.getField(), "CronField's CronFieldName cannot be null");
        if (r100.equals(r101.getField()) == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(String.format("Invalid argument! Expected CronField instance for field %s but found %s", new Object[]{r101.getField(), r100}));
    }

    public final r b(CronFieldName r100, int r101, int r102) {
        return new r(xr7.j.c(new CronField(r100, FieldExpression.always(), a(r100))).a(r101, r102));
    }

    public final r c(CronFieldName r100, int r101, int r102) {
        FieldConstraints r103 = a(r100);
        return new r(xr7.j.c(new CronField(r100, new On(new IntegerFieldValue(r101)), r103)).a(r101, r102));
    }
}
