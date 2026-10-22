package kotlin.jvm.internal;

import kotlin.reflect.KMutableProperty;

/* JADX INFO: loaded from: classes.dex */
public abstract class MutablePropertyReference extends PropertyReference implements KMutableProperty {
    public MutablePropertyReference() {
    }

    public MutablePropertyReference(Object r100) {
        super(r100);
    }

    public MutablePropertyReference(Object r100, Class r101, String r102, String r103, int r104) {
        super(r100, r101, r102, r103, r104);
    }
}
