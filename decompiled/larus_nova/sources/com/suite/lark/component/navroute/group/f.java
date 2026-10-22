package com.suite.lark.component.navroute.group;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class f<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f460385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference<T> f460386b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<f<T>> f460387c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public f<T> f460388d;

    public final int hashCode() {
        return this.f460385a;
    }

    public f(com.suite.lark.component.navroute.api.f r100) {
        this.f460385a = r100.hashCode();
        this.f460386b = new WeakReference(r100);
        this.f460387c = new ArrayList();
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f460386b.get(), ((f) r100).f460386b.get()) == true) goto L11;
        return false;
    L11:
        return true;
    }
}
