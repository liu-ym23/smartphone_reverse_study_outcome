package com.obric.assistant.settings.lockeduse;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f392138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<l> f392139b;

    public m() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (this.f392138a == r101.f392138a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f392139b, r101.f392139b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f392138a == false) goto L5;
        int r100 = 1231;
    L7:
        return (r100 * 31) + this.f392139b.hashCode();
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "ObricLockedUseUiState(enabled=" + this.f392138a + ", rows=" + this.f392139b + ')';
    }

    public /* synthetic */ m(int r100) {
        this(false, CollectionsKt.emptyList());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m(boolean r100, List<? extends l> r101) {
        Intrinsics.checkNotNullParameter(r101, "rows");
        this.f392138a = r100;
        this.f392139b = r101;
    }
}
