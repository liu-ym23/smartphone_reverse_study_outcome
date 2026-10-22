package com.cronutils.model.field.expression;

import androidx.exifinterface.media.ExifInterface;
import com.cronutils.model.field.value.IntegerFieldValue;
import com.cronutils.model.field.value.SpecialChar;
import com.cronutils.model.field.value.SpecialCharFieldValue;
import vr7.b;

/* JADX INFO: loaded from: classes6.dex */
public class On extends FieldExpression {
    private static final long serialVersionUID = 8746471281123327324L;
    private final IntegerFieldValue nth;
    private final SpecialCharFieldValue specialChar;
    private final IntegerFieldValue time;

    /* JADX INFO: loaded from: classes22.dex */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f273560a = null;

        static {
            int[] r100 = new int[SpecialChar.values().length];
            f273560a = r100;
            r100[SpecialChar.NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f273560a[SpecialChar.HASH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f273560a[SpecialChar.W.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f273560a[SpecialChar.L.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f273560a[SpecialChar.QUESTION_MARK.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    @Override // com.cronutils.model.field.expression.FieldExpression
    public String asString() {
        int r100 = a.f273560a[this.specialChar.getValue().ordinal()];
        if (r100 == 1) goto L42;
        if (r100 == 2) goto L40;
        if (r100 == 3) goto L32;
        if (r100 == 4) goto L17;
        if (r100 != 5) goto L13;
        return "?";
    L13:
        return this.specialChar.toString();
    L17:
        if (getTime().getValue().intValue() != (-1)) goto L19;
        boolean r101 = true;
    L20:
        if (r101 == false) goto L30;
        StringBuilder r102 = new StringBuilder("L");
        if (getNth().getValue().intValue() != (-1)) goto L24;
        boolean r103 = true;
    L25:
        if (r103 == false) goto L27;
        String r104 = "";
    L28:
        r102.append(r104);
        return r102.toString();
    L27:
        r104 = String.format("-%s", new Object[]{getNth()});
        goto L28
    L24:
        r103 = false;
        goto L25
    L30:
        return String.format("%sL", new Object[]{getTime()});
    L19:
        r101 = false;
        goto L20
    L32:
        if (getTime().getValue().intValue() != (-1)) goto L34;
        boolean r105 = true;
    L35:
        if (r105 == false) goto L38;
        return ExifInterface.LONGITUDE_WEST;
    L38:
        return String.format("%sW", new Object[]{getTime()});
    L34:
        r105 = false;
        goto L35
    L40:
        return String.format("%s#%s", new Object[]{getTime(), getNth()});
    L42:
        return getTime().toString();
    }

    public IntegerFieldValue getNth() {
        return this.nth;
    }

    public SpecialCharFieldValue getSpecialChar() {
        return this.specialChar;
    }

    public IntegerFieldValue getTime() {
        return this.time;
    }

    public On(IntegerFieldValue r100) {
        this(r100, new SpecialCharFieldValue(SpecialChar.NONE));
    }

    @Override // com.cronutils.model.field.expression.FieldExpression
    public FieldExpression accept(vr7.a r100) {
        b r101 = (b) r100;
        r101.a(this);
        IntegerFieldValue r102 = getTime();
        boolean r103 = true;
        if ((r102 instanceof IntegerFieldValue) == true) goto L5;
    L7:
        boolean r104 = false;
    L8:
        if (r104 == true) goto L10;
        r101.b(getTime());
    L10:
        IntegerFieldValue r105 = getNth();
        if ((r105 instanceof IntegerFieldValue) == true) goto L13;
    L15:
        r103 = false;
    L16:
        if (r103 == true) goto L18;
        r101.b(getNth());
    L18:
        return this;
    L13:
        if (r105.getValue().intValue() != (-1)) goto L15;
    L5:
        if (r102.getValue().intValue() != (-1)) goto L7;
        r104 = true;
        goto L8
    }

    public On(SpecialCharFieldValue r100) {
        this(new IntegerFieldValue(-1), r100);
    }

    public On(IntegerFieldValue r100, SpecialCharFieldValue r101) {
        this(r100, r101, new IntegerFieldValue(-1));
        zr7.a.a(!r101.getValue().equals(SpecialChar.HASH), "value missing for a#b cron expression");
    }

    public On(IntegerFieldValue r100, SpecialCharFieldValue r101, IntegerFieldValue r102) {
        zr7.a.b(r100, "time must not be null");
        zr7.a.b(r101, "special char must not null");
        zr7.a.b(r102, "nth value must not be null");
        this.time = r100;
        this.specialChar = r101;
        this.nth = r102;
    }
}
