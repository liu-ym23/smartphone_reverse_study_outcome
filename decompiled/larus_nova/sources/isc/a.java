package isc;

import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* JADX INFO: loaded from: classes41.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final KClass<?> f495712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Type f495713b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final KType f495714c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f495712a, r101.f495712a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f495713b, r101.f495713b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f495714c, r101.f495714c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f495712a.hashCode() * 31) + this.f495713b.hashCode()) * 31;
        KType r101 = this.f495714c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "TypeInfo(type=" + this.f495712a + ", reifiedType=" + this.f495713b + ", kotlinType=" + this.f495714c + ')';
    }

    public final KClass<?> getType() {
        return this.f495712a;
    }

    public a(KClass<?> r100, Type r101, KType r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "reifiedType");
        this.f495712a = r100;
        this.f495713b = r101;
        this.f495714c = r102;
    }
}
