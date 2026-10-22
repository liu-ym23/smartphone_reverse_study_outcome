package com.bytedance.android.shopping.commentv3.base;

import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CommentApiCenter {
    public final Lazy a;

    public final List<d> a() {
        return (List) this.a.getValue();
    }

    public CommentApiCenter() {
        this.a = LazyKt.lazy(CommentApiCenter$apiList$2.INSTANCE);
    }
}
