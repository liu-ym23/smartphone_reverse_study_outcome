package com.larus.bmhome.chat.referenceicon;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f308533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f308534b;

    public b() {
        this(null, null, 3);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f308533a, r101.f308533a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f308534b, r101.f308534b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f308533a.hashCode() * 31;
        Integer r101 = this.f308534b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "AttachmentReferenceVisual(thumbnailSources=" + this.f308533a + ", fileIconRes=" + this.f308534b + ')';
    }

    public b(List r100, Integer r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = CollectionsKt.emptyList();
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        Intrinsics.checkNotNullParameter(r100, "thumbnailSources");
        this.f308533a = r100;
        this.f308534b = r101;
    }
}
