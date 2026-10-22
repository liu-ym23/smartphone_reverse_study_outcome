package com.cronutils.model.field.expression;

import com.cronutils.model.field.value.IntegerFieldValue;
import vr7.a;
import vr7.b;

/* JADX INFO: loaded from: classes6.dex */
public class Every extends FieldExpression {
    private static final long serialVersionUID = -1103196842332906994L;
    private final FieldExpression expression;
    private final IntegerFieldValue period;

    @Override // com.cronutils.model.field.expression.FieldExpression
    public String asString() {
        String r100 = this.expression.asString();
        if ("*".equals(r100) == false) goto L8;
        if (this.period.getValue().intValue() != 1) goto L8;
        return r100;
    L8:
        return String.format("%s/%s", new Object[]{r100, this.period});
    }

    public FieldExpression getExpression() {
        return this.expression;
    }

    public IntegerFieldValue getPeriod() {
        return this.period;
    }

    public Every(IntegerFieldValue r100) {
        this(FieldExpression.always(), r100);
    }

    @Override // com.cronutils.model.field.expression.FieldExpression
    public FieldExpression accept(a r100) {
        b r101 = (b) r100;
        r101.a(this);
        if (getExpression() == null) goto L5;
        getExpression().accept(r101);
    L5:
        IntegerFieldValue r102 = getPeriod();
        if ((r102 instanceof IntegerFieldValue) == false) goto L12;
        int r103 = r102.getValue().intValue();
        if (r101.f556922a.isPeriodInRange(r103) == true) goto L12;
        throw new IllegalArgumentException(String.format("Period %s not in range [%s, %s]", new Object[]{Integer.valueOf(r103), Integer.valueOf(r101.f556922a.getStartRange()), Integer.valueOf(r101.f556922a.getEndRange())}));
    L12:
        return this;
    }

    public Every(FieldExpression r100, IntegerFieldValue r101) {
        zr7.a.b(r100, "Expression must not be null");
        this.expression = r100;
        if (r101 != null) goto L5;
        r101 = new IntegerFieldValue(1);
    L5:
        this.period = r101;
    }
}
