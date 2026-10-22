package com.bytedance.android.shopping.commentv3.uitree.root;

import com.bytedance.android.shopping.commentv3.data.interfaces.ToastData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements com.bytedance.android.shopping.commentv3.base.b {
    public final ToastData a;

    public a() {
        this(null);
    }

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof a) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.a, ((a) r2).a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        ToastData r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final String toString() {
        return "CommentRootState(toastData=" + this.a + ")";
    }

    public a(ToastData r1) {
        this.a = r1;
    }
}
