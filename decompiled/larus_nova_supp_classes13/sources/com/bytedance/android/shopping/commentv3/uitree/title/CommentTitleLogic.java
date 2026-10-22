package com.bytedance.android.shopping.commentv3.uitree.title;

import androidx.fragment.app.Fragment;
import com.bytedance.android.shopping.commentv3.base.BaseCommentLogic;
import com.bytedance.android.shopping.commentv3.data.CommentDataCenter;
import com.bytedance.android.shopping.commentv3.data.interfaces.SubTitle;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CommentTitleLogic extends BaseCommentLogic<com.bytedance.android.shopping.commentv3.uitree.title.a> {

    public static final class a<T> implements Observer {
        public final /* synthetic */ CommentTitleLogic a;

        public a(CommentTitleLogic r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            final p53.e r4 = (p53.e) r3;
            this.a.e(new CommentTitleLogic$onCreate$$inlined$let$lambda$1$1(r4));
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ CommentTitleLogic a;

        public b(CommentTitleLogic r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            final SubTitle r4 = (SubTitle) r3;
            this.a.e(new CommentTitleLogic$onCreate$$inlined$let$lambda$2$1(r4));
        }
    }

    @Override // com.bytedance.android.shopping.commentv3.base.e
    public final void a() {
        e(new CommentTitleLogic$onCreate$1(this));
        com.bytedance.android.shopping.commentv3.base.c r0 = this.c;
        if (r0 == null) goto L13;
        Fragment r1 = r0.b;
        if (r1 == null) goto L14;
        com.bytedance.android.shopping.commentv3.data.b r2 = this.d;
        if (r2 == null) goto L9;
        a r4 = new a(this);
        Intrinsics.checkNotNullParameter(r1, "owner");
        Intrinsics.checkNotNullParameter(r4, "observer");
        CommentDataCenter r3 = r2.h;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r1, "owner");
        Intrinsics.checkNotNullParameter(r4, "observer");
        r3.s.observe(r1, r4);
    L9:
        com.bytedance.android.shopping.commentv3.data.b r5 = this.d;
        if (r5 == null) goto L15;
        b r6 = new b(this);
        Intrinsics.checkNotNullParameter(r1, "owner");
        Intrinsics.checkNotNullParameter(r6, "observer");
        CommentDataCenter r7 = r5.h;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r1, "owner");
        Intrinsics.checkNotNullParameter(r6, "observer");
        r7.u.observe(r1, r6);
        return;
    L15:
        return;
    L14:
        return;
    }

    public CommentTitleLogic() {
    }
}
