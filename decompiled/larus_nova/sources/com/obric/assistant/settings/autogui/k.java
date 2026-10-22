package com.obric.assistant.settings.autogui;

import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f391934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f391935b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f391934a, r101.f391934a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f391935b, r101.f391935b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f391934a.hashCode() * 31) + this.f391935b.hashCode();
    }

    public final String toString() {
        return "ObricAutoGuiFastModeUseOption(displayModel=" + this.f391934a + ", model=" + this.f391935b + ')';
    }

    public k(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "displayModel");
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        this.f391934a = r100;
        this.f391935b = r101;
    }
}
