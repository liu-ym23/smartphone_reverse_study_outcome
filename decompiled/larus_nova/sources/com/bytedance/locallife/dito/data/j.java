package com.bytedance.locallife.dito.data;

import com.bytedance.locallife.dito.core.manager.DitoUpdateData;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f258203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DitoPageInfo f258204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f258205c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<DitoUpdateData> f258206d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final k f258207e;

    public j() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (this.f258203a == r101.f258203a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f258204b, r101.f258204b) == true) goto L15;
        return false;
    L15:
        if (this.f258205c == r101.f258205c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f258206d, r101.f258206d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f258207e, r101.f258207e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        if (this.f258203a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        DitoPageInfo r102 = this.f258204b;
        if (r102 != null) goto L9;
        int r103 = 0;
    L11:
        return ((((((r101 + r103) * 31) + this.f258205c) * 31) + this.f258206d.hashCode()) * 31) + this.f258207e.hashCode();
    L9:
        r103 = r102.hashCode();
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "DitoRequestBean(isRefresh=" + this.f258203a + ", pageInfo=" + this.f258204b + ", pageColumns=" + this.f258205c + ", updateDataList=" + this.f258206d + ", requestParams=" + this.f258207e + ')';
    }

    public /* synthetic */ j(int r100) {
        this(true, null, 1, new ArrayList(), new k(null, 31));
    }

    public j(boolean r100, DitoPageInfo r101, int r102, List<DitoUpdateData> r103, k r104) {
        Intrinsics.checkNotNullParameter(r103, "updateDataList");
        Intrinsics.checkNotNullParameter(r104, "requestParams");
        this.f258203a = r100;
        this.f258204b = r101;
        this.f258205c = r102;
        this.f258206d = r103;
        this.f258207e = r104;
    }
}
