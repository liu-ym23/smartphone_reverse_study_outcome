package com.cronutils.model.field.expression;

import java.io.Serializable;
import vr7.a;

/* JADX INFO: loaded from: classes6.dex */
public abstract class FieldExpression implements Serializable {
    private static final long serialVersionUID = 5138279438874391617L;

    public FieldExpression() {
    }

    public abstract FieldExpression accept(a r100);

    public abstract String asString();

    public static FieldExpression always() {
        return Always.INSTANCE;
    }

    public static FieldExpression questionMark() {
        return QuestionMark.INSTANCE;
    }

    public And and(FieldExpression r100) {
        return new And().and(this).and(r100);
    }
}
