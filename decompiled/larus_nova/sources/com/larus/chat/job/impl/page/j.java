package com.larus.chat.job.impl.page;

import com.larus.im.bean.job.AIJob;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<AIJob> f325382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f325383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f325384c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f325385d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f325386e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f325382a, r101.f325382a) == true) goto L12;
        return false;
    L12:
        if (this.f325383b == r101.f325383b) goto L15;
        return false;
    L15:
        if (this.f325384c == r101.f325384c) goto L18;
        return false;
    L18:
        if (this.f325385d == r101.f325385d) goto L21;
        return false;
    L21:
        if (this.f325386e == r101.f325386e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f325382a.hashCode() * 31;
        int r101 = 1231;
        if (this.f325383b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f325384c == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.f325385d == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (r105 + r106) * 31;
        if (this.f325386e == true) goto L19;
        r101 = 1237;
    L19:
        return r107 + r101;
    L13:
        r106 = 1237;
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "ChatJobListLoadSnapshot(jobs=" + this.f325382a + ", loading=" + this.f325383b + ", failure=" + this.f325384c + ", refreshing=" + this.f325385d + ", showRecommendJobs=" + this.f325386e + ')';
    }

    public j() {
        this(CollectionsKt.emptyList(), true, false, false, false);
    }

    public j(List<AIJob> r100, boolean r101, boolean r102, boolean r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "jobs");
        this.f325382a = r100;
        this.f325383b = r101;
        this.f325384c = r102;
        this.f325385d = r103;
        this.f325386e = r104;
    }
}
