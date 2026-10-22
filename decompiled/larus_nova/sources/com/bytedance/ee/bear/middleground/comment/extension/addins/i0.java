package com.bytedance.ee.bear.middleground.comment.extension.addins;

import android.text.TextUtils;
import com.bytedance.ee.bear.middleground.comment.export.ICardAdapter;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class i0 extends com.bytedance.ee.bear.middleground.comment.extension.addins.b {

    public static final class a {
    }

    public final class b extends ff5.a<ef5.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i0 f231484a;

        public b(i0 r100) {
            this.f231484a = r100;
        }

        @Override // ff5.a
        public final void b(gf5.c r100) {
            final ef5.x r101 = (ef5.x) r100;
            Intrinsics.checkNotNullParameter(r101, "event");
            i0 r102 = this.f231484a;
            CommentBean r103 = r101.f472515b;
            Object r104 = r101.f472514a.getAdapter();
            Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.comment.export.ICardAdapter");
            ICardAdapter r105 = (ICardAdapter) r104;
            Function1<Integer, Unit> r106 = new ScrollFromFeedAddin$ItemPageDataChangedEventHandler$onHandle$1(r101);
            r102.getClass();
            if (TextUtils.isEmpty(r103.getCurrentReplyId()) == true) goto L17;
            int r107 = r105.getCommentDetails().size();
            int r108 = 0;
        L5:
            if (r108 >= r107) goto L23;
            if (r103.getCommentType() != 0) goto L12;
            if (TextUtils.equals(r103.getCurrentReplyId(), ((CommentBean.CommentDetail) ListProtector.get(r105.getCommentDetails(), r108)).getReply_id()) == false) goto L12;
            r106.invoke(Integer.valueOf(r108));
        L16:
            r108 = r108 + 1;
        L12:
            if (r103.getCommentType() != 1) goto L16;
            if (TextUtils.equals(r103.getCurrentReplyId(), ((CommentBean.CommentDetail) ListProtector.get(r105.getCommentDetails(), r108)).getComment_id()) == false) goto L16;
            r106.invoke(Integer.valueOf(r108));
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
    public final void a(cf5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r100, "host");
        this.f231427a = r100;
        r100.b(ef5.x.class, new b(this));
    }
}
