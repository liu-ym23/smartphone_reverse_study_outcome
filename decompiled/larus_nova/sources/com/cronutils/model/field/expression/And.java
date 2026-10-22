package com.cronutils.model.field.expression;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import vr7.a;
import vr7.b;

/* JADX INFO: loaded from: classes6.dex */
public class And extends FieldExpression {
    private static final long serialVersionUID = -3406340596495131941L;
    private final List<FieldExpression> expressions;

    @Override // com.cronutils.model.field.expression.FieldExpression
    public String asString() {
        StringBuilder r100 = new StringBuilder();
        int r101 = 0;
    L4:
        if (r101 >= (this.expressions.size() - 1)) goto L7;
        r100.append(((FieldExpression) ListProtector.get(this.expressions, r101)).asString());
        r100.append(",");
        r101 = r101 + 1;
        goto L4
    L7:
        if (this.expressions.size() <= 0) goto L10;
        List<FieldExpression> r102 = this.expressions;
        r100.append(((FieldExpression) ListProtector.get(r102, r102.size() - 1)).asString());
    L10:
        return r100.toString();
    }

    public List<FieldExpression> getExpressions() {
        return Collections.unmodifiableList(this.expressions);
    }

    public And() {
        this.expressions = new ArrayList();
    }

    @Override // com.cronutils.model.field.expression.FieldExpression
    public FieldExpression accept(a r100) {
        b r101 = (b) r100;
        r101.a(this);
        Iterator<FieldExpression> r102 = getExpressions().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().accept(r101);
        goto L4
    L6:
        return this;
    }

    @Override // com.cronutils.model.field.expression.FieldExpression
    public And and(FieldExpression r100) {
        this.expressions.add(r100);
        return this;
    }
}
