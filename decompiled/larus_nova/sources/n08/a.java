package n08;

import com.larksuite.component.universe_design.datepicker.impl.data.CalendarAttr;
import com.larksuite.component.universe_design.util.CalendarDate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f516606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f516607b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CalendarDate f516608c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CalendarAttr f516609d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f516606a == r101.f516606a) goto L12;
        return false;
    L12:
        if (this.f516607b == r101.f516607b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f516608c, r101.f516608c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f516609d, r101.f516609d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f516606a * 31) + this.f516607b) * 31) + this.f516608c.hashCode()) * 31) + this.f516609d.hashCode();
    }

    public final String toString() {
        return "BaseDay(posRow=" + this.f516606a + ", posCol=" + this.f516607b + ", date=" + this.f516608c + ", calendarAttr=" + this.f516609d + ')';
    }

    public a(int r100, int r101, CalendarDate r102, CalendarAttr r103) {
        Intrinsics.checkNotNullParameter(r102, "date");
        Intrinsics.checkNotNullParameter(r103, "calendarAttr");
        this.f516606a = r100;
        this.f516607b = r101;
        this.f516608c = r102;
        this.f516609d = r103;
    }
}
