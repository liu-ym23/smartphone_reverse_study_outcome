package xr7;

import com.cronutils.mapper.WeekDay;
import com.cronutils.model.field.CronField;
import com.cronutils.model.field.CronFieldName;
import com.cronutils.model.field.constraint.FieldConstraints;
import com.cronutils.model.field.expression.Between;
import com.cronutils.model.field.expression.FieldExpression;
import com.cronutils.model.time.generator.NoSuchValueException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

/* JADX INFO: loaded from: classes22.dex */
public final class e extends i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f564863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f564864c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WeekDay f564865d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<Integer> f564866e;

    @Override // xr7.i
    public final int c(int r100) throws NoSuchValueException {
        return 0;
    }

    @Override // xr7.i
    public final boolean d(int r100) {
        int r101 = (LocalDate.of(this.f564863b, this.f564864c, r100).getDayOfWeek().getValue() % 7) + (this.f564865d.getMondayDoWValue() - 1);
        return ((HashSet) this.f564866e).contains(Integer.valueOf(r101));
    }

    @Override // xr7.i
    public final boolean e(FieldExpression r100) {
        return r100 instanceof Between;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // xr7.i
    public final List<Integer> b(int r110, int r111) {
        ArrayList r100 = new ArrayList();
        Iterator r101 = ((HashSet) this.f564866e).iterator();
    L4:
        if (r101.hasNext() == false) goto L13;
        Integer r102 = (Integer) r101.next();
        tr7.a r103 = new tr7.a();
        CronFieldName r104 = CronFieldName.DAY_OF_WEEK;
        r103.b(r104);
        FieldConstraints r105 = r103.a();
        yr7.h r106 = new yr7.h(r105);
        String r107 = r102.toString();
        if (r104.equals(r104) == false) goto L12;
        if (r107.endsWith("L") == false) goto L12;
        Integer r108 = r105.getStringMappingValue(r107.substring(0, r107.length() - 1));
        if (r108 == null) goto L12;
        r107 = r108 + "L";
    L12:
        r100.addAll(new n(new CronField(r104, r106.d(r107), r105), this.f564863b, this.f564864c, this.f564865d).a(r110, r111));
        goto L4
    L13:
        Collections.sort(r100);
        return r100;
    }

    public e(CronField r100, int r101, int r102, WeekDay r103) {
        super(r100);
        zr7.a.a(CronFieldName.DAY_OF_WEEK.equals(r100.getField()), "CronField does not belong to day of week");
        this.f564863b = r101;
        this.f564864c = r102;
        this.f564865d = r103;
        final HashSet r104 = new HashSet();
        this.f564866e = r104;
        Between r105 = (Between) r100.getExpression();
        int r106 = ((Integer) r105.getFrom().getValue()).intValue();
        int r107 = ((Integer) r105.getTo().getValue()).intValue();
        if (r107 < r106) goto L5;
        IntStream.rangeClosed(r106, r107).forEach(new d(r104));
        return;
    L5:
        IntStream.rangeClosed(r106, r100.getConstraints().getEndRange()).forEach(new d(r104));
        IntStream.rangeClosed(r100.getConstraints().getStartRange(), r107).forEach(new d(r104));
    }
}
