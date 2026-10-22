package com.bytedance.android.shopping.commentv3.uitree.list;

import androidx.fragment.app.Fragment;
import com.bytedance.android.shopping.commentv3.base.BaseCommentLogic;
import com.bytedance.android.shopping.commentv3.data.CommentDataCenter;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends BaseCommentLogic<b> {

    /* JADX INFO: renamed from: com.bytedance.android.shopping.commentv3.uitree.list.a$a, reason: collision with other inner class name */
    public static final class C0048a<T> implements Observer {
        public final /* synthetic */ a a;

        public C0048a(a r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            final lc3.b r4 = (lc3.b) r3;
            this.a.e(new CommentListLogic$onCreate$$inlined$let$lambda$1$1(r4));
        }
    }

    @Override // com.bytedance.android.shopping.commentv3.base.e
    public final void a() {
        com.bytedance.android.shopping.commentv3.base.c r0 = this.c;
        if (r0 == null) goto L10;
        Fragment r1 = r0.b;
        if (r1 == null) goto L11;
        com.bytedance.android.shopping.commentv3.data.b r2 = this.d;
        if (r2 == null) goto L12;
        C0048a r3 = new C0048a(this);
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
    L11:
        return;
    }

    public a() {
    }
}
