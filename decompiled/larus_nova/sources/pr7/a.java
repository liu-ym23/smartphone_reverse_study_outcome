package pr7;

import com.cronutils.model.Cron;
import com.cronutils.model.SingleCron;
import com.cronutils.model.definition.CronDefinition;
import com.cronutils.model.field.CronField;
import com.cronutils.model.field.CronFieldName;
import com.cronutils.model.field.constraint.FieldConstraints;
import com.cronutils.model.field.definition.FieldDefinition;
import com.cronutils.model.field.expression.FieldExpression;
import com.cronutils.model.field.expression.On;
import com.cronutils.model.field.value.IntegerFieldValue;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Map;
import vr7.b;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<CronFieldName, CronField> f530360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CronDefinition f530361b;

    public final Cron c() {
        return new SingleCron(this.f530361b, new ArrayList(((EnumMap) this.f530360a).values())).validate();
    }

    public a(CronDefinition r100) {
        this.f530360a = new EnumMap(CronFieldName.class);
        this.f530361b = r100;
    }

    public static Cron b(CronDefinition r100) {
        a r101 = new a(r100);
        CronFieldName r102 = CronFieldName.SECOND;
        if (r100.containsFieldDefinition(r102) == false) goto L5;
        r101.a(r102, new On(new IntegerFieldValue(0)));
    L5:
        CronFieldName r103 = CronFieldName.MINUTE;
        if (r100.containsFieldDefinition(r103) == false) goto L8;
        r101.a(r103, new On(new IntegerFieldValue(0)));
    L8:
        CronFieldName r104 = CronFieldName.HOUR;
        if (r100.containsFieldDefinition(r104) == false) goto L11;
        r101.a(r104, new On(new IntegerFieldValue(0)));
    L11:
        CronFieldName r105 = CronFieldName.DAY_OF_MONTH;
        if (r100.containsFieldDefinition(r105) == false) goto L14;
        r101.a(r105, FieldExpression.always());
    L14:
        CronFieldName r106 = CronFieldName.MONTH;
        if (r100.containsFieldDefinition(r106) == false) goto L17;
        r101.a(r106, FieldExpression.always());
    L17:
        CronFieldName r107 = CronFieldName.DAY_OF_WEEK;
        if (r100.containsFieldDefinition(r107) == false) goto L21;
        r101.a(r107, FieldExpression.always());
    L21:
        return r101.c();
    }

    public static Cron d(CronDefinition r100) {
        a r101 = new a(r100);
        CronFieldName r102 = CronFieldName.SECOND;
        if (r100.containsFieldDefinition(r102) == false) goto L5;
        r101.a(r102, new On(new IntegerFieldValue(0)));
    L5:
        CronFieldName r103 = CronFieldName.MINUTE;
        if (r100.containsFieldDefinition(r103) == false) goto L8;
        r101.a(r103, new On(new IntegerFieldValue(0)));
    L8:
        CronFieldName r104 = CronFieldName.HOUR;
        if (r100.containsFieldDefinition(r104) == false) goto L11;
        r101.a(r104, new On(new IntegerFieldValue(0)));
    L11:
        CronFieldName r105 = CronFieldName.DAY_OF_MONTH;
        if (r100.containsFieldDefinition(r105) == false) goto L14;
        r101.a(r105, new On(new IntegerFieldValue(1)));
    L14:
        CronFieldName r106 = CronFieldName.MONTH;
        if (r100.containsFieldDefinition(r106) == false) goto L17;
        r101.a(r106, new On(new IntegerFieldValue(1)));
    L17:
        CronFieldName r107 = CronFieldName.DAY_OF_WEEK;
        if (r100.containsFieldDefinition(r107) == false) goto L21;
        r101.a(r107, FieldExpression.always());
    L21:
        return r101.c();
    }

    public final void a(CronFieldName r100, FieldExpression r101) {
        if (this.f530361b == null) goto L5;
        boolean r102 = true;
    L6:
        zr7.a.d(r102, "CronBuilder not initialized.", new Object[0]);
        FieldDefinition r103 = this.f530361b.getFieldDefinition(r100);
        if (r103 == null) goto L9;
        boolean r104 = true;
    L10:
        zr7.a.d(r104, "Cron field definition does not exist: %s", new Object[]{r100});
        FieldConstraints r105 = r103.getConstraints();
        r101.accept(new b(r105));
        ((EnumMap) this.f530360a).put(r100, new CronField(r100, r101, r105));
        return;
    L9:
        r104 = false;
        goto L10
    L5:
        r102 = false;
        goto L6
    }
}
