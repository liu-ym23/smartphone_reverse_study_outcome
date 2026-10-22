package ub8;

import com.larus.im.callback.IIMError;
import kotlin.jvm.internal.Intrinsics;
import uc9.t;

/* JADX INFO: loaded from: classes25.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t f549370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Boolean f549371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IIMError f549372c;

    public b() {
        this(null, null, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f549370a, r101.f549370a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f549371b, r101.f549371b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f549372c, r101.f549372c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        t r100 = this.f549370a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.f549371b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        IIMError r107 = this.f549372c;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "BotInfoUpdateResult(botUpdateResult=" + this.f549370a + ", isMuted=" + this.f549371b + ", error=" + this.f549372c + ')';
    }

    public b(t r100, IIMError r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        Boolean r103 = Boolean.FALSE;
    L10:
        if ((r102 & 4) == 0) goto L12;
        r101 = null;
    L12:
        this.f549370a = r100;
        this.f549371b = r103;
        this.f549372c = r101;
        return;
    L8:
        r103 = null;
        goto L10
    }
}
