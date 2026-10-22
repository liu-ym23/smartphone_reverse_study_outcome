package xr7;

import com.cronutils.mapper.WeekDay;
import com.cronutils.model.field.CronField;
import com.cronutils.model.field.expression.Always;
import com.cronutils.model.field.expression.And;
import com.cronutils.model.field.expression.Between;
import com.cronutils.model.field.expression.Every;
import com.cronutils.model.field.expression.FieldExpression;
import com.cronutils.model.field.expression.On;
import com.cronutils.model.field.value.SpecialChar;

/* JADX INFO: loaded from: classes22.dex */
public final class j {
    public static i c(CronField r100) {
        FieldExpression r101 = r100.getExpression();
        if ((r101 instanceof Always) == false) goto L7;
        return new a(r100);
    L7:
        if ((r101 instanceof And) == false) goto L11;
        return new c(r100);
    L11:
        if ((r101 instanceof Between) == false) goto L15;
        return new f(r100);
    L15:
        if ((r101 instanceof Every) == false) goto L19;
        return new h(r100);
    L19:
        if ((r101 instanceof On) == false) goto L27;
        On r102 = (On) r101;
        if (SpecialChar.NONE.equals(r102.getSpecialChar().getValue()) == false) goto L25;
        return new o(r100);
    L25:
        throw new IllegalArgumentException(String.format("Cannot create instance for On instance with %s value", new Object[]{r102.getSpecialChar()}));
    L27:
        return new k(r100);
    }

    public static i a(CronField r100, int r101, int r102) {
        FieldExpression r103 = r100.getExpression();
        if ((r103 instanceof On) == false) goto L9;
        if (SpecialChar.NONE.equals(((On) r103).getSpecialChar().getValue()) == true) goto L9;
        return new m(r100, r101, r102);
    L9:
        return c(r100);
    }

    public static i b(CronField r100, int r101, int r102, WeekDay r103) {
        FieldExpression r104 = r100.getExpression();
        if ((r104 instanceof On) == false) goto L7;
        return new n(r100, r101, r102, r103);
    L7:
        if ((r104 instanceof Between) == false) goto L11;
        return new e(r100, r101, r102, r103);
    L11:
        if ((r104 instanceof And) == false) goto L15;
        return new b(r100, r101, r102, r103);
    L15:
        if ((r104 instanceof Every) == false) goto L19;
        return new g(r100, r101, r102, r103);
    L19:
        return c(r100);
    }
}
