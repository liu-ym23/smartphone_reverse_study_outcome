package com.bytedance.ee.bear.middleground.comment.extension.addins;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bizwidget.helper.FGDowngradeHelper;
import com.bytedance.ee.bear.document.comment.CommentPlugin;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter2;
import com.bytedance.ee.bear.middleground.comment.card.p1;
import com.bytedance.ee.bear.middleground.comment.card.q1;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.ScrollCommentBean;
import com.bytedance.ee.bear.middleground.comment.uitls.RecyclerViewScrollHelper;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class f extends com.bytedance.ee.bear.middleground.comment.extension.addins.b {
    public uu5.m<RecyclerView> b;
    public final ArrayList<uu5.m<RecyclerView>> c;

    public final class a extends ff5.a<ef5.g> {
        public final /* synthetic */ f a;

        public a(f r1) {
            this.a = r1;
        }

        @Override // ff5.a
        public final void b(gf5.c r3) {
            ef5.g r4 = (ef5.g) r3;
            Intrinsics.checkNotNullParameter(r4, "event");
            CommentPlugin.h r0 = this.a.getContext().getConfig().L;
            if (r0 == null) goto L7;
            MutableLiveData r1 = CommentPlugin.access$3300(r0.a);
            if (r1 == null) goto L7;
            boolean r2 = Intrinsics.areEqual(r1.getValue(), Boolean.TRUE);
        L8:
            if (r2 == false) goto L11;
            uu5.m<RecyclerView> r5 = this.a.c();
            this.a.c.add(r5);
            r5.a(r4.a);
            return;
        L11:
            return;
        L7:
            r2 = false;
            goto L8
        }
    }

    public static final class b {
    }

    public static final class c<V> implements uu5.m.a {
        public final /* synthetic */ f a;

        public c(f r1) {
            this.a = r1;
        }

        public final void onSubscribe(Object r7) {
            RecyclerView r8 = (RecyclerView) r7;
            p1 r0 = this.a.getContext().c();
            if (r0 == null) goto L39;
            q1 r1 = r0.jV();
            if (r1 == null) goto L39;
            if (Intrinsics.areEqual(r1.P0(r1.E()), r8) == true) goto L10;
            tt5.a.k("Comment#CalcScrollInfoAddin", "not the same recyclerview!");
            return;
        L10:
            RecyclerView.Adapter r2 = r8.getAdapter();
            Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter2");
            CardAdapter2 r3 = (CardAdapter2) r2;
            int r4 = r3.getHeightFromTop();
            RecyclerViewScrollHelper.a r9 = RecyclerViewScrollHelper.a(r8, r4);
            int r5 = r9.a;
            if (r5 >= 0) goto L13;
        L38:
            tt5.a.d("Comment#CalcScrollInfoAddin", "calculate scroll position error! scrollData = " + r9 + ", data size = " + r3.getItemCount() + ", anchorHeight = " + r4);
            return;
        L13:
            if (r5 >= r3.getItemCount()) goto L38;
            if (r3.getItemCount() < 4) goto L38;
            int r6 = r9.a;
            if (r6 > 1) goto L25;
            String r10 = ((CommentBean.CommentDetail) ListProtector.get(r3.getCommentDetails(), 2)).getComment_id();
            int r11 = ((CommentBean.CommentDetail) ListProtector.get(r3.getCommentDetails(), 2)).getCommentType();
            if (r9.a != 0) goto L22;
            float r12 = 0.0f;
        L23:
            String r13 = ScrollCommentBean.HEAD;
        L28:
            CommentPlugin.h r14 = this.a.getContext().getConfig().L;
            if (r14 == null) goto L33;
            com.bytedance.ee.bear.document.comment.f0 r15 = CommentPlugin.access$3400(r14.a);
            if (r15 == null) goto L33;
            CommentPlugin.T(r15.a, r10, r11, r13, r12);
        L33:
            CommentPlugin.h r16 = this.a.getContext().getConfig().L;
            if (r16 == null) goto L42;
            com.bytedance.ee.bear.document.comment.f0 r17 = CommentPlugin.access$3400(r16.a);
            if (r17 == null) goto L43;
            CommentPlugin.T(r17.a, r10, r11, r13, r12);
            return;
        L43:
            return;
        L42:
            return;
        L22:
            r12 = r9.b;
            goto L23
        L25:
            if (r6 != (r3.getItemCount() - 1)) goto L27;
            r10 = ((CommentBean.CommentDetail) ListProtector.get(r3.getCommentDetails(), r3.getItemCount() - 2)).getComment_id();
            int r18 = ((CommentBean.CommentDetail) ListProtector.get(r3.getCommentDetails(), r3.getItemCount() - 2)).getCommentType();
            r13 = ((CommentBean.CommentDetail) ListProtector.get(r3.getCommentDetails(), r3.getItemCount() - 2)).getReply_id();
            r11 = r18;
            r12 = 1.0f;
            goto L28
        L27:
            r10 = ((CommentBean.CommentDetail) ListProtector.get(r3.getCommentDetails(), r9.a)).getComment_id();
            int r19 = ((CommentBean.CommentDetail) ListProtector.get(r3.getCommentDetails(), r9.a)).getCommentType();
            String r20 = ((CommentBean.CommentDetail) ListProtector.get(r3.getCommentDetails(), r9.a)).getReply_id();
            r12 = r9.b;
            r13 = r20;
            r11 = r19;
        L39:
            tt5.a.k("Comment#CalcScrollInfoAddin", "pagerAdapter is null!");
        }
    }

    static {
    }

    public uu5.m<RecyclerView> c() {
        if (this.b != null) goto L5;
        com.bytedance.ee.bear.middleground.comment.export.g r1 = getContext().getConfig().L;
        this.b = new uu5.m(300, new c(this));
    L5:
        uu5.m<RecyclerView> r0 = this.b;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.extension.addins.b, gf5.b
    public final void onDestroy() {
        tt5.a.h("Comment#CalcScrollInfoAddin", "onDestroy() called");
        Iterator<T> r0 = this.c.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        uu5.m r1 = (uu5.m) r0.next();
        r1.getClass();
        tt5.a.h("SampleFlowableWrapper", "dispose() called");
        Disposable r2 = r1.b;
        if (r2 == null) goto L4;
        r2.dispose();
        goto L4
    }

    public f() {
        this.c = new ArrayList();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.extension.addins.b, gf5.b
    public final void a(cf5.a r4) {
        Intrinsics.checkNotNullParameter(r4, "host");
        Intrinsics.checkNotNullParameter(r4, "host");
        this.a = r4;
        r4.b(ef5.g.class, new a(this));
        com.bytedance.ee.bear.middleground.comment.uitls.p r5 = getContext().getConfig();
        if (r5.b == null) goto L8;
        Lazy r0 = FGDowngradeHelper.a;
        if (FGDowngradeHelper.b() == true) goto L8;
        Fragment r1 = r5.b;
    L9:
        CommentPlugin.h r2 = r5.L;
        if (r2 == null) goto L15;
        MutableLiveData r3 = CommentPlugin.access$3300(r2.a);
        if (r3 == null) goto L16;
        r3.observe(r1, new h(this, r5));
        return;
    L16:
        return;
    L15:
        return;
    L8:
        r1 = r5.getActivity();
        goto L9
    }

    public RecyclerView d(q1 r2) {
        Intrinsics.checkNotNullParameter(r2, "pagerAdapter");
        return r2.P0(r2.E());
    }
}
