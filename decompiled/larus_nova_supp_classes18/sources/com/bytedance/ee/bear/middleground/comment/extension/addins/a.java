package com.bytedance.ee.bear.middleground.comment.extension.addins;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.document.comment.CommentPlugin;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter2;
import com.bytedance.ee.bear.middleground.comment.card.aside.AsidePageAdapter;
import com.bytedance.ee.bear.middleground.comment.card.p1;
import com.bytedance.ee.bear.middleground.comment.card.q1;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.ScrollCommentBean;
import com.bytedance.ee.bear.middleground.comment.uitls.RecyclerViewScrollHelper;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends f {
    public static final int d = 0;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.comment.extension.addins.a$a, reason: collision with other inner class name */
    public static final class C0064a {
    }

    public static final class b<V> implements uu5.m.a {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        public final void onSubscribe(Object r7) {
            RecyclerView r8 = (RecyclerView) r7;
            p1 r0 = this.a.getContext().c();
            if (r0 == null) goto L56;
            q1 r1 = r0.jV();
            if (r1 == null) goto L56;
            LinearLayoutManager r9 = r8.getLayoutManager();
            CardAdapter2 r3 = null;
            if ((r9 instanceof LinearLayoutManager) == false) goto L10;
            LinearLayoutManager r10 = r9;
        L11:
            if (r10 != null) goto L13;
            tt5.a.h("Comment#AsideCalcScrollInfoAddin", "layoutManager is null!");
            return;
        L13:
            int r2 = r10.findFirstVisibleItemPosition();
            if (r2 != (-1)) goto L16;
            tt5.a.h("Comment#AsideCalcScrollInfoAddin", "first position is " + r2);
            return;
        L16:
            View r11 = r10.findViewByPosition(r2);
            if (r11 != null) goto L19;
            tt5.a.h("Comment#AsideCalcScrollInfoAddin", "outView is null!");
            return;
        L19:
            RecyclerView r4 = r1.P0(Integer.valueOf(r2));
            if (r4 != null) goto L22;
            tt5.a.h("Comment#AsideCalcScrollInfoAddin", "recyclerViewInner is null!");
            return;
        L22:
            RecyclerView r5 = r1.P0(Integer.valueOf(r2));
            if (r5 == null) goto L25;
            RecyclerView.Adapter r6 = r5.getAdapter();
        L27:
            if ((r6 instanceof CardAdapter2) == false) goto L29;
            r3 = (CardAdapter2) r6;
        L29:
            if (r3 != null) goto L31;
            tt5.a.h("Comment#AsideCalcScrollInfoAddin", "adapter is null!");
            return;
        L31:
            float r12 = 0.0f;
            if (r11.getY() >= 0.0f) goto L34;
            Number r13 = Float.valueOf(Math.abs(r11.getY()) - a.d);
        L35:
            RecyclerViewScrollHelper.a r14 = RecyclerViewScrollHelper.a(r4, r13.intValue());
            int r15 = r14.a;
            if (r15 >= 0) goto L38;
        L55:
            tt5.a.k("Comment#AsideCalcScrollInfoAddin", "calculate scroll position error! scrollData = " + r14 + ", data size = " + r3.getItemCount());
            return;
        L38:
            if (r15 >= r3.getItemCount()) goto L55;
            if (r3.getItemCount() < 2) goto L55;
            if (r14.a >= 1) goto L49;
            String r16 = ((CommentBean.CommentDetail) ListProtector.get(r3.getCommentDetails(), 1)).getComment_id();
            int r17 = ((CommentBean.CommentDetail) ListProtector.get(r3.getCommentDetails(), 1)).getCommentType();
            if (r14.a == 0) goto L48;
            r12 = r14.b;
        L48:
            String r18 = ScrollCommentBean.HEAD;
        L50:
            CommentPlugin.h r19 = this.a.getContext().getConfig().L;
            if (r19 == null) goto L63;
            com.bytedance.ee.bear.document.comment.f0 r20 = CommentPlugin.access$3400(r19.a);
            if (r20 == null) goto L64;
            CommentPlugin.T(r20.a, r16, r17, r18, r12);
            return;
        L64:
            return;
        L63:
            return;
        L49:
            r16 = ((CommentBean.CommentDetail) ListProtector.get(r3.getCommentDetails(), r14.a)).getComment_id();
            r17 = ((CommentBean.CommentDetail) ListProtector.get(r3.getCommentDetails(), r14.a)).getCommentType();
            String r21 = ((CommentBean.CommentDetail) ListProtector.get(r3.getCommentDetails(), r14.a)).getReply_id();
            r12 = r14.b;
            r18 = r21;
            goto L50
        L34:
            r13 = 0;
            goto L35
        L25:
            r6 = null;
            goto L27
        L10:
            r10 = null;
        L56:
            tt5.a.h("Comment#AsideCalcScrollInfoAddin", "pagerAdapter is null!");
        }
    }

    static {
        d = com.bytedance.ee.util.ui.n.d(12);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.extension.addins.f
    public final uu5.m<RecyclerView> c() {
        if (this.b != null) goto L5;
        com.bytedance.ee.bear.middleground.comment.export.g r1 = getContext().getConfig().L;
        this.b = new uu5.m(300, new b(this));
    L5:
        uu5.m<RecyclerView> r0 = this.b;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    public a() {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.extension.addins.f
    public final RecyclerView d(q1 r2) {
        Intrinsics.checkNotNullParameter(r2, "pagerAdapter");
        if ((r2 instanceof AsidePageAdapter) == true) goto L7;
        return null;
    L7:
        return ((AsidePageAdapter) r2).a;
    }
}
