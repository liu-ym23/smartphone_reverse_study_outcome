package com.larus.business.debug.base.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.business.debug.base.register.EntrancePage;
import cw8.a;
import cw8.b;
import cw8.d;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zv8.k;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\rH\u0016J\u0018\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\rH\u0016J \u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/larus/business/debug/base/adapter/EntranceTabAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "<init>", "()V", "tabList", "", "Lcom/larus/business/debug/base/register/EntrancePage;", "getTabList", "()Ljava/util/List;", "pageList", "", "Lcom/larus/business/debug/base/view/DebugEntrancePage;", "getCount", "", "isViewFromObject", "", "view", "Landroid/view/View;", "object", "", "getPageTitle", "", "position", "instantiateItem", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "destroyItem", "", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EntranceTabAdapter extends PagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<b> f319956a;

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        k.f573760a.getClass();
        return k.f573763d.size();
    }

    public EntranceTabAdapter() {
        this.f319956a = new ArrayList();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final CharSequence getPageTitle(int r100) {
        k.f573760a.getClass();
        return ((EntrancePage) ListProtector.get(k.f573763d, r100)).getDes();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final Object instantiateItem(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        EntrancePage r102 = EntrancePage.ALL;
        if (r101 != r102.getIndex()) goto L5;
        k.f573760a.getClass();
        b r103 = new b(r102, r100, k.c(r102));
    L9:
        r103.c();
        View r104 = r103.f465628d;
        r100.addView(r104);
        ListProtector.add(this.f319956a, r101, r103);
        return r104;
    L5:
        EntrancePage r105 = EntrancePage.RECENTLY;
        if (r101 != r105.getIndex()) goto L8;
        k.f573760a.getClass();
        r103 = new d(r105, r100, k.c(r105));
        goto L9
    L8:
        EntrancePage r106 = EntrancePage.FAVORITE;
        k.f573760a.getClass();
        r103 = new a(r106, r100, k.c(r106));
        goto L9
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final boolean isViewFromObject(View r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "object");
        return Intrinsics.areEqual(r100, r101);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void destroyItem(ViewGroup r100, int r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r102, "object");
        if ((r102 instanceof View) == false) goto L5;
        View r103 = (View) r102;
    L6:
        if (r103 == null) goto L9;
        r100.removeView(r103);
        ((b) ListProtector.remove(this.f319956a, r101)).d();
        return;
    L9:
        return;
    L5:
        r103 = null;
        goto L6
    }
}
