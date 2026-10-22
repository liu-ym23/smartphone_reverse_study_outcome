package com.bytedance.android.window.shop.holder;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.android.window.shop.repository.tab.entity.WindowChildCategoryVO;
import com.bytedance.android.window.shop.repository.tab.entity.d0;
import com.bytedance.android.window.shop.repository.tab.entity.e0;
import com.bytedance.android.window.shop.repository.tab.entity.f;
import com.bytedance.android.window.shop.repository.tab.entity.i0;
import com.bytedance.android.window.shop.repository.tab.entity.q;
import com.bytedance.android.window.shop.widget.SubCategoryView;
import com.bytedance.android.window.shop.widget.ToolBarView;
import com.bytedance.android.window.shop.widget.childcategory.HorizontalWeightedGroupView;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/window/shop/holder/WindowHybridToolBarHolder;", "Lcom/bytedance/android/window/shop/holder/ShopWindowItemHolder;", "Lcom/bytedance/android/window/shop/repository/tab/entity/q;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowHybridToolBarHolder extends ShopWindowItemHolder<q> {
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final LinearLayout t;

    @Override // com.bytedance.android.window.shop.holder.ShopWindowItemHolder
    public final boolean s4() {
        return true;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [android.view.ViewGroup, com.bytedance.android.window.shop.widget.ToolBarView] */
    public final ToolBarView u4() {
        ?? r0 = (ToolBarView) this.q.getValue();
        if (r0.getVisibility() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L10;
        return null;
    L10:
        return r0;
    L5:
        r1 = false;
        goto L6
    }

    public WindowHybridToolBarHolder(LinearLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "container");
        super(r2);
        this.t = r2;
        r2.setBackgroundColor(-1);
        this.q = LazyKt.lazy(new WindowHybridToolBarHolder$_toolBarView$2(this));
        this.r = LazyKt.lazy(new WindowHybridToolBarHolder$_childCategoryView$2(this));
        this.s = LazyKt.lazy(new WindowHybridToolBarHolder$_subCategoryView$2(this));
    }

    @Override // com.bytedance.android.window.shop.holder.ShopWindowItemHolder
    public final void q4(f r8) {
        q r9 = (q) r8;
        Intrinsics.checkNotNullParameter(r9, "vo");
        e0 r0 = r9.j;
        boolean r1 = false;
        ViewGroup.LayoutParams r3 = null;
        if (r0 == null) goto L17;
        d0 r5 = r0.j;
        if (r5 == null) goto L7;
        List<d0.b> r6 = r5.j;
    L8:
        if (r6 != null) goto L10;
    L13:
        boolean r7 = true;
    L14:
        if (r7 == true) goto L17;
        ((ToolBarView) this.q.getValue()).S5(r0);
    L18:
        i0 r2 = r9.l;
        if (r2 != null) goto L21;
        ((SubCategoryView) this.s.getValue()).setVisibility(8);
    L29:
        WindowChildCategoryVO r10 = r9.m;
        if (r10 == null) goto L39;
        List<WindowChildCategoryVO.ChildCategoryVO> r4 = r10.a;
        if (r4 != null) goto L34;
    L35:
        r1 = true;
    L36:
        if (r1 == true) goto L39;
        ((HorizontalWeightedGroupView) this.r.getValue()).R5(r10.a);
        return;
    L34:
        if (r4.isEmpty() == false) goto L36;
    L39:
        ((HorizontalWeightedGroupView) this.r.getValue()).setVisibility(8);
        return;
    L21:
        ((SubCategoryView) this.s.getValue()).a(r2);
        LinearLayout r11 = this.t;
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        if ((r12 instanceof ViewGroup.MarginLayoutParams) == false) goto L25;
        r3 = r12;
    L25:
        ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) r3;
        if (r13 == null) goto L29;
        r13.bottomMargin = com.bytedance.android.shopping.extensions.b.b(8);
        r11.setLayoutParams(r13);
        goto L29
    L10:
        if (r6.isEmpty() == true) goto L13;
        r7 = false;
        goto L14
    L7:
        r6 = null;
    L17:
        ((ToolBarView) this.q.getValue()).setVisibility(8);
        goto L18
    }
}
