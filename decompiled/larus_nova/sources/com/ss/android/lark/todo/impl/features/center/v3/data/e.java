package com.ss.android.lark.todo.impl.features.center.v3.data;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class e implements MultiItemEntity, com.ss.android.lark.todo.impl.features.tasklist.events.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f441555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f441556b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f441557c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f441558d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f441559e;

    @Override // com.ss.android.lark.todo.impl.features.tasklist.events.a
    public final void a() {
        this.f441559e = true;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f441555a, r101.f441555a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f441556b, r101.f441556b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f441557c, r101.f441557c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f441558d, r101.f441558d) == true) goto L21;
        return false;
    L21:
        if (this.f441559e == r101.f441559e) goto L23;
        return false;
    L23:
        return true;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public final int getItemType() {
        return 3;
    }

    public final int hashCode() {
        int r100 = ((((((this.f441555a.hashCode() * 31) + this.f441556b.hashCode()) * 31) + this.f441557c.hashCode()) * 31) + this.f441558d.hashCode()) * 31;
        if (this.f441559e == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "TaskEventSecondGroupItem(title=" + this.f441555a + ", groupTitle=" + this.f441556b + ", relatedTaskListGuids=" + this.f441557c + ", guidToName=" + this.f441558d + ", isGroupFirstItem=" + this.f441559e + ')';
    }

    @Override // com.ss.android.lark.todo.impl.features.tasklist.events.a
    public final String b() {
        return this.f441556b;
    }

    @Override // com.ss.android.lark.todo.impl.features.tasklist.events.a
    public final boolean c() {
        return this.f441559e;
    }

    public e(String r100, String r101, List r102, Map r103) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, "groupTitle");
        Intrinsics.checkNotNullParameter(r102, "relatedTaskListGuids");
        Intrinsics.checkNotNullParameter(r103, "guidToName");
        this.f441555a = r100;
        this.f441556b = r101;
        this.f441557c = r102;
        this.f441558d = r103;
        this.f441559e = false;
    }
}
