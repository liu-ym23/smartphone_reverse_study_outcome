package com.bytedance.ee.bear.middleground.comment.card;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.uitls.CommentUtils;
import com.bytedance.ee.bear.widgets.viewpager.VerticalViewPager;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c0 implements View.OnLongClickListener {
    public final /* synthetic */ FloatCardComment a;

    public c0(FloatCardComment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r5) {
        int r6 = com.bytedance.ee.bear.middleground.comment.audio.voiceinput.j.a;
        FragmentActivity r7 = this.a.e.getActivity();
        Function0<Unit> r0 = this.a.f.P();
        Intrinsics.checkNotNullParameter(r0, "onSwitchToPortrait");
        boolean r2 = false;
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L14;
        if (r7 == null) goto L13;
        com.bytedance.ee.bear.middleground.comment.audio.voiceinput.j.c(r7, r0);
    L13:
        r2 = true;
    L14:
        if (r2 == false) goto L16;
        return true;
    L16:
        FloatCardComment r8 = this.a;
        d r3 = r8.p;
        Boolean r4 = null;
        if (r3 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r3 = null;
    L19:
        VerticalViewPager r9 = this.a.m;
        if (r9 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        r9 = null;
    L22:
        CommentBean r10 = r3.e(Integer.valueOf(r9.getCurrentItem()));
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == false) goto L25;
        r4 = Boolean.FALSE;
    L25:
        FloatCardComment.m(r8, r10, r4, 2);
        return true;
    L5:
        if (CommentUtils.b(r7) == false) goto L7;
        r1 = true;
        goto L8
    }
}
