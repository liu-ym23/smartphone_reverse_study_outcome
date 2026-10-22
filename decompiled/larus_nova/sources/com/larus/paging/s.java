package com.larus.paging;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class s<T> extends AbstractList<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f363916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f363917b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<T> f363918c;

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public final int getSize() {
        return (this.f363916a + this.f363918c.size()) + this.f363917b;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final T get(int r100) {
        boolean r101 = true;
        if (r100 >= 0) goto L5;
    L7:
        boolean r102 = false;
    L9:
        if (r102 == true) goto L28;
        int r103 = this.f363916a;
        if (r100 >= (this.f363918c.size() + r103)) goto L15;
        if (r103 > r100) goto L15;
        boolean r104 = true;
    L16:
        if (r104 == true) goto L24;
        int r105 = this.f363916a + this.f363918c.size();
        if (r100 >= size()) goto L22;
        if (r105 > r100) goto L22;
    L23:
        if (r101 == false) goto L26;
        return null;
    L26:
        throw new IndexOutOfBoundsException("Illegal attempt to access index " + r100 + " in ItemSnapshotList of size " + size());
    L22:
        r101 = false;
        goto L23
    L24:
        return (T) ListProtector.get(this.f363918c, r100 - this.f363916a);
    L15:
        r104 = false;
        goto L16
    L28:
        return null;
    L5:
        if (r100 >= this.f363916a) goto L7;
        r102 = true;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public s(int r100, int r101, List<? extends T> r102) {
        Intrinsics.checkNotNullParameter(r102, "items");
        this.f363916a = r100;
        this.f363917b = r101;
        this.f363918c = r102;
    }
}
