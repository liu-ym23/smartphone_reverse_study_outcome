package tb8;

import fh8.d;
import jc8.l;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import lb8.e;
import tk8.c;

/* JADX INFO: loaded from: classes25.dex */
public final class a implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<ow8.a, Unit> f545273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<ow8.a, st8.a, Unit> f545274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f545275c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Unit> f545276d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f545277e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d f545278f;

    public a() {
        this(null, null, null, null, false, null, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f545273a, r101.f545273a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f545274b, r101.f545274b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f545275c, r101.f545275c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f545276d, r101.f545276d) == true) goto L21;
        return false;
    L21:
        if (this.f545277e == r101.f545277e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f545278f, r101.f545278f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        Function1<ow8.a, Unit> r100 = this.f545273a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Function2<ow8.a, st8.a, Unit> r104 = this.f545274b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Function0<Unit> r107 = this.f545275c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Function0<Unit> r110 = this.f545276d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        if (this.f545277e == false) goto L21;
        int r113 = 1231;
    L22:
        int r114 = (r112 + r113) * 31;
        d r115 = this.f545278f;
        if (r115 == null) goto L27;
        r101 = r115.hashCode();
    L27:
        return r114 + r101;
    L21:
        r113 = 1237;
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "DeepThinkParentContext(clickAction=" + this.f545273a + ", longClickAction=" + this.f545274b + ", onRefresh=" + this.f545275c + ", onExpandThink=" + this.f545276d + ", isDeepThinkingStreaming=" + this.f545277e + ", deepThinkFoldStatusManager=" + this.f545278f + ')';
    }

    public a(Function1 r100, Function2 r101, c r102, e r103, boolean r104, d r105, int r106) {
        if ((r106 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r106 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r106 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r106 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r106 & 16) == 0) goto L18;
        r104 = false;
    L18:
        if ((r106 & 32) == 0) goto L20;
        r105 = null;
    L20:
        this.f545273a = r100;
        this.f545274b = r101;
        this.f545275c = r102;
        this.f545276d = r103;
        this.f545277e = r104;
        this.f545278f = r105;
    }
}
