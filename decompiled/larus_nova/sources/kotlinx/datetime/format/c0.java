package kotlinx.datetime.format;

import bytedance.jvm.time.DateTimeException;
import bytedance.jvm.time.DayOfWeek;
import bytedance.jvm.time.LocalDate;
import com.byted.mgl.merge.service.api.ui.BdpGameHostBaseUIService;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.DateTimeFormatException;

/* JADX INFO: loaded from: classes42.dex */
public final class c0 implements e, kotlinx.datetime.internal.format.parser.c<c0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f505202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f505203b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f505204c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Integer f505205d;

    public c0() {
        this(null, null, null, null);
    }

    public final c0 b() {
        return new c0(this.f505202a, this.f505203b, this.f505204c, this.f505205d);
    }

    public final fuc.e g() {
        Integer r100 = this.f505202a;
        l0.a(r100, BdpGameHostBaseUIService.DATE_PICKER_TYPE_YEAR);
        int r101 = r100.intValue();
        Integer r102 = this.f505203b;
        l0.a(r102, "monthNumber");
        int r103 = r102.intValue();
        Integer r104 = this.f505204c;
        l0.a(r104, "dayOfMonth");
        LocalDate r105 = LocalDate.of(r101, r103, r104.intValue());     // Catch: DateTimeException -> L20
        Intrinsics.checkNotNull(r105);
        fuc.e r106 = new fuc.e(r105);
        Integer r107 = this.f505205d;
        if (r107 == null) goto L19;
        int r108 = r107.intValue();
        DayOfWeek r109 = r106.f478933a.getDayOfWeek();
        Intrinsics.checkNotNullParameter(r109, "<this>");
        if (r108 == (r109.ordinal() + 1)) goto L19;
        StringBuilder r110 = new StringBuilder("Can not create a LocalDate from the given input: the day of week is ");
        if (1 <= r108) goto L11;
    L13:
        boolean r111 = false;
    L14:
        if (r111 == false) goto L18;
        r110.append(fuc.b.f478929a.get(r108 - 1));
        r110.append(" but the date is ");
        r110.append(r106);
        r110.append(", which is a ");
        r110.append(r106.f478933a.getDayOfWeek());
        throw new DateTimeFormatException(r110.toString());
    L18:
        throw new IllegalArgumentException(("Expected ISO day-of-week number in 1..7, got " + r108).toString());
    L11:
        if (r108 >= 8) goto L13;
        r111 = true;
    L19:
        return r106;
    L20:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    public final int hashCode() {
        Integer r100 = this.f505202a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f505203b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = r103 + (r105 * 31);
        Integer r107 = this.f505204c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = r106 + (r108 * 31);
        Integer r110 = this.f505205d;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + (r101 * 31);
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder();
        Object r101 = this.f505202a;
        Object r102 = "??";
        if (r101 != null) goto L5;
        r101 = "??";
    L5:
        r100.append(r101);
        r100.append('-');
        Object r103 = this.f505203b;
        if (r103 != null) goto L8;
        r103 = "??";
    L8:
        r100.append(r103);
        r100.append('-');
        Object r104 = this.f505204c;
        if (r104 != null) goto L11;
        r104 = "??";
    L11:
        r100.append(r104);
        r100.append(" (day of week is ");
        Integer r105 = this.f505205d;
        if (r105 == null) goto L15;
        r102 = r105;
    L15:
        r100.append(r102);
        r100.append(')');
        return r100.toString();
    }

    @Override // kotlinx.datetime.internal.format.parser.c
    public final /* bridge */ /* synthetic */ c0 copy() {
        return b();
    }

    @Override // kotlinx.datetime.format.e
    public final Integer a() {
        return this.f505205d;
    }

    @Override // kotlinx.datetime.format.e
    public final Integer c() {
        return this.f505202a;
    }

    @Override // kotlinx.datetime.format.e
    public final Integer k() {
        return this.f505203b;
    }

    @Override // kotlinx.datetime.format.e
    public final Integer u() {
        return this.f505204c;
    }

    @Override // kotlinx.datetime.format.e
    public final void d(Integer r100) {
        this.f505205d = r100;
    }

    @Override // kotlinx.datetime.format.e
    public final void e(Integer r100) {
        this.f505203b = r100;
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof c0) == false) goto L13;
        c0 r101 = (c0) r100;
        if (Intrinsics.areEqual(this.f505202a, r101.f505202a) == false) goto L13;
        if (Intrinsics.areEqual(this.f505203b, r101.f505203b) == false) goto L13;
        if (Intrinsics.areEqual(this.f505204c, r101.f505204c) == false) goto L13;
        if (Intrinsics.areEqual(this.f505205d, r101.f505205d) == false) goto L13;
        return true;
    L13:
        return false;
    }

    @Override // kotlinx.datetime.format.e
    public final void f(Integer r100) {
        this.f505202a = r100;
    }

    @Override // kotlinx.datetime.format.e
    public final void w(Integer r100) {
        this.f505204c = r100;
    }

    public c0(Integer r100, Integer r101, Integer r102, Integer r103) {
        this.f505202a = r100;
        this.f505203b = r101;
        this.f505204c = r102;
        this.f505205d = r103;
    }
}
