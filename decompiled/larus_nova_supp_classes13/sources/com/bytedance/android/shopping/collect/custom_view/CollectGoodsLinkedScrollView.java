package com.bytedance.android.shopping.collect.custom_view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0014B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/shopping/collect/custom_view/CollectGoodsLinkedScrollView;", "Lcom/bytedance/android/shopping/collect/custom_view/CollectGoodsTwoRevNestedScrollView;", "Lcom/bytedance/android/shopping/collect/custom_view/CollectGoodsGULView;", "getGul", "Landroidx/recyclerview/widget/RecyclerView;", "getRv", "Lcom/bytedance/android/shopping/collect/custom_view/LoadMoreFooterView;", "getLoadMoreFooterView", "Lkb3/b;", "collectCommonAbility", "", "setCommentAbility", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CollectGoodsLinkedScrollView extends CollectGoodsTwoRevNestedScrollView {
    public final MaxHeightRecyclerView m;
    public final CollectGoodsGULView n;
    public final LoadMoreFooterView o;
    public kb3.b p;

    public static final class a implements ViewTreeObserver.OnPreDrawListener {
        public final /* synthetic */ CollectGoodsLinkedScrollView a;

        public a(CollectGoodsLinkedScrollView r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r0v4, types: [android.widget.FrameLayout, com.bytedance.android.shopping.collect.custom_view.CollectGoodsLinkedScrollView] */
        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            if (this.a.m.getMaxHeight() == this.a.getHeight()) goto L7;
            ?? r0 = this.a;
            r0.m.setMaxHeight(r0.getHeight());
            return true;
        L7:
            return true;
        }
    }

    public static final class b {
    }

    static {
    }

    public CollectGoodsLinkedScrollView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CollectGoodsLinkedScrollView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
    }

    public final CollectGoodsGULView getGul() {
        return this.n;
    }

    public final LoadMoreFooterView getLoadMoreFooterView() {
        return this.o;
    }

    public final RecyclerView getRv() {
        return this.m;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.shopping.collect.custom_view.CollectGoodsTwoRevNestedScrollView
    public final void g(int r6) {
        int[] r1 = new int[2];     // Catch: Throwable -> L12
        getLocationOnScreen(r1);     // Catch: Throwable -> L12
        int[] r0 = new int[2];     // Catch: Throwable -> L12
        boolean r2 = false;
        getChildAt(0).getLocationOnScreen(r0);     // Catch: Throwable -> L12
        MaxHeightRecyclerView r3 = this.m;     // Catch: Throwable -> L12
        if (r1[1] != r0[1]) goto L6;
        r2 = true;
    L6:
        r3.setParentIsTop(r2);     // Catch: Throwable -> L12
        if (r6 <= 0) goto L15;
        kb3.b r7 = this.p;     // Catch: Throwable -> L12
        if (r7 == null) goto L16;
        r7.a(this);     // Catch: Throwable -> L12
        return;
    L16:
        return;
    L15:
        return;
    }

    public final void setCommentAbility(kb3.b r3) {
        Intrinsics.checkNotNullParameter(r3, "collectCommonAbility");
        this.p = r3;
        getGul().setLifecycleOwner(r3.getLifecycleOwner());
        getGul().setCollectParams(r3.b());
        getGul().setYaTaInstance(r3.c());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CollectGoodsLinkedScrollView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131559845, this, true);
        setInnerLayout((ViewGroup) findViewById(2131367728));
        MaxHeightRecyclerView r5 = (MaxHeightRecyclerView) findViewById(2131384480);
        h("rev1", r5);
        Unit r6 = Unit.INSTANCE;
        this.m = r5;
        CollectGoodsGULView r7 = (CollectGoodsGULView) findViewById(2131380663);
        r7.setSetUpCallBack(new CollectGoodsLinkedScrollView$$special$$inlined$apply$lambda$1(this));
        this.n = r7;
        this.o = (LoadMoreFooterView) findViewById(2131378951);
        getViewTreeObserver().addOnPreDrawListener(new a(this));
    }

    public /* synthetic */ CollectGoodsLinkedScrollView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
