package jib;

import com.ss.android.lark.forwardv2.impl.view.m;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f499250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f499251b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f499252c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f499250a, r101.f499250a) == true) goto L12;
        return false;
    L12:
        if (this.f499251b == r101.f499251b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f499252c, r101.f499252c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f499250a.hashCode() * 31) + this.f499251b) * 31;
        a r101 = this.f499252c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "ForwardViewBtnConfig(btnText=" + this.f499250a + ", textColor=" + this.f499251b + ", btnStateDependency=" + this.f499252c + ')';
    }

    public b(String r100, int r101, m r102) {
        Intrinsics.checkNotNullParameter(r100, "btnText");
        this.f499250a = r100;
        this.f499251b = r101;
        this.f499252c = r102;
    }
}
