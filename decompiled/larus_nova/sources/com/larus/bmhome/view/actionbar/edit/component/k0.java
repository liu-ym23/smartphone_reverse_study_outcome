package com.larus.bmhome.view.actionbar.edit.component;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<l0> f316392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.larus.bmhome.actionbar.model.z1 f316393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final uz8.b f316394c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<uz8.b.C7949b> f316395d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k0) == true) goto L8;
        return false;
    L8:
        k0 r101 = (k0) r100;
        if (Intrinsics.areEqual(this.f316392a, r101.f316392a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f316393b, r101.f316393b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f316394c, r101.f316394c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f316395d, r101.f316395d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f316392a.hashCode() * 31;
        com.larus.bmhome.actionbar.model.z1 r101 = this.f316393b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((((r100 + r102) * 31) + this.f316394c.hashCode()) * 31) + this.f316395d.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "CollaboratedParamSubscribeRequest(selections=" + this.f316392a + ", subscribeConfig=" + this.f316393b + ", trackingExtra=" + this.f316394c + ", featureDetails=" + this.f316395d + ')';
    }

    public final String a() {
        com.larus.bmhome.actionbar.model.z1 r100 = this.f316393b;
        if (r100 == null) goto L10;
        String r101 = r100.f295634a;
        if (r101 != null) goto L7;
        return null;
    L7:
        if ((!StringsKt.isBlank(r101)) == true) goto L9;
        return null;
    L9:
        return r101;
    L10:
        return null;
    }

    public k0(List<l0> r100, com.larus.bmhome.actionbar.model.z1 r101, uz8.b r102, List<uz8.b.C7949b> r103) {
        Intrinsics.checkNotNullParameter(r100, "selections");
        Intrinsics.checkNotNullParameter(r102, "trackingExtra");
        Intrinsics.checkNotNullParameter(r103, "featureDetails");
        this.f316392a = r100;
        this.f316393b = r101;
        this.f316394c = r102;
        this.f316395d = r103;
    }
}
