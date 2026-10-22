package wr7;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.cronutils.mapper.WeekDay;
import com.cronutils.model.definition.CronDefinition;
import com.cronutils.model.field.CronField;
import com.cronutils.model.field.CronFieldName;
import com.cronutils.model.field.constraint.FieldConstraints;
import com.cronutils.model.field.definition.DayOfWeekFieldDefinition;
import com.cronutils.model.field.expression.Always;
import com.cronutils.model.field.expression.FieldExpression;
import com.cronutils.model.field.expression.QuestionMark;
import com.cronutils.model.field.value.SpecialChar;
import com.cronutils.model.time.generator.NoSuchValueException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* JADX INFO: loaded from: classes22.dex */
public final class q implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CronDefinition f560849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xr7.i f560850b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CronField f560851c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CronField f560852d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CronField f560853e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final r f560854f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final r f560855g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final r f560856h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final r f560857i;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ZonedDateTime f560858a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f560859b;

        public final String toString() {
            return "ExecutionTimeResult{time=" + this.f560858a + ", isMatch=" + this.f560859b + '}';
        }

        public a(ZonedDateTime r100, boolean r101) {
            this.f560858a = r100;
            this.f560859b = r101;
        }
    }

    static {
        LocalTime.MAX.truncatedTo(ChronoUnit.SECONDS);
    }

    public static ZonedDateTime e(ZonedDateTime r100) {
        return r100.truncatedTo(ChronoUnit.DAYS).plusMonths(1).withDayOfMonth(1);
    }

    @Override // wr7.h
    public final Optional<ZonedDateTime> a(ZonedDateTime r100) {
        r100.getClass();
        ZonedDateTime r101 = d(r100);     // Catch: NoSuchValueException -> L20
        if (r101.equals(r100) == false) goto L18;
        ZonedDateTime r102 = d(r100.plusSeconds(1));     // Catch: NoSuchValueException -> L20
        if (r102.getOffset().compareTo(r100.getOffset()) <= 0) goto L17;
        Optional r103 = Optional.empty();     // Catch: NoSuchValueException -> L20
        r103 = Optional.of(d(r102.plusSeconds(1)));     // Catch: NoSuchValueException -> L22
    L10:
        if (r103.isPresent() == false) goto L17;
        if (Duration.between(r102, (Temporal) r103.get()).toHours() <= 1) goto L14;
        boolean r104 = true;
    L15:
        if (r104 == false) goto L17;
        r101 = d(r100.plusSeconds(1).plusHours(1));     // Catch: NoSuchValueException -> L20
        goto L18
    L14:
        r104 = false;
    L17:
        r101 = r102;
    L18:
        return Optional.of(r101);
    L21:
        return Optional.empty();
    }

    public final ZonedDateTime d(ZonedDateTime r110) throws NoSuchValueException {
        a r100 = new a(r110, false);
        int r101 = 0;
    L4:
        if (r101 >= 100000) goto L52;
        final ZonedDateTime r102 = r100.f560858a;
        List r103 = (List) this.f560850b.a(r102.getYear(), r102.getYear()).stream().filter(new k(r102)).collect(Collectors.toList());
        int r104 = ((Integer) ListProtector.get(this.f560854f.c(), 0)).intValue();
        int r105 = ((Integer) ListProtector.get(this.f560855g.c(), 0)).intValue();
        int r106 = ((Integer) ListProtector.get(this.f560856h.c(), 0)).intValue();
        int r107 = ((Integer) ListProtector.get(this.f560857i.c(), 0)).intValue();
        if (r103.isEmpty() == false) goto L13;
        int r108 = this.f560850b.c(r102.getYear());
        Optional<r> r109 = b(this.f560849a, ZonedDateTime.of(LocalDate.of(r108, r104, 1), LocalTime.MIN, r102.getZone()));
        if (r109.isPresent() == false) goto L10;
        a r111 = new a(ZonedDateTime.of(LocalDate.of(r108, r104, ((Integer) ListProtector.get(r109.get().c(), 0)).intValue()), LocalTime.of(r105, r106, r107), r102.getZone()), false);
    L11:
        r100 = r111;
    L43:
        if (r100.f560859b == true) goto L45;
        if ((r100.f560858a.getYear() - r110.getYear()) > 100) goto L50;
        r101 = r101 + 1;
        goto L4
    L50:
        throw new NoSuchValueException();
    L45:
        return r100.f560858a;
    L10:
        r111 = new a(e(r102), false);
        goto L11
    L13:
        if (this.f560854f.c().contains(Integer.valueOf(r102.getMonthValue())) == true) goto L21;
        j r112 = this.f560854f.a(r102.getMonthValue());
        int r113 = r112.f560843b;
        if (r112.f560842a <= 0) goto L17;
        a r114 = new a(r102.truncatedTo(ChronoUnit.DAYS).withMonth(1).withDayOfMonth(1).plusYears(r112.f560842a), false);
    L30:
        r100 = r114;
        goto L43
    L17:
        Optional<r> r115 = b(this.f560849a, ZonedDateTime.of(LocalDateTime.of(r102.getYear(), r113, 1, 0, 0), r102.getZone()));
        if (r115.isPresent() == false) goto L20;
        r114 = new a(r102.truncatedTo(ChronoUnit.SECONDS).withMonth(r113).withDayOfMonth(((Integer) ListProtector.get(r115.get().c(), 0)).intValue()).with(LocalTime.of(r105, r106, r107)), false);
        goto L30
    L20:
        r114 = new a(e(r102), false);
        goto L30
    L21:
        Optional<r> r116 = b(this.f560849a, r102);
        if (r116.isPresent() == true) goto L24;
        a r117 = new a(e(r102), false);
    L41:
        r100 = r117;
        goto L43
    L24:
        r r118 = r116.get();
        if (r118.c().contains(Integer.valueOf(r102.getDayOfMonth())) == true) goto L32;
        j r119 = r118.a(r102.getDayOfMonth());
        if (r119.f560842a <= 0) goto L29;
        r114 = new a(r102.truncatedTo(ChronoUnit.DAYS).withDayOfMonth(1).plusMonths(r119.f560842a), false);
        goto L30
    L29:
        r114 = new a(r102.truncatedTo(ChronoUnit.SECONDS).withDayOfMonth(r119.f560843b).with(LocalTime.of(r105, r106, r107)), false);
        goto L30
    L32:
        if (this.f560855g.c().contains(Integer.valueOf(r102.getHour())) == true) goto L35;
        r100 = c(r102, this.f560855g, ChronoField.HOUR_OF_DAY);
        goto L43
    L35:
        if (this.f560856h.c().contains(Integer.valueOf(r102.getMinute())) == true) goto L38;
        r100 = c(r102, this.f560856h, ChronoField.MINUTE_OF_HOUR);
        goto L43
    L38:
        if (this.f560857i.c().contains(Integer.valueOf(r102.getSecond())) == true) goto L40;
        r100 = c(r102, this.f560857i, ChronoField.SECOND_OF_MINUTE);
        goto L43
    L40:
        r117 = new a(r102, true);
        goto L41
    L52:
        throw new NoSuchValueException();
    }

    public final Optional<r> b(CronDefinition r100, final ZonedDateTime r101) {
        CronFieldName r102 = CronFieldName.DAY_OF_YEAR;
        if (r100.containsFieldDefinition(r102) == true) goto L6;
        boolean r103 = false;
    L9:
        if (r103 == false) goto L16;
        int r104 = r101.getYear();
        int r105 = r101.getMonthValue();
        List<Integer> r106 = xr7.j.c(this.f560853e).a(1, LocalDate.of(r104, 1, 1).lengthOfYear());
        final int r107 = LocalDate.of(r104, r105, 1).getDayOfYear();
        if (r105 != 12) goto L13;
        final int r108 = LocalDate.of(r104, 12, 31).getDayOfYear() + 1;
    L15:
        return Optional.of((List) r106.stream().filter(new l(r107, r108)).map(new m(r101)).collect(Collectors.toList())).filter(new n().negate()).map(new o());
    L13:
        r108 = LocalDate.of(r104, r105 + 1, 1).getDayOfYear();
        goto L15
    L16:
        CronFieldName r109 = CronFieldName.DAY_OF_WEEK;
        if (r100.getFieldDefinition(r109) == null) goto L53;
        if (r100.getFieldDefinition(CronFieldName.DAY_OF_MONTH) == null) goto L53;
        if (r100.getFieldDefinition(r109).getConstraints().getSpecialChars().contains(SpecialChar.QUESTION_MARK) == false) goto L35;
        int r110 = r101.getYear();
        int r111 = r101.getMonthValue();
        WeekDay r112 = ((DayOfWeekFieldDefinition) r100.getFieldDefinition(r109)).getMondayDoWValue();
        int r113 = LocalDate.of(r110, r111, 1).lengthOfMonth();
        if ((this.f560852d.getExpression() instanceof Always) == false) goto L28;
        if ((this.f560851c.getExpression() instanceof Always) == false) goto L28;
        List r114 = (List) xr7.j.a(this.f560852d, r110, r111).a(1, r113).stream().distinct().sorted().collect(Collectors.toList());
    L61:
        return Optional.of(r114).filter(new n().negate()).map(new o());
    L28:
        if ((this.f560852d.getExpression() instanceof QuestionMark) == false) goto L31;
        r114 = (List) xr7.j.b(this.f560851c, r110, r111, r112).a(1, r113).stream().distinct().sorted().collect(Collectors.toList());
        goto L61
    L31:
        if ((this.f560851c.getExpression() instanceof QuestionMark) == false) goto L33;
        r114 = (List) xr7.j.a(this.f560852d, r110, r111).a(1, r113).stream().distinct().sorted().collect(Collectors.toList());
        goto L61
    L33:
        HashSet r115 = new HashSet(xr7.j.a(this.f560852d, r110, r111).a(1, r113));
        r115.retainAll(new HashSet(xr7.j.b(this.f560851c, r110, r111, r112).a(1, r113)));
        r114 = (List) r115.stream().sorted().collect(Collectors.toList());
        goto L61
    L35:
        int r116 = r101.getYear();
        int r117 = r101.getMonthValue();
        WeekDay r118 = ((DayOfWeekFieldDefinition) r100.getFieldDefinition(r109)).getMondayDoWValue();
        int r119 = LocalDate.of(r116, r117, 1).lengthOfMonth();
        if ((this.f560852d.getExpression() instanceof Always) == false) goto L41;
        if ((this.f560851c.getExpression() instanceof Always) == false) goto L41;
        List r120 = (List) xr7.j.a(this.f560852d, r116, r117).a(1, r119).stream().distinct().sorted().collect(Collectors.toList());
    L51:
        return Optional.of(r120).filter(new n().negate()).map(new o());
    L41:
        if ((this.f560852d.getExpression() instanceof Always) == false) goto L44;
        r120 = (List) xr7.j.b(this.f560851c, r116, r117, r118).a(1, r119).stream().distinct().sorted().collect(Collectors.toList());
        goto L51
    L44:
        if ((this.f560851c.getExpression() instanceof Always) == false) goto L46;
        r120 = (List) xr7.j.a(this.f560852d, r116, r117).a(1, r119).stream().distinct().sorted().collect(Collectors.toList());
        goto L51
    L46:
        List<Integer> r121 = xr7.j.b(this.f560851c, r116, r117, r118).a(1, r119);
        List<Integer> r122 = xr7.j.a(this.f560852d, r116, r117).a(1, r119);
        if (this.f560849a.isMatchDayOfWeekAndDayOfMonth() == false) goto L49;
        final HashSet r123 = new HashSet(r121);
        r120 = (List) r122.stream().filter(new p(r123)).distinct().sorted().collect(Collectors.toList());
        goto L51
    L49:
        r120 = (List) Stream.concat(r121.stream(), r122.stream()).distinct().sorted().collect(Collectors.toList());
    L53:
        if (r100.getFieldDefinition(r109) != null) goto L59;
        List r124 = (List) xr7.j.a(this.f560852d, r101.getYear(), r101.getMonthValue()).a(1, LocalDate.of(r101.getYear(), r101.getMonthValue(), 1).lengthOfMonth()).stream().distinct().sorted().collect(Collectors.toList());
        if (r124.isEmpty() == false) goto L58;
        return Optional.empty();
    L58:
        return Optional.of(new r(r124));
    L59:
        WeekDay r125 = ((DayOfWeekFieldDefinition) r100.getFieldDefinition(r109)).getMondayDoWValue();
        return Optional.of(new r((List) xr7.j.b(this.f560851c, r101.getYear(), r101.getMonthValue(), r125).a(1, LocalDate.of(r101.getYear(), r101.getMonthValue(), 1).lengthOfMonth()).stream().distinct().sorted().collect(Collectors.toList())));
    L6:
        if (r100.getFieldDefinition(r102).getConstraints().getSpecialChars().contains(SpecialChar.QUESTION_MARK) == true) goto L8;
        r103 = true;
        goto L9
    L8:
        r103 = !(this.f560853e.getExpression() instanceof QuestionMark);
        goto L9
    }

    public static a c(ZonedDateTime r100, r r101, TemporalField r110) throws NoSuchValueException {
        HashSet r102 = new HashSet(r101.f560860a);
        ChronoField r111 = (ChronoField) r110;
        TemporalUnit r103 = r111.getBaseUnit();
        long r104 = r111.range().getMaximum() - r111.range().getMinimum();
        long r105 = 0;
    L4:
        if (r105 >= (2 * r104)) goto L11;
        r100 = r100.plus(1, r103);
        if (r102.contains(Integer.valueOf(r100.get(r111))) == true) goto L8;
        r105 = r105 + 1;
        goto L4
    L8:
        return new a(r100.truncatedTo(r103), false);
    L11:
        throw new NoSuchValueException();
    }

    public q(CronDefinition r110, CronField r111, CronField r112, CronField r113, CronField r114, r r115, r r116, r r210, r r211) {
        r110.getClass();
        this.f560849a = r110;
        CronFieldName r100 = CronFieldName.YEAR;
        if (r110.containsFieldDefinition(r100) == true) goto L5;
        FieldExpression r101 = FieldExpression.always();
        HashMap r102 = new HashMap();
        HashMap r103 = new HashMap();
        HashSet r104 = new HashSet();
        r104.add(SpecialChar.NONE);
        this.f560850b = xr7.j.c(new CronField(r100, r101, new FieldConstraints(r102, r103, r104, 0, Integer.MAX_VALUE, false)));
    L12:
        r112.getClass();
        this.f560851c = r112;
        r113.getClass();
        this.f560852d = r113;
        this.f560853e = r114;
        r115.getClass();
        this.f560854f = r115;
        r116.getClass();
        this.f560855g = r116;
        r210.getClass();
        this.f560856h = r210;
        r211.getClass();
        this.f560857i = r211;
        return;
    L5:
        if (r110.getFieldDefinition(r100).isOptional() == true) goto L7;
        r111.getClass();
    L7:
        if (r111 != null) goto L9;
        xr7.i r105 = xr7.j.c(new CronField(r100, FieldExpression.always(), r110.getFieldDefinition(r100).getConstraints()));
    L10:
        this.f560850b = r105;
        goto L12
    L9:
        r105 = xr7.j.c(r111);
        goto L10
    }
}
