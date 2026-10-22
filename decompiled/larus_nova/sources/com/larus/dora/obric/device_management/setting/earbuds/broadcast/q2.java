package com.larus.dora.obric.device_management.setting.earbuds.broadcast;

import com.obric.oui.button.OIconButtonFloating;
import com.obric.oui.sheet.v2.OSheetTitleBar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class q2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OSheetTitleBar f339927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OIconButtonFloating f339928b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q2) == true) goto L8;
        return false;
    L8:
        q2 r101 = (q2) r100;
        if (Intrinsics.areEqual(this.f339927a, r101.f339927a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f339928b, r101.f339928b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f339927a.hashCode() * 31) + this.f339928b.hashCode();
    }

    public final String toString() {
        return "DoraObricEarbudsSheetTitleBar(view=" + this.f339927a + ", confirmButton=" + this.f339928b + ')';
    }

    public q2(OSheetTitleBar r100, OIconButtonFloating r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "confirmButton");
        this.f339927a = r100;
        this.f339928b = r101;
    }
}
