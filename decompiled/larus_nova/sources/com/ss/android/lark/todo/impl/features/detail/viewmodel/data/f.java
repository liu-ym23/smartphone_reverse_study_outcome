package com.ss.android.lark.todo.impl.features.detail.viewmodel.data;

import com.bytedance.lark.pb.todo.v1.SelectFieldOption;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<SelectFieldOption> f443855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<SelectFieldOption> f443856b;

    public final String toString() {
        return "MultiSelectFieldValue(selectedList=" + this.f443855a + ", allList=" + this.f443856b + ')';
    }

    public final int hashCode() {
        List<SelectFieldOption> r100 = this.f443855a;
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L7;
        r101.add(((SelectFieldOption) r102.next()).guid);
        goto L4
    L7:
        return r101.hashCode();
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        List<SelectFieldOption> r101 = this.f443855a;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L10:
        if (r103.hasNext() == false) goto L12;
        r102.add(((SelectFieldOption) r103.next()).guid);
        goto L10
    L12:
        List<SelectFieldOption> r104 = ((f) r100).f443855a;
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator<T> r106 = r104.iterator();
    L14:
        if (r106.hasNext() == false) goto L17;
        r105.add(((SelectFieldOption) r106.next()).guid);
        goto L14
    L17:
        if (Intrinsics.areEqual(r102, r105) == true) goto L19;
        return false;
    L19:
        return true;
    }

    public f(List<SelectFieldOption> r100, List<SelectFieldOption> r101) {
        Intrinsics.checkNotNullParameter(r100, "selectedList");
        Intrinsics.checkNotNullParameter(r101, "allList");
        this.f443855a = r100;
        this.f443856b = r101;
    }
}
