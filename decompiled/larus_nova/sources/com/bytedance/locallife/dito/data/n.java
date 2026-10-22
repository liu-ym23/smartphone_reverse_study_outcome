package com.bytedance.locallife.dito.data;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<eq6.b> f258226a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f258226a, ((n) r100).f258226a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f258226a.hashCode();
    }

    public final String toString() {
        return "DitoTreeNodeWakeUpMessage(updateMessage=" + this.f258226a + ')';
    }

    public n() {
        this(new ArrayList());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n(List<? extends eq6.b> r100) {
        Intrinsics.checkNotNullParameter(r100, "updateMessage");
        this.f258226a = r100;
    }
}
