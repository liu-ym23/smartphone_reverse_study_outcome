package fy8;

import com.larus.canvas.feature.ability.UpdateProgress;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UpdateProgress f479291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f479292b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f479293c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f479291a == r101.f479291a) goto L12;
        return false;
    L12:
        if (this.f479292b == r101.f479292b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f479293c, r101.f479293c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f479291a.hashCode() * 31) + this.f479292b) * 31;
        Boolean r101 = this.f479293c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "BottomInsetUpdateInfo(updateProgress=" + this.f479291a + ", padding=" + this.f479292b + ", isImeShowing=" + this.f479293c + ')';
    }

    public a(UpdateProgress r100, int r101, Boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "updateProgress");
        this.f479291a = r100;
        this.f479292b = r101;
        this.f479293c = r102;
    }
}
