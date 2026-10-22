package mwc;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes42.dex */
public final class d implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final KClass<?> f516127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f516128b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f516127a, ((d) r100).f516127a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f516127a.hashCode();
    }

    public final String toString() {
        return "q:'" + this.f516128b + '\'';
    }

    public final KClass<?> getType() {
        return this.f516127a;
    }

    @Override // mwc.a
    public final String getValue() {
        return this.f516128b;
    }

    public d(KClass<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f516127a = r100;
        this.f516128b = pwc.a.a(r100);
    }
}
