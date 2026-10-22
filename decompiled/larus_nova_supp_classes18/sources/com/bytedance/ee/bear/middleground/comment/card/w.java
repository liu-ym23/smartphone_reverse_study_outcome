package com.bytedance.ee.bear.middleground.comment.card;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.widget.CommentTextView;
import com.bytedance.ee.bear.widgets.viewpager.VerticalViewPager;
import com.bytedance.ee.bear.widgets.viewpager.viewpager2.widget.ViewPager2;
import com.bytedance.ee.docsdk.impl.utils.keyboard.producer.BaseKeyboardHeightProducer;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class w extends ViewPager2.OnPageChangeCallback {
    public final /* synthetic */ Ref.BooleanRef a;
    public final /* synthetic */ FloatCardComment b;
    public final /* synthetic */ Ref.LongRef c;

    @Override // com.bytedance.ee.bear.widgets.viewpager.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public final void onPageScrollStateChanged(int r5) {
        Ref.BooleanRef r0 = this.a;
        boolean r1 = true;
        if (r5 == 1) goto L6;
        r1 = false;
    L6:
        r0.element = r1;
        d r2 = this.b.p;
        VerticalViewPager r3 = null;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r2 = null;
    L9:
        d r4 = this.b.p;
        if (r4 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r4 = null;
    L12:
        VerticalViewPager r6 = this.b.m;
        if (r6 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    L16:
        boolean r7 = r2.q(r4.f(Integer.valueOf(r3.getCurrentItem())));
        if (r5 != 2) goto L19;
        if (r7 == false) goto L19;
    L21:
        FloatCardComment r8 = this.b;
        r8.p(r8.e.q.getComment());
        return;
    L19:
        if (r5 != 0) goto L23;
        if (r7 == false) goto L21;
        return;
    L23:
        return;
    L15:
        r3 = r6;
        goto L16
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v5, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r8v7 */
    @Override // com.bytedance.ee.bear.widgets.viewpager.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public final void onPageSelected(int r21) {
        tt5.a.h("Comment#CardComment2", "onPageSelected()... position = " + r21);
        FloatCardComment r2 = this.b;
        d r5 = null;
        VerticalViewPager r6 = null;
        if (r2.p0 != r21) goto L5;
    L12:
        d r3 = r2.p;
        if (r3 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r3 = null;
    L15:
        String r4 = r3.f(Integer.valueOf(r21));
        d r7 = this.b.p;
        if (r7 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r7 = null;
    L18:
        r7.getClass();
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r7.k = r4;
        d r8 = this.b.p;
        if (r8 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r8 = null;
    L21:
        CommentBean r9 = r8.e(Integer.valueOf(r21));
        if (r9 == null) goto L24;
        int r10 = r9.getCommentType();
    L25:
        if (r9 == null) goto L27;
        String r11 = r9.getCommentUUID();
    L28:
        String r14 = "";
        if (r11 != null) goto L31;
        String r12 = "";
    L32:
        com.bytedance.ee.bear.middleground.comment.uitls.p r13 = this.b.e;
        r13.getClass();
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r13.y = r4;
        this.b.e.N.a(new ef5.j(Integer.valueOf(r21), r10, r4, r12, this.b.J));
        FloatCardComment r15 = this.b;
        FloatCardComment.b(r15.e.getActivity().getWindow()).post(new l(r15));
        FloatCardComment r16 = this.b;
        com.bytedance.ee.bear.middleground.comment.uitls.h r17 = r16.e.d0;
        d r18 = r16.p;
        if (r18 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r18 = null;
    L35:
        CommentBean r19 = r18.e(Integer.valueOf(r21));
        if (r19 == null) goto L43;
        CommentBean.Extra r20 = r19.getExtra();
        if (r20 == null) goto L43;
        String r22 = r20.getReportVisibility();
        if (r22 == null) goto L43;
        r14 = r22;
    L43:
        r17.e(r4, r14);
        if (Intrinsics.areEqual(this.b.J, r4) == true) goto L79;
        FloatCardComment r23 = this.b;
        r23.J = r4;
        CommentPagerAdapter2 r24 = r23.o;
        if (r24 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
        r24 = null;
    L48:
        VerticalViewPager r25 = this.b.m;
        if (r25 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        r25 = null;
    L51:
        RecyclerView r26 = r24.P0(Integer.valueOf(r25.getCurrentItem()));
        if (r26 != null) goto L54;
    L56:
        boolean r27 = false;
    L57:
        if (r27 == true) goto L79;
        CommentPagerAdapter2 r28 = this.b.o;
        if (r28 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
        r28 = null;
    L61:
        VerticalViewPager r29 = this.b.m;
        if (r29 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        r29 = null;
    L64:
        Map<Integer, RecyclerView> r30 = r28.l;
        if (r29 == null) goto L67;
        int r31 = r29.getCurrentItem();
    L68:
        RecyclerView r32 = (RecyclerView) ((LinkedHashMap) r30).get(Integer.valueOf(r31));
        if (r32 == null) goto L71;
        RecyclerView.LayoutManager r33 = r32.getLayoutManager();
    L73:
        if ((r33 instanceof LinearLayoutManager) == false) goto L75;
        LinearLayoutManager r34 = (LinearLayoutManager) r33;
    L76:
        if (r34 == null) goto L79;
        r34.scrollToPositionWithOffset(0, 0);
        goto L79
    L75:
        r34 = null;
        goto L76
    L71:
        r33 = null;
        goto L73
    L67:
        r31 = -1;
        goto L68
    L54:
        if (r26.isVerticalFadingEdgeEnabled() == true) goto L56;
        r27 = true;
    L79:
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == false) goto L89;
        String r35 = this.b.L;
        if (r35 == null) goto L86;
        if (Intrinsics.areEqual(r35, r4) == true) goto L86;
        this.b.L = null;
    L86:
        if (this.b.r() == false) goto L88;
        this.b.n();
        goto L89
    L88:
        this.b.o(false, null);
    L89:
        d r36 = this.b.p;
        if (r36 != null) goto L92;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r36 = null;
    L92:
        VerticalViewPager r37 = this.b.m;
        if (r37 != null) goto L95;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        r37 = null;
    L95:
        CommentBean r38 = r36.e(Integer.valueOf(r37.getCurrentItem()));
        if (r38 == null) goto L120;
        CommentBean.Extra r39 = r38.getExtra();
        if (r39 == null) goto L120;
        int r40 = r39.getVisibility();
        FloatCardComment r41 = this.b;
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == false) goto L102;
        int r42 = 2131889568;
    L103:
        CommentTextView r43 = r41.s;
        ?? r44 = r43;
        if (r43 != null) goto L106;
        Intrinsics.throwUninitializedPropertyAccessException("commentTv");
        r44 = null;
    L106:
        FragmentActivity r45 = r41.e.getActivity();
        if (r40 == 0) goto L110;
        r42 = 2131889228;
    L110:
        r44.setHint(com.bytedance.ee.util.ui.n.x(r45, r42));
        View r46 = r41.t;
        if (r46 != null) goto L113;
        Intrinsics.throwUninitializedPropertyAccessException("privateIcon");
        r46 = null;
    L113:
        if (r40 == 0) goto L115;
        boolean r47 = true;
    L116:
        if (r47 == false) goto L118;
        int r48 = 0;
    L119:
        r46.setVisibility(r48);
        goto L120
    L118:
        r48 = 8;
        goto L119
    L115:
        r47 = false;
        goto L116
    L102:
        r42 = 2131887629;
    L120:
        FloatCardComment r49 = this.b;
        com.bytedance.ee.bear.middleground.comment.uitls.h r110 = r49.e.d0;
        d r50 = r49.p;
        if (r50 != null) goto L123;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
    L124:
        String r111 = r5.f(Integer.valueOf(r21));
        if (r21 != 0) goto L127;
        boolean r112 = true;
    L128:
        r110.d("bubble_comment_page_slide", null, r111, "", r112);
        return;
    L127:
        r112 = false;
        goto L128
    L123:
        r5 = r50;
        goto L124
    L31:
        r12 = r11;
        goto L32
    L27:
        r11 = null;
        goto L28
    L24:
        r10 = 0;
        goto L25
    L5:
        if (r2.e.s == false) goto L12;
        VerticalViewPager r1 = r2.m;
        if (r1 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    L10:
        r6.postDelayed(new k(r2), 50);
        return;
    L9:
        r6 = r1;
        goto L10
    }

    public w(Ref.BooleanRef r1, FloatCardComment r2, Ref.LongRef r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // com.bytedance.ee.bear.widgets.viewpager.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public final void onPageScrolled(int r4, float r5, int r6) {
        d r7 = this.b.p;
        if (r7 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r7 = null;
    L6:
        if (r7.o(r4) == true) goto L8;
        return;
    L8:
        if (this.a.element == false) goto L14;
        long r8 = System.currentTimeMillis();
        Ref.LongRef r9 = this.c;
        if ((r8 - r9.element) <= BaseKeyboardHeightProducer.CONFIGURATION_CHANGED_WAIT_MAX_INTERVAL) goto L15;
        r9.element = System.currentTimeMillis();
        Toast.showText(this.b.e.getActivity(), 2131887623);
        return;
    L15:
        return;
    }
}
