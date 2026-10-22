package com.bytedance.android.shopping.commentv3.uitree.p000float;

import androidx.fragment.app.Fragment;
import com.bytedance.android.shopping.commentv3.base.BaseCommentLogic;
import com.bytedance.android.shopping.commentv3.base.c;
import com.bytedance.android.shopping.commentv3.data.CommentDataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b extends BaseCommentLogic<c> {
    @Override // com.bytedance.android.shopping.commentv3.base.e
    public final void a() {
        c r0 = this.c;
        if (r0 == null) goto L11;
        Fragment r1 = r0.b;
        if (r1 == null) goto L13;
        com.bytedance.android.shopping.commentv3.data.b r2 = this.d;
        if (r2 == null) goto L12;
        a r3 = new a(this);
        Intrinsics.checkNotNullParameter(r1, "owner");
        Intrinsics.checkNotNullParameter(r3, "observer");
        CommentDataCenter r4 = r2.h;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r1, "owner");
        Intrinsics.checkNotNullParameter(r3, "observer");
        r4.r.e(r1, r3);
        return;
    L12:
        return;
    L13:
        return;
    }

    public b() {
    }
}
