package com.ss.android.lark.todo.impl.features.center.v3.tablayout;

import com.bytedance.lark.pb.todo.v1.TaskContainer;
import com.ss.android.lark.todo.impl.features.center.v3.type.ContainerType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f441751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f441752b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TaskContainer.Category f441753c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ContainerType f441754d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f441755e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f441751a, r101.f441751a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f441752b, r101.f441752b) == true) goto L15;
        return false;
    L15:
        if (this.f441753c == r101.f441753c) goto L18;
        return false;
    L18:
        if (this.f441754d == r101.f441754d) goto L21;
        return false;
    L21:
        if (this.f441755e == r101.f441755e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.f441751a.hashCode() * 31) + this.f441752b.hashCode()) * 31) + this.f441753c.hashCode()) * 31) + this.f441754d.hashCode()) * 31) + this.f441755e;
    }

    public final String toString() {
        return "FilterItem(id=" + this.f441751a + ", name=" + this.f441752b + ", category=" + this.f441753c + ", containerType=" + this.f441754d + ", itemCount=" + this.f441755e + ')';
    }

    public /* synthetic */ b(String r100, TaskContainer.Category r101, ContainerType r102) {
        this("", r100, r101, r102, 0);
    }

    public b(String r100, String r101, TaskContainer.Category r102, ContainerType r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r102, "category");
        Intrinsics.checkNotNullParameter(r103, "containerType");
        this.f441751a = r100;
        this.f441752b = r101;
        this.f441753c = r102;
        this.f441754d = r103;
        this.f441755e = r104;
    }
}
