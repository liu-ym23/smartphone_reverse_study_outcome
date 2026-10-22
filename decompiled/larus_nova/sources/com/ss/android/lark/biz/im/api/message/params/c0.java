package com.ss.android.lark.biz.im.api.message.params;

import com.ss.android.lark.time.format.entity.TimePreciseness;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class c0 implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f410339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f410340b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<Boolean, Boolean> f410341c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f410342d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TimePreciseness f410343e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f410344f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f410345g;

    public c0() {
        this(null, 0.0f, null, 127);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c0) == true) goto L8;
        return false;
    L8:
        c0 r101 = (c0) r100;
        if (Intrinsics.areEqual(this.f410339a, r101.f410339a) == true) goto L12;
        return false;
    L12:
        if (Float.compare(this.f410340b, r101.f410340b) == 0) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f410341c, r101.f410341c) == true) goto L18;
        return false;
    L18:
        if (this.f410342d == r101.f410342d) goto L21;
        return false;
    L21:
        if (this.f410343e == r101.f410343e) goto L24;
        return false;
    L24:
        if (this.f410344f == r101.f410344f) goto L27;
        return false;
    L27:
        if (this.f410345g == r101.f410345g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f410339a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + Float.floatToIntBits(this.f410340b)) * 31;
        Function1<Boolean, Boolean> r104 = this.f410341c;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        int r105 = (r103 + r101) * 31;
        int r106 = 1231;
        if (this.f410342d == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (((r105 + r107) * 31) + this.f410343e.hashCode()) * 31;
        if (this.f410344f == false) goto L17;
        int r109 = 1231;
    L18:
        int r110 = (r108 + r109) * 31;
        if (this.f410345g == true) goto L23;
        r106 = 1237;
    L23:
        return r110 + r106;
    L17:
        r109 = 1237;
        goto L18
    L13:
        r107 = 1237;
        goto L14
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "UsernameBlockCellParam(textColorRes=" + this.f410339a + ", startPaddingDp=" + this.f410340b + ", showUsername=" + this.f410341c + ", showEditInfo=" + this.f410342d + ", timePreciseness=" + this.f410343e + ", hideWhenRTlDisplay=" + this.f410344f + ", useDotSplit=" + this.f410345g + ')';
    }

    public c0(Integer r100, float r101, Function1 r102, int r103) {
        TimePreciseness r104 = null;
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = 0.0f;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        boolean r105 = false;
        if ((r103 & 8) == 0) goto L14;
        boolean r106 = true;
    L16:
        if ((r103 & 16) == 0) goto L19;
        r104 = TimePreciseness.MINUTE;
    L19:
        if ((r103 & 32) == 0) goto L21;
        boolean r107 = true;
    L23:
        if ((r103 & 64) == 0) goto L25;
        r105 = true;
    L25:
        Intrinsics.checkNotNullParameter(r104, "timePreciseness");
        this.f410339a = r100;
        this.f410340b = r101;
        this.f410341c = r102;
        this.f410342d = r106;
        this.f410343e = r104;
        this.f410344f = r107;
        this.f410345g = r105;
        return;
    L21:
        r107 = false;
        goto L23
    L14:
        r106 = false;
        goto L16
    }
}
