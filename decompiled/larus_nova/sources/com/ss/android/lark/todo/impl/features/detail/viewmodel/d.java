package com.ss.android.lark.todo.impl.features.detail.viewmodel;

import com.ss.android.lark.todo.impl.features.detail.dependent.TaskDependentSearchViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class d implements com.larksuite.framework.section.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f443818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TaskDependentSearchViewModel.Companion.TaskDependentType f443819b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f443818a, r101.f443818a) == true) goto L12;
        return false;
    L12:
        if (this.f443819b == r101.f443819b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f443818a.hashCode() * 31) + this.f443819b.hashCode();
    }

    public final String toString() {
        return "DependentRemoveInfo(removeGuid=" + this.f443818a + ", type=" + this.f443819b + ')';
    }

    public final TaskDependentSearchViewModel.Companion.TaskDependentType getType() {
        return this.f443819b;
    }

    public d(String r100, TaskDependentSearchViewModel.Companion.TaskDependentType r101) {
        Intrinsics.checkNotNullParameter(r100, "removeGuid");
        Intrinsics.checkNotNullParameter(r101, "type");
        this.f443818a = r100;
        this.f443819b = r101;
    }
}
