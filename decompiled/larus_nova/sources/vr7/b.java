package vr7;

import com.cronutils.model.field.constraint.FieldConstraints;
import com.cronutils.model.field.expression.FieldExpression;
import com.cronutils.model.field.value.FieldValue;
import com.cronutils.model.field.value.IntegerFieldValue;

/* JADX INFO: loaded from: classes22.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FieldConstraints f556922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final or7.a f556923b;

    public b(FieldConstraints r100) {
        this.f556922a = r100;
        this.f556923b = new or7.a(r100);
    }

    public final void a(FieldExpression r100) {
        String r101 = this.f556923b.b(r100.asString());
        if (r101.isEmpty() == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(String.format("Invalid chars in expression! Expression: %s Invalid chars: %s", new Object[]{r100.asString(), r101}));
    }

    public final void b(FieldValue<?> r100) {
        if ((r100 instanceof IntegerFieldValue) == false) goto L9;
        int r101 = ((IntegerFieldValue) r100).getValue().intValue();
        if (this.f556922a.isInRange(r101) == false) goto L8;
        return;
    L8:
        throw new IllegalArgumentException(String.format("Value %s not in range [%s, %s]", new Object[]{Integer.valueOf(r101), Integer.valueOf(this.f556922a.getStartRange()), Integer.valueOf(this.f556922a.getEndRange())}));
    }
}
