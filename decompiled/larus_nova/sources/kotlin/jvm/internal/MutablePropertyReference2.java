package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KMutableProperty;
import kotlin.reflect.KMutableProperty2;
import kotlin.reflect.KProperty;
import kotlin.reflect.KProperty2;

/* JADX INFO: loaded from: classes6.dex */
public abstract class MutablePropertyReference2 extends MutablePropertyReference implements KMutableProperty2 {
    @Override // kotlin.jvm.internal.CallableReference
    public KCallable computeReflected() {
        return Reflection.mutableProperty2(this);
    }

    @Override // kotlin.reflect.KProperty
    public KProperty2.Getter getGetter() {
        return ((KMutableProperty2) getReflected()).getGetter();
    }

    @Override // kotlin.reflect.KMutableProperty
    public KMutableProperty2.Setter getSetter() {
        return ((KMutableProperty2) getReflected()).getSetter();
    }

    public MutablePropertyReference2() {
    }

    @Override // kotlin.reflect.KProperty
    public /* bridge */ /* synthetic */ KProperty.Getter getGetter() {
        return getGetter();
    }

    @Override // kotlin.reflect.KMutableProperty
    public /* bridge */ /* synthetic */ KMutableProperty.Setter getSetter() {
        return getSetter();
    }

    @Override // kotlin.reflect.KProperty2
    public Object getDelegate(Object r100, Object r101) {
        return ((KMutableProperty2) getReflected()).getDelegate(r100, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public Object invoke(Object r100, Object r101) {
        return get(r100, r101);
    }

    public MutablePropertyReference2(Class r100, String r101, String r102, int r110) {
        super(CallableReference.NO_RECEIVER, r100, r101, r102, r110);
    }
}
