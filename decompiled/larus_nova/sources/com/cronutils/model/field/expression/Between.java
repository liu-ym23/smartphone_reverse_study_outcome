package com.cronutils.model.field.expression;

import com.cronutils.model.field.value.FieldValue;
import com.cronutils.model.field.value.IntegerFieldValue;
import com.cronutils.model.field.value.SpecialChar;
import com.cronutils.model.field.value.SpecialCharFieldValue;
import vr7.a;
import vr7.b;

/* JADX INFO: loaded from: classes6.dex */
public class Between extends FieldExpression {
    private static final long serialVersionUID = 549075258664100474L;
    private final FieldValue<?> from;

    /* JADX INFO: renamed from: to, reason: collision with root package name */
    private final FieldValue<?> f273559to;

    @Override // com.cronutils.model.field.expression.FieldExpression
    public String asString() {
        return String.format("%s-%s", new Object[]{this.from, this.f273559to});
    }

    public FieldValue<?> getFrom() {
        return this.from;
    }

    public FieldValue<?> getTo() {
        return this.f273559to;
    }

    public Between(Between r100) {
        this(r100.getFrom(), r100.getTo());
    }

    @Override // com.cronutils.model.field.expression.FieldExpression
    public FieldExpression accept(a r100) {
        b r101 = (b) r100;
        r101.a(this);
        r101.b(getFrom());
        r101.b(getTo());
        FieldValue<?> r102 = getFrom();
        if ((r102 instanceof SpecialCharFieldValue) == true) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == true) goto L29;
        FieldValue<?> r104 = getTo();
        if ((r104 instanceof SpecialCharFieldValue) == true) goto L12;
    L14:
        boolean r105 = false;
    L15:
        if (r105 == true) goto L29;
        if (r101.f556922a.isStrictRange() == true) goto L19;
    L27:
        return this;
    L19:
        if ((getFrom() instanceof IntegerFieldValue) == false) goto L27;
        if ((getTo() instanceof IntegerFieldValue) == false) goto L27;
        int r106 = ((IntegerFieldValue) getFrom()).getValue().intValue();
        int r107 = ((IntegerFieldValue) getTo()).getValue().intValue();
        if (r106 <= r107) goto L27;
        throw new IllegalArgumentException(String.format("Invalid range! [%s,%s]", new Object[]{Integer.valueOf(r106), Integer.valueOf(r107)}));
    L12:
        if (SpecialChar.L.equals(r104.getValue()) == true) goto L14;
        r105 = true;
    L29:
        throw new IllegalArgumentException("No special characters allowed in range, except for 'L'");
    L5:
        if (SpecialChar.L.equals(r102.getValue()) == true) goto L7;
        r103 = true;
        goto L8
    }

    public Between(FieldValue<?> r100, FieldValue<?> r101) {
        this.from = r100;
        this.f273559to = r101;
    }
}
