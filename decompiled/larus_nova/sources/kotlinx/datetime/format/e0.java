package kotlinx.datetime.format;

import bytedance.jvm.time.DateTimeException;
import bytedance.jvm.time.LocalTime;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.datetime.DateTimeFormatException;

/* JADX INFO: loaded from: classes42.dex */
public final class e0 implements d1, kotlinx.datetime.internal.format.parser.c<e0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f505209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f505210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AmPmMarker f505211c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Integer f505212d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Integer f505213e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Integer f505214f;

    public e0() {
        this(0);
    }

    public final e0 a() {
        return new e0(this.f505209a, this.f505210b, this.f505211c, this.f505212d, this.f505213e, this.f505214f);
    }

    public final fuc.g b() {
        Integer r100 = this.f505209a;
        int r101 = 12;
        int r102 = 0;
        if (r100 == null) goto L30;
        int r103 = r100.intValue();
        Integer r104 = this.f505210b;
        boolean r105 = true;
        if (r104 == null) goto L14;
        int r106 = r104.intValue();
        if ((((r103 + 11) % 12) + 1) != r106) goto L9;
        boolean r107 = true;
    L10:
        if (r107 == true) goto L14;
        throw new IllegalArgumentException(("Inconsistent hour and hour-of-am-pm: hour is " + r103 + ", but hour-of-am-pm is " + r106).toString());
    L9:
        r107 = false;
    L14:
        AmPmMarker r108 = this.f505211c;
        if (r108 != null) goto L17;
    L44:
        Integer r109 = this.f505212d;
        l0.a(r109, "minute");
        int r110 = r109.intValue();
        Integer r111 = this.f505213e;
        if (r111 == null) goto L47;
        int r112 = r111.intValue();
    L48:
        Integer r113 = this.f505214f;
        if (r113 == null) goto L59;
        r102 = r113.intValue();
    L59:
        LocalTime r114 = LocalTime.of(r103, r110, r112, r102);     // Catch: DateTimeException -> L54
        Intrinsics.checkNotNull(r114);
        return new fuc.g(r114);
    L54:
        e = move-exception;
        throw new IllegalArgumentException(e);
    L47:
        r112 = 0;
        goto L48
    L17:
        if (r108 != AmPmMarker.PM) goto L19;
        boolean r115 = true;
    L20:
        if (r103 < 12) goto L22;
        boolean r116 = true;
    L23:
        if (r115 == r116) goto L26;
        r105 = false;
    L26:
        if (r105 == true) goto L44;
        throw new IllegalArgumentException(("Inconsistent hour and the AM/PM marker: hour is " + r103 + ", but the AM/PM marker is " + r108).toString());
    L22:
        r116 = false;
        goto L23
    L19:
        r115 = false;
        goto L20
    L30:
        Integer r117 = this.f505210b;
        if (r117 == null) goto L41;
        int r118 = r117.intValue();
        AmPmMarker r119 = this.f505211c;
        if (r119 == null) goto L41;
        if (r118 != 12) goto L37;
        r118 = 0;
    L37:
        if (r119 == AmPmMarker.PM) goto L40;
        r101 = 0;
    L40:
        Integer r120 = Integer.valueOf(r118 + r101);
    L42:
        if (r120 == null) goto L58;
        r103 = r120.intValue();
        goto L44
    L58:
        throw new DateTimeFormatException("Incomplete time: missing hour");
    L41:
        r120 = null;
        goto L42
    }

    public final int hashCode() {
        Integer r100 = this.f505209a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.intValue();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f505210b;
        if (r104 == null) goto L9;
        int r105 = r104.intValue();
    L10:
        int r106 = r103 + (r105 * 31);
        AmPmMarker r107 = this.f505211c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = r106 + (r108 * 31);
        Integer r110 = this.f505212d;
        if (r110 == null) goto L17;
        int r111 = r110.intValue();
    L18:
        int r112 = r109 + (r111 * 31);
        Integer r113 = this.f505213e;
        if (r113 == null) goto L21;
        int r114 = r113.intValue();
    L22:
        int r115 = r112 + (r114 * 31);
        Integer r116 = this.f505214f;
        if (r116 == null) goto L26;
        r101 = r116.intValue();
    L26:
        return r115 + r101;
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
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

    @Override // kotlinx.datetime.format.d1
    public final guc.a t() {
        Integer r100 = this.f505214f;
        if (r100 != null) goto L7;
        return null;
    L7:
        return new guc.a(r100.intValue(), 9);
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder();
        Object r101 = this.f505209a;
        Object r102 = "??";
        if (r101 != null) goto L5;
        r101 = "??";
    L5:
        r100.append(r101);
        r100.append(':');
        Object r103 = this.f505212d;
        if (r103 != null) goto L8;
        r103 = "??";
    L8:
        r100.append(r103);
        r100.append(':');
        Integer r104 = this.f505213e;
        if (r104 == null) goto L12;
        r102 = r104;
    L12:
        r100.append(r102);
        r100.append('.');
        Integer r105 = this.f505214f;
        if (r105 == null) goto L16;
        String r106 = String.valueOf(r105.intValue());
        String r107 = StringsKt.padStart(r106, 9 - r106.length(), '0');
        if (r107 == null) goto L16;
    L17:
        r100.append(r107);
        return r100.toString();
    L16:
        r107 = "???";
        goto L17
    }

    @Override // kotlinx.datetime.internal.format.parser.c
    public final /* bridge */ /* synthetic */ e0 copy() {
        return a();
    }

    @Override // kotlinx.datetime.format.d1
    public final Integer g() {
        return this.f505210b;
    }

    @Override // kotlinx.datetime.format.d1
    public final Integer getHour() {
        return this.f505209a;
    }

    @Override // kotlinx.datetime.format.d1
    public final Integer getMinute() {
        return this.f505212d;
    }

    @Override // kotlinx.datetime.format.d1
    public final AmPmMarker i() {
        return this.f505211c;
    }

    @Override // kotlinx.datetime.format.d1
    public final Integer s() {
        return this.f505213e;
    }

    public /* synthetic */ e0(int r100) {
        this(null, null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof e0) == false) goto L17;
        e0 r101 = (e0) r100;
        if (Intrinsics.areEqual(this.f505209a, r101.f505209a) == false) goto L17;
        if (Intrinsics.areEqual(this.f505210b, r101.f505210b) == false) goto L17;
        if (this.f505211c != r101.f505211c) goto L17;
        if (Intrinsics.areEqual(this.f505212d, r101.f505212d) == false) goto L17;
        if (Intrinsics.areEqual(this.f505213e, r101.f505213e) == false) goto L17;
        if (Intrinsics.areEqual(this.f505214f, r101.f505214f) == false) goto L17;
        return true;
    L17:
        return false;
    }

    @Override // kotlinx.datetime.format.d1
    public final void j(Integer r100) {
        this.f505210b = r100;
    }

    @Override // kotlinx.datetime.format.d1
    public final void n(Integer r100) {
        this.f505209a = r100;
    }

    @Override // kotlinx.datetime.format.d1
    public final void o(guc.a r100) {
        if (r100 == null) goto L4;
        Integer r101 = Integer.valueOf(r100.a(9));
    L5:
        this.f505214f = r101;
        return;
    L4:
        r101 = null;
        goto L5
    }

    @Override // kotlinx.datetime.format.d1
    public final void p(Integer r100) {
        this.f505213e = r100;
    }

    @Override // kotlinx.datetime.format.d1
    public final void r(AmPmMarker r100) {
        this.f505211c = r100;
    }

    @Override // kotlinx.datetime.format.d1
    public final void y(Integer r100) {
        this.f505212d = r100;
    }

    public e0(Integer r100, Integer r101, AmPmMarker r102, Integer r103, Integer r104, Integer r105) {
        this.f505209a = r100;
        this.f505210b = r101;
        this.f505211c = r102;
        this.f505212d = r103;
        this.f505213e = r104;
        this.f505214f = r105;
    }
}
