package kotlinx.coroutines;

import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class a0 extends AbstractCoroutineContextElement {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f504617b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f504618a;

    public static final class a implements CoroutineContext.Key<a0> {
        public a() {
        }
    }

    static {
        f504617b = new a();
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a0) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f504618a, ((a0) r100).f504618a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f504618a.hashCode();
    }

    public final String toString() {
        return "CoroutineName(" + this.f504618a + ')';
    }

    public a0(String r100) {
        super(f504617b);
        this.f504618a = r100;
    }
}
