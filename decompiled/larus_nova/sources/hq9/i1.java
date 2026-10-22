package hq9;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class i1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f486640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f486641b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f486642c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i1) == true) goto L8;
        return false;
    L8:
        i1 r101 = (i1) r100;
        if (this.f486640a == r101.f486640a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f486641b, r101.f486641b) == true) goto L15;
        return false;
    L15:
        if (this.f486642c == r101.f486642c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f486640a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        List<String> r103 = this.f486641b;
        if (r103 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r102 + r104) * 31;
        if (this.f486642c == true) goto L15;
        r100 = 1237;
    L15:
        return r105 + r100;
    L9:
        r104 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "FlowWebViewConfig(enableWebViewScc=" + this.f486640a + ", webViewSccWhiteList=" + this.f486641b + ", enableWebViewSeclink=" + this.f486642c + ')';
    }

    public i1(boolean r100, List<String> r101, boolean r102) {
        this.f486640a = r100;
        this.f486641b = r101;
        this.f486642c = r102;
    }
}
