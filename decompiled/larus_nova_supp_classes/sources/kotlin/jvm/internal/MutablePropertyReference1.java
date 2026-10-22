package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KMutableProperty;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KProperty;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public abstract class MutablePropertyReference1 extends MutablePropertyReference implements KMutableProperty1 {
    @Override // kotlin.jvm.internal.CallableReference
    public KCallable computeReflected() {
        return Reflection.mutableProperty1(this);
    }

    @Override // kotlin.reflect.KProperty1
    /* JADX INFO: renamed from: getGetter, reason: collision with other method in class */
    public KProperty1.Getter mo165getGetter() {
        return ((KMutableProperty1) getReflected()).mo165getGetter();
    }

    @Override // kotlin.reflect.KMutableProperty1
    /* JADX INFO: renamed from: getSetter, reason: collision with other method in class */
    public KMutableProperty1.Setter mo166getSetter() {
        return ((KMutableProperty1) getReflected()).mo166getSetter();
    }

    public MutablePropertyReference1() {
    }

    @Override // kotlin.reflect.KProperty
    public /* bridge */ /* synthetic */ KProperty.Getter getGetter() {
        return mo165getGetter();
    }

    @Override // kotlin.reflect.KMutableProperty
    public /* bridge */ /* synthetic */ KMutableProperty.Setter getSetter() {
        return mo166getSetter();
    }

    public MutablePropertyReference1(Object r1) {
        super(r1);
    }

    @Override // kotlin.reflect.KProperty1
    public Object getDelegate(Object r2) {
        return ((KMutableProperty1) getReflected()).getDelegate(r2);
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object r1) {
        return get(r1);
    }

    public MutablePropertyReference1(Object r1, Class r2, String r3, String r4, int r5) {
        super(r1, r2, r3, r4, r5);
    }
}
