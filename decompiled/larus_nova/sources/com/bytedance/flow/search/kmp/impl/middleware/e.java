package com.bytedance.flow.search.kmp.impl.middleware;

import com.bytedance.flow.search.kmp.api.model.FlowSearchData;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<FlowSearchData> f243586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<FlowSearchData> f243587b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f243588c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f243589d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f243586a, r101.f243586a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f243587b, r101.f243587b) == true) goto L15;
        return false;
    L15:
        if (this.f243588c == r101.f243588c) goto L18;
        return false;
    L18:
        if (this.f243589d == r101.f243589d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f243586a.hashCode() * 31) + this.f243587b.hashCode()) * 31;
        int r101 = 1231;
        if (this.f243588c == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f243589d == true) goto L11;
        r101 = 1237;
    L11:
        return r103 + r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "MessageCacheSnapshot(localMessage=" + this.f243586a + ", remoteMessage=" + this.f243587b + ", localFailed=" + this.f243588c + ", remoteFailed=" + this.f243589d + ')';
    }

    public e(List<FlowSearchData> r100, List<FlowSearchData> r101, boolean r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "localMessage");
        Intrinsics.checkNotNullParameter(r101, "remoteMessage");
        this.f243586a = r100;
        this.f243587b = r101;
        this.f243588c = r102;
        this.f243589d = r103;
    }
}
