package xr7;

import com.cronutils.model.field.CronField;
import com.cronutils.model.field.CronFieldName;
import com.cronutils.model.field.expression.FieldExpression;
import com.cronutils.model.field.expression.On;
import com.cronutils.model.field.value.SpecialChar;
import com.cronutils.model.time.generator.NoSuchValueException;
import java.time.DayOfWeek;
import java.time.LocalDate;

/* JADX INFO: loaded from: classes22.dex */
public final class m extends l {

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f564876a = null;

        static {
            int[] r100 = new int[SpecialChar.values().length];
            f564876a = r100;
            r100[SpecialChar.L.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f564876a[SpecialChar.W.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f564876a[SpecialChar.LW.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    @Override // xr7.i
    public final int c(int r100) throws NoSuchValueException {
        int r101 = f((On) this.f564873a.getExpression(), this.f564874b, this.f564875c);
        if (r101 <= r100) goto L6;
        return r101;
    L6:
        throw new NoSuchValueException();
    }

    @Override // xr7.i
    public final boolean d(int r100) {
        On r101 = (On) this.f564873a.getExpression();
        if (r100 != f(r101, this.f564874b, this.f564875c)) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // xr7.i
    public final boolean e(FieldExpression r100) {
        return r100 instanceof On;
    }

    public m(CronField r100, int r101, int r102) {
        super(r100, r101, r102);
        zr7.a.a(CronFieldName.DAY_OF_MONTH.equals(r100.getField()), "CronField does not belong to day of month");
    }

    public static int f(On r100, int r101, int r102) throws NoSuchValueException {
        int r103 = r100.getTime().getValue().intValue();
        int r104 = a.f564876a[r100.getSpecialChar().getValue().ordinal()];
        if (r104 != 1) goto L5;
        int r105 = r100.getNth().getValue().intValue();
        int r106 = LocalDate.of(r101, r102, 1).lengthOfMonth();
        if (r105 > 0) goto L32;
        r105 = 0;
    L32:
        return r106 - r105;
    L5:
        if (r104 == 2) goto L15;
        if (r104 != 3) goto L14;
        LocalDate r107 = LocalDate.of(r101, r102, LocalDate.of(r101, r102, 1).lengthOfMonth());
        int r108 = r107.getDayOfWeek().getValue() - 5;
        if (r108 <= 0) goto L12;
        return r107.minusDays(r108).getDayOfMonth();
    L12:
        return r107.getDayOfMonth();
    L14:
        throw new NoSuchValueException();
    L15:
        LocalDate r109 = LocalDate.of(r101, r102, r103);
        if (r109.getDayOfWeek() != DayOfWeek.SATURDAY) goto L22;
        if (r103 != 1) goto L20;
        return 3;
    L20:
        return r103 - 1;
    L22:
        if (r109.getDayOfWeek() != DayOfWeek.SUNDAY) goto L26;
        int r110 = r103 + 1;
        if (r110 > r109.lengthOfMonth()) goto L26;
        return r110;
    L26:
        return r103;
    }
}
