package pt8;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class b implements ot8.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f530664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f530665b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f530666c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f530667d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f530668e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f530669f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f530670g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f530671h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function1<Boolean, Unit> f530672i;

    public b() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f530664a == r101.f530664a) goto L12;
        return false;
    L12:
        if (this.f530665b == r101.f530665b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f530666c, r101.f530666c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f530667d, r101.f530667d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f530668e, r101.f530668e) == true) goto L24;
        return false;
    L24:
        if (this.f530669f == r101.f530669f) goto L27;
        return false;
    L27:
        if (this.f530670g == r101.f530670g) goto L30;
        return false;
    L30:
        if (this.f530671h == r101.f530671h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f530672i, r101.f530672i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f530664a * 31;
        int r101 = 1231;
        if (this.f530665b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        String r104 = this.f530666c;
        int r105 = 0;
        if (r104 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r103 + r106) * 31;
        String r108 = this.f530667d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Integer r111 = this.f530668e;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        if (this.f530669f == false) goto L21;
        int r114 = 1231;
    L22:
        int r115 = (r113 + r114) * 31;
        if (this.f530670g == false) goto L25;
        int r116 = 1231;
    L26:
        int r117 = (r115 + r116) * 31;
        if (this.f530671h == true) goto L30;
        r101 = 1237;
    L30:
        int r118 = (r117 + r101) * 31;
        Function1<Boolean, Unit> r119 = this.f530672i;
        if (r119 == null) goto L35;
        r105 = r119.hashCode();
    L35:
        return r118 + r105;
    L25:
        r116 = 1237;
        goto L26
    L21:
        r114 = 1237;
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r104.hashCode();
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "WidgetCardMenu(id=" + this.f530664a + ", removeAroundDivider=" + this.f530665b + ", textString=" + this.f530666c + ", iconUrl=" + this.f530667d + ", textColor=" + this.f530668e + ", isSelected=" + this.f530669f + ", forbiddenDismissAfterClick=" + this.f530670g + ", disableClick=" + this.f530671h + ", onTap=" + this.f530672i + ')';
    }

    @Override // ot8.a
    public final boolean a() {
        return this.f530665b;
    }

    @Override // ot8.a
    public final int getId() {
        return this.f530664a;
    }

    public b(int r100, String r101, String r102, Integer r103, boolean r104, boolean r105, Function1 r106) {
        this.f530664a = r100;
        this.f530665b = false;
        this.f530666c = r101;
        this.f530667d = r102;
        this.f530668e = r103;
        this.f530669f = false;
        this.f530670g = r104;
        this.f530671h = r105;
        this.f530672i = r106;
    }
}
