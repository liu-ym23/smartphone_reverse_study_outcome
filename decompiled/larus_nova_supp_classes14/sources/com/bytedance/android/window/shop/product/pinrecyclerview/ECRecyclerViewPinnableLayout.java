package com.bytedance.android.window.shop.product.pinrecyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0003\u001a\u001b\u001cB'\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004J\u0010\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/window/shop/product/pinrecyclerview/ECRecyclerViewPinnableLayout;", "Landroid/widget/FrameLayout;", "", "getPinnedAreaHeight", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "", "setAdapter", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "layoutManager", "setLayoutManager", "Lcom/bytedance/android/window/shop/product/pinrecyclerview/ECRecyclerViewPinnableLayout$b;", "i", "Lcom/bytedance/android/window/shop/product/pinrecyclerview/ECRecyclerViewPinnableLayout$b;", "getPinedCallback", "()Lcom/bytedance/android/window/shop/product/pinrecyclerview/ECRecyclerViewPinnableLayout$b;", "setPinedCallback", "(Lcom/bytedance/android/window/shop/product/pinrecyclerview/ECRecyclerViewPinnableLayout$b;)V", "pinedCallback", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "InnerRecyclerView", "b", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECRecyclerViewPinnableLayout extends FrameLayout {
    public int a;
    public RecyclerView b;
    public final InnerRecyclerView c;
    public final List<Integer> d;
    public final SparseIntArray e;
    public int f;
    public int g;
    public final SparseIntArray h;
    public b i;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/window/shop/product/pinrecyclerview/ECRecyclerViewPinnableLayout$InnerRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class InnerRecyclerView extends RecyclerView {
        public InnerRecyclerView(Context r4) {
            AttributeSet r2 = null;
            this(r4, r2, 6, 0);
        }

        public InnerRecyclerView(Context r3, AttributeSet r4) {
            this(r3, r4, 4, 0);
        }

        public InnerRecyclerView(Context r2, AttributeSet r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "context");
            super(r2, r3, r4);
        }

        public /* synthetic */ InnerRecyclerView(Context r1, AttributeSet r2, int r3, int r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = null;
        L5:
            this(r1, r2, 0);
        }
    }

    public static final class a {
    }

    public interface b {
        void A(InnerRecyclerView r1);

        void S(InnerRecyclerView r1, int r2);
    }

    static {
    }

    public ECRecyclerViewPinnableLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ECRecyclerViewPinnableLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void f() {
        this.f = 0;
        this.g = -1;
        this.a = 0;
        this.h.clear();
        fq3.b r0 = this.c.getAdapter();
        if (r0 == null) goto L9;
        r0.clear();
        RecyclerView.Adapter r1 = this.c.getAdapter();
        if (r1 == null) goto L10;
        r1.notifyDataSetChanged();
        return;
    L10:
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.window.shop.product.pinrecyclerview.IECPinAdapterData");
    }

    public final int c() {
        int r0 = this.g;
        if (r0 >= 0) goto L5;
        return -1;
    L5:
        if (r0 < ((ArrayList) this.d).size()) goto L8;
        return -1;
    L8:
        return ((Number) ListProtector.get(this.d, 0)).intValue();
    }

    public final void e() {
        int r0 = this.g;
        if (r0 >= 0) goto L5;
        return;
    L5:
        if (r0 >= ((ArrayList) this.d).size()) goto L41;
        int r1 = ((Number) ListProtector.get(this.d, this.g)).intValue();
        RecyclerView r2 = this.b;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("realRv");
    L9:
        if (r2 == null) goto L13;
        RecyclerView.LayoutManager r3 = r2.getLayoutManager();
        if (r3 == null) goto L13;
        View r4 = r3.findViewByPosition(r1);
    L14:
        if (r4 != null) goto L16;
        return;
    L16:
        if (r4.getBottom() < (this.a - 500)) goto L26;
        int r5 = this.g;
        if (this.h.indexOfKey(r5) >= 0) goto L26;
        this.h.put(r5, r5);
        RecyclerView r6 = this.b;
        if (r6 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("realRv");
    L23:
        RecyclerView.Adapter r7 = r6.getAdapter();
        if (r7 == null) goto L26;
        r7.notifyItemChanged(((Number) ListProtector.get(this.d, r5)).intValue());
    L26:
        int r8 = r4.getBottom();
        int r9 = this.a;
        if (r8 < r9) goto L43;
        int r10 = this.g;
        this.g = r10 - 1;
        this.f--;
        this.a = r9 - r4.getHeight();
        RecyclerView r11 = this.b;
        if (r11 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("realRv");
    L31:
        fq3.b r12 = r11.getAdapter();
        if (r12 == null) goto L39;
        fq3.b r13 = r12;
        fq3.b r14 = this.c.getAdapter();
        if (r14 == null) goto L37;
        r14.remove(r13.getItem(((Number) ListProtector.get(this.d, r10)).intValue()));
        this.c.post(new fq3.a(this, r10));
        e();
        return;
    L37:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.window.shop.product.pinrecyclerview.IECPinAdapterData");
    L39:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.window.shop.product.pinrecyclerview.IECPinAdapterData");
    L43:
        return;
    L13:
        r4 = null;
        goto L14
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() != 1) goto L17;
        View r0 = getChildAt(0);
        if ((r0 instanceof RecyclerView) == true) goto L7;
        r0 = null;
    L7:
        RecyclerView r1 = (RecyclerView) r0;
        if (r1 == null) goto L15;
        this.b = r1;
        this.c.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.c.setItemAnimator(null);
        addView(this.c);
        RecyclerView r2 = this.b;
        if (r2 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("realRv");
    L12:
        r2.addOnScrollListener(new ECRecyclerViewPinnableLayout$initScrollListener$1(this));
        return;
    L15:
        throw new IllegalStateException("ECPinnableRecyclerView must have a recyclerView inside!!!");
    L17:
        throw new IllegalStateException("ECPinnableRecyclerView must have a recyclerView inside!!!");
    }

    public final b getPinedCallback() {
        return this.i;
    }

    public final int getPinnedAreaHeight() {
        return this.a;
    }

    public final void b(int r2) {
        if (((ArrayList) this.d).isEmpty() == false) goto L5;
    L6:
        List<Integer> r0 = this.d;
        ArrayList r1 = (ArrayList) r0;
        r1.add(Integer.valueOf(r2));
        return;
    L5:
        if (((Number) CollectionsKt.last(this.d)).intValue() < r2) goto L6;
    }

    public final void d(int r3) {
        RecyclerView r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("realRv");
    L5:
        RecyclerView.Adapter r1 = r0.getAdapter();
        if (r1 == null) goto L8;
        r1.notifyItemChanged(r3);
    L8:
        RecyclerView.Adapter r2 = this.c.getAdapter();
        if (r2 == null) goto L12;
        List<Integer> r4 = this.d;
        ArrayList r5 = (ArrayList) r4;
        r2.notifyItemChanged(r5.indexOf(Integer.valueOf(r3)));
        return;
    }

    public final void setAdapter(RecyclerView.Adapter<?> r2) {
        if ((r2 instanceof fq3.b) == false) goto L7;
        this.c.setAdapter(r2);
        return;
    L7:
        throw new IllegalStateException("ECPinnableRecyclerView adapter must be IECPinAdapterData!!!");
    }

    public final void setLayoutManager(RecyclerView.LayoutManager r2) {
        this.c.setLayoutManager(r2);
    }

    public final void setPinedCallback(b r1) {
        this.i = r1;
    }

    public ECRecyclerViewPinnableLayout(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        AttributeSet r1 = null;
        this.c = new InnerRecyclerView(r3, r1, 6, 0);
        this.d = new ArrayList();
        this.e = new SparseIntArray();
        this.g = -1;
        this.h = new SparseIntArray();
    }

    public static final void a(ECRecyclerViewPinnableLayout r2, int r3, int r4) {
        r2.g++;
        r2.f++;
        r2.a += r4;
        RecyclerView r5 = r2.b;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("realRv");
    L5:
        fq3.b r6 = r5.getAdapter();
        if (r6 == null) goto L19;
        fq3.b r7 = r6;
        fq3.b r1 = r2.c.getAdapter();
        if (r1 == null) goto L17;
        r1.add(r7.getItem(((Number) ListProtector.get(r2.d, r3)).intValue()));
        RecyclerView.Adapter r8 = r2.c.getAdapter();
        if (r8 == null) goto L12;
        r8.notifyItemChanged(r3);
    L12:
        b r9 = r2.i;
        if (r9 == null) goto L20;
        r9.S(r2.c, ((Number) ListProtector.get(r2.d, r3)).intValue());
        return;
    L20:
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.window.shop.product.pinrecyclerview.IECPinAdapterData");
    L19:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.window.shop.product.pinrecyclerview.IECPinAdapterData");
    }

    public /* synthetic */ ECRecyclerViewPinnableLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
