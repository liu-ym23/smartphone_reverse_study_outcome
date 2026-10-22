package com.larus.collection.impl.view;

import com.larus.platform.model.MessageCollection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f325629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<MessageCollection> f325630b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f325629a == r101.f325629a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f325630b, r101.f325630b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f325629a * 31) + this.f325630b.hashCode();
    }

    public final String toString() {
        return "CollectionListResponse(status=" + this.f325629a + ", list=" + this.f325630b + ')';
    }

    public b(@ResultStatus int r100, List<MessageCollection> r101) {
        Intrinsics.checkNotNullParameter(r101, "list");
        this.f325629a = r100;
        this.f325630b = r101;
    }
}
