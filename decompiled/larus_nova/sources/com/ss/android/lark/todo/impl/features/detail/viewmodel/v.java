package com.ss.android.lark.todo.impl.features.detail.viewmodel;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class v implements com.larksuite.framework.section.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f443900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f443901b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof v) == true) goto L8;
        return false;
    L8:
        v r101 = (v) r100;
        if (Intrinsics.areEqual(this.f443900a, r101.f443900a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f443901b, r101.f443901b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f443900a.hashCode() * 31) + this.f443901b.hashCode();
    }

    public final String toString() {
        return "SectionItemClickData(containerGuid=" + this.f443900a + ", sectionGuid=" + this.f443901b + ')';
    }

    public v(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "containerGuid");
        Intrinsics.checkNotNullParameter(r101, "sectionGuid");
        this.f443900a = r100;
        this.f443901b = r101;
    }
}
