package hsc;

import com.byted.mgl.merge.service.api.ui.BdpGameHostBaseUIService;
import io.ktor.util.date.Month;
import io.ktor.util.date.WeekDay;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class a implements Comparable<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f487081a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f487082b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f487083c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WeekDay f487084d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f487085e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f487086f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Month f487087g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f487088h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f487089i;

    /* JADX INFO: renamed from: hsc.a$a, reason: collision with other inner class name */
    public static final class C6193a {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f487081a == r101.f487081a) goto L12;
        return false;
    L12:
        if (this.f487082b == r101.f487082b) goto L15;
        return false;
    L15:
        if (this.f487083c == r101.f487083c) goto L18;
        return false;
    L18:
        if (this.f487084d == r101.f487084d) goto L21;
        return false;
    L21:
        if (this.f487085e == r101.f487085e) goto L24;
        return false;
    L24:
        if (this.f487086f == r101.f487086f) goto L27;
        return false;
    L27:
        if (this.f487087g == r101.f487087g) goto L30;
        return false;
    L30:
        if (this.f487088h == r101.f487088h) goto L33;
        return false;
    L33:
        if (this.f487089i == r101.f487089i) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((((((this.f487081a * 31) + this.f487082b) * 31) + this.f487083c) * 31) + this.f487084d.hashCode()) * 31) + this.f487085e) * 31) + this.f487086f) * 31) + this.f487087g.hashCode()) * 31) + this.f487088h) * 31;
        long r101 = this.f487089i;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "GMTDate(seconds=" + this.f487081a + ", minutes=" + this.f487082b + ", hours=" + this.f487083c + ", dayOfWeek=" + this.f487084d + ", dayOfMonth=" + this.f487085e + ", dayOfYear=" + this.f487086f + ", month=" + this.f487087g + ", year=" + this.f487088h + ", timestamp=" + this.f487089i + ')';
    }

    static {
        io.ktor.util.date.a.b(0L);
    }

    @Override // java.lang.Comparable
    public final int compareTo(a r100) {
        a r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "other");
        return Intrinsics.compare(this.f487089i, r101.f487089i);
    }

    public a(int r100, int r101, int r102, WeekDay r103, int r104, int r105, Month r106, int r107, long r110) {
        Intrinsics.checkNotNullParameter(r103, "dayOfWeek");
        Intrinsics.checkNotNullParameter(r106, BdpGameHostBaseUIService.DATE_PICKER_TYPE_MONTH);
        this.f487081a = r100;
        this.f487082b = r101;
        this.f487083c = r102;
        this.f487084d = r103;
        this.f487085e = r104;
        this.f487086f = r105;
        this.f487087g = r106;
        this.f487088h = r107;
        this.f487089i = r110;
    }
}
