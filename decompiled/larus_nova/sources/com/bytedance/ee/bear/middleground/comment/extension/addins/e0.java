package com.bytedance.ee.bear.middleground.comment.extension.addins;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bitable.homepage.activity.NoticeInfo;
import com.bytedance.ee.bear.middleground.comment.card.aside.AsidePageAdapter;
import com.bytedance.ee.bear.middleground.comment.card.p1;
import com.bytedance.ee.bear.middleground.comment.card.q1;
import com.bytedance.ee.bear.middleground.comment.export.CommentStyle;
import com.bytedance.ee.bear.middleground.comment.export.ICardAdapter;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.SmartReplyData;
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

/* JADX INFO: loaded from: classes18.dex */
public final class e0 extends com.bytedance.ee.bear.middleground.comment.extension.addins.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f231453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Set<String> f231454c;

    public final class a extends ff5.a<ef5.e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e0 f231455a;

        public a(e0 r100) {
            this.f231455a = r100;
        }

        @Override // ff5.a
        public final void b(gf5.c r100) {
            ef5.e r101 = (ef5.e) r100;
            Intrinsics.checkNotNullParameter(r101, "event");
            if (r101.f472454b != 0) goto L29;
            tt5.a.h("Comment#ReadMessageAddin", "detectVisibleItem onPageScrollStateChanged to SCROLL_STATE_IDLE");
            p1 r102 = this.f231455a.getContext().c();
            LinearLayoutManager r103 = null;
            if (r102 == null) goto L7;
            q1 r104 = r102.jV();
        L9:
            if ((r104 instanceof AsidePageAdapter) == false) goto L11;
            AsidePageAdapter r105 = (AsidePageAdapter) r104;
        L12:
            if (r105 == null) goto L33;
            RecyclerView.LayoutManager r106 = r105.f230913a.getLayoutManager();
            if ((r106 instanceof LinearLayoutManager) == false) goto L17;
            r103 = (LinearLayoutManager) r106;
        L17:
            if (r103 == null) goto L34;
            int r107 = r103.findFirstVisibleItemPosition();
            int r108 = r103.findLastVisibleItemPosition();
            if (r107 == (-1)) goto L31;
            if (r108 == (-1)) goto L35;
            if (r107 > r108) goto L32;
        L24:
            RecyclerView r109 = r105.P0(Integer.valueOf(r107));
            if (r109 == null) goto L27;
            this.f231455a.d(r109);
        L27:
            if (r107 == r108) goto L36;
            r107 = r107 + 1;
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
            r105 = null;
            goto L12
        L7:
            r104 = null;
            goto L9
        }
    }

    public final class b extends ff5.a<ef5.f> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e0 f231456a;

        public b(e0 r100) {
            this.f231456a = r100;
        }

        @Override // ff5.a
        public final void b(gf5.c r100) {
            ef5.f r101 = (ef5.f) r100;
            Intrinsics.checkNotNullParameter(r101, "event");
            if (r101.f472457b != 0) goto L6;
            tt5.a.h("Comment#ReadMessageAddin", "detectVisibleItem onScrollStateChanged to SCROLL_STATE_IDLE");
            this.f231456a.d(r101.f472456a);
            return;
        }
    }

    public final class c extends ff5.a<ef5.j> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e0 f231457a;

        public c(e0 r100) {
            this.f231457a = r100;
        }

        @Override // ff5.a
        public final void b(gf5.c r100) {
            ef5.j r101 = (ef5.j) r100;
            Intrinsics.checkNotNullParameter(r101, "event");
            tt5.a.h("Comment#ReadMessageAddin", "detectVisibleItem on comment switch");
            e0 r102 = this.f231457a;
            Integer r103 = r101.f472474a;
            r102.getContext().getConfig().f232222c.post(new h0(r102, r103, true));
            e0 r104 = this.f231457a;
            r104.f231453b = r101.f472476c;
            r104.f231454c = new LinkedHashSet();
        }
    }

    public static final class d {
    }

    public final class e extends ff5.a<ef5.m> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e0 f231458a;

        public e(e0 r100) {
            this.f231458a = r100;
        }

        @Override // ff5.a
        public final void b(gf5.c r100) {
            ef5.m r101 = (ef5.m) r100;
            Intrinsics.checkNotNullParameter(r101, "event");
            CommentStyle r102 = this.f231458a.b().a().getConfig().f232238n;
            LinearLayoutManager r103 = null;
            q1 r104 = null;
            if (r102 != CommentStyle.ASIDE) goto L5;
        L23:
            p1 r105 = this.f231458a.getContext().c();
            if (r105 == null) goto L26;
            q1 r106 = r105.jV();
        L28:
            if ((r106 instanceof AsidePageAdapter) == false) goto L30;
            AsidePageAdapter r107 = (AsidePageAdapter) r106;
        L31:
            if (r107 == null) goto L46;
            RecyclerView.LayoutManager r108 = r107.f230913a.getLayoutManager();
            if ((r108 instanceof LinearLayoutManager) == false) goto L36;
            r103 = (LinearLayoutManager) r108;
        L36:
            if (r103 == null) goto L47;
            r107.f230913a.post(new f0(r103, r101, this.f231458a));
            return;
        L47:
            return;
        L46:
            return;
        L30:
            r107 = null;
            goto L31
        L26:
            r106 = null;
            goto L28
        L5:
            if (r102 == CommentStyle.ASIDE_IN_PICTURE) goto L23;
            Integer r109 = r101.f472484b;
            if (r109 == null) goto L40;
            int r110 = r109.intValue();
            if (r102 != CommentStyle.HALF_SCREEN) goto L22;
            p1 r111 = this.f231458a.getContext().c();
            if (r111 == null) goto L14;
            r104 = r111.jV();
        L14:
            if (r104 == null) goto L41;
            RecyclerView r112 = r104.P0(Integer.valueOf(r110));
            if (r112 != null) goto L19;
            return;
        L19:
            if (r112.isAttachedToWindow() == false) goto L45;
            r112.post(new g0(r112, this, r101, r110));
            return;
        L45:
            return;
        L41:
            return;
        L22:
            c(r101, r110);
            return;
        }

        public final void c(ef5.m r100, int r101) {
            CommentBean r102 = (CommentBean) CollectionsKt.getOrNull(r100.f472483a, r101);
            if (r102 != null) goto L6;
            tt5.a.k("Comment#ReadMessageAddin", "handleDataUpdate skip, position out of bounds, position=" + r101 + ", dataSize=" + r100.f472483a.size());
            return;
        L6:
            String r103 = r102.getComment_id();
            String r104 = this.f231458a.f231453b;
            boolean r105 = false;
            if (r104 != null) goto L9;
        L12:
            boolean r106 = true;
        L13:
            if (r106 == true) goto L22;
            Integer r107 = r100.f472485c;
            if (r107 == null) goto L22;
            if (r101 != r107.intValue()) goto L22;
            if (Intrinsics.areEqual(this.f231458a.f231453b, r103) == true) goto L22;
            r105 = true;
        L22:
            this.f231458a.e(r100.f472483a, r101, r105);
            this.f231458a.f231453b = r103;
            return;
        L9:
            if (r104.length() == 0) goto L12;
            r106 = false;
            goto L13
        }
    }

    public static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e0 f231459a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f231460b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ q1 f231461c;

        public f(e0 r100, RecyclerView r101, q1 r102) {
            this.f231459a = r100;
            this.f231460b = r101;
            this.f231461c = r102;
        }

        public final void a() {
            CommentStyle r100 = this.f231459a.b().a().getConfig().f232238n;
            if (r100 != CommentStyle.ASIDE) goto L5;
        L14:
            e0.c(this.f231459a, this.f231460b, true);
            return;
        L5:
            if (r100 == CommentStyle.ASIDE_IN_PICTURE) goto L14;
            RecyclerView r101 = this.f231460b;
            q1 r102 = this.f231461c;
            if (r102 == null) goto L10;
            RecyclerView r103 = r102.P0(r102.E());
        L12:
            if (Intrinsics.areEqual(r101, r103) == false) goto L16;
            e0.c(this.f231459a, this.f231460b, true);
            return;
        L16:
            return;
        L10:
            r103 = null;
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
        this.f231454c = new LinkedHashSet();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.extension.addins.b, gf5.b
    public final void a(cf5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r100, "host");
        this.f231427a = r100;
        r100.b(ef5.f.class, new b(this));
        r100.b(ef5.e.class, new a(this));
        r100.b(ef5.j.class, new c(this));
        r100.b(ef5.m.class, new e(this));
    }

    public final void d(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        p1 r101 = getContext().c();
        if (r101 == null) goto L5;
        q1 r102 = r101.jV();
    L6:
        getContext().getConfig().f232222c.post(new f(this, r100, r102));
        return;
    L5:
        r102 = null;
        goto L6
    }

    public static final void c(e0 r110, RecyclerView r111, boolean r112) {
        r110.getClass();
        if (r111 == null) goto L124;
        RecyclerView.LayoutManager r100 = r111.getLayoutManager();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        LinearLayoutManager r101 = (LinearLayoutManager) r100;
        int r102 = r101.findFirstVisibleItemPosition();
        int r103 = r101.findLastVisibleItemPosition();
        tt5.a.h("Comment#ReadMessageAddin", "detectVisibleItemInternal, first: " + r102 + ", last: " + r103 + ", checkReadMessage: " + r112);
        CommentStyle r104 = r110.getContext().getConfig().f232238n;
        if (r104 != CommentStyle.ASIDE) goto L7;
    L8:
        float r105 = com.bytedance.ee.util.ui.n.t() - com.bytedance.ee.util.ui.n.b(r111).top;
    L9:
        View r106 = r101.getChildAt(r103);
        if (r106 == null) goto L12;
        int r107 = (int) r106.getY();
    L14:
        if (r107 <= r105) goto L18;
        if (r103 <= r102) goto L18;
        r103 = r103 - 1;
    L18:
        if (r102 == (-1)) goto L125;
        if (r103 == (-1)) goto L126;
        if (r102 <= r103) goto L22;
        return;
    L22:
        if (r112 == false) goto L55;
        Object r108 = r111.getAdapter();
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.comment.export.ICardAdapter");
        List<CommentBean.CommentDetail> r109 = ((ICardAdapter) r108).getCommentDetails();
        tt5.a.h("Comment#ReadMessageAddin", "onItemVisible, first: " + r102 + ", last: " + r103);
        if (r109.isEmpty() == true) goto L55;
        if (r102 < r109.size()) goto L29;
        int r113 = r109.size() - 1;
    L31:
        if (r103 < r109.size()) goto L33;
        int r114 = r109.size() - 1;
    L34:
        ArrayList r115 = new ArrayList();
        if (r113 > r114) goto L53;
    L36:
        CommentBean.CommentDetail r116 = (CommentBean.CommentDetail) ListProtector.get(r109, r113);
        String[] r117 = r116.getMessageIds();
        if (r117 != null) goto L39;
    L45:
        boolean r118 = true;
    L46:
        if (r118 == false) goto L48;
    L50:
        if (r113 == r114) goto L53;
        r113 = r113 + 1;
        goto L36
    L48:
        if (r116.getReadStatus() != 1) goto L50;
        CollectionsKt.addAll(r115, r116.getMessageIds());
        r116.setReadStatus(2);
        goto L50
    L39:
        if (r117.length != 0) goto L41;
        boolean r119 = true;
    L42:
        if (r119 == true) goto L45;
        r118 = false;
        goto L46
    L41:
        r119 = false;
    L53:
        if ((!r115.isEmpty()) == false) goto L55;
        tt5.a.h("Comment#ReadMessageAddin", "readMessage: " + r115);
        r110.getContext().a().g(r115);
        goto L55
    L33:
        r114 = r103;
        goto L34
    L29:
        r113 = r102;
    L55:
        Object r120 = r111.getAdapter();
        Intrinsics.checkNotNull(r120, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.comment.export.ICardAdapter");
        List<CommentBean.CommentDetail> r121 = ((ICardAdapter) r120).getCommentDetails();
        tt5.a.h("Comment#ReadMessageAddin", "reportSmartReplyDataView, first: " + r102 + ", last: " + r103);
        if (r121.isEmpty() == true) goto L128;
        int r122 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r102, 0), r121.size() - 1);
        int r123 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r103, r122), r121.size() - 1);
        LinkedHashSet r124 = new LinkedHashSet();
        if (r122 > r123) goto L66;
    L60:
        String r125 = ((CommentBean.CommentDetail) ListProtector.get(r121, r122)).getReply_id();
        SmartReplyData r126 = ((CommentBean.CommentDetail) ListProtector.get(r121, r122)).getSmartReplyData();
        if (r125 == null) goto L64;
        if (r126 == null) goto L64;
        r124.add(r125);
    L64:
        if (r122 == r123) goto L66;
        r122 = r122 + 1;
    L66:
        Set r127 = SetsKt.minus(r110.f231454c, r124);
        Set r128 = SetsKt.minus(r124, r110.f231454c);
        if (r128.isEmpty() == true) goto L82;
        tt5.a.h("Comment#ReadMessageAddin", "reportExposed: " + r128);
        Iterator<T> r129 = r121.iterator();
    L71:
        if (r129.hasNext() == false) goto L82;
        CommentBean.CommentDetail r130 = (CommentBean.CommentDetail) r129.next();
        String r131 = r130.getReply_id();
        if (r131 == null) goto L71;
        if (r128.contains(r131) == false) goto L71;
        SmartReplyData r132 = r130.getSmartReplyData();
        if (r132 == null) goto L71;
        if (r132.getExposedState() != 0) goto L71;
        com.bytedance.ee.bear.middleground.comment.uitls.h r133 = r110.getContext().getConfig().f232225d0;
        String r134 = r132.getAiReplyId();
        String r135 = r132.getCommentId();
        String r136 = r132.getAiReplyUserType().getValue();
        String r137 = r132.getSmartReplyViewSource().getValue();
        Map<String, Object> r138 = r133.b();
        HashMap r139 = (HashMap) r138;
        r139.put("ai_comment_id", r134);
        r139.put("show_type", "auto_show");
        r139.put("answer_style", "show_partly");
        r139.put(NoticeInfo.KEY_REPLY_ID, r131);
        r139.put("comment_card_id", r135);
        r139.put("ai_reply_user_type", r136);
        r139.put("smart_reply_view_source", r137);
        tt5.a.b("Comment#CommentAnalytic", "reportAIReplyView = " + r138);
        r133.f232209g.a("ccm_comment_box_ai_reply_view", r138);
        r132.setExposedState(1);
        r128 = r128;
    L82:
        if (r127.isEmpty() == true) goto L96;
        tt5.a.h("Comment#ReadMessageAddin", "reportUnexposed: " + r127);
        Iterator<T> r140 = r121.iterator();
    L86:
        if (r140.hasNext() == false) goto L96;
        CommentBean.CommentDetail r141 = (CommentBean.CommentDetail) r140.next();
        String r142 = r141.getReply_id();
        if (r142 == null) goto L86;
        if (r127.contains(r142) == false) goto L86;
        SmartReplyData r143 = r141.getSmartReplyData();
        if (r143 == null) goto L86;
        if (r143.getExposedState() != 1) goto L86;
        r143.setExposedState(0);
    L96:
        r110.f231454c.clear();
        r110.f231454c.addAll(r124);
        tt5.a.h("Comment#ReadMessageAddin", "update visibleCommentReplyIds: " + r110.f231454c);
        return;
    L128:
        return;
    L126:
        return;
    L125:
        return;
    L12:
        r107 = 0;
        goto L14
    L7:
        if (r104 != CommentStyle.ASIDE_IN_PICTURE) goto L18;
    }

    public final void e(List<? extends CommentBean> r100, int r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "data");
        boolean r103 = false;
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.docx.mobile_revision_notice") == false) goto L14;
        CommentBean r104 = (CommentBean) CollectionsKt.getOrNull(r100, r101);
        if (r104 == null) goto L14;
        List<CommentBean.CommentDetail> r105 = r104.getComment_list();
        if (r105 == null) goto L14;
        Iterator<T> r106 = r105.iterator();
        boolean r107 = false;
    L10:
        if (r106.hasNext() == false) goto L16;
        if (((CommentBean.CommentDetail) r106.next()).getReadStatus() != 1) goto L10;
        r107 = true;
    L16:
        if (getContext().getConfig().f232238n == CommentStyle.HALF_SCREEN) goto L19;
        if (r102 == true) goto L19;
        if (r107 == true) goto L19;
    L20:
        Integer r108 = Integer.valueOf(r101);
        getContext().getConfig().f232222c.post(new h0(this, r108, r103));
        return;
    L19:
        r103 = true;
    L14:
        r107 = false;
        goto L16
    }
}
