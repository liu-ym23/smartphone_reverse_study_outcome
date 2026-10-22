package com.ss.android.lark.chat.cot.detail;

import com.ss.android.lark.chat.entity.message.CotStatus;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class q {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final q f414994d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f414995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<k> f414996b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CotStatus f414997c;

    public static final class a {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L8;
        return false;
    L8:
        q r101 = (q) r100;
        if (Intrinsics.areEqual(this.f414995a, r101.f414995a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f414996b, r101.f414996b) == true) goto L15;
        return false;
    L15:
        if (this.f414997c == r101.f414997c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f414995a.hashCode() * 31) + this.f414996b.hashCode()) * 31) + this.f414997c.hashCode();
    }

    public final String toString() {
        return "CotDetailUiState(cotId=" + this.f414995a + ", items=" + this.f414996b + ", status=" + this.f414997c + ')';
    }

    static {
        f414994d = new q("", CollectionsKt.emptyList(), CotStatus.NONE);
    }

    public q(String r100, List<k> r101, CotStatus r102) {
        Intrinsics.checkNotNullParameter(r100, "cotId");
        Intrinsics.checkNotNullParameter(r101, "items");
        Intrinsics.checkNotNullParameter(r102, "status");
        this.f414995a = r100;
        this.f414996b = r101;
        this.f414997c = r102;
    }
}
