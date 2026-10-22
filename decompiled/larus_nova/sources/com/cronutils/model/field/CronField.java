package com.cronutils.model.field;

import com.cronutils.model.field.constraint.FieldConstraints;
import com.cronutils.model.field.expression.FieldExpression;
import java.io.Serializable;
import java.util.Comparator;
import sr7.a;

/* JADX INFO: loaded from: classes6.dex */
public class CronField implements Serializable {
    private static final long serialVersionUID = -4042499846855256325L;
    private final FieldConstraints constraints;
    private final FieldExpression expression;
    private final CronFieldName field;

    public static Comparator<CronField> createFieldComparator() {
        return Comparator.comparingInt(new a());
    }

    public String toString() {
        return "CronField{field=" + this.field + '}';
    }

    public FieldConstraints getConstraints() {
        return this.constraints;
    }

    public FieldExpression getExpression() {
        return this.expression;
    }

    public CronFieldName getField() {
        return this.field;
    }

    public CronField(CronFieldName r100, FieldExpression r101, FieldConstraints r102) {
        this.field = r100;
        zr7.a.b(r101, "FieldExpression must not be null");
        this.expression = r101;
        zr7.a.b(r102, "FieldConstraints must not be null");
        this.constraints = r102;
    }
}
