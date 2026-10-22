package com.larksuite.arch.jack;

import com.ss.android.lark.chat.entity.preview.PullUrlPreviewChatterListResponse;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class m<T> extends a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f282808a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f282808a, ((m) r100).f282808a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        T r100 = this.f282808a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "Success(value=" + this.f282808a + ')';
    }

    @Override // com.larksuite.arch.jack.a
    public final T a() {
        return this.f282808a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m(PullUrlPreviewChatterListResponse r100) {
        this.f282808a = r100;
    }
}
