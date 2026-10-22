package com.larus.bmhome.chat;

/* JADX INFO: loaded from: classes25.dex */
public final class e5 implements t1a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f302944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f302945b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f302946c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f302947d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f302948e;

    public e5() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e5) == true) goto L8;
        return false;
    L8:
        e5 r101 = (e5) r100;
        if (this.f302944a == r101.f302944a) goto L12;
        return false;
    L12:
        if (this.f302945b == r101.f302945b) goto L15;
        return false;
    L15:
        if (this.f302946c == r101.f302946c) goto L18;
        return false;
    L18:
        if (this.f302947d == r101.f302947d) goto L21;
        return false;
    L21:
        if (this.f302948e == r101.f302948e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f302944a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f302945b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f302946c == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.f302947d == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.f302948e == true) goto L23;
        r100 = 1237;
    L23:
        return r108 + r100;
    L17:
        r107 = 1237;
        goto L18
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "SettingsConfig(enableMdWidgetsMixedArrangement=" + this.f302944a + ", enableDataTagOptimize=" + this.f302945b + ", enableTypingAsyncOptimize=" + this.f302946c + ", enableTrackerOptimize=" + this.f302947d + ", enableTableHeader=" + this.f302948e + ')';
    }

    public /* synthetic */ e5(int r100) {
        this(false, false, false, false, false);
    }

    public e5(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104) {
        this.f302944a = r100;
        this.f302945b = r101;
        this.f302946c = r102;
        this.f302947d = r103;
        this.f302948e = r104;
    }
}
