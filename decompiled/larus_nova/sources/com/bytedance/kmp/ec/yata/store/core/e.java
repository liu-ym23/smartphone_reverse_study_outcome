package com.bytedance.kmp.ec.yata.store.core;

import com.bytedance.kmp.ec.yata.common.render.TreeType;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TreeType f251734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<RenderTreeStruct> f251735b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f251734a == r101.f251734a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f251735b, r101.f251735b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f251734a.hashCode() * 31) + this.f251735b.hashCode();
    }

    public final String toString() {
        return "RenderTreeGroup(type=" + this.f251734a + ", treeStructList=" + this.f251735b + ')';
    }

    public final TreeType getType() {
        return this.f251734a;
    }

    public e(TreeType r100, List<RenderTreeStruct> r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "treeStructList");
        this.f251734a = r100;
        this.f251735b = r101;
    }
}
