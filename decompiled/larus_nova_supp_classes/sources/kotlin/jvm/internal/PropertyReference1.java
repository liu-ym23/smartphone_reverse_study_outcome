package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public abstract class PropertyReference1 extends PropertyReference implements KProperty1 {
    @Override // kotlin.jvm.internal.CallableReference
    public KCallable computeReflected() {
        return Reflection.property1(this);
    }

    @Override // kotlin.reflect.KProperty1
    /* JADX INFO: renamed from: getGetter */
    public KProperty1.Getter mo165getGetter() {
        return ((KProperty1) getReflected()).mo165getGetter();
    }

    public PropertyReference1() {
    }

    @Override // kotlin.reflect.KProperty
    public /* bridge */ /* synthetic */ KProperty.Getter getGetter() {
        return mo165getGetter();
    }

    public PropertyReference1(Object r1) {
        super(r1);
    }

    @Override // kotlin.reflect.KProperty1
    public Object getDelegate(Object r2) {
        return ((KProperty1) getReflected()).getDelegate(r2);
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object r1) {
        return get(r1);
    }

    public PropertyReference1(Object r1, Class r2, String r3, String r4, int r5) {
        super(r1, r2, r3, r4, r5);
    }
}
