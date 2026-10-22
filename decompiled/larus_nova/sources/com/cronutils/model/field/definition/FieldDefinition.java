package com.cronutils.model.field.definition;

import com.cronutils.model.field.CronFieldName;
import com.cronutils.model.field.constraint.FieldConstraints;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;
import ur7.b;
import zr7.a;

/* JADX INFO: loaded from: classes6.dex */
public class FieldDefinition implements Serializable {
    private static final long serialVersionUID = 7285200909397193383L;
    private final FieldConstraints constraints;
    private final CronFieldName fieldName;
    private final boolean optional;

    public int hashCode() {
        return Objects.hash(new Object[]{this.fieldName, this.constraints, Boolean.valueOf(this.optional)});
    }

    public static Comparator<FieldDefinition> createFieldDefinitionComparator() {
        return Comparator.comparingInt(new b());
    }

    public FieldConstraints getConstraints() {
        return this.constraints;
    }

    public CronFieldName getFieldName() {
        return this.fieldName;
    }

    public boolean isOptional() {
        return this.optional;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L19:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L19;
        FieldDefinition r101 = (FieldDefinition) r100;
        if (this.optional == r101.optional) goto L13;
    L17:
        return false;
    L13:
        if (this.fieldName != r101.fieldName) goto L17;
        if (this.constraints.equals(r101.constraints) == false) goto L17;
        return true;
    }

    public FieldDefinition(CronFieldName r100, FieldConstraints r101) {
        this(r100, r101, false);
    }

    public FieldDefinition(CronFieldName r100, FieldConstraints r101, boolean r102) {
        a.b(r100, "CronFieldName must not be null");
        this.fieldName = r100;
        a.b(r101, "FieldConstraints must not be null");
        this.constraints = r101;
        this.optional = r102;
    }
}
