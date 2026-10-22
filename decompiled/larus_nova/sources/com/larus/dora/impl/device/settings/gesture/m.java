package com.larus.dora.impl.device.settings.gesture;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<DoraGGestureSettings> f334443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f334444b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.f334443a, r101.f334443a) == true) goto L12;
        return false;
    L12:
        if (this.f334444b == r101.f334444b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f334443a.hashCode() * 31;
        if (this.f334444b == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "DoraGGestureSettingsLoadResult(gestureList=" + this.f334443a + ", shouldShowOtaTooLowToast=" + this.f334444b + ')';
    }

    public m(List<DoraGGestureSettings> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "gestureList");
        this.f334443a = r100;
        this.f334444b = r101;
    }
}
