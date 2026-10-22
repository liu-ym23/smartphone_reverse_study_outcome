package kotlinx.datetime.format;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.format.NamedUnsignedIntFieldFormatDirective;

/* JADX INFO: loaded from: classes42.dex */
public final class b1 extends NamedUnsignedIntFieldFormatDirective<e> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MonthNames f505201d;

    public final int hashCode() {
        return this.f505201d.f505182a.hashCode();
    }

    public b1(MonthNames r100) {
        Intrinsics.checkNotNullParameter(r100, "names");
        super(DateFields.f505170b, r100.f505182a, "monthName");
        this.f505201d = r100;
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof b1) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(this.f505201d.f505182a, ((b1) r100).f505201d.f505182a) == false) goto L7;
        return true;
    }
}
