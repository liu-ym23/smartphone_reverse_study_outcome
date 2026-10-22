package com.ss.android.lark.todo.impl.features.detail.viewmodel.data;

import com.bytedance.lark.pb.basic.v1.RichContent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RichContent f443863a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f443863a, ((j) r100).f443863a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        RichContent r100 = this.f443863a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "TextFieldValue(richContent=" + this.f443863a + ')';
    }

    public j(RichContent r100) {
        this.f443863a = r100;
    }
}
