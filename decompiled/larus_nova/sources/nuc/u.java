package nuc;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class u<T> extends ClassValue<l1<T>> {
    public u() {
    }

    @Override // java.lang.ClassValue
    public final Object computeValue(Class r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return new l1();
    }
}
