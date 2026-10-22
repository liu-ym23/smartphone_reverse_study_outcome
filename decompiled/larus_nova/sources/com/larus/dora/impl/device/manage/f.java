package com.larus.dora.impl.device.manage;

import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class f implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f333747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f333748b;

    public f() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f333747a, r101.f333747a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f333748b, r101.f333748b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f333747a.hashCode() * 31) + this.f333748b.hashCode();
    }

    public final String toString() {
        return "DoraGDeviceManagementFeedbackItem(id=" + this.f333747a + ", title=" + this.f333748b + ')';
    }

    @Override // com.larus.dora.impl.device.manage.p0
    public final String getId() {
        return this.f333747a;
    }

    public f(int r100) {
        int r101 = com.larus.utils.j0.f375426a;
        String r102 = com.larus.utils.j0.d(R.string.larus_dora_g_feedback_title_cn);
        Intrinsics.checkNotNullParameter("DoraGDeviceManagementFeedbackItem", "id");
        Intrinsics.checkNotNullParameter(r102, "title");
        this.f333747a = "DoraGDeviceManagementFeedbackItem";
        this.f333748b = r102;
    }
}
