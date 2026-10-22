package com.bytedance.ee.bear.middleground.comment.extension.addins;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.middleground.comment.card.aside.AsidePageAdapter;
import com.bytedance.ee.bear.middleground.comment.card.p1;
import com.bytedance.ee.bear.middleground.comment.card.q1;
import com.bytedance.ee.bear.middleground.comment.export.CommentStyle;
import com.bytedance.ee.bear.middleground.comment.export.ICardAdapter;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.SmartReplyData;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e0 extends com.bytedance.ee.bear.middleground.comment.extension.addins.b {
    public String b;
    public Set<String> c;

    public final class a extends ff5.a<ef5.e> {
        public final /* synthetic */ e0 a;

        public a(e0 r1) {
            this.a = r1;
        }

        @Override // ff5.a
        public final void b(gf5.c r5) {
            ef5.e r6 = (ef5.e) r5;
            Intrinsics.checkNotNullParameter(r6, "event");
            if (r6.b != 0) goto L29;
            tt5.a.h("Comment#ReadMessageAddin", "detectVisibleItem onPageScrollStateChanged to SCROLL_STATE_IDLE");
            p1 r7 = this.a.getContext().c();
            LinearLayoutManager r0 = null;
            if (r7 == null) goto L7;
            q1 r8 = r7.jV();
        L9:
            if ((r8 instanceof AsidePageAdapter) == false) goto L11;
            AsidePageAdapter r9 = (AsidePageAdapter) r8;
        L12:
            if (r9 == null) goto L33;
            RecyclerView.LayoutManager r1 = r9.a.getLayoutManager();
            if ((r1 instanceof LinearLayoutManager) == false) goto L17;
            r0 = (LinearLayoutManager) r1;
        L17:
            if (r0 == null) goto L34;
            int r2 = r0.findFirstVisibleItemPosition();
            int r3 = r0.findLastVisibleItemPosition();
            if (r2 == (-1)) goto L31;
            if (r3 == (-1)) goto L35;
            if (r2 > r3) goto L32;
        L24:
            RecyclerView r4 = r9.P0(Integer.valueOf(r2));
            if (r4 == null) goto L27;
            this.a.d(r4);
        L27:
            if (r2 == r3) goto L36;
            r2 = r2 + 1;
            goto L24
        L36:
            return;
        L32:
            return;
        L35:
            return;
        L31:
            return;
        L34:
            return;
        L33:
            return;
        L11:
            r9 = null;
            goto L12
        L7:
            r8 = null;
            goto L9
        }
    }

    public final class b extends ff5.a<ef5.f> {
        public final /* synthetic */ e0 a;

        public b(e0 r1) {
            this.a = r1;
        }

        @Override // ff5.a
        public final void b(gf5.c r3) {
            ef5.f r4 = (ef5.f) r3;
            Intrinsics.checkNotNullParameter(r4, "event");
            if (r4.b != 0) goto L6;
            tt5.a.h("Comment#ReadMessageAddin", "detectVisibleItem onScrollStateChanged to SCROLL_STATE_IDLE");
            this.a.d(r4.a);
            return;
        }
    }

    public final class c extends ff5.a<ef5.j> {
        public final /* synthetic */ e0 a;

        public c(e0 r1) {
            this.a = r1;
        }

        @Override // ff5.a
        public final void b(gf5.c r6) {
            ef5.j r7 = (ef5.j) r6;
            Intrinsics.checkNotNullParameter(r7, "event");
            tt5.a.h("Comment#ReadMessageAddin", "detectVisibleItem on comment switch");
            e0 r0 = this.a;
            Integer r1 = r7.a;
            r0.getContext().getConfig().c.post(new h0(r0, r1, true));
            e0 r2 = this.a;
            r2.b = r7.c;
            r2.c = new LinkedHashSet();
        }
    }

    public static final class d {
    }

    public final class e extends ff5.a<ef5.m> {
        public final /* synthetic */ e0 a;

        public e(e0 r1) {
            this.a = r1;
        }

        @Override // ff5.a
        public final void b(gf5.c r5) {
            ef5.m r6 = (ef5.m) r5;
            Intrinsics.checkNotNullParameter(r6, "event");
            CommentStyle r0 = this.a.b().a().getConfig().n;
            q1 r2 = null;
            if (r0 != CommentStyle.ASIDE) goto L5;
        L23:
            p1 r1 = this.a.getContext().c();
            if (r1 == null) goto L26;
            q1 r3 = r1.jV();
        L28:
            if ((r3 instanceof AsidePageAdapter) == false) goto L30;
            AsidePageAdapter r4 = (AsidePageAdapter) r3;
        L31:
            if (r4 == null) goto L46;
            q1 r7 = r4.a.getLayoutManager();
            if ((r7 instanceof LinearLayoutManager) == false) goto L36;
            r2 = (LinearLayoutManager) r7;
        L36:
            if (r2 == null) goto L47;
            r4.a.post(new f0(r2, r6, this.a));
            return;
        L47:
            return;
        L46:
            return;
        L30:
            r4 = null;
            goto L31
        L26:
            r3 = null;
            goto L28
        L5:
            if (r0 == CommentStyle.ASIDE_IN_PICTURE) goto L23;
            Integer r8 = r6.b;
            if (r8 == null) goto L40;
            int r9 = r8.intValue();
            if (r0 != CommentStyle.HALF_SCREEN) goto L22;
            p1 r10 = this.a.getContext().c();
            if (r10 == null) goto L14;
            r2 = r10.jV();
        L14:
            if (r2 == null) goto L41;
            RecyclerView r11 = r2.P0(Integer.valueOf(r9));
            if (r11 != null) goto L19;
            return;
        L19:
            if (r11.isAttachedToWindow() == false) goto L45;
            r11.post(new g0(r11, this, r6, r9));
            return;
        L45:
            return;
        L41:
            return;
        L22:
            c(r6, r9);
            return;
        }

        public final void c(ef5.m r5, int r6) {
            CommentBean r0 = (CommentBean) CollectionsKt.getOrNull(r5.a, r6);
            if (r0 != null) goto L6;
            tt5.a.k("Comment#ReadMessageAddin", "handleDataUpdate skip, position out of bounds, position=" + r6 + ", dataSize=" + r5.a.size());
            return;
        L6:
            String r1 = r0.getComment_id();
            String r2 = this.a.b;
            boolean r3 = false;
            if (r2 != null) goto L9;
        L12:
            boolean r4 = true;
        L13:
            if (r4 == true) goto L22;
            Integer r7 = r5.c;
            if (r7 == null) goto L22;
            if (r6 != r7.intValue()) goto L22;
            if (Intrinsics.areEqual(this.a.b, r1) == true) goto L22;
            r3 = true;
        L22:
            this.a.e(r5.a, r6, r3);
            this.a.b = r1;
            return;
        L9:
            if (r2.length() == 0) goto L12;
            r4 = false;
            goto L13
        }
    }

    public static final class f implements Runnable {
        public final /* synthetic */ e0 a;
        public final /* synthetic */ RecyclerView b;
        public final /* synthetic */ q1 c;

        public f(e0 r1, RecyclerView r2, q1 r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a() {
            CommentStyle r0 = this.a.b().a().getConfig().n;
            if (r0 != CommentStyle.ASIDE) goto L5;
        L14:
            e0.c(this.a, this.b, true);
            return;
        L5:
            if (r0 == CommentStyle.ASIDE_IN_PICTURE) goto L14;
            RecyclerView r1 = this.b;
            q1 r2 = this.c;
            if (r2 == null) goto L10;
            RecyclerView r3 = r2.P0(r2.E());
        L12:
            if (Intrinsics.areEqual(r1, r3) == false) goto L16;
            e0.c(this.a, this.b, true);
            return;
        L16:
            return;
        L10:
            r3 = null;
            goto L12
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public e0() {
        this.c = new LinkedHashSet();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.extension.addins.b, gf5.b
    public final void a(cf5.a r3) {
        Intrinsics.checkNotNullParameter(r3, "host");
        Intrinsics.checkNotNullParameter(r3, "host");
        this.a = r3;
        r3.b(ef5.f.class, new b(this));
        r3.b(ef5.e.class, new a(this));
        r3.b(ef5.j.class, new c(this));
        r3.b(ef5.m.class, new e(this));
    }

    public final void d(RecyclerView r4) {
        Intrinsics.checkNotNullParameter(r4, "recyclerView");
        p1 r0 = getContext().c();
        if (r0 == null) goto L5;
        q1 r1 = r0.jV();
    L6:
        getContext().getConfig().c.post(new f(this, r4, r1));
        return;
    L5:
        r1 = null;
        goto L6
    }

    public static final void c(e0 r16, RecyclerView r17, boolean r18) {
        r16.getClass();
        if (r17 == null) goto L124;
        LinearLayoutManager r2 = r17.getLayoutManager();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        LinearLayoutManager r3 = r2;
        int r4 = r3.findFirstVisibleItemPosition();
        int r5 = r3.findLastVisibleItemPosition();
        tt5.a.h("Comment#ReadMessageAddin", "detectVisibleItemInternal, first: " + r4 + ", last: " + r5 + ", checkReadMessage: " + r18);
        CommentStyle r6 = r16.getContext().getConfig().n;
        if (r6 != CommentStyle.ASIDE) goto L7;
    L8:
        float r7 = com.bytedance.ee.util.ui.n.t() - com.bytedance.ee.util.ui.n.b(r17).top;
    L9:
        View r8 = r3.getChildAt(r5);
        if (r8 == null) goto L12;
        int r9 = (int) r8.getY();
    L14:
        if (r9 <= r7) goto L18;
        if (r5 <= r4) goto L18;
        r5 = r5 - 1;
    L18:
        if (r4 == (-1)) goto L125;
        if (r5 == (-1)) goto L126;
        if (r4 <= r5) goto L22;
        return;
    L22:
        if (r18 == false) goto L55;
        ICardAdapter r1 = r17.getAdapter();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.comment.export.ICardAdapter");
        List<CommentBean.CommentDetail> r10 = r1.getCommentDetails();
        tt5.a.h("Comment#ReadMessageAddin", "onItemVisible, first: " + r4 + ", last: " + r5);
        if (r10.isEmpty() == true) goto L55;
        if (r4 < r10.size()) goto L29;
        int r11 = r10.size() - 1;
    L31:
        if (r5 < r10.size()) goto L33;
        int r12 = r10.size() - 1;
    L34:
        ArrayList r13 = new ArrayList();
        if (r11 > r12) goto L53;
    L36:
        CommentBean.CommentDetail r14 = (CommentBean.CommentDetail) ListProtector.get(r10, r11);
        String[] r15 = r14.getMessageIds();
        if (r15 != null) goto L39;
    L45:
        boolean r19 = true;
    L46:
        if (r19 == false) goto L48;
    L50:
        if (r11 == r12) goto L53;
        r11 = r11 + 1;
        goto L36
    L48:
        if (r14.getReadStatus() != 1) goto L50;
        CollectionsKt.addAll(r13, r14.getMessageIds());
        r14.setReadStatus(2);
        goto L50
    L39:
        if (r15.length != 0) goto L41;
        boolean r110 = true;
    L42:
        if (r110 == true) goto L45;
        r19 = false;
        goto L46
    L41:
        r110 = false;
    L53:
        if ((!r13.isEmpty()) == false) goto L55;
        tt5.a.h("Comment#ReadMessageAddin", "readMessage: " + r13);
        r16.getContext().a().g(r13);
        goto L55
    L33:
        r12 = r5;
        goto L34
    L29:
        r11 = r4;
    L55:
        ICardAdapter r20 = r17.getAdapter();
        Intrinsics.checkNotNull(r20, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.comment.export.ICardAdapter");
        List<CommentBean.CommentDetail> r21 = r20.getCommentDetails();
        tt5.a.h("Comment#ReadMessageAddin", "reportSmartReplyDataView, first: " + r4 + ", last: " + r5);
        if (r21.isEmpty() == true) goto L128;
        int r22 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r4, 0), r21.size() - 1);
        int r23 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r5, r22), r21.size() - 1);
        LinkedHashSet r24 = new LinkedHashSet();
        if (r22 > r23) goto L66;
    L60:
        String r25 = ((CommentBean.CommentDetail) ListProtector.get(r21, r22)).getReply_id();
        SmartReplyData r26 = ((CommentBean.CommentDetail) ListProtector.get(r21, r22)).getSmartReplyData();
        if (r25 == null) goto L64;
        if (r26 == null) goto L64;
        r24.add(r25);
    L64:
        if (r22 == r23) goto L66;
        r22 = r22 + 1;
    L66:
        Set r27 = SetsKt.minus(r16.c, r24);
        Set r28 = SetsKt.minus(r24, r16.c);
        if (r28.isEmpty() == true) goto L82;
        tt5.a.h("Comment#ReadMessageAddin", "reportExposed: " + r28);
        Iterator<T> r29 = r21.iterator();
    L71:
        if (r29.hasNext() == false) goto L82;
        CommentBean.CommentDetail r30 = (CommentBean.CommentDetail) r29.next();
        String r111 = r30.getReply_id();
        if (r111 == null) goto L71;
        if (r28.contains(r111) == false) goto L71;
        SmartReplyData r31 = r30.getSmartReplyData();
        if (r31 == null) goto L71;
        if (r31.getExposedState() != 0) goto L71;
        com.bytedance.ee.bear.middleground.comment.uitls.h r112 = r16.getContext().getConfig().d0;
        String r113 = r31.getAiReplyId();
        String r114 = r31.getCommentId();
        String r115 = r31.getAiReplyUserType().getValue();
        String r116 = r31.getSmartReplyViewSource().getValue();
        Map<String, Object> r32 = r112.b();
        HashMap r33 = (HashMap) r32;
        r33.put("ai_comment_id", r113);
        r33.put("show_type", "auto_show");
        r33.put("answer_style", "show_partly");
        r33.put("reply_id", r111);
        r33.put("comment_card_id", r114);
        r33.put("ai_reply_user_type", r115);
        r33.put("smart_reply_view_source", r116);
        tt5.a.b("Comment#CommentAnalytic", "reportAIReplyView = " + r32);
        r112.g.a("ccm_comment_box_ai_reply_view", r32);
        r31.setExposedState(1);
        r28 = r28;
    L82:
        if (r27.isEmpty() == true) goto L96;
        tt5.a.h("Comment#ReadMessageAddin", "reportUnexposed: " + r27);
        Iterator<T> r34 = r21.iterator();
    L86:
        if (r34.hasNext() == false) goto L96;
        CommentBean.CommentDetail r35 = (CommentBean.CommentDetail) r34.next();
        String r36 = r35.getReply_id();
        if (r36 == null) goto L86;
        if (r27.contains(r36) == false) goto L86;
        SmartReplyData r37 = r35.getSmartReplyData();
        if (r37 == null) goto L86;
        if (r37.getExposedState() != 1) goto L86;
        r37.setExposedState(0);
    L96:
        r16.c.clear();
        r16.c.addAll(r24);
        tt5.a.h("Comment#ReadMessageAddin", "update visibleCommentReplyIds: " + r16.c);
        return;
    L128:
        return;
    L126:
        return;
    L125:
        return;
    L12:
        r9 = 0;
        goto L14
    L7:
        if (r6 != CommentStyle.ASIDE_IN_PICTURE) goto L18;
    }

    public final void e(List<? extends CommentBean> r5, int r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r5, WikiFolderPushPlugin.DATA);
        boolean r1 = false;
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.docx.mobile_revision_notice") == false) goto L14;
        CommentBean r8 = (CommentBean) CollectionsKt.getOrNull(r5, r6);
        if (r8 == null) goto L14;
        List<CommentBean.CommentDetail> r9 = r8.getComment_list();
        if (r9 == null) goto L14;
        Iterator<T> r10 = r9.iterator();
        boolean r0 = false;
    L10:
        if (r10.hasNext() == false) goto L16;
        if (((CommentBean.CommentDetail) r10.next()).getReadStatus() != 1) goto L10;
        r0 = true;
    L16:
        if (getContext().getConfig().n == CommentStyle.HALF_SCREEN) goto L19;
        if (r7 == true) goto L19;
        if (r0 == true) goto L19;
    L20:
        Integer r11 = Integer.valueOf(r6);
        getContext().getConfig().c.post(new h0(this, r11, r1));
        return;
    L19:
        r1 = true;
    L14:
        r0 = false;
        goto L16
    }
}
