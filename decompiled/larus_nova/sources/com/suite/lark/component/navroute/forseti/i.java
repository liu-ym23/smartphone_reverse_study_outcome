package com.suite.lark.component.navroute.forseti;

import androidx.fragment.app.Fragment;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<Fragment> f460346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f460347b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ForsetiNavOptions.DestinationStyle f460348c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f460346a, r101.f460346a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f460347b, r101.f460347b) == true) goto L15;
        return false;
    L15:
        if (this.f460348c == r101.f460348c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f460346a.hashCode() * 31) + this.f460347b.hashCode()) * 31;
        ForsetiNavOptions.DestinationStyle r101 = this.f460348c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "FragmentNavInfo(fragmentRef=" + this.f460346a + ", route=" + this.f460347b + ", style=" + this.f460348c + ')';
    }

    public i(WeakReference<Fragment> r100, String r101, ForsetiNavOptions.DestinationStyle r102) {
        Intrinsics.checkNotNullParameter(r100, "fragmentRef");
        Intrinsics.checkNotNullParameter(r101, CloudControlInf.ROUTE);
        this.f460346a = r100;
        this.f460347b = r101;
        this.f460348c = r102;
    }
}
