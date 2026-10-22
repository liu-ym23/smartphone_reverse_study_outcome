package com.bytedance.android.shopping.commentv3.base;

import android.content.Context;
import com.bytedance.android.shopping.commentv3.base.b;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public class BaseCommentLogic<State extends b> extends a<State> {
    public c c;
    public com.bytedance.android.shopping.commentv3.data.b d;
    public final Lazy e;

    public final Context getContext() {
        return (Context) this.e.getValue();
    }

    public BaseCommentLogic() {
        this.e = LazyKt.lazy(new BaseCommentLogic$context$2(this));
    }
}
