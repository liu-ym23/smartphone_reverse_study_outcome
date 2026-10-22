package com.bytedance.locallife.bridge.groupon.method;

import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f257103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f257104b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f257105c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f257106d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b0) == true) goto L8;
        return false;
    L8:
        b0 r101 = (b0) r100;
        if (Intrinsics.areEqual(this.f257103a, r101.f257103a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f257104b, r101.f257104b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f257105c, r101.f257105c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f257106d, r101.f257106d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f257103a.hashCode() * 31) + this.f257104b.hashCode()) * 31;
        Integer r101 = this.f257105c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f257106d;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "TargetViewInfo(module=" + this.f257103a + ", entranceName=" + this.f257104b + ", cardType=" + this.f257105c + ", targetView=" + this.f257106d + ')';
    }

    public b0(String r100, String r101, Integer r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r101, "entranceName");
        this.f257103a = r100;
        this.f257104b = r101;
        this.f257105c = r102;
        this.f257106d = r103;
    }
}
