package kotlin.jvm.internal;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class Ref$ObjectRef<T> implements Serializable {
    public T element;

    public Ref$ObjectRef() {
    }

    public String toString() {
        return String.valueOf(this.element);
    }
}
