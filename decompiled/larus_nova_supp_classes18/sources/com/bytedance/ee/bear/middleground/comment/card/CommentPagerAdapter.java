package com.bytedance.ee.bear.middleground.comment.card;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter2;
import com.bytedance.ee.bear.middleground.comment.adapter.HalfScreenCardAdapter;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.share.SharePermissionViewModel;
import com.bytedance.ee.bear.middleground.comment.uitls.RecyclerViewScrollHelper;
import com.bytedance.ee.bear.widgets.viewpager.FixPageTransformerViewPager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;
import com.ss.android.lark.widget.recyclerview.PointRecoderRecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class CommentPagerAdapter extends op5.a implements q1 {
    public List<CommentBean> c;
    public com.bytedance.ee.bear.middleground.comment.uitls.p d;
    public Activity e;
    public String f;
    public List<String> g;
    public com.bytedance.ee.bear.middleground.comment.control.z h;
    public com.bytedance.ee.bear.middleground.comment.control.y i;
    public Function0<Unit> j;
    public final List<View> k;
    public final Map<Integer, View> l;
    public FixPageTransformerViewPager m;
    public SharePermissionViewModel n;
    public d o;
    public int p;
    public final CommentPagerAdapter$createWholeCommentTailDecoration$1 q;
    public final boolean r;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.q1
    public final Integer E() {
        FixPageTransformerViewPager r0 = this.m;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        r0 = null;
    L7:
        return Integer.valueOf(r0.getCurrentItem());
    }

    @Override // op5.a
    public final int b() {
        List<CommentBean> r0 = this.c;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    @Override // op5.a
    public final void f() {
        tt5.a.h("Comment#CommentPagerAdapter", "notifyDataSetChanged:");
        i(false);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.ee.bear.middleground.comment.card.CommentPagerAdapter$createWholeCommentTailDecoration$1] */
    public CommentPagerAdapter() {
        this.k = new ArrayList();
        this.l = new LinkedHashMap();
        this.q = new CommentPagerAdapter$createWholeCommentTailDecoration$1(this);
        this.r = com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.doc.image_region_comment_view");
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.q1
    public final RecyclerView P0(Integer r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        Object r4 = ((LinkedHashMap) this.l).get(r3);
        if ((r4 instanceof RecyclerView) == true) goto L8;
        return null;
    L8:
        return (RecyclerView) r4;
    }

    @Override // op5.a
    public final int c(Object r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        Iterator r0 = ((LinkedHashMap) this.l).keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        int r1 = ((Number) r0.next()).intValue();
        Map<Integer, View> r2 = this.l;
        LinkedHashMap r3 = (LinkedHashMap) r2;
        if (Intrinsics.areEqual(r3.get(Integer.valueOf(r1)), r5) == false) goto L4;
        List<CommentBean> r4 = this.c;
        if (r4 == null) goto L10;
        int r6 = r4.size();
    L11:
        if (r1 >= r6) goto L4;
        return r1;
    L10:
        r6 = 0;
        goto L11
    L13:
        return -2;
    }

    public final void i(boolean r5) {
        tt5.a.h("Comment#CommentPagerAdapter", "notifyDataSetChanged:");
        Iterator r0 = ((LinkedHashMap) this.l).keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        int r1 = ((Number) r0.next()).intValue();
        List<CommentBean> r2 = this.c;
        if (r2 == null) goto L8;
        int r3 = r2.size();
    L9:
        if (r1 >= r3) goto L4;
        Map<Integer, View> r4 = this.l;
        LinkedHashMap r6 = (LinkedHashMap) r4;
        Object r7 = r6.get(Integer.valueOf(r1));
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        j((RecyclerView) r7, r1, r5);
        goto L4
    L8:
        r3 = 0;
        goto L9
    L11:
        super.f();
    }

    @Override // op5.a
    public final Object d(ViewGroup r29, int r30) {
        Intrinsics.checkNotNullParameter(r29, "container");
        if (((ArrayList) this.k).isEmpty() == true) goto L5;
        Object r2 = ListProtector.remove(this.k, 0);
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView r3 = (RecyclerView) r2;
    L75:
        this.l.put(Integer.valueOf(r30), r3);
        ViewGroup r4 = (ViewGroup) r3.getParent();
        if (r4 == null) goto L78;
        r4.removeView(r3);
    L78:
        r3.invalidateItemDecorations();
        j(r3, r30, true);
        r29.addView(r3);
        return r3;
    L5:
        Activity r5 = this.e;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("activity");
        r5 = null;
    L8:
        r3 = new PointRecoderRecyclerView(r5);
        ((CommonRecyclerView) r3).h = false;
        final Activity r6 = this.e;
        if (r6 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("activity");
        r6 = null;
    L11:
        r3.setLayoutManager(new CommentPagerAdapter$instantiateItem$recyclerView$1(r6));
        r3.addItemDecoration(this.q);
        r3.setOverScrollMode(2);
        com.bytedance.ee.bear.middleground.comment.uitls.p r7 = this.d;
        if (r7 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r7 = null;
    L15:
        if (r7.s == false) goto L20;
        if (this.r == false) goto L20;
        r3.setItemViewCacheSize(8);
    L20:
        if (this.r == false) goto L49;
        com.bytedance.ee.bear.middleground.comment.uitls.p r11 = this.d;
        if (r11 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        com.bytedance.ee.bear.middleground.comment.uitls.p r12 = null;
    L25:
        List<String> r8 = this.g;
        if (r8 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("userIds");
        List<String> r13 = null;
    L29:
        com.bytedance.ee.bear.middleground.comment.control.z r9 = this.h;
        if (r9 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mIListeners");
        com.bytedance.ee.bear.middleground.comment.control.z r14 = null;
    L33:
        com.bytedance.ee.bear.middleground.comment.control.y r10 = this.i;
        if (r10 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("actionControl");
        com.bytedance.ee.bear.middleground.comment.control.y r15 = null;
    L37:
        SharePermissionViewModel r16 = this.n;
        d r17 = this.o;
        if (r17 != null) goto L40;
        r17 = new d();
    L40:
        d r18 = r17;
        String r19 = this.f;
        if (r19 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("language");
        String r110 = null;
    L44:
        Function0<Unit> r20 = this.j;
        if (r20 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("clickLink");
        Function0<Unit> r111 = null;
    L48:
        RecyclerView.Adapter r21 = new HalfScreenCardAdapter(r12, r13, r14, r15, r16, r18, r110, r111);
    L74:
        r3.setAdapter(r21);
        r3.setTouchViewListener(new f(this));
        r3.setItemAnimator(null);
        r3.addOnScrollListener(new CommentPagerAdapter$instantiateItem$recyclerView$3(this));
        goto L75
    L47:
        r111 = r20;
        goto L48
    L43:
        r110 = r19;
        goto L44
    L36:
        r15 = r10;
        goto L37
    L32:
        r14 = r9;
        goto L33
    L28:
        r13 = r8;
        goto L29
    L24:
        r12 = r11;
        goto L25
    L49:
        com.bytedance.ee.bear.middleground.comment.uitls.p r112 = this.d;
        if (r112 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        com.bytedance.ee.bear.middleground.comment.uitls.p r22 = null;
    L53:
        String r23 = this.f;
        if (r23 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("language");
        String r24 = null;
    L57:
        List<String> r25 = this.g;
        if (r25 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("userIds");
        List<String> r26 = null;
    L61:
        com.bytedance.ee.bear.middleground.comment.control.z r27 = this.h;
        if (r27 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("mIListeners");
        com.bytedance.ee.bear.middleground.comment.control.z r28 = null;
    L65:
        com.bytedance.ee.bear.middleground.comment.control.y r31 = this.i;
        if (r31 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("actionControl");
        com.bytedance.ee.bear.middleground.comment.control.y r210 = null;
    L69:
        Function0<Unit> r32 = this.j;
        if (r32 != null) goto L72;
        Intrinsics.throwUninitializedPropertyAccessException("clickLink");
        Function0<Unit> r211 = null;
    L73:
        r21 = new CardAdapter(r22, r24, r26, r28, r210, false, r211);
        goto L74
    L72:
        r211 = r32;
        goto L73
    L68:
        r210 = r31;
        goto L69
    L64:
        r28 = r27;
        goto L65
    L60:
        r26 = r25;
        goto L61
    L56:
        r24 = r23;
        goto L57
    L52:
        r22 = r112;
        goto L53
    }

    @Override // op5.a
    public final boolean e(View r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        Intrinsics.checkNotNullParameter(r3, "p1");
        return Intrinsics.areEqual(r2, r3);
    }

    @Override // op5.a
    public final void a(ViewGroup r2, int r3, Object r4) {
        Intrinsics.checkNotNullParameter(r2, "container");
        Intrinsics.checkNotNullParameter(r4, "obj");
        r2.removeView((View) r4);
        this.l.remove(Integer.valueOf(r3));
        ((ArrayList) this.k).add(r4);
    }

    public final void j(final RecyclerView r3, int r4, final boolean r5) {
        tt5.a.b("Comment#CommentPagerAdapter", "notifyItemPageDataChanged: position = " + r4);
        List<CommentBean> r0 = this.c;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlin.collections.List<com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean>");
        final CommentBean r6 = (CommentBean) ListProtector.get(r0, r4);
        Function0<List<CommentBean.CommentDetail>> r1 = new CommentPagerAdapter$notifyItemPageDataChanged$oldList$1(this, r3, r6, r5);
        CommentPagerAdapter$notifyItemPageDataChanged$oldList$2 r7 = new CommentPagerAdapter$notifyItemPageDataChanged$oldList$2(r3);
        Intrinsics.checkNotNullParameter(r1, "updateData");
        Intrinsics.checkNotNullParameter(r7, "refreshDecoration");
        Object r2 = r1.invoke();
        r7.invoke();
        List r8 = (List) r2;
        com.bytedance.ee.bear.middleground.comment.uitls.p r9 = this.d;
        if (r9 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r9 = null;
    L5:
        r9.N.a(new ef5.x(r3, r6, r8));
    }

    public final void k(int r6, int r7, float r8) {
        RecyclerView r0 = P0(Integer.valueOf(r6));
        com.bytedance.ee.bear.middleground.comment.uitls.p r1 = null;
        if (r0 == null) goto L5;
        RecyclerView.Adapter r2 = r0.getAdapter();
    L7:
        if ((r2 instanceof CardAdapter2) == false) goto L9;
        CardAdapter2 r3 = (CardAdapter2) r2;
    L10:
        if (r3 != null) goto L13;
        return;
    L13:
        if (r8 >= 0.0f) goto L16;
        r8 = 0.0f;
    L18:
        com.bytedance.ee.bear.middleground.comment.uitls.p r4 = this.d;
        if (r4 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("config");
    L22:
        RecyclerViewScrollHelper.SetSmoothScroller r5 = new RecyclerViewScrollHelper.SetSmoothScroller(r1.getActivity());
        r5.setTargetPosition(r7);
        r5.a = -1;
        if (r8 >= 0.0f) goto L25;
    L28:
        RecyclerViewScrollHelper.b(P0(Integer.valueOf(r6)), r5);
        return;
    L25:
        if (r8 > 1.0f) goto L28;
        r5.d = r8;
        goto L28
    L21:
        r1 = r4;
        goto L22
    L16:
        if (r8 <= 1.0f) goto L18;
        r8 = 1.0f;
        goto L18
    L9:
        r3 = null;
        goto L10
    L5:
        r2 = null;
        goto L7
    }
}
