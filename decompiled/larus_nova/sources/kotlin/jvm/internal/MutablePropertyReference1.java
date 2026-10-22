package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KMutableProperty;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KProperty;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: classes.dex */
public abstract class MutablePropertyReference1 extends MutablePropertyReference implements KMutableProperty1 {
    @Override // kotlin.jvm.internal.CallableReference
    public KCallable computeReflected() {
        return Reflection.mutableProperty1(this);
    }

    @Override // kotlin.reflect.KProperty
    public KProperty1.Getter getGetter() {
        return ((KMutableProperty1) getReflected()).getGetter();
    }

    @Override // kotlin.reflect.KMutableProperty
    public KMutableProperty1.Setter getSetter() {
        return ((KMutableProperty1) getReflected()).getSetter();
    }

    public MutablePropertyReference1() {
    }

    @Override // kotlin.reflect.KProperty
    public /* bridge */ /* synthetic */ KProperty.Getter getGetter() {
        return getGetter();
    }

    @Override // kotlin.reflect.KMutableProperty
    public /* bridge */ /* synthetic */ KMutableProperty.Setter getSetter() {
        return getSetter();
    }

    public MutablePropertyReference1(Object r100) {
        super(r100);
    }

    @Override // kotlin.reflect.KProperty1
    public Object getDelegate(Object r100) {
        return ((KMutableProperty1) getReflected()).getDelegate(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object r100) {
        return get(r100);
    }

    public MutablePropertyReference1(Object r100, Class r101, String r102, String r103, int r104) {
        super(r100, r101, r102, r103, r104);
    }
}
