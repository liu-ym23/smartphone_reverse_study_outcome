package com.bytedance.ee.bear.middleground.comment.card;

import com.bytedance.ee.bear.widgets.viewpager.DampLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i implements DampLayout.a {
    public final /* synthetic */ CommentPagerAdapter2 a;

    @Override // com.bytedance.ee.bear.widgets.viewpager.DampLayout.a
    public final void a() {
        int r0 = this.a.getItemCount() - 1;
        int r1 = this.a.a.getCurrentItem();
        if (r1 >= r0) goto L10;
        CommentPagerAdapter2 r2 = this.a;
        if (r2.p == true) goto L10;
        Function2<? super Integer, ? super Boolean, Unit> r3 = r2.q;
        if (r3 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("switchItem");
        r3 = null;
    L9:
        r3.invoke(Integer.valueOf(r1 + 1), Boolean.TRUE);
    L10:
        if (r1 != r0) goto L13;
        CommentPagerAdapter2.y2(this.a, false);
        return;
    }

    @Override // com.bytedance.ee.bear.widgets.viewpager.DampLayout.a
    public final void b() {
        int r0 = this.a.a.getCurrentItem();
        if (r0 <= 0) goto L10;
        CommentPagerAdapter2 r1 = this.a;
        if (r1.p == true) goto L10;
        Function2<? super Integer, ? super Boolean, Unit> r2 = r1.q;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("switchItem");
        r2 = null;
    L9:
        r2.invoke(Integer.valueOf(r0 - 1), Boolean.TRUE);
    L10:
        if (r0 != 0) goto L15;
        CommentPagerAdapter2 r3 = this.a;
        if (r3.p == true) goto L16;
        CommentPagerAdapter2.y2(r3, true);
        return;
    L16:
        return;
    }

    public i(CommentPagerAdapter2 r1) {
        this.a = r1;
    }
}
