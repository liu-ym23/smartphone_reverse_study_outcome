package com.bytedance.ee.bear.middleground.comment.extension.addins;

import android.text.TextUtils;
import com.bytedance.ee.bear.middleground.comment.export.ICardAdapter;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i0 extends com.bytedance.ee.bear.middleground.comment.extension.addins.b {

    public static final class a {
    }

    public final class b extends ff5.a<ef5.x> {
        public final /* synthetic */ i0 a;

        public b(i0 r1) {
            this.a = r1;
        }

        @Override // ff5.a
        public final void b(gf5.c r7) {
            final ef5.x r8 = (ef5.x) r7;
            Intrinsics.checkNotNullParameter(r8, "event");
            i0 r0 = this.a;
            CommentBean r1 = r8.b;
            ICardAdapter r2 = r8.a.getAdapter();
            Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.comment.export.ICardAdapter");
            ICardAdapter r3 = r2;
            Function1<Integer, Unit> r4 = new ScrollFromFeedAddin$ItemPageDataChangedEventHandler$onHandle$1(r8);
            r0.getClass();
            if (TextUtils.isEmpty(r1.getCurrentReplyId()) == true) goto L17;
            int r9 = r3.getCommentDetails().size();
            int r5 = 0;
        L5:
            if (r5 >= r9) goto L23;
            if (r1.getCommentType() != 0) goto L12;
            if (TextUtils.equals(r1.getCurrentReplyId(), ((CommentBean.CommentDetail) ListProtector.get(r3.getCommentDetails(), r5)).getReply_id()) == false) goto L12;
            r4.invoke(Integer.valueOf(r5));
        L16:
            r5 = r5 + 1;
        L12:
            if (r1.getCommentType() != 1) goto L16;
            if (TextUtils.equals(r1.getCurrentReplyId(), ((CommentBean.CommentDetail) ListProtector.get(r3.getCommentDetails(), r5)).getComment_id()) == false) goto L16;
            r4.invoke(Integer.valueOf(r5));
            goto L16
        L23:
            return;
        }
    }

    static {
    }

    public i0() {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.extension.addins.b, gf5.b
    public final void a(cf5.a r3) {
        Intrinsics.checkNotNullParameter(r3, "host");
        Intrinsics.checkNotNullParameter(r3, "host");
        this.a = r3;
        r3.b(ef5.x.class, new b(this));
    }
}
