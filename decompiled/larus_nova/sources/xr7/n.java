package xr7;

import com.cronutils.mapper.WeekDay;
import com.cronutils.model.field.CronField;
import com.cronutils.model.field.CronFieldName;
import com.cronutils.model.field.expression.FieldExpression;
import com.cronutils.model.field.expression.On;
import com.cronutils.model.field.value.IntegerFieldValue;
import com.cronutils.model.field.value.SpecialChar;
import com.cronutils.model.time.generator.NoSuchValueException;
import java.time.DayOfWeek;
import java.time.LocalDate;

/* JADX INFO: loaded from: classes22.dex */
public final class n extends l {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final On f564877e = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WeekDay f564878d;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f564879a = null;

        static {
            int[] r100 = new int[SpecialChar.values().length];
            f564879a = r100;
            r100[SpecialChar.HASH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f564879a[SpecialChar.L.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f564879a[SpecialChar.NONE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    static {
        f564877e = new On(new IntegerFieldValue(7));
    }

    @Override // xr7.i
    public final int c(int r100) throws NoSuchValueException {
        int r101 = g((On) this.f564873a.getExpression(), this.f564874b, this.f564875c, r100);
        if (r101 <= r100) goto L6;
        return r101;
    L6:
        throw new NoSuchValueException();
    }

    @Override // xr7.i
    public final boolean d(int r100) {
        if (r100 != g((On) this.f564873a.getExpression(), this.f564874b, this.f564875c, r100 - 1)) goto L10;
        return true;
    L10:
        return false;
    L11:
        return false;
    }

    @Override // xr7.i
    public final boolean e(FieldExpression r100) {
        return r100 instanceof On;
    }

    public n(CronField r100, int r101, int r102, WeekDay r103) {
        super(r100, r101, r102);
        zr7.a.a(CronFieldName.DAY_OF_WEEK.equals(r100.getField()), "CronField does not belong to day of week");
        this.f564878d = r103;
    }

    public final int f(On r100, int r101, int r102, int r103) {
        int r104 = LocalDate.of(r101, r102, 1).getDayOfWeek().getValue();
        WeekDay r105 = this.f564878d;
        WeekDay r106 = qr7.a.f534620a;
        int r107 = r104 - r105.mapTo(r100.getTime().getValue().intValue(), r106);
        if (r107 >= 0) goto L5;
        int r108 = Math.abs(r107) + 1;
    L6:
        if (r107 <= 0) goto L8;
        r108 = (r108 + 7) - r107;
    L8:
        if (r103 >= 1) goto L10;
        return r108;
    L10:
        if (r108 > r103) goto L12;
        r108 = r108 + 7;
        goto L10
    L12:
        return r108;
    L5:
        r108 = 1;
        goto L6
    }

    public final int g(On r100, int r101, int r102, int r103) throws NoSuchValueException {
        int r104 = a.f564879a[r100.getSpecialChar().getValue().ordinal()];
        if (r104 != 1) goto L5;
        DayOfWeek r105 = LocalDate.of(r101, r102, 1).getDayOfWeek();
        int r106 = this.f564878d.mapTo(r100.getTime().getValue().intValue(), qr7.a.f534620a);
        int r107 = r100.getNth().getValue().intValue();
        int r108 = r105.getValue() - r106;
        if (r108 >= 0) goto L28;
        int r109 = Math.abs(r108) + 1;
    L29:
        if (r108 <= 0) goto L32;
        r109 = (r109 + 7) - r108;
    L32:
        return ((r107 - 1) * 7) + r109;
    L28:
        r109 = 1;
        goto L29
    L5:
        if (r104 == 2) goto L13;
        if (r104 != 3) goto L11;
        return f(r100, r101, r102, r103);
    L11:
        throw new NoSuchValueException();
    L13:
        if (r100.getTime().getValue().intValue() == (-1)) goto L33;
        LocalDate r110 = LocalDate.of(r101, r102, LocalDate.of(r101, r102, 1).lengthOfMonth());
        int r111 = r110.getDayOfWeek().getValue();
        int r112 = this.f564878d.mapTo(r100.getTime().getValue().intValue(), qr7.a.f534620a);
        int r113 = r111 - r112;
        if (r113 == 0) goto L34;
        if (r113 < 0) goto L35;
        if (r113 <= 0) goto L24;
        return r110.minusDays(r113).getDayOfMonth();
    L24:
        throw new NoSuchValueException();
    L35:
        return r110.minusDays(((long) r111) + ((long) (7 - r112))).getDayOfMonth();
    L34:
        return r110.getDayOfMonth();
    L33:
        return f(f564877e, r101, r102, r103);
    }
}
