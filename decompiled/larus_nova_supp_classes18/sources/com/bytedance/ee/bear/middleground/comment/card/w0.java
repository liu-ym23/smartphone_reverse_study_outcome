package com.bytedance.ee.bear.middleground.comment.card;

import android.view.View;
import android.widget.TextView;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.widgets.viewpager.FixPageTransformerViewPager;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class w0 implements FixPageTransformerViewPager.e {
    public final /* synthetic */ HalfScreenCardComment a;

    @Override // com.bytedance.ee.bear.widgets.viewpager.FixPageTransformerViewPager.e
    public final void a(int r1, float r2) {
    }

    @Override // com.bytedance.ee.bear.widgets.viewpager.FixPageTransformerViewPager.e
    public final void onPageScrollStateChanged(int r1) {
    }

    public w0(HalfScreenCardComment r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.widgets.viewpager.FixPageTransformerViewPager.e
    public final void onPageSelected(int r14) {
        com.bytedance.ee.bear.middleground.comment.audio.voiceinput.g r0 = this.a.h();
        if (r0 == null) goto L5;
        r0.d();
    L5:
        this.a.l();
        HalfScreenCardComment r1 = this.a;
        TextView r2 = r1.k;
        d r3 = r1.E;
        d r4 = null;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r3 = null;
    L8:
        r2.setText(r3.g(this.a.n.getCurrentItem()));
        HalfScreenCardComment r5 = this.a;
        View r6 = r5.q;
        int r7 = 8;
        if (r5.T == false) goto L16;
        d r8 = r5.E;
        if (r8 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r8 = null;
    L14:
        if (r8.r(r14) == false) goto L16;
        int r9 = 0;
    L17:
        r6.setVisibility(r9);
        HalfScreenCardComment r10 = this.a;
        View r11 = r10.m;
        if (r10.i() == false) goto L20;
        r7 = 0;
    L20:
        r11.setVisibility(r7);
        d r12 = this.a.E;
        if (r12 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r12 = null;
    L23:
        CommentBean r13 = r12.e(Integer.valueOf(r14));
        if (r13 == null) goto L26;
        String r15 = r13.getCommentUUID();
    L27:
        if (r15 != null) goto L29;
        r15 = "";
    L29:
        String r16 = r15;
        d r17 = this.a.E;
        if (r17 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r17 = null;
    L32:
        String r18 = r17.f(Integer.valueOf(r14));
        d r19 = this.a.E;
        if (r19 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r19 = null;
    L35:
        r19.getClass();
        Intrinsics.checkNotNullParameter(r18, "<set-?>");
        r19.k = r18;
        this.a.a.N.a(new ef5.j(Integer.valueOf(r14), 0, r18, r16, this.a.k0));
        HalfScreenCardComment r20 = this.a;
        com.bytedance.ee.bear.middleground.comment.uitls.h r21 = r20.a.d0;
        Function1<String, Boolean> r22 = r20.b.x();
        d r23 = this.a.E;
        if (r23 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r23 = null;
    L38:
        r21.c = ((Boolean) r22.invoke(r23.f(Integer.valueOf(r14)))).booleanValue();
        HalfScreenCardComment r24 = this.a;
        com.bytedance.ee.bear.middleground.comment.uitls.h r25 = r24.a.d0;
        d r26 = r24.E;
        if (r26 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
    L42:
        String r110 = r4.f(Integer.valueOf(r14));
        if (r14 != 0) goto L45;
        boolean r111 = true;
    L46:
        r25.d("bubble_comment_page_slide", null, r110, "", r111);
        HalfScreenCardComment r27 = this.a;
        r27.k0 = r18;
        HalfScreenCardComment.d(r27, r14);
        return;
    L45:
        r111 = false;
        goto L46
    L41:
        r4 = r26;
        goto L42
    L26:
        r15 = null;
    L16:
        r9 = 8;
        goto L17
    }
}
