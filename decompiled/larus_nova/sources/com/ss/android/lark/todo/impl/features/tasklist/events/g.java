package com.ss.android.lark.todo.impl.features.tasklist.events;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.larksuite.arch.jack.j;
import com.ss.android.lark.todo.impl.adapterhelper.loadmodule.PageLoadingStatus;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class g implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<MultiItemEntity> f444072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PageLoadingStatus f444073b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f444072a, r101.f444072a) == true) goto L12;
        return false;
    L12:
        if (this.f444073b == r101.f444073b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f444072a.hashCode() * 31) + this.f444073b.hashCode();
    }

    public final String toString() {
        return "TaskListEventsState(eventItems=" + this.f444072a + ", loadMoreStatus=" + this.f444073b + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(List<? extends MultiItemEntity> r100, PageLoadingStatus r101) {
        Intrinsics.checkNotNullParameter(r100, "eventItems");
        Intrinsics.checkNotNullParameter(r101, "loadMoreStatus");
        this.f444072a = r100;
        this.f444073b = r101;
    }
}
