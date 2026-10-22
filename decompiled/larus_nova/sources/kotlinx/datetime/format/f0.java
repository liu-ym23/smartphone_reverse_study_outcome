package kotlinx.datetime.format;

import bytedance.jvm.time.DateTimeException;
import bytedance.jvm.time.ZoneOffset;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes42.dex */
public final class f0 implements e1, kotlinx.datetime.internal.format.parser.c<f0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Boolean f505215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f505216b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f505217c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Integer f505218d;

    public f0() {
        this(null, null, null, null);
    }

    public final fuc.j a() {
        if (Intrinsics.areEqual(this.f505215a, Boolean.TRUE) == false) goto L5;
        int r100 = -1;
    L6:
        Integer r101 = this.f505216b;
        Integer r102 = null;
        if (r101 == null) goto L9;
        Integer r103 = Integer.valueOf(r101.intValue() * r100);
    L10:
        Integer r104 = this.f505217c;
        if (r104 == null) goto L13;
        Integer r105 = Integer.valueOf(r104.intValue() * r100);
    L14:
        Integer r106 = this.f505218d;
        if (r106 == null) goto L17;
        r102 = Integer.valueOf(r106.intValue() * r100);
    L17:
        Lazy r107 = fuc.o.f478943a;
        int r108 = 0;
        if (r103 == null) goto L28;
        int r109 = r103.intValue();     // Catch: DateTimeException -> L26
        if (r105 == null) goto L22;
        int r110 = r105.intValue();     // Catch: DateTimeException -> L26
    L23:
        if (r102 == null) goto L25;
        r108 = r102.intValue();     // Catch: DateTimeException -> L26
    L25:
        fuc.j r111 = new fuc.j(ZoneOffset.ofHoursMinutesSeconds(r109, r110, r108));     // Catch: DateTimeException -> L26
    L37:
        return r111;
    L22:
        r110 = 0;
        goto L23
    L28:
        if (r105 == null) goto L34;
        int r112 = r105.intValue() / 60;     // Catch: DateTimeException -> L26
        int r113 = r105.intValue() % 60;     // Catch: DateTimeException -> L26
        if (r102 == null) goto L32;
        r108 = r102.intValue();     // Catch: DateTimeException -> L26
    L32:
        r111 = new fuc.j(ZoneOffset.ofHoursMinutesSeconds(r112, r113, r108));     // Catch: DateTimeException -> L26
        goto L37
    L34:
        if (r102 == null) goto L36;
        r108 = r102.intValue();     // Catch: DateTimeException -> L26
    L36:
        r111 = new fuc.j(ZoneOffset.ofTotalSeconds(r108));     // Catch: DateTimeException -> L26
    L26:
        e = move-exception;
        throw new IllegalArgumentException(e);
    L13:
        r105 = null;
        goto L14
    L9:
        r103 = null;
        goto L10
    L5:
        r100 = 1;
        goto L6
    }

    @Override // kotlinx.datetime.internal.format.parser.c
    public final f0 copy() {
        return new f0(this.f505215a, this.f505216b, this.f505217c, this.f505218d);
    }

    public final int hashCode() {
        Boolean r100 = this.f505215a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        Integer r103 = this.f505216b;
        if (r103 == null) goto L9;
        int r104 = r103.hashCode();
    L10:
        int r105 = r102 + r104;
        Integer r106 = this.f505217c;
        if (r106 == null) goto L13;
        int r107 = r106.hashCode();
    L14:
        int r108 = r105 + r107;
        Integer r109 = this.f505218d;
        if (r109 == null) goto L18;
        r101 = r109.hashCode();
    L18:
        return r108 + r101;
    L13:
        r107 = 0;
        goto L14
    L9:
        r104 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder();
        Boolean r101 = this.f505215a;
        if (r101 != null) goto L5;
        String r102 = " ";
    L9:
        r100.append(r102);
        Object r103 = this.f505216b;
        Object r104 = "??";
        if (r103 != null) goto L12;
        r103 = "??";
    L12:
        r100.append(r103);
        r100.append(':');
        Object r105 = this.f505217c;
        if (r105 != null) goto L15;
        r105 = "??";
    L15:
        r100.append(r105);
        r100.append(':');
        Integer r106 = this.f505218d;
        if (r106 == null) goto L19;
        r104 = r106;
    L19:
        r100.append(r104);
        return r100.toString();
    L5:
        if (r101.booleanValue() == false) goto L7;
        r102 = "-";
        goto L9
    L7:
        r102 = Marker.ANY_NON_NULL_MARKER;
        goto L9
    }

    @Override // kotlinx.datetime.format.e1
    public final Boolean isNegative() {
        return this.f505215a;
    }

    @Override // kotlinx.datetime.format.e1
    public final Integer l() {
        return this.f505216b;
    }

    @Override // kotlinx.datetime.format.e1
    public final Integer m() {
        return this.f505217c;
    }

    @Override // kotlinx.datetime.format.e1
    public final Integer q() {
        return this.f505218d;
    }

    @Override // kotlinx.datetime.format.e1
    public final void b(Integer r100) {
        this.f505216b = r100;
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof f0) == false) goto L13;
        f0 r101 = (f0) r100;
        if (Intrinsics.areEqual(this.f505215a, r101.f505215a) == false) goto L13;
        if (Intrinsics.areEqual(this.f505216b, r101.f505216b) == false) goto L13;
        if (Intrinsics.areEqual(this.f505217c, r101.f505217c) == false) goto L13;
        if (Intrinsics.areEqual(this.f505218d, r101.f505218d) == false) goto L13;
        return true;
    L13:
        return false;
    }

    @Override // kotlinx.datetime.format.e1
    public final void h(Integer r100) {
        this.f505217c = r100;
    }

    @Override // kotlinx.datetime.format.e1
    public final void v(Boolean r100) {
        this.f505215a = r100;
    }

    @Override // kotlinx.datetime.format.e1
    public final void x(Integer r100) {
        this.f505218d = r100;
    }

    public f0(Boolean r100, Integer r101, Integer r102, Integer r103) {
        this.f505215a = r100;
        this.f505216b = r101;
        this.f505217c = r102;
        this.f505218d = r103;
    }
}
