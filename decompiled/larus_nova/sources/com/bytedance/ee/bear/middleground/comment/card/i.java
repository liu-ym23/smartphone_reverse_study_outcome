package com.bytedance.ee.bear.middleground.comment.card;

import com.bytedance.ee.bear.widgets.viewpager.DampLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class i implements DampLayout.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommentPagerAdapter2 f230989a;

    @Override // com.bytedance.ee.bear.widgets.viewpager.DampLayout.a
    public final void a() {
        int r100 = this.f230989a.getItemCount() - 1;
        int r101 = this.f230989a.f240421a.getCurrentItem();
        if (r101 >= r100) goto L10;
        CommentPagerAdapter2 r102 = this.f230989a;
        if (r102.f230768p == true) goto L10;
        Function2<? super Integer, ? super Boolean, Unit> r103 = r102.f230769q;
        if (r103 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("switchItem");
        r103 = null;
    L9:
        r103.invoke(Integer.valueOf(r101 + 1), Boolean.TRUE);
    L10:
        if (r101 != r100) goto L13;
        CommentPagerAdapter2.y2(this.f230989a, false);
        return;
    }

    @Override // com.bytedance.ee.bear.widgets.viewpager.DampLayout.a
    public final void b() {
        int r100 = this.f230989a.f240421a.getCurrentItem();
        if (r100 <= 0) goto L10;
        CommentPagerAdapter2 r101 = this.f230989a;
        if (r101.f230768p == true) goto L10;
        Function2<? super Integer, ? super Boolean, Unit> r102 = r101.f230769q;
        if (r102 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("switchItem");
        r102 = null;
    L9:
        r102.invoke(Integer.valueOf(r100 - 1), Boolean.TRUE);
    L10:
        if (r100 != 0) goto L15;
        CommentPagerAdapter2 r103 = this.f230989a;
        if (r103.f230768p == true) goto L16;
        CommentPagerAdapter2.y2(r103, true);
        return;
    L16:
        return;
    }

    public i(CommentPagerAdapter2 r100) {
        this.f230989a = r100;
    }
}
