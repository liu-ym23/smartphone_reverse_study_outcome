package com.ss.android.lark.todo.impl.features.detail.viewmodel.data;

import com.bytedance.lark.pb.todo.v1.SelectFieldOption;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SelectFieldOption f443861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<SelectFieldOption> f443862b;

    public final String toString() {
        return "SingleSelectFieldValue(selectedOption=" + this.f443861a + ", allList=" + this.f443862b + ')';
    }

    public final int hashCode() {
        SelectFieldOption r100 = this.f443861a;
        if (r100 == null) goto L7;
        String r101 = r100.guid;
        if (r101 == null) goto L7;
        return r101.hashCode();
    L7:
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        SelectFieldOption r101 = this.f443861a;
        String r102 = null;
        if (r101 == null) goto L11;
        String r103 = r101.guid;
    L12:
        SelectFieldOption r104 = ((i) r100).f443861a;
        if (r104 == null) goto L16;
        r102 = r104.guid;
    L16:
        if (Intrinsics.areEqual(r103, r102) == true) goto L18;
        return false;
    L18:
        return true;
    L11:
        r103 = null;
        goto L12
    }

    public i(SelectFieldOption r100, List<SelectFieldOption> r101) {
        Intrinsics.checkNotNullParameter(r101, "allList");
        this.f443861a = r100;
        this.f443862b = r101;
    }
}
