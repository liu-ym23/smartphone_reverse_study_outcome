package com.bytedance.android.shopping.jedi;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.ec.core.jedi.PullUpLoadMoreHelper;
import com.bytedance.android.ec.core.jedi.RecyclerViewWithFooterAdapter;
import com.bytedance.android.ec.core.widget.LoadMoreStatusView;
import com.bytedance.android.ec.hybrid.tools.UIToolsKt;
import com.bytedance.android.shopping.extensions.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/jedi/LoadMoreRecyclerViewAdapter;", "Lcom/bytedance/android/ec/core/jedi/RecyclerViewWithFooterAdapter;", "<init>", "()V", "a", "LoadMoreViewHolder", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class LoadMoreRecyclerViewAdapter extends RecyclerViewWithFooterAdapter {
    public static final /* synthetic */ int t = 0;
    public int b;
    public int c;
    public int d;
    public String e;
    public TextView f;
    public long g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public Integer m;
    public final String n;
    public final FrameLayout.LayoutParams o;
    public View p;
    public LoadMoreViewHolder q;
    public Function0<Unit> r;
    public int s;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0084\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/jedi/LoadMoreRecyclerViewAdapter$LoadMoreViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class LoadMoreViewHolder extends RecyclerView.ViewHolder {
        public PullUpLoadMoreHelper a;
        public final TextView b;
        public final /* synthetic */ LoadMoreRecyclerViewAdapter c;

        public LoadMoreViewHolder(LoadMoreRecyclerViewAdapter r2, LoadMoreStatusView r3, TextView r4) {
            Intrinsics.checkNotNullParameter(r4, "mErrorText");
            this.c = r2;
            Intrinsics.checkNotNull(r3);
            super(r3);
            this.b = r4;
            r4.setOnClickListener(new com.bytedance.android.shopping.jedi.a(this));
        }
    }

    public static final class a {
    }

    static {
    }

    public final void resetLoadMoreState() {
        LoadMoreViewHolder r0 = this.q;
        if (r0 == null) goto L9;
        Intrinsics.checkNotNull(r0);
        LoadMoreStatusView r1 = ((RecyclerView.ViewHolder) r0).itemView;
        if (r1 == null) goto L8;
        r1.b();
        goto L9
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.core.widget.LoadMoreStatusView");
    L9:
        this.b = -1;
        this.g = -1;
    }

    public final void showLoadMoreLoading() {
        LoadMoreViewHolder r0 = this.q;
        if (r0 == null) goto L9;
        LoadMoreStatusView r1 = ((RecyclerView.ViewHolder) r0).itemView;
        if (r1 == null) goto L8;
        r1.a();
        goto L9
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.core.widget.LoadMoreStatusView");
    L9:
        this.b = 0;
        if (this.g != (-1)) goto L13;
        this.g = System.currentTimeMillis();
        return;
    }

    public final void y2() {
        LoadMoreViewHolder r0 = this.q;
        if (r0 == null) goto L9;
        Intrinsics.checkNotNull(r0);
        LoadMoreStatusView r1 = ((RecyclerView.ViewHolder) r0).itemView;
        if (r1 == null) goto L8;
        r1.b();
        ((RecyclerView.ViewHolder) r0).itemView.setVisibility(8);
        goto L9
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.core.widget.LoadMoreStatusView");
    L9:
        this.b = -1;
        this.g = -1;
        notifyItemRangeRemoved(getItemCount() - 1, 1);
    }

    public final void z2() {
        LoadMoreViewHolder r0 = this.q;
        if (r0 == null) goto L9;
        Intrinsics.checkNotNull(r0);
        LoadMoreStatusView r1 = ((RecyclerView.ViewHolder) r0).itemView;
        if (r1 == null) goto L8;
        r1.d();
        goto L9
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.core.widget.LoadMoreStatusView");
    L9:
        this.b = 1;
    }

    public LoadMoreRecyclerViewAdapter() {
        this.b = -1;
        this.g = -1;
        this.i = b.b(16);
        this.l = b.b(16);
        this.n = "";
        this.o = new FrameLayout.LayoutParams(b.b(210), b.b(20));
        this.s = 17;
    }

    public int getItemCount() {
        if (getBasicItemCount() != 0) goto L6;
        return 0;
    L6:
        return super.getItemCount();
    }

    public void onAttachedToRecyclerView(RecyclerView r3) {
        Intrinsics.checkNotNullParameter(r3, "recyclerView");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onAttachedToRecyclerView(r3);
        final GridLayoutManager r4 = r3.getLayoutManager();
        if ((r4 instanceof GridLayoutManager) == false) goto L6;
        r4.setSpanSizeLookup(new AnonymousClass1(this, r4));
        return;
    }

    public void onBindFooterViewHolder(RecyclerView.ViewHolder r7) {
        Intrinsics.checkNotNullParameter(r7, "holder");
        LoadMoreViewHolder r8 = (LoadMoreViewHolder) r7;
        LoadMoreStatusView r0 = ((RecyclerView.ViewHolder) r8).itemView;
        if (r0 == null) goto L18;
        LoadMoreStatusView r1 = r0;
        r1.setECStatus(r8.c.b);
        int r2 = r8.c.h;
        if (r2 > 0) goto L8;
        r2 = -2;
    L8:
        r1.setLayoutParams(new RecyclerView.LayoutParams(-1, r2));
        LoadMoreRecyclerViewAdapter r3 = r8.c;
        r1.setPadding(r3.j, r3.l, r3.k, r3.i);
        if (r1.g != (-1)) goto L11;
        boolean r4 = true;
    L12:
        if (r4 == false) goto L19;
        Function0<Unit> r9 = r8.c.r;
        if (r9 == null) goto L20;
        Unit r10 = (Unit) r9.invoke();
        return;
    L20:
        return;
    L19:
        return;
    L11:
        r4 = false;
        goto L12
    L18:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.core.widget.LoadMoreStatusView");
    }

    public final RecyclerView.ViewHolder onCreateFooterViewHolder(ViewGroup r7) {
        Intrinsics.checkNotNullParameter(r7, "parent");
        int r0 = LoadMoreStatusView.h;
        LoadMoreStatusView r1 = LoadMoreStatusView.a.a(r7.getContext(), this.n, this.o);
        int r2 = this.h;
        if (r2 > 0) goto L6;
        r2 = -2;
    L6:
        r1.setLayoutParams(new RecyclerView.LayoutParams(-1, r2));
        r1.setPadding(this.j, this.l, this.k, this.i);
        TextView r3 = (TextView) th.a.d(r7.getContext(), 2131560983, null, 4);
        this.f = r3;
        if (this.c == 0) goto L10;
        Intrinsics.checkNotNull(r3);
        r3.setTextColor(this.c);
    L10:
        if (this.e == null) goto L12;
        TextView r4 = this.f;
        Intrinsics.checkNotNull(r4);
        r4.setText(this.e);
    L12:
        TextView r5 = this.f;
        Intrinsics.checkNotNull(r5);
        r5.setGravity(this.s);
        Integer r6 = this.m;
        if (r6 == null) goto L15;
        r6.intValue();
        TextView r8 = this.f;
        Intrinsics.checkNotNull(r8);
        Integer r9 = this.m;
        Intrinsics.checkNotNull(r9);
        r8.setPadding(0, r9.intValue(), 0, 0);
    L15:
        View r10 = th.a.d(r7.getContext(), 2131560984, null, 4);
        if (r10 == null) goto L27;
        TextView r11 = (TextView) r10;
        r11.setText(2131911657);
        r11.setGravity(17);
        int r12 = this.d;
        if (r12 == 0) goto L20;
        r11.setTextColor(r12);
    L20:
        View r13 = this.p;
        if (r13 == null) goto L23;
        UIToolsKt.b(r13);
        r1.f(this.p, this.f, r11);
    L24:
        LoadMoreViewHolder r14 = new LoadMoreViewHolder(this, r1, r11);
        this.q = r14;
        Intrinsics.checkNotNull(r14);
        return r14;
    L23:
        r1.c(r7.getContext(), this.f, r11);
        goto L24
    L27:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }

    public void onViewAttachedToWindow(RecyclerView.ViewHolder r3) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onViewAttachedToWindow(r3);
        if ((r3 instanceof com.bytedance.android.ecom.arch.slice.slices.a) == true) goto L14;
        StaggeredGridLayoutManager.LayoutParams r0 = r3.itemView.getLayoutParams();
        if (r0 != null) goto L7;
        return;
    L7:
        if ((r0 instanceof StaggeredGridLayoutManager.LayoutParams) == false) goto L16;
        StaggeredGridLayoutManager.LayoutParams r1 = r0;
        if (getItemViewType(r3.getLayoutPosition()) != Integer.MIN_VALUE) goto L11;
        boolean r4 = true;
    L12:
        r1.setFullSpan(r4);
        return;
    L11:
        r4 = false;
        goto L12
    L16:
        return;
    }

    public void onViewDetachedFromWindow(RecyclerView.ViewHolder r5) {
        Intrinsics.checkNotNullParameter(r5, "holder");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onViewDetachedFromWindow(r5);
        if (this.g != (-1)) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(null) == true) goto L9;
        this.g = -1;
        return;
    }
}
