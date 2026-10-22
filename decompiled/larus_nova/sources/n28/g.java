package n28;

import android.content.res.Configuration;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class g extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Configuration f516755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<Configuration, Unit> f516756b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L10;
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f516755a, r101.f516755a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f516756b, r101.f516756b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Configuration r100 = this.f516755a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Function1<Configuration, Unit> r104 = this.f516756b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "OnConfigurationChangedParam(newConfig=" + this.f516755a + ", superMethod=" + this.f516756b + ")";
    }

    @Override // n28.a
    public final void b() {
        this.f516756b.invoke(this.f516755a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(Configuration r100, Function1<? super Configuration, Unit> r101) {
        this.f516755a = r100;
        this.f516756b = r101;
    }
}
