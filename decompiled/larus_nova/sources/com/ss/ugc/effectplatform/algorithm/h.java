package com.ss.ugc.effectplatform.algorithm;

import com.ss.ugc.effectplatform.model.algorithm.ModelInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.ugc.effectplatform.model.d f457254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ModelInfo f457255b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L10;
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f457254a, r101.f457254a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f457255b, r101.f457255b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        com.ss.ugc.effectplatform.model.d r100 = this.f457254a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ModelInfo r104 = this.f457255b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ModelInfoCache(localModelInfo=" + this.f457254a + ", serverModelInfo=" + this.f457255b + ")";
    }

    public h(com.ss.ugc.effectplatform.model.d r100, ModelInfo r101) {
        this.f457254a = r100;
        this.f457255b = r101;
    }
}
