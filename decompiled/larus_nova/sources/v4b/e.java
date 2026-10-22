package v4b;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f553222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f553223b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f553224c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f553225d;

    public e() {
        this(false, false, null, false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f553222a == r101.f553222a) goto L12;
        return false;
    L12:
        if (this.f553223b == r101.f553223b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f553224c, r101.f553224c) == true) goto L18;
        return false;
    L18:
        if (this.f553225d == r101.f553225d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f553222a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f553223b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        Integer r105 = this.f553224c;
        if (r105 != null) goto L13;
        int r106 = 0;
    L14:
        int r107 = (r104 + r106) * 31;
        if (this.f553225d == true) goto L19;
        r100 = 1237;
    L19:
        return r107 + r100;
    L13:
        r106 = r105.hashCode();
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "TimeLineConfig(disableNewDayLabel=" + this.f553222a + ", disableNewMessageLine=" + this.f553223b + ", newMessagetextColor=" + this.f553224c + ", enableEditMode=" + this.f553225d + ')';
    }

    public e(boolean r100, boolean r101, Integer r102, boolean r103) {
        this.f553222a = r100;
        this.f553223b = r101;
        this.f553224c = r102;
        this.f553225d = r103;
    }
}
