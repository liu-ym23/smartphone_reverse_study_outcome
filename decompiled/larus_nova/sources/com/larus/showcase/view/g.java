package com.larus.showcase.view;

import com.larus.platform.model.showcase.Case;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f369306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Case> f369307b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f369308c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (this.f369306a == r101.f369306a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f369307b, r101.f369307b) == true) goto L15;
        return false;
    L15:
        if (this.f369308c == r101.f369308c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f369306a * 31) + this.f369307b.hashCode()) * 31;
        if (this.f369308c == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "CaseListResponse(status=" + this.f369306a + ", list=" + this.f369307b + ", isFirstPage=" + this.f369308c + ')';
    }

    public g(@ResultStatus int r100, List<Case> r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "list");
        this.f369306a = r100;
        this.f369307b = r101;
        this.f369308c = r102;
    }
}
