package v59;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f553279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f553280b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f553281c;

    public /* synthetic */ a() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f553279a == r101.f553279a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f553280b, r101.f553280b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f553281c, r101.f553281c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f553279a * 31;
        Integer r101 = this.f553280b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.f553281c.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "MessageModeOption(titleResId=" + this.f553279a + ", subtitleResId=" + this.f553280b + ", mode=" + this.f553281c + ')';
    }

    public a(int r100, Integer r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "mode");
        this.f553279a = r100;
        this.f553280b = r101;
        this.f553281c = r102;
    }
}
