package kotlinx.datetime.format;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.format.NamedUnsignedIntFieldFormatDirective;

/* JADX INFO: loaded from: classes42.dex */
public final class z extends NamedUnsignedIntFieldFormatDirective<e> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DayOfWeekNames f505252d;

    public final int hashCode() {
        return this.f505252d.f505180a.hashCode();
    }

    public z(DayOfWeekNames r100) {
        Intrinsics.checkNotNullParameter(r100, "names");
        super(DateFields.f505172d, r100.f505180a, "dayOfWeekName");
        this.f505252d = r100;
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof z) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(this.f505252d.f505180a, ((z) r100).f505252d.f505180a) == false) goto L7;
        return true;
    }
}
