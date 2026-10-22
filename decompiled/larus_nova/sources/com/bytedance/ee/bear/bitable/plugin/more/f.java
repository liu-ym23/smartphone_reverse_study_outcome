package com.bytedance.ee.bear.bitable.plugin.more;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f214937c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<BitableMoreItemInfo> f214938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f214939b;

    public static final class a {
        public static f a(ArrayList r100, ArrayList r101) {
            List r102 = CollectionsKt.createListBuilder();
            if (r100 == null) goto L5;
            r102.addAll(r100);
        L5:
            if (r101 == null) goto L7;
            r102.addAll(r101);
        L7:
            List r103 = CollectionsKt.build(r102);
            if (r100 == null) goto L10;
            int r104 = CollectionsKt.getLastIndex(r100);
        L12:
            return new f(r103, r104);
        L10:
            r104 = -1;
            goto L12
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f214938a, r101.f214938a) == true) goto L12;
        return false;
    L12:
        if (this.f214939b == r101.f214939b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f214938a.hashCode() * 31) + this.f214939b;
    }

    public final String toString() {
        return "BitableToolBarMoreMenuContent(items=" + this.f214938a + ", dividerAfterIndex=" + this.f214939b + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(List<? extends BitableMoreItemInfo> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "items");
        this.f214938a = r100;
        this.f214939b = r101;
    }
}
