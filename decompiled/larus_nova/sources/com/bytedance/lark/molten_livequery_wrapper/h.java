package com.bytedance.lark.molten_livequery_wrapper;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class h<Item, KeyChange> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Item> f253399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final KeyChange f253400b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f253401c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        return false;
    }

    public final String toString() {
        return "LiveList(list=" + this.f253399a + ", keyChange=" + this.f253400b + ", handle=" + this.f253401c + ')';
    }

    public final int hashCode() {
        return super.hashCode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(List<? extends Item> r100, KeyChange r101, g r102) {
        Intrinsics.checkNotNullParameter(r100, "list");
        this.f253399a = r100;
        this.f253400b = r101;
        this.f253401c = r102;
    }
}
